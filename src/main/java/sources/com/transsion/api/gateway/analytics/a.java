package com.transsion.api.gateway.analytics;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class a {
    public boolean c;
    public boolean d;
    public long e;
    public String f;
    public String g;
    public String h;
    public String i;
    public int j;
    public int k;
    public long b = System.currentTimeMillis();
    public String a = String.valueOf(System.currentTimeMillis());

    public String toString() {
        return "RequestAnalyticsData{requestId='" + this.a + "', requestSubId='" + ((String) null) + "', requestStartTime=" + this.b + ", subRequestStartTime=0, isIpConnect=" + this.c + ", isGateway=" + this.d + ", requestSize=" + this.e + ", responseSize=0, ip='" + ((String) null) + "', host='" + this.f + "', netQuality=0, path='" + this.g + "', originUrl='" + this.h + "', originHost='" + this.i + "', domain='" + ((String) null) + "', result='" + ((String) null) + "', retryTime=" + this.j + ", responseCode=" + this.k + '}';
    }
}
