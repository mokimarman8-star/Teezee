package com.transsion.audio.viewmodel;

import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.gslb.BuildConfig;
import com.transsnet.downloader.manager.DownloadEsHelper;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.audio.viewmodel.HistoryListManager$insert$1", f = "HistoryListManager.kt", l = {117, 118}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class HistoryListManager$insert$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ AudioBean $audioBean;
    int label;
    final /* synthetic */ HistoryListManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HistoryListManager$insert$1(AudioBean audioBean, HistoryListManager historyListManager, Continuation<? super HistoryListManager$insert$1> continuation) {
        super(2, continuation);
        this.$audioBean = audioBean;
        this.this$0 = historyListManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HistoryListManager$insert$1(this.$audioBean, this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        si.a q;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            this.$audioBean.setUpdateTimeStamp(Boxing.e(System.currentTimeMillis()));
            q = this.this$0.q();
            if (q != null) {
                AudioBean audioBean = this.$audioBean;
                this.label = 1;
                if (q.h(audioBean, this) == f) {
                    return f;
                }
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                a.a.g(wf.a.a, "audio insert ok", false, 2, (Object) null);
                yw.e eVar = new yw.e(true, false);
                FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
                String name = yw.e.class.getName();
                Intrinsics.g(name, "getName(...)");
                applicationScopeViewModel.postEvent(name, eVar, 0L);
                return Unit.a;
            }
            ResultKt.b(obj);
        }
        DownloadEsHelper a = DownloadEsHelper.m.a();
        String resourceId = this.$audioBean.getResourceId();
        if (resourceId == null) {
            resourceId = this.$audioBean.getAudioUrl();
        }
        Long readProcess = this.$audioBean.getReadProcess();
        long longValue = readProcess != null ? readProcess.longValue() : 0L;
        this.label = 2;
        if (a.e0(resourceId, longValue, this) == f) {
            return f;
        }
        a.a.g(wf.a.a, "audio insert ok", false, 2, (Object) null);
        yw.e eVar2 = new yw.e(true, false);
        FlowEventBus applicationScopeViewModel2 = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name2 = yw.e.class.getName();
        Intrinsics.g(name2, "getName(...)");
        applicationScopeViewModel2.postEvent(name2, eVar2, 0L);
        return Unit.a;
    }
}
