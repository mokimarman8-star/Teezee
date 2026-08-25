package androidx.media;

import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.os.ResultReceiver;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class MediaBrowserServiceCompat$b extends MediaBrowserServiceCompat$k {

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ ResultReceiver f8417f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ MediaBrowserServiceCompat f8418g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MediaBrowserServiceCompat$b(MediaBrowserServiceCompat mediaBrowserServiceCompat, Object obj, ResultReceiver resultReceiver) {
        super(obj);
        this.f8418g = mediaBrowserServiceCompat;
        this.f8417f = resultReceiver;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.media.MediaBrowserServiceCompat$k
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void d(MediaBrowserCompat.MediaItem mediaItem) {
        if ((a() & 2) != 0) {
            this.f8417f.send(-1, (Bundle) null);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("media_item", mediaItem);
        this.f8417f.send(0, bundle);
    }
}
