package org.apache.tools.ant.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class c extends InputStream {
    private int a = -1;
    private boolean b = false;
    private File[] c;
    private InputStream d;
    private org.apache.tools.ant.q e;

    public c(File[] fileArr) {
        this.c = fileArr;
    }

    private void d() {
        d.b(this.d);
        this.d = null;
    }

    private void h(int i) {
        d();
        File[] fileArr = this.c;
        if (fileArr == null || i >= fileArr.length) {
            this.b = true;
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Opening ");
        stringBuffer.append(this.c[i]);
        f(stringBuffer.toString(), 3);
        try {
            this.d = new BufferedInputStream(new FileInputStream(this.c[i]));
        } catch (IOException e) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Failed to open ");
            stringBuffer2.append(this.c[i]);
            f(stringBuffer2.toString(), 0);
            throw e;
        }
    }

    private int k() {
        InputStream inputStream;
        if (this.b || (inputStream = this.d) == null) {
            return -1;
        }
        return inputStream.read();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        d();
        this.b = true;
    }

    public void f(String str, int i) {
        org.apache.tools.ant.q qVar = this.e;
        if (qVar != null) {
            qVar.log(str, i);
        } else if (i > 1) {
            System.out.println(str);
        } else {
            System.err.println(str);
        }
    }

    public void l(org.apache.tools.ant.q qVar) {
        this.e = qVar;
    }

    @Override // java.io.InputStream
    public int read() {
        int k = k();
        if (k != -1 || this.b) {
            return k;
        }
        int i = this.a + 1;
        this.a = i;
        h(i);
        return k();
    }
}
