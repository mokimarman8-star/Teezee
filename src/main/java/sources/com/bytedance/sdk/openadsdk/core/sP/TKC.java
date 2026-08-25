package com.bytedance.sdk.openadsdk.core.sP;

import android.graphics.Point;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.dNu;
import com.bytedance.sdk.openadsdk.core.settings.uA;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class TKC implements View.OnClickListener, View.OnTouchListener {
    private static float EjP = 0.0f;
    private static long HiB = 0;
    protected static int LD = 8;
    private static float Sj;
    private static float TKC;
    private static float sP;
    protected View JcM;
    protected float dx = -1.0f;
    protected float zR = -1.0f;
    protected float ib = -1.0f;
    protected float kF = -1.0f;
    protected long uP = -1;
    protected long wE = -1;
    protected int ley = -1;
    protected int LqL = -1024;
    protected int Yf = -1;
    protected boolean fF = true;
    public SparseArray<Sj> WMZ = new SparseArray<>();
    private int vS = 0;
    private int Jcg = 0;

    public static class Sj {
        public long EjP;
        public int Sj;
        public double TKC;
        public double sP;

        public Sj(int i, double d, double d2, long j) {
            this.Sj = i;
            this.sP = d;
            this.TKC = d2;
            this.EjP = j;
        }
    }

    static {
        if (dNu.Sj() != null) {
            LD = dNu.sP();
        }
        Sj = 0.0f;
        sP = 0.0f;
        TKC = 0.0f;
        EjP = 0.0f;
        HiB = 0L;
    }

    private boolean Sj(View view, Point point) {
        int i;
        int i2;
        int i3;
        int i4;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i8 = 0; i8 < viewGroup.getChildCount(); i8++) {
                View childAt = viewGroup.getChildAt(i8);
                if (sP.TKC(childAt)) {
                    int[] iArr = new int[2];
                    childAt.getLocationOnScreen(iArr);
                    return view.isShown() && (i = point.x) >= (i2 = iArr[0]) && i <= i2 + childAt.getWidth() && (i3 = point.y) >= (i4 = iArr[1]) && i3 <= i4 + childAt.getHeight();
                }
                if (Sj(childAt, point)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean Jcg() {
        return this.fF;
    }

    protected abstract void Sj(View view, float f, float f2, float f3, float f4, SparseArray<Sj> sparseArray, boolean z);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (uA.Sj()) {
            Sj(view, this.dx, this.zR, this.ib, this.kF, this.WMZ, this.fF);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x006f, code lost:
    
        if (com.bytedance.sdk.openadsdk.core.sP.TKC.EjP <= r3) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int i;
        this.LqL = motionEvent.getDeviceId();
        this.ley = motionEvent.getToolType(0);
        this.Yf = motionEvent.getSource();
        int actionMasked = motionEvent.getActionMasked();
        int i2 = 1;
        if (actionMasked != 0) {
            int i3 = 3;
            if (actionMasked == 1) {
                this.ib = motionEvent.getRawX();
                this.kF = motionEvent.getRawY();
                this.wE = System.currentTimeMillis();
                if (Math.abs(this.ib - this.vS) >= LD || Math.abs(this.kF - this.Jcg) >= LD) {
                    this.fF = false;
                }
                Point point = new Point((int) this.ib, (int) this.kF);
                if (view != null && !sP.TKC(view) && Sj((View) view.getParent(), point)) {
                    return true;
                }
            } else if (actionMasked != 2) {
                i3 = actionMasked != 3 ? -1 : 4;
            } else {
                TKC += Math.abs(motionEvent.getX() - Sj);
                EjP += Math.abs(motionEvent.getY() - sP);
                Sj = motionEvent.getX();
                sP = motionEvent.getY();
                if (System.currentTimeMillis() - HiB > 200) {
                    float f = TKC;
                    int i4 = LD;
                    if (f <= i4) {
                    }
                    this.ib = motionEvent.getRawX();
                    this.kF = motionEvent.getRawY();
                    if (Math.abs(this.ib - this.vS) < LD || Math.abs(this.kF - this.Jcg) >= LD) {
                        this.fF = false;
                    }
                    i = i2;
                }
                i2 = 2;
                this.ib = motionEvent.getRawX();
                this.kF = motionEvent.getRawY();
                if (Math.abs(this.ib - this.vS) < LD) {
                }
                this.fF = false;
                i = i2;
            }
            i = i3;
        } else {
            this.vS = (int) motionEvent.getRawX();
            this.Jcg = (int) motionEvent.getRawY();
            this.dx = motionEvent.getRawX();
            this.zR = motionEvent.getRawY();
            this.uP = System.currentTimeMillis();
            this.ley = motionEvent.getToolType(0);
            this.LqL = motionEvent.getDeviceId();
            this.Yf = motionEvent.getSource();
            HiB = System.currentTimeMillis();
            this.fF = true;
            this.JcM = view;
            com.bytedance.sdk.openadsdk.core.uA.TKC.Sj(motionEvent);
            i = 0;
        }
        this.WMZ.put(motionEvent.getActionMasked(), new Sj(i, motionEvent.getSize(), motionEvent.getPressure(), System.currentTimeMillis()));
        return false;
    }
}
