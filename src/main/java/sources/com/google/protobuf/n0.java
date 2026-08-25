package com.google.protobuf;

import com.google.protobuf.m0;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
interface n0 {
    Map<?, ?> forMapData(Object obj);

    m0.b forMapMetadata(Object obj);

    Map<?, ?> forMutableMapData(Object obj);

    int getSerializedSize(int i, Object obj, Object obj2);

    boolean isImmutable(Object obj);

    Object mergeFrom(Object obj, Object obj2);

    Object newMapField(Object obj);

    Object toImmutable(Object obj);
}
