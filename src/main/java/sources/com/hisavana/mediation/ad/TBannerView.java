package com.hisavana.mediation.ad;

import android.content.Context;
import android.util.AttributeSet;
import com.hisavana.common.base.WrapTadView;
import com.hisavana.common.bean.TAdRequestBody;
import com.hisavana.common.utils.AdLogUtil;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class TBannerView extends WrapTadView {
    public TBannerAd a;

    public TBannerView(Context context) {
        this(context, null);
    }

    public TBannerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public TBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = null;
        this.a = new TBannerAd(context, this);
    }

    public void destroy() {
        TBannerAd tBannerAd = this.a;
        if (tBannerAd != null) {
            tBannerAd.destroy();
        }
    }

    public void enterScene(String str, int i) {
        TBannerAd tBannerAd = this.a;
        if (tBannerAd != null) {
            tBannerAd.enterScene(str, i);
        }
    }

    public double getTopPrice(int i) {
        TBannerAd tBannerAd = this.a;
        if (tBannerAd == null) {
            return 0.0d;
        }
        return tBannerAd.getTopPrice(i);
    }

    public void loadAd() {
        TBannerAd tBannerAd = this.a;
        if (tBannerAd != null) {
            tBannerAd.loadAd();
        }
    }

    public void pause() {
        TBannerAd tBannerAd = this.a;
        if (tBannerAd != null) {
            tBannerAd.pause();
        }
    }

    public void resume() {
        TBannerAd tBannerAd = this.a;
        if (tBannerAd != null) {
            tBannerAd.resume();
        }
    }

    public void setAdLoadScenes(String str, String str2, Map<String, Object> map) {
        TBannerAd tBannerAd = this.a;
        if (tBannerAd != null) {
            tBannerAd.setAdLoadScenes(str, str2, map);
        }
    }

    public void setAdSize(int i) {
        TBannerAd tBannerAd = this.a;
        if (tBannerAd != null) {
            tBannerAd.c(i);
        }
    }

    public void setAdUnitId(String str) {
        TBannerAd tBannerAd = this.a;
        if (tBannerAd != null) {
            tBannerAd.setAdUnitId(str);
        }
    }

    public void setBannerType(int i) {
        if (i >= 0 && i <= 2) {
            TBannerAd tBannerAd = this.a;
            if (tBannerAd != null) {
                tBannerAd.setBannerType(i);
                return;
            }
            return;
        }
        AdLogUtil.Log().d("TBannerView", "setBannerType --> invalid banner type " + i);
    }

    public void setCloseDirectlyWithoutJumping(boolean z) {
        TBannerAd tBannerAd = this.a;
        if (tBannerAd != null) {
            tBannerAd.setCloseDirectlyWithoutJumping(z);
        }
    }

    public void setContainVulgarContent(boolean z) {
        TBannerAd tBannerAd = this.a;
        if (tBannerAd != null) {
            tBannerAd.setContainVulgarContent(z);
        }
    }

    public void setCurrActivityFullscreen(boolean z) {
        TBannerAd tBannerAd = this.a;
        if (tBannerAd != null) {
            tBannerAd.setCurrActivityFullscreen(z);
        }
    }

    public void setCustomSizeForYandexAndLiftoff(int i, int i2) {
        TBannerAd tBannerAd = this.a;
        if (tBannerAd != null) {
            tBannerAd.e(i);
            this.a.d(i2);
        }
    }

    public void setHideAdCloseView(boolean z) {
        TBannerAd tBannerAd = this.a;
        if (tBannerAd != null) {
            tBannerAd.setHideAdCloseView(z);
        }
    }

    public void setRequestBody(TAdRequestBody tAdRequestBody) {
        TBannerAd tBannerAd = this.a;
        if (tBannerAd != null) {
            tBannerAd.setRequestBody(tAdRequestBody);
        }
    }
}
