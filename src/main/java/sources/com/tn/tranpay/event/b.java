package com.tn.tranpay.event;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class b {
    private final int a;

    public b(int i) {
        this.a = i;
    }

    public final int a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b) && this.a == ((b) obj).a;
    }

    public int hashCode() {
        return this.a;
    }

    public String toString() {
        return "PaymentEvent(status=" + this.a + ")";
    }
}
