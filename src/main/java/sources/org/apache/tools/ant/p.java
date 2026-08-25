package org.apache.tools.ant;

import java.io.File;
import java.util.StringTokenizer;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class p {
    private StringTokenizer a;
    private String b = null;
    private boolean c;
    private boolean d;

    public p(String str) {
        boolean a = lz.a.a("netware");
        this.c = a;
        if (a) {
            this.a = new StringTokenizer(str, ":;", true);
        } else {
            this.a = new StringTokenizer(str, ":;", false);
        }
        this.d = File.pathSeparatorChar == ';';
    }

    public boolean a() {
        if (this.b != null) {
            return true;
        }
        return this.a.hasMoreTokens();
    }

    public String b() {
        String str = this.b;
        if (str != null) {
            this.b = null;
        } else {
            str = this.a.nextToken().trim();
        }
        if (!this.c) {
            if (str.length() != 1 || !Character.isLetter(str.charAt(0)) || !this.d || !this.a.hasMoreTokens()) {
                return str;
            }
            String trim = this.a.nextToken().trim();
            if (!trim.startsWith("\\") && !trim.startsWith("/")) {
                this.b = trim;
                return str;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(":");
            stringBuffer.append(trim);
            return stringBuffer.toString();
        }
        String str2 = File.pathSeparator;
        if (str.equals(str2) || str.equals(":")) {
            str = this.a.nextToken().trim();
        }
        if (!this.a.hasMoreTokens()) {
            return str;
        }
        String trim2 = this.a.nextToken().trim();
        if (trim2.equals(str2)) {
            return str;
        }
        if (!trim2.equals(":")) {
            this.b = trim2;
            return str;
        }
        if (str.startsWith("/") || str.startsWith("\\") || str.startsWith(".") || str.startsWith("..")) {
            return str;
        }
        String trim3 = this.a.nextToken().trim();
        if (!trim3.equals(str2)) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(str);
            stringBuffer2.append(":");
            stringBuffer2.append(trim3);
            return stringBuffer2.toString();
        }
        StringBuffer stringBuffer3 = new StringBuffer();
        stringBuffer3.append(str);
        stringBuffer3.append(":");
        String stringBuffer4 = stringBuffer3.toString();
        this.b = trim3;
        return stringBuffer4;
    }
}
