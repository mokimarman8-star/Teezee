package androidx.constraintlayout.core;

import java.util.Arrays;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class PriorityGoalRow$a {

    /* renamed from: a, reason: collision with root package name */
    SolverVariable f5586a;

    /* renamed from: b, reason: collision with root package name */
    PriorityGoalRow f5587b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ PriorityGoalRow f5588c;

    public PriorityGoalRow$a(PriorityGoalRow priorityGoalRow, PriorityGoalRow priorityGoalRow2) {
        this.f5588c = priorityGoalRow;
        this.f5587b = priorityGoalRow2;
    }

    public boolean a(SolverVariable solverVariable, float f5) {
        boolean z5 = true;
        if (!this.f5586a.a) {
            for (int i5 = 0; i5 < 9; i5++) {
                float f6 = solverVariable.i[i5];
                if (f6 != 0.0f) {
                    float f7 = f6 * f5;
                    if (Math.abs(f7) < 1.0E-4f) {
                        f7 = 0.0f;
                    }
                    this.f5586a.i[i5] = f7;
                } else {
                    this.f5586a.i[i5] = 0.0f;
                }
            }
            return true;
        }
        for (int i6 = 0; i6 < 9; i6++) {
            float[] fArr = this.f5586a.i;
            float f8 = fArr[i6] + (solverVariable.i[i6] * f5);
            fArr[i6] = f8;
            if (Math.abs(f8) < 1.0E-4f) {
                this.f5586a.i[i6] = 0.0f;
            } else {
                z5 = false;
            }
        }
        if (z5) {
            PriorityGoalRow.E(this.f5588c, this.f5586a);
        }
        return false;
    }

    public void b(SolverVariable solverVariable) {
        this.f5586a = solverVariable;
    }

    public final boolean c() {
        for (int i5 = 8; i5 >= 0; i5--) {
            float f5 = this.f5586a.i[i5];
            if (f5 > 0.0f) {
                return false;
            }
            if (f5 < 0.0f) {
                return true;
            }
        }
        return false;
    }

    public final boolean d(SolverVariable solverVariable) {
        int i5 = 8;
        while (true) {
            if (i5 < 0) {
                break;
            }
            float f5 = solverVariable.i[i5];
            float f6 = this.f5586a.i[i5];
            if (f6 == f5) {
                i5--;
            } else if (f6 < f5) {
                return true;
            }
        }
        return false;
    }

    public void e() {
        Arrays.fill(this.f5586a.i, 0.0f);
    }

    public String toString() {
        String str = "[ ";
        if (this.f5586a != null) {
            for (int i5 = 0; i5 < 9; i5++) {
                str = str + this.f5586a.i[i5] + " ";
            }
        }
        return str + "] " + this.f5586a;
    }
}
