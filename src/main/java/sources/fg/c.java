package fg;

import android.text.TextUtils;
import com.blankj.utilcode.util.o;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.lang.reflect.Type;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.Okio;
import retrofit2.k;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class c implements k {
    private final Type a;
    private final String b;
    private final String d = "{\"code\":200005,\"data\":{},\"msg\":\"unknown error\"}";
    private Gson c = new Gson();

    public c(Type type, String str) {
        this.a = type;
        this.b = str;
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Object convert(ResponseBody responseBody) {
        BufferedSource buffer = Okio.buffer(responseBody.source());
        String readUtf8 = buffer.readUtf8();
        wf.a.a.c("HttpTag", "Converter origin json:" + readUtf8, false);
        buffer.close();
        if (TextUtils.equals(this.b, "1311")) {
            return readUtf8;
        }
        try {
            return o.e(readUtf8, this.a);
        } catch (JsonSyntaxException e) {
            wf.a.a.i("HttpTag", "error =" + e.getMessage() + "json= " + readUtf8, true);
            return this.c.fromJson(readUtf8, this.a);
        }
    }
}
