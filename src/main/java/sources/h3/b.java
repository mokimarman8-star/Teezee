package h3;

import android.os.Bundle;
import android.os.Parcel;
import java.util.ArrayList;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class b {
    public e a(long j5, byte[] bArr, int i5, int i6) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, i5, i6);
        obtain.setDataPosition(0);
        Bundle readBundle = obtain.readBundle(Bundle.class.getClassLoader());
        obtain.recycle();
        return new e(androidx.media3.common.util.h.a(new com.google.common.base.f() { // from class: h3.a
            public final Object apply(Object obj) {
                return u1.a.b((Bundle) obj);
            }
        }, (ArrayList) androidx.media3.common.util.a.e(readBundle.getParcelableArrayList("c"))), j5, readBundle.getLong("d"));
    }
}
