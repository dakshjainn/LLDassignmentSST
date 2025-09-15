package com.example.notifications;

/**
 * Concrete decorator that adds WhatsApp notification capability.
 */
public class WhatsAppDecorator extends NotifierDecorator {
    private final String username;

    public WhatsAppDecorator(Notifier notifier, String username) {
        super(notifier);
        this.username = username;
    }

    @Override
    public void notify(String text) {
        // Send WhatsApp notification first
        System.out.println("[WHATSAPP -> " + username + "]: " + text);
        // Then delegate to the wrapped notifier
        super.notify(text);
    }
}
