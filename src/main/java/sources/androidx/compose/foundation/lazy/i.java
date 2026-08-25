package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.j;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class i implements j.a {

    /* renamed from: a, reason: collision with root package name */
    private final Function1 f1948a;

    /* renamed from: b, reason: collision with root package name */
    private final Function1 f1949b;

    /* renamed from: c, reason: collision with root package name */
    private final Function4 f1950c;

    public i(Function1 function1, Function1 function12, Function4 function4) {
        this.f1948a = function1;
        this.f1949b = function12;
        this.f1950c = function4;
    }

    public final Function4 a() {
        return this.f1950c;
    }

    @Override // androidx.compose.foundation.lazy.layout.j.a
    public Function1 getKey() {
        return this.f1948a;
    }

    @Override // androidx.compose.foundation.lazy.layout.j.a
    public Function1 getType() {
        return this.f1949b;
    }
}
