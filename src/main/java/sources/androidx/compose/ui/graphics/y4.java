package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.compose.ui.graphics.u1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class y4 extends j1 {

    /* renamed from: c, reason: collision with root package name */
    private Shader f3913c;

    /* renamed from: d, reason: collision with root package name */
    private long f3914d;

    public y4() {
        super(null);
        this.f3914d = y.m.f18548b.a();
    }

    @Override // androidx.compose.ui.graphics.j1
    public final void a(long j5, m4 m4Var, float f5) {
        Shader shader = this.f3913c;
        if (shader == null || !y.m.f(this.f3914d, j5)) {
            if (y.m.k(j5)) {
                shader = null;
                this.f3913c = null;
                this.f3914d = y.m.f18548b.a();
            } else {
                shader = b(j5);
                this.f3913c = shader;
                this.f3914d = j5;
            }
        }
        long a5 = m4Var.a();
        u1.a aVar = u1.f3655b;
        if (!u1.m(a5, aVar.a())) {
            m4Var.s(aVar.a());
        }
        if (!Intrinsics.c(m4Var.y(), shader)) {
            m4Var.x(shader);
        }
        if (m4Var.getAlpha() == f5) {
            return;
        }
        m4Var.setAlpha(f5);
    }

    public abstract Shader b(long j5);
}
