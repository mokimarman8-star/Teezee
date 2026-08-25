package bm;

import cm.f;
import com.google.gson.JsonArray;
import com.transsion.mb.config.download.AppStartConfig;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e$c extends dg.a {
    e$c() {
    }

    public void a(String str, String str2) {
        a.a.f(wf.a.a, "RequestConfig", "onFailure code: " + str + "  message: " + str2, false, 4, (Object) null);
        e.f(false);
        b d = e.d();
        if (d != null) {
            d.a();
        }
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void c(AppStartConfig appStartConfig) {
        Object obj;
        Unit unit;
        super.c(appStartConfig);
        e.g(true);
        e.f(false);
        if (appStartConfig == null) {
            return;
        }
        a.a.f(wf.a.a, "RequestConfig", "onSuccess:" + appStartConfig, false, 4, (Object) null);
        try {
            Result.Companion companion = Result.Companion;
            JsonArray items = appStartConfig.getItems();
            if (items != null) {
                f.c.a().j(items);
            }
            String version = appStartConfig.getVersion();
            if (version != null) {
                cm.d.a.g().putString("configVersion", version);
            }
            b d = e.d();
            if (d != null) {
                d.b();
                unit = Unit.a;
            } else {
                unit = null;
            }
            obj = Result.constructor-impl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        Throwable th3 = Result.exceptionOrNull-impl(obj);
        if (th3 == null) {
            return;
        }
        a.a.f(wf.a.a, "RequestConfig", "fail --> it = " + th3.getMessage(), false, 4, (Object) null);
    }
}
