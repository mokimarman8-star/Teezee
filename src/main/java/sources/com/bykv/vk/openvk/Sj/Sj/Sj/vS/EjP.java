package com.bykv.vk.openvk.Sj.Sj.Sj.vS;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.Sj.Sj.Sj.vS.a;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class EjP extends TextureView implements TextureView.SurfaceTextureListener, a {
    private c6.a a;

    public EjP(Context context) {
        this(context, null);
    }

    public EjP(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.bykv.vk.openvk.Sj.Sj.Sj.vS.a
    public void Sj(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        setLayoutParams(layoutParams);
    }

    @Override // com.bykv.vk.openvk.Sj.Sj.Sj.vS.a
    public void Sj(c6.a aVar) {
        this.a = aVar;
        setSurfaceTextureListener(this);
    }

    @Override // com.bykv.vk.openvk.Sj.Sj.Sj.vS.a
    public SurfaceHolder getHolder() {
        return null;
    }

    @Override // com.bykv.vk.openvk.Sj.Sj.Sj.vS.a
    public View getView() {
        return this;
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        c6.a aVar = this.a;
        if (aVar != null) {
            aVar.Sj(surfaceTexture, i, i2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        c6.a aVar = this.a;
        if (aVar != null) {
            return aVar.Sj(surfaceTexture);
        }
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    public void setWindowVisibilityChangedListener(a.InterfaceC0013a interfaceC0013a) {
    }
}
