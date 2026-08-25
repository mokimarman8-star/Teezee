package com.amazonaws.services.s3.model.analytics;

import java.io.Serializable;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class AnalyticsFilterPredicate implements Serializable {
    public abstract void accept(AnalyticsPredicateVisitor analyticsPredicateVisitor);
}
