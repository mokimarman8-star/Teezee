package androidx.media;

import android.os.Bundle;
import android.support.v4.os.ResultReceiver;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompat;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class MediaBrowserServiceCompat$ServiceBinderImpl$8 implements Runnable {
    final /* synthetic */ MediaBrowserServiceCompat.ServiceBinderImpl this$1;
    final /* synthetic */ MediaBrowserServiceCompat$m val$callbacks;
    final /* synthetic */ Bundle val$extras;
    final /* synthetic */ String val$query;
    final /* synthetic */ ResultReceiver val$receiver;

    MediaBrowserServiceCompat$ServiceBinderImpl$8(MediaBrowserServiceCompat.ServiceBinderImpl serviceBinderImpl, MediaBrowserServiceCompat$m mediaBrowserServiceCompat$m, String str, Bundle bundle, ResultReceiver resultReceiver) {
        this.this$1 = serviceBinderImpl;
        this.val$callbacks = mediaBrowserServiceCompat$m;
        this.val$query = str;
        this.val$extras = bundle;
        this.val$receiver = resultReceiver;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaBrowserServiceCompat.ConnectionRecord connectionRecord = (MediaBrowserServiceCompat.ConnectionRecord) this.this$1.a.e.get(this.val$callbacks.asBinder());
        if (connectionRecord != null) {
            this.this$1.a.p(this.val$query, this.val$extras, connectionRecord, this.val$receiver);
            return;
        }
        Log.w("MBServiceCompat", "search for callback that isn't registered query=" + this.val$query);
    }
}
