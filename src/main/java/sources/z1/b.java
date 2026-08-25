package z1;

import java.util.Objects;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f18754a;

    /* renamed from: b, reason: collision with root package name */
    public final String f18755b;

    /* renamed from: c, reason: collision with root package name */
    public final int f18756c;

    /* renamed from: d, reason: collision with root package name */
    public final int f18757d;

    public b(String str, String str2, int i5, int i6) {
        this.f18754a = str;
        this.f18755b = str2;
        this.f18756c = i5;
        this.f18757d = i6;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f18756c == bVar.f18756c && this.f18757d == bVar.f18757d && Objects.equals(this.f18754a, bVar.f18754a) && Objects.equals(this.f18755b, bVar.f18755b);
    }

    public int hashCode() {
        return Objects.hash(this.f18754a, this.f18755b, Integer.valueOf(this.f18756c), Integer.valueOf(this.f18757d));
    }
}
