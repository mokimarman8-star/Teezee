package id;

import android.content.Intent;
import com.google.zxing.BarcodeFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class f {
    private static final Pattern a = Pattern.compile(",");
    static final Set b;
    static final Set c;
    private static final Set d;
    static final Set e;
    static final Set f;
    static final Set g;
    static final Set h;
    private static final Map i;

    static {
        EnumSet of2 = EnumSet.of(BarcodeFormat.QR_CODE);
        e = of2;
        EnumSet of3 = EnumSet.of(BarcodeFormat.DATA_MATRIX);
        f = of3;
        EnumSet of4 = EnumSet.of(BarcodeFormat.AZTEC);
        g = of4;
        EnumSet of5 = EnumSet.of(BarcodeFormat.PDF_417);
        h = of5;
        EnumSet of6 = EnumSet.of(BarcodeFormat.UPC_A, BarcodeFormat.UPC_E, BarcodeFormat.EAN_13, BarcodeFormat.EAN_8, BarcodeFormat.RSS_14, BarcodeFormat.RSS_EXPANDED);
        b = of6;
        EnumSet of7 = EnumSet.of(BarcodeFormat.CODE_39, BarcodeFormat.CODE_93, BarcodeFormat.CODE_128, BarcodeFormat.ITF, BarcodeFormat.CODABAR);
        c = of7;
        EnumSet copyOf = EnumSet.copyOf((Collection) of6);
        d = copyOf;
        copyOf.addAll(of7);
        HashMap hashMap = new HashMap();
        i = hashMap;
        hashMap.put("ONE_D_MODE", copyOf);
        hashMap.put("PRODUCT_MODE", of6);
        hashMap.put("QR_CODE_MODE", of2);
        hashMap.put("DATA_MATRIX_MODE", of3);
        hashMap.put("AZTEC_MODE", of4);
        hashMap.put("PDF417_MODE", of5);
    }

    public static Set a(Intent intent) {
        String stringExtra = intent.getStringExtra("SCAN_FORMATS");
        return b(stringExtra != null ? Arrays.asList(a.split(stringExtra)) : null, intent.getStringExtra("SCAN_MODE"));
    }

    private static Set b(Iterable iterable, String str) {
        if (iterable != null) {
            EnumSet noneOf = EnumSet.noneOf(BarcodeFormat.class);
            try {
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    noneOf.add(BarcodeFormat.valueOf((String) it.next()));
                }
                return noneOf;
            } catch (IllegalArgumentException unused) {
            }
        }
        if (str != null) {
            return (Set) i.get(str);
        }
        return null;
    }
}
