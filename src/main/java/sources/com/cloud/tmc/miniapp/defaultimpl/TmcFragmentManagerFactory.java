package com.cloud.tmc.miniapp.defaultimpl;

import androidx.fragment.app.FragmentActivity;
import com.cloud.tmc.integration.proxy.IFragmentManagerFactory;
import com.cloud.tmc.integration.ui.fragment.IFragmentManager;
import com.cloud.tmc.miniapp.R;
import com.cloud.tmc.miniapp.ui.TmcFragmentManager;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class TmcFragmentManagerFactory implements IFragmentManagerFactory {
    public IFragmentManager createFragmentManager(FragmentActivity fragmentActivity) {
        Intrinsics.h(fragmentActivity, "activity");
        return new TmcFragmentManager(fragmentActivity, R.id.main);
    }
}
