package org.jsoup.nodes;

import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import okhttp3.HttpUrl;
import org.jsoup.SerializationException;
import org.jsoup.nodes.Document;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class a implements Map.Entry, Cloneable {
    private static final String[] d = {"allowfullscreen", "async", "autofocus", "checked", "compact", "declare", "default", "defer", "disabled", "formnovalidate", "hidden", "inert", "ismap", "itemscope", "multiple", "muted", "nohref", "noresize", "noshade", "novalidate", "nowrap", MRAIDPresenter.OPEN, "readonly", "required", "reversed", "seamless", "selected", "sortable", "truespeed", "typemustmatch"};
    private String a;
    private String b;
    b c;

    public a(String str, String str2) {
        this(str, str2, null);
    }

    public a(String str, String str2, b bVar) {
        org.jsoup.helper.d.j(str);
        this.a = str.trim();
        org.jsoup.helper.d.h(str);
        this.b = str2;
        this.c = bVar;
    }

    protected static void h(String str, String str2, Appendable appendable, Document.OutputSettings outputSettings) {
        appendable.append(str);
        if (k(str, str2, outputSettings)) {
            return;
        }
        appendable.append("=\"");
        Entities.e(appendable, b.j(str2), outputSettings, true, false, false);
        appendable.append('\"');
    }

    protected static boolean i(String str) {
        return Arrays.binarySearch(d, str) >= 0;
    }

    protected static boolean k(String str, String str2, Document.OutputSettings outputSettings) {
        return outputSettings.n() == Document.OutputSettings.Syntax.html && (str2 == null || ((HttpUrl.FRAGMENT_ENCODE_SET.equals(str2) || str2.equalsIgnoreCase(str)) && i(str)));
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a clone() {
        try {
            return (a) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // java.util.Map.Entry
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String getKey() {
        return this.a;
    }

    @Override // java.util.Map.Entry
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public String getValue() {
        return this.b;
    }

    public String e() {
        StringBuilder sb = new StringBuilder();
        try {
            g(sb, new Document(HttpUrl.FRAGMENT_ENCODE_SET).g1());
            return sb.toString();
        } catch (IOException e) {
            throw new SerializationException(e);
        }
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        String str = this.a;
        if (str == null ? aVar.a != null : !str.equals(aVar.a)) {
            return false;
        }
        String str2 = this.b;
        String str3 = aVar.b;
        return str2 != null ? str2.equals(str3) : str3 == null;
    }

    protected void g(Appendable appendable, Document.OutputSettings outputSettings) {
        h(this.a, this.b, appendable, outputSettings);
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        String str = this.a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public String setValue(String str) {
        int t;
        String n = this.c.n(this.a);
        b bVar = this.c;
        if (bVar != null && (t = bVar.t(this.a)) != -1) {
            this.c.c[t] = str;
        }
        this.b = str;
        return n;
    }

    public String toString() {
        return e();
    }
}
