package com.hisavana.common.bean;

import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010Z\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\tR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\tR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0007\"\u0004\b\"\u0010\tR\u001e\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010*\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0007\"\u0004\b,\u0010\tR\u001c\u0010-\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0007\"\u0004\b/\u0010\tR\u001c\u00100\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0007\"\u0004\b2\u0010\tR\u001e\u00103\u001a\u0004\u0018\u000104X\u0086\u000e¢\u0006\u0010\n\u0002\u00108\u001a\u0004\b3\u00105\"\u0004\b6\u00107R\u001c\u00109\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0007\"\u0004\b;\u0010\tR\u001c\u0010<\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0007\"\u0004\b>\u0010\tR\u001c\u0010?\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0007\"\u0004\bA\u0010\tR\u001e\u0010B\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\bC\u0010&\"\u0004\bD\u0010(R\u001c\u0010E\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0007\"\u0004\bG\u0010\tR\u001e\u0010H\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\bI\u0010\r\"\u0004\bJ\u0010\u000fR\u001c\u0010K\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0007\"\u0004\bM\u0010\tR\u001e\u0010N\u001a\u0004\u0018\u000104X\u0086\u000e¢\u0006\u0010\n\u0002\u00108\u001a\u0004\bN\u00105\"\u0004\bO\u00107R\u001a\u0010P\u001a\u000204X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u001c\u0010T\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\u0007\"\u0004\bV\u0010\tR\u001c\u0010W\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\u0007\"\u0004\bY\u0010\t¨\u0006["}, d2 = {"Lcom/hisavana/common/bean/AdditionalInfo;", TtmlNode.ANONYMOUS_REGION_ID, "<init>", "()V", "placementId", TtmlNode.ANONYMOUS_REGION_ID, "getPlacementId", "()Ljava/lang/String;", "setPlacementId", "(Ljava/lang/String;)V", "source", TtmlNode.ANONYMOUS_REGION_ID, "getSource", "()Ljava/lang/Integer;", "setSource", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "applicationId", "getApplicationId", "setApplicationId", "applicationKey", "getApplicationKey", "setApplicationKey", "codeSeatId", "getCodeSeatId", "setCodeSeatId", "errorCode", "Lcom/hisavana/common/bean/TAdErrorCode;", "getErrorCode", "()Lcom/hisavana/common/bean/TAdErrorCode;", "setErrorCode", "(Lcom/hisavana/common/bean/TAdErrorCode;)V", "mcc", "getMcc", "setMcc", TrackingKey.ECPM, TtmlNode.ANONYMOUS_REGION_ID, "getEcpm", "()Ljava/lang/Double;", "setEcpm", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "precision", "getPrecision", "setPrecision", "currency", "getCurrency", "setCurrency", "triggerId", "getTriggerId", "setTriggerId", "isBidding", TtmlNode.ANONYMOUS_REGION_ID, "()Ljava/lang/Boolean;", "setBidding", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "trafficGroupId", "getTrafficGroupId", "setTrafficGroupId", "experimentGroupId", "getExperimentGroupId", "setExperimentGroupId", "sdkVersion", "getSdkVersion", "setSdkVersion", "admobECPM", "getAdmobECPM", "setAdmobECPM", "currencyCode", "getCurrencyCode", "setCurrencyCode", "precisionType", "getPrecisionType", "setPrecisionType", "mediatorSource", "getMediatorSource", "setMediatorSource", "isInternalAd", "setInternalAd", "isCollapsibleBanner", "()Z", "setCollapsibleBanner", "(Z)V", "packageName", "getPackageName", "setPackageName", "imageUrl", "getImageUrl", "setImageUrl", "toString", "common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class AdditionalInfo {
    private Double admobECPM;
    private String currency;
    private String currencyCode;

    /* renamed from: ecpm, reason: from kotlin metadata and from toString */
    private Double eCPM;
    private TAdErrorCode errorCode;
    private String experimentGroupId;
    private String imageUrl;
    private Boolean isBidding;
    private boolean isCollapsibleBanner;
    private Boolean isInternalAd;
    private String mediatorSource;
    private String packageName;
    private String precision;
    private Integer precisionType;
    private String sdkVersion;
    private String trafficGroupId;
    private String triggerId;
    private String placementId = TtmlNode.ANONYMOUS_REGION_ID;
    private Integer source = -1;
    private String applicationId = TtmlNode.ANONYMOUS_REGION_ID;
    private String applicationKey = TtmlNode.ANONYMOUS_REGION_ID;
    private String codeSeatId = TtmlNode.ANONYMOUS_REGION_ID;
    private String mcc = TtmlNode.ANONYMOUS_REGION_ID;

    public AdditionalInfo() {
        Double valueOf = Double.valueOf(0.0d);
        this.eCPM = valueOf;
        this.precision = TtmlNode.ANONYMOUS_REGION_ID;
        this.currency = TtmlNode.ANONYMOUS_REGION_ID;
        this.triggerId = TtmlNode.ANONYMOUS_REGION_ID;
        Boolean bool = Boolean.FALSE;
        this.isBidding = bool;
        this.trafficGroupId = TtmlNode.ANONYMOUS_REGION_ID;
        this.experimentGroupId = TtmlNode.ANONYMOUS_REGION_ID;
        this.sdkVersion = TtmlNode.ANONYMOUS_REGION_ID;
        this.admobECPM = valueOf;
        this.currencyCode = TtmlNode.ANONYMOUS_REGION_ID;
        this.precisionType = -1;
        this.mediatorSource = TtmlNode.ANONYMOUS_REGION_ID;
        this.isInternalAd = bool;
        this.packageName = TtmlNode.ANONYMOUS_REGION_ID;
        this.imageUrl = TtmlNode.ANONYMOUS_REGION_ID;
    }

    public final Double getAdmobECPM() {
        return this.admobECPM;
    }

    public final String getApplicationId() {
        return this.applicationId;
    }

    public final String getApplicationKey() {
        return this.applicationKey;
    }

    public final String getCodeSeatId() {
        return this.codeSeatId;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final String getCurrencyCode() {
        return this.currencyCode;
    }

    /* renamed from: getEcpm, reason: from getter */
    public final Double getECPM() {
        return this.eCPM;
    }

    public final TAdErrorCode getErrorCode() {
        return this.errorCode;
    }

    public final String getExperimentGroupId() {
        return this.experimentGroupId;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getMcc() {
        return this.mcc;
    }

    public final String getMediatorSource() {
        return this.mediatorSource;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getPlacementId() {
        return this.placementId;
    }

    public final String getPrecision() {
        return this.precision;
    }

    public final Integer getPrecisionType() {
        return this.precisionType;
    }

    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    public final Integer getSource() {
        return this.source;
    }

    public final String getTrafficGroupId() {
        return this.trafficGroupId;
    }

    public final String getTriggerId() {
        return this.triggerId;
    }

    /* renamed from: isBidding, reason: from getter */
    public final Boolean getIsBidding() {
        return this.isBidding;
    }

    /* renamed from: isCollapsibleBanner, reason: from getter */
    public final boolean getIsCollapsibleBanner() {
        return this.isCollapsibleBanner;
    }

    /* renamed from: isInternalAd, reason: from getter */
    public final Boolean getIsInternalAd() {
        return this.isInternalAd;
    }

    public final void setAdmobECPM(Double d) {
        this.admobECPM = d;
    }

    public final void setApplicationId(String str) {
        this.applicationId = str;
    }

    public final void setApplicationKey(String str) {
        this.applicationKey = str;
    }

    public final void setBidding(Boolean bool) {
        this.isBidding = bool;
    }

    public final void setCodeSeatId(String str) {
        this.codeSeatId = str;
    }

    public final void setCollapsibleBanner(boolean z) {
        this.isCollapsibleBanner = z;
    }

    public final void setCurrency(String str) {
        this.currency = str;
    }

    public final void setCurrencyCode(String str) {
        this.currencyCode = str;
    }

    public final void setEcpm(Double d) {
        this.eCPM = d;
    }

    public final void setErrorCode(TAdErrorCode tAdErrorCode) {
        this.errorCode = tAdErrorCode;
    }

    public final void setExperimentGroupId(String str) {
        this.experimentGroupId = str;
    }

    public final void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public final void setInternalAd(Boolean bool) {
        this.isInternalAd = bool;
    }

    public final void setMcc(String str) {
        this.mcc = str;
    }

    public final void setMediatorSource(String str) {
        this.mediatorSource = str;
    }

    public final void setPackageName(String str) {
        this.packageName = str;
    }

    public final void setPlacementId(String str) {
        this.placementId = str;
    }

    public final void setPrecision(String str) {
        this.precision = str;
    }

    public final void setPrecisionType(Integer num) {
        this.precisionType = num;
    }

    public final void setSdkVersion(String str) {
        this.sdkVersion = str;
    }

    public final void setSource(Integer num) {
        this.source = num;
    }

    public final void setTrafficGroupId(String str) {
        this.trafficGroupId = str;
    }

    public final void setTriggerId(String str) {
        this.triggerId = str;
    }

    public String toString() {
        return "AdditionalInfo(placementId=" + this.placementId + ", source=" + this.source + ", applicationId=" + this.applicationId + ", applicationKey=" + this.applicationKey + ", codeSeatId=" + this.codeSeatId + ", errorCode=" + this.errorCode + ", mcc=" + this.mcc + ", eCPM=" + this.eCPM + ", precision=" + this.precision + ", currency=" + this.currency + ", triggerId=" + this.triggerId + ", isBidding=" + this.isBidding + ", trafficGroupId=" + this.trafficGroupId + ", experimentGroupId=" + this.experimentGroupId + ", sdkVersion=" + this.sdkVersion + ", admobECPM=" + this.admobECPM + ", currencyCode=" + this.currencyCode + ", precisionType=" + this.precisionType + ", mediatorSource=" + this.mediatorSource + ", isInternalAd=" + this.isInternalAd + ", packageName=" + this.packageName + ", imageUrl=" + this.imageUrl + ", isCollapsibleBanner=" + this.isCollapsibleBanner + ')';
    }
}
