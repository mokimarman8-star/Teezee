package com.cloud.hisavana.sdk.data.bean.request;

import com.cloud.hisavana.sdk.common.bean.SSPWebPageReqInfo;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class CodeSeatDTO {
    private int adCount;
    private int adPriority;
    private Map<String, Object> extInfo;
    private String gameName;
    private String gameScene;
    private int height;
    private String id;
    private boolean offlineAdEnable;
    public OmSdk omSdk;
    private int type;
    private SdkVideo video;
    private SSPWebPageReqInfo webPageInfo;
    private int width;

    public int getAdCount() {
        return this.adCount;
    }

    public int getAdPriority() {
        return this.adPriority;
    }

    public Map<String, Object> getExtInfo() {
        return this.extInfo;
    }

    public String getGameName() {
        return this.gameName;
    }

    public String getGameScene() {
        return this.gameScene;
    }

    public int getHeight() {
        return this.height;
    }

    public String getId() {
        return this.id;
    }

    public OmSdk getOmSdk() {
        return this.omSdk;
    }

    public int getType() {
        return this.type;
    }

    public SdkVideo getVideo() {
        return this.video;
    }

    public SSPWebPageReqInfo getWebPageInfo() {
        return this.webPageInfo;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isOfflineAdEnable() {
        return this.offlineAdEnable;
    }

    public void setAdCount(int i) {
        this.adCount = i;
    }

    public void setAdPriority(int i) {
        this.adPriority = i;
    }

    public void setExtInfo(Map<String, Object> map) {
        this.extInfo = map;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public void setGameScene(String str) {
        this.gameScene = str;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setOfflineAdEnable(boolean z) {
        this.offlineAdEnable = z;
    }

    public void setOmSdk(OmSdk omSdk) {
        this.omSdk = omSdk;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setVideo(SdkVideo sdkVideo) {
        this.video = sdkVideo;
    }

    public void setWebPageInfo(SSPWebPageReqInfo sSPWebPageReqInfo) {
        this.webPageInfo = sSPWebPageReqInfo;
    }

    public void setWidth(int i) {
        this.width = i;
    }
}
