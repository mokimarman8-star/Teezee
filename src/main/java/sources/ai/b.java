package ai;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.transsion.ad.MBAd;
import com.transsion.ad.strategy.AppManager;
import com.transsion.ga.AthenaAnalytics;
import com.transsion.gslb.BuildConfig;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import qi.h;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b {
    public static final b a = new b();
    private static final AtomicBoolean b = new AtomicBoolean(false);

    private b() {
    }

    public final void a(String str, Map map, String str2) {
        Intrinsics.h(str, "event");
        Intrinsics.h(map, "map");
        if (!a.a.a()) {
            xh.a.e(xh.a.a, "Report_ad", "AdReportManager --> onReport() --> 业务线关闭埋点上报，不上报", 0, false, 4, null);
            return;
        }
        if (com.transsion.ad.scene.b.a.h()) {
            xh.a.e(xh.a.a, "Report_ad", "AdReportManager --> onReport() --> 广告数据上报链路已关闭，不上报", 0, false, 4, null);
            return;
        }
        AtomicBoolean atomicBoolean = b;
        if (!atomicBoolean.get()) {
            Application a2 = Utils.a();
            MBAd.a b2 = MBAd.a.b();
            AthenaAnalytics.Q(a2, "mb_ad", 6525, b2 != null ? b2.k() : false, false);
            atomicBoolean.set(true);
            xh.a.c(xh.a.a, "AdReportManager --> onReport() --> 广告埋点Athena初始化完成", 0, false, 6, null);
        }
        map.put("ad_vn", "4.0.3");
        map.put("biz_pkg", com.blankj.utilcode.util.c.e());
        map.put("biz_vc", Integer.valueOf(com.blankj.utilcode.util.c.f()));
        map.put("biz_vn", com.blankj.utilcode.util.c.h());
        h hVar = h.a;
        if (str2 == null) {
            str2 = BuildConfig.FLAVOR;
        }
        hVar.t(str, map, str2, 6525, AppManager.a.a());
    }
}
