package com.amazonaws.services.s3.model.metrics;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public interface MetricsPredicateVisitor {
    void a(MetricsAndOperator metricsAndOperator);

    void b(MetricsTagPredicate metricsTagPredicate);

    void c(MetricsPrefixPredicate metricsPrefixPredicate);
}
