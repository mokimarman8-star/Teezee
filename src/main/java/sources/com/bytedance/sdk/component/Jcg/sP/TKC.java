package com.bytedance.sdk.component.Jcg.sP;

import android.text.TextUtils;
import com.bytedance.sdk.component.sP.Sj.Fmk;
import com.bytedance.sdk.component.sP.Sj.Ym;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class TKC {
    String HiB;
    protected Ym TKC;
    int vS;
    protected String EjP = null;
    protected final Map<String, String> Jcg = new HashMap();
    protected String Dq = null;
    protected boolean uA = false;

    public TKC(Ym ym) {
        this.TKC = ym;
        try {
            TKC(UUID.randomUUID().toString());
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public String EjP() {
        return this.Dq;
    }

    public void EjP(Map<String, String> map) {
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.Jcg.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public void Sj(int i) {
        this.vS = i;
    }

    protected void Sj(Fmk.Sj sj) {
        if (sj != null && this.Jcg.size() > 0) {
            for (Map.Entry<String, String> entry : this.Jcg.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    String value = entry.getValue();
                    if (value == null) {
                        value = "";
                    }
                    sj.sP(key, value);
                }
            }
        }
    }

    public void Sj(String str) {
        this.HiB = str;
    }

    public String TKC() {
        return this.EjP;
    }

    public void TKC(String str) {
        this.EjP = str;
    }

    public void sP() {
        Ym ym;
        if (this.EjP == null || (ym = this.TKC) == null) {
            return;
        }
        com.bytedance.sdk.component.sP.Sj.EjP Sj = ym.Sj();
        synchronized (Sj) {
            try {
                for (com.bytedance.sdk.component.sP.Sj.sP sPVar : Sj.TKC()) {
                    if (this.EjP.equals(sPVar.Sj().Sj())) {
                        sPVar.TKC();
                    }
                }
                for (com.bytedance.sdk.component.sP.Sj.sP sPVar2 : Sj.EjP()) {
                    if (this.EjP.equals(sPVar2.Sj().Sj())) {
                        sPVar2.TKC();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void sP(String str) {
        this.Dq = str;
    }

    public void sP(String str, String str2) {
        this.Jcg.put(str, str2);
    }
}
