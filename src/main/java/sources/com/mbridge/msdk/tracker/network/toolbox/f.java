package com.mbridge.msdk.tracker.network.toolbox;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.Command;
import com.mbridge.msdk.tracker.network.b;
import com.mbridge.msdk.tracker.network.c0;
import com.mbridge.msdk.tracker.network.q;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeSet;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class f {
    public static b.a a(q qVar) {
        boolean z;
        long j;
        long j2;
        long j3;
        long j4;
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = qVar.c;
        if (map == null) {
            return null;
        }
        String str = map.get("Date");
        long b = str != null ? b(str) : 0L;
        String str2 = map.get("Cache-Control");
        int i = 0;
        if (str2 != null) {
            String[] split = str2.split(",", 0);
            z = false;
            j = 0;
            j2 = 0;
            while (i < split.length) {
                String trim = split[i].trim();
                if (trim.equals("no-cache") || trim.equals("no-store")) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j = Long.parseLong(trim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (trim.startsWith("stale-while-revalidate=")) {
                    j2 = Long.parseLong(trim.substring(23));
                } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                    z = true;
                }
                i++;
            }
            i = 1;
        } else {
            z = false;
            j = 0;
            j2 = 0;
        }
        String str3 = map.get("Expires");
        long b2 = str3 != null ? b(str3) : 0L;
        String str4 = map.get("Last-Modified");
        long b3 = str4 != null ? b(str4) : 0L;
        String str5 = map.get(Command.HTTP_HEADER_ETAG);
        if (i != 0) {
            j4 = currentTimeMillis + (j * 1000);
            if (!z) {
                Long.signum(j2);
                j3 = j4;
                j4 += j2 * 1000;
                b.a aVar = new b.a();
                aVar.a = qVar.b;
                aVar.b = str5;
                aVar.f = j3;
                aVar.e = j4;
                aVar.c = b;
                aVar.d = b3;
                aVar.g = map;
                aVar.h = qVar.d;
                return aVar;
            }
            j3 = j4;
            b.a aVar2 = new b.a();
            aVar2.a = qVar.b;
            aVar2.b = str5;
            aVar2.f = j3;
            aVar2.e = j4;
            aVar2.c = b;
            aVar2.d = b3;
            aVar2.g = map;
            aVar2.h = qVar.d;
            return aVar2;
        }
        j3 = 0;
        if (b <= 0 || b2 < b) {
            j4 = 0;
            b.a aVar22 = new b.a();
            aVar22.a = qVar.b;
            aVar22.b = str5;
            aVar22.f = j3;
            aVar22.e = j4;
            aVar22.c = b;
            aVar22.d = b3;
            aVar22.g = map;
            aVar22.h = qVar.d;
            return aVar22;
        }
        j4 = currentTimeMillis + (b2 - b);
        j3 = j4;
        b.a aVar222 = new b.a();
        aVar222.a = qVar.b;
        aVar222.b = str5;
        aVar222.f = j3;
        aVar222.e = j4;
        aVar222.c = b;
        aVar222.d = b3;
        aVar222.g = map;
        aVar222.h = qVar.d;
        return aVar222;
    }

    static String a(long j) {
        return a("EEE, dd MMM yyyy HH:mm:ss 'GMT'").format(new Date(j));
    }

    public static String a(Map<String, String> map) {
        return a(map, "ISO-8859-1");
    }

    public static String a(Map<String, String> map, String str) {
        String str2;
        if (map != null && (str2 = map.get("Content-Type")) != null) {
            String[] split = str2.split(";", 0);
            for (int i = 1; i < split.length; i++) {
                String[] split2 = split[i].trim().split("=", 0);
                if (split2.length == 2 && split2[0].equals("charset")) {
                    return split2[1];
                }
            }
        }
        return str;
    }

    private static SimpleDateFormat a(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }

    static List<com.mbridge.msdk.tracker.network.g> a(List<com.mbridge.msdk.tracker.network.g> list, b.a aVar) {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (!list.isEmpty()) {
            Iterator<com.mbridge.msdk.tracker.network.g> it = list.iterator();
            while (it.hasNext()) {
                treeSet.add(it.next().a());
            }
        }
        ArrayList arrayList = new ArrayList(list);
        List<com.mbridge.msdk.tracker.network.g> list2 = aVar.h;
        if (list2 != null) {
            if (!list2.isEmpty()) {
                for (com.mbridge.msdk.tracker.network.g gVar : aVar.h) {
                    if (!treeSet.contains(gVar.a())) {
                        arrayList.add(gVar);
                    }
                }
            }
        } else if (!aVar.g.isEmpty()) {
            for (Map.Entry<String, String> entry : aVar.g.entrySet()) {
                if (!treeSet.contains(entry.getKey())) {
                    arrayList.add(new com.mbridge.msdk.tracker.network.g(entry.getKey(), entry.getValue()));
                }
            }
        }
        return arrayList;
    }

    static Map<String, String> a(b.a aVar) {
        if (aVar == null) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        String str = aVar.b;
        if (str != null) {
            hashMap.put("If-None-Match", str);
        }
        long j = aVar.d;
        if (j > 0) {
            hashMap.put("If-Modified-Since", a(j));
        }
        return hashMap;
    }

    public static long b(String str) {
        try {
            Date parse = a("EEE, dd MMM yyyy HH:mm:ss zzz").parse(str);
            if (parse != null) {
                return parse.getTime();
            }
            return 0L;
        } catch (ParseException e) {
            if (MBridgeConstans.ENDCARD_URL_TYPE_PL.equals(str) || "-1".equals(str)) {
                c0.d("Unable to parse dateStr: %s, falling back to 0", str);
            } else {
                c0.a(e, "Unable to parse dateStr: %s, falling back to 0", str);
            }
            return 0L;
        }
    }
}
