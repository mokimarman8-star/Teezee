package com.cloud.tmc.kernel.resolver;

import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface ResultResolver<T> {
    public static final ResultResolver<Boolean> INTERSECTION_BOOL_RESOLVER = new BoolIntersectionResolver();
    public static final ResultResolver<Boolean> POSITIVE_RESOLVER = new BoolPositiveResolver();

    T resolve(List<T> list);
}
