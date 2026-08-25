package androidx.media;

import android.media.browse.MediaBrowser;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class MediaBrowserServiceCompat$l {

    /* renamed from: a, reason: collision with root package name */
    MediaBrowserService.Result f8441a;

    MediaBrowserServiceCompat$l(MediaBrowserService.Result result) {
        this.f8441a = result;
    }

    List a(List list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Parcel parcel = (Parcel) it.next();
            parcel.setDataPosition(0);
            arrayList.add((MediaBrowser.MediaItem) MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
            parcel.recycle();
        }
        return arrayList;
    }

    public void b(Object obj) {
        if (obj instanceof List) {
            this.f8441a.sendResult(a((List) obj));
            return;
        }
        if (!(obj instanceof Parcel)) {
            this.f8441a.sendResult(null);
            return;
        }
        Parcel parcel = (Parcel) obj;
        parcel.setDataPosition(0);
        this.f8441a.sendResult(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
        parcel.recycle();
    }
}
