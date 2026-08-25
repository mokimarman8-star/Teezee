package com.cloud.tmc.miniapp.offlineapps;

import androidx.collection.s;
import com.cloud.tmc.integration.model.ClassificationInfo;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.cloud.tmc.kernel.model.BaseBean;
import com.cloud.tmc.miniutils.constant.MemoryConstants;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OfflineAppBean extends BaseBean {
    private String appId;
    private Integer category;
    private List<ClassificationInfo> classification;
    private List<String> classificationNames;
    private String desc;
    private String logoPath;
    private String logoUrl;
    private String name;
    private long openTimestamp;
    private OfflineAppType type;
    private String version;

    public OfflineAppBean(String str, String str2, String str3, OfflineAppType offlineAppType, String str4, String str5, Integer num, String str6, long j, List<String> list, List<ClassificationInfo> list2) {
        Intrinsics.h(str, "appId");
        Intrinsics.h(offlineAppType, NativeComponentConstants.KEY_COMPONENT_TYPE);
        this.appId = str;
        this.version = str2;
        this.name = str3;
        this.type = offlineAppType;
        this.logoUrl = str4;
        this.logoPath = str5;
        this.category = num;
        this.desc = str6;
        this.openTimestamp = j;
        this.classificationNames = list;
        this.classification = list2;
    }

    public /* synthetic */ OfflineAppBean(String str, String str2, String str3, OfflineAppType offlineAppType, String str4, String str5, Integer num, String str6, long j, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, offlineAppType, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? 0 : num, (i & 128) != 0 ? null : str6, (i & 256) != 0 ? 0L : j, (i & 512) != 0 ? null : list, (i & MemoryConstants.KB) != 0 ? null : list2);
    }

    public final String component1() {
        return this.appId;
    }

    public final List<String> component10() {
        return this.classificationNames;
    }

    public final List<ClassificationInfo> component11() {
        return this.classification;
    }

    public final String component2() {
        return this.version;
    }

    public final String component3() {
        return this.name;
    }

    public final OfflineAppType component4() {
        return this.type;
    }

    public final String component5() {
        return this.logoUrl;
    }

    public final String component6() {
        return this.logoPath;
    }

    public final Integer component7() {
        return this.category;
    }

    public final String component8() {
        return this.desc;
    }

    public final long component9() {
        return this.openTimestamp;
    }

    public final OfflineAppBean copy(String str, String str2, String str3, OfflineAppType offlineAppType, String str4, String str5, Integer num, String str6, long j, List<String> list, List<ClassificationInfo> list2) {
        Intrinsics.h(str, "appId");
        Intrinsics.h(offlineAppType, NativeComponentConstants.KEY_COMPONENT_TYPE);
        return new OfflineAppBean(str, str2, str3, offlineAppType, str4, str5, num, str6, j, list, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OfflineAppBean)) {
            return false;
        }
        OfflineAppBean offlineAppBean = (OfflineAppBean) obj;
        return Intrinsics.c(this.appId, offlineAppBean.appId) && Intrinsics.c(this.version, offlineAppBean.version) && Intrinsics.c(this.name, offlineAppBean.name) && this.type == offlineAppBean.type && Intrinsics.c(this.logoUrl, offlineAppBean.logoUrl) && Intrinsics.c(this.logoPath, offlineAppBean.logoPath) && Intrinsics.c(this.category, offlineAppBean.category) && Intrinsics.c(this.desc, offlineAppBean.desc) && this.openTimestamp == offlineAppBean.openTimestamp && Intrinsics.c(this.classificationNames, offlineAppBean.classificationNames) && Intrinsics.c(this.classification, offlineAppBean.classification);
    }

    public final String getAppId() {
        return this.appId;
    }

    public final Integer getCategory() {
        return this.category;
    }

    public final List<ClassificationInfo> getClassification() {
        return this.classification;
    }

    public final List<String> getClassificationNames() {
        return this.classificationNames;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getLogoPath() {
        return this.logoPath;
    }

    public final String getLogoUrl() {
        return this.logoUrl;
    }

    public final String getName() {
        return this.name;
    }

    public final long getOpenTimestamp() {
        return this.openTimestamp;
    }

    public final OfflineAppType getType() {
        return this.type;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        int hashCode = this.appId.hashCode() * 31;
        String str = this.version;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.name;
        int hashCode3 = (this.type.hashCode() + ((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31)) * 31;
        String str3 = this.logoUrl;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.logoPath;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.category;
        int hashCode6 = (hashCode5 + (num == null ? 0 : num.hashCode())) * 31;
        String str5 = this.desc;
        int a = (s.a(this.openTimestamp) + ((hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31)) * 31;
        List<String> list = this.classificationNames;
        int hashCode7 = (a + (list == null ? 0 : list.hashCode())) * 31;
        List<ClassificationInfo> list2 = this.classification;
        return hashCode7 + (list2 != null ? list2.hashCode() : 0);
    }

    public final void setAppId(String str) {
        Intrinsics.h(str, "<set-?>");
        this.appId = str;
    }

    public final void setCategory(Integer num) {
        this.category = num;
    }

    public final void setClassification(List<ClassificationInfo> list) {
        this.classification = list;
    }

    public final void setClassificationNames(List<String> list) {
        this.classificationNames = list;
    }

    public final void setDesc(String str) {
        this.desc = str;
    }

    public final void setLogoPath(String str) {
        this.logoPath = str;
    }

    public final void setLogoUrl(String str) {
        this.logoUrl = str;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setOpenTimestamp(long j) {
        this.openTimestamp = j;
    }

    public final void setType(OfflineAppType offlineAppType) {
        Intrinsics.h(offlineAppType, "<set-?>");
        this.type = offlineAppType;
    }

    public final void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        return "OfflineAppBean(appId=" + this.appId + ", version=" + this.version + ", name=" + this.name + ", type=" + this.type + ", logoUrl=" + this.logoUrl + ", logoPath=" + this.logoPath + ", category=" + this.category + ", desc=" + this.desc + ", openTimestamp=" + this.openTimestamp + ", classificationNames=" + this.classificationNames + ", classification=" + this.classification + ")";
    }
}
