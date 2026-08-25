package com.cloud.tmc.miniapp.defaultimpl;

import com.cloud.tmc.integration.proxy.IRefreshProxy;
import com.cloud.tmc.integration.ui.fragment.TmcFragment;
import com.cloud.tmc.miniapp.base.MiniAppBaseFragment;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class RefreshProxyImpl implements IRefreshProxy {
    public void enableLoadMore(TmcFragment tmcFragment, boolean z) {
        if (tmcFragment instanceof MiniAppBaseFragment) {
            ((MiniAppBaseFragment) tmcFragment).enableLoadMore(z);
        }
    }

    public void enableRefresh(TmcFragment tmcFragment, boolean z) {
        if (tmcFragment instanceof MiniAppBaseFragment) {
            ((MiniAppBaseFragment) tmcFragment).enableRefresh(z);
        }
    }

    public boolean startPullDownRefresh(TmcFragment tmcFragment) {
        if (tmcFragment instanceof MiniAppBaseFragment) {
            return ((MiniAppBaseFragment) tmcFragment).startRefresh();
        }
        return false;
    }

    public boolean stopPullDownRefresh(TmcFragment tmcFragment) {
        if (tmcFragment instanceof MiniAppBaseFragment) {
            return ((MiniAppBaseFragment) tmcFragment).stopRefresh();
        }
        return false;
    }

    public boolean stopPullUpRefresh(TmcFragment tmcFragment) {
        if (tmcFragment instanceof MiniAppBaseFragment) {
            return ((MiniAppBaseFragment) tmcFragment).stopLoadMore();
        }
        return false;
    }
}
