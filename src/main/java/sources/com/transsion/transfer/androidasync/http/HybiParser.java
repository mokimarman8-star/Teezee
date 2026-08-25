package com.transsion.transfer.androidasync.http;

import android.util.Log;
import com.transsion.transfer.androidasync.ByteBufferList;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import okio.internal.Buffer;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
abstract class HybiParser {
    private static final List w = Arrays.asList(0, 1, 2, 8, 9, 10);
    private static final List x = Arrays.asList(0, 1, 2);
    private int c;
    private boolean d;
    private boolean e;
    private boolean f;
    private int g;
    private int h;
    private int i;
    private int j;
    private com.transsion.transfer.androidasync.r v;
    private boolean a = true;
    private boolean b = false;
    private byte[] k = new byte[0];
    private byte[] l = new byte[0];
    private boolean m = false;
    private ByteArrayOutputStream n = new ByteArrayOutputStream();
    private Inflater o = new Inflater(true);
    private byte[] p = new byte[Buffer.SEGMENTING_THRESHOLD];
    st.d q = new a();
    st.d r = new b();
    st.d s = new c();
    st.d t = new d();
    st.d u = new e();

    public static class ProtocolError extends IOException {
        public ProtocolError(String str) {
            super(str);
        }
    }

    class a implements st.d {
        a() {
        }

        @Override // st.d
        public void C(com.transsion.transfer.androidasync.p pVar, ByteBufferList byteBufferList) {
            try {
                HybiParser.this.F(byteBufferList.e());
            } catch (ProtocolError e) {
                HybiParser.this.H(e);
                e.printStackTrace();
            }
            HybiParser.this.C();
        }
    }

    class b implements st.d {
        b() {
        }

        @Override // st.d
        public void C(com.transsion.transfer.androidasync.p pVar, ByteBufferList byteBufferList) {
            HybiParser.this.E(byteBufferList.e());
            HybiParser.this.C();
        }
    }

    class c implements st.d {
        c() {
        }

        @Override // st.d
        public void C(com.transsion.transfer.androidasync.p pVar, ByteBufferList byteBufferList) {
            byte[] bArr = new byte[HybiParser.this.h];
            byteBufferList.h(bArr);
            try {
                HybiParser.this.D(bArr);
            } catch (ProtocolError e) {
                HybiParser.this.H(e);
                e.printStackTrace();
            }
            HybiParser.this.C();
        }
    }

    class d implements st.d {
        d() {
        }

        @Override // st.d
        public void C(com.transsion.transfer.androidasync.p pVar, ByteBufferList byteBufferList) {
            HybiParser.this.k = new byte[4];
            byteBufferList.h(HybiParser.this.k);
            HybiParser.this.c = 4;
            HybiParser.this.C();
        }
    }

    class e implements st.d {
        e() {
        }

        @Override // st.d
        public void C(com.transsion.transfer.androidasync.p pVar, ByteBufferList byteBufferList) {
            HybiParser hybiParser = HybiParser.this;
            hybiParser.l = new byte[hybiParser.i];
            byteBufferList.h(HybiParser.this.l);
            try {
                HybiParser.this.n();
            } catch (IOException e) {
                HybiParser.this.H(e);
                e.printStackTrace();
            }
            HybiParser.this.c = 0;
            HybiParser.this.C();
        }
    }

