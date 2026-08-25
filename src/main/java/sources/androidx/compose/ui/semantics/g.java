package androidx.compose.ui.semantics;

import kotlin.jvm.functions.Function0;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private final Function0 f4969a;

    /* renamed from: b, reason: collision with root package name */
    private final Function0 f4970b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f4971c;

    public g(Function0 function0, Function0 function02, boolean z5) {
        this.f4969a = function0;
        this.f4970b = function02;
        this.f4971c = z5;
    }

    public final Function0 a() {
        return this.f4970b;
    }

    public final boolean b() {
        return this.f4971c;
    }

    public final Function0 c() {
        return this.f4969a;
    }

    public String toString() {
        return "ScrollAxisRange(value=" + ((Number) this.f4969a.invoke()).floatValue() + ", maxValue=" + ((Number) this.f4970b.invoke()).floatValue() + ", reverseScrolling=" + this.f4971c + ')';
    }
}
