package androidx.media;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.media.MediaBrowserServiceCompat;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class MediaBrowserServiceCompat$g extends MediaBrowserServiceCompat.MediaBrowserServiceImplApi21 {

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ MediaBrowserServiceCompat f8425e;

    class a extends MediaBrowserServiceCompat$k {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ MediaBrowserServiceCompat$l f8426f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Object obj, MediaBrowserServiceCompat$l mediaBrowserServiceCompat$l) {
            super(obj);
            this.f8426f = mediaBrowserServiceCompat$l;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.media.MediaBrowserServiceCompat$k
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void d(MediaBrowserCompat.MediaItem mediaItem) {
            if (mediaItem == null) {
                this.f8426f.b(null);
                return;
            }
            Parcel obtain = Parcel.obtain();
            mediaItem.writeToParcel(obtain, 0);
            this.f8426f.b(obtain);
        }
    }

    class b extends MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$b {
        b(final Context context) {
            new MediaBrowserService(MediaBrowserServiceCompat$g.this, context) { // from class: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$b

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ MediaBrowserServiceCompat.MediaBrowserServiceImplApi21 f8411a;

                {
                    attachBaseContext(context);
                }

                @Override // android.service.media.MediaBrowserService
                public MediaBrowserService.BrowserRoot onGetRoot(String str, int i5, Bundle bundle) {
                    String str2;
                    Bundle bundle2;
                    MediaSessionCompat.a(bundle);
                    MediaBrowserServiceCompat$e d5 = this.f8411a.d(str, i5, bundle == null ? null : new Bundle(bundle));
                    if (d5 == null) {
                        return null;
                    }
                    str2 = d5.f8423a;
                    bundle2 = d5.f8424b;
                    return new MediaBrowserService.BrowserRoot(str2, bundle2);
                }

                @Override // android.service.media.MediaBrowserService
                public void onLoadChildren(String str, MediaBrowserService.Result result) {
                    this.f8411a.e(str, new MediaBrowserServiceCompat$l(result));
                }
            };
        }

        @Override // android.service.media.MediaBrowserService
        public void onLoadItem(String str, MediaBrowserService.Result result) {
            MediaBrowserServiceCompat$g.this.g(str, new MediaBrowserServiceCompat$l(result));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MediaBrowserServiceCompat$g(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
        super(mediaBrowserServiceCompat);
        this.f8425e = mediaBrowserServiceCompat;
    }

    public void g(String str, MediaBrowserServiceCompat$l mediaBrowserServiceCompat$l) {
        a aVar = new a(str, mediaBrowserServiceCompat$l);
        MediaBrowserServiceCompat mediaBrowserServiceCompat = this.f8425e;
        mediaBrowserServiceCompat.f = mediaBrowserServiceCompat.c;
        mediaBrowserServiceCompat.i(str, aVar);
        this.f8425e.f = null;
    }

    public void onCreate() {
        b bVar = new b(this.f8425e);
        ((MediaBrowserServiceCompat.MediaBrowserServiceImplApi21) this).b = bVar;
        bVar.onCreate();
    }
}
