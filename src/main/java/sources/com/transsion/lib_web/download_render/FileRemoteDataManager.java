package com.transsion.lib_web.download_render;

import com.blankj.utilcode.util.o;
import com.tencent.mmkv.MMKV;
import com.transsion.gslb.NetResponse;
import com.transsion.lib_web.download_render.data.config.ConfigData;
import com.transsion.lib_web.download_render.timer.SyncDataTimerTask;
import com.transsion.mb.config.manager.ConfigBean;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.m1;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import pl.h;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class FileRemoteDataManager {
    public static final FileRemoteDataManager a = new FileRemoteDataManager();
    private static final AtomicBoolean b = new AtomicBoolean(false);
    private static final xl.b c = new xl.b();
    private static final SyncDataTimerTask d = new SyncDataTimerTask();
    private static final n0 e;
    private static final Lazy f;
    private static final Lazy g;
    private static final String h;
    private static String i;

    static {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.g(newSingleThreadExecutor, "newSingleThreadExecutor(...)");
        e = o0.a(m1.c(newSingleThreadExecutor));
        f = LazyKt.b(new Function0() { // from class: com.transsion.lib_web.download_render.e
            public final Object invoke() {
                g f2;
                f2 = FileRemoteDataManager.f();
                return f2;
            }
        });
        g = LazyKt.b(new Function0() { // from class: com.transsion.lib_web.download_render.f
            public final Object invoke() {
                MMKV j;
                j = FileRemoteDataManager.j();
                return j;
            }
        });
        h = "requestTime";
        i = "wefeed-mobile-bff";
    }

    private FileRemoteDataManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final g f() {
        return (g) kg.c.e.a().h(g.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final g g() {
        return (g) f.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MMKV h() {
        Object value = g.getValue();
        Intrinsics.g(value, "getValue(...)");
        return (MMKV) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV j() {
        return MMKV.I("web_file_download_with_render_request");
    }

    public final String i() {
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0032, code lost:
    
        if (r8 == null) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void k() {
        String str;
        String value;
        try {
            long currentTimeMillis = System.currentTimeMillis() - h().getLong(h, 0L);
            long j = 3600000;
            try {
                ConfigBean d2 = cm.f.d(cm.f.c.a(), "dr_config", false, 2, (Object) null);
                if (d2 != null && (value = d2.getValue()) != null) {
                    str = StringsKt.q0(value) ? null : value;
                }
                str = NetResponse.EMPTY_RESPONSE;
                j = ((ConfigData) o.d(str, ConfigData.class)).getRequestMinInterval();
                h.a.a("DR_Config", "config:" + str + ", intervalTime:" + j);
            } catch (Throwable unused) {
            }
            if (currentTimeMillis > j) {
                m();
            }
        } catch (Throwable unused2) {
        }
    }

    public final void l(String str) {
        Intrinsics.h(str, "<set-?>");
        i = str;
    }

    public final void m() {
        i.d(e, (CoroutineContext) null, (CoroutineStart) null, new FileRemoteDataManager$syncData$1(null), 3, (Object) null);
    }
}
