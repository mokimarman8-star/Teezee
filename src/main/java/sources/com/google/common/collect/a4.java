package com.google.common.collect;

import com.google.common.collect.l3;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public interface a4 extends l3, y3 {
    @Override // com.google.common.collect.y3
    Comparator comparator();

    a4 descendingMultiset();

    @Override // com.google.common.collect.l3
    /* renamed from: elementSet */
    NavigableSet mo15elementSet();

    @Override // com.google.common.collect.l3
    /* renamed from: entrySet */
    Set mo17entrySet();

    l3.a firstEntry();

    a4 headMultiset(Object obj, BoundType boundType);

    l3.a lastEntry();

    l3.a pollFirstEntry();

    l3.a pollLastEntry();

    a4 subMultiset(Object obj, BoundType boundType, Object obj2, BoundType boundType2);

    a4 tailMultiset(Object obj, BoundType boundType);
}
