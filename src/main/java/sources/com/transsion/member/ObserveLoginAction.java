package com.transsion.member;

import com.therouter.TheRouter;
import com.transsnet.loginapi.bean.UserInfo;
import im.f;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import qx.a;
import qx.b;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class ObserveLoginAction implements b {
    public static final a c = new a((DefaultConstructorMarker) null);
    public static final int d = 8;
    private static final ObserveLoginAction e = new ObserveLoginAction();
    private final Lazy a = LazyKt.b(new Function0() { // from class: com.transsion.member.g0
        public final Object invoke() {
            a k;
            k = ObserveLoginAction.k();
            return k;
        }
    });
    private final CopyOnWriteArrayList b = new CopyOnWriteArrayList();

    private ObserveLoginAction() {
    }

    private final void f() {
        a.a.c(g() + " --> addLoginListener() --> 设置用户登录状态监听");
        a h = h();
        if (h != null) {
            h.e(this);
        }
    }

    private final String g() {
        String simpleName = ObserveLoginAction.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    private final a h() {
        return (a) this.a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a k() {
        return (a) TheRouter.d(a.class, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(ObserveLoginAction observeLoginAction) {
        observeLoginAction.m();
        return Unit.a;
    }

    private final void m() {
        a.a.a(g() + " --> onLogin() --> 监听到用户登录行为 --> 获取会员权益 --> refresh() --> 刷新UI");
        i.d(o0.a(y0.c()), (CoroutineContext) null, (CoroutineStart) null, new refresh.1(this, (Continuation) null), 3, (Object) null);
    }

    public final void e(f fVar) {
        Intrinsics.h(fVar, "listener");
        this.b.add(fVar);
    }

    public final void i() {
        i.d(o0.a(y0.c()), (CoroutineContext) null, (CoroutineStart) null, new getMemberSuccess.1(this, (Continuation) null), 3, (Object) null);
    }

    public final void j() {
        e.f();
    }

    public final void n(f fVar) {
        Intrinsics.h(fVar, "listener");
        this.b.remove(fVar);
    }

    public void onLogin(UserInfo userInfo) {
        Intrinsics.h(userInfo, "user");
        b.a.a(this, userInfo);
        a.a.a(g() + " --> onLogin() --> 监听到用户登录行为 --> 获取会员权益");
        im.b bVar = (im.b) TheRouter.d(im.b.class, new Object[0]);
        if (bVar != null) {
            bVar.A(new h0(this));
        }
    }

    public void onLogout() {
        b.a.b(this);
        a.a.a(g() + " --> onLogout() --> 监听到用户登出行为 --> 获取会员权益");
        w.a.b().putBoolean("kv_is_skip_ad", true);
    }

    public void onUpdateUserInfo(UserInfo userInfo) {
        b.a.c(this, userInfo);
    }
}
