package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    final c.a f1203a;

    /* renamed from: b, reason: collision with root package name */
    private final PendingIntent f1204b;

    /* renamed from: c, reason: collision with root package name */
    private final c f1205c;

    class a extends c {
        a() {
        }

        @Override // androidx.browser.customtabs.c
        public void extraCallback(String str, Bundle bundle) {
            try {
                k.this.f1203a.L(str, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        @Override // androidx.browser.customtabs.c
        public Bundle extraCallbackWithResult(String str, Bundle bundle) {
            try {
                return k.this.f1203a.s(str, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
                return null;
            }
        }

        @Override // androidx.browser.customtabs.c
        public void onActivityResized(int i5, int i6, Bundle bundle) {
            try {
                k.this.f1203a.B0(i5, i6, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        @Override // androidx.browser.customtabs.c
        public void onMessageChannelReady(Bundle bundle) {
            try {
                k.this.f1203a.R0(bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        @Override // androidx.browser.customtabs.c
        public void onNavigationEvent(int i5, Bundle bundle) {
            try {
                k.this.f1203a.K0(i5, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        @Override // androidx.browser.customtabs.c
        public void onPostMessage(String str, Bundle bundle) {
            try {
                k.this.f1203a.O0(str, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        @Override // androidx.browser.customtabs.c
        public void onRelationshipValidationResult(int i5, Uri uri, boolean z5, Bundle bundle) {
            try {
                k.this.f1203a.T0(i5, uri, z5, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }
    }

    k(c.a aVar, PendingIntent pendingIntent) {
        if (aVar == null && pendingIntent == null) {
            throw new IllegalStateException("CustomTabsSessionToken must have either a session id or a callback (or both).");
        }
        this.f1203a = aVar;
        this.f1204b = pendingIntent;
        this.f1205c = aVar == null ? null : new a();
    }

    private IBinder b() {
        c.a aVar = this.f1203a;
        if (aVar != null) {
            return aVar.asBinder();
        }
        throw new IllegalStateException("CustomTabSessionToken must have valid binder or pending session");
    }

    IBinder a() {
        c.a aVar = this.f1203a;
        if (aVar == null) {
            return null;
        }
        return aVar.asBinder();
    }

    PendingIntent c() {
        return this.f1204b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        PendingIntent c5 = kVar.c();
        PendingIntent pendingIntent = this.f1204b;
        if ((pendingIntent == null) != (c5 == null)) {
            return false;
        }
        return pendingIntent != null ? pendingIntent.equals(c5) : b().equals(kVar.b());
    }

    public int hashCode() {
        PendingIntent pendingIntent = this.f1204b;
        return pendingIntent != null ? pendingIntent.hashCode() : b().hashCode();
    }
}
