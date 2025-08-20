package com.manoelcampos.message;

public class MessageFactory {
    public static MessageService newInstance(MessageType type) {
        return switch (type) {
            case WHATSAPP -> new WhatsAppService();
            case SMS -> new SmsService();
            case EMAIL -> new EmailService();
        };
    }

    public enum MessageType {
        WHATSAPP, SMS, EMAIL
    }
}