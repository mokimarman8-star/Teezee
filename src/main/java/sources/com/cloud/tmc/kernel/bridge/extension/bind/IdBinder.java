package com.cloud.tmc.kernel.bridge.extension.bind;

import com.cloud.tmc.kernel.bridge.extension.annotation.BindingId;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class IdBinder implements Binder<BindingId, String> {
    private String id;

    public IdBinder(String str) {
        this.id = str;
    }

    @Override // com.cloud.tmc.kernel.bridge.extension.bind.Binder
    public String bind(Class<String> cls, BindingId bindingId) throws BindException {
        return this.id;
    }
}
