package androidx.media;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.os.ResultReceiver;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class MediaBrowserServiceCompat$c extends MediaBrowserServiceCompat$k {

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ ResultReceiver f8419f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ MediaBrowserServiceCompat f8420g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MediaBrowserServiceCompat$c(MediaBrowserServiceCompat mediaBrowserServiceCompat, Object obj, ResultReceiver resultReceiver) {
        super(obj);
        this.f8420g = mediaBrowserServiceCompat;
        this.f8419f = resultReceiver;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.media.MediaBrowserServiceCompat$k
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void d(List list) {
        if ((a() & 4) != 0 || list == null) {
            this.f8419f.send(-1, (Bundle) null);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArray("search_results", (Parcelable[]) list.toArray(new MediaBrowserCompat.MediaItem[0]));
        this.f8419f.send(0, bundle);
    }
}
