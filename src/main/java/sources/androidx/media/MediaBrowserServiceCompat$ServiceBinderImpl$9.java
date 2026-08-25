package androidx.media;

import android.os.Bundle;
import android.support.v4.os.ResultReceiver;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompat;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class MediaBrowserServiceCompat$ServiceBinderImpl$9 implements Runnable {
    final /* synthetic */ MediaBrowserServiceCompat.ServiceBinderImpl this$1;
    final /* synthetic */ String val$action;
    final /* synthetic */ MediaBrowserServiceCompat$m val$callbacks;
    final /* synthetic */ Bundle val$extras;
    final /* synthetic */ ResultReceiver val$receiver;

    MediaBrowserServiceCompat$ServiceBinderImpl$9(MediaBrowserServiceCompat.ServiceBinderImpl serviceBinderImpl, MediaBrowserServiceCompat$m mediaBrowserServiceCompat$m, String str, Bundle bundle, ResultReceiver resultReceiver) {
        this.this$1 = serviceBinderImpl;
        this.val$callbacks = mediaBrowserServiceCompat$m;
        this.val$action = str;
        this.val$extras = bundle;
        this.val$receiver = resultReceiver;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaBrowserServiceCompat.ConnectionRecord connectionRecord = (MediaBrowserServiceCompat.ConnectionRecord) this.this$1.a.e.get(this.val$callbacks.asBinder());
        if (connectionRecord != null) {
            this.this$1.a.m(this.val$action, this.val$extras, connectionRecord, this.val$receiver);
            return;
        }
        Log.w("MBServiceCompat", "sendCustomAction for callback that isn't registered action=" + this.val$action + ", extras=" + this.val$extras);
    }
}
