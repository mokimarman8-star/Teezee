package com.transsion.push.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.view.PointerIconCompat;
import com.transsion.push.bean.PushMessage;
import com.transsion.push.service.JobIntentService;
import com.transsion.push.service.PushJobIntentService;
import com.transsion.push.service.PushServiceHelper;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class ServiceUtils {
    private static void b(Context context, Intent intent) {
        try {
            JobIntentService.enqueueWork(context, PushJobIntentService.class, PointerIconCompat.TYPE_HELP, intent.setComponent(new ComponentName(context, (Class<?>) PushJobIntentService.class)));
        } catch (Exception e) {
            PushLogUtils.LOG.i("start job intent service exception, e:" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, Intent intent) {
        try {
            PushServiceHelper.f(intent);
        } catch (Exception e) {
            PushLogUtils.LOG.i("start job intent service exception, e:" + e.getMessage());
        }
    }

    public static void startJobThread(Context context, Bundle bundle) {
        ThreadManager.executeInBackground(new 1(bundle, context));
    }

    public static void startTargetIntentService(Context context, Bundle bundle) {
        Intent intent = new Intent();
        intent.putExtras(bundle);
        b(context, intent);
    }

    public static void startTargetIntentService(PushMessage pushMessage) {
    }
}
