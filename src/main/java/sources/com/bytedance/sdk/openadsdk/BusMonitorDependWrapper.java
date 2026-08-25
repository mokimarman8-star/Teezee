package com.bytedance.sdk.openadsdk;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.sdk.openadsdk.dNu.sP;
import com.bytedance.sdk.openadsdk.dNu.sP.Sj;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class BusMonitorDependWrapper implements sP {
    private sP Sj;
    private Handler sP;

    public BusMonitorDependWrapper(sP sPVar) {
        this.Sj = sPVar;
    }

    public static Context getReflectContext() {
        try {
            Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", null);
            method.setAccessible(true);
            Object invoke = method.invoke(null, null);
            return (Application) invoke.getClass().getMethod("getApplication", null).invoke(invoke, null);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.dNu.sP
    public Context getContext() {
        sP sPVar = this.Sj;
        return (sPVar == null || sPVar.getContext() == null) ? getReflectContext() : this.Sj.getContext();
    }

    @Override // com.bytedance.sdk.openadsdk.dNu.sP
    public Handler getHandler() {
        sP sPVar = this.Sj;
        if (sPVar != null && sPVar.getHandler() != null) {
            return this.Sj.getHandler();
        }
        if (this.sP == null) {
            this.sP = new Handler(getSafeHandlerThread("pag_monitor", 0).getLooper());
        }
        return this.sP;
    }

    @Override // com.bytedance.sdk.openadsdk.dNu.sP
    public int getOnceLogCount() {
        sP sPVar = this.Sj;
        if (sPVar != null) {
            return sPVar.getOnceLogCount();
        }
        return 20;
    }

    @Override // com.bytedance.sdk.openadsdk.dNu.sP
    public int getOnceLogInterval() {
        sP sPVar = this.Sj;
        if (sPVar != null) {
            return sPVar.getOnceLogInterval();
        }
        return 1000;
    }

    @Override // com.bytedance.sdk.openadsdk.dNu.sP
    public HandlerThread getSafeHandlerThread(String str, int i) {
        HandlerThread safeHandlerThread;
        sP sPVar = this.Sj;
        if (sPVar != null && (safeHandlerThread = sPVar.getSafeHandlerThread(str, i)) != null) {
            return safeHandlerThread;
        }
        HandlerThread handlerThread = new HandlerThread("pag_monitor");
        handlerThread.start();
        return handlerThread;
    }

    @Override // com.bytedance.sdk.openadsdk.dNu.sP
    public int getUploadIntervalTime() {
        int uploadIntervalTime;
        sP sPVar = this.Sj;
        if (sPVar == null || (uploadIntervalTime = sPVar.getUploadIntervalTime()) < 1800000) {
            return 1800000;
        }
        return uploadIntervalTime;
    }

    @Override // com.bytedance.sdk.openadsdk.dNu.sP
    public boolean isMonitorOpen() {
        sP sPVar = this.Sj;
        if (sPVar != null) {
            return sPVar.isMonitorOpen();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.dNu.sP
    public void onMonitorUpload(List<Sj> list) {
        sP sPVar = this.Sj;
        if (sPVar != null) {
            sPVar.onMonitorUpload(list);
        }
    }
}
