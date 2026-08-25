package tt;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class g extends e {
    String d;

    public g(String str, String str2) {
        super(str, str2.getBytes().length, null);
        this.d = str2;
    }

    @Override // tt.e
    protected InputStream e() {
        return new ByteArrayInputStream(this.d.getBytes());
    }

    public String toString() {
        return this.d;
    }
}
