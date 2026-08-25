package androidx.navigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.collection.a1;
import androidx.collection.y0;
import androidx.navigation.NavDestination;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class NavGraph extends NavDestination implements Iterable, KMappedMarker {
    public static final Companion p = new Companion(null);
    private final y0 l;
    private int m;
    private String n;
    private String o;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final NavDestination a(NavGraph navGraph) {
            Intrinsics.h(navGraph, "<this>");
            return (NavDestination) SequencesKt.x(SequencesKt.h(navGraph.A(navGraph.G()), findStartDestination.1.INSTANCE));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavGraph(Navigator navigator) {
        super(navigator);
        Intrinsics.h(navigator, "navGraphNavigator");
        this.l = new y0();
    }

    private final void I(int i) {
        if (i != n()) {
            if (this.o != null) {
                J(null);
            }
            this.m = i;
            this.n = null;
            return;
        }
        throw new IllegalArgumentException(("Start destination " + i + " cannot use the same id as the graph " + this).toString());
    }

    private final void J(String str) {
        int hashCode;
        if (str == null) {
            hashCode = 0;
        } else {
            if (Intrinsics.c(str, q())) {
                throw new IllegalArgumentException(("Start destination " + ((Object) str) + " cannot use the same route as the graph " + this).toString());
            }
            if (StringsKt.q0(str)) {
                throw new IllegalArgumentException("Cannot have an empty start destination route");
            }
            hashCode = NavDestination.j.a(str).hashCode();
        }
        this.m = hashCode;
        this.o = str;
    }

    public final NavDestination A(int i) {
        return B(i, true);
    }

    public final NavDestination B(int i, boolean z) {
        NavDestination navDestination = (NavDestination) this.l.g(i);
        if (navDestination != null) {
            return navDestination;
        }
        if (!z || p() == null) {
            return null;
        }
        NavGraph p2 = p();
        Intrinsics.e(p2);
        return p2.A(i);
    }

    public final NavDestination C(String str) {
        if (str == null || StringsKt.q0(str)) {
            return null;
        }
        return D(str, true);
    }

    public final NavDestination D(String str, boolean z) {
        Intrinsics.h(str, "route");
        NavDestination navDestination = (NavDestination) this.l.g(NavDestination.j.a(str).hashCode());
        if (navDestination != null) {
            return navDestination;
        }
        if (!z || p() == null) {
            return null;
        }
        NavGraph p2 = p();
        Intrinsics.e(p2);
        return p2.C(str);
    }

    public final y0 E() {
        return this.l;
    }

    public final String F() {
        if (this.n == null) {
            String str = this.o;
            if (str == null) {
                str = String.valueOf(this.m);
            }
            this.n = str;
        }
        String str2 = this.n;
        Intrinsics.e(str2);
        return str2;
    }

    public final int G() {
        return this.m;
    }

    public final String H() {
        return this.o;
    }

    @Override // androidx.navigation.NavDestination
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof NavGraph)) {
            return false;
        }
        List D = SequencesKt.D(SequencesKt.e(a1.a(this.l)));
        NavGraph navGraph = (NavGraph) obj;
        Iterator a = a1.a(navGraph.l);
        while (a.hasNext()) {
            D.remove((NavDestination) a.next());
        }
        return super.equals(obj) && this.l.p() == navGraph.l.p() && G() == navGraph.G() && D.isEmpty();
    }

    @Override // androidx.navigation.NavDestination
    public int hashCode() {
        int G = G();
        y0 y0Var = this.l;
        int p2 = y0Var.p();
        for (int i = 0; i < p2; i++) {
            G = (((G * 31) + y0Var.k(i)) * 31) + ((NavDestination) y0Var.q(i)).hashCode();
        }
        return G;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new a(this);
    }

    @Override // androidx.navigation.NavDestination
    public String m() {
        return n() != 0 ? super.m() : "the root navigation";
    }

    @Override // androidx.navigation.NavDestination
    public NavDestination.a r(g gVar) {
        Intrinsics.h(gVar, "navDeepLinkRequest");
        NavDestination.a r = super.r(gVar);
        ArrayList arrayList = new ArrayList();
        Iterator it = iterator();
        while (it.hasNext()) {
            NavDestination.a r2 = ((NavDestination) it.next()).r(gVar);
            if (r2 != null) {
                arrayList.add(r2);
            }
        }
        return CollectionsKt.w0(CollectionsKt.p(new NavDestination.a[]{r, CollectionsKt.w0(arrayList)}));
    }

    @Override // androidx.navigation.NavDestination
    public void s(Context context, AttributeSet attributeSet) {
        Intrinsics.h(context, "context");
        Intrinsics.h(attributeSet, "attrs");
        super.s(context, attributeSet);
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, androidx.navigation.common.R$styleable.NavGraphNavigator);
        Intrinsics.g(obtainAttributes, "context.resources.obtain…vGraphNavigator\n        )");
        I(obtainAttributes.getResourceId(androidx.navigation.common.R$styleable.NavGraphNavigator_startDestination, 0));
        this.n = NavDestination.j.b(context, this.m);
        Unit unit = Unit.a;
        obtainAttributes.recycle();
    }

    @Override // androidx.navigation.NavDestination
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        NavDestination C = C(this.o);
        if (C == null) {
            C = A(G());
        }
        sb.append(" startDestination=");
        if (C == null) {
            String str = this.o;
            if (str != null) {
                sb.append(str);
            } else {
                String str2 = this.n;
                if (str2 != null) {
                    sb.append(str2);
                } else {
                    sb.append(Intrinsics.q("0x", Integer.toHexString(this.m)));
                }
            }
        } else {
            sb.append("{");
            sb.append(C.toString());
            sb.append("}");
        }
        String sb2 = sb.toString();
        Intrinsics.g(sb2, "sb.toString()");
        return sb2;
    }

    public final void z(NavDestination navDestination) {
        Intrinsics.h(navDestination, "node");
        int n = navDestination.n();
        String q = navDestination.q();
        if (n == 0 && q == null) {
            throw new IllegalArgumentException("Destinations must have an id or route. Call setId(), setRoute(), or include an android:id or app:route in your navigation XML.");
        }
        if (q() != null && Intrinsics.c(q, q())) {
            throw new IllegalArgumentException(("Destination " + navDestination + " cannot have the same route as graph " + this).toString());
        }
        if (n == n()) {
            throw new IllegalArgumentException(("Destination " + navDestination + " cannot have the same id as graph " + this).toString());
        }
        NavDestination navDestination2 = (NavDestination) this.l.g(n);
        if (navDestination2 == navDestination) {
            return;
        }
        if (navDestination.p() != null) {
            throw new IllegalStateException("Destination already has a parent set. Call NavGraph.remove() to remove the previous parent.");
        }
        if (navDestination2 != null) {
            navDestination2.w(null);
        }
        navDestination.w(this);
        this.l.l(navDestination.n(), navDestination);
    }
}
