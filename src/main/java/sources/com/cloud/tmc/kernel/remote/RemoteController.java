package com.cloud.tmc.kernel.remote;

import android.os.RemoteException;
import com.cloud.tmc.kernel.extension.Extension;
import com.cloud.tmc.kernel.extension.ExtensionManager;
import java.lang.reflect.Method;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface RemoteController {
    void bindExtensionManager(ExtensionManager extensionManager);

    RemoteControlManagement getRemoteControlManagement();

    boolean isRemoteCallExtension(Extension extension, Method method);

    RemoteCallResult remoteCall(RemoteCallArgs remoteCallArgs) throws RemoteException;

    void setRemoteControlManagement(RemoteControlManagement remoteControlManagement);
}
