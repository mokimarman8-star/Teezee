package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import u0.a;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class WidgetRun implements a {
    public int a;
    ConstraintWidget b;
    k c;
    protected ConstraintWidget.DimensionBehaviour d;
    e e = new e(this);
    public int f = 0;
    boolean g = false;
    public DependencyNode h = new DependencyNode(this);
    public DependencyNode i = new DependencyNode(this);
    protected RunType j = RunType.NONE;

    public WidgetRun(ConstraintWidget constraintWidget) {
        this.b = constraintWidget;
    }

    private void l(int i, int i2) {
        int i3 = this.a;
        if (i3 == 0) {
            this.e.d(g(i2, i));
            return;
        }
        if (i3 == 1) {
            this.e.d(Math.min(g(this.e.m, i), i2));
            return;
        }
        if (i3 == 2) {
            ConstraintWidget M = this.b.M();
            if (M != null) {
                if ((i == 0 ? M.e : M.f).e.j) {
                    ConstraintWidget constraintWidget = this.b;
                    this.e.d(g((int) ((r9.g * (i == 0 ? constraintWidget.B : constraintWidget.E)) + 0.5f), i));
                    return;
                }
                return;
            }
            return;
        }
        if (i3 != 3) {
            return;
        }
        ConstraintWidget constraintWidget2 = this.b;
        l lVar = constraintWidget2.e;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = lVar.d;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (dimensionBehaviour == dimensionBehaviour2 && lVar.a == 3) {
            l lVar2 = constraintWidget2.f;
            if (lVar2.d == dimensionBehaviour2 && lVar2.a == 3) {
                return;
            }
        }
        if (i == 0) {
            lVar = constraintWidget2.f;
        }
        if (lVar.e.j) {
            float x = constraintWidget2.x();
            this.e.d(i == 1 ? (int) ((lVar.e.g / x) + 0.5f) : (int) ((x * lVar.e.g) + 0.5f));
        }
    }

    public abstract void a(a aVar);

    protected final void b(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i) {
        dependencyNode.l.add(dependencyNode2);
        dependencyNode.f = i;
        dependencyNode2.k.add(dependencyNode);
    }

    protected final void c(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i, e eVar) {
        dependencyNode.l.add(dependencyNode2);
        dependencyNode.l.add(this.e);
        dependencyNode.h = i;
        dependencyNode.i = eVar;
        dependencyNode2.k.add(dependencyNode);
        eVar.k.add(dependencyNode);
    }

    abstract void d();

    abstract void e();

    abstract void f();

    protected final int g(int i, int i2) {
        int max;
        if (i2 == 0) {
            ConstraintWidget constraintWidget = this.b;
            int i3 = constraintWidget.A;
            max = Math.max(constraintWidget.z, i);
            if (i3 > 0) {
                max = Math.min(i3, i);
            }
            if (max == i) {
                return i;
            }
        } else {
            ConstraintWidget constraintWidget2 = this.b;
            int i4 = constraintWidget2.D;
            max = Math.max(constraintWidget2.C, i);
            if (i4 > 0) {
                max = Math.min(i4, i);
            }
            if (max == i) {
                return i;
            }
        }
        return max;
    }

    protected final DependencyNode h(ConstraintAnchor constraintAnchor) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.d;
        int i = a.a[constraintAnchor2.e.ordinal()];
        if (i == 1) {
            return constraintWidget.e.h;
        }
        if (i == 2) {
            return constraintWidget.e.i;
        }
        if (i == 3) {
            return constraintWidget.f.h;
        }
        if (i == 4) {
            return constraintWidget.f.k;
        }
        if (i != 5) {
            return null;
        }
        return constraintWidget.f.i;
    }

    protected final DependencyNode i(ConstraintAnchor constraintAnchor, int i) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.d;
        j jVar = i == 0 ? constraintWidget.e : constraintWidget.f;
        int i2 = a.a[constraintAnchor2.e.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 5) {
                        return null;
                    }
                }
            }
            return jVar.i;
        }
        return jVar.h;
    }

    public long j() {
        if (this.e.j) {
            return r0.g;
        }
        return 0L;
    }

    public boolean k() {
        return this.g;
    }

    abstract boolean m();

    protected void n(a aVar, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i) {
        DependencyNode h = h(constraintAnchor);
        DependencyNode h2 = h(constraintAnchor2);
        if (h.j && h2.j) {
            int f = h.g + constraintAnchor.f();
            int f2 = h2.g - constraintAnchor2.f();
            int i2 = f2 - f;
            if (!this.e.j && this.d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                l(i, i2);
            }
            e eVar = this.e;
            if (eVar.j) {
                if (eVar.g == i2) {
                    this.h.d(f);
                    this.i.d(f2);
                    return;
                }
                ConstraintWidget constraintWidget = this.b;
                float A = i == 0 ? constraintWidget.A() : constraintWidget.T();
                if (h == h2) {
                    f = h.g;
                    f2 = h2.g;
                    A = 0.5f;
                }
                this.h.d((int) (f + 0.5f + (((f2 - f) - this.e.g) * A)));
                this.i.d(this.h.g + this.e.g);
            }
        }
    }

    protected void o(a aVar) {
    }

    protected void p(a aVar) {
    }
}
