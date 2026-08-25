package hh;

import android.content.Context;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class b implements gh.c {
    private final gh.c a;
    private final int b;
    private final int c;
    private final int d;
    private final float e;
    private final float f;

    public b(gh.c cVar, int i, int i2, int i3, float f, float f2) {
        Intrinsics.h(cVar, "mStyle");
        this.a = cVar;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = f;
        this.f = f2;
    }

    @Override // gh.c
    public View createView(Context context) {
        View createView = this.a.createView(context);
        Intrinsics.e(createView);
        return createView;
    }

    @Override // gh.c
    public int getGravity() {
        return this.b;
    }

    @Override // gh.c
    public float getHorizontalMargin() {
        return this.e;
    }

    @Override // gh.c
    public float getVerticalMargin() {
        return this.f;
    }

    @Override // gh.c
    public int getXOffset() {
        return this.c;
    }

    @Override // gh.c
    public int getYOffset() {
        return this.d;
    }
}
