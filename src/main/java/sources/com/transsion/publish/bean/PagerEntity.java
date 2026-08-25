package com.transsion.publish.bean;

import androidx.annotation.Keep;
import com.transsion.gslb.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/transsion/publish/bean/PagerEntity;", "Ljava/io/Serializable;", "<init>", "()V", "page", BuildConfig.FLAVOR, "getPage", "()Ljava/lang/String;", "setPage", "(Ljava/lang/String;)V", "count", BuildConfig.FLAVOR, "getCount", "()I", "setCount", "(I)V", "totalCount", "getTotalCount", "setTotalCount", "nextPage", "getNextPage", "setNextPage", "hasMore", BuildConfig.FLAVOR, "getHasMore", "()Z", "setHasMore", "(Z)V", "Publish_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PagerEntity implements Serializable {
    private int count;
    private boolean hasMore;
    private int totalCount;
    private String page = BuildConfig.FLAVOR;
    private String nextPage = BuildConfig.FLAVOR;

    public final int getCount() {
        return this.count;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final String getNextPage() {
        return this.nextPage;
    }

    public final String getPage() {
        return this.page;
    }

    public final int getTotalCount() {
        return this.totalCount;
    }

    public final void setCount(int i) {
        this.count = i;
    }

    public final void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public final void setNextPage(String str) {
        Intrinsics.h(str, "<set-?>");
        this.nextPage = str;
    }

    public final void setPage(String str) {
        Intrinsics.h(str, "<set-?>");
        this.page = str;
    }

    public final void setTotalCount(int i) {
        this.totalCount = i;
    }
}
