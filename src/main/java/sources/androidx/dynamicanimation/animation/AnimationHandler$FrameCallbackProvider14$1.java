package androidx.dynamicanimation.animation;

import android.os.SystemClock;
import androidx.dynamicanimation.animation.a;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class AnimationHandler$FrameCallbackProvider14$1 implements Runnable {
    final /* synthetic */ a.d this$0;

    AnimationHandler$FrameCallbackProvider14$1(a.d dVar) {
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.f7816b = SystemClock.uptimeMillis();
        this.this$0.f7815a.a();
    }
}
