package com.cloud.tmc.miniapp.point;

import android.app.Activity;
import com.cloud.tmc.kernel.annotation.DefaultImpl;
import com.cloud.tmc.kernel.extension.Extension;
import com.cloud.tmc.miniapp.dialog.OooOOO0;

@DefaultImpl("com.cloud.tmc.miniapp.defaultimpl.CreateBottomMenuImpl")
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface CreateBottomMenuPoint extends Extension {
    void buildBottomDialog(Activity activity, OooOOO0 oooOOO0);

    void requestBottomAbilityConfig();
}
