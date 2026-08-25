package y2;

import java.util.Arrays;
import java.util.Objects;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class c extends i {

    /* renamed from: b, reason: collision with root package name */
    public final String f18622b;

    /* renamed from: c, reason: collision with root package name */
    public final int f18623c;

    /* renamed from: d, reason: collision with root package name */
    public final int f18624d;

    /* renamed from: e, reason: collision with root package name */
    public final long f18625e;

    /* renamed from: f, reason: collision with root package name */
    public final long f18626f;

    /* renamed from: g, reason: collision with root package name */
    private final i[] f18627g;

    public c(String str, int i5, int i6, long j5, long j6, i[] iVarArr) {
        super("CHAP");
        this.f18622b = str;
        this.f18623c = i5;
        this.f18624d = i6;
        this.f18625e = j5;
        this.f18626f = j6;
        this.f18627g = iVarArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return this.f18623c == cVar.f18623c && this.f18624d == cVar.f18624d && this.f18625e == cVar.f18625e && this.f18626f == cVar.f18626f && Objects.equals(this.f18622b, cVar.f18622b) && Arrays.equals(this.f18627g, cVar.f18627g);
    }

    public int hashCode() {
        int i5 = (((((((527 + this.f18623c) * 31) + this.f18624d) * 31) + ((int) this.f18625e)) * 31) + ((int) this.f18626f)) * 31;
        String str = this.f18622b;
        return i5 + (str != null ? str.hashCode() : 0);
    }
}
