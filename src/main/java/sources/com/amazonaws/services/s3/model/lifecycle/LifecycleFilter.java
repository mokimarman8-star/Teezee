package com.amazonaws.services.s3.model.lifecycle;

import java.io.Serializable;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class LifecycleFilter implements Serializable {
    private LifecycleFilterPredicate predicate;

    public LifecycleFilter() {
    }

    public LifecycleFilter(LifecycleFilterPredicate lifecycleFilterPredicate) {
        this.predicate = lifecycleFilterPredicate;
    }

    public LifecycleFilterPredicate getPredicate() {
        return this.predicate;
    }

    public void setPredicate(LifecycleFilterPredicate lifecycleFilterPredicate) {
        this.predicate = lifecycleFilterPredicate;
    }

    public LifecycleFilter withPredicate(LifecycleFilterPredicate lifecycleFilterPredicate) {
        setPredicate(lifecycleFilterPredicate);
        return this;
    }
}
