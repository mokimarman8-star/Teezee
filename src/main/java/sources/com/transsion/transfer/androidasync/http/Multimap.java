package com.transsion.transfer.androidasync.http;

import android.net.Uri;
import android.text.TextUtils;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class Multimap extends LinkedHashMap<String, List<String>> implements Iterable<w> {
    public static final c QUERY_DECODER = new a();
    public static final c URL_DECODER = new b();

    class a implements c {
        a() {
        }

        @Override // com.transsion.transfer.androidasync.http.Multimap.c
        public String decode(String str) {
            return Uri.decode(str);
        }
    }

    class b implements c {
        b() {
        }

        @Override // com.transsion.transfer.androidasync.http.Multimap.c
        public String decode(String str) {
            return URLDecoder.decode(str);
        }
    }

    public interface c {
        String decode(String str);
    }

    public Multimap() {
    }

    public Multimap(Multimap multimap) {
        putAll(multimap);
    }

    public Multimap(List<w> list) {
        for (w wVar : list) {
            add(wVar.getName(), wVar.getValue());
        }
    }

    public static Multimap parse(String str, String str2, String str3, boolean z, c cVar) {
        Multimap multimap = new Multimap();
        if (str == null) {
            return multimap;
        }
        for (String str4 : str.split(str2)) {
            String[] split = str4.split(str3, 2);
            String trim = split[0].trim();
            if (!TextUtils.isEmpty(trim)) {
                String str5 = split.length > 1 ? split[1] : null;
                if (str5 != null && z && str5.endsWith("\"") && str5.startsWith("\"")) {
                    str5 = str5.substring(1, str5.length() - 1);
                }
                if (str5 != null && cVar != null) {
                    trim = cVar.decode(trim);
                    str5 = cVar.decode(str5);
                }
                multimap.add(trim, str5);
            }
        }
        return multimap;
    }

    public static Multimap parse(String str, String str2, boolean z, c cVar) {
        return parse(str, str2, "=", z, cVar);
    }

    public static Multimap parseCommaDelimited(String str) {
        return parse(str, ",", true, null);
    }

    public static Multimap parseQuery(String str) {
        return parse(str, "&", false, QUERY_DECODER);
    }

    public static Multimap parseSemicolonDelimited(String str) {
        return parse(str, ";", true, null);
    }

    public static Multimap parseUrlEncoded(String str) {
        return parse(str, "&", false, URL_DECODER);
    }

    public void add(String str, String str2) {
        ensure(str).add(str2);
    }

    public List<String> ensure(String str) {
        List<String> list = get(str);
        if (list != null) {
            return list;
        }
        List<String> newList = newList();
        put((Multimap) str, (String) newList);
        return newList;
    }

    public String getAllString(String str, String str2) {
        List<String> list = get(str);
        if (list == null || list.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str3 : list) {
            if (!z) {
                sb.append(str2);
            }
            sb.append(str3);
            z = false;
        }
        return sb.toString();
    }

    public String getString(String str) {
        List<String> list = get(str);
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    @Override // java.lang.Iterable
    public Iterator<w> iterator() {
        ArrayList arrayList = new ArrayList();
        for (String str : keySet()) {
            Iterator it = ((List) get(str)).iterator();
            while (it.hasNext()) {
                arrayList.add(new u(str, (String) it.next()));
            }
        }
        return arrayList.iterator();
    }

    protected List<String> newList() {
        return new ArrayList();
    }

    public void put(String str, String str2) {
        List<String> newList = newList();
        newList.add(str2);
        put((Multimap) str, (String) newList);
    }

    public Map<String, String> toSingleMap() {
        HashMap hashMap = new HashMap();
        for (String str : keySet()) {
            hashMap.put(str, getString(str));
        }
        return hashMap;
    }
}
