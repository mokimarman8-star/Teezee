package c9;

import android.content.Context;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class w0 implements w8.b {
    private final iy.a a;
    private final iy.a b;
    private final iy.a c;

    public w0(iy.a aVar, iy.a aVar2, iy.a aVar3) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
    }

    public static w0 a(iy.a aVar, iy.a aVar2, iy.a aVar3) {
        return new w0(aVar, aVar2, aVar3);
    }

    public static v0 c(Context context, String str, int i) {
        return new v0(context, str, i);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public v0 get() {
        return c((Context) this.a.get(), (String) this.b.get(), ((Integer) this.c.get()).intValue());
    }
}
