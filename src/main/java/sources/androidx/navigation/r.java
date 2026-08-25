package androidx.navigation;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.h1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.x0;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class r {

    /* renamed from: a, reason: collision with root package name */
    private final ReentrantLock f12567a = new ReentrantLock(true);

    /* renamed from: b, reason: collision with root package name */
    private final x0 f12568b;

    /* renamed from: c, reason: collision with root package name */
    private final x0 f12569c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f12570d;

    /* renamed from: e, reason: collision with root package name */
    private final h1 f12571e;

    /* renamed from: f, reason: collision with root package name */
    private final h1 f12572f;

    public r() {
        x0 a5 = i1.a(CollectionsKt.l());
        this.f12568b = a5;
        x0 a6 = i1.a(SetsKt.f());
        this.f12569c = a6;
        this.f12571e = kotlinx.coroutines.flow.c.b(a5);
        this.f12572f = kotlinx.coroutines.flow.c.b(a6);
    }

    public abstract NavBackStackEntry a(NavDestination navDestination, Bundle bundle);

    public final h1 b() {
        return this.f12571e;
    }

    public final h1 c() {
        return this.f12572f;
    }

    public final boolean d() {
        return this.f12570d;
    }

    public void e(NavBackStackEntry navBackStackEntry) {
        Intrinsics.h(navBackStackEntry, "entry");
        x0 x0Var = this.f12569c;
        x0Var.setValue(SetsKt.k((Set) x0Var.getValue(), navBackStackEntry));
    }

    public void f(NavBackStackEntry navBackStackEntry) {
        Intrinsics.h(navBackStackEntry, "backStackEntry");
        x0 x0Var = this.f12568b;
        x0Var.setValue(CollectionsKt.C0(CollectionsKt.z0((Iterable) x0Var.getValue(), CollectionsKt.u0((List) this.f12568b.getValue())), navBackStackEntry));
    }

    public void g(NavBackStackEntry navBackStackEntry, boolean z5) {
        Intrinsics.h(navBackStackEntry, "popUpTo");
        ReentrantLock reentrantLock = this.f12567a;
        reentrantLock.lock();
        try {
            x0 x0Var = this.f12568b;
            Iterable iterable = (Iterable) x0Var.getValue();
            ArrayList arrayList = new ArrayList();
            for (Object obj : iterable) {
                if (Intrinsics.c((NavBackStackEntry) obj, navBackStackEntry)) {
                    break;
                } else {
                    arrayList.add(obj);
                }
            }
            x0Var.setValue(arrayList);
            Unit unit = Unit.a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public void h(NavBackStackEntry navBackStackEntry) {
        Intrinsics.h(navBackStackEntry, "backStackEntry");
        ReentrantLock reentrantLock = this.f12567a;
        reentrantLock.lock();
        try {
            x0 x0Var = this.f12568b;
            x0Var.setValue(CollectionsKt.C0((Collection) x0Var.getValue(), navBackStackEntry));
            Unit unit = Unit.a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void i(boolean z5) {
        this.f12570d = z5;
    }
}
