package com.amazonaws.services.s3.model.analytics;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class AnalyticsPrefixPredicate extends AnalyticsFilterPredicate {
    private final String prefix;

    public AnalyticsPrefixPredicate(String str) {
        this.prefix = str;
    }

    @Override // com.amazonaws.services.s3.model.analytics.AnalyticsFilterPredicate
    public void accept(AnalyticsPredicateVisitor analyticsPredicateVisitor) {
        analyticsPredicateVisitor.a(this);
    }

    public String getPrefix() {
        return this.prefix;
    }
}
