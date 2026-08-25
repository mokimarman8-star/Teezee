package com.transsion.usercenter.profile;

import androidx.annotation.Keep;
import com.therouter.TheRouter;
import com.transsnet.loginapi.bean.UserInfo;
import java.util.Iterator;
import okhttp3.HttpUrl;

@Keep
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class ProfileActivity__TheRouter__Autowired {
    public static final String TAG = "Created by kymjs, and APT Version is 1.3.0.";
    public static final String THEROUTER_APT_VERSION = "1.3.0";

    public static void autowiredInject(Object obj) {
        if (obj instanceof ProfileActivity) {
            ProfileActivity profileActivity = (ProfileActivity) obj;
            Iterator it = TheRouter.g().iterator();
            while (it.hasNext()) {
                mf.a aVar = (mf.a) it.next();
                try {
                    UserInfo userInfo = (UserInfo) aVar.a("com.transsnet.loginapi.bean.UserInfo", profileActivity, new com.therouter.router.b("com.transsnet.loginapi.bean.UserInfo", "userInfo", 0, HttpUrl.FRAGMENT_ENCODE_SET, "com.transsion.usercenter.profile.ProfileActivity", "userInfo", false, "No desc."));
                    if (userInfo != null) {
                        profileActivity.userInfo = userInfo;
                    }
                } catch (Exception e) {
                    if (TheRouter.m()) {
                        e.printStackTrace();
                    }
                }
                try {
                    String str = (String) aVar.a("java.lang.String", profileActivity, new com.therouter.router.b("java.lang.String", "userId", 0, HttpUrl.FRAGMENT_ENCODE_SET, "com.transsion.usercenter.profile.ProfileActivity", "userId", false, "No desc."));
                    if (str != null) {
                        profileActivity.userId = str;
                    }
                } catch (Exception e2) {
                    if (TheRouter.m()) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }
}
