package com.transsion.transfer.androidasync.http;

import com.transsion.transfer.androidasync.util.TaggedList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import okhttp3.HttpUrl;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class Headers {
    final Multimap a = new Multimap() { // from class: com.transsion.transfer.androidasync.http.Headers.1
        @Override // com.transsion.transfer.androidasync.http.Multimap
        protected List<String> newList() {
            return new TaggedList();
        }
    };

    public Headers a(String str, String str2) {
        String lowerCase = str.toLowerCase(Locale.US);
        this.a.add(lowerCase, str2);
        ((TaggedList) this.a.get(lowerCase)).tagNull(str);
        return this;
    }

    public Headers b(String str) {
        if (str != null) {
            String[] split = str.trim().split(":", 2);
            if (split.length == 2) {
                a(split[0].trim(), split[1].trim());
            } else {
                a(split[0].trim(), HttpUrl.FRAGMENT_ENCODE_SET);
            }
        }
        return this;
    }

    public String c(String str) {
        return this.a.getString(str.toLowerCase(Locale.US));
    }

    public String d(String str) {
        List e = e(str.toLowerCase(Locale.US));
        if (e == null || e.size() == 0) {
            return null;
        }
        return (String) e.get(0);
    }

    public List e(String str) {
        return this.a.remove(str.toLowerCase(Locale.US));
    }

    public Headers f(String str, String str2) {
        if (str2 != null && (str2.contains("\n") || str2.contains("\r"))) {
            throw new IllegalArgumentException("value must not contain a new line or line feed");
        }
        String lowerCase = str.toLowerCase(Locale.US);
        this.a.put(lowerCase, str2);
        ((TaggedList) this.a.get(lowerCase)).tagNull(str);
        return this;
    }

    public String g(String str) {
        return h().insert(0, str + "\r\n").toString();
    }

    public StringBuilder h() {
        StringBuilder sb = new StringBuilder(256);
        Iterator<String> it = this.a.keySet().iterator();
        while (it.hasNext()) {
            TaggedList taggedList = (TaggedList) this.a.get(it.next());
            Iterator<T> it2 = taggedList.iterator();
            while (it2.hasNext()) {
                String str = (String) it2.next();
                sb.append((String) taggedList.tag());
                sb.append(": ");
                sb.append(str);
                sb.append("\r\n");
            }
        }
        sb.append("\r\n");
        return sb;
    }

    public String toString() {
        return h().toString();
    }
}
