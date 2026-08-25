package com.amazonaws.services.s3.model.lifecycle;

import java.io.Serializable;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class LifecycleFilterPredicate implements Serializable {
    public abstract void accept(LifecyclePredicateVisitor lifecyclePredicateVisitor);
}
