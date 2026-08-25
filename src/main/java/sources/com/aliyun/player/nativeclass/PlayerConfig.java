package com.aliyun.player.nativeclass;

import com.cloud.hisavana.abtestkit.db.ABContentProvider;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class PlayerConfig {
    public String mHttpProxy = "";
    public String mReferrer = "";
    public int mNetworkTimeout = 15000;
    public int mMaxDelayTime = 5000;
    public int mMaxBufferDuration = 50000;
    public int mHighBufferDuration = 3000;
    public int mStartBufferDuration = ABContentProvider.LOCAL_AB_BY_VERSION_CODE_SUCCESS;
    public int mMaxProbeSize = -1;
    public boolean mClearFrameWhenStop = false;
    public boolean mEnableVideoTunnelRender = false;
    public boolean mEnableVideoBufferRender = false;
    public boolean mEnableSEI = false;
    public String mUserAgent = "";
    public int mNetworkRetryCount = 2;
    public int mLiveStartIndex = -3;
    public boolean mDisableAudio = false;
    public boolean mDisableVideo = false;
    public int mPositionTimerIntervalMs = ABContentProvider.LOCAL_AB_BY_VERSION_CODE_SUCCESS;
    public long mMaxBackwardBufferDurationMs = 0;
    public boolean mPreferAudio = false;
    public boolean mEnableLocalCache = false;
    public int mEnableHttpDns = -1;
    private String[] mCustomHeaders = null;

    private PlayerConfig() {
    }

    public String[] getCustomHeaders() {
        return this.mCustomHeaders;
    }

    public void setCustomHeaders(String[] strArr) {
        this.mCustomHeaders = strArr;
    }
}
