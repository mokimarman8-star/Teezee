package hg;

import android.net.ParseException;
import android.text.TextUtils;
import android.util.MalformedJsonException;
import com.blankj.utilcode.util.o;
import com.google.gson.JsonParseException;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.net.exception.ApiException;
import com.tn.lib.net.exception.ServerException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.ResponseBody;
import org.json.JSONException;
import retrofit2.HttpException;
import retrofit2.j0;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class a {
    public static final C0143a a = new C0143a(null);
    private static final int b = 1000;
    private static final int c = 110004;
    private static final int d = 9003;
    private static final int e = 1102;
    private static final int f = 11000;
    private static final int g = 11001;
    private static final int h = 1032;
    private static final int i = 60002;

    /* renamed from: hg.a$a, reason: collision with other inner class name */
    public static final class C0143a {
        private C0143a() {
        }

        public /* synthetic */ C0143a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ApiException a(Throwable th) {
            ApiException apiException;
            ResponseBody d;
            if (th instanceof HttpException) {
                HttpException httpException = (HttpException) th;
                j0 response = httpException.response();
                BaseDto baseDto = (BaseDto) o.d((response == null || (d = response.d()) == null) ? null : d.string(), BaseDto.class);
                if (baseDto == null) {
                    return new ApiException(th, String.valueOf(httpException.code()), httpException.message());
                }
                if (TextUtils.isEmpty(baseDto.getMsg())) {
                    baseDto.setMsg("Oops，something went wrong");
                }
                return new ApiException(th, String.valueOf(httpException.code()), baseDto.getMsg());
            }
            if (th instanceof ServerException) {
                ServerException serverException = (ServerException) th;
                return new ApiException(th, serverException.getErrCode(), serverException.getErrMsg());
            }
            if ((th instanceof JsonParseException) || (th instanceof JSONException) || (th instanceof ParseException) || (th instanceof MalformedJsonException)) {
                apiException = new ApiException(th, String.valueOf(a.f), "Oops，something went wrong");
            } else if (th instanceof ConnectException) {
                apiException = new ApiException(th, String.valueOf(a.d), "Oops，something went wrong");
            } else if (th instanceof SocketTimeoutException) {
                apiException = new ApiException(th, String.valueOf(a.i), "Oops，something went wrong");
            } else if (th instanceof UnknownHostException) {
                apiException = new ApiException(th, String.valueOf(a.d), "Oops，something went wrong");
            } else {
                if (th == null) {
                    throw new RuntimeException("未知异常");
                }
                apiException = new ApiException(th, String.valueOf(a.b), "Oops，something went wrong");
            }
            return apiException;
        }
    }
}
