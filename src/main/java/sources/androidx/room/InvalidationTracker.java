package androidx.room;

import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.LiveData;
import androidx.room.coroutines.RunBlockingUninterruptible_androidKt;
import androidx.room.support.AutoCloser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import y3.b;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class InvalidationTracker {
    public static final a o = new a((DefaultConstructorMarker) null);
    private final RoomDatabase a;
    private final Map b;
    private final Map c;
    private final String[] d;
    private final TriggerBasedInvalidationTracker e;
    private final Map f;
    private final ReentrantLock g;
    private AutoCloser h;
    private final Function0 i;
    private final Function0 j;
    private final k k;
    private Intent l;
    private MultiInstanceInvalidationClient m;
    private final Object n;

    public InvalidationTracker(RoomDatabase roomDatabase, Map map, Map map2, String... strArr) {
        Intrinsics.h(roomDatabase, "database");
        Intrinsics.h(map, "shadowTablesMap");
        Intrinsics.h(map2, "viewTables");
        Intrinsics.h(strArr, "tableNames");
        this.a = roomDatabase;
        this.b = map;
        this.c = map2;
        this.d = strArr;
        TriggerBasedInvalidationTracker triggerBasedInvalidationTracker = new TriggerBasedInvalidationTracker(roomDatabase, map, map2, strArr, roomDatabase.J(), new implementation.1(this));
        this.e = triggerBasedInvalidationTracker;
        this.f = new LinkedHashMap();
        this.g = new ReentrantLock();
        this.i = new Function0() { // from class: androidx.room.l
            public final Object invoke() {
                Unit v;
                v = InvalidationTracker.v(InvalidationTracker.this);
                return v;
            }
        };
        this.j = new Function0() { // from class: androidx.room.m
            public final Object invoke() {
                Unit u;
                u = InvalidationTracker.u(InvalidationTracker.this);
                return u;
            }
        };
        this.k = new k(roomDatabase);
        this.n = new Object();
        triggerBasedInvalidationTracker.r(new Function0() { // from class: androidx.room.n
            public final Object invoke() {
                boolean d;
                d = InvalidationTracker.d(InvalidationTracker.this);
                return Boolean.valueOf(d);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(InvalidationTracker invalidationTracker) {
        return !invalidationTracker.a.K() || invalidationTracker.a.T();
    }

    private final boolean i(b bVar) {
        Pair v = this.e.v(bVar.a());
        String[] strArr = (String[]) v.component1();
        int[] iArr = (int[]) v.component2();
        q qVar = new q(bVar, iArr, strArr);
        ReentrantLock reentrantLock = this.g;
        reentrantLock.lock();
        try {
            q qVar2 = this.f.containsKey(bVar) ? (q) MapsKt.i(this.f, bVar) : (q) this.f.put(bVar, qVar);
            reentrantLock.unlock();
            return qVar2 == null && this.e.m(iArr);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    private final List m() {
        ReentrantLock reentrantLock = this.g;
        reentrantLock.lock();
        try {
            return CollectionsKt.R0(this.f.keySet());
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(Set set) {
        ReentrantLock reentrantLock = this.g;
        reentrantLock.lock();
        try {
            List R0 = CollectionsKt.R0(this.f.values());
            reentrantLock.unlock();
            Iterator it = R0.iterator();
            while (it.hasNext()) {
                ((q) it.next()).c(set);
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        synchronized (this.n) {
            try {
                MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.m;
                if (multiInstanceInvalidationClient != null) {
                    List m = m();
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : m) {
                        if (!((b) obj).b()) {
                            arrayList.add(obj);
                        }
                    }
                    if (arrayList.isEmpty()) {
                        multiInstanceInvalidationClient.k();
                    }
                }
                this.e.p();
                Unit unit = Unit.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(InvalidationTracker invalidationTracker) {
        AutoCloser autoCloser = invalidationTracker.h;
        if (autoCloser != null) {
            autoCloser.g();
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(InvalidationTracker invalidationTracker) {
        AutoCloser autoCloser = invalidationTracker.h;
        if (autoCloser != null) {
            autoCloser.j();
        }
        return Unit.a;
    }

    private final boolean z(b bVar) {
        ReentrantLock reentrantLock = this.g;
        reentrantLock.lock();
        try {
            q qVar = (q) this.f.remove(bVar);
            return qVar != null && this.e.n(qVar.b());
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void A(AutoCloser autoCloser) {
        Intrinsics.h(autoCloser, "autoCloser");
        this.h = autoCloser;
        autoCloser.n(new setAutoCloser.1(this));
    }

    public final void B() {
        MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.m;
        if (multiInstanceInvalidationClient != null) {
            multiInstanceInvalidationClient.k();
        }
    }

    public final Object C(Continuation continuation) {
        Object u;
        return ((!this.a.K() || this.a.T()) && (u = this.e.u(continuation)) == IntrinsicsKt.f()) ? u : Unit.a;
    }

    public final void D() {
        RunBlockingUninterruptible_androidKt.a(new syncBlocking.1(this, (Continuation) null));
    }

    public void h(b bVar) {
        Intrinsics.h(bVar, "observer");
        if (i(bVar)) {
            RunBlockingUninterruptible_androidKt.a(new addObserver.1(this, (Continuation) null));
        }
    }

    public final void j(b bVar) {
        Intrinsics.h(bVar, "observer");
        if (!bVar.b()) {
            throw new IllegalStateException("isRemote was false of observer argument");
        }
        i(bVar);
    }

    public void k(b bVar) {
        Intrinsics.h(bVar, "observer");
        h(new u0(this, bVar));
    }

    public LiveData l(String[] strArr, boolean z, Callable callable) {
        Intrinsics.h(strArr, "tableNames");
        Intrinsics.h(callable, "computeFunction");
        this.e.v(strArr);
        return this.k.a(strArr, z, callable);
    }

    public final RoomDatabase n() {
        return this.a;
    }

    public final String[] o() {
        return this.d;
    }

    public final void p(Context context, String str, Intent intent) {
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "name");
        Intrinsics.h(intent, "serviceIntent");
        this.l = intent;
        this.m = new MultiInstanceInvalidationClient(context, str, this);
    }

    public final void q(b bVar) {
        Intrinsics.h(bVar, "connection");
        this.e.j(bVar);
        synchronized (this.n) {
            try {
                MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.m;
                if (multiInstanceInvalidationClient != null) {
                    Intent intent = this.l;
                    if (intent == null) {
                        throw new IllegalStateException("Required value was null.");
                    }
                    multiInstanceInvalidationClient.j(intent);
                    Unit unit = Unit.a;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void s(Set set) {
        Intrinsics.h(set, "tables");
        ReentrantLock reentrantLock = this.g;
        reentrantLock.lock();
        try {
            List<q> R0 = CollectionsKt.R0(this.f.values());
            reentrantLock.unlock();
            for (q qVar : R0) {
                if (!qVar.a().b()) {
                    qVar.d(set);
                }
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void w() {
        this.e.o(this.i, this.j);
    }

    public void x() {
        this.e.o(this.i, this.j);
    }

    public void y(b bVar) {
        Intrinsics.h(bVar, "observer");
        if (z(bVar)) {
            RunBlockingUninterruptible_androidKt.a(new removeObserver.1(this, (Continuation) null));
        }
    }
}
