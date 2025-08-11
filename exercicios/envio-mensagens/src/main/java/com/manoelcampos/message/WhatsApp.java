package com.manoelcampos.message;

/**
 * Envia mensagens pelo WhatsApp.
 * @author Manoel Campos da Silva Filho
 */
public class WhatsApp implements MessageService {
    /**
     * {@inheritDoc}
     * @param destination telefone de destino da mensagem
     * @param msg {@inheritDoc}
     * @throws MessageSendException {@inheritDoc}
     */
    @Override
    public void send(final String destination, final String msg) throws MessageSendException {
        if (destination == null || msg == null) {
            throw new MessageSendException("WhatsApp => Destino ou mensagem não podem ser nulos");
        }
        System.out.printf("Enviando msg WhatsApp para %s: %s%n", destination, msg);
    }
}
