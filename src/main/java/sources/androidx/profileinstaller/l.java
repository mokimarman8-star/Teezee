package androidx.profileinstaller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
abstract class l {

    /* renamed from: a, reason: collision with root package name */
    static final byte[] f12664a = {112, 114, 111, 0};

    /* renamed from: b, reason: collision with root package name */
    static final byte[] f12665b = {112, 114, 109, 0};

    private static void A(byte[] bArr, int i5, int i6, e eVar) {
        int m5 = m(i5, i6, eVar.f12652g);
        int i7 = m5 / 8;
        bArr[i7] = (byte) ((1 << (m5 % 8)) | bArr[i7]);
    }

    private static void B(InputStream inputStream) {
        f.h(inputStream);
        int j5 = f.j(inputStream);
        if (j5 == 6 || j5 == 7) {
            return;
        }
        while (j5 > 0) {
            f.j(inputStream);
            for (int j6 = f.j(inputStream); j6 > 0; j6--) {
                f.h(inputStream);
            }
            j5--;
        }
    }

    static boolean C(OutputStream outputStream, byte[] bArr, e[] eVarArr) {
        if (Arrays.equals(bArr, n.f12677a)) {
            P(outputStream, eVarArr);
            return true;
        }
        if (Arrays.equals(bArr, n.f12678b)) {
            O(outputStream, eVarArr);
            return true;
        }
        if (Arrays.equals(bArr, n.f12680d)) {
            M(outputStream, eVarArr);
            return true;
        }
        if (Arrays.equals(bArr, n.f12679c)) {
            N(outputStream, eVarArr);
            return true;
        }
        if (!Arrays.equals(bArr, n.f12681e)) {
            return false;
        }
        L(outputStream, eVarArr);
        return true;
    }

