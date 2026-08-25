package org.apache.tools.ant;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class ExitException extends SecurityException {
    private static final long serialVersionUID = 2772487854280543363L;
    private int status;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ExitException(int i) {
        super(r0.toString());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ExitException: status ");
        stringBuffer.append(i);
        this.status = i;
    }

    public ExitException(String str, int i) {
        super(str);
        this.status = i;
    }

    public int getStatus() {
        return this.status;
    }
}
