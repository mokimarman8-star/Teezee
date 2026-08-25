package com.transsion.audio.viewmodel;

import android.text.TextUtils;
import com.transsion.audio.player.AudioPlayer;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.gslb.BuildConfig;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.audio.viewmodel.HistoryListManager$getAudioList$1", f = "HistoryListManager.kt", l = {56, 67}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class HistoryListManager$getAudioList$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ HistoryListManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HistoryListManager$getAudioList$1(HistoryListManager historyListManager, Continuation<? super HistoryListManager$getAudioList$1> continuation) {
        super(2, continuation);
        this.this$0 = historyListManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HistoryListManager$getAudioList$1(this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        si.a q;
        List list;
        List list2;
        AudioBean t;
        Iterator it;
        si.a q2;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            q = this.this$0.q();
            if (q == null) {
                list = null;
                if (list != null && !list.isEmpty()) {
                    list2 = list;
                    t = AudioPlayer.i.a().t();
                    it = list.iterator();
                    while (it.hasNext()) {
                    }
                    list = list2;
                }
                this.this$0.p().q(list);
                if (list != null) {
                }
                a.a.g(wf.a.a, "get getAudioList success" + (list != null ? Boxing.d(list.size()) : null), false, 2, (Object) null);
                return Unit.a;
            }
            this.label = 1;
            obj = q.e(this);
            if (obj == f) {
                return f;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (Iterator) this.L$2;
                t = (AudioBean) this.L$1;
                list2 = (List) this.L$0;
                ResultKt.b(obj);
                while (it.hasNext()) {
                    AudioBean audioBean = (AudioBean) it.next();
                    if (audioBean.getStatus() == 3) {
                        if (TextUtils.equals(t != null ? t.getAudioUrl() : null, audioBean.getAudioUrl())) {
                            continue;
                        } else {
                            audioBean.setStatus(4);
                            q2 = this.this$0.q();
                            if (q2 != null) {
                                this.L$0 = list2;
                                this.L$1 = t;
                                this.L$2 = it;
                                this.label = 2;
                                if (q2.h(audioBean, this) == f) {
                                    return f;
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                }
                list = list2;
                this.this$0.p().q(list);
                a.a.g(wf.a.a, "get getAudioList success" + (list != null ? Boxing.d(list.size()) : null), false, 2, (Object) null);
                return Unit.a;
            }
            ResultKt.b(obj);
        }
        list = (List) obj;
        if (list != null) {
            list2 = list;
            t = AudioPlayer.i.a().t();
            it = list.iterator();
            while (it.hasNext()) {
            }
            list = list2;
        }
        this.this$0.p().q(list);
        if (list != null) {
        }
        a.a.g(wf.a.a, "get getAudioList success" + (list != null ? Boxing.d(list.size()) : null), false, 2, (Object) null);
        return Unit.a;
    }
}
