package com.google.common.base;

import java.io.Serializable;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class FunctionalEquivalence<F, T> extends Equivalence implements Serializable {
    private static final long serialVersionUID = 0;
    private final f function;
    private final Equivalence resultEquivalence;

    FunctionalEquivalence(f fVar, Equivalence equivalence) {
        this.function = (f) m.o(fVar);
        this.resultEquivalence = (Equivalence) m.o(equivalence);
    }

    @Override // com.google.common.base.Equivalence
    protected boolean doEquivalent(F f, F f2) {
        return this.resultEquivalence.equivalent(this.function.apply(f), this.function.apply(f2));
    }

    @Override // com.google.common.base.Equivalence
    protected int doHash(F f) {
        return this.resultEquivalence.hash(this.function.apply(f));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FunctionalEquivalence)) {
            return false;
        }
        FunctionalEquivalence functionalEquivalence = (FunctionalEquivalence) obj;
        return this.function.equals(functionalEquivalence.function) && this.resultEquivalence.equals(functionalEquivalence.resultEquivalence);
    }

    public int hashCode() {
        return j.b(this.function, this.resultEquivalence);
    }

    public String toString() {
        return this.resultEquivalence + ".onResultOf(" + this.function + ")";
    }
}
