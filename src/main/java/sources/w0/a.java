package w0;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public interface a extends IInterface {

    /* renamed from: m, reason: collision with root package name */
    public static final String f18081m = "androidx$core$app$unusedapprestrictions$IUnusedAppRestrictionsBackportCallback".replace('$', '.');

    /* renamed from: w0.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0180a extends Binder implements a {

        /* renamed from: w0.a$a$a, reason: collision with other inner class name */
        private static class C0181a implements a {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f18082a;

            C0181a(IBinder iBinder) {
                this.f18082a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f18082a;
            }
        }

        public AbstractBinderC0180a() {
            attachInterface(this, a.f18081m);
        }

        public static a X0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(a.f18081m);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0181a(iBinder) : (a) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i5, Parcel parcel, Parcel parcel2, int i6) {
            String str = a.f18081m;
            if (i5 >= 1 && i5 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i5 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i5 != 1) {
                return super.onTransact(i5, parcel, parcel2, i6);
            }
            V(parcel.readInt() != 0, parcel.readInt() != 0);
            return true;
        }
    }

    void V(boolean z5, boolean z6);
}
