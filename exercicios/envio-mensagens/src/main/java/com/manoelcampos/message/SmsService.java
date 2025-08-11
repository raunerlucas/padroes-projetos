package com.manoelcampos.message;

import com.manoelcampos.people.Customer;

import java.util.List;

/**
 * Envia mensagens pelo Short Message Service (SMS)
 * @author Manoel Campos da Silva Filho
 */
public class SmsService implements MessageService {
    @Override
    public void send(final String destination, final String msg) throws MessageSendException {
        //TODO: Inclua um print para simular o envio da mensagem
        if (destination == null || msg == null) {
            throw new MessageSendException("SMS => Destino ou mensagem não podem ser nulos");
        }
        System.out.println("Enviando SMS para " + destination + ": " + msg);
    }
}
