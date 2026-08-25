package com.alibaba.fastjson.asm;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class TypeCollector {

    /* renamed from: e, reason: collision with root package name */
    private static String f14645e = com.alibaba.fastjson.util.b.b(z4.d.class);

    /* renamed from: f, reason: collision with root package name */
    private static final Map f14646f = new HashMap<String, String>() { // from class: com.alibaba.fastjson.asm.TypeCollector.1
        {
            put("int", "I");
            put("boolean", "Z");
            put("byte", "B");
            put("char", "C");
            put("short", "S");
            put("float", "F");
            put("long", "J");
            put("double", "D");
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final String f14647a;

    /* renamed from: b, reason: collision with root package name */
    private final Class[] f14648b;

    /* renamed from: c, reason: collision with root package name */
    protected g f14649c = null;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f14650d;

    public TypeCollector(String str, Class[] clsArr) {
        this.f14647a = str;
        this.f14648b = clsArr;
    }

    private boolean a(j jVar, String str) {
        String c5 = jVar.c();
        StringBuilder sb = new StringBuilder();
        while (c5.endsWith("[]")) {
            sb.append('[');
            c5 = c5.substring(0, c5.length() - 2);
        }
        if (sb.length() != 0) {
            Map map = f14646f;
            if (map.containsKey(c5)) {
                sb.append((String) map.get(c5));
                c5 = sb.toString();
            } else {
                sb.append('L');
                sb.append(c5);
                sb.append(';');
                c5 = sb.toString();
            }
        }
        return c5.equals(str);
    }

    public String[] b() {
        g gVar = this.f14649c;
        return (gVar == null || !gVar.f14698e) ? new String[0] : gVar.a().split(",");
    }

    public boolean c() {
        return this.f14650d;
    }

    public void d(String str) {
        if (f14645e.equals(str)) {
            this.f14650d = true;
        }
    }

    protected g e(int i5, String str, String str2) {
        if (this.f14649c != null || !str.equals(this.f14647a)) {
            return null;
        }
        j[] a5 = j.a(str2);
        int i6 = 0;
        for (j jVar : a5) {
            String c5 = jVar.c();
            if (c5.equals("long") || c5.equals("double")) {
                i6++;
            }
        }
        if (a5.length != this.f14648b.length) {
            return null;
        }
        for (int i7 = 0; i7 < a5.length; i7++) {
            if (!a(a5[i7], this.f14648b[i7].getName())) {
                return null;
            }
        }
        g gVar = new g(!Modifier.isStatic(i5) ? 1 : 0, a5.length + i6);
        this.f14649c = gVar;
        return gVar;
    }
}
