package org.apache.tools.ant.types;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Vector;
import okhttp3.HttpUrl;
import org.apache.tools.ant.BuildException;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class c implements Cloneable {
    private static final boolean c = lz.a.a("win9x");
    protected static final String d;
    private Vector a = new Vector();
    private String b = null;

    public static class a extends org.apache.tools.ant.q {
        private String[] a;

        public String[] e() {
            return this.a;
        }

        public void g(String str) {
            this.a = new String[]{str};
        }
    }

    static {
        StringBuffer stringBuffer = new StringBuffer();
        String str = org.apache.tools.ant.util.p.a;
        stringBuffer.append(str);
        stringBuffer.append("The ' characters around the executable and arguments are");
        stringBuffer.append(str);
        stringBuffer.append("not part of the command.");
        stringBuffer.append(str);
        d = stringBuffer.toString();
    }

    protected static String e(String[] strArr, int i) {
        if (strArr == null || strArr.length <= i) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        StringBuffer stringBuffer = new StringBuffer("argument");
        if (strArr.length > i) {
            stringBuffer.append("s");
        }
        stringBuffer.append(":");
        stringBuffer.append(org.apache.tools.ant.util.p.a);
        while (i < strArr.length) {
            stringBuffer.append("'");
            stringBuffer.append(strArr[i]);
            stringBuffer.append("'");
            stringBuffer.append(org.apache.tools.ant.util.p.a);
            i++;
        }
        stringBuffer.append(d);
        return stringBuffer.toString();
    }

    public static String g(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        StringBuffer stringBuffer = new StringBuffer("Executing '");
        stringBuffer.append(strArr[0]);
        stringBuffer.append("'");
        if (strArr.length > 1) {
            stringBuffer.append(" with ");
            stringBuffer.append(e(strArr, 1));
        } else {
            stringBuffer.append(d);
        }
        return stringBuffer.toString();
    }

    public static String l(String str) {
        if (str.indexOf("\"") > -1) {
            if (str.indexOf("'") > -1) {
                throw new BuildException("Can't handle single and double quotes in same argument");
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append('\'');
            stringBuffer.append(str);
            stringBuffer.append('\'');
            return stringBuffer.toString();
        }
        if (str.indexOf("'") <= -1 && str.indexOf(" ") <= -1 && (!c || str.indexOf(59) == -1)) {
            return str;
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append('\"');
        stringBuffer2.append(str);
        stringBuffer2.append('\"');
        return stringBuffer2.toString();
    }

    public static String n(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < strArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(' ');
            }
            stringBuffer.append(l(strArr[i]));
        }
        return stringBuffer.toString();
    }

    public void a(ListIterator listIterator) {
        for (int i = 0; i < this.a.size(); i++) {
            String[] e = ((a) this.a.elementAt(i)).e();
            if (e != null) {
                for (String str : e) {
                    listIterator.add(str);
                }
            }
        }
    }

    public void b(ListIterator listIterator) {
        String str = this.b;
        if (str != null) {
            listIterator.add(str);
        }
        a(listIterator);
    }

    public a c() {
        return d(false);
    }

    public Object clone() {
        try {
            c cVar = (c) super.clone();
            cVar.a = (Vector) this.a.clone();
            return cVar;
        } catch (CloneNotSupportedException e) {
            throw new BuildException(e);
        }
    }

    public a d(boolean z) {
        a aVar = new a();
        if (z) {
            this.a.insertElementAt(aVar, 0);
        } else {
            this.a.addElement(aVar);
        }
        return aVar;
    }

    public String[] i() {
        ArrayList arrayList = new ArrayList(this.a.size() * 2);
        a(arrayList.listIterator());
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public String[] j() {
        LinkedList linkedList = new LinkedList();
        b(linkedList.listIterator());
        return (String[]) linkedList.toArray(new String[linkedList.size()]);
    }

    public String k() {
        return this.b;
    }

    public void m(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        char c2 = File.separatorChar;
        this.b = str.replace('/', c2).replace('\\', c2);
    }

    public String toString() {
        return n(j());
    }
}
