package com.hisavana.common.interfacz;

import com.hisavana.common.bean.Network;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public interface ICacheAd {
    void destroyAd();

    void detachContext();

    int getAdSource();

    int getAdType();

    double getEcpmPrice();

    String getExt();

    String getFilterSource();

    String getMediatorSourceName();

    String getMediatorSourceUnitId();

    Network getNetwork();

    String getPlacementId();

    long getValidTimeLimit();

    boolean isAdxAd();

    boolean isEwAd();

    boolean isExpired();

    boolean isIconAd();

    boolean isInternalAd();

    boolean isMatchVulgarBrand();

    boolean isOfflineAd();

    void setAdSource(int i);

    void setEcpmPrice(double d);

    void setExt(String str);

    void setMaxPrice(double d);

    void setPreload(boolean z);

    void setRequestType(int i);

    void setSecondPrice(double d);

    void setTimeOut(boolean z);
}
