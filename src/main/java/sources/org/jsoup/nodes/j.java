package org.jsoup.nodes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import okhttp3.HttpUrl;
import org.jsoup.SerializationException;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class j implements Cloneable {
    j a;
    int b;

    class a implements tz.a {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // tz.a
        public void a(j jVar, int i) {
        }

        @Override // tz.a
        public void b(j jVar, int i) {
            jVar.s(this.a);
        }
    }

    private static class b implements tz.a {
        private Appendable a;
        private Document.OutputSettings b;

        b(Appendable appendable, Document.OutputSettings outputSettings) {
            this.a = appendable;
            this.b = outputSettings;
            outputSettings.l();
        }

        @Override // tz.a
        public void a(j jVar, int i) {
            if (jVar.B().equals("#text")) {
                return;
            }
            try {
                jVar.G(this.a, i, this.b);
            } catch (IOException e) {
                throw new SerializationException(e);
            }
        }

        @Override // tz.a
        public void b(j jVar, int i) {
            try {
                jVar.F(this.a, i, this.b);
            } catch (IOException e) {
                throw new SerializationException(e);
            }
        }
    }

    protected j() {
    }

    private void K(int i) {
        List t = t();
        while (i < t.size()) {
            ((j) t.get(i)).U(i);
            i++;
        }
    }

    private void d(int i, String str) {
        org.jsoup.helper.d.j(str);
        org.jsoup.helper.d.j(this.a);
        List d = org.jsoup.parser.e.d(str, I() instanceof Element ? (Element) I() : null, j());
        this.a.b(i, (j[]) d.toArray(new j[d.size()]));
    }

    private Element u(Element element) {
        Elements o0 = element.o0();
        return o0.size() > 0 ? u(o0.get(0)) : element;
    }

    public j A() {
        j jVar = this.a;
        if (jVar == null) {
            return null;
        }
        List t = jVar.t();
        int i = this.b + 1;
        if (t.size() > i) {
            return (j) t.get(i);
        }
        return null;
    }

    public abstract String B();

    void C() {
    }

    public String D() {
        StringBuilder sb = new StringBuilder(128);
        E(sb);
        return sb.toString();
    }

    protected void E(Appendable appendable) {
        org.jsoup.select.d.c(new b(appendable, v()), this);
    }

    abstract void F(Appendable appendable, int i, Document.OutputSettings outputSettings);

    abstract void G(Appendable appendable, int i, Document.OutputSettings outputSettings);

    public Document H() {
        j R = R();
        if (R instanceof Document) {
            return (Document) R;
        }
        return null;
    }

    public j I() {
        return this.a;
    }

    public final j J() {
        return this.a;
    }

    public void L() {
        org.jsoup.helper.d.j(this.a);
        this.a.N(this);
    }

    public j M(String str) {
        org.jsoup.helper.d.j(str);
        i().B(str);
        return this;
    }

    protected void N(j jVar) {
        org.jsoup.helper.d.d(jVar.a == this);
        int i = jVar.b;
        t().remove(i);
        K(i);
        jVar.a = null;
    }

    protected void O(j jVar) {
        jVar.T(this);
    }

    protected void P(j jVar, j jVar2) {
        org.jsoup.helper.d.d(jVar.a == this);
        org.jsoup.helper.d.j(jVar2);
        j jVar3 = jVar2.a;
        if (jVar3 != null) {
            jVar3.N(jVar2);
        }
        int i = jVar.b;
        t().set(i, jVar2);
        jVar2.a = this;
        jVar2.U(i);
        jVar.a = null;
    }

    public void Q(j jVar) {
        org.jsoup.helper.d.j(jVar);
        org.jsoup.helper.d.j(this.a);
        this.a.P(this, jVar);
    }

    public j R() {
        j jVar = this;
        while (true) {
            j jVar2 = jVar.a;
            if (jVar2 == null) {
                return jVar;
            }
            jVar = jVar2;
        }
    }

    public void S(String str) {
        org.jsoup.helper.d.j(str);
        X(new a(str));
    }

    protected void T(j jVar) {
        org.jsoup.helper.d.j(jVar);
        j jVar2 = this.a;
        if (jVar2 != null) {
            jVar2.N(this);
        }
        this.a = jVar;
    }

    protected void U(int i) {
        this.b = i;
    }

    public int V() {
        return this.b;
    }

    public List W() {
        j jVar = this.a;
        if (jVar == null) {
            return Collections.emptyList();
        }
        List<j> t = jVar.t();
        ArrayList arrayList = new ArrayList(t.size() - 1);
        for (j jVar2 : t) {
            if (jVar2 != this) {
                arrayList.add(jVar2);
            }
        }
        return arrayList;
    }

    public j X(tz.a aVar) {
        org.jsoup.helper.d.j(aVar);
        org.jsoup.select.d.c(aVar, this);
        return this;
    }

    public j Y() {
        org.jsoup.helper.d.j(this.a);
        List t = t();
        j jVar = t.size() > 0 ? (j) t.get(0) : null;
        this.a.b(this.b, p());
        L();
        return jVar;
    }

    public j Z(String str) {
        org.jsoup.helper.d.h(str);
        List d = org.jsoup.parser.e.d(str, I() instanceof Element ? (Element) I() : null, j());
        j jVar = (j) d.get(0);
        if (jVar == null || !(jVar instanceof Element)) {
            return null;
        }
        Element element = (Element) jVar;
        Element u = u(element);
        this.a.P(this, element);
        u.c(this);
        if (d.size() > 0) {
            for (int i = 0; i < d.size(); i++) {
                j jVar2 = (j) d.get(i);
                jVar2.a.N(jVar2);
                element.g0(jVar2);
            }
        }
        return this;
    }

    public String a(String str) {
        org.jsoup.helper.d.h(str);
        return !w(str) ? HttpUrl.FRAGMENT_ENCODE_SET : org.jsoup.helper.c.m(j(), g(str));
    }

    protected void b(int i, j... jVarArr) {
        org.jsoup.helper.d.f(jVarArr);
        List t = t();
        for (j jVar : jVarArr) {
            O(jVar);
        }
        t.addAll(i, Arrays.asList(jVarArr));
        K(i);
    }

    protected void c(j... jVarArr) {
        List t = t();
        for (j jVar : jVarArr) {
            O(jVar);
            t.add(jVar);
            jVar.U(t.size() - 1);
        }
    }

    public j e(String str) {
        d(this.b + 1, str);
        return this;
    }

    public boolean equals(Object obj) {
        return this == obj;
    }

    public String g(String str) {
        org.jsoup.helper.d.j(str);
        if (!x()) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        String o = i().o(str);
        return o.length() > 0 ? o : str.startsWith("abs:") ? a(str.substring(4)) : HttpUrl.FRAGMENT_ENCODE_SET;
    }

    public j h(String str, String str2) {
        i().y(str, str2);
        return this;
    }

    public abstract org.jsoup.nodes.b i();

    public abstract String j();

    public j k(String str) {
        d(this.b, str);
        return this;
    }

    public j l(j jVar) {
        org.jsoup.helper.d.j(jVar);
        org.jsoup.helper.d.j(this.a);
        this.a.b(this.b, jVar);
        return this;
    }

    public j m(int i) {
        return (j) t().get(i);
    }

    public abstract int n();

    public List o() {
        return Collections.unmodifiableList(t());
    }

    protected j[] p() {
        return (j[]) t().toArray(new j[n()]);
    }

    @Override // 
    public j q() {
        j r = r(null);
        LinkedList linkedList = new LinkedList();
        linkedList.add(r);
        while (!linkedList.isEmpty()) {
            j jVar = (j) linkedList.remove();
            int n = jVar.n();
            for (int i = 0; i < n; i++) {
                List t = jVar.t();
                j r2 = ((j) t.get(i)).r(jVar);
                t.set(i, r2);
                linkedList.add(r2);
            }
        }
        return r;
    }

    protected j r(j jVar) {
        try {
            j jVar2 = (j) super.clone();
            jVar2.a = jVar;
            jVar2.b = jVar == null ? 0 : this.b;
            return jVar2;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    protected abstract void s(String str);

    protected abstract List t();

    public String toString() {
        return D();
    }

    Document.OutputSettings v() {
        Document H = H();
        if (H == null) {
            H = new Document(HttpUrl.FRAGMENT_ENCODE_SET);
        }
        return H.g1();
    }

    public boolean w(String str) {
        org.jsoup.helper.d.j(str);
        if (str.startsWith("abs:")) {
            String substring = str.substring(4);
            if (i().q(substring) && !a(substring).equals(HttpUrl.FRAGMENT_ENCODE_SET)) {
                return true;
            }
        }
        return i().q(str);
    }

    protected abstract boolean x();

    public boolean y() {
        return this.a != null;
    }

    protected void z(Appendable appendable, int i, Document.OutputSettings outputSettings) {
        appendable.append('\n').append(org.jsoup.helper.c.l(i * outputSettings.j()));
    }
}
