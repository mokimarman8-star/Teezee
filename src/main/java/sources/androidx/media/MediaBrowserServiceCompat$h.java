package androidx.media;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.MediaBrowserServiceCompat$g;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class MediaBrowserServiceCompat$h extends MediaBrowserServiceCompat$g {

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ MediaBrowserServiceCompat f8429f;

    class a extends MediaBrowserServiceCompat$k {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ MediaBrowserServiceCompat$l f8430f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Bundle f8431g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Object obj, MediaBrowserServiceCompat$l mediaBrowserServiceCompat$l, Bundle bundle) {
            super(obj);
            this.f8430f = mediaBrowserServiceCompat$l;
            this.f8431g = bundle;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.media.MediaBrowserServiceCompat$k
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void d(List list) {
            if (list == null) {
                this.f8430f.b(null);
                return;
            }
            if ((a() & 1) != 0) {
                list = MediaBrowserServiceCompat$h.this.f8429f.b(list, this.f8431g);
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (MediaBrowserCompat.MediaItem mediaItem : list) {
                Parcel obtain = Parcel.obtain();
                mediaItem.writeToParcel(obtain, 0);
                arrayList.add(obtain);
            }
            this.f8430f.b(arrayList);
        }
    }

    class b extends MediaBrowserServiceCompat$g.b {
        b(Context context) {
            super(context);
        }

        @Override // android.service.media.MediaBrowserService
        public void onLoadChildren(String str, MediaBrowserService.Result result, Bundle bundle) {
            MediaSessionCompat.a(bundle);
            MediaBrowserServiceCompat$h mediaBrowserServiceCompat$h = MediaBrowserServiceCompat$h.this;
            MediaBrowserServiceCompat mediaBrowserServiceCompat = mediaBrowserServiceCompat$h.f8429f;
            mediaBrowserServiceCompat.f = mediaBrowserServiceCompat.c;
            mediaBrowserServiceCompat$h.h(str, new MediaBrowserServiceCompat$l(result), bundle);
            MediaBrowserServiceCompat$h.this.f8429f.f = null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MediaBrowserServiceCompat$h(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
        super(mediaBrowserServiceCompat);
        this.f8429f = mediaBrowserServiceCompat;
    }

    public void h(String str, MediaBrowserServiceCompat$l mediaBrowserServiceCompat$l, Bundle bundle) {
        a aVar = new a(str, mediaBrowserServiceCompat$l, bundle);
        MediaBrowserServiceCompat mediaBrowserServiceCompat = this.f8429f;
        mediaBrowserServiceCompat.f = mediaBrowserServiceCompat.c;
        mediaBrowserServiceCompat.h(str, aVar, bundle);
        this.f8429f.f = null;
    }

    @Override // androidx.media.MediaBrowserServiceCompat$g
    public void onCreate() {
        b bVar = new b(this.f8429f);
        ((MediaBrowserServiceCompat.MediaBrowserServiceImplApi21) this).b = bVar;
        bVar.onCreate();
    }
}
