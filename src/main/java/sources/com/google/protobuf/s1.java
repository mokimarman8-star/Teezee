package com.google.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class s1 {
    private static final long BOOLEAN_ARRAY_BASE_OFFSET;
    private static final long BOOLEAN_ARRAY_INDEX_SCALE;
    private static final long BUFFER_ADDRESS_OFFSET;
    private static final int BYTE_ARRAY_ALIGNMENT;
    static final long BYTE_ARRAY_BASE_OFFSET;
    private static final long DOUBLE_ARRAY_BASE_OFFSET;
    private static final long DOUBLE_ARRAY_INDEX_SCALE;
    private static final long FLOAT_ARRAY_BASE_OFFSET;
    private static final long FLOAT_ARRAY_INDEX_SCALE;
    private static final long INT_ARRAY_BASE_OFFSET;
    private static final long INT_ARRAY_INDEX_SCALE;
    static final boolean IS_BIG_ENDIAN;
    private static final long LONG_ARRAY_BASE_OFFSET;
    private static final long LONG_ARRAY_INDEX_SCALE;
    private static final long OBJECT_ARRAY_BASE_OFFSET;
    private static final long OBJECT_ARRAY_INDEX_SCALE;
    private static final int STRIDE = 8;
    private static final int STRIDE_ALIGNMENT_MASK = 7;
    private static final Unsafe UNSAFE = getUnsafe();
    private static final Class<?> MEMORY_CLASS = com.google.protobuf.d.getMemoryClass();
    private static final boolean IS_ANDROID_64 = determineAndroidSupportByAddressSize(Long.TYPE);
    private static final boolean IS_ANDROID_32 = determineAndroidSupportByAddressSize(Integer.TYPE);
    private static final e MEMORY_ACCESSOR = getMemoryAccessor();
    private static final boolean HAS_UNSAFE_BYTEBUFFER_OPERATIONS = supportsUnsafeByteBufferOperations();
    private static final boolean HAS_UNSAFE_ARRAY_OPERATIONS = supportsUnsafeArrayOperations();

    class a implements PrivilegedExceptionAction {
        a() {
        }

        @Override // java.security.PrivilegedExceptionAction
        public Unsafe run() throws Exception {
            for (Field field : Unsafe.class.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get(null);
                if (Unsafe.class.isInstance(obj)) {
                    return (Unsafe) Unsafe.class.cast(obj);
                }
            }
            return null;
        }
    }

    private static final class b extends e {
        private static final long SMALL_ADDRESS_MASK = -1;

        b(Unsafe unsafe) {
            super(unsafe);
        }

        private static int smallAddress(long j) {
            return (int) j;
        }

        @Override // com.google.protobuf.s1.e
        public void copyMemory(long j, byte[] bArr, long j2, long j3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.s1.e
        public void copyMemory(byte[] bArr, long j, long j2, long j3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.s1.e
        public boolean getBoolean(Object obj, long j) {
            return s1.IS_BIG_ENDIAN ? s1.getBooleanBigEndian(obj, j) : s1.getBooleanLittleEndian(obj, j);
        }

        @Override // com.google.protobuf.s1.e
        public byte getByte(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.s1.e
        public byte getByte(Object obj, long j) {
            return s1.IS_BIG_ENDIAN ? s1.getByteBigEndian(obj, j) : s1.getByteLittleEndian(obj, j);
        }

        @Override // com.google.protobuf.s1.e
        public double getDouble(Object obj, long j) {
            return Double.longBitsToDouble(getLong(obj, j));
        }

        @Override // com.google.protobuf.s1.e
        public float getFloat(Object obj, long j) {
            return Float.intBitsToFloat(getInt(obj, j));
        }

        @Override // com.google.protobuf.s1.e
        public int getInt(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.s1.e
        public long getLong(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.s1.e
        public Object getStaticObject(Field field) {
            try {
                return field.get(null);
            } catch (IllegalAccessException unused) {
                return null;
            }
        }

        @Override // com.google.protobuf.s1.e
        public void putBoolean(Object obj, long j, boolean z) {
            if (s1.IS_BIG_ENDIAN) {
                s1.putBooleanBigEndian(obj, j, z);
            } else {
                s1.putBooleanLittleEndian(obj, j, z);
            }
        }

        @Override // com.google.protobuf.s1.e
        public void putByte(long j, byte b) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.s1.e
        public void putByte(Object obj, long j, byte b) {
            if (s1.IS_BIG_ENDIAN) {
                s1.putByteBigEndian(obj, j, b);
            } else {
                s1.putByteLittleEndian(obj, j, b);
            }
        }

        @Override // com.google.protobuf.s1.e
        public void putDouble(Object obj, long j, double d) {
            putLong(obj, j, Double.doubleToLongBits(d));
        }

        @Override // com.google.protobuf.s1.e
        public void putFloat(Object obj, long j, float f) {
            putInt(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.google.protobuf.s1.e
        public void putInt(long j, int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.s1.e
        public void putLong(long j, long j2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.s1.e
        public boolean supportsUnsafeByteBufferOperations() {
            return false;
        }
    }

    private static final class c extends e {
        c(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.protobuf.s1.e
        public void copyMemory(long j, byte[] bArr, long j2, long j3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.s1.e
        public void copyMemory(byte[] bArr, long j, long j2, long j3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.s1.e
        public boolean getBoolean(Object obj, long j) {
            return s1.IS_BIG_ENDIAN ? s1.getBooleanBigEndian(obj, j) : s1.getBooleanLittleEndian(obj, j);
        }

        @Override // com.google.protobuf.s1.e
        public byte getByte(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.s1.e
        public byte getByte(Object obj, long j) {
            return s1.IS_BIG_ENDIAN ? s1.getByteBigEndian(obj, j) : s1.getByteLittleEndian(obj, j);
        }

        @Override // com.google.protobuf.s1.e
        public double getDouble(Object obj, long j) {
            return Double.longBitsToDouble(getLong(obj, j));
        }

        @Override // com.google.protobuf.s1.e
        public float getFloat(Object obj, long j) {
            return Float.intBitsToFloat(getInt(obj, j));
        }

        @Override // com.google.protobuf.s1.e
        public int getInt(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.s1.e
        public long getLong(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.s1.e
        public Object getStaticObject(Field field) {
            try {
                return field.get(null);
            } catch (IllegalAccessException unused) {
                return null;
            }
        }

        @Override // com.google.protobuf.s1.e
        public void putBoolean(Object obj, long j, boolean z) {
            if (s1.IS_BIG_ENDIAN) {
                s1.putBooleanBigEndian(obj, j, z);
            } else {
                s1.putBooleanLittleEndian(obj, j, z);
            }
        }

        @Override // com.google.protobuf.s1.e
        public void putByte(long j, byte b) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.s1.e
        public void putByte(Object obj, long j, byte b) {
            if (s1.IS_BIG_ENDIAN) {
                s1.putByteBigEndian(obj, j, b);
            } else {
                s1.putByteLittleEndian(obj, j, b);
            }
        }

        @Override // com.google.protobuf.s1.e
        public void putDouble(Object obj, long j, double d) {
            putLong(obj, j, Double.doubleToLongBits(d));
        }

        @Override // com.google.protobuf.s1.e
        public void putFloat(Object obj, long j, float f) {
            putInt(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.google.protobuf.s1.e
        public void putInt(long j, int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.s1.e
        public void putLong(long j, long j2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.s1.e
        public boolean supportsUnsafeByteBufferOperations() {
            return false;
        }
    }

    private static final class d extends e {
        d(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.protobuf.s1.e
        public void copyMemory(long j, byte[] bArr, long j2, long j3) {
            this.unsafe.copyMemory((Object) null, j, bArr, s1.BYTE_ARRAY_BASE_OFFSET + j2, j3);
        }

        @Override // com.google.protobuf.s1.e
        public void copyMemory(byte[] bArr, long j, long j2, long j3) {
            this.unsafe.copyMemory(bArr, s1.BYTE_ARRAY_BASE_OFFSET + j, (Object) null, j2, j3);
        }

        @Override // com.google.protobuf.s1.e
        public boolean getBoolean(Object obj, long j) {
            return this.unsafe.getBoolean(obj, j);
        }

        @Override // com.google.protobuf.s1.e
        public byte getByte(long j) {
            return this.unsafe.getByte(j);
        }

        @Override // com.google.protobuf.s1.e
        public byte getByte(Object obj, long j) {
            return this.unsafe.getByte(obj, j);
        }

        @Override // com.google.protobuf.s1.e
        public double getDouble(Object obj, long j) {
            return this.unsafe.getDouble(obj, j);
        }

        @Override // com.google.protobuf.s1.e
        public float getFloat(Object obj, long j) {
            return this.unsafe.getFloat(obj, j);
        }

        @Override // com.google.protobuf.s1.e
        public int getInt(long j) {
            return this.unsafe.getInt(j);
        }

        @Override // com.google.protobuf.s1.e
        public long getLong(long j) {
            return this.unsafe.getLong(j);
        }

        @Override // com.google.protobuf.s1.e
        public Object getStaticObject(Field field) {
            return getObject(this.unsafe.staticFieldBase(field), this.unsafe.staticFieldOffset(field));
        }

        @Override // com.google.protobuf.s1.e
        public void putBoolean(Object obj, long j, boolean z) {
            this.unsafe.putBoolean(obj, j, z);
        }

        @Override // com.google.protobuf.s1.e
        public void putByte(long j, byte b) {
            this.unsafe.putByte(j, b);
        }

        @Override // com.google.protobuf.s1.e
        public void putByte(Object obj, long j, byte b) {
            this.unsafe.putByte(obj, j, b);
        }

        @Override // com.google.protobuf.s1.e
        public void putDouble(Object obj, long j, double d) {
            this.unsafe.putDouble(obj, j, d);
        }

        @Override // com.google.protobuf.s1.e
        public void putFloat(Object obj, long j, float f) {
            this.unsafe.putFloat(obj, j, f);
        }

        @Override // com.google.protobuf.s1.e
        public void putInt(long j, int i) {
            this.unsafe.putInt(j, i);
        }

        @Override // com.google.protobuf.s1.e
        public void putLong(long j, long j2) {
            this.unsafe.putLong(j, j2);
        }

        @Override // com.google.protobuf.s1.e
        public boolean supportsUnsafeArrayOperations() {
            if (!super.supportsUnsafeArrayOperations()) {
                return false;
            }
            try {
                Class<?> cls = this.unsafe.getClass();
                Class<?> cls2 = Long.TYPE;
                cls.getMethod("getByte", Object.class, cls2);
                cls.getMethod("putByte", Object.class, cls2, Byte.TYPE);
                cls.getMethod("getBoolean", Object.class, cls2);
                cls.getMethod("putBoolean", Object.class, cls2, Boolean.TYPE);
                cls.getMethod("getFloat", Object.class, cls2);
                cls.getMethod("putFloat", Object.class, cls2, Float.TYPE);
                cls.getMethod("getDouble", Object.class, cls2);
                cls.getMethod("putDouble", Object.class, cls2, Double.TYPE);
                return true;
            } catch (Throwable th) {
                s1.logMissingMethod(th);
                return false;
            }
        }

        @Override // com.google.protobuf.s1.e
        public boolean supportsUnsafeByteBufferOperations() {
            if (!super.supportsUnsafeByteBufferOperations()) {
                return false;
            }
            try {
                Class<?> cls = this.unsafe.getClass();
                Class<?> cls2 = Long.TYPE;
                cls.getMethod("getByte", cls2);
                cls.getMethod("putByte", cls2, Byte.TYPE);
                cls.getMethod("getInt", cls2);
                cls.getMethod("putInt", cls2, Integer.TYPE);
                cls.getMethod("getLong", cls2);
                cls.getMethod("putLong", cls2, cls2);
                cls.getMethod("copyMemory", cls2, cls2, cls2);
                cls.getMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
                return true;
            } catch (Throwable th) {
                s1.logMissingMethod(th);
                return false;
            }
        }
    }

    private static abstract class e {
        Unsafe unsafe;

        e(Unsafe unsafe) {
            this.unsafe = unsafe;
        }

        public final int arrayBaseOffset(Class<?> cls) {
            return this.unsafe.arrayBaseOffset(cls);
        }

        public final int arrayIndexScale(Class<?> cls) {
            return this.unsafe.arrayIndexScale(cls);
        }

        public abstract void copyMemory(long j, byte[] bArr, long j2, long j3);

        public abstract void copyMemory(byte[] bArr, long j, long j2, long j3);

        public abstract boolean getBoolean(Object obj, long j);

        public abstract byte getByte(long j);

        public abstract byte getByte(Object obj, long j);

        public abstract double getDouble(Object obj, long j);

        public abstract float getFloat(Object obj, long j);

        public abstract int getInt(long j);

        public final int getInt(Object obj, long j) {
            return this.unsafe.getInt(obj, j);
        }

        public abstract long getLong(long j);

        public final long getLong(Object obj, long j) {
            return this.unsafe.getLong(obj, j);
        }

        public final Object getObject(Object obj, long j) {
            return this.unsafe.getObject(obj, j);
        }

        public abstract Object getStaticObject(Field field);

        public final long objectFieldOffset(Field field) {
            return this.unsafe.objectFieldOffset(field);
        }

        public abstract void putBoolean(Object obj, long j, boolean z);

        public abstract void putByte(long j, byte b);

        public abstract void putByte(Object obj, long j, byte b);

        public abstract void putDouble(Object obj, long j, double d);

        public abstract void putFloat(Object obj, long j, float f);

        public abstract void putInt(long j, int i);

        public final void putInt(Object obj, long j, int i) {
            this.unsafe.putInt(obj, j, i);
        }

        public abstract void putLong(long j, long j2);

        public final void putLong(Object obj, long j, long j2) {
            this.unsafe.putLong(obj, j, j2);
        }

        public final void putObject(Object obj, long j, Object obj2) {
            this.unsafe.putObject(obj, j, obj2);
        }

        public boolean supportsUnsafeArrayOperations() {
            Unsafe unsafe = this.unsafe;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                cls.getMethod("arrayBaseOffset", Class.class);
                cls.getMethod("arrayIndexScale", Class.class);
                Class<?> cls2 = Long.TYPE;
                cls.getMethod("getInt", Object.class, cls2);
                cls.getMethod("putInt", Object.class, cls2, Integer.TYPE);
                cls.getMethod("getLong", Object.class, cls2);
                cls.getMethod("putLong", Object.class, cls2, cls2);
                cls.getMethod("getObject", Object.class, cls2);
                cls.getMethod("putObject", Object.class, cls2, Object.class);
                return true;
            } catch (Throwable th) {
                s1.logMissingMethod(th);
                return false;
            }
        }

        public boolean supportsUnsafeByteBufferOperations() {
            Unsafe unsafe = this.unsafe;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                cls.getMethod("getLong", Object.class, Long.TYPE);
                return s1.bufferAddressField() != null;
            } catch (Throwable th) {
                s1.logMissingMethod(th);
                return false;
            }
        }
    }

    static {
        long arrayBaseOffset = arrayBaseOffset(byte[].class);
        BYTE_ARRAY_BASE_OFFSET = arrayBaseOffset;
        BOOLEAN_ARRAY_BASE_OFFSET = arrayBaseOffset(boolean[].class);
        BOOLEAN_ARRAY_INDEX_SCALE = arrayIndexScale(boolean[].class);
        INT_ARRAY_BASE_OFFSET = arrayBaseOffset(int[].class);
        INT_ARRAY_INDEX_SCALE = arrayIndexScale(int[].class);
        LONG_ARRAY_BASE_OFFSET = arrayBaseOffset(long[].class);
        LONG_ARRAY_INDEX_SCALE = arrayIndexScale(long[].class);
        FLOAT_ARRAY_BASE_OFFSET = arrayBaseOffset(float[].class);
        FLOAT_ARRAY_INDEX_SCALE = arrayIndexScale(float[].class);
        DOUBLE_ARRAY_BASE_OFFSET = arrayBaseOffset(double[].class);
        DOUBLE_ARRAY_INDEX_SCALE = arrayIndexScale(double[].class);
        OBJECT_ARRAY_BASE_OFFSET = arrayBaseOffset(Object[].class);
        OBJECT_ARRAY_INDEX_SCALE = arrayIndexScale(Object[].class);
        BUFFER_ADDRESS_OFFSET = fieldOffset(bufferAddressField());
        BYTE_ARRAY_ALIGNMENT = (int) (arrayBaseOffset & 7);
        IS_BIG_ENDIAN = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    private s1() {
    }

    static long addressOffset(ByteBuffer byteBuffer) {
        return MEMORY_ACCESSOR.getLong(byteBuffer, BUFFER_ADDRESS_OFFSET);
    }

    static <T> T allocateInstance(Class<T> cls) {
        try {
            return (T) UNSAFE.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    private static int arrayBaseOffset(Class<?> cls) {
        if (HAS_UNSAFE_ARRAY_OPERATIONS) {
            return MEMORY_ACCESSOR.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int arrayIndexScale(Class<?> cls) {
        if (HAS_UNSAFE_ARRAY_OPERATIONS) {
            return MEMORY_ACCESSOR.arrayIndexScale(cls);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Field bufferAddressField() {
        Field field;
        if (com.google.protobuf.d.isOnAndroidDevice() && (field = field(Buffer.class, "effectiveDirectAddress")) != null) {
            return field;
        }
        Field field2 = field(Buffer.class, "address");
        if (field2 == null || field2.getType() != Long.TYPE) {
            return null;
        }
        return field2;
    }

    static void copyMemory(long j, byte[] bArr, long j2, long j3) {
        MEMORY_ACCESSOR.copyMemory(j, bArr, j2, j3);
    }

    static void copyMemory(byte[] bArr, long j, long j2, long j3) {
        MEMORY_ACCESSOR.copyMemory(bArr, j, j2, j3);
    }

    static void copyMemory(byte[] bArr, long j, byte[] bArr2, long j2, long j3) {
        System.arraycopy(bArr, (int) j, bArr2, (int) j2, (int) j3);
    }

    static boolean determineAndroidSupportByAddressSize(Class<?> cls) {
        if (!com.google.protobuf.d.isOnAndroidDevice()) {
            return false;
        }
        try {
            Class<?> cls2 = MEMORY_CLASS;
            Class<?> cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class<?> cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static Field field(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static long fieldOffset(Field field) {
        e eVar;
        if (field == null || (eVar = MEMORY_ACCESSOR) == null) {
            return -1L;
        }
        return eVar.objectFieldOffset(field);
    }

    private static int firstDifferingByteIndexNativeEndian(long j, long j2) {
        return (IS_BIG_ENDIAN ? Long.numberOfLeadingZeros(j ^ j2) : Long.numberOfTrailingZeros(j ^ j2)) >> 3;
    }

    static boolean getBoolean(Object obj, long j) {
        return MEMORY_ACCESSOR.getBoolean(obj, j);
    }

    static boolean getBoolean(boolean[] zArr, long j) {
        return MEMORY_ACCESSOR.getBoolean(zArr, BOOLEAN_ARRAY_BASE_OFFSET + (j * BOOLEAN_ARRAY_INDEX_SCALE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean getBooleanBigEndian(Object obj, long j) {
        return getByteBigEndian(obj, j) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean getBooleanLittleEndian(Object obj, long j) {
        return getByteLittleEndian(obj, j) != 0;
    }

    static byte getByte(long j) {
        return MEMORY_ACCESSOR.getByte(j);
    }

    static byte getByte(Object obj, long j) {
        return MEMORY_ACCESSOR.getByte(obj, j);
    }

    static byte getByte(byte[] bArr, long j) {
        return MEMORY_ACCESSOR.getByte(bArr, BYTE_ARRAY_BASE_OFFSET + j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte getByteBigEndian(Object obj, long j) {
        return (byte) ((getInt(obj, (-4) & j) >>> ((int) (((~j) & 3) << 3))) & 255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte getByteLittleEndian(Object obj, long j) {
        return (byte) ((getInt(obj, (-4) & j) >>> ((int) ((j & 3) << 3))) & 255);
    }

    static double getDouble(Object obj, long j) {
        return MEMORY_ACCESSOR.getDouble(obj, j);
    }

    static double getDouble(double[] dArr, long j) {
        return MEMORY_ACCESSOR.getDouble(dArr, DOUBLE_ARRAY_BASE_OFFSET + (j * DOUBLE_ARRAY_INDEX_SCALE));
    }

    static float getFloat(Object obj, long j) {
        return MEMORY_ACCESSOR.getFloat(obj, j);
    }

    static float getFloat(float[] fArr, long j) {
        return MEMORY_ACCESSOR.getFloat(fArr, FLOAT_ARRAY_BASE_OFFSET + (j * FLOAT_ARRAY_INDEX_SCALE));
    }

    static int getInt(long j) {
        return MEMORY_ACCESSOR.getInt(j);
    }

    static int getInt(Object obj, long j) {
        return MEMORY_ACCESSOR.getInt(obj, j);
    }

    static int getInt(int[] iArr, long j) {
        return MEMORY_ACCESSOR.getInt(iArr, INT_ARRAY_BASE_OFFSET + (j * INT_ARRAY_INDEX_SCALE));
    }

    static long getLong(long j) {
        return MEMORY_ACCESSOR.getLong(j);
    }

    static long getLong(Object obj, long j) {
        return MEMORY_ACCESSOR.getLong(obj, j);
    }

    static long getLong(long[] jArr, long j) {
        return MEMORY_ACCESSOR.getLong(jArr, LONG_ARRAY_BASE_OFFSET + (j * LONG_ARRAY_INDEX_SCALE));
    }

    private static e getMemoryAccessor() {
        Unsafe unsafe = UNSAFE;
        if (unsafe == null) {
            return null;
        }
        if (!com.google.protobuf.d.isOnAndroidDevice()) {
            return new d(unsafe);
        }
        if (IS_ANDROID_64) {
            return new c(unsafe);
        }
        if (IS_ANDROID_32) {
            return new b(unsafe);
        }
        return null;
    }

    static Object getObject(Object obj, long j) {
        return MEMORY_ACCESSOR.getObject(obj, j);
    }

    static Object getObject(Object[] objArr, long j) {
        return MEMORY_ACCESSOR.getObject(objArr, OBJECT_ARRAY_BASE_OFFSET + (j * OBJECT_ARRAY_INDEX_SCALE));
    }

    static Object getStaticObject(Field field) {
        return MEMORY_ACCESSOR.getStaticObject(field);
    }

    static Unsafe getUnsafe() {
        try {
            return (Unsafe) AccessController.doPrivileged(new a());
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean hasUnsafeArrayOperations() {
        return HAS_UNSAFE_ARRAY_OPERATIONS;
    }

    static boolean hasUnsafeByteBufferOperations() {
        return HAS_UNSAFE_BYTEBUFFER_OPERATIONS;
    }

    static boolean isAndroid64() {
        return IS_ANDROID_64;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void logMissingMethod(Throwable th) {
        Logger.getLogger(s1.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
    }

    static int mismatch(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        if (i < 0 || i2 < 0 || i3 < 0 || i + i3 > bArr.length || i2 + i3 > bArr2.length) {
            throw new IndexOutOfBoundsException();
        }
        int i4 = 0;
        if (HAS_UNSAFE_ARRAY_OPERATIONS) {
            for (int i5 = (BYTE_ARRAY_ALIGNMENT + i) & 7; i4 < i3 && (i5 & 7) != 0; i5++) {
                if (bArr[i + i4] != bArr2[i2 + i4]) {
                    return i4;
                }
                i4++;
            }
            int i6 = ((i3 - i4) & (-8)) + i4;
            while (i4 < i6) {
                long j = BYTE_ARRAY_BASE_OFFSET;
                long j2 = i4;
                long j3 = getLong((Object) bArr, i + j + j2);
                long j4 = getLong((Object) bArr2, j + i2 + j2);
                if (j3 != j4) {
                    return i4 + firstDifferingByteIndexNativeEndian(j3, j4);
                }
                i4 += 8;
            }
        }
        while (i4 < i3) {
            if (bArr[i + i4] != bArr2[i2 + i4]) {
                return i4;
            }
            i4++;
        }
        return -1;
    }

    static long objectFieldOffset(Field field) {
        return MEMORY_ACCESSOR.objectFieldOffset(field);
    }

    static void putBoolean(Object obj, long j, boolean z) {
        MEMORY_ACCESSOR.putBoolean(obj, j, z);
    }

    static void putBoolean(boolean[] zArr, long j, boolean z) {
        MEMORY_ACCESSOR.putBoolean(zArr, BOOLEAN_ARRAY_BASE_OFFSET + (j * BOOLEAN_ARRAY_INDEX_SCALE), z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void putBooleanBigEndian(Object obj, long j, boolean z) {
        putByteBigEndian(obj, j, z ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void putBooleanLittleEndian(Object obj, long j, boolean z) {
        putByteLittleEndian(obj, j, z ? (byte) 1 : (byte) 0);
    }

    static void putByte(long j, byte b2) {
        MEMORY_ACCESSOR.putByte(j, b2);
    }

    static void putByte(Object obj, long j, byte b2) {
        MEMORY_ACCESSOR.putByte(obj, j, b2);
    }

    static void putByte(byte[] bArr, long j, byte b2) {
        MEMORY_ACCESSOR.putByte(bArr, BYTE_ARRAY_BASE_OFFSET + j, b2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void putByteBigEndian(Object obj, long j, byte b2) {
        long j2 = (-4) & j;
        int i = getInt(obj, j2);
        int i2 = ((~((int) j)) & 3) << 3;
        putInt(obj, j2, ((255 & b2) << i2) | (i & (~(255 << i2))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void putByteLittleEndian(Object obj, long j, byte b2) {
        long j2 = (-4) & j;
        int i = (((int) j) & 3) << 3;
        putInt(obj, j2, ((255 & b2) << i) | (getInt(obj, j2) & (~(255 << i))));
    }

    static void putDouble(Object obj, long j, double d2) {
        MEMORY_ACCESSOR.putDouble(obj, j, d2);
    }

    static void putDouble(double[] dArr, long j, double d2) {
        MEMORY_ACCESSOR.putDouble(dArr, DOUBLE_ARRAY_BASE_OFFSET + (j * DOUBLE_ARRAY_INDEX_SCALE), d2);
    }

    static void putFloat(Object obj, long j, float f) {
        MEMORY_ACCESSOR.putFloat(obj, j, f);
    }

    static void putFloat(float[] fArr, long j, float f) {
        MEMORY_ACCESSOR.putFloat(fArr, FLOAT_ARRAY_BASE_OFFSET + (j * FLOAT_ARRAY_INDEX_SCALE), f);
    }

    static void putInt(long j, int i) {
        MEMORY_ACCESSOR.putInt(j, i);
    }

    static void putInt(Object obj, long j, int i) {
        MEMORY_ACCESSOR.putInt(obj, j, i);
    }

    static void putInt(int[] iArr, long j, int i) {
        MEMORY_ACCESSOR.putInt(iArr, INT_ARRAY_BASE_OFFSET + (j * INT_ARRAY_INDEX_SCALE), i);
    }

    static void putLong(long j, long j2) {
        MEMORY_ACCESSOR.putLong(j, j2);
    }

    static void putLong(Object obj, long j, long j2) {
        MEMORY_ACCESSOR.putLong(obj, j, j2);
    }

    static void putLong(long[] jArr, long j, long j2) {
        MEMORY_ACCESSOR.putLong(jArr, LONG_ARRAY_BASE_OFFSET + (j * LONG_ARRAY_INDEX_SCALE), j2);
    }

    static void putObject(Object obj, long j, Object obj2) {
        MEMORY_ACCESSOR.putObject(obj, j, obj2);
    }

    static void putObject(Object[] objArr, long j, Object obj) {
        MEMORY_ACCESSOR.putObject(objArr, OBJECT_ARRAY_BASE_OFFSET + (j * OBJECT_ARRAY_INDEX_SCALE), obj);
    }

    private static boolean supportsUnsafeArrayOperations() {
        e eVar = MEMORY_ACCESSOR;
        if (eVar == null) {
            return false;
        }
        return eVar.supportsUnsafeArrayOperations();
    }

    private static boolean supportsUnsafeByteBufferOperations() {
        e eVar = MEMORY_ACCESSOR;
        if (eVar == null) {
            return false;
        }
        return eVar.supportsUnsafeByteBufferOperations();
    }
}
