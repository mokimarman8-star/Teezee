package com.amazonaws.services.s3.internal;

import com.amazonaws.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class XmlWriter {
    List a = new ArrayList();
    StringBuilder b = new StringBuilder();

    private void a(String str, StringBuilder sb) {
        if (str == null) {
            str = "";
        }
        int length = str.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            String str2 = charAt != '\t' ? charAt != '\n' ? charAt != '\r' ? charAt != '\"' ? charAt != '&' ? charAt != '<' ? charAt != '>' ? null : "&gt;" : "&lt;" : "&amp;" : "&quot;" : "&#13;" : "&#10;" : "&#9;";
            if (str2 != null) {
                if (i2 < i) {
                    sb.append((CharSequence) str, i2, i);
                }
                this.b.append(str2);
                i2 = i + 1;
            }
            i++;
        }
        if (i2 < i) {
            this.b.append((CharSequence) str, i2, i);
        }
    }

    public XmlWriter b() {
        String str = (String) this.a.remove(r0.size() - 1);
        StringBuilder sb = this.b;
        sb.append("</");
        sb.append(str);
        sb.append(">");
        return this;
    }

    public byte[] c() {
        return toString().getBytes(StringUtils.a);
    }

    public XmlWriter d(String str) {
        StringBuilder sb = this.b;
        sb.append("<");
        sb.append(str);
        sb.append(">");
        this.a.add(str);
        return this;
    }

    public XmlWriter e(String str) {
        a(str, this.b);
        return this;
    }

    public String toString() {
        return this.b.toString();
    }
}
