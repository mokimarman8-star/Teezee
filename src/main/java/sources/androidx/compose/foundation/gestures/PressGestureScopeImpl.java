package androidx.compose.foundation.gestures;

import androidx.core.view.inputmethod.EditorInfoCompat;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlinx.coroutines.sync.a;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class PressGestureScopeImpl implements i, o0.e {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ o0.e f1670a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f1671b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f1672c;

    /* renamed from: d, reason: collision with root package name */
    private final kotlinx.coroutines.sync.a f1673d = kotlinx.coroutines.sync.g.a(false);

    public PressGestureScopeImpl(o0.e eVar) {
        this.f1670a = eVar;
    }

    @Override // o0.n
    public float B0() {
        return this.f1670a.B0();
    }

    @Override // o0.e
    public float D0(float f5) {
        return this.f1670a.D0(f5);
    }

    @Override // o0.n
    public long H(float f5) {
        return this.f1670a.H(f5);
    }

    @Override // o0.n
    public float J(long j5) {
        return this.f1670a.J(j5);
    }

    @Override // o0.e
    public long P0(long j5) {
        return this.f1670a.P0(j5);
    }

    @Override // o0.e
    public long Q(float f5) {
        return this.f1670a.Q(f5);
    }

    @Override // o0.e
    public int c0(float f5) {
        return this.f1670a.c0(f5);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // androidx.compose.foundation.gestures.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object f0(Continuation continuation) {
        PressGestureScopeImpl$tryAwaitRelease$1 pressGestureScopeImpl$tryAwaitRelease$1;
        int i5;
        PressGestureScopeImpl pressGestureScopeImpl;
        if (continuation instanceof PressGestureScopeImpl$tryAwaitRelease$1) {
            pressGestureScopeImpl$tryAwaitRelease$1 = (PressGestureScopeImpl$tryAwaitRelease$1) continuation;
            int i6 = pressGestureScopeImpl$tryAwaitRelease$1.label;
            if ((i6 & EditorInfoCompat.IME_FLAG_FORCE_ASCII) != 0) {
                pressGestureScopeImpl$tryAwaitRelease$1.label = i6 - EditorInfoCompat.IME_FLAG_FORCE_ASCII;
                Object obj = pressGestureScopeImpl$tryAwaitRelease$1.result;
                Object f5 = IntrinsicsKt.f();
                i5 = pressGestureScopeImpl$tryAwaitRelease$1.label;
                if (i5 != 0) {
                    ResultKt.b(obj);
                    if (this.f1671b || this.f1672c) {
                        pressGestureScopeImpl = this;
                        return Boxing.a(pressGestureScopeImpl.f1671b);
                    }
                    kotlinx.coroutines.sync.a aVar = this.f1673d;
                    pressGestureScopeImpl$tryAwaitRelease$1.L$0 = this;
                    pressGestureScopeImpl$tryAwaitRelease$1.label = 1;
                    if (a.a.a(aVar, (Object) null, pressGestureScopeImpl$tryAwaitRelease$1, 1, (Object) null) == f5) {
                        return f5;
                    }
                    pressGestureScopeImpl = this;
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    pressGestureScopeImpl = (PressGestureScopeImpl) pressGestureScopeImpl$tryAwaitRelease$1.L$0;
                    ResultKt.b(obj);
                }
                a.a.c(pressGestureScopeImpl.f1673d, (Object) null, 1, (Object) null);
                return Boxing.a(pressGestureScopeImpl.f1671b);
            }
        }
        pressGestureScopeImpl$tryAwaitRelease$1 = new PressGestureScopeImpl$tryAwaitRelease$1(this, continuation);
        Object obj2 = pressGestureScopeImpl$tryAwaitRelease$1.result;
        Object f52 = IntrinsicsKt.f();
        i5 = pressGestureScopeImpl$tryAwaitRelease$1.label;
        if (i5 != 0) {
        }
        a.a.c(pressGestureScopeImpl.f1673d, (Object) null, 1, (Object) null);
        return Boxing.a(pressGestureScopeImpl.f1671b);
    }

    @Override // o0.e
    public float getDensity() {
        return this.f1670a.getDensity();
    }

    @Override // o0.e
    public float h0(long j5) {
        return this.f1670a.h0(j5);
    }

    public final void n() {
        this.f1672c = true;
        a.a.c(this.f1673d, (Object) null, 1, (Object) null);
    }

    public final void v() {
        this.f1671b = true;
        a.a.c(this.f1673d, (Object) null, 1, (Object) null);
    }

    @Override // o0.e
    public float x0(float f5) {
        return this.f1670a.x0(f5);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object z(Continuation continuation) {
        PressGestureScopeImpl$reset$1 pressGestureScopeImpl$reset$1;
        int i5;
        PressGestureScopeImpl pressGestureScopeImpl;
        if (continuation instanceof PressGestureScopeImpl$reset$1) {
            pressGestureScopeImpl$reset$1 = (PressGestureScopeImpl$reset$1) continuation;
            int i6 = pressGestureScopeImpl$reset$1.label;
            if ((i6 & EditorInfoCompat.IME_FLAG_FORCE_ASCII) != 0) {
                pressGestureScopeImpl$reset$1.label = i6 - EditorInfoCompat.IME_FLAG_FORCE_ASCII;
                Object obj = pressGestureScopeImpl$reset$1.result;
                Object f5 = IntrinsicsKt.f();
                i5 = pressGestureScopeImpl$reset$1.label;
                if (i5 != 0) {
                    ResultKt.b(obj);
                    kotlinx.coroutines.sync.a aVar = this.f1673d;
                    pressGestureScopeImpl$reset$1.L$0 = this;
                    pressGestureScopeImpl$reset$1.label = 1;
                    if (a.a.a(aVar, (Object) null, pressGestureScopeImpl$reset$1, 1, (Object) null) == f5) {
                        return f5;
                    }
                    pressGestureScopeImpl = this;
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    pressGestureScopeImpl = (PressGestureScopeImpl) pressGestureScopeImpl$reset$1.L$0;
                    ResultKt.b(obj);
                }
                pressGestureScopeImpl.f1671b = false;
                pressGestureScopeImpl.f1672c = false;
                return Unit.a;
            }
        }
        pressGestureScopeImpl$reset$1 = new PressGestureScopeImpl$reset$1(this, continuation);
        Object obj2 = pressGestureScopeImpl$reset$1.result;
        Object f52 = IntrinsicsKt.f();
        i5 = pressGestureScopeImpl$reset$1.label;
        if (i5 != 0) {
        }
        pressGestureScopeImpl.f1671b = false;
        pressGestureScopeImpl.f1672c = false;
        return Unit.a;
    }
}
