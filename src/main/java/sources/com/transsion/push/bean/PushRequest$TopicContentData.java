package com.transsion.push.bean;

import com.transsion.push.PushConstants;
import java.util.ArrayList;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class PushRequest$TopicContentData {
    public String action;
    public String appId;
    public String appKey;
    public String appVersion;
    public int appVersionCode;
    public String clientId;
    public String gaid;
    public String sdkVersion;
    public int sdkVersionCode;

    @nl.a(name = PushConstants.SP_KEY_SUBSCRIBE_TOPICS)
    public ArrayList<String> topics;

    public String toString() {
        return "TopicContentData{clientId='" + this.clientId + "', gaid='" + this.gaid + "', appId='" + this.appId + "', appKey='" + this.appKey + "', appVersion='" + this.appVersion + "', appVersionCode='" + this.appVersionCode + "', sdkVersion='" + this.sdkVersion + "', sdkVersionCode='" + this.sdkVersionCode + "', topics=" + this.topics + ", action='" + this.action + "'}";
    }
}
