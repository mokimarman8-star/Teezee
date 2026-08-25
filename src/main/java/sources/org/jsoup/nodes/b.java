package org.jsoup.nodes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import okhttp3.HttpUrl;
import org.jsoup.SerializationException;
import org.jsoup.nodes.Document;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class b implements Iterable, Cloneable {
    private static final String[] d = new String[0];
    private int a = 0;
    String[] b;
    String[] c;

    class a implements Iterator {
        int a = 0;

        a() {
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public org.jsoup.nodes.a next() {
            b bVar = b.this;
            String[] strArr = bVar.b;
            int i = this.a;
            org.jsoup.nodes.a aVar = new org.jsoup.nodes.a(strArr[i], bVar.c[i], bVar);
            this.a++;
            return aVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a < b.this.a;
        }

        @Override // java.util.Iterator
        public void remove() {
            b bVar = b.this;
            int i = this.a - 1;
            this.a = i;
            bVar.z(i);
        }
    }

    public b() {
        String[] strArr = d;
        this.b = strArr;
        this.c = strArr;
    }

    private void c(String str, String str2) {
        i(this.a + 1);
        String[] strArr = this.b;
        int i = this.a;
        strArr[i] = str;
        this.c[i] = str2;
        this.a = i + 1;
    }

    private void i(int i) {
        org.jsoup.helper.d.d(i >= this.a);
        String[] strArr = this.b;
        int length = strArr.length;
        if (length >= i) {
            return;
        }
        int i2 = length >= 4 ? this.a * 2 : 4;
        if (i <= i2) {
            i = i2;
        }
        this.b = m(strArr, i);
        this.c = m(this.c, i);
    }

    static String j(String str) {
        return str == null ? HttpUrl.FRAGMENT_ENCODE_SET : str;
    }

    private static String[] m(String[] strArr, int i) {
        String[] strArr2 = new String[i];
        System.arraycopy(strArr, 0, strArr2, 0, Math.min(strArr.length, i));
        return strArr2;
    }

    private int u(String str) {
        org.jsoup.helper.d.j(str);
        for (int i = 0; i < this.a; i++) {
            if (str.equalsIgnoreCase(this.b[i])) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(int i) {
        org.jsoup.helper.d.b(i >= this.a);
        int i2 = (this.a - i) - 1;
        if (i2 > 0) {
            String[] strArr = this.b;
            int i3 = i + 1;
            System.arraycopy(strArr, i3, strArr, i, i2);
            String[] strArr2 = this.c;
            System.arraycopy(strArr2, i3, strArr2, i, i2);
        }
        int i4 = this.a - 1;
        this.a = i4;
        this.b[i4] = null;
        this.c[i4] = null;
    }

    public void A(String str) {
        int t = t(str);
        if (t != -1) {
            z(t);
        }
    }

    public void B(String str) {
        int u = u(str);
        if (u != -1) {
            z(u);
        }
    }

    public void e(b bVar) {
        if (bVar.size() == 0) {
            return;
        }
        i(this.a + bVar.a);
        Iterator it = bVar.iterator();
        while (it.hasNext()) {
            x((org.jsoup.nodes.a) it.next());
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.a == bVar.a && Arrays.equals(this.b, bVar.b)) {
            return Arrays.equals(this.c, bVar.c);
        }
        return false;
    }

    public List g() {
        ArrayList arrayList = new ArrayList(this.a);
        for (int i = 0; i < this.a; i++) {
            arrayList.add(this.c[i] == null ? new c(this.b[i]) : new org.jsoup.nodes.a(this.b[i], this.c[i], this));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public int hashCode() {
        return (((this.a * 31) + Arrays.hashCode(this.b)) * 31) + Arrays.hashCode(this.c);
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return new a();
    }

    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public b clone() {
        try {
            b bVar = (b) super.clone();
            bVar.a = this.a;
            this.b = m(this.b, this.a);
            this.c = m(this.c, this.a);
            return bVar;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public String n(String str) {
        int t = t(str);
        return t == -1 ? HttpUrl.FRAGMENT_ENCODE_SET : j(this.c[t]);
    }

    public String o(String str) {
        int u = u(str);
        return u == -1 ? HttpUrl.FRAGMENT_ENCODE_SET : j(this.c[u]);
    }

    public boolean p(String str) {
        return t(str) != -1;
    }

    public boolean q(String str) {
        return u(str) != -1;
    }

    public String r() {
        StringBuilder sb = new StringBuilder();
        try {
            s(sb, new Document(HttpUrl.FRAGMENT_ENCODE_SET).g1());
            return sb.toString();
        } catch (IOException e) {
            throw new SerializationException(e);
        }
    }

    final void s(Appendable appendable, Document.OutputSettings outputSettings) {
        int i = this.a;
        for (int i2 = 0; i2 < i; i2++) {
            String str = this.b[i2];
            String str2 = this.c[i2];
            appendable.append(' ').append(str);
            if (!org.jsoup.nodes.a.k(str, str2, outputSettings)) {
                appendable.append("=\"");
                if (str2 == null) {
                    str2 = HttpUrl.FRAGMENT_ENCODE_SET;
                }
                Entities.e(appendable, str2, outputSettings, true, false, false);
                appendable.append('\"');
            }
        }
    }

    public int size() {
        return this.a;
    }

    int t(String str) {
        org.jsoup.helper.d.j(str);
        for (int i = 0; i < this.a; i++) {
            if (str.equals(this.b[i])) {
                return i;
            }
        }
        return -1;
    }

    public String toString() {
        return r();
    }

    public void v() {
        for (int i = 0; i < this.a; i++) {
            String[] strArr = this.b;
            strArr[i] = sz.b.a(strArr[i]);
        }
    }

    public b w(String str, String str2) {
        int t = t(str);
        if (t != -1) {
            this.c[t] = str2;
        } else {
            c(str, str2);
        }
        return this;
    }

    public b x(org.jsoup.nodes.a aVar) {
        org.jsoup.helper.d.j(aVar);
        w(aVar.getKey(), aVar.getValue());
        aVar.c = this;
        return this;
    }

    void y(String str, String str2) {
        int u = u(str);
        if (u == -1) {
            c(str, str2);
            return;
        }
        this.c[u] = str2;
        if (this.b[u].equals(str)) {
            return;
        }
        this.b[u] = str;
    }
}
