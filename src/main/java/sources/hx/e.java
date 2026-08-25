package hx;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class e {
    private final int a;

    public e(int i) {
        this.a = i;
    }

    public final int a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && this.a == ((e) obj).a;
    }

    public int hashCode() {
        return this.a;
    }

    public String toString() {
        return "PaymentEvent(status=" + this.a + ")";
    }
}
