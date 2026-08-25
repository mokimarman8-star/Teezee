package com.amazonaws.services.s3.model.lifecycle;

import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class LifecycleAndOperator extends LifecycleNAryOperator {
    public LifecycleAndOperator(List<LifecycleFilterPredicate> list) {
        super(list);
    }

    @Override // com.amazonaws.services.s3.model.lifecycle.LifecycleFilterPredicate
    public void accept(LifecyclePredicateVisitor lifecyclePredicateVisitor) {
        lifecyclePredicateVisitor.c(this);
    }

    @Override // com.amazonaws.services.s3.model.lifecycle.LifecycleNAryOperator
    public /* bridge */ /* synthetic */ List getOperands() {
        return super.getOperands();
    }
}
