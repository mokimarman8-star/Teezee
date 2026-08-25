package androidx.media;

import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.media.MediaBrowserCompat;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class MediaBrowserServiceCompat$o extends Handler {

    /* renamed from: a, reason: collision with root package name */
    private MediaBrowserServiceCompat f8443a;

    MediaBrowserServiceCompat$o(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
        this.f8443a = mediaBrowserServiceCompat;
    }

    public void a(Runnable runnable) {
        if (Thread.currentThread() == getLooper().getThread()) {
            runnable.run();
        } else {
            post(runnable);
        }
    }

    public void b() {
        this.f8443a = null;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        MediaBrowserServiceCompat mediaBrowserServiceCompat = this.f8443a;
        if (mediaBrowserServiceCompat != null) {
            mediaBrowserServiceCompat.c(message);
        } else {
            removeCallbacksAndMessages(null);
        }
    }

    @Override // android.os.Handler
    public boolean sendMessageAtTime(Message message, long j5) {
        Bundle data = message.getData();
        data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
        data.putInt("data_calling_uid", Binder.getCallingUid());
        int callingPid = Binder.getCallingPid();
        if (callingPid > 0) {
            data.putInt("data_calling_pid", callingPid);
        } else if (!data.containsKey("data_calling_pid")) {
            data.putInt("data_calling_pid", -1);
        }
        return super.sendMessageAtTime(message, j5);
    }
}
