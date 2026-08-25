package androidx.media.session;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.view.KeyEvent;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class MediaButtonReceiver$b extends MediaBrowserCompat.c {

    /* renamed from: c, reason: collision with root package name */
    private final Context f8455c;

    /* renamed from: d, reason: collision with root package name */
    private final Intent f8456d;

    /* renamed from: e, reason: collision with root package name */
    private final BroadcastReceiver.PendingResult f8457e;

    /* renamed from: f, reason: collision with root package name */
    private MediaBrowserCompat f8458f;

    MediaButtonReceiver$b(Context context, Intent intent, BroadcastReceiver.PendingResult pendingResult) {
        this.f8455c = context;
        this.f8456d = intent;
        this.f8457e = pendingResult;
    }

    private void e() {
        this.f8458f.b();
        this.f8457e.finish();
    }

    public void a() {
        new MediaControllerCompat(this.f8455c, this.f8458f.d()).a((KeyEvent) this.f8456d.getParcelableExtra("android.intent.extra.KEY_EVENT"));
        e();
    }

    public void b() {
        e();
    }

    public void c() {
        e();
    }

    void f(MediaBrowserCompat mediaBrowserCompat) {
        this.f8458f = mediaBrowserCompat;
    }
}
