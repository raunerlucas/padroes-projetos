package com.manoelcampos.message;

import com.manoelcampos.people.Customer;

import java.util.List;

/**
 * Envia mensagens pelo Short Message Service (SMS)
 * @author Manoel Campos da Silva Filho
 */
public class Sms extends Newsletter implements MessageService {
    /**
     * Instancia uma newsletter para envio de mensagens para uma determinada lista de clientes
     * @param customers lista de clientes para enviar mensagens
     */
    public Sms(List<Customer> customers) {
        super(customers);
    }

    @Override
    public void send(final String destination, final String msg) throws MessageSendException {
        //TODO: Inclua um print para simular o envio da mensagem
        if (destination == null || msg == null) {
            throw new MessageSendException("SMS => Destino ou mensagem não podem ser nulos");
        }
        System.out.println("Enviando SMS para " + destination + ": " + msg);
    }

    @Override
    protected MessageService createMessageService() {
        return this;
    }
}
