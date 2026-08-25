package o9;

import com.google.android.exoplayer2.ParserException;
import i9.m;
import java.util.ArrayDeque;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class a implements c {
    private final byte[] a = new byte[8];
    private final ArrayDeque b = new ArrayDeque();
    private final g c = new g();
    private o9.b d;
    private int e;
    private int f;
    private long g;

    private static final class b {
        private final int a;
        private final long b;

        private b(int i, long j) {
            this.a = i;
            this.b = j;
        }
    }

    private long c(m mVar) {
        mVar.resetPeekPosition();
        while (true) {
            mVar.peekFully(this.a, 0, 4);
            int c = g.c(this.a[0]);
            if (c != -1 && c <= 4) {
                int a = (int) g.a(this.a, c, false);
                if (this.d.isLevel1Element(a)) {
                    mVar.skipFully(c);
                    return a;
                }
            }
            mVar.skipFully(1);
        }
    }

    private double d(m mVar, int i) {
        return i == 4 ? Float.intBitsToFloat((int) r0) : Double.longBitsToDouble(e(mVar, i));
    }

    private long e(m mVar, int i) {
        mVar.readFully(this.a, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | (this.a[i2] & 255);
        }
        return j;
    }

    private static String f(m mVar, int i) {
        if (i == 0) {
            return "";
        }
        byte[] bArr = new byte[i];
        mVar.readFully(bArr, 0, i);
        while (i > 0 && bArr[i - 1] == 0) {
            i--;
        }
        return new String(bArr, 0, i);
    }

    @Override // o9.c
    public boolean a(m mVar) {
        com.google.android.exoplayer2.util.a.i(this.d);
        while (true) {
            b bVar = (b) this.b.peek();
            if (bVar != null && mVar.getPosition() >= bVar.b) {
                this.d.endMasterElement(((b) this.b.pop()).a);
                return true;
            }
            if (this.e == 0) {
                long d = this.c.d(mVar, true, false, 4);
                if (d == -2) {
                    d = c(mVar);
                }
                if (d == -1) {
                    return false;
                }
                this.f = (int) d;
                this.e = 1;
            }
            if (this.e == 1) {
                this.g = this.c.d(mVar, false, true, 8);
                this.e = 2;
            }
            int elementType = this.d.getElementType(this.f);
            if (elementType != 0) {
                if (elementType == 1) {
                    long position = mVar.getPosition();
                    this.b.push(new b(this.f, this.g + position));
                    this.d.startMasterElement(this.f, position, this.g);
                    this.e = 0;
                    return true;
                }
                if (elementType == 2) {
                    long j = this.g;
                    if (j <= 8) {
                        this.d.integerElement(this.f, e(mVar, (int) j));
                        this.e = 0;
                        return true;
                    }
                    throw ParserException.createForMalformedContainer("Invalid integer size: " + this.g, (Throwable) null);
                }
                if (elementType == 3) {
                    long j2 = this.g;
                    if (j2 <= 2147483647L) {
                        this.d.stringElement(this.f, f(mVar, (int) j2));
                        this.e = 0;
                        return true;
                    }
                    throw ParserException.createForMalformedContainer("String element size: " + this.g, (Throwable) null);
                }
                if (elementType == 4) {
                    this.d.a(this.f, (int) this.g, mVar);
                    this.e = 0;
                    return true;
                }
                if (elementType != 5) {
                    throw ParserException.createForMalformedContainer("Invalid element type " + elementType, (Throwable) null);
                }
                long j3 = this.g;
                if (j3 == 4 || j3 == 8) {
                    this.d.floatElement(this.f, d(mVar, (int) j3));
                    this.e = 0;
                    return true;
                }
                throw ParserException.createForMalformedContainer("Invalid float size: " + this.g, (Throwable) null);
            }
            mVar.skipFully((int) this.g);
            this.e = 0;
        }
    }

    @Override // o9.c
    public void b(o9.b bVar) {
        this.d = bVar;
    }

    @Override // o9.c
    public void reset() {
        this.e = 0;
        this.b.clear();
        this.c.e();
    }
}
