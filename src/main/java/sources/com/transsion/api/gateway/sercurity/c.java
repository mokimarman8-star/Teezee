package com.transsion.api.gateway.sercurity;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class c {
    public final a a;

    public c(a aVar) {
        this.a = aVar;
    }

    public final String a(String str) {
        HashMap hashMap = new HashMap();
        for (String str2 : str.split("&")) {
            int indexOf = str2.indexOf("=");
            try {
                hashMap.put(URLDecoder.decode(str2.substring(0, indexOf), "UTF-8"), URLDecoder.decode(str2.substring(indexOf + 1), "UTF-8"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            ArrayList arrayList = new ArrayList(hashMap.entrySet());
            Collections.sort(arrayList, new b(this));
            StringBuilder sb = new StringBuilder();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (!"".equals(entry.getKey())) {
                    String str3 = (String) entry.getKey();
                    String str4 = (String) entry.getValue();
                    sb.append(str3);
                    sb.append("=");
                    sb.append(str4);
                    sb.append("&");
                }
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }
}
