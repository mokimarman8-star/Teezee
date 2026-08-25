package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.fragment.R$id;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
abstract class SpecialEffectsController {
    private final ViewGroup a;
    final ArrayList b = new ArrayList();
    final ArrayList c = new ArrayList();
    boolean d = false;
    boolean e = false;

    static class Operation {
        private State a;
        private LifecycleImpact b;
        private final Fragment c;
        private final List d = new ArrayList();
        private final HashSet e = new HashSet();
        private boolean f = false;
        private boolean g = false;

        enum LifecycleImpact {
            NONE,
            ADDING,
            REMOVING
        }

        enum State {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            @NonNull
            static State from(int i) {
                if (i == 0) {
                    return VISIBLE;
                }
                if (i == 4) {
                    return INVISIBLE;
                }
                if (i == 8) {
                    return GONE;
                }
                throw new IllegalArgumentException("Unknown visibility " + i);
            }

            @NonNull
            static State from(@NonNull View view) {
                return (view.getAlpha() == 0.0f && view.getVisibility() == 0) ? INVISIBLE : from(view.getVisibility());
            }

            void applyState(@NonNull View view) {
                int i = a.a[ordinal()];
                if (i == 1) {
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    if (viewGroup != null) {
                        if (FragmentManager.M0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                        }
                        viewGroup.removeView(view);
                        return;
                    }
                    return;
                }
                if (i == 2) {
                    if (FragmentManager.M0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                    }
                    view.setVisibility(0);
                    return;
                }
                if (i == 3) {
                    if (FragmentManager.M0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
                    }
                    view.setVisibility(8);
                    return;
                }
                if (i != 4) {
                    return;
                }
                if (FragmentManager.M0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                }
                view.setVisibility(4);
            }
        }

        Operation(State state, LifecycleImpact lifecycleImpact, Fragment fragment, androidx.core.os.e eVar) {
            this.a = state;
            this.b = lifecycleImpact;
            this.c = fragment;
            eVar.b(new a(this));
        }

        final void a(Runnable runnable) {
            this.d.add(runnable);
        }

        final void b() {
            if (h()) {
                return;
            }
            this.f = true;
            if (this.e.isEmpty()) {
                c();
                return;
            }
            Iterator it = new ArrayList(this.e).iterator();
            while (it.hasNext()) {
                ((androidx.core.os.e) it.next()).a();
            }
        }

