package com.cloud.tmc.kernel.proxy.performanceanalyse;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class MiniAppAnalyseType implements IPerformanceAnalyseType {
    public final Object data;
    public final String eventName;
    public final String pagePath;

    public MiniAppAnalyseType(String str, String str2, Object obj) {
        this.eventName = str;
        this.pagePath = str2;
        this.data = obj;
    }
}
