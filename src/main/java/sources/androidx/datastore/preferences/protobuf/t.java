package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.w;
import java.util.RandomAccess;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
abstract class t extends c implements w.d, RandomAccess, w0 {
    public abstract void addFloat(float f5);

    public abstract float getFloat(int i5);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public abstract int size();
}
