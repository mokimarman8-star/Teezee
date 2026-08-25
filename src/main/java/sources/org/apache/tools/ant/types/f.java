package org.apache.tools.ant.types;

import org.apache.tools.ant.BuildException;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class f {
    protected String a;
    private int b = -1;

    protected f() {
    }

    public final int a() {
        return this.b;
    }

    public final String b() {
        return this.a;
    }

    public abstract String[] c();

    public final int d(String str) {
        String[] c = c();
        if (c != null && str != null) {
            for (int i = 0; i < c.length; i++) {
                if (str.equals(c[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public final void e(String str) {
        int d = d(str);
        if (d != -1) {
            this.b = d;
            this.a = str;
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(" is not a legal value for this attribute");
            throw new BuildException(stringBuffer.toString());
        }
    }

    public String toString() {
        return b();
    }
}
