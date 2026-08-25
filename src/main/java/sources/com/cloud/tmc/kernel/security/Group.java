package com.cloud.tmc.kernel.security;

import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface Group {
    void assignPermissions(List<? extends Permission> list);

    String description();

    String groupName();

    List<? extends Permission> permissions();
}
