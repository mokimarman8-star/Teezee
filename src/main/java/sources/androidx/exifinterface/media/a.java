package androidx.exifinterface.media;

import android.content.res.AssetManager;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.system.OsConstants;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import androidx.datastore.preferences.protobuf.DescriptorProtos$Edition;
import androidx.exifinterface.media.b;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import java.util.zip.CRC32;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class a {
    private static SimpleDateFormat T;
    private static SimpleDateFormat U;
    private static final d[] Y;
    private static final d[] Z;

    /* renamed from: a0, reason: collision with root package name */
    private static final d[] f7956a0;

    /* renamed from: b0, reason: collision with root package name */
    private static final d[] f7957b0;

    /* renamed from: c0, reason: collision with root package name */
    private static final d[] f7958c0;

    /* renamed from: d0, reason: collision with root package name */
    private static final d f7959d0;

    /* renamed from: e0, reason: collision with root package name */
    private static final d[] f7960e0;

    /* renamed from: f0, reason: collision with root package name */
    private static final d[] f7961f0;

    /* renamed from: g0, reason: collision with root package name */
    private static final d[] f7962g0;

    /* renamed from: h0, reason: collision with root package name */
    private static final d[] f7963h0;

    /* renamed from: i0, reason: collision with root package name */
    static final d[][] f7964i0;

    /* renamed from: j0, reason: collision with root package name */
    private static final d[] f7965j0;

    /* renamed from: k0, reason: collision with root package name */
    private static final HashMap[] f7966k0;

    /* renamed from: l0, reason: collision with root package name */
    private static final HashMap[] f7967l0;

    /* renamed from: m0, reason: collision with root package name */
    private static final HashSet f7968m0;

    /* renamed from: n0, reason: collision with root package name */
    private static final HashMap f7969n0;

    /* renamed from: o0, reason: collision with root package name */
    static final Charset f7970o0;

    /* renamed from: p0, reason: collision with root package name */
    static final byte[] f7971p0;

    /* renamed from: q0, reason: collision with root package name */
    private static final byte[] f7972q0;

    /* renamed from: r0, reason: collision with root package name */
    private static final Pattern f7973r0;

    /* renamed from: s0, reason: collision with root package name */
    private static final Pattern f7974s0;

    /* renamed from: t0, reason: collision with root package name */
    private static final Pattern f7975t0;

    /* renamed from: u0, reason: collision with root package name */
    private static final Pattern f7977u0;

    /* renamed from: a, reason: collision with root package name */
    private String f7983a;

    /* renamed from: b, reason: collision with root package name */
    private FileDescriptor f7984b;

    /* renamed from: c, reason: collision with root package name */
    private AssetManager.AssetInputStream f7985c;

    /* renamed from: d, reason: collision with root package name */
    private int f7986d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f7987e;

    /* renamed from: f, reason: collision with root package name */
    private final HashMap[] f7988f;

    /* renamed from: g, reason: collision with root package name */
    private Set f7989g;

    /* renamed from: h, reason: collision with root package name */
    private ByteOrder f7990h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f7991i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f7992j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f7993k;

    /* renamed from: l, reason: collision with root package name */
    private int f7994l;

    /* renamed from: m, reason: collision with root package name */
    private int f7995m;

    /* renamed from: n, reason: collision with root package name */
    private byte[] f7996n;

    /* renamed from: o, reason: collision with root package name */
    private int f7997o;

    /* renamed from: p, reason: collision with root package name */
    private int f7998p;

    /* renamed from: q, reason: collision with root package name */
    private int f7999q;

    /* renamed from: r, reason: collision with root package name */
    private int f8000r;

    /* renamed from: s, reason: collision with root package name */
    private int f8001s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f8002t;

    /* renamed from: u, reason: collision with root package name */
    private static final boolean f7976u = Log.isLoggable("ExifInterface", 3);

    /* renamed from: v, reason: collision with root package name */
    private static final List f7978v = Arrays.asList(1, 6, 3, 8);

    /* renamed from: w, reason: collision with root package name */
    private static final List f7979w = Arrays.asList(2, 7, 4, 5);

    /* renamed from: x, reason: collision with root package name */
    public static final int[] f7980x = {8, 8, 8};

    /* renamed from: y, reason: collision with root package name */
    public static final int[] f7981y = {4};

    /* renamed from: z, reason: collision with root package name */
    public static final int[] f7982z = {8};
    static final byte[] A = {-1, -40, -1};
    private static final byte[] B = {102, 116, 121, 112};
    private static final byte[] C = {109, 105, 102, 49};
    private static final byte[] D = {104, 101, 105, 99};
    private static final byte[] E = {79, 76, 89, 77, 80, 0};
    private static final byte[] F = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
    private static final byte[] G = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final byte[] H = {101, 88, 73, 102};
    private static final byte[] I = {73, 72, 68, 82};
    private static final byte[] J = {73, 69, 78, 68};
    private static final byte[] K = {82, 73, 70, 70};
    private static final byte[] L = {87, 69, 66, 80};
    private static final byte[] M = {69, 88, 73, 70};
    private static final byte[] N = {-99, 1, 42};
    private static final byte[] O = "VP8X".getBytes(Charset.defaultCharset());
    private static final byte[] P = "VP8L".getBytes(Charset.defaultCharset());
    private static final byte[] Q = "VP8 ".getBytes(Charset.defaultCharset());
    private static final byte[] R = "ANIM".getBytes(Charset.defaultCharset());
    private static final byte[] S = "ANMF".getBytes(Charset.defaultCharset());
    static final String[] V = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
    static final int[] W = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    static final byte[] X = {65, 83, 67, 73, 73, 0, 0, 0};

    /* renamed from: androidx.exifinterface.media.a$a, reason: collision with other inner class name */
    class C0062a extends MediaDataSource {

        /* renamed from: a, reason: collision with root package name */
        long f8003a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ f f8004b;

        C0062a(f fVar) {
            this.f8004b = fVar;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // android.media.MediaDataSource
        public long getSize() {
            return -1L;
        }

        @Override // android.media.MediaDataSource
        public int readAt(long j5, byte[] bArr, int i5, int i6) {
            if (i6 == 0) {
                return 0;
            }
            if (j5 < 0) {
                return -1;
            }
            try {
                long j6 = this.f8003a;
                if (j6 != j5) {
                    if (j6 >= 0 && j5 >= j6 + this.f8004b.available()) {
                        return -1;
                    }
                    this.f8004b.l(j5);
                    this.f8003a = j5;
                }
                if (i6 > this.f8004b.available()) {
                    i6 = this.f8004b.available();
                }
                int read = this.f8004b.read(bArr, i5, i6);
                if (read >= 0) {
                    this.f8003a += read;
                    return read;
                }
            } catch (IOException unused) {
            }
            this.f8003a = -1L;
            return -1;
        }
    }

    private static class b extends InputStream implements DataInput {

        /* renamed from: e, reason: collision with root package name */
        private static final ByteOrder f8006e = ByteOrder.LITTLE_ENDIAN;

        /* renamed from: f, reason: collision with root package name */
        private static final ByteOrder f8007f = ByteOrder.BIG_ENDIAN;

        /* renamed from: a, reason: collision with root package name */
        final DataInputStream f8008a;

        /* renamed from: b, reason: collision with root package name */
        private ByteOrder f8009b;

        /* renamed from: c, reason: collision with root package name */
        int f8010c;

        /* renamed from: d, reason: collision with root package name */
        private byte[] f8011d;

        b(InputStream inputStream) {
            this(inputStream, ByteOrder.BIG_ENDIAN);
        }

        b(InputStream inputStream, ByteOrder byteOrder) {
            this.f8009b = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.f8008a = dataInputStream;
            dataInputStream.mark(0);
            this.f8010c = 0;
            this.f8009b = byteOrder;
        }

        b(byte[] bArr) {
            this(new ByteArrayInputStream(bArr), ByteOrder.BIG_ENDIAN);
        }

        @Override // java.io.InputStream
        public int available() {
            return this.f8008a.available();
        }

        public int d() {
            return this.f8010c;
        }

        public long h() {
            return readInt() & 4294967295L;
        }

        public void j(ByteOrder byteOrder) {
            this.f8009b = byteOrder;
        }

        public void k(int i5) {
            int i6 = 0;
            while (i6 < i5) {
                int i7 = i5 - i6;
                int skip = (int) this.f8008a.skip(i7);
                if (skip <= 0) {
                    if (this.f8011d == null) {
                        this.f8011d = new byte[8192];
                    }
                    skip = this.f8008a.read(this.f8011d, 0, Math.min(8192, i7));
                    if (skip == -1) {
                        throw new EOFException("Reached EOF while skipping " + i5 + " bytes.");
                    }
                }
                i6 += skip;
            }
            this.f8010c += i6;
        }

        @Override // java.io.InputStream
        public void mark(int i5) {
            throw new UnsupportedOperationException("Mark is currently unsupported");
        }

        @Override // java.io.InputStream
        public int read() {
            this.f8010c++;
            return this.f8008a.read();
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i5, int i6) {
            int read = this.f8008a.read(bArr, i5, i6);
            this.f8010c += read;
            return read;
        }

        @Override // java.io.DataInput
        public boolean readBoolean() {
            this.f8010c++;
            return this.f8008a.readBoolean();
        }

        @Override // java.io.DataInput
        public byte readByte() {
            this.f8010c++;
            int read = this.f8008a.read();
            if (read >= 0) {
                return (byte) read;
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public char readChar() {
            this.f8010c += 2;
            return this.f8008a.readChar();
        }

        @Override // java.io.DataInput
        public double readDouble() {
            return Double.longBitsToDouble(readLong());
        }

        @Override // java.io.DataInput
        public float readFloat() {
            return Float.intBitsToFloat(readInt());
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr) {
            this.f8010c += bArr.length;
            this.f8008a.readFully(bArr);
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr, int i5, int i6) {
            this.f8010c += i6;
            this.f8008a.readFully(bArr, i5, i6);
        }

        @Override // java.io.DataInput
        public int readInt() {
            this.f8010c += 4;
            int read = this.f8008a.read();
            int read2 = this.f8008a.read();
            int read3 = this.f8008a.read();
            int read4 = this.f8008a.read();
            if ((read | read2 | read3 | read4) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f8009b;
            if (byteOrder == f8006e) {
                return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
            }
            if (byteOrder == f8007f) {
                return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
            }
            throw new IOException("Invalid byte order: " + this.f8009b);
        }

        @Override // java.io.DataInput
        public String readLine() {
            return null;
        }

        @Override // java.io.DataInput
        public long readLong() {
            this.f8010c += 8;
            int read = this.f8008a.read();
            int read2 = this.f8008a.read();
            int read3 = this.f8008a.read();
            int read4 = this.f8008a.read();
            int read5 = this.f8008a.read();
            int read6 = this.f8008a.read();
            int read7 = this.f8008a.read();
            int read8 = this.f8008a.read();
            if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f8009b;
            if (byteOrder == f8006e) {
                return (read8 << 56) + (read7 << 48) + (read6 << 40) + (read5 << 32) + (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
            }
            if (byteOrder == f8007f) {
                return (read << 56) + (read2 << 48) + (read3 << 40) + (read4 << 32) + (read5 << 24) + (read6 << 16) + (read7 << 8) + read8;
            }
            throw new IOException("Invalid byte order: " + this.f8009b);
        }

        @Override // java.io.DataInput
        public short readShort() {
            this.f8010c += 2;
            int read = this.f8008a.read();
            int read2 = this.f8008a.read();
            if ((read | read2) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f8009b;
            if (byteOrder == f8006e) {
                return (short) ((read2 << 8) + read);
            }
            if (byteOrder == f8007f) {
                return (short) ((read << 8) + read2);
            }
            throw new IOException("Invalid byte order: " + this.f8009b);
        }

        @Override // java.io.DataInput
        public String readUTF() {
            this.f8010c += 2;
            return this.f8008a.readUTF();
        }

        @Override // java.io.DataInput
        public int readUnsignedByte() {
            this.f8010c++;
            return this.f8008a.readUnsignedByte();
        }

        @Override // java.io.DataInput
        public int readUnsignedShort() {
            this.f8010c += 2;
            int read = this.f8008a.read();
            int read2 = this.f8008a.read();
            if ((read | read2) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f8009b;
            if (byteOrder == f8006e) {
                return (read2 << 8) + read;
            }
            if (byteOrder == f8007f) {
                return (read << 8) + read2;
            }
            throw new IOException("Invalid byte order: " + this.f8009b);
        }

        @Override // java.io.InputStream
        public void reset() {
            throw new UnsupportedOperationException("Reset is currently unsupported");
        }

        @Override // java.io.DataInput
        public int skipBytes(int i5) {
            throw new UnsupportedOperationException("skipBytes is currently unsupported");
        }
    }

    private static class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f8012a;

        /* renamed from: b, reason: collision with root package name */
        public final int f8013b;

        /* renamed from: c, reason: collision with root package name */
        public final long f8014c;

        /* renamed from: d, reason: collision with root package name */
        public final byte[] f8015d;

        c(int i5, int i6, long j5, byte[] bArr) {
            this.f8012a = i5;
            this.f8013b = i6;
            this.f8014c = j5;
            this.f8015d = bArr;
        }

        c(int i5, int i6, byte[] bArr) {
            this(i5, i6, -1L, bArr);
        }

        public static c a(String str) {
            byte[] bytes = (str + (char) 0).getBytes(a.f7970o0);
            return new c(2, bytes.length, bytes);
        }

        public static c b(long j5, ByteOrder byteOrder) {
            return c(new long[]{j5}, byteOrder);
        }

        public static c c(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[a.W[4] * jArr.length]);
            wrap.order(byteOrder);
            for (long j5 : jArr) {
                wrap.putInt((int) j5);
            }
            return new c(4, jArr.length, wrap.array());
        }

        public static c d(e eVar, ByteOrder byteOrder) {
            return e(new e[]{eVar}, byteOrder);
        }

        public static c e(e[] eVarArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[a.W[5] * eVarArr.length]);
            wrap.order(byteOrder);
            for (e eVar : eVarArr) {
                wrap.putInt((int) eVar.f8020a);
                wrap.putInt((int) eVar.f8021b);
            }
            return new c(5, eVarArr.length, wrap.array());
        }

        public static c f(int i5, ByteOrder byteOrder) {
            return g(new int[]{i5}, byteOrder);
        }

        public static c g(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[a.W[3] * iArr.length]);
            wrap.order(byteOrder);
            for (int i5 : iArr) {
                wrap.putShort((short) i5);
            }
            return new c(3, iArr.length, wrap.array());
        }

        public double h(ByteOrder byteOrder) {
            Object k5 = k(byteOrder);
            if (k5 == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            }
            if (k5 instanceof String) {
                return Double.parseDouble((String) k5);
            }
            if (k5 instanceof long[]) {
                if (((long[]) k5).length == 1) {
                    return r5[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (k5 instanceof int[]) {
                if (((int[]) k5).length == 1) {
                    return r5[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (k5 instanceof double[]) {
                double[] dArr = (double[]) k5;
                if (dArr.length == 1) {
                    return dArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (!(k5 instanceof e[])) {
                throw new NumberFormatException("Couldn't find a double value");
            }
            e[] eVarArr = (e[]) k5;
            if (eVarArr.length == 1) {
                return eVarArr[0].a();
            }
            throw new NumberFormatException("There are more than one component");
        }

        public int i(ByteOrder byteOrder) {
            Object k5 = k(byteOrder);
            if (k5 == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            }
            if (k5 instanceof String) {
                return Integer.parseInt((String) k5);
            }
            if (k5 instanceof long[]) {
                long[] jArr = (long[]) k5;
                if (jArr.length == 1) {
                    return (int) jArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (!(k5 instanceof int[])) {
                throw new NumberFormatException("Couldn't find a integer value");
            }
            int[] iArr = (int[]) k5;
            if (iArr.length == 1) {
                return iArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }

        public String j(ByteOrder byteOrder) {
            Object k5 = k(byteOrder);
            if (k5 == null) {
                return null;
            }
            if (k5 instanceof String) {
                return (String) k5;
            }
            StringBuilder sb = new StringBuilder();
            int i5 = 0;
            if (k5 instanceof long[]) {
                long[] jArr = (long[]) k5;
                while (i5 < jArr.length) {
                    sb.append(jArr[i5]);
                    i5++;
                    if (i5 != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (k5 instanceof int[]) {
                int[] iArr = (int[]) k5;
                while (i5 < iArr.length) {
                    sb.append(iArr[i5]);
                    i5++;
                    if (i5 != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (k5 instanceof double[]) {
                double[] dArr = (double[]) k5;
                while (i5 < dArr.length) {
                    sb.append(dArr[i5]);
                    i5++;
                    if (i5 != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (!(k5 instanceof e[])) {
                return null;
            }
            e[] eVarArr = (e[]) k5;
            while (i5 < eVarArr.length) {
                sb.append(eVarArr[i5].f8020a);
                sb.append('/');
                sb.append(eVarArr[i5].f8021b);
                i5++;
                if (i5 != eVarArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }

        /* JADX WARN: Not initialized variable reg: 5, insn: 0x0030: MOVE (r4 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:166:0x0030 */
        /* JADX WARN: Removed duplicated region for block: B:169:0x018f A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        Object k(ByteOrder byteOrder) {
            b bVar;
            InputStream inputStream;
            byte b5;
            byte b6;
            int i5 = 0;
            InputStream inputStream2 = null;
            try {
                try {
                    bVar = new b(this.f8015d);
                    try {
                        bVar.j(byteOrder);
                        switch (this.f8012a) {
                            case 1:
                            case 6:
                                byte[] bArr = this.f8015d;
                                if (bArr.length != 1 || (b5 = bArr[0]) < 0 || b5 > 1) {
                                    String str = new String(bArr, a.f7970o0);
                                    try {
                                        bVar.close();
                                    } catch (IOException e5) {
                                        Log.e("ExifInterface", "IOException occurred while closing InputStream", e5);
                                    }
                                    return str;
                                }
                                String str2 = new String(new char[]{(char) (b5 + 48)});
                                try {
                                    bVar.close();
                                } catch (IOException e6) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e6);
                                }
                                return str2;
                            case 2:
                            case 7:
                                if (this.f8013b >= a.X.length) {
                                    int i6 = 0;
                                    while (true) {
                                        byte[] bArr2 = a.X;
                                        if (i6 >= bArr2.length) {
                                            i5 = bArr2.length;
                                        } else if (this.f8015d[i6] == bArr2[i6]) {
                                            i6++;
                                        }
                                    }
                                }
                                StringBuilder sb = new StringBuilder();
                                while (i5 < this.f8013b && (b6 = this.f8015d[i5]) != 0) {
                                    if (b6 >= 32) {
                                        sb.append((char) b6);
                                    } else {
                                        sb.append('?');
                                    }
                                    i5++;
                                }
                                String sb2 = sb.toString();
                                try {
                                    bVar.close();
                                } catch (IOException e7) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e7);
                                }
                                return sb2;
                            case 3:
                                int[] iArr = new int[this.f8013b];
                                while (i5 < this.f8013b) {
                                    iArr[i5] = bVar.readUnsignedShort();
                                    i5++;
                                }
                                try {
                                    bVar.close();
                                } catch (IOException e8) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e8);
                                }
                                return iArr;
                            case 4:
                                long[] jArr = new long[this.f8013b];
                                while (i5 < this.f8013b) {
                                    jArr[i5] = bVar.h();
                                    i5++;
                                }
                                try {
                                    bVar.close();
                                } catch (IOException e9) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e9);
                                }
                                return jArr;
                            case 5:
                                e[] eVarArr = new e[this.f8013b];
                                while (i5 < this.f8013b) {
                                    eVarArr[i5] = new e(bVar.h(), bVar.h());
                                    i5++;
                                }
                                try {
                                    bVar.close();
                                } catch (IOException e10) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e10);
                                }
                                return eVarArr;
                            case 8:
                                int[] iArr2 = new int[this.f8013b];
                                while (i5 < this.f8013b) {
                                    iArr2[i5] = bVar.readShort();
                                    i5++;
                                }
                                try {
                                    bVar.close();
                                } catch (IOException e11) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e11);
                                }
                                return iArr2;
                            case 9:
                                int[] iArr3 = new int[this.f8013b];
                                while (i5 < this.f8013b) {
                                    iArr3[i5] = bVar.readInt();
                                    i5++;
                                }
                                try {
                                    bVar.close();
                                } catch (IOException e12) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e12);
                                }
                                return iArr3;
                            case 10:
                                e[] eVarArr2 = new e[this.f8013b];
                                while (i5 < this.f8013b) {
                                    eVarArr2[i5] = new e(bVar.readInt(), bVar.readInt());
                                    i5++;
                                }
                                try {
                                    bVar.close();
                                } catch (IOException e13) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e13);
                                }
                                return eVarArr2;
                            case 11:
                                double[] dArr = new double[this.f8013b];
                                while (i5 < this.f8013b) {
                                    dArr[i5] = bVar.readFloat();
                                    i5++;
                                }
                                try {
                                    bVar.close();
                                } catch (IOException e14) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e14);
                                }
                                return dArr;
                            case 12:
                                double[] dArr2 = new double[this.f8013b];
                                while (i5 < this.f8013b) {
                                    dArr2[i5] = bVar.readDouble();
                                    i5++;
                                }
                                try {
                                    bVar.close();
                                } catch (IOException e15) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e15);
                                }
                                return dArr2;
                            default:
                                try {
                                    bVar.close();
                                } catch (IOException e16) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e16);
                                }
                                return null;
                        }
                    } catch (IOException e17) {
                        e = e17;
                        Log.w("ExifInterface", "IOException occurred during reading a value", e);
                        if (bVar != null) {
                            try {
                                bVar.close();
                            } catch (IOException e18) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e18);
                            }
                        }
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    inputStream2 = inputStream;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException e19) {
                            Log.e("ExifInterface", "IOException occurred while closing InputStream", e19);
                        }
                    }
                    throw th;
                }
            } catch (IOException e20) {
                e = e20;
                bVar = null;
            } catch (Throwable th2) {
                th = th2;
                if (inputStream2 != null) {
                }
                throw th;
            }
        }

        public String toString() {
            return "(" + a.V[this.f8012a] + ", data length:" + this.f8015d.length + ")";
        }
    }

    static class d {

        /* renamed from: a, reason: collision with root package name */
        public final int f8016a;

        /* renamed from: b, reason: collision with root package name */
        public final String f8017b;

        /* renamed from: c, reason: collision with root package name */
        public final int f8018c;

        /* renamed from: d, reason: collision with root package name */
        public final int f8019d;

        d(String str, int i5, int i6) {
            this.f8017b = str;
            this.f8016a = i5;
            this.f8018c = i6;
            this.f8019d = -1;
        }

        d(String str, int i5, int i6, int i7) {
            this.f8017b = str;
            this.f8016a = i5;
            this.f8018c = i6;
            this.f8019d = i7;
        }

        boolean a(int i5) {
            int i6;
            int i7 = this.f8018c;
            if (i7 == 7 || i5 == 7 || i7 == i5 || (i6 = this.f8019d) == i5) {
                return true;
            }
            if ((i7 == 4 || i6 == 4) && i5 == 3) {
                return true;
            }
            if ((i7 == 9 || i6 == 9) && i5 == 8) {
                return true;
            }
            return (i7 == 12 || i6 == 12) && i5 == 11;
        }
    }

    private static class e {

        /* renamed from: a, reason: collision with root package name */
        public final long f8020a;

        /* renamed from: b, reason: collision with root package name */
        public final long f8021b;

        e(long j5, long j6) {
            if (j6 == 0) {
                this.f8020a = 0L;
                this.f8021b = 1L;
            } else {
                this.f8020a = j5;
                this.f8021b = j6;
            }
        }

        public double a() {
            return this.f8020a / this.f8021b;
        }

        public String toString() {
            return this.f8020a + "/" + this.f8021b;
        }
    }

    private static class f extends b {
        f(InputStream inputStream) {
            super(inputStream);
            if (!inputStream.markSupported()) {
                throw new IllegalArgumentException("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
            }
            this.f8008a.mark(DescriptorProtos$Edition.EDITION_MAX_VALUE);
        }

        f(byte[] bArr) {
            super(bArr);
            this.f8008a.mark(DescriptorProtos$Edition.EDITION_MAX_VALUE);
        }

        public void l(long j5) {
            int i5 = this.f8010c;
            if (i5 > j5) {
                this.f8010c = 0;
                this.f8008a.reset();
            } else {
                j5 -= i5;
            }
            k((int) j5);
        }
    }

    static {
        d[] dVarArr = {new d("NewSubfileType", 254, 4), new d("SubfileType", 255, 4), new d("ImageWidth", 256, 3, 4), new d("ImageLength", InputDeviceCompat.SOURCE_KEYBOARD, 3, 4), new d("BitsPerSample", 258, 3), new d("Compression", 259, 3), new d("PhotometricInterpretation", 262, 3), new d("ImageDescription", 270, 2), new d("Make", 271, 2), new d("Model", 272, 2), new d("StripOffsets", 273, 3, 4), new d("Orientation", 274, 3), new d("SamplesPerPixel", 277, 3), new d("RowsPerStrip", 278, 3, 4), new d("StripByteCounts", 279, 3, 4), new d("XResolution", 282, 5), new d("YResolution", 283, 5), new d("PlanarConfiguration", 284, 3), new d("ResolutionUnit", 296, 3), new d("TransferFunction", 301, 3), new d("Software", 305, 2), new d("DateTime", 306, 2), new d("Artist", 315, 2), new d("WhitePoint", 318, 5), new d("PrimaryChromaticities", 319, 5), new d("SubIFDPointer", 330, 4), new d("JPEGInterchangeFormat", InputDeviceCompat.SOURCE_DPAD, 4), new d("JPEGInterchangeFormatLength", 514, 4), new d("YCbCrCoefficients", 529, 5), new d("YCbCrSubSampling", 530, 3), new d("YCbCrPositioning", 531, 3), new d("ReferenceBlackWhite", 532, 5), new d("Copyright", 33432, 2), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d("SensorTopBorder", 4, 4), new d("SensorLeftBorder", 5, 4), new d("SensorBottomBorder", 6, 4), new d("SensorRightBorder", 7, 4), new d("ISO", 23, 3), new d("JpgFromRaw", 46, 7), new d("Xmp", 700, 1)};
        Y = dVarArr;
        d[] dVarArr2 = {new d("ExposureTime", 33434, 5), new d("FNumber", 33437, 5), new d("ExposureProgram", 34850, 3), new d("SpectralSensitivity", 34852, 2), new d("PhotographicSensitivity", 34855, 3), new d("OECF", 34856, 7), new d("SensitivityType", 34864, 3), new d("StandardOutputSensitivity", 34865, 4), new d("RecommendedExposureIndex", 34866, 4), new d("ISOSpeed", 34867, 4), new d("ISOSpeedLatitudeyyy", 34868, 4), new d("ISOSpeedLatitudezzz", 34869, 4), new d("ExifVersion", 36864, 2), new d("DateTimeOriginal", 36867, 2), new d("DateTimeDigitized", 36868, 2), new d("OffsetTime", 36880, 2), new d("OffsetTimeOriginal", 36881, 2), new d("OffsetTimeDigitized", 36882, 2), new d("ComponentsConfiguration", 37121, 7), new d("CompressedBitsPerPixel", 37122, 5), new d("ShutterSpeedValue", 37377, 10), new d("ApertureValue", 37378, 5), new d("BrightnessValue", 37379, 10), new d("ExposureBiasValue", 37380, 10), new d("MaxApertureValue", 37381, 5), new d("SubjectDistance", 37382, 5), new d("MeteringMode", 37383, 3), new d("LightSource", 37384, 3), new d("Flash", 37385, 3), new d("FocalLength", 37386, 5), new d("SubjectArea", 37396, 3), new d("MakerNote", 37500, 7), new d("UserComment", 37510, 7), new d("SubSecTime", 37520, 2), new d("SubSecTimeOriginal", 37521, 2), new d("SubSecTimeDigitized", 37522, 2), new d("FlashpixVersion", 40960, 7), new d("ColorSpace", 40961, 3), new d("PixelXDimension", 40962, 3, 4), new d("PixelYDimension", 40963, 3, 4), new d("RelatedSoundFile", 40964, 2), new d("InteroperabilityIFDPointer", 40965, 4), new d("FlashEnergy", 41483, 5), new d("SpatialFrequencyResponse", 41484, 7), new d("FocalPlaneXResolution", 41486, 5), new d("FocalPlaneYResolution", 41487, 5), new d("FocalPlaneResolutionUnit", 41488, 3), new d("SubjectLocation", 41492, 3), new d("ExposureIndex", 41493, 5), new d("SensingMethod", 41495, 3), new d("FileSource", 41728, 7), new d("SceneType", 41729, 7), new d("CFAPattern", 41730, 7), new d("CustomRendered", 41985, 3), new d("ExposureMode", 41986, 3), new d("WhiteBalance", 41987, 3), new d("DigitalZoomRatio", 41988, 5), new d("FocalLengthIn35mmFilm", 41989, 3), new d("SceneCaptureType", 41990, 3), new d("GainControl", 41991, 3), new d("Contrast", 41992, 3), new d("Saturation", 41993, 3), new d("Sharpness", 41994, 3), new d("DeviceSettingDescription", 41995, 7), new d("SubjectDistanceRange", 41996, 3), new d("ImageUniqueID", 42016, 2), new d("CameraOwnerName", 42032, 2), new d("BodySerialNumber", 42033, 2), new d("LensSpecification", 42034, 5), new d("LensMake", 42035, 2), new d("LensModel", 42036, 2), new d("Gamma", 42240, 5), new d("DNGVersion", 50706, 1), new d("DefaultCropSize", 50720, 3, 4)};
        Z = dVarArr2;
        d[] dVarArr3 = {new d("GPSVersionID", 0, 1), new d("GPSLatitudeRef", 1, 2), new d("GPSLatitude", 2, 5, 10), new d("GPSLongitudeRef", 3, 2), new d("GPSLongitude", 4, 5, 10), new d("GPSAltitudeRef", 5, 1), new d("GPSAltitude", 6, 5), new d("GPSTimeStamp", 7, 5), new d("GPSSatellites", 8, 2), new d("GPSStatus", 9, 2), new d("GPSMeasureMode", 10, 2), new d("GPSDOP", 11, 5), new d("GPSSpeedRef", 12, 2), new d("GPSSpeed", 13, 5), new d("GPSTrackRef", 14, 2), new d("GPSTrack", 15, 5), new d("GPSImgDirectionRef", 16, 2), new d("GPSImgDirection", 17, 5), new d("GPSMapDatum", 18, 2), new d("GPSDestLatitudeRef", 19, 2), new d("GPSDestLatitude", 20, 5), new d("GPSDestLongitudeRef", 21, 2), new d("GPSDestLongitude", 22, 5), new d("GPSDestBearingRef", 23, 2), new d("GPSDestBearing", 24, 5), new d("GPSDestDistanceRef", 25, 2), new d("GPSDestDistance", 26, 5), new d("GPSProcessingMethod", 27, 7), new d("GPSAreaInformation", 28, 7), new d("GPSDateStamp", 29, 2), new d("GPSDifferential", 30, 3), new d("GPSHPositioningError", 31, 5)};
        f7956a0 = dVarArr3;
        d[] dVarArr4 = {new d("InteroperabilityIndex", 1, 2)};
        f7957b0 = dVarArr4;
        d[] dVarArr5 = {new d("NewSubfileType", 254, 4), new d("SubfileType", 255, 4), new d("ThumbnailImageWidth", 256, 3, 4), new d("ThumbnailImageLength", InputDeviceCompat.SOURCE_KEYBOARD, 3, 4), new d("BitsPerSample", 258, 3), new d("Compression", 259, 3), new d("PhotometricInterpretation", 262, 3), new d("ImageDescription", 270, 2), new d("Make", 271, 2), new d("Model", 272, 2), new d("StripOffsets", 273, 3, 4), new d("ThumbnailOrientation", 274, 3), new d("SamplesPerPixel", 277, 3), new d("RowsPerStrip", 278, 3, 4), new d("StripByteCounts", 279, 3, 4), new d("XResolution", 282, 5), new d("YResolution", 283, 5), new d("PlanarConfiguration", 284, 3), new d("ResolutionUnit", 296, 3), new d("TransferFunction", 301, 3), new d("Software", 305, 2), new d("DateTime", 306, 2), new d("Artist", 315, 2), new d("WhitePoint", 318, 5), new d("PrimaryChromaticities", 319, 5), new d("SubIFDPointer", 330, 4), new d("JPEGInterchangeFormat", InputDeviceCompat.SOURCE_DPAD, 4), new d("JPEGInterchangeFormatLength", 514, 4), new d("YCbCrCoefficients", 529, 5), new d("YCbCrSubSampling", 530, 3), new d("YCbCrPositioning", 531, 3), new d("ReferenceBlackWhite", 532, 5), new d("Copyright", 33432, 2), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d("DNGVersion", 50706, 1), new d("DefaultCropSize", 50720, 3, 4)};
        f7958c0 = dVarArr5;
        f7959d0 = new d("StripOffsets", 273, 3);
        d[] dVarArr6 = {new d("ThumbnailImage", 256, 7), new d("CameraSettingsIFDPointer", 8224, 4), new d("ImageProcessingIFDPointer", 8256, 4)};
        f7960e0 = dVarArr6;
        d[] dVarArr7 = {new d("PreviewImageStart", InputDeviceCompat.SOURCE_KEYBOARD, 4), new d("PreviewImageLength", 258, 4)};
        f7961f0 = dVarArr7;
        d[] dVarArr8 = {new d("AspectFrame", 4371, 3)};
        f7962g0 = dVarArr8;
        d[] dVarArr9 = {new d("ColorSpace", 55, 3)};
        f7963h0 = dVarArr9;
        d[][] dVarArr10 = {dVarArr, dVarArr2, dVarArr3, dVarArr4, dVarArr5, dVarArr, dVarArr6, dVarArr7, dVarArr8, dVarArr9};
        f7964i0 = dVarArr10;
        f7965j0 = new d[]{new d("SubIFDPointer", 330, 4), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d("InteroperabilityIFDPointer", 40965, 4), new d("CameraSettingsIFDPointer", 8224, 1), new d("ImageProcessingIFDPointer", 8256, 1)};
        f7966k0 = new HashMap[dVarArr10.length];
        f7967l0 = new HashMap[dVarArr10.length];
        f7968m0 = new HashSet(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
        f7969n0 = new HashMap();
        Charset forName = Charset.forName("US-ASCII");
        f7970o0 = forName;
        f7971p0 = "Exif\u0000\u0000".getBytes(forName);
        f7972q0 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(forName);
        Locale locale = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale);
        T = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);
        U = simpleDateFormat2;
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("UTC"));
        int i5 = 0;
        while (true) {
            d[][] dVarArr11 = f7964i0;
            if (i5 >= dVarArr11.length) {
                HashMap hashMap = f7969n0;
                d[] dVarArr12 = f7965j0;
                hashMap.put(Integer.valueOf(dVarArr12[0].f8016a), 5);
                hashMap.put(Integer.valueOf(dVarArr12[1].f8016a), 1);
                hashMap.put(Integer.valueOf(dVarArr12[2].f8016a), 2);
                hashMap.put(Integer.valueOf(dVarArr12[3].f8016a), 3);
                hashMap.put(Integer.valueOf(dVarArr12[4].f8016a), 7);
                hashMap.put(Integer.valueOf(dVarArr12[5].f8016a), 8);
                f7973r0 = Pattern.compile(".*[1-9].*");
                f7974s0 = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
                f7975t0 = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                f7977u0 = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                return;
            }
            f7966k0[i5] = new HashMap();
            f7967l0[i5] = new HashMap();
            for (d dVar : dVarArr11[i5]) {
                f7966k0[i5].put(Integer.valueOf(dVar.f8016a), dVar);
                f7967l0[i5].put(dVar.f8017b, dVar);
            }
            i5++;
        }
    }

    public a(InputStream inputStream) {
        this(inputStream, 0);
    }

    public a(InputStream inputStream, int i5) {
        d[][] dVarArr = f7964i0;
        this.f7988f = new HashMap[dVarArr.length];
        this.f7989g = new HashSet(dVarArr.length);
        this.f7990h = ByteOrder.BIG_ENDIAN;
        if (inputStream == null) {
            throw new NullPointerException("inputStream cannot be null");
        }
        this.f7983a = null;
        if (i5 == 1) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, f7971p0.length);
            if (!r(bufferedInputStream)) {
                Log.w("ExifInterface", "Given data does not follow the structure of an Exif-only data.");
                return;
            }
            this.f7987e = true;
            this.f7985c = null;
            this.f7984b = null;
            inputStream = bufferedInputStream;
        } else if (inputStream instanceof AssetManager.AssetInputStream) {
            this.f7985c = (AssetManager.AssetInputStream) inputStream;
            this.f7984b = null;
        } else {
            if (inputStream instanceof FileInputStream) {
                FileInputStream fileInputStream = (FileInputStream) inputStream;
                if (y(fileInputStream.getFD())) {
                    this.f7985c = null;
                    this.f7984b = fileInputStream.getFD();
                }
            }
            this.f7985c = null;
            this.f7984b = null;
        }
        C(inputStream);
    }

    private boolean A(HashMap hashMap) {
        c cVar = (c) hashMap.get("ImageLength");
        c cVar2 = (c) hashMap.get("ImageWidth");
        if (cVar == null || cVar2 == null) {
            return false;
        }
        return cVar.i(this.f7990h) <= 512 && cVar2.i(this.f7990h) <= 512;
    }

    private boolean B(byte[] bArr) {
        int i5 = 0;
        while (true) {
            byte[] bArr2 = K;
            if (i5 >= bArr2.length) {
                int i6 = 0;
                while (true) {
                    byte[] bArr3 = L;
                    if (i6 >= bArr3.length) {
                        return true;
                    }
                    if (bArr[K.length + i6 + 4] != bArr3[i6]) {
                        return false;
                    }
                    i6++;
                }
            } else {
                if (bArr[i5] != bArr2[i5]) {
                    return false;
                }
                i5++;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x009f A[Catch: all -> 0x0015, TRY_LEAVE, TryCatch #0 {all -> 0x0015, blocks: (B:4:0x0004, B:6:0x0009, B:8:0x001e, B:10:0x0022, B:11:0x0030, B:13:0x0038, B:15:0x0041, B:16:0x0061, B:23:0x0045, B:25:0x004b, B:28:0x0052, B:31:0x005a, B:32:0x005e, B:33:0x006b, B:35:0x0075, B:38:0x007d, B:41:0x0085, B:44:0x008d, B:53:0x009b, B:55:0x009f), top: B:3:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void C(InputStream inputStream) {
        boolean z5;
        if (inputStream == null) {
            throw new NullPointerException("inputstream shouldn't be null");
        }
        for (int i5 = 0; i5 < f7964i0.length; i5++) {
            try {
                try {
                    this.f7988f[i5] = new HashMap();
                } catch (Throwable th) {
                    a();
                    if (f7976u) {
                        E();
                    }
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
                z5 = f7976u;
                if (z5) {
                    Log.w("ExifInterface", "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface.", e);
                }
                a();
                if (!z5) {
                    return;
                }
                E();
            } catch (UnsupportedOperationException e6) {
                e = e6;
                z5 = f7976u;
                if (z5) {
                }
                a();
                if (!z5) {
                }
                E();
            }
        }
        if (!this.f7987e) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
            this.f7986d = g(bufferedInputStream);
            inputStream = bufferedInputStream;
        }
        if (L(this.f7986d)) {
            f fVar = new f(inputStream);
            if (this.f7987e) {
                n(fVar);
            } else {
                int i6 = this.f7986d;
                if (i6 == 12) {
                    e(fVar);
                } else if (i6 == 7) {
                    h(fVar);
                } else if (i6 == 10) {
                    m(fVar);
                } else {
                    k(fVar);
                }
            }
            fVar.l(this.f7998p);
            K(fVar);
        } else {
            b bVar = new b(inputStream);
            int i7 = this.f7986d;
            if (i7 == 4) {
                f(bVar, 0, 0);
            } else if (i7 == 13) {
                i(bVar);
            } else if (i7 == 9) {
                j(bVar);
            } else if (i7 == 14) {
                o(bVar);
            }
        }
        a();
        if (!f7976u) {
            return;
        }
        E();
    }

    private void D(b bVar) {
        ByteOrder F2 = F(bVar);
        this.f7990h = F2;
        bVar.j(F2);
        int readUnsignedShort = bVar.readUnsignedShort();
        int i5 = this.f7986d;
        if (i5 != 7 && i5 != 10 && readUnsignedShort != 42) {
            throw new IOException("Invalid start code: " + Integer.toHexString(readUnsignedShort));
        }
        int readInt = bVar.readInt();
        if (readInt < 8) {
            throw new IOException("Invalid first Ifd offset: " + readInt);
        }
        int i6 = readInt - 8;
        if (i6 > 0) {
            bVar.k(i6);
        }
    }

    private void E() {
        for (int i5 = 0; i5 < this.f7988f.length; i5++) {
            StringBuilder sb = new StringBuilder();
            sb.append("The size of tag group[");
            sb.append(i5);
            sb.append("]: ");
            sb.append(this.f7988f[i5].size());
            for (Map.Entry entry : this.f7988f[i5].entrySet()) {
                c cVar = (c) entry.getValue();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("tagName: ");
                sb2.append((String) entry.getKey());
                sb2.append(", tagType: ");
                sb2.append(cVar.toString());
                sb2.append(", tagValue: '");
                sb2.append(cVar.j(this.f7990h));
                sb2.append("'");
            }
        }
    }

    private ByteOrder F(b bVar) {
        short readShort = bVar.readShort();
        if (readShort == 18761) {
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (readShort == 19789) {
            return ByteOrder.BIG_ENDIAN;
        }
        throw new IOException("Invalid byte order: " + Integer.toHexString(readShort));
    }

    private void G(byte[] bArr, int i5) {
        f fVar = new f(bArr);
        D(fVar);
        H(fVar, i5);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void H(f fVar, int i5) {
        short s5;
        long j5;
        char c5;
        short s6;
        long j6;
        int i6;
        int i7;
        int readUnsignedShort;
        long j7;
        int i8 = 5;
        char c6 = 0;
        int i9 = 1;
        this.f7989g.add(Integer.valueOf(fVar.f8010c));
        short readShort = fVar.readShort();
        if (f7976u) {
            StringBuilder sb = new StringBuilder();
            sb.append("numberOfDirectoryEntry: ");
            sb.append((int) readShort);
        }
        if (readShort <= 0) {
            return;
        }
        short s7 = 0;
        while (s7 < readShort) {
            int readUnsignedShort2 = fVar.readUnsignedShort();
            int readUnsignedShort3 = fVar.readUnsignedShort();
            int readInt = fVar.readInt();
            long d5 = fVar.d() + 4;
            d dVar = (d) f7966k0[i5].get(Integer.valueOf(readUnsignedShort2));
            boolean z5 = f7976u;
            if (z5) {
                Integer valueOf = Integer.valueOf(i5);
                Integer valueOf2 = Integer.valueOf(readUnsignedShort2);
                String str = dVar != null ? dVar.f8017b : null;
                Integer valueOf3 = Integer.valueOf(readUnsignedShort3);
                Integer valueOf4 = Integer.valueOf(readInt);
                s5 = readShort;
                Object[] objArr = new Object[i8];
                objArr[c6] = valueOf;
                objArr[i9] = valueOf2;
                objArr[2] = str;
                objArr[3] = valueOf3;
                objArr[4] = valueOf4;
                String.format("ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d", objArr);
            } else {
                s5 = readShort;
            }
            if (dVar != null) {
                if (readUnsignedShort3 > 0) {
                    if (readUnsignedShort3 < W.length) {
                        if (dVar.a(readUnsignedShort3)) {
                            if (readUnsignedShort3 == 7) {
                                readUnsignedShort3 = dVar.f8018c;
                            }
                            j5 = r5[readUnsignedShort3] * readInt;
                            if (j5 < 0 || j5 > 2147483647L) {
                                if (z5) {
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("Skip the tag entry since the number of components is invalid: ");
                                    sb2.append(readInt);
                                }
                                c5 = c6;
                            } else {
                                c5 = 1;
                            }
                            if (c5 != 0) {
                                fVar.l(d5);
                                s6 = s7;
                                i7 = 1;
                            } else {
                                if (j5 > 4) {
                                    int readInt2 = fVar.readInt();
                                    if (z5) {
                                        StringBuilder sb3 = new StringBuilder();
                                        s6 = s7;
                                        sb3.append("seek to data offset: ");
                                        sb3.append(readInt2);
                                    } else {
                                        s6 = s7;
                                    }
                                    if (this.f7986d == 7) {
                                        if ("MakerNote".equals(dVar.f8017b)) {
                                            this.f7999q = readInt2;
                                        } else if (i5 == 6 && "ThumbnailImage".equals(dVar.f8017b)) {
                                            this.f8000r = readInt2;
                                            this.f8001s = readInt;
                                            c f5 = c.f(6, this.f7990h);
                                            j6 = d5;
                                            c b5 = c.b(this.f8000r, this.f7990h);
                                            i6 = readInt;
                                            c b6 = c.b(this.f8001s, this.f7990h);
                                            this.f7988f[4].put("Compression", f5);
                                            this.f7988f[4].put("JPEGInterchangeFormat", b5);
                                            this.f7988f[4].put("JPEGInterchangeFormatLength", b6);
                                            fVar.l(readInt2);
                                        }
                                    }
                                    j6 = d5;
                                    i6 = readInt;
                                    fVar.l(readInt2);
                                } else {
                                    s6 = s7;
                                    j6 = d5;
                                    i6 = readInt;
                                }
                                Integer num = (Integer) f7969n0.get(Integer.valueOf(readUnsignedShort2));
                                if (z5) {
                                    StringBuilder sb4 = new StringBuilder();
                                    sb4.append("nextIfdType: ");
                                    sb4.append(num);
                                    sb4.append(" byteCount: ");
                                    sb4.append(j5);
                                }
                                if (num != null) {
                                    if (readUnsignedShort3 != 3) {
                                        if (readUnsignedShort3 == 4) {
                                            j7 = fVar.h();
                                        } else if (readUnsignedShort3 == 8) {
                                            readUnsignedShort = fVar.readShort();
                                        } else if (readUnsignedShort3 == 9 || readUnsignedShort3 == 13) {
                                            readUnsignedShort = fVar.readInt();
                                        } else {
                                            j7 = -1;
                                        }
                                        if (!z5) {
                                            String.format("Offset: %d, tagName: %s", Long.valueOf(j7), dVar.f8017b);
                                        }
                                        if (j7 <= 0) {
                                            if (!this.f7989g.contains(Integer.valueOf((int) j7))) {
                                                fVar.l(j7);
                                                H(fVar, num.intValue());
                                            } else if (z5) {
                                                StringBuilder sb5 = new StringBuilder();
                                                sb5.append("Skip jump into the IFD since it has already been read: IfdType ");
                                                sb5.append(num);
                                                sb5.append(" (at ");
                                                sb5.append(j7);
                                                sb5.append(")");
                                            }
                                        } else if (z5) {
                                            StringBuilder sb6 = new StringBuilder();
                                            sb6.append("Skip jump into the IFD since its offset is invalid: ");
                                            sb6.append(j7);
                                        }
                                        fVar.l(j6);
                                        i7 = 1;
                                    } else {
                                        readUnsignedShort = fVar.readUnsignedShort();
                                    }
                                    j7 = readUnsignedShort;
                                    if (!z5) {
                                    }
                                    if (j7 <= 0) {
                                    }
                                    fVar.l(j6);
                                    i7 = 1;
                                } else {
                                    long j8 = j6;
                                    int d6 = fVar.d() + this.f7998p;
                                    byte[] bArr = new byte[(int) j5];
                                    fVar.readFully(bArr);
                                    c cVar = new c(readUnsignedShort3, i6, d6, bArr);
                                    this.f7988f[i5].put(dVar.f8017b, cVar);
                                    if ("DNGVersion".equals(dVar.f8017b)) {
                                        this.f7986d = 3;
                                    }
                                    if ((("Make".equals(dVar.f8017b) || "Model".equals(dVar.f8017b)) && cVar.j(this.f7990h).contains("PENTAX")) || ("Compression".equals(dVar.f8017b) && cVar.i(this.f7990h) == 65535)) {
                                        this.f7986d = 8;
                                    }
                                    if (fVar.d() != j8) {
                                        fVar.l(j8);
                                    }
                                    i7 = 1;
                                }
                            }
                            i9 = i7;
                            s7 = (short) (s6 + 1);
                            readShort = s5;
                            i8 = 5;
                            c6 = 0;
                        } else if (z5) {
                            StringBuilder sb7 = new StringBuilder();
                            sb7.append("Skip the tag entry since data format (");
                            sb7.append(V[readUnsignedShort3]);
                            sb7.append(") is unexpected for tag: ");
                            sb7.append(dVar.f8017b);
                        }
                    }
                }
                if (z5) {
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append("Skip the tag entry since data format is invalid: ");
                    sb8.append(readUnsignedShort3);
                }
            } else if (z5) {
                StringBuilder sb9 = new StringBuilder();
                sb9.append("Skip the tag entry since tag number is not defined: ");
                sb9.append(readUnsignedShort2);
            }
            c5 = c6;
            j5 = 0;
            if (c5 != 0) {
            }
            i9 = i7;
            s7 = (short) (s6 + 1);
            readShort = s5;
            i8 = 5;
            c6 = 0;
        }
        int i10 = i9;
        int readInt3 = fVar.readInt();
        boolean z6 = f7976u;
        if (z6) {
            Object[] objArr2 = new Object[i10];
            objArr2[0] = Integer.valueOf(readInt3);
            String.format("nextIfdOffset: %d", objArr2);
        }
        long j9 = readInt3;
        if (j9 <= 0) {
            if (z6) {
                StringBuilder sb10 = new StringBuilder();
                sb10.append("Stop reading file since a wrong offset may cause an infinite loop: ");
                sb10.append(readInt3);
                return;
            }
            return;
        }
        if (this.f7989g.contains(Integer.valueOf(readInt3))) {
            if (z6) {
                StringBuilder sb11 = new StringBuilder();
                sb11.append("Stop reading file since re-reading an IFD may cause an infinite loop: ");
                sb11.append(readInt3);
                return;
            }
            return;
        }
        fVar.l(j9);
        if (this.f7988f[4].isEmpty()) {
            H(fVar, 4);
        } else if (this.f7988f[5].isEmpty()) {
            H(fVar, 5);
        }
    }

    private void I(int i5, String str, String str2) {
        if (this.f7988f[i5].isEmpty() || this.f7988f[i5].get(str) == null) {
            return;
        }
        HashMap hashMap = this.f7988f[i5];
        hashMap.put(str2, hashMap.get(str));
        this.f7988f[i5].remove(str);
    }

    private void J(f fVar, int i5) {
        c cVar = (c) this.f7988f[i5].get("ImageLength");
        c cVar2 = (c) this.f7988f[i5].get("ImageWidth");
        if (cVar == null || cVar2 == null) {
            c cVar3 = (c) this.f7988f[i5].get("JPEGInterchangeFormat");
            c cVar4 = (c) this.f7988f[i5].get("JPEGInterchangeFormatLength");
            if (cVar3 == null || cVar4 == null) {
                return;
            }
            int i6 = cVar3.i(this.f7990h);
            int i7 = cVar3.i(this.f7990h);
            fVar.l(i6);
            byte[] bArr = new byte[i7];
            fVar.read(bArr);
            f(new b(bArr), i6, i5);
        }
    }

    private void K(b bVar) {
        HashMap hashMap = this.f7988f[4];
        c cVar = (c) hashMap.get("Compression");
        if (cVar == null) {
            this.f7997o = 6;
            p(bVar, hashMap);
            return;
        }
        int i5 = cVar.i(this.f7990h);
        this.f7997o = i5;
        if (i5 != 1) {
            if (i5 == 6) {
                p(bVar, hashMap);
                return;
            } else if (i5 != 7) {
                return;
            }
        }
        if (z(hashMap)) {
            q(bVar, hashMap);
        }
    }

    private static boolean L(int i5) {
        return (i5 == 4 || i5 == 9 || i5 == 13 || i5 == 14) ? false : true;
    }

    private void M(int i5, int i6) {
        if (this.f7988f[i5].isEmpty() || this.f7988f[i6].isEmpty()) {
            return;
        }
        c cVar = (c) this.f7988f[i5].get("ImageLength");
        c cVar2 = (c) this.f7988f[i5].get("ImageWidth");
        c cVar3 = (c) this.f7988f[i6].get("ImageLength");
        c cVar4 = (c) this.f7988f[i6].get("ImageWidth");
        if (cVar == null || cVar2 == null || cVar3 == null || cVar4 == null) {
            return;
        }
        int i7 = cVar.i(this.f7990h);
        int i8 = cVar2.i(this.f7990h);
        int i9 = cVar3.i(this.f7990h);
        int i10 = cVar4.i(this.f7990h);
        if (i7 >= i9 || i8 >= i10) {
            return;
        }
        HashMap[] hashMapArr = this.f7988f;
        HashMap hashMap = hashMapArr[i5];
        hashMapArr[i5] = hashMapArr[i6];
        hashMapArr[i6] = hashMap;
    }

    private void N(f fVar, int i5) {
        c f5;
        c f6;
        c cVar = (c) this.f7988f[i5].get("DefaultCropSize");
        c cVar2 = (c) this.f7988f[i5].get("SensorTopBorder");
        c cVar3 = (c) this.f7988f[i5].get("SensorLeftBorder");
        c cVar4 = (c) this.f7988f[i5].get("SensorBottomBorder");
        c cVar5 = (c) this.f7988f[i5].get("SensorRightBorder");
        if (cVar == null) {
            if (cVar2 == null || cVar3 == null || cVar4 == null || cVar5 == null) {
                J(fVar, i5);
                return;
            }
            int i6 = cVar2.i(this.f7990h);
            int i7 = cVar4.i(this.f7990h);
            int i8 = cVar5.i(this.f7990h);
            int i9 = cVar3.i(this.f7990h);
            if (i7 <= i6 || i8 <= i9) {
                return;
            }
            c f7 = c.f(i7 - i6, this.f7990h);
            c f8 = c.f(i8 - i9, this.f7990h);
            this.f7988f[i5].put("ImageLength", f7);
            this.f7988f[i5].put("ImageWidth", f8);
            return;
        }
        if (cVar.f8012a == 5) {
            e[] eVarArr = (e[]) cVar.k(this.f7990h);
            if (eVarArr == null || eVarArr.length != 2) {
                Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(eVarArr));
                return;
            }
            f5 = c.d(eVarArr[0], this.f7990h);
            f6 = c.d(eVarArr[1], this.f7990h);
        } else {
            int[] iArr = (int[]) cVar.k(this.f7990h);
            if (iArr == null || iArr.length != 2) {
                Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                return;
            }
            f5 = c.f(iArr[0], this.f7990h);
            f6 = c.f(iArr[1], this.f7990h);
        }
        this.f7988f[i5].put("ImageWidth", f5);
        this.f7988f[i5].put("ImageLength", f6);
    }

    private void O() {
        M(0, 5);
        M(0, 4);
        M(5, 4);
        c cVar = (c) this.f7988f[1].get("PixelXDimension");
        c cVar2 = (c) this.f7988f[1].get("PixelYDimension");
        if (cVar != null && cVar2 != null) {
            this.f7988f[0].put("ImageWidth", cVar);
            this.f7988f[0].put("ImageLength", cVar2);
        }
        if (this.f7988f[4].isEmpty() && A(this.f7988f[5])) {
            HashMap[] hashMapArr = this.f7988f;
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap();
        }
        A(this.f7988f[4]);
        I(0, "ThumbnailOrientation", "Orientation");
        I(0, "ThumbnailImageLength", "ImageLength");
        I(0, "ThumbnailImageWidth", "ImageWidth");
        I(5, "ThumbnailOrientation", "Orientation");
        I(5, "ThumbnailImageLength", "ImageLength");
        I(5, "ThumbnailImageWidth", "ImageWidth");
        I(4, "Orientation", "ThumbnailOrientation");
        I(4, "ImageLength", "ThumbnailImageLength");
        I(4, "ImageWidth", "ThumbnailImageWidth");
    }

    private void a() {
        String b5 = b("DateTimeOriginal");
        if (b5 != null && b("DateTime") == null) {
            this.f7988f[0].put("DateTime", c.a(b5));
        }
        if (b("ImageWidth") == null) {
            this.f7988f[0].put("ImageWidth", c.b(0L, this.f7990h));
        }
        if (b("ImageLength") == null) {
            this.f7988f[0].put("ImageLength", c.b(0L, this.f7990h));
        }
        if (b("Orientation") == null) {
            this.f7988f[0].put("Orientation", c.b(0L, this.f7990h));
        }
        if (b("LightSource") == null) {
            this.f7988f[1].put("LightSource", c.b(0L, this.f7990h));
        }
    }

    private c d(String str) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        if ("ISOSpeedRatings".equals(str)) {
            str = "PhotographicSensitivity";
        }
        for (int i5 = 0; i5 < f7964i0.length; i5++) {
            c cVar = (c) this.f7988f[i5].get(str);
            if (cVar != null) {
                return cVar;
            }
        }
        return null;
    }

    private void e(f fVar) {
        String str;
        String str2;
        String str3;
        if (Build.VERSION.SDK_INT < 28) {
            throw new UnsupportedOperationException("Reading EXIF from HEIF files is supported from SDK 28 and above");
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                b.C0063b.a(mediaMetadataRetriever, new C0062a(fVar));
                String extractMetadata = mediaMetadataRetriever.extractMetadata(33);
                String extractMetadata2 = mediaMetadataRetriever.extractMetadata(34);
                String extractMetadata3 = mediaMetadataRetriever.extractMetadata(26);
                String extractMetadata4 = mediaMetadataRetriever.extractMetadata(17);
                if ("yes".equals(extractMetadata3)) {
                    str = mediaMetadataRetriever.extractMetadata(29);
                    str2 = mediaMetadataRetriever.extractMetadata(30);
                    str3 = mediaMetadataRetriever.extractMetadata(31);
                } else if ("yes".equals(extractMetadata4)) {
                    str = mediaMetadataRetriever.extractMetadata(18);
                    str2 = mediaMetadataRetriever.extractMetadata(19);
                    str3 = mediaMetadataRetriever.extractMetadata(24);
                } else {
                    str = null;
                    str2 = null;
                    str3 = null;
                }
                if (str != null) {
                    this.f7988f[0].put("ImageWidth", c.f(Integer.parseInt(str), this.f7990h));
                }
                if (str2 != null) {
                    this.f7988f[0].put("ImageLength", c.f(Integer.parseInt(str2), this.f7990h));
                }
                if (str3 != null) {
                    int parseInt = Integer.parseInt(str3);
                    this.f7988f[0].put("Orientation", c.f(parseInt != 90 ? parseInt != 180 ? parseInt != 270 ? 1 : 8 : 3 : 6, this.f7990h));
                }
                if (extractMetadata != null && extractMetadata2 != null) {
                    int parseInt2 = Integer.parseInt(extractMetadata);
                    int parseInt3 = Integer.parseInt(extractMetadata2);
                    if (parseInt3 <= 6) {
                        throw new IOException("Invalid exif length");
                    }
                    fVar.l(parseInt2);
                    byte[] bArr = new byte[6];
                    if (fVar.read(bArr) != 6) {
                        throw new IOException("Can't read identifier");
                    }
                    int i5 = parseInt2 + 6;
                    int i6 = parseInt3 - 6;
                    if (!Arrays.equals(bArr, f7971p0)) {
                        throw new IOException("Invalid identifier");
                    }
                    byte[] bArr2 = new byte[i6];
                    if (fVar.read(bArr2) != i6) {
                        throw new IOException("Can't read exif");
                    }
                    this.f7998p = i5;
                    G(bArr2, 0);
                }
                if (f7976u) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Heif meta: ");
                    sb.append(str);
                    sb.append("x");
                    sb.append(str2);
                    sb.append(", rotation ");
                    sb.append(str3);
                }
                mediaMetadataRetriever.release();
            } catch (RuntimeException unused) {
                throw new UnsupportedOperationException("Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported.");
            }
        } catch (Throwable th) {
            mediaMetadataRetriever.release();
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x016d, code lost:
    
        r20.j(r19.f7990h);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0172, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x015b A[LOOP:0: B:9:0x002e->B:32:0x015b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0161 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009e A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void f(b bVar, int i5, int i6) {
        if (f7976u) {
            StringBuilder sb = new StringBuilder();
            sb.append("getJpegAttributes starting with: ");
            sb.append(bVar);
        }
        bVar.j(ByteOrder.BIG_ENDIAN);
        byte readByte = bVar.readByte();
        if (readByte != -1) {
            throw new IOException("Invalid marker: " + Integer.toHexString(readByte & 255));
        }
        if (bVar.readByte() != -40) {
            throw new IOException("Invalid marker: " + Integer.toHexString(readByte & 255));
        }
        int i7 = 2;
        while (true) {
            byte readByte2 = bVar.readByte();
            if (readByte2 != -1) {
                throw new IOException("Invalid marker:" + Integer.toHexString(readByte2 & 255));
            }
            byte readByte3 = bVar.readByte();
            boolean z5 = f7976u;
            if (z5) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Found JPEG segment indicator: ");
                sb2.append(Integer.toHexString(readByte3 & 255));
            }
            if (readByte3 != -39 && readByte3 != -38) {
                int readUnsignedShort = bVar.readUnsignedShort();
                int i8 = readUnsignedShort - 2;
                int i9 = i7 + 4;
                if (z5) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("JPEG segment: ");
                    sb3.append(Integer.toHexString(readByte3 & 255));
                    sb3.append(" (length: ");
                    sb3.append(readUnsignedShort);
                    sb3.append(")");
                }
                if (i8 < 0) {
                    throw new IOException("Invalid length");
                }
                if (readByte3 == -31) {
                    byte[] bArr = new byte[i8];
                    bVar.readFully(bArr);
                    int i10 = i9 + i8;
                    byte[] bArr2 = f7971p0;
                    if (androidx.exifinterface.media.b.c(bArr, bArr2)) {
                        byte[] copyOfRange = Arrays.copyOfRange(bArr, bArr2.length, i8);
                        this.f7998p = i5 + i9 + bArr2.length;
                        G(copyOfRange, i6);
                        K(new b(copyOfRange));
                    } else {
                        byte[] bArr3 = f7972q0;
                        if (androidx.exifinterface.media.b.c(bArr, bArr3)) {
                            int length = i9 + bArr3.length;
                            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, bArr3.length, i8);
                            if (b("Xmp") == null) {
                                this.f7988f[0].put("Xmp", new c(1, copyOfRange2.length, length, copyOfRange2));
                                this.f8002t = true;
                            }
                        }
                    }
                    i9 = i10;
                } else if (readByte3 != -2) {
                    switch (readByte3) {
                        default:
                            switch (readByte3) {
                                default:
                                    switch (readByte3) {
                                        default:
                                            switch (readByte3) {
                                            }
                                        case -55:
                                        case -54:
                                        case -53:
                                            bVar.k(1);
                                            this.f7988f[i6].put(i6 != 4 ? "ImageLength" : "ThumbnailImageLength", c.b(bVar.readUnsignedShort(), this.f7990h));
                                            this.f7988f[i6].put(i6 != 4 ? "ImageWidth" : "ThumbnailImageWidth", c.b(bVar.readUnsignedShort(), this.f7990h));
                                            i8 = readUnsignedShort - 7;
                                            break;
                                    }
                                case -59:
                                case -58:
                                case -57:
                                    break;
                            }
                        case -64:
                        case -63:
                        case -62:
                        case -61:
                            break;
                    }
                    if (i8 >= 0) {
                        throw new IOException("Invalid length");
                    }
                    bVar.k(i8);
                    i7 = i9 + i8;
                } else {
                    byte[] bArr4 = new byte[i8];
                    if (bVar.read(bArr4) != i8) {
                        throw new IOException("Invalid exif");
                    }
                    if (b("UserComment") == null) {
                        this.f7988f[1].put("UserComment", c.a(new String(bArr4, f7970o0)));
                    }
                }
                i8 = 0;
                if (i8 >= 0) {
                }
            }
        }
    }

    private int g(BufferedInputStream bufferedInputStream) {
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (t(bArr)) {
            return 4;
        }
        if (w(bArr)) {
            return 9;
        }
        if (s(bArr)) {
            return 12;
        }
        if (u(bArr)) {
            return 7;
        }
        if (x(bArr)) {
            return 10;
        }
        if (v(bArr)) {
            return 13;
        }
        return B(bArr) ? 14 : 0;
    }

    private void h(f fVar) {
        int i5;
        int i6;
        k(fVar);
        c cVar = (c) this.f7988f[1].get("MakerNote");
        if (cVar != null) {
            f fVar2 = new f(cVar.f8015d);
            fVar2.j(this.f7990h);
            byte[] bArr = E;
            byte[] bArr2 = new byte[bArr.length];
            fVar2.readFully(bArr2);
            fVar2.l(0L);
            byte[] bArr3 = F;
            byte[] bArr4 = new byte[bArr3.length];
            fVar2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                fVar2.l(8L);
            } else if (Arrays.equals(bArr4, bArr3)) {
                fVar2.l(12L);
            }
            H(fVar2, 6);
            c cVar2 = (c) this.f7988f[7].get("PreviewImageStart");
            c cVar3 = (c) this.f7988f[7].get("PreviewImageLength");
            if (cVar2 != null && cVar3 != null) {
                this.f7988f[5].put("JPEGInterchangeFormat", cVar2);
                this.f7988f[5].put("JPEGInterchangeFormatLength", cVar3);
            }
            c cVar4 = (c) this.f7988f[8].get("AspectFrame");
            if (cVar4 != null) {
                int[] iArr = (int[]) cVar4.k(this.f7990h);
                if (iArr == null || iArr.length != 4) {
                    Log.w("ExifInterface", "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
                    return;
                }
                int i7 = iArr[2];
                int i8 = iArr[0];
                if (i7 <= i8 || (i5 = iArr[3]) <= (i6 = iArr[1])) {
                    return;
                }
                int i9 = (i7 - i8) + 1;
                int i10 = (i5 - i6) + 1;
                if (i9 < i10) {
                    int i11 = i9 + i10;
                    i10 = i11 - i10;
                    i9 = i11 - i10;
                }
                c f5 = c.f(i9, this.f7990h);
                c f6 = c.f(i10, this.f7990h);
                this.f7988f[0].put("ImageWidth", f5);
                this.f7988f[0].put("ImageLength", f6);
            }
        }
    }

    private void i(b bVar) {
        if (f7976u) {
            StringBuilder sb = new StringBuilder();
            sb.append("getPngAttributes starting with: ");
            sb.append(bVar);
        }
        bVar.j(ByteOrder.BIG_ENDIAN);
        byte[] bArr = G;
        bVar.k(bArr.length);
        int length = bArr.length;
        while (true) {
            try {
                int readInt = bVar.readInt();
                byte[] bArr2 = new byte[4];
                if (bVar.read(bArr2) != 4) {
                    throw new IOException("Encountered invalid length while parsing PNG chunktype");
                }
                int i5 = length + 8;
                if (i5 == 16 && !Arrays.equals(bArr2, I)) {
                    throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                }
                if (Arrays.equals(bArr2, J)) {
                    return;
                }
                if (Arrays.equals(bArr2, H)) {
                    byte[] bArr3 = new byte[readInt];
                    if (bVar.read(bArr3) != readInt) {
                        throw new IOException("Failed to read given length for given PNG chunk type: " + androidx.exifinterface.media.b.a(bArr2));
                    }
                    int readInt2 = bVar.readInt();
                    CRC32 crc32 = new CRC32();
                    crc32.update(bArr2);
                    crc32.update(bArr3);
                    if (((int) crc32.getValue()) == readInt2) {
                        this.f7998p = i5;
                        G(bArr3, 0);
                        O();
                        K(new b(bArr3));
                        return;
                    }
                    throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + readInt2 + ", calculated CRC value: " + crc32.getValue());
                }
                int i6 = readInt + 4;
                bVar.k(i6);
                length = i5 + i6;
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt PNG file.");
            }
        }
    }

    private void j(b bVar) {
        boolean z5 = f7976u;
        if (z5) {
            StringBuilder sb = new StringBuilder();
            sb.append("getRafAttributes starting with: ");
            sb.append(bVar);
        }
        bVar.k(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        bVar.read(bArr);
        bVar.read(bArr2);
        bVar.read(bArr3);
        int i5 = ByteBuffer.wrap(bArr).getInt();
        int i6 = ByteBuffer.wrap(bArr2).getInt();
        int i7 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i6];
        bVar.k(i5 - bVar.d());
        bVar.read(bArr4);
        f(new b(bArr4), i5, 5);
        bVar.k(i7 - bVar.d());
        bVar.j(ByteOrder.BIG_ENDIAN);
        int readInt = bVar.readInt();
        if (z5) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("numberOfDirectoryEntry: ");
            sb2.append(readInt);
        }
        for (int i8 = 0; i8 < readInt; i8++) {
            int readUnsignedShort = bVar.readUnsignedShort();
            int readUnsignedShort2 = bVar.readUnsignedShort();
            if (readUnsignedShort == f7959d0.f8016a) {
                short readShort = bVar.readShort();
                short readShort2 = bVar.readShort();
                c f5 = c.f(readShort, this.f7990h);
                c f6 = c.f(readShort2, this.f7990h);
                this.f7988f[0].put("ImageLength", f5);
                this.f7988f[0].put("ImageWidth", f6);
                if (f7976u) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Updated to length: ");
                    sb3.append((int) readShort);
                    sb3.append(", width: ");
                    sb3.append((int) readShort2);
                    return;
                }
                return;
            }
            bVar.k(readUnsignedShort2);
        }
    }

    private void k(f fVar) {
        c cVar;
        D(fVar);
        H(fVar, 0);
        N(fVar, 0);
        N(fVar, 5);
        N(fVar, 4);
        O();
        if (this.f7986d != 8 || (cVar = (c) this.f7988f[1].get("MakerNote")) == null) {
            return;
        }
        f fVar2 = new f(cVar.f8015d);
        fVar2.j(this.f7990h);
        fVar2.k(6);
        H(fVar2, 9);
        c cVar2 = (c) this.f7988f[9].get("ColorSpace");
        if (cVar2 != null) {
            this.f7988f[1].put("ColorSpace", cVar2);
        }
    }

    private void m(f fVar) {
        if (f7976u) {
            StringBuilder sb = new StringBuilder();
            sb.append("getRw2Attributes starting with: ");
            sb.append(fVar);
        }
        k(fVar);
        c cVar = (c) this.f7988f[0].get("JpgFromRaw");
        if (cVar != null) {
            f(new b(cVar.f8015d), (int) cVar.f8014c, 5);
        }
        c cVar2 = (c) this.f7988f[0].get("ISO");
        c cVar3 = (c) this.f7988f[1].get("PhotographicSensitivity");
        if (cVar2 == null || cVar3 != null) {
            return;
        }
        this.f7988f[1].put("PhotographicSensitivity", cVar2);
    }

    private void n(f fVar) {
        byte[] bArr = f7971p0;
        fVar.k(bArr.length);
        byte[] bArr2 = new byte[fVar.available()];
        fVar.readFully(bArr2);
        this.f7998p = bArr.length;
        G(bArr2, 0);
    }

    private void o(b bVar) {
        if (f7976u) {
            StringBuilder sb = new StringBuilder();
            sb.append("getWebpAttributes starting with: ");
            sb.append(bVar);
        }
        bVar.j(ByteOrder.LITTLE_ENDIAN);
        bVar.k(K.length);
        int readInt = bVar.readInt() + 8;
        byte[] bArr = L;
        bVar.k(bArr.length);
        int length = bArr.length + 8;
        while (true) {
            try {
                byte[] bArr2 = new byte[4];
                if (bVar.read(bArr2) != 4) {
                    throw new IOException("Encountered invalid length while parsing WebP chunktype");
                }
                int readInt2 = bVar.readInt();
                int i5 = length + 8;
                if (Arrays.equals(M, bArr2)) {
                    byte[] bArr3 = new byte[readInt2];
                    if (bVar.read(bArr3) == readInt2) {
                        this.f7998p = i5;
                        G(bArr3, 0);
                        K(new b(bArr3));
                        return;
                    } else {
                        throw new IOException("Failed to read given length for given PNG chunk type: " + androidx.exifinterface.media.b.a(bArr2));
                    }
                }
                if (readInt2 % 2 == 1) {
                    readInt2++;
                }
                length = i5 + readInt2;
                if (length == readInt) {
                    return;
                }
                if (length > readInt) {
                    throw new IOException("Encountered WebP file with invalid chunk size");
                }
                bVar.k(readInt2);
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt WebP file.");
            }
        }
    }

    private void p(b bVar, HashMap hashMap) {
        c cVar = (c) hashMap.get("JPEGInterchangeFormat");
        c cVar2 = (c) hashMap.get("JPEGInterchangeFormatLength");
        if (cVar == null || cVar2 == null) {
            return;
        }
        int i5 = cVar.i(this.f7990h);
        int i6 = cVar2.i(this.f7990h);
        if (this.f7986d == 7) {
            i5 += this.f7999q;
        }
        if (i5 > 0 && i6 > 0) {
            this.f7991i = true;
            if (this.f7983a == null && this.f7985c == null && this.f7984b == null) {
                byte[] bArr = new byte[i6];
                bVar.skip(i5);
                bVar.read(bArr);
                this.f7996n = bArr;
            }
            this.f7994l = i5;
            this.f7995m = i6;
        }
        if (f7976u) {
            StringBuilder sb = new StringBuilder();
            sb.append("Setting thumbnail attributes with offset: ");
            sb.append(i5);
            sb.append(", length: ");
            sb.append(i6);
        }
    }

    private void q(b bVar, HashMap hashMap) {
        c cVar = (c) hashMap.get("StripOffsets");
        c cVar2 = (c) hashMap.get("StripByteCounts");
        if (cVar == null || cVar2 == null) {
            return;
        }
        long[] b5 = androidx.exifinterface.media.b.b(cVar.k(this.f7990h));
        long[] b6 = androidx.exifinterface.media.b.b(cVar2.k(this.f7990h));
        if (b5 == null || b5.length == 0) {
            Log.w("ExifInterface", "stripOffsets should not be null or have zero length.");
            return;
        }
        if (b6 == null || b6.length == 0) {
            Log.w("ExifInterface", "stripByteCounts should not be null or have zero length.");
            return;
        }
        if (b5.length != b6.length) {
            Log.w("ExifInterface", "stripOffsets and stripByteCounts should have same length.");
            return;
        }
        long j5 = 0;
        for (long j6 : b6) {
            j5 += j6;
        }
        int i5 = (int) j5;
        byte[] bArr = new byte[i5];
        this.f7993k = true;
        this.f7992j = true;
        this.f7991i = true;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < b5.length; i8++) {
            int i9 = (int) b5[i8];
            int i10 = (int) b6[i8];
            if (i8 < b5.length - 1 && i9 + i10 != b5[i8 + 1]) {
                this.f7993k = false;
            }
            int i11 = i9 - i6;
            if (i11 < 0) {
                return;
            }
            long j7 = i11;
            if (bVar.skip(j7) != j7) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to skip ");
                sb.append(i11);
                sb.append(" bytes.");
                return;
            }
            int i12 = i6 + i11;
            byte[] bArr2 = new byte[i10];
            if (bVar.read(bArr2) != i10) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed to read ");
                sb2.append(i10);
                sb2.append(" bytes.");
                return;
            }
            i6 = i12 + i10;
            System.arraycopy(bArr2, 0, bArr, i7, i10);
            i7 += i10;
        }
        this.f7996n = bArr;
        if (this.f7993k) {
            this.f7994l = (int) b5[0];
            this.f7995m = i5;
        }
    }

    private static boolean r(BufferedInputStream bufferedInputStream) {
        byte[] bArr = f7971p0;
        bufferedInputStream.mark(bArr.length);
        byte[] bArr2 = new byte[bArr.length];
        bufferedInputStream.read(bArr2);
        bufferedInputStream.reset();
        int i5 = 0;
        while (true) {
            byte[] bArr3 = f7971p0;
            if (i5 >= bArr3.length) {
                return true;
            }
            if (bArr2[i5] != bArr3[i5]) {
                return false;
            }
            i5++;
        }
    }

    private boolean s(byte[] bArr) {
        b bVar;
        long readInt;
        byte[] bArr2;
        long j5;
        b bVar2 = null;
        try {
            bVar = new b(bArr);
            try {
                readInt = bVar.readInt();
                bArr2 = new byte[4];
                bVar.read(bArr2);
            } catch (Exception unused) {
                bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.close();
                }
                return false;
            } catch (Throwable th) {
                th = th;
                bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.close();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
        if (!Arrays.equals(bArr2, B)) {
            bVar.close();
            return false;
        }
        if (readInt == 1) {
            readInt = bVar.readLong();
            j5 = 16;
            if (readInt < 16) {
                bVar.close();
                return false;
            }
        } else {
            j5 = 8;
        }
        if (readInt > bArr.length) {
            readInt = bArr.length;
        }
        long j6 = readInt - j5;
        if (j6 < 8) {
            bVar.close();
            return false;
        }
        byte[] bArr3 = new byte[4];
        boolean z5 = false;
        boolean z6 = false;
        for (long j7 = 0; j7 < j6 / 4; j7++) {
            if (bVar.read(bArr3) != 4) {
                bVar.close();
                return false;
            }
            if (j7 != 1) {
                if (Arrays.equals(bArr3, C)) {
                    z5 = true;
                } else if (Arrays.equals(bArr3, D)) {
                    z6 = true;
                }
                if (z5 && z6) {
                    bVar.close();
                    return true;
                }
            }
        }
        bVar.close();
        return false;
    }

    private static boolean t(byte[] bArr) {
        int i5 = 0;
        while (true) {
            byte[] bArr2 = A;
            if (i5 >= bArr2.length) {
                return true;
            }
            if (bArr[i5] != bArr2[i5]) {
                return false;
            }
            i5++;
        }
    }

    private boolean u(byte[] bArr) {
        b bVar = null;
        try {
            b bVar2 = new b(bArr);
            try {
                ByteOrder F2 = F(bVar2);
                this.f7990h = F2;
                bVar2.j(F2);
                short readShort = bVar2.readShort();
                boolean z5 = readShort == 20306 || readShort == 21330;
                bVar2.close();
                return z5;
            } catch (Exception unused) {
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                return false;
            } catch (Throwable th) {
                th = th;
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private boolean v(byte[] bArr) {
        int i5 = 0;
        while (true) {
            byte[] bArr2 = G;
            if (i5 >= bArr2.length) {
                return true;
            }
            if (bArr[i5] != bArr2[i5]) {
                return false;
            }
            i5++;
        }
    }

    private boolean w(byte[] bArr) {
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        for (int i5 = 0; i5 < bytes.length; i5++) {
            if (bArr[i5] != bytes[i5]) {
                return false;
            }
        }
        return true;
    }

    private boolean x(byte[] bArr) {
        b bVar = null;
        try {
            b bVar2 = new b(bArr);
            try {
                ByteOrder F2 = F(bVar2);
                this.f7990h = F2;
                bVar2.j(F2);
                boolean z5 = bVar2.readShort() == 85;
                bVar2.close();
                return z5;
            } catch (Exception unused) {
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                return false;
            } catch (Throwable th) {
                th = th;
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static boolean y(FileDescriptor fileDescriptor) {
        try {
            b.a.c(fileDescriptor, 0L, OsConstants.SEEK_CUR);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean z(HashMap hashMap) {
        c cVar;
        c cVar2 = (c) hashMap.get("BitsPerSample");
        if (cVar2 == null) {
            return false;
        }
        int[] iArr = (int[]) cVar2.k(this.f7990h);
        int[] iArr2 = f7980x;
        if (Arrays.equals(iArr2, iArr)) {
            return true;
        }
        if (this.f7986d != 3 || (cVar = (c) hashMap.get("PhotometricInterpretation")) == null) {
            return false;
        }
        int i5 = cVar.i(this.f7990h);
        return (i5 == 1 && Arrays.equals(iArr, f7982z)) || (i5 == 6 && Arrays.equals(iArr, iArr2));
    }

    public String b(String str) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        c d5 = d(str);
        if (d5 != null) {
            if (!f7968m0.contains(str)) {
                return d5.j(this.f7990h);
            }
            if (str.equals("GPSTimeStamp")) {
                int i5 = d5.f8012a;
                if (i5 != 5 && i5 != 10) {
                    Log.w("ExifInterface", "GPS Timestamp format is not rational. format=" + d5.f8012a);
                    return null;
                }
                e[] eVarArr = (e[]) d5.k(this.f7990h);
                if (eVarArr == null || eVarArr.length != 3) {
                    Log.w("ExifInterface", "Invalid GPS Timestamp array. array=" + Arrays.toString(eVarArr));
                    return null;
                }
                e eVar = eVarArr[0];
                Integer valueOf = Integer.valueOf((int) (eVar.f8020a / eVar.f8021b));
                e eVar2 = eVarArr[1];
                Integer valueOf2 = Integer.valueOf((int) (eVar2.f8020a / eVar2.f8021b));
                e eVar3 = eVarArr[2];
                return String.format("%02d:%02d:%02d", valueOf, valueOf2, Integer.valueOf((int) (eVar3.f8020a / eVar3.f8021b)));
            }
            try {
                return Double.toString(d5.h(this.f7990h));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public int c(String str, int i5) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        c d5 = d(str);
        if (d5 == null) {
            return i5;
        }
        try {
            return d5.i(this.f7990h);
        } catch (NumberFormatException unused) {
            return i5;
        }
    }

    public int l() {
        switch (c("Orientation", 1)) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 8:
                return 270;
            case 6:
            case 7:
                return 90;
            default:
                return 0;
        }
    }
}
