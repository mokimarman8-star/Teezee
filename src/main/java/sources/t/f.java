package t;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMutableCollection;
import kotlin.jvm.internal.markers.KMutableList;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public interface f extends d, b {

    public interface a extends List, Collection, KMutableCollection, KMutableList {
        f build();
    }

    @Override // java.util.List
    f add(int i5, Object obj);

    @Override // java.util.List, java.util.Collection
    f add(Object obj);

    @Override // java.util.List, java.util.Collection
    f addAll(Collection collection);

    a builder();

    f d(int i5);

    f k(Function1 function1);

    @Override // java.util.List, java.util.Collection
    f remove(Object obj);

    @Override // java.util.List, java.util.Collection
    f removeAll(Collection collection);

    @Override // java.util.List
    f set(int i5, Object obj);
}
