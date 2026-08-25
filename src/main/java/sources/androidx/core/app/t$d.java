package androidx.core.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import e.a;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class t$d implements Handler.Callback, ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    private final Context f6960a;

    /* renamed from: b, reason: collision with root package name */
    private final HandlerThread f6961b;

    /* renamed from: c, reason: collision with root package name */
    private final Handler f6962c;

    /* renamed from: d, reason: collision with root package name */
    private final Map f6963d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    private Set f6964e = new HashSet();

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        final ComponentName f6965a;

        /* renamed from: c, reason: collision with root package name */
        e.a f6967c;

        /* renamed from: b, reason: collision with root package name */
        boolean f6966b = false;

        /* renamed from: d, reason: collision with root package name */
        ArrayDeque f6968d = new ArrayDeque();

        /* renamed from: e, reason: collision with root package name */
        int f6969e = 0;

        a(ComponentName componentName) {
            this.f6965a = componentName;
        }
    }

    t$d(Context context) {
        this.f6960a = context;
        HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
        this.f6961b = handlerThread;
        handlerThread.start();
        this.f6962c = new Handler(handlerThread.getLooper(), this);
    }

    private boolean a(a aVar) {
        if (aVar.f6966b) {
            return true;
        }
        boolean bindService = this.f6960a.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(aVar.f6965a), this, 33);
        aVar.f6966b = bindService;
        if (bindService) {
            aVar.f6969e = 0;
        } else {
            Log.w("NotifManCompat", "Unable to bind to listener " + aVar.f6965a);
            this.f6960a.unbindService(this);
        }
        return aVar.f6966b;
    }

    private void b(a aVar) {
        if (aVar.f6966b) {
            this.f6960a.unbindService(this);
            aVar.f6966b = false;
        }
        aVar.f6967c = null;
    }

    private void c(t$e t_e) {
        j();
        for (a aVar : this.f6963d.values()) {
            aVar.f6968d.add(t_e);
            g(aVar);
        }
    }

    private void d(ComponentName componentName) {
        a aVar = (a) this.f6963d.get(componentName);
        if (aVar != null) {
            g(aVar);
        }
    }

    private void e(ComponentName componentName, IBinder iBinder) {
        a aVar = (a) this.f6963d.get(componentName);
        if (aVar != null) {
            aVar.f6967c = a.AbstractBinderC0135a.X0(iBinder);
            aVar.f6969e = 0;
            g(aVar);
        }
    }

    private void f(ComponentName componentName) {
        a aVar = (a) this.f6963d.get(componentName);
        if (aVar != null) {
            b(aVar);
        }
    }

    private void g(a aVar) {
        if (Log.isLoggable("NotifManCompat", 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Processing component ");
            sb.append(aVar.f6965a);
            sb.append(", ");
            sb.append(aVar.f6968d.size());
            sb.append(" queued tasks");
        }
        if (aVar.f6968d.isEmpty()) {
            return;
        }
        if (!a(aVar) || aVar.f6967c == null) {
            i(aVar);
            return;
        }
        while (true) {
            t$e t_e = (t$e) aVar.f6968d.peek();
            if (t_e == null) {
                break;
            }
            try {
                if (Log.isLoggable("NotifManCompat", 3)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Sending task ");
                    sb2.append(t_e);
                }
                t_e.a(aVar.f6967c);
                aVar.f6968d.remove();
            } catch (DeadObjectException unused) {
                if (Log.isLoggable("NotifManCompat", 3)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Remote service has died: ");
                    sb3.append(aVar.f6965a);
                }
            } catch (RemoteException e5) {
                Log.w("NotifManCompat", "RemoteException communicating with " + aVar.f6965a, e5);
            }
        }
        if (aVar.f6968d.isEmpty()) {
            return;
        }
        i(aVar);
    }

    private void i(a aVar) {
        if (this.f6962c.hasMessages(3, aVar.f6965a)) {
            return;
        }
        int i5 = aVar.f6969e;
        int i6 = i5 + 1;
        aVar.f6969e = i6;
        if (i6 <= 6) {
            int i7 = (1 << i5) * 1000;
            if (Log.isLoggable("NotifManCompat", 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Scheduling retry for ");
                sb.append(i7);
                sb.append(" ms");
            }
            this.f6962c.sendMessageDelayed(this.f6962c.obtainMessage(3, aVar.f6965a), i7);
            return;
        }
        Log.w("NotifManCompat", "Giving up on delivering " + aVar.f6968d.size() + " tasks to " + aVar.f6965a + " after " + aVar.f6969e + " retries");
        aVar.f6968d.clear();
    }

    private void j() {
        Set c5 = t.c(this.f6960a);
        if (c5.equals(this.f6964e)) {
            return;
        }
        this.f6964e = c5;
        List<ResolveInfo> queryIntentServices = this.f6960a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
        HashSet<ComponentName> hashSet = new HashSet();
        for (ResolveInfo resolveInfo : queryIntentServices) {
            if (c5.contains(resolveInfo.serviceInfo.packageName)) {
                ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                if (resolveInfo.serviceInfo.permission != null) {
                    Log.w("NotifManCompat", "Permission present on component " + componentName + ", not adding listener record.");
                } else {
                    hashSet.add(componentName);
                }
            }
        }
        for (ComponentName componentName2 : hashSet) {
            if (!this.f6963d.containsKey(componentName2)) {
                if (Log.isLoggable("NotifManCompat", 3)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Adding listener record for ");
                    sb.append(componentName2);
                }
                this.f6963d.put(componentName2, new a(componentName2));
            }
        }
        Iterator it = this.f6963d.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (!hashSet.contains(entry.getKey())) {
                if (Log.isLoggable("NotifManCompat", 3)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Removing listener record for ");
                    sb2.append(entry.getKey());
                }
                b((a) entry.getValue());
                it.remove();
            }
        }
    }

    public void h(t$e t_e) {
        this.f6962c.obtainMessage(0, t_e).sendToTarget();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i5 = message.what;
        if (i5 == 0) {
            c((t$e) message.obj);
            return true;
        }
        if (i5 == 1) {
            t$c t_c = (t$c) message.obj;
            e(t_c.f6958a, t_c.f6959b);
            return true;
        }
        if (i5 == 2) {
            f((ComponentName) message.obj);
            return true;
        }
        if (i5 != 3) {
            return false;
        }
        d((ComponentName) message.obj);
        return true;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("NotifManCompat", 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Connected to service ");
            sb.append(componentName);
        }
        this.f6962c.obtainMessage(1, new t$c(componentName, iBinder)).sendToTarget();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("NotifManCompat", 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Disconnected from service ");
            sb.append(componentName);
        }
        this.f6962c.obtainMessage(2, componentName).sendToTarget();
    }
}
