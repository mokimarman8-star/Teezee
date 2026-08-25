package y2;

import java.util.Arrays;
import java.util.Objects;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class m extends i {

    /* renamed from: b, reason: collision with root package name */
    public final String f18655b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f18656c;

    public m(String str, byte[] bArr) {
        super("PRIV");
        this.f18655b = str;
        this.f18656c = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || m.class != obj.getClass()) {
            return false;
        }
        m mVar = (m) obj;
        return Objects.equals(this.f18655b, mVar.f18655b) && Arrays.equals(this.f18656c, mVar.f18656c);
    }

    public int hashCode() {
        String str = this.f18655b;
        return ((527 + (str != null ? str.hashCode() : 0)) * 31) + Arrays.hashCode(this.f18656c);
    }

    @Override // y2.i
    public String toString() {
        return this.f18645a + ": owner=" + this.f18655b;
    }
}
