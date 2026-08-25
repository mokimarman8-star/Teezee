package com.journeyapps.barcodescanner.camera;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.view.SurfaceHolder;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class j {
    private SurfaceHolder a;
    private SurfaceTexture b;

    public j(SurfaceTexture surfaceTexture) {
        if (surfaceTexture == null) {
            throw new IllegalArgumentException("surfaceTexture may not be null");
        }
        this.b = surfaceTexture;
    }

    public j(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            throw new IllegalArgumentException("surfaceHolder may not be null");
        }
        this.a = surfaceHolder;
    }

    public void a(Camera camera) {
        SurfaceHolder surfaceHolder = this.a;
        if (surfaceHolder != null) {
            camera.setPreviewDisplay(surfaceHolder);
        } else {
            camera.setPreviewTexture(this.b);
        }
    }
}
