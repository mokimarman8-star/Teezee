package org.jsoup.parser;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class d {
    public static final d c = new d(false, false);
    public static final d d = new d(true, true);
    private final boolean a;
    private final boolean b;

    public d(boolean z, boolean z2) {
        this.a = z;
        this.b = z2;
    }

    org.jsoup.nodes.b a(org.jsoup.nodes.b bVar) {
        if (!this.b) {
            bVar.v();
        }
        return bVar;
    }

    String b(String str) {
        String trim = str.trim();
        return !this.a ? sz.b.a(trim) : trim;
    }
}
