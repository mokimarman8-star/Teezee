package androidx.recyclerview.widget;

import android.database.Observable;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class RecyclerView$f extends Observable {
    RecyclerView$f() {
    }

    public boolean a() {
        return !((Observable) this).mObservers.isEmpty();
    }

    public void b() {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((RecyclerView$g) ((Observable) this).mObservers.get(size)).onChanged();
        }
    }

    public void c(int i5, int i6) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((RecyclerView$g) ((Observable) this).mObservers.get(size)).onItemRangeMoved(i5, i6, 1);
        }
    }

    public void d(int i5, int i6) {
        e(i5, i6, null);
    }

    public void e(int i5, int i6, Object obj) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((RecyclerView$g) ((Observable) this).mObservers.get(size)).onItemRangeChanged(i5, i6, obj);
        }
    }

    public void f(int i5, int i6) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((RecyclerView$g) ((Observable) this).mObservers.get(size)).onItemRangeInserted(i5, i6);
        }
    }

    public void g(int i5, int i6) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((RecyclerView$g) ((Observable) this).mObservers.get(size)).onItemRangeRemoved(i5, i6);
        }
    }

    public void h() {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((RecyclerView$g) ((Observable) this).mObservers.get(size)).onStateRestorationPolicyChanged();
        }
    }
}
