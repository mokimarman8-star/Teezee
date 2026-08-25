package org.apache.tools.ant.taskdefs;

import okhttp3.HttpUrl;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.u;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class b extends u {
    private String g = HttpUrl.FRAGMENT_ENCODE_SET;
    private ClassLoader h;

    public ClassLoader u() {
        return this.h;
    }

    public String v() {
        return this.g;
    }

    public void w(ClassLoader classLoader) {
        this.h = classLoader;
    }

    public void x(String str) {
        if (str.equals("antlib:org.apache.tools.ant")) {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        if (!str.startsWith("ant:")) {
            this.g = str;
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Attempt to use a reserved URI ");
        stringBuffer.append(str);
        throw new BuildException(stringBuffer.toString());
    }
}
