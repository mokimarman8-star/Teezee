package com.transsion.usercenter.setting.labelsfeedback.sender;

import android.app.Application;
import android.os.Build;
import android.util.Log;
import androidx.coroutines.ExistingWorkPolicy;
import androidx.coroutines.WorkManager;
import androidx.lifecycle.LiveData;
import androidx.work.d;
import androidx.work.k;
import com.blankj.utilcode.util.o;
import com.cloud.tmc.integration.b;
import com.tencent.mmkv.MMKV;
import com.transsion.usercenter.setting.labelsfeedback.model.FbDataModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import yg.l;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class FBSender {
    public static final FBSender a = new FBSender();
    private static final Lazy b = LazyKt.b(new Function0() { // from class: com.transsion.usercenter.setting.labelsfeedback.sender.a
        public final Object invoke() {
            MMKV g;
            g = FBSender.g();
            return g;
        }
    });

    private FBSender() {
    }

    private final String d() {
        return f().k("key_failed_json");
    }

    private final MMKV f() {
        return (MMKV) b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV g() {
        MMKV I = MMKV.I("feedback_mmkv");
        Intrinsics.g(I, "mmkvWithID(...)");
        return I;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v4, types: [android.content.Context] */
    public final void j(String str, Application application) {
        k.a aVar = new k.a(FbSenderWorker.class);
        Pair[] pairArr = {TuplesKt.a("key_work_data", str)};
        d.a aVar2 = new d.a();
        Pair pair = pairArr[0];
        aVar2.b((String) pair.getFirst(), pair.getSecond());
        d a2 = aVar2.a();
        Intrinsics.g(a2, "dataBuilder.build()");
        aVar.l(a2);
        k b2 = aVar.b();
        Application application2 = application;
        if (Build.VERSION.SDK_INT >= 24) {
            application2 = b.a(application);
        }
        WorkManager f = WorkManager.f(application2);
        Intrinsics.g(f, "getInstance(...)");
        f.a("feedback work name", ExistingWorkPolicy.REPLACE, b2).a();
        LiveData g = f.g(b2.a());
        Intrinsics.g(g, "getWorkInfoByIdLiveData(...)");
        i.d(o0.a(y0.c()), (CoroutineContext) null, (CoroutineStart) null, new sendJson.1(g, new a(g, str), (Continuation) null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(String str) {
        if (str == null) {
            f().remove("key_failed_json");
        } else {
            f().v("key_failed_json", str);
        }
    }

    public final FbDataModel e() {
        String d = d();
        if (d == null) {
            return null;
        }
        try {
            return (FbDataModel) o.d(d, FbDataModel.class);
        } catch (Exception e) {
            String message = e.getMessage();
            if (message == null) {
                message = "unable to parse json";
            }
            Log.e("feedback", message);
            return null;
        }
    }

    public final void h(Application application) {
        String d;
        Intrinsics.h(application, "application");
        if (l.a.e() && (d = d()) != null) {
            a.j(d, application);
        }
    }

    public final void i(FbDataModel fbDataModel, Application application) {
        Intrinsics.h(fbDataModel, "model");
        Intrinsics.h(application, "application");
        i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new send.1(fbDataModel, application, (Continuation) null), 3, (Object) null);
    }
}
