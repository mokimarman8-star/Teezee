package androidx.media;

import android.os.Bundle;
import android.support.v4.os.ResultReceiver;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class MediaBrowserServiceCompat$d extends MediaBrowserServiceCompat$k {

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ ResultReceiver f8421f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ MediaBrowserServiceCompat f8422g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MediaBrowserServiceCompat$d(MediaBrowserServiceCompat mediaBrowserServiceCompat, Object obj, ResultReceiver resultReceiver) {
        super(obj);
        this.f8422g = mediaBrowserServiceCompat;
        this.f8421f = resultReceiver;
    }

    @Override // androidx.media.MediaBrowserServiceCompat$k
    void c(Bundle bundle) {
        this.f8421f.send(-1, bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.media.MediaBrowserServiceCompat$k
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void d(Bundle bundle) {
        this.f8421f.send(0, bundle);
    }
}
