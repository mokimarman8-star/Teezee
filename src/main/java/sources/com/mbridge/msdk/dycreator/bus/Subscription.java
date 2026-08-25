package com.mbridge.msdk.dycreator.bus;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class Subscription {
    final Object a;
    final SubscriberMethod b;

    Subscription(Object obj, SubscriberMethod subscriberMethod) {
        this.a = obj;
        this.b = subscriberMethod;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Subscription)) {
            return false;
        }
        Subscription subscription = (Subscription) obj;
        return this.a == subscription.a && this.b.equals(subscription.b);
    }

    public int hashCode() {
        return this.a.hashCode() + this.b.d.hashCode();
    }
}
