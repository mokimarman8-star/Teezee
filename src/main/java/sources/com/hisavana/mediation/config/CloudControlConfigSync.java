package com.hisavana.mediation.config;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.http.a;
import com.cloud.hisavana.sdk.common.http.listener.CommonResponseListener;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import com.cloud.sdk.commonutil.util.HSScopeHelper;
import com.cloud.sdk.commonutil.util.Preconditions;
import com.cloud.sdk.commonutil.util.o;
import com.hisavana.common.base.LogSwitch;
import com.hisavana.common.bean.Network;
import com.hisavana.common.constant.ComConstants$Pref;
import com.hisavana.common.mock.RecordTestInfo;
import com.hisavana.common.param.CloudConfigParam;
import com.hisavana.common.tracking.TrackingKey;
import com.hisavana.common.tracking.TrackingManager;
import com.hisavana.common.tracking.TrackingUtil;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.common.utils.AdUtil;
import com.hisavana.common.utils.NetUtil;
import com.hisavana.mediation.bean.CloudControlConfig;
import com.hisavana.mediation.config.TAdManager;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.interstitial.view.MBInterstitialActivity;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import ee.l;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import k7.c;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class CloudControlConfigSync {
    public static Handler c;
    public static final AtomicBoolean a = new AtomicBoolean();
    public static int b = 0;
    public static final Runnable d = new Runnable() { // from class: com.hisavana.mediation.config.CloudControlConfigSync.4
        @Override // java.lang.Runnable
        public void run() {
            CloudControlConfigSync.m(70001, "The cloud control reaches 15s timeout");
        }
    };

    public class a implements a.b {
        public String a() {
            return CloudConfigParam.getPostBody(TAdManager.getAppId(), TAdManager.isTestDevice(), TAdManager.getAhaChannel(), TAdManager.getCodeSeatIds());
        }
    }

    public class b implements Preconditions.a {
        public final /* synthetic */ int a;
        public final /* synthetic */ String b;

        public b(int i, String str) {
            this.a = i;
            this.b = str;
        }

        public void onRun() {
            TAdManager.OnCloudCompleteListener cloudCompleteListener = TAdManager.getCloudCompleteListener();
            if (cloudCompleteListener != null) {
                cloudCompleteListener.onCloudComplete(this.a, this.b);
                TAdManager.releaseCloudListener();
            }
        }
    }

    public static void b(int i) {
        String triggerId = TrackingUtil.getTriggerId();
        b = 0;
        String k = l7.a.e().k("cloudControlVersion", (String) null);
        if (TextUtils.isEmpty(k)) {
            o(i, triggerId);
            return;
        }
        if (TextUtils.equals(TAdManager.getAhaChannel(), "aha")) {
            if (i == 1 || i == 5) {
                AdLogUtil.Log().d("sdk_init", "aha渠道请求云控 triggerType " + i + " ids= " + TAdManager.getCodeSeatIds());
                if (TAdManager.getCodeSeatIds() == null || TAdManager.getCodeSeatIds().size() <= 0) {
                    return;
                }
                o(i, triggerId);
                return;
            }
            return;
        }
        String j = l7.a.e().j("new_config_ver");
        RecordTestInfo.record("CloudControlConfigSync - newVersion = " + j + ",current version=" + k);
        if (!TextUtils.isEmpty(j) && !TextUtils.equals(k, j)) {
            o(i, triggerId);
            return;
        }
        if (System.currentTimeMillis() - l7.a.e().i("last_req_config_time", 0L) <= l7.a.e().i(ComConstants$Pref.REQ_CONFIG_INTERVAL, 86400000L)) {
            AdLogUtil.Log().d("sdk_init", "*----> new cloud config version is empty or is the same as current,don't send config request");
        } else if (NetUtil.checkNetworkState()) {
            AdLogUtil.Log().d("sdk_init", "request cloud config because of out of time");
            o(i, triggerId);
        }
    }

    public static void d(long j, String str, int i) {
        Bundle bundle = new Bundle();
        bundle.putString(TrackingKey.CLD_APP_ID, TAdManager.getAppId());
        bundle.putInt(TrackingKey.TRIGGER_TYPE, i);
        bundle.putString(TrackingKey.CLD_REQUEST_ID, str);
        bundle.putLong(TrackingKey.CLD_REQUEST_TS, j);
        TrackingManager.trackingADCldRequest(bundle);
    }

    public static boolean g(String str, String str2) {
        AdLogUtil.Log().w("CloudControlConfigSync", "isNeedToUpdateLocalConfig newVersion=" + str + ",curVersion=" + str2);
        if (TextUtils.isEmpty(str2)) {
            return true;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, str2)) {
            try {
                if (str2.length() > 13) {
                    str2 = str2.substring(0, str2.length() - 13);
                }
                if (str.length() > 13) {
                    str = str.substring(0, str.length() - 13);
                }
                return Long.parseLong(str) > Long.parseLong(str2);
            } catch (Exception unused) {
                AdLogUtil.Log().w("CloudControlConfigSync", "not need update local config");
            }
        }
        return false;
    }

    public static void j(CloudControlConfig cloudControlConfig, boolean z) {
        if (cloudControlConfig == null) {
            return;
        }
        if (cloudControlConfig.getData() == null || cloudControlConfig.getData().getCodeSeats() == null) {
            AdLogUtil.Log().d("sdk_init", "CloudControlConfigSync --> extracted --> 数据为空 无法保存");
            t();
            m(cloudControlConfig.getCode(), cloudControlConfig.getMessage());
            return;
        }
        ConfigContentHelper.g().b();
        boolean i = ConfigContentHelper.g().i(cloudControlConfig.getData().getCodeSeats());
        if (ConfigContentHelper.g().f() > 0) {
            t();
            m(0, "get cloud data success");
        }
        if (!i) {
            AdLogUtil.Log().d("sdk_init", "*----> CloudControlConfigSync --> save data 2 sqlite failed!!!");
            return;
        }
        l7.a.e().r("cloudControlVersion", cloudControlConfig.getData().getCloudControlVersion());
        if (z) {
            l7.a.e().r("new_config_ver", cloudControlConfig.getData().getCloudControlVersion());
        }
        AdLogUtil.Log().i("sdk_init", "*----> CloudControlConfigSync --> save data 2 sqlite --> 持久化当前云控版本：" + cloudControlConfig.getData().getCloudControlVersion());
    }

    public static void k(boolean z, String str, String str2, long j, String str3, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt(TrackingKey.TRIGGER_TYPE, i);
        bundle.putString(TrackingKey.CLD_REQUEST_ID, str3);
        bundle.putLong(TrackingKey.CLD_RETURN_TS, System.currentTimeMillis());
        try {
            bundle.putInt(TrackingKey.CLD_RETURN_TIME_INTERVAL, (int) (System.currentTimeMillis() - j));
        } catch (Exception unused) {
        }
        if (z) {
            bundle.putInt(TrackingKey.CODE, 0);
        } else {
            bundle.putInt(TrackingKey.CODE, 1);
        }
        if (TextUtils.isEmpty(str)) {
            bundle.putString(TrackingKey.MESSAGE, TtmlNode.ANONYMOUS_REGION_ID);
        } else {
            bundle.putString(TrackingKey.MESSAGE, str);
        }
        bundle.putString("data", str2);
        TrackingManager.trackingCldReturn(bundle);
    }

    public static void m(int i, String str) {
        Preconditions.d(new b(i, str));
    }

    public static /* synthetic */ int n() {
        int i = b;
        b = i + 1;
        return i;
    }

    public static void o(final int i, final String str) {
        if (NetUtil.checkNetworkState()) {
            AtomicBoolean atomicBoolean = a;
            if (!atomicBoolean.get()) {
                if (TextUtils.equals(TAdManager.getAhaChannel(), "aha") && (TAdManager.getCodeSeatIds() == null || TAdManager.getCodeSeatIds().isEmpty())) {
                    AdLogUtil.Log().d("sdk_init", "requestCloudControl channel is aha,but codeSeatIds is empty,stop requestCloudControl");
                    return;
                }
                atomicBoolean.set(true);
                final long currentTimeMillis = System.currentTimeMillis();
                d(currentTimeMillis, str, i);
                RecordTestInfo.record("CloudControlConfigSync - send cloud control request");
                com.cloud.hisavana.sdk.common.http.a p = new com.cloud.hisavana.sdk.common.http.a().m(new CommonResponseListener<CloudControlConfig>() { // from class: com.hisavana.mediation.config.CloudControlConfigSync.3
                    public void a(TaErrorCode taErrorCode) {
                        String str2;
                        CloudControlConfigSync.a.set(false);
                        AdLogUtil Log = AdLogUtil.Log();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("CloudControlConfigSync --> error msg ");
                        if (taErrorCode != null) {
                            str2 = taErrorCode.getErrorMessage() + "，" + taErrorCode.getErrorCode();
                        } else {
                            str2 = TtmlNode.ANONYMOUS_REGION_ID;
                        }
                        sb2.append(str2);
                        Log.w("sdk_init", sb2.toString());
                        String j = l7.a.e().j("cloudControlVersion");
                        l7.a.e().p(ComConstants$Pref.CLOUD_CONFIG_ERROR_CODE, taErrorCode != null ? taErrorCode.getErrorCode() : -1);
                        if (taErrorCode != null) {
                            CloudControlConfigSync.k(false, taErrorCode.getErrorMessage(), j, currentTimeMillis, str, i);
                        } else {
                            CloudControlConfigSync.k(false, "no message", j, currentTimeMillis, str, i);
                        }
                        if (CloudControlConfigSync.b >= 1 && taErrorCode != null) {
                            CloudControlConfigSync.t();
                            if (taErrorCode.getErrorCode() == 481) {
                                CloudControlConfigSync.m(481, "request cloud network time out");
                            } else if (taErrorCode.getErrorCode() == 484) {
                                CloudControlConfigSync.m(484, "request cloud is host fail ");
                            }
                        }
                        if (taErrorCode != null) {
                            AdLogUtil.Log().i("sdk_init", "currentCloudRetryCount = " + CloudControlConfigSync.b + " , errorCode = " + taErrorCode.getErrorCode());
                            if (CloudControlConfigSync.b == 0) {
                                if (taErrorCode.getErrorCode() == 481 || taErrorCode.getErrorCode() == 484) {
                                    CloudControlConfigSync.n();
                                    CloudControlConfigSync.o(i, str);
                                }
                            }
                        }
                    }

                    /* renamed from: k, reason: merged with bridge method [inline-methods] */
                    public void g(int i2, final CloudControlConfig cloudControlConfig) {
                        List<Network> networks;
                        l7.a.e().p(ComConstants$Pref.CLOUD_CONFIG_ERROR_CODE, 0);
                        if (cloudControlConfig == null) {
                            CloudControlConfigSync.a.set(false);
                            CloudControlConfigSync.t();
                            CloudControlConfigSync.m(484, "request cloud is host fail ");
                            return;
                        }
                        if (LogSwitch.isDebug) {
                            AdLogUtil.Log().d("sdk_init", "CloudControlConfigSync --> CloudControl is: " + GsonUtil.d(cloudControlConfig));
                        }
                        l7.a.e().q("last_req_config_time", System.currentTimeMillis());
                        CloudControlConfig.ConfigData data = cloudControlConfig.getData();
                        if (data != null) {
                            int intValue = data.getCloudControlCacheInterval().intValue();
                            if (intValue > 0) {
                                l7.a.e().q(ComConstants$Pref.REQ_CONFIG_INTERVAL, intValue * 3600000);
                            }
                            ArrayList codeSeats = data.getCodeSeats();
                            if (codeSeats != null && !codeSeats.isEmpty()) {
                                int size = codeSeats.size();
                                for (int i3 = 0; i3 < size; i3++) {
                                    CloudControlConfig.CodeSeat codeSeat = (CloudControlConfig.CodeSeat) codeSeats.get(i3);
                                    if (codeSeat != null && (networks = codeSeat.getNetworks()) != null && !networks.isEmpty()) {
                                        for (Network network : networks) {
                                            if (network != null) {
                                                network.setTempPrice(network.getPrice().doubleValue());
                                                AdUtil.overwriteAdmobNetworkPrice(network);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        HSScopeHelper.a.g(new Runnable() { // from class: com.hisavana.mediation.config.CloudControlConfigSync.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    try {
                                        CloudControlConfigSync.j(cloudControlConfig, true);
                                    } catch (Exception e) {
                                        AdLogUtil.Log().e("sdk_init", "CloudControlConfigSync --> 保存本地数据失败 " + Log.getStackTraceString(e));
                                    }
                                } finally {
                                    CloudControlConfigSync.a.set(false);
                                }
                            }
                        });
                        if (cloudControlConfig.getData() != null) {
                            CloudControlConfigSync.k(true, cloudControlConfig.getMessage(), cloudControlConfig.getData().getCloudControlVersion(), currentTimeMillis, str, i);
                        }
                    }
                }).o(new a()).q(l.a()).p(MBridgeConstans.API_REUQEST_CATEGORY_APP);
                if (p != null) {
                    p.b();
                    return;
                }
                return;
            }
        }
        AdLogUtil.Log().w("sdk_init", "CloudControlConfigSync --> network error or requesting");
    }

    public static void q() {
        AdLogUtil Log = AdLogUtil.Log();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Current mode,testDevice: ");
        sb2.append(TAdManager.isTestDevice());
        sb2.append(",debug: ");
        sb2.append(TAdManager.isDebug());
        sb2.append(",server: ");
        sb2.append(i7.a.c() == 1 ? "Test" : "Release");
        Log.d("sdk_init", sb2.toString());
        c = new Handler(Looper.getMainLooper());
        r();
        s();
        HSScopeHelper.a.j(new 1(), 500L);
    }

    public static boolean r() {
        if (ConfigContentHelper.g().f() <= 0) {
            AdLogUtil.Log().i("CloudControlConfigSync", "no cloud data in db");
            return false;
        }
        t();
        ConfigContentHelper.g().h();
        m(0, "get cloud data success");
        return true;
    }

    public static void s() {
        try {
            String k = l7.a.e().k("host_version", (String) null);
            AdLogUtil.Log().d("CloudControlConfigSync", "cache host version: " + k + ", current host version: " + c.p());
            if (k == null || !TextUtils.equals(k, c.p())) {
                String k2 = l7.a.e().k("cloudControlVersion", (String) null);
                try {
                    String j = o.j("mediation.json");
                    if (TextUtils.isEmpty(j)) {
                        AdLogUtil.Log().e("CloudControlConfigSync", "get nothing from mediation.json");
                        return;
                    }
                    CloudControlConfig cloudControlConfig = (CloudControlConfig) GsonUtil.a(j, CloudControlConfig.class);
                    if (cloudControlConfig != null && cloudControlConfig.getData() != null) {
                        if (g(cloudControlConfig.getData().getCloudControlVersion(), k2)) {
                            j(cloudControlConfig, false);
                            l7.a.e().r("host_version", c.p());
                        }
                        r();
                    }
                } catch (FileNotFoundException unused) {
                    AdLogUtil.Log().w("CloudControlConfigSync", "There is no default mediation.json available locally.");
                    l7.a.e().r("host_version", c.p());
                } catch (IOException unused2) {
                    AdLogUtil.Log().w("CloudControlConfigSync", "Failed to read default mediation.json from assets.");
                }
            }
        } catch (Throwable th) {
            AdLogUtil.Log().e("CloudControlConfigSync", Log.getStackTraceString(th));
        }
    }

    public static void t() {
        Handler handler = c;
        if (handler != null) {
            handler.removeCallbacks(d);
        }
    }

    public static void u() {
        Handler handler = c;
        if (handler != null) {
            handler.postDelayed(d, MBInterstitialActivity.WEB_LOAD_TIME);
        }
    }
}
