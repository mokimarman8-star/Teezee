package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.w;
import java.util.RandomAccess;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
abstract class f extends c implements w.d, RandomAccess, w0 {
    public abstract void addBoolean(boolean z5);

    public abstract boolean getBoolean(int i5);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public abstract int size();
}
