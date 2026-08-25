package androidx.constraintlayout.core;

import androidx.constraintlayout.core.b;
import java.util.Arrays;
import java.util.Comparator;
import org.mvel2.ast.ASTNode;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class PriorityGoalRow extends b {
    private int g;
    private SolverVariable[] h;
    private SolverVariable[] i;
    private int j;
    a k;
    c l;

    public PriorityGoalRow(c cVar) {
        super(cVar);
        this.g = ASTNode.ASSIGN;
        this.h = new SolverVariable[ASTNode.ASSIGN];
        this.i = new SolverVariable[ASTNode.ASSIGN];
        this.j = 0;
        this.k = new a(this, this);
        this.l = cVar;
    }

    private final void F(SolverVariable solverVariable) {
        int i;
        int i2 = this.j + 1;
        SolverVariable[] solverVariableArr = this.h;
        if (i2 > solverVariableArr.length) {
            SolverVariable[] solverVariableArr2 = (SolverVariable[]) Arrays.copyOf(solverVariableArr, solverVariableArr.length * 2);
            this.h = solverVariableArr2;
            this.i = (SolverVariable[]) Arrays.copyOf(solverVariableArr2, solverVariableArr2.length * 2);
        }
        SolverVariable[] solverVariableArr3 = this.h;
        int i3 = this.j;
        solverVariableArr3[i3] = solverVariable;
        int i4 = i3 + 1;
        this.j = i4;
        if (i4 > 1 && solverVariableArr3[i3].c > solverVariable.c) {
            int i6 = 0;
            while (true) {
                i = this.j;
                if (i6 >= i) {
                    break;
                }
                this.i[i6] = this.h[i6];
                i6++;
            }
            Arrays.sort(this.i, 0, i, new Comparator<SolverVariable>() { // from class: androidx.constraintlayout.core.PriorityGoalRow.1
                @Override // java.util.Comparator
                public int compare(SolverVariable solverVariable2, SolverVariable solverVariable3) {
                    return solverVariable2.c - solverVariable3.c;
                }
            });
            for (int i7 = 0; i7 < this.j; i7++) {
                this.h[i7] = this.i[i7];
            }
        }
        solverVariable.a = true;
        solverVariable.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(SolverVariable solverVariable) {
        int i = 0;
        while (i < this.j) {
            if (this.h[i] == solverVariable) {
                while (true) {
                    int i2 = this.j;
                    if (i >= i2 - 1) {
                        this.j = i2 - 1;
                        solverVariable.a = false;
                        return;
                    } else {
                        SolverVariable[] solverVariableArr = this.h;
                        int i3 = i + 1;
                        solverVariableArr[i] = solverVariableArr[i3];
                        i = i3;
                    }
                }
            } else {
                i++;
            }
        }
    }

    public void B(d dVar, b bVar, boolean z) {
        SolverVariable solverVariable = bVar.a;
        if (solverVariable == null) {
            return;
        }
        b.a aVar = bVar.e;
        int currentSize = aVar.getCurrentSize();
        for (int i = 0; i < currentSize; i++) {
            SolverVariable b = aVar.b(i);
            float h = aVar.h(i);
            this.k.b(b);
            if (this.k.a(solverVariable, h)) {
                F(b);
            }
            ((b) this).b += bVar.b * h;
        }
        G(solverVariable);
    }

    public SolverVariable b(d dVar, boolean[] zArr) {
        int i = -1;
        for (int i2 = 0; i2 < this.j; i2++) {
            SolverVariable solverVariable = this.h[i2];
            if (!zArr[solverVariable.c]) {
                this.k.b(solverVariable);
                if (i == -1) {
                    if (!this.k.c()) {
                    }
                    i = i2;
                } else {
                    if (!this.k.d(this.h[i])) {
                    }
                    i = i2;
                }
            }
        }
        if (i == -1) {
            return null;
        }
        return this.h[i];
    }

    public void c(SolverVariable solverVariable) {
        this.k.b(solverVariable);
        this.k.e();
        solverVariable.i[solverVariable.e] = 1.0f;
        F(solverVariable);
    }

    public void clear() {
        this.j = 0;
        ((b) this).b = 0.0f;
    }

    public boolean isEmpty() {
        return this.j == 0;
    }

    public String toString() {
        String str = " goal -> (" + ((b) this).b + ") : ";
        for (int i = 0; i < this.j; i++) {
            this.k.b(this.h[i]);
            str = str + this.k + " ";
        }
        return str;
    }
}
