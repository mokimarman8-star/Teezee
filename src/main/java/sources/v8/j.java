package v8;

import android.content.Context;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class j implements w8.b {
    private final iy.a a;
    private final iy.a b;

    public j(iy.a aVar, iy.a aVar2) {
        this.a = aVar;
        this.b = aVar2;
    }

    public static j a(iy.a aVar, iy.a aVar2) {
        return new j(aVar, aVar2);
    }

    public static i c(Context context, Object obj) {
        return new i(context, (g) obj);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public i get() {
        return c((Context) this.a.get(), this.b.get());
    }
}
