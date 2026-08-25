package com.google.common.hash;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class Murmur3_128HashFunction extends com.google.common.hash.a implements Serializable {
    private static final long serialVersionUID = 0;
    private final int seed;
    static final d MURMUR3_128 = new Murmur3_128HashFunction(0);
    static final d GOOD_FAST_HASH_128 = new Murmur3_128HashFunction(f.a);

    private static final class a extends c {
        private long d;
        private long e;
        private int f;

        a(int i) {
            super(16);
            long j = i;
            this.d = j;
            this.e = j;
            this.f = 0;
        }

        private void q(long j, long j2) {
            long s = s(j) ^ this.d;
            this.d = s;
            long rotateLeft = Long.rotateLeft(s, 27);
            long j3 = this.e;
            this.d = ((rotateLeft + j3) * 5) + 1390208809;
            long t = t(j2) ^ j3;
            this.e = t;
            this.e = ((Long.rotateLeft(t, 31) + this.d) * 5) + 944331445;
        }

        private static long r(long j) {
            long j2 = (j ^ (j >>> 33)) * (-49064778989728563L);
            long j3 = (j2 ^ (j2 >>> 33)) * (-4265267296055464877L);
            return j3 ^ (j3 >>> 33);
        }

        private static long s(long j) {
            return Long.rotateLeft(j * (-8663945395140668459L), 31) * 5545529020109919103L;
        }

        private static long t(long j) {
            return Long.rotateLeft(j * 5545529020109919103L, 33) * (-8663945395140668459L);
        }

        @Override // com.google.common.hash.c
        protected HashCode k() {
            long j = this.d;
            int i = this.f;
            long j2 = j ^ i;
            long j3 = this.e ^ i;
            long j4 = j2 + j3;
            this.d = j4;
            this.e = j3 + j4;
            this.d = r(j4);
            long r = r(this.e);
            long j5 = this.d + r;
            this.d = j5;
            this.e = r + j5;
            return HashCode.fromBytesNoCopy(ByteBuffer.wrap(new byte[16]).order(ByteOrder.LITTLE_ENDIAN).putLong(this.d).putLong(this.e).array());
        }

        @Override // com.google.common.hash.c
        protected void n(ByteBuffer byteBuffer) {
            q(byteBuffer.getLong(), byteBuffer.getLong());
            this.f += 16;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.google.common.hash.c
        protected void o(ByteBuffer byteBuffer) {
            long j;
            long j2;
            long j3;
            long j4;
            long j5;
            long j6;
            long c;
            this.f += byteBuffer.remaining();
            long j7 = 0;
            switch (byteBuffer.remaining()) {
                case 1:
                    j = 0;
                    c = j ^ com.google.common.primitives.f.c(byteBuffer.get(0));
                    this.d = s(c) ^ this.d;
                    this.e ^= t(j7);
                    return;
                case 2:
                    j2 = 0;
                    j = j2 ^ (com.google.common.primitives.f.c(byteBuffer.get(1)) << 8);
                    c = j ^ com.google.common.primitives.f.c(byteBuffer.get(0));
                    this.d = s(c) ^ this.d;
                    this.e ^= t(j7);
                    return;
                case 3:
                    j3 = 0;
                    j2 = (com.google.common.primitives.f.c(byteBuffer.get(2)) << 16) ^ j3;
                    j = j2 ^ (com.google.common.primitives.f.c(byteBuffer.get(1)) << 8);
                    c = j ^ com.google.common.primitives.f.c(byteBuffer.get(0));
                    this.d = s(c) ^ this.d;
                    this.e ^= t(j7);
                    return;
                case 4:
                    j4 = 0;
                    j3 = j4 ^ (com.google.common.primitives.f.c(byteBuffer.get(3)) << 24);
                    j2 = (com.google.common.primitives.f.c(byteBuffer.get(2)) << 16) ^ j3;
                    j = j2 ^ (com.google.common.primitives.f.c(byteBuffer.get(1)) << 8);
                    c = j ^ com.google.common.primitives.f.c(byteBuffer.get(0));
                    this.d = s(c) ^ this.d;
                    this.e ^= t(j7);
                    return;
                case 5:
                    j5 = 0;
                    j4 = j5 ^ (com.google.common.primitives.f.c(byteBuffer.get(4)) << 32);
                    j3 = j4 ^ (com.google.common.primitives.f.c(byteBuffer.get(3)) << 24);
                    j2 = (com.google.common.primitives.f.c(byteBuffer.get(2)) << 16) ^ j3;
                    j = j2 ^ (com.google.common.primitives.f.c(byteBuffer.get(1)) << 8);
                    c = j ^ com.google.common.primitives.f.c(byteBuffer.get(0));
                    this.d = s(c) ^ this.d;
                    this.e ^= t(j7);
                    return;
                case 6:
                    j6 = 0;
                    j5 = (com.google.common.primitives.f.c(byteBuffer.get(5)) << 40) ^ j6;
                    j4 = j5 ^ (com.google.common.primitives.f.c(byteBuffer.get(4)) << 32);
                    j3 = j4 ^ (com.google.common.primitives.f.c(byteBuffer.get(3)) << 24);
                    j2 = (com.google.common.primitives.f.c(byteBuffer.get(2)) << 16) ^ j3;
                    j = j2 ^ (com.google.common.primitives.f.c(byteBuffer.get(1)) << 8);
                    c = j ^ com.google.common.primitives.f.c(byteBuffer.get(0));
                    this.d = s(c) ^ this.d;
                    this.e ^= t(j7);
                    return;
                case 7:
                    j6 = com.google.common.primitives.f.c(byteBuffer.get(6)) << 48;
                    j5 = (com.google.common.primitives.f.c(byteBuffer.get(5)) << 40) ^ j6;
                    j4 = j5 ^ (com.google.common.primitives.f.c(byteBuffer.get(4)) << 32);
                    j3 = j4 ^ (com.google.common.primitives.f.c(byteBuffer.get(3)) << 24);
                    j2 = (com.google.common.primitives.f.c(byteBuffer.get(2)) << 16) ^ j3;
                    j = j2 ^ (com.google.common.primitives.f.c(byteBuffer.get(1)) << 8);
                    c = j ^ com.google.common.primitives.f.c(byteBuffer.get(0));
                    this.d = s(c) ^ this.d;
                    this.e ^= t(j7);
                    return;
                case 8:
                    c = byteBuffer.getLong();
                    this.d = s(c) ^ this.d;
                    this.e ^= t(j7);
                    return;
                case 9:
                    j7 ^= com.google.common.primitives.f.c(byteBuffer.get(8));
                    c = byteBuffer.getLong();
                    this.d = s(c) ^ this.d;
                    this.e ^= t(j7);
                    return;
                case 10:
                    j7 ^= com.google.common.primitives.f.c(byteBuffer.get(9)) << 8;
                    j7 ^= com.google.common.primitives.f.c(byteBuffer.get(8));
                    c = byteBuffer.getLong();
                    this.d = s(c) ^ this.d;
                    this.e ^= t(j7);
                    return;
                case 11:
                    j7 ^= com.google.common.primitives.f.c(byteBuffer.get(10)) << 16;
                    j7 ^= com.google.common.primitives.f.c(byteBuffer.get(9)) << 8;
                    j7 ^= com.google.common.primitives.f.c(byteBuffer.get(8));
                    c = byteBuffer.getLong();
                    this.d = s(c) ^ this.d;
                    this.e ^= t(j7);
                    return;
                case 12:
                    j7 ^= com.google.common.primitives.f.c(byteBuffer.get(11)) << 24;
                    j7 ^= com.google.common.primitives.f.c(byteBuffer.get(10)) << 16;
                    j7 ^= com.google.common.primitives.f.c(byteBuffer.get(9)) << 8;
                    j7 ^= com.google.common.primitives.f.c(byteBuffer.get(8));
                    c = byteBuffer.getLong();
                    this.d = s(c) ^ this.d;
                    this.e ^= t(j7);
                    return;
                case 13:
                    j7 ^= com.google.common.primitives.f.c(byteBuffer.get(12)) << 32;
                    j7 ^= com.google.common.primitives.f.c(byteBuffer.get(11)) << 24;
                    j7 ^= com.google.common.primitives.f.c(byteBuffer.get(10)) << 16;
                    j7 ^= com.google.common.primitives.f.c(byteBuffer.get(9)) << 8;
                    j7 ^= com.google.common.primitives.f.c(byteBuffer.get(8));
                    c = byteBuffer.getLong();
                    this.d = s(c) ^ this.d;
                    this.e ^= t(j7);
                    return;
                case 14:
                    j7 ^= com.google.common.primitives.f.c(byteBuffer.get(13)) << 40;
                    j7 ^= com.google.common.primitives.f.c(byteBuffer.get(12)) << 32;
                    j7 ^= com.google.common.primitives.f.c(byteBuffer.get(11)) << 24;
                    j7 ^= com.google.common.primitives.f.c(byteBuffer.get(10)) << 16;
                    j7 ^= com.google.common.primitives.f.c(byteBuffer.get(9)) << 8;
                    j7 ^= com.google.common.primitives.f.c(byteBuffer.get(8));
                    c = byteBuffer.getLong();
                    this.d = s(c) ^ this.d;
                    this.e ^= t(j7);
                    return;
                case 15:
                    j7 = com.google.common.primitives.f.c(byteBuffer.get(14)) << 48;
                    j7 ^= com.google.common.primitives.f.c(byteBuffer.get(13)) << 40;
                    j7 ^= com.google.common.primitives.f.c(byteBuffer.get(12)) << 32;
                    j7 ^= com.google.common.primitives.f.c(byteBuffer.get(11)) << 24;
                    j7 ^= com.google.common.primitives.f.c(byteBuffer.get(10)) << 16;
                    j7 ^= com.google.common.primitives.f.c(byteBuffer.get(9)) << 8;
                    j7 ^= com.google.common.primitives.f.c(byteBuffer.get(8));
                    c = byteBuffer.getLong();
                    this.d = s(c) ^ this.d;
                    this.e ^= t(j7);
                    return;
                default:
                    throw new AssertionError("Should never get here.");
            }
        }
    }

    Murmur3_128HashFunction(int i) {
        this.seed = i;
    }

    public int bits() {
        return 128;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Murmur3_128HashFunction) && this.seed == ((Murmur3_128HashFunction) obj).seed;
    }

    public int hashCode() {
        return Murmur3_128HashFunction.class.hashCode() ^ this.seed;
    }

    @Override // com.google.common.hash.d
    public e newHasher() {
        return new a(this.seed);
    }

    public String toString() {
        return "Hashing.murmur3_128(" + this.seed + ")";
    }
}
