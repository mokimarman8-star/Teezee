package androidx.media;

import android.os.IBinder;
import androidx.media.MediaBrowserServiceCompat;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class MediaBrowserServiceCompat$ServiceBinderImpl$7 implements Runnable {
    final /* synthetic */ MediaBrowserServiceCompat.ServiceBinderImpl this$1;
    final /* synthetic */ MediaBrowserServiceCompat$m val$callbacks;

    MediaBrowserServiceCompat$ServiceBinderImpl$7(MediaBrowserServiceCompat.ServiceBinderImpl serviceBinderImpl, MediaBrowserServiceCompat$m mediaBrowserServiceCompat$m) {
        this.this$1 = serviceBinderImpl;
        this.val$callbacks = mediaBrowserServiceCompat$m;
    }

    @Override // java.lang.Runnable
    public void run() {
        IBinder asBinder = this.val$callbacks.asBinder();
        MediaBrowserServiceCompat.ConnectionRecord connectionRecord = (MediaBrowserServiceCompat.ConnectionRecord) this.this$1.a.e.remove(asBinder);
        if (connectionRecord != null) {
            asBinder.unlinkToDeath(connectionRecord, 0);
        }
    }
}
