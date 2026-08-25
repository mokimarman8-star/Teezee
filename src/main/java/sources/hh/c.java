package hh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class c implements gh.c {
    private final int a;
    private final gh.c b;

    public c(int i, gh.c cVar) {
        this.a = i;
        this.b = cVar;
    }

    @Override // gh.c
    public View createView(Context context) {
        View inflate = LayoutInflater.from(context).inflate(this.a, (ViewGroup) null);
        Intrinsics.g(inflate, "inflate(...)");
        return inflate;
    }

    @Override // gh.c
    public int getGravity() {
        gh.c cVar = this.b;
        if (cVar != null) {
            return cVar.getGravity();
        }
        return 17;
    }

    @Override // gh.c
    public float getHorizontalMargin() {
        gh.c cVar = this.b;
        if (cVar != null) {
            return cVar.getHorizontalMargin();
        }
        return 0.0f;
    }

    @Override // gh.c
    public float getVerticalMargin() {
        gh.c cVar = this.b;
        if (cVar != null) {
            return cVar.getVerticalMargin();
        }
        return 0.0f;
    }

    @Override // gh.c
    public int getXOffset() {
        gh.c cVar = this.b;
        if (cVar != null) {
            return cVar.getXOffset();
        }
        return 0;
    }

    @Override // gh.c
    public int getYOffset() {
        gh.c cVar = this.b;
        if (cVar != null) {
            return cVar.getYOffset();
        }
        return 0;
    }
}
