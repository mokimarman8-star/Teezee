package ig;

import android.text.TextUtils;
import java.util.List;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class a implements Interceptor {
    public Response intercept(Interceptor.Chain chain) {
        Request request = chain.request();
        HttpUrl url = request.url();
        Request.Builder newBuilder = request.newBuilder();
        List headers = request.headers("multiple_base_url");
        if (!headers.isEmpty()) {
            newBuilder.removeHeader("multiple_base_url");
            String str = (String) headers.get(0);
            HttpUrl parse = !TextUtils.isEmpty(str) ? HttpUrl.parse(str) : url;
            if (parse != null) {
                return chain.proceed(newBuilder.url(url.newBuilder().scheme("https").host(parse.host()).port(parse.port()).build()).build());
            }
        }
        return chain.proceed(request);
    }
}
