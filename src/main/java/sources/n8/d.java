package n8;

import android.util.Log;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.facebook.biddingkit.http.client.HttpMethod;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public abstract class d {
    protected String a;
    protected HttpMethod b;
    protected String c;
    protected byte[] d;

    public d(String str, Map map) {
        this.a = "";
        if (str != null) {
            this.a = str;
        }
        if (map != null) {
            this.a += UrlUtils.QUESTION_MARK + e(map);
        }
    }

    private String e(Map map) {
        StringBuilder sb = new StringBuilder();
        for (String str : map.keySet()) {
            if (sb.length() > 0) {
                sb.append(UrlUtils.AND_MARK);
            }
            sb.append(str);
            String str2 = (String) map.get(str);
            if (str2 != null) {
                sb.append(UrlUtils.EQUAL_MARK);
                try {
                    sb.append(URLEncoder.encode(str2, TmcConstants.DEFAULT_ENCODING));
                } catch (UnsupportedEncodingException e) {
                    Log.e("HttpRequest", "Failed url encode: ", e);
                }
            }
        }
        return sb.toString();
    }

    public byte[] a() {
        return this.d;
    }

    public String b() {
        return this.c;
    }

    public HttpMethod c() {
        return this.b;
    }

    public String d() {
        return this.a;
    }
}
