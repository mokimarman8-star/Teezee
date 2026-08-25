package c9;

import android.content.Context;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class h implements w8.b {
    private final iy.a a;

    public h(iy.a aVar) {
        this.a = aVar;
    }

    public static h a(iy.a aVar) {
        return new h(aVar);
    }

    public static String c(Context context) {
        return (String) w8.d.d(f.b(context));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String get() {
        return c((Context) this.a.get());
    }
}
