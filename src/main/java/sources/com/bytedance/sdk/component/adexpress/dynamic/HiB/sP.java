package com.bytedance.sdk.component.adexpress.dynamic.HiB;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.sP.Fmk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class sP {
    private String Dq;
    private double HiB;
    private double Jcg;
    private Fmk uA;
    private int vS;
    public Map<String, TKC> Sj = new HashMap();
    public Map<String, TKC> sP = new HashMap();
    public Map<String, TKC> TKC = new HashMap();
    private double EjP = Math.random();

    static class Sj implements Cloneable {
        float Sj;
        float TKC;
        boolean sP;

        Sj() {
        }

        public Object clone() {
            try {
                return (Sj) super.clone();
            } catch (CloneNotSupportedException unused) {
                return null;
            }
        }
    }

    static class TKC {
        float Sj;
        float sP;

        public TKC() {
        }

        public TKC(float f, float f2) {
            this.Sj = f;
            this.sP = f2;
        }

        public String toString() {
            return "UnitSize{width=" + this.Sj + ", height=" + this.sP + '}';
        }
    }

    /* renamed from: com.bytedance.sdk.component.adexpress.dynamic.HiB.sP$sP, reason: collision with other inner class name */
    static class C0044sP {
        double EjP;
        float HiB;
        float Sj;
        int TKC;
        int sP;

        C0044sP() {
        }

        static JSONObject Sj(C0044sP c0044sP) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("fontSize", c0044sP.Sj);
                jSONObject.put("letterSpacing", c0044sP.sP);
                jSONObject.put("lineHeight", c0044sP.EjP);
                jSONObject.put("maxWidth", c0044sP.HiB);
                jSONObject.put("fontWeight", c0044sP.TKC);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
    }

    public sP(double d, int i, double d2, String str, Fmk fmk) {
        this.HiB = d;
        this.vS = i;
        this.Jcg = d2;
        this.Dq = str;
        this.uA = fmk;
    }

    private String EjP(List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            String TKC2 = list.get(i).TKC();
            if (i < list.size() - 1) {
                sb.append(TKC2);
                sb.append("-");
            } else {
                sb.append(TKC2);
            }
        }
        return sb.toString();
    }

    private void EjP(com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq) {
        this.Sj.remove(HiB(dq));
        List<List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq>> dNu = dq.dNu();
        if (dNu == null || dNu.size() <= 0) {
            return;
        }
        Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq>> it = dNu.iterator();
        while (it.hasNext()) {
            TKC(it.next());
        }
    }

    private TKC HiB(com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq, float f, float f2) {
        String str = dq.TKC() + "_" + f + "_" + f2;
        if (this.TKC.containsKey(str)) {
            return this.TKC.get(str);
        }
        TKC vS = vS(dq, f, f2);
        this.TKC.put(str, vS);
        return vS;
    }

    private String HiB(com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq) {
        return dq.TKC();
    }

    private TKC Sj(String str, C0044sP c0044sP, boolean z, boolean z2, int i, com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq) {
        return Ym.Sj(str, dq.TEQ().sP(), C0044sP.Sj(c0044sP).toString(), z, z2, i, dq, this.HiB, this.vS, this.Jcg, this.Dq, this.uA);
    }

    private void Sj(com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq, TKC tkc) {
        this.Sj.put(HiB(dq), tkc);
    }

    private void Sj(List<List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq>> list, float f, float f2) {
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq>> it = list.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (Sj(it.next(), false)) {
                z = true;
            }
        }
        ArrayList arrayList = new ArrayList();
        for (List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq> list2 : list) {
            Sj sj = new Sj();
            boolean Sj2 = Sj(list2, !z);
            sj.Sj = Sj2 ? 1.0f : sP(list2, f, f2).sP;
            sj.sP = !Sj2;
            arrayList.add(sj);
        }
        List<Sj> Sj3 = TEQ.Sj(f2, arrayList);
        for (int i = 0; i < list.size(); i++) {
            if (((Sj) arrayList.get(i)).Sj != Sj3.get(i).Sj) {
                List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq> list3 = list.get(i);
                TKC(list3);
                sP(list3, f, Sj3.get(i).Sj);
            }
        }
    }

    private void Sj(List<Sj> list, float f, List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq> list2) {
        float f2 = 0.0f;
        for (Sj sj : list) {
            if (sj.sP) {
                f2 += sj.Sj;
            }
        }
        if (f2 > f) {
            int i = 0;
            for (int i2 = 0; i2 < list2.size(); i2++) {
                if (list.get(i2).sP && list2.get(i2).zR()) {
                    i++;
                }
            }
            if (i > 0) {
                float ceil = (float) (Math.ceil(((f2 - f) / i) * 1000.0f) / 1000.0d);
                for (int i3 = 0; i3 < list2.size(); i3++) {
                    Sj sj2 = list.get(i3);
                    if (sj2.sP && list2.get(i3).zR()) {
                        sj2.Sj -= ceil;
                    }
                }
            }
        }
    }

    private void Sj(List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq> list, TKC tkc) {
        this.sP.put(EjP(list), tkc);
    }

    private boolean Sj(List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq> list, boolean z) {
        for (com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq : list) {
            com.bytedance.sdk.component.adexpress.dynamic.EjP.vS HiB = dq.TEQ().HiB();
            String ley = HiB.ley();
            if (TextUtils.equals(ley, "flex") || (z && ((TextUtils.equals(HiB.LqL(), "flex") && TextUtils.equals(HiB.ley(), "scale") && com.bytedance.sdk.component.adexpress.dynamic.EjP.HiB.Sj.get(dq.TEQ().sP()).intValue() == 7) || TextUtils.equals(ley, "flex")))) {
                return true;
            }
        }
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq> it = list.iterator();
        while (it.hasNext()) {
            if (TKC(it.next())) {
                return true;
            }
        }
        return false;
    }

    private TKC TKC(List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq> list, float f, float f2) {
        float f3;
        EjP(list);
        TKC tkc = new TKC();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq : list) {
            com.bytedance.sdk.component.adexpress.dynamic.EjP.vS HiB = dq.TEQ().HiB();
            if (HiB.EZ() == 1 || HiB.EZ() == 2) {
                arrayList.add(dq);
            }
            if (HiB.EZ() != 1 && HiB.EZ() != 2) {
                arrayList2.add(dq);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            TKC((com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq) it.next(), f, f2);
        }
        if (arrayList2.size() <= 0) {
            return tkc;
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq> it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            arrayList3.add(Float.valueOf(TKC(it2.next(), f, f2).Sj));
        }
        ArrayList arrayList4 = new ArrayList();
        int i = 0;
        while (true) {
            if (i >= arrayList2.size()) {
                break;
            }
            com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq2 = arrayList2.get(i);
            String LqL = dq2.TEQ().HiB().LqL();
            float Dq = dq2.Dq();
            boolean equals = TextUtils.equals(LqL, "flex");
            if (TextUtils.equals(LqL, "auto")) {
                List<List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq>> dNu = dq2.dNu();
                if (dNu != null && dNu.size() > 0) {
                    Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq>> it3 = dNu.iterator();
                    while (it3.hasNext()) {
                        if (sP(it3.next())) {
                            equals = true;
                            break;
                        }
                    }
                }
                equals = false;
            }
            Sj sj = new Sj();
            if (!equals) {
                Dq = ((Float) arrayList3.get(i)).floatValue();
            }
            sj.Sj = Dq;
            sj.sP = !equals;
            if (equals) {
                f3 = ((Float) arrayList3.get(i)).floatValue();
            }
            sj.TKC = f3;
            arrayList4.add(sj);
            i++;
        }
        Sj(arrayList4, f, arrayList2);
        List<Sj> Sj2 = TEQ.Sj(f, arrayList4);
        float f4 = 0.0f;
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            f4 += Sj2.get(i2).Sj;
            if (((Float) arrayList3.get(i2)).floatValue() != Sj2.get(i2).Sj) {
                EjP(arrayList2.get(i2));
            }
        }
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq> it4 = arrayList2.iterator();
        int i3 = 0;
        boolean z = false;
        while (true) {
            if (!it4.hasNext()) {
                break;
            }
            i3++;
            if (!sP(it4.next())) {
                z = false;
                break;
            }
            if (i3 == arrayList2.size()) {
                z = true;
            }
        }
        f3 = z ? f2 : 0.0f;
        ArrayList arrayList5 = new ArrayList();
        for (int i4 = 0; i4 < arrayList2.size(); i4++) {
            com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq3 = arrayList2.get(i4);
            TKC TKC2 = TKC(dq3, Sj2.get(i4).Sj, f2);
            if (!sP(dq3)) {
                f3 = Math.max(f3, TKC2.sP);
            }
            arrayList5.add(TKC2);
        }
        ArrayList arrayList6 = new ArrayList();
        Iterator it5 = arrayList5.iterator();
        while (it5.hasNext()) {
            arrayList6.add(Float.valueOf(((TKC) it5.next()).sP));
        }
        if (!z) {
            for (int i8 = 0; i8 < arrayList2.size(); i8++) {
                com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq4 = arrayList2.get(i8);
                if (sP(dq4) && ((Float) arrayList6.get(i8)).floatValue() != f3) {
                    EjP(dq4);
                    TKC(dq4, Sj2.get(i8).Sj, f3);
                }
            }
        }
        tkc.Sj = f4;
        tkc.sP = f3;
        return tkc;
    }

    private void TKC(List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.sP.remove(EjP(list));
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq> it = list.iterator();
        while (it.hasNext()) {
            EjP(it.next());
        }
    }

    private boolean TKC(com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq) {
        List<List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq>> dNu;
        if (!dq.TzV() && TextUtils.equals(dq.TEQ().HiB().ley(), "auto") && (dNu = dq.dNu()) != null && dNu.size() > 0) {
            if (dNu.size() == 1) {
                Iterator<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq> it = dNu.get(0).iterator();
                while (it.hasNext()) {
                    if (!sP(it.next())) {
                        return false;
                    }
                }
                return true;
            }
            Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq>> it2 = dNu.iterator();
            while (it2.hasNext()) {
                if (Sj(it2.next(), true)) {
                    return true;
                }
            }
        }
        return false;
    }

    private TKC sP(List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq> list, float f, float f2) {
        TKC Sj2 = Sj(list);
        if (Sj2 != null && (Sj2.Sj != 0.0f || Sj2.sP != 0.0f)) {
            return Sj2;
        }
        TKC TKC2 = TKC(list, f, f2);
        Sj(list, TKC2);
        return TKC2;
    }

    private boolean sP(com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq) {
        if (dq == null) {
            return false;
        }
        if (TextUtils.equals(dq.TEQ().HiB().ley(), "flex")) {
            return true;
        }
        return TKC(dq);
    }

    private boolean sP(List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq> list) {
        List<List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq>> dNu;
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().TEQ().HiB().LqL(), "flex")) {
                return true;
            }
        }
        while (true) {
            boolean z = false;
            for (com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq : list) {
                if (TextUtils.equals(dq.TEQ().HiB().LqL(), "auto") && (dNu = dq.dNu()) != null) {
                    int i = 0;
                    for (List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq> list2 : dNu) {
                        i++;
                        if (!sP(list2)) {
                            break;
                        }
                        if (i == list2.size()) {
                            z = true;
                        }
                    }
                }
            }
            return z;
        }
    }

    private TKC vS(com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq, float f, float f2) {
        new TKC();
        com.bytedance.sdk.component.adexpress.dynamic.EjP.vS HiB = dq.TEQ().HiB();
        dq.TEQ().TKC();
        HiB.MuB();
        float TzV = HiB.TzV();
        int sdp = HiB.sdp();
        double dwU = HiB.dwU();
        int IOh = HiB.IOh();
        boolean HpB = HiB.HpB();
        boolean pfr = HiB.pfr();
        int xhi = HiB.xhi();
        C0044sP c0044sP = new C0044sP();
        c0044sP.Sj = TzV;
        c0044sP.sP = sdp;
        c0044sP.TKC = IOh;
        c0044sP.EjP = dwU;
        c0044sP.HiB = f;
        return Sj(dq.TEQ().TKC(), c0044sP, HpB, pfr, xhi, dq);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0120  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TKC EjP(com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq, float f, float f2) {
        float min;
        Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq>> it;
        TKC tkc = new TKC();
        float f3 = 0.0f;
        if (f2 <= 0.0f || f <= 0.0f) {
            tkc.Sj = 0.0f;
            tkc.sP = 0.0f;
            return tkc;
        }
        if (dq.TzV()) {
            return Sj(dq, f, f2);
        }
        float Dq = dq.Dq();
        float uA = dq.uA();
        float Zq = dq.Zq();
        float uvD = dq.uvD();
        com.bytedance.sdk.component.adexpress.dynamic.EjP.vS HiB = dq.TEQ().HiB();
        String LqL = HiB.LqL();
        String ley = HiB.ley();
        float min2 = ((TextUtils.equals(LqL, "flex") || TextUtils.equals(LqL, "auto")) ? f : Math.min(Dq, f)) - Zq;
        if (!TextUtils.equals(ley, "scale")) {
            if (!TextUtils.equals(ley, "auto") && !TextUtils.equals(ley, "flex")) {
                min = Math.min(uA, f2);
                float f4 = min - uvD;
                List<List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq>> dNu = dq.dNu();
                it = dNu.iterator();
                float f8 = 0.0f;
                float f9 = 0.0f;
                while (it.hasNext()) {
                }
                TKC tkc2 = tkc;
                if (TextUtils.equals(LqL, "auto")) {
                }
                if (TextUtils.equals(ley, "auto")) {
                }
                tkc2.Sj = Math.min(min2 + Zq, f);
                tkc2.sP = Math.min(f4 + uvD, f2);
                return tkc2;
            }
            min = f2;
            float f42 = min - uvD;
            List<List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq>> dNu2 = dq.dNu();
            it = dNu2.iterator();
            float f82 = 0.0f;
            float f92 = 0.0f;
            while (it.hasNext()) {
            }
            TKC tkc22 = tkc;
            if (TextUtils.equals(LqL, "auto")) {
            }
            if (TextUtils.equals(ley, "auto")) {
            }
            tkc22.Sj = Math.min(min2 + Zq, f);
            tkc22.sP = Math.min(f42 + uvD, f2);
            return tkc22;
        }
        min = Math.round(min2 / uA) + uvD;
        if (min > f2) {
            min2 = Math.round((f2 - uvD) * uA);
            min = f2;
        }
        float f422 = min - uvD;
        List<List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq>> dNu22 = dq.dNu();
        it = dNu22.iterator();
        float f822 = 0.0f;
        float f922 = 0.0f;
        while (it.hasNext()) {
            Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq>> it2 = it;
            List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq> next = it.next();
            TKC tkc3 = tkc;
            TKC sP = sP(next, min2, f422);
            if (sP(next)) {
                f3 += 1.0f;
            } else {
                f822 = Math.max(f822, sP.Sj);
            }
            float f10 = f3;
            f922 = dq.TEQ().sP().equals("carousel") ? Math.max(dq.uA(), sP.sP) : f922 + sP.sP;
            tkc = tkc3;
            it = it2;
            f3 = f10;
        }
        TKC tkc222 = tkc;
        if (TextUtils.equals(LqL, "auto")) {
            if (f3 == dNu22.size()) {
                min2 = f;
            } else {
                for (List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq> list : dNu22) {
                    TKC(list);
                    sP(list, f822, f422);
                }
                min2 = f822;
            }
        }
        if (TextUtils.equals(ley, "auto")) {
            if (f922 <= f2) {
                f422 = f922;
            } else {
                Sj(dNu22, min2, f422);
            }
        } else if ((TextUtils.equals(ley, "fixed") || TextUtils.equals(ley, "flex")) && f422 < f922) {
            Sj(dNu22, min2, f422);
        }
        tkc222.Sj = Math.min(min2 + Zq, f);
        tkc222.sP = Math.min(f422 + uvD, f2);
        return tkc222;
    }

    public TKC Sj(com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq) {
        return this.Sj.get(HiB(dq));
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TKC Sj(com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq, float f, float f2) {
        float f3;
        if ((!TextUtils.isEmpty(dq.TEQ().TKC()) || dq.TEQ().HiB().kb() != null) && !TextUtils.equals(dq.TEQ().sP(), "creative-playable-bait")) {
            float Dq = dq.Dq();
            float uA = dq.uA();
            com.bytedance.sdk.component.adexpress.dynamic.EjP.vS HiB = dq.TEQ().HiB();
            String LqL = HiB.LqL();
            String ley = HiB.ley();
            float Fmk = dq.Fmk();
            float sef = dq.sef();
            float Zq = dq.Zq();
            float uvD = dq.uvD();
            if (TextUtils.equals(LqL, "fixed")) {
                f = Math.min(Dq, f);
                if (TextUtils.equals(ley, "auto")) {
                    f3 = sP(dq, f - Zq, f2 - uvD).sP;
                    uA = f3 + uvD;
                }
                if (TextUtils.equals(ley, "scale")) {
                    float round = Math.round((f - Fmk) / uA) + sef;
                    if (round > f2) {
                        f = Math.round((f2 - sef) * uA) + Fmk;
                    } else {
                        f2 = round;
                    }
                } else if (TextUtils.equals(ley, "fixed")) {
                    f2 = Math.min(uA + sef, f2);
                } else if (!TextUtils.equals(ley, "flex")) {
                    f2 = uA;
                }
                TKC tkc = new TKC();
                tkc.Sj = f;
                tkc.sP = f2;
                return tkc;
            }
            if (TextUtils.equals(LqL, "auto")) {
                TKC sP = sP(dq, f - Zq, f2 - uvD);
                f = sP.Sj + Zq;
                if (TextUtils.equals(ley, "auto")) {
                    f3 = sP.sP;
                    uA = f3 + uvD;
                }
                if (TextUtils.equals(ley, "scale")) {
                }
                TKC tkc2 = new TKC();
                tkc2.Sj = f;
                tkc2.sP = f2;
                return tkc2;
            }
            if (!TextUtils.equals(LqL, "flex")) {
                f = Dq;
            } else if (TextUtils.equals(ley, "auto")) {
                f3 = sP(dq, f - Zq, f2 - uvD).sP;
                uA = f3 + uvD;
            }
            if (TextUtils.equals(ley, "scale")) {
            }
            TKC tkc22 = new TKC();
            tkc22.Sj = f;
            tkc22.sP = f2;
            return tkc22;
        }
        return new TKC(0.0f, 0.0f);
    }

    public TKC Sj(List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq> list) {
        return this.sP.get(EjP(list));
    }

    public void Sj() {
        this.TKC.clear();
        this.Sj.clear();
        this.sP.clear();
    }

    public TKC TKC(com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq, float f, float f2) {
        if (dq == null) {
            return null;
        }
        TKC Sj2 = Sj(dq);
        if (Sj2 != null && (Sj2.Sj != 0.0f || Sj2.sP != 0.0f)) {
            return Sj2;
        }
        TKC EjP = EjP(dq, f, f2);
        Sj(dq, EjP);
        return EjP;
    }

    public TKC sP(com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq, float f, float f2) {
        TKC tkc = new TKC();
        if (dq.TEQ().HiB() == null) {
            return tkc;
        }
        TKC HiB = HiB(dq, f, f2);
        float f3 = HiB.Sj;
        float f4 = HiB.sP;
        tkc.Sj = Math.min(f3, f);
        tkc.sP = Math.min(f4, f2);
        return tkc;
    }
}
