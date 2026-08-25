package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.NotFoundException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
abstract class q {
    private static final Map a;
    private static final Map b;
    private static final Map c;
    private static final Map d;

    private static final class a {
        final boolean a;
        final int b;

        private a(boolean z, int i) {
            this.a = z;
            this.b = i;
        }

        static a a(int i) {
            return new a(false, i);
        }

        static a b(int i) {
            return new a(true, i);
        }
    }

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put("00", a.a(18));
        hashMap.put("01", a.a(14));
        hashMap.put("02", a.a(14));
        hashMap.put("10", a.b(20));
        hashMap.put("11", a.a(6));
        hashMap.put("12", a.a(6));
        hashMap.put("13", a.a(6));
        hashMap.put("15", a.a(6));
        hashMap.put("17", a.a(6));
        hashMap.put("20", a.a(2));
        hashMap.put("21", a.b(20));
        hashMap.put("22", a.b(29));
        hashMap.put("30", a.b(8));
        hashMap.put("37", a.b(8));
        for (int i = 90; i <= 99; i++) {
            a.put(String.valueOf(i), a.b(30));
        }
        HashMap hashMap2 = new HashMap();
        b = hashMap2;
        hashMap2.put("240", a.b(30));
        hashMap2.put("241", a.b(30));
        hashMap2.put("242", a.b(6));
        hashMap2.put("250", a.b(30));
        hashMap2.put("251", a.b(30));
        hashMap2.put("253", a.b(17));
        hashMap2.put("254", a.b(20));
        hashMap2.put("400", a.b(30));
        hashMap2.put("401", a.b(30));
        hashMap2.put("402", a.a(17));
        hashMap2.put("403", a.b(30));
        hashMap2.put("410", a.a(13));
        hashMap2.put("411", a.a(13));
        hashMap2.put("412", a.a(13));
        hashMap2.put("413", a.a(13));
        hashMap2.put("414", a.a(13));
        hashMap2.put("420", a.b(20));
        hashMap2.put("421", a.b(15));
        hashMap2.put("422", a.a(3));
        hashMap2.put("423", a.b(15));
        hashMap2.put("424", a.a(3));
        hashMap2.put("425", a.a(3));
        hashMap2.put("426", a.a(3));
        c = new HashMap();
        for (int i2 = 310; i2 <= 316; i2++) {
            c.put(String.valueOf(i2), a.a(6));
        }
        for (int i3 = 320; i3 <= 336; i3++) {
            c.put(String.valueOf(i3), a.a(6));
        }
        for (int i4 = 340; i4 <= 357; i4++) {
            c.put(String.valueOf(i4), a.a(6));
        }
        for (int i5 = 360; i5 <= 369; i5++) {
            c.put(String.valueOf(i5), a.a(6));
        }
        Map map = c;
        map.put("390", a.b(15));
        map.put("391", a.b(18));
        map.put("392", a.b(15));
        map.put("393", a.b(18));
        map.put("703", a.b(30));
        HashMap hashMap3 = new HashMap();
        d = hashMap3;
        hashMap3.put("7001", a.a(13));
        hashMap3.put("7002", a.b(30));
        hashMap3.put("7003", a.a(10));
        hashMap3.put("8001", a.a(14));
        hashMap3.put("8002", a.b(20));
        hashMap3.put("8003", a.b(30));
        hashMap3.put("8004", a.b(30));
        hashMap3.put("8005", a.a(6));
        hashMap3.put("8006", a.a(18));
        hashMap3.put("8007", a.b(30));
        hashMap3.put("8008", a.b(12));
        hashMap3.put("8018", a.a(18));
        hashMap3.put("8020", a.b(25));
        hashMap3.put("8100", a.a(6));
        hashMap3.put("8101", a.a(10));
        hashMap3.put("8102", a.a(2));
        hashMap3.put("8110", a.b(70));
        hashMap3.put("8200", a.b(70));
    }

    static String a(String str) {
        if (str.isEmpty()) {
            return null;
        }
        if (str.length() < 2) {
            throw NotFoundException.getNotFoundInstance();
        }
        a aVar = (a) a.get(str.substring(0, 2));
        if (aVar != null) {
            return aVar.a ? c(2, aVar.b, str) : b(2, aVar.b, str);
        }
        if (str.length() < 3) {
            throw NotFoundException.getNotFoundInstance();
        }
        String substring = str.substring(0, 3);
        a aVar2 = (a) b.get(substring);
        if (aVar2 != null) {
            return aVar2.a ? c(3, aVar2.b, str) : b(3, aVar2.b, str);
        }
        if (str.length() < 4) {
            throw NotFoundException.getNotFoundInstance();
        }
        a aVar3 = (a) c.get(substring);
        if (aVar3 != null) {
            return aVar3.a ? c(4, aVar3.b, str) : b(4, aVar3.b, str);
        }
        a aVar4 = (a) d.get(str.substring(0, 4));
        if (aVar4 != null) {
            return aVar4.a ? c(4, aVar4.b, str) : b(4, aVar4.b, str);
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static String b(int i, int i2, String str) {
        if (str.length() < i) {
            throw NotFoundException.getNotFoundInstance();
        }
        String substring = str.substring(0, i);
        int i3 = i2 + i;
        if (str.length() < i3) {
            throw NotFoundException.getNotFoundInstance();
        }
        String substring2 = str.substring(i, i3);
        String str2 = '(' + substring + ')' + substring2;
        String a2 = a(str.substring(i3));
        if (a2 == null) {
            return str2;
        }
        return str2 + a2;
    }

    private static String c(int i, int i2, String str) {
        String substring = str.substring(0, i);
        int min = Math.min(str.length(), i2 + i);
        String substring2 = str.substring(i, min);
        String str2 = '(' + substring + ')' + substring2;
        String a2 = a(str.substring(min));
        if (a2 == null) {
            return str2;
        }
        return str2 + a2;
    }
}
