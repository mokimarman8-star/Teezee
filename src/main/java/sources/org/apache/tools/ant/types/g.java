package org.apache.tools.ant.types;

import java.util.Vector;
import org.apache.tools.ant.BuildException;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class g {
    protected Vector a = new Vector();

    public static class a {
        private String a;
        private String b;

        public String a() {
            d();
            StringBuffer stringBuffer = new StringBuffer(this.a.trim());
            stringBuffer.append("=");
            stringBuffer.append(this.b.trim());
            return stringBuffer.toString();
        }

        public String b() {
            return this.a;
        }

        public String c() {
            return this.b;
        }

        public void d() {
            if (this.a == null || this.b == null) {
                throw new BuildException("key and value must be specified for environment variables.");
            }
        }
    }

    public String[] a() {
        if (this.a.size() == 0) {
            return null;
        }
        int size = this.a.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = ((a) this.a.elementAt(i)).a();
        }
        return strArr;
    }
}
