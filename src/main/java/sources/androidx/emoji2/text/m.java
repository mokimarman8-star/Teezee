package androidx.emoji2.text;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
abstract class m {

    private static class a implements c {

        /* renamed from: a, reason: collision with root package name */
        private final ByteBuffer f7935a;

        a(ByteBuffer byteBuffer) {
            this.f7935a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // androidx.emoji2.text.m.c
        public int a() {
            return this.f7935a.getInt();
        }

        @Override // androidx.emoji2.text.m.c
        public long b() {
            return m.c(this.f7935a.getInt());
        }

        @Override // androidx.emoji2.text.m.c
        public long getPosition() {
            return this.f7935a.position();
        }

        @Override // androidx.emoji2.text.m.c
        public int readUnsignedShort() {
            return m.d(this.f7935a.getShort());
        }

        @Override // androidx.emoji2.text.m.c
        public void skip(int i5) {
            ByteBuffer byteBuffer = this.f7935a;
            byteBuffer.position(byteBuffer.position() + i5);
        }
    }

    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private final long f7936a;

        /* renamed from: b, reason: collision with root package name */
        private final long f7937b;

        b(long j5, long j6) {
            this.f7936a = j5;
            this.f7937b = j6;
        }

        long a() {
            return this.f7936a;
        }
    }

    private interface c {
        int a();

        long b();

        long getPosition();

        int readUnsignedShort();

        void skip(int i5);
    }

    private static b a(c cVar) {
        long j5;
        cVar.skip(4);
        int readUnsignedShort = cVar.readUnsignedShort();
        if (readUnsignedShort > 100) {
            throw new IOException("Cannot read metadata.");
        }
        cVar.skip(6);
        int i5 = 0;
        while (true) {
            if (i5 >= readUnsignedShort) {
                j5 = -1;
                break;
            }
            int a5 = cVar.a();
            cVar.skip(4);
            j5 = cVar.b();
            cVar.skip(4);
            if (1835365473 == a5) {
                break;
            }
            i5++;
        }
        if (j5 != -1) {
            cVar.skip((int) (j5 - cVar.getPosition()));
            cVar.skip(12);
            long b5 = cVar.b();
            for (int i6 = 0; i6 < b5; i6++) {
                int a6 = cVar.a();
                long b6 = cVar.b();
                long b7 = cVar.b();
                if (1164798569 == a6 || 1701669481 == a6) {
                    return new b(b6 + j5, b7);
                }
            }
        }
        throw new IOException("Cannot read metadata.");
    }

    static androidx.emoji2.text.flatbuffer.c b(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.position((int) a(new a(duplicate)).a());
        return androidx.emoji2.text.flatbuffer.c.i(duplicate);
    }

    static long c(int i5) {
        return i5 & 4294967295L;
    }

    static int d(short s5) {
        return s5 & 65535;
    }
}
