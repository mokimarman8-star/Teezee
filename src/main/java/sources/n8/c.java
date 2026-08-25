package n8;

import com.facebook.biddingkit.http.client.HttpMethod;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class c extends d {
    public c(String str, Map map, String str2, byte[] bArr) {
        super(str, map);
        this.b = HttpMethod.POST;
        this.c = str2;
        this.d = bArr;
    }
}
