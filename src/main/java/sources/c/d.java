package c;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import c.a;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public interface d extends IInterface {

    /* renamed from: i, reason: collision with root package name */
    public static final String f14190i = "android$support$customtabs$IPostMessageService".replace('$', '.');

    public static abstract class a extends Binder implements d {
        public a() {
            attachInterface(this, d.f14190i);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i5, Parcel parcel, Parcel parcel2, int i6) {
            String str = d.f14190i;
            if (i5 >= 1 && i5 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i5 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i5 == 2) {
                n(a.AbstractBinderC0119a.X0(parcel.readStrongBinder()), (Bundle) b.b(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
            } else {
                if (i5 != 3) {
                    return super.onTransact(i5, parcel, parcel2, i6);
                }
                E0(a.AbstractBinderC0119a.X0(parcel.readStrongBinder()), parcel.readString(), (Bundle) b.b(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
            }
            return true;
        }
    }

    public static class b {
        /* JADX INFO: Access modifiers changed from: private */
        public static Object b(Parcel parcel, Parcelable.Creator creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }
    }

    void E0(c.a aVar, String str, Bundle bundle);

    void n(c.a aVar, Bundle bundle);
}
