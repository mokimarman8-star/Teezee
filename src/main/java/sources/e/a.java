package e;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public interface a extends IInterface {

    /* renamed from: l, reason: collision with root package name */
    public static final String f14956l = "android$support$v4$app$INotificationSideChannel".replace('$', '.');

    /* renamed from: e.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0135a extends Binder implements a {

        /* renamed from: e.a$a$a, reason: collision with other inner class name */
        private static class C0136a implements a {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f14957a;

            C0136a(IBinder iBinder) {
                this.f14957a = iBinder;
            }

            @Override // e.a
            public void S0(String str, int i5, String str2, Notification notification) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f14956l);
                    obtain.writeString(str);
                    obtain.writeInt(i5);
                    obtain.writeString(str2);
                    b.d(obtain, notification, 0);
                    this.f14957a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f14957a;
            }
        }

        public AbstractBinderC0135a() {
            attachInterface(this, a.f14956l);
        }

        public static a X0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(a.f14956l);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0136a(iBinder) : (a) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i5, Parcel parcel, Parcel parcel2, int i6) {
            String str = a.f14956l;
            if (i5 >= 1 && i5 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i5 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i5 == 1) {
                S0(parcel.readString(), parcel.readInt(), parcel.readString(), (Notification) b.c(parcel, Notification.CREATOR));
            } else if (i5 == 2) {
                K(parcel.readString(), parcel.readInt(), parcel.readString());
            } else {
                if (i5 != 3) {
                    return super.onTransact(i5, parcel, parcel2, i6);
                }
                p0(parcel.readString());
            }
            return true;
        }
    }

    public static class b {
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

    void K(String str, int i5, String str2);

    void S0(String str, int i5, String str2, Notification notification);

    void p0(String str);
}
