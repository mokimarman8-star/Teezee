package androidx.media3.container;

import androidx.media3.common.util.i0;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class ObuParser {

    private static class NotYetImplementedException extends Exception {
        private NotYetImplementedException() {
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final boolean f9245a;

        private b(d dVar, c cVar) {
            int i5 = cVar.f9246a;
            androidx.media3.common.util.a.a(i5 == 6 || i5 == 3);
            byte[] bArr = new byte[Math.min(4, cVar.f9247b.remaining())];
            cVar.f9247b.asReadOnlyBuffer().get(bArr);
            i0 i0Var = new i0(bArr);
            ObuParser.f(dVar.f9248a);
            if (i0Var.g()) {
                this.f9245a = false;
                return;
            }
            int h5 = i0Var.h(2);
            boolean g5 = i0Var.g();
            ObuParser.f(dVar.f9249b);
            if (!g5) {
                this.f9245a = true;
                return;
            }
            boolean g6 = (h5 == 3 || h5 == 0) ? true : i0Var.g();
            i0Var.q();
            ObuParser.f(!dVar.f9251d);
            if (i0Var.g()) {
                ObuParser.f(!dVar.f9252e);
                i0Var.q();
            }
            ObuParser.f(dVar.f9250c);
            if (h5 != 3) {
                i0Var.q();
            }
            i0Var.r(dVar.f9253f);
            if (h5 != 2 && h5 != 0 && !g6) {
                i0Var.r(3);
            }
            this.f9245a = ((h5 == 3 || h5 == 0) ? 255 : i0Var.h(8)) != 0;
        }

        public static b b(d dVar, c cVar) {
            try {
                return new b(dVar, cVar);
            } catch (NotYetImplementedException unused) {
                return null;
            }
        }

        public boolean a() {
            return this.f9245a;
        }
    }

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f9246a;

        /* renamed from: b, reason: collision with root package name */
        public final ByteBuffer f9247b;

        private c(int i5, ByteBuffer byteBuffer) {
            this.f9246a = i5;
            this.f9247b = byteBuffer;
        }
    }

    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f9248a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f9249b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f9250c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f9251d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f9252e;

        /* renamed from: f, reason: collision with root package name */
        public final int f9253f;

        private d(c cVar) {
            androidx.media3.common.util.a.a(cVar.f9246a == 1);
            byte[] bArr = new byte[cVar.f9247b.remaining()];
            cVar.f9247b.asReadOnlyBuffer().get(bArr);
            i0 i0Var = new i0(bArr);
            i0Var.r(4);
            boolean g5 = i0Var.g();
            this.f9248a = g5;
            ObuParser.f(g5);
            if (i0Var.g()) {
                b(i0Var);
                boolean g6 = i0Var.g();
                this.f9249b = g6;
                if (g6) {
                    i0Var.r(47);
                }
            } else {
                this.f9249b = false;
            }
            boolean g7 = i0Var.g();
            int h5 = i0Var.h(5);
            for (int i5 = 0; i5 <= h5; i5++) {
                i0Var.r(12);
                if (i0Var.h(5) > 7) {
                    i0Var.q();
                }
                ObuParser.f(this.f9249b);
                if (g7 && i0Var.g()) {
                    i0Var.r(4);
                }
            }
            int h6 = i0Var.h(4);
            int h7 = i0Var.h(4);
            i0Var.r(h6 + 1);
            i0Var.r(h7 + 1);
            boolean g8 = i0Var.g();
            this.f9250c = g8;
            ObuParser.f(g8);
            i0Var.r(3);
            i0Var.r(4);
            boolean g9 = i0Var.g();
            if (g9) {
                i0Var.r(2);
            }
            if (i0Var.g()) {
                this.f9251d = true;
            } else {
                this.f9251d = i0Var.g();
            }
            if (!this.f9251d) {
                this.f9252e = true;
            } else if (i0Var.g()) {
                this.f9252e = true;
            } else {
                this.f9252e = i0Var.g();
            }
            if (g9) {
                this.f9253f = i0Var.h(3) + 1;
            } else {
                this.f9253f = 0;
            }
        }

        public static d a(c cVar) {
            try {
                return new d(cVar);
            } catch (NotYetImplementedException unused) {
                return null;
            }
        }

        private static void b(i0 i0Var) {
            i0Var.r(64);
            if (i0Var.g()) {
                ObuParser.d(i0Var);
            }
        }
    }

    private static int c(ByteBuffer byteBuffer) {
        int i5 = 0;
        for (int i6 = 0; i6 < 8; i6++) {
            byte b5 = byteBuffer.get();
            i5 |= (b5 & Byte.MAX_VALUE) << (i6 * 7);
            if ((b5 & 128) == 0) {
                break;
            }
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(i0 i0Var) {
        int i5 = 0;
        while (!i0Var.g()) {
            i5++;
        }
        if (i5 < 32) {
            i0Var.r(i5);
        }
    }

    public static List e(ByteBuffer byteBuffer) {
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        ArrayList arrayList = new ArrayList();
        while (asReadOnlyBuffer.hasRemaining()) {
            byte b5 = asReadOnlyBuffer.get();
            int i5 = (b5 >> 3) & 15;
            if (((b5 >> 2) & 1) != 0) {
                asReadOnlyBuffer.get();
            }
            int c5 = ((b5 >> 1) & 1) != 0 ? c(asReadOnlyBuffer) : asReadOnlyBuffer.remaining();
            ByteBuffer duplicate = asReadOnlyBuffer.duplicate();
            duplicate.limit(asReadOnlyBuffer.position() + c5);
            arrayList.add(new c(i5, duplicate));
            asReadOnlyBuffer.position(asReadOnlyBuffer.position() + c5);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(boolean z5) {
        if (z5) {
            throw new NotYetImplementedException();
        }
    }
}
