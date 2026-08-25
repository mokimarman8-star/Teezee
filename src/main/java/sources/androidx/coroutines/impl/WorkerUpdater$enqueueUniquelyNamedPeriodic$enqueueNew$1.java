package androidx.coroutines.impl;

import androidx.coroutines.ExistingWorkPolicy;
import androidx.coroutines.impl.utils.EnqueueRunnable;
import androidx.work.r;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
final class WorkerUpdater$enqueueUniquelyNamedPeriodic$enqueueNew$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $name;
    final /* synthetic */ o $operation;
    final /* synthetic */ d0 $this_enqueueUniquelyNamedPeriodic;
    final /* synthetic */ r $workRequest;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WorkerUpdater$enqueueUniquelyNamedPeriodic$enqueueNew$1(r rVar, d0 d0Var, String str, o oVar) {
        super(0);
        this.$workRequest = rVar;
        this.$this_enqueueUniquelyNamedPeriodic = d0Var;
        this.$name = str;
        this.$operation = oVar;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m10invoke();
        return Unit.a;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m10invoke() {
        new EnqueueRunnable(new w(this.$this_enqueueUniquelyNamedPeriodic, this.$name, ExistingWorkPolicy.KEEP, CollectionsKt.e(this.$workRequest)), this.$operation).run();
    }
}
