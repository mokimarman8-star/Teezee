package org.apache.tools.ant.types;

import java.io.File;
import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Vector;
import org.apache.tools.ant.BuildException;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class i extends e implements Cloneable {
    static /* synthetic */ Class k;
    private String a = "@";
    private String b = "@";
    private boolean c = false;
    private boolean d = true;
    private Hashtable e = null;
    private Vector f = new Vector();
    private b g = b.d;
    private boolean h = false;
    private int i = 0;
    private Vector j = new Vector();

    public static class a {
        String a;
        String b;

        public a() {
        }

        public a(String str, String str2) {
            a(str);
            b(str2);
        }

        public void a(String str) {
            this.a = str;
        }

        public void b(String str) {
            this.b = str;
        }
    }

    public static class b extends f {
        private static final String[] c = {"fail", "warn", "ignore"};
        public static final b d = new b("fail");
        public static final b e = new b("warn");
        public static final b f = new b("ignore");

        public b() {
        }

        public b(String str) {
            e(str);
        }

        @Override // org.apache.tools.ant.types.f
        public String[] c() {
            return c;
        }
    }

    static /* synthetic */ Class d(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    private void h(String str) {
        int a2 = this.g.a();
        if (a2 == 0) {
            throw new BuildException(str);
        }
        if (a2 == 1) {
            log(str, 1);
        } else if (a2 != 2) {
            throw new BuildException("Invalid value for onMissingFiltersFile");
        }
    }

    @Override // org.apache.tools.ant.types.e, org.apache.tools.ant.q
    public synchronized Object clone() {
        if (isReference()) {
            return g().clone();
        }
        try {
            i iVar = (i) super.clone();
            iVar.j = (Vector) e().clone();
            iVar.setProject(getProject());
            return iVar;
        } catch (CloneNotSupportedException e) {
            throw new BuildException(e);
        }
    }

    protected synchronized Vector e() {
        if (isReference()) {
            return g().e();
        }
        if (!this.h) {
            this.h = true;
            int size = this.f.size();
            for (int i = 0; i < size; i++) {
                i((File) this.f.get(i));
            }
            this.f.clear();
            this.h = false;
        }
        return this.j;
    }

    protected i g() {
        Class cls = k;
        if (cls == null) {
            cls = d("org.apache.tools.ant.types.FilterSet");
            k = cls;
        }
        return (i) getCheckedRef(cls, "filterset");
    }

    public synchronized void i(File file) {
        Properties properties;
        FileInputStream fileInputStream;
        try {
            if (isReference()) {
                throw tooManyAttributes();
            }
            if (!file.exists()) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Could not read filters from file ");
                stringBuffer.append(file);
                stringBuffer.append(" as it doesn't exist.");
                h(stringBuffer.toString());
            }
            FileInputStream fileInputStream2 = null;
            if (file.isFile()) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Reading filters from ");
                stringBuffer2.append(file);
                log(stringBuffer2.toString(), 3);
                try {
                    try {
                        properties = new Properties();
                        fileInputStream = new FileInputStream(file);
                    } catch (Exception e) {
                        e = e;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    properties.load(fileInputStream);
                    Enumeration<?> propertyNames = properties.propertyNames();
                    Vector e2 = e();
                    while (propertyNames.hasMoreElements()) {
                        String str = (String) propertyNames.nextElement();
                        e2.addElement(new a(str, properties.getProperty(str)));
                    }
                    org.apache.tools.ant.util.d.b(fileInputStream);
                } catch (Exception e3) {
                    e = e3;
                    fileInputStream2 = fileInputStream;
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append("Could not read filters from file: ");
                    stringBuffer3.append(file);
                    throw new BuildException(stringBuffer3.toString(), e);
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    org.apache.tools.ant.util.d.b(fileInputStream2);
                    throw th;
                }
            } else {
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append("Must specify a file rather than a directory in the filtersfile attribute:");
                stringBuffer4.append(file);
                h(stringBuffer4.toString());
            }
            this.e = null;
        } catch (Throwable th3) {
            throw th3;
        }
    }
}
