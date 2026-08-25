package m2;

import androidx.media3.common.util.j0;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class c implements a {

    /* renamed from: a, reason: collision with root package name */
    public final int f16509a;

    /* renamed from: b, reason: collision with root package name */
    public final int f16510b;

    /* renamed from: c, reason: collision with root package name */
    public final int f16511c;

    /* renamed from: d, reason: collision with root package name */
    public final int f16512d;

    private c(int i5, int i6, int i7, int i8) {
        this.f16509a = i5;
        this.f16510b = i6;
        this.f16511c = i7;
        this.f16512d = i8;
    }

    public static c b(j0 j0Var) {
        int u5 = j0Var.u();
        j0Var.X(8);
        int u6 = j0Var.u();
        int u7 = j0Var.u();
        j0Var.X(4);
        int u8 = j0Var.u();
        j0Var.X(12);
        return new c(u5, u6, u7, u8);
    }

    public boolean a() {
        return (this.f16510b & 16) == 16;
    }

    @Override // m2.a
    public int getType() {
        return 1751742049;
    }
}
