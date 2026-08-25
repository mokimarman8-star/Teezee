package com.hisavana.common.interfacz;

import android.os.Bundle;
import com.hisavana.common.bean.TInnerAdRequestBody;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public interface Iad extends ICacheAd {
    void addRequestBody(TInnerAdRequestBody tInnerAdRequestBody);

    String getAdUnit();

    int getLoadStatus();

    long getRequestTime();

    WrapTAdAllianceListener getTAdAllianceListener();

    boolean isSupportRtBidding();

    void loadAd();

    void setAdUnit(String str);

    void setLoadStatus(int i);

    void setOfflineAd(boolean z);

    void setRequestRound(int i);

    void setRequestTime(long j);

    void setSupportFlag(int i);

    void setTrackingBundle(Bundle bundle);

    void stopLoader();
}
