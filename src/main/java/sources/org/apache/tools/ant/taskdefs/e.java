package org.apache.tools.ant.taskdefs;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.ComponentHelper;
import org.apache.tools.ant.r;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class e extends c {
    private static b w = new b(null);
    private String k;
    private String l;
    private File m;
    private String n;
    private int o = 0;
    private boolean p = false;
    private int q = 0;
    private String r;
    private String s;
    private Class t;
    private Class u;

    public static class a extends org.apache.tools.ant.types.f {
        public a() {
        }

        public a(String str) {
            e(str);
        }

        @Override // org.apache.tools.ant.types.f
        public String[] c() {
            return new String[]{"fail", "report", "ignore", "failall"};
        }
    }

    private static class b extends ThreadLocal {
        private b() {
        }

        /* synthetic */ b(d dVar) {
            this();
        }

        Map a() {
            return (Map) get();
        }

        @Override // java.lang.ThreadLocal
        public Object initialValue() {
            return new HashMap();
        }
    }

    private URL B() {
        String str;
        if (this.m.exists()) {
            str = null;
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("File ");
            stringBuffer.append(this.m);
            stringBuffer.append(" does not exist");
            str = stringBuffer.toString();
        }
        if (str == null && !this.m.isFile()) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("File ");
            stringBuffer2.append(this.m);
            stringBuffer2.append(" is not a file");
            str = stringBuffer2.toString();
        }
        if (str == null) {
            try {
                return this.m.toURL();
            } catch (Exception e) {
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("File ");
                stringBuffer3.append(this.m);
                stringBuffer3.append(" cannot use as URL: ");
                stringBuffer3.append(e.toString());
                str = stringBuffer3.toString();
            }
        }
        int i = this.q;
        if (i == 0 || i == 1) {
            log(str, 1);
        } else if (i == 2) {
            log(str, 3);
        } else if (i == 3) {
            throw new BuildException(str);
        }
        return null;
    }

    private void C(ClassLoader classLoader, URL url) {
        try {
            org.apache.tools.ant.taskdefs.a v = org.apache.tools.ant.taskdefs.a.v(getProject(), url, v());
            v.x(classLoader);
            v.y(v());
            v.e();
        } catch (BuildException e) {
            throw r.a(e, getLocation());
        }
    }

    public static String E(String str) {
        String substring = str.substring(7);
        if (!substring.startsWith("//")) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(substring.replace('.', '/'));
            stringBuffer.append("/antlib.xml");
            return stringBuffer.toString();
        }
        String substring2 = substring.substring(2);
        if (substring2.endsWith(".xml")) {
            return substring2;
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(substring2);
        stringBuffer2.append("/antlib.xml");
        return stringBuffer2.toString();
    }

    private Enumeration F(ClassLoader classLoader) {
        try {
            Enumeration<URL> resources = classLoader.getResources(this.n);
            if (!resources.hasMoreElements()) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Could not load definitions from resource ");
                stringBuffer.append(this.n);
                stringBuffer.append(". It could not be found.");
                String stringBuffer2 = stringBuffer.toString();
                int i = this.q;
                if (i == 0 || i == 1) {
                    log(stringBuffer2, 1);
                } else if (i == 2) {
                    log(stringBuffer2, 3);
                } else if (i == 3) {
                    throw new BuildException(stringBuffer2);
                }
            }
            return resources;
        } catch (IOException e) {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("Could not fetch resources named ");
            stringBuffer3.append(this.n);
            throw new BuildException(stringBuffer3.toString(), e, getLocation());
        }
    }

    private void I() {
        throw new BuildException("Only one of the attributes name, file and resource can be set", getLocation());
    }

    protected void A(ClassLoader classLoader, String str, String str2) {
        try {
            try {
                String e = r.e(v(), str);
                Class<?> cls = this.q != 2 ? Class.forName(str2, true, classLoader) : null;
                String str3 = this.r;
                if (str3 != null) {
                    this.t = Class.forName(str3, true, classLoader);
                }
                String str4 = this.s;
                if (str4 != null) {
                    this.u = Class.forName(str4, true, classLoader);
                }
                org.apache.tools.ant.b bVar = new org.apache.tools.ant.b();
                bVar.t(e);
                bVar.s(str2);
                bVar.q(cls);
                bVar.p(this.t);
                bVar.o(this.u);
                bVar.r(classLoader);
                if (cls != null) {
                    bVar.a(getProject());
                }
                ComponentHelper.j(getProject()).a(bVar);
            } catch (ClassNotFoundException e2) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(j());
                stringBuffer.append(" class ");
                stringBuffer.append(str2);
                stringBuffer.append(" cannot be found");
                throw new BuildException(stringBuffer.toString(), e2, getLocation());
            } catch (NoClassDefFoundError e3) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append(j());
                stringBuffer2.append(" A class needed by class ");
                stringBuffer2.append(str2);
                stringBuffer2.append(" cannot be found: ");
                stringBuffer2.append(e3.getMessage());
                throw new BuildException(stringBuffer2.toString(), e3, getLocation());
            }
        } catch (BuildException e4) {
            int i = this.q;
            if (i != 0) {
                if (i == 1) {
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append(e4.getLocation());
                    stringBuffer3.append("Warning: ");
                    stringBuffer3.append(e4.getMessage());
                    log(stringBuffer3.toString(), 1);
                    return;
                }
                if (i != 3) {
                    StringBuffer stringBuffer4 = new StringBuffer();
                    stringBuffer4.append(e4.getLocation());
                    stringBuffer4.append(e4.getMessage());
                    log(stringBuffer4.toString(), 4);
                    return;
                }
            }
            throw e4;
        }
    }

    protected void D(ClassLoader classLoader, URL url) {
        try {
            try {
                InputStream openStream = FirebasePerfUrlConnection.openStream(url);
                if (openStream == null) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Could not load definitions from ");
                    stringBuffer.append(url);
                    log(stringBuffer.toString(), 1);
                    org.apache.tools.ant.util.d.b(openStream);
                    return;
                }
                Properties properties = new Properties();
                properties.load(openStream);
                Enumeration keys = properties.keys();
                while (keys.hasMoreElements()) {
                    String str = (String) keys.nextElement();
                    this.k = str;
                    String property = properties.getProperty(str);
                    this.l = property;
                    A(classLoader, this.k, property);
                }
                org.apache.tools.ant.util.d.b(openStream);
            } catch (IOException e) {
                throw new BuildException(e, getLocation());
            }
        } catch (Throwable th) {
            org.apache.tools.ant.util.d.b(null);
            throw th;
        }
    }

    public void G(a aVar) {
        this.q = aVar.a();
    }

    public void H(String str) {
        if (this.p) {
            I();
        }
        this.p = true;
        this.n = str;
    }

    @Override // org.apache.tools.ant.u
    public void e() {
        Enumeration F;
        ClassLoader y = y();
        if (!this.p) {
            if (v() == null) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("name, file or resource attribute of ");
                stringBuffer.append(j());
                stringBuffer.append(" is undefined");
                throw new BuildException(stringBuffer.toString(), getLocation());
            }
            if (!v().startsWith("antlib:")) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Only antlib URIs can be located from the URI alone,not the URI ");
                stringBuffer2.append(v());
                throw new BuildException(stringBuffer2.toString());
            }
            H(E(v()));
        }
        String str = this.k;
        if (str != null) {
            String str2 = this.l;
            if (str2 != null) {
                A(y, str, str2);
                return;
            }
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("classname attribute of ");
            stringBuffer3.append(j());
            stringBuffer3.append(" element ");
            stringBuffer3.append("is undefined");
            throw new BuildException(stringBuffer3.toString(), getLocation());
        }
        if (this.l != null) {
            throw new BuildException("You must not specify classname together with file or resource.", getLocation());
        }
        if (this.m != null) {
            URL B = B();
            if (B == null) {
                return;
            } else {
                F = new d(this, B);
            }
        } else {
            F = F(y);
        }
        while (F.hasMoreElements()) {
            URL url = (URL) F.nextElement();
            int i = this.o;
            if (url.toString().toLowerCase(Locale.US).endsWith(".xml")) {
                i = 1;
            }
            if (i == 0) {
                D(y, url);
                return;
            }
            if (w.a().get(url) != null) {
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append("Warning: Recursive loading of ");
                stringBuffer4.append(url);
                stringBuffer4.append(" ignored");
                stringBuffer4.append(" at ");
                stringBuffer4.append(getLocation());
                stringBuffer4.append(" originally loaded at ");
                stringBuffer4.append(w.a().get(url));
                log(stringBuffer4.toString(), 1);
            } else {
                try {
                    w.a().put(url, getLocation());
                    C(y, url);
                } finally {
                    w.a().remove(url);
                }
            }
        }
    }
}
