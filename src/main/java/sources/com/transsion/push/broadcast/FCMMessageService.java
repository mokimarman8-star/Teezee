package com.transsion.push.broadcast;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.transsion.gslb.BuildConfig;
import com.transsion.json.b;
import com.transsion.push.PushConstants;
import com.transsion.push.PushManager;
import com.transsion.push.bean.PushMessage;
import com.transsion.push.bean.PushMessageKey;
import com.transsion.push.tracker.Tracker;
import com.transsion.push.utils.PushLogUtils;
import com.transsion.push.utils.PushUtils;
import com.transsion.push.utils.ServiceUtils;
import com.transsion.push.utils.p0;
import java.util.Map;
import yj.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class FCMMessageService extends FirebaseMessagingService {
    private boolean w(PushMessage pushMessage) {
        return pushMessage.messageId > 0 && pushMessage.type > 0 && !TextUtils.isEmpty(pushMessage.pkgId);
    }

    private PushMessage x(RemoteMessage remoteMessage) {
        PushMessage pushMessage = new PushMessage();
        Map data = remoteMessage.getData();
        if (data != null && !data.isEmpty()) {
            pushMessage.messageId = p0.e((String) data.get(PushMessageKey.KEY_TCM_MSG_ID));
            pushMessage.type = p0.d((String) data.get(PushMessageKey.KEY_TCM_MSG_TYPE));
            pushMessage.pkgId = (String) data.get(PushMessageKey.KEY_TCM_MSG_PKG);
            pushMessage.packageName = (String) data.get(PushMessageKey.KEY_TCM_MSG_PKGNAME);
            try {
                pushMessage.rpkg = a.a().getPackageName();
            } catch (Exception unused) {
                pushMessage.rpkg = BuildConfig.FLAVOR;
            }
            pushMessage.notiType = p0.d((String) data.get(PushMessageKey.KEY_NOTI_TYPE));
            pushMessage.notiExType = p0.c((String) data.get(PushMessageKey.KEY_NOTI_EX_TYPE));
            pushMessage.msgTtl = p0.d((String) data.get(PushMessageKey.KEY_TCM_MSG_TTL));
            pushMessage.ignoreExpire = p0.d((String) data.get(PushMessageKey.KEY_NOTI_IGNORE_EXPIRE));
            pushMessage.groupId = (String) data.get(PushMessageKey.KEY_APP_GROUP_ID);
            pushMessage.groupMaxCount = (String) data.get(PushMessageKey.KEY_APP_GROUP_MAX_COUNT);
            pushMessage.notiTitle = (String) data.get(PushMessageKey.KEY_NOTI_TITLE);
            pushMessage.notiDes = (String) data.get(PushMessageKey.KEY_NOTI_DESC);
            pushMessage.notiImg = (String) data.get(PushMessageKey.KEY_NOTI_IMG);
            pushMessage.notiIcon = (String) data.get(PushMessageKey.KEY_NOTI_ICON);
            pushMessage.notiBtn = (String) data.get(PushMessageKey.KEY_NOTI_BTN);
            pushMessage.notiImgEx = (String) data.get(PushMessageKey.KEY_NOTI_IMG_EX);
            pushMessage.notiTitleEx = (String) data.get(PushMessageKey.KEY_NOTI_TITLE_EX);
            pushMessage.notiTxtEx = (String) data.get(PushMessageKey.KEY_NOTI_TXT_EX);
            pushMessage.notiOpenType = p0.d((String) data.get(PushMessageKey.KEY_NOTI_OPEN_TYPE));
            pushMessage.notiOpenContent = (String) data.get(PushMessageKey.KEY_NOTI_OPEN_CONTENT);
            pushMessage.transData = p0.b((String) data.get("trans_data"));
            pushMessage.timeStamp = (String) data.get(PushMessageKey.KEY_TCM_MSG_TIMESTAMP);
            pushMessage.notiSmallIcon = (String) data.get(PushMessageKey.KEY_NOTI_SMALL_ICON);
            pushMessage.displayPolicy = p0.d((String) data.get(PushMessageKey.KEY_DISPLAY_POLICY));
            pushMessage.appName = (String) data.get(PushMessageKey.KEY_APP_NAME);
            pushMessage.layoutStyleId = p0.d((String) data.get(PushMessageKey.KEY_APP_LAYOUT_STYLE_ID));
            pushMessage.channelId = (String) data.get(PushMessageKey.KEY_APP_CHANNEL_ID);
            pushMessage.channelName = (String) data.get(PushMessageKey.KEY_APP_CHANNEL_NAME);
            pushMessage.iconColor = (String) data.get(PushMessageKey.KEY_NOTI_SMALL_ICON_COLOR);
            pushMessage.impUrlList = (String) data.get(PushMessageKey.KEY_NOTI_IMP_URLS);
            pushMessage.clickUrlList = (String) data.get(PushMessageKey.KEY_NOTI_CLICK_URLS);
            pushMessage.isHeadsUp = p0.d((String) data.get(PushMessageKey.KEY_NOTI_IS_HEADSUP));
            pushMessage.retraceMsgId = p0.e((String) data.get(PushMessageKey.KEY_NOTI_RETRACE_MSG_ID));
            pushMessage.notiExtensionBtn = (String) data.get(PushMessageKey.KEY_NOTI_BTN_EX);
            pushMessage.notiBtnBgColor = (String) data.get(PushMessageKey.KEY_NOTI_BTN_BG_COLOR);
            pushMessage.notiBtnTxtColor = (String) data.get(PushMessageKey.KEY_NOTI_BTN_WORD_COLOR);
            pushMessage.notiOptionalIcon = (String) data.get(PushMessageKey.KEY_NOTI_OPTIONAL_ICON);
            pushMessage.priority = p0.d((String) data.get(PushMessageKey.KEY_TCM_MSG_PRIORITY));
            pushMessage.sdkShow = p0.d((String) data.get(PushMessageKey.KEY_TCM_MSG_SDKSHOW));
            pushMessage.floatNotice = (String) data.get(PushMessageKey.KEY_NOTI_FLOAT_NOTICE);
            pushMessage.materialId = (String) data.get(PushMessageKey.KEY_TCM_MATERIAL_ID);
            pushMessage.seq = (String) data.get(PushMessageKey.KEY_TCM_SEQ);
            pushMessage.sourceType = (String) data.get(PushMessageKey.KEY_TCM_SOURCE_TYPE);
            pushMessage.scheduleDate = (String) data.get(PushMessageKey.KEY_TCM_SCHEDULE_DATE);
            pushMessage.tag = (String) data.get(PushMessageKey.KEY_TCM_TAG);
        }
        return pushMessage;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void r(RemoteMessage remoteMessage) {
        String str;
        PushLogUtils.LOG.g("Receiving FCM messages by FirebaseMessagingService:" + remoteMessage.getData());
        super.r(remoteMessage);
        Context applicationContext = getApplicationContext();
        a.b(applicationContext);
        PushManager.getInstance().init(applicationContext.getApplicationContext());
        PushMessage x = x(remoteMessage);
        PushLogUtils.LOG.g("Receiving FCM messages packageName:" + applicationContext.getPackageName() + "  " + x);
        if (w(x)) {
            Tracker.getInstance().trackMessage(x.messageId, x.type, x.timeStamp, "all", 0);
            try {
                str = b.b(x);
            } catch (Exception e) {
                PushLogUtils.LOG.i("Receiving FCM messages to messageContent fail, e:" + e.getMessage());
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("message", str);
            bundle.putString(PushConstants.EXTRA_PUSH_SERVICE_TYPE, "message");
            ServiceUtils.startTargetIntentService(applicationContext, bundle);
        }
    }

    public void t(String str) {
        super.t(str);
        PushLogUtils.LOG.g("FCM MessageService onNewToken: " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        PushUtils.B(str);
    }
}
