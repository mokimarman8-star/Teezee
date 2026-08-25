package com.transsion.infra.gateway.core.sercurity;

import android.text.TextUtils;
import com.transsion.gslb.BuildConfig;
import com.transsion.infra.gateway.core.bean.RequestBean;
import com.transsion.infra.gateway.core.utils.d;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class HttpSigner {
    private final c a;

    public HttpSigner(c cVar) {
        this.a = cVar;
    }

    private String a(String str) {
        StringBuilder sb = new StringBuilder();
        try {
            URI uri = new URI(str);
            sb.append(uri.getPath());
            if (!TextUtils.isEmpty(uri.getQuery())) {
                String f = f(uri.getQuery());
                if (!TextUtils.isEmpty(f)) {
                    sb.append("?");
                    sb.append(f);
                }
            }
            return sb.toString();
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return BuildConfig.FLAVOR;
        }
    }

    public static String b(RequestBean requestBean) {
        if (requestBean == null) {
            com.transsion.infra.gateway.core.utils.c.a.g("request bean is null");
            return null;
        }
        if (requestBean.getMethod() == null) {
            com.transsion.infra.gateway.core.utils.c.a.g("request method is null");
            return null;
        }
        if (TextUtils.isEmpty(requestBean.getUrl())) {
            com.transsion.infra.gateway.core.utils.c.a.g("request url is null");
            return null;
        }
        if (requestBean.getKey() == null) {
            com.transsion.infra.gateway.core.utils.c.a.g("request key is null");
            return null;
        }
        if (requestBean.getKey().getKey() == null) {
            com.transsion.infra.gateway.core.utils.c.a.g("request key is null");
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis() + d.a(com.transsion.infra.gateway.core.utils.a.a()).b("time_offset");
        String str = currentTimeMillis + "|" + requestBean.getKey().getKeyVersion() + "|" + new HttpSigner(new a(requestBean.getKey().getKey())).e(requestBean.getMethod(), requestBean.getAccept(), requestBean.getContentType(), requestBean.getUrl(), requestBean.getBody(), currentTimeMillis, requestBean.getKey().getAlgorithm());
        com.transsion.infra.gateway.core.utils.c.a.g("x-tr-signature: " + str);
        return str;
    }

    private String c(Map map) {
        try {
            ArrayList<Map.Entry> arrayList = new ArrayList(map.entrySet());
            Collections.sort(arrayList, new Comparator<Map.Entry<String, String>>() { // from class: com.transsion.infra.gateway.core.sercurity.HttpSigner.1
                @Override // java.util.Comparator
                public int compare(Map.Entry<String, String> entry, Map.Entry<String, String> entry2) {
                    return entry.getKey().compareTo(entry2.getKey());
                }
            });
            StringBuilder sb = new StringBuilder();
            for (Map.Entry entry : arrayList) {
                if (!BuildConfig.FLAVOR.equals(entry.getKey())) {
                    String str = (String) entry.getKey();
                    String str2 = (String) entry.getValue();
                    sb.append(str);
                    sb.append("=");
                    sb.append(str2);
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

    /* JADX WARN: Removed duplicated region for block: B:12:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String d(String str, String str2, String str3, String str4, String str5, long j) {
        long j2;
        String str6;
        StringBuilder sb = new StringBuilder();
        boolean isEmpty = TextUtils.isEmpty(str5);
        String str7 = BuildConfig.FLAVOR;
        if (isEmpty) {
            com.transsion.infra.gateway.core.utils.c.a.g("request body is null");
            str6 = BuildConfig.FLAVOR;
            j2 = 0;
        } else {
            try {
                j2 = str5.length();
                try {
                    System.currentTimeMillis();
                    str6 = str5.length() > 102400 ? com.transsion.infra.gateway.core.utils.b.c(str5.substring(0, 102400)) : com.transsion.infra.gateway.core.utils.b.c(str5);
                } catch (Exception e) {
                    e = e;
                    com.transsion.infra.gateway.core.utils.c.a.i("generateContent exception" + e.toString());
                    str6 = BuildConfig.FLAVOR;
                    sb.append(str.toUpperCase());
                    sb.append("\n");
                    sb.append(str2 != null ? BuildConfig.FLAVOR : str2);
                    sb.append("\n");
                    sb.append(str3 != null ? BuildConfig.FLAVOR : str3);
                    sb.append("\n");
                    sb.append(j2 != 0 ? BuildConfig.FLAVOR : Long.valueOf(j2));
                    sb.append("\n");
                    sb.append(j);
                    sb.append("\n");
                    if (!TextUtils.isEmpty(str6)) {
                    }
                    sb.append(str7);
                    sb.append("\n");
                    sb.append(a(str4));
                    com.transsion.infra.gateway.core.utils.c.a.g(sb.toString());
                    return sb.toString();
                }
            } catch (Exception e2) {
                e = e2;
                j2 = 0;
            }
        }
        sb.append(str.toUpperCase());
        sb.append("\n");
        sb.append(str2 != null ? BuildConfig.FLAVOR : str2);
        sb.append("\n");
        sb.append(str3 != null ? BuildConfig.FLAVOR : str3);
        sb.append("\n");
        sb.append(j2 != 0 ? BuildConfig.FLAVOR : Long.valueOf(j2));
        sb.append("\n");
        sb.append(j);
        sb.append("\n");
        if (!TextUtils.isEmpty(str6)) {
            str7 = str6;
        }
        sb.append(str7);
        sb.append("\n");
        sb.append(a(str4));
        com.transsion.infra.gateway.core.utils.c.a.g(sb.toString());
        return sb.toString();
    }

    private String f(String str) {
        HashMap hashMap = new HashMap();
        for (String str2 : str.split("&")) {
            int indexOf = str2.indexOf("=");
            try {
                hashMap.put(URLDecoder.decode(str2.substring(0, indexOf), "UTF-8"), URLDecoder.decode(str2.substring(indexOf + 1), "UTF-8"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return c(hashMap);
    }

    public String e(String str, String str2, String str3, String str4, String str5, long j, SignAlgorithm signAlgorithm) {
        return this.a.a(signAlgorithm, d(str, str2, str3, str4, str5, j));
    }
}
