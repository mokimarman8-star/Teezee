package com.google.common.collect;

import java.util.Map;
import java.util.Set;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public interface c4 {

    public interface a {
        Object getColumnKey();

        Object getRowKey();

        Object getValue();
    }

    /* renamed from: cellSet */
    Set mo29cellSet();

    /* renamed from: columnKeySet */
    Set mo0columnKeySet();

    Map columnMap();

    Object get(Object obj, Object obj2);

    Object put(Object obj, Object obj2, Object obj3);

    /* renamed from: rowKeySet */
    Set mo1rowKeySet();

    Map rowMap();

    int size();
}
