package androidx.media;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.support.v4.media.session.MediaSessionCompat;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class MediaBrowserServiceCompat$n implements MediaBrowserServiceCompat$m {

    /* renamed from: a, reason: collision with root package name */
    final Messenger f8442a;

    MediaBrowserServiceCompat$n(Messenger messenger) {
        this.f8442a = messenger;
    }

    private void d(int i5, Bundle bundle) {
        Message obtain = Message.obtain();
        obtain.what = i5;
        obtain.arg1 = 2;
        obtain.setData(bundle);
        this.f8442a.send(obtain);
    }

    @Override // androidx.media.MediaBrowserServiceCompat$m
    public void a(String str, List list, Bundle bundle, Bundle bundle2) {
        Bundle bundle3 = new Bundle();
        bundle3.putString("data_media_item_id", str);
        bundle3.putBundle("data_options", bundle);
        bundle3.putBundle("data_notify_children_changed_options", bundle2);
        if (list != null) {
            bundle3.putParcelableArrayList("data_media_item_list", list instanceof ArrayList ? (ArrayList) list : new ArrayList<>(list));
        }
        d(3, bundle3);
    }

    @Override // androidx.media.MediaBrowserServiceCompat$m
    public IBinder asBinder() {
        return this.f8442a.getBinder();
    }

    @Override // androidx.media.MediaBrowserServiceCompat$m
    public void b() {
        d(2, null);
    }

    @Override // androidx.media.MediaBrowserServiceCompat$m
    public void c(String str, MediaSessionCompat.Token token, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("extra_service_version", 2);
        Bundle bundle2 = new Bundle();
        bundle2.putString("data_media_item_id", str);
        bundle2.putParcelable("data_media_session_token", token);
        bundle2.putBundle("data_root_hints", bundle);
        d(1, bundle2);
    }
}
