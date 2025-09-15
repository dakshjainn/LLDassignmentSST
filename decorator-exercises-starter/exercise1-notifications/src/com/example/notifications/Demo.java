package com.example.notifications;

/**
 * Starter demo that uses only the existing Email notifier.
 * TODOs guide you to add decorators and compose them.
 */
public class Demo {
    public static void main(String[] args) {
        Notifier base = new EmailNotifier("user@example.com");

        // Baseline behavior (already works)
        base.notify("Baseline email only.");

        // === DECORATOR IMPLEMENTATIONS ===
        
        System.out.println("\n--- Email + SMS ---");
        Notifier emailAndSms = new SmsDecorator(base, "+91-99999-11111");
        emailAndSms.notify("Build green ✅");
        
        System.out.println("\n--- Email + WhatsApp ---");
        Notifier emailAndWhatsApp = new WhatsAppDecorator(base, "user_wa");
        emailAndWhatsApp.notify("Code review ready 📝");
        
        System.out.println("\n--- Email + Slack ---");
        Notifier emailAndSlack = new SlackDecorator(base, "deployments");
        emailAndSlack.notify("Deployment started 🚀");
        
        System.out.println("\n--- Email + WhatsApp + Slack ---");
        Notifier multiChannel = new SlackDecorator(
            new WhatsAppDecorator(base, "user_wa"), 
            "deployments"
        );
        multiChannel.notify("Critical alert: System down! 🚨");
        
        System.out.println("\n--- Email + SMS + WhatsApp + Slack ---");
        Notifier allChannels = new SlackDecorator(
            new WhatsAppDecorator(
                new SmsDecorator(base, "+91-99999-11111"), 
                "user_wa"
            ), 
            "deployments"
        );
        allChannels.notify("All systems operational ✅");
    }
}
