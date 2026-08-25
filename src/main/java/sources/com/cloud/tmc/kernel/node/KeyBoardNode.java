package com.cloud.tmc.kernel.node;

import com.cloud.tmc.kernel.BuildConfig;
import com.cloud.tmc.kernel.listener.OnKeyboardListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/cloud/tmc/kernel/node/KeyBoardNode;", "", "addOnKeyboardListener", "", "listener", "Lcom/cloud/tmc/kernel/listener/OnKeyboardListener;", "removeOnKeyboardListener", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface KeyBoardNode {
    void addOnKeyboardListener(OnKeyboardListener listener);

    void removeOnKeyboardListener(OnKeyboardListener listener);
}
