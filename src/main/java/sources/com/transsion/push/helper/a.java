package com.transsion.push.helper;

import android.net.Uri;
import androidx.core.app.t;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.notification.MsgBean;
import com.transsion.gslb.BuildConfig;
import com.transsion.push.PushConstants;
import com.transsion.push.PushManager;
import com.transsion.push.bean.MsgShowStatus;
import com.transsion.push.bean.MsgStyle;
import com.transsion.push.bean.PushConfigHelper;
import com.transsion.push.bean.PushSimbaConfig;
import ij.v;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a {
    public static final a a = new a();

    private a() {
    }

    public final void a(String str, String str2, String str3, String str4, Uri uri, boolean z, String str5, String str6, String str7) {
        Intrinsics.h(str6, "moduleName");
        boolean e = e();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (str7 == null) {
            str7 = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("screen_status", str7);
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        linkedHashMap.put(PushConstants.EXTRA_PUSH_MESSAGE_ID, str);
        if (str2 == null) {
            str2 = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("channel_id", str2);
        if (str3 == null) {
            str3 = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("source", str3);
        if (str4 == null) {
            str4 = BuildConfig.FLAVOR;
        }
        linkedHashMap.put(PushConstants.EXTRA_PUSH_MESSAGE_TYPE, str4);
        if (str5 == null) {
            str5 = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("style", str5);
        linkedHashMap.put("are_notify_enabled", e ? MsgStyle.CUSTOM_LEFT_PIC : "0");
        linkedHashMap.put("deep_link", String.valueOf(uri));
        linkedHashMap.put("is_permanent", String.valueOf(z));
        linkedHashMap.put("module_name", str6);
        linkedHashMap.put("action", PushConstants.PUSH_SERVICE_TYPE_CLICK);
        qi.h.a.q("notification", MsgStyle.SOURCE_PUSH, linkedHashMap);
    }

    public final void c(MsgBean msgBean, String str, String str2) {
        Intrinsics.h(msgBean, "msgBean");
        boolean e = e();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String messageId = msgBean.getMessageId();
        String str3 = BuildConfig.FLAVOR;
        if (messageId == null) {
            messageId = BuildConfig.FLAVOR;
        }
        linkedHashMap.put(PushConstants.EXTRA_PUSH_MESSAGE_ID, messageId);
        String source = msgBean.getSource();
        if (source == null) {
            source = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("source", source);
        String type = msgBean.getType();
        if (type == null) {
            type = BuildConfig.FLAVOR;
        }
        linkedHashMap.put(PushConstants.EXTRA_PUSH_MESSAGE_TYPE, type);
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("channel_id", str);
        linkedHashMap.put("are_notify_enabled", e ? MsgStyle.CUSTOM_LEFT_PIC : "0");
        String style = msgBean.getStyle();
        if (style == null) {
            style = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("style", style);
        if (str2 == null) {
            str2 = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("show_status", str2);
        String deeplink = msgBean.getDeeplink();
        if (deeplink != null) {
            str3 = deeplink;
        }
        linkedHashMap.put("deep_link", str3);
        linkedHashMap.put("screen_status", String.valueOf(v.a.a()));
        linkedHashMap.put("is_permanent", String.valueOf(msgBean.getIsPermanent()));
        linkedHashMap.put("action", "exposure");
        qi.h.a.q("notification", MsgStyle.SOURCE_PUSH, linkedHashMap);
    }

    public final void d(MsgBean msgBean) {
        Intrinsics.h(msgBean, "msgBean");
        boolean e = e();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String messageId = msgBean.getMessageId();
        String str = BuildConfig.FLAVOR;
        if (messageId == null) {
            messageId = BuildConfig.FLAVOR;
        }
        linkedHashMap.put(PushConstants.EXTRA_PUSH_MESSAGE_ID, messageId);
        String source = msgBean.getSource();
        if (source == null) {
            source = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("source", source);
        String type = msgBean.getType();
        if (type == null) {
            type = BuildConfig.FLAVOR;
        }
        linkedHashMap.put(PushConstants.EXTRA_PUSH_MESSAGE_TYPE, type);
        linkedHashMap.put("are_notify_enabled", e ? MsgStyle.CUSTOM_LEFT_PIC : "0");
        String style = msgBean.getStyle();
        if (style == null) {
            style = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("style", style);
        String deeplink = msgBean.getDeeplink();
        if (deeplink != null) {
            str = deeplink;
        }
        linkedHashMap.put("deep_link", str);
        linkedHashMap.put("action", "receive");
        qi.h.a.q("notification", MsgStyle.SOURCE_PUSH, linkedHashMap);
    }

    public final boolean e() {
        try {
            return t.b(Utils.a()).a();
        } catch (Exception unused) {
            return true;
        }
    }

    public final void f(String str, String str2, String str3, String str4, String str5, String str6) {
        Intrinsics.h(str, "msgId");
        Intrinsics.h(str2, "url");
        Intrinsics.h(str5, "pushType");
        PushManager pushManager = PushManager.getInstance();
        Long x = StringsKt.x(str);
        pushManager.trackClick(x != null ? x.longValue() : 0L);
    }

    public final void g(String str, String str2, String str3, String str4, String str5, String str6) {
        Long x;
        Intrinsics.h(str6, "pushType");
        PushManager.getInstance().trackShow((str == null || (x = StringsKt.x(str)) == null) ? 0L : x.longValue(), MsgShowStatus.INSTANCE.isShowStatus(str5) ? 0 : 7);
    }

    public final void h(String str, String str2, String str3) {
        Long x;
        Intrinsics.h(str2, "url");
        Intrinsics.h(str3, "channelType");
        PushManager.getInstance().trackArrive((str == null || (x = StringsKt.x(str)) == null) ? 0L : x.longValue());
    }

    public final void i(String str) {
        Intrinsics.h(str, "requestTime");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("module_name", "local_push_request");
        PushConfigHelper pushConfigHelper = PushConfigHelper.INSTANCE;
        linkedHashMap.put("hash_time", String.valueOf(pushConfigHelper.getHashTime()));
        linkedHashMap.put("request_time", str);
        PushSimbaConfig simbaConfig = pushConfigHelper.getSimbaConfig();
        linkedHashMap.put("config_enable", String.valueOf(simbaConfig != null ? Boolean.valueOf(simbaConfig.getRequestHashEnable()) : null));
        qi.h.a.z("notification", linkedHashMap);
    }
}
