package com.cloud.tmc.miniapp.base;

import androidx.collection.s;
import com.cloud.tmc.integration.chain.page.PageChainContext;
import com.cloud.tmc.miniapp.base.MiniAppH5BaseFragment;
import com.cloud.tmc.miniutils.constant.MemoryConstants;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class ShowPageData {
    private boolean isRedirect;
    private boolean loadFail;
    private String originalUrl;
    private PageChainContext pageChainContext;
    private String pageRandomIdByGAID;
    private ConcurrentHashMap<Integer, Long> progressCollectList;
    private MiniAppH5BaseFragment.ProgressStep progressCurrentStep;
    private long progressStartTime;
    private String requestUrl;
    private ShowPageStatus status;
    private String url;
    private String virtual_h5PageId;

    public ShowPageData(String str, String str2, String str3, String str4, ShowPageStatus showPageStatus, boolean z, String str5, PageChainContext pageChainContext, boolean z2, ConcurrentHashMap<Integer, Long> concurrentHashMap, MiniAppH5BaseFragment.ProgressStep progressStep, long j) {
        Intrinsics.h(str, "originalUrl");
        Intrinsics.h(str2, "url");
        Intrinsics.h(str3, "requestUrl");
        Intrinsics.h(str4, "virtual_h5PageId");
        Intrinsics.h(showPageStatus, "status");
        Intrinsics.h(str5, "pageRandomIdByGAID");
        Intrinsics.h(concurrentHashMap, "progressCollectList");
        this.originalUrl = str;
        this.url = str2;
        this.requestUrl = str3;
        this.virtual_h5PageId = str4;
        this.status = showPageStatus;
        this.loadFail = z;
        this.pageRandomIdByGAID = str5;
        this.pageChainContext = pageChainContext;
        this.isRedirect = z2;
        this.progressCollectList = concurrentHashMap;
        this.progressCurrentStep = progressStep;
        this.progressStartTime = j;
    }

    public /* synthetic */ ShowPageData(String str, String str2, String str3, String str4, ShowPageStatus showPageStatus, boolean z, String str5, PageChainContext pageChainContext, boolean z2, ConcurrentHashMap concurrentHashMap, MiniAppH5BaseFragment.ProgressStep progressStep, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, (i & 16) != 0 ? ShowPageStatus.SHOULDOVERRIDEURKLOADING : showPageStatus, (i & 32) != 0 ? false : z, (i & 64) != 0 ? "" : str5, (i & 128) != 0 ? null : pageChainContext, (i & 256) != 0 ? false : z2, (i & 512) != 0 ? new ConcurrentHashMap() : concurrentHashMap, (i & MemoryConstants.KB) != 0 ? null : progressStep, (i & 2048) != 0 ? System.currentTimeMillis() : j);
    }

    public final String component1() {
        return this.originalUrl;
    }

    public final ConcurrentHashMap<Integer, Long> component10() {
        return this.progressCollectList;
    }

    public final MiniAppH5BaseFragment.ProgressStep component11() {
        return this.progressCurrentStep;
    }

    public final long component12() {
        return this.progressStartTime;
    }

    public final String component2() {
        return this.url;
    }

    public final String component3() {
        return this.requestUrl;
    }

    public final String component4() {
        return this.virtual_h5PageId;
    }

    public final ShowPageStatus component5() {
        return this.status;
    }

    public final boolean component6() {
        return this.loadFail;
    }

    public final String component7() {
        return this.pageRandomIdByGAID;
    }

    public final PageChainContext component8() {
        return this.pageChainContext;
    }

    public final boolean component9() {
        return this.isRedirect;
    }

    public final ShowPageData copy(String str, String str2, String str3, String str4, ShowPageStatus showPageStatus, boolean z, String str5, PageChainContext pageChainContext, boolean z2, ConcurrentHashMap<Integer, Long> concurrentHashMap, MiniAppH5BaseFragment.ProgressStep progressStep, long j) {
        Intrinsics.h(str, "originalUrl");
        Intrinsics.h(str2, "url");
        Intrinsics.h(str3, "requestUrl");
        Intrinsics.h(str4, "virtual_h5PageId");
        Intrinsics.h(showPageStatus, "status");
        Intrinsics.h(str5, "pageRandomIdByGAID");
        Intrinsics.h(concurrentHashMap, "progressCollectList");
        return new ShowPageData(str, str2, str3, str4, showPageStatus, z, str5, pageChainContext, z2, concurrentHashMap, progressStep, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShowPageData)) {
            return false;
        }
        ShowPageData showPageData = (ShowPageData) obj;
        return Intrinsics.c(this.originalUrl, showPageData.originalUrl) && Intrinsics.c(this.url, showPageData.url) && Intrinsics.c(this.requestUrl, showPageData.requestUrl) && Intrinsics.c(this.virtual_h5PageId, showPageData.virtual_h5PageId) && this.status == showPageData.status && this.loadFail == showPageData.loadFail && Intrinsics.c(this.pageRandomIdByGAID, showPageData.pageRandomIdByGAID) && Intrinsics.c(this.pageChainContext, showPageData.pageChainContext) && this.isRedirect == showPageData.isRedirect && Intrinsics.c(this.progressCollectList, showPageData.progressCollectList) && this.progressCurrentStep == showPageData.progressCurrentStep && this.progressStartTime == showPageData.progressStartTime;
    }

    public final boolean getLoadFail() {
        return this.loadFail;
    }

    public final String getOriginalUrl() {
        return this.originalUrl;
    }

    public final PageChainContext getPageChainContext() {
        return this.pageChainContext;
    }

    public final String getPageRandomIdByGAID() {
        return this.pageRandomIdByGAID;
    }

    public final ConcurrentHashMap<Integer, Long> getProgressCollectList() {
        return this.progressCollectList;
    }

    public final MiniAppH5BaseFragment.ProgressStep getProgressCurrentStep() {
        return this.progressCurrentStep;
    }

    public final long getProgressStartTime() {
        return this.progressStartTime;
    }

    public final String getRequestUrl() {
        return this.requestUrl;
    }

    public final ShowPageStatus getStatus() {
        return this.status;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getVirtual_h5PageId() {
        return this.virtual_h5PageId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = (this.status.hashCode() + ((this.virtual_h5PageId.hashCode() + ((this.requestUrl.hashCode() + ((this.url.hashCode() + (this.originalUrl.hashCode() * 31)) * 31)) * 31)) * 31)) * 31;
        boolean z = this.loadFail;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int hashCode2 = (this.pageRandomIdByGAID.hashCode() + ((hashCode + i) * 31)) * 31;
        PageChainContext pageChainContext = this.pageChainContext;
        int hashCode3 = (hashCode2 + (pageChainContext == null ? 0 : pageChainContext.hashCode())) * 31;
        boolean z2 = this.isRedirect;
        int hashCode4 = (this.progressCollectList.hashCode() + ((hashCode3 + (z2 ? 1 : z2 ? 1 : 0)) * 31)) * 31;
        MiniAppH5BaseFragment.ProgressStep progressStep = this.progressCurrentStep;
        return s.a(this.progressStartTime) + ((hashCode4 + (progressStep != null ? progressStep.hashCode() : 0)) * 31);
    }

    public final boolean isRedirect() {
        return this.isRedirect;
    }

    public final void setLoadFail(boolean z) {
        this.loadFail = z;
    }

    public final void setOriginalUrl(String str) {
        Intrinsics.h(str, "<set-?>");
        this.originalUrl = str;
    }

    public final void setPageChainContext(PageChainContext pageChainContext) {
        this.pageChainContext = pageChainContext;
    }

    public final void setPageRandomIdByGAID(String str) {
        Intrinsics.h(str, "<set-?>");
        this.pageRandomIdByGAID = str;
    }

    public final void setProgressCollectList(ConcurrentHashMap<Integer, Long> concurrentHashMap) {
        Intrinsics.h(concurrentHashMap, "<set-?>");
        this.progressCollectList = concurrentHashMap;
    }

    public final void setProgressCurrentStep(MiniAppH5BaseFragment.ProgressStep progressStep) {
        this.progressCurrentStep = progressStep;
    }

    public final void setProgressStartTime(long j) {
        this.progressStartTime = j;
    }

    public final void setRedirect(boolean z) {
        this.isRedirect = z;
    }

    public final void setRequestUrl(String str) {
        Intrinsics.h(str, "<set-?>");
        this.requestUrl = str;
    }

    public final void setStatus(ShowPageStatus showPageStatus) {
        Intrinsics.h(showPageStatus, "<set-?>");
        this.status = showPageStatus;
    }

    public final void setUrl(String str) {
        Intrinsics.h(str, "<set-?>");
        this.url = str;
    }

    public final void setVirtual_h5PageId(String str) {
        Intrinsics.h(str, "<set-?>");
        this.virtual_h5PageId = str;
    }

    public String toString() {
        return "ShowPageData(originalUrl=" + this.originalUrl + ", url=" + this.url + ", requestUrl=" + this.requestUrl + ", virtual_h5PageId=" + this.virtual_h5PageId + ", status=" + this.status + ", loadFail=" + this.loadFail + ", pageRandomIdByGAID=" + this.pageRandomIdByGAID + ", pageChainContext=" + this.pageChainContext + ", isRedirect=" + this.isRedirect + ", progressCollectList=" + this.progressCollectList + ", progressCurrentStep=" + this.progressCurrentStep + ", progressStartTime=" + this.progressStartTime + ")";
    }
}
