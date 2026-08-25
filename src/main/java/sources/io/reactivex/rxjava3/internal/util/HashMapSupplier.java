package io.reactivex.rxjava3.internal.util;

import java.util.HashMap;
import java.util.Map;
import yx.k;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public enum HashMapSupplier implements k {
    INSTANCE;

    public static <K, V> k asSupplier() {
        return INSTANCE;
    }

    @Override // yx.k
    public Map<Object, Object> get() {
        return new HashMap();
    }
}
