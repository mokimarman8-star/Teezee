package androidx.navigation;

import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J1\u0010\u0014\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00122\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Landroidx/navigation/h;", "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavGraph;", "Landroidx/navigation/q;", "navigatorProvider", "<init>", "(Landroidx/navigation/q;)V", "Landroidx/navigation/NavBackStackEntry;", "entry", "Landroidx/navigation/l;", "navOptions", "Landroidx/navigation/Navigator$a;", "navigatorExtras", "", "m", "(Landroidx/navigation/NavBackStackEntry;Landroidx/navigation/l;Landroidx/navigation/Navigator$a;)V", "l", "()Landroidx/navigation/NavGraph;", "", "entries", "e", "(Ljava/util/List;Landroidx/navigation/l;Landroidx/navigation/Navigator$a;)V", "c", "Landroidx/navigation/q;", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Navigator$b(NotificationCompat.CATEGORY_NAVIGATION)
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class h extends Navigator {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final q navigatorProvider;

    public h(q qVar) {
        Intrinsics.h(qVar, "navigatorProvider");
        this.navigatorProvider = qVar;
    }

    private final void m(NavBackStackEntry entry, l navOptions, Navigator$a navigatorExtras) {
        NavGraph f5 = entry.f();
        Bundle d5 = entry.d();
        int G = f5.G();
        String H = f5.H();
        if (G == 0 && H == null) {
            throw new IllegalStateException(Intrinsics.q("no start destination defined via app:startDestination for ", f5.m()).toString());
        }
        NavDestination D = H != null ? f5.D(H, false) : f5.B(G, false);
        if (D != null) {
            this.navigatorProvider.d(D.o()).e(CollectionsKt.e(b().a(D, D.f(d5))), navOptions, navigatorExtras);
            return;
        }
        throw new IllegalArgumentException("navigation destination " + f5.F() + " is not a direct child of this NavGraph");
    }

    public void e(List entries, l navOptions, Navigator$a navigatorExtras) {
        Intrinsics.h(entries, "entries");
        Iterator it = entries.iterator();
        while (it.hasNext()) {
            m((NavBackStackEntry) it.next(), navOptions, navigatorExtras);
        }
    }

    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public NavGraph a() {
        return new NavGraph(this);
    }
}
