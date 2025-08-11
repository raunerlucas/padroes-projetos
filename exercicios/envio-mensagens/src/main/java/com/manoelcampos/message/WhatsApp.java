package com.manoelcampos.message;

import com.manoelcampos.people.Customer;

import java.util.List;

/**
 * Envia mensagens pelo WhatsApp.
 * @author Manoel Campos da Silva Filho
 */
public class WhatsApp extends Newsletter implements MessageService {
    /**
     * Instancia uma newsletter para envio de mensagens para uma determinada lista de clientes
     * @param customers lista de clientes para enviar mensagens
     */
    public WhatsApp(List<Customer> customers) {
        super(customers);
    }

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

    @Override
    protected MessageService createMessageService() {
        return this;
    }
}
