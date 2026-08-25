package com.transsion.shorttv_pugc.base.widget.toast.core;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;
import os.a;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class b implements os.a {
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

    @Override // os.a
    public boolean a() {
        return this.c == null;
    }

    public TextView b(View view) {
        return a.C0094a.a(this, view);
    }

    @Override // os.a
    public void cancel() {
        ToastImpl toastImpl = this.a;
        if (toastImpl != null) {
            toastImpl.e();
        }
    }

    @Override // os.a
    public int getDuration() {
        return this.e;
    }

    @Override // os.a
    public int getGravity() {
        return this.d;
    }

    @Override // os.a
    public float getHorizontalMargin() {
        return this.h;
    }

    @Override // os.a
    public float getVerticalMargin() {
        return this.i;
    }

    @Override // os.a
    public View getView() {
        return this.b;
    }

    @Override // os.a
    public int getXOffset() {
        return this.f;
    }

    @Override // os.a
    public int getYOffset() {
        return this.g;
    }

    @Override // os.a
    public void setDuration(int i) {
        this.e = i;
    }

    @Override // os.a
    public void setGravity(int i, int i2, int i3) {
        this.d = i;
        this.f = i2;
        this.g = i3;
    }

    @Override // os.a
    public void setMargin(float f, float f2) {
        this.h = f;
        this.i = f2;
    }

    @Override // os.a
    public void setText(CharSequence charSequence) {
        TextView textView = this.c;
        if (textView == null) {
            return;
        }
        Intrinsics.e(textView);
        textView.setText(charSequence);
    }

    @Override // os.a
    public void setView(View view) {
        this.b = view;
        if (view == null) {
            this.c = null;
        } else {
            Intrinsics.e(view);
            this.c = b(view);
        }
    }

    @Override // os.a
    public void show() {
        ToastImpl toastImpl = this.a;
        if (toastImpl != null) {
            toastImpl.h();
        }
    }
}
