package w0;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import w0.a;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public interface b extends IInterface {

    /* renamed from: n, reason: collision with root package name */
    public static final String f18083n = "androidx$core$app$unusedapprestrictions$IUnusedAppRestrictionsBackportService".replace('$', '.');

    public static abstract class a extends Binder implements b {
        public a() {
            attachInterface(this, b.f18083n);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i5, Parcel parcel, Parcel parcel2, int i6) {
            String str = b.f18083n;
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
            I0(a.AbstractBinderC0180a.X0(parcel.readStrongBinder()));
            return true;
        }
    }

    void I0(w0.a aVar);
}
