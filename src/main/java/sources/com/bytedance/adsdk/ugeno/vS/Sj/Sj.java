package com.bytedance.adsdk.ugeno.vS.Sj;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.adsdk.ugeno.Jcg.Dq;
import com.bytedance.adsdk.ugeno.vS.EjP;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Sj extends LinearLayout {
    private boolean Dq;
    private Context EjP;
    private int HiB;
    private int Jcg;
    private List<View> Sj;
    private int TKC;
    private int sP;
    private int uA;
    private int vS;

    public Sj(Context context) {
        super(context);
        this.sP = -65536;
        this.TKC = -16776961;
        this.HiB = 5;
        this.vS = 20;
        this.Jcg = 20;
        this.EjP = context;
        this.Sj = new ArrayList();
        Sj();
    }

    private GradientDrawable sP(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(i);
        return gradientDrawable;
    }

    public void Sj() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        setGravity(17);
        setOrientation(0);
        layoutParams.bottomMargin = (int) Dq.Sj(this.EjP, 10.0f);
        setLayoutParams(layoutParams);
    }

    public void Sj(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.vS, this.Jcg);
        int i2 = this.HiB;
        layoutParams.leftMargin = i2;
        layoutParams.rightMargin = i2;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.vS, this.Jcg);
        int i3 = this.HiB;
        layoutParams2.leftMargin = i3;
        layoutParams2.rightMargin = i3;
        int Sj = EjP.Sj(this.Dq, this.uA, this.Sj.size());
        int Sj2 = EjP.Sj(this.Dq, i, this.Sj.size());
        if (this.Sj.size() == 0) {
            Sj2 = 0;
        }
        if (!this.Sj.isEmpty() && EjP.Sj(Sj, this.Sj) && EjP.Sj(Sj2, this.Sj)) {
            this.Sj.get(Sj).setBackground(sP(this.TKC));
            this.Sj.get(Sj).setLayoutParams(layoutParams2);
            this.Sj.get(Sj2).setBackground(sP(this.sP));
            this.Sj.get(Sj2).setLayoutParams(layoutParams);
            this.uA = i;
        }
    }

    public void Sj(int i, int i2) {
        Iterator<View> it = this.Sj.iterator();
        while (it.hasNext()) {
            it.next().setBackground(sP(this.TKC));
        }
        if (i < 0 || i >= this.Sj.size()) {
            i = 0;
        }
        if (this.Sj.size() > 0) {
            this.Sj.get(i).setBackground(sP(this.sP));
            this.uA = i2;
        }
    }

    public int getSize() {
        return this.Sj.size();
    }

    public void sP() {
        View view = new View(getContext());
        view.setClickable(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.vS, this.Jcg);
        int i = this.HiB;
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i;
        addView(view, layoutParams);
        view.setBackground(sP(this.TKC));
        this.Sj.add(view);
    }

    public void setLoop(boolean z) {
        this.Dq = z;
    }

    public void setSelectedColor(int i) {
        this.sP = i;
    }

    public void setUnSelectedColor(int i) {
        this.TKC = i;
    }
}
