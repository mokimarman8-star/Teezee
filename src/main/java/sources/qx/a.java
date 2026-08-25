package qx;

import android.content.Context;
import android.content.Intent;
import com.transsnet.loginapi.bean.Country;
import com.transsnet.loginapi.bean.UserInfo;
import kotlin.coroutines.Continuation;
import okhttp3.Response;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public interface a {
    boolean a();

    String b();

    void c(UserInfo userInfo);

    void d();

    void e(b bVar);

    Country f();

    void g(String str);

    void h(Response response);

    UserInfo i();

    void j(b bVar);

    void k(Context context);

    void l(Context context);

    Object m(UserInfo userInfo, Continuation continuation);

    void n(long j);

    long o();

    Intent p(Context context);
}
