package c;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public interface c extends IInterface {

    /* renamed from: h, reason: collision with root package name */
    public static final String f14188h = "android$support$customtabs$IEngagementSignalsCallback".replace('$', '.');

    public static abstract class a extends Binder implements c {

        /* renamed from: c.c$a$a, reason: collision with other inner class name */
        private static class C0123a implements c {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f14189a;

            C0123a(IBinder iBinder) {
                this.f14189a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f14189a;
            }

            @Override // c.c
            public void onGreatestScrollPercentageIncreased(int i5, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(c.f14188h);
                    obtain.writeInt(i5);
                    b.d(obtain, bundle, 0);
                    this.f14189a.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // c.c
            public void onSessionEnded(boolean z5, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(c.f14188h);
                    obtain.writeInt(z5 ? 1 : 0);
                    b.d(obtain, bundle, 0);
                    this.f14189a.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // c.c
            public void onVerticalScrollEvent(boolean z5, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(c.f14188h);
                    obtain.writeInt(z5 ? 1 : 0);
                    b.d(obtain, bundle, 0);
                    this.f14189a.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, c.f14188h);
        }

        public static c X0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(c.f14188h);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof c)) ? new C0123a(iBinder) : (c) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i5, Parcel parcel, Parcel parcel2, int i6) {
            String str = c.f14188h;
            if (i5 >= 1 && i5 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i5 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i5 == 2) {
                onVerticalScrollEvent(parcel.readInt() != 0, (Bundle) b.c(parcel, Bundle.CREATOR));
            } else if (i5 == 3) {
                onGreatestScrollPercentageIncreased(parcel.readInt(), (Bundle) b.c(parcel, Bundle.CREATOR));
            } else {
                if (i5 != 4) {
                    return super.onTransact(i5, parcel, parcel2, i6);
                }
                onSessionEnded(parcel.readInt() != 0, (Bundle) b.c(parcel, Bundle.CREATOR));
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

    void onGreatestScrollPercentageIncreased(int i5, Bundle bundle);

    void onSessionEnded(boolean z5, Bundle bundle);

    void onVerticalScrollEvent(boolean z5, Bundle bundle);
}
