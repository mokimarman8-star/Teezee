package com.transsion.home.viewmodel;

import com.transsion.gslb.BuildConfig;
import com.transsion.home.bean.HomePreferencesConfig;
import com.transsion.home.bean.HomePreferencesRefreshType;
import com.transsion.home.repository.HomePreferencesRepository;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.home.viewmodel.HomePreferencesViewModel$submitPreferencesInternal$1", f = "HomePreferencesViewModel.kt", l = {410, 413}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class HomePreferencesViewModel$submitPreferencesInternal$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ HomePreferencesConfig $config;
    final /* synthetic */ boolean $force;
    final /* synthetic */ String $labelId;
    final /* synthetic */ List<String> $normalized;
    final /* synthetic */ String $scene;
    private /* synthetic */ Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    final /* synthetic */ HomePreferencesViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HomePreferencesViewModel$submitPreferencesInternal$1(HomePreferencesViewModel homePreferencesViewModel, String str, List<String> list, boolean z, HomePreferencesConfig homePreferencesConfig, String str2, Continuation<? super HomePreferencesViewModel$submitPreferencesInternal$1> continuation) {
        super(2, continuation);
        this.this$0 = homePreferencesViewModel;
        this.$labelId = str;
        this.$normalized = list;
        this.$force = z;
        this.$config = homePreferencesConfig;
        this.$scene = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        HomePreferencesViewModel$submitPreferencesInternal$1 homePreferencesViewModel$submitPreferencesInternal$1 = new HomePreferencesViewModel$submitPreferencesInternal$1(this.this$0, this.$labelId, this.$normalized, this.$force, this.$config, this.$scene, continuation);
        homePreferencesViewModel$submitPreferencesInternal$1.L$0 = obj;
        return homePreferencesViewModel$submitPreferencesInternal$1;
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Throwable th2;
        HomePreferencesViewModel homePreferencesViewModel;
        HomePreferencesRepository y;
        boolean z;
        HomePreferencesConfig homePreferencesConfig;
        HomePreferencesRepository y2;
        HomePreferencesViewModel homePreferencesViewModel2;
        HomePreferencesConfig homePreferencesConfig2;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        try {
        } catch (Throwable th3) {
            Result.Companion companion = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.a(th3));
        }
        if (i == 0) {
            ResultKt.b(obj);
            homePreferencesViewModel = this.this$0;
            String str = this.$labelId;
            List<String> list = this.$normalized;
            boolean z2 = this.$force;
            HomePreferencesConfig homePreferencesConfig3 = this.$config;
            Result.Companion companion2 = Result.Companion;
            y = homePreferencesViewModel.y();
            this.L$0 = homePreferencesViewModel;
            this.L$1 = homePreferencesConfig3;
            this.Z$0 = z2;
            this.label = 1;
            if (y.m(str, list, this) == f) {
                return f;
            }
            z = z2;
            homePreferencesConfig = homePreferencesConfig3;
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                homePreferencesConfig2 = (HomePreferencesConfig) this.L$1;
                homePreferencesViewModel2 = (HomePreferencesViewModel) this.L$0;
                ResultKt.b(obj);
                homePreferencesConfig = homePreferencesConfig2;
                homePreferencesViewModel = homePreferencesViewModel2;
                if (homePreferencesConfig.isPopStyle() && !Intrinsics.c(homePreferencesConfig.getRefreshType(), HomePreferencesRefreshType.NO_REFRESH.getValue())) {
                    homePreferencesViewModel.x().n(homePreferencesConfig);
                }
                obj2 = Result.constructor-impl(Unit.a);
                String str2 = this.$labelId;
                String str3 = this.$scene;
                th2 = Result.exceptionOrNull-impl(obj2);
                if (th2 != null) {
                    a.a.l(wf.a.a, "HomePreferencesViewModel", "submitPreferences error, labelId=" + str2 + ", scene=" + str3 + ", msg=" + th2.getMessage(), false, 4, (Object) null);
                }
                return Unit.a;
            }
            z = this.Z$0;
            homePreferencesConfig = (HomePreferencesConfig) this.L$1;
            HomePreferencesViewModel homePreferencesViewModel3 = (HomePreferencesViewModel) this.L$0;
            ResultKt.b(obj);
            homePreferencesViewModel = homePreferencesViewModel3;
        }
        if (!z) {
            y2 = homePreferencesViewModel.y();
            this.L$0 = homePreferencesViewModel;
            this.L$1 = homePreferencesConfig;
            this.label = 2;
            if (y2.g(homePreferencesConfig, this) == f) {
                return f;
            }
            homePreferencesViewModel2 = homePreferencesViewModel;
            homePreferencesConfig2 = homePreferencesConfig;
            homePreferencesConfig = homePreferencesConfig2;
            homePreferencesViewModel = homePreferencesViewModel2;
        }
        if (homePreferencesConfig.isPopStyle()) {
            homePreferencesViewModel.x().n(homePreferencesConfig);
        }
        obj2 = Result.constructor-impl(Unit.a);
        String str22 = this.$labelId;
        String str32 = this.$scene;
        th2 = Result.exceptionOrNull-impl(obj2);
        if (th2 != null) {
        }
        return Unit.a;
    }
}
