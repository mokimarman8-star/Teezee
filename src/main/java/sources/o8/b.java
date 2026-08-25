package o8;

import com.cloud.tmc.kernel.constants.TmcConstants;
import java.nio.charset.Charset;
import n8.e;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class b {
    public static e a(String str, int i) {
        n8.a a = a.a();
        a.o(i);
        return a.e(str, null);
    }

    public static e b(String str, int i, String str2) {
        n8.a a = a.a();
        a.o(i);
        return a.j(str, "application/json", str2.getBytes(Charset.forName(TmcConstants.DEFAULT_ENCODING)));
    }
}
