package com.amazonaws.services.s3.model.metrics;

import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class MetricsAndOperator extends MetricsNAryOperator {
    public MetricsAndOperator(List<MetricsFilterPredicate> list) {
        super(list);
    }

    @Override // com.amazonaws.services.s3.model.metrics.MetricsFilterPredicate
    public void accept(MetricsPredicateVisitor metricsPredicateVisitor) {
        metricsPredicateVisitor.a(this);
    }

    @Override // com.amazonaws.services.s3.model.metrics.MetricsNAryOperator
    public /* bridge */ /* synthetic */ List getOperands() {
        return super.getOperands();
    }
}
