package y2;

import java.util.Arrays;
import java.util.Objects;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class d extends i {

    /* renamed from: b, reason: collision with root package name */
    public final String f18628b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f18629c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f18630d;

    /* renamed from: e, reason: collision with root package name */
    public final String[] f18631e;

    /* renamed from: f, reason: collision with root package name */
    private final i[] f18632f;

    public d(String str, boolean z5, boolean z6, String[] strArr, i[] iVarArr) {
        super("CTOC");
        this.f18628b = str;
        this.f18629c = z5;
        this.f18630d = z6;
        this.f18631e = strArr;
        this.f18632f = iVarArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return this.f18629c == dVar.f18629c && this.f18630d == dVar.f18630d && Objects.equals(this.f18628b, dVar.f18628b) && Arrays.equals(this.f18631e, dVar.f18631e) && Arrays.equals(this.f18632f, dVar.f18632f);
    }

    public int hashCode() {
        int i5 = (((527 + (this.f18629c ? 1 : 0)) * 31) + (this.f18630d ? 1 : 0)) * 31;
        String str = this.f18628b;
        return i5 + (str != null ? str.hashCode() : 0);
    }
}