        public void c() {
            if (this.g) {
                return;
            }
            if (FragmentManager.M0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.g = true;
            Iterator it = this.d.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        }

        public final void d(androidx.core.os.e eVar) {
            if (this.e.remove(eVar) && this.e.isEmpty()) {
                c();
            }
        }

        public State e() {
            return this.a;
        }

        public final Fragment f() {
            return this.c;
        }

        LifecycleImpact g() {
            return this.b;
        }

        final boolean h() {
            return this.f;
        }

        final boolean i() {
            return this.g;
        }

        public final void j(androidx.core.os.e eVar) {
            l();
            this.e.add(eVar);
        }

        final void k(State state, LifecycleImpact lifecycleImpact) {
            int i = a.b[lifecycleImpact.ordinal()];
            if (i == 1) {
                if (this.a == State.REMOVED) {
                    if (FragmentManager.M0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.c + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.b + " to ADDING.");
                    }
                    this.a = State.VISIBLE;
                    this.b = LifecycleImpact.ADDING;
                    return;
                }
                return;
            }
            if (i == 2) {
                if (FragmentManager.M0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.c + " mFinalState = " + this.a + " -> REMOVED. mLifecycleImpact  = " + this.b + " to REMOVING.");
                }
                this.a = State.REMOVED;
                this.b = LifecycleImpact.REMOVING;
                return;
            }
            if (i == 3 && this.a != State.REMOVED) {
                if (FragmentManager.M0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.c + " mFinalState = " + this.a + " -> " + state + ". ");
                }
                this.a = state;
            }
        }

        abstract void l();

        public String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {mFinalState = " + this.a + "} {mLifecycleImpact = " + this.b + "} {mFragment = " + this.c + "}";
        }
    }

    SpecialEffectsController(ViewGroup viewGroup) {
        this.a = viewGroup;
    }

    private void a(Operation.State state, Operation.LifecycleImpact lifecycleImpact, u uVar) {
        synchronized (this.b) {
            try {
                androidx.core.os.e eVar = new androidx.core.os.e();
                Operation h = h(uVar.k());
                if (h != null) {
                    h.k(state, lifecycleImpact);
                    return;
                }
                final b bVar = new b(state, lifecycleImpact, uVar, eVar);
                this.b.add(bVar);
                bVar.a(new Runnable() { // from class: androidx.fragment.app.SpecialEffectsController.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (SpecialEffectsController.this.b.contains(bVar)) {
                            bVar.e().applyState(bVar.f().mView);
                        }
                    }
                });
                bVar.a(new Runnable() { // from class: androidx.fragment.app.SpecialEffectsController.2
                    @Override // java.lang.Runnable
                    public void run() {
                        SpecialEffectsController.this.b.remove(bVar);
                        SpecialEffectsController.this.c.remove(bVar);
                    }
                });
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private Operation h(Fragment fragment) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            Operation operation = (Operation) it.next();
            if (operation.f().equals(fragment) && !operation.h()) {
                return operation;
            }
        }
        return null;
    }

    private Operation i(Fragment fragment) {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            Operation operation = (Operation) it.next();
            if (operation.f().equals(fragment) && !operation.h()) {
                return operation;
            }
        }
        return null;
    }

    static SpecialEffectsController n(ViewGroup viewGroup, FragmentManager fragmentManager) {
        return o(viewGroup, fragmentManager.E0());
    }

    static SpecialEffectsController o(ViewGroup viewGroup, b0 b0Var) {
        Object tag = viewGroup.getTag(R$id.special_effects_controller_view_tag);
        if (tag instanceof SpecialEffectsController) {
            return (SpecialEffectsController) tag;
        }
        SpecialEffectsController a = b0Var.a(viewGroup);
        viewGroup.setTag(R$id.special_effects_controller_view_tag, a);
        return a;
    }

    private void q() {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            Operation operation = (Operation) it.next();
            if (operation.g() == Operation.LifecycleImpact.ADDING) {
                operation.k(Operation.State.from(operation.f().requireView().getVisibility()), Operation.LifecycleImpact.NONE);
            }
        }
    }

    void b(Operation.State state, u uVar) {
        if (FragmentManager.M0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + uVar.k());
        }
        a(state, Operation.LifecycleImpact.ADDING, uVar);
    }

    void c(u uVar) {
        if (FragmentManager.M0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + uVar.k());
        }
        a(Operation.State.GONE, Operation.LifecycleImpact.NONE, uVar);
    }

    void d(u uVar) {
        if (FragmentManager.M0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + uVar.k());
        }
        a(Operation.State.REMOVED, Operation.LifecycleImpact.REMOVING, uVar);
    }

    void e(u uVar) {
        if (FragmentManager.M0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + uVar.k());
        }
        a(Operation.State.VISIBLE, Operation.LifecycleImpact.NONE, uVar);
    }

    abstract void f(List list, boolean z);

    void g() {
        if (this.e) {
            return;
        }
        if (!ViewCompat.isAttachedToWindow(this.a)) {
            j();
            this.d = false;
            return;
        }
        synchronized (this.b) {
            try {
                if (!this.b.isEmpty()) {
                    ArrayList arrayList = new ArrayList(this.c);
                    this.c.clear();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Operation operation = (Operation) it.next();
                        if (FragmentManager.M0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + operation);
                        }
                        operation.b();
                        if (!operation.i()) {
                            this.c.add(operation);
                        }
                    }
                    q();
                    ArrayList arrayList2 = new ArrayList(this.b);
                    this.b.clear();
                    this.c.addAll(arrayList2);
                    if (FragmentManager.M0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Executing pending operations");
                    }
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        ((Operation) it2.next()).l();
                    }
                    f(arrayList2, this.d);
                    this.d = false;
                    if (FragmentManager.M0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Finished executing pending operations");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void j() {
        String str;
        String str2;
        if (FragmentManager.M0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Forcing all operations to complete");
        }
        boolean isAttachedToWindow = ViewCompat.isAttachedToWindow(this.a);
        synchronized (this.b) {
            try {
                q();
                Iterator it = this.b.iterator();
                while (it.hasNext()) {
                    ((Operation) it.next()).l();
                }
                Iterator it2 = new ArrayList(this.c).iterator();
                while (it2.hasNext()) {
                    Operation operation = (Operation) it2.next();
                    if (FragmentManager.M0(2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("SpecialEffectsController: ");
                        if (isAttachedToWindow) {
                            str2 = "";
                        } else {
                            str2 = "Container " + this.a + " is not attached to window. ";
                        }
                        sb.append(str2);
                        sb.append("Cancelling running operation ");
                        sb.append(operation);
                        Log.v("FragmentManager", sb.toString());
                    }
                    operation.b();
                }
                Iterator it3 = new ArrayList(this.b).iterator();
                while (it3.hasNext()) {
                    Operation operation2 = (Operation) it3.next();
                    if (FragmentManager.M0(2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("SpecialEffectsController: ");
                        if (isAttachedToWindow) {
                            str = "";
                        } else {
                            str = "Container " + this.a + " is not attached to window. ";
                        }
                        sb2.append(str);
                        sb2.append("Cancelling pending operation ");
                        sb2.append(operation2);
                        Log.v("FragmentManager", sb2.toString());
                    }
                    operation2.b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void k() {
        if (this.e) {
            if (FragmentManager.M0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Forcing postponed operations");
            }
            this.e = false;
            g();
        }
    }

    Operation.LifecycleImpact l(u uVar) {
        Operation h = h(uVar.k());
        Operation.LifecycleImpact g = h != null ? h.g() : null;
        Operation i = i(uVar.k());
        return (i == null || !(g == null || g == Operation.LifecycleImpact.NONE)) ? g : i.g();
    }

    public ViewGroup m() {
        return this.a;
    }

    void p() {
        synchronized (this.b) {
            try {
                q();
                this.e = false;
                int size = this.b.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    }
                    Operation operation = (Operation) this.b.get(size);
                    Operation.State from = Operation.State.from(operation.f().mView);
                    Operation.State e = operation.e();
                    Operation.State state = Operation.State.VISIBLE;
                    if (e == state && from != state) {
                        this.e = operation.f().isPostponed();
                        break;
                    }
                    size--;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void r(boolean z) {
        this.d = z;
    }
}
