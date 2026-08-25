package androidx.media;

import android.os.IBinder;
import androidx.media.MediaBrowserServiceCompat;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class MediaBrowserServiceCompat$ServiceBinderImpl$2 implements Runnable {
    final /* synthetic */ MediaBrowserServiceCompat.ServiceBinderImpl this$1;
    final /* synthetic */ MediaBrowserServiceCompat$m val$callbacks;

    MediaBrowserServiceCompat$ServiceBinderImpl$2(MediaBrowserServiceCompat.ServiceBinderImpl serviceBinderImpl, MediaBrowserServiceCompat$m mediaBrowserServiceCompat$m) {
        this.this$1 = serviceBinderImpl;
        this.val$callbacks = mediaBrowserServiceCompat$m;
    }

    @Override // java.lang.Runnable
    public void run() {
        IBinder.DeathRecipient deathRecipient = (MediaBrowserServiceCompat.ConnectionRecord) this.this$1.a.e.remove(this.val$callbacks.asBinder());
        if (deathRecipient != null) {
            ((MediaBrowserServiceCompat.ConnectionRecord) deathRecipient).f.asBinder().unlinkToDeath(deathRecipient, 0);
        }
    }
}
