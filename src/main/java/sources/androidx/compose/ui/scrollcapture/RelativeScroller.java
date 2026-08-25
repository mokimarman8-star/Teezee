package androidx.compose.ui.scrollcapture;

import androidx.core.view.inputmethod.EditorInfoCompat;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class RelativeScroller {

    /* renamed from: a, reason: collision with root package name */
    private final int f4894a;

    /* renamed from: b, reason: collision with root package name */
    private final Function2 f4895b;

    /* renamed from: c, reason: collision with root package name */
    private float f4896c;

    public RelativeScroller(int i5, Function2 function2) {
        this.f4894a = i5;
        this.f4895b = function2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object e(float f5, Continuation continuation) {
        RelativeScroller$scrollBy$1 relativeScroller$scrollBy$1;
        int i5;
        RelativeScroller relativeScroller;
        if (continuation instanceof RelativeScroller$scrollBy$1) {
            relativeScroller$scrollBy$1 = (RelativeScroller$scrollBy$1) continuation;
            int i6 = relativeScroller$scrollBy$1.label;
            if ((i6 & EditorInfoCompat.IME_FLAG_FORCE_ASCII) != 0) {
                relativeScroller$scrollBy$1.label = i6 - EditorInfoCompat.IME_FLAG_FORCE_ASCII;
                Object obj = relativeScroller$scrollBy$1.result;
                Object f6 = IntrinsicsKt.f();
                i5 = relativeScroller$scrollBy$1.label;
                if (i5 != 0) {
                    ResultKt.b(obj);
                    Function2 function2 = this.f4895b;
                    Float c5 = Boxing.c(f5);
                    relativeScroller$scrollBy$1.L$0 = this;
                    relativeScroller$scrollBy$1.label = 1;
                    obj = function2.invoke(c5, relativeScroller$scrollBy$1);
                    if (obj == f6) {
                        return f6;
                    }
                    relativeScroller = this;
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    relativeScroller = (RelativeScroller) relativeScroller$scrollBy$1.L$0;
                    ResultKt.b(obj);
                }
                relativeScroller.f4896c += ((Number) obj).floatValue();
                return Unit.a;
            }
        }
        relativeScroller$scrollBy$1 = new RelativeScroller$scrollBy$1(this, continuation);
        Object obj2 = relativeScroller$scrollBy$1.result;
        Object f62 = IntrinsicsKt.f();
        i5 = relativeScroller$scrollBy$1.label;
        if (i5 != 0) {
        }
        relativeScroller.f4896c += ((Number) obj2).floatValue();
        return Unit.a;
    }

    public final float b() {
        return this.f4896c;
    }

    public final int c(int i5) {
        return RangesKt.l(i5 - MathKt.d(this.f4896c), 0, this.f4894a);
    }

    public final void d() {
        this.f4896c = 0.0f;
    }

    public final Object f(int i5, int i6, Continuation continuation) {
        if (i5 > i6) {
            throw new IllegalArgumentException(("Expected min=" + i5 + " ≤ max=" + i6).toString());
        }
        int i7 = i6 - i5;
        int i8 = this.f4894a;
        if (i7 > i8) {
            throw new IllegalArgumentException(("Expected range (" + i7 + ") to be ≤ viewportSize=" + this.f4894a).toString());
        }
        float f5 = i5;
        float f6 = this.f4896c;
        if (f5 >= f6 && i6 <= i8 + f6) {
            return Unit.a;
        }
        if (f5 >= f6) {
            i5 = i6 - i8;
        }
        Object g5 = g(i5, continuation);
        return g5 == IntrinsicsKt.f() ? g5 : Unit.a;
    }

    public final Object g(float f5, Continuation continuation) {
        Object e5 = e(f5 - this.f4896c, continuation);
        return e5 == IntrinsicsKt.f() ? e5 : Unit.a;
    }
}
