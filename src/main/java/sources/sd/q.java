package sd;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class q implements com.google.zxing.m {
    private static final Pattern a = Pattern.compile("[0-9]+");

    protected static int b(boolean[] zArr, int i, int[] iArr, boolean z) {
        int i2 = 0;
        for (int i3 : iArr) {
            int i4 = 0;
            while (i4 < i3) {
                zArr[i] = z;
                i4++;
                i++;
            }
            i2 += i3;
            z = !z;
        }
        return i2;
    }

    protected static void c(String str) {
        if (!a.matcher(str).matches()) {
            throw new IllegalArgumentException("Input should only contain digits 0-9");
        }
    }

    private static kd.b h(boolean[] zArr, int i, int i2, int i3) {
        int length = zArr.length;
        int i4 = i3 + length;
        int max = Math.max(i, i4);
        int max2 = Math.max(1, i2);
        int i5 = max / i4;
        int i6 = (max - (length * i5)) / 2;
        kd.b bVar = new kd.b(max, max2);
        int i7 = 0;
        while (i7 < length) {
            if (zArr[i7]) {
                bVar.s(i6, 0, i5, max2);
            }
            i7++;
            i6 += i5;
        }
        return bVar;
    }

    @Override // com.google.zxing.m
    public kd.b a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map map) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Negative size is not allowed. Input: " + i + 'x' + i2);
        }
        Collection g = g();
        if (g == null || g.contains(barcodeFormat)) {
            int f = f();
            if (map != null) {
                EncodeHintType encodeHintType = EncodeHintType.MARGIN;
                if (map.containsKey(encodeHintType)) {
                    f = Integer.parseInt(map.get(encodeHintType).toString());
                }
            }
            return h(e(str, map), i, i2, f);
        }
        throw new IllegalArgumentException("Can only encode " + g + ", but got " + barcodeFormat);
    }

    public abstract boolean[] d(String str);

    public boolean[] e(String str, Map map) {
        return d(str);
    }

    public int f() {
        return 10;
    }

    protected Collection g() {
        return null;
    }
}
