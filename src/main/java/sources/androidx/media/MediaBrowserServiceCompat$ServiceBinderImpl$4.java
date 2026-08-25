package androidx.media;

import android.os.IBinder;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompat;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class MediaBrowserServiceCompat$ServiceBinderImpl$4 implements Runnable {
    final /* synthetic */ MediaBrowserServiceCompat.ServiceBinderImpl this$1;
    final /* synthetic */ MediaBrowserServiceCompat$m val$callbacks;
    final /* synthetic */ String val$id;
    final /* synthetic */ IBinder val$token;

    MediaBrowserServiceCompat$ServiceBinderImpl$4(MediaBrowserServiceCompat.ServiceBinderImpl serviceBinderImpl, MediaBrowserServiceCompat$m mediaBrowserServiceCompat$m, String str, IBinder iBinder) {
        this.this$1 = serviceBinderImpl;
        this.val$callbacks = mediaBrowserServiceCompat$m;
        this.val$id = str;
        this.val$token = iBinder;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaBrowserServiceCompat.ConnectionRecord connectionRecord = (MediaBrowserServiceCompat.ConnectionRecord) this.this$1.a.e.get(this.val$callbacks.asBinder());
        if (connectionRecord == null) {
            Log.w("MBServiceCompat", "removeSubscription for callback that isn't registered id=" + this.val$id);
            return;
        }
        if (this.this$1.a.q(this.val$id, connectionRecord, this.val$token)) {
            return;
        }
        Log.w("MBServiceCompat", "removeSubscription called for " + this.val$id + " which is not subscribed");
    }
}
