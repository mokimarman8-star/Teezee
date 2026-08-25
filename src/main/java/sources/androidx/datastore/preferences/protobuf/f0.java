package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.w;
import java.util.RandomAccess;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
abstract class f0 extends c implements w.d, RandomAccess, w0 {
    public abstract void addLong(long j5);

    public abstract long getLong(int i5);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public abstract int size();
}
