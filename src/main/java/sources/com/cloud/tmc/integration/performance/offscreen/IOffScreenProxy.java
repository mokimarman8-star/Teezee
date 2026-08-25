package com.cloud.tmc.integration.performance.offscreen;

import android.app.Activity;
import com.cloud.tmc.integration.BuildConfig;
import com.cloud.tmc.integration.event.EventConstants;
import com.cloud.tmc.integration.model.PrepareContext;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.cloud.tmc.kernel.constants.PageType;
import com.cloud.tmc.kernel.render.IRender;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH&J*\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\"\u0010\u0010\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&¨\u0006\u0012"}, d2 = {"Lcom/cloud/tmc/integration/performance/offscreen/IOffScreenProxy;", "", "destroy", "", EventConstants.ADDRESS_RENDER, "Lcom/cloud/tmc/kernel/render/IRender;", "getOffScreenRender", TmcStartParams.KEY_URL, "", "offScreenRender", "pageType", "Lcom/cloud/tmc/kernel/constants/PageType;", "activity", "Landroid/app/Activity;", "context", "Lcom/cloud/tmc/integration/model/PrepareContext;", "retryOffScreenRender", "tag", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public interface IOffScreenProxy {
    void destroy(IRender render);

    IRender getOffScreenRender(String url);

    void offScreenRender(String url, PageType pageType, Activity activity, PrepareContext context);

    void retryOffScreenRender(Activity activity, Object tag, PrepareContext context);
}
