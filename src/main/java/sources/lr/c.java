package lr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c implements kr.c {
    private final int a;
    private final kr.c b;

    public c(int i, kr.c cVar) {
        this.a = i;
        this.b = cVar;
    }

    @Override // kr.c
    public View createView(Context context) {
        View inflate = LayoutInflater.from(context).inflate(this.a, (ViewGroup) null);
        Intrinsics.g(inflate, "inflate(...)");
        return inflate;
    }

    @Override // kr.c
    public int getGravity() {
        kr.c cVar = this.b;
        if (cVar != null) {
            return cVar.getGravity();
        }
        return 17;
    }

    @Override // kr.c
    public float getHorizontalMargin() {
        kr.c cVar = this.b;
        if (cVar != null) {
            return cVar.getHorizontalMargin();
        }
        return 0.0f;
    }

    @Override // kr.c
    public float getVerticalMargin() {
        kr.c cVar = this.b;
        if (cVar != null) {
            return cVar.getVerticalMargin();
        }
        return 0.0f;
    }

    @Override // kr.c
    public int getXOffset() {
        kr.c cVar = this.b;
        if (cVar != null) {
            return cVar.getXOffset();
        }
        return 0;
    }

    @Override // kr.c
    public int getYOffset() {
        kr.c cVar = this.b;
        if (cVar != null) {
            return cVar.getYOffset();
        }
        return 0;
    }
}
