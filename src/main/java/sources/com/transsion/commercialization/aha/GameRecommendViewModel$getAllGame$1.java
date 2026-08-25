package com.transsion.commercialization.aha;

import androidx.lifecycle.b0;
import com.transsion.bean.AhaGameResponse;
import com.transsion.gslb.BuildConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;
import mg.b;
import okhttp3.RequestBody;
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.commercialization.aha.GameRecommendViewModel$getAllGame$1", f = "GameRecommendViewModel.kt", l = {37}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class GameRecommendViewModel$getAllGame$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ GameRecommendViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GameRecommendViewModel$getAllGame$1(GameRecommendViewModel gameRecommendViewModel, Continuation<? super GameRecommendViewModel$getAllGame$1> continuation) {
        super(2, continuation);
        this.this$0 = gameRecommendViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GameRecommendViewModel$getAllGame$1(this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        String j;
        String j2;
        b0 b0Var;
        g k;
        int i;
        GameRecommendViewModel gameRecommendViewModel;
        int i2;
        b0 b0Var2;
        String j3;
        String j4;
        Object f = IntrinsicsKt.f();
        int i3 = this.label;
        try {
            if (i3 == 0) {
                ResultKt.b(obj);
                GameRecommendViewModel gameRecommendViewModel2 = this.this$0;
                Result.Companion companion = Result.Companion;
                k = gameRecommendViewModel2.k();
                Map a = g.INSTANCE.a();
                b.a aVar = mg.b.a;
                i = gameRecommendViewModel2.c;
                RequestBody a2 = aVar.a(new AhaGameRequest(new AhaGameQuery(i, 10)));
                this.L$0 = gameRecommendViewModel2;
                this.label = 1;
                Object a3 = k.a(a, a2, this);
                if (a3 == f) {
                    return f;
                }
                gameRecommendViewModel = gameRecommendViewModel2;
                obj = a3;
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                gameRecommendViewModel = (GameRecommendViewModel) this.L$0;
                ResultKt.b(obj);
            }
            AhaGameResponse ahaGameResponse = (AhaGameResponse) obj;
            Integer code = ahaGameResponse.getCode();
            if (code != null && code.intValue() == 1000) {
                i2 = gameRecommendViewModel.c;
                gameRecommendViewModel.c = i2 + 1;
            }
            b0Var2 = gameRecommendViewModel.a;
            b0Var2.n(ahaGameResponse);
            a.a aVar2 = wf.a.a;
            j3 = gameRecommendViewModel.j();
            j4 = gameRecommendViewModel.j();
            aVar2.c(j3, j4 + " --> getAllGame() --> postAhaGameRecommendList = " + ahaGameResponse, true);
            obj2 = Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.a(th2));
        }
        GameRecommendViewModel gameRecommendViewModel3 = this.this$0;
        Throwable th3 = Result.exceptionOrNull-impl(obj2);
        if (th3 != null) {
            a.a aVar3 = wf.a.a;
            j = gameRecommendViewModel3.j();
            j2 = gameRecommendViewModel3.j();
            aVar3.c(j, j2 + " --> getAllGame() --> 加载失败了 it = " + th3, true);
            b0Var = gameRecommendViewModel3.a;
            b0Var.n((Object) null);
        }
        return Unit.a;
    }
}
