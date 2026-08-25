package t6;

import com.chad.library.adapter.base.BaseQuickAdapter;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class g {
    private final BaseQuickAdapter a;
    private r6.g b;
    private boolean c;
    private boolean d;
    private int e;

    public g(BaseQuickAdapter baseQuickAdapter) {
        Intrinsics.h(baseQuickAdapter, "baseQuickAdapter");
        this.a = baseQuickAdapter;
        this.e = 1;
    }

    public final void a(int i) {
        r6.g gVar;
        if (!this.c || this.d || i > this.e || (gVar = this.b) == null) {
            return;
        }
        gVar.a();
    }

    public void b(r6.g gVar) {
        this.b = gVar;
    }

    public final void c(int i) {
        this.e = i;
    }

    public final void d(boolean z) {
        this.c = z;
    }

    public final void e(boolean z) {
        this.d = z;
    }
}
