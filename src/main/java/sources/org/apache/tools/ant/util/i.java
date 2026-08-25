package org.apache.tools.ant.util;

import java.io.IOException;
import java.io.PipedInputStream;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class i extends PipedInputStream {
    private org.apache.tools.ant.q a;

    public void b(String str, int i) {
        org.apache.tools.ant.q qVar = this.a;
        if (qVar != null) {
            qVar.log(str, i);
        } else if (i > 1) {
            System.out.println(str);
        } else {
            System.err.println(str);
        }
    }

    public void d(org.apache.tools.ant.q qVar) {
        this.a = qVar;
    }

    @Override // java.io.PipedInputStream, java.io.InputStream
    public synchronized int read() {
        int i;
        try {
            i = super.read();
        } catch (IOException e) {
            if ("write end dead".equalsIgnoreCase(e.getMessage())) {
                int i2 = ((PipedInputStream) this).in;
                if (i2 > 0) {
                    int i3 = ((PipedInputStream) this).out;
                    byte[] bArr = ((PipedInputStream) this).buffer;
                    if (i3 < bArr.length && i3 > i2) {
                        ((PipedInputStream) this).out = i3 + 1;
                        i = bArr[i3] & 255;
                    }
                }
            } else {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("error at LeadPipeInputStream.read():  ");
                stringBuffer.append(e.getMessage());
                b(stringBuffer.toString(), 2);
            }
            i = -1;
        }
        return i;
    }
}
