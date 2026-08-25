package com.bytedance.adsdk.ugeno.HiB;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
class EjP {
    static final /* synthetic */ boolean TKC = true;
    private final com.bytedance.adsdk.ugeno.HiB.Sj EjP;
    private boolean[] HiB;
    int[] Sj;
    long[] sP;
    private long[] vS;

    static class Sj {
        List<TKC> Sj;
        int sP;

        Sj() {
        }

        void Sj() {
            this.Sj = null;
            this.sP = 0;
        }
    }

    private static class sP implements Comparable<sP> {
        int Sj;
        int sP;

        private sP() {
        }

        @Override // java.lang.Comparable
        /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
        public int compareTo(sP sPVar) {
            int i = this.sP;
            int i2 = sPVar.sP;
            return i != i2 ? i - i2 : this.Sj - sPVar.Sj;
        }

        public String toString() {
            return "Order{order=" + this.sP + ", index=" + this.Sj + '}';
        }
    }

    EjP(com.bytedance.adsdk.ugeno.HiB.Sj sj) {
        this.EjP = sj;
    }

    private int EjP(com.bytedance.adsdk.ugeno.HiB.sP sPVar, boolean z) {
        return z ? sPVar.Zq() : sPVar.uvD();
    }

    private int EjP(boolean z) {
        return z ? this.EjP.getPaddingBottom() : this.EjP.getPaddingEnd();
    }

    private int HiB(com.bytedance.adsdk.ugeno.HiB.sP sPVar, boolean z) {
        return z ? sPVar.sef() : sPVar.Fmk();
    }

    private int Sj(int i, com.bytedance.adsdk.ugeno.HiB.sP sPVar, int i2) {
        com.bytedance.adsdk.ugeno.HiB.Sj sj = this.EjP;
        int Sj2 = sj.Sj(i, sj.getPaddingLeft() + this.EjP.getPaddingRight() + sPVar.Fmk() + sPVar.Zq() + i2, sPVar.Sj());
        int size = View.MeasureSpec.getSize(Sj2);
        return size > sPVar.uA() ? View.MeasureSpec.makeMeasureSpec(sPVar.uA(), View.MeasureSpec.getMode(Sj2)) : size < sPVar.Jcg() ? View.MeasureSpec.makeMeasureSpec(sPVar.Jcg(), View.MeasureSpec.getMode(Sj2)) : Sj2;
    }

    private int Sj(View view, boolean z) {
        return z ? view.getMeasuredWidth() : view.getMeasuredHeight();
    }

    private int Sj(com.bytedance.adsdk.ugeno.HiB.sP sPVar, boolean z) {
        return z ? sPVar.Sj() : sPVar.sP();
    }

    private int Sj(boolean z) {
        return z ? this.EjP.getPaddingStart() : this.EjP.getPaddingTop();
    }

