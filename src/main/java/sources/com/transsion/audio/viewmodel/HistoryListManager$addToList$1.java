package com.transsion.audio.viewmodel;

import com.transsion.athena.config.data.model.TidConfigBean;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.gslb.BuildConfig;
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
import kotlinx.coroutines.i;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.audio.viewmodel.HistoryListManager$addToList$1", f = "HistoryListManager.kt", l = {101}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class HistoryListManager$addToList$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ AudioBean $audioBean;
    int label;
    final /* synthetic */ HistoryListManager this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.audio.viewmodel.HistoryListManager$addToList$1$1", f = "HistoryListManager.kt", l = {103, TidConfigBean.REASON_SAMPLING_RATE, 107}, m = "invokeSuspend")
    /* renamed from: com.transsion.audio.viewmodel.HistoryListManager$addToList$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
        final /* synthetic */ AudioBean $audioBean;
        int label;
        final /* synthetic */ HistoryListManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(AudioBean audioBean, HistoryListManager historyListManager, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$audioBean = audioBean;
            this.this$0 = historyListManager;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$audioBean, this.this$0, continuation);
        }

        public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
            return create(n0Var, continuation).invokeSuspend(Unit.a);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0082 A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            si.a q;
            si.a q2;
            List list;
            si.a q3;
            AudioBean audioBean;
            Object f = IntrinsicsKt.f();
            int i = this.label;
            if (i == 0) {
                ResultKt.b(obj);
                this.$audioBean.setUpdateTimeStamp(Boxing.e(System.currentTimeMillis()));
                q = this.this$0.q();
                if (q != null) {
                    AudioBean audioBean2 = this.$audioBean;
                    this.label = 1;
                    if (q.h(audioBean2, this) == f) {
                        return f;
                    }
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                        return Unit.a;
                    }
                    ResultKt.b(obj);
                    list = (List) obj;
                    if (list != null && list.size() > 30 && q3 != null) {
                        audioBean = (AudioBean) list.get(list.size() - 1);
                        this.label = 3;
                        if (q3.b(audioBean, this) == f) {
                            return f;
                        }
                    }
                    return Unit.a;
                }
                ResultKt.b(obj);
            }
            q2 = this.this$0.q();
            if (q2 == null) {
                list = null;
                if (list != null) {
                }
                return Unit.a;
            }
            this.label = 2;
            obj = q2.e(this);
            if (obj == f) {
                return f;
            }
            list = (List) obj;
            if (list != null) {
                q3 = this.this$0.q();
                audioBean = (AudioBean) list.get(list.size() - 1);
                this.label = 3;
                if (q3.b(audioBean, this) == f) {
                }
            }
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HistoryListManager$addToList$1(AudioBean audioBean, HistoryListManager historyListManager, Continuation<? super HistoryListManager$addToList$1> continuation) {
        super(2, continuation);
        this.$audioBean = audioBean;
        this.this$0 = historyListManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HistoryListManager$addToList$1(this.$audioBean, this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            i0 b = y0.b();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$audioBean, this.this$0, null);
            this.label = 1;
            if (i.g(b, anonymousClass1, this) == f) {
                return f;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.a;
    }
}
