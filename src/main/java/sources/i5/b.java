package i5;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import java.util.List;
import pa.a;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
class b extends i5.a {
    private int a = 0;
    private final Context b;
    private pa.a c;
    private ServiceConnection d;

    /* renamed from: i5.b$b, reason: collision with other inner class name */
    private final class ServiceConnectionC0144b implements ServiceConnection {
        private final c a;

        private ServiceConnectionC0144b(c cVar) {
            if (cVar == null) {
                throw new RuntimeException("Please specify a listener to know when setup is done.");
            }
            this.a = cVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            j5.a.a("InstallReferrerClient", "Install Referrer service connected.");
            b.this.c = a.a.Y0(iBinder);
            b.this.a = 2;
            this.a.onInstallReferrerSetupFinished(0);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            j5.a.b("InstallReferrerClient", "Install Referrer service disconnected.");
            b.this.c = null;
            b.this.a = 0;
            this.a.onInstallReferrerServiceDisconnected();
        }
    }

    public b(Context context) {
        this.b = context.getApplicationContext();
    }

    private boolean g() {
        return this.b.getPackageManager().getPackageInfo("com.android.vending", 128).versionCode >= 80837300;
    }

    public void a() {
        this.a = 3;
        if (this.d != null) {
            j5.a.a("InstallReferrerClient", "Unbinding from service.");
            this.b.unbindService(this.d);
            this.d = null;
        }
        this.c = null;
    }

    public d b() {
        if (!h()) {
            throw new IllegalStateException("Service not connected. Please start a connection before using the service.");
        }
        Bundle bundle = new Bundle();
        bundle.putString("package_name", this.b.getPackageName());
        try {
            return new d(this.c.w(bundle));
        } catch (RemoteException e) {
            j5.a.b("InstallReferrerClient", "RemoteException getting install referrer information");
            this.a = 0;
            throw e;
        }
    }

    public void d(c cVar) {
        ServiceInfo serviceInfo;
        if (h()) {
            j5.a.a("InstallReferrerClient", "Service connection is valid. No need to re-initialize.");
            cVar.onInstallReferrerSetupFinished(0);
            return;
        }
        int i = this.a;
        if (i == 1) {
            j5.a.b("InstallReferrerClient", "Client is already in the process of connecting to the service.");
            cVar.onInstallReferrerSetupFinished(3);
            return;
        }
        if (i == 3) {
            j5.a.b("InstallReferrerClient", "Client was already closed and can't be reused. Please create another instance.");
            cVar.onInstallReferrerSetupFinished(3);
            return;
        }
        j5.a.a("InstallReferrerClient", "Starting install referrer service setup.");
        Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
        intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
        List<ResolveInfo> queryIntentServices = this.b.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.isEmpty() || (serviceInfo = queryIntentServices.get(0).serviceInfo) == null) {
            this.a = 0;
            j5.a.a("InstallReferrerClient", "Install Referrer service unavailable on device.");
            cVar.onInstallReferrerSetupFinished(2);
            return;
        }
        String str = serviceInfo.packageName;
        String str2 = serviceInfo.name;
        if (!"com.android.vending".equals(str) || str2 == null || !g()) {
            j5.a.b("InstallReferrerClient", "Play Store missing or incompatible. Version 8.3.73 or later required.");
            this.a = 0;
            cVar.onInstallReferrerSetupFinished(2);
            return;
        }
        Intent intent2 = new Intent(intent);
        ServiceConnectionC0144b serviceConnectionC0144b = new ServiceConnectionC0144b(cVar);
        this.d = serviceConnectionC0144b;
        try {
            if (this.b.bindService(intent2, serviceConnectionC0144b, 1)) {
                j5.a.a("InstallReferrerClient", "Service was bonded successfully.");
                return;
            }
            j5.a.b("InstallReferrerClient", "Connection to service is blocked.");
            this.a = 0;
            cVar.onInstallReferrerSetupFinished(1);
        } catch (SecurityException unused) {
            j5.a.b("InstallReferrerClient", "No permission to connect to service.");
            this.a = 0;
            cVar.onInstallReferrerSetupFinished(4);
        }
    }

    public boolean h() {
        return (this.a != 2 || this.c == null || this.d == null) ? false : true;
    }
}
