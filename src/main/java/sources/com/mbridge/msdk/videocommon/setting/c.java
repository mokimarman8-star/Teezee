package com.mbridge.msdk.videocommon.setting;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.foundation.tools.i0;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class c {
    private static g W;
    public static String X;
    private int E;
    private int G;
    private JSONArray U;
    private JSONObject V;
    private String a;
    private String b;
    private List<com.mbridge.msdk.videocommon.entity.b> c;
    private long d;
    private ArrayList<Integer> t;
    private int e = -1;
    private int f = 0;
    private int g = 0;
    private int h = 1;
    private int i = 1;
    private int j = 1;
    private int k = 1;
    private int l = 5;
    private int m = 1;
    private int n = 3;
    private int o = 80;
    private int p = 100;
    private int q = 0;
    private double r = 1.0d;
    private int s = -1;
    private int u = 3;
    private int v = 1;
    private int w = 100;
    private int x = 60;
    private int y = 0;
    private int z = 70;
    private int A = 0;
    private int B = -1;
    private int C = -1;
    private int D = -1;
    private int F = 20;
    private int H = 0;
    private int I = 1;
    private String J = TtmlNode.ANONYMOUS_REGION_ID;
    private int K = 1;
    private String L = TtmlNode.ANONYMOUS_REGION_ID;
    private int M = 1;
    private String N = "Virtual Item";
    private String O = TtmlNode.ANONYMOUS_REGION_ID;
    private String P = TtmlNode.ANONYMOUS_REGION_ID;
    private int Q = 0;
    private int R = 1;
    private int S = 60;
    private String T = TtmlNode.ANONYMOUS_REGION_ID;

    public static c a(String str) {
        JSONObject optJSONObject;
        if (W == null) {
            W = g.a(com.mbridge.msdk.foundation.controller.c.m().d());
        }
        c cVar = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("vtag", TtmlNode.ANONYMOUS_REGION_ID);
                String optString2 = jSONObject.optString("rid", TtmlNode.ANONYMOUS_REGION_ID);
                JSONArray optJSONArray = jSONObject.optJSONArray("unitSetting");
                if (optJSONArray == null || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
                    return null;
                }
                String optString3 = optJSONObject.optString("unitId");
                if (TextUtils.isEmpty(optString3)) {
                    return null;
                }
                c cVar2 = new c();
                try {
                    cVar2.j(optString);
                    cVar2.g(optString2);
                    List<com.mbridge.msdk.videocommon.entity.b> a = com.mbridge.msdk.videocommon.entity.b.a(optJSONObject.optJSONArray("adSourceList"));
                    cVar2.h(optString3);
                    cVar2.a(a);
                    cVar2.h(optJSONObject.optInt("callbackType"));
                    int optInt = optJSONObject.optInt("aqn", 1);
                    if (optInt <= 0) {
                        optInt = 1;
                    }
                    cVar2.e(optInt);
                    int optInt2 = optJSONObject.optInt("acn", 1);
                    if (optInt2 < 0) {
                        optInt2 = 1;
                    }
                    cVar2.b(optInt2);
                    cVar2.E(optJSONObject.optInt("vcn", 5));
                    cVar2.u(optJSONObject.optInt("offset", 5));
                    cVar2.n(optJSONObject.optInt("dlnet", 1));
                    cVar2.o(optJSONObject.optInt("endscreen_type", 2));
                    cVar2.D(optJSONObject.optInt("tv_start", 3));
                    cVar2.C(optJSONObject.optInt("tv_end", 80));
                    cVar2.y(optJSONObject.optInt(CampaignEx.JSON_KEY_READY_RATE, 100));
                    cVar2.i(optJSONObject.optInt("cd_rate", 0));
                    cVar2.a(jSONObject.optLong("current_time"));
                    cVar2.A(optJSONObject.optInt("orientation", 0));
                    cVar2.m(optJSONObject.optInt("daily_play_cap", 0));
                    cVar2.I(optJSONObject.optInt("video_skip_time", -1));
                    cVar2.H(optJSONObject.optInt("video_skip_result", 2));
                    cVar2.G(optJSONObject.optInt("video_interactive_type", -1));
                    cVar2.k(optJSONObject.optInt("close_button_delay", 1));
                    cVar2.w(optJSONObject.optInt("playclosebtn_tm", -1));
                    cVar2.v(optJSONObject.optInt("play_ctdown", 0));
                    cVar2.j(optJSONObject.optInt("close_alert", 0));
                    cVar2.x(optJSONObject.optInt("rdrct", 20));
                    cVar2.p(optJSONObject.optInt("load_global_timeout", 70));
                    cVar2.z(optJSONObject.optInt("rfpv", -1));
                    cVar2.a(optJSONObject.optDouble("vdcmp", 1.0d));
                    cVar2.c(optJSONObject.optString("atzu"));
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("atl_type");
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    try {
                        if (optJSONArray2 != null) {
                            for (int i = 0; i < optJSONArray2.length(); i++) {
                                arrayList.add(Integer.valueOf(optJSONArray2.getInt(i)));
                            }
                        } else {
                            arrayList.add(4);
                            arrayList.add(6);
                        }
                        cVar2.a(arrayList);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    int optInt3 = optJSONObject.optInt("atl_dyt", 0);
                    cVar2.f(optInt3 > 0 ? optInt3 : 3);
                    int optInt4 = optJSONObject.optInt("tmorl", 1);
                    if (optInt4 > 2 || optInt4 <= 0) {
                        optInt4 = 1;
                    }
                    cVar2.B(optInt4);
                    cVar2.f(optJSONObject.optString("placementid"));
                    cVar2.s(optJSONObject.optInt("ltafemty", 10));
                    cVar2.t(optJSONObject.optInt("ltorwc", 60));
                    cVar2.b(optJSONObject.optString("ab_id"));
                    cVar2.d(optJSONObject.optInt(RewardPlus.AMOUNT_MAX, 0));
                    cVar2.g(optJSONObject.optInt(RewardPlus.CALLBACK_RULE, 1));
                    cVar2.i(optJSONObject.optString(RewardPlus.VIRTUAL_CURRENCY, TtmlNode.ANONYMOUS_REGION_ID));
                    cVar2.c(optJSONObject.optInt(RewardPlus.AMOUNT, 1));
                    cVar2.d(optJSONObject.optString(RewardPlus.ICON, TtmlNode.ANONYMOUS_REGION_ID));
                    cVar2.l(optJSONObject.optInt(RewardPlus.CURRENCY_ID, 1));
                    cVar2.e(optJSONObject.optString(RewardPlus.NAME, "Virtual Item"));
                    cVar2.F(optJSONObject.optInt("video_error_rule", 1));
                    cVar2.r(optJSONObject.optInt("loadtmo", 60));
                    cVar2.a(optJSONObject.optJSONArray("local_cache_info"));
                    try {
                        String optString4 = optJSONObject.optString("retry_strategy");
                        if (!TextUtils.isEmpty(optString4)) {
                            String a2 = i0.a(optString4);
                            if (!TextUtils.isEmpty(a2)) {
                                cVar2.b(new JSONObject(a2));
                            }
                        }
                    } catch (Exception unused) {
                    }
                    return cVar2;
                } catch (Exception e2) {
                    e = e2;
                    cVar = cVar2;
                    e.printStackTrace();
                    return cVar;
                }
            } catch (Exception e3) {
                e = e3;
            }
        }
        return cVar;
    }

    public static c a(JSONObject jSONObject) {
        c cVar;
        c cVar2 = null;
        if (jSONObject == null) {
            return null;
        }
        try {
            cVar = new c();
        } catch (Exception e) {
            e = e;
        }
        try {
            cVar.a(com.mbridge.msdk.videocommon.entity.b.a(jSONObject.optJSONArray("adSourceList")));
            cVar.h(jSONObject.optInt("callbackType"));
            int optInt = jSONObject.optInt("aqn", 1);
            if (optInt <= 0) {
                optInt = 1;
            }
            cVar.e(optInt);
            int optInt2 = jSONObject.optInt("acn", 1);
            if (optInt2 < 0) {
                optInt2 = 1;
            }
            cVar.b(optInt2);
            cVar.E(jSONObject.optInt("vcn", 5));
            cVar.u(jSONObject.optInt("offset", 5));
            cVar.n(jSONObject.optInt("dlnet", 1));
            cVar.o(jSONObject.optInt("endscreen_type", 2));
            cVar.D(jSONObject.optInt("tv_start", 3));
            cVar.C(jSONObject.optInt("tv_end", 80));
            cVar.y(jSONObject.optInt(CampaignEx.JSON_KEY_READY_RATE, 100));
            cVar.a(jSONObject.optLong("current_time"));
            cVar.A(jSONObject.optInt("orientation", 0));
            cVar.m(jSONObject.optInt("daily_play_cap", 0));
            cVar.I(jSONObject.optInt("video_skip_time", -1));
            cVar.H(jSONObject.optInt("video_skip_result", 2));
            cVar.G(jSONObject.optInt("video_interactive_type", -1));
            cVar.k(jSONObject.optInt("close_button_delay", 1));
            cVar.w(jSONObject.optInt("playclosebtn_tm", -1));
            cVar.v(jSONObject.optInt("play_ctdown", 0));
            cVar.j(jSONObject.optInt("close_alert", 0));
            cVar.x(jSONObject.optInt("rdrct", 20));
            cVar.z(jSONObject.optInt("rfpv", -1));
            cVar.a(jSONObject.optDouble("vdcmp", 1.0d));
            cVar.p(jSONObject.optInt("load_global_timeout", 70));
            JSONArray optJSONArray = jSONObject.optJSONArray("atl_type");
            ArrayList<Integer> arrayList = new ArrayList<>();
            try {
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        arrayList.add(Integer.valueOf(optJSONArray.getInt(i)));
                    }
                } else {
                    arrayList.add(4);
                    arrayList.add(6);
                }
                cVar.a(arrayList);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            cVar.f(jSONObject.optInt("atl_dyt", 3));
            int optInt3 = jSONObject.optInt("tmorl", 1);
            if (optInt3 > 2 || optInt3 <= 0) {
                optInt3 = 1;
            }
            cVar.B(optInt3);
            cVar.f(jSONObject.optString("placementid"));
            cVar.s(jSONObject.optInt("ltafemty", 10));
            cVar.t(jSONObject.optInt("ltorwc", 60));
            cVar.b(jSONObject.optString("ab_id"));
            cVar.g(jSONObject.optString("rid", TtmlNode.ANONYMOUS_REGION_ID));
            cVar.d(jSONObject.optInt(RewardPlus.AMOUNT_MAX, 0));
            cVar.g(jSONObject.optInt(RewardPlus.CALLBACK_RULE, 1));
            cVar.i(jSONObject.optString(RewardPlus.VIRTUAL_CURRENCY, TtmlNode.ANONYMOUS_REGION_ID));
            cVar.c(jSONObject.optInt(RewardPlus.AMOUNT, 1));
            cVar.d(jSONObject.optString(RewardPlus.ICON, TtmlNode.ANONYMOUS_REGION_ID));
            cVar.l(jSONObject.optInt(RewardPlus.CURRENCY_ID, 1));
            cVar.e(jSONObject.optString(RewardPlus.NAME, "Virtual Item"));
            cVar.F(jSONObject.optInt("video_error_rule", 1));
            cVar.r(jSONObject.optInt("loadtmo", 60));
            cVar.j(jSONObject.optString("vtag", TtmlNode.ANONYMOUS_REGION_ID));
            cVar.a(jSONObject.optJSONArray("local_cache_info"));
            try {
                String optString = jSONObject.optString("retry_strategy");
                if (!TextUtils.isEmpty(optString)) {
                    String a = i0.a(optString);
                    if (!TextUtils.isEmpty(a)) {
                        cVar.b(new JSONObject(a));
                    }
                }
            } catch (Exception unused) {
            }
            return cVar;
        } catch (Exception e3) {
            e = e3;
            cVar2 = cVar;
            e.printStackTrace();
            return cVar2;
        }
    }

    public int A() {
        return this.v;
    }

    public void A(int i) {
        this.y = i;
    }

    public JSONArray B() {
        return this.U;
    }

    public void B(int i) {
        this.v = i;
    }

    public int C() {
        return this.R;
    }

    public void C(int i) {
        this.o = i;
    }

    public int D() {
        return this.D;
    }

    public void D(int i) {
        this.n = i;
    }

    public int E() {
        return this.C;
    }

    public void E(int i) {
        this.k = i;
    }

    public int F() {
        return this.B;
    }

    public void F(int i) {
        this.R = i;
    }

    public String G() {
        return this.T;
    }

    public void G(int i) {
        this.D = i;
    }

    public JSONObject H() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("unitId", this.a);
            jSONObject.put("callbackType", this.h);
            List<com.mbridge.msdk.videocommon.entity.b> list = this.c;
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (com.mbridge.msdk.videocommon.entity.b bVar : this.c) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("id", bVar.a());
                    jSONObject2.put("timeout", bVar.b());
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("adSourceList", jSONArray);
            }
            jSONObject.put("aqn", this.i);
            jSONObject.put("acn", this.j);
            jSONObject.put("vcn", this.k);
            jSONObject.put("offset", this.l);
            jSONObject.put("dlnet", this.m);
            jSONObject.put("tv_start", this.n);
            jSONObject.put("tv_end", this.o);
            jSONObject.put(CampaignEx.JSON_KEY_READY_RATE, this.p);
            jSONObject.put("endscreen_type", this.G);
            jSONObject.put("daily_play_cap", this.A);
            jSONObject.put("video_skip_time", this.B);
            jSONObject.put("video_skip_result", this.C);
            jSONObject.put("video_interactive_type", this.D);
            jSONObject.put("orientation", this.y);
            jSONObject.put("close_button_delay", this.E);
            jSONObject.put("playclosebtn_tm", this.e);
            jSONObject.put("play_ctdown", this.f);
            jSONObject.put("close_alert", this.g);
            jSONObject.put("rfpv", this.s);
            jSONObject.put("vdcmp", this.r);
            JSONArray jSONArray2 = new JSONArray();
            ArrayList<Integer> arrayList = this.t;
            if (arrayList != null) {
                if (arrayList.size() > 0) {
                    Iterator<Integer> it = this.t.iterator();
                    while (it.hasNext()) {
                        jSONArray2.put(it.next());
                    }
                }
                jSONObject.put("atl_type", jSONArray2);
            }
            jSONObject.put("atl_dyt", this.u);
            jSONObject.put("tmorl", this.v);
            jSONObject.put("placementid", this.b);
            jSONObject.put("ltafemty", this.w);
            jSONObject.put("ltorwc", this.x);
            jSONObject.put(RewardPlus.AMOUNT_MAX, this.H);
            jSONObject.put(RewardPlus.CALLBACK_RULE, this.I);
            jSONObject.put(RewardPlus.VIRTUAL_CURRENCY, this.J);
            jSONObject.put(RewardPlus.AMOUNT, this.K);
            jSONObject.put(RewardPlus.ICON, this.L);
            jSONObject.put(RewardPlus.CURRENCY_ID, this.M);
            jSONObject.put(RewardPlus.NAME, this.N);
            jSONObject.put("isDefault", this.Q);
            jSONObject.put("video_error_rule", this.R);
            jSONObject.put("loadtmo", this.S);
            jSONObject.put("vtag", this.T);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public void H(int i) {
        this.C = i;
    }

    public void I(int i) {
        this.B = i;
    }

    public String a() {
        return this.O;
    }

    public void a(double d) {
        this.r = d;
    }

    public void a(long j) {
        this.d = j;
    }

    public void a(ArrayList<Integer> arrayList) {
        this.t = arrayList;
    }

    public void a(List<com.mbridge.msdk.videocommon.entity.b> list) {
        this.c = list;
    }

    public void a(JSONArray jSONArray) {
        this.U = jSONArray;
    }

    public boolean a(int i) {
        ArrayList<Integer> arrayList = this.t;
        if (arrayList == null || arrayList.size() <= 0) {
            return false;
        }
        return this.t.contains(Integer.valueOf(i));
    }

    public int b() {
        return this.j;
    }

    public void b(int i) {
        this.j = i;
    }

    public void b(String str) {
        this.O = str;
        com.mbridge.msdk.foundation.controller.a.r.put(this.a, str);
    }

    public void b(JSONObject jSONObject) {
        this.V = jSONObject;
    }

    public String c() {
        return X;
    }

    public void c(int i) {
        if (i <= 0) {
            this.K = 1;
        } else {
            this.K = i;
        }
    }

    public void c(String str) {
        X = str;
    }

    public int d() {
        return this.K;
    }

    public void d(int i) {
        this.H = i;
    }

    public void d(String str) {
        this.L = str;
    }

    public int e() {
        return this.i;
    }

    public void e(int i) {
        this.i = i;
    }

    public void e(String str) {
        if (TextUtils.isEmpty(str)) {
            this.N = this.J;
        } else {
            this.N = str;
        }
    }

    public int f() {
        return this.u;
    }

    public void f(int i) {
        this.u = i;
    }

    public void f(String str) {
        this.b = str;
    }

    public int g() {
        return this.q;
    }

    public void g(int i) {
        this.I = i;
    }

    public void g(String str) {
        this.P = str;
    }

    public int h() {
        return this.g;
    }

    public void h(int i) {
        this.h = i;
    }

    public void h(String str) {
        this.a = str;
    }

    public int i() {
        return this.E;
    }

    public void i(int i) {
        this.q = i;
    }

    public void i(String str) {
        this.J = str;
    }

    public long j() {
        return this.d;
    }

    public void j(int i) {
        this.g = i;
    }

    public void j(String str) {
        this.T = str;
    }

    public int k() {
        return this.A;
    }

    public void k(int i) {
        this.E = i;
    }

    public int l() {
        return this.m;
    }

    public void l(int i) {
        this.M = i;
    }

    public int m() {
        return this.G;
    }

    public void m(int i) {
        this.A = i;
    }

    public int n() {
        return this.z;
    }

    public void n(int i) {
        this.m = i;
    }

    public int o() {
        return this.S;
    }

    public void o(int i) {
        this.G = i;
    }

    public int p() {
        return this.w;
    }

    public void p(int i) {
        this.z = i;
    }

    public int q() {
        return this.x;
    }

    public void q(int i) {
        this.Q = i;
    }

    public int r() {
        return this.l;
    }

    public void r(int i) {
        this.S = i;
    }

    public String s() {
        return this.N;
    }

    public void s(int i) {
        this.w = i;
    }

    public String t() {
        return this.b;
    }

    public void t(int i) {
        this.x = i;
    }

    public int u() {
        return this.e;
    }

    public void u(int i) {
        this.l = i;
    }

    public int v() {
        return this.F;
    }

    public void v(int i) {
        this.f = i;
    }

    public int w() {
        return this.p;
    }

    public void w(int i) {
        this.e = i;
    }

    public String x() {
        return this.P;
    }

    public void x(int i) {
        this.F = i;
    }

    public int y() {
        return this.y;
    }

    public void y(int i) {
        this.p = i;
    }

    public Queue<Integer> z() {
        LinkedList linkedList;
        Exception e;
        List<com.mbridge.msdk.videocommon.entity.b> list;
        try {
            list = this.c;
        } catch (Exception e2) {
            linkedList = null;
            e = e2;
        }
        if (list == null || list.size() <= 0) {
            return null;
        }
        linkedList = new LinkedList();
        for (int i = 0; i < this.c.size(); i++) {
            try {
                linkedList.add(Integer.valueOf(this.c.get(i).b()));
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                return linkedList;
            }
        }
        return linkedList;
    }

    public void z(int i) {
        this.s = i;
    }
}
