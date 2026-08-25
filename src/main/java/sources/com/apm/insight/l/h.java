package com.apm.insight.l;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class h {
    private Writer a;
    private final List<a> b = new ArrayList();

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    static final class a {
        public static final a a = new a("EMPTY_ARRAY", 0);
        public static final a b = new a("NONEMPTY_ARRAY", 1);
        public static final a c = new a("EMPTY_OBJECT", 2);
        public static final a d = new a("DANGLING_KEY", 3);
        public static final a e = new a("NONEMPTY_OBJECT", 4);
        public static final a f = new a("NULL", 5);

        private a(String str, int i) {
        }
    }

    private h(Writer writer) {
        this.a = writer;
    }

    private h a() throws JSONException, IOException {
        return a(a.a, "[");
    }

    private h a(a aVar, String str) throws JSONException, IOException {
        f();
        this.b.add(aVar);
        this.a.write(str);
        return this;
    }

    private h a(Object obj) throws JSONException, IOException {
        if (obj instanceof JSONArray) {
            a((JSONArray) obj);
            return this;
        }
        if (obj instanceof JSONObject) {
            a((JSONObject) obj);
            return this;
        }
        f();
        if (obj == null || obj == JSONObject.NULL) {
            this.a.write("null");
        } else if (obj instanceof Boolean) {
            this.a.write(String.valueOf(obj));
        } else if (obj instanceof Number) {
            this.a.write(JSONObject.numberToString((Number) obj));
        } else {
            b(obj.toString());
        }
        return this;
    }

    private h a(String str) throws JSONException, IOException {
        e();
        this.b.remove(r0.size() - 1);
        this.a.write(str);
        return this;
    }

    private void a(a aVar) {
        this.b.set(r0.size() - 1, aVar);
    }

    private void a(JSONArray jSONArray) throws JSONException, IOException {
        a();
        for (int i = 0; i < jSONArray.length(); i++) {
            a(jSONArray.get(i));
        }
        b();
    }

    public static void a(JSONArray jSONArray, Writer writer) throws Throwable {
        new h(writer).a(jSONArray);
        writer.flush();
    }

    private void a(JSONObject jSONObject) throws JSONException, IOException {
        c();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            c(next).a(jSONObject.get(next));
        }
        d();
    }

    public static void a(JSONObject jSONObject, Writer writer) throws Throwable {
        new h(writer).a(jSONObject);
        writer.flush();
    }

    private h b() throws JSONException, IOException {
        a aVar = a.a;
        return a("]");
    }

    private void b(String str) throws IOException {
        this.a.write("\"");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '\f') {
                this.a.write("\\f");
            } else if (charAt != '\r') {
                if (charAt != '\"' && charAt != '/' && charAt != '\\') {
                    switch (charAt) {
                        case '\b':
                            this.a.write("\\b");
                            continue;
                        case '\t':
                            this.a.write("\\t");
                            continue;
                        case '\n':
                            this.a.write("\\n");
                            continue;
                        default:
                            if (charAt <= 31) {
                                this.a.write(String.format("\\u%04x", Integer.valueOf(charAt)));
                                break;
                            }
                            break;
                    }
                } else {
                    this.a.write(92);
                }
                this.a.write(charAt);
            } else {
                this.a.write("\\r");
            }
        }
        this.a.write("\"");
    }

    private h c() throws JSONException, IOException {
        return a(a.c, "{");
    }

    private h c(String str) throws JSONException, IOException {
        a e = e();
        if (e == a.e) {
            this.a.write(44);
        } else if (e != a.c) {
            throw new JSONException("Nesting problem");
        }
        a(a.d);
        b(str);
        return this;
    }

    private h d() throws JSONException, IOException {
        a aVar = a.a;
        return a("}");
    }

    private a e() throws JSONException {
        return this.b.get(r0.size() - 1);
    }

    private void f() throws JSONException, IOException {
        if (this.b.isEmpty()) {
            return;
        }
        a e = e();
        if (e == a.a) {
            a(a.b);
            return;
        }
        if (e == a.b) {
            this.a.write(44);
        } else if (e == a.d) {
            this.a.write(":");
            a(a.e);
        } else if (e != a.f) {
            throw new JSONException("Nesting problem");
        }
    }

    public final String toString() {
        return "";
    }
}
