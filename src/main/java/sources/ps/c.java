package ps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class c implements os.c {
    private final int a;
    private final os.c b;

    public c(int i, os.c cVar) {
        this.a = i;
        this.b = cVar;
    }

    @Override // os.c
    public View createView(Context context) {
        View inflate = LayoutInflater.from(context).inflate(this.a, (ViewGroup) null);
        Intrinsics.g(inflate, "inflate(...)");
        return inflate;
    }

    @Override // os.c
    public int getGravity() {
        os.c cVar = this.b;
        if (cVar != null) {
            return cVar.getGravity();
        }
        return 17;
    }

    @Override // os.c
    public float getHorizontalMargin() {
        os.c cVar = this.b;
        if (cVar != null) {
            return cVar.getHorizontalMargin();
        }
        return 0.0f;
    }

    @Override // os.c
    public float getVerticalMargin() {
        os.c cVar = this.b;
        if (cVar != null) {
            return cVar.getVerticalMargin();
        }
        return 0.0f;
    }

    @Override // os.c
    public int getXOffset() {
        os.c cVar = this.b;
        if (cVar != null) {
            return cVar.getXOffset();
        }
        return 0;
    }

    @Override // os.c
    public int getYOffset() {
        os.c cVar = this.b;
        if (cVar != null) {
            return cVar.getYOffset();
        }
        return 0;
    }
}
