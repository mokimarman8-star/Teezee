package org.apache.tools.ant.taskdefs;

import java.io.IOException;
import org.apache.tools.ant.q;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class j extends org.apache.tools.ant.util.j {
    private q c;
    private int d;

    public j(q qVar) {
        this.d = 2;
        this.c = qVar;
    }

    public j(q qVar, int i) {
        this(qVar);
        this.d = i;
    }

    @Override // org.apache.tools.ant.util.j
    protected void d() {
        try {
            super.d();
        } catch (IOException e) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Impossible IOException caught: ");
            stringBuffer.append(e);
            throw new RuntimeException(stringBuffer.toString());
        }
    }

    @Override // org.apache.tools.ant.util.j
    protected void f(String str) {
        h(str, this.d);
    }

    protected void h(String str, int i) {
        this.c.log(str, i);
    }
}
