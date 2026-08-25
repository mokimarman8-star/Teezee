package com.amazonaws.services.s3.model.transform;

import java.util.Iterator;
import java.util.LinkedList;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
abstract class AbstractHandler extends DefaultHandler {
    private final StringBuilder a = new StringBuilder();
    private final LinkedList b = new LinkedList();

    AbstractHandler() {
    }

    protected final boolean a() {
        return this.b.isEmpty();
    }

    protected abstract void b(String str, String str2, String str3);

    protected abstract void c(String str, String str2, String str3, Attributes attributes);

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public final void characters(char[] cArr, int i, int i2) {
        this.a.append(cArr, i, i2);
    }

    protected final String d() {
        return this.a.toString();
    }

    protected final boolean e(String... strArr) {
        if (strArr.length != this.b.size()) {
            return false;
        }
        Iterator it = this.b.iterator();
        int i = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            String str2 = strArr[i];
            if (!str2.equals("*") && !str2.equals(str)) {
                return false;
            }
            i++;
        }
        return true;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public final void endElement(String str, String str2, String str3) {
        this.b.removeLast();
        b(str, str2, str3);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public final void startElement(String str, String str2, String str3, Attributes attributes) {
        this.a.setLength(0);
        c(str, str2, str3, attributes);
        this.b.add(str2);
    }
}
