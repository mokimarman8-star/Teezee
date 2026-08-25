package androidx.coroutines;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.coroutines.i;
import androidx.coroutines.j;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.c1;
import kotlinx.coroutines.flow.w0;
import kotlinx.coroutines.n0;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class MultiInstanceInvalidationClient {

    /* renamed from: a, reason: collision with root package name */
    private final String f13018a;

    /* renamed from: b, reason: collision with root package name */
    private final InvalidationTracker f13019b;

    /* renamed from: c, reason: collision with root package name */
    private final Context f13020c;

    /* renamed from: d, reason: collision with root package name */
    private final n0 f13021d;

    /* renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f13022e;

    /* renamed from: f, reason: collision with root package name */
    private int f13023f;

    /* renamed from: g, reason: collision with root package name */
    private j f13024g;

    /* renamed from: h, reason: collision with root package name */
    private final w0 f13025h;

    /* renamed from: i, reason: collision with root package name */
    private final a f13026i;

    /* renamed from: j, reason: collision with root package name */
    private final i f13027j;

    /* renamed from: k, reason: collision with root package name */
    private final ServiceConnection f13028k;

    public static final class a extends InvalidationTracker$b {
        a(String[] strArr) {
            super(strArr);
        }

        @Override // androidx.coroutines.InvalidationTracker$b
        public boolean b() {
            return true;
        }

        @Override // androidx.coroutines.InvalidationTracker$b
        public void c(Set set) {
            Intrinsics.h(set, "tables");
            if (MultiInstanceInvalidationClient.this.f13022e.get()) {
                return;
            }
            try {
                j jVar = MultiInstanceInvalidationClient.this.f13024g;
                if (jVar != null) {
                    jVar.Z(MultiInstanceInvalidationClient.this.f13023f, (String[]) set.toArray(new String[0]));
                }
            } catch (RemoteException e5) {
                Log.w("ROOM", "Cannot broadcast invalidation", e5);
            }
        }
    }

    public static final class b implements ServiceConnection {
        b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Intrinsics.h(componentName, "name");
            Intrinsics.h(iBinder, NotificationCompat.CATEGORY_SERVICE);
            MultiInstanceInvalidationClient.this.f13024g = j.a.X0(iBinder);
            MultiInstanceInvalidationClient.this.i();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Intrinsics.h(componentName, "name");
            MultiInstanceInvalidationClient.this.f13024g = null;
        }
    }

    public MultiInstanceInvalidationClient(Context context, String str, InvalidationTracker invalidationTracker) {
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "name");
        Intrinsics.h(invalidationTracker, "invalidationTracker");
        this.f13018a = str;
        this.f13019b = invalidationTracker;
        this.f13020c = context.getApplicationContext();
        this.f13021d = invalidationTracker.n().x();
        this.f13022e = new AtomicBoolean(true);
        this.f13025h = c1.a(0, 0, BufferOverflow.SUSPEND);
        this.f13026i = new a(invalidationTracker.o());
        this.f13027j = new i.a() { // from class: androidx.room.MultiInstanceInvalidationClient$invalidationCallback$1
            @Override // androidx.coroutines.i
            public void o(String[] strArr) {
                n0 n0Var;
                Intrinsics.h(strArr, "tables");
                n0Var = MultiInstanceInvalidationClient.this.f13021d;
                kotlinx.coroutines.i.d(n0Var, (CoroutineContext) null, (CoroutineStart) null, new C0197x5cbf7351(strArr, MultiInstanceInvalidationClient.this, null), 3, (Object) null);
            }
        };
        this.f13028k = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i() {
        try {
            j jVar = this.f13024g;
            if (jVar != null) {
                this.f13023f = jVar.r0(this.f13027j, this.f13018a);
            }
        } catch (RemoteException e5) {
            Log.w("ROOM", "Cannot register multi-instance invalidation callback", e5);
        }
    }

    public final InvalidationTracker h() {
        return this.f13019b;
    }

    public final void j(Intent intent) {
        Intrinsics.h(intent, "serviceIntent");
        if (this.f13022e.compareAndSet(true, false)) {
            this.f13020c.bindService(intent, this.f13028k, 1);
            this.f13019b.j(this.f13026i);
        }
    }

    public final void k() {
        if (this.f13022e.compareAndSet(false, true)) {
            this.f13019b.y(this.f13026i);
            try {
                j jVar = this.f13024g;
                if (jVar != null) {
                    jVar.V0(this.f13027j, this.f13023f);
                }
            } catch (RemoteException e5) {
                Log.w("ROOM", "Cannot unregister multi-instance invalidation callback", e5);
            }
            this.f13020c.unbindService(this.f13028k);
        }
    }
}
