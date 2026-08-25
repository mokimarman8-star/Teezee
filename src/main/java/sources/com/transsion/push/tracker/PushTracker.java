package com.transsion.push.tracker;

import ak.b;
import ak.c;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.transsion.core.deviceinfo.DeviceInfo;
import com.transsion.core.utils.a;
import com.transsion.push.PushManager;
import com.transsion.push.bean.PushPointInfo;
import com.transsion.push.bean.PushRequest;
import com.transsion.push.bean.TrackerResponse;
import com.transsion.push.config.PushRepository;
import com.transsion.push.db.h;
import com.transsion.push.tracker.Tracker;
import com.transsion.push.utils.PushLogUtils;
import com.transsion.push.utils.PushUtils;
import com.transsion.push.utils.ThreadManager;
import com.transsion.push.utils.g0;
import com.transsion.push.utils.k;
import com.transsion.push.utils.m;
import com.transsion.push.utils.o;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
final class PushTracker {
    private static PushTracker b;
    private Context a;

    private PushTracker() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject e() {
        JSONObject jSONObject;
        JSONException e;
        try {
            jSONObject = new JSONObject();
        } catch (JSONException e3) {
            jSONObject = null;
            e = e3;
        }
        try {
            jSONObject.put("app_id", PushUtils.e());
            jSONObject.put("app_ver", a.c());
            jSONObject.put("app_ver_code", a.b());
            jSONObject.put("gaid", DeviceInfo.e());
            jSONObject.put("pkg_name", a.a());
            jSONObject.put("sdk_ver", "2.0.2.01");
            jSONObject.put("sdk_ver_code", 17004);
            jSONObject.put("tz", k.c());
            jSONObject.put("country", Locale.getDefault().getCountry());
            String str = Build.BRAND;
            if (!TextUtils.isEmpty(str)) {
                str = str.toUpperCase().replace(" ", "");
            }
            jSONObject.put("brand", str);
            jSONObject.put("mcc", k.d());
            jSONObject.put("mnc", k.d());
            jSONObject.put("device_type", k.h(this.a) ? "pad" : "phone");
            jSONObject.put("android_ver", Build.VERSION.RELEASE);
            jSONObject.put("os_ver", Build.VERSION.SDK_INT);
        } catch (JSONException e4) {
            e = e4;
            e.printStackTrace();
            return jSONObject;
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject f(Tracker.KEY key, Bundle bundle) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        try {
            jSONObject = new JSONObject();
        } catch (JSONException e) {
            e = e;
        }
        try {
            jSONObject.put("name", key.event);
            jSONObject.put("ts", System.currentTimeMillis());
            jSONObject.put("network_type", o.b());
            if (bundle != null && !bundle.isEmpty()) {
                JSONObject jSONObject3 = new JSONObject();
                for (String str : bundle.keySet()) {
                    jSONObject3.put(str, bundle.get(str));
                }
                jSONObject.put("extra", jSONObject3);
                return jSONObject;
            }
            return jSONObject;
        } catch (JSONException e3) {
            e = e3;
            jSONObject2 = jSONObject;
            e.printStackTrace();
            return jSONObject2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(JSONObject jSONObject, List list) {
        if (jSONObject == null || list == null || list.size() <= 0) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(new JSONObject(((PushPointInfo) it.next()).evt));
            }
            jSONObject.put("evt", jSONArray);
            String jSONObject2 = jSONObject.toString();
            PushLogUtils.LOG.g("request body:" + jSONObject2);
            String str = PushManager.getInstance().getTestEnv() ? "https://test-tracking.twibida.com/v1/sdk/point/report" : PushManager.getInstance().getDebug() ? "https://mi-pre.shalltry.com/tcm/v1/sdk/point/report" : "https://tracking.twibida.com/v1/sdk/point/report";
            PushLogUtils.LOG.g("request url:" + str);
            b bVar = new b();
            c cVar = new c("MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKEaYIhDF/GSQZagVqAOo7UU/GqDjQBU5muTCS6qPMfAdtKOzbhRpNCJA/ZmgBxPhc8RVLPO9yiJn5g+hy+tz3cCAwEAAQ==");
            PushRequest pushRequest = new PushRequest();
            String c = bVar.c(bVar.e(jSONObject2));
            String c2 = bVar.c(cVar.d(bVar.i()));
            pushRequest.data = c;
            pushRequest.key = c2;
            byte[] c3 = m.c(str, com.transsion.json.b.b(pushRequest).getBytes());
            if (c3 == null) {
                PushLogUtils.LOG.i("the response data is empty");
                return;
            }
            TrackerResponse trackerResponse = (TrackerResponse) com.transsion.json.b.a(new String(c3), TrackerResponse.class);
            if (trackerResponse != null && trackerResponse.config != null) {
                PushLogUtils.LOG.g("post points response:" + trackerResponse);
                if (trackerResponse.status == 200) {
                    PushRepository.getInstance().putSpValue("is_immediately_tracker", Boolean.valueOf(trackerResponse.config.reportType == 0));
                    PushRepository.getInstance().putSpValue("tracker_report_interval", Long.valueOf(trackerResponse.config.reportTime));
                    PushRepository.getInstance().putSpValue("tracker_report_time", Long.valueOf(System.currentTimeMillis() + g0.f()));
                    h.b().a(list);
                    return;
                }
                PushLogUtils.LOG.i("post points response status error, status:" + trackerResponse.status + ", " + trackerResponse.message);
                return;
            }
            PushLogUtils.LOG.i("parse post points BaseResponse failed");
        } catch (Exception e) {
            PushLogUtils.LOG.i("post points Exception: " + e.getMessage());
        }
    }

    public static PushTracker getInstance() {
        if (b == null) {
            b = new PushTracker();
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject2);
            jSONObject.put("evt", jSONArray);
            String jSONObject3 = jSONObject.toString();
            PushLogUtils.LOG.g("request body:" + jSONObject3);
            String str = PushManager.getInstance().getTestEnv() ? "https://test-tracking.twibida.com/v1/sdk/point/report" : PushManager.getInstance().getDebug() ? "https://mi-pre.shalltry.com/tcm/v1/sdk/point/report" : "https://tracking.twibida.com/v1/sdk/point/report";
            PushLogUtils.LOG.g("request url:" + str);
            b bVar = new b();
            c cVar = new c("MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKEaYIhDF/GSQZagVqAOo7UU/GqDjQBU5muTCS6qPMfAdtKOzbhRpNCJA/ZmgBxPhc8RVLPO9yiJn5g+hy+tz3cCAwEAAQ==");
            PushRequest pushRequest = new PushRequest();
            String c = bVar.c(bVar.e(jSONObject3));
            String c2 = bVar.c(cVar.d(bVar.i()));
            pushRequest.data = c;
            pushRequest.key = c2;
            byte[] c3 = m.c(str, com.transsion.json.b.b(pushRequest).getBytes());
            if (c3 == null) {
                PushLogUtils.LOG.i("the response data is empty");
                h.b().c(jSONObject2.toString());
                return;
            }
            TrackerResponse trackerResponse = (TrackerResponse) com.transsion.json.b.a(new String(c3), TrackerResponse.class);
            if (trackerResponse == null) {
                PushLogUtils.LOG.i("parse post point BaseResponse failed");
                h.b().c(jSONObject2.toString());
                return;
            }
            PushLogUtils.LOG.g("post point response:" + trackerResponse);
            if (trackerResponse.status == 200) {
                PushRepository.getInstance().putSpValue("is_immediately_tracker", Boolean.valueOf(trackerResponse.config.reportType == 0));
                PushRepository.getInstance().putSpValue("tracker_report_interval", Long.valueOf(trackerResponse.config.reportTime));
                return;
            }
            PushLogUtils.LOG.i("post point response status error, status:" + trackerResponse.status + ", " + trackerResponse.message);
            h.b().c(jSONObject2.toString());
        } catch (Exception e) {
            PushLogUtils.LOG.i("post point Exception: " + e.getMessage());
            h.b().c(jSONObject2.toString());
        }
    }

    void i(Tracker.KEY key, Bundle bundle) {
        boolean booleanValue = ((Boolean) PushRepository.getInstance().getSpValue("push_start_point_report", Boolean.FALSE)).booleanValue();
        PushLogUtils.LOG.g("push tracker isStartPointReport:" + booleanValue + ", key:" + key.event);
        if (booleanValue) {
            ThreadManager.executeInBackground(new 1(this, key, bundle));
        }
    }

    public void tracks() {
        boolean booleanValue = ((Boolean) PushRepository.getInstance().getSpValue("push_start_point_report", Boolean.FALSE)).booleanValue();
        PushLogUtils.LOG.g("push trackers isStartPointReport:" + booleanValue);
        if (!booleanValue) {
            PushLogUtils.LOG.g("check tracker report");
        } else if (PushUtils.t()) {
            PushLogUtils.LOG.g("check tracker report");
            ThreadManager.executeInBackground(new 2(this));
        }
    }
}
