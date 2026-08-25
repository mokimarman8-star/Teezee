package org.jsoup.parser;

import com.vungle.ads.internal.model.AdPayload;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class f {
    private static final Map j = new HashMap();
    private static final String[] k;
    private static final String[] l;
    private static final String[] m;
    private static final String[] n;
    private static final String[] o;
    private static final String[] p;
    private static final String[] q;
    private String a;
    private boolean b = true;
    private boolean c = true;
    private boolean d = true;
    private boolean e = false;
    private boolean f = false;
    private boolean g = false;
    private boolean h = false;
    private boolean i = false;

    static {
        String[] strArr = {"html", "head", "body", "frameset", "script", "noscript", "style", "meta", "link", "title", "frame", "noframes", "section", "nav", "aside", "hgroup", "header", "footer", "p", "h1", "h2", "h3", "h4", "h5", "h6", "ul", "ol", "pre", "div", "blockquote", "hr", "address", "figure", "figcaption", "form", "fieldset", "ins", "del", "dl", "dt", "dd", "li", "table", "caption", "thead", "tfoot", "tbody", "colgroup", "col", "tr", "th", "td", "video", "audio", "canvas", "details", "menu", "plaintext", AdPayload.KEY_TEMPLATE, "article", "main", "svg", "math"};
        k = strArr;
        l = new String[]{"object", "base", "font", "tt", "i", "b", "u", "big", "small", "em", "strong", "dfn", "code", "samp", "kbd", "var", "cite", "abbr", "time", "acronym", "mark", "ruby", "rt", "rp", "a", "img", "br", "wbr", "map", "q", "sub", "sup", "bdo", "iframe", "embed", "span", "input", "select", "textarea", "label", "button", "optgroup", "option", "legend", "datalist", "keygen", "output", "progress", "meter", "area", "param", "source", "track", "summary", "command", "device", "area", "basefont", "bgsound", "menuitem", "param", "source", "track", "data", "bdi", "s"};
        m = new String[]{"meta", "link", "base", "frame", "img", "br", "wbr", "embed", "hr", "input", "keygen", "col", "command", "device", "area", "basefont", "bgsound", "menuitem", "param", "source", "track"};
        n = new String[]{"title", "a", "p", "h1", "h2", "h3", "h4", "h5", "h6", "pre", "address", "li", "th", "td", "script", "style", "ins", "del", "s"};
        o = new String[]{"pre", "plaintext", "title", "textarea"};
        p = new String[]{"button", "fieldset", "input", "keygen", "object", "output", "select", "textarea"};
        q = new String[]{"input", "keygen", "object", "select", "textarea"};
        for (String str : strArr) {
            i(new f(str));
        }
        for (String str2 : l) {
            f fVar = new f(str2);
            fVar.b = false;
            fVar.c = false;
            i(fVar);
        }
        for (String str3 : m) {
            f fVar2 = (f) j.get(str3);
            org.jsoup.helper.d.j(fVar2);
            fVar2.d = false;
            fVar2.e = true;
        }
        for (String str4 : n) {
            f fVar3 = (f) j.get(str4);
            org.jsoup.helper.d.j(fVar3);
            fVar3.c = false;
        }
        for (String str5 : o) {
            f fVar4 = (f) j.get(str5);
            org.jsoup.helper.d.j(fVar4);
            fVar4.g = true;
        }
        for (String str6 : p) {
            f fVar5 = (f) j.get(str6);
            org.jsoup.helper.d.j(fVar5);
            fVar5.h = true;
        }
        for (String str7 : q) {
            f fVar6 = (f) j.get(str7);
            org.jsoup.helper.d.j(fVar6);
            fVar6.i = true;
        }
    }

    private f(String str) {
        this.a = str;
    }

    private static void i(f fVar) {
        j.put(fVar.a, fVar);
    }

    public static f k(String str) {
        return l(str, d.d);
    }

    public static f l(String str, d dVar) {
        org.jsoup.helper.d.j(str);
        Map map = j;
        f fVar = (f) map.get(str);
        if (fVar != null) {
            return fVar;
        }
        String b = dVar.b(str);
        org.jsoup.helper.d.h(b);
        f fVar2 = (f) map.get(b);
        if (fVar2 != null) {
            return fVar2;
        }
        f fVar3 = new f(b);
        fVar3.b = false;
        return fVar3;
    }

    public boolean a() {
        return this.c;
    }

    public String b() {
        return this.a;
    }

    public boolean c() {
        return this.b;
    }

    public boolean d() {
        return this.e;
    }

    public boolean e() {
        return this.h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.a.equals(fVar.a) && this.d == fVar.d && this.e == fVar.e && this.c == fVar.c && this.b == fVar.b && this.g == fVar.g && this.f == fVar.f && this.h == fVar.h && this.i == fVar.i;
    }

    public boolean f() {
        return j.containsKey(this.a);
    }

    public boolean g() {
        return this.e || this.f;
    }

    public boolean h() {
        return this.g;
    }

    public int hashCode() {
        return (((((((((((((((this.a.hashCode() * 31) + (this.b ? 1 : 0)) * 31) + (this.c ? 1 : 0)) * 31) + (this.d ? 1 : 0)) * 31) + (this.e ? 1 : 0)) * 31) + (this.f ? 1 : 0)) * 31) + (this.g ? 1 : 0)) * 31) + (this.h ? 1 : 0)) * 31) + (this.i ? 1 : 0);
    }

    f j() {
        this.f = true;
        return this;
    }

    public String toString() {
        return this.a;
    }
}
