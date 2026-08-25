package com.transsion.json;

import com.transsion.json.b.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class j {
    public static final char[] f = "0123456789ABCDEF".toCharArray();
    private boolean d;
    private String e;
    private final Map b = new HashMap();
    private final List c = new ArrayList();
    private final p a = new p(w.a());

    public j a(boolean z) {
        this.d = z;
        return this;
    }

    public j b(String... strArr) {
        for (String str : strArr) {
            e(str);
        }
        return this;
    }

    public String c(Object obj) {
        return d(obj, t.SHALLOW, new s(new StringBuilder()));
    }

    protected String d(Object obj, t tVar, p pVar) {
        h q = h.q();
        q.k(this.e);
        q.m(this.d);
        q.g(pVar);
        q.h(tVar);
        q.e(this.a);
        q.l(this.b);
        q.s(this.c);
        try {
            String y = q.y();
            if (y != null && !y.trim().equals("")) {
                q.H();
                q.u(y);
                q.j(obj);
                q.D();
                String obj2 = q.v().toString();
                h.c();
                return obj2;
            }
            q.j(obj);
            String obj22 = q.v().toString();
            h.c();
            return obj22;
        } catch (Throwable th) {
            h.c();
            throw th;
        }
    }

    protected void e(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf > 0) {
            r rVar = new r(str.substring(0, lastIndexOf), true);
            if (!rVar.c()) {
                this.c.add(rVar);
            }
        }
        this.c.add(new r(str, false));
    }
}
