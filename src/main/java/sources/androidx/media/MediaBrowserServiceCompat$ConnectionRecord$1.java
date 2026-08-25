package androidx.media;

import androidx.media.MediaBrowserServiceCompat;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class MediaBrowserServiceCompat$ConnectionRecord$1 implements Runnable {
    final /* synthetic */ MediaBrowserServiceCompat.ConnectionRecord this$1;

    MediaBrowserServiceCompat$ConnectionRecord$1(MediaBrowserServiceCompat.ConnectionRecord connectionRecord) {
        this.this$1 = connectionRecord;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaBrowserServiceCompat.ConnectionRecord connectionRecord = this.this$1;
        connectionRecord.i.e.remove(connectionRecord.f.asBinder());
    }
}
