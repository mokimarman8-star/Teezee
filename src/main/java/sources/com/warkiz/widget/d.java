package com.warkiz.widget;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class d {
    private ArrowView c;
    private TextView d;
    private PopupWindow e;
    private LinearLayout f;
    private int g;
    private int h;
    private Context i;
    private int j;
    private IndicatorSeekBar k;
    private View l;
    private View m;
    private View n;
    private float o;
    private int p;
    private int[] b = new int[2];
    private final int a = e();

    public d(Context context, IndicatorSeekBar indicatorSeekBar, int i, int i2, int i3, int i4, View view, View view2) {
        this.i = context;
        this.k = indicatorSeekBar;
        this.h = i;
        this.j = i2;
        this.m = view;
        this.n = view2;
        this.o = i3;
        this.p = i4;
        this.g = g.a(this.i, 2.0f);
        h();
    }

    private void a(float f) {
        int i = this.j;
        if (i == 4 || i == 1) {
            return;
        }
        if (c() + f < this.e.getContentView().getMeasuredWidth() / 2) {
            k(this.c, -((int) (((this.e.getContentView().getMeasuredWidth() / 2) - r0) - f)), -1, -1, -1);
        } else if ((this.a - r0) - f < this.e.getContentView().getMeasuredWidth() / 2) {
            k(this.c, (int) ((this.e.getContentView().getMeasuredWidth() / 2) - ((this.a - r0) - f)), -1, -1, -1);
        } else {
            k(this.c, 0, 0, 0, 0);
        }
    }

    private GradientDrawable b() {
        GradientDrawable gradientDrawable = this.j == 2 ? (GradientDrawable) this.i.getResources().getDrawable(R$drawable.isb_indicator_rounded_corners) : (GradientDrawable) this.i.getResources().getDrawable(R$drawable.isb_indicator_square_corners);
        gradientDrawable.setColor(this.h);
        return gradientDrawable;
    }

    private int c() {
        this.k.getLocationOnScreen(this.b);
        return this.b[0];
    }

    private int e() {
        WindowManager windowManager = (WindowManager) this.i.getSystemService("window");
        if (windowManager != null) {
            return windowManager.getDefaultDisplay().getWidth();
        }
        return 0;
    }

    private void h() {
        View findViewById;
        int i = this.j;
        if (i == 4) {
            View view = this.m;
            if (view == null) {
                throw new IllegalArgumentException("the attr：indicator_custom_layout must be set while you set the indicator type to CUSTOM.");
            }
            this.l = view;
            int identifier = this.i.getResources().getIdentifier("isb_progress", "id", this.i.getApplicationContext().getPackageName());
            if (identifier <= 0 || (findViewById = this.l.findViewById(identifier)) == null) {
                return;
            }
            if (!(findViewById instanceof TextView)) {
                throw new ClassCastException("the view identified by isb_progress in indicator custom layout can not be cast to TextView");
            }
            TextView textView = (TextView) findViewById;
            this.d = textView;
            textView.setText(this.k.getIndicatorTextString());
            this.d.setTextSize(g.b(this.i, this.o));
            this.d.setTextColor(this.p);
            return;
        }
        if (i == 1) {
            CircleBubbleView circleBubbleView = new CircleBubbleView(this.i, this.o, this.p, this.h, "1000");
            this.l = circleBubbleView;
            circleBubbleView.setProgress(this.k.getIndicatorTextString());
            return;
        }
        View inflate = View.inflate(this.i, R$layout.isb_indicator, null);
        this.l = inflate;
        this.f = (LinearLayout) inflate.findViewById(R$id.indicator_container);
        ArrowView arrowView = (ArrowView) this.l.findViewById(R$id.indicator_arrow);
        this.c = arrowView;
        arrowView.setColor(this.h);
        TextView textView2 = (TextView) this.l.findViewById(R$id.isb_progress);
        this.d = textView2;
        textView2.setText(this.k.getIndicatorTextString());
        this.d.setTextSize(g.b(this.i, this.o));
        this.d.setTextColor(this.p);
        this.f.setBackground(b());
        if (this.n != null) {
            int identifier2 = this.i.getResources().getIdentifier("isb_progress", "id", this.i.getApplicationContext().getPackageName());
            View view2 = this.n;
            if (identifier2 <= 0) {
                m(view2);
                return;
            }
            View findViewById2 = view2.findViewById(identifier2);
            if (findViewById2 == null || !(findViewById2 instanceof TextView)) {
                m(view2);
            } else {
                n(view2, (TextView) findViewById2);
            }
        }
    }

    private void k(View view, int i, int i2, int i3, int i4) {
        if (view != null && (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (i == -1) {
                i = marginLayoutParams.leftMargin;
            }
            if (i2 == -1) {
                i2 = marginLayoutParams.topMargin;
            }
            if (i3 == -1) {
                i3 = marginLayoutParams.rightMargin;
            }
            if (i4 == -1) {
                i4 = marginLayoutParams.bottomMargin;
            }
            marginLayoutParams.setMargins(i, i2, i3, i4);
            view.requestLayout();
        }
    }

    View d() {
        return this.l;
    }

    void f() {
        PopupWindow popupWindow = this.e;
        if (popupWindow == null) {
            return;
        }
        popupWindow.dismiss();
    }

    void g() {
        View view;
        if (this.e != null || this.j == 0 || (view = this.l) == null) {
            return;
        }
        view.measure(0, 0);
        this.e = new PopupWindow(this.l, -2, -2, false);
    }

    boolean i() {
        PopupWindow popupWindow = this.e;
        return popupWindow != null && popupWindow.isShowing();
    }

    void j() {
        String indicatorTextString = this.k.getIndicatorTextString();
        View view = this.l;
        if (view instanceof CircleBubbleView) {
            ((CircleBubbleView) view).setProgress(indicatorTextString);
            return;
        }
        TextView textView = this.d;
        if (textView != null) {
            textView.setText(indicatorTextString);
        }
    }

    void l(String str) {
        View view = this.l;
        if (view instanceof CircleBubbleView) {
            ((CircleBubbleView) view).setProgress(str);
            return;
        }
        TextView textView = this.d;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void m(View view) {
        n(view, null);
    }

    public void n(View view, TextView textView) {
        this.d = textView;
        this.f.removeAllViews();
        view.setBackground(b());
        this.f.addView(view);
    }

    void o(float f) {
        if (this.k.isEnabled() && this.k.getVisibility() == 0) {
            j();
            PopupWindow popupWindow = this.e;
            if (popupWindow != null) {
                popupWindow.getContentView().measure(0, 0);
                this.e.showAsDropDown(this.k, (int) (f - (r0.getContentView().getMeasuredWidth() / 2.0f)), -(((this.k.getMeasuredHeight() + this.e.getContentView().getMeasuredHeight()) - this.k.getPaddingTop()) + this.g));
                a(f);
            }
        }
    }

    void p(float f) {
        if (this.k.isEnabled() && this.k.getVisibility() == 0) {
            j();
            PopupWindow popupWindow = this.e;
            if (popupWindow != null) {
                popupWindow.getContentView().measure(0, 0);
                this.e.update(this.k, (int) (f - (r2.getContentView().getMeasuredWidth() / 2)), -(((this.k.getMeasuredHeight() + this.e.getContentView().getMeasuredHeight()) - this.k.getPaddingTop()) + this.g), -1, -1);
                a(f);
            }
        }
    }

    void q(int i) {
        k(this.c, i, -1, -1, -1);
    }

    void r(int i) {
        k(this.l, i, -1, -1, -1);
    }
}
