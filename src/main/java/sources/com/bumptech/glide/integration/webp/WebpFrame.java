package com.bumptech.glide.integration.webp;

import android.graphics.Bitmap;
import androidx.annotation.Keep;

@Keep
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class WebpFrame {
    static final int FRAME_DURATION_MS_FOR_MIN = 100;
    static final int MIN_FRAME_DURATION_MS = 20;
    boolean blendPreviousFrame;
    int delay;
    boolean disposeBackgroundColor;

    /* renamed from: ih, reason: collision with root package name */
    int f2ih;
    int iw;

    /* renamed from: ix, reason: collision with root package name */
    int f3ix;
    int iy;

    @Keep
    private long mNativePtr;

    WebpFrame(long j, int i, int i2, int i3, int i4, int i6, boolean z, boolean z2) {
        this.mNativePtr = j;
        this.f3ix = i;
        this.iy = i2;
        this.iw = i3;
        this.f2ih = i4;
        this.delay = i6;
        this.blendPreviousFrame = z;
        this.disposeBackgroundColor = z2;
        fixFrameDuration();
    }

    private void fixFrameDuration() {
        if (this.delay < 20) {
            this.delay = 100;
        }
    }

    private native void nativeDispose();

    private native void nativeFinalize();

    private native void nativeRenderFrame(int i, int i2, Bitmap bitmap);

    public void dispose() {
        nativeDispose();
    }

    protected void finalize() throws Throwable {
        nativeFinalize();
    }

    public int getDurationMs() {
        return this.delay;
    }

    public int getHeight() {
        return this.f2ih;
    }

    public int getWidth() {
        return this.iw;
    }

    public int getXOffest() {
        return this.f3ix;
    }

    public int getYOffest() {
        return this.iy;
    }

    public boolean isBlendWithPreviousFrame() {
        return this.blendPreviousFrame;
    }

    public void renderFrame(int i, int i2, Bitmap bitmap) {
        nativeRenderFrame(i, i2, bitmap);
    }

    public boolean shouldDisposeToBackgroundColor() {
        return this.disposeBackgroundColor;
    }
}
