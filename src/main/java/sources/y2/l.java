package y2;

import java.util.Arrays;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class l extends i {

    /* renamed from: b, reason: collision with root package name */
    public final int f18650b;

    /* renamed from: c, reason: collision with root package name */
    public final int f18651c;

    /* renamed from: d, reason: collision with root package name */
    public final int f18652d;

    /* renamed from: e, reason: collision with root package name */
    public final int[] f18653e;

    /* renamed from: f, reason: collision with root package name */
    public final int[] f18654f;

    public l(int i5, int i6, int i7, int[] iArr, int[] iArr2) {
        super("MLLT");
        this.f18650b = i5;
        this.f18651c = i6;
        this.f18652d = i7;
        this.f18653e = iArr;
        this.f18654f = iArr2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l.class != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        return this.f18650b == lVar.f18650b && this.f18651c == lVar.f18651c && this.f18652d == lVar.f18652d && Arrays.equals(this.f18653e, lVar.f18653e) && Arrays.equals(this.f18654f, lVar.f18654f);
    }

    public int hashCode() {
        return ((((((((527 + this.f18650b) * 31) + this.f18651c) * 31) + this.f18652d) * 31) + Arrays.hashCode(this.f18653e)) * 31) + Arrays.hashCode(this.f18654f);
    }
}
