package com.transsion.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class PhotoView extends AppCompatImageView {
    private PhotoViewAttachment d;
    private ImageView.ScaleType e;

    public PhotoView(Context context) {
        this(context, null);
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a() {
        this.d = new PhotoViewAttachment(this);
        super/*android.widget.ImageView*/.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType scaleType = this.e;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.e = null;
        }
    }

    public PhotoViewAttachment getAttachment() {
        return this.d;
    }

    public void getDisplayMatrix(Matrix matrix) {
        this.d.C(matrix);
    }

    public RectF getDisplayRect() {
        return this.d.D();
    }

    public Matrix getImageMatrix() {
        return this.d.G();
    }

    public float getMaximumScale() {
        return this.d.J();
    }

    public float getMediumScale() {
        return this.d.K();
    }

    public float getMinimumScale() {
        return this.d.L();
    }

    public float getScale() {
        return this.d.M();
    }

    public ImageView.ScaleType getScaleType() {
        return this.d.N();
    }

    public void getSuppMatrix(Matrix matrix) {
        this.d.O(matrix);
    }

    public boolean isZoomable() {
        return this.d.R();
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.d.T(z);
    }

    public boolean setDisplayMatrix(Matrix matrix) {
        return this.d.U(matrix);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super/*android.widget.ImageView*/.setFrame(i, i2, i3, i4);
        if (frame) {
            this.d.t0();
        }
        return frame;
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        PhotoViewAttachment photoViewAttachment = this.d;
        if (photoViewAttachment != null) {
            photoViewAttachment.t0();
        }
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        PhotoViewAttachment photoViewAttachment = this.d;
        if (photoViewAttachment != null) {
            photoViewAttachment.t0();
        }
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        PhotoViewAttachment photoViewAttachment = this.d;
        if (photoViewAttachment != null) {
            photoViewAttachment.t0();
        }
    }

    public void setMaximumScale(float f) {
        this.d.W(f);
    }

    public void setMediumScale(float f) {
        this.d.X(f);
    }

    public void setMinimumScale(float f) {
        this.d.Y(f);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.d.Z(onClickListener);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.d.a0(onDoubleTapListener);
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.d.b0(onLongClickListener);
    }

    public void setOnMatrixChangeListener(d dVar) {
        this.d.c0(dVar);
    }

    public void setOnOutsidePhotoTapListener(e eVar) {
        this.d.d0(eVar);
    }

    public void setOnPhotoTapListener(f fVar) {
        this.d.e0(fVar);
    }

    public void setOnScaleChangeListener(g gVar) {
        this.d.f0(gVar);
    }

    public void setOnSingleFlingListener(h hVar) {
        this.d.g0(hVar);
    }

    public void setOnViewDragListener(j jVar) {
        this.d.h0(jVar);
    }

    public void setOnViewTapListener(k kVar) {
        this.d.i0(kVar);
    }

    public void setRotationBy(float f) {
        this.d.j0(f);
    }

    public void setRotationTo(float f) {
        this.d.k0(f);
    }

    public void setScale(float f) {
        this.d.l0(f);
    }

    public void setScale(float f, float f2, float f3, boolean z) {
        this.d.m0(f, f2, f3, z);
    }

    public void setScale(float f, boolean z) {
        this.d.n0(f, z);
    }

    public void setScaleLevels(float f, float f2, float f3) {
        this.d.o0(f, f2, f3);
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        PhotoViewAttachment photoViewAttachment = this.d;
        if (photoViewAttachment == null) {
            this.e = scaleType;
        } else {
            photoViewAttachment.p0(scaleType);
        }
    }

    public void setSlideUpAndDownListener(i iVar) {
        this.d.q0(iVar);
    }

    public boolean setSuppMatrix(Matrix matrix) {
        return this.d.U(matrix);
    }

    public void setZoomTransitionDuration(int i) {
        this.d.r0(i);
    }

    public void setZoomable(boolean z) {
        this.d.s0(z);
    }
}
