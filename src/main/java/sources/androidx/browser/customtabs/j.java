package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import c.c;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    private final Object f1195a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final c.b f1196b;

    /* renamed from: c, reason: collision with root package name */
    private final c.a f1197c;

    /* renamed from: d, reason: collision with root package name */
    private final ComponentName f1198d;

    /* renamed from: e, reason: collision with root package name */
    private final PendingIntent f1199e;

    class a extends c.a {

        /* renamed from: a, reason: collision with root package name */
        private final Handler f1200a = new Handler(Looper.getMainLooper());

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ l f1201b;

        a(l lVar) {
            this.f1201b = lVar;
        }

        @Override // c.c
        public void onGreatestScrollPercentageIncreased(final int i5, final Bundle bundle) {
            Handler handler = this.f1200a;
            final l lVar = this.f1201b;
            handler.post(new Runnable() { // from class: androidx.browser.customtabs.h
                @Override // java.lang.Runnable
                public final void run() {
                    l.this.onGreatestScrollPercentageIncreased(i5, bundle);
                }
            });
        }

        @Override // c.c
        public void onSessionEnded(final boolean z5, final Bundle bundle) {
            Handler handler = this.f1200a;
            final l lVar = this.f1201b;
            handler.post(new Runnable() { // from class: androidx.browser.customtabs.g
                @Override // java.lang.Runnable
                public final void run() {
                    l.this.onSessionEnded(z5, bundle);
                }
            });
        }

        @Override // c.c
        public void onVerticalScrollEvent(final boolean z5, final Bundle bundle) {
            Handler handler = this.f1200a;
            final l lVar = this.f1201b;
            handler.post(new Runnable() { // from class: androidx.browser.customtabs.i
                @Override // java.lang.Runnable
                public final void run() {
                    l.this.onVerticalScrollEvent(z5, bundle);
                }
            });
        }
    }

    j(c.b bVar, c.a aVar, ComponentName componentName, PendingIntent pendingIntent) {
        this.f1196b = bVar;
        this.f1197c = aVar;
        this.f1198d = componentName;
        this.f1199e = pendingIntent;
    }

    private void a(Bundle bundle) {
        PendingIntent pendingIntent = this.f1199e;
        if (pendingIntent != null) {
            bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
        }
    }

    private Bundle b(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        a(bundle2);
        return bundle2;
    }

    private c.a c(l lVar) {
        return new a(lVar);
    }

    IBinder d() {
        return this.f1197c.asBinder();
    }

    ComponentName e() {
        return this.f1198d;
    }

    PendingIntent f() {
        return this.f1199e;
    }

    public boolean g(Bundle bundle) {
        try {
            return this.f1196b.B(this.f1197c, bundle);
        } catch (SecurityException e5) {
            throw new UnsupportedOperationException("This method isn't supported by the Custom Tabs implementation.", e5);
        }
    }

    public boolean h(Uri uri, Bundle bundle, List list) {
        try {
            return this.f1196b.U(this.f1197c, uri, b(bundle), list);
        } catch (RemoteException unused) {
            return false;
        }
    }

    public int i(String str, Bundle bundle) {
        int W;
        Bundle b5 = b(bundle);
        synchronized (this.f1195a) {
            try {
                try {
                    W = this.f1196b.W(this.f1197c, str, b5);
                } catch (RemoteException unused) {
                    return -2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return W;
    }

    public boolean j(l lVar, Bundle bundle) {
        try {
            return this.f1196b.P0(this.f1197c, c(lVar).asBinder(), bundle);
        } catch (SecurityException e5) {
            throw new UnsupportedOperationException("This method isn't supported by the Custom Tabs implementation.", e5);
        }
    }
}
