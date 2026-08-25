package org.jsoup.nodes;

import org.jsoup.nodes.Document;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class l extends i {
    public l(String str) {
        this.c = str;
    }

    static boolean e0(StringBuilder sb) {
        return sb.length() != 0 && sb.charAt(sb.length() - 1) == ' ';
    }

    @Override // org.jsoup.nodes.j
    public String B() {
        return "#text";
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0022, code lost:
    
        if (d0() == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x003a, code lost:
    
        z(r7, r8, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0038, code lost:
    
        if (d0() == false) goto L18;
     */
    @Override // org.jsoup.nodes.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void F(Appendable appendable, int i, Document.OutputSettings outputSettings) {
        if (outputSettings.m()) {
            if (V() == 0) {
                j jVar = this.a;
                if (jVar instanceof Element) {
                    if (((Element) jVar).T0().a()) {
                    }
                }
            }
            if (outputSettings.k()) {
                if (W().size() > 0) {
                }
            }
        }
        Entities.e(appendable, a0(), outputSettings, false, outputSettings.m() && (I() instanceof Element) && !Element.O0(I()), false);
    }

    @Override // org.jsoup.nodes.j
    void G(Appendable appendable, int i, Document.OutputSettings outputSettings) {
    }

    @Override // org.jsoup.nodes.i, org.jsoup.nodes.j
    public /* bridge */ /* synthetic */ String a(String str) {
        return super.a(str);
    }

    public String c0() {
        return a0();
    }

    public boolean d0() {
        return org.jsoup.helper.c.e(a0());
    }

    @Override // org.jsoup.nodes.i, org.jsoup.nodes.j
    public /* bridge */ /* synthetic */ String g(String str) {
        return super.g(str);
    }

    @Override // org.jsoup.nodes.i, org.jsoup.nodes.j
    public /* bridge */ /* synthetic */ String j() {
        return super.j();
    }

    @Override // org.jsoup.nodes.i, org.jsoup.nodes.j
    public /* bridge */ /* synthetic */ int n() {
        return super.n();
    }

    @Override // org.jsoup.nodes.j
    public String toString() {
        return D();
    }

    @Override // org.jsoup.nodes.i, org.jsoup.nodes.j
    public /* bridge */ /* synthetic */ boolean w(String str) {
        return super.w(str);
    }
}
