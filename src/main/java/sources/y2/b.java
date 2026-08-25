package y2;

import java.util.Arrays;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class b extends i {

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f18621b;

    public b(String str, byte[] bArr) {
        super(str);
        this.f18621b = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f18645a.equals(bVar.f18645a) && Arrays.equals(this.f18621b, bVar.f18621b);
    }

    public int hashCode() {
        return ((527 + this.f18645a.hashCode()) * 31) + Arrays.hashCode(this.f18621b);
    }
}
