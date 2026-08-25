package com.cloud.tmc.miniapp.process;

import android.app.Activity;
import android.app.ActivityManager;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.kernel.constants.TmcConstants;
import kotlin.jvm.internal.Intrinsics;

@Keep
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class AppRecord {
    public static final OooO00o Companion = new OooO00o();
    private static final String TAG = "Tmcintegration:AppRecord";
    private static long lastStartToken = -1;
    private Class<? extends Activity> activityClz;
    private final String appId;
    private boolean isReceivedRemoteReady;
    private boolean isTaskRoot;
    private AppModel mAppModel;
    private Bundle mSceneParams;
    private Bundle mStartParams;
    private int remoteLpid;
    private ActivityManager.RunningTaskInfo runningTaskInfo;
    private final long startToken;

    public static final class OooO00o {
    }

    public AppRecord(String str, long j, Bundle bundle, @Nullable Bundle bundle2) {
        Intrinsics.h(str, "appId");
        this.appId = str;
        this.startToken = j;
        this.mStartParams = bundle;
        Intrinsics.e(bundle);
        bundle.putString("appId", str);
        bundle2 = bundle2 == null ? new Bundle() : bundle2;
        this.mSceneParams = bundle2;
        Intrinsics.e(bundle2);
        bundle2.putLong(TmcConstants.EXTRA_START_TOKEN, j);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppRecord(String str, Bundle bundle, @Nullable Bundle bundle2) {
        this(str, System.currentTimeMillis(), bundle, bundle2);
        Intrinsics.h(str, "appId");
    }

    public final void finishClient() {
    }

    public final Class<? extends Activity> getActivityClz() {
        return this.activityClz;
    }

    public final String getAppId() {
        return this.appId;
    }

    @Nullable
    public final AppModel getAppModel() {
        return this.mAppModel;
    }

    public final int getRemoteLpid() {
        return this.remoteLpid;
    }

    public final ActivityManager.RunningTaskInfo getRunningTaskInfo() {
        return this.runningTaskInfo;
    }

    public final Bundle getSceneParams() {
        return this.mSceneParams;
    }

    public final Bundle getStartParams() {
        return this.mStartParams;
    }

    public final long getStartToken() {
        return this.startToken;
    }

    public final boolean isReceivedRemoteReady() {
        return this.isReceivedRemoteReady;
    }

    public final boolean isTaskRoot() {
        return this.isTaskRoot;
    }

    public final void setActivityClz(Class<? extends Activity> cls) {
        this.activityClz = cls;
    }

    public final void setAppModel(AppModel appModel) {
        this.mAppModel = appModel;
    }

    public final void setReceivedRemoteReady(int i) {
        this.remoteLpid = i;
        this.isReceivedRemoteReady = true;
    }

    public final void setRunningTaskInfo(ActivityManager.RunningTaskInfo runningTaskInfo) {
        this.runningTaskInfo = runningTaskInfo;
    }

    public final void setSceneParams(Bundle bundle) {
        this.mSceneParams = bundle;
        if (bundle != null) {
            bundle.setClassLoader(AppRecord.class.getClassLoader());
        }
    }

    public final void setStartParams(Bundle bundle) {
        this.mStartParams = bundle;
        if (bundle != null) {
            bundle.setClassLoader(AppRecord.class.getClassLoader());
        }
    }

    public final void setTaskRoot(boolean z) {
        this.isTaskRoot = z;
    }

    public String toString() {
        return "AppRecord{mStartToken=" + this.mStartParams + ", appId='" + this.appId + "', activityClz=" + this.activityClz + "}";
    }
}
