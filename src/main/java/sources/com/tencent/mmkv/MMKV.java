package com.tencent.mmkv;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.util.Log;
import androidx.annotation.Nullable;
import dalvik.annotation.optimization.FastNative;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class MMKV implements SharedPreferences, SharedPreferences.Editor {
    private static final EnumMap a;
    private static final EnumMap b;
    private static final MMKVLogLevel[] c;
    private static final Set d;
    private static String e;
    private static boolean f;
    private static final HashMap g;
    private static a h;
    private static boolean i;
    public static final /* synthetic */ int j = 0;
    private final long nativeHandle;

    static {
        EnumMap enumMap = new EnumMap(MMKVRecoverStrategic.class);
        a = enumMap;
        enumMap.put((EnumMap) MMKVRecoverStrategic.OnErrorDiscard, (MMKVRecoverStrategic) 0);
        enumMap.put((EnumMap) MMKVRecoverStrategic.OnErrorRecover, (MMKVRecoverStrategic) 1);
        EnumMap enumMap2 = new EnumMap(MMKVLogLevel.class);
        b = enumMap2;
        MMKVLogLevel mMKVLogLevel = MMKVLogLevel.LevelDebug;
        enumMap2.put((EnumMap) mMKVLogLevel, (MMKVLogLevel) 0);
        MMKVLogLevel mMKVLogLevel2 = MMKVLogLevel.LevelInfo;
        enumMap2.put((EnumMap) mMKVLogLevel2, (MMKVLogLevel) 1);
        MMKVLogLevel mMKVLogLevel3 = MMKVLogLevel.LevelWarning;
        enumMap2.put((EnumMap) mMKVLogLevel3, (MMKVLogLevel) 2);
        MMKVLogLevel mMKVLogLevel4 = MMKVLogLevel.LevelError;
        enumMap2.put((EnumMap) mMKVLogLevel4, (MMKVLogLevel) 3);
        MMKVLogLevel mMKVLogLevel5 = MMKVLogLevel.LevelNone;
        enumMap2.put((EnumMap) mMKVLogLevel5, (MMKVLogLevel) 4);
        c = new MMKVLogLevel[]{mMKVLogLevel, mMKVLogLevel2, mMKVLogLevel3, mMKVLogLevel4, mMKVLogLevel5};
        d = new HashSet();
        e = null;
        f = true;
        g = new HashMap();
        i = false;
    }

    private MMKV(long j2) {
        this.nativeHandle = j2;
    }

    public static String A() {
        return e;
    }

    public static String C(Context context) {
        return E(context, context.getFilesDir().getAbsolutePath() + "/mmkv", null, MMKVLogLevel.LevelInfo, null);
    }

    public static String D(Context context, String str) {
        return E(context, str, null, MMKVLogLevel.LevelInfo, null);
    }

    public static String E(Context context, String str, b bVar, MMKVLogLevel mMKVLogLevel, a aVar) {
        if ((context.getApplicationInfo().flags & 2) == 0) {
            p();
        } else {
            r();
        }
        String absolutePath = context.getCacheDir().getAbsolutePath();
        h = aVar;
        if (aVar != null && aVar.c()) {
            i = true;
        }
        String q = q(str, absolutePath, bVar, mMKVLogLevel, i);
        if (h != null) {
            setCallbackHandler(i, true);
        }
        return q;
    }

    private static int F(MMKVLogLevel mMKVLogLevel) {
        int i2 = a.a[mMKVLogLevel.ordinal()];
        if (i2 == 1) {
            return 0;
        }
        int i3 = 2;
        if (i2 != 2) {
            i3 = 3;
            if (i2 != 3) {
                i3 = 4;
                if (i2 != 4) {
                    return 1;
                }
            }
        }
        return i3;
    }

    public static MMKV G(String str, int i2, int i3, String str2) {
        long mMKVWithAshmemFD = getMMKVWithAshmemFD(str, i2, i3, str2);
        if (mMKVWithAshmemFD != 0) {
            return new MMKV(mMKVWithAshmemFD);
        }
        throw new RuntimeException("Fail to create an ashmem MMKV instance [" + str + "] in JNI");
    }

    public static MMKV H(Context context, String str, int i2, int i3, String str2) {
        MMKV mmkv;
        if (e == null) {
            throw new IllegalStateException("You should Call MMKV.initialize() first.");
        }
        String b2 = MMKVContentProvider.b(context, Process.myPid());
        if (b2 == null || b2.length() == 0) {
            N(MMKVLogLevel.LevelError, "process name detect fail, try again later");
            throw new IllegalStateException("process name detect fail, try again later");
        }
        if (b2.contains(":")) {
            Uri a2 = MMKVContentProvider.a(context);
            if (a2 == null) {
                N(MMKVLogLevel.LevelError, "MMKVContentProvider has invalid authority");
                throw new IllegalStateException("MMKVContentProvider has invalid authority");
            }
            MMKVLogLevel mMKVLogLevel = MMKVLogLevel.LevelInfo;
            N(mMKVLogLevel, "getting parcelable mmkv in process, Uri = " + a2);
            Bundle bundle = new Bundle();
            bundle.putInt("KEY_SIZE", i2);
            bundle.putInt("KEY_MODE", i3);
            if (str2 != null) {
                bundle.putString("KEY_CRYPT", str2);
            }
            Bundle call = context.getContentResolver().call(a2, "mmkvFromAshmemID", str, bundle);
            if (call != null) {
                call.setClassLoader(ParcelableMMKV.class.getClassLoader());
                ParcelableMMKV parcelable = call.getParcelable("KEY");
                if (parcelable != null && (mmkv = parcelable.toMMKV()) != null) {
                    N(mMKVLogLevel, mmkv.mmapID() + " fd = " + mmkv.ashmemFD() + ", meta fd = " + mmkv.ashmemMetaFD());
                    return mmkv;
                }
            }
        }
        N(MMKVLogLevel.LevelInfo, "getting mmkv in main process");
        long mMKVWithIDAndSize = getMMKVWithIDAndSize(str, i2, i3 | 8, str2);
        if (mMKVWithIDAndSize != 0) {
            return new MMKV(mMKVWithIDAndSize);
        }
        throw new IllegalStateException("Fail to create an Ashmem MMKV instance [" + str + "]");
    }

    public static MMKV I(String str) {
        if (e != null) {
            return b(getMMKVWithID(str, 1, null, null, 0L), str, 1);
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    public static MMKV J(String str, int i2) {
        if (e != null) {
            return b(getMMKVWithID(str, i2, null, null, 0L), str, i2);
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    public static MMKV K(String str, int i2, String str2) {
        if (e != null) {
            return b(getMMKVWithID(str, i2, str2, null, 0L), str, i2);
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    public static MMKV L(String str, int i2, String str2, String str3) {
        if (e != null) {
            return b(getMMKVWithID(str, i2, str2, str3, 0L), str, i2);
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    private static void N(MMKVLogLevel mMKVLogLevel, String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[r0.length - 1];
        Integer num = (Integer) b.get(mMKVLogLevel);
        mmkvLogImp(num == null ? 0 : num.intValue(), stackTraceElement.getFileName(), stackTraceElement.getLineNumber(), stackTraceElement.getMethodName(), str);
    }

    private native long actualSize(long j2);

    private native String[] allKeys(long j2, boolean z);

    private static MMKV b(long j2, String str, int i2) {
        String str2;
        if (j2 == 0) {
            throw new RuntimeException("Fail to create an MMKV instance [" + str + "] in JNI");
        }
        if (!f) {
            return new MMKV(j2);
        }
        Set set = d;
        synchronized (set) {
            try {
                if (!set.contains(Long.valueOf(j2))) {
                    if (!checkProcessMode(j2)) {
                        if (i2 == 1) {
                            str2 = "Opening a multi-process MMKV instance [" + str + "] with SINGLE_PROCESS_MODE!";
                        } else {
                            str2 = ("Opening an MMKV instance [" + str + "] with MULTI_PROCESS_MODE, ") + "while it's already been opened with SINGLE_PROCESS_MODE by someone somewhere else!";
                        }
                        throw new IllegalArgumentException(str2);
                    }
                    set.add(Long.valueOf(j2));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return new MMKV(j2);
    }

    public static native long backupAllToDirectory(String str);

    public static native boolean backupOneToDirectory(String str, String str2, @Nullable String str3);

    private static native boolean checkProcessMode(long j2);

    private native boolean containsKey(long j2, String str);

    private native long count(long j2, boolean z);

    private static native long createNB(int i2);

    private native boolean decodeBool(long j2, String str, boolean z);

    @Nullable
    private native byte[] decodeBytes(long j2, String str);

    private native double decodeDouble(long j2, String str, double d2);

    private native float decodeFloat(long j2, String str, float f2);

    private native int decodeInt(long j2, String str, int i2);

    private native long decodeLong(long j2, String str, long j3);

    @Nullable
    private native String decodeString(long j2, String str, @Nullable String str2);

    @Nullable
    private native String[] decodeStringSet(long j2, String str);

    private static native void destroyNB(long j2, int i2);

    private native boolean encodeBool(long j2, String str, boolean z);

    private native boolean encodeBool_2(long j2, String str, boolean z, int i2);

    private native boolean encodeBytes(long j2, String str, @Nullable byte[] bArr);

    private native boolean encodeBytes_2(long j2, String str, @Nullable byte[] bArr, int i2);

    private native boolean encodeDouble(long j2, String str, double d2);

    private native boolean encodeDouble_2(long j2, String str, double d2, int i2);

    private native boolean encodeFloat(long j2, String str, float f2);

    private native boolean encodeFloat_2(long j2, String str, float f2, int i2);

    private native boolean encodeInt(long j2, String str, int i2);

    private native boolean encodeInt_2(long j2, String str, int i2, int i3);

    private native boolean encodeLong(long j2, String str, long j3);

    private native boolean encodeLong_2(long j2, String str, long j3, int i2);

    private native boolean encodeSet(long j2, String str, @Nullable String[] strArr);

    private native boolean encodeSet_2(long j2, String str, @Nullable String[] strArr, int i2);

    private native boolean encodeString(long j2, String str, @Nullable String str2);

    private native boolean encodeString_2(long j2, String str, @Nullable String str2, int i2);

    private static native long getDefaultMMKV(int i2, @Nullable String str);

    private static native long getMMKVWithAshmemFD(String str, int i2, int i3, @Nullable String str2);

    private static native long getMMKVWithID(String str, int i2, @Nullable String str2, @Nullable String str3, long j2);

    private static native long getMMKVWithIDAndSize(String str, int i2, int i3, @Nullable String str2);

    private native boolean isCompareBeforeSetEnabled();

    @FastNative
    private native boolean isEncryptionEnabled();

    @FastNative
    private native boolean isExpirationEnabled();

    public static native boolean isFileValid(String str, @Nullable String str2);

    private static native void jniInitialize(String str, String str2, int i2, boolean z);

    private static void mmkvLogImp(int i2, String str, int i3, String str2, String str3) {
        a aVar = h;
        if (aVar != null && i) {
            aVar.a(c[i2], str, i3, str2, str3);
            return;
        }
        int i4 = a.a[c[i2].ordinal()];
        if (i4 == 2) {
            Log.w("MMKV", str3);
        } else {
            if (i4 != 3) {
                return;
            }
            Log.e("MMKV", str3);
        }
    }

    @FastNative
    private native void nativeEnableCompareBeforeSet();

    public static MMKV o() {
        if (e != null) {
            return b(getDefaultMMKV(1, null), "DefaultMMKV", 1);
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    private static void onContentChangedByOuterProcess(String str) {
    }

    public static native void onExit();

    private static int onMMKVCRCCheckFail(String str) {
        MMKVRecoverStrategic mMKVRecoverStrategic = MMKVRecoverStrategic.OnErrorDiscard;
        a aVar = h;
        if (aVar != null) {
            mMKVRecoverStrategic = aVar.b(str);
        }
        N(MMKVLogLevel.LevelInfo, "Recover strategic for " + str + " is " + mMKVRecoverStrategic);
        Integer num = (Integer) a.get(mMKVRecoverStrategic);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    private static int onMMKVFileLengthError(String str) {
        MMKVRecoverStrategic mMKVRecoverStrategic = MMKVRecoverStrategic.OnErrorDiscard;
        a aVar = h;
        if (aVar != null) {
            mMKVRecoverStrategic = aVar.d(str);
        }
        N(MMKVLogLevel.LevelInfo, "Recover strategic for " + str + " is " + mMKVRecoverStrategic);
        Integer num = (Integer) a.get(mMKVRecoverStrategic);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static void p() {
        synchronized (d) {
            f = false;
        }
    }

    public static native int pageSize();

    private static String q(String str, String str2, b bVar, MMKVLogLevel mMKVLogLevel, boolean z) {
        if (bVar != null) {
            bVar.a("mmkv");
        } else {
            System.loadLibrary("mmkv");
        }
        jniInitialize(str, str2, F(mMKVLogLevel), z);
        e = str;
        return str;
    }

    public static void r() {
        synchronized (d) {
            f = true;
        }
    }

    public static native boolean removeStorage(String str, @Nullable String str2);

    private native void removeValueForKey(long j2, String str);

    public static native long restoreAllFromDirectory(String str);

    public static native boolean restoreOneMMKVFromDirectory(String str, String str2, @Nullable String str3);

    private static native void setCallbackHandler(boolean z, boolean z2);

    private static native void setLogLevel(int i2);

    private static native void setWantsContentChangeNotify(boolean z);

    private native void sync(boolean z);

    private native long totalSize(long j2);

    private native int valueSize(long j2, String str, boolean z);

    public static native String version();

    private native int writeValueToNB(long j2, String str, long j3, int i2);

    private byte[] z(Parcelable parcelable) {
        Parcel obtain = Parcel.obtain();
        parcelable.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }

    public int B(String str) {
        return valueSize(this.nativeHandle, str, true);
    }

    public void M(String str) {
        removeValueForKey(this.nativeHandle, str);
    }

    public String[] a() {
        return allKeys(this.nativeHandle, false);
    }

    @Override // android.content.SharedPreferences.Editor
    public void apply() {
        sync(false);
    }

    public native int ashmemFD();

    public native int ashmemMetaFD();

    public boolean c(String str) {
        return containsKey(this.nativeHandle, str);
    }

    public native void checkContentChangedByOuterProcess();

    public native void checkReSetCryptKey(@Nullable String str);

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        clearAll();
        return this;
    }

    public native void clearAll();

    public native void clearAllWithKeepingSpace();

    public native void clearMemoryCache();

    public native void close();

    @Override // android.content.SharedPreferences.Editor
    public boolean commit() {
        sync(true);
        return true;
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return c(str);
    }

    @Nullable
    public native String cryptKey();

    public boolean d(String str, boolean z) {
        return decodeBool(this.nativeHandle, str, z);
    }

    public native boolean disableAutoKeyExpire();

    public native void disableCompareBeforeSet();

    public byte[] e(String str) {
        return f(str, null);
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this;
    }

    public native boolean enableAutoKeyExpire(int i2);

    public byte[] f(String str, byte[] bArr) {
        byte[] decodeBytes = decodeBytes(this.nativeHandle, str);
        return decodeBytes != null ? decodeBytes : bArr;
    }

    public int g(String str, int i2) {
        return decodeInt(this.nativeHandle, str, i2);
    }

    @Override // android.content.SharedPreferences
    public Map getAll() {
        throw new UnsupportedOperationException("Intentionally Not Supported. Use allKeys() instead, getAll() not implement because type-erasure inside mmkv");
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return decodeBool(this.nativeHandle, str, z);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f2) {
        return decodeFloat(this.nativeHandle, str, f2);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i2) {
        return decodeInt(this.nativeHandle, str, i2);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j2) {
        return decodeLong(this.nativeHandle, str, j2);
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        return decodeString(this.nativeHandle, str, str2);
    }

    @Override // android.content.SharedPreferences
    public Set getStringSet(String str, Set set) {
        return m(str, set);
    }

    public long h(String str, long j2) {
        return decodeLong(this.nativeHandle, str, j2);
    }

    public Parcelable i(String str, Class cls) {
        return j(str, cls, null);
    }

    public Parcelable j(String str, Class cls, Parcelable parcelable) {
        byte[] decodeBytes;
        Parcelable.Creator creator;
        if (cls == null || (decodeBytes = decodeBytes(this.nativeHandle, str)) == null) {
            return parcelable;
        }
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(decodeBytes, 0, decodeBytes.length);
        obtain.setDataPosition(0);
        try {
            String cls2 = cls.toString();
            HashMap hashMap = g;
            synchronized (hashMap) {
                try {
                    creator = (Parcelable.Creator) hashMap.get(cls2);
                    if (creator == null && (creator = (Parcelable.Creator) cls.getField("CREATOR").get(null)) != null) {
                        hashMap.put(cls2, creator);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (creator != null) {
                return (Parcelable) creator.createFromParcel(obtain);
            }
            throw new Exception("Parcelable protocol requires a non-null static Parcelable.Creator object called CREATOR on class " + cls2);
        } catch (Exception e3) {
            N(MMKVLogLevel.LevelError, e3.toString());
            return parcelable;
        } finally {
            obtain.recycle();
        }
    }

    public String k(String str) {
        return decodeString(this.nativeHandle, str, null);
    }

    public String l(String str, String str2) {
        return decodeString(this.nativeHandle, str, str2);
    }

    public native void lock();

    public Set m(String str, Set set) {
        return n(str, set, HashSet.class);
    }

    public native String mmapID();

    public Set n(String str, Set set, Class cls) {
        String[] decodeStringSet = decodeStringSet(this.nativeHandle, str);
        if (decodeStringSet == null) {
            return set;
        }
        try {
            Set set2 = (Set) cls.newInstance();
            set2.addAll(Arrays.asList(decodeStringSet));
            return set2;
        } catch (IllegalAccessException | InstantiationException unused) {
            return set;
        }
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        encodeBool(this.nativeHandle, str, z);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f2) {
        encodeFloat(this.nativeHandle, str, f2);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i2) {
        encodeInt(this.nativeHandle, str, i2);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j2) {
        encodeLong(this.nativeHandle, str, j2);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, String str2) {
        encodeString(this.nativeHandle, str, str2);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putStringSet(String str, Set set) {
        w(str, set);
        return this;
    }

    public native boolean reKey(@Nullable String str);

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        throw new UnsupportedOperationException("Intentionally Not implement in MMKV");
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        M(str);
        return this;
    }

    public native void removeValuesForKeys(String[] strArr);

    public boolean s(String str, int i2) {
        return encodeInt(this.nativeHandle, str, i2);
    }

    public boolean t(String str, long j2) {
        return encodeLong(this.nativeHandle, str, j2);
    }

    public native void trim();

    public native boolean tryLock();

    public boolean u(String str, Parcelable parcelable) {
        if (parcelable == null) {
            return encodeBytes(this.nativeHandle, str, null);
        }
        return encodeBytes(this.nativeHandle, str, z(parcelable));
    }

    public native void unlock();

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        throw new UnsupportedOperationException("Intentionally Not implement in MMKV");
    }

    public boolean v(String str, String str2) {
        return encodeString(this.nativeHandle, str, str2);
    }

    public boolean w(String str, Set set) {
        return encodeSet(this.nativeHandle, str, set == null ? null : (String[]) set.toArray(new String[0]));
    }

    public boolean x(String str, boolean z) {
        return encodeBool(this.nativeHandle, str, z);
    }

    public boolean y(String str, byte[] bArr) {
        return encodeBytes(this.nativeHandle, str, bArr);
    }
}
