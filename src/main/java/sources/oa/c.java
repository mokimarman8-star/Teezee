package oa;

import android.graphics.SurfaceTexture;
import com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ SphericalGLSurfaceView a;
    public final /* synthetic */ SurfaceTexture b;

    public /* synthetic */ c(SphericalGLSurfaceView sphericalGLSurfaceView, SurfaceTexture surfaceTexture) {
        this.a = sphericalGLSurfaceView;
        this.b = surfaceTexture;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SphericalGLSurfaceView.b(this.a, this.b);
    }
}
