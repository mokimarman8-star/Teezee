package org.jsoup.nodes;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import okhttp3.HttpUrl;
import org.jsoup.nodes.Entities;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class Document extends Element {
    private OutputSettings j;
    private QuirksMode k;
    private String l;
    private boolean m;

    public static class OutputSettings implements Cloneable {
        private Charset b;
        Entities.CoreCharset d;
        private Entities.EscapeMode a = Entities.EscapeMode.base;
        private ThreadLocal c = new ThreadLocal();
        private boolean e = true;
        private boolean f = false;
        private int g = 1;
        private Syntax h = Syntax.html;

        public enum Syntax {
            html,
            xml
        }

        public OutputSettings() {
            c(Charset.forName("UTF8"));
        }

        public Charset a() {
            return this.b;
        }

        public OutputSettings b(String str) {
            c(Charset.forName(str));
            return this;
        }

        public OutputSettings c(Charset charset) {
            this.b = charset;
            return this;
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public OutputSettings clone() {
            try {
                OutputSettings outputSettings = (OutputSettings) super.clone();
                outputSettings.b(this.b.name());
                outputSettings.a = Entities.EscapeMode.valueOf(this.a.name());
                return outputSettings;
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }

        CharsetEncoder g() {
            CharsetEncoder charsetEncoder = (CharsetEncoder) this.c.get();
            return charsetEncoder != null ? charsetEncoder : l();
        }

        public Entities.EscapeMode i() {
            return this.a;
        }

        public int j() {
            return this.g;
        }

        public boolean k() {
            return this.f;
        }

        CharsetEncoder l() {
            CharsetEncoder newEncoder = this.b.newEncoder();
            this.c.set(newEncoder);
            this.d = Entities.CoreCharset.byName(newEncoder.charset().name());
            return newEncoder;
        }

        public boolean m() {
            return this.e;
        }

        public Syntax n() {
            return this.h;
        }

        public OutputSettings o(Syntax syntax) {
            this.h = syntax;
            return this;
        }
    }

    public enum QuirksMode {
        noQuirks,
        quirks,
        limitedQuirks
    }

    public Document(String str) {
        super(org.jsoup.parser.f.l("#root", org.jsoup.parser.d.c), str);
        this.j = new OutputSettings();
        this.k = QuirksMode.noQuirks;
        this.m = false;
        this.l = str;
    }

    private Element f1(String str, j jVar) {
        if (jVar.B().equals(str)) {
            return (Element) jVar;
        }
        int n = jVar.n();
        for (int i = 0; i < n; i++) {
            Element f1 = f1(str, jVar.m(i));
            if (f1 != null) {
                return f1;
            }
        }
        return null;
    }

    @Override // org.jsoup.nodes.Element, org.jsoup.nodes.j
    public String B() {
        return "#document";
    }

    @Override // org.jsoup.nodes.j
    public String D() {
        return super.B0();
    }

    @Override // org.jsoup.nodes.Element
    public Element X0(String str) {
        d1().X0(str);
        return this;
    }

    public Element d1() {
        return f1("body", this);
    }

    @Override // org.jsoup.nodes.Element
    /* renamed from: e1, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public Document q() {
        Document document = (Document) super.q();
        document.j = this.j.clone();
        return document;
    }

    public OutputSettings g1() {
        return this.j;
    }

    public QuirksMode h1() {
        return this.k;
    }

    public Document i1(QuirksMode quirksMode) {
        this.k = quirksMode;
        return this;
    }

    public String j1() {
        Element first = y0("title").first();
        return first != null ? org.jsoup.helper.c.k(first.W0()).trim() : HttpUrl.FRAGMENT_ENCODE_SET;
    }
}
