package com.cloud.tmc.integration.invoke;

import android.text.TextUtils;
import com.cloud.tmc.integration.invoke.ExtensionInvoker;
import com.cloud.tmc.kernel.annotation.ActionFilter;
import com.cloud.tmc.kernel.annotation.UsePermission;
import com.cloud.tmc.kernel.datastructure.immutable.ImmutableList;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.extension.Extension;
import com.cloud.tmc.kernel.extension.bridge.BridgeGuard;
import com.cloud.tmc.kernel.extension.bridge.BridgePermission;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.security.AccessController;
import com.cloud.tmc.kernel.security.Guard;
import com.cloud.tmc.kernel.security.Permission;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class SecurityExtensionInvoker extends ExtensionInvoker {
    private static final String TAG = "Tmcintegration:ExtensionInvoker:Security";
    private AccessController mAccessController;

    public SecurityExtensionInvoker(AccessController accessController, ExtensionInvoker extensionInvoker) {
        super(extensionInvoker);
        this.mAccessController = accessController;
    }

    @Override // com.cloud.tmc.integration.invoke.ExtensionInvoker
    public ExtensionInvoker.InvokeResult onInvoke(final Object obj, final Method method, final Object[] objArr) throws Throwable {
        final long currentTimeMillis = System.currentTimeMillis();
        final ArrayList arrayList = new ArrayList();
        Iterator it = this.targetExtensions.iterator();
        while (it.hasNext()) {
            Guard guard = (Extension) it.next();
            if (guard instanceof Guard) {
                arrayList.add(guard);
            }
            Method method2 = guard.getClass().getMethod(method.getName(), method.getParameterTypes());
            if (method2 != null) {
                UsePermission annotation = method2.getAnnotation(UsePermission.class);
                if (annotation != null && annotation.value() != null && annotation.value().length() > 0) {
                    arrayList.add(new BridgeGuard(new BridgePermission(annotation.value(), annotation.desc())));
                } else if ((guard instanceof BridgeExtension) && method2.getAnnotation(ActionFilter.class) != null) {
                    ActionFilter annotation2 = method2.getAnnotation(ActionFilter.class);
                    String name = (annotation2 == null || TextUtils.isEmpty(annotation2.value())) ? method2.getName() : annotation2.value();
                    arrayList.add(new BridgeGuard(new BridgePermission(name, name)));
                }
            }
        }
        AccessController.ApplyCallback applyCallback = new AccessController.ApplyCallback() { // from class: com.cloud.tmc.integration.invoke.SecurityExtensionInvoker.1
            public void onFailure(List<? extends Permission> list) {
                List mutable = SecurityExtensionInvoker.this.targetExtensions.mutable();
                for (Permission permission : list) {
                    for (Guard guard2 : arrayList) {
                        if (guard2.permit().authority().equalsIgnoreCase(permission.authority())) {
                            mutable.remove(guard2);
                        }
                    }
                }
                TmcLogger.debug(SecurityExtensionInvoker.TAG, "method " + method + " cost " + (System.currentTimeMillis() - currentTimeMillis));
                SecurityExtensionInvoker.this.proceedSafe(new ImmutableList<>(mutable), obj, method, objArr);
            }

            public void onSuccess() {
                TmcLogger.debug(SecurityExtensionInvoker.TAG, "method " + method + " cost " + (System.currentTimeMillis() - currentTimeMillis));
                SecurityExtensionInvoker securityExtensionInvoker = SecurityExtensionInvoker.this;
                securityExtensionInvoker.proceedSafe(securityExtensionInvoker.targetExtensions, obj, method, objArr);
            }
        };
        AccessController accessController = this.mAccessController;
        return (accessController == null || !accessController.check(this.targetNode, arrayList, applyCallback)) ? ExtensionInvoker.InvokeResult.proceed() : ExtensionInvoker.InvokeResult.pending();
    }
}
