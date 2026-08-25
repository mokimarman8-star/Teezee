package com.cloud.tmc.worker;

import com.cloud.tmc.kernel.framework.FrameworkConstants;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.WorkerAnalyseType;
import com.cloud.tmc.kernel.proxy.worker.IWorkerFactory;
import com.cloud.tmc.kernel.worker.IWorker;
import com.cloud.tmc.worker.WorkerManager.MyWorkCall;
import com.cloud.tmc.worker.WorkerManager.MyWorkLifeCycle;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.cloud.tmc.worker.WorkerManager$registerWorkerReadyListener$1", f = "WorkerManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class WorkerManager$registerWorkerReadyListener$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ WorkerManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WorkerManager$registerWorkerReadyListener$1(WorkerManager workerManager, Continuation<? super WorkerManager$registerWorkerReadyListener$1> continuation) {
        super(2, continuation);
        this.this$0 = workerManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WorkerManager$registerWorkerReadyListener$1(this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0071, code lost:
    
        r6 = r5.this$0.workerId;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Node node;
        IWorker iWorker;
        String str;
        String str2;
        String str3;
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        WorkerManager workerManager = this.this$0;
        IWorkerFactory iWorkerFactory = (IWorkerFactory) TmcProxy.get(IWorkerFactory.class);
        String str4 = this.this$0.appId;
        node = this.this$0.node;
        IWorker createWorker = iWorkerFactory.createWorker(str4, node);
        if (createWorker != null) {
            WorkerManager workerManager2 = this.this$0;
            createWorker.registerWorkLifeCycle(workerManager2.new MyWorkLifeCycle());
            createWorker.registerWorkerCallback(workerManager2.new MyWorkCall());
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(workerManager2.appId, WorkerAnalyseType.CREATE_START, null);
            createWorker.create();
        } else {
            createWorker = null;
        }
        workerManager.worker = createWorker;
        iWorker = this.this$0.worker;
        if (iWorker == null) {
            str = this.this$0.workerId;
            if (str != null) {
                str2 = this.this$0.workerId;
                if (!Intrinsics.c(str2, "100000") && (str3 == null || !StringsKt.W(str3, FrameworkConstants.TMP_WARMUP_WORKER_ID_PREFIX, false, 2, (Object) null))) {
                    this.this$0.postCreateWorkerEvent();
                }
            }
            this.this$0.pendingCreateWorkerFail = true;
        }
        return Unit.a;
    }
}
