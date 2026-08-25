package com.transsion.postdetail.viewmodel.ugcfavorite;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.BuildConfig;
import com.transsion.postdetail.bean.favorite.FeedFavorData;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;
import np.a;
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.postdetail.viewmodel.ugcfavorite.UgcFavoriteViewModel$getUgcVideoFavoriteList$1", f = "UgcFavoriteViewModel.kt", l = {114}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class UgcFavoriteViewModel$getUgcVideoFavoriteList$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $page;
    final /* synthetic */ String $userId;
    int label;
    final /* synthetic */ UgcFavoriteViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UgcFavoriteViewModel$getUgcVideoFavoriteList$1(UgcFavoriteViewModel ugcFavoriteViewModel, String str, String str2, Continuation<? super UgcFavoriteViewModel$getUgcVideoFavoriteList$1> continuation) {
        super(2, continuation);
        this.this$0 = ugcFavoriteViewModel;
        this.$page = str;
        this.$userId = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UgcFavoriteViewModel$getUgcVideoFavoriteList$1(this.this$0, this.$page, this.$userId, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar;
        int i;
        List<UGCVideo> items;
        Object f = IntrinsicsKt.f();
        int i2 = this.label;
        try {
            if (i2 == 0) {
                ResultKt.b(obj);
                aVar = this.this$0.d;
                String a = gg.a.a.a();
                String str = this.$page;
                i = UgcFavoriteViewModel.i;
                String str2 = this.$userId;
                this.label = 1;
                obj = aVar.a(a, str, i, str2, this);
                if (obj == f) {
                    return f;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            BaseDto baseDto = (BaseDto) obj;
            a.a aVar2 = wf.a.a;
            a.a.f(aVar2, "subscription", "favorite data " + baseDto, false, 4, (Object) null);
            FeedFavorData feedFavorData = (FeedFavorData) baseDto.getData();
            a.a.f(aVar2, "subscription", "favorite data size " + ((feedFavorData == null || (items = feedFavorData.getItems()) == null) ? null : Boxing.d(items.size())), false, 4, (Object) null);
            this.this$0.e().n(baseDto.getData());
        } catch (Exception e) {
            e.printStackTrace();
            a.a aVar3 = wf.a.a;
            String simpleName = UgcFavoriteViewModel.class.getSimpleName();
            Intrinsics.g(simpleName, "getSimpleName(...)");
            aVar3.i(simpleName, "exceptionHandler " + e.getMessage(), true);
        }
        return Unit.a;
    }
}
