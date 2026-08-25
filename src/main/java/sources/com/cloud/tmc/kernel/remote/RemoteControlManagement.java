package com.cloud.tmc.kernel.remote;

import com.cloud.tmc.kernel.extension.Extension;
import java.lang.reflect.Method;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface RemoteControlManagement {
    boolean isRemoteExtension(Extension extension, Method method);
}
