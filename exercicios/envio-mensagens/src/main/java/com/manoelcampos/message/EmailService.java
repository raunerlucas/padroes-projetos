package com.manoelcampos.message;

import com.manoelcampos.people.Customer;

import java.util.List;

/**
 * Envia mensagens de email.
 * @author Manoel Campos da Silva Filho
 */
public class EmailService implements MessageService {
    @Override
    public void send(final String destination, final String msg) throws MessageSendException {
        if (destination == null || msg == null) {
            throw new MessageSendException("Email => Destino ou mensagem não podem ser nulos");
        }
        System.out.println("Enviando email para " + destination + ": " + msg);
    }
}
