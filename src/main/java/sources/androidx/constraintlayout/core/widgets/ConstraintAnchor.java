package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.c;
import androidx.constraintlayout.core.widgets.analyzer.g;
import androidx.constraintlayout.core.widgets.analyzer.m;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class ConstraintAnchor {
    private int b;
    private boolean c;
    public final ConstraintWidget d;
    public final Type e;
    public ConstraintAnchor f;
    SolverVariable i;
    private HashSet a = null;
    public int g = 0;
    int h = Integer.MIN_VALUE;

    public enum Type {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public ConstraintAnchor(ConstraintWidget constraintWidget, Type type) {
        this.d = constraintWidget;
        this.e = type;
    }

    public boolean a(ConstraintAnchor constraintAnchor, int i) {
        return b(constraintAnchor, i, Integer.MIN_VALUE, false);
    }

    public boolean b(ConstraintAnchor constraintAnchor, int i, int i2, boolean z) {
        if (constraintAnchor == null) {
            q();
            return true;
        }
        if (!z && !p(constraintAnchor)) {
            return false;
        }
        this.f = constraintAnchor;
        if (constraintAnchor.a == null) {
            constraintAnchor.a = new HashSet();
        }
        HashSet hashSet = this.f.a;
        if (hashSet != null) {
            hashSet.add(this);
        }
        this.g = i;
        this.h = i2;
        return true;
    }

    public void c(int i, ArrayList arrayList, m mVar) {
        HashSet hashSet = this.a;
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                g.a(((ConstraintAnchor) it.next()).d, i, arrayList, mVar);
            }
        }
    }

    public HashSet d() {
        return this.a;
    }

    public int e() {
        if (this.c) {
            return this.b;
        }
        return 0;
    }

    public int f() {
        ConstraintAnchor constraintAnchor;
        if (this.d.X() == 8) {
            return 0;
        }
        return (this.h == Integer.MIN_VALUE || (constraintAnchor = this.f) == null || constraintAnchor.d.X() != 8) ? this.g : this.h;
    }

    public final ConstraintAnchor g() {
        switch (a.a[this.e.ordinal()]) {
            case 1:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
            case 2:
                return this.d.S;
            case 3:
                return this.d.Q;
            case 4:
                return this.d.T;
            case 5:
                return this.d.R;
            default:
                throw new AssertionError(this.e.name());
        }
    }

    public ConstraintWidget h() {
        return this.d;
    }

    public SolverVariable i() {
        return this.i;
    }

    public ConstraintAnchor j() {
        return this.f;
    }

    public Type k() {
        return this.e;
    }

    public boolean l() {
        HashSet hashSet = this.a;
        if (hashSet == null) {
            return false;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (((ConstraintAnchor) it.next()).g().o()) {
                return true;
            }
        }
        return false;
    }

    public boolean m() {
        HashSet hashSet = this.a;
        return hashSet != null && hashSet.size() > 0;
    }

    public boolean n() {
        return this.c;
    }

    public boolean o() {
        return this.f != null;
    }

    public boolean p(ConstraintAnchor constraintAnchor) {
        if (constraintAnchor == null) {
            return false;
        }
        Type k = constraintAnchor.k();
        Type type = this.e;
        if (k == type) {
            return type != Type.BASELINE || (constraintAnchor.h().b0() && h().b0());
        }
        switch (a.a[type.ordinal()]) {
            case 1:
                return (k == Type.BASELINE || k == Type.CENTER_X || k == Type.CENTER_Y) ? false : true;
            case 2:
            case 3:
                boolean z = k == Type.LEFT || k == Type.RIGHT;
                if (constraintAnchor.h() instanceof f) {
                    return z || k == Type.CENTER_X;
                }
                return z;
            case 4:
            case 5:
                boolean z2 = k == Type.TOP || k == Type.BOTTOM;
                if (constraintAnchor.h() instanceof f) {
                    return z2 || k == Type.CENTER_Y;
                }
                return z2;
            case 6:
                return (k == Type.LEFT || k == Type.RIGHT) ? false : true;
            case 7:
            case 8:
            case 9:
                return false;
            default:
                throw new AssertionError(this.e.name());
        }
    }

    public void q() {
        HashSet hashSet;
        ConstraintAnchor constraintAnchor = this.f;
        if (constraintAnchor != null && (hashSet = constraintAnchor.a) != null) {
            hashSet.remove(this);
            if (this.f.a.size() == 0) {
                this.f.a = null;
            }
        }
        this.a = null;
        this.f = null;
        this.g = 0;
        this.h = Integer.MIN_VALUE;
        this.c = false;
        this.b = 0;
    }

    public void r() {
        this.c = false;
        this.b = 0;
    }

    public void s(c cVar) {
        SolverVariable solverVariable = this.i;
        if (solverVariable == null) {
            this.i = new SolverVariable(SolverVariable.Type.UNRESTRICTED, null);
        } else {
            solverVariable.f();
        }
    }

    public void t(int i) {
        this.b = i;
        this.c = true;
    }

    public String toString() {
        return this.d.v() + ":" + this.e.toString();
    }

    public void u(int i) {
        if (o()) {
            this.h = i;
        }
    }
}
