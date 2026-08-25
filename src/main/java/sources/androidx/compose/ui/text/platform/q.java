package androidx.compose.ui.text.platform;

import android.graphics.Typeface;
import androidx.compose.runtime.a3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class q {

    /* renamed from: a, reason: collision with root package name */
    private final a3 f5329a;

    /* renamed from: b, reason: collision with root package name */
    private final q f5330b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f5331c;

    public q(a3 a3Var, q qVar) {
        this.f5329a = a3Var;
        this.f5330b = qVar;
        this.f5331c = a3Var.getValue();
    }

    public final Typeface a() {
        Object obj = this.f5331c;
        Intrinsics.f(obj, "null cannot be cast to non-null type android.graphics.Typeface");
        return (Typeface) obj;
    }

    public final boolean b() {
        q qVar;
        return this.f5329a.getValue() != this.f5331c || ((qVar = this.f5330b) != null && qVar.b());
    }
}
