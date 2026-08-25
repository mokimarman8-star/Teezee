package org.brotli.dec;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class a {
    private InputStream d;
    private boolean e;
    long f;
    int g;
    private int h;
    private final byte[] a = new byte[4160];
    private final int[] b = new int[1040];
    private final h c = new h();
    private int i = 0;

    a() {
    }

    static void a(a aVar, boolean z) {
        if (aVar.e) {
            int i = ((aVar.h << 2) + ((aVar.g + 7) >> 3)) - 8;
            int i2 = aVar.i;
            if (i > i2) {
                throw new BrotliRuntimeException("Read after end");
            }
            if (z && i != i2) {
                throw new BrotliRuntimeException("Unused bytes after end");
            }
        }
    }

    static void b(a aVar) {
        InputStream inputStream = aVar.d;
        aVar.d = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    static void c(a aVar, byte[] bArr, int i, int i2) {
        if ((aVar.g & 7) != 0) {
            throw new BrotliRuntimeException("Unaligned copyBytes");
        }
        while (true) {
            int i3 = aVar.g;
            if (i3 == 64 || i2 == 0) {
                break;
            }
            bArr[i] = (byte) (aVar.f >>> i3);
            aVar.g = i3 + 8;
            i2--;
            i++;
        }
        if (i2 == 0) {
            return;
        }
        int min = Math.min(f(aVar), i2 >> 2);
        if (min > 0) {
            int i4 = min << 2;
            System.arraycopy(aVar.a, aVar.h << 2, bArr, i, i4);
            i += i4;
            i2 -= i4;
            aVar.h += min;
        }
        if (i2 == 0) {
            return;
        }
        if (f(aVar) <= 0) {
            while (i2 > 0) {
                try {
                    int read = aVar.d.read(bArr, i, i2);
                    if (read == -1) {
                        throw new BrotliRuntimeException("Unexpected end of input");
                    }
                    i += read;
                    i2 -= read;
                } catch (IOException e) {
                    throw new BrotliRuntimeException("Failed to read input", e);
                }
            }
            return;
        }
        d(aVar);
        while (i2 != 0) {
            long j = aVar.f;
            int i5 = aVar.g;
            bArr[i] = (byte) (j >>> i5);
            aVar.g = i5 + 8;
            i2--;
            i++;
        }
        a(aVar, false);
    }

    static void d(a aVar) {
        int i = aVar.g;
        if (i >= 32) {
            int[] iArr = aVar.b;
            aVar.h = aVar.h + 1;
            aVar.f = (iArr[r3] << 32) | (aVar.f >>> 32);
            aVar.g = i - 32;
        }
    }

    static void e(a aVar, InputStream inputStream) {
        if (aVar.d != null) {
            throw new IllegalStateException("Bit reader already has associated input stream");
        }
        h.b(aVar.c, aVar.a, aVar.b);
        aVar.d = inputStream;
        aVar.f = 0L;
        aVar.g = 64;
        aVar.h = 1024;
        aVar.e = false;
        h(aVar);
    }

    static int f(a aVar) {
        return (aVar.e ? (aVar.i + 3) >> 2 : 1024) - aVar.h;
    }

    static void g(a aVar) {
        int i = (64 - aVar.g) & 7;
        if (i != 0 && i(aVar, i) != 0) {
            throw new BrotliRuntimeException("Corrupted padding bits");
        }
    }

    private static void h(a aVar) {
        j(aVar);
        a(aVar, false);
        d(aVar);
        d(aVar);
    }

    static int i(a aVar, int i) {
        d(aVar);
        long j = aVar.f;
        int i2 = aVar.g;
        int i3 = ((int) (j >>> i2)) & ((1 << i) - 1);
        aVar.g = i2 + i;
        return i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0037, code lost:
    
        r4.e = true;
        r4.i = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
    
        r1 = r1 + 3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static void j(a aVar) {
        int i = aVar.h;
        if (i <= 1015) {
            return;
        }
        if (aVar.e) {
            if (f(aVar) < -2) {
                throw new BrotliRuntimeException("No more input");
            }
            return;
        }
        int i2 = i << 2;
        int i3 = 4096 - i2;
        byte[] bArr = aVar.a;
        System.arraycopy(bArr, i2, bArr, 0, i3);
        aVar.h = 0;
        while (true) {
            if (i3 >= 4096) {
                break;
            }
            try {
                int read = aVar.d.read(aVar.a, i3, 4096 - i3);
                if (read <= 0) {
                    break;
                } else {
                    i3 += read;
                }
            } catch (IOException e) {
                throw new BrotliRuntimeException("Failed to read input", e);
            }
        }
        h.a(aVar.c, i3 >> 2);
    }

    static void k(a aVar) {
        if (aVar.g == 64) {
            h(aVar);
        }
    }
}
