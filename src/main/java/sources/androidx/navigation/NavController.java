package androidx.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.activity.OnBackPressedDispatcher;
import androidx.core.app.b0;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.r;
import androidx.lifecycle.t;
import androidx.lifecycle.u;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigator;
import androidx.navigation.f;
import androidx.navigation.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.a;
import kotlinx.coroutines.flow.c;
import kotlinx.coroutines.flow.c1;
import kotlinx.coroutines.flow.h1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.w0;
import kotlinx.coroutines.flow.x0;
import org.mvel2.ast.ASTNode;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class NavController {
    public static final a G = new a((DefaultConstructorMarker) null);
    private static boolean H = true;
    private final Map A;
    private int B;
    private final List C;
    private final Lazy D;
    private final w0 E;
    private final a F;
    private final Context a;
    private Activity b;
    private k c;
    private NavGraph d;
    private Bundle e;
    private Parcelable[] f;
    private boolean g;
    private final ArrayDeque h;
    private final x0 i;
    private final h1 j;
    private final Map k;
    private final Map l;
    private final Map m;
    private final Map n;
    private u o;
    private OnBackPressedDispatcher p;
    private f q;
    private final CopyOnWriteArrayList r;
    private Lifecycle.State s;
    private final t t;
    private final androidx.activity.u u;
    private boolean v;
    private q w;
    private final Map x;
    private Function1 y;
    private Function1 z;

    private final class NavControllerNavigatorState extends r {
        private final Navigator g;
        final /* synthetic */ NavController h;

        public NavControllerNavigatorState(NavController navController, Navigator navigator) {
            Intrinsics.h(navController, "this$0");
            Intrinsics.h(navigator, "navigator");
            this.h = navController;
            this.g = navigator;
        }

        public NavBackStackEntry a(NavDestination navDestination, Bundle bundle) {
            Intrinsics.h(navDestination, "destination");
            return NavBackStackEntry.a.b(NavBackStackEntry.n, this.h.y(), navDestination, bundle, this.h.D(), this.h.q, (String) null, (Bundle) null, 96, (Object) null);
        }

        public void e(NavBackStackEntry navBackStackEntry) {
            f fVar;
            Intrinsics.h(navBackStackEntry, "entry");
            boolean c = Intrinsics.c(this.h.A.get(navBackStackEntry), Boolean.TRUE);
            super.e(navBackStackEntry);
            this.h.A.remove(navBackStackEntry);
            if (this.h.v().contains(navBackStackEntry)) {
                if (d()) {
                    return;
                }
                this.h.h0();
                this.h.i.b(this.h.W());
                return;
            }
            this.h.g0(navBackStackEntry);
            if (navBackStackEntry.getLifecycle().b().isAtLeast(Lifecycle.State.CREATED)) {
                navBackStackEntry.l(Lifecycle.State.DESTROYED);
            }
            ArrayDeque v = this.h.v();
            if (!(v instanceof Collection) || !v.isEmpty()) {
                Iterator it = v.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.c(((NavBackStackEntry) it.next()).g(), navBackStackEntry.g())) {
                        break;
                    }
                }
            }
            if (!c && (fVar = this.h.q) != null) {
                fVar.c(navBackStackEntry.g());
            }
            this.h.h0();
            this.h.i.b(this.h.W());
        }

        public void g(NavBackStackEntry navBackStackEntry, boolean z) {
            Intrinsics.h(navBackStackEntry, "popUpTo");
            Navigator d = this.h.w.d(navBackStackEntry.f().o());
            if (!Intrinsics.c(d, this.g)) {
                Object obj = this.h.x.get(d);
                Intrinsics.e(obj);
                ((NavControllerNavigatorState) obj).g(navBackStackEntry, z);
            } else {
                Function1 function1 = this.h.z;
                if (function1 == null) {
                    this.h.Q(navBackStackEntry, new pop.1(this, navBackStackEntry, z));
                } else {
                    function1.invoke(navBackStackEntry);
                    super.g(navBackStackEntry, z);
                }
            }
        }

        public void h(NavBackStackEntry navBackStackEntry) {
            Intrinsics.h(navBackStackEntry, "backStackEntry");
            Navigator d = this.h.w.d(navBackStackEntry.f().o());
            if (!Intrinsics.c(d, this.g)) {
                Object obj = this.h.x.get(d);
                if (obj != null) {
                    ((NavControllerNavigatorState) obj).h(navBackStackEntry);
                    return;
                }
                throw new IllegalStateException(("NavigatorBackStack for " + navBackStackEntry.f().o() + " should already be created").toString());
            }
            Function1 function1 = this.h.y;
            if (function1 != null) {
                function1.invoke(navBackStackEntry);
                k(navBackStackEntry);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Ignoring add of destination ");
                sb.append(navBackStackEntry.f());
                sb.append(" outside of the call to navigate(). ");
            }
        }

        public final void k(NavBackStackEntry navBackStackEntry) {
            Intrinsics.h(navBackStackEntry, "backStackEntry");
            super.h(navBackStackEntry);
        }
    }

    public NavController(Context context) {
        Object obj;
        Intrinsics.h(context, "context");
        this.a = context;
        Iterator it = SequencesKt.h(context, new Function1<Context, Context>() { // from class: androidx.navigation.NavController$activity$1
            public final Context invoke(Context context2) {
                Intrinsics.h(context2, "it");
                if (context2 instanceof ContextWrapper) {
                    return ((ContextWrapper) context2).getBaseContext();
                }
                return null;
            }
        }).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (((Context) obj) instanceof Activity) {
                    break;
                }
            }
        }
        this.b = (Activity) obj;
        this.h = new ArrayDeque();
        x0 a = i1.a(CollectionsKt.l());
        this.i = a;
        this.j = c.b(a);
        this.k = new LinkedHashMap();
        this.l = new LinkedHashMap();
        this.m = new LinkedHashMap();
        this.n = new LinkedHashMap();
        this.r = new CopyOnWriteArrayList();
        this.s = Lifecycle.State.INITIALIZED;
        this.t = new r() { // from class: androidx.navigation.e
            public final void onStateChanged(u uVar, Lifecycle.Event event) {
                NavController.I(NavController.this, uVar, event);
            }
        };
        this.u = new b(this);
        this.v = true;
        this.w = new q();
        this.x = new LinkedHashMap();
        this.A = new LinkedHashMap();
        q qVar = this.w;
        qVar.b(new h(qVar));
        this.w.b(new ActivityNavigator(this.a));
        this.C = new ArrayList();
        this.D = LazyKt.b(new Function0<k>() { // from class: androidx.navigation.NavController$navInflater$2
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final androidx.navigation.k m4invoke() {
                androidx.navigation.k kVar;
                kVar = NavController.this.c;
                return kVar == null ? new androidx.navigation.k(NavController.this.y(), NavController.this.w) : kVar;
            }
        });
        w0 b = c1.b(1, 0, BufferOverflow.DROP_OLDEST, 2, (Object) null);
        this.E = b;
        this.F = c.a(b);
    }

    private final int B() {
        ArrayDeque v = v();
        int i = 0;
        if (!(v instanceof Collection) || !v.isEmpty()) {
            Iterator it = v.iterator();
            while (it.hasNext()) {
                if (!(((NavBackStackEntry) it.next()).f() instanceof NavGraph) && (i = i + 1) < 0) {
                    CollectionsKt.t();
                }
            }
        }
        return i;
    }

    private final List H(ArrayDeque arrayDeque) {
        ArrayList arrayList = new ArrayList();
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) v().l();
        NavDestination f = navBackStackEntry == null ? null : navBackStackEntry.f();
        if (f == null) {
            f = C();
        }
        if (arrayDeque != null) {
            Iterator it = arrayDeque.iterator();
            while (it.hasNext()) {
                NavBackStackEntryState navBackStackEntryState = (NavBackStackEntryState) it.next();
                NavDestination t = t(f, navBackStackEntryState.getDestinationId());
                if (t == null) {
                    throw new IllegalStateException(("Restore State failed: destination " + NavDestination.j.b(y(), navBackStackEntryState.getDestinationId()) + " cannot be found from the current destination " + f).toString());
                }
                arrayList.add(navBackStackEntryState.instantiate(y(), t, D(), this.q));
                f = t;
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(NavController navController, u uVar, Lifecycle.Event event) {
        Intrinsics.h(navController, "this$0");
        Intrinsics.h(uVar, "$noName_0");
        Intrinsics.h(event, "event");
        Lifecycle.State targetState = event.getTargetState();
        Intrinsics.g(targetState, "event.targetState");
        navController.s = targetState;
        if (navController.d != null) {
            Iterator it = navController.v().iterator();
            while (it.hasNext()) {
                ((NavBackStackEntry) it.next()).i(event);
            }
        }
    }

    private final void J(NavBackStackEntry navBackStackEntry, NavBackStackEntry navBackStackEntry2) {
        this.k.put(navBackStackEntry, navBackStackEntry2);
        if (this.l.get(navBackStackEntry2) == null) {
            this.l.put(navBackStackEntry2, new AtomicInteger(0));
        }
        Object obj = this.l.get(navBackStackEntry2);
        Intrinsics.e(obj);
        ((AtomicInteger) obj).incrementAndGet();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0112 A[LOOP:1: B:20:0x010c->B:22:0x0112, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void K(final androidx.navigation.NavDestination r21, android.os.Bundle r22, androidx.navigation.l r23, androidx.navigation.Navigator.a r24) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.K(androidx.navigation.NavDestination, android.os.Bundle, androidx.navigation.l, androidx.navigation.Navigator$a):void");
    }

    private final void L(Navigator navigator, List list, l lVar, Navigator.a aVar, Function1 function1) {
        this.y = function1;
        navigator.e(list, lVar, aVar);
        this.y = null;
    }

    private final void M(Bundle bundle) {
        Activity activity;
        ArrayList<String> stringArrayList;
        Bundle bundle2 = this.e;
        if (bundle2 != null && (stringArrayList = bundle2.getStringArrayList("android-support-nav:controller:navigatorState:names")) != null) {
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                q qVar = this.w;
                Intrinsics.g(next, "name");
                Navigator d = qVar.d(next);
                Bundle bundle3 = bundle2.getBundle(next);
                if (bundle3 != null) {
                    d.h(bundle3);
                }
            }
        }
        NavBackStackEntryState[] navBackStackEntryStateArr = this.f;
        if (navBackStackEntryStateArr != null) {
            int length = navBackStackEntryStateArr.length;
            int i = 0;
            while (i < length) {
                NavBackStackEntryState navBackStackEntryState = navBackStackEntryStateArr[i];
                i++;
                NavBackStackEntryState navBackStackEntryState2 = navBackStackEntryState;
                NavDestination s = s(navBackStackEntryState2.getDestinationId());
                if (s == null) {
                    throw new IllegalStateException("Restoring the Navigation back stack failed: destination " + NavDestination.j.b(y(), navBackStackEntryState2.getDestinationId()) + " cannot be found from the current destination " + A());
                }
                NavBackStackEntry instantiate = navBackStackEntryState2.instantiate(y(), s, D(), this.q);
                Navigator d2 = this.w.d(s.o());
                Map map = this.x;
                Object obj = map.get(d2);
                if (obj == null) {
                    obj = new NavControllerNavigatorState(this, d2);
                    map.put(d2, obj);
                }
                v().add(instantiate);
                ((NavControllerNavigatorState) obj).k(instantiate);
                NavGraph p = instantiate.f().p();
                if (p != null) {
                    J(instantiate, w(p.n()));
                }
            }
            i0();
            this.f = null;
        }
        Collection values = this.w.e().values();
        ArrayList<Navigator> arrayList = new ArrayList();
        for (Object obj2 : values) {
            if (!((Navigator) obj2).c()) {
                arrayList.add(obj2);
            }
        }
        for (Navigator navigator : arrayList) {
            Map map2 = this.x;
            Object obj3 = map2.get(navigator);
            if (obj3 == null) {
                obj3 = new NavControllerNavigatorState(this, navigator);
                map2.put(navigator, obj3);
            }
            navigator.f((NavControllerNavigatorState) obj3);
        }
        if (this.d == null || !v().isEmpty()) {
            q();
            return;
        }
        if (!this.g && (activity = this.b) != null) {
            Intrinsics.e(activity);
            if (G(activity.getIntent())) {
                return;
            }
        }
        NavGraph navGraph = this.d;
        Intrinsics.e(navGraph);
        K(navGraph, bundle, null, null);
    }

    private final void R(Navigator navigator, NavBackStackEntry navBackStackEntry, boolean z, Function1 function1) {
        this.z = function1;
        navigator.j(navBackStackEntry, z);
        this.z = null;
    }

    private final boolean S(int i, boolean z, boolean z2) {
        NavDestination navDestination;
        if (v().isEmpty()) {
            return false;
        }
        ArrayList<Navigator> arrayList = new ArrayList();
        Iterator it = CollectionsKt.D0(v()).iterator();
        while (true) {
            if (!it.hasNext()) {
                navDestination = null;
                break;
            }
            NavDestination f = ((NavBackStackEntry) it.next()).f();
            Navigator d = this.w.d(f.o());
            if (z || f.n() != i) {
                arrayList.add(d);
            }
            if (f.n() == i) {
                navDestination = f;
                break;
            }
        }
        if (navDestination == null) {
            String b = NavDestination.j.b(this.a, i);
            StringBuilder sb = new StringBuilder();
            sb.append("Ignoring popBackStack to destination ");
            sb.append(b);
            sb.append(" as it was not found on the current back stack");
            return false;
        }
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        ArrayDeque arrayDeque = new ArrayDeque();
        for (Navigator navigator : arrayList) {
            Ref$BooleanRef ref$BooleanRef2 = new Ref$BooleanRef();
            R(navigator, (NavBackStackEntry) v().last(), z2, new popBackStackInternal.2(ref$BooleanRef2, ref$BooleanRef, this, z2, arrayDeque));
            if (!ref$BooleanRef2.element) {
                break;
            }
        }
        if (z2) {
            if (!z) {
                for (NavDestination navDestination2 : SequencesKt.A(SequencesKt.h(navDestination, popBackStackInternal.3.INSTANCE), new popBackStackInternal.4(this))) {
                    Map map = this.m;
                    Integer valueOf = Integer.valueOf(navDestination2.n());
                    NavBackStackEntryState navBackStackEntryState = (NavBackStackEntryState) arrayDeque.i();
                    map.put(valueOf, navBackStackEntryState == null ? null : navBackStackEntryState.getId());
                }
            }
            if (!arrayDeque.isEmpty()) {
                NavBackStackEntryState navBackStackEntryState2 = (NavBackStackEntryState) arrayDeque.first();
                Iterator it2 = SequencesKt.A(SequencesKt.h(s(navBackStackEntryState2.getDestinationId()), popBackStackInternal.6.INSTANCE), new popBackStackInternal.7(this)).iterator();
                while (it2.hasNext()) {
                    this.m.put(Integer.valueOf(((NavDestination) it2.next()).n()), navBackStackEntryState2.getId());
                }
                this.n.put(navBackStackEntryState2.getId(), arrayDeque);
            }
        }
        i0();
        return ref$BooleanRef.element;
    }

    static /* synthetic */ boolean T(NavController navController, int i, boolean z, boolean z2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popBackStackInternal");
        }
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        return navController.S(i, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U(NavBackStackEntry navBackStackEntry, boolean z, ArrayDeque arrayDeque) {
        f fVar;
        h1 c;
        Set set;
        NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) v().last();
        if (!Intrinsics.c(navBackStackEntry2, navBackStackEntry)) {
            throw new IllegalStateException(("Attempted to pop " + navBackStackEntry.f() + ", which is not the top of the back stack (" + navBackStackEntry2.f() + ')').toString());
        }
        v().removeLast();
        NavControllerNavigatorState navControllerNavigatorState = (NavControllerNavigatorState) this.x.get(F().d(navBackStackEntry2.f().o()));
        boolean z2 = true;
        if ((navControllerNavigatorState == null || (c = navControllerNavigatorState.c()) == null || (set = (Set) c.getValue()) == null || !set.contains(navBackStackEntry2)) && !this.l.containsKey(navBackStackEntry2)) {
            z2 = false;
        }
        Lifecycle.State b = navBackStackEntry2.getLifecycle().b();
        Lifecycle.State state = Lifecycle.State.CREATED;
        if (b.isAtLeast(state)) {
            if (z) {
                navBackStackEntry2.l(state);
                arrayDeque.addFirst(new NavBackStackEntryState(navBackStackEntry2));
            }
            if (z2) {
                navBackStackEntry2.l(state);
            } else {
                navBackStackEntry2.l(Lifecycle.State.DESTROYED);
                g0(navBackStackEntry2);
            }
        }
        if (z || z2 || (fVar = this.q) == null) {
            return;
        }
        fVar.c(navBackStackEntry2.g());
    }

    static /* synthetic */ void V(NavController navController, NavBackStackEntry navBackStackEntry, boolean z, ArrayDeque arrayDeque, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popEntryFromBackStack");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            arrayDeque = new ArrayDeque();
        }
        navController.U(navBackStackEntry, z, arrayDeque);
    }

    private final boolean Y(int i, Bundle bundle, l lVar, Navigator.a aVar) {
        NavBackStackEntry navBackStackEntry;
        NavDestination f;
        if (!this.m.containsKey(Integer.valueOf(i))) {
            return false;
        }
        String str = (String) this.m.get(Integer.valueOf(i));
        CollectionsKt.G(this.m.values(), new restoreStateInternal.1(str));
        List H2 = H((ArrayDeque) this.n.remove(str));
        ArrayList<List> arrayList = new ArrayList();
        ArrayList<NavBackStackEntry> arrayList2 = new ArrayList();
        for (Object obj : H2) {
            if (!(((NavBackStackEntry) obj).f() instanceof NavGraph)) {
                arrayList2.add(obj);
            }
        }
        for (NavBackStackEntry navBackStackEntry2 : arrayList2) {
            List list = (List) CollectionsKt.v0(arrayList);
            String str2 = null;
            if (list != null && (navBackStackEntry = (NavBackStackEntry) CollectionsKt.u0(list)) != null && (f = navBackStackEntry.f()) != null) {
                str2 = f.o();
            }
            if (Intrinsics.c(str2, navBackStackEntry2.f().o())) {
                list.add(navBackStackEntry2);
            } else {
                arrayList.add(CollectionsKt.q(new NavBackStackEntry[]{navBackStackEntry2}));
            }
        }
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        for (List list2 : arrayList) {
            L(this.w.d(((NavBackStackEntry) CollectionsKt.i0(list2)).f().o()), list2, lVar, aVar, new restoreStateInternal.4(ref$BooleanRef, H2, new Ref.IntRef(), this, bundle));
        }
        return ref$BooleanRef.element;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000b, code lost:
    
        if (B() > 1) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void i0() {
        /*
            r3 = this;
            androidx.activity.u r0 = r3.u
            boolean r1 = r3.v
            if (r1 == 0) goto Le
            int r1 = r3.B()
            r2 = 1
            if (r1 <= r2) goto Le
            goto Lf
        Le:
            r2 = 0
        Lf:
            r0.setEnabled(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.i0():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(NavDestination navDestination, Bundle bundle, NavBackStackEntry navBackStackEntry, List list) {
        Bundle bundle2;
        NavBackStackEntry navBackStackEntry2;
        ArrayDeque<NavBackStackEntry> arrayDeque;
        NavDestination navDestination2;
        List list2;
        Object obj;
        NavGraph navGraph;
        Object obj2;
        List list3 = list;
        NavDestination f = navBackStackEntry.f();
        if (!(f instanceof b)) {
            while (!v().isEmpty() && (((NavBackStackEntry) v().last()).f() instanceof b) && T(this, ((NavBackStackEntry) v().last()).f().n(), true, false, 4, null)) {
            }
        }
        ArrayDeque arrayDeque2 = new ArrayDeque();
        Object obj3 = null;
        if (navDestination instanceof NavGraph) {
            NavDestination navDestination3 = f;
            while (true) {
                Intrinsics.e(navDestination3);
                NavGraph p = navDestination3.p();
                if (p != null) {
                    ListIterator listIterator = list3.listIterator(list.size());
                    while (true) {
                        if (listIterator.hasPrevious()) {
                            obj2 = listIterator.previous();
                            if (Intrinsics.c(((NavBackStackEntry) obj2).f(), p)) {
                                break;
                            }
                        } else {
                            obj2 = null;
                            break;
                        }
                    }
                    NavBackStackEntry navBackStackEntry3 = (NavBackStackEntry) obj2;
                    if (navBackStackEntry3 == null) {
                        navDestination2 = f;
                        navBackStackEntry3 = NavBackStackEntry.a.b(NavBackStackEntry.n, this.a, p, bundle, D(), this.q, (String) null, (Bundle) null, 96, (Object) null);
                    } else {
                        navDestination2 = f;
                    }
                    arrayDeque2.addFirst(navBackStackEntry3);
                    if (v().isEmpty() || ((NavBackStackEntry) v().last()).f() != p) {
                        bundle2 = bundle;
                        navBackStackEntry2 = navBackStackEntry;
                        list2 = list;
                        navGraph = p;
                        arrayDeque = arrayDeque2;
                    } else {
                        bundle2 = bundle;
                        navBackStackEntry2 = navBackStackEntry;
                        list2 = list;
                        navGraph = p;
                        arrayDeque = arrayDeque2;
                        V(this, (NavBackStackEntry) v().last(), false, null, 6, null);
                    }
                } else {
                    bundle2 = bundle;
                    navBackStackEntry2 = navBackStackEntry;
                    navGraph = p;
                    arrayDeque = arrayDeque2;
                    navDestination2 = f;
                    list2 = list3;
                }
                if (navGraph == null || navGraph == navDestination) {
                    break;
                }
                arrayDeque2 = arrayDeque;
                list3 = list2;
                navDestination3 = navGraph;
                f = navDestination2;
            }
        } else {
            bundle2 = bundle;
            navBackStackEntry2 = navBackStackEntry;
            arrayDeque = arrayDeque2;
            navDestination2 = f;
            list2 = list3;
        }
        NavDestination f2 = arrayDeque.isEmpty() ? navDestination2 : ((NavBackStackEntry) arrayDeque.first()).f();
        while (f2 != null && s(f2.n()) == null) {
            f2 = f2.p();
            if (f2 != null) {
                ListIterator listIterator2 = list2.listIterator(list.size());
                while (true) {
                    if (listIterator2.hasPrevious()) {
                        obj = listIterator2.previous();
                        if (Intrinsics.c(((NavBackStackEntry) obj).f(), f2)) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                NavBackStackEntry navBackStackEntry4 = (NavBackStackEntry) obj;
                if (navBackStackEntry4 == null) {
                    navBackStackEntry4 = NavBackStackEntry.a.b(NavBackStackEntry.n, this.a, f2, f2.f(bundle2), D(), this.q, (String) null, (Bundle) null, 96, (Object) null);
                }
                arrayDeque.addFirst(navBackStackEntry4);
            }
        }
        NavDestination f3 = arrayDeque.isEmpty() ? navDestination2 : ((NavBackStackEntry) arrayDeque.last()).f();
        while (!v().isEmpty() && (((NavBackStackEntry) v().last()).f() instanceof NavGraph) && ((NavGraph) ((NavBackStackEntry) v().last()).f()).B(f3.n(), false) == null) {
            V(this, (NavBackStackEntry) v().last(), false, null, 6, null);
        }
        NavBackStackEntry navBackStackEntry5 = (NavBackStackEntry) v().i();
        if (navBackStackEntry5 == null) {
            navBackStackEntry5 = (NavBackStackEntry) arrayDeque.i();
        }
        if (!Intrinsics.c(navBackStackEntry5 == null ? null : navBackStackEntry5.f(), this.d)) {
            ListIterator listIterator3 = list2.listIterator(list.size());
            while (true) {
                if (!listIterator3.hasPrevious()) {
                    break;
                }
                Object previous = listIterator3.previous();
                NavDestination f4 = ((NavBackStackEntry) previous).f();
                NavGraph navGraph2 = this.d;
                Intrinsics.e(navGraph2);
                if (Intrinsics.c(f4, navGraph2)) {
                    obj3 = previous;
                    break;
                }
            }
            NavBackStackEntry navBackStackEntry6 = (NavBackStackEntry) obj3;
            if (navBackStackEntry6 == null) {
                NavBackStackEntry.a aVar = NavBackStackEntry.n;
                Context context = this.a;
                NavGraph navGraph3 = this.d;
                Intrinsics.e(navGraph3);
                NavGraph navGraph4 = this.d;
                Intrinsics.e(navGraph4);
                navBackStackEntry6 = NavBackStackEntry.a.b(aVar, context, navGraph3, navGraph4.f(bundle2), D(), this.q, (String) null, (Bundle) null, 96, (Object) null);
            }
            arrayDeque.addFirst(navBackStackEntry6);
        }
        for (NavBackStackEntry navBackStackEntry7 : arrayDeque) {
            Object obj4 = this.x.get(this.w.d(navBackStackEntry7.f().o()));
            if (obj4 == null) {
                throw new IllegalStateException(("NavigatorBackStack for " + navDestination.o() + " should already be created").toString());
            }
            ((NavControllerNavigatorState) obj4).k(navBackStackEntry7);
        }
        v().addAll(arrayDeque);
        v().add(navBackStackEntry2);
        for (NavBackStackEntry navBackStackEntry8 : CollectionsKt.C0(arrayDeque, navBackStackEntry2)) {
            NavGraph p2 = navBackStackEntry8.f().p();
            if (p2 != null) {
                J(navBackStackEntry8, w(p2.n()));
            }
        }
    }

    static /* synthetic */ void o(NavController navController, NavDestination navDestination, Bundle bundle, NavBackStackEntry navBackStackEntry, List list, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addEntryToBackStack");
        }
        if ((i & 8) != 0) {
            list = CollectionsKt.l();
        }
        navController.n(navDestination, bundle, navBackStackEntry, list);
    }

    private final boolean p(int i) {
        Iterator it = this.x.values().iterator();
        while (it.hasNext()) {
            ((NavControllerNavigatorState) it.next()).i(true);
        }
        boolean Y = Y(i, null, null, null);
        Iterator it2 = this.x.values().iterator();
        while (it2.hasNext()) {
            ((NavControllerNavigatorState) it2.next()).i(false);
        }
        return Y && S(i, true, false);
    }

    private final boolean q() {
        while (!v().isEmpty() && (((NavBackStackEntry) v().last()).f() instanceof NavGraph)) {
            V(this, (NavBackStackEntry) v().last(), false, null, 6, null);
        }
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) v().l();
        if (navBackStackEntry != null) {
            this.C.add(navBackStackEntry);
        }
        this.B++;
        h0();
        int i = this.B - 1;
        this.B = i;
        if (i == 0) {
            List<NavBackStackEntry> U0 = CollectionsKt.U0(this.C);
            this.C.clear();
            for (NavBackStackEntry navBackStackEntry2 : U0) {
                Iterator it = this.r.iterator();
                if (it.hasNext()) {
                    android.support.v4.media.session.c.a(it.next());
                    navBackStackEntry2.f();
                    navBackStackEntry2.d();
                    throw null;
                }
                this.E.b(navBackStackEntry2);
            }
            this.i.b(W());
        }
        return navBackStackEntry != null;
    }

    private final NavDestination t(NavDestination navDestination, int i) {
        NavGraph p;
        if (navDestination.n() == i) {
            return navDestination;
        }
        if (navDestination instanceof NavGraph) {
            p = (NavGraph) navDestination;
        } else {
            p = navDestination.p();
            Intrinsics.e(p);
        }
        return p.A(i);
    }

    private final String u(int[] iArr) {
        NavGraph navGraph = this.d;
        int length = iArr.length;
        int i = 0;
        while (true) {
            NavDestination navDestination = null;
            if (i >= length) {
                return null;
            }
            int i2 = i + 1;
            int i3 = iArr[i];
            if (i == 0) {
                NavGraph navGraph2 = this.d;
                Intrinsics.e(navGraph2);
                if (navGraph2.n() == i3) {
                    navDestination = this.d;
                }
            } else {
                Intrinsics.e(navGraph);
                navDestination = navGraph.A(i3);
            }
            if (navDestination == null) {
                return NavDestination.j.b(this.a, i3);
            }
            if (i != iArr.length - 1 && (navDestination instanceof NavGraph)) {
                navGraph = (NavGraph) navDestination;
                while (true) {
                    Intrinsics.e(navGraph);
                    if (navGraph.A(navGraph.G()) instanceof NavGraph) {
                        navGraph = (NavGraph) navGraph.A(navGraph.G());
                    }
                }
            }
            i = i2;
        }
    }

    public NavDestination A() {
        NavBackStackEntry z = z();
        if (z == null) {
            return null;
        }
        return z.f();
    }

    public NavGraph C() {
        NavGraph navGraph = this.d;
        if (navGraph == null) {
            throw new IllegalStateException("You must call setGraph() before calling getGraph()");
        }
        if (navGraph != null) {
            return navGraph;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.navigation.NavGraph");
    }

    public final Lifecycle.State D() {
        return this.o == null ? Lifecycle.State.CREATED : this.s;
    }

    public k E() {
        return (k) this.D.getValue();
    }

    public q F() {
        return this.w;
    }

    public boolean G(Intent intent) {
        int[] iArr;
        NavDestination A;
        Bundle bundle;
        int i = 0;
        if (intent == null) {
            return false;
        }
        Bundle extras = intent.getExtras();
        int[] intArray = extras == null ? null : extras.getIntArray("android-support-nav:controller:deepLinkIds");
        ArrayList parcelableArrayList = extras == null ? null : extras.getParcelableArrayList("android-support-nav:controller:deepLinkArgs");
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = extras == null ? null : extras.getBundle("android-support-nav:controller:deepLinkExtras");
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        if (intArray == null || intArray.length == 0) {
            NavGraph navGraph = this.d;
            Intrinsics.e(navGraph);
            NavDestination.a r = navGraph.r(new g(intent));
            if (r != null) {
                NavDestination b = r.b();
                int[] j = NavDestination.j(b, null, 1, null);
                Bundle f = b.f(r.d());
                if (f != null) {
                    bundle2.putAll(f);
                }
                iArr = j;
                parcelableArrayList = null;
                if (iArr != null || iArr.length == 0) {
                    return false;
                }
                String u = u(iArr);
                if (u != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Could not find destination ");
                    sb.append((Object) u);
                    sb.append(" in the navigation graph, ignoring the deep link from ");
                    sb.append(intent);
                    return false;
                }
                bundle2.putParcelable("android-support-nav:controller:deepLinkIntent", intent);
                int length = iArr.length;
                Bundle[] bundleArr = new Bundle[length];
                int i2 = 0;
                while (i2 < length) {
                    int i3 = i2 + 1;
                    Bundle bundle4 = new Bundle();
                    bundle4.putAll(bundle2);
                    if (parcelableArrayList != null && (bundle = (Bundle) parcelableArrayList.get(i2)) != null) {
                        bundle4.putAll(bundle);
                    }
                    bundleArr[i2] = bundle4;
                    i2 = i3;
                }
                int flags = intent.getFlags();
                int i4 = 268435456 & flags;
                if (i4 != 0 && (flags & ASTNode.BLOCK_WHILE) == 0) {
                    intent.addFlags(ASTNode.BLOCK_WHILE);
                    b0 b2 = b0.f(this.a).b(intent);
                    Intrinsics.g(b2, "create(context)\n        …ntWithParentStack(intent)");
                    b2.g();
                    Activity activity = this.b;
                    if (activity != null) {
                        activity.finish();
                        activity.overridePendingTransition(0, 0);
                    }
                    return true;
                }
                if (i4 != 0) {
                    if (!v().isEmpty()) {
                        NavGraph navGraph2 = this.d;
                        Intrinsics.e(navGraph2);
                        T(this, navGraph2.n(), true, false, 4, null);
                    }
                    while (i < iArr.length) {
                        int i6 = iArr[i];
                        int i7 = i + 1;
                        Bundle bundle5 = bundleArr[i];
                        NavDestination s = s(i6);
                        if (s == null) {
                            throw new IllegalStateException("Deep Linking failed: destination " + NavDestination.j.b(this.a, i6) + " cannot be found from the current destination " + A());
                        }
                        K(s, bundle5, n.a(new handleDeepLink.2(s, this)), null);
                        i = i7;
                    }
                    return true;
                }
                NavGraph navGraph3 = this.d;
                int length2 = iArr.length;
                int i8 = 0;
                while (i8 < length2) {
                    int i9 = i8 + 1;
                    int i10 = iArr[i8];
                    Bundle bundle6 = bundleArr[i8];
                    if (i8 == 0) {
                        A = this.d;
                    } else {
                        Intrinsics.e(navGraph3);
                        A = navGraph3.A(i10);
                    }
                    if (A == null) {
                        throw new IllegalStateException("Deep Linking failed: destination " + NavDestination.j.b(this.a, i10) + " cannot be found in graph " + navGraph3);
                    }
                    if (i8 == iArr.length - 1) {
                        l.a aVar = new l.a();
                        NavGraph navGraph4 = this.d;
                        Intrinsics.e(navGraph4);
                        K(A, bundle6, l.a.i(aVar, navGraph4.n(), true, false, 4, (Object) null).b(0).c(0).a(), null);
                    } else if (A instanceof NavGraph) {
                        navGraph3 = (NavGraph) A;
                        while (true) {
                            Intrinsics.e(navGraph3);
                            if (navGraph3.A(navGraph3.G()) instanceof NavGraph) {
                                navGraph3 = (NavGraph) navGraph3.A(navGraph3.G());
                            }
                        }
                    }
                    i8 = i9;
                }
                this.g = true;
                return true;
            }
        }
        iArr = intArray;
        if (iArr != null) {
        }
        return false;
    }

    public boolean N() {
        if (v().isEmpty()) {
            return false;
        }
        NavDestination A = A();
        Intrinsics.e(A);
        return O(A.n(), true);
    }

    public boolean O(int i, boolean z) {
        return P(i, z, false);
    }

    public boolean P(int i, boolean z, boolean z2) {
        return S(i, z, z2) && q();
    }

    public final void Q(NavBackStackEntry navBackStackEntry, Function0 function0) {
        Intrinsics.h(navBackStackEntry, "popUpTo");
        Intrinsics.h(function0, "onComplete");
        int indexOf = v().indexOf(navBackStackEntry);
        if (indexOf < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Ignoring pop of ");
            sb.append(navBackStackEntry);
            sb.append(" as it was not found on the current back stack");
            return;
        }
        int i = indexOf + 1;
        if (i != v().size()) {
            S(((NavBackStackEntry) v().get(i)).f().n(), true, false);
        }
        V(this, navBackStackEntry, false, null, 6, null);
        function0.invoke();
        i0();
        q();
    }

    public final List W() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.x.values().iterator();
        while (it.hasNext()) {
            Iterable iterable = (Iterable) ((NavControllerNavigatorState) it.next()).c().getValue();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : iterable) {
                NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
                if (!arrayList.contains(navBackStackEntry) && !navBackStackEntry.getLifecycle().b().isAtLeast(Lifecycle.State.STARTED)) {
                    arrayList2.add(obj);
                }
            }
            CollectionsKt.B(arrayList, arrayList2);
        }
        ArrayDeque v = v();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : v) {
            NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) obj2;
            if (!arrayList.contains(navBackStackEntry2) && navBackStackEntry2.getLifecycle().b().isAtLeast(Lifecycle.State.STARTED)) {
                arrayList3.add(obj2);
            }
        }
        CollectionsKt.B(arrayList, arrayList3);
        ArrayList arrayList4 = new ArrayList();
        for (Object obj3 : arrayList) {
            if (!(((NavBackStackEntry) obj3).f() instanceof NavGraph)) {
                arrayList4.add(obj3);
            }
        }
        return arrayList4;
    }

    public void X(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(this.a.getClassLoader());
        this.e = bundle.getBundle("android-support-nav:controller:navigatorState");
        this.f = bundle.getParcelableArray("android-support-nav:controller:backStack");
        this.n.clear();
        int[] intArray = bundle.getIntArray("android-support-nav:controller:backStackDestIds");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("android-support-nav:controller:backStackIds");
        if (intArray != null && stringArrayList != null) {
            int length = intArray.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                int i3 = intArray[i];
                i++;
                this.m.put(Integer.valueOf(i3), stringArrayList.get(i2));
                i2++;
            }
        }
        ArrayList<String> stringArrayList2 = bundle.getStringArrayList("android-support-nav:controller:backStackStates");
        if (stringArrayList2 != null) {
            for (String str : stringArrayList2) {
                Parcelable[] parcelableArray = bundle.getParcelableArray(Intrinsics.q("android-support-nav:controller:backStackStates:", str));
                if (parcelableArray != null) {
                    Map map = this.n;
                    Intrinsics.g(str, "id");
                    ArrayDeque arrayDeque = new ArrayDeque(parcelableArray.length);
                    Iterator a = ArrayIteratorKt.a(parcelableArray);
                    while (a.hasNext()) {
                        NavBackStackEntryState navBackStackEntryState = (Parcelable) a.next();
                        if (navBackStackEntryState == null) {
                            throw new NullPointerException("null cannot be cast to non-null type androidx.navigation.NavBackStackEntryState");
                        }
                        arrayDeque.add(navBackStackEntryState);
                    }
                    Unit unit = Unit.a;
                    map.put(str, arrayDeque);
                }
            }
        }
        this.g = bundle.getBoolean("android-support-nav:controller:deepLinkHandled");
    }

    public Bundle Z() {
        Bundle bundle;
        ArrayList<String> arrayList = new ArrayList<>();
        Bundle bundle2 = new Bundle();
        for (Map.Entry entry : this.w.e().entrySet()) {
            String str = (String) entry.getKey();
            Bundle i = ((Navigator) entry.getValue()).i();
            if (i != null) {
                arrayList.add(str);
                bundle2.putBundle(str, i);
            }
        }
        if (arrayList.isEmpty()) {
            bundle = null;
        } else {
            bundle = new Bundle();
            bundle2.putStringArrayList("android-support-nav:controller:navigatorState:names", arrayList);
            bundle.putBundle("android-support-nav:controller:navigatorState", bundle2);
        }
        if (!v().isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            Parcelable[] parcelableArr = new Parcelable[v().size()];
            Iterator it = v().iterator();
            int i2 = 0;
            while (it.hasNext()) {
                parcelableArr[i2] = new NavBackStackEntryState((NavBackStackEntry) it.next());
                i2++;
            }
            bundle.putParcelableArray("android-support-nav:controller:backStack", parcelableArr);
        }
        if (!this.m.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            int[] iArr = new int[this.m.size()];
            ArrayList<String> arrayList2 = new ArrayList<>();
            int i3 = 0;
            for (Map.Entry entry2 : this.m.entrySet()) {
                int intValue = ((Number) entry2.getKey()).intValue();
                String str2 = (String) entry2.getValue();
                iArr[i3] = intValue;
                arrayList2.add(str2);
                i3++;
            }
            bundle.putIntArray("android-support-nav:controller:backStackDestIds", iArr);
            bundle.putStringArrayList("android-support-nav:controller:backStackIds", arrayList2);
        }
        if (!this.n.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            ArrayList<String> arrayList3 = new ArrayList<>();
            for (Map.Entry entry3 : this.n.entrySet()) {
                String str3 = (String) entry3.getKey();
                ArrayDeque arrayDeque = (ArrayDeque) entry3.getValue();
                arrayList3.add(str3);
                Parcelable[] parcelableArr2 = new Parcelable[arrayDeque.size()];
                int i4 = 0;
                for (Object obj : arrayDeque) {
                    int i6 = i4 + 1;
                    if (i4 < 0) {
                        CollectionsKt.u();
                    }
                    parcelableArr2[i4] = (NavBackStackEntryState) obj;
                    i4 = i6;
                }
                bundle.putParcelableArray(Intrinsics.q("android-support-nav:controller:backStackStates:", str3), parcelableArr2);
            }
            bundle.putStringArrayList("android-support-nav:controller:backStackStates", arrayList3);
        }
        if (this.g) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android-support-nav:controller:deepLinkHandled", this.g);
        }
        return bundle;
    }

    public void a0(int i) {
        c0(E().b(i), null);
    }

    public void b0(int i, Bundle bundle) {
        c0(E().b(i), bundle);
    }

    public void c0(NavGraph navGraph, Bundle bundle) {
        Intrinsics.h(navGraph, "graph");
        if (!Intrinsics.c(this.d, navGraph)) {
            NavGraph navGraph2 = this.d;
            if (navGraph2 != null) {
                for (Integer num : new ArrayList(this.m.keySet())) {
                    Intrinsics.g(num, "id");
                    p(num.intValue());
                }
                T(this, navGraph2.n(), true, false, 4, null);
            }
            this.d = navGraph;
            M(bundle);
            return;
        }
        int p = navGraph.E().p();
        int i = 0;
        while (i < p) {
            int i2 = i + 1;
            NavDestination navDestination = (NavDestination) navGraph.E().q(i);
            NavGraph navGraph3 = this.d;
            Intrinsics.e(navGraph3);
            navGraph3.E().o(i, navDestination);
            ArrayDeque v = v();
            ArrayList<NavBackStackEntry> arrayList = new ArrayList();
            for (Object obj : v) {
                int n = ((NavBackStackEntry) obj).f().n();
                if (navDestination != null && n == navDestination.n()) {
                    arrayList.add(obj);
                }
            }
            for (NavBackStackEntry navBackStackEntry : arrayList) {
                Intrinsics.g(navDestination, "newDestination");
                navBackStackEntry.k(navDestination);
            }
            i = i2;
        }
    }

    public void d0(u uVar) {
        Lifecycle lifecycle;
        Intrinsics.h(uVar, "owner");
        if (Intrinsics.c(uVar, this.o)) {
            return;
        }
        u uVar2 = this.o;
        if (uVar2 != null && (lifecycle = uVar2.getLifecycle()) != null) {
            lifecycle.d(this.t);
        }
        this.o = uVar;
        uVar.getLifecycle().a(this.t);
    }

    public void e0(OnBackPressedDispatcher onBackPressedDispatcher) {
        Intrinsics.h(onBackPressedDispatcher, "dispatcher");
        if (Intrinsics.c(onBackPressedDispatcher, this.p)) {
            return;
        }
        u uVar = this.o;
        if (uVar == null) {
            throw new IllegalStateException("You must call setLifecycleOwner() before calling setOnBackPressedDispatcher()");
        }
        this.u.remove();
        this.p = onBackPressedDispatcher;
        onBackPressedDispatcher.i(uVar, this.u);
        Lifecycle lifecycle = uVar.getLifecycle();
        lifecycle.d(this.t);
        lifecycle.a(this.t);
    }

    public void f0(androidx.lifecycle.x0 x0Var) {
        Intrinsics.h(x0Var, "viewModelStore");
        f fVar = this.q;
        f.b bVar = f.b;
        if (Intrinsics.c(fVar, bVar.a(x0Var))) {
            return;
        }
        if (!v().isEmpty()) {
            throw new IllegalStateException("ViewModelStore should be set before setGraph call");
        }
        this.q = bVar.a(x0Var);
    }

    public final NavBackStackEntry g0(NavBackStackEntry navBackStackEntry) {
        Intrinsics.h(navBackStackEntry, "child");
        NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) this.k.remove(navBackStackEntry);
        if (navBackStackEntry2 == null) {
            return null;
        }
        AtomicInteger atomicInteger = (AtomicInteger) this.l.get(navBackStackEntry2);
        Integer valueOf = atomicInteger != null ? Integer.valueOf(atomicInteger.decrementAndGet()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            NavControllerNavigatorState navControllerNavigatorState = (NavControllerNavigatorState) this.x.get(this.w.d(navBackStackEntry2.f().o()));
            if (navControllerNavigatorState != null) {
                navControllerNavigatorState.e(navBackStackEntry2);
            }
            this.l.remove(navBackStackEntry2);
        }
        return navBackStackEntry2;
    }

    public final void h0() {
        NavDestination navDestination;
        h1 c;
        Set set;
        AtomicInteger atomicInteger;
        List<NavBackStackEntry> U0 = CollectionsKt.U0(v());
        if (U0.isEmpty()) {
            return;
        }
        NavDestination f = ((NavBackStackEntry) CollectionsKt.u0(U0)).f();
        if (f instanceof b) {
            Iterator it = CollectionsKt.D0(U0).iterator();
            while (it.hasNext()) {
                navDestination = ((NavBackStackEntry) it.next()).f();
                if (!(navDestination instanceof NavGraph) && !(navDestination instanceof b)) {
                    break;
                }
            }
        }
        navDestination = null;
        HashMap hashMap = new HashMap();
        for (NavBackStackEntry navBackStackEntry : CollectionsKt.D0(U0)) {
            Lifecycle.State h = navBackStackEntry.h();
            NavDestination f2 = navBackStackEntry.f();
            if (f != null && f2.n() == f.n()) {
                Lifecycle.State state = Lifecycle.State.RESUMED;
                if (h != state) {
                    NavControllerNavigatorState navControllerNavigatorState = (NavControllerNavigatorState) this.x.get(F().d(navBackStackEntry.f().o()));
                    if (Intrinsics.c((navControllerNavigatorState == null || (c = navControllerNavigatorState.c()) == null || (set = (Set) c.getValue()) == null) ? null : Boolean.valueOf(set.contains(navBackStackEntry)), Boolean.TRUE) || ((atomicInteger = (AtomicInteger) this.l.get(navBackStackEntry)) != null && atomicInteger.get() == 0)) {
                        hashMap.put(navBackStackEntry, Lifecycle.State.STARTED);
                    } else {
                        hashMap.put(navBackStackEntry, state);
                    }
                }
                f = f.p();
            } else if (navDestination == null || f2.n() != navDestination.n()) {
                navBackStackEntry.l(Lifecycle.State.CREATED);
            } else {
                if (h == Lifecycle.State.RESUMED) {
                    navBackStackEntry.l(Lifecycle.State.STARTED);
                } else {
                    Lifecycle.State state2 = Lifecycle.State.STARTED;
                    if (h != state2) {
                        hashMap.put(navBackStackEntry, state2);
                    }
                }
                navDestination = navDestination.p();
            }
        }
        for (NavBackStackEntry navBackStackEntry2 : U0) {
            Lifecycle.State state3 = (Lifecycle.State) hashMap.get(navBackStackEntry2);
            if (state3 != null) {
                navBackStackEntry2.l(state3);
            } else {
                navBackStackEntry2.m();
            }
        }
    }

    public void r(boolean z) {
        this.v = z;
        i0();
    }

    public final NavDestination s(int i) {
        NavGraph navGraph = this.d;
        if (navGraph == null) {
            return null;
        }
        Intrinsics.e(navGraph);
        if (navGraph.n() == i) {
            return this.d;
        }
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) v().l();
        NavDestination f = navBackStackEntry != null ? navBackStackEntry.f() : null;
        if (f == null) {
            f = this.d;
            Intrinsics.e(f);
        }
        return t(f, i);
    }

    public ArrayDeque v() {
        return this.h;
    }

    public NavBackStackEntry w(int i) {
        Object obj;
        ArrayDeque v = v();
        ListIterator listIterator = v.listIterator(v.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                obj = null;
                break;
            }
            obj = listIterator.previous();
            if (((NavBackStackEntry) obj).f().n() == i) {
                break;
            }
        }
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
        if (navBackStackEntry != null) {
            return navBackStackEntry;
        }
        throw new IllegalArgumentException(("No destination with ID " + i + " is on the NavController's back stack. The current destination is " + A()).toString());
    }

    public final NavBackStackEntry x(String str) {
        Object obj;
        Intrinsics.h(str, "route");
        ArrayDeque v = v();
        ListIterator listIterator = v.listIterator(v.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                obj = null;
                break;
            }
            obj = listIterator.previous();
            if (Intrinsics.c(((NavBackStackEntry) obj).f().q(), str)) {
                break;
            }
        }
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
        if (navBackStackEntry != null) {
            return navBackStackEntry;
        }
        throw new IllegalArgumentException(("No destination with route " + str + " is on the NavController's back stack. The current destination is " + A()).toString());
    }

    public final Context y() {
        return this.a;
    }

    public NavBackStackEntry z() {
        return (NavBackStackEntry) v().l();
    }
}
