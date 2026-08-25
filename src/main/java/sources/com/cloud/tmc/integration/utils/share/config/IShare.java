package com.cloud.tmc.integration.utils.share.config;

import com.cloud.tmc.integration.BuildConfig;
import com.cloud.tmc.integration.utils.share.OnShareListener;
import com.cloud.tmc.integration.utils.share.ShareParams;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/cloud/tmc/integration/utils/share/config/IShare;", "", "share", "", "shareParams", "Lcom/cloud/tmc/integration/utils/share/ShareParams;", "listener", "Lcom/cloud/tmc/integration/utils/share/OnShareListener;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public interface IShare {
    void share(ShareParams shareParams, OnShareListener listener);
}
