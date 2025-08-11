package com.manoelcampos;

import com.manoelcampos.message.Email;
import com.manoelcampos.message.Sms;
import com.manoelcampos.message.WhatsApp;
import com.manoelcampos.people.Customer;
import com.manoelcampos.message.Newsletter;

import java.util.List;

/**
 * Executa a aplicação
 * @author Manoel Campos da Silva Filho
 */
public class Principal {
    public static void main(String[] args) {
        final List<Customer> customers = List.of(
            new Customer("Manoel", "(63) 1111-2222", "manoel@teste.com"),
            new Customer("Breno",  "(63) 3333-4444", "breno@teste.com"),
            new Customer("Raysa",  "(63) 5555-6666", "raysa@teste.com")
        );
        final String msgTemplate = "Aproveite as promoções de natal #name.";

        System.out.println("---------- Whatsapp -----------");
        Newsletter newsletter = new WhatsApp(customers);
        newsletter.send(msgTemplate);
        System.out.println("---------- SMS -----------");
        newsletter = new Sms(customers);
        newsletter.send(msgTemplate);
        System.out.println("---------- EMAIL -----------");
        newsletter = new Email(customers);
        newsletter.send(msgTemplate);
    }
}
