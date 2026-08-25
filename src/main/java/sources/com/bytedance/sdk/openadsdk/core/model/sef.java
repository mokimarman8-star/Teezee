package com.bytedance.sdk.openadsdk.core.model;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.sP.TKC;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class sef implements com.bytedance.sdk.component.adexpress.TKC {
    public final int Dq;
    public final float EjP;
    public JSONObject Fmk;
    public final long HiB;
    public final int Jcg;
    public final float Sj;
    public final int TEQ;
    public final float TKC;
    public boolean TzV;
    public final String Ym;
    public final boolean Zq;
    public int aa;
    public JSONObject dNu;
    public final float sP;
    public SparseArray<TKC.Sj> sef;
    public final int uA;
    public int uvD;
    public final long vS;

    public static class Sj {
        private int Dq;
        private float EjP;
        private int Fmk;
        private float HiB;
        private float Jcg;
        private int TEQ;
        private long TKC;
        private boolean TzV;
        private int Ym;
        private int Zq;
        private String aa;
        private long sP;
        private JSONObject sef;
        private int uA;
        private JSONObject uvD;
        private float vS;
        private boolean dNu = false;
        protected SparseArray<TKC.Sj> Sj = new SparseArray<>();

        public Sj EjP(float f) {
            this.Jcg = f;
            return this;
        }

        public Sj EjP(int i) {
            this.uA = i;
            return this;
        }

        public Sj HiB(int i) {
            this.TEQ = i;
            return this;
        }

        public Sj Sj(float f) {
            this.EjP = f;
            return this;
        }

        public Sj Sj(int i) {
            this.Zq = i;
            return this;
        }

        public Sj Sj(long j) {
            this.sP = j;
            return this;
        }

        public Sj Sj(SparseArray<TKC.Sj> sparseArray) {
            this.Sj = sparseArray;
            return this;
        }

        public Sj Sj(String str) {
            this.aa = str;
            return this;
        }

        public Sj Sj(JSONObject jSONObject) {
            this.sef = jSONObject;
            return this;
        }

        public Sj Sj(boolean z) {
            this.TzV = z;
            return this;
        }

        public sef Sj() {
            return new sef(this);
        }

        public Sj TKC(float f) {
            this.vS = f;
            return this;
        }

        public Sj TKC(int i) {
            this.Dq = i;
            return this;
        }

        public Sj sP(float f) {
            this.HiB = f;
            return this;
        }

        public Sj sP(int i) {
            this.Fmk = i;
            return this;
        }

        public Sj sP(long j) {
            this.TKC = j;
            return this;
        }

        public Sj sP(JSONObject jSONObject) {
            this.uvD = jSONObject;
            return this;
        }

        public Sj sP(boolean z) {
            this.dNu = z;
            return this;
        }

        public Sj vS(int i) {
            this.Ym = i;
            return this;
        }
    }

    private sef(@NonNull Sj sj) {
        this.TzV = false;
        this.Sj = sj.Jcg;
        this.sP = sj.vS;
        this.TKC = sj.HiB;
        this.EjP = sj.EjP;
        this.HiB = sj.TKC;
        this.vS = sj.sP;
        this.Jcg = sj.Dq;
        this.Dq = sj.uA;
        this.uA = sj.TEQ;
        this.TEQ = sj.Ym;
        this.Ym = sj.aa;
        this.sef = sj.Sj;
        this.Zq = sj.TzV;
        this.aa = sj.Fmk;
        this.Fmk = sj.sef;
        this.uvD = sj.Zq;
        this.dNu = sj.uvD;
        this.TzV = sj.dNu;
    }
}
