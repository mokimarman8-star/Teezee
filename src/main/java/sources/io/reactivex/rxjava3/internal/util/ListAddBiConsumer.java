package io.reactivex.rxjava3.internal.util;

import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public enum ListAddBiConsumer implements yx.c {
    INSTANCE;

    public static <T> yx.c instance() {
        return INSTANCE;
    }

    @Override // yx.c
    public List apply(List list, Object obj) {
        list.add(obj);
        return list;
    }
}
