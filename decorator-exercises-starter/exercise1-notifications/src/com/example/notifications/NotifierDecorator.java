package com.example.notifications;

/**
 * Base decorator class that implements Notifier and wraps another Notifier.
 * This provides a foundation for concrete decorators to extend.
 */
public abstract class NotifierDecorator implements Notifier {
    protected Notifier wrappedNotifier;

    public NotifierDecorator(Notifier notifier) {
        this.wrappedNotifier = notifier;
    }

    @Override
    public void notify(String text) {
        wrappedNotifier.notify(text);
    }
}
