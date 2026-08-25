package com.transsion.push.bean;

import cm.g;
import java.util.HashSet;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ConfigRequestParamAutoGenerate implements g {
    @Override // cm.g
    public HashSet providerParams() {
        HashSet hashSet = new HashSet();
        hashSet.add("push_remind_notification_time");
        hashSet.add("push_permanent_ui_ab_config");
        hashSet.add(PushConfigHelper.PUSH_PIC_TYPE_CONFIG_KEY);
        hashSet.add(PushConfigHelper.PUSH_SIMBA_CONFIG_KEY);
        hashSet.add("sa_toolbar_notice");
        hashSet.add("sa_notification_refresh");
        return hashSet;
    }
}
