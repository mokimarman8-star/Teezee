package d;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public interface b extends IInterface {

    /* renamed from: k, reason: collision with root package name */
    public static final String f14732k = "android$support$customtabs$trusted$ITrustedWebActivityService".replace('$', '.');

    public static abstract class a extends Binder implements b {
        public a() {
            attachInterface(this, b.f14732k);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i5, Parcel parcel, Parcel parcel2, int i6) {
            String str = b.f14732k;
            if (i5 >= 1 && i5 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i5 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            switch (i5) {
                case 2:
                    Bundle P = P((Bundle) C0132b.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    C0132b.d(parcel2, P, 1);
                    return true;
                case 3:
                    H0((Bundle) C0132b.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    int C0 = C0();
                    parcel2.writeNoException();
                    parcel2.writeInt(C0);
                    return true;
                case 5:
                    Bundle k02 = k0();
                    parcel2.writeNoException();
                    C0132b.d(parcel2, k02, 1);
                    return true;
                case 6:
                    Bundle D0 = D0((Bundle) C0132b.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    C0132b.d(parcel2, D0, 1);
                    return true;
                case 7:
                    Bundle G = G();
                    parcel2.writeNoException();
                    C0132b.d(parcel2, G, 1);
                    return true;
                case 8:
                default:
                    return super.onTransact(i5, parcel, parcel2, i6);
                case 9:
                    Bundle z5 = z(parcel.readString(), (Bundle) C0132b.c(parcel, Bundle.CREATOR), parcel.readStrongBinder());
                    parcel2.writeNoException();
                    C0132b.d(parcel2, z5, 1);
                    return true;
            }
        }
    }

    /* renamed from: d.b$b, reason: collision with other inner class name */
    public static class C0132b {
        /* JADX INFO: Access modifiers changed from: private */
        public static Object c(Parcel parcel, Parcelable.Creator creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void d(Parcel parcel, Parcelable parcelable, int i5) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcelable.writeToParcel(parcel, i5);
            }
        }
    }

    int C0();

    Bundle D0(Bundle bundle);

    Bundle G();

    void H0(Bundle bundle);

    Bundle P(Bundle bundle);

    Bundle k0();

    Bundle z(String str, Bundle bundle, IBinder iBinder);
}
