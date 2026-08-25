package org.jsoup.parser;

import java.io.Reader;
import java.io.StringReader;
import java.util.List;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class e {
    private i a;
    private int b = 0;
    private ParseErrorList c;
    private d d;

    public e(i iVar) {
        this.a = iVar;
        this.d = iVar.b();
    }

    public static e a() {
        return new e(new b());
    }

    public static Document c(String str, String str2) {
        b bVar = new b();
        return bVar.d(new StringReader(str), str2, ParseErrorList.noTracking(), bVar.b());
    }

    public static List d(String str, Element element, String str2) {
        b bVar = new b();
        return bVar.i0(str, element, str2, ParseErrorList.noTracking(), bVar.b());
    }

    public static e g() {
        return new e(new j());
    }

    public boolean b() {
        return this.b > 0;
    }

    public Document e(Reader reader, String str) {
        ParseErrorList tracking = b() ? ParseErrorList.tracking(this.b) : ParseErrorList.noTracking();
        this.c = tracking;
        return this.a.d(reader, str, tracking, this.d);
    }

    public Document f(String str, String str2) {
        this.c = b() ? ParseErrorList.tracking(this.b) : ParseErrorList.noTracking();
        return this.a.d(new StringReader(str), str2, this.c, this.d);
    }
}
