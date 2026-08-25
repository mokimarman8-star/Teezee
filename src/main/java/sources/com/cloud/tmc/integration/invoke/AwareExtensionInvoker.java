package com.cloud.tmc.integration.invoke;

import com.cloud.tmc.integration.invoke.ExtensionInvoker;
import com.cloud.tmc.kernel.executor.IExecutorService;
import com.cloud.tmc.kernel.extension.Extension;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.scheduler.Schedulable;
import com.cloud.tmc.kernel.utils.NodeAwareUtils;
import java.lang.reflect.Method;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class AwareExtensionInvoker extends ExtensionInvoker {
    public static final String TAG = "TmcKernel:ExtensionInvoker:Aware";

    public AwareExtensionInvoker(Node node, ExtensionInvoker.InvokeCallback invokeCallback) {
        super(node, invokeCallback);
    }

    @Override // com.cloud.tmc.integration.invoke.ExtensionInvoker
    protected ExtensionInvoker.InvokeResult onInvoke(Object obj, Method method, Object[] objArr) {
        long currentTimeMillis = System.currentTimeMillis();
        Schedulable schedulable = (Extension) this.targetExtensions.get(0);
        NodeAwareUtils.handleSetNode(this.targetNode, schedulable);
        if (schedulable instanceof Schedulable) {
            schedulable.setExecutorFactory((IExecutorService) TmcProxy.get(IExecutorService.class));
        }
        TmcLogger.debug(TAG, "extension " + schedulable.getClass() + " method " + method + " cost " + (System.currentTimeMillis() - currentTimeMillis));
        return ExtensionInvoker.InvokeResult.proceed();
    }
}