    public HybiParser(com.transsion.transfer.androidasync.p pVar) {
        com.transsion.transfer.androidasync.r rVar = new com.transsion.transfer.androidasync.r();
        this.v = rVar;
        pVar.F(rVar);
        C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(byte[] bArr) {
        this.i = u(bArr);
        this.c = this.e ? 3 : 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(byte b2) {
        boolean z = (b2 & 128) == 128;
        this.e = z;
        int i = b2 & Byte.MAX_VALUE;
        this.i = i;
        if (i >= 0 && i <= 125) {
            this.c = z ? 3 : 4;
        } else {
            this.h = i == 126 ? 2 : 8;
            this.c = 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(byte b2) {
        boolean z = (b2 & 64) == 64;
        boolean z2 = (b2 & 32) == 32;
        boolean z3 = (b2 & 16) == 16;
        if ((!this.b && z) || z2 || z3) {
            throw new ProtocolError("RSV not zero");
        }
        this.d = (b2 & 128) == 128;
        int i = b2 & 15;
        this.g = i;
        this.f = z;
        this.k = new byte[0];
        this.l = new byte[0];
        if (!w.contains(Integer.valueOf(i))) {
            throw new ProtocolError("Bad opcode");
        }
        if (!x.contains(Integer.valueOf(this.g)) && !this.d) {
            throw new ProtocolError("Expected non-final packet");
        }
        this.c = 1;
    }

    private void I() {
        this.j = 0;
        this.n.reset();
    }

    private byte[] M(byte[] bArr, int i) {
        byte[] bArr2 = new byte[bArr.length - i];
        System.arraycopy(bArr, i, bArr2, 0, bArr.length - i);
        return bArr2;
    }

    private static long l(byte[] bArr, int i, int i2) {
        if (bArr.length < i2) {
            throw new IllegalArgumentException("length must be less than or equal to b.length");
        }
        long j = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            j += (bArr[i3 + i] & 255) << (((i2 - 1) - i3) * 8);
        }
        return j;
    }

    private byte[] m(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        byte[] w2 = w(this.l, this.k, 0);
        if (this.f) {
            try {
                w2 = v(w2);
            } catch (DataFormatException unused) {
                throw new IOException("Invalid deflated data");
            }
        }
        int i = this.g;
        if (i == 0) {
            if (this.j == 0) {
                throw new ProtocolError("Mode was not set.");
            }
            this.n.write(w2);
            if (this.d) {
                byte[] byteArray = this.n.toByteArray();
                if (this.j == 1) {
                    y(o(byteArray));
                } else {
                    z(byteArray);
                }
                I();
                return;
            }
            return;
        }
        if (i == 1) {
            if (this.d) {
                y(o(w2));
                return;
            } else {
                this.j = 1;
                this.n.write(w2);
                return;
            }
        }
        if (i == 2) {
            if (this.d) {
                z(w2);
                return;
            } else {
                this.j = 2;
                this.n.write(w2);
                return;
            }
        }
        if (i == 8) {
            x(w2.length >= 2 ? (w2[1] & 255) + ((w2[0] & 255) * 256) : 0, w2.length > 2 ? o(M(w2, 2)) : null);
            return;
        }
        if (i != 9) {
            if (i == 10) {
                B(o(w2));
            }
        } else {
            if (w2.length > 125) {
                throw new ProtocolError("Ping payload too large");
            }
            String o = o(w2);
            J(q(10, w2, -1));
            A(o);
        }
    }

    private String o(byte[] bArr) {
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    private byte[] p(int i, String str, int i2) {
        return q(i, m(str), i2);
    }

    private byte[] q(int i, byte[] bArr, int i2) {
        return r(i, bArr, i2, 0, bArr.length);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private byte[] r(int i, byte[] bArr, int i2, int i3, int i4) {
        int i5;
        if (this.m) {
            return null;
        }
        int i6 = i2 > 0 ? 2 : 0;
        int i7 = (i4 + i6) - i3;
        int i8 = i7 <= 125 ? 2 : i7 <= 65535 ? 4 : 10;
        boolean z = this.a;
        int i9 = (z ? 4 : 0) + i8;
        int i10 = z ? 128 : 0;
        byte[] bArr2 = new byte[i7 + i9];
        bArr2[0] = (byte) (((byte) i) | Byte.MIN_VALUE);
        if (i7 <= 125) {
            bArr2[1] = (byte) (i10 | i7);
        } else {
            if (i7 > 65535) {
                bArr2[1] = (byte) (i10 | 127);
                long j = i7;
                i5 = i6;
                bArr2[2] = (byte) ((j / 72057594037927936L) & 255);
                bArr2[3] = (byte) ((j / 281474976710656L) & 255);
                bArr2[4] = (byte) ((j / 1099511627776L) & 255);
                bArr2[5] = (byte) ((j / 4294967296L) & 255);
                bArr2[6] = (byte) ((j / 16777216) & 255);
                bArr2[7] = (byte) ((j / 65536) & 255);
                bArr2[8] = (byte) ((j / 256) & 255);
                bArr2[9] = (byte) (i7 & 255);
                if (i2 > 0) {
                    bArr2[i9] = (byte) ((i2 / 256) & 255);
                    bArr2[i9 + 1] = (byte) (i2 & 255);
                }
                System.arraycopy(bArr, i3, bArr2, i9 + i5, i4 - i3);
                if (this.a) {
                    byte[] bArr3 = {(byte) Math.floor(Math.random() * 256.0d), (byte) Math.floor(Math.random() * 256.0d), (byte) Math.floor(Math.random() * 256.0d), (byte) Math.floor(Math.random() * 256.0d)};
                    System.arraycopy(bArr3, 0, bArr2, i8, 4);
                    w(bArr2, bArr3, i9);
                }
                return bArr2;
            }
            bArr2[1] = (byte) (i10 | 126);
            bArr2[2] = (byte) (i7 / 256);
            bArr2[3] = (byte) (i7 & 255);
        }
        i5 = i6;
        if (i2 > 0) {
        }
        System.arraycopy(bArr, i3, bArr2, i9 + i5, i4 - i3);
        if (this.a) {
        }
        return bArr2;
    }

    private int u(byte[] bArr) {
        long l = l(bArr, 0, bArr.length);
        if (l >= 0 && l <= 2147483647L) {
            return (int) l;
        }
        throw new ProtocolError("Bad integer: " + l);
    }

    private byte[] v(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.o.setInput(bArr);
        while (!this.o.needsInput()) {
            byteArrayOutputStream.write(this.p, 0, this.o.inflate(this.p));
        }
        this.o.setInput(new byte[]{0, 0, -1, -1});
        while (!this.o.needsInput()) {
            byteArrayOutputStream.write(this.p, 0, this.o.inflate(this.p));
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static byte[] w(byte[] bArr, byte[] bArr2, int i) {
        if (bArr2.length == 0) {
            return bArr;
        }
        for (int i2 = 0; i2 < bArr.length - i; i2++) {
            int i3 = i + i2;
            bArr[i3] = (byte) (bArr[i3] ^ bArr2[i2 % 4]);
        }
        return bArr;
    }

    protected abstract void A(String str);

    protected abstract void B(String str);

    void C() {
        int i = this.c;
        if (i == 0) {
            this.v.b(1, this.q);
            return;
        }
        if (i == 1) {
            this.v.b(1, this.r);
            return;
        }
        if (i == 2) {
            this.v.b(this.h, this.s);
        } else if (i == 3) {
            this.v.b(4, this.t);
        } else {
            if (i != 4) {
                return;
            }
            this.v.b(this.i, this.u);
        }
    }

    public byte[] G(String str) {
        return p(9, str, -1);
    }

    protected abstract void H(Exception exc);

    protected abstract void J(byte[] bArr);

    public void K(boolean z) {
        this.b = z;
    }

    public void L(boolean z) {
        this.a = z;
    }

    protected void finalize() {
        Inflater inflater = this.o;
        if (inflater != null) {
            try {
                inflater.end();
            } catch (Exception e2) {
                Log.e("HybiParser", "inflater.end failed", e2);
            }
        }
        super.finalize();
    }

    public byte[] s(String str) {
        return p(1, str, -1);
    }

    public byte[] t(byte[] bArr) {
        return q(2, bArr, -1);
    }

    protected abstract void x(int i, String str);

    protected abstract void y(String str);

    protected abstract void z(byte[] bArr);
}
