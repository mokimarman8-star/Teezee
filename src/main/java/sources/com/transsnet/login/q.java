package com.transsnet.login;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.Utils;
import com.therouter.TheRouter;
import com.transsnet.loginapi.bean.Country;
import com.transsnet.loginapi.bean.UserInfo;
import io.reactivex.rxjava3.core.j;
import ix.d;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kg.c;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import nx.a;
import okhttp3.Response;
import org.mvel2.ast.ASTNode;
import qx.a;
import qx.b;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class q implements a {
    public static final a f = new a((DefaultConstructorMarker) null);
    private static final Lazy g = LazyKt.b(new Function0() { // from class: com.transsnet.login.o
        public final Object invoke() {
            a E;
            E = q.E();
            return E;
        }
    });
    private Context a;
    private volatile UserInfo b;
    private List c = new CopyOnWriteArrayList();
    private final Lazy d = LazyKt.b(new Function0() { // from class: com.transsnet.login.l
        public final Object invoke() {
            nx.a D;
            D = q.D();
            return D;
        }
    });
    private final String e = "X-User";

    private final WeakReference B(b bVar) {
        for (WeakReference weakReference : this.c) {
            b bVar2 = (b) weakReference.get();
            if (bVar2 != null && bVar2 == bVar) {
                return weakReference;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final nx.a C() {
        return (nx.a) this.d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final nx.a D() {
        return (nx.a) c.e.a().h(nx.a.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a E() {
        return (a) TheRouter.d(a.class, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G() {
        this.b = null;
        d.a.b().putString("login_user", "");
        mg.a.a.h("");
        ThreadUtils.j(new n(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(q qVar) {
        Iterator it = qVar.c.iterator();
        while (it.hasNext()) {
            b bVar = (b) ((WeakReference) it.next()).get();
            if (bVar != null) {
                bVar.onLogout();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(UserInfo userInfo) {
        c(userInfo);
        ThreadUtils.j(new m(this, userInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(q qVar, UserInfo userInfo) {
        Iterator it = qVar.c.iterator();
        while (it.hasNext()) {
            b bVar = (b) ((WeakReference) it.next()).get();
            if (bVar != null) {
                bVar.onLogin(userInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L(UserInfo userInfo) {
        this.b = userInfo;
        ThreadUtils.j(new p(this, userInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(q qVar, UserInfo userInfo) {
        Iterator it = qVar.c.iterator();
        while (it.hasNext()) {
            b bVar = (b) ((WeakReference) it.next()).get();
            if (bVar != null) {
                bVar.onUpdateUserInfo(userInfo);
            }
        }
    }

    public final void F() {
        j.t("").u(e.a).n(new f(this)).f(dg.d.a.c()).subscribe(new g(this));
    }

    public void K() {
        G();
    }

    @Override // qx.a
    public boolean a() {
        UserInfo userInfo;
        return (this.b == null || (userInfo = this.b) == null || userInfo.getUserType() != 1) ? false : true;
    }

    @Override // qx.a
    public String b() {
        String string = Utils.a().getString(R.string.login_success);
        Intrinsics.g(string, "getString(...)");
        return string;
    }

    @Override // qx.a
    public synchronized void c(UserInfo userInfo) {
        String userId;
        try {
            this.b = userInfo;
            a.a.e(wf.a.a, "login", "saveUserInfo " + (userInfo != null ? userInfo.getUserId() : null), new Throwable("info"), false, 8, (Object) null);
            if (userInfo != null && (userId = userInfo.getUserId()) != null) {
                mg.a.a.h(userId);
            }
            d.a.b().putString("login_user", com.blankj.utilcode.util.o.j(userInfo));
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // qx.a
    public void d() {
        if (yg.l.a.e()) {
            F();
        } else {
            G();
        }
    }

    @Override // qx.a
    public void e(b bVar) {
        Intrinsics.h(bVar, "listener");
        if (B(bVar) == null) {
            this.c.add(new WeakReference(bVar));
        }
    }

    @Override // qx.a
    public Country f() {
        return lx.a.a.b();
    }

    @Override // qx.a
    public void g(String str) {
        nx.a C = C();
        if (str == null) {
            str = "";
        }
        a.a.c(C, str, (String) null, 2, (Object) null).v(ey.a.c()).u(new b(this)).h(new c(this)).f(dg.d.a.c()).subscribe(new d(this));
    }

    @Override // qx.a
    public void h(Response response) {
        Intrinsics.h(response, "response");
        try {
            if (response.code() != 200) {
                if (response.code() == 401) {
                    K();
                    return;
                }
                return;
            }
            String str = response.headers().get(this.e);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            UserInfo userInfo = (UserInfo) com.blankj.utilcode.util.o.d(str, UserInfo.class);
            if (this.b == null) {
                Intrinsics.e(userInfo);
                I(userInfo);
                return;
            }
            UserInfo userInfo2 = this.b;
            if (TextUtils.equals(userInfo2 != null ? userInfo2.getToken() : null, userInfo.getToken())) {
                return;
            }
            UserInfo userInfo3 = this.b;
            if (userInfo3 != null) {
                userInfo3.setToken(userInfo.getToken());
            }
            c(this.b);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // qx.a
    public UserInfo i() {
        return this.b;
    }

    @Override // qx.a
    public void j(b bVar) {
        Intrinsics.h(bVar, "listener");
        List list = this.c;
        TypeIntrinsics.a(list).remove(B(bVar));
    }

    @Override // qx.a
    public void k(Context context) {
        Intrinsics.h(context, "context");
        Intent intent = new Intent(context, (Class<?>) LoginLikeActivity.class);
        intent.setFlags(ASTNode.DEOP);
        context.startActivity(intent);
    }

    @Override // qx.a
    public void l(Context context) {
        String userId;
        Intrinsics.h(context, "context");
        this.a = context;
        String string = d.a.b().getString("login_user", "");
        String str = string != null ? string : "";
        Object obj = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                Result.Companion companion = Result.Companion;
                obj = com.blankj.utilcode.util.o.d(str, UserInfo.class);
                Result.m34constructorimpl(Unit.a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.m34constructorimpl(ResultKt.a(th));
            }
        }
        if (this.b == null) {
            UserInfo userInfo = (UserInfo) obj;
            this.b = userInfo;
            if (userInfo == null || (userId = userInfo.getUserId()) == null) {
                return;
            }
            mg.a.a.h(userId);
        }
    }

    @Override // qx.a
    public Object m(UserInfo userInfo, Continuation continuation) {
        I(userInfo);
        g(userInfo.getUserId());
        return Unit.a;
    }

    @Override // qx.a
    public void n(long j) {
        d.a.b().putLong("login_launch_first_state", j);
    }

    @Override // qx.a
    public long o() {
        return d.a.b().getLong("login_launch_first_state", 0L);
    }

    @Override // qx.a
    public Intent p(Context context) {
        Intrinsics.h(context, "context");
        return new Intent(context, (Class<?>) LoginLikeActivity.class);
    }
}
