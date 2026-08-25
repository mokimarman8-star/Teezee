package com.cloud.tmc.miniapp.utils.toast;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.cloud.tmc.miniapp.utils.toast.config.IToast;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public abstract class CustomToast implements IToast {
    private int mAnimationId;
    private int mDuration;
    private int mGravity;
    private float mHorizontalMargin;
    private TextView mMessageView;
    private ToastParams mToastParams;
    private float mVerticalMargin;
    private View mView;
    private int mXOffset;
    private int mYOffset;
    private long mShortDuration = ToastStrategy.SHORT_DURATION_TIMEOUT;
    private long mLongDuration = ToastStrategy.LONG_DURATION_TIMEOUT;

    @Override // com.cloud.tmc.miniapp.utils.toast.config.IToast
    public ImageView findIconView(View view) {
        return IToast.DefaultImpls.findIconView(this, view);
    }

    @Override // com.cloud.tmc.miniapp.utils.toast.config.IToast
    public TextView findMessageView(View view) {
        return IToast.DefaultImpls.findMessageView(this, view);
    }

    public final int getAnimationId() {
        return this.mAnimationId;
    }

    @Override // com.cloud.tmc.miniapp.utils.toast.config.IToast
    public int getDuration() {
        return this.mDuration;
    }

    @Override // com.cloud.tmc.miniapp.utils.toast.config.IToast
    public int getGravity() {
        return this.mGravity;
    }

    @Override // com.cloud.tmc.miniapp.utils.toast.config.IToast
    public float getHorizontalMargin() {
        return this.mHorizontalMargin;
    }

    public final long getLongDuration() {
        return this.mLongDuration;
    }

    public final long getShortDuration() {
        return this.mShortDuration;
    }

    public final ToastParams getToastParams() {
        return this.mToastParams;
    }

    @Override // com.cloud.tmc.miniapp.utils.toast.config.IToast
    public float getVerticalMargin() {
        return this.mVerticalMargin;
    }

    @Override // com.cloud.tmc.miniapp.utils.toast.config.IToast
    public View getView() {
        return this.mView;
    }

    @Override // com.cloud.tmc.miniapp.utils.toast.config.IToast
    public int getXOffset() {
        return this.mXOffset;
    }

    @Override // com.cloud.tmc.miniapp.utils.toast.config.IToast
    public int getYOffset() {
        return this.mYOffset;
    }

    public abstract boolean isShow();

    public final void setAnimationId(int i) {
        this.mAnimationId = i;
    }

    @Override // com.cloud.tmc.miniapp.utils.toast.config.IToast
    public void setDuration(int i) {
        this.mDuration = i;
    }

    @Override // com.cloud.tmc.miniapp.utils.toast.config.IToast
    public void setGravity(int i, int i2, int i3) {
        this.mGravity = i;
        this.mXOffset = i2;
        this.mYOffset = i3;
    }

    public final void setLongDuration(long j) {
        this.mLongDuration = j;
    }

    @Override // com.cloud.tmc.miniapp.utils.toast.config.IToast
    public void setMargin(float f, float f2) {
        this.mHorizontalMargin = f;
        this.mVerticalMargin = f2;
    }

    public final void setShortDuration(long j) {
        this.mShortDuration = j;
    }

    @Override // com.cloud.tmc.miniapp.utils.toast.config.IToast
    public void setText(int i) {
        View view = this.mView;
        if (view != null) {
            setText(view.getResources().getText(i));
        }
    }

    @Override // com.cloud.tmc.miniapp.utils.toast.config.IToast
    public void setText(CharSequence charSequence) {
        TextView textView = this.mMessageView;
        if (textView == null) {
            return;
        }
        textView.setText(charSequence);
    }

    public final void setToastParams(ToastParams toastParams) {
        Intrinsics.h(toastParams, "params");
        this.mToastParams = toastParams;
    }

    @Override // com.cloud.tmc.miniapp.utils.toast.config.IToast
    public void setView(View view) {
        this.mView = view;
        if (view == null) {
            this.mMessageView = null;
        } else {
            this.mMessageView = findMessageView(view);
        }
    }
}
