package com.bykv.vk.openvk.preload.falconx.statistic;

import android.os.SystemClock;
import com.bykv.vk.openvk.preload.a.a.b;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class InterceptorModel {

    @b(a = "ac")
    public String ac;

    @b(a = "access_key")
    public String accessKey;

    @b(a = "channel")
    public String channel;

    @b(a = "err_code")
    public String errCode;

    @b(a = "err_msg")
    public String errMsg;

    @b(a = "log_id")
    public String logId;

    @b(a = "mime_type")
    public String mimeType;

    @b(a = "offline_duration")
    public Long offlineDuration;

    @b(a = "offline_rule")
    public String offlineRule;

    @b(a = "offline_status")
    public Integer offlineStatus;

    @b(a = "online_duration")
    public Long onlineDuration;

    @b(a = "page_url")
    public String pageUrl;

    @b(a = "pkg_version")
    public Long pkgVersion;

    @b(a = "res_root_dir")
    public String resRootDir;
    public Long startTime = Long.valueOf(SystemClock.uptimeMillis());

    @b(a = "resource_url")
    public String url;

    public void loadFinish(boolean z) {
        if (!z) {
            this.offlineStatus = 0;
        } else {
            this.offlineDuration = Long.valueOf(SystemClock.uptimeMillis() - this.startTime.longValue());
            this.offlineStatus = 1;
        }
    }

    public void setErrorCode(String str) {
        this.errCode = str;
    }

    public void setErrorMsg(String str) {
        this.errMsg = str;
    }
}
