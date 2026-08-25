package androidx.datastore.flow;

import androidx.core.view.inputmethod.EditorInfoCompat;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.sync.a;
import kotlinx.coroutines.sync.g;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class RunOnce {

    /* renamed from: a, reason: collision with root package name */
    private final a f7452a = g.b(false, 1, (Object) null);

    /* renamed from: b, reason: collision with root package name */
    private final w f7453b = y.b((t1) null, 1, (Object) null);

    public final Object a(Continuation continuation) {
        Object f5 = this.f7453b.f(continuation);
        return f5 == IntrinsicsKt.f() ? f5 : Unit.a;
    }

    protected abstract Object b(Continuation continuation);

    /* JADX WARN: Removed duplicated region for block: B:27:0x0072 A[Catch: all -> 0x0078, TRY_LEAVE, TryCatch #1 {all -> 0x0078, blocks: (B:25:0x006a, B:27:0x0072, B:30:0x007c), top: B:24:0x006a }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007c A[Catch: all -> 0x0078, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0078, blocks: (B:25:0x006a, B:27:0x0072, B:30:0x007c), top: B:24:0x006a }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object c(Continuation continuation) {
        RunOnce$runIfNeeded$1 runOnce$runIfNeeded$1;
        int i5;
        a aVar;
        RunOnce runOnce;
        a aVar2;
        Throwable th;
        RunOnce runOnce2;
        try {
            if (continuation instanceof RunOnce$runIfNeeded$1) {
                runOnce$runIfNeeded$1 = (RunOnce$runIfNeeded$1) continuation;
                int i6 = runOnce$runIfNeeded$1.label;
                if ((i6 & EditorInfoCompat.IME_FLAG_FORCE_ASCII) != 0) {
                    runOnce$runIfNeeded$1.label = i6 - EditorInfoCompat.IME_FLAG_FORCE_ASCII;
                    Object obj = runOnce$runIfNeeded$1.result;
                    Object f5 = IntrinsicsKt.f();
                    i5 = runOnce$runIfNeeded$1.label;
                    if (i5 != 0) {
                        ResultKt.b(obj);
                        if (this.f7453b.isCompleted()) {
                            return Unit.a;
                        }
                        aVar = this.f7452a;
                        runOnce$runIfNeeded$1.L$0 = this;
                        runOnce$runIfNeeded$1.L$1 = aVar;
                        runOnce$runIfNeeded$1.label = 1;
                        if (aVar.f((Object) null, runOnce$runIfNeeded$1) == f5) {
                            return f5;
                        }
                        runOnce = this;
                    } else {
                        if (i5 != 1) {
                            if (i5 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            aVar2 = (a) runOnce$runIfNeeded$1.L$1;
                            runOnce2 = (RunOnce) runOnce$runIfNeeded$1.L$0;
                            try {
                                ResultKt.b(obj);
                                w wVar = runOnce2.f7453b;
                                Unit unit = Unit.a;
                                wVar.l(unit);
                                aVar2.unlock((Object) null);
                                return unit;
                            } catch (Throwable th2) {
                                th = th2;
                                aVar2.unlock((Object) null);
                                throw th;
                            }
                        }
                        a aVar3 = (a) runOnce$runIfNeeded$1.L$1;
                        runOnce = (RunOnce) runOnce$runIfNeeded$1.L$0;
                        ResultKt.b(obj);
                        aVar = aVar3;
                    }
                    if (!runOnce.f7453b.isCompleted()) {
                        Unit unit2 = Unit.a;
                        aVar.unlock((Object) null);
                        return unit2;
                    }
                    runOnce$runIfNeeded$1.L$0 = runOnce;
                    runOnce$runIfNeeded$1.L$1 = aVar;
                    runOnce$runIfNeeded$1.label = 2;
                    if (runOnce.b(runOnce$runIfNeeded$1) == f5) {
                        return f5;
                    }
                    aVar2 = aVar;
                    runOnce2 = runOnce;
                    w wVar2 = runOnce2.f7453b;
                    Unit unit3 = Unit.a;
                    wVar2.l(unit3);
                    aVar2.unlock((Object) null);
                    return unit3;
                }
            }
            if (!runOnce.f7453b.isCompleted()) {
            }
        } catch (Throwable th3) {
            aVar2 = aVar;
            th = th3;
            aVar2.unlock((Object) null);
            throw th;
        }
        runOnce$runIfNeeded$1 = new RunOnce$runIfNeeded$1(this, continuation);
        Object obj2 = runOnce$runIfNeeded$1.result;
        Object f52 = IntrinsicsKt.f();
        i5 = runOnce$runIfNeeded$1.label;
        if (i5 != 0) {
        }
    }
}
