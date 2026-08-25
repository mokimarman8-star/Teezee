package com.amazonaws.services.s3.model.lifecycle;

import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
abstract class LifecycleNAryOperator extends LifecycleFilterPredicate {
    private final List<LifecycleFilterPredicate> operands;

    public LifecycleNAryOperator(List<LifecycleFilterPredicate> list) {
        this.operands = list;
    }

    public List<LifecycleFilterPredicate> getOperands() {
        return this.operands;
    }
}
