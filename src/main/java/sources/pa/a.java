package pa;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import s8.b;
import s8.c;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface a extends IInterface {

    /* renamed from: pa.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0059a extends b implements a {

        /* renamed from: pa.a$a$a, reason: collision with other inner class name */
        public static class C0060a extends s8.a implements a {
            C0060a(IBinder iBinder) {
                super(iBinder);
            }

            @Override // pa.a
            public final Bundle w(Bundle bundle) {
                Parcel X0 = X0();
                c.b(X0, bundle);
                Parcel Y0 = Y0(X0);
                Bundle bundle2 = (Bundle) c.a(Y0, Bundle.CREATOR);
                Y0.recycle();
                return bundle2;
            }
        }

        public static a Y0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
            return queryLocalInterface instanceof a ? (a) queryLocalInterface : new C0060a(iBinder);
        }

        @Override // s8.b
        protected final boolean X0(int i, Parcel parcel, Parcel parcel2) {
            if (i != 1) {
                return false;
            }
            Bundle w = w((Bundle) c.a(parcel, Bundle.CREATOR));
            parcel2.writeNoException();
            c.c(parcel2, w);
            return true;
        }
    }

    Bundle w(Bundle bundle);
}
