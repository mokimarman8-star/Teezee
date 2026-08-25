package androidx.fragment.app;

import android.view.ViewGroup;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class w {
    private final h a;
    private final ClassLoader b;
    ArrayList c;
    int d;
    int e;
    int f;
    int g;
    int h;
    boolean i;
    boolean j;
    String k;
    int l;
    CharSequence m;
    int n;
    CharSequence o;
    ArrayList p;
    ArrayList q;
    boolean r;
    ArrayList s;

    @Deprecated
    public w() {
        this.c = new ArrayList();
        this.j = true;
        this.r = false;
        this.a = null;
        this.b = null;
    }

    w(h hVar, ClassLoader classLoader) {
        this.c = new ArrayList();
        this.j = true;
        this.r = false;
        this.a = hVar;
        this.b = classLoader;
    }

    w(h hVar, ClassLoader classLoader, w wVar) {
        this(hVar, classLoader);
        Iterator it = wVar.c.iterator();
        while (it.hasNext()) {
            this.c.add(new a((a) it.next()));
        }
        this.d = wVar.d;
        this.e = wVar.e;
        this.f = wVar.f;
        this.g = wVar.g;
        this.h = wVar.h;
        this.i = wVar.i;
        this.j = wVar.j;
        this.k = wVar.k;
        this.n = wVar.n;
        this.o = wVar.o;
        this.l = wVar.l;
        this.m = wVar.m;
        if (wVar.p != null) {
            ArrayList arrayList = new ArrayList();
            this.p = arrayList;
            arrayList.addAll(wVar.p);
        }
        if (wVar.q != null) {
            ArrayList arrayList2 = new ArrayList();
            this.q = arrayList2;
            arrayList2.addAll(wVar.q);
        }
        this.r = wVar.r;
    }

    public w b(int i, Fragment fragment) {
        o(i, fragment, null, 1);
        return this;
    }

    public w c(int i, Fragment fragment, String str) {
        o(i, fragment, str, 1);
        return this;
    }

    w d(ViewGroup viewGroup, Fragment fragment, String str) {
        fragment.mContainer = viewGroup;
        return c(viewGroup.getId(), fragment, str);
    }

    public w e(Fragment fragment, String str) {
        o(0, fragment, str, 1);
        return this;
    }

    void f(a aVar) {
        this.c.add(aVar);
        aVar.d = this.d;
        aVar.e = this.e;
        aVar.f = this.f;
        aVar.g = this.g;
    }

    public w g(String str) {
        if (!this.j) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        this.i = true;
        this.k = str;
        return this;
    }

    public w h(Fragment fragment) {
        f(new a(7, fragment));
        return this;
    }

    public abstract int i();

    public abstract int j();

    public abstract void k();

    public abstract void l();

    public w m(Fragment fragment) {
        f(new a(6, fragment));
        return this;
    }

    public w n() {
        if (this.i) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.j = false;
        return this;
    }

    void o(int i, Fragment fragment, String str, int i2) {
        String str2 = fragment.mPreviousWho;
        if (str2 != null) {
            FragmentStrictMode.f(fragment, str2);
        }
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str3 = fragment.mTag;
            if (str3 != null && !str.equals(str3)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
            fragment.mTag = str;
        }
        if (i != 0) {
            if (i == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
            int i3 = fragment.mFragmentId;
            if (i3 != 0 && i3 != i) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i);
            }
            fragment.mFragmentId = i;
            fragment.mContainerId = i;
        }
        f(new a(i2, fragment));
    }

    public w p(Fragment fragment) {
        f(new a(4, fragment));
        return this;
    }

    public boolean q() {
        return this.c.isEmpty();
    }

    public w r(Fragment fragment) {
        f(new a(3, fragment));
        return this;
    }

    public w s(int i, Fragment fragment) {
        return t(i, fragment, null);
    }

    public w t(int i, Fragment fragment, String str) {
        if (i == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        o(i, fragment, str, 2);
        return this;
    }

    public w u(int i, int i2, int i3, int i4) {
        this.d = i;
        this.e = i2;
        this.f = i3;
        this.g = i4;
        return this;
    }

    public w v(Fragment fragment, Lifecycle.State state) {
        f(new a(10, fragment, state));
        return this;
    }

    public w w(Fragment fragment) {
        f(new a(8, fragment));
        return this;
    }

    public w x(boolean z) {
        this.r = z;
        return this;
    }

    public w y(Fragment fragment) {
        f(new a(5, fragment));
        return this;
    }
}
