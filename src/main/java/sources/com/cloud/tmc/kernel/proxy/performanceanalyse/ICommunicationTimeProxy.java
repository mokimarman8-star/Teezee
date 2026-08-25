package com.cloud.tmc.kernel.proxy.performanceanalyse;

import com.cloud.tmc.kernel.proxy.Proxiable;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface ICommunicationTimeProxy extends Proxiable {
    void clear(String str);

    int getTotalNum(String str);

    long getTotalTime(String str);

    void plusNum(String str, int i);

    void plusTime(String str, long j);
}
