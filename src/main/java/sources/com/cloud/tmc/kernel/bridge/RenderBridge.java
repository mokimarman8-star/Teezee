package com.cloud.tmc.kernel.bridge;

import com.google.gson.JsonObject;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface RenderBridge {
    void sendToRender(RenderCallContext renderCallContext, SendToRenderCallback sendToRenderCallback);

    void setGlobalObject(String str, JsonObject jsonObject);

    SendToRenderCallback takeCallback(String str);
}
