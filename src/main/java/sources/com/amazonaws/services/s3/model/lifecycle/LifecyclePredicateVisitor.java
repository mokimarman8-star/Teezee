package com.amazonaws.services.s3.model.lifecycle;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public interface LifecyclePredicateVisitor {
    void a(LifecyclePrefixPredicate lifecyclePrefixPredicate);

    void b(LifecycleTagPredicate lifecycleTagPredicate);

    void c(LifecycleAndOperator lifecycleAndOperator);
}
