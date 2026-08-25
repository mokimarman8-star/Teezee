package com.apm.insight;

import java.util.List;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public interface ICommonParams {
    Map<String, Object> getCommonParams();

    String getDeviceId();

    List<String> getPatchInfo();

    Map<String, Integer> getPluginInfo();

    String getSessionId();

    long getUserId();
}
