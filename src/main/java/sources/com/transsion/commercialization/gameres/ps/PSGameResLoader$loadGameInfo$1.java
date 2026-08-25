package com.transsion.commercialization.gameres.ps;

import android.content.Context;
import android.view.View;
import com.transsion.ad.ps.model.PsLinkDto;
import com.transsion.ad.ps.model.RecommendInfo;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.gslb.BuildConfig;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y0;
import okhttp3.RequestBody;
import org.json.JSONArray;
import org.json.JSONObject;
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.commercialization.gameres.ps.PSGameResLoader$loadGameInfo$1", f = "PSGameResLoader.kt", l = {62}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class PSGameResLoader$loadGameInfo$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<View, Unit> $callback;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $itemId;
    final /* synthetic */ String $pageName;
    int label;
    final /* synthetic */ PSGameResLoader this$0;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/flow/b;", BuildConfig.FLAVOR, "Lcom/transsion/ad/ps/model/RecommendInfo;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/flow/b;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.commercialization.gameres.ps.PSGameResLoader$loadGameInfo$1$3", f = "PSGameResLoader.kt", l = {52, 54, DownloadBean.STATUS_COMPLETED_REMOVED}, m = "invokeSuspend")
    /* renamed from: com.transsion.commercialization.gameres.ps.PSGameResLoader$loadGameInfo$1$3, reason: invalid class name */
    static final class AnonymousClass3 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.b, Continuation<? super Unit>, Object> {
        final /* synthetic */ RequestBody $body;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ PSGameResLoader this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(PSGameResLoader pSGameResLoader, RequestBody requestBody, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.this$0 = pSGameResLoader;
            this.$body = requestBody;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.this$0, this.$body, continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        public final Object invoke(kotlinx.coroutines.flow.b bVar, Continuation<? super Unit> continuation) {
            return create(bVar, continuation).invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlinx.coroutines.flow.b bVar;
            a g;
            Object f = IntrinsicsKt.f();
            int i = this.label;
            if (i == 0) {
                ResultKt.b(obj);
                bVar = (kotlinx.coroutines.flow.b) this.L$0;
                g = this.this$0.g();
                RequestBody requestBody = this.$body;
                String f2 = this.this$0.f();
                this.L$0 = bVar;
                this.label = 1;
                obj = g.a(requestBody, f2, this);
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
            PsLinkDto psLinkDto = (PsLinkDto) obj;
            if (psLinkDto.getCode() == 0) {
                List<RecommendInfo> data = psLinkDto.getData();
                this.L$0 = null;
                this.label = 2;
                if (bVar.emit(data, this) == f) {
                    return f;
                }
            } else {
                wf.a.a.c("GameResLoader", "PSGameRes fail, code:" + psLinkDto.getCode() + ", msg:" + psLinkDto.getMsg(), true);
                this.L$0 = null;
                this.label = 3;
                if (bVar.emit((Object) null, this) == f) {
                    return f;
                }
            }
            return Unit.a;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005*\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlinx/coroutines/flow/b;", BuildConfig.FLAVOR, "Lcom/transsion/ad/ps/model/RecommendInfo;", BuildConfig.FLAVOR, "it", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/flow/b;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.commercialization.gameres.ps.PSGameResLoader$loadGameInfo$1$4", f = "PSGameResLoader.kt", l = {61}, m = "invokeSuspend")
    /* renamed from: com.transsion.commercialization.gameres.ps.PSGameResLoader$loadGameInfo$1$4, reason: invalid class name */
    static final class AnonymousClass4 extends SuspendLambda implements Function3<kotlinx.coroutines.flow.b, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        AnonymousClass4(Continuation<? super AnonymousClass4> continuation) {
            super(3, continuation);
        }

        public final Object invoke(kotlinx.coroutines.flow.b bVar, Throwable th2, Continuation<? super Unit> continuation) {
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(continuation);
            anonymousClass4.L$0 = bVar;
            anonymousClass4.L$1 = th2;
            return anonymousClass4.invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            Object f = IntrinsicsKt.f();
            int i = this.label;
            if (i == 0) {
                ResultKt.b(obj);
                kotlinx.coroutines.flow.b bVar = (kotlinx.coroutines.flow.b) this.L$0;
                Throwable th2 = (Throwable) this.L$1;
                wf.a.a.c("GameResLoader", "PSGameRes error:" + th2, true);
                this.L$0 = null;
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    PSGameResLoader$loadGameInfo$1(String str, PSGameResLoader pSGameResLoader, Function1<? super View, Unit> function1, Context context, String str2, Continuation<? super PSGameResLoader$loadGameInfo$1> continuation) {
        super(2, continuation);
        this.$itemId = str;
        this.this$0 = pSGameResLoader;
        this.$callback = function1;
        this.$context = context;
        this.$pageName = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PSGameResLoader$loadGameInfo$1(this.$itemId, this.this$0, this.$callback, this.$context, this.$pageName, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(this.$itemId);
            Unit unit = Unit.a;
            jSONObject.put("itemIds", jSONArray);
            for (Map.Entry entry : zh.a.INSTANCE.a(System.currentTimeMillis()).entrySet()) {
                jSONObject.put((String) entry.getKey(), entry.getValue());
            }
            String jSONObject2 = jSONObject.toString();
            Intrinsics.g(jSONObject2, "toString(...)");
            wf.a.a.c("GameResLoader", "PSGameRes loadGameInfo,bodyStr:" + jSONObject2 + " ", true);
            kotlinx.coroutines.flow.a e = kotlinx.coroutines.flow.c.e(kotlinx.coroutines.flow.c.r(new AnonymousClass3(this.this$0, mg.b.a.a(jSONObject2), null)), new AnonymousClass4(null));
            final Function1<View, Unit> function1 = this.$callback;
            final PSGameResLoader pSGameResLoader = this.this$0;
            final Context context = this.$context;
            final String str = this.$pageName;
            final String str2 = this.$itemId;
            kotlinx.coroutines.flow.b bVar = new kotlinx.coroutines.flow.b() { // from class: com.transsion.commercialization.gameres.ps.PSGameResLoader$loadGameInfo$1.5

                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
                @DebugMetadata(c = "com.transsion.commercialization.gameres.ps.PSGameResLoader$loadGameInfo$1$5$1", f = "PSGameResLoader.kt", l = {}, m = "invokeSuspend")
                /* renamed from: com.transsion.commercialization.gameres.ps.PSGameResLoader$loadGameInfo$1$5$1, reason: invalid class name */
                static final class AnonymousClass1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
                    final /* synthetic */ Function1<View, Unit> $callback;
                    final /* synthetic */ Context $context;
                    final /* synthetic */ String $itemId;
                    final /* synthetic */ String $pageName;
                    final /* synthetic */ List<RecommendInfo> $response;
                    int label;
                    final /* synthetic */ PSGameResLoader this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    AnonymousClass1(List<RecommendInfo> list, Function1<? super View, Unit> function1, PSGameResLoader pSGameResLoader, Context context, String str, String str2, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$response = list;
                        this.$callback = function1;
                        this.this$0 = pSGameResLoader;
                        this.$context = context;
                        this.$pageName = str;
                        this.$itemId = str2;
                    }

                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.$response, this.$callback, this.this$0, this.$context, this.$pageName, this.$itemId, continuation);
                    }

                    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
                        return create(n0Var, continuation).invokeSuspend(Unit.a);
                    }

                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.f();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                        List<RecommendInfo> list = this.$response;
                        if (list != null && !list.isEmpty()) {
                            RecommendInfo recommendInfo = (RecommendInfo) CollectionsKt.k0(this.$response);
                            if (recommendInfo != null ? Intrinsics.c(recommendInfo.getExists(), Boxing.a(true)) : false) {
                                RecommendInfo recommendInfo2 = (RecommendInfo) CollectionsKt.k0(this.$response);
                                if (recommendInfo2 != null) {
                                    Function1<View, Unit> function1 = this.$callback;
                                    PSGameResLoader pSGameResLoader = this.this$0;
                                    Context context = this.$context;
                                    String str = this.$pageName;
                                    String str2 = this.$itemId;
                                    a.a.f(wf.a.a, "GameResLoader", "PSGameRes getGameInfo, success:" + recommendInfo2, false, 4, (Object) null);
                                    function1.invoke(pSGameResLoader.e(context, pSGameResLoader.d(str, str2, recommendInfo2)));
                                } else {
                                    this.$callback.invoke((Object) null);
                                }
                                return Unit.a;
                            }
                        }
                        this.$callback.invoke((Object) null);
                        return Unit.a;
                    }
                }

                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object emit(List list, Continuation continuation) {
                    Object g = i.g(y0.c(), new AnonymousClass1(list, function1, pSGameResLoader, context, str, str2, null), continuation);
                    return g == IntrinsicsKt.f() ? g : Unit.a;
                }
            };
            this.label = 1;
            if (e.a(bVar, this) == f) {
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
