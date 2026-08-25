package com.cloud.tmc.kernel.bridge.extension.bind;

import com.cloud.tmc.kernel.bridge.extension.annotation.BindingRequest;
import com.google.gson.JsonObject;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class RequestBinder<T> implements Binder<BindingRequest, T> {
    private JsonObject sourceJSON;

    public RequestBinder(JsonObject jsonObject) {
        this.sourceJSON = jsonObject;
    }

    @Override // com.cloud.tmc.kernel.bridge.extension.bind.Binder
    public T bind(Class<T> cls, BindingRequest bindingRequest) throws BindException {
        if (this.sourceJSON != null) {
            return null;
        }
        throw new BindException("input JSON is null");
    }
}
