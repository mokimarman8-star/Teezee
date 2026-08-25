package com.transsion.push;

import com.transsion.push.bean.PushMessage;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public interface TPushListener {
    void onClickException(long j, String str);

    void onMessageReceive(long j, String str, int i);

    void onNotificationShow(long j, String str);

    void onPushReceive(long j, PushMessage pushMessage, int i);

    void onSdkInitSuccess(String str, String str2);
}
