package androidx.navigation;

import androidx.collection.y0;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class NavGraph$a implements Iterator, KMutableIterator {

    /* renamed from: a, reason: collision with root package name */
    private int f12463a = -1;

    /* renamed from: b, reason: collision with root package name */
    private boolean f12464b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ NavGraph f12465c;

    NavGraph$a(NavGraph navGraph) {
        this.f12465c = navGraph;
    }

    @Override // java.util.Iterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public NavDestination next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f12464b = true;
        y0 E = this.f12465c.E();
        int i5 = this.f12463a + 1;
        this.f12463a = i5;
        Object q5 = E.q(i5);
        Intrinsics.g(q5, "nodes.valueAt(++index)");
        return (NavDestination) q5;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f12463a + 1 < this.f12465c.E().p();
    }

    @Override // java.util.Iterator
    public void remove() {
        if (!this.f12464b) {
            throw new IllegalStateException("You must call next() before you can remove an element");
        }
        y0 E = this.f12465c.E();
        ((NavDestination) E.q(this.f12463a)).w((NavGraph) null);
        E.n(this.f12463a);
        this.f12463a--;
        this.f12464b = false;
    }
}