    private List<TKC> Sj(List<TKC> list, int i, int i2) {
        int i3 = (i - i2) / 2;
        ArrayList arrayList = new ArrayList();
        TKC tkc = new TKC();
        tkc.Jcg = i3;
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (i4 == 0) {
                arrayList.add(tkc);
            }
            arrayList.add(list.get(i4));
            if (i4 == list.size() - 1) {
                arrayList.add(tkc);
            }
        }
        return arrayList;
    }

    private void Sj(int i, int i2, int i3, View view) {
        long[] jArr = this.sP;
        if (jArr != null) {
            jArr[i] = sP(i2, i3);
        }
        long[] jArr2 = this.vS;
        if (jArr2 != null) {
            jArr2[i] = sP(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    private void Sj(int i, int i2, TKC tkc, int i3, int i4, boolean z) {
        int i8;
        int i9;
        int i10;
        double d;
        int i11;
        double d2;
        float f = tkc.TEQ;
        float f2 = 0.0f;
        if (f <= 0.0f || i3 < (i8 = tkc.HiB)) {
            return;
        }
        float f3 = (i3 - i8) / f;
        tkc.HiB = i4 + tkc.vS;
        if (!z) {
            tkc.Jcg = Integer.MIN_VALUE;
        }
        int i12 = 0;
        boolean z2 = false;
        int i13 = 0;
        float f4 = 0.0f;
        while (i12 < tkc.Dq) {
            int i14 = tkc.Zq + i12;
            View sP2 = this.EjP.sP(i14);
            if (sP2 == null || sP2.getVisibility() == 8) {
                i9 = i8;
            } else {
                com.bytedance.adsdk.ugeno.HiB.sP sPVar = (com.bytedance.adsdk.ugeno.HiB.sP) sP2.getLayoutParams();
                int flexDirection = this.EjP.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    int i15 = i8;
                    int measuredWidth = sP2.getMeasuredWidth();
                    long[] jArr = this.vS;
                    if (jArr != null) {
                        measuredWidth = Sj(jArr[i14]);
                    }
                    int measuredHeight = sP2.getMeasuredHeight();
                    long[] jArr2 = this.vS;
                    i9 = i15;
                    if (jArr2 != null) {
                        measuredHeight = sP(jArr2[i14]);
                    }
                    if (!this.HiB[i14] && sPVar.EjP() > 0.0f) {
                        float EjP = measuredWidth + (sPVar.EjP() * f3);
                        if (i12 == tkc.Dq - 1) {
                            EjP += f4;
                            f4 = 0.0f;
                        }
                        int round = Math.round(EjP);
                        if (round > sPVar.uA()) {
                            round = sPVar.uA();
                            this.HiB[i14] = true;
                            tkc.TEQ -= sPVar.EjP();
                            z2 = true;
                        } else {
                            f4 += EjP - round;
                            double d3 = f4;
                            if (d3 > 1.0d) {
                                round++;
                                d = d3 - 1.0d;
                            } else if (d3 < -1.0d) {
                                round--;
                                d = d3 + 1.0d;
                            }
                            f4 = (float) d;
                        }
                        int sP3 = sP(i2, sPVar, tkc.Fmk);
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(round, 1073741824);
                        sP2.measure(makeMeasureSpec, sP3);
                        int measuredWidth2 = sP2.getMeasuredWidth();
                        int measuredHeight2 = sP2.getMeasuredHeight();
                        Sj(i14, makeMeasureSpec, sP3, sP2);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int max = Math.max(i13, measuredHeight + sPVar.sef() + sPVar.uvD() + this.EjP.Sj(sP2));
                    tkc.HiB += measuredWidth + sPVar.Fmk() + sPVar.Zq();
                    i10 = max;
                } else {
                    int measuredHeight3 = sP2.getMeasuredHeight();
                    long[] jArr3 = this.vS;
                    if (jArr3 != null) {
                        measuredHeight3 = sP(jArr3[i14]);
                    }
                    int measuredWidth3 = sP2.getMeasuredWidth();
                    long[] jArr4 = this.vS;
                    if (jArr4 != null) {
                        measuredWidth3 = Sj(jArr4[i14]);
                    }
                    if (this.HiB[i14] || sPVar.EjP() <= f2) {
                        i11 = i8;
                    } else {
                        float EjP2 = measuredHeight3 + (sPVar.EjP() * f3);
                        if (i12 == tkc.Dq - 1) {
                            EjP2 += f4;
                            f4 = f2;
                        }
                        int round2 = Math.round(EjP2);
                        if (round2 > sPVar.TEQ()) {
                            round2 = sPVar.TEQ();
                            this.HiB[i14] = true;
                            tkc.TEQ -= sPVar.EjP();
                            i11 = i8;
                            z2 = true;
                        } else {
                            f4 += EjP2 - round2;
                            i11 = i8;
                            double d4 = f4;
                            if (d4 > 1.0d) {
                                round2++;
                                d2 = d4 - 1.0d;
                            } else if (d4 < -1.0d) {
                                round2--;
                                d2 = d4 + 1.0d;
                            }
                            f4 = (float) d2;
                        }
                        int Sj2 = Sj(i, sPVar, tkc.Fmk);
                        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(round2, 1073741824);
                        sP2.measure(Sj2, makeMeasureSpec2);
                        measuredWidth3 = sP2.getMeasuredWidth();
                        int measuredHeight4 = sP2.getMeasuredHeight();
                        Sj(i14, Sj2, makeMeasureSpec2, sP2);
                        measuredHeight3 = measuredHeight4;
                    }
                    i10 = Math.max(i13, measuredWidth3 + sPVar.Fmk() + sPVar.Zq() + this.EjP.Sj(sP2));
                    tkc.HiB += measuredHeight3 + sPVar.sef() + sPVar.uvD();
                    i9 = i11;
                }
                tkc.Jcg = Math.max(tkc.Jcg, i10);
                i13 = i10;
            }
            i12++;
            i8 = i9;
            f2 = 0.0f;
        }
        int i16 = i8;
        if (!z2 || i16 == tkc.HiB) {
            return;
        }
        Sj(i, i2, tkc, i3, i4, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void Sj(View view, int i) {
        boolean z;
        com.bytedance.adsdk.ugeno.HiB.sP sPVar = (com.bytedance.adsdk.ugeno.HiB.sP) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        boolean z2 = true;
        if (measuredWidth < sPVar.Jcg()) {
            measuredWidth = sPVar.Jcg();
        } else {
            if (measuredWidth <= sPVar.uA()) {
                z = false;
                if (measuredHeight >= sPVar.Dq()) {
                    measuredHeight = sPVar.Dq();
                } else if (measuredHeight > sPVar.TEQ()) {
                    measuredHeight = sPVar.TEQ();
                } else {
                    z2 = z;
                }
                if (z2) {
                    return;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
                int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                Sj(i, makeMeasureSpec, makeMeasureSpec2, view);
                return;
            }
            measuredWidth = sPVar.uA();
        }
        z = true;
        if (measuredHeight >= sPVar.Dq()) {
        }
        if (z2) {
        }
    }

    private void Sj(View view, int i, int i2) {
        com.bytedance.adsdk.ugeno.HiB.sP sPVar = (com.bytedance.adsdk.ugeno.HiB.sP) view.getLayoutParams();
        int min = Math.min(Math.max(((i - sPVar.sef()) - sPVar.uvD()) - this.EjP.Sj(view), sPVar.Dq()), sPVar.TEQ());
        long[] jArr = this.vS;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(jArr != null ? Sj(jArr[i2]) : view.getMeasuredWidth(), 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec, makeMeasureSpec2);
        Sj(i2, makeMeasureSpec, makeMeasureSpec2, view);
    }

    private void Sj(CompoundButton compoundButton) {
        com.bytedance.adsdk.ugeno.HiB.sP sPVar = (com.bytedance.adsdk.ugeno.HiB.sP) compoundButton.getLayoutParams();
        int Jcg = sPVar.Jcg();
        int Dq = sPVar.Dq();
        Drawable Sj2 = com.bytedance.adsdk.ugeno.Jcg.HiB.Sj(compoundButton);
        int minimumWidth = Sj2 == null ? 0 : Sj2.getMinimumWidth();
        int minimumHeight = Sj2 != null ? Sj2.getMinimumHeight() : 0;
        if (Jcg == -1) {
            Jcg = minimumWidth;
        }
        sPVar.Sj(Jcg);
        if (Dq == -1) {
            Dq = minimumHeight;
        }
        sPVar.sP(Dq);
    }

    private void Sj(List<TKC> list, TKC tkc, int i, int i2) {
        tkc.Fmk = i2;
        this.EjP.Sj(tkc);
        tkc.uvD = i;
        list.add(tkc);
    }

    private boolean Sj(int i, int i2, TKC tkc) {
        return i == i2 - 1 && tkc.sP() != 0;
    }

    private boolean Sj(View view, int i, int i2, int i3, int i4, com.bytedance.adsdk.ugeno.HiB.sP sPVar, int i8, int i9, int i10) {
        if (this.EjP.getFlexWrap() == 0) {
            return false;
        }
        if (sPVar.Ym()) {
            return true;
        }
        if (i == 0) {
            return false;
        }
        int maxLine = this.EjP.getMaxLine();
        if (maxLine != -1 && maxLine <= i10 + 1) {
            return false;
        }
        int Sj2 = this.EjP.Sj(view, i8, i9);
        if (Sj2 > 0) {
            i4 += Sj2;
        }
        return i2 < i3 + i4;
    }

    private int[] Sj(int i, List<sP> list, SparseIntArray sparseIntArray) {
        Collections.sort(list);
        sparseIntArray.clear();
        int[] iArr = new int[i];
        int i2 = 0;
        for (sP sPVar : list) {
            int i3 = sPVar.Sj;
            iArr[i2] = i3;
            sparseIntArray.append(i3, sPVar.sP);
            i2++;
        }
        return iArr;
    }

    private int TKC(com.bytedance.adsdk.ugeno.HiB.sP sPVar, boolean z) {
        return z ? sPVar.Fmk() : sPVar.sef();
    }

    private int TKC(boolean z) {
        return z ? this.EjP.getPaddingTop() : this.EjP.getPaddingStart();
    }

    private void TKC(int i) {
        boolean[] zArr = this.HiB;
        if (zArr == null) {
            this.HiB = new boolean[Math.max(i, 10)];
        } else if (zArr.length < i) {
            this.HiB = new boolean[Math.max(zArr.length * 2, i)];
        } else {
            Arrays.fill(zArr, false);
        }
    }

    private int sP(int i, com.bytedance.adsdk.ugeno.HiB.sP sPVar, int i2) {
        com.bytedance.adsdk.ugeno.HiB.Sj sj = this.EjP;
        int sP2 = sj.sP(i, sj.getPaddingTop() + this.EjP.getPaddingBottom() + sPVar.sef() + sPVar.uvD() + i2, sPVar.sP());
        int size = View.MeasureSpec.getSize(sP2);
        return size > sPVar.TEQ() ? View.MeasureSpec.makeMeasureSpec(sPVar.TEQ(), View.MeasureSpec.getMode(sP2)) : size < sPVar.Dq() ? View.MeasureSpec.makeMeasureSpec(sPVar.Dq(), View.MeasureSpec.getMode(sP2)) : sP2;
    }

    private int sP(View view, boolean z) {
        return z ? view.getMeasuredHeight() : view.getMeasuredWidth();
    }

    private int sP(com.bytedance.adsdk.ugeno.HiB.sP sPVar, boolean z) {
        return z ? sPVar.sP() : sPVar.Sj();
    }

    private int sP(boolean z) {
        return z ? this.EjP.getPaddingEnd() : this.EjP.getPaddingBottom();
    }

    private List<sP> sP(int i) {
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            com.bytedance.adsdk.ugeno.HiB.sP sPVar = (com.bytedance.adsdk.ugeno.HiB.sP) this.EjP.Sj(i2).getLayoutParams();
            sP sPVar2 = new sP();
            sPVar2.sP = sPVar.TKC();
            sPVar2.Sj = i2;
            arrayList.add(sPVar2);
        }
        return arrayList;
    }

    private void sP(int i, int i2, TKC tkc, int i3, int i4, boolean z) {
        int i8;
        int i9;
        int i10;
        int i11 = tkc.HiB;
        float f = tkc.Ym;
        float f2 = 0.0f;
        if (f <= 0.0f || i3 > i11) {
            return;
        }
        float f3 = (i11 - i3) / f;
        tkc.HiB = i4 + tkc.vS;
        if (!z) {
            tkc.Jcg = Integer.MIN_VALUE;
        }
        int i12 = 0;
        boolean z2 = false;
        int i13 = 0;
        float f4 = 0.0f;
        while (i12 < tkc.Dq) {
            int i14 = tkc.Zq + i12;
            View sP2 = this.EjP.sP(i14);
            if (sP2 == null || sP2.getVisibility() == 8) {
                i8 = i11;
                i9 = i12;
            } else {
                com.bytedance.adsdk.ugeno.HiB.sP sPVar = (com.bytedance.adsdk.ugeno.HiB.sP) sP2.getLayoutParams();
                int flexDirection = this.EjP.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    i8 = i11;
                    int i15 = i12;
                    int measuredWidth = sP2.getMeasuredWidth();
                    long[] jArr = this.vS;
                    if (jArr != null) {
                        measuredWidth = Sj(jArr[i14]);
                    }
                    int measuredHeight = sP2.getMeasuredHeight();
                    long[] jArr2 = this.vS;
                    if (jArr2 != null) {
                        measuredHeight = sP(jArr2[i14]);
                    }
                    if (this.HiB[i14] || sPVar.HiB() <= 0.0f) {
                        i9 = i15;
                    } else {
                        float HiB = measuredWidth - (sPVar.HiB() * f3);
                        i9 = i15;
                        if (i9 == tkc.Dq - 1) {
                            HiB += f4;
                            f4 = 0.0f;
                        }
                        int round = Math.round(HiB);
                        if (round < sPVar.Jcg()) {
                            round = sPVar.Jcg();
                            this.HiB[i14] = true;
                            tkc.Ym -= sPVar.HiB();
                            z2 = true;
                        } else {
                            f4 += HiB - round;
                            double d = f4;
                            if (d > 1.0d) {
                                round++;
                                f4 -= 1.0f;
                            } else if (d < -1.0d) {
                                round--;
                                f4 += 1.0f;
                            }
                        }
                        int sP3 = sP(i2, sPVar, tkc.Fmk);
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(round, 1073741824);
                        sP2.measure(makeMeasureSpec, sP3);
                        int measuredWidth2 = sP2.getMeasuredWidth();
                        int measuredHeight2 = sP2.getMeasuredHeight();
                        Sj(i14, makeMeasureSpec, sP3, sP2);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int max = Math.max(i13, measuredHeight + sPVar.sef() + sPVar.uvD() + this.EjP.Sj(sP2));
                    tkc.HiB += measuredWidth + sPVar.Fmk() + sPVar.Zq();
                    i10 = max;
                } else {
                    int measuredHeight3 = sP2.getMeasuredHeight();
                    long[] jArr3 = this.vS;
                    if (jArr3 != null) {
                        measuredHeight3 = sP(jArr3[i14]);
                    }
                    int measuredWidth3 = sP2.getMeasuredWidth();
                    long[] jArr4 = this.vS;
                    if (jArr4 != null) {
                        measuredWidth3 = Sj(jArr4[i14]);
                    }
                    if (this.HiB[i14] || sPVar.HiB() <= f2) {
                        i8 = i11;
                        i9 = i12;
                    } else {
                        float HiB2 = measuredHeight3 - (sPVar.HiB() * f3);
                        if (i12 == tkc.Dq - 1) {
                            HiB2 += f4;
                            f4 = f2;
                        }
                        int round2 = Math.round(HiB2);
                        if (round2 < sPVar.Dq()) {
                            round2 = sPVar.Dq();
                            this.HiB[i14] = true;
                            tkc.Ym -= sPVar.HiB();
                            i8 = i11;
                            i9 = i12;
                            z2 = true;
                        } else {
                            f4 += HiB2 - round2;
                            i8 = i11;
                            i9 = i12;
                            double d2 = f4;
                            if (d2 > 1.0d) {
                                round2++;
                                f4 -= 1.0f;
                            } else if (d2 < -1.0d) {
                                round2--;
                                f4 += 1.0f;
                            }
                        }
                        int Sj2 = Sj(i, sPVar, tkc.Fmk);
                        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(round2, 1073741824);
                        sP2.measure(Sj2, makeMeasureSpec2);
                        measuredWidth3 = sP2.getMeasuredWidth();
                        int measuredHeight4 = sP2.getMeasuredHeight();
                        Sj(i14, Sj2, makeMeasureSpec2, sP2);
                        measuredHeight3 = measuredHeight4;
                    }
                    i10 = Math.max(i13, measuredWidth3 + sPVar.Fmk() + sPVar.Zq() + this.EjP.Sj(sP2));
                    tkc.HiB += measuredHeight3 + sPVar.sef() + sPVar.uvD();
                }
                tkc.Jcg = Math.max(tkc.Jcg, i10);
                i13 = i10;
            }
            i12 = i9 + 1;
            i11 = i8;
            f2 = 0.0f;
        }
        int i16 = i11;
        if (!z2 || i16 == tkc.HiB) {
            return;
        }
        sP(i, i2, tkc, i3, i4, true);
    }

    private void sP(View view, int i, int i2) {
        com.bytedance.adsdk.ugeno.HiB.sP sPVar = (com.bytedance.adsdk.ugeno.HiB.sP) view.getLayoutParams();
        int min = Math.min(Math.max(((i - sPVar.Fmk()) - sPVar.Zq()) - this.EjP.Sj(view), sPVar.Jcg()), sPVar.uA());
        long[] jArr = this.vS;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(jArr != null ? sP(jArr[i2]) : view.getMeasuredHeight(), 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec2, makeMeasureSpec);
        Sj(i2, makeMeasureSpec2, makeMeasureSpec, view);
    }

    private int vS(com.bytedance.adsdk.ugeno.HiB.sP sPVar, boolean z) {
        return z ? sPVar.uvD() : sPVar.Zq();
    }

    int Sj(long j) {
        return (int) j;
    }

    void Sj() {
        Sj(0);
    }

    void Sj(int i) {
        View sP2;
        if (i >= this.EjP.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.EjP.getFlexDirection();
        if (this.EjP.getAlignItems() != 4) {
            for (TKC tkc : this.EjP.getFlexLinesInternal()) {
                for (Integer num : tkc.sef) {
                    View sP3 = this.EjP.sP(num.intValue());
                    if (flexDirection == 0 || flexDirection == 1) {
                        Sj(sP3, tkc.Jcg, num.intValue());
                    } else {
                        if (flexDirection != 2 && flexDirection != 3) {
                            throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
                        }
                        sP(sP3, tkc.Jcg, num.intValue());
                    }
                }
            }
            return;
        }
        int[] iArr = this.Sj;
        List<TKC> flexLinesInternal = this.EjP.getFlexLinesInternal();
        int size = flexLinesInternal.size();
        for (int i2 = iArr != null ? iArr[i] : 0; i2 < size; i2++) {
            TKC tkc2 = flexLinesInternal.get(i2);
            int i3 = tkc2.Dq;
            for (int i4 = 0; i4 < i3; i4++) {
                int i8 = tkc2.Zq + i4;
                if (i4 < this.EjP.getFlexItemCount() && (sP2 = this.EjP.sP(i8)) != null && sP2.getVisibility() != 8) {
                    com.bytedance.adsdk.ugeno.HiB.sP sPVar = (com.bytedance.adsdk.ugeno.HiB.sP) sP2.getLayoutParams();
                    if (sPVar.vS() == -1 || sPVar.vS() == 4) {
                        if (flexDirection == 0 || flexDirection == 1) {
                            Sj(sP2, tkc2.Jcg, i8);
                        } else {
                            if (flexDirection != 2 && flexDirection != 3) {
                                throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
                            }
                            sP(sP2, tkc2.Jcg, i8);
                        }
                    }
                }
            }
        }
    }

    void Sj(int i, int i2) {
        Sj(i, i2, 0);
    }

    void Sj(int i, int i2, int i3) {
        int size;
        int paddingLeft;
        int paddingRight;
        TKC(this.EjP.getFlexItemCount());
        if (i3 >= this.EjP.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.EjP.getFlexDirection();
        int flexDirection2 = this.EjP.getFlexDirection();
        if (flexDirection2 == 0 || flexDirection2 == 1) {
            int mode = View.MeasureSpec.getMode(i);
            size = View.MeasureSpec.getSize(i);
            int largestMainSize = this.EjP.getLargestMainSize();
            if (mode != 1073741824) {
                size = Math.min(largestMainSize, size);
            }
            paddingLeft = this.EjP.getPaddingLeft();
            paddingRight = this.EjP.getPaddingRight();
        } else {
            if (flexDirection2 != 2 && flexDirection2 != 3) {
                throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
            }
            int mode2 = View.MeasureSpec.getMode(i2);
            size = View.MeasureSpec.getSize(i2);
            if (mode2 != 1073741824) {
                size = this.EjP.getLargestMainSize();
            }
            paddingLeft = this.EjP.getPaddingTop();
            paddingRight = this.EjP.getPaddingBottom();
        }
        int i4 = paddingLeft + paddingRight;
        int[] iArr = this.Sj;
        List<TKC> flexLinesInternal = this.EjP.getFlexLinesInternal();
        int size2 = flexLinesInternal.size();
        for (int i8 = iArr != null ? iArr[i3] : 0; i8 < size2; i8++) {
            TKC tkc = flexLinesInternal.get(i8);
            int i9 = tkc.HiB;
            if (i9 < size && tkc.dNu) {
                Sj(i, i2, tkc, size, i4, false);
            } else if (i9 > size && tkc.TzV) {
                sP(i, i2, tkc, size, i4, false);
            }
        }
    }

    void Sj(View view, TKC tkc, int i, int i2, int i3, int i4) {
        com.bytedance.adsdk.ugeno.HiB.sP sPVar = (com.bytedance.adsdk.ugeno.HiB.sP) view.getLayoutParams();
        int alignItems = this.EjP.getAlignItems();
        if (sPVar.vS() != -1) {
            alignItems = sPVar.vS();
        }
        int i8 = tkc.Jcg;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (this.EjP.getFlexWrap() == 2) {
                    view.layout(i, (i2 - i8) + view.getMeasuredHeight() + sPVar.sef(), i3, (i4 - i8) + view.getMeasuredHeight() + sPVar.sef());
                    return;
                } else {
                    int i9 = i2 + i8;
                    view.layout(i, (i9 - view.getMeasuredHeight()) - sPVar.uvD(), i3, i9 - sPVar.uvD());
                    return;
                }
            }
            if (alignItems == 2) {
                int measuredHeight = (((i8 - view.getMeasuredHeight()) + sPVar.sef()) - sPVar.uvD()) / 2;
                if (this.EjP.getFlexWrap() != 2) {
                    int i10 = i2 + measuredHeight;
                    view.layout(i, i10, i3, view.getMeasuredHeight() + i10);
                    return;
                } else {
                    int i11 = i2 - measuredHeight;
                    view.layout(i, i11, i3, view.getMeasuredHeight() + i11);
                    return;
                }
            }
            if (alignItems == 3) {
                if (this.EjP.getFlexWrap() != 2) {
                    int max = Math.max(tkc.aa - view.getBaseline(), sPVar.sef());
                    view.layout(i, i2 + max, i3, i4 + max);
                    return;
                } else {
                    int max2 = Math.max((tkc.aa - view.getMeasuredHeight()) + view.getBaseline(), sPVar.uvD());
                    view.layout(i, i2 - max2, i3, i4 - max2);
                    return;
                }
            }
            if (alignItems != 4) {
                return;
            }
        }
        if (this.EjP.getFlexWrap() != 2) {
            view.layout(i, i2 + sPVar.sef(), i3, i4 + sPVar.sef());
        } else {
            view.layout(i, i2 - sPVar.uvD(), i3, i4 - sPVar.uvD());
        }
    }

    void Sj(View view, TKC tkc, boolean z, int i, int i2, int i3, int i4) {
        com.bytedance.adsdk.ugeno.HiB.sP sPVar = (com.bytedance.adsdk.ugeno.HiB.sP) view.getLayoutParams();
        int alignItems = this.EjP.getAlignItems();
        if (sPVar.vS() != -1) {
            alignItems = sPVar.vS();
        }
        int i8 = tkc.Jcg;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (z) {
                    view.layout((i - i8) + view.getMeasuredWidth() + sPVar.Fmk(), i2, (i3 - i8) + view.getMeasuredWidth() + sPVar.Fmk(), i4);
                    return;
                } else {
                    view.layout(((i + i8) - view.getMeasuredWidth()) - sPVar.Zq(), i2, ((i3 + i8) - view.getMeasuredWidth()) - sPVar.Zq(), i4);
                    return;
                }
            }
            if (alignItems == 2) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                int measuredWidth = (((i8 - view.getMeasuredWidth()) + com.bytedance.adsdk.ugeno.Jcg.vS.Sj(marginLayoutParams)) - com.bytedance.adsdk.ugeno.Jcg.vS.sP(marginLayoutParams)) / 2;
                if (z) {
                    view.layout(i - measuredWidth, i2, i3 - measuredWidth, i4);
                    return;
                } else {
                    view.layout(i + measuredWidth, i2, i3 + measuredWidth, i4);
                    return;
                }
            }
            if (alignItems != 3 && alignItems != 4) {
                return;
            }
        }
        if (z) {
            view.layout(i - sPVar.Zq(), i2, i3 - sPVar.Zq(), i4);
        } else {
            view.layout(i + sPVar.Fmk(), i2, i3 + sPVar.Fmk(), i4);
        }
    }

    void Sj(Sj sj, int i, int i2) {
        Sj(sj, i, i2, Integer.MAX_VALUE, 0, -1, (List<TKC>) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    void Sj(Sj sj, int i, int i2, int i3, int i4, int i8, List<TKC> list) {
        int i9;
        Sj sj2;
        int i10;
        int i11;
        int i12;
        List<TKC> list2;
        int i13;
        int i14;
        View view;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23 = i;
        int i24 = i2;
        int i25 = i8;
        boolean Sj2 = this.EjP.Sj();
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        List<TKC> arrayList = list == null ? new ArrayList() : list;
        sj.Sj = arrayList;
        int i26 = i25 == -1 ? 1 : 0;
        int Sj3 = Sj(Sj2);
        int sP2 = sP(Sj2);
        int TKC2 = TKC(Sj2);
        int EjP = EjP(Sj2);
        TKC tkc = new TKC();
        int i27 = i4;
        tkc.Zq = i27;
        int i28 = sP2 + Sj3;
        tkc.HiB = i28;
        int flexItemCount = this.EjP.getFlexItemCount();
        int i29 = i26;
        int i30 = Integer.MIN_VALUE;
        int i31 = 0;
        int i32 = 0;
        int i33 = 0;
        while (true) {
            if (i27 >= flexItemCount) {
                i9 = i32;
                sj2 = sj;
                break;
            }
            View sP3 = this.EjP.sP(i27);
            if (sP3 != null) {
                if (sP3.getVisibility() != 8) {
                    if (sP3 instanceof CompoundButton) {
                        Sj((CompoundButton) sP3);
                    }
                    com.bytedance.adsdk.ugeno.HiB.sP sPVar = (com.bytedance.adsdk.ugeno.HiB.sP) sP3.getLayoutParams();
                    int i34 = flexItemCount;
                    if (sPVar.vS() == 4) {
                        tkc.sef.add(Integer.valueOf(i27));
                    }
                    int Sj4 = Sj(sPVar, Sj2);
                    if (sPVar.aa() != -1.0f && mode == 1073741824) {
                        Sj4 = Math.round(size * sPVar.aa());
                    }
                    if (Sj2) {
                        int Sj5 = this.EjP.Sj(i23, i28 + TKC(sPVar, true) + EjP(sPVar, true), Sj4);
                        i10 = size;
                        i11 = mode;
                        int sP4 = this.EjP.sP(i24, TKC2 + EjP + HiB(sPVar, true) + vS(sPVar, true) + i31, sP(sPVar, true));
                        sP3.measure(Sj5, sP4);
                        Sj(i27, Sj5, sP4, sP3);
                        i12 = Sj5;
                    } else {
                        i10 = size;
                        i11 = mode;
                        int Sj6 = this.EjP.Sj(i24, TKC2 + EjP + HiB(sPVar, false) + vS(sPVar, false) + i31, sP(sPVar, false));
                        int sP5 = this.EjP.sP(i23, TKC(sPVar, false) + i28 + EjP(sPVar, false), Sj4);
                        sP3.measure(Sj6, sP5);
                        Sj(i27, Sj6, sP5, sP3);
                        i12 = sP5;
                    }
                    Sj(sP3, i27);
                    i32 = View.combineMeasuredStates(i32, sP3.getMeasuredState());
                    int i35 = i31;
                    int i36 = i28;
                    TKC tkc2 = tkc;
                    int i37 = i27;
                    list2 = arrayList;
                    int i38 = i12;
                    if (Sj(sP3, i11, i10, tkc.HiB, EjP(sPVar, Sj2) + Sj(sP3, Sj2) + TKC(sPVar, Sj2), sPVar, i37, i33, arrayList.size())) {
                        if (tkc2.sP() > 0) {
                            Sj(list2, tkc2, i37 > 0 ? i37 - 1 : 0, i35);
                            i31 = tkc2.Jcg + i35;
                        } else {
                            i31 = i35;
                        }
                        if (!Sj2) {
                            i13 = i2;
                            i14 = i37;
                            view = sP3;
                            i15 = -1;
                            if (sPVar.Sj() == -1) {
                                com.bytedance.adsdk.ugeno.HiB.Sj sj3 = this.EjP;
                                view.measure(sj3.Sj(i13, sj3.getPaddingLeft() + this.EjP.getPaddingRight() + sPVar.Fmk() + sPVar.Zq() + i31, sPVar.Sj()), i38);
                                Sj(view, i14);
                            }
                        } else if (sPVar.sP() == -1) {
                            com.bytedance.adsdk.ugeno.HiB.Sj sj4 = this.EjP;
                            i13 = i2;
                            i15 = -1;
                            view = sP3;
                            view.measure(i38, sj4.sP(i13, sj4.getPaddingTop() + this.EjP.getPaddingBottom() + sPVar.sef() + sPVar.uvD() + i31, sPVar.sP()));
                            i14 = i37;
                            Sj(view, i14);
                        } else {
                            i13 = i2;
                            i14 = i37;
                            view = sP3;
                            i15 = -1;
                        }
                        tkc = new TKC();
                        i17 = 1;
                        tkc.Dq = 1;
                        i16 = i36;
                        tkc.HiB = i16;
                        tkc.Zq = i14;
                        i19 = Integer.MIN_VALUE;
                        i18 = 0;
                    } else {
                        i13 = i2;
                        i14 = i37;
                        view = sP3;
                        i15 = -1;
                        tkc = tkc2;
                        i16 = i36;
                        i17 = 1;
                        tkc.Dq++;
                        i18 = i33 + 1;
                        i31 = i35;
                        i19 = i30;
                    }
                    tkc.dNu = (tkc.dNu ? 1 : 0) | (sPVar.EjP() != 0.0f ? i17 : 0);
                    tkc.TzV = (tkc.TzV ? 1 : 0) | (sPVar.HiB() != 0.0f ? i17 : 0);
                    int[] iArr = this.Sj;
                    if (iArr != null) {
                        iArr[i14] = list2.size();
                    }
                    tkc.HiB += Sj(view, Sj2) + TKC(sPVar, Sj2) + EjP(sPVar, Sj2);
                    tkc.TEQ += sPVar.EjP();
                    tkc.Ym += sPVar.HiB();
                    this.EjP.Sj(view, i14, i18, tkc);
                    int max = Math.max(i19, sP(view, Sj2) + HiB(sPVar, Sj2) + vS(sPVar, Sj2) + this.EjP.Sj(view));
                    tkc.Jcg = Math.max(tkc.Jcg, max);
                    if (Sj2) {
                        if (this.EjP.getFlexWrap() != 2) {
                            tkc.aa = Math.max(tkc.aa, view.getBaseline() + sPVar.sef());
                        } else {
                            tkc.aa = Math.max(tkc.aa, (view.getMeasuredHeight() - view.getBaseline()) + sPVar.uvD());
                        }
                    }
                    i20 = i34;
                    if (Sj(i14, i20, tkc)) {
                        Sj(list2, tkc, i14, i31);
                        i31 += tkc.Jcg;
                    }
                    i21 = i8;
                    if (i21 == i15 || list2.size() <= 0 || list2.get(list2.size() - i17).uvD < i21 || i14 < i21 || i29 != 0) {
                        i22 = i3;
                    } else {
                        i31 = -tkc.Sj();
                        i22 = i3;
                        i29 = i17;
                    }
                    if (i31 > i22 && i29 != 0) {
                        sj2 = sj;
                        i9 = i32;
                        break;
                    }
                    i33 = i18;
                    i30 = max;
                    i23 = i;
                    i27 = i14 + 1;
                    flexItemCount = i20;
                    i24 = i13;
                    i28 = i16;
                    arrayList = list2;
                    size = i10;
                    mode = i11;
                    i25 = i21;
                } else {
                    tkc.uA++;
                    tkc.Dq++;
                    if (Sj(i27, flexItemCount, tkc)) {
                        Sj(arrayList, tkc, i27, i31);
                    }
                }
            } else if (Sj(i27, flexItemCount, tkc)) {
                Sj(arrayList, tkc, i27, i31);
            }
            i10 = size;
            i11 = mode;
            i13 = i24;
            i21 = i25;
            i16 = i28;
            list2 = arrayList;
            i20 = flexItemCount;
            i14 = i27;
            i23 = i;
            i27 = i14 + 1;
            flexItemCount = i20;
            i24 = i13;
            i28 = i16;
            arrayList = list2;
            size = i10;
            mode = i11;
            i25 = i21;
        }
        sj2.sP = i9;
    }

    int[] Sj(SparseIntArray sparseIntArray) {
        int flexItemCount = this.EjP.getFlexItemCount();
        return Sj(flexItemCount, sP(flexItemCount), sparseIntArray);
    }

    /* JADX WARN: Multi-variable type inference failed */
    int[] Sj(View view, int i, ViewGroup.LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        int flexItemCount = this.EjP.getFlexItemCount();
        List<sP> sP2 = sP(flexItemCount);
        sP sPVar = new sP();
        if (view == null || !(layoutParams instanceof com.bytedance.adsdk.ugeno.HiB.sP)) {
            sPVar.sP = 1;
        } else {
            sPVar.sP = ((com.bytedance.adsdk.ugeno.HiB.sP) layoutParams).TKC();
        }
        if (i == -1 || i == flexItemCount) {
            sPVar.Sj = flexItemCount;
        } else if (i < this.EjP.getFlexItemCount()) {
            sPVar.Sj = i;
            while (i < flexItemCount) {
                sP2.get(i).Sj++;
                i++;
            }
        } else {
            sPVar.Sj = flexItemCount;
        }
        sP2.add(sPVar);
        return Sj(flexItemCount + 1, sP2, sparseIntArray);
    }

    int sP(long j) {
        return (int) (j >> 32);
    }

    long sP(int i, int i2) {
        return (i & 4294967295L) | (i2 << 32);
    }

    void sP(int i, int i2, int i3) {
        int i4;
        int i8;
        int flexDirection = this.EjP.getFlexDirection();
        if (flexDirection == 0 || flexDirection == 1) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            i4 = mode;
            i8 = size;
        } else {
            if (flexDirection != 2 && flexDirection != 3) {
                throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
            }
            i4 = View.MeasureSpec.getMode(i);
            i8 = View.MeasureSpec.getSize(i);
        }
        List<TKC> flexLinesInternal = this.EjP.getFlexLinesInternal();
        if (i4 == 1073741824) {
            int sumOfCrossSize = this.EjP.getSumOfCrossSize() + i3;
            int i9 = 0;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).Jcg = i8 - i3;
                return;
            }
            if (flexLinesInternal.size() >= 2) {
                int alignContent = this.EjP.getAlignContent();
                if (alignContent == 1) {
                    int i10 = i8 - sumOfCrossSize;
                    TKC tkc = new TKC();
                    tkc.Jcg = i10;
                    flexLinesInternal.add(0, tkc);
                    return;
                }
                if (alignContent == 2) {
                    this.EjP.setFlexLines(Sj(flexLinesInternal, i8, sumOfCrossSize));
                    return;
                }
                if (alignContent == 3) {
                    if (sumOfCrossSize < i8) {
                        float size2 = (i8 - sumOfCrossSize) / (flexLinesInternal.size() - 1);
                        ArrayList arrayList = new ArrayList();
                        int size3 = flexLinesInternal.size();
                        float f = 0.0f;
                        while (i9 < size3) {
                            arrayList.add(flexLinesInternal.get(i9));
                            if (i9 != flexLinesInternal.size() - 1) {
                                TKC tkc2 = new TKC();
                                if (i9 == flexLinesInternal.size() - 2) {
                                    tkc2.Jcg = Math.round(f + size2);
                                    f = 0.0f;
                                } else {
                                    tkc2.Jcg = Math.round(size2);
                                }
                                int i11 = tkc2.Jcg;
                                f += size2 - i11;
                                if (f > 1.0f) {
                                    tkc2.Jcg = i11 + 1;
                                    f -= 1.0f;
                                } else if (f < -1.0f) {
                                    tkc2.Jcg = i11 - 1;
                                    f += 1.0f;
                                }
                                arrayList.add(tkc2);
                            }
                            i9++;
                        }
                        this.EjP.setFlexLines(arrayList);
                        return;
                    }
                    return;
                }
                if (alignContent == 4) {
                    if (sumOfCrossSize >= i8) {
                        this.EjP.setFlexLines(Sj(flexLinesInternal, i8, sumOfCrossSize));
                        return;
                    }
                    int size4 = (i8 - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                    ArrayList arrayList2 = new ArrayList();
                    TKC tkc3 = new TKC();
                    tkc3.Jcg = size4;
                    for (TKC tkc4 : flexLinesInternal) {
                        arrayList2.add(tkc3);
                        arrayList2.add(tkc4);
                        arrayList2.add(tkc3);
                    }
                    this.EjP.setFlexLines(arrayList2);
                    return;
                }
                if (alignContent == 5 && sumOfCrossSize < i8) {
                    float size5 = (i8 - sumOfCrossSize) / flexLinesInternal.size();
                    int size6 = flexLinesInternal.size();
                    float f2 = 0.0f;
                    while (i9 < size6) {
                        TKC tkc5 = flexLinesInternal.get(i9);
                        float f3 = tkc5.Jcg + size5;
                        if (i9 == flexLinesInternal.size() - 1) {
                            f3 += f2;
                            f2 = 0.0f;
                        }
                        int round = Math.round(f3);
                        f2 += f3 - round;
                        if (f2 > 1.0f) {
                            round++;
                            f2 -= 1.0f;
                        } else if (f2 < -1.0f) {
                            round--;
                            f2 += 1.0f;
                        }
                        tkc5.Jcg = round;
                        i9++;
                    }
                }
            }
        }
    }

    void sP(Sj sj, int i, int i2) {
        Sj(sj, i2, i, Integer.MAX_VALUE, 0, -1, (List<TKC>) null);
    }

    boolean sP(SparseIntArray sparseIntArray) {
        int flexItemCount = this.EjP.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i = 0; i < flexItemCount; i++) {
            View Sj2 = this.EjP.Sj(i);
            if (Sj2 != null && ((com.bytedance.adsdk.ugeno.HiB.sP) Sj2.getLayoutParams()).TKC() != sparseIntArray.get(i)) {
                return true;
            }
        }
        return false;
    }
}
