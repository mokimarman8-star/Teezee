package com.google.common.collect;

import java.util.Collection;
import java.util.Set;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public interface l3 extends Collection {

    public interface a {
        int getCount();

        Object getElement();

        String toString();
    }

    int add(Object obj, int i);

    @Override // java.util.Collection, com.google.common.collect.l3
    boolean contains(Object obj);

    @Override // java.util.Collection
    boolean containsAll(Collection collection);

    int count(Object obj);

    /* renamed from: elementSet */
    Set mo15elementSet();

    /* renamed from: entrySet */
    Set mo17entrySet();

    @Override // java.util.Collection
    boolean equals(Object obj);

    @Override // java.util.Collection
    int hashCode();

    int remove(Object obj, int i);

    @Override // java.util.Collection, com.google.common.collect.l3
    boolean remove(Object obj);

    int setCount(Object obj, int i);

    boolean setCount(Object obj, int i, int i2);

    @Override // java.util.Collection, com.google.common.collect.l3
    int size();
}
