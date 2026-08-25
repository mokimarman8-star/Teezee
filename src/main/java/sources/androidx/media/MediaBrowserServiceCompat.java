package androidx.media;

import android.app.Service;
import android.content.Intent;
import android.media.session.MediaSession;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.b;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.a;
import androidx.core.app.f;
import androidx.core.util.e;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class MediaBrowserServiceCompat extends Service {
    static final boolean i = Log.isLoggable("MBServiceCompat", 3);
    private f a;
    ConnectionRecord f;
    MediaSessionCompat.Token h;
    private final ServiceBinderImpl b = new ServiceBinderImpl();
    final ConnectionRecord c = new ConnectionRecord("android.media.session.MediaController", -1, -1, null, null);
    final ArrayList d = new ArrayList();
    final a e = new a();
    final o g = new o(this);

    private class ConnectionRecord implements IBinder.DeathRecipient {
        public final String a;
        public final int b;
        public final int c;
        public final b d;
        public final Bundle e;
        public final m f;
        public final HashMap g = new HashMap();
        public e h;

        ConnectionRecord(String str, int i, int i2, Bundle bundle, m mVar) {
            this.a = str;
            this.b = i;
            this.c = i2;
            this.d = new b(str, i, i2);
            this.e = bundle;
            this.f = mVar;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            MediaBrowserServiceCompat.this.g.post(new 1(this));
        }
    }

    class MediaBrowserServiceImplApi21 implements f {
        final List a = new ArrayList();
        MediaBrowserService b;
        Messenger c;

        MediaBrowserServiceImplApi21() {
        }

        public void a(final MediaSessionCompat.Token token) {
            MediaBrowserServiceCompat.this.g.a(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.1
                @Override // java.lang.Runnable
                public void run() {
                    MediaBrowserServiceImplApi21.this.f(token);
                }
            });
        }

        public IBinder b(Intent intent) {
            return this.b.onBind(intent);
        }

        void c(ConnectionRecord connectionRecord, String str, Bundle bundle) {
            List<e> list = (List) connectionRecord.g.get(str);
            if (list != null) {
                for (e eVar : list) {
                    if (a.b(bundle, (Bundle) eVar.b)) {
                        MediaBrowserServiceCompat.this.n(str, connectionRecord, (Bundle) eVar.b, bundle);
                    }
                }
            }
        }

        public e d(String str, int i, Bundle bundle) {
            Bundle bundle2;
            int i2 = -1;
            if (bundle == null || bundle.getInt("extra_client_version", 0) == 0) {
                bundle2 = null;
            } else {
                bundle.remove("extra_client_version");
                this.c = new Messenger((Handler) MediaBrowserServiceCompat.this.g);
                bundle2 = new Bundle();
                bundle2.putInt("extra_service_version", 2);
                f.b(bundle2, "extra_messenger", this.c.getBinder());
                MediaSessionCompat.Token token = MediaBrowserServiceCompat.this.h;
                if (token != null) {
                    b extraBinder = token.getExtraBinder();
                    f.b(bundle2, "extra_session_binder", extraBinder == null ? null : extraBinder.asBinder());
                } else {
                    this.a.add(bundle2);
                }
                i2 = bundle.getInt("extra_calling_pid", -1);
                bundle.remove("extra_calling_pid");
            }
            ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.new ConnectionRecord(str, i2, i, bundle, null);
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat.f = connectionRecord;
            e f = mediaBrowserServiceCompat.f(str, i, bundle);
            MediaBrowserServiceCompat mediaBrowserServiceCompat2 = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat2.f = null;
            if (f == null) {
                return null;
            }
            if (this.c != null) {
                mediaBrowserServiceCompat2.d.add(connectionRecord);
            }
            if (bundle2 == null) {
                bundle2 = f.c();
            } else if (f.c() != null) {
                bundle2.putAll(f.c());
            }
            return new e(f.d(), bundle2);
        }

        public void e(String str, l lVar) {
            k aVar = new a(this, str, lVar);
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat.f = mediaBrowserServiceCompat.c;
            mediaBrowserServiceCompat.g(str, aVar);
            MediaBrowserServiceCompat.this.f = null;
        }

        void f(MediaSessionCompat.Token token) {
            if (!this.a.isEmpty()) {
                b extraBinder = token.getExtraBinder();
                if (extraBinder != null) {
                    Iterator it = this.a.iterator();
                    while (it.hasNext()) {
                        f.b((Bundle) it.next(), "extra_session_binder", extraBinder.asBinder());
                    }
                }
                this.a.clear();
            }
            this.b.setSessionToken((MediaSession.Token) token.getToken());
        }
    }

    private class ServiceBinderImpl {
        ServiceBinderImpl() {
        }

        public void a(final String str, final IBinder iBinder, final Bundle bundle, final m mVar) {
            MediaBrowserServiceCompat.this.g.a(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.3
                @Override // java.lang.Runnable
                public void run() {
                    ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.e.get(mVar.asBinder());
                    if (connectionRecord != null) {
                        MediaBrowserServiceCompat.this.a(str, connectionRecord, iBinder, bundle);
                        return;
                    }
                    Log.w("MBServiceCompat", "addSubscription for callback that isn't registered id=" + str);
                }
            });
        }

        public void b(String str, int i, int i2, Bundle bundle, m mVar) {
            if (MediaBrowserServiceCompat.this.d(str, i2)) {
                MediaBrowserServiceCompat.this.g.a(new 1(this, mVar, str, i, i2, bundle));
                return;
            }
            throw new IllegalArgumentException("Package/uid mismatch: uid=" + i2 + " package=" + str);
        }

        public void c(m mVar) {
            MediaBrowserServiceCompat.this.g.a(new 2(this, mVar));
        }

        public void d(String str, ResultReceiver resultReceiver, m mVar) {
            if (TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            MediaBrowserServiceCompat.this.g.a(new 5(this, mVar, str, resultReceiver));
        }

        public void e(final m mVar, final String str, final int i, final int i2, final Bundle bundle) {
            MediaBrowserServiceCompat.this.g.a(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.6
                @Override // java.lang.Runnable
                public void run() {
                    ConnectionRecord connectionRecord;
                    IBinder asBinder = mVar.asBinder();
                    MediaBrowserServiceCompat.this.e.remove(asBinder);
                    Iterator it = MediaBrowserServiceCompat.this.d.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ConnectionRecord connectionRecord2 = (ConnectionRecord) it.next();
                        if (connectionRecord2.c == i2) {
                            connectionRecord = (TextUtils.isEmpty(str) || i <= 0) ? MediaBrowserServiceCompat.this.new ConnectionRecord(connectionRecord2.a, connectionRecord2.b, connectionRecord2.c, bundle, mVar) : null;
                            it.remove();
                        }
                    }
                    if (connectionRecord == null) {
                        connectionRecord = MediaBrowserServiceCompat.this.new ConnectionRecord(str, i, i2, bundle, mVar);
                    }
                    MediaBrowserServiceCompat.this.e.put(asBinder, connectionRecord);
                    try {
                        asBinder.linkToDeath(connectionRecord, 0);
                    } catch (RemoteException unused) {
                        Log.w("MBServiceCompat", "IBinder is already dead.");
                    }
                }
            });
        }

        public void f(String str, IBinder iBinder, m mVar) {
            MediaBrowserServiceCompat.this.g.a(new 4(this, mVar, str, iBinder));
        }

        public void g(String str, Bundle bundle, ResultReceiver resultReceiver, m mVar) {
            if (TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            MediaBrowserServiceCompat.this.g.a(new 8(this, mVar, str, bundle, resultReceiver));
        }

        public void h(String str, Bundle bundle, ResultReceiver resultReceiver, m mVar) {
            if (TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            MediaBrowserServiceCompat.this.g.a(new 9(this, mVar, str, bundle, resultReceiver));
        }

        public void i(m mVar) {
            MediaBrowserServiceCompat.this.g.a(new 7(this, mVar));
        }
    }

    void a(String str, ConnectionRecord connectionRecord, IBinder iBinder, Bundle bundle) {
        List<e> list = (List) connectionRecord.g.get(str);
        if (list == null) {
            list = new ArrayList();
        }
        for (e eVar : list) {
            if (iBinder == eVar.a && a.a(bundle, (Bundle) eVar.b)) {
                return;
            }
        }
        list.add(new e(iBinder, bundle));
        connectionRecord.g.put(str, list);
        n(str, connectionRecord, bundle, null);
        this.f = connectionRecord;
        k(str, bundle);
        this.f = null;
    }

    List b(List list, Bundle bundle) {
        if (list == null) {
            return null;
        }
        int i2 = bundle.getInt("android.media.browse.extra.PAGE", -1);
        int i3 = bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
        if (i2 == -1 && i3 == -1) {
            return list;
        }
        int i4 = i3 * i2;
        int i6 = i4 + i3;
        if (i2 < 0 || i3 < 1 || i4 >= list.size()) {
            return Collections.emptyList();
        }
        if (i6 > list.size()) {
            i6 = list.size();
        }
        return list.subList(i4, i6);
    }

    void c(Message message) {
        Bundle data = message.getData();
        switch (message.what) {
            case 1:
                Bundle bundle = data.getBundle("data_root_hints");
                MediaSessionCompat.a(bundle);
                this.b.b(data.getString("data_package_name"), data.getInt("data_calling_pid"), data.getInt("data_calling_uid"), bundle, new n(message.replyTo));
                break;
            case 2:
                this.b.c(new n(message.replyTo));
                break;
            case 3:
                Bundle bundle2 = data.getBundle("data_options");
                MediaSessionCompat.a(bundle2);
                this.b.a(data.getString("data_media_item_id"), f.a(data, "data_callback_token"), bundle2, new n(message.replyTo));
                break;
            case 4:
                this.b.f(data.getString("data_media_item_id"), f.a(data, "data_callback_token"), new n(message.replyTo));
                break;
            case 5:
                this.b.d(data.getString("data_media_item_id"), (ResultReceiver) data.getParcelable("data_result_receiver"), new n(message.replyTo));
                break;
            case 6:
                Bundle bundle3 = data.getBundle("data_root_hints");
                MediaSessionCompat.a(bundle3);
                this.b.e(new n(message.replyTo), data.getString("data_package_name"), data.getInt("data_calling_pid"), data.getInt("data_calling_uid"), bundle3);
                break;
            case 7:
                this.b.i(new n(message.replyTo));
                break;
            case 8:
                Bundle bundle4 = data.getBundle("data_search_extras");
                MediaSessionCompat.a(bundle4);
                this.b.g(data.getString("data_search_query"), bundle4, (ResultReceiver) data.getParcelable("data_result_receiver"), new n(message.replyTo));
                break;
            case 9:
                Bundle bundle5 = data.getBundle("data_custom_action_extras");
                MediaSessionCompat.a(bundle5);
                this.b.h(data.getString("data_custom_action"), bundle5, (ResultReceiver) data.getParcelable("data_result_receiver"), new n(message.replyTo));
                break;
            default:
                Log.w("MBServiceCompat", "Unhandled message: " + message + "\n  Service version: 2\n  Client version: " + message.arg1);
                break;
        }
    }

    boolean d(String str, int i2) {
        if (str == null) {
            return false;
        }
        for (String str2 : getPackageManager().getPackagesForUid(i2)) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.app.Service
    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public void e(String str, Bundle bundle, k kVar) {
        kVar.e((Bundle) null);
    }

    public abstract e f(String str, int i2, Bundle bundle);

    public abstract void g(String str, k kVar);

    public void h(String str, k kVar, Bundle bundle) {
        kVar.g(1);
        g(str, kVar);
    }

    public void i(String str, k kVar) {
        kVar.g(2);
        kVar.f((Object) null);
    }

    public void j(String str, Bundle bundle, k kVar) {
        kVar.g(4);
        kVar.f((Object) null);
    }

    public void k(String str, Bundle bundle) {
    }

    public void l(String str) {
    }

    void m(String str, Bundle bundle, ConnectionRecord connectionRecord, ResultReceiver resultReceiver) {
        d dVar = new d(this, str, resultReceiver);
        this.f = connectionRecord;
        e(str, bundle, dVar);
        this.f = null;
        if (dVar.b()) {
            return;
        }
        throw new IllegalStateException("onCustomAction must call detach() or sendResult() or sendError() before returning for action=" + str + " extras=" + bundle);
    }

    void n(String str, ConnectionRecord connectionRecord, Bundle bundle, Bundle bundle2) {
        a aVar = new a(this, str, connectionRecord, str, bundle, bundle2);
        this.f = connectionRecord;
        if (bundle == null) {
            g(str, aVar);
        } else {
            h(str, aVar, bundle);
        }
        this.f = null;
        if (aVar.b()) {
            return;
        }
        throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + connectionRecord.a + " id=" + str);
    }

    void o(String str, ConnectionRecord connectionRecord, ResultReceiver resultReceiver) {
        b bVar = new b(this, str, resultReceiver);
        this.f = connectionRecord;
        i(str, bVar);
        this.f = null;
        if (bVar.b()) {
            return;
        }
        throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + str);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.a.b(intent);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            this.a = new i(this);
        } else if (i2 >= 26) {
            this.a = new h(this);
        } else {
            this.a = new g(this);
        }
        this.a.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.g.b();
    }

    void p(String str, Bundle bundle, ConnectionRecord connectionRecord, ResultReceiver resultReceiver) {
        c cVar = new c(this, str, resultReceiver);
        this.f = connectionRecord;
        j(str, bundle, cVar);
        this.f = null;
        if (cVar.b()) {
            return;
        }
        throw new IllegalStateException("onSearch must call detach() or sendResult() before returning for query=" + str);
    }

    boolean q(String str, ConnectionRecord connectionRecord, IBinder iBinder) {
        boolean z = false;
        try {
            if (iBinder != null) {
                List list = (List) connectionRecord.g.get(str);
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        if (iBinder == ((e) it.next()).a) {
                            it.remove();
                            z = true;
                        }
                    }
                    if (list.size() == 0) {
                        connectionRecord.g.remove(str);
                    }
                }
            } else if (connectionRecord.g.remove(str) != null) {
                z = true;
            }
            return z;
        } finally {
            this.f = connectionRecord;
            l(str);
            this.f = null;
        }
    }

    public void r(MediaSessionCompat.Token token) {
        if (token == null) {
            throw new IllegalArgumentException("Session token may not be null");
        }
        if (this.h != null) {
            throw new IllegalStateException("The session token has already been set");
        }
        this.h = token;
        this.a.a(token);
    }
}
