package io.reactivex.rxjava3.internal.util;

import java.util.ArrayList;
import java.util.List;
import yx.k;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public enum ArrayListSupplier implements k, yx.h {
    INSTANCE;

    public static <T, O> yx.h asFunction() {
        return INSTANCE;
    }

    public static <T> k asSupplier() {
        return INSTANCE;
    }

    @Override // yx.h
    public List<Object> apply(Object obj) {
        return new ArrayList();
    }

    @Override // yx.k
    public List<Object> get() {
        return new ArrayList();
    }
}
