package com.transsion.publish.net;

import androidx.annotation.Keep;
import com.transsion.gslb.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/transsion/publish/net/PostResuleEntity;", "Ljava/io/Serializable;", "<init>", "()V", "postId", BuildConfig.FLAVOR, "getPostId", "()Ljava/lang/String;", "setPostId", "(Ljava/lang/String;)V", "score", "getScore", "setScore", "Publish_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PostResuleEntity implements Serializable {
    private String postId = BuildConfig.FLAVOR;
    private String score = "0";

    public final String getPostId() {
        return this.postId;
    }

    public final String getScore() {
        return this.score;
    }

    public final void setPostId(String str) {
        Intrinsics.h(str, "<set-?>");
        this.postId = str;
    }

    public final void setScore(String str) {
        Intrinsics.h(str, "<set-?>");
        this.score = str;
    }
}
