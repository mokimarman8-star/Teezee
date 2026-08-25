package com.squareup.okhttp.internal.framed;

import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
abstract class c {
    private static final com.squareup.okhttp.internal.framed.b[] a;
    private static final Map b;

    static final class a {
        private final BufferedSource b;
        private int c;
        private int d;
        int f;
        private final List a = new ArrayList();
        com.squareup.okhttp.internal.framed.b[] e = new com.squareup.okhttp.internal.framed.b[8];
        int g = 0;
        int h = 0;

        a(int i, Source source) {
            this.f = r0.length - 1;
            this.c = i;
            this.d = i;
            this.b = Okio.buffer(source);
        }

        private void a() {
            int i = this.d;
            int i2 = this.h;
            if (i < i2) {
                if (i == 0) {
                    b();
                } else {
                    d(i2 - i);
                }
            }
        }

        private void b() {
            this.a.clear();
            Arrays.fill(this.e, (Object) null);
            this.f = this.e.length - 1;
            this.g = 0;
            this.h = 0;
        }

        private int c(int i) {
            return this.f + 1 + i;
        }

        private int d(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.e.length;
                while (true) {
                    length--;
                    i2 = this.f;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    int i4 = this.e[length].c;
                    i -= i4;
                    this.h -= i4;
                    this.g--;
                    i3++;
                }
                com.squareup.okhttp.internal.framed.b[] bVarArr = this.e;
                System.arraycopy(bVarArr, i2 + 1, bVarArr, i2 + 1 + i3, this.g);
                this.f += i3;
            }
            return i3;
        }

        private ByteString f(int i) {
            return i(i) ? c.a[i].a : this.e[c(i - c.a.length)].a;
        }

        private void h(int i, com.squareup.okhttp.internal.framed.b bVar) {
            this.a.add(bVar);
            int i2 = bVar.c;
            if (i != -1) {
                i2 -= this.e[c(i)].c;
            }
            int i3 = this.d;
            if (i2 > i3) {
                b();
                return;
            }
            int d = d((this.h + i2) - i3);
            if (i == -1) {
                int i4 = this.g + 1;
                com.squareup.okhttp.internal.framed.b[] bVarArr = this.e;
                if (i4 > bVarArr.length) {
                    com.squareup.okhttp.internal.framed.b[] bVarArr2 = new com.squareup.okhttp.internal.framed.b[bVarArr.length * 2];
                    System.arraycopy(bVarArr, 0, bVarArr2, bVarArr.length, bVarArr.length);
                    this.f = this.e.length - 1;
                    this.e = bVarArr2;
                }
                int i5 = this.f;
                this.f = i5 - 1;
                this.e[i5] = bVar;
                this.g++;
            } else {
                this.e[i + c(i) + d] = bVar;
            }
            this.h += i2;
        }

        private boolean i(int i) {
            return i >= 0 && i <= c.a.length - 1;
        }

        private int j() {
            return this.b.readByte() & 255;
        }

