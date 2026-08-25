package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.u;
import androidx.core.app.v;
import androidx.core.app.x;
import androidx.core.util.a;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuProvider;
import androidx.fragment.R$id;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.fragment.app.w;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.r;
import androidx.lifecycle.x0;
import androidx.lifecycle.y0;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import f.h;
import f.j;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.mvel2.ast.ASTNode;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class FragmentManager {
    private static boolean S;
    private androidx.activity.result.b D;
    private androidx.activity.result.b E;
    private androidx.activity.result.b F;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private ArrayList M;
    private ArrayList N;
    private ArrayList O;
    private r P;
    private FragmentStrictMode.b Q;
    private boolean b;
    ArrayList d;
    private ArrayList e;
    private OnBackPressedDispatcher g;
    private ArrayList m;
    private i v;
    private androidx.fragment.app.f w;
    private Fragment x;
    Fragment y;
    private final ArrayList a = new ArrayList();
    private final v c = new v();
    private final j f = new j(this);
    private final u h = new b(this, false);
    private final AtomicInteger i = new AtomicInteger();
    private final Map j = Collections.synchronizedMap(new HashMap());
    private final Map k = Collections.synchronizedMap(new HashMap());
    private final Map l = Collections.synchronizedMap(new HashMap());
    private final k n = new k(this);
    private final CopyOnWriteArrayList o = new CopyOnWriteArrayList();
    private final a p = new a() { // from class: androidx.fragment.app.l
        public final void accept(Object obj) {
            FragmentManager.this.V0((Configuration) obj);
        }
    };
    private final a q = new a() { // from class: androidx.fragment.app.m
        public final void accept(Object obj) {
            FragmentManager.this.W0((Integer) obj);
        }
    };
    private final a r = new a() { // from class: androidx.fragment.app.n
        public final void accept(Object obj) {
            FragmentManager.this.X0((androidx.core.app.m) obj);
        }
    };
    private final a s = new a() { // from class: androidx.fragment.app.o
        public final void accept(Object obj) {
            FragmentManager.this.Y0((x) obj);
        }
    };
    private final MenuProvider t = new c(this);
    int u = -1;
    private h z = null;
    private h A = new d(this);
    private b0 B = null;
    private b0 C = new e(this);
    ArrayDeque G = new ArrayDeque();
    private Runnable R = new Runnable() { // from class: androidx.fragment.app.FragmentManager.5
        @Override // java.lang.Runnable
        public void run() {
            FragmentManager.this.c0(true);
        }
    };

    class f implements r {
        final /* synthetic */ String a;
        final /* synthetic */ t b;
        final /* synthetic */ Lifecycle c;

        f(String str, t tVar, Lifecycle lifecycle) {
            this.a = str;
            this.b = tVar;
            this.c = lifecycle;
        }

        public void onStateChanged(androidx.lifecycle.u uVar, Lifecycle.Event event) {
            Bundle bundle;
            if (event == Lifecycle.Event.ON_START && (bundle = (Bundle) FragmentManager.this.k.get(this.a)) != null) {
                this.b.a(this.a, bundle);
                FragmentManager.this.u(this.a);
            }
            if (event == Lifecycle.Event.ON_DESTROY) {
                this.c.d(this);
                FragmentManager.this.l.remove(this.a);
            }
        }
    }

    static Fragment G0(View view) {
        Object tag = view.getTag(R$id.fragment_container_view_tag);
        if (tag instanceof Fragment) {
            return (Fragment) tag;
        }
        return null;
    }

    private void J1(Fragment fragment) {
        ViewGroup v0 = v0(fragment);
        if (v0 == null || fragment.getEnterAnim() + fragment.getExitAnim() + fragment.getPopEnterAnim() + fragment.getPopExitAnim() <= 0) {
            return;
        }
        if (v0.getTag(R$id.visible_removing_fragment_view_tag) == null) {
            v0.setTag(R$id.visible_removing_fragment_view_tag, fragment);
        }
        ((Fragment) v0.getTag(R$id.visible_removing_fragment_view_tag)).setPopDirection(fragment.getPopDirection());
    }

    private void L1() {
        Iterator it = this.c.k().iterator();
        while (it.hasNext()) {
            f1((u) it.next());
        }
    }

    public static boolean M0(int i) {
        return S || Log.isLoggable("FragmentManager", i);
    }

    private void M1(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter((Writer) new a0("FragmentManager"));
        i iVar = this.v;
        if (iVar != null) {
            try {
                iVar.h("  ", (FileDescriptor) null, printWriter, new String[0]);
                throw runtimeException;
            } catch (Exception e) {
                Log.e("FragmentManager", "Failed dumping state", e);
                throw runtimeException;
            }
        }
        try {
            Y("  ", null, printWriter, new String[0]);
            throw runtimeException;
        } catch (Exception e3) {
            Log.e("FragmentManager", "Failed dumping state", e3);
            throw runtimeException;
        }
    }

    private void N(Fragment fragment) {
        if (fragment == null || !fragment.equals(h0(fragment.mWho))) {
            return;
        }
        fragment.performPrimaryNavigationFragmentChanged();
    }

    private boolean N0(Fragment fragment) {
        return (fragment.mHasMenu && fragment.mMenuVisible) || fragment.mChildFragmentManager.q();
    }

    private boolean O0() {
        Fragment fragment = this.x;
        if (fragment == null) {
            return true;
        }
        return fragment.isAdded() && this.x.getParentFragmentManager().O0();
    }

    private void O1() {
        synchronized (this.a) {
            try {
                if (this.a.isEmpty()) {
                    this.h.setEnabled(r0() > 0 && R0(this.x));
                } else {
                    this.h.setEnabled(true);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void U(int i) {
        try {
            this.b = true;
            this.c.d(i);
            c1(i, false);
            Iterator it = v().iterator();
            while (it.hasNext()) {
                ((SpecialEffectsController) it.next()).j();
            }
            this.b = false;
            c0(true);
        } catch (Throwable th) {
            this.b = false;
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V0(Configuration configuration) {
        if (O0()) {
            B(configuration, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W0(Integer num) {
        if (O0() && num.intValue() == 80) {
            H(false);
        }
    }

    private void X() {
        if (this.L) {
            this.L = false;
            L1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X0(androidx.core.app.m mVar) {
        if (O0()) {
            I(mVar.a(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y0(x xVar) {
        if (O0()) {
            P(xVar.a(), false);
        }
    }

    private void Z() {
        Iterator it = v().iterator();
        while (it.hasNext()) {
            ((SpecialEffectsController) it.next()).j();
        }
    }

    private void b0(boolean z) {
        if (this.b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.v == null) {
            if (!this.K) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.v.g().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z) {
            r();
        }
        if (this.M == null) {
            this.M = new ArrayList();
            this.N = new ArrayList();
        }
    }

    private static void e0(ArrayList arrayList, ArrayList arrayList2, int i, int i2) {
        while (i < i2) {
            a aVar = (a) arrayList.get(i);
            if (((Boolean) arrayList2.get(i)).booleanValue()) {
                aVar.z(-1);
                aVar.F();
            } else {
                aVar.z(1);
                aVar.E();
            }
            i++;
        }
    }

    private void f0(ArrayList arrayList, ArrayList arrayList2, int i, int i2) {
        boolean z = ((a) arrayList.get(i)).r;
        ArrayList arrayList3 = this.O;
        if (arrayList3 == null) {
            this.O = new ArrayList();
        } else {
            arrayList3.clear();
        }
        this.O.addAll(this.c.o());
        Fragment D0 = D0();
        boolean z2 = false;
        for (int i3 = i; i3 < i2; i3++) {
            a aVar = (a) arrayList.get(i3);
            D0 = !((Boolean) arrayList2.get(i3)).booleanValue() ? aVar.G(this.O, D0) : aVar.J(this.O, D0);
            z2 = z2 || aVar.i;
        }
        this.O.clear();
        if (!z && this.u >= 1) {
            for (int i4 = i; i4 < i2; i4++) {
                Iterator it = ((a) arrayList.get(i4)).c.iterator();
                while (it.hasNext()) {
                    Fragment fragment = ((w.a) it.next()).b;
                    if (fragment != null && fragment.mFragmentManager != null) {
                        this.c.r(x(fragment));
                    }
                }
            }
        }
        e0(arrayList, arrayList2, i, i2);
        boolean booleanValue = ((Boolean) arrayList2.get(i2 - 1)).booleanValue();
        for (int i6 = i; i6 < i2; i6++) {
            a aVar2 = (a) arrayList.get(i6);
            if (booleanValue) {
                for (int size = aVar2.c.size() - 1; size >= 0; size--) {
                    Fragment fragment2 = ((w.a) aVar2.c.get(size)).b;
                    if (fragment2 != null) {
                        x(fragment2).m();
                    }
                }
            } else {
                Iterator it2 = aVar2.c.iterator();
                while (it2.hasNext()) {
                    Fragment fragment3 = ((w.a) it2.next()).b;
                    if (fragment3 != null) {
                        x(fragment3).m();
                    }
                }
            }
        }
        c1(this.u, true);
        for (SpecialEffectsController specialEffectsController : w(arrayList, i, i2)) {
            specialEffectsController.r(booleanValue);
            specialEffectsController.p();
            specialEffectsController.g();
        }
        while (i < i2) {
            a aVar3 = (a) arrayList.get(i);
            if (((Boolean) arrayList2.get(i)).booleanValue() && aVar3.v >= 0) {
                aVar3.v = -1;
            }
            aVar3.I();
            i++;
        }
        if (z2) {
            t1();
        }
    }

    private int i0(String str, int i, boolean z) {
        ArrayList arrayList = this.d;
        if (arrayList == null || arrayList.isEmpty()) {
            return -1;
        }
        if (str == null && i < 0) {
            if (z) {
                return 0;
            }
            return this.d.size() - 1;
        }
        int size = this.d.size() - 1;
        while (size >= 0) {
            a aVar = (a) this.d.get(size);
            if ((str != null && str.equals(aVar.H())) || (i >= 0 && i == aVar.v)) {
                break;
            }
            size--;
        }
        if (size < 0) {
            return size;
        }
        if (!z) {
            if (size == this.d.size() - 1) {
                return -1;
            }
            return size + 1;
        }
        while (size > 0) {
            a aVar2 = (a) this.d.get(size - 1);
            if ((str == null || !str.equals(aVar2.H())) && (i < 0 || i != aVar2.v)) {
                return size;
            }
            size--;
        }
        return size;
    }

    static FragmentManager m0(View view) {
        FragmentActivity fragmentActivity;
        Fragment n0 = n0(view);
        if (n0 != null) {
            if (n0.isAdded()) {
                return n0.getChildFragmentManager();
            }
            throw new IllegalStateException("The Fragment " + n0 + " that owns View " + view + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
        }
        Context context = view.getContext();
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                fragmentActivity = null;
                break;
            }
            if (context instanceof FragmentActivity) {
                fragmentActivity = (FragmentActivity) context;
                break;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (fragmentActivity != null) {
            return fragmentActivity.getSupportFragmentManager();
        }
        throw new IllegalStateException("View " + view + " is not within a subclass of FragmentActivity.");
    }

    private boolean m1(String str, int i, int i2) {
        c0(false);
        b0(true);
        Fragment fragment = this.y;
        if (fragment != null && i < 0 && str == null && fragment.getChildFragmentManager().j1()) {
            return true;
        }
        boolean n1 = n1(this.M, this.N, str, i, i2);
        if (n1) {
            this.b = true;
            try {
                r1(this.M, this.N);
            } finally {
                s();
            }
        }
        O1();
        X();
        this.c.b();
        return n1;
    }

    private static Fragment n0(View view) {
        while (view != null) {
            Fragment G0 = G0(view);
            if (G0 != null) {
                return G0;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return null;
    }

    private void o0() {
        Iterator it = v().iterator();
        while (it.hasNext()) {
            ((SpecialEffectsController) it.next()).k();
        }
    }

    private boolean p0(ArrayList arrayList, ArrayList arrayList2) {
        synchronized (this.a) {
            if (this.a.isEmpty()) {
                return false;
            }
            try {
                int size = this.a.size();
                boolean z = false;
                for (int i = 0; i < size; i++) {
                    z |= ((m) this.a.get(i)).a(arrayList, arrayList2);
                }
                return z;
            } finally {
                this.a.clear();
                this.v.g().removeCallbacks(this.R);
            }
        }
    }

    private void r() {
        if (T0()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    private void r1(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            if (!((a) arrayList.get(i)).r) {
                if (i2 != i) {
                    f0(arrayList, arrayList2, i2, i);
                }
                i2 = i + 1;
                if (((Boolean) arrayList2.get(i)).booleanValue()) {
                    while (i2 < size && ((Boolean) arrayList2.get(i2)).booleanValue() && !((a) arrayList.get(i2)).r) {
                        i2++;
                    }
                }
                f0(arrayList, arrayList2, i, i2);
                i = i2 - 1;
            }
            i++;
        }
        if (i2 != size) {
            f0(arrayList, arrayList2, i2, size);
        }
    }

    private void s() {
        this.b = false;
        this.N.clear();
        this.M.clear();
    }

    private r s0(Fragment fragment) {
        return this.P.g(fragment);
    }

    private void t() {
        i iVar = this.v;
        if (iVar instanceof y0 ? this.c.p().k() : iVar.f() instanceof Activity ? !((Activity) this.v.f()).isChangingConfigurations() : true) {
            Iterator it = this.j.values().iterator();
            while (it.hasNext()) {
                Iterator it2 = ((BackStackState) it.next()).a.iterator();
                while (it2.hasNext()) {
                    this.c.p().d((String) it2.next());
                }
            }
        }
    }

    private void t1() {
        ArrayList arrayList = this.m;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        android.support.v4.media.session.c.a(this.m.get(0));
        throw null;
    }

    private Set v() {
        HashSet hashSet = new HashSet();
        Iterator it = this.c.k().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = ((u) it.next()).k().mContainer;
            if (viewGroup != null) {
                hashSet.add(SpecialEffectsController.o(viewGroup, E0()));
            }
        }
        return hashSet;
    }

    private ViewGroup v0(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.mContainerId > 0 && this.w.d()) {
            View c = this.w.c(fragment.mContainerId);
            if (c instanceof ViewGroup) {
                return (ViewGroup) c;
            }
        }
        return null;
    }

    private Set w(ArrayList arrayList, int i, int i2) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i < i2) {
            Iterator it = ((a) arrayList.get(i)).c.iterator();
            while (it.hasNext()) {
                Fragment fragment = ((w.a) it.next()).b;
                if (fragment != null && (viewGroup = fragment.mContainer) != null) {
                    hashSet.add(SpecialEffectsController.n(viewGroup, this));
                }
            }
            i++;
        }
        return hashSet;
    }

    static int x1(int i) {
        int i2 = 4097;
        if (i == 4097) {
            return 8194;
        }
        if (i != 8194) {
            i2 = 8197;
            if (i == 8197) {
                return TaErrorCode.CODE_AD_UNIT_CONFIG_IS_EMPTY;
            }
            if (i == 4099) {
                return 4099;
            }
            if (i != 4100) {
                return 0;
            }
        }
        return i2;
    }

    void A() {
        this.I = false;
        this.J = false;
        this.P.m(false);
        U(0);
    }

    LayoutInflater.Factory2 A0() {
        return this.f;
    }

    boolean A1(ArrayList arrayList, ArrayList arrayList2, String str) {
        int i;
        int i0 = i0(str, -1, true);
        if (i0 < 0) {
            return false;
        }
        for (int i2 = i0; i2 < this.d.size(); i2++) {
            a aVar = (a) this.d.get(i2);
            if (!aVar.r) {
                M1(new IllegalArgumentException("saveBackStack(\"" + str + "\") included FragmentTransactions must use setReorderingAllowed(true) to ensure that the back stack can be restored as an atomic operation. Found " + aVar + " that did not use setReorderingAllowed(true)."));
            }
        }
        HashSet hashSet = new HashSet();
        for (int i3 = i0; i3 < this.d.size(); i3++) {
            a aVar2 = (a) this.d.get(i3);
            HashSet hashSet2 = new HashSet();
            HashSet hashSet3 = new HashSet();
            Iterator it = aVar2.c.iterator();
            while (it.hasNext()) {
                w.a aVar3 = (w.a) it.next();
                Fragment fragment = aVar3.b;
                if (fragment != null) {
                    if (!aVar3.c || (i = aVar3.a) == 1 || i == 2 || i == 8) {
                        hashSet.add(fragment);
                        hashSet2.add(fragment);
                    }
                    int i4 = aVar3.a;
                    if (i4 == 1 || i4 == 2) {
                        hashSet3.add(fragment);
                    }
                }
            }
            hashSet2.removeAll(hashSet3);
            if (!hashSet2.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                sb.append("saveBackStack(\"");
                sb.append(str);
                sb.append("\") must be self contained and not reference fragments from non-saved FragmentTransactions. Found reference to fragment");
                sb.append(hashSet2.size() == 1 ? " " + hashSet2.iterator().next() : "s " + hashSet2);
                sb.append(" in ");
                sb.append(aVar2);
                sb.append(" that were previously added to the FragmentManager through a separate FragmentTransaction.");
                M1(new IllegalArgumentException(sb.toString()));
            }
        }
        ArrayDeque arrayDeque = new ArrayDeque(hashSet);
        while (!arrayDeque.isEmpty()) {
            Fragment fragment2 = (Fragment) arrayDeque.removeFirst();
            if (fragment2.mRetainInstance) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("saveBackStack(\"");
                sb2.append(str);
                sb2.append("\") must not contain retained fragments. Found ");
                sb2.append(hashSet.contains(fragment2) ? "direct reference to retained " : "retained child ");
                sb2.append("fragment ");
                sb2.append(fragment2);
                M1(new IllegalArgumentException(sb2.toString()));
            }
            for (Fragment fragment3 : fragment2.mChildFragmentManager.q0()) {
                if (fragment3 != null) {
                    arrayDeque.addLast(fragment3);
                }
            }
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            arrayList3.add(((Fragment) it2.next()).mWho);
        }
        ArrayList arrayList4 = new ArrayList(this.d.size() - i0);
        for (int i6 = i0; i6 < this.d.size(); i6++) {
            arrayList4.add(null);
        }
        BackStackState backStackState = new BackStackState(arrayList3, arrayList4);
        for (int size = this.d.size() - 1; size >= i0; size--) {
            a aVar4 = (a) this.d.remove(size);
            a aVar5 = new a(aVar4);
            aVar5.A();
            arrayList4.set(size - i0, new BackStackRecordState(aVar5));
            aVar4.w = true;
            arrayList.add(aVar4);
            arrayList2.add(Boolean.TRUE);
        }
        this.j.put(str, backStackState);
        return true;
    }

    void B(Configuration configuration, boolean z) {
        if (z && (this.v instanceof androidx.core.content.d)) {
            M1(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
        }
        for (Fragment fragment : this.c.o()) {
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
                if (z) {
                    fragment.mChildFragmentManager.B(configuration, true);
                }
            }
        }
    }

    k B0() {
        return this.n;
    }

    public Fragment.SavedState B1(Fragment fragment) {
        u n = this.c.n(fragment.mWho);
        if (n == null || !n.k().equals(fragment)) {
            M1(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        return n.r();
    }

    boolean C(MenuItem menuItem) {
        if (this.u < 1) {
            return false;
        }
        for (Fragment fragment : this.c.o()) {
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    Fragment C0() {
        return this.x;
    }

    void C1() {
        synchronized (this.a) {
            try {
                if (this.a.size() == 1) {
                    this.v.g().removeCallbacks(this.R);
                    this.v.g().post(this.R);
                    O1();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void D() {
        this.I = false;
        this.J = false;
        this.P.m(false);
        U(1);
    }

    public Fragment D0() {
        return this.y;
    }

    void D1(Fragment fragment, boolean z) {
        ViewGroup v0 = v0(fragment);
        if (v0 == null || !(v0 instanceof FragmentContainerView)) {
            return;
        }
        ((FragmentContainerView) v0).setDrawDisappearingViewsLast(!z);
    }

    boolean E(Menu menu, MenuInflater menuInflater) {
        if (this.u < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z = false;
        for (Fragment fragment : this.c.o()) {
            if (fragment != null && Q0(fragment) && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(fragment);
                z = true;
            }
        }
        if (this.e != null) {
            for (int i = 0; i < this.e.size(); i++) {
                Fragment fragment2 = (Fragment) this.e.get(i);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.e = arrayList;
        return z;
    }

    b0 E0() {
        b0 b0Var = this.B;
        if (b0Var != null) {
            return b0Var;
        }
        Fragment fragment = this.x;
        return fragment != null ? fragment.mFragmentManager.E0() : this.C;
    }

    public void E1(h hVar) {
        this.z = hVar;
    }

    void F() {
        this.K = true;
        c0(true);
        Z();
        t();
        U(-1);
        androidx.core.content.e eVar = this.v;
        if (eVar instanceof androidx.core.content.e) {
            eVar.removeOnTrimMemoryListener(this.q);
        }
        androidx.core.content.d dVar = this.v;
        if (dVar instanceof androidx.core.content.d) {
            dVar.removeOnConfigurationChangedListener(this.p);
        }
        androidx.core.app.u uVar = this.v;
        if (uVar instanceof androidx.core.app.u) {
            uVar.removeOnMultiWindowModeChangedListener(this.r);
        }
        v vVar = this.v;
        if (vVar instanceof v) {
            vVar.removeOnPictureInPictureModeChangedListener(this.s);
        }
        MenuHost menuHost = this.v;
        if (menuHost instanceof MenuHost) {
            menuHost.removeMenuProvider(this.t);
        }
        this.v = null;
        this.w = null;
        this.x = null;
        if (this.g != null) {
            this.h.remove();
            this.g = null;
        }
        androidx.activity.result.b bVar = this.D;
        if (bVar != null) {
            bVar.c();
            this.E.c();
            this.F.c();
        }
    }

    public FragmentStrictMode.b F0() {
        return this.Q;
    }

    public final void F1(String str, Bundle bundle) {
        l lVar = (l) this.l.get(str);
        if (lVar == null || !lVar.b(Lifecycle.State.STARTED)) {
            this.k.put(str, bundle);
        } else {
            lVar.a(str, bundle);
        }
        if (M0(2)) {
            Log.v("FragmentManager", "Setting fragment result with key " + str + " and result " + bundle);
        }
    }

    void G() {
        U(1);
    }

    public final void G1(String str, androidx.lifecycle.u uVar, t tVar) {
        Lifecycle lifecycle = uVar.getLifecycle();
        if (lifecycle.b() == Lifecycle.State.DESTROYED) {
            return;
        }
        f fVar = new f(str, tVar, lifecycle);
        lifecycle.a(fVar);
        l lVar = (l) this.l.put(str, new l(lifecycle, tVar, fVar));
        if (lVar != null) {
            lVar.c();
        }
        if (M0(2)) {
            Log.v("FragmentManager", "Setting FragmentResultListener with key " + str + " lifecycleOwner " + lifecycle + " and listener " + tVar);
        }
    }

    void H(boolean z) {
        if (z && (this.v instanceof androidx.core.content.e)) {
            M1(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
        }
        for (Fragment fragment : this.c.o()) {
            if (fragment != null) {
                fragment.performLowMemory();
                if (z) {
                    fragment.mChildFragmentManager.H(true);
                }
            }
        }
    }

    x0 H0(Fragment fragment) {
        return this.P.j(fragment);
    }

    void H1(Fragment fragment, Lifecycle.State state) {
        if (fragment.equals(h0(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this)) {
            fragment.mMaxState = state;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    void I(boolean z, boolean z2) {
        if (z2 && (this.v instanceof androidx.core.app.u)) {
            M1(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
        }
        for (Fragment fragment : this.c.o()) {
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z);
                if (z2) {
                    fragment.mChildFragmentManager.I(z, true);
                }
            }
        }
    }

    void I0() {
        c0(true);
        if (this.h.isEnabled()) {
            j1();
        } else {
            this.g.l();
        }
    }

    void I1(Fragment fragment) {
        if (fragment == null || (fragment.equals(h0(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this))) {
            Fragment fragment2 = this.y;
            this.y = fragment;
            N(fragment2);
            N(this.y);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    void J(Fragment fragment) {
        Iterator it = this.o.iterator();
        while (it.hasNext()) {
            ((s) it.next()).a(this, fragment);
        }
    }

    void J0(Fragment fragment) {
        if (M0(2)) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.mHidden) {
            return;
        }
        fragment.mHidden = true;
        fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
        J1(fragment);
    }

    void K() {
        for (Fragment fragment : this.c.l()) {
            if (fragment != null) {
                fragment.onHiddenChanged(fragment.isHidden());
                fragment.mChildFragmentManager.K();
            }
        }
    }

    void K0(Fragment fragment) {
        if (fragment.mAdded && N0(fragment)) {
            this.H = true;
        }
    }

    void K1(Fragment fragment) {
        if (M0(2)) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    boolean L(MenuItem menuItem) {
        if (this.u < 1) {
            return false;
        }
        for (Fragment fragment : this.c.o()) {
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public boolean L0() {
        return this.K;
    }

    void M(Menu menu) {
        if (this.u < 1) {
            return;
        }
        for (Fragment fragment : this.c.o()) {
            if (fragment != null) {
                fragment.performOptionsMenuClosed(menu);
            }
        }
    }

    public void N1(k kVar) {
        this.n.p(kVar);
    }

    void O() {
        U(5);
    }

    void P(boolean z, boolean z2) {
        if (z2 && (this.v instanceof v)) {
            M1(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
        }
        for (Fragment fragment : this.c.o()) {
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z);
                if (z2) {
                    fragment.mChildFragmentManager.P(z, true);
                }
            }
        }
    }

    boolean P0(Fragment fragment) {
        if (fragment == null) {
            return false;
        }
        return fragment.isHidden();
    }

    boolean Q(Menu menu) {
        boolean z = false;
        if (this.u < 1) {
            return false;
        }
        for (Fragment fragment : this.c.o()) {
            if (fragment != null && Q0(fragment) && fragment.performPrepareOptionsMenu(menu)) {
                z = true;
            }
        }
        return z;
    }

    boolean Q0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        return fragment.isMenuVisible();
    }

    void R() {
        O1();
        N(this.y);
    }

    boolean R0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        FragmentManager fragmentManager = fragment.mFragmentManager;
        return fragment.equals(fragmentManager.D0()) && R0(fragmentManager.x);
    }

    void S() {
        this.I = false;
        this.J = false;
        this.P.m(false);
        U(7);
    }

    boolean S0(int i) {
        return this.u >= i;
    }

    void T() {
        this.I = false;
        this.J = false;
        this.P.m(false);
        U(5);
    }

    public boolean T0() {
        return this.I || this.J;
    }

    void V() {
        this.J = true;
        this.P.m(true);
        U(4);
    }

    void W() {
        U(2);
    }

    public void Y(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String str2 = str + "    ";
        this.c.e(str, fileDescriptor, printWriter, strArr);
        ArrayList arrayList = this.e;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i = 0; i < size2; i++) {
                Fragment fragment = (Fragment) this.e.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
        ArrayList arrayList2 = this.d;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i2 = 0; i2 < size; i2++) {
                a aVar = (a) this.d.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.C(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.i.get());
        synchronized (this.a) {
            try {
                int size3 = this.a.size();
                if (size3 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i3 = 0; i3 < size3; i3++) {
                        m mVar = (m) this.a.get(i3);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i3);
                        printWriter.print(": ");
                        printWriter.println(mVar);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.v);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.w);
        if (this.x != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.x);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.u);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.I);
        printWriter.print(" mStopped=");
        printWriter.print(this.J);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.K);
        if (this.H) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.H);
        }
    }

    void Z0(Fragment fragment, String[] strArr, int i) {
        if (this.F == null) {
            this.v.k(fragment, strArr, i);
            return;
        }
        this.G.addLast(new LaunchedFragmentInfo(fragment.mWho, i));
        this.F.a(strArr);
    }

    void a0(m mVar, boolean z) {
        if (!z) {
            if (this.v == null) {
                if (!this.K) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            r();
        }
        synchronized (this.a) {
            try {
                if (this.v == null) {
                    if (!z) {
                        throw new IllegalStateException("Activity has been destroyed");
                    }
                } else {
                    this.a.add(mVar);
                    C1();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void a1(Fragment fragment, Intent intent, int i, Bundle bundle) {
        if (this.D == null) {
            this.v.m(fragment, intent, i, bundle);
            return;
        }
        this.G.addLast(new LaunchedFragmentInfo(fragment.mWho, i));
        if (intent != null && bundle != null) {
            intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        }
        this.D.a(intent);
    }

    void b1(Fragment fragment, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        Intent intent2;
        if (this.E == null) {
            this.v.n(fragment, intentSender, i, intent, i2, i3, i4, bundle);
            return;
        }
        if (bundle != null) {
            if (intent == null) {
                intent2 = new Intent();
                intent2.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
            } else {
                intent2 = intent;
            }
            if (M0(2)) {
                Log.v("FragmentManager", "ActivityOptions " + bundle + " were added to fillInIntent " + intent2 + " for fragment " + fragment);
            }
            intent2.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        } else {
            intent2 = intent;
        }
        IntentSenderRequest a = new IntentSenderRequest.a(intentSender).b(intent2).c(i3, i2).a();
        this.G.addLast(new LaunchedFragmentInfo(fragment.mWho, i));
        if (M0(2)) {
            Log.v("FragmentManager", "Fragment " + fragment + "is launching an IntentSender for result ");
        }
        this.E.a(a);
    }

    boolean c0(boolean z) {
        b0(z);
        boolean z2 = false;
        while (p0(this.M, this.N)) {
            z2 = true;
            this.b = true;
            try {
                r1(this.M, this.N);
            } finally {
                s();
            }
        }
        O1();
        X();
        this.c.b();
        return z2;
    }

    void c1(int i, boolean z) {
        i iVar;
        if (this.v == null && i != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z || i != this.u) {
            this.u = i;
            this.c.t();
            L1();
            if (this.H && (iVar = this.v) != null && this.u == 7) {
                iVar.o();
                this.H = false;
            }
        }
    }

    void d0(m mVar, boolean z) {
        if (z && (this.v == null || this.K)) {
            return;
        }
        b0(z);
        if (mVar.a(this.M, this.N)) {
            this.b = true;
            try {
                r1(this.M, this.N);
            } finally {
                s();
            }
        }
        O1();
        X();
        this.c.b();
    }

    void d1() {
        if (this.v == null) {
            return;
        }
        this.I = false;
        this.J = false;
        this.P.m(false);
        for (Fragment fragment : this.c.o()) {
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
        }
    }

    void e1(FragmentContainerView fragmentContainerView) {
        View view;
        for (u uVar : this.c.k()) {
            Fragment k = uVar.k();
            if (k.mContainerId == fragmentContainerView.getId() && (view = k.mView) != null && view.getParent() == null) {
                k.mContainer = fragmentContainerView;
                uVar.b();
            }
        }
    }

    void f1(u uVar) {
        Fragment k = uVar.k();
        if (k.mDeferStart) {
            if (this.b) {
                this.L = true;
            } else {
                k.mDeferStart = false;
                uVar.m();
            }
        }
    }

    public boolean g0() {
        boolean c0 = c0(true);
        o0();
        return c0;
    }

    public void g1() {
        a0(new n(this, (String) null, -1, 0), false);
    }

    Fragment h0(String str) {
        return this.c.f(str);
    }

    void h1(int i, int i2, boolean z) {
        if (i >= 0) {
            a0(new n(this, (String) null, i, i2), z);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i);
    }

    void i(a aVar) {
        if (this.d == null) {
            this.d = new ArrayList();
        }
        this.d.add(aVar);
    }

    public void i1(String str, int i) {
        a0(new n(this, str, -1, i), false);
    }

    u j(Fragment fragment) {
        String str = fragment.mPreviousWho;
        if (str != null) {
            FragmentStrictMode.f(fragment, str);
        }
        if (M0(2)) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        u x = x(fragment);
        fragment.mFragmentManager = this;
        this.c.r(x);
        if (!fragment.mDetached) {
            this.c.a(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (N0(fragment)) {
                this.H = true;
            }
        }
        return x;
    }

    public Fragment j0(int i) {
        return this.c.g(i);
    }

    public boolean j1() {
        return m1(null, -1, 0);
    }

    public void k(s sVar) {
        this.o.add(sVar);
    }

    public Fragment k0(String str) {
        return this.c.h(str);
    }

    public boolean k1(int i, int i2) {
        if (i >= 0) {
            return m1(null, i, i2);
        }
        throw new IllegalArgumentException("Bad id: " + i);
    }

    void l(Fragment fragment) {
        this.P.b(fragment);
    }

    Fragment l0(String str) {
        return this.c.i(str);
    }

    public boolean l1(String str, int i) {
        return m1(str, -1, i);
    }

    int m() {
        return this.i.getAndIncrement();
    }

    void n(i iVar, androidx.fragment.app.f fVar, Fragment fragment) {
        String str;
        if (this.v != null) {
            throw new IllegalStateException("Already attached");
        }
        this.v = iVar;
        this.w = fVar;
        this.x = fragment;
        if (fragment != null) {
            k(new g(this, fragment));
        } else if (iVar instanceof s) {
            k((s) iVar);
        }
        if (this.x != null) {
            O1();
        }
        if (iVar instanceof androidx.activity.x) {
            Fragment fragment2 = (androidx.activity.x) iVar;
            OnBackPressedDispatcher onBackPressedDispatcher = fragment2.getOnBackPressedDispatcher();
            this.g = onBackPressedDispatcher;
            if (fragment != null) {
                fragment2 = fragment;
            }
            onBackPressedDispatcher.i(fragment2, this.h);
        }
        if (fragment != null) {
            this.P = fragment.mFragmentManager.s0(fragment);
        } else if (iVar instanceof y0) {
            this.P = r.h(((y0) iVar).getViewModelStore());
        } else {
            this.P = new r(false);
        }
        this.P.m(T0());
        this.c.A(this.P);
        androidx.savedstate.e eVar = this.v;
        if ((eVar instanceof androidx.savedstate.e) && fragment == null) {
            androidx.savedstate.c savedStateRegistry = eVar.getSavedStateRegistry();
            savedStateRegistry.h("android:support:fragments", new p(this));
            Bundle b = savedStateRegistry.b("android:support:fragments");
            if (b != null) {
                w1(b);
            }
        }
        androidx.activity.result.d dVar = this.v;
        if (dVar instanceof androidx.activity.result.d) {
            ActivityResultRegistry activityResultRegistry = dVar.getActivityResultRegistry();
            if (fragment != null) {
                str = fragment.mWho + ":";
            } else {
                str = "";
            }
            String str2 = "FragmentManager:" + str;
            this.D = activityResultRegistry.m(str2 + "StartActivityForResult", new j(), new h(this));
            this.E = activityResultRegistry.m(str2 + "StartIntentSenderForResult", new j(), new i(this));
            this.F = activityResultRegistry.m(str2 + "RequestPermissions", new h(), new a(this));
        }
        androidx.core.content.d dVar2 = this.v;
        if (dVar2 instanceof androidx.core.content.d) {
            dVar2.addOnConfigurationChangedListener(this.p);
        }
        androidx.core.content.e eVar2 = this.v;
        if (eVar2 instanceof androidx.core.content.e) {
            eVar2.addOnTrimMemoryListener(this.q);
        }
        androidx.core.app.u uVar = this.v;
        if (uVar instanceof androidx.core.app.u) {
            uVar.addOnMultiWindowModeChangedListener(this.r);
        }
        v vVar = this.v;
        if (vVar instanceof v) {
            vVar.addOnPictureInPictureModeChangedListener(this.s);
        }
        MenuHost menuHost = this.v;
        if ((menuHost instanceof MenuHost) && fragment == null) {
            menuHost.addMenuProvider(this.t);
        }
    }

    boolean n1(ArrayList arrayList, ArrayList arrayList2, String str, int i, int i2) {
        int i0 = i0(str, i, (i2 & 1) != 0);
        if (i0 < 0) {
            return false;
        }
        for (int size = this.d.size() - 1; size >= i0; size--) {
            arrayList.add((a) this.d.remove(size));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    void o(Fragment fragment) {
        if (M0(2)) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (fragment.mAdded) {
                return;
            }
            this.c.a(fragment);
            if (M0(2)) {
                Log.v("FragmentManager", "add from attach: " + fragment);
            }
            if (N0(fragment)) {
                this.H = true;
            }
        }
    }

    public void o1(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mFragmentManager != this) {
            M1(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putString(str, fragment.mWho);
    }

    public w p() {
        return new a(this);
    }

    public void p1(k kVar, boolean z) {
        this.n.o(kVar, z);
    }

    boolean q() {
        boolean z = false;
        for (Fragment fragment : this.c.l()) {
            if (fragment != null) {
                z = N0(fragment);
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    List q0() {
        return this.c.l();
    }

    void q1(Fragment fragment) {
        if (M0(2)) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean isInBackStack = fragment.isInBackStack();
        if (fragment.mDetached && isInBackStack) {
            return;
        }
        this.c.u(fragment);
        if (N0(fragment)) {
            this.H = true;
        }
        fragment.mRemoving = true;
        J1(fragment);
    }

    public int r0() {
        ArrayList arrayList = this.d;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    void s1(Fragment fragment) {
        this.P.l(fragment);
    }

    androidx.fragment.app.f t0() {
        return this.w;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(ASTNode.ASSIGN);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.x;
        if (fragment != null) {
            sb.append(fragment.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.x)));
            sb.append("}");
        } else {
            i iVar = this.v;
            if (iVar != null) {
                sb.append(iVar.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.v)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    public final void u(String str) {
        this.k.remove(str);
        if (M0(2)) {
            Log.v("FragmentManager", "Clearing fragment result with key " + str);
        }
    }

    public Fragment u0(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment h0 = h0(string);
        if (h0 == null) {
            M1(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        }
        return h0;
    }

    public void u1(String str) {
        a0(new o(this, str), false);
    }

    boolean v1(ArrayList arrayList, ArrayList arrayList2, String str) {
        BackStackState backStackState = (BackStackState) this.j.remove(str);
        if (backStackState == null) {
            return false;
        }
        HashMap hashMap = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.w) {
                Iterator it2 = aVar.c.iterator();
                while (it2.hasNext()) {
                    Fragment fragment = ((w.a) it2.next()).b;
                    if (fragment != null) {
                        hashMap.put(fragment.mWho, fragment);
                    }
                }
            }
        }
        Iterator it3 = backStackState.a(this, hashMap).iterator();
        while (true) {
            boolean z = false;
            while (it3.hasNext()) {
                if (((a) it3.next()).a(arrayList, arrayList2) || z) {
                    z = true;
                }
            }
            return z;
        }
    }

    public h w0() {
        h hVar = this.z;
        if (hVar != null) {
            return hVar;
        }
        Fragment fragment = this.x;
        return fragment != null ? fragment.mFragmentManager.w0() : this.A;
    }

    void w1(Parcelable parcelable) {
        u uVar;
        Bundle bundle;
        Bundle bundle2;
        if (parcelable == null) {
            return;
        }
        Bundle bundle3 = (Bundle) parcelable;
        for (String str : bundle3.keySet()) {
            if (str.startsWith("result_") && (bundle2 = bundle3.getBundle(str)) != null) {
                bundle2.setClassLoader(this.v.f().getClassLoader());
                this.k.put(str.substring(7), bundle2);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : bundle3.keySet()) {
            if (str2.startsWith("fragment_") && (bundle = bundle3.getBundle(str2)) != null) {
                bundle.setClassLoader(this.v.f().getClassLoader());
                arrayList.add(bundle.getParcelable("state"));
            }
        }
        this.c.x(arrayList);
        FragmentManagerState parcelable2 = bundle3.getParcelable("state");
        if (parcelable2 == null) {
            return;
        }
        this.c.v();
        Iterator it = parcelable2.a.iterator();
        while (it.hasNext()) {
            FragmentState B = this.c.B((String) it.next(), (FragmentState) null);
            if (B != null) {
                Fragment f2 = this.P.f(B.b);
                if (f2 != null) {
                    if (M0(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + f2);
                    }
                    uVar = new u(this.n, this.c, f2, B);
                } else {
                    uVar = new u(this.n, this.c, this.v.f().getClassLoader(), w0(), B);
                }
                Fragment k = uVar.k();
                k.mFragmentManager = this;
                if (M0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + k.mWho + "): " + k);
                }
                uVar.o(this.v.f().getClassLoader());
                this.c.r(uVar);
                uVar.u(this.u);
            }
        }
        for (Fragment fragment : this.P.i()) {
            if (!this.c.c(fragment.mWho)) {
                if (M0(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + fragment + " that was not found in the set of active Fragments " + parcelable2.a);
                }
                this.P.l(fragment);
                fragment.mFragmentManager = this;
                u uVar2 = new u(this.n, this.c, fragment);
                uVar2.u(1);
                uVar2.m();
                fragment.mRemoving = true;
                uVar2.m();
            }
        }
        this.c.w(parcelable2.b);
        if (parcelable2.c != null) {
            this.d = new ArrayList(parcelable2.c.length);
            int i = 0;
            while (true) {
                BackStackRecordState[] backStackRecordStateArr = parcelable2.c;
                if (i >= backStackRecordStateArr.length) {
                    break;
                }
                a b = backStackRecordStateArr[i].b(this);
                if (M0(2)) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i + " (index " + b.v + "): " + b);
                    PrintWriter printWriter = new PrintWriter((Writer) new a0("FragmentManager"));
                    b.D("  ", printWriter, false);
                    printWriter.close();
                }
                this.d.add(b);
                i++;
            }
        } else {
            this.d = null;
        }
        this.i.set(parcelable2.d);
        String str3 = parcelable2.e;
        if (str3 != null) {
            Fragment h0 = h0(str3);
            this.y = h0;
            N(h0);
        }
        ArrayList arrayList2 = parcelable2.f;
        if (arrayList2 != null) {
            for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                this.j.put((String) arrayList2.get(i2), (BackStackState) parcelable2.g.get(i2));
            }
        }
        this.G = new ArrayDeque(parcelable2.h);
    }

    u x(Fragment fragment) {
        u n = this.c.n(fragment.mWho);
        if (n != null) {
            return n;
        }
        u uVar = new u(this.n, this.c, fragment);
        uVar.o(this.v.f().getClassLoader());
        uVar.u(this.u);
        return uVar;
    }

    v x0() {
        return this.c;
    }

    void y(Fragment fragment) {
        if (M0(2)) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (fragment.mDetached) {
            return;
        }
        fragment.mDetached = true;
        if (fragment.mAdded) {
            if (M0(2)) {
                Log.v("FragmentManager", "remove from detach: " + fragment);
            }
            this.c.u(fragment);
            if (N0(fragment)) {
                this.H = true;
            }
            J1(fragment);
        }
    }

    public List y0() {
        return this.c.o();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: y1, reason: merged with bridge method [inline-methods] */
    public Bundle U0() {
        BackStackRecordState[] backStackRecordStateArr;
        int size;
        Bundle bundle = new Bundle();
        o0();
        Z();
        c0(true);
        this.I = true;
        this.P.m(true);
        ArrayList y = this.c.y();
        ArrayList m = this.c.m();
        if (!m.isEmpty()) {
            ArrayList z = this.c.z();
            ArrayList arrayList = this.d;
            if (arrayList == null || (size = arrayList.size()) <= 0) {
                backStackRecordStateArr = null;
            } else {
                backStackRecordStateArr = new BackStackRecordState[size];
                for (int i = 0; i < size; i++) {
                    backStackRecordStateArr[i] = new BackStackRecordState((a) this.d.get(i));
                    if (M0(2)) {
                        Log.v("FragmentManager", "saveAllState: adding back stack #" + i + ": " + this.d.get(i));
                    }
                }
            }
            FragmentManagerState fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.a = y;
            fragmentManagerState.b = z;
            fragmentManagerState.c = backStackRecordStateArr;
            fragmentManagerState.d = this.i.get();
            Fragment fragment = this.y;
            if (fragment != null) {
                fragmentManagerState.e = fragment.mWho;
            }
            fragmentManagerState.f.addAll(this.j.keySet());
            fragmentManagerState.g.addAll(this.j.values());
            fragmentManagerState.h = new ArrayList(this.G);
            bundle.putParcelable("state", fragmentManagerState);
            for (String str : this.k.keySet()) {
                bundle.putBundle("result_" + str, (Bundle) this.k.get(str));
            }
            Iterator it = m.iterator();
            while (it.hasNext()) {
                FragmentState fragmentState = (FragmentState) it.next();
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("state", fragmentState);
                bundle.putBundle("fragment_" + fragmentState.b, bundle2);
            }
        } else if (M0(2)) {
            Log.v("FragmentManager", "saveAllState: no fragments!");
        }
        return bundle;
    }

    void z() {
        this.I = false;
        this.J = false;
        this.P.m(false);
        U(4);
    }

    public i z0() {
        return this.v;
    }

    public void z1(String str) {
        a0(new p(this, str), false);
    }
}
