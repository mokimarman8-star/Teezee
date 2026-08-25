package com.transsion.lib_web.download_render.data.config;

import androidx.annotation.Keep;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Keep
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/transsion/lib_web/download_render/data/config/ConfigData;", BuildConfig.FLAVOR, "maxCacheSize", BuildConfig.FLAVOR, "maxUsedTime", "maxUpgradeTime", "htmlUseRemote", BuildConfig.FLAVOR, "requestMinInterval", "<init>", "(JJJZJ)V", "getMaxCacheSize", "()J", "getMaxUsedTime", "getMaxUpgradeTime", "getHtmlUseRemote", "()Z", "getRequestMinInterval", "lib_web_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ConfigData {
    private final boolean htmlUseRemote;
    private final long maxCacheSize;
    private final long maxUpgradeTime;
    private final long maxUsedTime;
    private final long requestMinInterval;

    public ConfigData() {
        this(0L, 0L, 0L, false, 0L, 31, null);
    }

    public ConfigData(long j, long j2, long j3, boolean z, long j4) {
        this.maxCacheSize = j;
        this.maxUsedTime = j2;
        this.maxUpgradeTime = j3;
        this.htmlUseRemote = z;
        this.requestMinInterval = j4;
    }

    public /* synthetic */ ConfigData(long j, long j2, long j3, boolean z, long j4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 104857600L : j, (i & 2) != 0 ? 2592000000L : j2, (i & 4) == 0 ? j3 : 2592000000L, (i & 8) != 0 ? false : z, (i & 16) != 0 ? 3600000L : j4);
    }

    public final boolean getHtmlUseRemote() {
        return this.htmlUseRemote;
    }

    public final long getMaxCacheSize() {
        return this.maxCacheSize;
    }

    public final long getMaxUpgradeTime() {
        return this.maxUpgradeTime;
    }

    public final long getMaxUsedTime() {
        return this.maxUsedTime;
    }

    public final long getRequestMinInterval() {
        return this.requestMinInterval;
    }
}
