package com.cloud.tmc.kernel.api.bytedata;

import com.cloud.tmc.kernel.api.bytedata.ByteArrayPools;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class ByteOrderDataUtil {
    static final int BYTE_127 = 127;
    static final int BYTE_2 = 2;
    static final int BYTE_4 = 4;
    static final int BYTE_8 = 8;
    private static ByteArrayPools.ByteArray2Pool BYTE_ARRAY_2_POOL = new ByteArrayPools.ByteArray2Pool();
    private static ByteArrayPools.ByteArray4Pool BYTE_ARRAY_4_POOL = new ByteArrayPools.ByteArray4Pool();
    private static ByteArrayPools.ByteArray8Pool BYTE_ARRAY_8_POOL = new ByteArrayPools.ByteArray8Pool();
    private static ByteArrayPools.ByteArray127Pool BYTE_ARRAY_127_POOL = new ByteArrayPools.ByteArray127Pool();

    public static boolean readBoolean(BufferedInputStream bufferedInputStream) throws IOException {
        return bufferedInputStream.read() > 0;
    }

    public static boolean readBoolean2(BufferedInputStream bufferedInputStream) throws IOException {
        return readByte(bufferedInputStream) > 0;
    }

    public static byte readByte(BufferedInputStream bufferedInputStream) throws IOException {
        int read = bufferedInputStream.read();
        if (read != -1) {
            return (byte) read;
        }
        throw new IOException("end of the stream has been reached");
    }

    public static int readBytes(BufferedInputStream bufferedInputStream, byte[] bArr) throws IOException {
        int read = bufferedInputStream.read(bArr);
        if (read != -1) {
            return read;
        }
        throw new IOException("end of the stream has been reached, expect length " + bArr.length + " but got " + read);
    }

    public static int readBytes(BufferedInputStream bufferedInputStream, byte[] bArr, int i, int i2) throws IOException {
        int read = bufferedInputStream.read(bArr, i, i2);
        if (read != -1) {
            return read;
        }
        throw new IOException("end of the stream has been reached, expect count " + i2 + " but got " + read);
    }

    public static double readDouble(BufferedInputStream bufferedInputStream) throws IOException {
        byte[] obtain = BYTE_ARRAY_8_POOL.obtain();
        readBytes(bufferedInputStream, obtain);
        double d = ByteOrderValues.getDouble(obtain);
        BYTE_ARRAY_8_POOL.free(obtain);
        return d;
    }

    public static float readFloat(BufferedInputStream bufferedInputStream) throws IOException {
        byte[] obtain = BYTE_ARRAY_4_POOL.obtain();
        readBytes(bufferedInputStream, obtain);
        float f = ByteOrderValues.getFloat(obtain);
        BYTE_ARRAY_4_POOL.free(obtain);
        return f;
    }

    public static int readInt(BufferedInputStream bufferedInputStream) throws IOException {
        byte[] obtain = BYTE_ARRAY_4_POOL.obtain();
        readBytes(bufferedInputStream, obtain);
        int i = ByteOrderValues.getInt(obtain);
        BYTE_ARRAY_4_POOL.free(obtain);
        return i;
    }

    public static long readLong(BufferedInputStream bufferedInputStream) throws IOException {
        byte[] obtain = BYTE_ARRAY_8_POOL.obtain();
        readBytes(bufferedInputStream, obtain);
        long j = ByteOrderValues.getLong(obtain);
        BYTE_ARRAY_8_POOL.free(obtain);
        return j;
    }

    public static short readShort(BufferedInputStream bufferedInputStream) throws IOException {
        byte[] obtain = BYTE_ARRAY_2_POOL.obtain();
        readBytes(bufferedInputStream, obtain);
        short s = ByteOrderValues.getShort(obtain);
        BYTE_ARRAY_2_POOL.free(obtain);
        return s;
    }

    public static String readString(BufferedInputStream bufferedInputStream) throws IOException {
        int read = bufferedInputStream.read();
        if (read == 0) {
            return null;
        }
        if (read > BYTE_127) {
            byte[] bArr = new byte[read];
            bufferedInputStream.read(bArr);
            return new String(bArr, "utf-8");
        }
        byte[] obtain = BYTE_ARRAY_127_POOL.obtain();
        bufferedInputStream.read(obtain, 0, read);
        String str = new String(obtain, 0, read, "utf-8");
        BYTE_ARRAY_127_POOL.free(obtain);
        return str;
    }

    public static String readString2(BufferedInputStream bufferedInputStream) throws IOException {
        String str;
        int readInt = readInt(bufferedInputStream);
        if (readInt < 0) {
            return null;
        }
        if (readInt == 0) {
            return "";
        }
        if (readInt > BYTE_127) {
            synchronized (ByteOrderDataUtil.class) {
                byte[] bArr = new byte[readInt];
                readBytes(bufferedInputStream, bArr);
                str = new String(bArr, "utf-8");
            }
            return str;
        }
        byte[] obtain = BYTE_ARRAY_127_POOL.obtain();
        readBytes(bufferedInputStream, obtain, 0, readInt);
        String str2 = new String(obtain, 0, readInt, "utf-8");
        BYTE_ARRAY_127_POOL.free(obtain);
        return str2;
    }

    public static String[] readStringArray(BufferedInputStream bufferedInputStream) throws IOException {
        int read = bufferedInputStream.read();
        if (read == 0) {
            return null;
        }
        String[] strArr = new String[read];
        for (int i = 0; i < read; i++) {
            strArr[i] = readString(bufferedInputStream);
        }
        return strArr;
    }

    public static String[] readStringArray2(BufferedInputStream bufferedInputStream) throws IOException {
        int readInt = readInt(bufferedInputStream);
        if (readInt < 0) {
            return null;
        }
        if (readInt == 0) {
            return new String[0];
        }
        String[] strArr = new String[readInt];
        for (int i = 0; i < readInt; i++) {
            strArr[i] = readString2(bufferedInputStream);
        }
        return strArr;
    }

    public static List<String> readStringList(BufferedInputStream bufferedInputStream) throws IOException {
        int read = bufferedInputStream.read();
        if (read <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(read);
        for (int i = 0; i < read; i++) {
            arrayList.add(readString(bufferedInputStream));
        }
        return arrayList;
    }

    public static List<String> readStringList2(BufferedInputStream bufferedInputStream) throws IOException {
        int readInt = readInt(bufferedInputStream);
        if (readInt < 0) {
            return null;
        }
        if (readInt == 0) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            arrayList.add(readString2(bufferedInputStream));
        }
        return arrayList;
    }

    public static void writeBoolean(BufferedOutputStream bufferedOutputStream, boolean z) throws IOException {
        bufferedOutputStream.write(z ? 1 : 0);
    }

    public static void writeBoolean2(BufferedOutputStream bufferedOutputStream, boolean z) throws IOException {
        writeByte(bufferedOutputStream, z ? (byte) 1 : (byte) 0);
    }

    public static void writeByte(BufferedOutputStream bufferedOutputStream, byte b) throws IOException {
        bufferedOutputStream.write(b);
    }

    public static void writeDouble(BufferedOutputStream bufferedOutputStream, double d) throws IOException {
        byte[] obtain = BYTE_ARRAY_8_POOL.obtain();
        ByteOrderValues.putDouble(d, obtain);
        bufferedOutputStream.write(obtain);
        BYTE_ARRAY_8_POOL.free(obtain);
    }

    public static void writeFloat(BufferedOutputStream bufferedOutputStream, float f) throws IOException {
        byte[] obtain = BYTE_ARRAY_4_POOL.obtain();
        ByteOrderValues.putFloat(f, obtain);
        bufferedOutputStream.write(obtain);
        BYTE_ARRAY_4_POOL.free(obtain);
    }

    public static void writeInt(BufferedOutputStream bufferedOutputStream, int i) throws IOException {
        byte[] obtain = BYTE_ARRAY_4_POOL.obtain();
        ByteOrderValues.putInt(i, obtain);
        BYTE_ARRAY_4_POOL.free(obtain);
        bufferedOutputStream.write(obtain);
    }

    public static void writeLong(BufferedOutputStream bufferedOutputStream, long j) throws IOException {
        byte[] obtain = BYTE_ARRAY_8_POOL.obtain();
        ByteOrderValues.putLong(j, obtain);
        bufferedOutputStream.write(obtain);
        BYTE_ARRAY_8_POOL.free(obtain);
    }

    public static void writeShort(BufferedOutputStream bufferedOutputStream, short s) throws IOException {
        byte[] obtain = BYTE_ARRAY_2_POOL.obtain();
        ByteOrderValues.putShort(s, obtain);
        bufferedOutputStream.write(obtain);
        BYTE_ARRAY_2_POOL.free(obtain);
    }

    public static void writeString(BufferedOutputStream bufferedOutputStream, String str) throws IOException {
        if (str == null || str.length() == 0) {
            bufferedOutputStream.write(0);
            return;
        }
        byte[] bytes = str.getBytes();
        bufferedOutputStream.write(bytes.length);
        bufferedOutputStream.write(bytes);
    }

    public static void writeString2(BufferedOutputStream bufferedOutputStream, String str) throws IOException {
        if (str == null) {
            writeInt(bufferedOutputStream, -1);
        } else {
            if (str.length() == 0) {
                writeInt(bufferedOutputStream, 0);
                return;
            }
            byte[] bytes = str.getBytes();
            writeInt(bufferedOutputStream, bytes.length);
            bufferedOutputStream.write(bytes);
        }
    }

    public static void writeStringArray(BufferedOutputStream bufferedOutputStream, String[] strArr) throws IOException {
        if (strArr == null || strArr.length == 0) {
            bufferedOutputStream.write(0);
            return;
        }
        bufferedOutputStream.write(strArr.length);
        for (String str : strArr) {
            writeString(bufferedOutputStream, str);
        }
    }

    public static void writeStringArray2(BufferedOutputStream bufferedOutputStream, String[] strArr) throws IOException {
        if (strArr == null) {
            writeInt(bufferedOutputStream, -1);
            return;
        }
        if (strArr.length == 0) {
            writeInt(bufferedOutputStream, 0);
            return;
        }
        writeInt(bufferedOutputStream, strArr.length);
        for (String str : strArr) {
            writeString2(bufferedOutputStream, str);
        }
    }

    public static void writeStringList(BufferedOutputStream bufferedOutputStream, List<String> list) throws IOException {
        if (list == null || list.isEmpty()) {
            bufferedOutputStream.write(0);
            return;
        }
        bufferedOutputStream.write(list.size());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            writeString(bufferedOutputStream, it.next());
        }
    }

    public static void writeStringList2(BufferedOutputStream bufferedOutputStream, List<String> list) throws IOException {
        if (list == null) {
            writeInt(bufferedOutputStream, -1);
            return;
        }
        if (list.isEmpty()) {
            writeInt(bufferedOutputStream, 0);
            return;
        }
        writeInt(bufferedOutputStream, list.size());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            writeString2(bufferedOutputStream, it.next());
        }
    }
}
