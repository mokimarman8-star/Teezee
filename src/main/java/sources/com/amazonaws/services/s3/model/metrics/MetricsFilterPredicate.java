package com.amazonaws.services.s3.model.metrics;

import java.io.Serializable;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class MetricsFilterPredicate implements Serializable {
    public abstract void accept(MetricsPredicateVisitor metricsPredicateVisitor);
}
