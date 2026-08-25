package com.cloud.tmc.integration.invoke;

import com.cloud.tmc.integration.invoke.ExtensionInvoker;
import com.cloud.tmc.kernel.extension.Extension;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public interface ExtensionCallback<T> extends ExtensionInvoker.InvokeCallback<T> {
    void onException(Extension extension, Throwable th);

    void onInterrupt(Extension extension);

    void onProgress(Extension extension, T t);

    void onStart(List<Extension> list);
}
