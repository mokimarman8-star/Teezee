package c5;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.GZIPOutputStream;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class o0 extends i1 {
    protected final g1 j;
    public final j1 k;
    private int l;
    private String m;
    private String n;
    private DateFormat o;
    private String p;
    protected IdentityHashMap q;
    protected e1 r;
    protected TimeZone s;
    protected Locale t;

    public o0() {
        this(new j1(), g1.g());
    }

    public o0(j1 j1Var) {
        this(j1Var, g1.g());
    }

    public o0(j1 j1Var, g1 g1Var) {
        this.l = 0;
        this.m = "\t";
        this.q = null;
        this.s = com.alibaba.fastjson.a.defaultTimeZone;
        this.t = com.alibaba.fastjson.a.defaultLocale;
        this.k = j1Var;
        this.j = g1Var;
    }

    private DateFormat m(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, this.t);
        simpleDateFormat.setTimeZone(this.s);
        return simpleDateFormat;
    }

    public final void A(Object obj) {
        if (obj == null) {
            this.k.h0();
            return;
        }
        try {
            q(obj.getClass()).c(this, obj, null, null, 0);
        } catch (IOException e) {
            throw new JSONException(e.getMessage(), e);
        }
    }

    public final void B(String str) {
        k1.a.f(this, str);
    }

    public void C() {
        this.k.h0();
    }

    public void D(Object obj) {
        e1 e1Var = this.r;
        if (obj == e1Var.b) {
            this.k.write("{\"$ref\":\"@\"}");
            return;
        }
        e1 e1Var2 = e1Var.a;
        if (e1Var2 != null && obj == e1Var2.b) {
            this.k.write("{\"$ref\":\"..\"}");
            return;
        }
        while (true) {
            e1 e1Var3 = e1Var.a;
            if (e1Var3 == null) {
                break;
            } else {
                e1Var = e1Var3;
            }
        }
        if (obj == e1Var.b) {
            this.k.write("{\"$ref\":\"$\"}");
            return;
        }
        this.k.write("{\"$ref\":\"");
        this.k.write(((e1) this.q.get(obj)).toString());
        this.k.write("\"}");
    }

    public final void E(Object obj, Object obj2) {
        F(obj, obj2, null, 0);
    }

    public final void F(Object obj, Object obj2, Type type, int i) {
        try {
            if (obj == null) {
                this.k.h0();
            } else {
                q(obj.getClass()).c(this, obj, obj2, type, i);
            }
        } catch (IOException e) {
            throw new JSONException(e.getMessage(), e);
        }
    }

    public final void G(Object obj, String str) {
        if (obj instanceof Date) {
            if ("unixtime".equals(str)) {
                this.k.e0((int) (((Date) obj).getTime() / 1000));
                return;
            }
            if ("millis".equals(str)) {
                this.k.g0(((Date) obj).getTime());
                return;
            }
            DateFormat n = n();
            if (n == null) {
                if (str != null) {
                    try {
                        n = m(str);
                    } catch (IllegalArgumentException unused) {
                        n = m(str.replaceAll("T", "'T'"));
                    }
                } else {
                    String str2 = this.p;
                    n = str2 != null ? m(str2) : m(com.alibaba.fastjson.a.DEFFAULT_DATE_FORMAT);
                }
            }
            this.k.o0(n.format((Date) obj));
            return;
        }
        if (!(obj instanceof byte[])) {
            if (!(obj instanceof Collection)) {
                A(obj);
                return;
            }
            Collection collection = (Collection) obj;
            Iterator it = collection.iterator();
            this.k.write(91);
            for (int i = 0; i < collection.size(); i++) {
                Object next = it.next();
                if (i != 0) {
                    this.k.write(44);
                }
                G(next, str);
            }
            this.k.write(93);
            return;
        }
        byte[] bArr = (byte[]) obj;
        if (!"gzip".equals(str) && !"gzip,base64".equals(str)) {
            if ("hex".equals(str)) {
                this.k.d0(bArr);
                return;
            } else {
                this.k.r(bArr);
                return;
            }
        }
        GZIPOutputStream gZIPOutputStream = null;
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                gZIPOutputStream = bArr.length < 512 ? new GZIPOutputStream(byteArrayOutputStream, bArr.length) : new GZIPOutputStream(byteArrayOutputStream);
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.finish();
                this.k.r(byteArrayOutputStream.toByteArray());
                com.alibaba.fastjson.util.f.a(gZIPOutputStream);
            } catch (IOException e) {
                throw new JSONException("write gzipBytes error", e);
            }
        } catch (Throwable th) {
            com.alibaba.fastjson.util.f.a(gZIPOutputStream);
            throw th;
        }
    }

    public void j(SerializerFeature serializerFeature, boolean z) {
        this.k.j(serializerFeature, z);
    }

    public boolean k(Object obj) {
        e1 e1Var;
        IdentityHashMap identityHashMap = this.q;
        if (identityHashMap == null || (e1Var = (e1) identityHashMap.get(obj)) == null || obj == Collections.emptyMap()) {
            return false;
        }
        Object obj2 = e1Var.c;
        return obj2 == null || (obj2 instanceof Integer) || (obj2 instanceof String);
    }

    public void l() {
        this.l--;
    }

    public DateFormat n() {
        String str;
        if (this.o == null && (str = this.n) != null) {
            this.o = m(str);
        }
        return this.o;
    }

    public String o() {
        DateFormat dateFormat = this.o;
        return dateFormat instanceof SimpleDateFormat ? ((SimpleDateFormat) dateFormat).toPattern() : this.n;
    }

    public String p() {
        return this.p;
    }

    public z0 q(Class cls) {
        return this.j.h(cls);
    }

    public j1 r() {
        return this.k;
    }

    public void s() {
        this.l++;
    }

    public boolean t(SerializerFeature serializerFeature) {
        return this.k.o(serializerFeature);
    }

    public String toString() {
        return this.k.toString();
    }

    public final boolean u(Type type, Object obj) {
        e1 e1Var;
        return this.k.o(SerializerFeature.WriteClassName) && !(type == null && this.k.o(SerializerFeature.NotWriteRootClassName) && ((e1Var = this.r) == null || e1Var.a == null));
    }

    public void v() {
        this.k.write(10);
        for (int i = 0; i < this.l; i++) {
            this.k.write(this.m);
        }
    }

    public void w(e1 e1Var, Object obj, Object obj2, int i) {
        x(e1Var, obj, obj2, i, 0);
    }

    public void x(e1 e1Var, Object obj, Object obj2, int i, int i2) {
        if (this.k.h) {
            return;
        }
        this.r = new e1(e1Var, obj, obj2, i, i2);
        if (this.q == null) {
            this.q = new IdentityHashMap();
        }
        this.q.put(obj, this.r);
    }

    public void y(String str) {
        this.n = str;
        if (this.o != null) {
            this.o = null;
        }
    }

    public void z(String str) {
        this.p = str;
    }
}
