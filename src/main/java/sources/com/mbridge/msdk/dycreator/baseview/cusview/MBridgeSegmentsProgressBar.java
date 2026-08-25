package com.mbridge.msdk.dycreator.baseview.cusview;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.mbridge.msdk.foundation.tools.g0;
import com.mbridge.msdk.foundation.tools.o0;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class MBridgeSegmentsProgressBar extends LinearLayout {
    private final String a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private List<ProgressBar> i;
    private TextView j;
    private String k;
    private boolean l;

    public MBridgeSegmentsProgressBar(Context context) {
        super(context);
        this.a = "MBridgeSegmentsProgressBar";
        this.c = 1;
        this.d = 20;
        this.e = 10;
        this.f = 1;
        this.g = -1711276033;
        this.h = -1;
        this.i = new ArrayList();
        this.l = false;
    }

    public MBridgeSegmentsProgressBar(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = "MBridgeSegmentsProgressBar";
        this.c = 1;
        this.d = 20;
        this.e = 10;
        this.f = 1;
        this.g = -1711276033;
        this.h = -1;
        this.i = new ArrayList();
        this.l = false;
    }

    public MBridgeSegmentsProgressBar(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = "MBridgeSegmentsProgressBar";
        this.c = 1;
        this.d = 20;
        this.e = 10;
        this.f = 1;
        this.g = -1711276033;
        this.h = -1;
        this.i = new ArrayList();
        this.l = false;
    }

    public MBridgeSegmentsProgressBar(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.a = "MBridgeSegmentsProgressBar";
        this.c = 1;
        this.d = 20;
        this.e = 10;
        this.f = 1;
        this.g = -1711276033;
        this.h = -1;
        this.i = new ArrayList();
        this.l = false;
    }

    private StringBuilder a(int i) {
        StringBuilder sb2 = new StringBuilder();
        try {
            sb2.append(String.format(this.k, Integer.valueOf(i), Integer.valueOf(this.b)));
        } catch (Throwable th) {
            sb2.append(this.b);
            sb2.append("videos, the");
            sb2.append(i);
            sb2.append(" is playing.");
            o0.b("MBridgeSegmentsProgressBar", th.getMessage());
        }
        return sb2;
    }

    private void a() {
        Drawable drawable;
        try {
            this.l = getContext().getResources().getConfiguration().locale.getLanguage().contains("zh");
        } catch (Throwable th) {
            o0.b("MBridgeSegmentsProgressBar", th.getMessage());
        }
        try {
            if (this.c == 1) {
                setOrientation(1);
                if (TextUtils.isEmpty(this.k)) {
                    this.k = this.l ? "正在播放第%s个，共%s个视频" : "The %s is playing, %s videos.";
                }
            }
            if (this.c == 2) {
                setOrientation(0);
                if (TextUtils.isEmpty(this.k)) {
                    this.k = this.l ? "广告 %s/%s" : "ADS %s/%s";
                }
            }
            this.i.clear();
            removeAllViews();
            setBackground(getBackgroundDrawable());
            TextView textView = new TextView(getContext());
            this.j = textView;
            textView.setTextColor(-1);
            this.j.setTextSize(12.0f);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            this.j.setLayoutParams(layoutParams);
            if (this.c == 1) {
                layoutParams.gravity = 5;
                TextView textView2 = this.j;
                int i = this.d;
                textView2.setPadding(i / 2, 15, i / 2, 5);
            }
            if (this.c == 2) {
                this.j.setGravity(16);
                TextView textView3 = this.j;
                int i2 = this.d;
                textView3.setPadding(i2 / 2, 0, i2 / 2, 0);
            }
            try {
                int a = g0.a(getContext(), "mbridge_reward_video_icon", "drawable");
                if (g0.a(a) && (drawable = getContext().getResources().getDrawable(a)) != null) {
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    this.j.setCompoundDrawables(drawable, null, null, null);
                    this.j.setCompoundDrawablePadding(5);
                }
            } catch (Throwable th2) {
                o0.b("MBridgeSegmentsProgressBar", th2.getMessage());
            }
            this.j.setText(a(this.f));
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(0);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 25);
            linearLayout.setLayoutParams(layoutParams2);
            for (int i3 = 0; i3 < this.b; i3++) {
                ProgressBar progressBar = new ProgressBar(getContext(), null, R.attr.progressBarStyleHorizontal);
                progressBar.setMax(100);
                progressBar.setProgress(0);
                progressBar.setProgressDrawable(getSegmentLayerDrawable());
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, 20, 1.0f);
                int i4 = this.d;
                layoutParams3.leftMargin = i4 / 2;
                layoutParams3.rightMargin = i4 / 2;
                progressBar.setLayoutParams(layoutParams3);
                linearLayout.addView(progressBar);
                this.i.add(progressBar);
            }
            int i5 = this.c;
            if (i5 == 1) {
                setPadding(15, 10, 15, 25);
                addView(this.j);
                addView(linearLayout);
            } else {
                if (i5 != 2) {
                    addView(linearLayout);
                    return;
                }
                setPadding(15, 0, 15, 25);
                layoutParams2.gravity = 16;
                layoutParams2.weight = 1.0f;
                addView(linearLayout);
                addView(this.j);
            }
        } catch (Throwable th3) {
            o0.b("MBridgeSegmentsProgressBar", th3.getMessage());
        }
    }

    private GradientDrawable getBackgroundDrawable() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setGradientType(0);
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        gradientDrawable.setDither(true);
        gradientDrawable.setColors(new int[]{0, 1291845632});
        return gradientDrawable;
    }

    private LayerDrawable getSegmentLayerDrawable() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(this.e);
        gradientDrawable.setColor(this.g);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setCornerRadius(this.e);
        gradientDrawable2.setColor(this.h);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawable, new ScaleDrawable(gradientDrawable2, 3, 1.0f, -1.0f)});
        layerDrawable.setId(0, R.id.background);
        layerDrawable.setId(1, R.id.progress);
        return layerDrawable;
    }

    public void dismiss() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(1000L);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.dycreator.baseview.cusview.MBridgeSegmentsProgressBar.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                MBridgeSegmentsProgressBar.this.setVisibility(8);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        startAnimation(alphaAnimation);
    }

    public void init(int i, int i2) {
        this.b = i;
        this.c = i2;
        a();
    }

    public void init(int i, int i2, int i3, int i4) {
        this.b = i;
        this.c = i2;
        this.h = i3;
        this.g = i4;
        a();
    }

    public void init(int i, int i2, int i3, int i4, int i5, int i6) {
        this.b = i;
        this.c = i2;
        this.h = i3;
        this.g = i4;
        this.d = i5;
        this.e = i6;
        a();
    }

    public void setIndicatorText(String str) {
        this.k = str;
    }

    public void setProgress(int i, int i2) {
        try {
            if (this.i.size() == 0) {
                return;
            }
            if (i2 < this.i.size()) {
                this.i.get(i2).setProgress(i);
            }
            int i3 = i2 + 1;
            if (i3 > this.f) {
                this.f = i3;
                TextView textView = this.j;
                if (textView != null) {
                    textView.setText(a(i3));
                }
            }
        } catch (Throwable th) {
            o0.b("MBridgeSegmentsProgressBar", th.getMessage());
        }
    }
}
