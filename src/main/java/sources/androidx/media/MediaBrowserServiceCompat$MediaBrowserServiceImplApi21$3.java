package androidx.media;

import android.os.Bundle;
import android.os.IBinder;
import androidx.media.MediaBrowserServiceCompat;
import java.util.Iterator;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$3 implements Runnable {
    final /* synthetic */ MediaBrowserServiceCompat.MediaBrowserServiceImplApi21 this$1;
    final /* synthetic */ Bundle val$options;
    final /* synthetic */ String val$parentId;

    MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$3(MediaBrowserServiceCompat.MediaBrowserServiceImplApi21 mediaBrowserServiceImplApi21, String str, Bundle bundle) {
        this.this$1 = mediaBrowserServiceImplApi21;
        this.val$parentId = str;
        this.val$options = bundle;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator<Object> it = this.this$1.d.e.keySet().iterator();
        while (it.hasNext()) {
            this.this$1.c((MediaBrowserServiceCompat.ConnectionRecord) this.this$1.d.e.get((IBinder) it.next()), this.val$parentId, this.val$options);
        }
    }
}
