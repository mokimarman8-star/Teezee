package h3;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class d {
    public byte[] a(List list, long j5) {
        ArrayList<? extends Parcelable> b5 = androidx.media3.common.util.h.b(list, new com.google.common.base.f() { // from class: h3.c
            public final Object apply(Object obj) {
                return ((u1.a) obj).d();
            }
        });
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("c", b5);
        bundle.putLong("d", j5);
        Parcel obtain = Parcel.obtain();
        obtain.writeBundle(bundle);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }
}
