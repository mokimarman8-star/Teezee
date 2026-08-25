package com.cloud.tmc.miniapp.defaultimpl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.cloud.tmc.integration.proxy.StartActivityProxy;
import com.cloud.tmc.miniapp.NewTaskManager;
import com.cloud.tmc.miniapp.ui.MiniSchemaFilterActivity;
import com.cloud.tmc.miniapp.ui.WebViewActivity;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class DefaultLauncherMiniActivityProxy implements StartActivityProxy {
    public Boolean checkFeedBackApp(String str) {
        return Boolean.valueOf(NewTaskManager.Companion.getInstance().checkUseSingleTaskMode(str));
    }

    public Boolean checkOpenMutipleTask(String str) {
        return Boolean.valueOf(NewTaskManager.Companion.getInstance().checkOpenMutipleTask(str));
    }

    public Class<?> getLauncherShortCutActivity() {
        return MiniSchemaFilterActivity.class;
    }

    public Class<?> getWebViewActivity() {
        return WebViewActivity.class;
    }

    public void launchMiniApp(Context context, String str) {
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "url");
        MiniAppLaunch.launchMiniApp$default(MiniAppLaunch.INSTANCE, context, str, null, 4, null);
    }

    public void launchMiniAppForId(Context context, String str) {
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "appId");
        MiniAppLaunch.launchMiniAppForId(MiniAppLaunch.INSTANCE.getLaunchContext(str, context), str, new Bundle());
    }

    public void removeMiniAppTask(String str, Activity activity) {
        NewTaskManager.Companion companion = NewTaskManager.Companion;
        if (!companion.getInstance().checkOpenMutipleTask(str)) {
            if (activity != null) {
                activity.finishAndRemoveTask();
            }
        } else if (str != null) {
            companion.getInstance().removeFromStack(str, true);
            if (!companion.getInstance().checkFeedBackApp(str) || activity == null) {
                return;
            }
            activity.finish();
        }
    }

    public void removeMiniAppTaskByRecent(String str) {
        try {
            NewTaskManager.Companion companion = NewTaskManager.Companion;
            if (!companion.getInstance().checkOpenMutipleTask(str) || str == null) {
                return;
            }
            companion.getInstance().remoceFromStackFromRecent(str);
        } catch (Throwable unused) {
        }
    }

    public void updateTaskRootId(String str) {
        if (str != null) {
            NewTaskManager.Companion.getInstance().updateProcessInfoByAppId(str);
        }
    }
}