        private void m(int i) {
            if (i(i)) {
                this.a.add(c.a[i]);
                return;
            }
            int c = c(i - c.a.length);
            if (c >= 0) {
                com.squareup.okhttp.internal.framed.b[] bVarArr = this.e;
                if (c <= bVarArr.length - 1) {
                    this.a.add(bVarArr[c]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        private void o(int i) {
            h(-1, new com.squareup.okhttp.internal.framed.b(f(i), k()));
        }

        private void p() {
            h(-1, new com.squareup.okhttp.internal.framed.b(c.d(k()), k()));
        }

        private void q(int i) {
            this.a.add(new com.squareup.okhttp.internal.framed.b(f(i), k()));
        }

        private void r() {
            this.a.add(new com.squareup.okhttp.internal.framed.b(c.d(k()), k()));
        }

        public List e() {
            ArrayList arrayList = new ArrayList(this.a);
            this.a.clear();
            return arrayList;
        }

        void g(int i) {
            this.c = i;
            this.d = i;
            a();
        }

        ByteString k() {
            int j = j();
            boolean z = (j & 128) == 128;
            int n = n(j, 127);
            return z ? ByteString.of(e.d().c(this.b.readByteArray(n))) : this.b.readByteString(n);
        }

        void l() {
            while (!this.b.exhausted()) {
                byte readByte = this.b.readByte();
                int i = readByte & 255;
                if (i == 128) {
                    throw new IOException("index == 0");
                }
                if ((readByte & 128) == 128) {
                    m(n(i, 127) - 1);
                } else if (i == 64) {
                    p();
                } else if ((readByte & 64) == 64) {
                    o(n(i, 63) - 1);
                } else if ((readByte & 32) == 32) {
                    int n = n(i, 31);
                    this.d = n;
                    if (n < 0 || n > this.c) {
                        throw new IOException("Invalid dynamic table size update " + this.d);
                    }
                    a();
                } else if (i == 16 || i == 0) {
                    r();
                } else {
                    q(n(i, 15) - 1);
                }
            }
        }

        int n(int i, int i2) {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int j = j();
                if ((j & 128) == 0) {
                    return i2 + (j << i4);
                }
                i2 += (j & 127) << i4;
                i4 += 7;
            }
        }
    }

    static final class b {
        private final Buffer a;

        b(Buffer buffer) {
            this.a = buffer;
        }

        void a(ByteString byteString) {
            c(byteString.size(), 127, 0);
            this.a.write(byteString);
        }

        void b(List list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ByteString asciiLowercase = ((com.squareup.okhttp.internal.framed.b) list.get(i)).a.toAsciiLowercase();
                Integer num = (Integer) c.b.get(asciiLowercase);
                if (num != null) {
                    c(num.intValue() + 1, 15, 0);
                    a(((com.squareup.okhttp.internal.framed.b) list.get(i)).b);
                } else {
                    this.a.writeByte(0);
                    a(asciiLowercase);
                    a(((com.squareup.okhttp.internal.framed.b) list.get(i)).b);
                }
            }
        }

        void c(int i, int i2, int i3) {
            if (i < i2) {
                this.a.writeByte(i | i3);
                return;
            }
            this.a.writeByte(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.a.writeByte(128 | (i4 & 127));
                i4 >>>= 7;
            }
            this.a.writeByte(i4);
        }
    }

    static {
        com.squareup.okhttp.internal.framed.b bVar = new com.squareup.okhttp.internal.framed.b(com.squareup.okhttp.internal.framed.b.h, TtmlNode.ANONYMOUS_REGION_ID);
        ByteString byteString = com.squareup.okhttp.internal.framed.b.e;
        com.squareup.okhttp.internal.framed.b bVar2 = new com.squareup.okhttp.internal.framed.b(byteString, "GET");
        com.squareup.okhttp.internal.framed.b bVar3 = new com.squareup.okhttp.internal.framed.b(byteString, "POST");
        ByteString byteString2 = com.squareup.okhttp.internal.framed.b.f;
        com.squareup.okhttp.internal.framed.b bVar4 = new com.squareup.okhttp.internal.framed.b(byteString2, "/");
        com.squareup.okhttp.internal.framed.b bVar5 = new com.squareup.okhttp.internal.framed.b(byteString2, "/index.html");
        ByteString byteString3 = com.squareup.okhttp.internal.framed.b.g;
        com.squareup.okhttp.internal.framed.b bVar6 = new com.squareup.okhttp.internal.framed.b(byteString3, "http");
        com.squareup.okhttp.internal.framed.b bVar7 = new com.squareup.okhttp.internal.framed.b(byteString3, "https");
        ByteString byteString4 = com.squareup.okhttp.internal.framed.b.d;
        a = new com.squareup.okhttp.internal.framed.b[]{bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7, new com.squareup.okhttp.internal.framed.b(byteString4, "200"), new com.squareup.okhttp.internal.framed.b(byteString4, "204"), new com.squareup.okhttp.internal.framed.b(byteString4, "206"), new com.squareup.okhttp.internal.framed.b(byteString4, "304"), new com.squareup.okhttp.internal.framed.b(byteString4, "400"), new com.squareup.okhttp.internal.framed.b(byteString4, "404"), new com.squareup.okhttp.internal.framed.b(byteString4, "500"), new com.squareup.okhttp.internal.framed.b("accept-charset", TtmlNode.ANONYMOUS_REGION_ID), new com.squareup.okhttp.internal.framed.b("accept-encoding", "gzip, deflate"), new com.squareup.okhttp.internal.framed.b("accept-language", TtmlNode.ANONYMOUS_REGION_ID), new com.squareup.okhttp.internal.framed.b("accept-ranges", TtmlNode.ANONYMOUS_REGION_ID), new com.squareup.okhttp.internal.framed.b("accept", TtmlNode.ANONYMOUS_REGION_ID), new com.squareup.okhttp.internal.framed.b("access-control-allow-origin", TtmlNode.ANONYMOUS_REGION_ID), new com.squareup.okhttp.internal.framed.b("age", TtmlNode.ANONYMOUS_REGION_ID), new com.squareup.okhttp.internal.framed.b("allow", TtmlNode.ANONYMOUS_REGION_ID), new com.squareup.okhttp.internal.framed.b("authorization", TtmlNode.ANONYMOUS_REGION_ID), new com.squareup.okhttp.internal.framed.b("cache-control", TtmlNode.ANONYMOUS_REGION_ID), new com.squareup.okhttp.internal.framed.b("content-disposition", TtmlNode.ANONYMOUS_REGION_ID), new com.squareup.okhttp.internal.framed.b("content-encoding", TtmlNode.ANONYMOUS_REGION_ID), new com.squareup.okhttp.internal.framed.b("content-language", TtmlNode.ANONYMOUS_REGION_ID), new com.squareup.okhttp.internal.framed.b("content-length", TtmlNode.ANONYMOUS_REGION_ID), new com.squareup.okhttp.internal.framed.b("content-location", TtmlNode.ANONYMOUS_REGION_ID), new com.squareup.okhttp.internal.framed.b("content-range", TtmlNode.ANONYMOUS_REGION_ID), new com.squareup.okhttp.internal.framed.b("content-type", TtmlNode.ANONYMOUS_REGION_ID), new com.squareup.okhttp.internal.framed.b("cookie", TtmlNode.ANONYMOUS_REGION_ID), new com.squareup.okhttp.internal.framed.b("date", TtmlNode.ANONYMOUS_REGION_ID), new com.squareup.okhttp.internal.framed.b(DownloadModel.ETAG, TtmlNode.ANONYMOUS_REGION_ID), new com.squareup.okhttp.internal.framed.b("expect", TtmlNode.ANONYMOUS_REGION_ID), new com.squareup.okhttp.internal.framed.b("expires", TtmlNode.ANONYMOUS_REGION_ID), new com.squareup.okhttp.internal.framed.b("from", TtmlNode.ANONYMOUS_REGION_ID), new com.squareup.okhttp.internal.framed.b("host", TtmlNode.ANONYMOUS_REGION_ID), new com.squareup.okhttp.internal.framed.b("if-match", TtmlNode.ANONYMOUS_REGION_ID), new com.squareup.okhttp.internal.framed.b("if-modified-since", TtmlNode.ANONYMOUS_REGION_ID), new com.squareup.okhttp.internal.framed.b("if-none-match", TtmlNode.ANONYMOUS_REGION_ID), new com.squareup.okhttp.internal.framed.b("if-range", TtmlNode.ANONYMOUS_REGION_ID), new com.squareup.okhttp.internal.framed.b("if-unmodified-since", TtmlNode.ANONYMOUS_REGION_ID), new com.squareup.okhttp.internal.framed.b("last-modified", TtmlNode.ANONYMOUS_REGION_ID), new com.squareup.okhttp.internal.framed.b("link", TtmlNode.ANONYMOUS_REGION_ID), new com.squareup.okhttp.internal.framed.b("location", TtmlNode.ANONYMOUS_REGION_ID), new com.squareup.okhttp.internal.framed.b("max-forwards", TtmlNode.ANONYMOUS_REGION_ID), new com.squareup.okhttp.internal.framed.b("proxy-authenticate", TtmlNode.ANONYMOUS_REGION_ID), new com.squareup.okhttp.internal.framed.b("proxy-authorization", TtmlNode.ANONYMOUS_REGION_ID), new com.squareup.okhttp.internal.framed.b("range", TtmlNode.ANONYMOUS_REGION_ID), new com.squareup.okhttp.internal.framed.b("referer", TtmlNode.ANONYMOUS_REGION_ID), new com.squareup.okhttp.internal.framed.b(ToolBar.REFRESH, TtmlNode.ANONYMOUS_REGION_ID), new com.squareup.okhttp.internal.framed.b("retry-after", TtmlNode.ANONYMOUS_REGION_ID), new com.squareup.okhttp.internal.framed.b("server", TtmlNode.ANONYMOUS_REGION_ID), new com.squareup.okhttp.internal.framed.b("set-cookie", TtmlNode.ANONYMOUS_REGION_ID), new com.squareup.okhttp.internal.framed.b("strict-transport-security", TtmlNode.ANONYMOUS_REGION_ID), new com.squareup.okhttp.internal.framed.b("transfer-encoding", TtmlNode.ANONYMOUS_REGION_ID), new com.squareup.okhttp.internal.framed.b("user-agent", TtmlNode.ANONYMOUS_REGION_ID), new com.squareup.okhttp.internal.framed.b("vary", TtmlNode.ANONYMOUS_REGION_ID), new com.squareup.okhttp.internal.framed.b("via", TtmlNode.ANONYMOUS_REGION_ID), new com.squareup.okhttp.internal.framed.b("www-authenticate", TtmlNode.ANONYMOUS_REGION_ID)};
        b = e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ByteString d(ByteString byteString) {
        int size = byteString.size();
        for (int i = 0; i < size; i++) {
            byte b2 = byteString.getByte(i);
            if (b2 >= 65 && b2 <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.utf8());
            }
        }
        return byteString;
    }

    private static Map e() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(a.length);
        int i = 0;
        while (true) {
            com.squareup.okhttp.internal.framed.b[] bVarArr = a;
            if (i >= bVarArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(bVarArr[i].a)) {
                linkedHashMap.put(bVarArr[i].a, Integer.valueOf(i));
            }
            i++;
        }
    }
}
