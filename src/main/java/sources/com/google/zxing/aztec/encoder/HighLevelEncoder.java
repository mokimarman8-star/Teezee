package com.google.zxing.aztec.encoder;

import com.google.zxing.common.CharacterSetECI;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class HighLevelEncoder {
    static final String[] c = {"UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT"};
    static final int[][] d = {new int[]{0, 327708, 327710, 327709, 656318}, new int[]{590318, 0, 327710, 327709, 656318}, new int[]{262158, 590300, 0, 590301, 932798}, new int[]{327709, 327708, 656318, 0, 327710}, new int[]{327711, 656380, 656382, 656381, 0}};
    private static final int[][] e;
    static final int[][] f;
    private final byte[] a;
    private final Charset b;

    static {
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 5, 256);
        e = iArr;
        iArr[0][32] = 1;
        for (int i = 65; i <= 90; i++) {
            e[0][i] = i - 63;
        }
        e[1][32] = 1;
        for (int i2 = 97; i2 <= 122; i2++) {
            e[1][i2] = i2 - 95;
        }
        e[2][32] = 1;
        for (int i3 = 48; i3 <= 57; i3++) {
            e[2][i3] = i3 - 46;
        }
        int[] iArr2 = e[2];
        iArr2[44] = 12;
        iArr2[46] = 13;
        int[] iArr3 = {0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, 124, 126, 127};
        int i4 = 0;
        for (int i5 = 28; i4 < i5; i5 = 28) {
            e[3][iArr3[i4]] = i4;
            i4++;
        }
        int[] iArr4 = {0, 13, 0, 0, 0, 0, 33, 39, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 93, 123, 125};
        for (int i6 = 0; i6 < 31; i6++) {
            int i7 = iArr4[i6];
            if (i7 > 0) {
                e[4][i7] = i6;
            }
        }
        int[][] iArr5 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 6, 6);
        f = iArr5;
        for (int[] iArr6 : iArr5) {
            Arrays.fill(iArr6, -1);
        }
        int[][] iArr7 = f;
        iArr7[0][4] = 0;
        int[] iArr8 = iArr7[1];
        iArr8[4] = 0;
        iArr8[0] = 28;
        iArr7[3][4] = 0;
        int[] iArr9 = iArr7[2];
        iArr9[4] = 0;
        iArr9[0] = 15;
    }

    public HighLevelEncoder(byte[] bArr, Charset charset) {
        this.a = bArr;
        this.b = charset;
    }

    private static Collection b(Iterable iterable) {
        LinkedList linkedList = new LinkedList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            Iterator it2 = linkedList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    linkedList.addFirst(eVar);
                    break;
                }
                e eVar2 = (e) it2.next();
                if (eVar2.h(eVar)) {
                    break;
                }
                if (eVar.h(eVar2)) {
                    it2.remove();
                }
            }
        }
        return linkedList;
    }

    private void c(e eVar, int i, Collection collection) {
        char c2 = (char) (this.a[i] & 255);
        boolean z = e[eVar.g()][c2] > 0;
        e eVar2 = null;
        for (int i2 = 0; i2 <= 4; i2++) {
            int i3 = e[i2][c2];
            if (i3 > 0) {
                if (eVar2 == null) {
                    eVar2 = eVar.d(i);
                }
                if (!z || i2 == eVar.g() || i2 == 2) {
                    collection.add(eVar2.i(i2, i3));
                }
                if (!z && f[eVar.g()][i2] >= 0) {
                    collection.add(eVar2.j(i2, i3));
                }
            }
        }
        if (eVar.e() > 0 || e[eVar.g()][c2] == 0) {
            collection.add(eVar.a(i));
        }
    }

    private static void d(e eVar, int i, int i2, Collection collection) {
        e d2 = eVar.d(i);
        collection.add(d2.i(4, i2));
        if (eVar.g() != 4) {
            collection.add(d2.j(4, i2));
        }
        if (i2 == 3 || i2 == 4) {
            collection.add(d2.i(2, 16 - i2).i(2, 1));
        }
        if (eVar.e() > 0) {
            collection.add(eVar.a(i).a(i + 1));
        }
    }

    private Collection e(Iterable iterable, int i) {
        LinkedList linkedList = new LinkedList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            c((e) it.next(), i, linkedList);
        }
        return b(linkedList);
    }

    private static Collection f(Iterable iterable, int i, int i2) {
        LinkedList linkedList = new LinkedList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            d((e) it.next(), i, i2, linkedList);
        }
        return b(linkedList);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public kd.a a() {
        int i;
        e eVar = e.f;
        Charset charset = this.b;
        if (charset != null) {
            CharacterSetECI characterSetECI = CharacterSetECI.getCharacterSetECI(charset);
            if (characterSetECI == null) {
                throw new IllegalArgumentException("No ECI code for character set " + this.b);
            }
            eVar = eVar.b(characterSetECI.getValue());
        }
        Collection singletonList = Collections.singletonList(eVar);
        int i2 = 0;
        while (true) {
            byte[] bArr = this.a;
            if (i2 >= bArr.length) {
                return ((e) Collections.min(singletonList, new Comparator<e>() { // from class: com.google.zxing.aztec.encoder.HighLevelEncoder.1
                    @Override // java.util.Comparator
                    public int compare(e eVar2, e eVar3) {
                        return eVar2.f() - eVar3.f();
                    }
                })).k(this.a);
            }
            int i3 = i2 + 1;
            byte b = i3 < bArr.length ? bArr[i3] : (byte) 0;
            byte b2 = bArr[i2];
            if (b2 == 13) {
                if (b == 10) {
                    i = 2;
                    if (i <= 0) {
                    }
                    i2++;
                }
                i = 0;
                if (i <= 0) {
                }
                i2++;
            } else if (b2 == 44) {
                if (b == 32) {
                    i = 4;
                    if (i <= 0) {
                    }
                    i2++;
                }
                i = 0;
                if (i <= 0) {
                }
                i2++;
            } else if (b2 != 46) {
                if (b2 == 58 && b == 32) {
                    i = 5;
                    if (i <= 0) {
                        singletonList = f(singletonList, i2, i);
                        i2 = i3;
                    } else {
                        singletonList = e(singletonList, i2);
                    }
                    i2++;
                }
                i = 0;
                if (i <= 0) {
                }
                i2++;
            } else {
                if (b == 32) {
                    i = 3;
                    if (i <= 0) {
                    }
                    i2++;
                }
                i = 0;
                if (i <= 0) {
                }
                i2++;
            }
        }
    }
}
