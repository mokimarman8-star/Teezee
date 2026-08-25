package com.cloud.tmc.kernel.point;

import com.cloud.tmc.kernel.bridge.NativeCallContext;
import com.cloud.tmc.kernel.extension.Extension;
import com.google.gson.JsonObject;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface NativeCallResultPoint extends Extension {
    void onSendBack(NativeCallContext nativeCallContext, JsonObject jsonObject);
}
