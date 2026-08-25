package com.cloud.tmc.miniapp;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.intf.IPackageConfig;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.model.BaseBean;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.service.ConfigService;
import com.cloud.tmc.kernel.service.EnvironmentService;
import com.cloud.tmc.launcherlib.LauncherMiniAppConfigHelper;
import com.cloud.tmc.miniapp.process.AppRecord;
import com.cloud.tmc.miniapp.ui.multiprogress.MiniAppMiniProcessActivity;
import com.cloud.tmc.miniapp.ui.multiprogress.MiniSubActivity1;
import com.cloud.tmc.miniapp.ui.multiprogress.MiniSubActivity2;
import com.cloud.tmc.miniapp.ui.multiprogress.MiniSubActivity3;
import com.cloud.tmc.miniapp.ui.multiprogress.MiniSubActivity4;
import com.cloud.tmc.miniutils.util.ActivityUtils;
import com.cloud.tmc.miniutils.util.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class NewTaskManager {
    public static final String KEY_APM_PRELAUNCH_PROCESS = "PreLaunchProcess";
    public static final String KEY_APM_PRELAUNCH_PROCESS_PHASE = "PreLaunchProcessPhase";
    public static final String KEY_PROCESS_MESSAGE = "processMessage";
    private static final String TAG = "NewTaskManager";
    public static final String UNKNOWN_PROCESS = "unknown process";
    private boolean isInitNativeStorage;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<NewTaskManager> instance$delegate = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<NewTaskManager>() { // from class: com.cloud.tmc.miniapp.NewTaskManager$Companion$instance$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final NewTaskManager m20invoke() {
            return new NewTaskManager(null);
        }
    });
    private static final Lazy<Boolean> enableTaskStorage$delegate = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0<Boolean>() { // from class: com.cloud.tmc.miniapp.NewTaskManager$Companion$enableTaskStorage$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m19invoke() {
            boolean z = true;
            try {
                z = MiniAppConfigHelper.INSTANCE.getConfigTargetBool(LauncherMiniAppConfigHelper.KEY_MINI_ENABLE_TASK_STORAGE, true);
            } catch (Throwable unused) {
            }
            return Boolean.valueOf(z);
        }
    });
    private static final List<ProcessInfo> sProcessInfos = new ArrayList();
    private static final ConcurrentLinkedQueue<TaskModel> taskQueue = new ConcurrentLinkedQueue<>();
    private static int sMaxIdleProcessNum = 1;

    public static final class ActivityInfo {
        private Class<? extends MiniAppMiniProcessActivity> activityClazz;
        private String mProcessName;
        private Void serviceClazz;

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof ActivityInfo)) {
                return false;
            }
            ActivityInfo activityInfo = (ActivityInfo) obj;
            return Intrinsics.c(this.activityClazz, activityInfo.activityClazz) && Intrinsics.c(this.serviceClazz, activityInfo.serviceClazz) && Intrinsics.c(this.mProcessName, activityInfo.mProcessName);
        }

        public final Class<? extends MiniAppMiniProcessActivity> getActivityClazz() {
            return this.activityClazz;
        }

        public final String getMProcessName() {
            return this.mProcessName;
        }

        public final Void getServiceClazz() {
            return this.serviceClazz;
        }

        public final void setActivityClazz(Class<? extends MiniAppMiniProcessActivity> cls) {
            this.activityClazz = cls;
        }

        public final void setMProcessName(String str) {
            this.mProcessName = str;
        }

        public final void setServiceClazz(Void r1) {
            this.serviceClazz = r1;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int getCurrentIdleProcessNum() {
            ProcessInfo.Companion companion = ProcessInfo.Companion;
            return getCurrentProcessNumByStatus(companion.getSTATUS_PROCESS_IDLE()) + getCurrentProcessNumByStatus(companion.getSTATUS_PROCESS_LAST_USED());
        }

        private final int getCurrentProcessNumByStatus(int i) {
            Iterator it = NewTaskManager.sProcessInfos.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (((ProcessInfo) it.next()).getMStatus() == i) {
                    i2++;
                }
            }
            return i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int getCurrentRunningProcessNum() {
            return getCurrentProcessNumByStatus(ProcessInfo.Companion.getSTATUS_PROCESS_RUNNING());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean getEnableTaskStorage() {
            return ((Boolean) NewTaskManager.enableTaskStorage$delegate.getValue()).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void resetProcessInfoToStatus(ProcessInfo processInfo, int i) {
            if (processInfo != null) {
                processInfo.setMAppId(null);
            }
            if (processInfo != null) {
                processInfo.setMAppToken(0L);
            }
            if (processInfo == null) {
                return;
            }
            processInfo.setMStatus(i);
        }

        public final NewTaskManager getInstance() {
            return (NewTaskManager) NewTaskManager.instance$delegate.getValue();
        }

        public final void updateTaskIdByAppId(String str, int i) {
            if (getInstance().checkOpenMutipleTask(str) && !getInstance().checkFeedBackApp(str)) {
                int i2 = 0;
                for (ProcessInfo processInfo : NewTaskManager.sProcessInfos) {
                    if (!TextUtils.isEmpty(str) && Intrinsics.c(str, processInfo.getMAppId())) {
                        processInfo.setTaskId(i);
                        if (getEnableTaskStorage()) {
                            KVStorageProxy kVStorageProxy = (KVStorageProxy) TmcProxy.get(KVStorageProxy.class);
                            Application app = Utils.getApp();
                            String str2 = "miniapp_task_info_" + i2;
                            if (str == null) {
                                str = "";
                            }
                            kVStorageProxy.putString(app, TmcConstants.KEY_MINI_SDK_STORAGE, str2, str);
                            TmcLogger.d(NewTaskManager.TAG, "saveUpdateTaskIdByAppId:" + processInfo.getMAppId());
                            return;
                        }
                        return;
                    }
                    i2++;
                }
            }
        }
    }

    public static final class ProcessInfo {
        private static int STATUS_PROCESS_DEAD;
        private ActivityInfo mActivityInfo;
        private String mAppId;
        private long mAppToken;
        private int mStatus;
        private int taskId;
        public static final Companion Companion = new Companion(null);
        private static int STATUS_PROCESS_IDLE = 1;
        private static int STATUS_PROCESS_RUNNING = 2;
        private static int STATUS_PROCESS_BACKGROUND = 3;
        private static int STATUS_PROCESS_WAIT_RELEASE = 4;
        private static int STATUS_PROCESS_LAST_USED = 5;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final int getSTATUS_PROCESS_BACKGROUND() {
                return ProcessInfo.STATUS_PROCESS_BACKGROUND;
            }

            public final int getSTATUS_PROCESS_DEAD() {
                return ProcessInfo.STATUS_PROCESS_DEAD;
            }

            public final int getSTATUS_PROCESS_IDLE() {
                return ProcessInfo.STATUS_PROCESS_IDLE;
            }

            public final int getSTATUS_PROCESS_LAST_USED() {
                return ProcessInfo.STATUS_PROCESS_LAST_USED;
            }

            public final int getSTATUS_PROCESS_RUNNING() {
                return ProcessInfo.STATUS_PROCESS_RUNNING;
            }

            public final int getSTATUS_PROCESS_WAIT_RELEASE() {
                return ProcessInfo.STATUS_PROCESS_WAIT_RELEASE;
            }

            public final void setSTATUS_PROCESS_BACKGROUND(int i) {
                ProcessInfo.STATUS_PROCESS_BACKGROUND = i;
            }

            public final void setSTATUS_PROCESS_DEAD(int i) {
                ProcessInfo.STATUS_PROCESS_DEAD = i;
            }

            public final void setSTATUS_PROCESS_IDLE(int i) {
                ProcessInfo.STATUS_PROCESS_IDLE = i;
            }

            public final void setSTATUS_PROCESS_LAST_USED(int i) {
                ProcessInfo.STATUS_PROCESS_LAST_USED = i;
            }

            public final void setSTATUS_PROCESS_RUNNING(int i) {
                ProcessInfo.STATUS_PROCESS_RUNNING = i;
            }

            public final void setSTATUS_PROCESS_WAIT_RELEASE(int i) {
                ProcessInfo.STATUS_PROCESS_WAIT_RELEASE = i;
            }
        }

        public ProcessInfo(ActivityInfo activityInfo) {
            Intrinsics.h(activityInfo, "activityInfo");
            this.mStatus = STATUS_PROCESS_DEAD;
            this.mActivityInfo = activityInfo;
        }

        public final ActivityInfo getMActivityInfo() {
            return this.mActivityInfo;
        }

        public final String getMAppId() {
            return this.mAppId;
        }

        public final long getMAppToken() {
            return this.mAppToken;
        }

        public final int getMStatus() {
            return this.mStatus;
        }

        public final int getTaskId() {
            return this.taskId;
        }

        public final void setMActivityInfo(ActivityInfo activityInfo) {
            Intrinsics.h(activityInfo, "<set-?>");
            this.mActivityInfo = activityInfo;
        }

        public final void setMAppId(String str) {
            this.mAppId = str;
        }

        public final void setMAppToken(long j) {
            this.mAppToken = j;
        }

        public final void setMStatus(int i) {
            this.mStatus = i;
        }

        public final void setTaskId(int i) {
            this.taskId = i;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("ProcessInfo:");
            sb.append(this.mActivityInfo.getMProcessName());
            sb.append(",activityName:");
            Class<? extends MiniAppMiniProcessActivity> activityClazz = this.mActivityInfo.getActivityClazz();
            sb.append(activityClazz != null ? activityClazz.getSimpleName() : null);
            sb.append(",status:");
            sb.append(this.mStatus);
            sb.append(",appId:");
            sb.append(this.mAppId);
            sb.append(",apptoken:");
            sb.append(this.mAppToken);
            String sb2 = sb.toString();
            Intrinsics.g(sb2, "builder.append(mActivity…end(mAppToken).toString()");
            return sb2;
        }
    }

    public static final class TaskModel extends BaseBean {
        private String childAppId;
        private String rootAppId;

        public TaskModel(String str, String str2) {
            Intrinsics.h(str, "rootAppId");
            Intrinsics.h(str2, "childAppId");
            this.rootAppId = str;
            this.childAppId = str2;
        }

        public /* synthetic */ TaskModel(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? "" : str2);
        }

        public static /* synthetic */ TaskModel copy$default(TaskModel taskModel, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = taskModel.rootAppId;
            }
            if ((i & 2) != 0) {
                str2 = taskModel.childAppId;
            }
            return taskModel.copy(str, str2);
        }

        public final String component1() {
            return this.rootAppId;
        }

        public final String component2() {
            return this.childAppId;
        }

        public final TaskModel copy(String str, String str2) {
            Intrinsics.h(str, "rootAppId");
            Intrinsics.h(str2, "childAppId");
            return new TaskModel(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TaskModel)) {
                return false;
            }
            TaskModel taskModel = (TaskModel) obj;
            return Intrinsics.c(this.rootAppId, taskModel.rootAppId) && Intrinsics.c(this.childAppId, taskModel.childAppId);
        }

        public final String getChildAppId() {
            return this.childAppId;
        }

        public final String getRootAppId() {
            return this.rootAppId;
        }

        public int hashCode() {
            return this.childAppId.hashCode() + (this.rootAppId.hashCode() * 31);
        }

        public final void setChildAppId(String str) {
            Intrinsics.h(str, "<set-?>");
            this.childAppId = str;
        }

        public final void setRootAppId(String str) {
            Intrinsics.h(str, "<set-?>");
            this.rootAppId = str;
        }

        public String toString() {
            return "TaskModel(rootAppId=" + this.rootAppId + ", childAppId=" + this.childAppId + ")";
        }
    }

    private NewTaskManager() {
        ActivityInfo activityInfo = new ActivityInfo();
        activityInfo.setActivityClazz(MiniSubActivity1.class);
        activityInfo.setMProcessName(":mini");
        ProcessInfo processInfo = new ProcessInfo(activityInfo);
        List<ProcessInfo> list = sProcessInfos;
        list.add(processInfo);
        ActivityInfo activityInfo2 = new ActivityInfo();
        activityInfo2.setActivityClazz(MiniSubActivity2.class);
        activityInfo2.setMProcessName(":mini");
        list.add(new ProcessInfo(activityInfo2));
        ActivityInfo activityInfo3 = new ActivityInfo();
        activityInfo3.setActivityClazz(MiniSubActivity3.class);
        activityInfo3.setMProcessName(":mini");
        list.add(new ProcessInfo(activityInfo3));
        ActivityInfo activityInfo4 = new ActivityInfo();
        activityInfo4.setActivityClazz(MiniSubActivity4.class);
        activityInfo4.setMProcessName(":mini");
        list.add(new ProcessInfo(activityInfo4));
    }

    public /* synthetic */ NewTaskManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final void clearIdleProcess(boolean z) {
        synchronized (Companion.getInstance()) {
            try {
                for (ProcessInfo processInfo : sProcessInfos) {
                    if (processInfo.getMStatus() == ProcessInfo.Companion.getSTATUS_PROCESS_IDLE()) {
                        if (!z && Companion.getCurrentIdleProcessNum() <= sMaxIdleProcessNum) {
                        }
                        releaseProcess(processInfo);
                    }
                }
                for (ProcessInfo processInfo2 : sProcessInfos) {
                    if (processInfo2.getMStatus() == ProcessInfo.Companion.getSTATUS_PROCESS_LAST_USED() && (z || Companion.getCurrentIdleProcessNum() > sMaxIdleProcessNum)) {
                        releaseProcess(processInfo2);
                    }
                }
                Unit unit = Unit.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void finishActivityTask(Class<?> cls) {
        try {
            Activity topActivity = ActivityUtils.getTopActivity();
            if (Intrinsics.c(cls != null ? cls.getSimpleName() : null, topActivity != null ? topActivity.getClass().getSimpleName() : null)) {
                topActivity.finishAndRemoveTask();
                return;
            }
            if (cls == null) {
                cls = null;
            }
            if (cls != null) {
                ActivityUtils.finishActivity((Class<? extends Activity>) cls);
            }
        } catch (Throwable th) {
            TmcLogger.e(TAG, th);
        }
    }

    private final ProcessInfo getFirstDeadProcess() {
        return getFirstProcessByStatus(ProcessInfo.Companion.getSTATUS_PROCESS_DEAD());
    }

    private final ProcessInfo getFirstProcessByStatus(int i) {
        for (ProcessInfo processInfo : sProcessInfos) {
            if (processInfo.getMStatus() == i) {
                return processInfo;
            }
        }
        return null;
    }

    private final ProcessInfo getFirstRunningProcess() {
        return getFirstProcessByStatus(ProcessInfo.Companion.getSTATUS_PROCESS_RUNNING());
    }

    private final ActivityInfo getNextLaunchActivityInfo() {
        ActivityInfo mActivityInfo;
        Companion companion = Companion;
        synchronized (companion.getInstance()) {
            try {
                if (getMaxTaskNum() == 0) {
                    return null;
                }
                ProcessInfo firstLastUsedProcess = getFirstLastUsedProcess();
                if (firstLastUsedProcess != null) {
                    ActivityInfo mActivityInfo2 = firstLastUsedProcess.getMActivityInfo();
                    TmcLogger.d(TAG, "Use last process: " + getProcessFullName(firstLastUsedProcess));
                    return mActivityInfo2;
                }
                ProcessInfo firstIdleProcess = getFirstIdleProcess();
                if (firstIdleProcess != null) {
                    TmcLogger.d(TAG, "Use idle process: " + getProcessFullName(firstIdleProcess));
                    return firstIdleProcess.getMActivityInfo();
                }
                ProcessInfo firstDeadProcess = getFirstDeadProcess();
                if (companion.getCurrentRunningProcessNum() < getMaxTaskNum() && firstDeadProcess != null) {
                    TmcLogger.d(TAG, "Use new process: " + getProcessFullName(firstDeadProcess));
                    return firstDeadProcess.getMActivityInfo();
                }
                ProcessInfo firstRunningProcess = getFirstRunningProcess();
                if (firstRunningProcess != null && (mActivityInfo = firstRunningProcess.getMActivityInfo()) != null) {
                    TmcLogger.d(TAG, "Reuse background info: " + getProcessFullName(firstRunningProcess));
                    return mActivityInfo;
                }
                ProcessInfo firstRunningProcess2 = getFirstRunningProcess();
                if (firstRunningProcess2 == null) {
                    TmcLogger.e(TAG, "Error, Can't find container to launch, please Check");
                    return null;
                }
                TmcLogger.d(TAG, "Fallback: Reuse info:" + getProcessFullName(firstRunningProcess2));
                return firstRunningProcess2.getMActivityInfo();
            } finally {
                TmcLogger.d(TAG, "getNextLaunchActivityInfo finish");
                printStatus();
            }
        }
    }

    private final String getProcessFullName(ActivityInfo activityInfo) {
        String str;
        try {
            String packageName = ((EnvironmentService) TmcProxy.get(EnvironmentService.class)).getApplicationContext().getPackageName();
            if (activityInfo == null || (str = activityInfo.getMProcessName()) == null) {
                str = "";
            }
            return packageName + str;
        } catch (Throwable unused) {
            return UNKNOWN_PROCESS;
        }
    }

    private final String getProcessFullName(ProcessInfo processInfo) {
        return getProcessFullName(processInfo != null ? processInfo.getMActivityInfo() : null);
    }

    private final ProcessInfo getProcessInfoByActivityInfo(ActivityInfo activityInfo) {
        for (ProcessInfo processInfo : sProcessInfos) {
            if (processInfo.getMActivityInfo() == activityInfo) {
                return processInfo;
            }
        }
        return null;
    }

    public static /* synthetic */ void moveToForeground$default(NewTaskManager newTaskManager, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        newTaskManager.moveToForeground(str, str2);
    }

    private final void printStatus() {
    }

    private final synchronized void releaseProcess(ProcessInfo processInfo) {
        if (processInfo != null) {
            processInfo.setMStatus(ProcessInfo.Companion.getSTATUS_PROCESS_WAIT_RELEASE());
        }
    }

    private final boolean removeFromRecentTasksList(Class<?> cls, ProcessInfo processInfo) {
        Intent intent;
        Intent intent2;
        Intent intent3;
        if (cls == null) {
            TmcLogger.d(TAG, "removeFromRecentTasksList: className null");
            return false;
        }
        try {
            Companion.resetProcessInfoToStatus(processInfo, ProcessInfo.Companion.getSTATUS_PROCESS_DEAD());
        } catch (Throwable unused) {
        }
        try {
            Object systemService = Utils.getApp().getSystemService("activity");
            Intrinsics.f(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            List<ActivityManager.AppTask> appTasks = ((ActivityManager) systemService).getAppTasks();
            Intrinsics.g(appTasks, "activityManager.appTasks");
            for (ActivityManager.AppTask appTask : appTasks) {
                ActivityManager.RecentTaskInfo taskInfo = appTask.getTaskInfo();
                Intrinsics.g(taskInfo, "appTask.taskInfo");
                intent = taskInfo.baseIntent;
                String str = null;
                if (intent.getComponent() != null) {
                    String canonicalName = cls.getCanonicalName();
                    intent3 = taskInfo.baseIntent;
                    ComponentName component = intent3.getComponent();
                    if (StringsKt.H(canonicalName, component != null ? component.getClassName() : null, true)) {
                        appTask.finishAndRemoveTask();
                        TmcLogger.d(TAG, "removeFromRecentTasksList: finishAndRemoveTask success");
                        return true;
                    }
                    TmcLogger.d(TAG, "removeFromRecentTasksList: recentTaskInfo null");
                }
                String canonicalName2 = cls.getCanonicalName();
                intent2 = taskInfo.baseIntent;
                ComponentName component2 = intent2.getComponent();
                if (component2 != null) {
                    str = component2.getClassName();
                }
                TmcLogger.d(TAG, "removeFromRecentTasksList: recentTaskInfo " + canonicalName2 + "," + str);
            }
        } catch (Throwable th) {
            TmcLogger.e(TAG, "removeFromRecentTasksList exception", th);
            Companion.resetProcessInfoToStatus(processInfo, ProcessInfo.Companion.getSTATUS_PROCESS_DEAD());
            finishActivityTask(cls);
        }
        return false;
    }

    private final void updateConfig() {
        ProcessInfo processInfo;
        String mAppId;
        try {
            if (!Companion.getEnableTaskStorage()) {
                TmcLogger.d(TAG, "init updateTaskInfoConfig:enableTaskStorage is false");
                return;
            }
            IntIterator it = RangesKt.s(0, getMaxTaskNum()).iterator();
            while (it.hasNext()) {
                int a = it.a();
                String string = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getString(Utils.getApp(), TmcConstants.KEY_MINI_SDK_STORAGE, "miniapp_task_info_" + a);
                if (string != null && string.length() > 0 && ((mAppId = (processInfo = sProcessInfos.get(a)).getMAppId()) == null || mAppId.length() == 0)) {
                    processInfo.setMAppId(string);
                    TmcLogger.d(TAG, " init updateTaskInfoConfig:MiniappActivity" + (a + 1) + " -> " + processInfo.getMAppId());
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final void addActivityStack(String str) {
        Object obj;
        try {
            if (checkOpenMutipleTask(str)) {
                return;
            }
            Iterator<T> it = taskQueue.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it.next();
                    if (Intrinsics.c(str, ((TaskModel) obj).getRootAppId())) {
                        break;
                    }
                }
            }
            TaskModel taskModel = (TaskModel) obj;
            if (taskModel != null) {
                taskQueue.remove(taskModel);
            }
            taskQueue.add(new TaskModel(str == null ? "" : str, ""));
            TmcLogger.d(TAG, "addActivityStack: add appId:" + str);
        } catch (Throwable th) {
            TmcLogger.e(TAG, "addActivityStack:" + th);
        }
    }

    public final void addStack(String str, long j, ActivityInfo activityInfo) {
        Intrinsics.h(str, "appId");
        try {
            if (checkOpenMutipleTask(str)) {
                if (activityInfo == null) {
                    return;
                }
                TmcLogger.d(TAG, "addStack:" + activityInfo.getActivityClazz() + " " + str);
                ProcessInfo processInfoByActivityInfo = getProcessInfoByActivityInfo(activityInfo);
                if (processInfoByActivityInfo != null) {
                    String mAppId = processInfoByActivityInfo.getMAppId();
                    if (mAppId != null && !Intrinsics.c(mAppId, str)) {
                        TmcLogger.d(TAG, "addStack oldAppid:" + mAppId + ",new appId:" + str);
                        removeFromStack(mAppId, true);
                    }
                    processInfoByActivityInfo.setMStatus(ProcessInfo.Companion.getSTATUS_PROCESS_RUNNING());
                    processInfoByActivityInfo.setMAppId(str);
                    processInfoByActivityInfo.setMAppToken(j);
                }
            }
        } catch (Throwable th) {
            try {
                TmcLogger.e(TAG, "addStack exception:", th);
            } finally {
                TmcLogger.d(TAG, "addStack finish");
                printStatus();
            }
        }
    }

    public final boolean checkFeedBackApp(String str) {
        String str2 = "1000391591855976448";
        try {
            str2 = ((ConfigService) TmcProxy.get(ConfigService.class)).getConfigString(LauncherMiniAppConfigHelper.KEY_MINI_FEEDBACK_ID, "1000391591855976448");
        } catch (Throwable unused) {
        }
        return Intrinsics.c(str, str2) && checkOpenMutipleTask(str);
    }

    public final boolean checkMiniAppServerApp(String str) {
        String str2 = TmcConstants.SETTING_MINIAPP_ID;
        try {
            str2 = ((ConfigService) TmcProxy.get(ConfigService.class)).getConfigString(LauncherMiniAppConfigHelper.KEY_MINI_APP_SERVER_ID, TmcConstants.SETTING_MINIAPP_ID);
        } catch (Throwable unused) {
        }
        return Intrinsics.c(str, str2) && checkOpenMutipleTask(str);
    }

    public final boolean checkOpenMutipleTask(String str) {
        IPackageConfig iPackageConfig = (IPackageConfig) TmcProxy.get(IPackageConfig.class);
        return (iPackageConfig == null || !iPackageConfig.getOpenMutipleTask() || getMaxTaskNum() == 0) ? false : true;
    }

    public final void checkRecentTaskList() {
        try {
            if (getMaxTaskNum() == 0) {
                TmcLogger.d(TAG, "<checkRecentTaskList> getMaxTaskNum == 0, try clean recentTaskList");
                IntIterator it = RangesKt.s(0, 4).iterator();
                while (it.hasNext()) {
                    int a = it.a();
                    String string = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getString(Utils.getApp(), TmcConstants.KEY_MINI_SDK_STORAGE, "miniapp_task_info_" + a);
                    if (string != null && string.length() > 0) {
                        ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putString(Utils.getApp(), TmcConstants.KEY_MINI_SDK_STORAGE, "miniapp_task_info_" + a, "");
                        Class cls = a != 0 ? a != 1 ? a != 2 ? a != 3 ? null : MiniSubActivity4.class : MiniSubActivity3.class : MiniSubActivity2.class : MiniSubActivity1.class;
                        TmcLogger.d(TAG, "<checkRecentTaskList> task_" + a + " exit, try clean " + cls + " recentTask");
                        if (cls != null) {
                            removeFromRecentTasksList(cls, null);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            TmcLogger.e(TAG, "<checkRecentTaskList> error", th);
        }
    }

    public final void checkTaskId(String str, Class<?> cls) {
        try {
            if (checkOpenMutipleTask(str)) {
                for (ProcessInfo processInfo : sProcessInfos) {
                    Class<? extends MiniAppMiniProcessActivity> activityClazz = processInfo.getMActivityInfo().getActivityClazz();
                    if (Intrinsics.c(activityClazz != null ? activityClazz.getSimpleName() : null, cls != null ? cls.getSimpleName() : null)) {
                        TmcLogger.d(TAG, "checkTaskId:" + processInfo.getMAppId() + "," + (cls != null ? cls.getSimpleName() : null));
                        if (Intrinsics.c(str, processInfo.getMAppId())) {
                            return;
                        }
                        TmcLogger.d(TAG, "removeFromRecentTasksList activity appid:" + str + ",processInfo.mAppId:" + processInfo.getMAppId());
                        if (TextUtils.isEmpty(processInfo.getMAppId())) {
                            TmcLogger.d(TAG, "removeFromRecentTasksList, update");
                            processInfo.setMAppId(str);
                            return;
                        } else {
                            TmcLogger.d(TAG, "removeFromRecentTasksList,remove");
                            removeFromRecentTasksList(cls, processInfo);
                            return;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            TmcLogger.e(TAG, th);
        }
    }

    public final boolean checkUseSingleTaskMode(String str) {
        return checkFeedBackApp(str);
    }

    public final List<String> getExistAppIds() {
        ArrayList arrayList = new ArrayList();
        for (TaskModel taskModel : taskQueue) {
            if (taskModel != null) {
                Intrinsics.g(taskModel, "it");
                arrayList.add(taskModel.getRootAppId());
            }
        }
        return arrayList;
    }

    public final ProcessInfo getFirstIdleProcess() {
        return getFirstProcessByStatus(ProcessInfo.Companion.getSTATUS_PROCESS_IDLE());
    }

    public final ProcessInfo getFirstLastUsedProcess() {
        return getFirstProcessByStatus(ProcessInfo.Companion.getSTATUS_PROCESS_LAST_USED());
    }

    public final String getForegroundAppId() {
        ConcurrentLinkedQueue<TaskModel> concurrentLinkedQueue = taskQueue;
        if (concurrentLinkedQueue.size() <= 0) {
            return null;
        }
        TaskModel taskModel = (TaskModel) CollectionsKt.t0(concurrentLinkedQueue);
        String childAppId = taskModel.getChildAppId();
        return childAppId.length() == 0 ? taskModel.getRootAppId() : childAppId;
    }

    public final int getMaxTaskNum() {
        try {
            return ((ConfigService) TmcProxy.get(ConfigService.class)).getConfigInt(LauncherMiniAppConfigHelper.KEY_MINI_MUTIPLE_TASK, CommonAppUtils.INSTANCE.getDefaultMultiTaskCount());
        } catch (Exception e) {
            TmcLogger.e(TAG, e);
            return 0;
        }
    }

    public final ProcessInfo getProcessInfoByAppId(String str) {
        Intrinsics.h(str, "appId");
        for (ProcessInfo processInfo : sProcessInfos) {
            if (!TextUtils.isEmpty(str) && Intrinsics.c(str, processInfo.getMAppId())) {
                return processInfo;
            }
        }
        return null;
    }

    public final String getTaskRootAppId() {
        ConcurrentLinkedQueue<TaskModel> concurrentLinkedQueue = taskQueue;
        if (concurrentLinkedQueue.size() > 0) {
            return ((TaskModel) CollectionsKt.t0(concurrentLinkedQueue)).getRootAppId();
        }
        return null;
    }

    public final boolean isInitNativeStorage() {
        return this.isInitNativeStorage;
    }

    public final void moveToForeground(String str, String str2) {
        Object obj;
        Intrinsics.h(str, "appId");
        Intrinsics.h(str2, "childAppId");
        if (checkOpenMutipleTask(str)) {
            synchronized (Companion.getInstance()) {
                try {
                    TmcLogger.d(TAG, "moveToForeground:" + str);
                    ProcessInfo processInfoByAppId = getProcessInfoByAppId(str);
                    if (processInfoByAppId != null) {
                        if (processInfoByAppId.getMActivityInfo() != null) {
                            processInfoByAppId.setMStatus(ProcessInfo.Companion.getSTATUS_PROCESS_RUNNING());
                            Iterator<T> it = taskQueue.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    obj = null;
                                    break;
                                } else {
                                    obj = it.next();
                                    if (Intrinsics.c(str, ((TaskModel) obj).getRootAppId())) {
                                        break;
                                    }
                                }
                            }
                            TaskModel taskModel = (TaskModel) obj;
                            if (taskModel == null) {
                                taskModel = new TaskModel(str, str2);
                            }
                            taskModel.setChildAppId(str2);
                            ConcurrentLinkedQueue<TaskModel> concurrentLinkedQueue = taskQueue;
                            concurrentLinkedQueue.remove(taskModel);
                            concurrentLinkedQueue.add(taskModel);
                        } else {
                            TmcLogger.e(TAG, "moveToForeground:Can't find target in sActivityStack?");
                            Unit unit = Unit.a;
                        }
                    }
                    TmcLogger.d(TAG, "moveToForeground finish");
                } catch (Throwable th) {
                    try {
                        TmcLogger.e(TAG, "moveToForeground exception:", th);
                        Unit unit2 = Unit.a;
                        TmcLogger.d(TAG, "moveToForeground finish");
                    } catch (Throwable th2) {
                        TmcLogger.d(TAG, "moveToForeground finish");
                        printStatus();
                        throw th2;
                    }
                }
                printStatus();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0020, code lost:
    
        if (checkUseSingleTaskMode(r9.getAppId()) != false) goto L10;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0057 A[Catch: all -> 0x0069, TryCatch #3 {all -> 0x0069, blocks: (B:16:0x0047, B:17:0x0051, B:19:0x0057, B:23:0x006d, B:25:0x0071, B:30:0x0099, B:32:0x00a5, B:34:0x00c5, B:36:0x00cd, B:38:0x00e6, B:40:0x00ec, B:44:0x00ff, B:54:0x0040), top: B:53:0x0040, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0071 A[Catch: all -> 0x0069, TRY_LEAVE, TryCatch #3 {all -> 0x0069, blocks: (B:16:0x0047, B:17:0x0051, B:19:0x0057, B:23:0x006d, B:25:0x0071, B:30:0x0099, B:32:0x00a5, B:34:0x00c5, B:36:0x00cd, B:38:0x00e6, B:40:0x00ec, B:44:0x00ff, B:54:0x0040), top: B:53:0x0040, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0099 A[Catch: all -> 0x0069, TRY_ENTER, TryCatch #3 {all -> 0x0069, blocks: (B:16:0x0047, B:17:0x0051, B:19:0x0057, B:23:0x006d, B:25:0x0071, B:30:0x0099, B:32:0x00a5, B:34:0x00c5, B:36:0x00cd, B:38:0x00e6, B:40:0x00ec, B:44:0x00ff, B:54:0x0040), top: B:53:0x0040, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x006c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ActivityInfo preLaunchActivity(Context context, AppRecord appRecord) {
        Iterator<T> it;
        Object obj;
        ProcessInfo processInfo;
        String str;
        Intrinsics.h(context, "context");
        Intrinsics.h(appRecord, "appRecord");
        try {
            checkRecentTaskList();
            if (checkOpenMutipleTask(appRecord.getAppId())) {
            }
            return null;
        } catch (Throwable th) {
            TmcLogger.e(TAG, "getNextLaunchActivityInfo error", th);
        }
        try {
            synchronized (Companion.getInstance()) {
                try {
                    if (!this.isInitNativeStorage) {
                        this.isInitNativeStorage = true;
                        updateConfig();
                    }
                } catch (Throwable th2) {
                    try {
                        TmcLogger.e(TAG, "updateConfig error", th2);
                        String appId = appRecord.getAppId();
                        it = sProcessInfos.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                obj = null;
                                break;
                            }
                            obj = it.next();
                            if (Intrinsics.c(((ProcessInfo) obj).getMAppId(), appId)) {
                                break;
                            }
                        }
                        processInfo = (ProcessInfo) obj;
                        if (processInfo == null) {
                            TmcLogger.d(TAG, "preLaunchActivity: current activity , appId:" + appId);
                            return processInfo.getMActivityInfo();
                        }
                        int currentRunningProcessNum = Companion.getCurrentRunningProcessNum();
                        if (currentRunningProcessNum >= getMaxTaskNum()) {
                            TmcLogger.d(TAG, "currentRunningProcessNum：" + currentRunningProcessNum);
                            TaskModel poll = taskQueue.poll();
                            if (poll == null || (str = poll.getRootAppId()) == null) {
                                str = "";
                            }
                            TmcLogger.d(TAG, "oldAppId：" + str);
                            removeFromStack(str, true);
                        }
                        ActivityInfo nextLaunchActivityInfo = getNextLaunchActivityInfo();
                        if (nextLaunchActivityInfo != null) {
                            addStack(appId, appRecord.getStartToken(), nextLaunchActivityInfo);
                            return nextLaunchActivityInfo;
                        }
                        Unit unit = Unit.a;
                        return null;
                    } finally {
                    }
                }
                String appId2 = appRecord.getAppId();
                it = sProcessInfos.iterator();
                while (true) {
                    if (it.hasNext()) {
                    }
                }
                processInfo = (ProcessInfo) obj;
                if (processInfo == null) {
                }
            }
        } finally {
            try {
                return null;
            } finally {
            }
        }
    }

    public final void remoceFromStackFromRecent(String str) {
        ProcessInfo processInfoByAppId;
        Intrinsics.h(str, "appId");
        Companion companion = Companion;
        synchronized (companion.getInstance()) {
            try {
                if (checkUseSingleTaskMode(str)) {
                    TaskModel peek = taskQueue.peek();
                    if (Intrinsics.c(peek != null ? peek.getChildAppId() : null, str)) {
                        peek.setChildAppId("");
                        return;
                    }
                }
                processInfoByAppId = getProcessInfoByAppId(str);
            } catch (Throwable unused) {
            }
            if (processInfoByAppId == null) {
                return;
            }
            removeTaskQueue(str);
            companion.resetProcessInfoToStatus(processInfoByAppId, ProcessInfo.Companion.getSTATUS_PROCESS_DEAD());
            Unit unit = Unit.a;
        }
    }

    public final void removeActivityStack(String str) {
        Object obj;
        try {
            if (checkOpenMutipleTask(str)) {
                return;
            }
            Iterator<T> it = taskQueue.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it.next();
                    if (Intrinsics.c(str, ((TaskModel) obj).getRootAppId())) {
                        break;
                    }
                }
            }
            TaskModel taskModel = (TaskModel) obj;
            if (taskModel != null) {
                taskQueue.remove(taskModel);
            }
            TmcLogger.d(TAG, "removeActivityStack: remove appId:" + str);
        } catch (Throwable th) {
            TmcLogger.e(TAG, th);
        }
    }

    public final void removeFromStack(String str, boolean z) {
        ProcessInfo processInfoByAppId;
        Intrinsics.h(str, "appId");
        Companion companion = Companion;
        synchronized (companion.getInstance()) {
            try {
                if (checkUseSingleTaskMode(str)) {
                    TaskModel peek = taskQueue.peek();
                    if (Intrinsics.c(peek != null ? peek.getChildAppId() : null, str)) {
                        peek.setChildAppId("");
                        return;
                    }
                }
                TmcLogger.d(TAG, "removeFromStack:" + str);
                processInfoByAppId = getProcessInfoByAppId(str);
            } catch (Throwable th) {
                try {
                    TmcLogger.e(TAG, "removeFromStack exception:", th);
                    TmcLogger.d(TAG, "removeFromStack finish");
                } finally {
                    TmcLogger.d(TAG, "removeFromStack finish");
                    printStatus();
                }
            }
            if (processInfoByAppId == null) {
                return;
            }
            String processFullName = getProcessFullName(processInfoByAppId);
            ActivityInfo mActivityInfo = processInfoByAppId.getMActivityInfo();
            if (TextUtils.isEmpty(processFullName) || mActivityInfo == null) {
                TmcLogger.e(TAG, "removeFromStack:Can't find target in sActivityStack?");
            } else {
                TmcLogger.d(TAG, "removeFromStack:" + processFullName);
                removeTaskQueue(str);
                removeFromRecentTasksList(mActivityInfo.getActivityClazz(), processInfoByAppId);
                if (z) {
                    companion.resetProcessInfoToStatus(processInfoByAppId, ProcessInfo.Companion.getSTATUS_PROCESS_DEAD());
                } else {
                    ProcessInfo firstLastUsedProcess = getFirstLastUsedProcess();
                    if (firstLastUsedProcess == null || Intrinsics.c(firstLastUsedProcess.getMActivityInfo(), mActivityInfo)) {
                        if ((firstLastUsedProcess == null || !Intrinsics.c(firstLastUsedProcess.getMActivityInfo(), mActivityInfo)) && firstLastUsedProcess == null) {
                            companion.resetProcessInfoToStatus(processInfoByAppId, ProcessInfo.Companion.getSTATUS_PROCESS_LAST_USED());
                        }
                    } else if (companion.getCurrentIdleProcessNum() >= sMaxIdleProcessNum) {
                        releaseProcess(processInfoByAppId);
                    } else {
                        companion.resetProcessInfoToStatus(processInfoByAppId, ProcessInfo.Companion.getSTATUS_PROCESS_IDLE());
                    }
                    clearIdleProcess(false);
                }
            }
            TmcLogger.d(TAG, "removeFromStack finish");
            printStatus();
            Unit unit = Unit.a;
        }
    }

    public final void removeTaskQueue(String str) {
        Object obj;
        Intrinsics.h(str, "appId");
        try {
            Iterator<T> it = taskQueue.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it.next();
                    if (Intrinsics.c(str, ((TaskModel) obj).getRootAppId())) {
                        break;
                    }
                }
            }
            taskQueue.remove((TaskModel) obj);
        } catch (Throwable th) {
            TmcLogger.e(TAG, th);
        }
    }

    public final void setInitNativeStorage(boolean z) {
        this.isInitNativeStorage = z;
    }

    public final void updateProcessInfoByAppId(String str) {
        Object obj;
        String str2;
        Intrinsics.h(str, "appId");
        for (ProcessInfo processInfo : sProcessInfos) {
            if (!TextUtils.isEmpty(str) && Intrinsics.c(str, processInfo.getMAppId())) {
                Iterator<T> it = taskQueue.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (Intrinsics.c(((TaskModel) obj).getRootAppId(), str)) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                TaskModel taskModel = (TaskModel) obj;
                if (taskModel == null || (str2 = taskModel.getChildAppId()) == null) {
                    str2 = "";
                }
                TmcLogger.d(TAG, "current root id -> " + str + " ,new root id -> " + str2);
                if (str2.length() > 0) {
                    processInfo.setMAppId(str2);
                }
            }
        }
    }
}
