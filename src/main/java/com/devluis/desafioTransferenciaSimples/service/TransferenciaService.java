package com.devluis.desafioTransferenciaSimples.service;

import com.devluis.desafioTransferenciaSimples.controller.TransferenciaDTO;
import com.devluis.desafioTransferenciaSimples.entity.Carteira;
import com.devluis.desafioTransferenciaSimples.entity.TipoUsuario;
import com.devluis.desafioTransferenciaSimples.entity.Transferencia;
import com.devluis.desafioTransferenciaSimples.entity.Usuario;
import com.devluis.desafioTransferenciaSimples.exeptions.BadRequestException;
import com.devluis.desafioTransferenciaSimples.repository.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import java.math.BigDecimal;

@Service
public class TransferenciaService {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AutorizacaoService autorizacaoService;

    @Autowired
    private CarteiraService carteiraService;

    @Autowired
    private TransferenciaRepository repository;

    @Autowired
    private NotificacaoService notificacaoService;

    @Transactional
    public void realizarTransferencia(TransferenciaDTO transferenciaDTO) {

        Usuario pagador = usuarioService.buscarUsuarioPorId(transferenciaDTO.getPayer());

        Usuario recebedor = usuarioService.buscarUsuarioPorId(transferenciaDTO.getPayee());

        verificarUsuarioLojista(pagador);
        verificarSaldo(pagador, transferenciaDTO.getValue());
        validarTransferencia();

        Carteira carteiraPagador = pagador.getCarteira();
        carteiraPagador.setSaldo(carteiraPagador.getSaldo().subtract(transferenciaDTO.getValue()));
        atualizarSaldoCarteira(carteiraPagador);

        Carteira carteiraRecebedor = recebedor.getCarteira();
        carteiraRecebedor.setSaldo(carteiraRecebedor.getSaldo().add(transferenciaDTO.getValue()));
        atualizarSaldoCarteira(carteiraRecebedor);

        Transferencia transferencia = Transferencia.builder()
                .valor(transferenciaDTO.getValue())
                .pagador(pagador)
                .recebedor(recebedor)
                .build();

        repository.save(transferencia);
        enviarNotificacao();

    }

    private void verificarUsuarioLojista(Usuario usuario) {

        try {
            if (usuario.getTipoUsuario().equals(TipoUsuario.LOJISTA)) {
                throw new IllegalArgumentException("Transação não finalizada, lojista não pode efetuar um pagamento.");
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }

    }

    private void verificarSaldo(Usuario usuario, BigDecimal valor) {
        try {
            if (usuario.getCarteira().getSaldo().compareTo(valor) < 0) {
                throw new IllegalArgumentException("Transação não finalizada, saldo insuficiente.");
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void validarTransferencia() {
        try {
            if (!autorizacaoService.validarTransferencia()) {
                throw new IllegalArgumentException("Transação não autorizada pela API.");
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void atualizarSaldoCarteira(Carteira carteira) {
        carteiraService.salvar(carteira);
    }

    private void enviarNotificacao() {
        try {
            notificacaoService.enviarNotificacao();
        } catch (HttpClientErrorException e) {
            throw new BadRequestException("Erro ao enviar notificação!");
        }
    }

}
