package com.cloud.tmc.render.bean;

import com.cloud.tmc.kernel.model.BaseBean;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.cloud.tmc.render.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/cloud/tmc/render/bean/WebviewCacheStrategyBean;", "Lcom/cloud/tmc/kernel/model/BaseBean;", "systemWebView", "", "shellWebView", "(ZZ)V", "getShellWebView", "()Z", "setShellWebView", "(Z)V", "getSystemWebView", "setSystemWebView", "component1", "component2", "copy", "equals", OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_OTHER, "", "hashCode", "", "toString", "", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final /* data */ class WebviewCacheStrategyBean extends BaseBean {
    private boolean shellWebView;
    private boolean systemWebView;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public WebviewCacheStrategyBean() {
        this(r2, r2, 3, null);
        boolean z = false;
    }

    public WebviewCacheStrategyBean(boolean z, boolean z2) {
        this.systemWebView = z;
        this.shellWebView = z2;
    }

    public /* synthetic */ WebviewCacheStrategyBean(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? true : z2);
    }

    public static /* synthetic */ WebviewCacheStrategyBean copy$default(WebviewCacheStrategyBean webviewCacheStrategyBean, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = webviewCacheStrategyBean.systemWebView;
        }
        if ((i & 2) != 0) {
            z2 = webviewCacheStrategyBean.shellWebView;
        }
        return webviewCacheStrategyBean.copy(z, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getSystemWebView() {
        return this.systemWebView;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getShellWebView() {
        return this.shellWebView;
    }

    public final WebviewCacheStrategyBean copy(boolean systemWebView, boolean shellWebView) {
        return new WebviewCacheStrategyBean(systemWebView, shellWebView);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WebviewCacheStrategyBean)) {
            return false;
        }
        WebviewCacheStrategyBean webviewCacheStrategyBean = (WebviewCacheStrategyBean) other;
        return this.systemWebView == webviewCacheStrategyBean.systemWebView && this.shellWebView == webviewCacheStrategyBean.shellWebView;
    }

    public final boolean getShellWebView() {
        return this.shellWebView;
    }

    public final boolean getSystemWebView() {
        return this.systemWebView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.systemWebView;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z2 = this.shellWebView;
        return i + (z2 ? 1 : z2 ? 1 : 0);
    }

    public final void setShellWebView(boolean z) {
        this.shellWebView = z;
    }

    public final void setSystemWebView(boolean z) {
        this.systemWebView = z;
    }

    public String toString() {
        return "WebviewCacheStrategyBean(systemWebView=" + this.systemWebView + ", shellWebView=" + this.shellWebView + ')';
    }
}
