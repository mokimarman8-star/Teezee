package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class i0 extends c0 {

    /* renamed from: b, reason: collision with root package name */
    private final WeakReference f1045b;

    public i0(Context context, Resources resources) {
        super(resources);
        this.f1045b = new WeakReference(context);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i5) {
        Drawable a5 = a(i5);
        Context context = (Context) this.f1045b.get();
        if (a5 != null && context != null) {
            b0.h().x(context, i5, a5);
        }
        return a5;
    }
}
