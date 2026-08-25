package androidx.browser.customtabs;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import c.c;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class m implements l {

    /* renamed from: a, reason: collision with root package name */
    private final c.c f1207a;

    private m(c.c cVar) {
        this.f1207a = cVar;
    }

    static m a(IBinder iBinder) {
        return new m(c.a.X0(iBinder));
    }

    @Override // androidx.browser.customtabs.l
    public void onGreatestScrollPercentageIncreased(int i5, Bundle bundle) {
        try {
            this.f1207a.onGreatestScrollPercentageIncreased(i5, bundle);
        } catch (RemoteException unused) {
            Log.e("EngagementSigsCallbkRmt", "RemoteException during IEngagementSignalsCallback transaction");
        }
    }

    @Override // androidx.browser.customtabs.l
    public void onSessionEnded(boolean z5, Bundle bundle) {
        try {
            this.f1207a.onSessionEnded(z5, bundle);
        } catch (RemoteException unused) {
            Log.e("EngagementSigsCallbkRmt", "RemoteException during IEngagementSignalsCallback transaction");
        }
    }

    @Override // androidx.browser.customtabs.l
    public void onVerticalScrollEvent(boolean z5, Bundle bundle) {
        try {
            this.f1207a.onVerticalScrollEvent(z5, bundle);
        } catch (RemoteException unused) {
            Log.e("EngagementSigsCallbkRmt", "RemoteException during IEngagementSignalsCallback transaction");
        }
    }
}
