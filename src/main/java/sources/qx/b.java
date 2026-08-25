package qx;

import com.transsnet.loginapi.bean.UserInfo;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public interface b {

    public static final class a {
        public static void a(b bVar, UserInfo user) {
            Intrinsics.h(user, "user");
        }

        public static void b(b bVar) {
        }

        public static void c(b bVar, UserInfo user) {
            Intrinsics.h(user, "user");
        }
    }

    void onLogin(UserInfo userInfo);

    void onLogout();

    void onUpdateUserInfo(UserInfo userInfo);
}
