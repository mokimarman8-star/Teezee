package com.transsion.room.sub.viewmodel.likes;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.BuildConfig;
import com.transsion.room.sub.bean.likes.GetUgcVideoLikesBean;
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
import op.a;
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.room.sub.viewmodel.likes.UgcLikesViewModel$getUgcVideoLikesBean$1", f = "UgcLikesViewModel.kt", l = {125}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class UgcLikesViewModel$getUgcVideoLikesBean$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $page;
    final /* synthetic */ String $userId;
    int label;
    final /* synthetic */ UgcLikesViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UgcLikesViewModel$getUgcVideoLikesBean$1(String str, String str2, UgcLikesViewModel ugcLikesViewModel, Continuation<? super UgcLikesViewModel$getUgcVideoLikesBean$1> continuation) {
        super(2, continuation);
        this.$page = str;
        this.$userId = str2;
        this.this$0 = ugcLikesViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UgcLikesViewModel$getUgcVideoLikesBean$1(this.$page, this.$userId, this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        int i;
        a aVar;
        int i2;
        List<UGCVideo> items;
        Object f = IntrinsicsKt.f();
        int i3 = this.label;
        try {
            if (i3 == 0) {
                ResultKt.b(obj);
                a.a aVar2 = wf.a.a;
                a.a.f(aVar2, "UgcLikesViewModel", "Likes page:" + this.$page, false, 4, (Object) null);
                i = UgcLikesViewModel.j;
                a.a.f(aVar2, "UgcLikesViewModel", "Likes perPage:" + i, false, 4, (Object) null);
                a.a.f(aVar2, "UgcLikesViewModel", "Likes userId:" + this.$userId, false, 4, (Object) null);
                aVar = this.this$0.d;
                String a = gg.a.a.a();
                String str = this.$page;
                i2 = UgcLikesViewModel.j;
                String str2 = this.$userId;
                this.label = 1;
                obj = aVar.b(a, str, i2, str2, this);
                if (obj == f) {
                    return f;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            BaseDto baseDto = (BaseDto) obj;
            a.a aVar3 = wf.a.a;
            a.a.f(aVar3, "UgcLikesViewModel", "Likes getUgcVideoLikesBean " + baseDto, false, 4, (Object) null);
            GetUgcVideoLikesBean getUgcVideoLikesBean = (GetUgcVideoLikesBean) baseDto.getData();
            a.a.f(aVar3, "UgcLikesViewModel", "Likes getUgcVideoLikesBean size:" + ((getUgcVideoLikesBean == null || (items = getUgcVideoLikesBean.getItems()) == null) ? null : Boxing.d(items.size())), false, 4, (Object) null);
            this.this$0.f().n(baseDto.getData());
        } catch (Exception e) {
            e.printStackTrace();
            a.a aVar4 = wf.a.a;
            String simpleName = UgcLikesViewModel.class.getSimpleName();
            Intrinsics.g(simpleName, "getSimpleName(...)");
            aVar4.i(simpleName, "exceptionHandler " + e.getMessage(), true);
        }
        return Unit.a;
    }
}
