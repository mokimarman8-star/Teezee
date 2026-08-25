package com.amazonaws.services.s3.model.analytics;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public interface AnalyticsPredicateVisitor {
    void a(AnalyticsPrefixPredicate analyticsPrefixPredicate);

    void b(AnalyticsTagPredicate analyticsTagPredicate);

    void c(AnalyticsAndOperator analyticsAndOperator);
}
