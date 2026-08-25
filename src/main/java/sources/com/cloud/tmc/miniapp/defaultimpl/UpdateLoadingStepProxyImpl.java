package com.cloud.tmc.miniapp.defaultimpl;

import com.cloud.tmc.integration.activity.LoadStepAction;
import com.cloud.tmc.integration.proxy.IUpdateLoadingStepProxy;
import com.cloud.tmc.integration.proxy.UpdateLoadingStepListener;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class UpdateLoadingStepProxyImpl implements IUpdateLoadingStepProxy {
    public final ConcurrentHashMap<String, UpdateLoadingStepListener> OooO00o = new ConcurrentHashMap<>();

    public void addUpdateLoadingListener(String str, UpdateLoadingStepListener updateLoadingStepListener) {
        Intrinsics.h(str, "appId");
        Intrinsics.h(updateLoadingStepListener, "listener");
        if (str.length() == 0) {
            return;
        }
        this.OooO00o.put(str, updateLoadingStepListener);
    }

    public final ConcurrentHashMap<String, UpdateLoadingStepListener> getMap() {
        return this.OooO00o;
    }

    public void notifyUpdateLoadingStep(String str, LoadStepAction loadStepAction) {
        UpdateLoadingStepListener updateLoadingStepListener;
        Intrinsics.h(str, "appId");
        Intrinsics.h(loadStepAction, "step");
        if (str.length() == 0 || (updateLoadingStepListener = this.OooO00o.get(str)) == null) {
            return;
        }
        updateLoadingStepListener.onUpdateStep(loadStepAction);
    }

    public void removeUpdateLoadingListener(String str) {
        Intrinsics.h(str, "appId");
        if (str.length() == 0) {
            return;
        }
        this.OooO00o.remove(str);
    }
}
