package androidx.media;

import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.media.session.MediaSessionCompat;
import java.util.List;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public interface MediaBrowserServiceCompat$m {
    void a(String str, List list, Bundle bundle, Bundle bundle2);

    IBinder asBinder();

    void b();

    void c(String str, MediaSessionCompat.Token token, Bundle bundle);
}
