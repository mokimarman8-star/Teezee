package com.pgl.ssdk;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class d {

    public static class a {
        private final long a;
        private final o b;

        public a(long j, o oVar) {
            this.a = j;
            this.b = oVar;
        }

        public o a() {
            return this.b;
        }

        public long b() {
            return this.a;
        }
    }

    public static a a(o oVar, r rVar) throws IOException, b {
        long a2 = rVar.a();
        long c = rVar.c() + a2;
        long e = rVar.e();
        if (c != e) {
            throw new b("ZIP Central Directory is not immediately followed by End of Central Directory. CD end: " + c + ", EoCD start: " + e);
        }
        if (a2 < 32) {
            throw new b("APK too small for APK Signing Block. ZIP Central Directory offset: ".concat(String.valueOf(a2)));
        }
        ByteBuffer a3 = oVar.a(a2 - 24, 24);
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        a3.order(byteOrder);
        if (a3.getLong(8) != 2334950737559900225L || a3.getLong(16) != 3617552046287187010L) {
            throw new b("No APK Signing Block before ZIP Central Directory");
        }
        long j = a3.getLong(0);
        if (j < a3.capacity() || j > 2147483639) {
            throw new b("APK Signing Block size out of range: ".concat(String.valueOf(j)));
        }
        long j2 = (int) (8 + j);
        long j3 = a2 - j2;
        if (j3 < 0) {
            throw new b("APK Signing Block offset out of range: ".concat(String.valueOf(j3)));
        }
        ByteBuffer a4 = oVar.a(j3, 8);
        a4.order(byteOrder);
        long j4 = a4.getLong(0);
        if (j4 == j) {
            return new a(j3, oVar.a(j3, j2));
        }
        throw new b("APK Signing Block sizes in header and footer do not match: " + j4 + " vs " + j);
    }

    public static r a(o oVar) throws IOException, q {
        m<ByteBuffer, Long> a2 = n.a(oVar);
        if (a2 == null) {
            throw new q("ZIP End of Central Directory record not found");
        }
        ByteBuffer a3 = a2.a();
        long longValue = a2.b().longValue();
        a3.order(ByteOrder.LITTLE_ENDIAN);
        long c = n.c(a3);
        if (c > longValue) {
            throw new q("ZIP Central Directory start offset out of range: " + c + ". ZIP End of Central Directory offset: " + longValue);
        }
        long d = n.d(a3);
        long j = c + d;
        if (j <= longValue) {
            return new r(c, d, n.e(a3), longValue, a3);
        }
        throw new q("ZIP Central Directory overlaps with End of Central Directory. CD end: " + j + ", EoCD start: " + longValue);
    }
}
