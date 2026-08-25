package k2;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final int f16257a;

    /* renamed from: b, reason: collision with root package name */
    public final int f16258b;

    /* renamed from: c, reason: collision with root package name */
    public final String f16259c;

    private o(int i5, int i6, String str) {
        this.f16257a = i5;
        this.f16258b = i6;
        this.f16259c = str;
    }

    public static o a(androidx.media3.common.util.j0 j0Var) {
        String str;
        j0Var.X(2);
        int H = j0Var.H();
        int i5 = H >> 1;
        int H2 = ((j0Var.H() >> 3) & 31) | ((H & 1) << 5);
        if (i5 == 4 || i5 == 5 || i5 == 7 || i5 == 8) {
            str = "dvhe";
        } else if (i5 == 9) {
            str = "dvav";
        } else {
            if (i5 != 10) {
                return null;
            }
            str = "dav1";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i5 < 10 ? ".0" : ".");
        sb.append(i5);
        sb.append(H2 < 10 ? ".0" : ".");
        sb.append(H2);
        return new o(i5, H2, sb.toString());
    }
}
