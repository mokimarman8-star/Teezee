package com.cloud.tmc.kernel.extension.bridge;

import com.cloud.tmc.kernel.security.Guard;
import com.cloud.tmc.kernel.security.Permission;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class BridgeGuard implements Guard {
    private Permission permission;

    public BridgeGuard(Permission permission) {
        this.permission = permission;
    }

    @Override // com.cloud.tmc.kernel.security.Guard
    public Permission permit() {
        return this.permission;
    }
}
