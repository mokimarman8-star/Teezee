package v8;

import android.content.Context;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class h implements w8.b {
    private final iy.a a;
    private final iy.a b;
    private final iy.a c;

    public h(iy.a aVar, iy.a aVar2, iy.a aVar3) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
    }

    public static h a(iy.a aVar, iy.a aVar2, iy.a aVar3) {
        return new h(aVar, aVar2, aVar3);
    }

    public static g c(Context context, e9.a aVar, e9.a aVar2) {
        return new g(context, aVar, aVar2);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public g get() {
        return c((Context) this.a.get(), (e9.a) this.b.get(), (e9.a) this.c.get());
    }
}
