package com.transsion.usercenter.profile;

import androidx.annotation.Keep;
import com.therouter.TheRouter;
import java.util.Iterator;
import okhttp3.HttpUrl;

@Keep
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class UserProfileActivity__TheRouter__Autowired {
    public static final String TAG = "Created by kymjs, and APT Version is 1.3.0.";
    public static final String THEROUTER_APT_VERSION = "1.3.0";

    public static void autowiredInject(Object obj) {
        if (obj instanceof UserProfileActivity) {
            UserProfileActivity userProfileActivity = (UserProfileActivity) obj;
            Iterator it = TheRouter.g().iterator();
            while (it.hasNext()) {
                mf.a aVar = (mf.a) it.next();
                try {
                    String str = (String) aVar.a("java.lang.String", userProfileActivity, new com.therouter.router.b("java.lang.String", "fromOptId", 0, HttpUrl.FRAGMENT_ENCODE_SET, "com.transsion.usercenter.profile.UserProfileActivity", "fromOptId", false, "No desc."));
                    if (str != null) {
                        userProfileActivity.fromOptId = str;
                    }
                } catch (Exception e) {
                    if (TheRouter.m()) {
                        e.printStackTrace();
                    }
                }
                try {
                    String str2 = (String) aVar.a("java.lang.String", userProfileActivity, new com.therouter.router.b("java.lang.String", "userId", 0, HttpUrl.FRAGMENT_ENCODE_SET, "com.transsion.usercenter.profile.UserProfileActivity", "userId", false, "No desc."));
                    if (str2 != null) {
                        userProfileActivity.userId = str2;
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
