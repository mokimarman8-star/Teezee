package com.transsion.usercenter.message.detail;

import androidx.annotation.Keep;
import com.therouter.TheRouter;
import com.therouter.router.b;
import java.util.Iterator;
import mf.a;
import okhttp3.HttpUrl;

@Keep
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class MessageDetailActivity__TheRouter__Autowired {
    public static final String TAG = "Created by kymjs, and APT Version is 1.3.0.";
    public static final String THEROUTER_APT_VERSION = "1.3.0";

    public static void autowiredInject(Object obj) {
        if (obj instanceof MessageDetailActivity) {
            MessageDetailActivity messageDetailActivity = (MessageDetailActivity) obj;
            Iterator it = TheRouter.g().iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                try {
                    String str = (String) aVar.a("java.lang.String", messageDetailActivity, new b("java.lang.String", "msg_content", 0, HttpUrl.FRAGMENT_ENCODE_SET, "com.transsion.usercenter.message.detail.MessageDetailActivity", "msgContent", false, "No desc."));
                    if (str != null) {
                        messageDetailActivity.msgContent = str;
                    }
                } catch (Exception e) {
                    if (TheRouter.m()) {
                        e.printStackTrace();
                    }
                }
                try {
                    String str2 = (String) aVar.a("java.lang.String", messageDetailActivity, new b("java.lang.String", "msg_create_time", 0, HttpUrl.FRAGMENT_ENCODE_SET, "com.transsion.usercenter.message.detail.MessageDetailActivity", "createTime", false, "No desc."));
                    if (str2 != null) {
                        messageDetailActivity.createTime = str2;
                    }
                } catch (Exception e2) {
                    if (TheRouter.m()) {
                        e2.printStackTrace();
                    }
                }
                try {
                    String str3 = (String) aVar.a("java.lang.String", messageDetailActivity, new b("java.lang.String", "msg_nickname", 0, HttpUrl.FRAGMENT_ENCODE_SET, "com.transsion.usercenter.message.detail.MessageDetailActivity", "nickName", false, "No desc."));
                    if (str3 != null) {
                        messageDetailActivity.nickName = str3;
                    }
                } catch (Exception e3) {
                    if (TheRouter.m()) {
                        e3.printStackTrace();
                    }
                }
            }
        }
    }
}
