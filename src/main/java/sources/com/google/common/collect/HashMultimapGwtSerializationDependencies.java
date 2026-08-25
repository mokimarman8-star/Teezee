package com.google.common.collect;

import java.util.Collection;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
abstract class HashMultimapGwtSerializationDependencies<K, V> extends AbstractSetMultimap<K, V> {
    HashMultimapGwtSerializationDependencies(Map<K, Collection<V>> map) {
        super(map);
    }
}
