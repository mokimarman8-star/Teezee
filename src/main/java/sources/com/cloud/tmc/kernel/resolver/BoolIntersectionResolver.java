package com.cloud.tmc.kernel.resolver;

import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class BoolIntersectionResolver implements ResultResolver<Boolean> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.cloud.tmc.kernel.resolver.ResultResolver
    public Boolean resolve(List<Boolean> list) {
        if (list == null) {
            return Boolean.FALSE;
        }
        for (Boolean bool : list) {
            if (bool != null && bool.booleanValue()) {
            }
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
