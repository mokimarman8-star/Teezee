package com.transsion.publish.bean;

import androidx.annotation.Keep;
import com.transsion.gslb.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0005R\u001a\u0010\u0010\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0005¨\u0006\u0015"}, d2 = {"Lcom/transsion/publish/bean/PublishValue;", "Ljava/io/Serializable;", "fileType", BuildConfig.FLAVOR, "<init>", "(I)V", "uploadUrl", BuildConfig.FLAVOR, "getUploadUrl", "()Ljava/lang/String;", "setUploadUrl", "(Ljava/lang/String;)V", "state", "getState", "()I", "setState", "progress", "getProgress", "setProgress", "getFileType", "setFileType", "Publish_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PublishValue implements Serializable {
    private int fileType;
    private int progress;
    private int state;
    private String uploadUrl = BuildConfig.FLAVOR;

    public PublishValue(int i) {
        this.fileType = i;
    }

    public final int getFileType() {
        return this.fileType;
    }

    public final int getProgress() {
        return this.progress;
    }

    public final int getState() {
        return this.state;
    }

    public final String getUploadUrl() {
        return this.uploadUrl;
    }

    public final void setFileType(int i) {
        this.fileType = i;
    }

    public final void setProgress(int i) {
        this.progress = i;
    }

    public final void setState(int i) {
        this.state = i;
    }

    public final void setUploadUrl(String str) {
        Intrinsics.h(str, "<set-?>");
        this.uploadUrl = str;
    }
}
