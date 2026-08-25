package com.transsion.transfer.androidasync.http.server;

import android.text.TextUtils;
import com.transsion.transfer.androidasync.http.b0;
import com.transsion.transfer.androidasync.http.f0;
import com.transsion.transfer.androidasync.http.server.AsyncHttpServer;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class n implements r {
    static Hashtable c;
    static Hashtable d;
    final ArrayList a = new ArrayList();
    private b b = new b();

    abstract class a extends com.transsion.transfer.androidasync.http.server.c {
        Matcher o;

        a() {
        }
    }

    class b implements q, r {
        b() {
        }

        @Override // com.transsion.transfer.androidasync.http.server.r
        public d a(String str, String str2) {
            return n.this.a(str, str2);
        }

        @Override // com.transsion.transfer.androidasync.http.server.q
        public void b(com.transsion.transfer.androidasync.http.server.b bVar, com.transsion.transfer.androidasync.http.server.d dVar) {
            d a = a(bVar.y(), bVar.getPath());
            if (a != null) {
                a.d.b(bVar, dVar);
            } else {
                dVar.c(404);
                dVar.d();
            }
        }
    }

    private static class c {
        String a;
        Pattern b;
        q c;

        private c() {
        }
    }

    public static class d {
        public final String a;
        public final String b;
        public final Matcher c;
        public final q d;

        private d(String str, String str2, Matcher matcher, q qVar, com.transsion.transfer.androidasync.http.server.a aVar) {
            this.a = str;
            this.b = str2;
            this.c = matcher;
            this.d = qVar;
        }
    }

    static {
        Hashtable hashtable = new Hashtable();
        c = hashtable;
        hashtable.put("js", "application/javascript");
        c.put("json", "application/json");
        c.put("png", "image/png");
        c.put("jpg", "image/jpeg");
        c.put("jpeg", "image/jpeg");
        c.put("html", "text/html");
        c.put("css", "text/css");
        c.put("mp4", "video/mp4");
        c.put("mov", "video/quicktime");
        c.put("wmv", "video/x-ms-wmv");
        c.put("txt", "text/plain");
        d = new Hashtable();
    }

    public static b0 e(String str, com.transsion.transfer.androidasync.http.server.b bVar, com.transsion.transfer.androidasync.http.server.d dVar) {
        String c2 = bVar.getHeaders().c("Connection");
        boolean z = false;
        if (c2 != null) {
            String[] split = c2.split(",");
            int length = split.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if ("Upgrade".equalsIgnoreCase(split[i].trim())) {
                    z = true;
                    break;
                }
                i++;
            }
        }
        if ("websocket".equalsIgnoreCase(bVar.getHeaders().c("Upgrade")) && z && TextUtils.equals(str, bVar.getHeaders().c("Sec-WebSocket-Protocol"))) {
            return new f0(bVar, dVar);
        }
        return null;
    }

    public static String g(String str) {
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return null;
        }
        String str2 = (String) c.get(str.substring(lastIndexOf + 1));
        if (str2 != null) {
            return str2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(String str, AsyncHttpServer.a aVar, com.transsion.transfer.androidasync.http.server.b bVar, com.transsion.transfer.androidasync.http.server.d dVar) {
        b0 e = e(str, bVar, dVar);
        if (e != null) {
            aVar.a(e, bVar);
        } else {
            dVar.c(404);
            dVar.d();
        }
    }

    @Override // com.transsion.transfer.androidasync.http.server.r
    public d a(String str, String str2) {
        synchronized (this.a) {
            try {
                Iterator it = this.a.iterator();
                while (it.hasNext()) {
                    c cVar = (c) it.next();
                    if (TextUtils.equals(str, cVar.a) || cVar.a == null) {
                        Matcher matcher = cVar.b.matcher(str2);
                        if (matcher.matches()) {
                            q qVar = cVar.c;
                            if (qVar instanceof r) {
                                return ((r) cVar.c).a(str, matcher.group(1));
                            }
                            return new d(str, str2, matcher, qVar, null);
                        }
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void c(String str, String str2, q qVar) {
        d(str, str2, qVar, null);
    }

    public void d(String str, String str2, q qVar, com.transsion.transfer.androidasync.http.server.a aVar) {
        c cVar = new c();
        cVar.b = Pattern.compile("^" + str2);
        cVar.c = qVar;
        cVar.a = str;
        synchronized (this.a) {
            this.a.add(cVar);
        }
    }

    public void f(String str, q qVar) {
        c("GET", str, qVar);
    }

    public void i(String str, q qVar) {
        c("POST", str, qVar);
    }

    public void j(String str, final String str2, final AsyncHttpServer.a aVar) {
        f(str, new q() { // from class: com.transsion.transfer.androidasync.http.server.l
            @Override // com.transsion.transfer.androidasync.http.server.q
            public final void b(b bVar, d dVar) {
                n.h(str2, aVar, bVar, dVar);
            }
        });
    }
}
