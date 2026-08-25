package com.facebook.biddingkit.logging;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.cloud.tmc.kernel.bridge.SendToNativeCallback;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class e {
    private String a;
    private String b;
    private final Map c = new HashMap();
    private String d;

    class a extends AsyncTask {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(e... eVarArr) {
            f.g(eVarArr[0]);
            return null;
        }
    }

    public void a(String str) {
        this.b = str;
    }

    public void b(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        Map map = (Map) this.c.get(str);
        if (map == null) {
            map = new HashMap();
            this.c.put(str, map);
        }
        map.put("cpm_cents", str2);
    }

    protected void c(String str) {
        this.a = str;
    }

    public void d(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        Map map = (Map) this.c.get(str);
        if (map == null) {
            map = new HashMap();
            this.c.put(str, map);
        }
        map.put(SendToNativeCallback.KEY_CODE, str2);
    }

    public void e(String str) {
        this.d = str;
    }

    public void f(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        Map map = (Map) this.c.get(str);
        if (map == null) {
            map = new HashMap();
            this.c.put(str, map);
        }
        map.put("latency_ms", str2);
    }

    public void g(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        Map map = (Map) this.c.get(str);
        if (map == null) {
            map = new HashMap();
            this.c.put(str, map);
        }
        map.put("result", str2);
    }

    protected JSONObject h() {
        JSONObject jSONObject = new JSONObject();
        Iterator it = this.c.entrySet().iterator();
        while (it.hasNext()) {
            String str = (String) ((Map.Entry) it.next()).getKey();
            jSONObject.put(str, j(str));
        }
        return jSONObject;
    }

    protected String i() {
        return TextUtils.isEmpty(this.b) ? "" : this.b;
    }

    protected JSONObject j(String str) {
        JSONObject jSONObject = new JSONObject();
        if (!this.c.containsKey(str)) {
            return jSONObject;
        }
        for (Map.Entry entry : ((Map) this.c.get(str)).entrySet()) {
            if ("cpm_cents".equals(entry.getKey())) {
                jSONObject.put((String) entry.getKey(), Double.parseDouble((String) entry.getValue()));
            } else if ("latency_ms".equals(entry.getKey())) {
                jSONObject.put((String) entry.getKey(), Long.parseLong((String) entry.getValue()));
            } else {
                jSONObject.put((String) entry.getKey(), entry.getValue());
            }
        }
        return jSONObject;
    }

    protected String k() {
        return this.a;
    }

    protected String l() {
        return TextUtils.isEmpty(this.d) ? "" : this.d;
    }

    protected JSONObject m() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.b)) {
                jSONObject.put("auction_id", this.b);
            }
            if (!TextUtils.isEmpty(this.d)) {
                jSONObject.put("exception", this.d);
            }
            Iterator it = this.c.entrySet().iterator();
            while (it.hasNext()) {
                String str = (String) ((Map.Entry) it.next()).getKey();
                jSONObject.put(str, j(str));
            }
        } catch (JSONException e) {
            b.d("EventLog", "Failed to create json data", e);
        }
        return jSONObject;
    }

    public void n() {
        new a().execute(this);
    }
}
