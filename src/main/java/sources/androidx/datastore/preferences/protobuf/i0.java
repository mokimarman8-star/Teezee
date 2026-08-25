package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.h0;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
interface i0 {
    Map forMapData(Object obj);

    h0.a forMapMetadata(Object obj);

    Map forMutableMapData(Object obj);

    int getSerializedSize(int i5, Object obj, Object obj2);

    boolean isImmutable(Object obj);

    Object mergeFrom(Object obj, Object obj2);

    Object newMapField(Object obj);

    Object toImmutable(Object obj);
}
