package androidx.coroutines;

import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: androidx.work.d, reason: case insensitive filesystem */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class C0210d {

    /* renamed from: b, reason: collision with root package name */
    private static final String f13922b = AbstractC0216j.i("Data");

    /* renamed from: c, reason: collision with root package name */
    public static final C0210d f13923c = new a().a();

    /* renamed from: a, reason: collision with root package name */
    Map f13924a;

    /* renamed from: androidx.work.d$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private Map f13925a = new HashMap();

        public C0210d a() {
            C0210d c0210d = new C0210d(this.f13925a);
            C0210d.k(c0210d);
            return c0210d;
        }

        public a b(String str, Object obj) {
            if (obj == null) {
                this.f13925a.put(str, null);
            } else {
                Class<?> cls = obj.getClass();
                if (cls == Boolean.class || cls == Byte.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == String.class || cls == Boolean[].class || cls == Byte[].class || cls == Integer[].class || cls == Long[].class || cls == Float[].class || cls == Double[].class || cls == String[].class) {
                    this.f13925a.put(str, obj);
                } else if (cls == boolean[].class) {
                    this.f13925a.put(str, C0210d.a((boolean[]) obj));
                } else if (cls == byte[].class) {
                    this.f13925a.put(str, C0210d.b((byte[]) obj));
                } else if (cls == int[].class) {
                    this.f13925a.put(str, C0210d.e((int[]) obj));
                } else if (cls == long[].class) {
                    this.f13925a.put(str, C0210d.f((long[]) obj));
                } else if (cls == float[].class) {
                    this.f13925a.put(str, C0210d.d((float[]) obj));
                } else {
                    if (cls != double[].class) {
                        throw new IllegalArgumentException("Key " + str + "has invalid type " + cls);
                    }
                    this.f13925a.put(str, C0210d.c((double[]) obj));
                }
            }
            return this;
        }

        public a c(C0210d c0210d) {
            d(c0210d.f13924a);
            return this;
        }

        public a d(Map map) {
            for (Map.Entry entry : map.entrySet()) {
                b((String) entry.getKey(), entry.getValue());
            }
            return this;
        }

        public a e(String str, String str2) {
            this.f13925a.put(str, str2);
            return this;
        }
    }

    public C0210d(C0210d c0210d) {
        this.f13924a = new HashMap(c0210d.f13924a);
    }

    public C0210d(Map map) {
        this.f13924a = new HashMap(map);
    }

    public static Boolean[] a(boolean[] zArr) {
        Boolean[] boolArr = new Boolean[zArr.length];
        for (int i5 = 0; i5 < zArr.length; i5++) {
            boolArr[i5] = Boolean.valueOf(zArr[i5]);
        }
        return boolArr;
    }

    public static Byte[] b(byte[] bArr) {
        Byte[] bArr2 = new Byte[bArr.length];
        for (int i5 = 0; i5 < bArr.length; i5++) {
            bArr2[i5] = Byte.valueOf(bArr[i5]);
        }
        return bArr2;
    }

    public static Double[] c(double[] dArr) {
        Double[] dArr2 = new Double[dArr.length];
        for (int i5 = 0; i5 < dArr.length; i5++) {
            dArr2[i5] = Double.valueOf(dArr[i5]);
        }
        return dArr2;
    }

    public static Float[] d(float[] fArr) {
        Float[] fArr2 = new Float[fArr.length];
        for (int i5 = 0; i5 < fArr.length; i5++) {
            fArr2[i5] = Float.valueOf(fArr[i5]);
        }
        return fArr2;
    }

    public static Integer[] e(int[] iArr) {
        Integer[] numArr = new Integer[iArr.length];
        for (int i5 = 0; i5 < iArr.length; i5++) {
            numArr[i5] = Integer.valueOf(iArr[i5]);
        }
        return numArr;
    }

    public static Long[] f(long[] jArr) {
        Long[] lArr = new Long[jArr.length];
        for (int i5 = 0; i5 < jArr.length; i5++) {
            lArr[i5] = Long.valueOf(jArr[i5]);
        }
        return lArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0058 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0040 -> B:16:0x0065). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C0210d g(byte[] bArr) {
        ObjectInputStream objectInputStream;
        Throwable e5;
        if (bArr.length > 10240) {
            throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
        }
        HashMap hashMap = new HashMap();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ObjectInputStream objectInputStream2 = null;
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
            } catch (IOException e6) {
                Log.e(f13922b, "Error in Data#fromByteArray: ", e6);
            }
            try {
                for (int readInt = objectInputStream.readInt(); readInt > 0; readInt--) {
                    hashMap.put(objectInputStream.readUTF(), objectInputStream.readObject());
                }
                try {
                    objectInputStream.close();
                } catch (IOException e7) {
                    Log.e(f13922b, "Error in Data#fromByteArray: ", e7);
                }
                byteArrayInputStream.close();
            } catch (IOException e8) {
                e5 = e8;
                Log.e(f13922b, "Error in Data#fromByteArray: ", e5);
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e9) {
                        Log.e(f13922b, "Error in Data#fromByteArray: ", e9);
                    }
                }
                byteArrayInputStream.close();
                return new C0210d(hashMap);
            } catch (ClassNotFoundException e10) {
                e5 = e10;
                Log.e(f13922b, "Error in Data#fromByteArray: ", e5);
                if (objectInputStream != null) {
                }
                byteArrayInputStream.close();
                return new C0210d(hashMap);
            }
        } catch (IOException e11) {
            e = e11;
            Throwable th2 = e;
            objectInputStream = null;
            e5 = th2;
            Log.e(f13922b, "Error in Data#fromByteArray: ", e5);
            if (objectInputStream != null) {
            }
            byteArrayInputStream.close();
            return new C0210d(hashMap);
        } catch (ClassNotFoundException e12) {
            e = e12;
            Throwable th22 = e;
            objectInputStream = null;
            e5 = th22;
            Log.e(f13922b, "Error in Data#fromByteArray: ", e5);
            if (objectInputStream != null) {
            }
            byteArrayInputStream.close();
            return new C0210d(hashMap);
        } catch (Throwable th3) {
            th = th3;
            if (0 != 0) {
                try {
                    objectInputStream2.close();
                } catch (IOException e13) {
                    Log.e(f13922b, "Error in Data#fromByteArray: ", e13);
                }
            }
            try {
                byteArrayInputStream.close();
                throw th;
            } catch (IOException e14) {
                Log.e(f13922b, "Error in Data#fromByteArray: ", e14);
                throw th;
            }
        }
        return new C0210d(hashMap);
    }

    public static byte[] k(C0210d c0210d) {
        ObjectOutputStream objectOutputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream2 = null;
        try {
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e5) {
            e = e5;
        }
        try {
            objectOutputStream.writeInt(c0210d.j());
            for (Map.Entry entry : c0210d.f13924a.entrySet()) {
                objectOutputStream.writeUTF((String) entry.getKey());
                objectOutputStream.writeObject(entry.getValue());
            }
            try {
                objectOutputStream.close();
            } catch (IOException e6) {
                Log.e(f13922b, "Error in Data#toByteArray: ", e6);
            }
            try {
                byteArrayOutputStream.close();
            } catch (IOException e7) {
                Log.e(f13922b, "Error in Data#toByteArray: ", e7);
            }
            if (byteArrayOutputStream.size() <= 10240) {
                return byteArrayOutputStream.toByteArray();
            }
            throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
        } catch (IOException e8) {
            e = e8;
            objectOutputStream2 = objectOutputStream;
            Log.e(f13922b, "Error in Data#toByteArray: ", e);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (objectOutputStream2 != null) {
                try {
                    objectOutputStream2.close();
                } catch (IOException e9) {
                    Log.e(f13922b, "Error in Data#toByteArray: ", e9);
                }
            }
            try {
                byteArrayOutputStream.close();
            } catch (IOException e10) {
                Log.e(f13922b, "Error in Data#toByteArray: ", e10);
            }
            return byteArray;
        } catch (Throwable th2) {
            th = th2;
            objectOutputStream2 = objectOutputStream;
            if (objectOutputStream2 != null) {
                try {
                    objectOutputStream2.close();
                } catch (IOException e11) {
                    Log.e(f13922b, "Error in Data#toByteArray: ", e11);
                }
            }
            try {
                byteArrayOutputStream.close();
                throw th;
            } catch (IOException e12) {
                Log.e(f13922b, "Error in Data#toByteArray: ", e12);
                throw th;
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0210d.class != obj.getClass()) {
            return false;
        }
        C0210d c0210d = (C0210d) obj;
        Set<String> keySet = this.f13924a.keySet();
        if (!keySet.equals(c0210d.f13924a.keySet())) {
            return false;
        }
        for (String str : keySet) {
            Object obj2 = this.f13924a.get(str);
            Object obj3 = c0210d.f13924a.get(str);
            if (!((obj2 == null || obj3 == null) ? obj2 == obj3 : ((obj2 instanceof Object[]) && (obj3 instanceof Object[])) ? Arrays.deepEquals((Object[]) obj2, (Object[]) obj3) : obj2.equals(obj3))) {
                return false;
            }
        }
        return true;
    }

    public Map h() {
        return Collections.unmodifiableMap(this.f13924a);
    }

    public int hashCode() {
        return this.f13924a.hashCode() * 31;
    }

    public String i(String str) {
        Object obj = this.f13924a.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public int j() {
        return this.f13924a.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Data {");
        if (!this.f13924a.isEmpty()) {
            for (String str : this.f13924a.keySet()) {
                sb.append(str);
                sb.append(" : ");
                Object obj = this.f13924a.get(str);
                if (obj instanceof Object[]) {
                    sb.append(Arrays.toString((Object[]) obj));
                } else {
                    sb.append(obj);
                }
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
