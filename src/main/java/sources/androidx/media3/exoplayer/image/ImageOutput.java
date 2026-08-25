package androidx.media3.exoplayer.image;

import android.graphics.Bitmap;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public interface ImageOutput {

    /* renamed from: a, reason: collision with root package name */
    public static final ImageOutput f10706a = new a();

    class a implements ImageOutput {
        a() {
        }

        @Override // androidx.media3.exoplayer.image.ImageOutput
        public void a() {
        }

        @Override // androidx.media3.exoplayer.image.ImageOutput
        public void onImageAvailable(long j5, Bitmap bitmap) {
        }
    }

    void a();

    void onImageAvailable(long j5, Bitmap bitmap);
}
