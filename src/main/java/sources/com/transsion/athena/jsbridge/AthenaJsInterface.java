package com.transsion.athena.jsbridge;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.transsion.athena.config.data.model.ehanat;
import com.transsion.athena.data.athena;
import com.transsion.athena.taaneh.aethna;
import com.transsion.athena.taaneh.anehat;
import com.transsion.athena.taaneh.ehatna;
import com.transsion.gslb.BuildConfig;
import hi.a;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class AthenaJsInterface {
    private final Context a;

    public AthenaJsInterface(Context context) {
        this.a = context;
    }

    @JavascriptInterface
    public String getAccountId() {
        return ehanat.b();
    }

    @JavascriptInterface
    public String getAppIds() {
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator<Integer> it = athena.a().iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            return jSONArray.toString();
        } catch (Exception e) {
            aethna.b(Log.getStackTraceString(e));
            return "[]";
        }
    }

    @JavascriptInterface
    public String getGAID() {
        return anehat.a();
    }

    @JavascriptInterface
    public long getRealTime() {
        try {
            return com.transsion.athena.ehatna.aethna.b().a(System.currentTimeMillis(), SystemClock.elapsedRealtime());
        } catch (Exception e) {
            aethna.b(Log.getStackTraceString(e));
            return System.currentTimeMillis();
        }
    }

    @JavascriptInterface
    public String getVAID() {
        try {
            return ehatna.a();
        } catch (Exception e) {
            aethna.b(Log.getStackTraceString(e));
            return BuildConfig.FLAVOR;
        }
    }

    @JavascriptInterface
    public void track(int i, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("track appid = ");
        sb.append(i);
        sb.append(", eventName = ");
        sb.append(str);
        try {
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject(str2);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                bundle.putString(next, jSONObject.get(next).toString());
            }
            new a(str, i).c(bundle, null).b();
        } catch (Exception e) {
            aethna.b(Log.getStackTraceString(e));
        }
    }
}
