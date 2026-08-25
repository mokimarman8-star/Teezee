package androidx.compose.runtime;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class q {

    /* renamed from: a, reason: collision with root package name */
    private final g3 f2868a;

    private q(Function0 function0) {
        this.f2868a = new s0(function0);
    }

    public /* synthetic */ q(Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0);
    }

    public g3 a() {
        return this.f2868a;
    }

    public abstract g3 b(t1 t1Var, g3 g3Var);
}
