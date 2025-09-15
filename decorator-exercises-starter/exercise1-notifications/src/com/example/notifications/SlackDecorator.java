package com.example.notifications;

/**
 * Concrete decorator that adds Slack notification capability.
 */
public class SlackDecorator extends NotifierDecorator {
    private final String channel;

    public SlackDecorator(Notifier notifier, String channel) {
        super(notifier);
        this.channel = channel;
    }

    @Override
    public void notify(String text) {
        // Send Slack notification first
        System.out.println("[SLACK -> #" + channel + "]: " + text);
        // Then delegate to the wrapped notifier
        super.notify(text);
    }
}
