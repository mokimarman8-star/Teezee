package ee;

import android.content.Context;
import android.util.SparseArray;
import com.hisavana.common.bean.AdSourceConfig;
import com.hisavana.common.interfacz.IBaseAdSummary;
import com.hisavana.common.interfacz.Iad;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.common.utils.AdUtil;
import com.hisavana.mediation.config.TAdManager;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class o {
    public static final int[] b = {0, 1, 2, 3, 4, 5, 12, 8, 11, 6, 9, 14, 15, 16, 17};
    public static final SparseArray c;
    public final SparseArray a = new SparseArray();

    public static class a {
        public static final o a = new o();
    }

    static {
        SparseArray sparseArray = new SparseArray();
        c = sparseArray;
        sparseArray.put(0, "com.hisavana.adxlibrary.check.ExistsCheck");
        sparseArray.put(1, "com.hisavana.admoblibrary.check.ExistsCheck");
        sparseArray.put(2, "com.hisavana.fblibrary.excuter.check.ExistsCheck");
        sparseArray.put(3, "com.hisavana.applovin.check.ExistsCheck");
        sparseArray.put(4, "com.hisavana.unity.check.ExistsCheck");
        sparseArray.put(5, "com.hisavana.ironsource.check.ExistsCheck");
        sparseArray.put(8, "com.hisavana.inmobi.check.ExistsCheck");
        sparseArray.put(12, "com.hisavana.vungle.check.ExistsCheck");
        sparseArray.put(11, "com.hisavana.adcolony.check.ExistsCheck");
        sparseArray.put(9, "com.hisavana.mintegral.check.ExistsCheck");
        sparseArray.put(14, "com.hisavana.max.check.ExistsCheck");
        sparseArray.put(15, "com.hisavana.yandex.check.ExistsCheck");
        sparseArray.put(16, "com.hisavana.bigo.check.ExistsCheck");
        sparseArray.put(6, "com.hisavana.pangle.check.ExistsCheck");
        sparseArray.put(17, "com.hisavana.topon.check.ExistsCheck");
    }

    public static o a() {
        return a.a;
    }

    public static boolean e(Iad iad) {
        if (iad == null) {
            return false;
        }
        return AdUtil.isBiddingNetwork(iad.getNetwork());
    }

    public final String b(int i) {
        return (String) c.get(i);
    }

    public final void c(Context context, int i, TAdManager.AdConfig adConfig) {
        boolean z;
        IBaseAdSummary iBaseAdSummary;
        String b2 = b(i);
        IBaseAdSummary iBaseAdSummary2 = null;
        try {
            iBaseAdSummary = (IBaseAdSummary) Class.forName(b2).newInstance();
            z = true;
        } catch (Throwable unused) {
            z = false;
            iBaseAdSummary = null;
        }
        AdLogUtil.Log().d("sdk_init", "platform classname = " + b2 + " exist = " + z);
        if (z) {
            try {
                AdSourceConfig adSourceConfig = new AdSourceConfig();
                adSourceConfig.isDebug = adConfig.isDebug();
                adSourceConfig.pkgEvn = adConfig.getPkgEvn();
                adSourceConfig.appId = adConfig.getAppId();
                adSourceConfig.testDevice = adConfig.isTestDevice();
                adSourceConfig.isLite = adConfig.isLite();
                adSourceConfig.vidAppId = adConfig.getAppId();
                adSourceConfig.appIconId = adConfig.getAppIconId();
                adSourceConfig.isInitAdMob = adConfig.isInitAdmob();
                adSourceConfig.isInitAlliance = adConfig.isInitAlliance();
                adSourceConfig.defaultVersion = adConfig.getDefaultVersion();
                adSourceConfig.defaultMaterialMaxSize = adConfig.getDefaultMaterialMaxSize();
                adSourceConfig.shouldOptimizeImageLoading = adConfig.getShouldOptimizeImageLoading();
                adSourceConfig.isEnableRewardedToast = adConfig.checkEnableRewardedToast();
                adSourceConfig.isEnableWebRecommendFeature = adConfig.checkEnableWebRecommendFeature();
                adSourceConfig.pangleAppId = adConfig.getPangleAppId();
                adSourceConfig.isClosePangleWebFileLock = adConfig.isClosePangleWebFileLock();
                iBaseAdSummary.init(context, adSourceConfig);
                iBaseAdSummary2 = iBaseAdSummary;
            } catch (Throwable th) {
                AdLogUtil.Log().e("sdk_init", "ad source init error source:" + i + " error:" + th.getMessage());
            }
            if (iBaseAdSummary2 != null) {
                this.a.put(i, iBaseAdSummary2);
            }
        }
    }

    public void d(Context context, TAdManager.AdConfig adConfig) {
        for (int i : b) {
            c(context, i, adConfig);
        }
    }

    public IBaseAdSummary f(int i) {
        return (IBaseAdSummary) this.a.get(i);
    }
}
