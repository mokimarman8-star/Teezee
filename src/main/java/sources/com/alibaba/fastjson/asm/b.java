package com.alibaba.fastjson.asm;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f14653a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f14654b;

    /* renamed from: c, reason: collision with root package name */
    private final String[] f14655c;

    /* renamed from: d, reason: collision with root package name */
    private final int f14656d;

    /* renamed from: e, reason: collision with root package name */
    public final int f14657e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f14658f;

    public b(InputStream inputStream, boolean z5) {
        int i5;
        this.f14658f = z5;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            i5 = 0;
            if (read == -1) {
                break;
            } else if (read > 0) {
                byteArrayOutputStream.write(bArr, 0, read);
            }
        }
        inputStream.close();
        this.f14653a = byteArrayOutputStream.toByteArray();
        int[] iArr = new int[g(8)];
        this.f14654b = iArr;
        int length = iArr.length;
        this.f14655c = new String[length];
        int i6 = 10;
        int i7 = 1;
        while (i7 < length) {
            int i8 = i6 + 1;
            this.f14654b[i7] = i8;
            byte b5 = this.f14653a[i6];
            int i9 = 3;
            if (b5 == 1) {
                i9 = 3 + g(i8);
                if (i9 > i5) {
                    i5 = i9;
                }
            } else if (b5 != 15) {
                if (b5 != 18 && b5 != 3 && b5 != 4) {
                    if (b5 == 5 || b5 == 6) {
                        i7++;
                        i9 = 9;
                    } else {
                        switch (b5) {
                        }
                    }
                }
                i9 = 5;
            } else {
                i9 = 4;
            }
            i6 += i9;
            i7++;
        }
        this.f14656d = i5;
        this.f14657e = i6;
    }

    private int b() {
        int i5 = this.f14657e;
        int g5 = i5 + 8 + (g(i5 + 6) * 2);
        for (int g6 = g(g5); g6 > 0; g6--) {
            for (int g7 = g(g5 + 8); g7 > 0; g7--) {
                g5 += c(g5 + 12) + 6;
            }
            g5 += 8;
        }
        int i6 = g5 + 2;
        for (int g8 = g(i6); g8 > 0; g8--) {
            for (int g9 = g(i6 + 8); g9 > 0; g9--) {
                i6 += c(i6 + 12) + 6;
            }
            i6 += 8;
        }
        return i6 + 2;
    }

    private int c(int i5) {
        byte[] bArr = this.f14653a;
        return (bArr[i5 + 3] & 255) | ((bArr[i5] & 255) << 24) | ((bArr[i5 + 1] & 255) << 16) | ((bArr[i5 + 2] & 255) << 8);
    }

    private int d(TypeCollector typeCollector, char[] cArr, int i5) {
        int g5 = g(i5);
        String f5 = f(i5 + 2, cArr);
        String f6 = f(i5 + 4, cArr);
        int i6 = i5 + 8;
        int i7 = 0;
        int i8 = 0;
        for (int g6 = g(i5 + 6); g6 > 0; g6--) {
            String f7 = f(i6, cArr);
            int c5 = c(i6 + 2);
            int i9 = i6 + 6;
            if (f7.equals("Code")) {
                i8 = i9;
            }
            i6 = i9 + c5;
        }
        g e5 = typeCollector.e(g5, f5, f6);
        if (e5 != null && i8 != 0) {
            int c6 = i8 + 8 + c(i8 + 4);
            int i10 = c6 + 2;
            for (int g7 = g(c6); g7 > 0; g7--) {
                i10 += 8;
            }
            int i11 = i10 + 2;
            int i12 = 0;
            for (int g8 = g(i10); g8 > 0; g8--) {
                String f8 = f(i11, cArr);
                if (f8.equals("LocalVariableTable")) {
                    i7 = i11 + 6;
                } else if (f8.equals("LocalVariableTypeTable")) {
                    i12 = i11 + 6;
                }
                i11 += c(i11 + 2) + 6;
            }
            if (i7 != 0) {
                if (i12 != 0) {
                    int g9 = g(i12) * 3;
                    int i13 = i12 + 2;
                    int[] iArr = new int[g9];
                    while (g9 > 0) {
                        iArr[g9 - 1] = i13 + 6;
                        iArr[g9 - 2] = g(i13 + 8);
                        g9 -= 3;
                        iArr[g9] = g(i13);
                        i13 += 10;
                    }
                }
                int i14 = i7 + 2;
                for (int g10 = g(i7); g10 > 0; g10--) {
                    e5.b(f(i14 + 4, cArr), g(i14 + 8));
                    i14 += 10;
                }
            }
        }
        return i6;
    }

    private String e(int i5, int i6, char[] cArr) {
        int i7;
        int i8 = i6 + i5;
        byte[] bArr = this.f14653a;
        int i9 = 0;
        char c5 = 0;
        char c6 = 0;
        while (i5 < i8) {
            int i10 = i5 + 1;
            byte b5 = bArr[i5];
            if (c5 != 0) {
                if (c5 == 1) {
                    cArr[i9] = (char) ((b5 & 63) | (c6 << 6));
                    i9++;
                    c5 = 0;
                } else if (c5 == 2) {
                    i7 = (b5 & 63) | (c6 << 6);
                    c6 = (char) i7;
                    c5 = 1;
                }
                i5 = i10;
            } else {
                int i11 = b5 & 255;
                if (i11 < 128) {
                    cArr[i9] = (char) i11;
                    i9++;
                } else if (i11 >= 224 || i11 <= 191) {
                    c6 = (char) (b5 & 15);
                    c5 = 2;
                } else {
                    i7 = b5 & 31;
                    c6 = (char) i7;
                    c5 = 1;
                }
                i5 = i10;
            }
        }
        return new String(cArr, 0, i9);
    }

    private String f(int i5, char[] cArr) {
        int g5 = g(i5);
        String[] strArr = this.f14655c;
        String str = strArr[g5];
        if (str != null) {
            return str;
        }
        int i6 = this.f14654b[g5];
        String e5 = e(i6 + 2, g(i6), cArr);
        strArr[g5] = e5;
        return e5;
    }

    private int g(int i5) {
        byte[] bArr = this.f14653a;
        return (bArr[i5 + 1] & 255) | ((bArr[i5] & 255) << 8);
    }

    public void a(TypeCollector typeCollector) {
        int i5;
        char[] cArr = new char[this.f14656d];
        if (this.f14658f) {
            int b5 = b();
            for (int g5 = g(b5); g5 > 0; g5--) {
                if ("RuntimeVisibleAnnotations".equals(f(b5 + 2, cArr))) {
                    i5 = b5 + 8;
                    break;
                }
                b5 += c(b5 + 4) + 6;
            }
        }
        i5 = 0;
        int i6 = this.f14657e;
        int g6 = g(i6 + 6);
        int i7 = i6 + 8;
        for (int i8 = 0; i8 < g6; i8++) {
            i7 += 2;
        }
        int i9 = i7 + 2;
        int i10 = i9;
        for (int g7 = g(i7); g7 > 0; g7--) {
            i10 += 8;
            for (int g8 = g(i10 + 6); g8 > 0; g8--) {
                i10 += c(i10 + 2) + 6;
            }
        }
        int i11 = i10 + 2;
        for (int g9 = g(i10); g9 > 0; g9--) {
            i11 += 8;
            for (int g10 = g(i11 + 6); g10 > 0; g10--) {
                i11 += c(i11 + 2) + 6;
            }
        }
        int i12 = i11 + 2;
        for (int g11 = g(i11); g11 > 0; g11--) {
            i12 += c(i12 + 2) + 6;
        }
        if (i5 != 0) {
            int i13 = i5 + 2;
            for (int g12 = g(i5); g12 > 0; g12--) {
                typeCollector.d(f(i13, cArr));
            }
        }
        for (int g13 = g(i7); g13 > 0; g13--) {
            i9 += 8;
            for (int g14 = g(i9 + 6); g14 > 0; g14--) {
                i9 += c(i9 + 2) + 6;
            }
        }
        int i14 = i9 + 2;
        for (int g15 = g(i9); g15 > 0; g15--) {
            i14 = d(typeCollector, cArr, i14);
        }
    }
}
