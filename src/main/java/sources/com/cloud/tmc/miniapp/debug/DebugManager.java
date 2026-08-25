package com.cloud.tmc.miniapp.debug;

import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.debug.DebugCallback;
import com.cloud.tmc.kernel.debug.IDebugManager;
import com.cloud.tmc.miniapp.widget.OooO;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class DebugManager implements IDebugManager {
    public final Map<Object, DebugCallback> OooO00o = new LinkedHashMap();

    @Override // com.cloud.tmc.kernel.debug.IDebugManager
    public void addObserver(Object obj, DebugCallback debugCallback) {
        Intrinsics.h(obj, "tag");
        Intrinsics.h(debugCallback, TmcConstants.EXTRA_SHARE_TARGET);
        this.OooO00o.put(obj, debugCallback);
    }

    @Override // com.cloud.tmc.kernel.debug.IDebugManager
    public void notifyObserver() {
        if (this.OooO00o.size() != 1) {
            OooO.OooO00o("当前非主页，不支chrome/inspect 刷新");
            return;
        }
        Iterator<T> it = this.OooO00o.values().iterator();
        while (it.hasNext()) {
            ((DebugCallback) it.next()).debugRefresh();
        }
    }

    @Override // com.cloud.tmc.kernel.debug.IDebugManager
    public void removeObserver(Object obj) {
        Intrinsics.h(obj, "tag");
        this.OooO00o.remove(obj);
    }
}
