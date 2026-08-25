package com.transsion.photoview;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.transsion.gslb.BuildConfig;
import com.transsion.gslb.Utils;
import java.lang.ref.WeakReference;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class n {
    private final int a;
    private float b;
    private final int c;
    private float d = 1.0f;
    private final WeakReference e;
    private i f;
    private boolean g;
    private int h;

    public n(final ImageView imageView) {
        this.e = new WeakReference(imageView);
        int c = o.c(imageView.getContext());
        this.c = c;
        this.a = (int) (c * 0.15d);
        imageView.post(new Runnable() { // from class: com.transsion.photoview.m
            @Override // java.lang.Runnable
            public final void run() {
                n.this.j(imageView);
            }
        });
    }

    private void c(float f, float f2) {
        ImageView imageView = (ImageView) this.e.get();
        if (imageView == null) {
            return;
        }
        if (Math.abs(f2) < this.c / 4.0f) {
            float abs = 1.0f - (Math.abs(f2) / this.c);
            this.d = 1.0f - (Math.abs(f2) / (this.c / 3.0f));
            imageView.setScaleX(abs);
            imageView.setScaleY(abs);
            ((ViewGroup) imageView.getParent()).setBackgroundColor(f(this.d));
        }
        imageView.setTranslationY(f2);
    }

    private int f(float f) {
        int min = (int) (Math.min(1.0f, Math.max(0.0f, f)) * 255.0f);
        if (min <= 102) {
            return this.h;
        }
        String lowerCase = Integer.toHexString(min).toLowerCase();
        StringBuilder sb = new StringBuilder();
        sb.append(Utils.SEPARATOR);
        sb.append(lowerCase.length() < 2 ? "0" : BuildConfig.FLAVOR);
        sb.append(lowerCase);
        sb.append("000000");
        int parseColor = Color.parseColor(sb.toString());
        this.h = parseColor;
        return parseColor;
    }

    private void g() {
        ImageView imageView = (ImageView) this.e.get();
        if (imageView == null) {
            return;
        }
        i iVar = this.f;
        if (iVar != null) {
            iVar.a();
        }
        try {
            ((Activity) imageView.getContext()).finish();
            ((Activity) imageView.getContext()).overridePendingTransition(0, 0);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(ImageView imageView, ValueAnimator valueAnimator) {
        if (this.d < valueAnimator.getAnimatedFraction()) {
            ((ViewGroup) imageView.getParent()).setBackgroundColor(f(valueAnimator.getAnimatedFraction()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(ImageView imageView) {
        ((ViewGroup) imageView.getParent()).setBackgroundColor(f(this.d));
    }

    public void d() {
        final ImageView imageView = (ImageView) this.e.get();
        if (imageView != null && this.g) {
            this.g = false;
            if (Math.abs(this.b) <= this.a) {
                imageView.animate().setDuration(200L).scaleX(1.0f).scaleY(1.0f).translationX(0.0f).translationY(0.0f).setUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.transsion.photoview.l
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        n.this.i(imageView, valueAnimator);
                    }
                }).start();
            } else {
                this.b = 0.0f;
                g();
            }
        }
    }

    public void e(float f, float f2, float f3) {
        if (Math.abs(f - 1.0f) != 0.0f) {
            return;
        }
        this.b = f3;
        if (Math.abs(f3) > 50.0f) {
            this.g = true;
            c(f2, this.b);
        }
    }

    public boolean h() {
        return this.g;
    }

    public void k(i iVar) {
        this.f = iVar;
    }
}
