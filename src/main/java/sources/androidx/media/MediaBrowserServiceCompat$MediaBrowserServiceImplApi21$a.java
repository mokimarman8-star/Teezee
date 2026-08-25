package androidx.media;

import android.os.Build;
import android.os.Parcel;
import android.support.v4.media.MediaBrowserCompat;
import androidx.media.MediaBrowserServiceCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$a extends MediaBrowserServiceCompat$k {

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ MediaBrowserServiceCompat$l f8409f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ MediaBrowserServiceCompat.MediaBrowserServiceImplApi21 f8410g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$a(MediaBrowserServiceCompat.MediaBrowserServiceImplApi21 mediaBrowserServiceImplApi21, Object obj, MediaBrowserServiceCompat$l mediaBrowserServiceCompat$l) {
        super(obj);
        this.f8410g = mediaBrowserServiceImplApi21;
        this.f8409f = mediaBrowserServiceCompat$l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.media.MediaBrowserServiceCompat$k
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void d(List list) {
        List list2;
        if (list == null) {
            list2 = Build.VERSION.SDK_INT >= 24 ? null : Collections.emptyList();
        } else {
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                MediaBrowserCompat.MediaItem mediaItem = (MediaBrowserCompat.MediaItem) it.next();
                Parcel obtain = Parcel.obtain();
                mediaItem.writeToParcel(obtain, 0);
                arrayList.add(obtain);
            }
            list2 = arrayList;
        }
        this.f8409f.b(list2);
    }
}
