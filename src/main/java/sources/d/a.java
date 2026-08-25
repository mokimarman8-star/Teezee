package d;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public interface a extends IInterface {

    /* renamed from: j, reason: collision with root package name */
    public static final String f14730j = "android$support$customtabs$trusted$ITrustedWebActivityCallback".replace('$', '.');

    /* renamed from: d.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0130a extends Binder implements a {

        /* renamed from: d.a$a$a, reason: collision with other inner class name */
        private static class C0131a implements a {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f14731a;

            C0131a(IBinder iBinder) {
                this.f14731a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f14731a;
            }
        }

        public AbstractBinderC0130a() {
            attachInterface(this, a.f14730j);
        }

        public static a X0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(a.f14730j);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0131a(iBinder) : (a) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i5, Parcel parcel, Parcel parcel2, int i6) {
            String str = a.f14730j;
            if (i5 >= 1 && i5 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i5 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i5 != 2) {
                return super.onTransact(i5, parcel, parcel2, i6);
            }
            Q0(parcel.readString(), (Bundle) b.b(parcel, Bundle.CREATOR));
            parcel2.writeNoException();
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

    void Q0(String str, Bundle bundle);
}
