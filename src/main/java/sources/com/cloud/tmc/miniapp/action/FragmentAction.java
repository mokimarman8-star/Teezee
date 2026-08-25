package com.cloud.tmc.miniapp.action;

import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.ui.fragment.TmcFragment;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface FragmentAction {
    boolean exitPage(Page page, boolean z, boolean z2);

    void pushPage(Page page, TmcFragment tmcFragment, boolean z);

    void resetFragmentToTop(TmcFragment tmcFragment);
}
