package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.d;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import androidx.constraintlayout.core.widgets.analyzer.c;
import androidx.constraintlayout.core.widgets.analyzer.j;
import androidx.constraintlayout.core.widgets.analyzer.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import s0.a;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class ConstraintWidget {
    public static float U0 = 0.5f;
    int A0;
    int B0;
    boolean C0;
    boolean D0;
    boolean E0;
    public boolean F;
    boolean F0;
    public boolean G;
    boolean G0;
    boolean H0;
    boolean I0;
    int J0;
    int K0;
    boolean L0;
    private boolean M;
    boolean M0;
    public float[] N0;
    protected ConstraintWidget[] O0;
    protected ConstraintWidget[] P0;
    ConstraintWidget Q0;
    ConstraintWidget R0;
    public int S0;
    public int T0;
    public ConstraintAnchor X;
    public ConstraintAnchor[] Y;
    protected ArrayList Z;
    private boolean[] a0;
    public DimensionBehaviour[] b0;
    public c c;
    public ConstraintWidget c0;
    public c d;
    int d0;
    int e0;
    public float f0;
    protected int g0;
    protected int h0;
    protected int i0;
    int j0;
    int k0;
    protected int l0;
    protected int m0;
    int n0;
    public String o;
    protected int o0;
    protected int p0;
    float q0;
    float r0;
    private Object s0;
    private int t0;
    private int u0;
    private boolean v0;
    private String w0;
    private String x0;
    int y0;
    int z0;
    public boolean a = false;
    public WidgetRun[] b = new WidgetRun[2];
    public j e = null;
    public l f = null;
    public boolean[] g = {true, true};
    boolean h = false;
    private boolean i = true;
    private boolean j = false;
    private boolean k = true;
    private int l = -1;
    private int m = -1;
    public a n = new a(this);
    private boolean p = false;
    private boolean q = false;
    private boolean r = false;
    private boolean s = false;
    public int t = -1;
    public int u = -1;
    private int v = 0;
    public int w = 0;
    public int x = 0;
    public int[] y = new int[2];
    public int z = 0;
    public int A = 0;
    public float B = 1.0f;
    public int C = 0;
    public int D = 0;
    public float E = 1.0f;
    int H = -1;
    float I = 1.0f;
    private int[] J = {Integer.MAX_VALUE, Integer.MAX_VALUE};
    private float K = 0.0f;
    private boolean L = false;
    private boolean N = false;
    private int O = 0;
    private int P = 0;
    public ConstraintAnchor Q = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
    public ConstraintAnchor R = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
    public ConstraintAnchor S = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
    public ConstraintAnchor T = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
    public ConstraintAnchor U = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
    ConstraintAnchor V = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
    ConstraintAnchor W = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);

    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public ConstraintWidget() {
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.X = constraintAnchor;
        this.Y = new ConstraintAnchor[]{this.Q, this.S, this.R, this.T, this.U, constraintAnchor};
        this.Z = new ArrayList();
        this.a0 = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.b0 = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.c0 = null;
        this.d0 = 0;
        this.e0 = 0;
        this.f0 = 0.0f;
        this.g0 = -1;
        this.h0 = 0;
        this.i0 = 0;
        this.j0 = 0;
        this.k0 = 0;
        this.l0 = 0;
        this.m0 = 0;
        this.n0 = 0;
        float f = U0;
        this.q0 = f;
        this.r0 = f;
        this.t0 = 0;
        this.u0 = 0;
        this.v0 = false;
        this.w0 = null;
        this.x0 = null;
        this.I0 = false;
        this.J0 = 0;
        this.K0 = 0;
        this.N0 = new float[]{-1.0f, -1.0f};
        this.O0 = new ConstraintWidget[]{null, null};
        this.P0 = new ConstraintWidget[]{null, null};
        this.Q0 = null;
        this.R0 = null;
        this.S0 = -1;
        this.T0 = -1;
        d();
    }

    private void A0(StringBuilder sb, String str, float f, float f2) {
        if (f == f2) {
            return;
        }
        sb.append(str);
        sb.append(" :   ");
        sb.append(f);
        sb.append(",\n");
    }

    private void B0(StringBuilder sb, String str, int i, int i2) {
        if (i == i2) {
            return;
        }
        sb.append(str);
        sb.append(" :   ");
        sb.append(i);
        sb.append(",\n");
    }

    private void C0(StringBuilder sb, String str, float f, int i) {
        if (f == 0.0f) {
            return;
        }
        sb.append(str);
        sb.append(" :  [");
        sb.append(f);
        sb.append(",");
        sb.append(i);
        sb.append("");
        sb.append("],\n");
    }

    private void R(StringBuilder sb, String str, int i, int i2, int i3, int i4, int i6, int i7, float f, float f2) {
        sb.append(str);
        sb.append(" :  {\n");
        B0(sb, "      size", i, 0);
        B0(sb, "      min", i2, 0);
        B0(sb, "      max", i3, Integer.MAX_VALUE);
        B0(sb, "      matchMin", i6, 0);
        B0(sb, "      matchDef", i7, 0);
        A0(sb, "      matchPercent", f, 1.0f);
        sb.append("    },\n");
    }

    private void S(StringBuilder sb, String str, ConstraintAnchor constraintAnchor) {
        if (constraintAnchor.f == null) {
            return;
        }
        sb.append("    ");
        sb.append(str);
        sb.append(" : [ '");
        sb.append(constraintAnchor.f);
        sb.append("'");
        if (constraintAnchor.h != Integer.MIN_VALUE || constraintAnchor.g != 0) {
            sb.append(",");
            sb.append(constraintAnchor.g);
            if (constraintAnchor.h != Integer.MIN_VALUE) {
                sb.append(",");
                sb.append(constraintAnchor.h);
                sb.append(",");
            }
        }
        sb.append(" ] ,\n");
    }

    private void d() {
        this.Z.add(this.Q);
        this.Z.add(this.R);
        this.Z.add(this.S);
        this.Z.add(this.T);
        this.Z.add(this.V);
        this.Z.add(this.W);
        this.Z.add(this.X);
        this.Z.add(this.U);
    }

    private boolean h0(int i) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        int i2 = i * 2;
        ConstraintAnchor[] constraintAnchorArr = this.Y;
        ConstraintAnchor constraintAnchor3 = constraintAnchorArr[i2];
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f;
        return (constraintAnchor4 == null || constraintAnchor4.f == constraintAnchor3 || (constraintAnchor2 = (constraintAnchor = constraintAnchorArr[i2 + 1]).f) == null || constraintAnchor2.f != constraintAnchor) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:111:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x03a3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0404  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x040d  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0433 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x044d  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0497  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x04a9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:244:0x042f  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x03f4  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x04fd  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x04cd A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void i(androidx.constraintlayout.core.d r32, boolean r33, boolean r34, boolean r35, boolean r36, androidx.constraintlayout.core.SolverVariable r37, androidx.constraintlayout.core.SolverVariable r38, androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour r39, boolean r40, androidx.constraintlayout.core.widgets.ConstraintAnchor r41, androidx.constraintlayout.core.widgets.ConstraintAnchor r42, int r43, int r44, int r45, int r46, float r47, boolean r48, boolean r49, boolean r50, boolean r51, boolean r52, int r53, int r54, int r55, int r56, float r57, boolean r58) {
        /*
            Method dump skipped, instructions count: 1353
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.i(androidx.constraintlayout.core.d, boolean, boolean, boolean, boolean, androidx.constraintlayout.core.SolverVariable, androidx.constraintlayout.core.SolverVariable, androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour, boolean, androidx.constraintlayout.core.widgets.ConstraintAnchor, androidx.constraintlayout.core.widgets.ConstraintAnchor, int, int, int, int, float, boolean, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    public float A() {
        return this.q0;
    }

    public int B() {
        return this.J0;
    }

    public DimensionBehaviour C() {
        return this.b0[0];
    }

    public int D() {
        ConstraintAnchor constraintAnchor = this.Q;
        int i = constraintAnchor != null ? constraintAnchor.g : 0;
        ConstraintAnchor constraintAnchor2 = this.S;
        return constraintAnchor2 != null ? i + constraintAnchor2.g : i;
    }

    public void D0(boolean z) {
        this.v0 = z;
    }

    public int E() {
        return this.O;
    }

    public void E0(int i) {
        this.n0 = i;
        this.L = i > 0;
    }

    public int F() {
        return this.P;
    }

    public void F0(Object obj) {
        this.s0 = obj;
    }

    public int G(int i) {
        if (i == 0) {
            return Y();
        }
        if (i == 1) {
            return z();
        }
        return 0;
    }

    public void G0(String str) {
        this.w0 = str;
    }

    public int H() {
        return this.J[1];
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0086 -> B:31:0x0087). Please report as a decompilation issue!!! */
    public void H0(String str) {
        float f;
        int i = 0;
        if (str == null || str.length() == 0) {
            this.f0 = 0.0f;
            return;
        }
        int length = str.length();
        int indexOf = str.indexOf(44);
        int i2 = -1;
        if (indexOf > 0 && indexOf < length - 1) {
            String substring = str.substring(0, indexOf);
            i2 = substring.equalsIgnoreCase("W") ? 0 : substring.equalsIgnoreCase("H") ? 1 : -1;
            r3 = indexOf + 1;
        }
        int indexOf2 = str.indexOf(58);
        if (indexOf2 < 0 || indexOf2 >= length - 1) {
            String substring2 = str.substring(r3);
            if (substring2.length() > 0) {
                f = Float.parseFloat(substring2);
            }
            f = i;
        } else {
            String substring3 = str.substring(r3, indexOf2);
            String substring4 = str.substring(indexOf2 + 1);
            if (substring3.length() > 0 && substring4.length() > 0) {
                float parseFloat = Float.parseFloat(substring3);
                float parseFloat2 = Float.parseFloat(substring4);
                if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                    f = i2 == 1 ? Math.abs(parseFloat2 / parseFloat) : Math.abs(parseFloat / parseFloat2);
                }
            }
            f = i;
        }
        i = (f > i ? 1 : (f == i ? 0 : -1));
        if (i > 0) {
            this.f0 = f;
            this.g0 = i2;
        }
    }

    public int I() {
        return this.J[0];
    }

    public void I0(int i) {
        if (this.L) {
            int i2 = i - this.n0;
            int i3 = this.e0 + i2;
            this.i0 = i2;
            this.R.t(i2);
            this.T.t(i3);
            this.U.t(i);
            this.q = true;
        }
    }

    public int J() {
        return this.p0;
    }

    public void J0(int i, int i2) {
        if (this.p) {
            return;
        }
        this.Q.t(i);
        this.S.t(i2);
        this.h0 = i;
        this.d0 = i2 - i;
        this.p = true;
    }

    public int K() {
        return this.o0;
    }

    public void K0(int i) {
        this.Q.t(i);
        this.h0 = i;
    }

    public ConstraintWidget L(int i) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i != 0) {
            if (i == 1 && (constraintAnchor2 = (constraintAnchor = this.T).f) != null && constraintAnchor2.f == constraintAnchor) {
                return constraintAnchor2.d;
            }
            return null;
        }
        ConstraintAnchor constraintAnchor3 = this.S;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f;
        if (constraintAnchor4 == null || constraintAnchor4.f != constraintAnchor3) {
            return null;
        }
        return constraintAnchor4.d;
    }

    public void L0(int i) {
        this.R.t(i);
        this.i0 = i;
    }

    public ConstraintWidget M() {
        return this.c0;
    }

    public void M0(int i, int i2) {
        if (this.q) {
            return;
        }
        this.R.t(i);
        this.T.t(i2);
        this.i0 = i;
        this.e0 = i2 - i;
        if (this.L) {
            this.U.t(i + this.n0);
        }
        this.q = true;
    }

    public ConstraintWidget N(int i) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i != 0) {
            if (i == 1 && (constraintAnchor2 = (constraintAnchor = this.R).f) != null && constraintAnchor2.f == constraintAnchor) {
                return constraintAnchor2.d;
            }
            return null;
        }
        ConstraintAnchor constraintAnchor3 = this.Q;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f;
        if (constraintAnchor4 == null || constraintAnchor4.f != constraintAnchor3) {
            return null;
        }
        return constraintAnchor4.d;
    }

    public void N0(int i, int i2, int i3, int i4) {
        int i6;
        int i7;
        int i8 = i3 - i;
        int i9 = i4 - i2;
        this.h0 = i;
        this.i0 = i2;
        if (this.u0 == 8) {
            this.d0 = 0;
            this.e0 = 0;
            return;
        }
        DimensionBehaviour[] dimensionBehaviourArr = this.b0;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.FIXED;
        if (dimensionBehaviour == dimensionBehaviour2 && i8 < (i7 = this.d0)) {
            i8 = i7;
        }
        if (dimensionBehaviourArr[1] == dimensionBehaviour2 && i9 < (i6 = this.e0)) {
            i9 = i6;
        }
        this.d0 = i8;
        this.e0 = i9;
        int i10 = this.p0;
        if (i9 < i10) {
            this.e0 = i10;
        }
        int i11 = this.o0;
        if (i8 < i11) {
            this.d0 = i11;
        }
        int i12 = this.A;
        if (i12 > 0 && dimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT) {
            this.d0 = Math.min(this.d0, i12);
        }
        int i13 = this.D;
        if (i13 > 0 && this.b0[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
            this.e0 = Math.min(this.e0, i13);
        }
        int i14 = this.d0;
        if (i8 != i14) {
            this.l = i14;
        }
        int i15 = this.e0;
        if (i9 != i15) {
            this.m = i15;
        }
    }

    public int O() {
        return Z() + this.d0;
    }

    public void O0(boolean z) {
        this.L = z;
    }

    public WidgetRun P(int i) {
        if (i == 0) {
            return this.e;
        }
        if (i == 1) {
            return this.f;
        }
        return null;
    }

    public void P0(int i) {
        this.e0 = i;
        int i2 = this.p0;
        if (i < i2) {
            this.e0 = i2;
        }
    }

    public void Q(StringBuilder sb) {
        sb.append("  " + this.o + ":{\n");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("    actualWidth:");
        sb2.append(this.d0);
        sb.append(sb2.toString());
        sb.append("\n");
        sb.append("    actualHeight:" + this.e0);
        sb.append("\n");
        sb.append("    actualLeft:" + this.h0);
        sb.append("\n");
        sb.append("    actualTop:" + this.i0);
        sb.append("\n");
        S(sb, "left", this.Q);
        S(sb, "top", this.R);
        S(sb, "right", this.S);
        S(sb, "bottom", this.T);
        S(sb, "baseline", this.U);
        S(sb, "centerX", this.V);
        S(sb, "centerY", this.W);
        R(sb, "    width", this.d0, this.o0, this.J[0], this.l, this.z, this.w, this.B, this.N0[0]);
        R(sb, "    height", this.e0, this.p0, this.J[1], this.m, this.C, this.x, this.E, this.N0[1]);
        C0(sb, "    dimensionRatio", this.f0, this.g0);
        A0(sb, "    horizontalBias", this.q0, U0);
        A0(sb, "    verticalBias", this.r0, U0);
        B0(sb, "    horizontalChainStyle", this.J0, 0);
        B0(sb, "    verticalChainStyle", this.K0, 0);
        sb.append("  }");
    }

    public void Q0(float f) {
        this.q0 = f;
    }

    public void R0(int i) {
        this.J0 = i;
    }

    public void S0(int i, int i2) {
        this.h0 = i;
        int i3 = i2 - i;
        this.d0 = i3;
        int i4 = this.o0;
        if (i3 < i4) {
            this.d0 = i4;
        }
    }

    public float T() {
        return this.r0;
    }

    public void T0(DimensionBehaviour dimensionBehaviour) {
        this.b0[0] = dimensionBehaviour;
    }

    public int U() {
        return this.K0;
    }

    public void U0(int i, int i2, int i3, float f) {
        this.w = i;
        this.z = i2;
        if (i3 == Integer.MAX_VALUE) {
            i3 = 0;
        }
        this.A = i3;
        this.B = f;
        if (f <= 0.0f || f >= 1.0f || i != 0) {
            return;
        }
        this.w = 2;
    }

    public DimensionBehaviour V() {
        return this.b0[1];
    }

    public void V0(float f) {
        this.N0[0] = f;
    }

    public int W() {
        int i = this.Q != null ? this.R.g : 0;
        return this.S != null ? i + this.T.g : i;
    }

    protected void W0(int i, boolean z) {
        this.a0[i] = z;
    }

    public int X() {
        return this.u0;
    }

    public void X0(boolean z) {
        this.M = z;
    }

    public int Y() {
        if (this.u0 == 8) {
            return 0;
        }
        return this.d0;
    }

    public void Y0(boolean z) {
        this.N = z;
    }

    public int Z() {
        d dVar = this.c0;
        return (dVar == null || !(dVar instanceof d)) ? this.h0 : dVar.d1 + this.h0;
    }

    public void Z0(int i, int i2) {
        this.O = i;
        this.P = i2;
        c1(false);
    }

    public int a0() {
        d dVar = this.c0;
        return (dVar == null || !(dVar instanceof d)) ? this.i0 : dVar.e1 + this.i0;
    }

    public void a1(int i) {
        this.J[1] = i;
    }

    public boolean b0() {
        return this.L;
    }

    public void b1(int i) {
        this.J[0] = i;
    }

    public boolean c0(int i) {
        if (i == 0) {
            return (this.Q.f != null ? 1 : 0) + (this.S.f != null ? 1 : 0) < 2;
        }
        return ((this.R.f != null ? 1 : 0) + (this.T.f != null ? 1 : 0)) + (this.U.f != null ? 1 : 0) < 2;
    }

    public void c1(boolean z) {
        this.i = z;
    }

    public boolean d0() {
        int size = this.Z.size();
        for (int i = 0; i < size; i++) {
            if (((ConstraintAnchor) this.Z.get(i)).m()) {
                return true;
            }
        }
        return false;
    }

    public void d1(int i) {
        if (i < 0) {
            this.p0 = 0;
        } else {
            this.p0 = i;
        }
    }

    public void e(d dVar, d dVar2, HashSet hashSet, int i, boolean z) {
        if (z) {
            if (!hashSet.contains(this)) {
                return;
            }
            g.a(dVar, dVar2, this);
            hashSet.remove(this);
            g(dVar2, dVar.Y1(64));
        }
        if (i == 0) {
            HashSet d = this.Q.d();
            if (d != null) {
                Iterator it = d.iterator();
                while (it.hasNext()) {
                    ((ConstraintAnchor) it.next()).d.e(dVar, dVar2, hashSet, i, true);
                }
            }
            HashSet d2 = this.S.d();
            if (d2 != null) {
                Iterator it2 = d2.iterator();
                while (it2.hasNext()) {
                    ((ConstraintAnchor) it2.next()).d.e(dVar, dVar2, hashSet, i, true);
                }
                return;
            }
            return;
        }
        HashSet d3 = this.R.d();
        if (d3 != null) {
            Iterator it3 = d3.iterator();
            while (it3.hasNext()) {
                ((ConstraintAnchor) it3.next()).d.e(dVar, dVar2, hashSet, i, true);
            }
        }
        HashSet d4 = this.T.d();
        if (d4 != null) {
            Iterator it4 = d4.iterator();
            while (it4.hasNext()) {
                ((ConstraintAnchor) it4.next()).d.e(dVar, dVar2, hashSet, i, true);
            }
        }
        HashSet d5 = this.U.d();
        if (d5 != null) {
            Iterator it5 = d5.iterator();
            while (it5.hasNext()) {
                ((ConstraintAnchor) it5.next()).d.e(dVar, dVar2, hashSet, i, true);
            }
        }
    }

    public boolean e0() {
        return (this.l == -1 && this.m == -1) ? false : true;
    }

    public void e1(int i) {
        if (i < 0) {
            this.o0 = 0;
        } else {
            this.o0 = i;
        }
    }

    boolean f() {
        return (this instanceof i) || (this instanceof f);
    }

    public boolean f0(int i, int i2) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i == 0) {
            ConstraintAnchor constraintAnchor3 = this.Q.f;
            return constraintAnchor3 != null && constraintAnchor3.n() && (constraintAnchor2 = this.S.f) != null && constraintAnchor2.n() && (this.S.f.e() - this.S.f()) - (this.Q.f.e() + this.Q.f()) >= i2;
        }
        ConstraintAnchor constraintAnchor4 = this.R.f;
        return constraintAnchor4 != null && constraintAnchor4.n() && (constraintAnchor = this.T.f) != null && constraintAnchor.n() && (this.T.f.e() - this.T.f()) - (this.R.f.e() + this.R.f()) >= i2;
        return false;
    }

    public void f1(int i, int i2) {
        this.h0 = i;
        this.i0 = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x044b  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x04c3  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x04c8  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0563  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x05af  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x05dd  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0566  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x04c5  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x04af  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0390  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x03e7  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x03ea  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x019f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void g(androidx.constraintlayout.core.d r54, boolean r55) {
        /*
            Method dump skipped, instructions count: 1539
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.g(androidx.constraintlayout.core.d, boolean):void");
    }

    public void g0(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i, int i2) {
        q(type).b(constraintWidget.q(type2), i, i2, true);
    }

    public void g1(ConstraintWidget constraintWidget) {
        this.c0 = constraintWidget;
    }

    public boolean h() {
        return this.u0 != 8;
    }

    public void h1(float f) {
        this.r0 = f;
    }

    public boolean i0() {
        return this.r;
    }

    public void i1(int i) {
        this.K0 = i;
    }

    public void j(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2) {
        k(type, constraintWidget, type2, 0);
    }

    public boolean j0(int i) {
        return this.a0[i];
    }

    public void j1(int i, int i2) {
        this.i0 = i;
        int i3 = i2 - i;
        this.e0 = i3;
        int i4 = this.p0;
        if (i3 < i4) {
            this.e0 = i4;
        }
    }

    public void k(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i) {
        ConstraintAnchor.Type type3;
        ConstraintAnchor.Type type4;
        boolean z;
        ConstraintAnchor.Type type5 = ConstraintAnchor.Type.CENTER;
        if (type == type5) {
            if (type2 != type5) {
                ConstraintAnchor.Type type6 = ConstraintAnchor.Type.LEFT;
                if (type2 == type6 || type2 == ConstraintAnchor.Type.RIGHT) {
                    k(type6, constraintWidget, type2, 0);
                    k(ConstraintAnchor.Type.RIGHT, constraintWidget, type2, 0);
                    q(type5).a(constraintWidget.q(type2), 0);
                    return;
                }
                ConstraintAnchor.Type type7 = ConstraintAnchor.Type.TOP;
                if (type2 == type7 || type2 == ConstraintAnchor.Type.BOTTOM) {
                    k(type7, constraintWidget, type2, 0);
                    k(ConstraintAnchor.Type.BOTTOM, constraintWidget, type2, 0);
                    q(type5).a(constraintWidget.q(type2), 0);
                    return;
                }
                return;
            }
            ConstraintAnchor.Type type8 = ConstraintAnchor.Type.LEFT;
            ConstraintAnchor q = q(type8);
            ConstraintAnchor.Type type9 = ConstraintAnchor.Type.RIGHT;
            ConstraintAnchor q2 = q(type9);
            ConstraintAnchor.Type type10 = ConstraintAnchor.Type.TOP;
            ConstraintAnchor q3 = q(type10);
            ConstraintAnchor.Type type11 = ConstraintAnchor.Type.BOTTOM;
            ConstraintAnchor q4 = q(type11);
            boolean z2 = true;
            if ((q == null || !q.o()) && (q2 == null || !q2.o())) {
                k(type8, constraintWidget, type8, 0);
                k(type9, constraintWidget, type9, 0);
                z = true;
            } else {
                z = false;
            }
            if ((q3 == null || !q3.o()) && (q4 == null || !q4.o())) {
                k(type10, constraintWidget, type10, 0);
                k(type11, constraintWidget, type11, 0);
            } else {
                z2 = false;
            }
            if (z && z2) {
                q(type5).a(constraintWidget.q(type5), 0);
                return;
            }
            if (z) {
                ConstraintAnchor.Type type12 = ConstraintAnchor.Type.CENTER_X;
                q(type12).a(constraintWidget.q(type12), 0);
                return;
            } else {
                if (z2) {
                    ConstraintAnchor.Type type13 = ConstraintAnchor.Type.CENTER_Y;
                    q(type13).a(constraintWidget.q(type13), 0);
                    return;
                }
                return;
            }
        }
        ConstraintAnchor.Type type14 = ConstraintAnchor.Type.CENTER_X;
        if (type == type14 && (type2 == (type4 = ConstraintAnchor.Type.LEFT) || type2 == ConstraintAnchor.Type.RIGHT)) {
            ConstraintAnchor q5 = q(type4);
            ConstraintAnchor q6 = constraintWidget.q(type2);
            ConstraintAnchor q7 = q(ConstraintAnchor.Type.RIGHT);
            q5.a(q6, 0);
            q7.a(q6, 0);
            q(type14).a(q6, 0);
            return;
        }
        ConstraintAnchor.Type type15 = ConstraintAnchor.Type.CENTER_Y;
        if (type == type15 && (type2 == (type3 = ConstraintAnchor.Type.TOP) || type2 == ConstraintAnchor.Type.BOTTOM)) {
            ConstraintAnchor q8 = constraintWidget.q(type2);
            q(type3).a(q8, 0);
            q(ConstraintAnchor.Type.BOTTOM).a(q8, 0);
            q(type15).a(q8, 0);
            return;
        }
        if (type == type14 && type2 == type14) {
            ConstraintAnchor.Type type16 = ConstraintAnchor.Type.LEFT;
            q(type16).a(constraintWidget.q(type16), 0);
            ConstraintAnchor.Type type17 = ConstraintAnchor.Type.RIGHT;
            q(type17).a(constraintWidget.q(type17), 0);
            q(type14).a(constraintWidget.q(type2), 0);
            return;
        }
        if (type == type15 && type2 == type15) {
            ConstraintAnchor.Type type18 = ConstraintAnchor.Type.TOP;
            q(type18).a(constraintWidget.q(type18), 0);
            ConstraintAnchor.Type type19 = ConstraintAnchor.Type.BOTTOM;
            q(type19).a(constraintWidget.q(type19), 0);
            q(type15).a(constraintWidget.q(type2), 0);
            return;
        }
        ConstraintAnchor q9 = q(type);
        ConstraintAnchor q10 = constraintWidget.q(type2);
        if (q9.p(q10)) {
            ConstraintAnchor.Type type20 = ConstraintAnchor.Type.BASELINE;
            if (type == type20) {
                ConstraintAnchor q11 = q(ConstraintAnchor.Type.TOP);
                ConstraintAnchor q12 = q(ConstraintAnchor.Type.BOTTOM);
                if (q11 != null) {
                    q11.q();
                }
                if (q12 != null) {
                    q12.q();
                }
            } else if (type == ConstraintAnchor.Type.TOP || type == ConstraintAnchor.Type.BOTTOM) {
                ConstraintAnchor q13 = q(type20);
                if (q13 != null) {
                    q13.q();
                }
                ConstraintAnchor q14 = q(type5);
                if (q14.j() != q10) {
                    q14.q();
                }
                ConstraintAnchor g = q(type).g();
                ConstraintAnchor q15 = q(type15);
                if (q15.o()) {
                    g.q();
                    q15.q();
                }
            } else if (type == ConstraintAnchor.Type.LEFT || type == ConstraintAnchor.Type.RIGHT) {
                ConstraintAnchor q16 = q(type5);
                if (q16.j() != q10) {
                    q16.q();
                }
                ConstraintAnchor g2 = q(type).g();
                ConstraintAnchor q17 = q(type14);
                if (q17.o()) {
                    g2.q();
                    q17.q();
                }
            }
            q9.a(q10, i);
        }
    }

    public boolean k0() {
        ConstraintAnchor constraintAnchor = this.Q;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f;
        if (constraintAnchor2 != null && constraintAnchor2.f == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.S;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f;
        return constraintAnchor4 != null && constraintAnchor4.f == constraintAnchor3;
    }

    public void k1(DimensionBehaviour dimensionBehaviour) {
        this.b0[1] = dimensionBehaviour;
    }

    public void l(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i) {
        if (constraintAnchor.h() == this) {
            k(constraintAnchor.k(), constraintAnchor2.h(), constraintAnchor2.k(), i);
        }
    }

    public boolean l0() {
        return this.M;
    }

    public void l1(int i, int i2, int i3, float f) {
        this.x = i;
        this.C = i2;
        if (i3 == Integer.MAX_VALUE) {
            i3 = 0;
        }
        this.D = i3;
        this.E = f;
        if (f <= 0.0f || f >= 1.0f || i != 0) {
            return;
        }
        this.x = 2;
    }

    public void m(ConstraintWidget constraintWidget, float f, int i) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.CENTER;
        g0(type, constraintWidget, type, i, 0);
        this.K = f;
    }

    public boolean m0() {
        ConstraintAnchor constraintAnchor = this.R;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f;
        if (constraintAnchor2 != null && constraintAnchor2.f == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.T;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f;
        return constraintAnchor4 != null && constraintAnchor4.f == constraintAnchor3;
    }

    public void m1(float f) {
        this.N0[1] = f;
    }

    public void n(ConstraintWidget constraintWidget, HashMap hashMap) {
        this.t = constraintWidget.t;
        this.u = constraintWidget.u;
        this.w = constraintWidget.w;
        this.x = constraintWidget.x;
        int[] iArr = this.y;
        int[] iArr2 = constraintWidget.y;
        iArr[0] = iArr2[0];
        iArr[1] = iArr2[1];
        this.z = constraintWidget.z;
        this.A = constraintWidget.A;
        this.C = constraintWidget.C;
        this.D = constraintWidget.D;
        this.E = constraintWidget.E;
        this.F = constraintWidget.F;
        this.G = constraintWidget.G;
        this.H = constraintWidget.H;
        this.I = constraintWidget.I;
        int[] iArr3 = constraintWidget.J;
        this.J = Arrays.copyOf(iArr3, iArr3.length);
        this.K = constraintWidget.K;
        this.L = constraintWidget.L;
        this.M = constraintWidget.M;
        this.Q.q();
        this.R.q();
        this.S.q();
        this.T.q();
        this.U.q();
        this.V.q();
        this.W.q();
        this.X.q();
        this.b0 = (DimensionBehaviour[]) Arrays.copyOf(this.b0, 2);
        this.c0 = this.c0 == null ? null : (ConstraintWidget) hashMap.get(constraintWidget.c0);
        this.d0 = constraintWidget.d0;
        this.e0 = constraintWidget.e0;
        this.f0 = constraintWidget.f0;
        this.g0 = constraintWidget.g0;
        this.h0 = constraintWidget.h0;
        this.i0 = constraintWidget.i0;
        this.j0 = constraintWidget.j0;
        this.k0 = constraintWidget.k0;
        this.l0 = constraintWidget.l0;
        this.m0 = constraintWidget.m0;
        this.n0 = constraintWidget.n0;
        this.o0 = constraintWidget.o0;
        this.p0 = constraintWidget.p0;
        this.q0 = constraintWidget.q0;
        this.r0 = constraintWidget.r0;
        this.s0 = constraintWidget.s0;
        this.t0 = constraintWidget.t0;
        this.u0 = constraintWidget.u0;
        this.v0 = constraintWidget.v0;
        this.w0 = constraintWidget.w0;
        this.x0 = constraintWidget.x0;
        this.y0 = constraintWidget.y0;
        this.z0 = constraintWidget.z0;
        this.A0 = constraintWidget.A0;
        this.B0 = constraintWidget.B0;
        this.C0 = constraintWidget.C0;
        this.D0 = constraintWidget.D0;
        this.E0 = constraintWidget.E0;
        this.F0 = constraintWidget.F0;
        this.G0 = constraintWidget.G0;
        this.H0 = constraintWidget.H0;
        this.J0 = constraintWidget.J0;
        this.K0 = constraintWidget.K0;
        this.L0 = constraintWidget.L0;
        this.M0 = constraintWidget.M0;
        float[] fArr = this.N0;
        float[] fArr2 = constraintWidget.N0;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        ConstraintWidget[] constraintWidgetArr = this.O0;
        ConstraintWidget[] constraintWidgetArr2 = constraintWidget.O0;
        constraintWidgetArr[0] = constraintWidgetArr2[0];
        constraintWidgetArr[1] = constraintWidgetArr2[1];
        ConstraintWidget[] constraintWidgetArr3 = this.P0;
        ConstraintWidget[] constraintWidgetArr4 = constraintWidget.P0;
        constraintWidgetArr3[0] = constraintWidgetArr4[0];
        constraintWidgetArr3[1] = constraintWidgetArr4[1];
        ConstraintWidget constraintWidget2 = constraintWidget.Q0;
        this.Q0 = constraintWidget2 == null ? null : (ConstraintWidget) hashMap.get(constraintWidget2);
        ConstraintWidget constraintWidget3 = constraintWidget.R0;
        this.R0 = constraintWidget3 != null ? (ConstraintWidget) hashMap.get(constraintWidget3) : null;
    }

    public boolean n0() {
        return this.N;
    }

    public void n1(int i) {
        this.u0 = i;
    }

    public void o(d dVar) {
        dVar.q(this.Q);
        dVar.q(this.R);
        dVar.q(this.S);
        dVar.q(this.T);
        if (this.n0 > 0) {
            dVar.q(this.U);
        }
    }

    public boolean o0() {
        return this.i && this.u0 != 8;
    }

    public void o1(int i) {
        this.d0 = i;
        int i2 = this.o0;
        if (i < i2) {
            this.d0 = i2;
        }
    }

    public void p() {
        if (this.e == null) {
            this.e = new j(this);
        }
        if (this.f == null) {
            this.f = new l(this);
        }
    }

    public boolean p0() {
        return this.p || (this.Q.n() && this.S.n());
    }

    public void p1(int i) {
        if (i < 0 || i > 3) {
            return;
        }
        this.v = i;
    }

    public ConstraintAnchor q(ConstraintAnchor.Type type) {
        switch (a.a[type.ordinal()]) {
            case 1:
                return this.Q;
            case 2:
                return this.R;
            case 3:
                return this.S;
            case 4:
                return this.T;
            case 5:
                return this.U;
            case 6:
                return this.X;
            case 7:
                return this.V;
            case 8:
                return this.W;
            case 9:
                return null;
            default:
                throw new AssertionError(type.name());
        }
    }

    public boolean q0() {
        return this.q || (this.R.n() && this.T.n());
    }

    public void q1(int i) {
        this.h0 = i;
    }

    public int r() {
        return this.n0;
    }

    public boolean r0() {
        return this.s;
    }

    public void r1(int i) {
        this.i0 = i;
    }

    public float s(int i) {
        if (i == 0) {
            return this.q0;
        }
        if (i == 1) {
            return this.r0;
        }
        return -1.0f;
    }

    public void s0() {
        this.r = true;
    }

    public void s1(boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.H == -1) {
            if (z3 && !z4) {
                this.H = 0;
            } else if (!z3 && z4) {
                this.H = 1;
                if (this.g0 == -1) {
                    this.I = 1.0f / this.I;
                }
            }
        }
        if (this.H == 0 && (!this.R.o() || !this.T.o())) {
            this.H = 1;
        } else if (this.H == 1 && (!this.Q.o() || !this.S.o())) {
            this.H = 0;
        }
        if (this.H == -1 && (!this.R.o() || !this.T.o() || !this.Q.o() || !this.S.o())) {
            if (this.R.o() && this.T.o()) {
                this.H = 0;
            } else if (this.Q.o() && this.S.o()) {
                this.I = 1.0f / this.I;
                this.H = 1;
            }
        }
        if (this.H == -1) {
            int i = this.z;
            if (i > 0 && this.C == 0) {
                this.H = 0;
            } else {
                if (i != 0 || this.C <= 0) {
                    return;
                }
                this.I = 1.0f / this.I;
                this.H = 1;
            }
        }
    }

    public int t() {
        return a0() + this.e0;
    }

    public void t0() {
        this.s = true;
    }

    public void t1(boolean z, boolean z2) {
        int i;
        int i2;
        boolean k = z & this.e.k();
        boolean k2 = z2 & this.f.k();
        j jVar = this.e;
        int i3 = jVar.h.g;
        l lVar = this.f;
        int i4 = lVar.h.g;
        int i6 = jVar.i.g;
        int i7 = lVar.i.g;
        int i8 = i7 - i4;
        if (i6 - i3 < 0 || i8 < 0 || i3 == Integer.MIN_VALUE || i3 == Integer.MAX_VALUE || i4 == Integer.MIN_VALUE || i4 == Integer.MAX_VALUE || i6 == Integer.MIN_VALUE || i6 == Integer.MAX_VALUE || i7 == Integer.MIN_VALUE || i7 == Integer.MAX_VALUE) {
            i6 = 0;
            i3 = 0;
            i7 = 0;
            i4 = 0;
        }
        int i9 = i6 - i3;
        int i10 = i7 - i4;
        if (k) {
            this.h0 = i3;
        }
        if (k2) {
            this.i0 = i4;
        }
        if (this.u0 == 8) {
            this.d0 = 0;
            this.e0 = 0;
            return;
        }
        if (k) {
            if (this.b0[0] == DimensionBehaviour.FIXED && i9 < (i2 = this.d0)) {
                i9 = i2;
            }
            this.d0 = i9;
            int i11 = this.o0;
            if (i9 < i11) {
                this.d0 = i11;
            }
        }
        if (k2) {
            if (this.b0[1] == DimensionBehaviour.FIXED && i10 < (i = this.e0)) {
                i10 = i;
            }
            this.e0 = i10;
            int i12 = this.p0;
            if (i10 < i12) {
                this.e0 = i12;
            }
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (this.x0 != null) {
            str = "type: " + this.x0 + " ";
        } else {
            str = "";
        }
        sb.append(str);
        if (this.w0 != null) {
            str2 = "id: " + this.w0 + " ";
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.h0);
        sb.append(", ");
        sb.append(this.i0);
        sb.append(") - (");
        sb.append(this.d0);
        sb.append(" x ");
        sb.append(this.e0);
        sb.append(")");
        return sb.toString();
    }

    public Object u() {
        return this.s0;
    }

    public boolean u0() {
        DimensionBehaviour[] dimensionBehaviourArr = this.b0;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.MATCH_CONSTRAINT;
        return dimensionBehaviour == dimensionBehaviour2 && dimensionBehaviourArr[1] == dimensionBehaviour2;
    }

    public void u1(d dVar, boolean z) {
        l lVar;
        j jVar;
        int y = dVar.y(this.Q);
        int y2 = dVar.y(this.R);
        int y3 = dVar.y(this.S);
        int y4 = dVar.y(this.T);
        if (z && (jVar = this.e) != null) {
            DependencyNode dependencyNode = jVar.h;
            if (dependencyNode.j) {
                DependencyNode dependencyNode2 = jVar.i;
                if (dependencyNode2.j) {
                    y = dependencyNode.g;
                    y3 = dependencyNode2.g;
                }
            }
        }
        if (z && (lVar = this.f) != null) {
            DependencyNode dependencyNode3 = lVar.h;
            if (dependencyNode3.j) {
                DependencyNode dependencyNode4 = lVar.i;
                if (dependencyNode4.j) {
                    y2 = dependencyNode3.g;
                    y4 = dependencyNode4.g;
                }
            }
        }
        int i = y4 - y2;
        if (y3 - y < 0 || i < 0 || y == Integer.MIN_VALUE || y == Integer.MAX_VALUE || y2 == Integer.MIN_VALUE || y2 == Integer.MAX_VALUE || y3 == Integer.MIN_VALUE || y3 == Integer.MAX_VALUE || y4 == Integer.MIN_VALUE || y4 == Integer.MAX_VALUE) {
            y = 0;
            y4 = 0;
            y2 = 0;
            y3 = 0;
        }
        N0(y, y2, y3, y4);
    }

    public String v() {
        return this.w0;
    }

    public void v0() {
        this.Q.q();
        this.R.q();
        this.S.q();
        this.T.q();
        this.U.q();
        this.V.q();
        this.W.q();
        this.X.q();
        this.c0 = null;
        this.K = 0.0f;
        this.d0 = 0;
        this.e0 = 0;
        this.f0 = 0.0f;
        this.g0 = -1;
        this.h0 = 0;
        this.i0 = 0;
        this.l0 = 0;
        this.m0 = 0;
        this.n0 = 0;
        this.o0 = 0;
        this.p0 = 0;
        float f = U0;
        this.q0 = f;
        this.r0 = f;
        DimensionBehaviour[] dimensionBehaviourArr = this.b0;
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        dimensionBehaviourArr[0] = dimensionBehaviour;
        dimensionBehaviourArr[1] = dimensionBehaviour;
        this.s0 = null;
        this.t0 = 0;
        this.u0 = 0;
        this.x0 = null;
        this.G0 = false;
        this.H0 = false;
        this.J0 = 0;
        this.K0 = 0;
        this.L0 = false;
        this.M0 = false;
        float[] fArr = this.N0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.t = -1;
        this.u = -1;
        int[] iArr = this.J;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.w = 0;
        this.x = 0;
        this.B = 1.0f;
        this.E = 1.0f;
        this.A = Integer.MAX_VALUE;
        this.D = Integer.MAX_VALUE;
        this.z = 0;
        this.C = 0;
        this.h = false;
        this.H = -1;
        this.I = 1.0f;
        this.I0 = false;
        boolean[] zArr = this.g;
        zArr[0] = true;
        zArr[1] = true;
        this.N = false;
        boolean[] zArr2 = this.a0;
        zArr2[0] = false;
        zArr2[1] = false;
        this.i = true;
        int[] iArr2 = this.y;
        iArr2[0] = 0;
        iArr2[1] = 0;
        this.l = -1;
        this.m = -1;
    }

    public DimensionBehaviour w(int i) {
        if (i == 0) {
            return C();
        }
        if (i == 1) {
            return V();
        }
        return null;
    }

    public void w0() {
        x0();
        h1(U0);
        Q0(U0);
    }

    public float x() {
        return this.f0;
    }

    public void x0() {
        ConstraintWidget M = M();
        if (M != null && (M instanceof d) && M().Q1()) {
            return;
        }
        int size = this.Z.size();
        for (int i = 0; i < size; i++) {
            ((ConstraintAnchor) this.Z.get(i)).q();
        }
    }

    public int y() {
        return this.g0;
    }

    public void y0() {
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = false;
        int size = this.Z.size();
        for (int i = 0; i < size; i++) {
            ((ConstraintAnchor) this.Z.get(i)).r();
        }
    }

    public int z() {
        if (this.u0 == 8) {
            return 0;
        }
        return this.e0;
    }

    public void z0(androidx.constraintlayout.core.c cVar) {
        this.Q.s(cVar);
        this.R.s(cVar);
        this.S.s(cVar);
        this.T.s(cVar);
        this.U.s(cVar);
        this.X.s(cVar);
        this.V.s(cVar);
        this.W.s(cVar);
    }
}
