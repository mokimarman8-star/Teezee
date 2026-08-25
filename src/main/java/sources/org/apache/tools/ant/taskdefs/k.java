package org.apache.tools.ant.taskdefs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import okhttp3.HttpUrl;
import org.apache.tools.ant.BuildException;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class k {
    private String a;
    private b b = new b();
    private Hashtable c = new Hashtable();
    private Vector d = new Vector();

    public static class a {
        private String a;
        private Vector b;
        private int c;

        public a() {
            this.a = null;
            this.b = new Vector();
            this.c = 0;
        }

        public a(String str) {
            this.a = null;
            this.b = new Vector();
            this.c = 0;
            g(str);
        }

        public a(String str, String str2) {
            this.a = null;
            this.b = new Vector();
            this.c = 0;
            this.a = str;
            h(str2);
        }

        private void j(PrintWriter printWriter, String str) {
            String stringBuffer;
            int length = this.a.getBytes("UTF-8").length;
            if (length <= 68) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append(this.a);
                stringBuffer2.append(": ");
                stringBuffer2.append(str);
                stringBuffer = stringBuffer2.toString();
            } else {
                if (length > 70) {
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append("Unable to write manifest line ");
                    stringBuffer3.append(this.a);
                    stringBuffer3.append(": ");
                    stringBuffer3.append(str);
                    throw new IOException(stringBuffer3.toString());
                }
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append(this.a);
                stringBuffer4.append(": ");
                stringBuffer4.append("\r\n");
                printWriter.print(stringBuffer4.toString());
                StringBuffer stringBuffer5 = new StringBuffer();
                stringBuffer5.append(" ");
                stringBuffer5.append(str);
                stringBuffer = stringBuffer5.toString();
            }
            while (stringBuffer.getBytes("UTF-8").length > 70) {
                int length2 = 70 >= stringBuffer.length() ? stringBuffer.length() - 1 : 70;
                String substring = stringBuffer.substring(0, length2);
                while (substring.getBytes("UTF-8").length > 70 && length2 > 0) {
                    length2--;
                    substring = stringBuffer.substring(0, length2);
                }
                if (length2 == 0) {
                    StringBuffer stringBuffer6 = new StringBuffer();
                    stringBuffer6.append("Unable to write manifest line ");
                    stringBuffer6.append(this.a);
                    stringBuffer6.append(": ");
                    stringBuffer6.append(str);
                    throw new IOException(stringBuffer6.toString());
                }
                StringBuffer stringBuffer7 = new StringBuffer();
                stringBuffer7.append(substring);
                stringBuffer7.append("\r\n");
                printWriter.print(stringBuffer7.toString());
                StringBuffer stringBuffer8 = new StringBuffer();
                stringBuffer8.append(" ");
                stringBuffer8.append(stringBuffer.substring(length2));
                stringBuffer = stringBuffer8.toString();
            }
            StringBuffer stringBuffer9 = new StringBuffer();
            stringBuffer9.append(stringBuffer);
            stringBuffer9.append("\r\n");
            printWriter.print(stringBuffer9.toString());
        }

        public void a(String str) {
            String str2 = (String) this.b.elementAt(this.c);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str2);
            stringBuffer.append(str.substring(1));
            h(stringBuffer.toString());
        }

        public void b(String str) {
            this.c++;
            h(str);
        }

        public String c() {
            String str = this.a;
            if (str == null) {
                return null;
            }
            return str.toLowerCase();
        }

        public String d() {
            return this.a;
        }

        public String e() {
            if (this.b.size() == 0) {
                return null;
            }
            Enumeration f = f();
            String str = HttpUrl.FRAGMENT_ENCODE_SET;
            while (f.hasMoreElements()) {
                String str2 = (String) f.nextElement();
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(str);
                stringBuffer.append(str2);
                stringBuffer.append(" ");
                str = stringBuffer.toString();
            }
            return str.trim();
        }

        public boolean equals(Object obj) {
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            a aVar = (a) obj;
            String c = c();
            String c2 = aVar.c();
            if ((c != null || c2 == null) && (c == null || c.equals(c2))) {
                return this.b.equals(aVar.b);
            }
            return false;
        }

        public Enumeration f() {
            return this.b.elements();
        }

        public void g(String str) {
            int indexOf = str.indexOf(": ");
            if (indexOf != -1) {
                this.a = str.substring(0, indexOf);
                h(str.substring(indexOf + 2));
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Manifest line \"");
            stringBuffer.append(str);
            stringBuffer.append("\" is not valid as it does not ");
            stringBuffer.append("contain a name and a value separated by ': ' ");
            throw new ManifestException(stringBuffer.toString());
        }

        public void h(String str) {
            if (this.c < this.b.size()) {
                this.b.setElementAt(str, this.c);
            } else {
                this.b.addElement(str);
                this.c = this.b.size() - 1;
            }
        }

        public int hashCode() {
            return (this.a != null ? c().hashCode() : 0) + this.b.hashCode();
        }

        public void i(PrintWriter printWriter) {
            Enumeration f = f();
            while (f.hasMoreElements()) {
                j(printWriter, (String) f.nextElement());
            }
        }
    }

    public static class b {
        private Vector a = new Vector();
        private String b = null;
        private Hashtable c = new Hashtable();
        private Vector d = new Vector();

        private void j(a aVar) {
            if (aVar == null) {
                return;
            }
            String c = aVar.c();
            this.c.put(c, aVar);
            if (this.d.contains(c)) {
                return;
            }
            this.d.addElement(c);
        }

        public String a(a aVar) {
            if (aVar.d() == null || aVar.e() == null) {
                throw new BuildException("Attributes must have name and value");
            }
            if (aVar.c().equalsIgnoreCase("Name")) {
                Vector vector = this.a;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("\"Name\" attributes should not occur in the main section and must be the first element in all other sections: \"");
                stringBuffer.append(aVar.d());
                stringBuffer.append(": ");
                stringBuffer.append(aVar.e());
                stringBuffer.append("\"");
                vector.addElement(stringBuffer.toString());
                return aVar.e();
            }
            if (aVar.c().startsWith("From".toLowerCase())) {
                Vector vector2 = this.a;
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Manifest attributes should not start with \"From\" in \"");
                stringBuffer2.append(aVar.d());
                stringBuffer2.append(": ");
                stringBuffer2.append(aVar.e());
                stringBuffer2.append("\"");
                vector2.addElement(stringBuffer2.toString());
                return null;
            }
            String c = aVar.c();
            if (c.equalsIgnoreCase("Class-Path")) {
                a aVar2 = (a) this.c.get(c);
                if (aVar2 == null) {
                    j(aVar);
                    return null;
                }
                this.a.addElement("Multiple Class-Path attributes are supported but violate the Jar specification and may not be correctly processed in all environments");
                Enumeration f = aVar.f();
                while (f.hasMoreElements()) {
                    aVar2.b((String) f.nextElement());
                }
                return null;
            }
            if (!this.c.containsKey(c)) {
                j(aVar);
                return null;
            }
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("The attribute \"");
            stringBuffer3.append(aVar.d());
            stringBuffer3.append("\" may not occur more ");
            stringBuffer3.append("than once in the same section");
            throw new ManifestException(stringBuffer3.toString());
        }

        public void b(a aVar) {
            if (a(aVar) != null) {
                throw new BuildException("Specify the section name using the \"name\" attribute of the <section> element rather than using a \"Name\" manifest attribute");
            }
        }

        public a c(String str) {
            return (a) this.c.get(str.toLowerCase());
        }

        public Object clone() {
            b bVar = new b();
            bVar.i(this.b);
            Enumeration d = d();
            while (d.hasMoreElements()) {
                a c = c((String) d.nextElement());
                bVar.j(new a(c.d(), c.e()));
            }
            return bVar;
        }

        public Enumeration d() {
            return this.d.elements();
        }

        public String e(String str) {
            a c = c(str.toLowerCase());
            if (c == null) {
                return null;
            }
            return c.e();
        }

        public boolean equals(Object obj) {
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            return this.c.equals(((b) obj).c);
        }

        public String f() {
            return this.b;
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x0066, code lost:
        
            return null;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String g(BufferedReader bufferedReader) {
            a aVar = null;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null || readLine.length() == 0) {
                    break;
                }
                if (readLine.charAt(0) != ' ') {
                    a aVar2 = new a(readLine);
                    String a = a(aVar2);
                    aVar = c(aVar2.c());
                    if (a != null) {
                        return a;
                    }
                } else if (aVar != null) {
                    aVar.a(readLine);
                } else {
                    if (this.b == null) {
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("Can't start an attribute with a continuation line ");
                        stringBuffer.append(readLine);
                        throw new ManifestException(stringBuffer.toString());
                    }
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append(this.b);
                    stringBuffer2.append(readLine.substring(1));
                    this.b = stringBuffer2.toString();
                }
            }
        }

        public void h(String str) {
            String lowerCase = str.toLowerCase();
            this.c.remove(lowerCase);
            this.d.removeElement(lowerCase);
        }

        public int hashCode() {
            return this.c.hashCode();
        }

        public void i(String str) {
            this.b = str;
        }

        public void k(PrintWriter printWriter) {
            String str = this.b;
            if (str != null) {
                new a("Name", str).i(printWriter);
            }
            Enumeration d = d();
            while (d.hasMoreElements()) {
                c((String) d.nextElement()).i(printWriter);
            }
            printWriter.print("\r\n");
        }
    }

    public k() {
        this.a = "1.0";
        this.a = null;
    }

    public k(Reader reader) {
        this.a = "1.0";
        BufferedReader bufferedReader = new BufferedReader(reader);
        String g = this.b.g(bufferedReader);
        String e = this.b.e("Manifest-Version");
        if (e != null) {
            this.a = e;
            this.b.h("Manifest-Version");
        }
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return;
            }
            if (readLine.length() != 0) {
                b bVar = new b();
                if (g == null) {
                    a aVar = new a(readLine);
                    if (!aVar.d().equalsIgnoreCase("Name")) {
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("Manifest sections should start with a \"Name\" attribute and not \"");
                        stringBuffer.append(aVar.d());
                        stringBuffer.append("\"");
                        throw new ManifestException(stringBuffer.toString());
                    }
                    g = aVar.e();
                } else {
                    bVar.a(new a(readLine));
                }
                bVar.i(g);
                g = bVar.g(bufferedReader);
                a(bVar);
            }
        }
    }

    public void a(b bVar) {
        String f = bVar.f();
        if (f == null) {
            throw new BuildException("Sections must have a name");
        }
        this.c.put(f, bVar);
        if (this.d.contains(f)) {
            return;
        }
        this.d.addElement(f);
    }

    public b b() {
        return this.b;
    }

    public b c(String str) {
        return (b) this.c.get(str);
    }

    public void d(PrintWriter printWriter) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Manifest-Version: ");
        stringBuffer.append(this.a);
        stringBuffer.append("\r\n");
        printWriter.print(stringBuffer.toString());
        String e = this.b.e("Signature-Version");
        if (e != null) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Signature-Version: ");
            stringBuffer2.append(e);
            stringBuffer2.append("\r\n");
            printWriter.print(stringBuffer2.toString());
            this.b.h("Signature-Version");
        }
        this.b.k(printWriter);
        if (e != null) {
            try {
                this.b.b(new a("Signature-Version", e));
            } catch (ManifestException unused) {
            }
        }
        Enumeration elements = this.d.elements();
        while (elements.hasMoreElements()) {
            c((String) elements.nextElement()).k(printWriter);
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        k kVar = (k) obj;
        String str = this.a;
        if (str == null) {
            if (kVar.a != null) {
                return false;
            }
        } else if (!str.equals(kVar.a)) {
            return false;
        }
        if (this.b.equals(kVar.b)) {
            return this.c.equals(kVar.c);
        }
        return false;
    }

    public int hashCode() {
        String str = this.a;
        return (str != null ? str.hashCode() : 0) + this.b.hashCode() + this.c.hashCode();
    }

    public String toString() {
        StringWriter stringWriter = new StringWriter();
        try {
            d(new PrintWriter(stringWriter));
            return stringWriter.toString();
        } catch (IOException unused) {
            return null;
        }
    }
}
