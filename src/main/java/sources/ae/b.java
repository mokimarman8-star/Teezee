package ae;

import com.google.logging.type.LogSeverity;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.g;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class b {
    private Mode a;
    private ErrorCorrectionLevel b;
    private g c;
    private int d = -1;
    private a e;

    public static boolean b(int i) {
        return i >= 0 && i < 8;
    }

    public a a() {
        return this.e;
    }

    public void c(ErrorCorrectionLevel errorCorrectionLevel) {
        this.b = errorCorrectionLevel;
    }

    public void d(int i) {
        this.d = i;
    }

    public void e(a aVar) {
        this.e = aVar;
    }

    public void f(Mode mode) {
        this.a = mode;
    }

    public void g(g gVar) {
        this.c = gVar;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(LogSeverity.INFO_VALUE);
        sb2.append("<<\n");
        sb2.append(" mode: ");
        sb2.append(this.a);
        sb2.append("\n ecLevel: ");
        sb2.append(this.b);
        sb2.append("\n version: ");
        sb2.append(this.c);
        sb2.append("\n maskPattern: ");
        sb2.append(this.d);
        if (this.e == null) {
            sb2.append("\n matrix: null\n");
        } else {
            sb2.append("\n matrix:\n");
            sb2.append(this.e);
        }
        sb2.append(">>\n");
        return sb2.toString();
    }
}
