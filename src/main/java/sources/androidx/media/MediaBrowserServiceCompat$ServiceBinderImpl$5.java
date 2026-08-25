package androidx.media;

import android.support.v4.os.ResultReceiver;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompat;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class MediaBrowserServiceCompat$ServiceBinderImpl$5 implements Runnable {
    final /* synthetic */ MediaBrowserServiceCompat.ServiceBinderImpl this$1;
    final /* synthetic */ MediaBrowserServiceCompat$m val$callbacks;
    final /* synthetic */ String val$mediaId;
    final /* synthetic */ ResultReceiver val$receiver;

    MediaBrowserServiceCompat$ServiceBinderImpl$5(MediaBrowserServiceCompat.ServiceBinderImpl serviceBinderImpl, MediaBrowserServiceCompat$m mediaBrowserServiceCompat$m, String str, ResultReceiver resultReceiver) {
        this.this$1 = serviceBinderImpl;
        this.val$callbacks = mediaBrowserServiceCompat$m;
        this.val$mediaId = str;
        this.val$receiver = resultReceiver;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaBrowserServiceCompat.ConnectionRecord connectionRecord = (MediaBrowserServiceCompat.ConnectionRecord) this.this$1.a.e.get(this.val$callbacks.asBinder());
        if (connectionRecord != null) {
            this.this$1.a.o(this.val$mediaId, connectionRecord, this.val$receiver);
            return;
        }
        Log.w("MBServiceCompat", "getMediaItem for callback that isn't registered id=" + this.val$mediaId);
    }
}
