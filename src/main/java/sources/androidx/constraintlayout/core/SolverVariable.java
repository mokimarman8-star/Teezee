package androidx.constraintlayout.core;

import java.util.Arrays;
import java.util.HashSet;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class SolverVariable implements Comparable {
    private static int r = 1;
    public boolean a;
    private String b;
    public float f;
    Type j;
    public int c = -1;
    int d = -1;
    public int e = 0;
    public boolean g = false;
    float[] h = new float[9];
    float[] i = new float[9];
    b[] k = new b[16];
    int l = 0;
    public int m = 0;
    boolean n = false;
    int o = -1;
    float p = 0.0f;
    HashSet q = null;

    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public SolverVariable(Type type, String str) {
        this.j = type;
    }

    static void d() {
        r++;
    }

    public final void a(b bVar) {
        int i = 0;
        while (true) {
            int i2 = this.l;
            if (i >= i2) {
                b[] bVarArr = this.k;
                if (i2 >= bVarArr.length) {
                    this.k = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.k;
                int i3 = this.l;
                bVarArr2[i3] = bVar;
                this.l = i3 + 1;
                return;
            }
            if (this.k[i] == bVar) {
                return;
            } else {
                i++;
            }
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(SolverVariable solverVariable) {
        return this.c - solverVariable.c;
    }

    public final void e(b bVar) {
        int i = this.l;
        int i2 = 0;
        while (i2 < i) {
            if (this.k[i2] == bVar) {
                while (i2 < i - 1) {
                    b[] bVarArr = this.k;
                    int i3 = i2 + 1;
                    bVarArr[i2] = bVarArr[i3];
                    i2 = i3;
                }
                this.l--;
                return;
            }
            i2++;
        }
    }

    public void f() {
        this.b = null;
        this.j = Type.UNKNOWN;
        this.e = 0;
        this.c = -1;
        this.d = -1;
        this.f = 0.0f;
        this.g = false;
        this.n = false;
        this.o = -1;
        this.p = 0.0f;
        int i = this.l;
        for (int i2 = 0; i2 < i; i2++) {
            this.k[i2] = null;
        }
        this.l = 0;
        this.m = 0;
        this.a = false;
        Arrays.fill(this.i, 0.0f);
    }

    public void g(d dVar, float f) {
        this.f = f;
        this.g = true;
        this.n = false;
        this.o = -1;
        this.p = 0.0f;
        int i = this.l;
        this.d = -1;
        for (int i2 = 0; i2 < i; i2++) {
            this.k[i2].A(dVar, this, false);
        }
        this.l = 0;
    }

    public void h(Type type, String str) {
        this.j = type;
    }

    public final void i(d dVar, b bVar) {
        int i = this.l;
        for (int i2 = 0; i2 < i; i2++) {
            this.k[i2].B(dVar, bVar, false);
        }
        this.l = 0;
    }

    public String toString() {
        if (this.b != null) {
            return "" + this.b;
        }
        return "" + this.c;
    }
}
