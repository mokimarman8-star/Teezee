package ps;

import android.content.Context;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class b implements os.c {
    private final os.c a;
    private final int b;
    private final int c;
    private final int d;
    private final float e;
    private final float f;

    public b(os.c mStyle, int i, int i2, int i3, float f, float f2) {
        Intrinsics.h(mStyle, "mStyle");
        this.a = mStyle;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = f;
        this.f = f2;
    }

    @Override // os.c
    public View createView(Context context) {
        View createView = this.a.createView(context);
        Intrinsics.e(createView);
        return createView;
    }

    @Override // os.c
    public int getGravity() {
        return this.b;
    }

    @Override // os.c
    public float getHorizontalMargin() {
        return this.e;
    }

    @Override // os.c
    public float getVerticalMargin() {
        return this.f;
    }

    @Override // os.c
    public int getXOffset() {
        return this.c;
    }

    @Override // os.c
    public int getYOffset() {
        return this.d;
    }
}
