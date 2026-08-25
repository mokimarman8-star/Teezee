package com.transsion.search.speech;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.speech.SpeechRecognizer;
import android.text.TextUtils;
import com.blankj.utilcode.util.Utils;
import com.transsion.gslb.BuildConfig;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c {
    public static final a c = new a(null);
    private Function0 a;
    private final Lazy b = LazyKt.b(new Function0() { // from class: com.transsion.search.speech.a
        public final Object invoke() {
            Handler h;
            h = c.h();
            return h;
        }
    });

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final String c() {
        String simpleName = c.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    private final Handler d() {
        return (Handler) this.b.getValue();
    }

    private final SpeechRecognizer f(Context context) {
        f.a.a(c() + " --> getSpeechRecognizerOneParameterStrategy() --> deviceModel = " + Build.MODEL + " --> 采用第一种策略");
        return SpeechRecognizer.createSpeechRecognizer(context);
    }

    private final SpeechRecognizer g(Context context) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            f fVar = f.a;
            String c2 = c();
            String str = Build.MODEL;
            fVar.a(c2 + " --> deviceModel = " + str + " --> 采用第二种策略");
            List<ResolveInfo> queryIntentServices = Utils.a().getPackageManager().queryIntentServices(new Intent("android.speech.RecognitionService"), 0);
            Intrinsics.g(queryIntentServices, "queryIntentServices(...)");
            ResolveInfo resolveInfo = queryIntentServices.get(0);
            fVar.a(c() + " --> getSpeechRecognizerTwoParameterStrategy() --> packageName = " + resolveInfo.serviceInfo.packageName + " --> name = info.serviceInfo.name --> info = " + resolveInfo + " --> deviceModel = " + str);
            ServiceInfo serviceInfo = resolveInfo.serviceInfo;
            obj = Result.constructor-impl(SpeechRecognizer.createSpeechRecognizer(context, new ComponentName(serviceInfo.packageName, serviceInfo.name)));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            obj = null;
        }
        return (SpeechRecognizer) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Handler h() {
        return new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(c cVar) {
        com.transsion.baselib.report.launch.b.a.b().putString("initialize_strategy", "initialize_two");
        f.a.a(cVar.c() + " --> startListening() --> 标记当前不支持第一种策略 --> 回调给场景重新加载对象");
        Function0 function0 = cVar.a;
        if (function0 != null) {
        }
        q.a.f();
    }

    public final SpeechRecognizer e(Context context) {
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.a;
        if (TextUtils.isEmpty(bVar.b().getString("initialize_one_affirm", BuildConfig.FLAVOR))) {
            if (TextUtils.equals("TECNO AC8", Build.MODEL)) {
                return g(context);
            }
            String string = bVar.b().getString("initialize_strategy", "initialize_one");
            if (!Intrinsics.c(string, "initialize_one") && Intrinsics.c(string, "initialize_two")) {
                return g(context);
            }
            return f(context);
        }
        f.a.a(c() + " --> getSpeechRecognizer() --> 确定了支持第一种策略，直接返回");
        return f(context);
    }

    public final void i() {
        d().removeCallbacksAndMessages(null);
        f.a.a(c() + " --> onReadyForSpeech() --> 当前策略起作用了");
        com.transsion.baselib.report.launch.b.a.b().putString("initialize_strategy_affirm", "initialize_one_affirm");
    }

    public final void j(Function0 function0) {
        Intrinsics.h(function0, "callback");
        this.a = function0;
    }

    public final void k() {
        if (TextUtils.equals(com.transsion.baselib.report.launch.b.a.b().getString("initialize_strategy", "initialize_one"), "initialize_two")) {
            f.a.a(c() + " --> startListening() --> 当前策略已经是第二种策略了");
            return;
        }
        d().removeCallbacksAndMessages(null);
        d().postDelayed(new Runnable() { // from class: com.transsion.search.speech.b
            @Override // java.lang.Runnable
            public final void run() {
                c.l(c.this);
            }
        }, 3000L);
        f.a.a(c() + " --> startListening() --> 开启倒计时");
    }
}
