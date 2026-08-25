package com.cloud.tmc.miniapp.performanceanalyse;

import android.os.Bundle;
import com.cloud.tmc.kernel.model.BaseBean;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.LogEProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.miniapp.NewTaskManager;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class LogEReportManager implements LogEProxy {
    public static final OooO00o Companion = new OooO00o();
    public Map<String, GrayBean> OooO00o = new LinkedHashMap();
    public float OooO0O0;

    public static final class GrayBean extends BaseBean {
        private final float localGrayScal;
        private final float remoteGrayScale;

        public GrayBean(float f, float f2) {
            this.localGrayScal = f;
            this.remoteGrayScale = f2;
        }

        public static /* synthetic */ GrayBean copy$default(GrayBean grayBean, float f, float f2, int i, Object obj) {
            if ((i & 1) != 0) {
                f = grayBean.localGrayScal;
            }
            if ((i & 2) != 0) {
                f2 = grayBean.remoteGrayScale;
            }
            return grayBean.copy(f, f2);
        }

        public final float component1() {
            return this.localGrayScal;
        }

        public final float component2() {
            return this.remoteGrayScale;
        }

        public final GrayBean copy(float f, float f2) {
            return new GrayBean(f, f2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof GrayBean)) {
                return false;
            }
            GrayBean grayBean = (GrayBean) obj;
            return Float.compare(this.localGrayScal, grayBean.localGrayScal) == 0 && Float.compare(this.remoteGrayScale, grayBean.remoteGrayScale) == 0;
        }

        public final float getLocalGrayScal() {
            return this.localGrayScal;
        }

        public final float getRemoteGrayScale() {
            return this.remoteGrayScale;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.remoteGrayScale) + (Float.floatToIntBits(this.localGrayScal) * 31);
        }

        public String toString() {
            return "GrayBean(localGrayScal=" + this.localGrayScal + ", remoteGrayScale=" + this.remoteGrayScale + ")";
        }
    }

    public static final class OooO00o {
    }

    @Override // com.cloud.tmc.kernel.proxy.performanceanalyse.LogEProxy
    public void destroy(String str) {
        if (str != null) {
            try {
                this.OooO00o.remove(str);
                List<String> existAppIds = NewTaskManager.Companion.getInstance().getExistAppIds();
                Iterator<Map.Entry<String, GrayBean>> it = this.OooO00o.entrySet().iterator();
                while (it.hasNext()) {
                    if (!existAppIds.contains(it.next().getKey())) {
                        it.remove();
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.performanceanalyse.LogEProxy
    public void e(String str, String str2) {
        GrayBean grayBean;
        try {
            String foregroundAppId = NewTaskManager.Companion.getInstance().getForegroundAppId();
            if (foregroundAppId == null || (grayBean = this.OooO00o.get(foregroundAppId)) == null || grayBean.getRemoteGrayScale() == 0.0f || grayBean.getLocalGrayScal() > grayBean.getRemoteGrayScale()) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("tag", str);
            bundle.putString("msg", str2);
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record("", PointAnalyseType.POINT_LOG_ERROR, "", bundle);
        } catch (Throwable unused) {
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.performanceanalyse.LogEProxy
    public void init(String str) {
        if (str != null) {
            try {
                this.OooO00o.put(str, new GrayBean(new SecureRandom().nextFloat(), this.OooO0O0));
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.performanceanalyse.LogEProxy
    public void saveConfig(float f) {
        this.OooO0O0 = f;
    }
}
