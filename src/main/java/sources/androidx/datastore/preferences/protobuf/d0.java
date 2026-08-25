package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.w;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class d0 implements c0 {
    d0() {
    }

    static w.d d(Object obj, long j5) {
        return (w.d) k1.G(obj, j5);
    }

    @Override // androidx.datastore.preferences.protobuf.c0
    public void a(Object obj, long j5) {
        d(obj, j5).makeImmutable();
    }

    @Override // androidx.datastore.preferences.protobuf.c0
    public void b(Object obj, Object obj2, long j5) {
        w.d d5 = d(obj, j5);
        w.d d6 = d(obj2, j5);
        int size = d5.size();
        int size2 = d6.size();
        if (size > 0 && size2 > 0) {
            if (!d5.isModifiable()) {
                d5 = d5.mutableCopyWithCapacity(size2 + size);
            }
            d5.addAll(d6);
        }
        if (size > 0) {
            d6 = d5;
        }
        k1.W(obj, j5, d6);
    }

    @Override // androidx.datastore.preferences.protobuf.c0
    public List c(Object obj, long j5) {
        w.d d5 = d(obj, j5);
        if (d5.isModifiable()) {
            return d5;
        }
        int size = d5.size();
        w.d mutableCopyWithCapacity = d5.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
        k1.W(obj, j5, mutableCopyWithCapacity);
        return mutableCopyWithCapacity;
    }
}
