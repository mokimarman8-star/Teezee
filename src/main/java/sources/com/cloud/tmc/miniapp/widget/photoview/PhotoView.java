package com.cloud.tmc.miniapp.widget.photoview;

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
import com.cloud.tmc.miniapp.widget.photoview.OooOo00;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class PhotoView extends AppCompatImageView {
    public OooOOOO OooO00o;
    public ImageView.ScaleType OooO0O0;

    public PhotoView(Context context) {
        this(context, null);
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        OooO00o();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void OooO00o() {
        this.OooO00o = new OooOOOO(this);
        super/*android.widget.ImageView*/.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType scaleType = this.OooO0O0;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.OooO0O0 = null;
        }
    }

    public OooOOOO getAttacher() {
        return this.OooO00o;
    }

    public RectF getDisplayRect() {
        return this.OooO00o.OooO0OO();
    }

    public Matrix getImageMatrix() {
        return this.OooO00o.OooOOO0;
    }

    public float getMaximumScale() {
        return this.OooO00o.OooO0o0;
    }

    public float getMediumScale() {
        return this.OooO00o.OooO0Oo;
    }

    public float getMinimumScale() {
        return this.OooO00o.OooO0OO;
    }

    public float getScale() {
        return this.OooO00o.OooO0o0();
    }

    public ImageView.ScaleType getScaleType() {
        return this.OooO00o.OooOooO;
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.OooO00o.OooO0o = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super/*android.widget.ImageView*/.setFrame(i, i2, i3, i4);
        if (frame) {
            this.OooO00o.OooO0oO();
        }
        return frame;
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        OooOOOO oooOOOO = this.OooO00o;
        if (oooOOOO != null) {
            oooOOOO.OooO0oO();
        }
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        OooOOOO oooOOOO = this.OooO00o;
        if (oooOOOO != null) {
            oooOOOO.OooO0oO();
        }
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        OooOOOO oooOOOO = this.OooO00o;
        if (oooOOOO != null) {
            oooOOOO.OooO0oO();
        }
    }

    public void setMaximumScale(float f) {
        OooOOOO oooOOOO = this.OooO00o;
        OooOo00.OooO00o(oooOOOO.OooO0OO, oooOOOO.OooO0Oo, f);
        oooOOOO.OooO0o0 = f;
    }

    public void setMediumScale(float f) {
        OooOOOO oooOOOO = this.OooO00o;
        OooOo00.OooO00o(oooOOOO.OooO0OO, f, oooOOOO.OooO0o0);
        oooOOOO.OooO0Oo = f;
    }

    public void setMinimumScale(float f) {
        OooOOOO oooOOOO = this.OooO00o;
        OooOo00.OooO00o(f, oooOOOO.OooO0Oo, oooOOOO.OooO0o0);
        oooOOOO.OooO0OO = f;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.OooO00o.OooOo0 = onClickListener;
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.OooO00o.OooOO0.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.OooO00o.OooOo0O = onLongClickListener;
    }

    public void setOnMatrixChangeListener(OooO0OO oooO0OO) {
        this.OooO00o.OooOOo0 = oooO0OO;
    }

    public void setOnOutsidePhotoTapListener(OooO0o oooO0o) {
        this.OooO00o.OooOOoo = oooO0o;
    }

    public void setOnPhotoTapListener(OooO oooO) {
        this.OooO00o.OooOOo = oooO;
    }

    public void setOnScaleChangeListener(OooOO0 oooOO0) {
        this.OooO00o.OooOo0o = oooOO0;
    }

    public void setOnSingleFlingListener(OooOO0O oooOO0O) {
        this.OooO00o.OooOo = oooOO0O;
    }

    public void setOnViewDragListener(OooOOO0 oooOOO0) {
        this.OooO00o.OooOoO0 = oooOOO0;
    }

    public void setOnViewTapListener(OooOOO oooOOO) {
        this.OooO00o.OooOo00 = oooOOO;
    }

    public void setRotationBy(float f) {
        OooOOOO oooOOOO = this.OooO00o;
        oooOOOO.OooOOO.postRotate(f % 360.0f);
        oooOOOO.OooO00o();
    }

    public void setRotationTo(float f) {
        OooOOOO oooOOOO = this.OooO00o;
        oooOOOO.OooOOO.setRotate(f % 360.0f);
        oooOOOO.OooO00o();
    }

    public void setScale(float f) {
        this.OooO00o.OooO00o(f, r0.OooO.getRight() / 2, r0.OooO.getBottom() / 2, false);
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        OooOOOO oooOOOO = this.OooO00o;
        if (oooOOOO == null) {
            this.OooO0O0 = scaleType;
            return;
        }
        if (scaleType == null) {
            return;
        }
        if (OooOo00.OooO00o.OooO00o[scaleType.ordinal()] == 1) {
            throw new IllegalStateException("Matrix scale type is not supported");
        }
        if (scaleType != oooOOOO.OooOooO) {
            oooOOOO.OooOooO = scaleType;
            oooOOOO.OooO0oO();
        }
    }

    public void setZoomTransitionDuration(int i) {
        this.OooO00o.OooO0O0 = i;
    }

    public void setZoomable(boolean z) {
        OooOOOO oooOOOO = this.OooO00o;
        oooOOOO.OooOoo = z;
        oooOOOO.OooO0oO();
    }
}
