package com.transsion.push.config;

import ak.b;
import ak.c;
import android.os.Build;
import android.text.TextUtils;
import com.transsion.core.deviceinfo.DeviceInfo;
import com.transsion.ga.AthenaAnalytics;
import com.transsion.gslb.BuildConfig;
import com.transsion.push.ITopicListener;
import com.transsion.push.PushConstants;
import com.transsion.push.bean.ConfigInfo;
import com.transsion.push.bean.PushRequest;
import com.transsion.push.bean.PushRequest$SelfDestroyContentData;
import com.transsion.push.bean.PushRequest$TopicContentData;
import com.transsion.push.bean.PushResponse;
import com.transsion.push.bean.SelfDestroyInfo;
import com.transsion.push.utils.NotificationAssistUtils;
import com.transsion.push.utils.PushLogUtils;
import com.transsion.push.utils.PushUtils;
import com.transsion.push.utils.g0;
import com.transsion.push.utils.k;
import com.transsion.push.utils.k0;
import com.transsion.push.utils.m;
import com.transsion.push.utils.o;
import com.transsion.push.utils.p0;
import com.transsion.push.utils.q0;
import java.util.ArrayList;
import java.util.Locale;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a {
    private PushRequest.ReportContentData a() {
        PushRequest.ReportContentData reportContentData = new PushRequest.ReportContentData();
        Locale locale = Locale.getDefault();
        reportContentData.vaid = AthenaAnalytics.H(yj.a.a(), true);
        reportContentData.gaid = DeviceInfo.e();
        reportContentData.sdkVersion = "2.0.2.01";
        reportContentData.sdkVersionCode = 17004;
        reportContentData.pkg = k.f();
        reportContentData.confVersion = g0.a();
        reportContentData.whitelistVersion = q0.b();
        if (k0.e()) {
            reportContentData.platVer = k0.c();
        }
        boolean booleanValue = ((Boolean) PushRepository.getInstance().getSpValue(PushConstants.SP_KEY_IS_REPORT_DETAIL, Boolean.TRUE)).booleanValue();
        if (TextUtils.isEmpty(reportContentData.clientId)) {
            booleanValue = true;
        }
        reportContentData.withDetail = booleanValue;
        if (booleanValue) {
            reportContentData.aid = DeviceInfo.c();
            String str = Build.BRAND;
            if (!TextUtils.isEmpty(str)) {
                str = str.toUpperCase().replace(" ", BuildConfig.FLAVOR);
            }
            reportContentData.brand = str;
            reportContentData.androidVersion = Build.VERSION.RELEASE;
            reportContentData.cid = 0;
            reportContentData.lac = 0;
            reportContentData.language = locale.getLanguage() == null ? null : locale.getLanguage().toLowerCase();
            reportContentData.mcc = k.d();
            reportContentData.mnc = k.e();
            String str2 = Build.MODEL;
            if (!TextUtils.isEmpty(str2)) {
                str2 = str2.toUpperCase().replace(" ", BuildConfig.FLAVOR);
            }
            reportContentData.model = str2;
            reportContentData.network = o.a();
            reportContentData.osVersion = String.valueOf(Build.VERSION.SDK_INT);
            reportContentData.appVersion = k.g(yj.a.a());
            reportContentData.appVersionCode = com.transsion.core.utils.a.b();
            reportContentData.token = (String) PushRepository.getInstance().getSpValue(PushConstants.SP_KEY_FCM_TOKEN, BuildConfig.FLAVOR);
            reportContentData.country = locale.getCountry() != null ? locale.getCountry().toUpperCase() : null;
        }
        k0.h(reportContentData);
        reportContentData.appId = PushUtils.e();
        reportContentData.appKey = PushUtils.f();
        reportContentData.clientId = (String) PushRepository.getInstance().getSpValue(PushConstants.SP_KEY_CLIENT_ID, BuildConfig.FLAVOR);
        reportContentData.noticeEnable = NotificationAssistUtils.isOpenNotification(yj.a.a()) ? 1 : 2;
        return reportContentData;
    }

    private PushRequest$SelfDestroyContentData b() {
        PushRequest$SelfDestroyContentData pushRequest$SelfDestroyContentData = new PushRequest$SelfDestroyContentData();
        pushRequest$SelfDestroyContentData.appId = PushUtils.e();
        pushRequest$SelfDestroyContentData.appKey = PushUtils.f();
        pushRequest$SelfDestroyContentData.clientId = (String) PushRepository.getInstance().getSpValue(PushConstants.SP_KEY_CLIENT_ID, BuildConfig.FLAVOR);
        pushRequest$SelfDestroyContentData.sdkVersion = "2.0.2.01";
        pushRequest$SelfDestroyContentData.sdkVersionCode = 17004;
        pushRequest$SelfDestroyContentData.appVersion = k.g(yj.a.a());
        pushRequest$SelfDestroyContentData.appVersionCode = com.transsion.core.utils.a.b();
        pushRequest$SelfDestroyContentData.confVersion = g0.a();
        pushRequest$SelfDestroyContentData.whitelistVersion = q0.b();
        return pushRequest$SelfDestroyContentData;
    }

    private PushRequest$TopicContentData c(String str, String str2) {
        PushRequest$TopicContentData pushRequest$TopicContentData = new PushRequest$TopicContentData();
        pushRequest$TopicContentData.clientId = (String) PushRepository.getInstance().getSpValue(PushConstants.SP_KEY_CLIENT_ID, BuildConfig.FLAVOR);
        pushRequest$TopicContentData.gaid = DeviceInfo.e();
        pushRequest$TopicContentData.appId = PushUtils.e();
        pushRequest$TopicContentData.appKey = PushUtils.f();
        pushRequest$TopicContentData.appVersion = com.transsion.core.utils.a.c();
        pushRequest$TopicContentData.appVersionCode = com.transsion.core.utils.a.b();
        pushRequest$TopicContentData.sdkVersion = "2.0.2.01";
        pushRequest$TopicContentData.sdkVersionCode = 17004;
        if (!TextUtils.isEmpty(str)) {
            pushRequest$TopicContentData.topics = new ArrayList<>();
            if (str.contains(",")) {
                for (String str3 : str.split(",")) {
                    pushRequest$TopicContentData.topics.add(str3.toLowerCase());
                }
            } else {
                pushRequest$TopicContentData.topics.add(str.toLowerCase());
            }
        }
        pushRequest$TopicContentData.action = str2;
        return pushRequest$TopicContentData;
    }

    private void d(ITopicListener iTopicListener, String str) {
        if (iTopicListener != null) {
            iTopicListener.onFail(str);
        }
    }

    SelfDestroyInfo e() {
        try {
            PushRequest$SelfDestroyContentData b = b();
            PushLogUtils.LOG.g("get self-destroying request data: " + b.toString());
            b bVar = new b();
            c cVar = new c(PushConstants.RSA_PUB_KEY);
            PushRequest pushRequest = new PushRequest();
            String c = bVar.c(bVar.e(com.transsion.json.b.b(b)));
            String c2 = bVar.c(cVar.d(bVar.i()));
            pushRequest.data = c;
            pushRequest.key = c2;
            byte[] bytes = com.transsion.json.b.b(pushRequest).getBytes();
            String d = k0.d();
            if (TextUtils.isEmpty(d)) {
                return null;
            }
            String str = d + PushUtils.e() + PushConstants.CONFIG_URL_PATH;
            PushLogUtils.LOG.g("self-destroying request url:" + str);
            byte[] c3 = m.c(str, bytes);
            if (c3 == null) {
                PushLogUtils.LOG.i("the response data is empty");
                return null;
            }
            PushResponse pushResponse = (PushResponse) com.transsion.json.b.a(new String(c3), PushResponse.class);
            if (pushResponse == null) {
                PushLogUtils.LOG.i("parse self-destroying BaseResponse failed");
                return null;
            }
            if (pushResponse.status != 200) {
                PushLogUtils.LOG.i("self-destroying BaseResponse status error, status:" + pushResponse.status + ", " + pushResponse.message);
                return null;
            }
            PushResponse.SignedEncryptedData signedEncryptedData = pushResponse.data;
            if (signedEncryptedData == null) {
                PushLogUtils.LOG.i("parse self-destroying signedResponse failed");
                return null;
            }
            if (!cVar.g(p0.a(bVar.a(signedEncryptedData.data)), bVar.a(signedEncryptedData.sign))) {
                PushLogUtils.LOG.i("self-destroying verify signature failed");
                return null;
            }
            SelfDestroyInfo selfDestroyInfo = (SelfDestroyInfo) com.transsion.json.b.a(new String(bVar.d(bVar.a(signedEncryptedData.data))), SelfDestroyInfo.class);
            if (selfDestroyInfo != null) {
                return selfDestroyInfo;
            }
            PushLogUtils.LOG.i("parse self-destroying info failed");
            return null;
        } catch (Exception e) {
            PushLogUtils.LOG.z("self-destroying Exception: " + e.getMessage());
            return null;
        }
    }

    ConfigInfo f() {
        String str;
        try {
            PushRequest.ReportContentData a = a();
            PushLogUtils.LOG.g("get config request data: " + a.toString());
            b bVar = new b();
            c cVar = new c(PushConstants.RSA_PUB_KEY);
            PushRequest pushRequest = new PushRequest();
            String c = bVar.c(bVar.e(com.transsion.json.b.b(a)));
            String c2 = bVar.c(cVar.d(bVar.i()));
            pushRequest.data = c;
            pushRequest.key = c2;
            byte[] bytes = com.transsion.json.b.b(pushRequest).getBytes();
            String d = k0.d();
            if (TextUtils.isEmpty(d)) {
                return null;
            }
            if (k0.e()) {
                str = d + PushConstants.TPMS_URL_PATH;
            } else {
                str = d + PushUtils.e() + PushConstants.UPDATE_URL_PATH;
            }
            PushLogUtils.LOG.g("request url:" + str);
            byte[] c3 = m.c(str, bytes);
            if (c3 == null) {
                PushLogUtils.LOG.i("the response data is empty");
                return null;
            }
            PushResponse pushResponse = (PushResponse) com.transsion.json.b.a(new String(c3), PushResponse.class);
            if (pushResponse == null) {
                PushLogUtils.LOG.i("parse syncActive BaseResponse failed");
                return null;
            }
            if (pushResponse.status != 200) {
                PushLogUtils.LOG.i("syncActive BaseResponse status error, status:" + pushResponse.status + ", " + pushResponse.message);
                return null;
            }
            PushResponse.SignedEncryptedData signedEncryptedData = pushResponse.data;
            if (signedEncryptedData == null) {
                PushLogUtils.LOG.i("parse syncActive signedResponse failed");
                return null;
            }
            if (!cVar.g(p0.a(bVar.a(signedEncryptedData.data)), bVar.a(signedEncryptedData.sign))) {
                PushLogUtils.LOG.i("syncActive verify signature failed");
                return null;
            }
            ConfigInfo configInfo = (ConfigInfo) com.transsion.json.b.a(new String(bVar.d(bVar.a(signedEncryptedData.data))), ConfigInfo.class);
            if (configInfo != null) {
                return configInfo;
            }
            PushLogUtils.LOG.i("parse syncActive reportResponse failed");
            return null;
        } catch (Exception e) {
            PushLogUtils.LOG.i("syncActive Exception: " + e.getMessage());
            return null;
        }
    }

    void g(String str, String str2, ITopicListener iTopicListener) {
        PushRequest$TopicContentData c = c(str, str2);
        PushLogUtils.LOG.g("topics request data: " + c.toString());
        b bVar = new b();
        c cVar = new c(PushConstants.RSA_PUB_KEY);
        PushRequest pushRequest = new PushRequest();
        try {
            String c2 = bVar.c(bVar.e(com.transsion.json.b.b(c)));
            String c3 = bVar.c(cVar.d(bVar.i()));
            pushRequest.data = c2;
            pushRequest.key = c3;
            byte[] bytes = com.transsion.json.b.b(pushRequest).getBytes();
            String d = k0.d();
            if (TextUtils.isEmpty(d)) {
                return;
            }
            String str3 = d + PushUtils.e() + PushConstants.TOPICS_URL_PATH;
            PushLogUtils.LOG.g("topics request url:" + str3);
            byte[] c4 = m.c(str3, bytes);
            if (c4 == null) {
                PushLogUtils.LOG.i("the response data is empty");
                d(iTopicListener, "the response data is empty");
                return;
            }
            PushResponse pushResponse = (PushResponse) com.transsion.json.b.a(new String(c4), PushResponse.class);
            if (pushResponse == null) {
                PushLogUtils.LOG.i("parse topics BaseResponse failed");
                d(iTopicListener, "parse topics BaseResponse failed");
                return;
            }
            if (pushResponse.status == 200) {
                if (iTopicListener != null) {
                    iTopicListener.onSuccess();
                    return;
                }
                return;
            }
            PushLogUtils.LOG.i("topics BaseResponse status error, status:" + pushResponse.status + ", " + pushResponse.message);
            d(iTopicListener, "topics BaseResponse status error, status:" + pushResponse.status + ", " + pushResponse.message);
        } catch (Exception e) {
            PushLogUtils.LOG.z("topics Exception: " + e.getMessage());
            d(iTopicListener, "topics Exception: " + e.getMessage());
        }
    }
}
