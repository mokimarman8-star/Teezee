package com.transsion.push.tpush;

import android.app.Application;
import android.net.Network;
import android.net.NetworkCapabilities;
import androidx.core.app.t;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.o;
import com.therouter.TheRouter;
import com.tn.lib.net.dns.or.CacheIpPool;
import com.transsion.baselib.db.notification.MsgBean;
import com.transsion.push.bean.MsgType;
import com.transsion.push.helper.e;
import com.transsion.push.tpush.PushRegisterManager;
import com.transsion.push.utils.NotificationUtil;
import com.transsnet.loginapi.bean.UserInfo;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.CancellationException;
import kg.c;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.y0;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONObject;
import qx.b;
import uo.a;
import wf.a;
import wg.a;
import yg.m;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class PushRegisterManager implements yg.m, b {
    public static final PushRegisterManager a = new PushRegisterManager();
    private static final Lazy b = LazyKt.b(new Function0() { // from class: com.transsion.push.tpush.j
        public final Object invoke() {
            h F;
            F = PushRegisterManager.F();
            return F;
        }
    });
    private static final Lazy c = LazyKt.b(new Function0() { // from class: com.transsion.push.tpush.k
        public final Object invoke() {
            a E;
            E = PushRegisterManager.E();
            return E;
        }
    });
    private static final Lazy d = LazyKt.b(new Function0() { // from class: com.transsion.push.tpush.l
        public final Object invoke() {
            qx.a D;
            D = PushRegisterManager.D();
            return D;
        }
    });
    private static final Lazy e = LazyKt.b(new Function0() { // from class: com.transsion.push.tpush.m
        public final Object invoke() {
            PushRegisterManager.a G;
            G = PushRegisterManager.G();
            return G;
        }
    });
    private static t1 f;
    private static volatile boolean g;

    private PushRegisterManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RequestBody A(String str) {
        return RequestBody.Companion.create(str, MediaType.Companion.parse("application/json"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v11, types: [T, java.lang.String] */
    public final void B(long j, String str) {
        a.a aVar = wf.a.a;
        a.a.f(aVar, "PushRegisterManager", "onMessageReceive msgId " + j + " transData=" + str, false, 4, (Object) null);
        if (str != null) {
            try {
                if (StringsKt.c0(str, "clientLogsRetrieve", false, 2, (Object) null)) {
                    i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new handleTransData.1.1(str, (Continuation) null), 3, (Object) null);
                } else if (StringsKt.c0(str, "configRefreshPush", false, 2, (Object) null)) {
                    i iVar = (i) TheRouter.d(i.class, new Object[0]);
                    if (iVar != null) {
                        iVar.a();
                    }
                } else {
                    MsgBean msgBean = (MsgBean) o.d(str, MsgBean.class);
                    if (msgBean != null) {
                        com.transsion.push.helper.a.a.h(String.valueOf(j), String.valueOf(msgBean.getDeeplink()), "2");
                        msgBean.setMessageId(String.valueOf(j));
                        msgBean.setType(MsgType.ONLINE_JSON_PUSH.getType());
                        msgBean.setSource("fcm_push");
                        a.a.f(aVar, "PushRegisterManager", "msg.message: " + msgBean, false, 4, (Object) null);
                        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                        NotificationUtil notificationUtil = NotificationUtil.a;
                        ref$ObjectRef.element = notificationUtil.T(String.valueOf(msgBean.getDeeplink()), "id");
                        String T = notificationUtil.T(String.valueOf(msgBean.getDeeplink()), "msg_type");
                        a.a.f(aVar, "PushRegisterManager", "msg_type: " + T, false, 4, (Object) null);
                        if (StringsKt.I(T, "SportsLiveEventRemind", false, 2, (Object) null)) {
                            a.a.f(aVar, "PushRegisterManager", "接收到SportsLiveEventRemind的通知", false, 4, (Object) null);
                            i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new handleTransData.1.2.1(ref$ObjectRef, msgBean, (Continuation) null), 3, (Object) null);
                        } else {
                            e eVar = e.a;
                            Application a2 = Utils.a();
                            Intrinsics.g(a2, "getApp(...)");
                            eVar.i(a2, msgBean);
                        }
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qx.a D() {
        return (qx.a) TheRouter.d(qx.a.class, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final uo.a E() {
        return (uo.a) c.e.a().h(uo.a.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final h F() {
        return (h) c.e.a().h(h.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a G() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H() {
        boolean c2 = Intrinsics.c(CacheIpPool.a.l(), "test-mse-api.aoneroom.com");
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.a;
        String string = bVar.b().getString("push_topic_country", "");
        String string2 = bVar.b().getString("push_topic_zone", "");
        String string3 = bVar.b().getString("push_topic_language", "");
        String string4 = bVar.b().getString("push_topic_app", "");
        String str = "topic_country_" + Locale.getDefault().getCountry() + (c2 ? "_test" : "");
        String id = TimeZone.getDefault().getID();
        Intrinsics.g(id, "getID(...)");
        String str2 = "topic_zone_" + StringsKt.P(id, '/', '_', false, 4, (Object) null) + (c2 ? "_test" : "");
        String str3 = "topic_language_" + Locale.getDefault().getLanguage() + (c2 ? "_test" : "");
        String str4 = "topic_appid_" + Utils.a().getPackageName() + (c2 ? "_test" : "");
        if (!Intrinsics.c(string, str)) {
            if (string != null && string.length() != 0) {
                e.a.r(string);
            }
            e.a.m(str, new p(str));
        }
        if (!Intrinsics.c(string2, str2)) {
            if (string2 != null && string2.length() != 0) {
                e.a.r(string2);
            }
            e.a.m(str2, new q(str2));
        }
        if (!Intrinsics.c(string3, str3)) {
            if (string3 != null && string3.length() != 0) {
                e.a.r(string3);
            }
            e.a.m(str3, new r(str3));
        }
        if (Intrinsics.c(string4, str4)) {
            return;
        }
        if (string4 != null && string4.length() != 0) {
            e.a.r(string4);
        }
        e.a.m(str4, new s(str4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(String str, boolean z) {
        if (z) {
            com.transsion.baselib.report.launch.b.a.b().putString("push_topic_country", str);
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(String str, boolean z) {
        if (z) {
            com.transsion.baselib.report.launch.b.a.b().putString("push_topic_zone", str);
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K(String str, boolean z) {
        if (z) {
            com.transsion.baselib.report.launch.b.a.b().putString("push_topic_language", str);
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(String str, boolean z) {
        if (z) {
            com.transsion.baselib.report.launch.b.a.b().putString("push_topic_app", str);
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M() {
        if (g) {
            return;
        }
        g = true;
        N();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(JSONObject jSONObject, String str) {
        Intrinsics.h(str, "regHash");
        t1 t1Var = f;
        if (t1Var != null) {
            t1.a.b(t1Var, (CancellationException) null, 1, (Object) null);
        }
        f = i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new sendToServer.1.1(jSONObject, str, (Continuation) null), 3, (Object) null);
        return Unit.a;
    }

    private final boolean s() {
        try {
            return t.b(Utils.a()).a();
        } catch (Exception unused) {
            return true;
        }
    }

    private final void t(Function1 function1) {
        String str;
        UserInfo i;
        String id = TimeZone.getDefault().getID();
        qx.a w = w();
        if (w == null || (i = w.i()) == null || (str = i.getUserId()) == null) {
            str = "";
        }
        int f2 = com.blankj.utilcode.util.c.f();
        String country = Locale.getDefault().getCountry();
        String language = Locale.getDefault().getLanguage();
        String n = tg.b.a.n();
        a.a aVar = wg.a.a;
        e eVar = e.a;
        String a2 = aVar.a(str + "|" + id + "|" + f2 + "|" + country + "|" + language + "|" + n + "|" + eVar.j() + "|" + eVar.g());
        if (Intrinsics.c(a2, com.transsion.baselib.report.launch.b.a.b().getString("push_ru", ""))) {
            return;
        }
        function1.invoke(a2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(String str) {
        Intrinsics.h(str, "it");
        a.N();
        return Unit.a;
    }

    private final qx.a w() {
        return (qx.a) d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final uo.a x() {
        return (uo.a) c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final h y() {
        return (h) b.getValue();
    }

    private final a z() {
        return (a) e.getValue();
    }

    public final void C(Application application) {
        Intrinsics.h(application, "context");
        yg.l.a.l(this);
        e eVar = e.a;
        eVar.k(application);
        eVar.l(z());
        qx.a w = w();
        if (w != null) {
            w.e(this);
        }
    }

    public final void N() {
        e eVar = e.a;
        if (eVar.j().length() == 0 || eVar.g().length() == 0) {
            return;
        }
        boolean s = s();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("firebaseToken", eVar.j());
        jSONObject.put("twibidaClientId", eVar.g());
        jSONObject.put("notifySwitchOff", !s);
        a.a.f(wf.a.a, "PushRegisterManager", "onSuccess, firebaseToken:" + eVar.j() + " twibidaClientId " + eVar.g(), false, 4, (Object) null);
        t(new o(jSONObject));
    }

    public void onConnected() {
        m.a.a(this);
    }

    public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics.h(network, "network");
        Intrinsics.h(networkCapabilities, "networkCapabilities");
        u();
    }

    public void onDisconnected() {
    }

    public void onLogin(UserInfo userInfo) {
        Intrinsics.h(userInfo, "user");
        b.a.a(this, userInfo);
        a.a.f(wf.a.a, "PushRegisterManager", "onLogin, " + userInfo.getUserId(), false, 4, (Object) null);
        u();
    }

    public void onLogout() {
        b.a.b(this);
    }

    public void onUpdateUserInfo(UserInfo userInfo) {
        b.a.c(this, userInfo);
    }

    public final void u() {
        t(new n());
    }
}
