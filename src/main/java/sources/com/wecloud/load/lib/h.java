package com.wecloud.load.lib;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.wecloud.load.lib.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public interface h extends IInterface {

    public static abstract class a extends Binder implements h {

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.wecloud.load.lib.h$a$a, reason: collision with other inner class name */
        static class C0051a implements h {
            private IBinder a;

            C0051a(IBinder iBinder) {
                this.a = iBinder;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void Y0(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            @Override // com.wecloud.load.lib.h
            public void R(String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.wecloud.load.lib.ISoLoadCallback");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // com.wecloud.load.lib.h
            public void e(String str, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.wecloud.load.lib.ISoLoadCallback");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.wecloud.load.lib.h
            public void n0(int i, int i2, int i3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.wecloud.load.lib.ISoLoadCallback");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.wecloud.load.lib.h
            public void onError(int i, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.wecloud.load.lib.ISoLoadCallback");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.wecloud.load.lib.h
            public void q0(int i, int i2, int i3, List list, Map map) {
                final Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.wecloud.load.lib.ISoLoadCallback");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeStringList(list);
                    if (map == null) {
                        obtain.writeInt(-1);
                    } else {
                        obtain.writeInt(map.size());
                        map.forEach(new BiConsumer() { // from class: com.wecloud.load.lib.g
                            @Override // java.util.function.BiConsumer
                            public final void accept(Object obj, Object obj2) {
                                h.a.C0051a.Y0(obtain, (String) obj, (String) obj2);
                            }
                        });
                    }
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }
        }

        public a() {
            attachInterface(this, "com.wecloud.load.lib.ISoLoadCallback");
        }

        public static h Y0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.wecloud.load.lib.ISoLoadCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof h)) ? new C0051a(iBinder) : (h) queryLocalInterface;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void Z0(Parcel parcel, Map map, int i) {
            map.put(parcel.readString(), parcel.readString());
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, final Parcel parcel, Parcel parcel2, int i2) {
            IntStream range;
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface("com.wecloud.load.lib.ISoLoadCallback");
            }
            if (i == 1598968902) {
                parcel2.writeString("com.wecloud.load.lib.ISoLoadCallback");
                return true;
            }
            if (i == 1) {
                int readInt = parcel.readInt();
                int readInt2 = parcel.readInt();
                int readInt3 = parcel.readInt();
                ArrayList<String> createStringArrayList = parcel.createStringArrayList();
                int readInt4 = parcel.readInt();
                final HashMap hashMap = readInt4 < 0 ? null : new HashMap();
                range = IntStream.range(0, readInt4);
                range.forEach(new IntConsumer() { // from class: com.wecloud.load.lib.e
                    @Override // java.util.function.IntConsumer
                    public final void accept(int i3) {
                        h.a.Z0(parcel, hashMap, i3);
                    }
                });
                q0(readInt, readInt2, readInt3, createStringArrayList, hashMap);
                parcel2.writeNoException();
            } else if (i == 2) {
                n0(parcel.readInt(), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
            } else if (i == 3) {
                onError(parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
            } else if (i == 4) {
                e(parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
            } else {
                if (i != 5) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                R(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
            }
            return true;
        }
    }

    void R(String str, String str2);

    void e(String str, int i);

    void n0(int i, int i2, int i3);

    void onError(int i, String str);

    void q0(int i, int i2, int i3, List list, Map map);
}
