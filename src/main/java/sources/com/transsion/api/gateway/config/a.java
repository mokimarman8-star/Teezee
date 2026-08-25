package com.transsion.api.gateway.config;

import com.hisavana.common.constant.ComConstants;
import com.transsion.api.gateway.bean.RemoteConfig;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class a {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final int d;
    public final long e;
    public final int f;
    public final long g;
    public final String h;
    public final List i;
    public final List j;
    public final List k;

    /* renamed from: com.transsion.api.gateway.config.a$a, reason: collision with other inner class name */
    public static final class C0005a {
        public boolean a;
        public boolean b;
        public boolean c;
        public int d;
        public long e;
        public long f;
        public String g;
        public List h;
        public int i;
        public List j;
        public List k;

        public C0005a() {
            this.a = false;
            this.b = false;
            this.c = true;
            this.d = ComConstants.defScheduleTime;
            this.e = 3600000L;
            this.f = 3600000L;
            this.i = 0;
            this.j = new ArrayList();
            this.k = new ArrayList();
        }

        public C0005a(a aVar) {
            this.a = aVar.a;
            this.b = aVar.b;
            this.c = aVar.c;
            this.d = aVar.d;
            this.e = aVar.e;
            this.f = aVar.g;
            this.j = aVar.j;
            this.k = aVar.k;
            this.i = aVar.f;
            this.g = aVar.h;
            this.h = aVar.i;
        }

        public C0005a a(RemoteConfig remoteConfig) {
            this.a = remoteConfig.activateGatewayDns;
            this.b = remoteConfig.useGateway;
            this.c = remoteConfig.activateTracking;
            this.d = remoteConfig.requestTimeout;
            this.e = remoteConfig.refreshInterval;
            this.f = remoteConfig.metricsInterval;
            this.j = remoteConfig.useGatewayHostList;
            this.k = remoteConfig.gatewayStrategy;
            this.i = remoteConfig.configVersion;
            this.g = remoteConfig.gatewayHost;
            this.h = remoteConfig.gatewayIp;
            return this;
        }
    }

    public a(C0005a c0005a) {
        this.a = c0005a.a;
        this.b = c0005a.b;
        this.c = c0005a.c;
        this.d = c0005a.d;
        this.e = c0005a.e;
        this.f = c0005a.i;
        this.g = c0005a.f;
        this.h = c0005a.g;
        this.i = c0005a.h;
        this.j = c0005a.j;
        this.k = c0005a.k;
    }

    public String toString() {
        return "GatewayConfig{activateGatewayDns=" + this.a + ", useGateway=" + this.b + ", activateTracking=" + this.c + ", requestTimeout=" + this.d + ", refreshInterval=" + this.e + ", configVersion=" + this.f + ", metricsInterval=" + this.g + ", gatewayHost='" + this.h + "', gatewayIp=" + this.i + ", useGatewayHostList=" + this.j + ", gatewayStrategy=" + this.k + '}';
    }
}
