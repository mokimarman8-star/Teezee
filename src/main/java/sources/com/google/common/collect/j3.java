package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public interface j3 {
    Map asMap();

    void clear();

    boolean containsEntry(Object obj, Object obj2);

    boolean containsKey(Object obj);

    /* renamed from: entries */
    Collection mo8entries();

    /* renamed from: get */
    Collection mo9get(Object obj);

    boolean isEmpty();

    /* renamed from: keySet */
    Set mo10keySet();

    boolean put(Object obj, Object obj2);

    boolean putAll(j3 j3Var);

    boolean remove(Object obj, Object obj2);

    /* renamed from: removeAll */
    Collection mo11removeAll(Object obj);

    int size();

    /* renamed from: values */
    Collection mo13values();
}
