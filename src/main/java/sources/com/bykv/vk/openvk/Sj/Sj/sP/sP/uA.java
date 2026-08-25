package com.bykv.vk.openvk.Sj.Sj.sP.sP;

import android.net.Uri;
import android.text.TextUtils;
import com.cloud.tmc.integration.params.TmcStartParams;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class uA {
    public final b a;
    public final List b;
    public final a c;

    static final class EjP extends Exception {
        EjP(String str) {
            super(str);
        }
    }

    static final class a {
        final int a;
        final String b;
        final String c;
        final int d;
        final int e;
        final String f;
        final List g;

        private a(int i, String str, String str2, int i2, int i3, String str3, List list) {
            this.a = i;
            this.b = str;
            this.c = str2;
            this.d = i2;
            this.e = i3;
            this.f = str3;
            this.g = list;
        }

        static a a(b bVar, List list) {
            String str;
            int i;
            int i2;
            int indexOf = bVar.b.indexOf("?");
            if (indexOf == -1) {
                throw new EjP("path format error, path: " + bVar.b);
            }
            ArrayList arrayList = new ArrayList();
            String str2 = null;
            String str3 = null;
            String str4 = null;
            int i3 = 0;
            for (String str5 : bVar.b.substring(indexOf + 1).split("&")) {
                String[] split = str5.split("=");
                if (split.length == 2) {
                    if ("rk".equals(split[0])) {
                        str3 = Uri.decode(split[1]);
                    } else if ("k".equals(split[0])) {
                        str4 = Uri.decode(split[1]);
                    } else if (split[0].startsWith(TmcStartParams.KEY_URL_SHORT)) {
                        arrayList.add(Uri.decode(split[1]));
                    } else if ("f".equals(split[0]) && h6.a.t(split[1]) == 1) {
                        i3 = 1;
                    }
                }
            }
            if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
                throw new EjP("rawKey or key is empty, path: " + bVar.b);
            }
            if (list != null) {
                Iterator it = list.iterator();
                i2 = 0;
                int i4 = 0;
                while (it.hasNext()) {
                    c cVar = (c) it.next();
                    if (cVar != null && "Range".equalsIgnoreCase(cVar.a)) {
                        int indexOf2 = cVar.b.indexOf("=");
                        if (indexOf2 == -1) {
                            throw new EjP("Range format error, Range: " + cVar.b);
                        }
                        if (!"bytes".equalsIgnoreCase(cVar.b.substring(0, indexOf2).trim())) {
                            throw new EjP("Range format error, Range: " + cVar.b);
                        }
                        String substring = cVar.b.substring(indexOf2 + 1);
                        if (substring.contains(",")) {
                            throw new EjP("Range format error, Range: " + cVar.b);
                        }
                        int indexOf3 = substring.indexOf("-");
                        if (indexOf3 == -1) {
                            throw new EjP("Range format error, Range: " + cVar.b);
                        }
                        String trim = substring.substring(0, indexOf3).trim();
                        String trim2 = substring.substring(indexOf3 + 1).trim();
                        try {
                            if (trim.length() > 0) {
                                i2 = Integer.parseInt(trim);
                            }
                            if (trim2.length() > 0 && i2 > (i4 = Integer.parseInt(trim2))) {
                                throw new EjP("Range format error, Range: " + cVar.b);
                            }
                            str2 = cVar.b;
                        } catch (NumberFormatException unused) {
                            throw new EjP("Range format error, Range: " + cVar.b);
                        }
                    }
                }
                i = i4;
                str = str2;
            } else {
                str = null;
                i = 0;
                i2 = 0;
            }
            if (!arrayList.isEmpty()) {
                return new a(i3, str3, str4, i2, i, str, arrayList);
            }
            throw new EjP("no url found: path: " + bVar.b);
        }

        public String toString() {
            return "Extra{flag=" + this.a + ", rawKey='" + this.b + "', key='" + this.c + "', from=" + this.d + ", to=" + this.e + ", urls=" + this.g + '}';
        }
    }

    static final class b {
        final String a;
        final String b;
        final String c;

        private b(String str, String str2, String str3) {
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        static b a(String str) {
            int indexOf = str.indexOf(32);
            if (indexOf == -1) {
                throw new EjP("request line format error, line: ".concat(str));
            }
            int lastIndexOf = str.lastIndexOf(32);
            if (lastIndexOf <= indexOf) {
                throw new EjP("request line format error, line: ".concat(str));
            }
            String trim = str.substring(0, indexOf).trim();
            String trim2 = str.substring(indexOf + 1, lastIndexOf).trim();
            String trim3 = str.substring(lastIndexOf + 1).trim();
            if (trim.length() == 0 || trim2.length() == 0 || trim3.length() == 0) {
                throw new EjP("request line format error, line: ".concat(str));
            }
            return new b(trim, trim2, trim3);
        }

        public String toString() {
            return "RequestLine{method='" + this.a + "', path='" + this.b + "', version='" + this.c + "'}";
        }
    }

    public static final class c {
        public final String a;
        public final String b;

        public c(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        static c a(String str) {
            int indexOf = str.indexOf(":");
            if (indexOf == -1) {
                throw new EjP("request header format error, header: ".concat(str));
            }
            String trim = str.substring(0, indexOf).trim();
            String trim2 = str.substring(indexOf + 1).trim();
            if (trim.length() == 0 || trim2.length() == 0) {
                throw new EjP("request header format error, header: ".concat(str));
            }
            return new c(trim, trim2);
        }

        public String toString() {
            return "Header{name='" + this.a + "', value='" + this.b + "'}";
        }
    }

    public uA(b bVar, List list, a aVar) {
        this.a = bVar;
        this.b = list;
        this.c = aVar;
    }

    public static uA a(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, h6.a.b));
        ArrayList arrayList = new ArrayList();
        b bVar = null;
        while (true) {
            String readLine = bufferedReader.readLine();
            if (TextUtils.isEmpty(readLine)) {
                break;
            }
            String trim = readLine.trim();
            if (bVar == null) {
                bVar = b.a(trim);
            } else {
                arrayList.add(c.a(trim));
            }
        }
        if (bVar != null) {
            return new uA(bVar, arrayList, a.a(bVar, arrayList));
        }
        throw new EjP("request line is null");
    }

    public String toString() {
        return "Request{requestLine=" + this.a + ", headers=" + this.b + ", extra=" + this.c + '}';
    }
}
