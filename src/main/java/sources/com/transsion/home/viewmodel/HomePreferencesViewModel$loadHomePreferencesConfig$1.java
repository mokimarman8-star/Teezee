package com.transsion.home.viewmodel;

import com.transsion.gslb.BuildConfig;
import com.transsion.home.bean.HomePreferencesState;
import com.transsion.home.repository.HomePreferencesRepository;
import java.util.Iterator;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.home.viewmodel.HomePreferencesViewModel$loadHomePreferencesConfig$1", f = "HomePreferencesViewModel.kt", l = {126}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class HomePreferencesViewModel$loadHomePreferencesConfig$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ HomePreferencesViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HomePreferencesViewModel$loadHomePreferencesConfig$1(HomePreferencesViewModel homePreferencesViewModel, Continuation<? super HomePreferencesViewModel$loadHomePreferencesConfig$1> continuation) {
        super(2, continuation);
        this.this$0 = homePreferencesViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        HomePreferencesViewModel$loadHomePreferencesConfig$1 homePreferencesViewModel$loadHomePreferencesConfig$1 = new HomePreferencesViewModel$loadHomePreferencesConfig$1(this.this$0, continuation);
        homePreferencesViewModel$loadHomePreferencesConfig$1.L$0 = obj;
        return homePreferencesViewModel$loadHomePreferencesConfig$1;
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        HomePreferencesRepository y;
        HomePreferencesViewModel homePreferencesViewModel;
        Map map;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.b(obj);
                HomePreferencesViewModel homePreferencesViewModel2 = this.this$0;
                Result.Companion companion = Result.Companion;
                y = homePreferencesViewModel2.y();
                this.L$0 = homePreferencesViewModel2;
                this.label = 1;
                Object f2 = y.f(null, this);
                if (f2 == f) {
                    return f;
                }
                homePreferencesViewModel = homePreferencesViewModel2;
                obj = f2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                homePreferencesViewModel = (HomePreferencesViewModel) this.L$0;
                ResultKt.b(obj);
            }
            HomePreferencesState homePreferencesState = (HomePreferencesState) obj;
            homePreferencesViewModel.h = homePreferencesState;
            homePreferencesViewModel.w().n(homePreferencesState);
            map = homePreferencesViewModel.i;
            Iterator it = map.keySet().iterator();
            while (it.hasNext()) {
                homePreferencesViewModel.p((String) it.next());
            }
            homePreferencesViewModel.N(homePreferencesState);
            obj2 = Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.a(th2));
        }
        HomePreferencesViewModel homePreferencesViewModel3 = this.this$0;
        Throwable th3 = Result.exceptionOrNull-impl(obj2);
        if (th3 != null) {
            a.a.l(wf.a.a, "HomePreferencesViewModel", "loadHomePreferencesConfig error: " + th3.getMessage(), false, 4, (Object) null);
            homePreferencesViewModel3.w().n((Object) null);
        }
        return Unit.a;
    }
}
