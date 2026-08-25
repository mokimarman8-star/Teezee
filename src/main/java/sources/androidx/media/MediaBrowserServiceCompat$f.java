package androidx.media;

import android.content.Intent;
import android.os.IBinder;
import android.support.v4.media.session.MediaSessionCompat;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
interface MediaBrowserServiceCompat$f {
    void a(MediaSessionCompat.Token token);

    IBinder b(Intent intent);

    void onCreate();
}
