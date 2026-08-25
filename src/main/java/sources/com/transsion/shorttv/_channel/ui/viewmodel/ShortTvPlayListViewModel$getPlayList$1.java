package com.transsion.shorttv._channel.ui.viewmodel;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.BuildConfig;
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
import rq.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.shorttv._channel.ui.viewmodel.ShortTvPlayListViewModel$getPlayList$1", f = "ShortTvPlayListViewModel.kt", l = {22}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class ShortTvPlayListViewModel$getPlayList$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $category;
    final /* synthetic */ String $label;
    final /* synthetic */ String $recType;
    final /* synthetic */ int $tabId;
    final /* synthetic */ String $topIds;
    int label;
    final /* synthetic */ ShortTvPlayListViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ShortTvPlayListViewModel$getPlayList$1(ShortTvPlayListViewModel shortTvPlayListViewModel, String str, String str2, String str3, String str4, int i, Continuation<? super ShortTvPlayListViewModel$getPlayList$1> continuation) {
        super(2, continuation);
        this.this$0 = shortTvPlayListViewModel;
        this.$label = str;
        this.$category = str2;
        this.$recType = str3;
        this.$topIds = str4;
        this.$tabId = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShortTvPlayListViewModel$getPlayList$1(this.this$0, this.$label, this.$category, this.$recType, this.$topIds, this.$tabId, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        rq.a aVar;
        int i;
        Object a;
        Object f = IntrinsicsKt.f();
        int i2 = this.label;
        try {
            if (i2 == 0) {
                ResultKt.b(obj);
                aVar = this.this$0.a;
                int e = this.this$0.e();
                i = this.this$0.d;
                String str = this.$label;
                String str2 = this.$category;
                String str3 = this.$recType;
                String str4 = this.$topIds;
                int i3 = this.$tabId;
                this.label = 1;
                a = a.C0092a.a(aVar, null, e, i, str, str2, str3, str4, i3, this, 1, null);
                if (a == f) {
                    return f;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                a = obj;
            }
            BaseDto baseDto = (BaseDto) a;
            if (baseDto.getData() != null) {
                this.this$0.g().n(baseDto.getData());
                int e2 = this.this$0.e();
                this.this$0.i(e2 + 1);
                Boxing.d(e2);
            } else {
                this.this$0.g().n((Object) null);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            this.this$0.g().n((Object) null);
        }
        return Unit.a;
    }
}
