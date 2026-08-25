package com.transsion.home.fragment.home;

import com.transsion.gslb.BuildConfig;
import com.transsion.mb.config.manager.ConfigBean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.u0;
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.home.fragment.home.HomeFragment$updateMenuButtonVisibility$1", f = "HomeFragment.kt", l = {410}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class HomeFragment$updateMenuButtonVisibility$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    int label;
    final /* synthetic */ HomeFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HomeFragment$updateMenuButtonVisibility$1(HomeFragment homeFragment, Continuation<? super HomeFragment$updateMenuButtonVisibility$1> continuation) {
        super(2, continuation);
        this.this$0 = homeFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeFragment$updateMenuButtonVisibility$1(this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0046  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0035 -> B:5:0x0038). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        int i;
        int i2;
        Object f = IntrinsicsKt.f();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.b(obj);
            i = 0;
            i2 = 3;
            if (i < i2) {
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i2 = this.I$1;
            i = this.I$0;
            ResultKt.b(obj);
            ConfigBean c = cm.f.c.a().c("home_tab_menu_show", true);
            String value = c == null ? c.getValue() : null;
            if (value == null && value.length() != 0) {
                this.this$0.r1(value);
                return Unit.a;
            }
            i++;
            a.a.f(wf.a.a, "HomeFragment", "Cloud config retry #" + i + ", value still null", false, 4, (Object) null);
            if (i < i2) {
                this.I$0 = i;
                this.I$1 = i2;
                this.label = 1;
                if (u0.a(3500L, this) == f) {
                    return f;
                }
                ConfigBean c2 = cm.f.c.a().c("home_tab_menu_show", true);
                if (c2 == null) {
                }
                if (value == null) {
                }
                i++;
                a.a.f(wf.a.a, "HomeFragment", "Cloud config retry #" + i + ", value still null", false, 4, (Object) null);
                if (i < i2) {
                    a.a.f(wf.a.a, "HomeFragment", "Cloud config max retries reached, using default (hidden)", false, 4, (Object) null);
                    return Unit.a;
                }
            }
        }
    }
}
