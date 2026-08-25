package com.transsion.shorttv._channel.ui.viewmodel;

import com.google.gson.JsonObject;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.BuildConfig;
import com.transsion.shorttv._channel.model.ShortTvCategoryBean;
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
import mg.b;
import okhttp3.RequestBody;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.shorttv._channel.ui.viewmodel.ShortTvCategoryViewModel$getCategoryList$1", f = "ShortTvCategoryViewModel.kt", l = {36}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class ShortTvCategoryViewModel$getCategoryList$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $type;
    Object L$0;
    int label;
    final /* synthetic */ ShortTvCategoryViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ShortTvCategoryViewModel$getCategoryList$1(String str, ShortTvCategoryViewModel shortTvCategoryViewModel, Continuation<? super ShortTvCategoryViewModel$getCategoryList$1> continuation) {
        super(2, continuation);
        this.$type = str;
        this.this$0 = shortTvCategoryViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShortTvCategoryViewModel$getCategoryList$1(this.$type, this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        int i;
        rq.a l;
        ShortTvCategoryViewModel shortTvCategoryViewModel;
        Object f = IntrinsicsKt.f();
        int i2 = this.label;
        try {
        } catch (Exception e) {
            this.this$0.j().n(new BaseDto());
            e.printStackTrace();
        }
        if (i2 == 0) {
            ResultKt.b(obj);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("type", this.$type);
            jsonObject.addProperty("page", Boxing.d(this.this$0.k()));
            i = this.this$0.c;
            jsonObject.addProperty("perPage", Boxing.d(i));
            b.a aVar = mg.b.a;
            String jsonElement = jsonObject.toString();
            Intrinsics.g(jsonElement, "toString(...)");
            RequestBody a = aVar.a(jsonElement);
            if (a != null) {
                ShortTvCategoryViewModel shortTvCategoryViewModel2 = this.this$0;
                l = shortTvCategoryViewModel2.l();
                String a2 = gg.a.a.a();
                this.L$0 = shortTvCategoryViewModel2;
                this.label = 1;
                obj = l.c(a2, a, this);
                if (obj == f) {
                    return f;
                }
                shortTvCategoryViewModel = shortTvCategoryViewModel2;
            }
            return Unit.a;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        shortTvCategoryViewModel = (ShortTvCategoryViewModel) this.L$0;
        ResultKt.b(obj);
        BaseDto baseDto = (BaseDto) obj;
        shortTvCategoryViewModel.m((ShortTvCategoryBean) baseDto.getData());
        shortTvCategoryViewModel.j().n(baseDto);
        int k = shortTvCategoryViewModel.k();
        shortTvCategoryViewModel.o(k + 1);
        Boxing.d(k);
        return Unit.a;
    }
}
