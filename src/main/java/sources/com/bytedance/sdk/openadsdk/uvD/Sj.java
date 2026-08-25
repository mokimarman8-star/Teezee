package com.bytedance.sdk.openadsdk.uvD;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.utils.sU;
import com.cloud.tmc.integration.audio.recording.RecorderConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Sj implements Comparable<Sj> {
    private int HiB;
    private int Jcg;
    private int TKC;
    private final String sP;
    private long sef;
    private final ArrayList<Long> Sj = new ArrayList<>();
    private final ArrayList<Long> EjP = new ArrayList<>();
    private final ArrayList<Long> vS = new ArrayList<>();
    private final ArrayList<Long> Dq = new ArrayList<>();
    private final HashMap<String, sP> uA = new HashMap<>();
    private int TEQ = 0;
    private int Ym = 0;
    private final HashMap<String, sP> aa = new HashMap<>();
    private int Fmk = 0;
    private final ArrayList<String> Zq = new ArrayList<>();

    public Sj(String str) {
        this.sP = str;
    }

    private void Sj(String str, JSONObject jSONObject, ArrayList<Long> arrayList, int[] iArr, long j, JSONObject jSONObject2) throws JSONException {
        int size = arrayList.size() - 1;
        int i = 0;
        for (int i2 : iArr) {
            long j2 = j - (i2 * RecorderConstants.DEFAULT_RECORD_DURATION);
            while (size >= 0 && arrayList.get(size).longValue() >= j2) {
                i++;
                size--;
            }
            if (i != 0) {
                jSONObject.put(str + i2, i);
                int optInt = jSONObject2.optInt(str + i2) + i;
                if (optInt != 0) {
                    jSONObject2.put(str + i2, optInt);
                }
            }
        }
        while (size >= 0) {
            arrayList.remove(0);
            size--;
        }
    }

    private void Sj(@NonNull JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        int i;
        int i2;
        int i3;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Sj("show_c_", jSONObject, this.Sj, com.bytedance.sdk.openadsdk.vS.Sj.Sj().uA(), elapsedRealtime, jSONObject2);
        Sj("click_c_", jSONObject, this.EjP, com.bytedance.sdk.openadsdk.vS.Sj.Sj().TEQ(), elapsedRealtime, jSONObject2);
        Sj("v_play_c_", jSONObject, this.vS, com.bytedance.sdk.openadsdk.vS.Sj.Sj().Ym(), elapsedRealtime, jSONObject2);
        Sj("dislike_c_", jSONObject, this.Dq, com.bytedance.sdk.openadsdk.vS.Sj.Sj().uvD(), elapsedRealtime, jSONObject2);
        if (com.bytedance.sdk.openadsdk.vS.Sj.Sj().vS() && (i3 = this.TKC) != 0) {
            jSONObject.put("show_c_s", i3);
            int optInt = jSONObject2.optInt("show_c_s") + this.TKC;
            if (optInt != 0) {
                jSONObject2.put("show_c_s", optInt);
            }
        }
        if (com.bytedance.sdk.openadsdk.vS.Sj.Sj().Jcg() && (i2 = this.HiB) != 0) {
            jSONObject.put("click_c_s", i2);
            int optInt2 = jSONObject2.optInt("click_c_s") + this.HiB;
            if (optInt2 != 0) {
                jSONObject2.put("click_c_s", optInt2);
            }
        }
        if (!com.bytedance.sdk.openadsdk.vS.Sj.Sj().Dq() || (i = this.Jcg) == 0) {
            return;
        }
        jSONObject.put("v_play_c_s", i);
        int optInt3 = jSONObject2.optInt("v_play_c_s") + this.Jcg;
        if (optInt3 != 0) {
            jSONObject2.put("v_play_c_s", optInt3);
        }
    }

    private void sP(@NonNull JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        int i;
        int i2;
        int i3;
        long j;
        HashSet hashSet;
        HashSet hashSet2;
        HashSet hashSet3;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        int[] aa = com.bytedance.sdk.openadsdk.vS.Sj.Sj().aa();
        long j2 = RecorderConstants.DEFAULT_RECORD_DURATION;
        if (aa != null) {
            int i4 = 0;
            while (i4 < aa.length) {
                int i8 = aa[i4];
                long j3 = elapsedRealtime - (i8 * j2);
                Iterator<String> it = this.aa.keySet().iterator();
                long j4 = 0;
                while (it.hasNext()) {
                    String next = it.next();
                    Iterator<String> it2 = it;
                    sP sPVar = this.aa.get(next);
                    if (sPVar != null) {
                        long Sj = sPVar.Sj(j3, elapsedRealtime);
                        j4 += Sj;
                        if (Sj <= 0 && i4 == aa.length - 1) {
                            hashSet4.add(next);
                        }
                    }
                    it = it2;
                }
                if (j4 != 0) {
                    jSONObject.put("lp_stay_t_".concat(String.valueOf(i8)), j4);
                    hashSet2 = hashSet4;
                    hashSet3 = hashSet5;
                    long optInt = jSONObject2.optInt("lp_stay_t_".concat(String.valueOf(i8))) + j4;
                    if (optInt != 0) {
                        jSONObject2.put("lp_stay_t_".concat(String.valueOf(i8)), optInt);
                    }
                } else {
                    hashSet2 = hashSet4;
                    hashSet3 = hashSet5;
                }
                i4++;
                hashSet4 = hashSet2;
                hashSet5 = hashSet3;
                j2 = RecorderConstants.DEFAULT_RECORD_DURATION;
            }
        }
        HashSet hashSet6 = hashSet4;
        HashSet hashSet7 = hashSet5;
        int[] Fmk = com.bytedance.sdk.openadsdk.vS.Sj.Sj().Fmk();
        if (Fmk != null) {
            int i9 = 0;
            while (i9 < Fmk.length) {
                int i10 = Fmk[i9];
                long j8 = elapsedRealtime - (i10 * RecorderConstants.DEFAULT_RECORD_DURATION);
                Iterator<String> it3 = this.uA.keySet().iterator();
                int i11 = 0;
                long j9 = 0;
                while (it3.hasNext()) {
                    String next2 = it3.next();
                    Iterator<String> it4 = it3;
                    sP sPVar2 = this.uA.get(next2);
                    if (sPVar2 != null) {
                        long Sj2 = sPVar2.Sj(j8, elapsedRealtime);
                        j9 += Sj2;
                        if (Sj2 > 20000) {
                            i11++;
                        }
                        if (Sj2 <= 0 && i9 == Fmk.length - 1) {
                            hashSet = hashSet7;
                            hashSet.add(next2);
                            hashSet7 = hashSet;
                            it3 = it4;
                        }
                    }
                    hashSet = hashSet7;
                    hashSet7 = hashSet;
                    it3 = it4;
                }
                HashSet hashSet8 = hashSet7;
                if (j9 != 0) {
                    jSONObject.put("v_stay_t_".concat(String.valueOf(i10)), j9);
                    j = elapsedRealtime;
                    long optInt2 = jSONObject2.optInt("v_stay_t_".concat(String.valueOf(i10))) + j9;
                    if (optInt2 != 0) {
                        jSONObject2.put("v_stay_t_".concat(String.valueOf(i10)), optInt2);
                    }
                } else {
                    j = elapsedRealtime;
                }
                if (i11 != 0) {
                    jSONObject.put("v_20s_play_c_".concat(String.valueOf(i10)), i11);
                    int optInt3 = jSONObject2.optInt("v_20s_play_c_".concat(String.valueOf(i10))) + i11;
                    if (optInt3 != 0) {
                        jSONObject2.put("v_20s_play_c_".concat(String.valueOf(i10)), optInt3);
                    }
                }
                i9++;
                hashSet7 = hashSet8;
                elapsedRealtime = j;
            }
        }
        HashSet hashSet9 = hashSet7;
        if (!hashSet6.isEmpty()) {
            Iterator it5 = hashSet6.iterator();
            while (it5.hasNext()) {
                this.aa.remove((String) it5.next());
            }
        }
        if (!hashSet9.isEmpty()) {
            Iterator it6 = hashSet9.iterator();
            while (it6.hasNext()) {
                this.uA.remove((String) it6.next());
            }
        }
        if (com.bytedance.sdk.openadsdk.vS.Sj.Sj().Zq() && (i3 = this.TEQ) != 0) {
            jSONObject.put("v_stay_t_s", i3);
            int optInt4 = jSONObject2.optInt("v_stay_t_s") + this.TEQ;
            if (optInt4 != 0) {
                jSONObject2.put("v_stay_t_s", optInt4);
            }
        }
        if (com.bytedance.sdk.openadsdk.vS.Sj.Sj().sef() && (i2 = this.Fmk) != 0) {
            jSONObject.put("lp_stay_t_s", i2);
            int optInt5 = jSONObject2.optInt("lp_stay_t_s") + this.Fmk;
            if (optInt5 != 0) {
                jSONObject2.put("lp_stay_t_s", optInt5);
            }
        }
        if (!com.bytedance.sdk.openadsdk.vS.Sj.Sj().dNu() || (i = this.Ym) == 0) {
            return;
        }
        jSONObject.put("v_30p_play_c_s", i);
        int optInt6 = jSONObject2.optInt("v_30p_play_c_s") + this.Ym;
        if (optInt6 != 0) {
            jSONObject2.put("v_30p_play_c_s", optInt6);
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
    public int compareTo(Sj sj) {
        return sj.TKC - this.TKC;
    }

    public JSONObject Sj(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            Sj(jSONObject2, jSONObject);
            sP(jSONObject2, jSONObject);
        } catch (Throwable th) {
            sU.sP(th.getMessage(), new Object[0]);
        }
        return jSONObject2;
    }

    public void Sj() {
        this.sef = SystemClock.elapsedRealtime();
        this.Ym = 0;
        this.HiB = 0;
        this.TKC = 0;
        this.Fmk = 0;
        this.TEQ = 0;
        this.Jcg = 0;
    }

    public void Sj(@NonNull String str, @Nullable String str2) {
        sP sPVar;
        sP sPVar2;
        sP sPVar3;
        sP sPVar4;
        sP sPVar5;
        sP sPVar6;
        str.hashCode();
        switch (str) {
            case "landingContinue":
                if (!TextUtils.isEmpty(str2) && (sPVar = this.aa.get(str2)) != null) {
                    sPVar.EjP(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "landingPause":
                if (!TextUtils.isEmpty(str2) && (sPVar2 = this.aa.get(str2)) != null) {
                    sPVar2.TKC(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "landingStart":
                if (!TextUtils.isEmpty(str2) && this.aa.get(str2) == null) {
                    sP sPVar7 = new sP();
                    this.aa.put(str2, sPVar7);
                    sPVar7.Sj(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "feed_over":
            case "feed_break":
            case "videoForceBreak":
            case "play_error":
                if (!TextUtils.isEmpty(str2) && (sPVar3 = this.uA.get(str2)) != null && sPVar3.Sj() != sP.HiB) {
                    sPVar3.sP(SystemClock.elapsedRealtime());
                    if (com.bytedance.sdk.openadsdk.vS.Sj.Sj().Zq()) {
                        this.TEQ = (int) (this.TEQ + sPVar3.Sj(this.sef, SystemClock.elapsedRealtime()));
                        break;
                    }
                }
                break;
            case "feed_play":
                this.vS.add(Long.valueOf(SystemClock.elapsedRealtime()));
                if (com.bytedance.sdk.openadsdk.vS.Sj.Sj().Dq()) {
                    this.Jcg++;
                }
                if (!TextUtils.isEmpty(str2) && this.uA.get(str2) == null) {
                    sP sPVar8 = new sP();
                    this.uA.put(str2, sPVar8);
                    sPVar8.Sj(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "show":
                this.Sj.add(Long.valueOf(SystemClock.elapsedRealtime()));
                if (com.bytedance.sdk.openadsdk.vS.Sj.Sj().vS()) {
                    this.TKC++;
                    break;
                }
                break;
            case "click":
                if (!this.Zq.contains(str2)) {
                    if (this.Zq.size() > 50) {
                        this.Zq.subList(0, 25).clear();
                    }
                    this.Zq.add(str2);
                    this.EjP.add(Long.valueOf(SystemClock.elapsedRealtime()));
                    if (com.bytedance.sdk.openadsdk.vS.Sj.Sj().Jcg()) {
                        this.HiB++;
                        break;
                    }
                }
                break;
            case "feed_continue":
                if (!TextUtils.isEmpty(str2) && (sPVar4 = this.uA.get(str2)) != null) {
                    sPVar4.EjP(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "feed_pause":
                if (!TextUtils.isEmpty(str2) && (sPVar5 = this.uA.get(str2)) != null) {
                    sPVar5.TKC(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "landingFinish":
                if (!TextUtils.isEmpty(str2) && (sPVar6 = this.aa.get(str2)) != null && sPVar6.Sj() != sP.HiB) {
                    sPVar6.sP(SystemClock.elapsedRealtime());
                    if (com.bytedance.sdk.openadsdk.vS.Sj.Sj().sef()) {
                        this.Fmk = (int) (this.Fmk + sPVar6.Sj(this.sef, SystemClock.elapsedRealtime()));
                        break;
                    }
                }
                break;
            case "videoPercent30":
                if (com.bytedance.sdk.openadsdk.vS.Sj.Sj().dNu()) {
                    this.Ym++;
                    break;
                }
                break;
            case "dislike":
                this.Dq.add(Long.valueOf(SystemClock.elapsedRealtime()));
                break;
        }
    }

    public String sP() {
        return this.sP;
    }
}
