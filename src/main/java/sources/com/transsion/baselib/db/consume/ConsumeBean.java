package com.transsion.baselib.db.consume;

import androidx.annotation.Keep;
import androidx.collection.s;
import com.transsion.gslb.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003J=\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\t\u0010'\u001a\u00020\tHÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006("}, d2 = {"Lcom/transsion/baselib/db/consume/ConsumeBean;", "Ljava/io/Serializable;", "id", BuildConfig.FLAVOR, "updateTimeStamp", BuildConfig.FLAVOR, "dataType", "appVersion", "consumeJson", BuildConfig.FLAVOR, "<init>", "(IJIILjava/lang/String;)V", "getId", "()I", "setId", "(I)V", "getUpdateTimeStamp", "()J", "setUpdateTimeStamp", "(J)V", "getDataType", "setDataType", "getAppVersion", "setAppVersion", "getConsumeJson", "()Ljava/lang/String;", "setConsumeJson", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "toString", "BaseLib_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class ConsumeBean implements Serializable {
    private int appVersion;
    private String consumeJson;
    private int dataType;
    private int id;
    private long updateTimeStamp;

    public ConsumeBean(int i, long j, int i2, int i3, String str) {
        this.id = i;
        this.updateTimeStamp = j;
        this.dataType = i2;
        this.appVersion = i3;
        this.consumeJson = str;
    }

    public /* synthetic */ ConsumeBean(int i, long j, int i2, int i3, String str, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i, j, i2, i3, (i4 & 16) != 0 ? BuildConfig.FLAVOR : str);
    }

    public static /* synthetic */ ConsumeBean copy$default(ConsumeBean consumeBean, int i, long j, int i2, int i3, String str, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = consumeBean.id;
        }
        if ((i4 & 2) != 0) {
            j = consumeBean.updateTimeStamp;
        }
        long j2 = j;
        if ((i4 & 4) != 0) {
            i2 = consumeBean.dataType;
        }
        int i5 = i2;
        if ((i4 & 8) != 0) {
            i3 = consumeBean.appVersion;
        }
        int i6 = i3;
        if ((i4 & 16) != 0) {
            str = consumeBean.consumeJson;
        }
        return consumeBean.copy(i, j2, i5, i6, str);
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final long getUpdateTimeStamp() {
        return this.updateTimeStamp;
    }

    /* renamed from: component3, reason: from getter */
    public final int getDataType() {
        return this.dataType;
    }

    /* renamed from: component4, reason: from getter */
    public final int getAppVersion() {
        return this.appVersion;
    }

    /* renamed from: component5, reason: from getter */
    public final String getConsumeJson() {
        return this.consumeJson;
    }

    public final ConsumeBean copy(int id, long updateTimeStamp, int dataType, int appVersion, String consumeJson) {
        return new ConsumeBean(id, updateTimeStamp, dataType, appVersion, consumeJson);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConsumeBean)) {
            return false;
        }
        ConsumeBean consumeBean = (ConsumeBean) other;
        return this.id == consumeBean.id && this.updateTimeStamp == consumeBean.updateTimeStamp && this.dataType == consumeBean.dataType && this.appVersion == consumeBean.appVersion && Intrinsics.c(this.consumeJson, consumeBean.consumeJson);
    }

    public final int getAppVersion() {
        return this.appVersion;
    }

    public final String getConsumeJson() {
        return this.consumeJson;
    }

    public final int getDataType() {
        return this.dataType;
    }

    public final int getId() {
        return this.id;
    }

    public final long getUpdateTimeStamp() {
        return this.updateTimeStamp;
    }

    public int hashCode() {
        int a = ((((((this.id * 31) + s.a(this.updateTimeStamp)) * 31) + this.dataType) * 31) + this.appVersion) * 31;
        String str = this.consumeJson;
        return a + (str == null ? 0 : str.hashCode());
    }

    public final void setAppVersion(int i) {
        this.appVersion = i;
    }

    public final void setConsumeJson(String str) {
        this.consumeJson = str;
    }

    public final void setDataType(int i) {
        this.dataType = i;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setUpdateTimeStamp(long j) {
        this.updateTimeStamp = j;
    }

    public String toString() {
        return "ConsumeBean(id=" + this.id + ", updateTimeStamp=" + this.updateTimeStamp + ", dataType=" + this.dataType + ", appVersion=" + this.appVersion + ", consumeJson=" + this.consumeJson + ")";
    }
}
