package com.bytedance.sdk.openadsdk.vS;

import com.bytedance.sdk.openadsdk.core.TKC;
import com.bytedance.sdk.openadsdk.core.sef;
import com.cloud.tmc.ad.TaErrorCode;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Sj {
    private static volatile Sj Sj;
    private int[] Dq;
    private boolean EjP;
    private boolean Fmk;
    private int[] HiB;
    private int[] Jcg;
    private boolean TEQ;
    private boolean TKC;
    private boolean Ym;
    private int Zq;
    private int[] aa;
    private boolean dNu;
    private boolean sP;
    private boolean sef;
    private int[] uA;
    private boolean uvD;
    private int[] vS;

    private Sj() {
        sP();
    }

    public static Sj Sj() {
        if (Sj == null) {
            synchronized (TKC.class) {
                try {
                    if (Sj == null) {
                        Sj = new Sj();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return Sj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Sj(String[] strArr) {
        if (strArr.length == 2) {
            return "session".equals(strArr[1]);
        }
        if (strArr.length == 1) {
            return "session".equals(strArr[0]);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] TKC(String[] strArr) {
        int length = strArr.length;
        int[] iArr = new int[length];
        int i = 0;
        for (String str : strArr) {
            try {
                int parseInt = Integer.parseInt(str);
                iArr[i] = parseInt;
                if (parseInt > 0) {
                    i++;
                }
            } catch (NumberFormatException unused) {
            }
        }
        if (i == length) {
            return iArr;
        }
        int[] iArr2 = new int[i];
        System.arraycopy(iArr, 0, iArr2, 0, i);
        return iArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] sP(String[] strArr) {
        return strArr.length > 0 ? TKC(strArr[0].split(",")) : new int[0];
    }

    public boolean Dq() {
        return this.EjP;
    }

    public int EjP() {
        return this.Zq;
    }

    public int[] Fmk() {
        return this.uA;
    }

    public boolean HiB() {
        return this.uvD;
    }

    public boolean Jcg() {
        return this.TKC;
    }

    public int[] TEQ() {
        return this.vS;
    }

    public boolean TKC() {
        return this.sef;
    }

    public boolean TzV() {
        return this.dNu;
    }

    public int[] Ym() {
        return this.Jcg;
    }

    public boolean Zq() {
        return this.Ym;
    }

    public int[] aa() {
        return this.Dq;
    }

    public boolean dNu() {
        return this.Fmk;
    }

    public void sP() {
        sef.sP().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.vS.Sj.1
            @Override // java.lang.Runnable
            public void run() {
                Sj.this.sef = com.bytedance.sdk.openadsdk.dx.Sj.Sj("feature_switch", false);
                if (Sj.this.sef) {
                    try {
                        Sj.this.dNu = com.bytedance.sdk.openadsdk.dx.Sj.Sj("exclude_banner_native", false);
                        Sj.this.Zq = com.bytedance.sdk.openadsdk.dx.Sj.Sj("feature_timer_interval", TaErrorCode.UNKNOWN_ERROR_CODE);
                        Sj.this.uvD = com.bytedance.sdk.openadsdk.dx.Sj.Sj("enable_feature_cids", true);
                        String[] split = com.bytedance.sdk.openadsdk.dx.Sj.Sj("pag_ad_show_cnt", "1,3,5&session").split("&");
                        String[] split2 = com.bytedance.sdk.openadsdk.dx.Sj.Sj("pag_ad_click_cnt", "1,3,5&session").split("&");
                        String[] split3 = com.bytedance.sdk.openadsdk.dx.Sj.Sj("pag_video_play_cnt", "1,3,5&session").split("&");
                        String[] split4 = com.bytedance.sdk.openadsdk.dx.Sj.Sj("pag_dislike_cnt", "1,3,5session").split(",");
                        Sj sj = Sj.this;
                        sj.sP = sj.Sj(split);
                        Sj sj2 = Sj.this;
                        sj2.TKC = sj2.Sj(split2);
                        Sj sj3 = Sj.this;
                        sj3.EjP = sj3.Sj(split3);
                        Sj sj4 = Sj.this;
                        sj4.HiB = sj4.sP(split);
                        Sj sj5 = Sj.this;
                        sj5.vS = sj5.sP(split2);
                        Sj sj6 = Sj.this;
                        sj6.Jcg = sj6.sP(split3);
                        Sj sj7 = Sj.this;
                        sj7.aa = sj7.TKC(split4);
                        String[] split5 = com.bytedance.sdk.openadsdk.dx.Sj.Sj("pag_landingPage_stay_time", "1,3,5&session").split("&");
                        String[] split6 = com.bytedance.sdk.openadsdk.dx.Sj.Sj("pag_video_stay_time", "1,3,5&session").split("&");
                        Sj sj8 = Sj.this;
                        sj8.TEQ = sj8.Sj(split5);
                        Sj sj9 = Sj.this;
                        sj9.Ym = sj9.Sj(split6);
                        Sj sj10 = Sj.this;
                        sj10.Dq = sj10.sP(split5);
                        Sj sj11 = Sj.this;
                        sj11.uA = sj11.sP(split6);
                        Sj.this.Fmk = com.bytedance.sdk.openadsdk.dx.Sj.Sj("pag_video_30p_session", true);
                    } catch (Throwable unused) {
                    }
                }
            }
        });
    }

    public boolean sef() {
        return this.TEQ;
    }

    public int[] uA() {
        return this.HiB;
    }

    public int[] uvD() {
        return this.aa;
    }

    public boolean vS() {
        return this.sP;
    }
}
