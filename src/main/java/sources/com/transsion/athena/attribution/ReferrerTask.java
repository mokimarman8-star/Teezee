package com.transsion.athena.attribution;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import i5.a;
import i5.c;
import i5.d;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class ReferrerTask implements Runnable {
    private final int mAppId;
    private final Context mContext;
    private a referrerClient;

    public ReferrerTask(Context context, int i) {
        this.mContext = context;
        this.mAppId = i;
    }

    private void checkGpReferrer() {
        if (isAppIdGpRefTracked()) {
            AttrLog.d("appId : " + this.mAppId + " referrer has tracked !");
            return;
        }
        String cachedGpRef = getCachedGpRef();
        if (!TextUtils.isEmpty(cachedGpRef)) {
            AttrLog.d("appId : " + this.mAppId + " has cached GP referrer !");
            try {
                trackGpReferrer(cachedGpRef);
                markAppIdGpRefTracked();
                return;
            } catch (Exception e) {
                AttrLog.printStackTrace(e);
                return;
            }
        }
        try {
            if (this.referrerClient == null) {
                this.referrerClient = a.c(this.mContext).a();
            }
            AttrLog.d("appId : " + this.mAppId + " referrerClient startConnection");
            this.referrerClient.d(new c() { // from class: com.transsion.athena.attribution.ReferrerTask.1
                public void onInstallReferrerServiceDisconnected() {
                    if (ReferrerTask.this.referrerClient != null) {
                        ReferrerTask.this.referrerClient.a();
                    }
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0050 A[ORIG_RETURN, RETURN] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onInstallReferrerSetupFinished(int i) {
                    try {
                        try {
                        } catch (Exception e2) {
                            AttrLog.printStackTrace(e2);
                            if (ReferrerTask.this.referrerClient == null) {
                                return;
                            }
                        }
                        if (i == 0) {
                            AttrLog.d("InstallReferrerResponse.OK");
                            ReferrerTask.this.trackGpReferrer(ReferrerTask.this.referrerClient.b());
                            ReferrerTask.this.markAppIdGpRefTracked();
                        } else {
                            if (i != 1) {
                                if (i == 2) {
                                    AttrLog.d("InstallReferrerResponse.FEATURE_NOT_SUPPORTED");
                                }
                                if (ReferrerTask.this.referrerClient == null) {
                                    return;
                                }
                                ReferrerTask.this.referrerClient.a();
                            }
                            AttrLog.d("InstallReferrerResponse.SERVICE_UNAVAILABLE");
                        }
                        if (ReferrerTask.this.referrerClient == null) {
                        }
                        ReferrerTask.this.referrerClient.a();
                    } catch (Throwable th2) {
                        if (ReferrerTask.this.referrerClient != null) {
                            ReferrerTask.this.referrerClient.a();
                        }
                        throw th2;
                    }
                }
            });
        } catch (Exception e2) {
            AttrLog.printStackTrace(e2);
        }
    }

    private void checkPsReferrer() {
        if (isAppIdPsRefTracked()) {
            return;
        }
        String cachedPsRef = getCachedPsRef();
        if (!TextUtils.isEmpty(cachedPsRef)) {
            try {
                trackPsReferrer(cachedPsRef);
                markAppIdPsRefTracked();
                return;
            } catch (Exception e) {
                AttrLog.printStackTrace(e);
                return;
            }
        }
        try {
            Cursor query = this.mContext.getContentResolver().query(Uri.parse(AttrConstant.PS_REFERRER_PROVIDER_URI), null, null, new String[]{this.mContext.getPackageName()}, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        trackPsReferrer(query.getString(0), query.getString(1), query.getString(2), query.getString(3));
                        markAppIdPsRefTracked();
                    } else {
                        AttrLog.d(this.mContext.getPackageName() + " Referrer not found");
                    }
                } finally {
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e2) {
            AttrLog.printStackTrace(e2);
        }
    }

    private String getCachedGpRef() {
        return SpUtils.getInstance(this.mContext).getString(AttrConstant.KEY_GP_REF);
    }

    private String getCachedPsRef() {
        return SpUtils.getInstance(this.mContext).getString(AttrConstant.KEY_PS_REF);
    }

    private boolean isAppIdGpRefTracked() {
        SpUtils spUtils = SpUtils.getInstance(this.mContext);
        return !TextUtils.isEmpty(spUtils.getString("key_appid_gp_track_flag_" + this.mAppId));
    }

    private boolean isAppIdPsRefTracked() {
        SpUtils spUtils = SpUtils.getInstance(this.mContext);
        return !TextUtils.isEmpty(spUtils.getString("key_appid_ps_track_flag_" + this.mAppId));
    }

    private boolean isGpReferrerValid(d dVar) {
        if (dVar == null) {
            return false;
        }
        String d = dVar.d();
        long f = dVar.f();
        return !TextUtils.isEmpty(d) && f > 0 && dVar.b() >= f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void markAppIdGpRefTracked() {
        SpUtils.getInstance(this.mContext).saveString("key_appid_gp_track_flag_" + this.mAppId, String.valueOf(System.currentTimeMillis()));
    }

    private void markAppIdPsRefTracked() {
        SpUtils.getInstance(this.mContext).saveString("key_appid_ps_track_flag_" + this.mAppId, String.valueOf(System.currentTimeMillis()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trackGpReferrer(d dVar) {
        if (dVar == null) {
            return;
        }
        String d = dVar.d();
        String e = dVar.e();
        long f = dVar.f();
        long g = dVar.g();
        long b = dVar.b();
        long c = dVar.c();
        boolean a = dVar.a();
        Bundle bundle = new Bundle();
        bundle.putString(AttrConstant.KEY_INSTALL_REFERRER, d);
        bundle.putString(AttrConstant.KEY_INSTALL_VERSION, e);
        bundle.putLong(AttrConstant.KEY_REFERRER_CLICK_TIMESTAMP, f);
        bundle.putLong(AttrConstant.KEY_REFERRER_CLICK_TIMESTAMP_SERVER, g);
        bundle.putLong(AttrConstant.KEY_INSTALL_BEGIN_TIMESTAMP, b);
        bundle.putLong(AttrConstant.KEY_INSTALL_BEGIN_TIMESTAMP_SERVER, c);
        bundle.putBoolean(AttrConstant.KEY_GOOGLE_PLAY_INSTANT, a);
        new hi.a(AttrConstant.GP_REFERRER_EVENT, this.mAppId).c(bundle, null).b();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(AttrConstant.KEY_INSTALL_REFERRER, d);
            jSONObject.put(AttrConstant.KEY_INSTALL_VERSION, e);
            jSONObject.put(AttrConstant.KEY_REFERRER_CLICK_TIMESTAMP, f);
            jSONObject.put(AttrConstant.KEY_REFERRER_CLICK_TIMESTAMP_SERVER, g);
            jSONObject.put(AttrConstant.KEY_INSTALL_BEGIN_TIMESTAMP, b);
            jSONObject.put(AttrConstant.KEY_INSTALL_BEGIN_TIMESTAMP_SERVER, c);
            jSONObject.put(AttrConstant.KEY_GOOGLE_PLAY_INSTANT, a);
            SpUtils.getInstance(this.mContext).saveString(AttrConstant.KEY_GP_REF, jSONObject.toString());
        } catch (Exception e2) {
            AttrLog.printStackTrace(e2);
        }
    }

    private void trackGpReferrer(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        Bundle bundle = new Bundle();
        bundle.putString(AttrConstant.KEY_INSTALL_REFERRER, jSONObject.optString(AttrConstant.KEY_INSTALL_REFERRER));
        bundle.putString(AttrConstant.KEY_INSTALL_VERSION, jSONObject.optString(AttrConstant.KEY_INSTALL_VERSION));
        bundle.putLong(AttrConstant.KEY_REFERRER_CLICK_TIMESTAMP, jSONObject.optLong(AttrConstant.KEY_REFERRER_CLICK_TIMESTAMP));
        bundle.putLong(AttrConstant.KEY_REFERRER_CLICK_TIMESTAMP_SERVER, jSONObject.optLong(AttrConstant.KEY_REFERRER_CLICK_TIMESTAMP_SERVER));
        bundle.putLong(AttrConstant.KEY_INSTALL_BEGIN_TIMESTAMP, jSONObject.optLong(AttrConstant.KEY_INSTALL_BEGIN_TIMESTAMP));
        bundle.putLong(AttrConstant.KEY_INSTALL_BEGIN_TIMESTAMP_SERVER, jSONObject.optLong(AttrConstant.KEY_INSTALL_BEGIN_TIMESTAMP_SERVER));
        bundle.putBoolean(AttrConstant.KEY_GOOGLE_PLAY_INSTANT, jSONObject.optBoolean(AttrConstant.KEY_GOOGLE_PLAY_INSTANT));
        new hi.a(AttrConstant.GP_REFERRER_EVENT, this.mAppId).c(bundle, null).b();
    }

    private void trackPsReferrer(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        Bundle bundle = new Bundle();
        bundle.putString(AttrConstant.KEY_INSTALL_REFERRER, jSONObject.optString(AttrConstant.KEY_INSTALL_REFERRER));
        bundle.putString(AttrConstant.KEY_START_CLICK_TIME, jSONObject.optString(AttrConstant.KEY_START_CLICK_TIME));
        bundle.putString(AttrConstant.KEY_START_DOWNLOAD_TIME, jSONObject.optString(AttrConstant.KEY_START_DOWNLOAD_TIME));
        bundle.putString(AttrConstant.KEY_INSTALLED_FINISH_TIME, jSONObject.optString(AttrConstant.KEY_INSTALLED_FINISH_TIME));
        new hi.a(AttrConstant.PS_REFERRER_EVENT, this.mAppId).c(bundle, null).b();
    }

    private void trackPsReferrer(String str, String str2, String str3, String str4) {
        Bundle bundle = new Bundle();
        bundle.putString(AttrConstant.KEY_INSTALL_REFERRER, str);
        bundle.putString(AttrConstant.KEY_START_CLICK_TIME, str2);
        bundle.putString(AttrConstant.KEY_START_DOWNLOAD_TIME, str3);
        bundle.putString(AttrConstant.KEY_INSTALLED_FINISH_TIME, str4);
        new hi.a(AttrConstant.PS_REFERRER_EVENT, this.mAppId).c(bundle, null).b();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(AttrConstant.KEY_INSTALL_REFERRER, str);
            jSONObject.put(AttrConstant.KEY_START_CLICK_TIME, str2);
            jSONObject.put(AttrConstant.KEY_START_DOWNLOAD_TIME, str3);
            jSONObject.put(AttrConstant.KEY_INSTALLED_FINISH_TIME, str4);
            SpUtils.getInstance(this.mContext).saveString(AttrConstant.KEY_PS_REF, jSONObject.toString());
        } catch (Exception e) {
            AttrLog.printStackTrace(e);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        AttrLog.d("====================\\ ReferrerTask start \\================");
        try {
            checkGpReferrer();
            checkPsReferrer();
        } catch (Exception e) {
            AttrLog.printStackTrace(e);
        }
        AttrLog.d("====================\\ ReferrerTask end \\================");
    }
}
