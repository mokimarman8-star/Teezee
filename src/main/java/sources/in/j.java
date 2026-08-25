package in;

import androidx.collection.s;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class j {
    private final long a;

    public j(long j) {
        this.a = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof j) && this.a == ((j) obj).a;
    }

    public int hashCode() {
        return s.a(this.a);
    }

    public String toString() {
        return "VideoConfig(cacheByte=" + this.a + ")";
    }
}
