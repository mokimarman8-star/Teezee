package com.transsion.push.tpush;

import android.app.Application;
import android.content.Context;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.transsion.gslb.BuildConfig;
import com.transsion.lib.push.R$drawable;
import com.transsion.push.PushManager;
import com.transsion.push.TPushListener;
import com.transsion.push.bean.PushMessage;
import com.transsion.push.bean.PushNotification;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e {
    private static f b;
    public static final e a = new e();
    private static volatile String c = BuildConfig.FLAVOR;
    private static volatile String d = BuildConfig.FLAVOR;
    private static final Lazy e = LazyKt.b(new Function0() { // from class: com.transsion.push.tpush.a
        public final Object invoke() {
            OnCompleteListener e2;
            e2 = e.e();
            return e2;
        }
    });

    public static final class a implements TPushListener {
        a() {
        }

        public void onClickException(long j, String str) {
            wf.a.a.c("FCM_PUSH", "onClickException msgId " + j + " reason " + str, true);
        }

        public void onMessageReceive(long j, String str, int i) {
            f i2 = e.a.i();
            if (i2 != null) {
                i2.b(j, str);
            }
        }

        public void onNotificationShow(long j, String str) {
            a.a.f(wf.a.a, "FCM_PUSH", "onNotificationShow msgId " + j + " landingPage " + str, false, 4, (Object) null);
        }

        public void onPushReceive(long j, PushMessage pushMessage, int i) {
        }

        public void onSdkInitSuccess(String str, String str2) {
            a.a.f(wf.a.a, "FCM_PUSH", "onSdkInitSuccess clientId " + str + "  token " + str2, false, 4, (Object) null);
            e eVar = e.a;
            String str3 = BuildConfig.FLAVOR;
            eVar.o(str == null ? BuildConfig.FLAVOR : str);
            if (str2 != null) {
                str3 = str2;
            }
            eVar.p(str3);
            f i = eVar.i();
            if (i != null) {
                i.onSdkInitSuccess(str, str2);
            }
        }
    }

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OnCompleteListener e() {
        return new OnCompleteListener() { // from class: com.transsion.push.tpush.b
            public final void onComplete(Task task) {
                e.f(task);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Task task) {
        Intrinsics.h(task, "task");
        if (!task.isSuccessful()) {
            a.a.f(wf.a.a, "FCM_PUSH", "firebase token getFailed " + task.getException(), false, 4, (Object) null);
            return;
        }
        String str = (String) task.getResult();
        d = str == null ? BuildConfig.FLAVOR : str;
        a.a.f(wf.a.a, "FCM_PUSH", "firebase token " + str, false, 4, (Object) null);
        f fVar = b;
        if (fVar != null) {
            Intrinsics.e(str);
            fVar.a(str);
        }
    }

    private final OnCompleteListener h() {
        return (OnCompleteListener) e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(String str, Function1 function1, Task task) {
        Intrinsics.h(task, "task");
        a.a.f(wf.a.a, "FCM_PUSH", "registerTopic " + str + " isSuccessful:" + task.isSuccessful(), false, 4, (Object) null);
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(task.isSuccessful()));
        }
    }

    private final void q(Context context) {
        PushManager.getInstance().addCustomNotification(new PushNotification.Builder().setSmallIcon(R$drawable.push_small_logo).setType(1).setShowDefaultLargeIcon(false).build());
        FirebaseMessaging.p().s().addOnCompleteListener(h());
        PushManager.getInstance().init(context);
        PushManager.getInstance().registerPushListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(String str, Task task) {
        Intrinsics.h(task, "task");
        a.a.f(wf.a.a, "FCM_PUSH", "unregisterTopic " + str + " isSuccessful:" + task.isSuccessful(), false, 4, (Object) null);
    }

    public final String g() {
        return c;
    }

    public final f i() {
        return b;
    }

    public final String j() {
        return d;
    }

    public final void k(Application application) {
        Object obj;
        Intrinsics.h(application, "context");
        try {
            Result.Companion companion = Result.Companion;
            a.q(application);
            obj = Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        Throwable th3 = Result.exceptionOrNull-impl(obj);
        if (th3 != null) {
            a.a.f(wf.a.a, "FCM_PUSH", "firebase onFailure error " + th3.getMessage(), false, 4, (Object) null);
        }
    }

    public final void l(f fVar) {
        Intrinsics.h(fVar, "listener");
        b = fVar;
    }

    public final void m(final String str, final Function1 function1) {
        Intrinsics.h(str, "topic");
        FirebaseMessaging.p().O(str).addOnCompleteListener(new OnCompleteListener() { // from class: com.transsion.push.tpush.d
            public final void onComplete(Task task) {
                e.n(str, function1, task);
            }
        });
    }

    public final void o(String str) {
        Intrinsics.h(str, "<set-?>");
        c = str;
    }

    public final void p(String str) {
        Intrinsics.h(str, "<set-?>");
        d = str;
    }

    public final void r(final String str) {
        Intrinsics.h(str, "topic");
        FirebaseMessaging.p().R(str).addOnCompleteListener(new OnCompleteListener() { // from class: com.transsion.push.tpush.c
            public final void onComplete(Task task) {
                e.s(str, task);
            }
        });
    }
}
