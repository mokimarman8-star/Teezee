package com.transsion.shorttv.base.widget.toast.core;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;
import kr.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b implements kr.a {
    private ToastImpl a;
    private View b;
    private TextView c;
    private int d;
    private int e;
    private int f;
    private int g;
    private float h;
    private float i;

    public b(Activity activity) {
        this.a = new ToastImpl(activity, this);
    }

    @Override // kr.a
    public boolean a() {
        return this.c == null;
    }

    public TextView b(View view) {
        return a.C0083a.a(this, view);
    }

    @Override // kr.a
    public void cancel() {
        ToastImpl toastImpl = this.a;
        if (toastImpl != null) {
            toastImpl.e();
        }
    }

    @Override // kr.a
    public int getDuration() {
        return this.e;
    }

    @Override // kr.a
    public int getGravity() {
        return this.d;
    }

    @Override // kr.a
    public float getHorizontalMargin() {
        return this.h;
    }

    @Override // kr.a
    public float getVerticalMargin() {
        return this.i;
    }

    @Override // kr.a
    public View getView() {
        return this.b;
    }

    @Override // kr.a
    public int getXOffset() {
        return this.f;
    }

    @Override // kr.a
    public int getYOffset() {
        return this.g;
    }

    @Override // kr.a
    public void setDuration(int i) {
        this.e = i;
    }

    @Override // kr.a
    public void setGravity(int i, int i2, int i3) {
        this.d = i;
        this.f = i2;
        this.g = i3;
    }

    @Override // kr.a
    public void setMargin(float f, float f2) {
        this.h = f;
        this.i = f2;
    }

    @Override // kr.a
    public void setText(CharSequence charSequence) {
        TextView textView = this.c;
        if (textView == null) {
            return;
        }
        Intrinsics.e(textView);
        textView.setText(charSequence);
    }

    @Override // kr.a
    public void setView(View view) {
        this.b = view;
        if (view == null) {
            this.c = null;
        } else {
            Intrinsics.e(view);
            this.c = b(view);
        }
    }

    @Override // kr.a
    public void show() {
        ToastImpl toastImpl = this.a;
        if (toastImpl != null) {
            toastImpl.h();
        }
    }
}
