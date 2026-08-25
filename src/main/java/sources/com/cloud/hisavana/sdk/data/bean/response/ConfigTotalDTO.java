package com.cloud.hisavana.sdk.data.bean.response;

import com.cloud.hisavana.sdk.data.bean.response.ccofig.CustomConfigs;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class ConfigTotalDTO {
    private Boolean abTestEnable;
    private List<String> adInternalBlackBrands;
    private Boolean adInternalRequestEnable;
    private Boolean antifraudPowerEnable;
    private String antifraudSubfunctionControl;
    private Integer cdnVersionAddressRequestTimeInterval;
    private Integer clickDataSyncTimeInterval;
    private Integer cloudControlCacheInterval;
    private String cloudControlVersion;
    private List<ConfigCodeSeatDTO> codeSeats;
    private CustomConfigs customConfigs;
    private Integer defaultAdRequestTimeInterval;
    private String extInfo;
    private boolean initPolyGammaEnable;
    private Boolean preConnectEnable;
    private Integer showDataSyncTimeInterval;
    private boolean showTrackingNewPowerEnable;
    private String sspUrl;
    private boolean showRuStyle = false;
    private Boolean initOmIdEnable = Boolean.FALSE;

    public Boolean getAbTestEnable() {
        Boolean bool = this.abTestEnable;
        return Boolean.valueOf(bool == null ? false : bool.booleanValue());
    }

    public List<String> getAdInternalBlackBrands() {
        return this.adInternalBlackBrands;
    }

    public boolean getAdInternalRequestEnable() {
        Boolean bool = this.adInternalRequestEnable;
        return bool == null || bool.booleanValue();
    }

    public Boolean getAntifraudPowerEnable() {
        return this.antifraudPowerEnable;
    }

    public String getAntifraudSubfunctionControl() {
        return this.antifraudSubfunctionControl;
    }

    public Integer getCdnVersionAddressRequestTimeInterval() {
        Integer num = this.cdnVersionAddressRequestTimeInterval;
        return Integer.valueOf(num == null ? 1440 : num.intValue());
    }

    public Integer getClickDataSyncTimeInterval() {
        Integer num = this.clickDataSyncTimeInterval;
        return Integer.valueOf(num == null ? -1 : num.intValue());
    }

    public Integer getCloudControlCacheInterval() {
        return this.cloudControlCacheInterval;
    }

    public String getCloudControlVersion() {
        return this.cloudControlVersion;
    }

    public List<ConfigCodeSeatDTO> getCodeSeats() {
        return this.codeSeats;
    }

    public CustomConfigs getCustomConfigs() {
        return this.customConfigs;
    }

    public String getExtInfo() {
        return this.extInfo;
    }

    public Boolean getPreConnectEnable() {
        return this.preConnectEnable;
    }

    public Integer getShowDataSyncTimeInterval() {
        Integer num = this.showDataSyncTimeInterval;
        return Integer.valueOf(num == null ? -1 : num.intValue());
    }

    public String getSspUrl() {
        return this.sspUrl;
    }

    public boolean isInitPolyGammaEnable() {
        return this.initPolyGammaEnable;
    }

    public boolean isOmIdEnabled() {
        return this.initOmIdEnable.booleanValue();
    }

    public boolean isShowRuStyle() {
        return this.showRuStyle;
    }

    public boolean isShowTrackingNewPowerEnable() {
        return this.showTrackingNewPowerEnable;
    }

    public void setAbTestEnable(Boolean bool) {
        this.abTestEnable = bool;
    }

    public void setAntifraudPowerEnable(Boolean bool) {
        this.antifraudPowerEnable = bool;
    }

    public void setAntifraudSubfunctionControl(String str) {
        this.antifraudSubfunctionControl = str;
    }

    public void setCdnVersionAddressRequestTimeInterval(Integer num) {
        this.cdnVersionAddressRequestTimeInterval = num;
    }

    public void setClickDataSyncTimeInterval(Integer num) {
        this.clickDataSyncTimeInterval = num;
    }

    public void setCloudControlCacheInterval(Integer num) {
        this.cloudControlCacheInterval = num;
    }

    public void setCloudControlVersion(String str) {
        this.cloudControlVersion = str;
    }

    public void setCodeSeats(List<ConfigCodeSeatDTO> list) {
        this.codeSeats = list;
    }

    public void setCustomConfigs(CustomConfigs customConfigs) {
        this.customConfigs = customConfigs;
    }

    public void setInitPolyGammaEnable(boolean z) {
        this.initPolyGammaEnable = z;
    }

    public void setPreConnectEnable(Boolean bool) {
        this.preConnectEnable = bool;
    }

    public void setShowDataSyncTimeInterval(Integer num) {
        this.showDataSyncTimeInterval = num;
    }

    public void setShowTrackingNewPowerEnable(boolean z) {
        this.showTrackingNewPowerEnable = z;
    }

    public void setSspUrl(String str) {
        this.sspUrl = str;
    }

    public String toString() {
        return "ConfigTotalDTO{showTrackingNewPowerEnable=" + this.showTrackingNewPowerEnable + ", cloudControlVersion='" + this.cloudControlVersion + "', preConnectEnable=" + this.preConnectEnable + ", codeSeats=" + this.codeSeats + ", cdnVersionAddressRequestTimeInterval=" + this.cdnVersionAddressRequestTimeInterval + ", cloudControlCacheInterval=" + this.cloudControlCacheInterval + ", adInternalBlackBrands=" + this.adInternalBlackBrands + ", showRUStyle=" + this.showRuStyle + ", abTestEnable=" + this.abTestEnable + ", initPolyGammaEnable=" + this.initPolyGammaEnable + ", adInternalRequestEnable=" + this.adInternalRequestEnable + ", showDataSyncTimeInterval=" + this.showDataSyncTimeInterval + ", clickDataSyncTimeInterval=" + this.clickDataSyncTimeInterval + ", initOmIdEnable=" + this.initOmIdEnable.toString() + ", extInfo=" + this.extInfo + ", customConfigs=" + this.customConfigs + '}';
    }
}