    private static void D(OutputStream outputStream, e eVar) {
        int[] iArr = eVar.f12653h;
        int length = iArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            int i7 = iArr[i5];
            f.p(outputStream, i7 - i6);
            i5++;
            i6 = i7;
        }
    }

    private static o E(e[] eVarArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            f.p(byteArrayOutputStream, eVarArr.length);
            int i5 = 2;
            for (e eVar : eVarArr) {
                f.q(byteArrayOutputStream, eVar.f12648c);
                f.q(byteArrayOutputStream, eVar.f12649d);
                f.q(byteArrayOutputStream, eVar.f12652g);
                String j5 = j(eVar.f12646a, eVar.f12647b, n.f12677a);
                int k5 = f.k(j5);
                f.p(byteArrayOutputStream, k5);
                i5 = i5 + 14 + k5;
                f.n(byteArrayOutputStream, j5);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (i5 == byteArray.length) {
                o oVar = new o(FileSectionType.DEX_FILES, i5, byteArray, false);
                byteArrayOutputStream.close();
                return oVar;
            }
            throw f.c("Expected size " + i5 + ", does not match actual size " + byteArray.length);
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    static void F(OutputStream outputStream, byte[] bArr) {
        outputStream.write(f12664a);
        outputStream.write(bArr);
    }

    private static void G(OutputStream outputStream, e eVar) {
        K(outputStream, eVar);
        D(outputStream, eVar);
        I(outputStream, eVar);
    }

    private static void H(OutputStream outputStream, e eVar, String str) {
        f.p(outputStream, f.k(str));
        f.p(outputStream, eVar.f12650e);
        f.q(outputStream, eVar.f12651f);
        f.q(outputStream, eVar.f12648c);
        f.q(outputStream, eVar.f12652g);
        f.n(outputStream, str);
    }

    private static void I(OutputStream outputStream, e eVar) {
        byte[] bArr = new byte[k(eVar.f12652g)];
        for (Map.Entry entry : eVar.f12654i.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            if ((intValue2 & 2) != 0) {
                A(bArr, 2, intValue, eVar);
            }
            if ((intValue2 & 4) != 0) {
                A(bArr, 4, intValue, eVar);
            }
        }
        outputStream.write(bArr);
    }

    private static void J(OutputStream outputStream, int i5, e eVar) {
        byte[] bArr = new byte[l(i5, eVar.f12652g)];
        for (Map.Entry entry : eVar.f12654i.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            int i6 = 0;
            for (int i7 = 1; i7 <= 4; i7 <<= 1) {
                if (i7 != 1 && (i7 & i5) != 0) {
                    if ((i7 & intValue2) == i7) {
                        int i8 = (eVar.f12652g * i6) + intValue;
                        int i9 = i8 / 8;
                        bArr[i9] = (byte) ((1 << (i8 % 8)) | bArr[i9]);
                    }
                    i6++;
                }
            }
        }
        outputStream.write(bArr);
    }

    private static void K(OutputStream outputStream, e eVar) {
        int i5 = 0;
        for (Map.Entry entry : eVar.f12654i.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            if ((((Integer) entry.getValue()).intValue() & 1) != 0) {
                f.p(outputStream, intValue - i5);
                f.p(outputStream, 0);
                i5 = intValue;
            }
        }
    }

    private static void L(OutputStream outputStream, e[] eVarArr) {
        f.p(outputStream, eVarArr.length);
        for (e eVar : eVarArr) {
            String j5 = j(eVar.f12646a, eVar.f12647b, n.f12681e);
            f.p(outputStream, f.k(j5));
            f.p(outputStream, eVar.f12654i.size());
            f.p(outputStream, eVar.f12653h.length);
            f.q(outputStream, eVar.f12648c);
            f.n(outputStream, j5);
            Iterator it = eVar.f12654i.keySet().iterator();
            while (it.hasNext()) {
                f.p(outputStream, ((Integer) it.next()).intValue());
            }
            for (int i5 : eVar.f12653h) {
                f.p(outputStream, i5);
            }
        }
    }

    private static void M(OutputStream outputStream, e[] eVarArr) {
        f.r(outputStream, eVarArr.length);
        for (e eVar : eVarArr) {
            int size = eVar.f12654i.size() * 4;
            String j5 = j(eVar.f12646a, eVar.f12647b, n.f12680d);
            f.p(outputStream, f.k(j5));
            f.p(outputStream, eVar.f12653h.length);
            f.q(outputStream, size);
            f.q(outputStream, eVar.f12648c);
            f.n(outputStream, j5);
            Iterator it = eVar.f12654i.keySet().iterator();
            while (it.hasNext()) {
                f.p(outputStream, ((Integer) it.next()).intValue());
                f.p(outputStream, 0);
            }
            for (int i5 : eVar.f12653h) {
                f.p(outputStream, i5);
            }
        }
    }

    private static void N(OutputStream outputStream, e[] eVarArr) {
        byte[] b5 = b(eVarArr, n.f12679c);
        f.r(outputStream, eVarArr.length);
        f.m(outputStream, b5);
    }

    private static void O(OutputStream outputStream, e[] eVarArr) {
        byte[] b5 = b(eVarArr, n.f12678b);
        f.r(outputStream, eVarArr.length);
        f.m(outputStream, b5);
    }

    private static void P(OutputStream outputStream, e[] eVarArr) {
        Q(outputStream, eVarArr);
    }

    private static void Q(OutputStream outputStream, e[] eVarArr) {
        int length;
        ArrayList arrayList = new ArrayList(3);
        ArrayList arrayList2 = new ArrayList(3);
        arrayList.add(E(eVarArr));
        arrayList.add(c(eVarArr));
        arrayList.add(d(eVarArr));
        long length2 = n.f12677a.length + f12664a.length + 4 + (arrayList.size() * 16);
        f.q(outputStream, arrayList.size());
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            o oVar = (o) arrayList.get(i5);
            f.q(outputStream, oVar.f12684a.getValue());
            f.q(outputStream, length2);
            if (oVar.f12687d) {
                byte[] bArr = oVar.f12686c;
                long length3 = bArr.length;
                byte[] b5 = f.b(bArr);
                arrayList2.add(b5);
                f.q(outputStream, b5.length);
                f.q(outputStream, length3);
                length = b5.length;
            } else {
                arrayList2.add(oVar.f12686c);
                f.q(outputStream, oVar.f12686c.length);
                f.q(outputStream, 0L);
                length = oVar.f12686c.length;
            }
            length2 += length;
        }
        for (int i6 = 0; i6 < arrayList2.size(); i6++) {
            outputStream.write((byte[]) arrayList2.get(i6));
        }
    }

    private static int a(e eVar) {
        Iterator it = eVar.f12654i.entrySet().iterator();
        int i5 = 0;
        while (it.hasNext()) {
            i5 |= ((Integer) ((Map.Entry) it.next()).getValue()).intValue();
        }
        return i5;
    }

    private static byte[] b(e[] eVarArr, byte[] bArr) {
        int i5 = 0;
        int i6 = 0;
        for (e eVar : eVarArr) {
            i6 += f.k(j(eVar.f12646a, eVar.f12647b, bArr)) + 16 + (eVar.f12650e * 2) + eVar.f12651f + k(eVar.f12652g);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i6);
        if (Arrays.equals(bArr, n.f12679c)) {
            int length = eVarArr.length;
            while (i5 < length) {
                e eVar2 = eVarArr[i5];
                H(byteArrayOutputStream, eVar2, j(eVar2.f12646a, eVar2.f12647b, bArr));
                G(byteArrayOutputStream, eVar2);
                i5++;
            }
        } else {
            for (e eVar3 : eVarArr) {
                H(byteArrayOutputStream, eVar3, j(eVar3.f12646a, eVar3.f12647b, bArr));
            }
            int length2 = eVarArr.length;
            while (i5 < length2) {
                G(byteArrayOutputStream, eVarArr[i5]);
                i5++;
            }
        }
        if (byteArrayOutputStream.size() == i6) {
            return byteArrayOutputStream.toByteArray();
        }
        throw f.c("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + i6);
    }

    private static o c(e[] eVarArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i5 = 0;
        for (int i6 = 0; i6 < eVarArr.length; i6++) {
            try {
                e eVar = eVarArr[i6];
                f.p(byteArrayOutputStream, i6);
                f.p(byteArrayOutputStream, eVar.f12650e);
                i5 = i5 + 4 + (eVar.f12650e * 2);
                D(byteArrayOutputStream, eVar);
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i5 == byteArray.length) {
            o oVar = new o(FileSectionType.CLASSES, i5, byteArray, true);
            byteArrayOutputStream.close();
            return oVar;
        }
        throw f.c("Expected size " + i5 + ", does not match actual size " + byteArray.length);
    }

    private static o d(e[] eVarArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i5 = 0;
        for (int i6 = 0; i6 < eVarArr.length; i6++) {
            try {
                e eVar = eVarArr[i6];
                int a5 = a(eVar);
                byte[] e5 = e(a5, eVar);
                byte[] f5 = f(eVar);
                f.p(byteArrayOutputStream, i6);
                int length = e5.length + 2 + f5.length;
                f.q(byteArrayOutputStream, length);
                f.p(byteArrayOutputStream, a5);
                byteArrayOutputStream.write(e5);
                byteArrayOutputStream.write(f5);
                i5 = i5 + 6 + length;
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i5 == byteArray.length) {
            o oVar = new o(FileSectionType.METHODS, i5, byteArray, true);
            byteArrayOutputStream.close();
            return oVar;
        }
        throw f.c("Expected size " + i5 + ", does not match actual size " + byteArray.length);
    }

    private static byte[] e(int i5, e eVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            J(byteArrayOutputStream, i5, eVar);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static byte[] f(e eVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            K(byteArrayOutputStream, eVar);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static String g(String str, String str2) {
        return "!".equals(str2) ? str.replace(":", "!") : ":".equals(str2) ? str.replace("!", ":") : str;
    }

    private static String h(String str) {
        int indexOf = str.indexOf("!");
        if (indexOf < 0) {
            indexOf = str.indexOf(":");
        }
        return indexOf > 0 ? str.substring(indexOf + 1) : str;
    }

    private static e i(e[] eVarArr, String str) {
        if (eVarArr.length <= 0) {
            return null;
        }
        String h5 = h(str);
        for (int i5 = 0; i5 < eVarArr.length; i5++) {
            if (eVarArr[i5].f12647b.equals(h5)) {
                return eVarArr[i5];
            }
        }
        return null;
    }

    private static String j(String str, String str2, byte[] bArr) {
        String a5 = n.a(bArr);
        if (str.length() <= 0) {
            return g(str2, a5);
        }
        if (str2.equals("classes.dex")) {
            return str;
        }
        if (str2.contains("!") || str2.contains(":")) {
            return g(str2, a5);
        }
        if (str2.endsWith(".apk")) {
            return str2;
        }
        return str + n.a(bArr) + str2;
    }

    private static int k(int i5) {
        return z(i5 * 2) / 8;
    }

    private static int l(int i5, int i6) {
        return z(Integer.bitCount(i5 & (-2)) * i6) / 8;
    }

    private static int m(int i5, int i6, int i7) {
        if (i5 == 1) {
            throw f.c("HOT methods are not stored in the bitmap");
        }
        if (i5 == 2) {
            return i6;
        }
        if (i5 == 4) {
            return i6 + i7;
        }
        throw f.c("Unexpected flag: " + i5);
    }

    private static int[] n(InputStream inputStream, int i5) {
        int[] iArr = new int[i5];
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            i6 += f.h(inputStream);
            iArr[i7] = i6;
        }
        return iArr;
    }

    private static int o(BitSet bitSet, int i5, int i6) {
        int i7 = bitSet.get(m(2, i5, i6)) ? 2 : 0;
        return bitSet.get(m(4, i5, i6)) ? i7 | 4 : i7;
    }

    static byte[] p(InputStream inputStream, byte[] bArr) {
        if (Arrays.equals(bArr, f.d(inputStream, bArr.length))) {
            return f.d(inputStream, n.f12678b.length);
        }
        throw f.c("Invalid magic");
    }

    private static void q(InputStream inputStream, e eVar) {
        int available = inputStream.available() - eVar.f12651f;
        int i5 = 0;
        while (inputStream.available() > available) {
            i5 += f.h(inputStream);
            eVar.f12654i.put(Integer.valueOf(i5), 1);
            for (int h5 = f.h(inputStream); h5 > 0; h5--) {
                B(inputStream);
            }
        }
        if (inputStream.available() != available) {
            throw f.c("Read too much data during profile line parse");
        }
    }

    static e[] r(InputStream inputStream, byte[] bArr, byte[] bArr2, e[] eVarArr) {
        if (Arrays.equals(bArr, n.f12682f)) {
            if (Arrays.equals(n.f12677a, bArr2)) {
                throw f.c("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
            }
            return s(inputStream, bArr, eVarArr);
        }
        if (Arrays.equals(bArr, n.f12683g)) {
            return u(inputStream, bArr2, eVarArr);
        }
        throw f.c("Unsupported meta version");
    }

    static e[] s(InputStream inputStream, byte[] bArr, e[] eVarArr) {
        if (!Arrays.equals(bArr, n.f12682f)) {
            throw f.c("Unsupported meta version");
        }
        int j5 = f.j(inputStream);
        byte[] e5 = f.e(inputStream, (int) f.i(inputStream), (int) f.i(inputStream));
        if (inputStream.read() > 0) {
            throw f.c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(e5);
        try {
            e[] t5 = t(byteArrayInputStream, j5, eVarArr);
            byteArrayInputStream.close();
            return t5;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static e[] t(InputStream inputStream, int i5, e[] eVarArr) {
        if (inputStream.available() == 0) {
            return new e[0];
        }
        if (i5 != eVarArr.length) {
            throw f.c("Mismatched number of dex files found in metadata");
        }
        String[] strArr = new String[i5];
        int[] iArr = new int[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            int h5 = f.h(inputStream);
            iArr[i6] = f.h(inputStream);
            strArr[i6] = f.f(inputStream, h5);
        }
        for (int i7 = 0; i7 < i5; i7++) {
            e eVar = eVarArr[i7];
            if (!eVar.f12647b.equals(strArr[i7])) {
                throw f.c("Order of dexfiles in metadata did not match baseline");
            }
            int i8 = iArr[i7];
            eVar.f12650e = i8;
            eVar.f12653h = n(inputStream, i8);
        }
        return eVarArr;
    }

    static e[] u(InputStream inputStream, byte[] bArr, e[] eVarArr) {
        int h5 = f.h(inputStream);
        byte[] e5 = f.e(inputStream, (int) f.i(inputStream), (int) f.i(inputStream));
        if (inputStream.read() > 0) {
            throw f.c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(e5);
        try {
            e[] v5 = v(byteArrayInputStream, bArr, h5, eVarArr);
            byteArrayInputStream.close();
            return v5;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static e[] v(InputStream inputStream, byte[] bArr, int i5, e[] eVarArr) {
        if (inputStream.available() == 0) {
            return new e[0];
        }
        if (i5 != eVarArr.length) {
            throw f.c("Mismatched number of dex files found in metadata");
        }
        for (int i6 = 0; i6 < i5; i6++) {
            f.h(inputStream);
            String f5 = f.f(inputStream, f.h(inputStream));
            long i7 = f.i(inputStream);
            int h5 = f.h(inputStream);
            e i8 = i(eVarArr, f5);
            if (i8 == null) {
                throw f.c("Missing profile key: " + f5);
            }
            i8.f12649d = i7;
            int[] n5 = n(inputStream, h5);
            if (Arrays.equals(bArr, n.f12681e)) {
                i8.f12650e = h5;
                i8.f12653h = n5;
            }
        }
        return eVarArr;
    }

    private static void w(InputStream inputStream, e eVar) {
        BitSet valueOf = BitSet.valueOf(f.d(inputStream, f.a(eVar.f12652g * 2)));
        int i5 = 0;
        while (true) {
            int i6 = eVar.f12652g;
            if (i5 >= i6) {
                return;
            }
            int o5 = o(valueOf, i5, i6);
            if (o5 != 0) {
                Integer num = (Integer) eVar.f12654i.get(Integer.valueOf(i5));
                if (num == null) {
                    num = 0;
                }
                eVar.f12654i.put(Integer.valueOf(i5), Integer.valueOf(o5 | num.intValue()));
            }
            i5++;
        }
    }

    static e[] x(InputStream inputStream, byte[] bArr, String str) {
        if (!Arrays.equals(bArr, n.f12678b)) {
            throw f.c("Unsupported version");
        }
        int j5 = f.j(inputStream);
        byte[] e5 = f.e(inputStream, (int) f.i(inputStream), (int) f.i(inputStream));
        if (inputStream.read() > 0) {
            throw f.c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(e5);
        try {
            e[] y5 = y(byteArrayInputStream, str, j5);
            byteArrayInputStream.close();
            return y5;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static e[] y(InputStream inputStream, String str, int i5) {
        if (inputStream.available() == 0) {
            return new e[0];
        }
        e[] eVarArr = new e[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            int h5 = f.h(inputStream);
            int h6 = f.h(inputStream);
            eVarArr[i6] = new e(str, f.f(inputStream, h5), f.i(inputStream), 0L, h6, (int) f.i(inputStream), (int) f.i(inputStream), new int[h6], new TreeMap());
        }
        for (int i7 = 0; i7 < i5; i7++) {
            e eVar = eVarArr[i7];
            q(inputStream, eVar);
            eVar.f12653h = n(inputStream, eVar.f12650e);
            w(inputStream, eVar);
        }
        return eVarArr;
    }

    private static int z(int i5) {
        return (i5 + 7) & (-8);
    }
}
