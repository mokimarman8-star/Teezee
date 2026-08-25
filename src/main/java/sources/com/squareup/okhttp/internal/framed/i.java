package com.squareup.okhttp.internal.framed;

import com.google.protobuf.h1;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.framed.FrameReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.util.List;
import java.util.zip.Deflater;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.DeflaterSink;
import okio.Okio;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class i implements Variant {
    static final byte[] a;

    static final class a implements FrameReader {
        private final BufferedSource a;
        private final boolean b;
        private final f c;

        a(BufferedSource bufferedSource, boolean z) {
            this.a = bufferedSource;
            this.c = new f(bufferedSource);
            this.b = z;
        }

        private static IOException b(String str, Object... objArr) {
            throw new IOException(String.format(str, objArr));
        }

        private void d(FrameReader.Handler handler, int i, int i2) {
            if (i2 != 8) {
                throw b("TYPE_GOAWAY length: %d != 8", Integer.valueOf(i2));
            }
            int readInt = this.a.readInt() & h1.READ_DONE;
            int readInt2 = this.a.readInt();
            ErrorCode fromSpdyGoAway = ErrorCode.fromSpdyGoAway(readInt2);
            if (fromSpdyGoAway == null) {
                throw b("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt2));
            }
            handler.goAway(readInt, fromSpdyGoAway, ByteString.EMPTY);
        }

        private void f(FrameReader.Handler handler, int i, int i2) {
            handler.headers(false, false, this.a.readInt() & h1.READ_DONE, -1, this.c.f(i2 - 4), HeadersMode.SPDY_HEADERS);
        }

        private void h(FrameReader.Handler handler, int i, int i2) {
            if (i2 != 4) {
                throw b("TYPE_PING length: %d != 4", Integer.valueOf(i2));
            }
            int readInt = this.a.readInt();
            handler.ping(this.b == ((readInt & 1) == 1), readInt, 0);
        }

        private void j(FrameReader.Handler handler, int i, int i2) {
            if (i2 != 8) {
                throw b("TYPE_RST_STREAM length: %d != 8", Integer.valueOf(i2));
            }
            int readInt = this.a.readInt() & h1.READ_DONE;
            int readInt2 = this.a.readInt();
            ErrorCode fromSpdy3Rst = ErrorCode.fromSpdy3Rst(readInt2);
            if (fromSpdy3Rst == null) {
                throw b("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt2));
            }
            handler.rstStream(readInt, fromSpdy3Rst);
        }

        private void k(FrameReader.Handler handler, int i, int i2) {
            int readInt = this.a.readInt();
            if (i2 != (readInt * 8) + 4) {
                throw b("TYPE_SETTINGS length: %d != 4 + 8 * %d", Integer.valueOf(i2), Integer.valueOf(readInt));
            }
            h hVar = new h();
            for (int i3 = 0; i3 < readInt; i3++) {
                int readInt2 = this.a.readInt();
                hVar.l(readInt2 & 16777215, ((-16777216) & readInt2) >>> 24, this.a.readInt());
            }
            handler.settings((i & 1) != 0, hVar);
        }

        private void l(FrameReader.Handler handler, int i, int i2) {
            handler.headers(false, (i & 1) != 0, this.a.readInt() & h1.READ_DONE, -1, this.c.f(i2 - 4), HeadersMode.SPDY_REPLY);
        }

        private void m(FrameReader.Handler handler, int i, int i2) {
            int readInt = this.a.readInt();
            int readInt2 = this.a.readInt();
            int i3 = readInt & h1.READ_DONE;
            int i4 = readInt2 & h1.READ_DONE;
            this.a.readShort();
            handler.headers((i & 2) != 0, (i & 1) != 0, i3, i4, this.c.f(i2 - 10), HeadersMode.SPDY_SYN_STREAM);
        }

        private void n(FrameReader.Handler handler, int i, int i2) {
            if (i2 != 8) {
                throw b("TYPE_WINDOW_UPDATE length: %d != 8", Integer.valueOf(i2));
            }
            int readInt = this.a.readInt();
            int readInt2 = this.a.readInt();
            int i3 = readInt & h1.READ_DONE;
            long j = readInt2 & h1.READ_DONE;
            if (j == 0) {
                throw b("windowSizeIncrement was 0", Long.valueOf(j));
            }
            handler.windowUpdate(i3, j);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.c.c();
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader
        public boolean nextFrame(FrameReader.Handler handler) {
            try {
                int readInt = this.a.readInt();
                int readInt2 = this.a.readInt();
                int i = ((-16777216) & readInt2) >>> 24;
                int i2 = readInt2 & 16777215;
                if (!((Integer.MIN_VALUE & readInt) != 0)) {
                    handler.data((i & 1) != 0, readInt & h1.READ_DONE, this.a, i2);
                    return true;
                }
                int i3 = (2147418112 & readInt) >>> 16;
                int i4 = readInt & 65535;
                if (i3 != 3) {
                    throw new ProtocolException("version != 3: " + i3);
                }
                switch (i4) {
                    case 1:
                        m(handler, i, i2);
                        return true;
                    case 2:
                        l(handler, i, i2);
                        return true;
                    case 3:
                        j(handler, i, i2);
                        return true;
                    case 4:
                        k(handler, i, i2);
                        return true;
                    case 5:
                    default:
                        this.a.skip(i2);
                        return true;
                    case 6:
                        h(handler, i, i2);
                        return true;
                    case 7:
                        d(handler, i, i2);
                        return true;
                    case 8:
                        f(handler, i, i2);
                        return true;
                    case 9:
                        n(handler, i, i2);
                        return true;
                }
            } catch (IOException unused) {
                return false;
            }
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader
        public void readConnectionPreface() {
        }
    }

    static final class b implements FrameWriter {
        private final BufferedSink a;
        private final Buffer b;
        private final BufferedSink c;
        private final boolean d;
        private boolean e;

        b(BufferedSink bufferedSink, boolean z) {
            this.a = bufferedSink;
            this.d = z;
            Deflater deflater = new Deflater();
            deflater.setDictionary(i.a);
            Buffer buffer = new Buffer();
            this.b = buffer;
            this.c = Okio.buffer(new DeflaterSink(buffer, deflater));
        }

        private void d(List list) {
            this.c.writeInt(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ByteString byteString = ((com.squareup.okhttp.internal.framed.b) list.get(i)).a;
                this.c.writeInt(byteString.size());
                this.c.write(byteString);
                ByteString byteString2 = ((com.squareup.okhttp.internal.framed.b) list.get(i)).b;
                this.c.writeInt(byteString2.size());
                this.c.write(byteString2);
            }
            this.c.flush();
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public void ackSettings(h hVar) {
        }

        void b(int i, int i2, Buffer buffer, int i3) {
            if (this.e) {
                throw new IOException("closed");
            }
            long j = i3;
            if (j > 16777215) {
                throw new IllegalArgumentException("FRAME_TOO_LARGE max size is 16Mib: " + i3);
            }
            this.a.writeInt(i & h1.READ_DONE);
            this.a.writeInt(((i2 & 255) << 24) | (16777215 & i3));
            if (i3 > 0) {
                this.a.write(buffer, j);
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            this.e = true;
            com.squareup.okhttp.internal.g.b(this.a, this.c);
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void connectionPreface() {
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void data(boolean z, int i, Buffer buffer, int i2) {
            b(i, z ? 1 : 0, buffer, i2);
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void flush() {
            if (this.e) {
                throw new IOException("closed");
            }
            this.a.flush();
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void goAway(int i, ErrorCode errorCode, byte[] bArr) {
            if (this.e) {
                throw new IOException("closed");
            }
            if (errorCode.spdyGoAwayCode == -1) {
                throw new IllegalArgumentException("errorCode.spdyGoAwayCode == -1");
            }
            this.a.writeInt(-2147287033);
            this.a.writeInt(8);
            this.a.writeInt(i);
            this.a.writeInt(errorCode.spdyGoAwayCode);
            this.a.flush();
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void headers(int i, List list) {
            if (this.e) {
                throw new IOException("closed");
            }
            d(list);
            int size = (int) (this.b.size() + 4);
            this.a.writeInt(-2147287032);
            this.a.writeInt(size & 16777215);
            this.a.writeInt(i & h1.READ_DONE);
            this.a.writeAll(this.b);
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public int maxDataLength() {
            return 16383;
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void ping(boolean z, int i, int i2) {
            if (this.e) {
                throw new IOException("closed");
            }
            if (z != (this.d != ((i & 1) == 1))) {
                throw new IllegalArgumentException("payload != reply");
            }
            this.a.writeInt(-2147287034);
            this.a.writeInt(4);
            this.a.writeInt(i);
            this.a.flush();
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public void pushPromise(int i, int i2, List list) {
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void rstStream(int i, ErrorCode errorCode) {
            if (this.e) {
                throw new IOException("closed");
            }
            if (errorCode.spdyRstCode == -1) {
                throw new IllegalArgumentException();
            }
            this.a.writeInt(-2147287037);
            this.a.writeInt(8);
            this.a.writeInt(i & h1.READ_DONE);
            this.a.writeInt(errorCode.spdyRstCode);
            this.a.flush();
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void settings(h hVar) {
            try {
                if (this.e) {
                    throw new IOException("closed");
                }
                int m = hVar.m();
                this.a.writeInt(-2147287036);
                this.a.writeInt(((m * 8) + 4) & 16777215);
                this.a.writeInt(m);
                for (int i = 0; i <= 10; i++) {
                    if (hVar.i(i)) {
                        this.a.writeInt(((hVar.b(i) & 255) << 24) | (i & 16777215));
                        this.a.writeInt(hVar.c(i));
                    }
                }
                this.a.flush();
            } catch (Throwable th) {
                throw th;
            }
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void synReply(boolean z, int i, List list) {
            if (this.e) {
                throw new IOException("closed");
            }
            d(list);
            int size = (int) (this.b.size() + 4);
            this.a.writeInt(-2147287038);
            this.a.writeInt((((z ? 1 : 0) & 255) << 24) | (size & 16777215));
            this.a.writeInt(i & h1.READ_DONE);
            this.a.writeAll(this.b);
            this.a.flush();
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void synStream(boolean z, boolean z2, int i, int i2, List list) {
            if (this.e) {
                throw new IOException("closed");
            }
            d(list);
            int size = (int) (this.b.size() + 10);
            int i3 = (z ? 1 : 0) | (z2 ? 2 : 0);
            this.a.writeInt(-2147287039);
            this.a.writeInt(((i3 & 255) << 24) | (size & 16777215));
            this.a.writeInt(i & h1.READ_DONE);
            this.a.writeInt(Integer.MAX_VALUE & i2);
            this.a.writeShort(0);
            this.a.writeAll(this.b);
            this.a.flush();
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void windowUpdate(int i, long j) {
            if (this.e) {
                throw new IOException("closed");
            }
            if (j == 0 || j > 2147483647L) {
                throw new IllegalArgumentException("windowSizeIncrement must be between 1 and 0x7fffffff: " + j);
            }
            this.a.writeInt(-2147287031);
            this.a.writeInt(8);
            this.a.writeInt(i);
            this.a.writeInt((int) j);
            this.a.flush();
        }
    }

    static {
        try {
            a = "\u0000\u0000\u0000\u0007options\u0000\u0000\u0000\u0004head\u0000\u0000\u0000\u0004post\u0000\u0000\u0000\u0003put\u0000\u0000\u0000\u0006delete\u0000\u0000\u0000\u0005trace\u0000\u0000\u0000\u0006accept\u0000\u0000\u0000\u000eaccept-charset\u0000\u0000\u0000\u000faccept-encoding\u0000\u0000\u0000\u000faccept-language\u0000\u0000\u0000\raccept-ranges\u0000\u0000\u0000\u0003age\u0000\u0000\u0000\u0005allow\u0000\u0000\u0000\rauthorization\u0000\u0000\u0000\rcache-control\u0000\u0000\u0000\nconnection\u0000\u0000\u0000\fcontent-base\u0000\u0000\u0000\u0010content-encoding\u0000\u0000\u0000\u0010content-language\u0000\u0000\u0000\u000econtent-length\u0000\u0000\u0000\u0010content-location\u0000\u0000\u0000\u000bcontent-md5\u0000\u0000\u0000\rcontent-range\u0000\u0000\u0000\fcontent-type\u0000\u0000\u0000\u0004date\u0000\u0000\u0000\u0004etag\u0000\u0000\u0000\u0006expect\u0000\u0000\u0000\u0007expires\u0000\u0000\u0000\u0004from\u0000\u0000\u0000\u0004host\u0000\u0000\u0000\bif-match\u0000\u0000\u0000\u0011if-modified-since\u0000\u0000\u0000\rif-none-match\u0000\u0000\u0000\bif-range\u0000\u0000\u0000\u0013if-unmodified-since\u0000\u0000\u0000\rlast-modified\u0000\u0000\u0000\blocation\u0000\u0000\u0000\fmax-forwards\u0000\u0000\u0000\u0006pragma\u0000\u0000\u0000\u0012proxy-authenticate\u0000\u0000\u0000\u0013proxy-authorization\u0000\u0000\u0000\u0005range\u0000\u0000\u0000\u0007referer\u0000\u0000\u0000\u000bretry-after\u0000\u0000\u0000\u0006server\u0000\u0000\u0000\u0002te\u0000\u0000\u0000\u0007trailer\u0000\u0000\u0000\u0011transfer-encoding\u0000\u0000\u0000\u0007upgrade\u0000\u0000\u0000\nuser-agent\u0000\u0000\u0000\u0004vary\u0000\u0000\u0000\u0003via\u0000\u0000\u0000\u0007warning\u0000\u0000\u0000\u0010www-authenticate\u0000\u0000\u0000\u0006method\u0000\u0000\u0000\u0003get\u0000\u0000\u0000\u0006status\u0000\u0000\u0000\u0006200 OK\u0000\u0000\u0000\u0007version\u0000\u0000\u0000\bHTTP/1.1\u0000\u0000\u0000\u0003url\u0000\u0000\u0000\u0006public\u0000\u0000\u0000\nset-cookie\u0000\u0000\u0000\nkeep-alive\u0000\u0000\u0000\u0006origin100101201202205206300302303304305306307402405406407408409410411412413414415416417502504505203 Non-Authoritative Information204 No Content301 Moved Permanently400 Bad Request401 Unauthorized403 Forbidden404 Not Found500 Internal Server Error501 Not Implemented503 Service UnavailableJan Feb Mar Apr May Jun Jul Aug Sept Oct Nov Dec 00:00:00 Mon, Tue, Wed, Thu, Fri, Sat, Sun, GMTchunked,text/html,image/png,image/jpg,image/gif,application/xml,application/xhtml+xml,text/plain,text/javascript,publicprivatemax-age=gzip,deflate,sdchcharset=utf-8charset=iso-8859-1,utf-,*,enq=0.".getBytes(com.squareup.okhttp.internal.g.c.name());
        } catch (UnsupportedEncodingException unused) {
            throw new AssertionError();
        }
    }

    @Override // com.squareup.okhttp.internal.framed.Variant
    public Protocol getProtocol() {
        return Protocol.SPDY_3;
    }

    @Override // com.squareup.okhttp.internal.framed.Variant
    public FrameReader newReader(BufferedSource bufferedSource, boolean z) {
        return new a(bufferedSource, z);
    }

    @Override // com.squareup.okhttp.internal.framed.Variant
    public FrameWriter newWriter(BufferedSink bufferedSink, boolean z) {
        return new b(bufferedSink, z);
    }
}
