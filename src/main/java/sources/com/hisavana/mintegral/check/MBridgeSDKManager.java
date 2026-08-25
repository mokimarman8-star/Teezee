package com.hisavana.mintegral.check;

import android.content.Context;
import android.text.TextUtils;
import com.hisavana.common.bean.AppStartInfo;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.MBridgeSDK;
import com.mbridge.msdk.out.MBridgeSDKFactory;
import com.mbridge.msdk.out.SDKInitStatusListener;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.system.MBridgeSDKImpl;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class MBridgeSDKManager {
    private static MBridgeSDKInitializeState e;
    private volatile String a;
    private volatile String b;
    private volatile MBridgeSDKInitializeListener c;
    private MBridgeSDK d;

    private static final class ClassHolder {
        private static final MBridgeSDKManager a = new MBridgeSDKManager();
    }

    private static class DefaultSDKInitStatusListener implements SDKInitStatusListener {
        private String a;
        private String b;
        private MBridgeSDKInitializeListener c;

        public DefaultSDKInitStatusListener(String str, String str2, MBridgeSDKInitializeListener mBridgeSDKInitializeListener) {
            this.a = str;
            this.b = str2;
            this.c = mBridgeSDKInitializeListener;
        }

        public void onInitFail(String str) {
            MBridgeSDKInitializeState unused = MBridgeSDKManager.e = MBridgeSDKInitializeState.SDK_STATE_INITIALIZE_FAILURE;
            MBridgeSDKInitializeListener mBridgeSDKInitializeListener = this.c;
            if (mBridgeSDKInitializeListener != null) {
                mBridgeSDKInitializeListener.onInitializeFailure("sdk initialize failed： an exception occurs");
            }
        }

        public void onInitSuccess() {
            MBridgeSDKInitializeState unused = MBridgeSDKManager.e = MBridgeSDKInitializeState.SDK_STATE_INITIALIZE_SUCCESS;
            MBridgeSDKInitializeListener mBridgeSDKInitializeListener = this.c;
            if (mBridgeSDKInitializeListener != null) {
                mBridgeSDKInitializeListener.onInitializeSuccess(this.a, this.b);
            }
        }
    }

    public interface MBridgeSDKInitializeListener {
        void onInitializeFailure(String str);

        void onInitializeSuccess(String str, String str2);
    }

    public enum MBridgeSDKInitializeState {
        SDK_STATE_UN_INITIALIZE,
        SDK_STATE_INITIALIZING,
        SDK_STATE_INITIALIZE_SUCCESS,
        SDK_STATE_INITIALIZE_FAILURE
    }

    private MBridgeSDKManager() {
        e = MBridgeSDKInitializeState.SDK_STATE_UN_INITIALIZE;
    }

    private void b(Context context, boolean z, Map map, MBridgeSDKInitializeListener mBridgeSDKInitializeListener) {
        try {
            MBridgeConstans.DEBUG = z;
            MBridgeSDKImpl mBridgeSDK = MBridgeSDKFactory.getMBridgeSDK();
            this.d = mBridgeSDK;
            Map<String, String> mBConfigurationMap = mBridgeSDK.getMBConfigurationMap(this.b, this.a, TtmlNode.ANONYMOUS_REGION_ID);
            if (map != null && !map.isEmpty()) {
                mBConfigurationMap.putAll(map);
            }
            this.d.setConsentStatus(context, AppStartInfo.userConsent ? 1 : 0);
            this.d.init(mBConfigurationMap, context, new DefaultSDKInitStatusListener(this.a, this.b, this.c));
            this.d.setCoppaStatus(context, AppStartInfo.ageRestrictedUser);
        } catch (Exception e2) {
            e = MBridgeSDKInitializeState.SDK_STATE_INITIALIZE_FAILURE;
            if (this.c != null) {
                mBridgeSDKInitializeListener.onInitializeFailure(e2.getMessage());
            }
        }
    }

    private boolean c(Context context, String str, String str2) {
        boolean z;
        String str3;
        boolean z2 = false;
        if (context == null) {
            str3 = "context must not null";
            z = false;
        } else {
            z = true;
            str3 = TtmlNode.ANONYMOUS_REGION_ID;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            z2 = z;
        } else if (TextUtils.isEmpty(str3)) {
            str3 = "appKey or appID must not null";
        } else {
            str3 = str3 + " & appKey or appID must not null";
        }
        if (!z2 && !TextUtils.isEmpty(str3) && this.c != null) {
            e = MBridgeSDKInitializeState.SDK_STATE_INITIALIZE_FAILURE;
            this.c.onInitializeFailure(str3);
        }
        return z2;
    }

    public static MBridgeSDKManager getInstance() {
        return ClassHolder.a;
    }

    public String getAppID() {
        return this.b;
    }

    public String getAppKey() {
        return this.a;
    }

    public MBridgeSDKInitializeState getCurrentState() {
        return e;
    }

    public MBridgeSDK getMBridgeSDK() {
        return this.d;
    }

    public synchronized void initialize(Context context, String str, String str2) {
        initialize(context, str, str2, false, null, null);
    }

    public synchronized void initialize(Context context, String str, String str2, MBridgeSDKInitializeListener mBridgeSDKInitializeListener) {
        initialize(context, str, str2, false, null, mBridgeSDKInitializeListener);
    }

    public synchronized void initialize(Context context, String str, String str2, boolean z) {
        initialize(context, str, str2, z, null, null);
    }

    public synchronized void initialize(Context context, String str, String str2, boolean z, MBridgeSDKInitializeListener mBridgeSDKInitializeListener) {
        initialize(context, str, str2, z, null, mBridgeSDKInitializeListener);
    }

    public synchronized void initialize(Context context, String str, String str2, boolean z, Map<String, String> map) {
        initialize(context, str, str2, z, map, null);
    }

    public synchronized void initialize(Context context, String str, String str2, boolean z, Map<String, String> map, MBridgeSDKInitializeListener mBridgeSDKInitializeListener) {
        MBridgeSDKInitializeState mBridgeSDKInitializeState = e;
        MBridgeSDKInitializeState mBridgeSDKInitializeState2 = MBridgeSDKInitializeState.SDK_STATE_INITIALIZING;
        if (mBridgeSDKInitializeState == mBridgeSDKInitializeState2) {
            if (mBridgeSDKInitializeListener != null) {
                mBridgeSDKInitializeListener.onInitializeFailure("sdk is initializing");
            }
            return;
        }
        this.c = mBridgeSDKInitializeListener;
        if (c(context, str, str2)) {
            if (e == MBridgeSDKInitializeState.SDK_STATE_INITIALIZE_SUCCESS && TextUtils.equals(this.b, str2) && TextUtils.equals(this.a, str)) {
                if (this.c != null) {
                    this.c.onInitializeSuccess(this.a, this.b);
                }
            } else {
                e = mBridgeSDKInitializeState2;
                this.a = str;
                this.b = str2;
                b(context, z, map, this.c);
            }
        }
    }
}
