package com.manoelcampos;

import com.manoelcampos.message.Newsletter;
import com.manoelcampos.message.NewsletterFactory;
import com.manoelcampos.people.Customer;

import java.util.List;

import static com.manoelcampos.message.NewsletterFactory.NewsletterType.*;


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
        Newsletter newsletter = NewsletterFactory.createNewsletter(WHATSAPP, customers);
        newsletter.send(msgTemplate);

        System.out.println("---------- SMS -----------");
        newsletter = NewsletterFactory.createNewsletter(SMS, customers);
        newsletter.send(msgTemplate);

        System.out.println("---------- EMAIL -----------");
        newsletter = NewsletterFactory.createNewsletter(EMAIL, customers);
        newsletter.send(msgTemplate);
    }
}
