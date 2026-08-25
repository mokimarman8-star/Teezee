package id;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import id.h;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class h {
    private final Context a;
    private Runnable e;
    private boolean f;
    private boolean c = false;
    private final BroadcastReceiver b = new b();
    private Handler d = new Handler();

    /* JADX INFO: Access modifiers changed from: private */
    final class b extends BroadcastReceiver {
        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(boolean z) {
            h.this.f(z);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                final boolean z = intent.getIntExtra("plugged", -1) <= 0;
                h.this.d.post(new Runnable() { // from class: id.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        h.b.this.b(z);
                    }
                });
            }
        }
    }

    public h(Context context, Runnable runnable) {
        this.a = context;
        this.e = runnable;
    }

    private void e() {
        this.d.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z) {
        this.f = z;
        if (this.c) {
            c();
        }
    }

    private void g() {
        if (this.c) {
            return;
        }
        this.a.registerReceiver(this.b, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        this.c = true;
    }

    private void i() {
        if (this.c) {
            this.a.unregisterReceiver(this.b);
            this.c = false;
        }
    }

    public void c() {
        e();
        if (this.f) {
            this.d.postDelayed(this.e, 300000L);
        }
    }

    public void d() {
        e();
        i();
    }

    public void h() {
        g();
        c();
    }
}
