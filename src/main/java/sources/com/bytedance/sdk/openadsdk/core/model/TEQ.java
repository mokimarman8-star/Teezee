package com.bytedance.sdk.openadsdk.core.model;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.sP.TKC;
import com.cloud.tmc.integration.event.EventConstants;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class TEQ {
    private final float Dq;
    private final int[] EjP;
    private final int Fmk;
    private final float HiB;
    private final float Jcg;
    private final JSONObject RiZ;
    private final int[] Sj;
    private final long TEQ;
    private final int[] TKC;
    private final String TzV;
    private final int Ym;
    private final SparseArray<TKC.Sj> Zq;
    private final int aa;
    private final JSONObject dNu;
    private final int[] sP;
    private final int sef;
    private final long uA;
    private final int uvD;
    private final float vS;

    public static class Sj {
        private float Dq;
        private long EjP;
        private int[] Fmk;
        private long HiB;
        private float Jcg;
        private String RiZ;
        float Sj;
        private int[] TEQ;
        float TKC;
        private int TzV;
        private int[] Ym;
        private int Zq;
        private int[] aa;
        private SparseArray<TKC.Sj> dNu;
        private JSONObject dx;
        int sP;
        private int sU;
        private int sef;
        private float uA;
        private int uvD;
        private float vS;
        private JSONObject zR;

        public Sj EjP(float f) {
            this.Jcg = f;
            return this;
        }

        public Sj EjP(int i) {
            this.sef = i;
            return this;
        }

        public Sj EjP(int[] iArr) {
            this.Fmk = iArr;
            return this;
        }

        public Sj HiB(float f) {
            this.Dq = f;
            return this;
        }

        public Sj HiB(int i) {
            this.Zq = i;
            return this;
        }

        public Sj Sj(float f) {
            this.Sj = f;
            return this;
        }

        public Sj Sj(int i) {
            this.sU = i;
            return this;
        }

        public Sj Sj(long j) {
            this.EjP = j;
            return this;
        }

        public Sj Sj(SparseArray<TKC.Sj> sparseArray) {
            this.dNu = sparseArray;
            return this;
        }

        public Sj Sj(String str) {
            this.RiZ = str;
            return this;
        }

        public Sj Sj(JSONObject jSONObject) {
            this.dx = jSONObject;
            return this;
        }

        public Sj Sj(int[] iArr) {
            this.TEQ = iArr;
            return this;
        }

        public TEQ Sj() {
            return new TEQ(this);
        }

        public Sj TKC(float f) {
            this.vS = f;
            return this;
        }

        public Sj TKC(int i) {
            this.sP = i;
            return this;
        }

        public Sj TKC(int[] iArr) {
            this.aa = iArr;
            return this;
        }

        public Sj sP(float f) {
            this.TKC = f;
            return this;
        }

        public Sj sP(int i) {
            this.TzV = i;
            return this;
        }

        public Sj sP(long j) {
            this.HiB = j;
            return this;
        }

        public Sj sP(JSONObject jSONObject) {
            this.zR = jSONObject;
            return this;
        }

        public Sj sP(int[] iArr) {
            this.Ym = iArr;
            return this;
        }

        public Sj vS(float f) {
            this.uA = f;
            return this;
        }

        public Sj vS(int i) {
            this.uvD = i;
            return this;
        }
    }

    private TEQ(@NonNull Sj sj) {
        this.Sj = sj.Ym;
        this.sP = sj.aa;
        this.EjP = sj.Fmk;
        this.TKC = sj.TEQ;
        this.HiB = sj.uA;
        this.vS = sj.Dq;
        this.Jcg = sj.Jcg;
        this.Dq = sj.vS;
        this.uA = sj.HiB;
        this.TEQ = sj.EjP;
        this.Ym = sj.sef;
        this.aa = sj.Zq;
        this.Fmk = sj.uvD;
        this.sef = sj.TzV;
        this.Zq = sj.dNu;
        this.TzV = sj.RiZ;
        this.uvD = sj.sU;
        this.dNu = sj.dx;
        this.RiZ = sj.zR;
    }

    public static JSONObject Sj(SparseArray<TKC.Sj> sparseArray, int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (sparseArray != null) {
                for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                    TKC.Sj valueAt = sparseArray.valueAt(i2);
                    if (valueAt != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.putOpt("force", Double.valueOf(valueAt.TKC)).putOpt("mr", Double.valueOf(valueAt.sP)).putOpt("phase", Integer.valueOf(valueAt.Sj)).putOpt("ts", Long.valueOf(valueAt.EjP));
                        jSONArray.put(jSONObject2);
                        jSONObject.putOpt("ftc", Integer.valueOf(i)).putOpt("info", jSONArray);
                    }
                }
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public JSONObject Sj() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = this.RiZ;
            if (jSONObject2 != null) {
                try {
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        jSONObject.putOpt(next, this.RiZ.opt(next));
                    }
                } catch (Exception unused) {
                }
            }
            int[] iArr = this.Sj;
            if (iArr != null && iArr.length == 2) {
                jSONObject.putOpt("ad_x", Integer.valueOf(iArr[0])).putOpt("ad_y", Integer.valueOf(this.Sj[1]));
            }
            int[] iArr2 = this.sP;
            if (iArr2 != null && iArr2.length == 2) {
                jSONObject.putOpt("width", Integer.valueOf(iArr2[0])).putOpt("height", Integer.valueOf(this.sP[1]));
            }
            int[] iArr3 = this.TKC;
            if (iArr3 != null && iArr3.length == 2) {
                jSONObject.putOpt("button_x", Integer.valueOf(iArr3[0])).putOpt("button_y", Integer.valueOf(this.TKC[1]));
            }
            int[] iArr4 = this.EjP;
            if (iArr4 != null && iArr4.length == 2) {
                jSONObject.putOpt("button_width", Integer.valueOf(iArr4[0])).putOpt("button_height", Integer.valueOf(this.EjP[1]));
            }
            jSONObject.putOpt("down_x", Float.toString(this.HiB)).putOpt("down_y", Float.toString(this.vS)).putOpt("up_x", Float.toString(this.Jcg)).putOpt("up_y", Float.toString(this.Dq)).putOpt("down_time", Long.valueOf(this.uA)).putOpt("up_time", Long.valueOf(this.TEQ)).putOpt("toolType", Integer.valueOf(this.Ym)).putOpt("deviceId", Integer.valueOf(this.aa)).putOpt(EventConstants.KEY_SOURCE, Integer.valueOf(this.Fmk)).putOpt("ft", Sj(this.Zq, this.sef)).putOpt("click_area_type", this.TzV);
            int i = this.uvD;
            if (i > 0) {
                jSONObject.putOpt("areaType", Integer.valueOf(i));
            }
            JSONObject jSONObject3 = this.dNu;
            if (jSONObject3 != null) {
                jSONObject.putOpt("rectInfo", jSONObject3);
            }
        } catch (Exception unused2) {
        }
        return jSONObject;
    }
}
