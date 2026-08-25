package androidx.appcompat.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
abstract class AppCompatDelegateImpl$n {

    /* renamed from: a, reason: collision with root package name */
    private BroadcastReceiver f244a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AppCompatDelegateImpl f245b;

    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            AppCompatDelegateImpl$n.this.d();
        }
    }

    AppCompatDelegateImpl$n(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.f245b = appCompatDelegateImpl;
    }

    void a() {
        BroadcastReceiver broadcastReceiver = this.f244a;
        if (broadcastReceiver != null) {
            try {
                this.f245b.k.unregisterReceiver(broadcastReceiver);
            } catch (IllegalArgumentException unused) {
            }
            this.f244a = null;
        }
    }

    abstract IntentFilter b();

    abstract int c();

    abstract void d();

    void e() {
        a();
        IntentFilter b5 = b();
        if (b5 == null || b5.countActions() == 0) {
            return;
        }
        if (this.f244a == null) {
            this.f244a = new a();
        }
        this.f245b.k.registerReceiver(this.f244a, b5);
    }
}
