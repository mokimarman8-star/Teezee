package org.apache.tools.ant.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Vector;
import okhttp3.HttpUrl;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class f {
    private static final boolean a = lz.a.a("dos");
    private static final boolean b = lz.a.b("netware");
    private static final boolean c = lz.a.b("aix");
    private static final String d = System.getProperty("java.home");
    private static final d e = d.k();
    private static String f;
    private static int g;
    private static boolean h;
    private static Vector i;

    static {
        try {
            f = "1.1";
            g = 10 + 1;
            Class.forName("java.lang.ThreadLocal");
            f = "1.2";
            g++;
            Class.forName("java.lang.StrictMath");
            int i2 = g;
            f = "1.4";
            g = i2 + 2;
            Class.forName("java.net.Proxy");
            f = "1.5";
            g++;
            Class.forName("java.util.ServiceLoader");
            f = "1.6";
            g++;
        } catch (Throwable unused) {
        }
        h = false;
        try {
            Class.forName("kaffe.util.NotImplemented");
            h = true;
        } catch (Throwable unused2) {
        }
    }

    private static String a(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(a ? ".exe" : HttpUrl.FRAGMENT_ENCODE_SET);
        return stringBuffer.toString();
    }

    private static void b() {
        Vector vector = new Vector();
        i = vector;
        switch (g) {
            case 15:
            case 16:
                vector.addElement("com.sun.org.apache");
            case 14:
                if (g == 14) {
                    i.addElement("org.apache.crimson");
                    i.addElement("org.apache.xalan");
                    i.addElement("org.apache.xml");
                    i.addElement("org.apache.xpath");
                }
                i.addElement("org.ietf.jgss");
                i.addElement("org.w3c.dom");
                i.addElement("org.xml.sax");
            case 13:
                i.addElement("org.omg");
                i.addElement("com.sun.corba");
                i.addElement("com.sun.jndi");
                i.addElement("com.sun.media");
                i.addElement("com.sun.naming");
                i.addElement("com.sun.org.omg");
                i.addElement("com.sun.rmi");
                i.addElement("sunw.io");
                i.addElement("sunw.util");
            case 12:
                i.addElement("com.sun.java");
                i.addElement("com.sun.image");
                break;
        }
        i.addElement("sun");
        i.addElement("java");
        i.addElement("javax");
    }

    public static File c(String[] strArr) {
        File f2 = e.f("ANT", ".JAVA_OPTS", null, false, true);
        PrintWriter printWriter = null;
        try {
            PrintWriter printWriter2 = new PrintWriter(new BufferedWriter(new FileWriter(f2)));
            for (String str : strArr) {
                try {
                    printWriter2.println(str);
                } catch (Throwable th) {
                    th = th;
                    printWriter = printWriter2;
                    d.e(printWriter);
                    throw th;
                }
            }
            d.e(printWriter2);
            return f2;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static File d(String str, String str2) {
        File o = e.o(str);
        if (!o.exists()) {
            return null;
        }
        File file = new File(o, a(str2));
        if (file.exists()) {
            return file;
        }
        return null;
    }

    public static String e() {
        return f;
    }

    public static int f() {
        return g;
    }

    public static String g(String str) {
        File file;
        if (b) {
            return str;
        }
        if (c) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(d);
            stringBuffer.append("/sh");
            file = d(stringBuffer.toString(), str);
        } else {
            file = null;
        }
        if (file == null) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(d);
            stringBuffer2.append("/bin");
            file = d(stringBuffer2.toString(), str);
        }
        return file != null ? file.getAbsolutePath() : a(str);
    }

    public static Vector h() {
        if (i == null) {
            b();
        }
        return i;
    }
}
