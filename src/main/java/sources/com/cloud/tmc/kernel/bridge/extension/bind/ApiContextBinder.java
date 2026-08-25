package com.cloud.tmc.kernel.bridge.extension.bind;

import com.cloud.tmc.kernel.bridge.extension.annotation.BindingApiContext;
import com.cloud.tmc.kernel.model.ApiContext;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class ApiContextBinder implements Binder<BindingApiContext, ApiContext> {
    private ApiContext mApiContext;

    public ApiContextBinder(ApiContext apiContext) {
        this.mApiContext = apiContext;
    }

    @Override // com.cloud.tmc.kernel.bridge.extension.bind.Binder
    public ApiContext bind(Class<ApiContext> cls, BindingApiContext bindingApiContext) throws BindException {
        if (bindingApiContext.required() && this.mApiContext == null) {
            throw new BindException("Required ApiContext but not inject!!!");
        }
        return this.mApiContext;
    }
}
