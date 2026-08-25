package hx;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class d {
    private final boolean a;

    public d(boolean z) {
        this.a = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof d) && this.a == ((d) obj).a;
    }

    public int hashCode() {
        return androidx.compose.foundation.e.a(this.a);
    }

    public String toString() {
        return "MainTabEvent(white=" + this.a + ")";
    }
}
