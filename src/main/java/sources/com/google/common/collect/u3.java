package com.google.common.collect;

import java.util.Set;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public interface u3 {
    /* renamed from: asRanges */
    Set mo21asRanges();

    u3 complement();

    boolean encloses(Range range);

    boolean isEmpty();

    void removeAll(u3 u3Var);
}
