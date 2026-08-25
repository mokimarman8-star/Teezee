package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    protected ConstraintWidget f5875a;

    /* renamed from: b, reason: collision with root package name */
    protected ConstraintWidget f5876b;

    /* renamed from: c, reason: collision with root package name */
    protected ConstraintWidget f5877c;

    /* renamed from: d, reason: collision with root package name */
    protected ConstraintWidget f5878d;

    /* renamed from: e, reason: collision with root package name */
    protected ConstraintWidget f5879e;

    /* renamed from: f, reason: collision with root package name */
    protected ConstraintWidget f5880f;

    /* renamed from: g, reason: collision with root package name */
    protected ConstraintWidget f5881g;

    /* renamed from: h, reason: collision with root package name */
    protected ArrayList f5882h;

    /* renamed from: i, reason: collision with root package name */
    protected int f5883i;

    /* renamed from: j, reason: collision with root package name */
    protected int f5884j;

    /* renamed from: k, reason: collision with root package name */
    protected float f5885k = 0.0f;

    /* renamed from: l, reason: collision with root package name */
    int f5886l;

    /* renamed from: m, reason: collision with root package name */
    int f5887m;

    /* renamed from: n, reason: collision with root package name */
    int f5888n;

    /* renamed from: o, reason: collision with root package name */
    boolean f5889o;

    /* renamed from: p, reason: collision with root package name */
    private int f5890p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f5891q;

    /* renamed from: r, reason: collision with root package name */
    protected boolean f5892r;

    /* renamed from: s, reason: collision with root package name */
    protected boolean f5893s;

    /* renamed from: t, reason: collision with root package name */
    protected boolean f5894t;

    /* renamed from: u, reason: collision with root package name */
    protected boolean f5895u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f5896v;

    public c(ConstraintWidget constraintWidget, int i5, boolean z5) {
        this.f5875a = constraintWidget;
        this.f5890p = i5;
        this.f5891q = z5;
    }

    private void b() {
        int i5 = this.f5890p * 2;
        ConstraintWidget constraintWidget = this.f5875a;
        this.f5889o = true;
        ConstraintWidget constraintWidget2 = constraintWidget;
        boolean z5 = false;
        while (!z5) {
            this.f5883i++;
            ConstraintWidget[] constraintWidgetArr = constraintWidget.P0;
            int i6 = this.f5890p;
            ConstraintWidget constraintWidget3 = null;
            constraintWidgetArr[i6] = null;
            constraintWidget.O0[i6] = null;
            if (constraintWidget.X() != 8) {
                this.f5886l++;
                ConstraintWidget.DimensionBehaviour w5 = constraintWidget.w(this.f5890p);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (w5 != dimensionBehaviour) {
                    this.f5887m += constraintWidget.G(this.f5890p);
                }
                int f5 = this.f5887m + constraintWidget.Y[i5].f();
                this.f5887m = f5;
                int i7 = i5 + 1;
                this.f5887m = f5 + constraintWidget.Y[i7].f();
                int f6 = this.f5888n + constraintWidget.Y[i5].f();
                this.f5888n = f6;
                this.f5888n = f6 + constraintWidget.Y[i7].f();
                if (this.f5876b == null) {
                    this.f5876b = constraintWidget;
                }
                this.f5878d = constraintWidget;
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.b0;
                int i8 = this.f5890p;
                if (dimensionBehaviourArr[i8] == dimensionBehaviour) {
                    int i9 = constraintWidget.y[i8];
                    if (i9 == 0 || i9 == 3 || i9 == 2) {
                        this.f5884j++;
                        float f7 = constraintWidget.N0[i8];
                        if (f7 > 0.0f) {
                            this.f5885k += f7;
                        }
                        if (c(constraintWidget, i8)) {
                            if (f7 < 0.0f) {
                                this.f5892r = true;
                            } else {
                                this.f5893s = true;
                            }
                            if (this.f5882h == null) {
                                this.f5882h = new ArrayList();
                            }
                            this.f5882h.add(constraintWidget);
                        }
                        if (this.f5880f == null) {
                            this.f5880f = constraintWidget;
                        }
                        ConstraintWidget constraintWidget4 = this.f5881g;
                        if (constraintWidget4 != null) {
                            constraintWidget4.O0[this.f5890p] = constraintWidget;
                        }
                        this.f5881g = constraintWidget;
                    }
                    if (this.f5890p == 0) {
                        if (constraintWidget.w != 0) {
                            this.f5889o = false;
                        } else if (constraintWidget.z != 0 || constraintWidget.A != 0) {
                            this.f5889o = false;
                        }
                    } else if (constraintWidget.x != 0) {
                        this.f5889o = false;
                    } else if (constraintWidget.C != 0 || constraintWidget.D != 0) {
                        this.f5889o = false;
                    }
                    if (constraintWidget.f0 != 0.0f) {
                        this.f5889o = false;
                        this.f5895u = true;
                    }
                }
            }
            if (constraintWidget2 != constraintWidget) {
                constraintWidget2.P0[this.f5890p] = constraintWidget;
            }
            ConstraintAnchor constraintAnchor = constraintWidget.Y[i5 + 1].f;
            if (constraintAnchor != null) {
                ConstraintWidget constraintWidget5 = constraintAnchor.d;
                ConstraintAnchor constraintAnchor2 = constraintWidget5.Y[i5].f;
                if (constraintAnchor2 != null && constraintAnchor2.d == constraintWidget) {
                    constraintWidget3 = constraintWidget5;
                }
            }
            if (constraintWidget3 == null) {
                constraintWidget3 = constraintWidget;
                z5 = true;
            }
            constraintWidget2 = constraintWidget;
            constraintWidget = constraintWidget3;
        }
        ConstraintWidget constraintWidget6 = this.f5876b;
        if (constraintWidget6 != null) {
            this.f5887m -= constraintWidget6.Y[i5].f();
        }
        ConstraintWidget constraintWidget7 = this.f5878d;
        if (constraintWidget7 != null) {
            this.f5887m -= constraintWidget7.Y[i5 + 1].f();
        }
        this.f5877c = constraintWidget;
        if (this.f5890p == 0 && this.f5891q) {
            this.f5879e = constraintWidget;
        } else {
            this.f5879e = this.f5875a;
        }
        this.f5894t = this.f5893s && this.f5892r;
    }

    private static boolean c(ConstraintWidget constraintWidget, int i5) {
        int i6;
        return constraintWidget.X() != 8 && constraintWidget.b0[i5] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && ((i6 = constraintWidget.y[i5]) == 0 || i6 == 3);
    }

    public void a() {
        if (!this.f5896v) {
            b();
        }
        this.f5896v = true;
    }
}
