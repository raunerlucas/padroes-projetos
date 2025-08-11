package com.manoelcampos.message;

import com.manoelcampos.people.Customer;
import java.util.List;

public class NewsletterFactory {
    public static Newsletter createNewsletter(NewsletterType type, List<Customer> customers) {
        var msgService = switch (type) {
            case WHATSAPP -> new WhatsAppService();
            case SMS -> new SmsService();
            case EMAIL -> new EmailService();
            default -> throw new IllegalArgumentException("Tipo de newsletter não suportado: " + type);
        };
        return new Newsletter(customers, msgService);
    }

    public enum NewsletterType {
        WHATSAPP, SMS, EMAIL
    }
}