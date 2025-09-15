package com.example.notifications;

/**
 * Concrete decorator that adds SMS notification capability.
 */
public class SmsDecorator extends NotifierDecorator {
    private final String phoneNumber;

    public SmsDecorator(Notifier notifier, String phoneNumber) {
        super(notifier);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void notify(String text) {
        // Send SMS notification first
        System.out.println("[SMS -> " + phoneNumber + "]: " + text);
        // Then delegate to the wrapped notifier
        super.notify(text);
    }
}
