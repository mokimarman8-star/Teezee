package androidx.room;

import android.app.ActivityManager;
import android.content.Context;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.os.Looper;
import androidx.room.support.AutoCloser;
import androidx.room.util.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import w3.a;
import z3.d;
import z3.e;
import z3.g;
import z3.h;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class RoomDatabase {
    public static final c o = new c((DefaultConstructorMarker) null);
    protected volatile d a;
    private n0 b;
    private CoroutineContext c;
    private Executor d;
    private Executor e;
    private v f;
    private InvalidationTracker g;
    private boolean i;
    protected List j;
    private AutoCloser k;
    private final a h = new a(new closeBarrier.1(this));
    private final ThreadLocal l = new ThreadLocal();
    private final Map m = new LinkedHashMap();
    private boolean n = true;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b\nj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u000b"}, d2 = {"Landroidx/room/RoomDatabase$JournalMode;", "", "<init>", "(Ljava/lang/String;I)V", "AUTOMATIC", "TRUNCATE", "WRITE_AHEAD_LOGGING", "resolve", "context", "Landroid/content/Context;", "resolve$room_runtime_release", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class JournalMode {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ JournalMode[] $VALUES;
        public static final JournalMode AUTOMATIC = new JournalMode("AUTOMATIC", 0);
        public static final JournalMode TRUNCATE = new JournalMode("TRUNCATE", 1);
        public static final JournalMode WRITE_AHEAD_LOGGING = new JournalMode("WRITE_AHEAD_LOGGING", 2);

        private static final /* synthetic */ JournalMode[] $values() {
            return new JournalMode[]{AUTOMATIC, TRUNCATE, WRITE_AHEAD_LOGGING};
        }

        static {
            JournalMode[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.a($values);
        }

        private JournalMode(String str, int i) {
        }

        public static EnumEntries<JournalMode> getEntries() {
            return $ENTRIES;
        }

        public static JournalMode valueOf(String str) {
            return (JournalMode) Enum.valueOf(JournalMode.class, str);
        }

        public static JournalMode[] values() {
            return (JournalMode[]) $VALUES.clone();
        }

        public final JournalMode resolve$room_runtime_release(Context context) {
            Intrinsics.h(context, "context");
            if (this != AUTOMATIC) {
                return this;
            }
            Object systemService = context.getSystemService("activity");
            ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
            return (activityManager == null || activityManager.isLowRamDevice()) ? TRUNCATE : WRITE_AHEAD_LOGGING;
        }
    }

    private final void N() {
        i();
        d writableDatabase = z().getWritableDatabase();
        if (!writableDatabase.v0()) {
            y().D();
        }
        if (writableDatabase.z0()) {
            writableDatabase.K();
        } else {
            writableDatabase.A();
        }
    }

    private final void O() {
        z().getWritableDatabase().L();
        if (L()) {
            return;
        }
        y().x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U() {
        n0 n0Var = this.b;
        v vVar = null;
        if (n0Var == null) {
            Intrinsics.y("coroutineScope");
            n0Var = null;
        }
        o0.d(n0Var, (CancellationException) null, 1, (Object) null);
        y().B();
        v vVar2 = this.f;
        if (vVar2 == null) {
            Intrinsics.y("connectionManager");
        } else {
            vVar = vVar2;
        }
        vVar.F();
    }

    public static /* synthetic */ Cursor X(RoomDatabase roomDatabase, g gVar, CancellationSignal cancellationSignal, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: query");
        }
        if ((i & 2) != 0) {
            cancellationSignal = null;
        }
        return roomDatabase.W(gVar, cancellationSignal);
    }

    private final Object Z(Function0 function0) {
        if (!K()) {
            return b.d(this, false, true, new a0(function0));
        }
        k();
        try {
            Object invoke = function0.invoke();
            e0();
            return invoke;
        } finally {
            t();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b0(Runnable runnable) {
        runnable.run();
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object c0(Callable callable) {
        return callable.call();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object d0(Function0 function0, y3.b bVar) {
        Intrinsics.h(bVar, "it");
        return function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(RoomDatabase roomDatabase, d dVar) {
        Intrinsics.h(dVar, "it");
        roomDatabase.N();
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final e o(RoomDatabase roomDatabase, c cVar) {
        Intrinsics.h(cVar, "config");
        return roomDatabase.s(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(RoomDatabase roomDatabase, d dVar) {
        Intrinsics.h(dVar, "it");
        roomDatabase.O();
        return Unit.a;
    }

    public final CoroutineContext A() {
        n0 n0Var = this.b;
        if (n0Var == null) {
            Intrinsics.y("coroutineScope");
            n0Var = null;
        }
        return n0Var.getCoroutineContext();
    }

    public Set B() {
        Set C = C();
        ArrayList arrayList = new ArrayList(CollectionsKt.v(C, 10));
        Iterator it = C.iterator();
        while (it.hasNext()) {
            arrayList.add(JvmClassMappingKt.c((Class) it.next()));
        }
        return CollectionsKt.W0(arrayList);
    }

    public Set C() {
        return SetsKt.f();
    }

    protected Map D() {
        Set<Map.Entry> entrySet = F().entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.e(MapsKt.e(CollectionsKt.v(entrySet, 10)), 16));
        for (Map.Entry entry : entrySet) {
            Class cls = (Class) entry.getKey();
            List list = (List) entry.getValue();
            KClass c = JvmClassMappingKt.c(cls);
            List list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.v(list2, 10));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(JvmClassMappingKt.c((Class) it.next()));
            }
            Pair a = TuplesKt.a(c, arrayList);
            linkedHashMap.put(a.getFirst(), a.getSecond());
        }
        return linkedHashMap;
    }

    public final Map E() {
        return D();
    }

    protected Map F() {
        return MapsKt.h();
    }

    public final ThreadLocal G() {
        return this.l;
    }

    public final CoroutineContext H() {
        CoroutineContext coroutineContext = this.c;
        if (coroutineContext != null) {
            return coroutineContext;
        }
        Intrinsics.y("transactionContext");
        return null;
    }

    public Executor I() {
        Executor executor = this.e;
        if (executor != null) {
            return executor;
        }
        Intrinsics.y("internalTransactionExecutor");
        return null;
    }

    public final boolean J() {
        return this.n;
    }

    public final boolean K() {
        v vVar = this.f;
        if (vVar == null) {
            Intrinsics.y("connectionManager");
            vVar = null;
        }
        return vVar.G() != null;
    }

    public boolean L() {
        return T() && z().getWritableDatabase().v0();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0160 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x010d A[LOOP:0: B:45:0x010d->B:49:0x0116, LOOP_START, PHI: r0
      0x010d: PHI (r0v29 androidx.room.support.AutoClosingRoomOpenHelper) = (r0v28 androidx.room.support.AutoClosingRoomOpenHelper), (r0v31 androidx.room.support.AutoClosingRoomOpenHelper) binds: [B:26:0x0109, B:49:0x0116] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void M(androidx.room.c r8) {
        /*
            Method dump skipped, instructions count: 353
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomDatabase.M(androidx.room.c):void");
    }

    protected final void P(y3.b bVar) {
        Intrinsics.h(bVar, "connection");
        y().q(bVar);
    }

    protected void Q(d dVar) {
        Intrinsics.h(dVar, "db");
        P(new androidx.room.driver.a(dVar));
    }

    public final boolean R() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public boolean S() {
        AutoCloser autoCloser = this.k;
        if (autoCloser != null) {
            return autoCloser.m();
        }
        v vVar = this.f;
        if (vVar == null) {
            Intrinsics.y("connectionManager");
            vVar = null;
        }
        return vVar.J();
    }

    public final boolean T() {
        v vVar = this.f;
        if (vVar == null) {
            Intrinsics.y("connectionManager");
            vVar = null;
        }
        return vVar.J();
    }

    public final Cursor V(g gVar) {
        Intrinsics.h(gVar, "query");
        return X(this, gVar, null, 2, null);
    }

    public Cursor W(g gVar, CancellationSignal cancellationSignal) {
        Intrinsics.h(gVar, "query");
        i();
        j();
        return cancellationSignal != null ? z().getWritableDatabase().a0(gVar, cancellationSignal) : z().getWritableDatabase().b0(gVar);
    }

    public Object Y(Callable callable) {
        Intrinsics.h(callable, "body");
        return Z(new z(callable));
    }

    public void a0(Runnable runnable) {
        Intrinsics.h(runnable, "body");
        Z(new b0(runnable));
    }

    public void e0() {
        z().getWritableDatabase().I();
    }

    public final Object f0(boolean z, Function2 function2, Continuation continuation) {
        v vVar = this.f;
        if (vVar == null) {
            Intrinsics.y("connectionManager");
            vVar = null;
        }
        return vVar.K(z, function2, continuation);
    }

    public final void h(KClass kClass, Object obj) {
        Intrinsics.h(kClass, "kclass");
        Intrinsics.h(obj, "converter");
        this.m.put(kClass, obj);
    }

    public void i() {
        if (!this.i && R()) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    public void j() {
        if (K() && !L() && this.l.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    public void k() {
        i();
        AutoCloser autoCloser = this.k;
        if (autoCloser == null) {
            N();
        } else {
            autoCloser.h(new y(this));
        }
    }

    public h m(String str) {
        Intrinsics.h(str, "sql");
        i();
        j();
        return z().getWritableDatabase().Y(str);
    }

    public List n(Map map) {
        Intrinsics.h(map, "autoMigrationSpecs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.e(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            linkedHashMap.put(JvmClassMappingKt.a((KClass) entry.getKey()), entry.getValue());
        }
        return v(linkedHashMap);
    }

    public final v p(c cVar) {
        f0 f0Var;
        Intrinsics.h(cVar, "configuration");
        try {
            g0 r = r();
            Intrinsics.f(r, "null cannot be cast to non-null type androidx.room.RoomOpenDelegate");
            f0Var = (f0) r;
        } catch (NotImplementedError unused) {
            f0Var = null;
        }
        return f0Var == null ? new v(cVar, new x(this)) : new v(cVar, f0Var);
    }

    protected abstract InvalidationTracker q();

    protected g0 r() {
        throw new NotImplementedError((String) null, 1, (DefaultConstructorMarker) null);
    }

    protected e s(c cVar) {
        Intrinsics.h(cVar, "config");
        throw new NotImplementedError((String) null, 1, (DefaultConstructorMarker) null);
    }

    public void t() {
        AutoCloser autoCloser = this.k;
        if (autoCloser == null) {
            O();
        } else {
            autoCloser.h(new w(this));
        }
    }

    public List v(Map map) {
        Intrinsics.h(map, "autoMigrationSpecs");
        return CollectionsKt.l();
    }

    public final a w() {
        return this.h;
    }

    public final n0 x() {
        n0 n0Var = this.b;
        if (n0Var != null) {
            return n0Var;
        }
        Intrinsics.y("coroutineScope");
        return null;
    }

    public InvalidationTracker y() {
        InvalidationTracker invalidationTracker = this.g;
        if (invalidationTracker != null) {
            return invalidationTracker;
        }
        Intrinsics.y("internalTracker");
        return null;
    }

    public e z() {
        v vVar = this.f;
        if (vVar == null) {
            Intrinsics.y("connectionManager");
            vVar = null;
        }
        e G = vVar.G();
        if (G != null) {
            return G;
        }
        throw new IllegalStateException("Cannot return a SupportSQLiteOpenHelper since no SupportSQLiteOpenHelper.Factory was configured with Room.");
    }
}
