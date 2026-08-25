package com.transsion.audio.viewmodel;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.audio.viewmodel.HistoryListManager;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.DownloadItem;
import com.transsnet.downloader.bean.DownloadListBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.audio.viewmodel.HistoryListManager$getResourcePosition$1", f = "HistoryListManager.kt", l = {145}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class HistoryListManager$getResourcePosition$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $postId;
    final /* synthetic */ int $resourceNum;
    final /* synthetic */ String $subjectId;
    int label;
    final /* synthetic */ HistoryListManager this$0;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/b;", "Lcom/transsnet/downloader/bean/DownloadListBean;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/flow/b;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.audio.viewmodel.HistoryListManager$getResourcePosition$1$1", f = "HistoryListManager.kt", l = {137, 139, 141}, m = "invokeSuspend")
    /* renamed from: com.transsion.audio.viewmodel.HistoryListManager$getResourcePosition$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.b, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $postId;
        final /* synthetic */ int $resourceNum;
        final /* synthetic */ String $subjectId;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ HistoryListManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(HistoryListManager historyListManager, String str, String str2, int i, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = historyListManager;
            this.$subjectId = str;
            this.$postId = str2;
            this.$resourceNum = i;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$subjectId, this.$postId, this.$resourceNum, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(kotlinx.coroutines.flow.b bVar, Continuation<? super Unit> continuation) {
            return create(bVar, continuation).invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlinx.coroutines.flow.b bVar;
            li.a u;
            DownloadListBean downloadListBean;
            List items;
            Object f = IntrinsicsKt.f();
            int i = this.label;
            if (i == 0) {
                ResultKt.b(obj);
                bVar = (kotlinx.coroutines.flow.b) this.L$0;
                u = this.this$0.u();
                String a = gg.a.a.a();
                String str = this.$subjectId;
                String str2 = this.$postId;
                int i2 = this.$resourceNum;
                this.L$0 = bVar;
                this.label = 1;
                obj = u.a(a, str, str2, i2, this);
                if (obj == f) {
                    return f;
                }
            } else {
                if (i != 1) {
                    if (i != 2 && i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    return Unit.a;
                }
                bVar = (kotlinx.coroutines.flow.b) this.L$0;
                ResultKt.b(obj);
            }
            BaseDto baseDto = (BaseDto) obj;
            if (Intrinsics.c(baseDto.getCode(), "0") && ((downloadListBean = (DownloadListBean) baseDto.getData()) == null || (items = downloadListBean.getItems()) == null || !items.isEmpty())) {
                Object data = baseDto.getData();
                this.L$0 = null;
                this.label = 3;
                if (bVar.emit(data, this) == f) {
                    return f;
                }
            } else {
                this.L$0 = null;
                this.label = 2;
                if (bVar.emit((Object) null, this) == f) {
                    return f;
                }
            }
            return Unit.a;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/b;", "Lcom/transsnet/downloader/bean/DownloadListBean;", BuildConfig.FLAVOR, "it", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/flow/b;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.audio.viewmodel.HistoryListManager$getResourcePosition$1$2", f = "HistoryListManager.kt", l = {144}, m = "invokeSuspend")
    /* renamed from: com.transsion.audio.viewmodel.HistoryListManager$getResourcePosition$1$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function3<kotlinx.coroutines.flow.b, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
        }

        public final Object invoke(kotlinx.coroutines.flow.b bVar, Throwable th2, Continuation<? super Unit> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
            anonymousClass2.L$0 = bVar;
            return anonymousClass2.invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            Object f = IntrinsicsKt.f();
            int i = this.label;
            if (i == 0) {
                ResultKt.b(obj);
                kotlinx.coroutines.flow.b bVar = (kotlinx.coroutines.flow.b) this.L$0;
                this.label = 1;
                if (bVar.emit((Object) null, this) == f) {
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

    /* renamed from: com.transsion.audio.viewmodel.HistoryListManager$getResourcePosition$1$3, reason: invalid class name */
    static final class AnonymousClass3 implements kotlinx.coroutines.flow.b {
        final /* synthetic */ HistoryListManager a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        AnonymousClass3(HistoryListManager historyListManager, String str, String str2) {
            this.a = historyListManager;
            this.b = str;
            this.c = str2;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x007e  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0090  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x009f  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00ae  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x003e  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(DownloadListBean downloadListBean, Continuation continuation) {
            HistoryListManager$getResourcePosition$1$3$emit$1 historyListManager$getResourcePosition$1$3$emit$1;
            int i;
            si.a q;
            AudioBean audioBean;
            si.a q2;
            List items;
            if (continuation instanceof HistoryListManager$getResourcePosition$1$3$emit$1) {
                historyListManager$getResourcePosition$1$3$emit$1 = (HistoryListManager$getResourcePosition$1$3$emit$1) continuation;
                int i2 = historyListManager$getResourcePosition$1$3$emit$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    historyListManager$getResourcePosition$1$3$emit$1.label = i2 - Integer.MIN_VALUE;
                    Object obj = historyListManager$getResourcePosition$1$3$emit$1.result;
                    Object f = IntrinsicsKt.f();
                    i = historyListManager$getResourcePosition$1$3$emit$1.label;
                    if (i != 0) {
                        ResultKt.b(obj);
                        HistoryListManager.a aVar = HistoryListManager.e;
                        if (!aVar.a()) {
                            this.a.v().n(downloadListBean);
                            aVar.c(true);
                        } else if (downloadListBean != null) {
                            this.a.v().n(downloadListBean);
                        }
                        q = this.a.q();
                        if (q == null) {
                            audioBean = null;
                            if (downloadListBean != null && (items = downloadListBean.getItems()) != null && !items.isEmpty()) {
                                if (audioBean != null) {
                                    audioBean.setSe(((DownloadItem) items.get(0)).getSe());
                                }
                                if (audioBean != null) {
                                    audioBean.setEp(((DownloadItem) items.get(0)).getEp());
                                }
                            }
                            if (audioBean != null || q2 == null) {
                                return Unit.a;
                            }
                            historyListManager$getResourcePosition$1$3$emit$1.L$0 = null;
                            historyListManager$getResourcePosition$1$3$emit$1.label = 2;
                            if (q2.f(audioBean, historyListManager$getResourcePosition$1$3$emit$1) == f) {
                                return f;
                            }
                            return Unit.a;
                        }
                        String str = this.b;
                        String str2 = this.c;
                        historyListManager$getResourcePosition$1$3$emit$1.L$0 = downloadListBean;
                        historyListManager$getResourcePosition$1$3$emit$1.label = 1;
                        obj = q.g(str, str2, historyListManager$getResourcePosition$1$3$emit$1);
                        if (obj == f) {
                            return f;
                        }
                    } else {
                        if (i != 1) {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.b(obj);
                            return Unit.a;
                        }
                        downloadListBean = (DownloadListBean) historyListManager$getResourcePosition$1$3$emit$1.L$0;
                        ResultKt.b(obj);
                    }
                    audioBean = (AudioBean) obj;
                    if (downloadListBean != null) {
                        if (audioBean != null) {
                        }
                        if (audioBean != null) {
                        }
                    }
                    if (audioBean != null) {
                        q2 = this.a.q();
                    }
                    return Unit.a;
                }
            }
            historyListManager$getResourcePosition$1$3$emit$1 = new HistoryListManager$getResourcePosition$1$3$emit$1(this, continuation);
            Object obj2 = historyListManager$getResourcePosition$1$3$emit$1.result;
            Object f2 = IntrinsicsKt.f();
            i = historyListManager$getResourcePosition$1$3$emit$1.label;
            if (i != 0) {
            }
            audioBean = (AudioBean) obj2;
            if (downloadListBean != null) {
            }
            if (audioBean != null) {
            }
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HistoryListManager$getResourcePosition$1(HistoryListManager historyListManager, String str, String str2, int i, Continuation<? super HistoryListManager$getResourcePosition$1> continuation) {
        super(2, continuation);
        this.this$0 = historyListManager;
        this.$subjectId = str;
        this.$postId = str2;
        this.$resourceNum = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HistoryListManager$getResourcePosition$1(this.this$0, this.$subjectId, this.$postId, this.$resourceNum, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            kotlinx.coroutines.flow.a e = kotlinx.coroutines.flow.c.e(kotlinx.coroutines.flow.c.r(new AnonymousClass1(this.this$0, this.$subjectId, this.$postId, this.$resourceNum, null)), new AnonymousClass2(null));
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.this$0, this.$subjectId, this.$postId);
            this.label = 1;
            if (e.a(anonymousClass3, this) == f) {
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
