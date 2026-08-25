package com.google.protobuf;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class y {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final ByteBuffer EMPTY_BYTE_BUFFER;
    public static final com.google.protobuf.i EMPTY_CODED_INPUT_STREAM;
    static final Charset US_ASCII = Charset.forName(C.ASCII_NAME);
    static final Charset UTF_8 = Charset.forName(C.UTF8_NAME);
    static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");

    public interface a extends j {
        void addBoolean(boolean z);

        boolean getBoolean(int i);

        @Override // com.google.protobuf.y.j
        /* synthetic */ boolean isModifiable();

        @Override // com.google.protobuf.y.j
        /* synthetic */ void makeImmutable();

        @Override // com.google.protobuf.y.j
        a mutableCopyWithCapacity(int i);

        @Override // com.google.protobuf.y.j
        /* bridge */ /* synthetic */ j mutableCopyWithCapacity(int i);

        boolean setBoolean(int i, boolean z);
    }

    public interface b extends j {
        void addDouble(double d);

        double getDouble(int i);

        @Override // com.google.protobuf.y.j
        /* synthetic */ boolean isModifiable();

        @Override // com.google.protobuf.y.j
        /* synthetic */ void makeImmutable();

        @Override // com.google.protobuf.y.j
        b mutableCopyWithCapacity(int i);

        @Override // com.google.protobuf.y.j
        /* bridge */ /* synthetic */ j mutableCopyWithCapacity(int i);

        double setDouble(int i, double d);
    }

    public interface c {
        int getNumber();
    }

    public interface d {
        c findValueByNumber(int i);
    }

    public interface e {
        boolean isInRange(int i);
    }

    public interface f extends j {
        void addFloat(float f);

        float getFloat(int i);

        @Override // com.google.protobuf.y.j
        /* synthetic */ boolean isModifiable();

        @Override // com.google.protobuf.y.j
        /* synthetic */ void makeImmutable();

        @Override // com.google.protobuf.y.j
        f mutableCopyWithCapacity(int i);

        @Override // com.google.protobuf.y.j
        /* bridge */ /* synthetic */ j mutableCopyWithCapacity(int i);

        float setFloat(int i, float f);
    }

    public interface g extends j {
        void addInt(int i);

        int getInt(int i);

        @Override // com.google.protobuf.y.j
        /* synthetic */ boolean isModifiable();

        @Override // com.google.protobuf.y.j
        /* synthetic */ void makeImmutable();

        @Override // com.google.protobuf.y.j
        g mutableCopyWithCapacity(int i);

        @Override // com.google.protobuf.y.j
        /* bridge */ /* synthetic */ j mutableCopyWithCapacity(int i);

        int setInt(int i, int i2);
    }

    public static class h extends AbstractList {
        private final a converter;
        private final List<Object> fromList;

        public interface a {
            Object convert(Object obj);
        }

        public h(List<Object> list, a aVar) {
            this.fromList = list;
            this.converter = aVar;
        }

        @Override // java.util.AbstractList, java.util.List
        public Object get(int i) {
            return this.converter.convert(this.fromList.get(i));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.fromList.size();
        }
    }

    public interface i extends j {
        void addLong(long j);

        long getLong(int i);

        @Override // com.google.protobuf.y.j
        /* synthetic */ boolean isModifiable();

        @Override // com.google.protobuf.y.j
        /* synthetic */ void makeImmutable();

        @Override // com.google.protobuf.y.j
        i mutableCopyWithCapacity(int i);

        @Override // com.google.protobuf.y.j
        /* bridge */ /* synthetic */ j mutableCopyWithCapacity(int i);

        long setLong(int i, long j);
    }

    public interface j extends List, RandomAccess {
        boolean isModifiable();

        void makeImmutable();

        j mutableCopyWithCapacity(int i);
    }

    static {
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        EMPTY_BYTE_BUFFER = ByteBuffer.wrap(bArr);
        EMPTY_CODED_INPUT_STREAM = com.google.protobuf.i.newInstance(bArr);
    }

    private y() {
    }

    public static byte[] byteArrayDefaultValue(String str) {
        return str.getBytes(ISO_8859_1);
    }

    public static ByteBuffer byteBufferDefaultValue(String str) {
        return ByteBuffer.wrap(byteArrayDefaultValue(str));
    }

    public static ByteString bytesDefaultValue(String str) {
        return ByteString.copyFrom(str.getBytes(ISO_8859_1));
    }

    static <T> T checkNotNull(T t) {
        t.getClass();
        return t;
    }

    static <T> T checkNotNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static ByteBuffer copyByteBuffer(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.clear();
        ByteBuffer allocate = ByteBuffer.allocate(duplicate.capacity());
        allocate.put(duplicate);
        allocate.clear();
        return allocate;
    }

    public static boolean equals(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (!Arrays.equals(list.get(i2), list2.get(i2))) {
                return false;
            }
        }
        return true;
    }

    public static boolean equalsByteBuffer(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        if (byteBuffer.capacity() != byteBuffer2.capacity()) {
            return false;
        }
        ByteBuffer duplicate = byteBuffer.duplicate();
        e0.clear(duplicate);
        ByteBuffer duplicate2 = byteBuffer2.duplicate();
        e0.clear(duplicate2);
        return duplicate.equals(duplicate2);
    }

    public static boolean equalsByteBuffer(List<ByteBuffer> list, List<ByteBuffer> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (!equalsByteBuffer(list.get(i2), list2.get(i2))) {
                return false;
            }
        }
        return true;
    }

    public static <T extends s0> T getDefaultInstance(Class<T> cls) {
        try {
            Method method = cls.getMethod("getDefaultInstance", null);
            return (T) method.invoke(method, null);
        } catch (Exception e2) {
            throw new RuntimeException("Failed to get default instance for " + cls, e2);
        }
    }

    public static int hashBoolean(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int hashCode(List<byte[]> list) {
        Iterator<byte[]> it = list.iterator();
        int i2 = 1;
        while (it.hasNext()) {
            i2 = (i2 * 31) + hashCode(it.next());
        }
        return i2;
    }

    public static int hashCode(byte[] bArr) {
        return hashCode(bArr, 0, bArr.length);
    }

    static int hashCode(byte[] bArr, int i2, int i3) {
        int partialHash = partialHash(i3, bArr, i2, i3);
        if (partialHash == 0) {
            return 1;
        }
        return partialHash;
    }

    public static int hashCodeByteBuffer(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            int partialHash = partialHash(byteBuffer.capacity(), byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
            if (partialHash == 0) {
                return 1;
            }
            return partialHash;
        }
        int capacity = byteBuffer.capacity() <= 4096 ? byteBuffer.capacity() : 4096;
        byte[] bArr = new byte[capacity];
        ByteBuffer duplicate = byteBuffer.duplicate();
        e0.clear(duplicate);
        int capacity2 = byteBuffer.capacity();
        while (duplicate.remaining() > 0) {
            int remaining = duplicate.remaining() <= capacity ? duplicate.remaining() : capacity;
            duplicate.get(bArr, 0, remaining);
            capacity2 = partialHash(capacity2, bArr, 0, remaining);
        }
        if (capacity2 == 0) {
            return 1;
        }
        return capacity2;
    }

    public static int hashCodeByteBuffer(List<ByteBuffer> list) {
        Iterator<ByteBuffer> it = list.iterator();
        int i2 = 1;
        while (it.hasNext()) {
            i2 = (i2 * 31) + hashCodeByteBuffer(it.next());
        }
        return i2;
    }

    public static int hashEnum(c cVar) {
        return cVar.getNumber();
    }

    public static int hashEnumList(List<? extends c> list) {
        Iterator<? extends c> it = list.iterator();
        int i2 = 1;
        while (it.hasNext()) {
            i2 = (i2 * 31) + hashEnum(it.next());
        }
        return i2;
    }

    public static int hashLong(long j2) {
        return (int) (j2 ^ (j2 >>> 32));
    }

    public static boolean isValidUtf8(ByteString byteString) {
        return byteString.isValidUtf8();
    }

    public static boolean isValidUtf8(byte[] bArr) {
        return Utf8.isValidUtf8(bArr);
    }

    static Object mergeMessage(Object obj, Object obj2) {
        return ((s0) obj).toBuilder().mergeFrom((s0) obj2).mo54buildPartial();
    }

    static int partialHash(int i2, byte[] bArr, int i3, int i4) {
        for (int i5 = i3; i5 < i3 + i4; i5++) {
            i2 = (i2 * 31) + bArr[i5];
        }
        return i2;
    }

    public static String stringDefaultValue(String str) {
        return new String(str.getBytes(ISO_8859_1), UTF_8);
    }

    public static byte[] toByteArray(String str) {
        return str.getBytes(UTF_8);
    }

    public static String toStringUtf8(byte[] bArr) {
        return new String(bArr, UTF_8);
    }
}
