package androidx.media3.exoplayer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Looper;
import androidx.media3.exoplayer.e;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class e {

    /* renamed from: a, reason: collision with root package name */
    private final Context f10291a;

    /* renamed from: b, reason: collision with root package name */
    private final a f10292b;

    /* renamed from: c, reason: collision with root package name */
    private final androidx.media3.common.util.p f10293c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f10294d;

    /* JADX INFO: Access modifiers changed from: private */
    final class a extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        private final b f10295a;

        /* renamed from: b, reason: collision with root package name */
        private final androidx.media3.common.util.p f10296b;

        public a(androidx.media3.common.util.p pVar, b bVar) {
            this.f10296b = pVar;
            this.f10295a = bVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            if (e.this.f10294d) {
                this.f10295a.m();
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
                this.f10296b.post(new Runnable() { // from class: androidx.media3.exoplayer.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        e.a.this.b();
                    }
                });
            }
        }
    }

    public interface b {
        void m();
    }

    public e(Context context, Looper looper, Looper looper2, b bVar, androidx.media3.common.util.i iVar) {
        this.f10291a = context.getApplicationContext();
        this.f10293c = iVar.createHandler(looper, null);
        this.f10292b = new a(iVar.createHandler(looper2, null), bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        this.f10291a.registerReceiver(this.f10292b, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        this.f10291a.unregisterReceiver(this.f10292b);
    }

    public void f(boolean z5) {
        if (z5 == this.f10294d) {
            return;
        }
        if (z5) {
            this.f10293c.post(new Runnable() { // from class: androidx.media3.exoplayer.b
                @Override // java.lang.Runnable
                public final void run() {
                    e.this.d();
                }
            });
            this.f10294d = true;
        } else {
            this.f10293c.post(new Runnable() { // from class: androidx.media3.exoplayer.c
                @Override // java.lang.Runnable
                public final void run() {
                    e.this.e();
                }
            });
            this.f10294d = false;
        }
    }
}
