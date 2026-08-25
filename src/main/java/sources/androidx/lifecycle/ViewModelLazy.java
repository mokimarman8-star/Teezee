package androidx.lifecycle;

import androidx.lifecycle.v0;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import p1.a;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class ViewModelLazy implements Lazy {
    private final KClass a;
    private final Function0 b;
    private final Function0 c;
    private final Function0 d;
    private androidx.lifecycle.t0 e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewModelLazy(KClass kClass, Function0 function0, Function0 function02) {
        this(kClass, function0, function02, null, 8, null);
        Intrinsics.h(kClass, "viewModelClass");
        Intrinsics.h(function0, "storeProducer");
        Intrinsics.h(function02, "factoryProducer");
    }

    public ViewModelLazy(KClass kClass, Function0 function0, Function0 function02, Function0 function03) {
        Intrinsics.h(kClass, "viewModelClass");
        Intrinsics.h(function0, "storeProducer");
        Intrinsics.h(function02, "factoryProducer");
        Intrinsics.h(function03, "extrasProducer");
        this.a = kClass;
        this.b = function0;
        this.c = function02;
        this.d = function03;
    }

    public /* synthetic */ ViewModelLazy(KClass kClass, Function0 function0, Function0 function02, Function0 function03, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(kClass, function0, function02, (i & 8) != 0 ? new Function0<a.a>() { // from class: androidx.lifecycle.ViewModelLazy.1
            public final a.a invoke() {
                return a.a.b;
            }
        } : function03);
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public androidx.lifecycle.t0 getValue() {
        androidx.lifecycle.t0 t0Var = this.e;
        if (t0Var != null) {
            return t0Var;
        }
        androidx.lifecycle.t0 c = v0.b.a((x0) this.b.invoke(), (v0.c) this.c.invoke(), (a) this.d.invoke()).c(this.a);
        this.e = c;
        return c;
    }

    public boolean isInitialized() {
        return this.e != null;
    }
}
