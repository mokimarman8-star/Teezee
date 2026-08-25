package com.tn.lib.widget.toast.core;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import gh.a;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class b implements gh.a {
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

    @Override // gh.a
    public boolean a() {
        return this.c == null;
    }

    @Override // gh.a
    public void b(View view) {
        this.b = view;
        if (view == null) {
            this.c = null;
        } else {
            Intrinsics.e(view);
            this.c = d(view);
        }
    }

    @Override // gh.a
    public View c() {
        return this.b;
    }

    @Override // gh.a
    public void cancel() {
        ToastImpl toastImpl = this.a;
        if (toastImpl != null) {
            toastImpl.e();
        }
    }

    public TextView d(View view) {
        return a.C0048a.a(this, view);
    }

    public final void e(View view) {
        Intrinsics.h(view, "view");
        this.b = view;
    }

    @Override // gh.a
    public int getDuration() {
        return this.e;
    }

    @Override // gh.a
    public int getGravity() {
        return this.d;
    }

    @Override // gh.a
    public float getHorizontalMargin() {
        return this.h;
    }

    @Override // gh.a
    public float getVerticalMargin() {
        return this.i;
    }

    @Override // gh.a
    public int getXOffset() {
        return this.f;
    }

    @Override // gh.a
    public int getYOffset() {
        return this.g;
    }

    @Override // gh.a
    public void setDuration(int i) {
        this.e = i;
    }

    @Override // gh.a
    public void setGravity(int i, int i2, int i3) {
        this.d = i;
        this.f = i2;
        this.g = i3;
    }

    @Override // gh.a
    public void setMargin(float f, float f2) {
        this.h = f;
        this.i = f2;
    }

    @Override // gh.a
    public void setText(CharSequence charSequence) {
        TextView textView = this.c;
        if (textView == null) {
            return;
        }
        Intrinsics.e(textView);
        textView.setText(charSequence);
    }

    @Override // gh.a
    public void show() {
        ToastImpl toastImpl = this.a;
        if (toastImpl != null) {
            toastImpl.h();
        }
    }
}
