package kd;

import com.google.zxing.FormatException;
import com.google.zxing.common.CharacterSetECI;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class i {
    private StringBuilder a;
    private StringBuilder b;
    private Charset c;

    public i() {
        this.c = StandardCharsets.ISO_8859_1;
        this.a = new StringBuilder();
    }

    public i(int i) {
        this.c = StandardCharsets.ISO_8859_1;
        this.a = new StringBuilder(i);
    }

    private void g() {
        Charset charset = this.c;
        Charset charset2 = StandardCharsets.ISO_8859_1;
        if (charset.equals(charset2)) {
            if (this.a.length() > 0) {
                StringBuilder sb2 = this.b;
                if (sb2 == null) {
                    this.b = this.a;
                    this.a = new StringBuilder();
                    return;
                } else {
                    sb2.append((CharSequence) this.a);
                    this.a = new StringBuilder();
                    return;
                }
            }
            return;
        }
        if (this.a.length() > 0) {
            byte[] bytes = this.a.toString().getBytes(charset2);
            this.a = new StringBuilder();
            StringBuilder sb3 = this.b;
            if (sb3 == null) {
                this.b = new StringBuilder(new String(bytes, this.c));
            } else {
                sb3.append(new String(bytes, this.c));
            }
        }
    }

    public void a(byte b) {
        this.a.append((char) (b & 255));
    }

    public void b(char c) {
        this.a.append((char) (c & 255));
    }

    public void c(int i) {
        d(String.valueOf(i));
    }

    public void d(String str) {
        this.a.append(str);
    }

    public void e(StringBuilder sb2) {
        g();
        this.b.append((CharSequence) sb2);
    }

    public void f(int i) {
        g();
        CharacterSetECI characterSetECIByValue = CharacterSetECI.getCharacterSetECIByValue(i);
        if (characterSetECIByValue == null) {
            throw FormatException.getFormatInstance();
        }
        this.c = characterSetECIByValue.getCharset();
    }

    public boolean h() {
        StringBuilder sb2;
        return this.a.length() == 0 && ((sb2 = this.b) == null || sb2.length() == 0);
    }

    public int i() {
        return toString().length();
    }

    public String toString() {
        g();
        StringBuilder sb2 = this.b;
        return sb2 == null ? TtmlNode.ANONYMOUS_REGION_ID : sb2.toString();
    }
}
