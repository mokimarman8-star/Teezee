package com.cloud.tmc.integration.proxy;

import android.view.View;
import com.cloud.tmc.integration.BuildConfig;
import com.cloud.tmc.kernel.annotation.DefaultImpl;
import com.cloud.tmc.kernel.proxy.Proxiable;
import kotlin.Metadata;

@DefaultImpl("com.cloud.tmc.miniapp.defaultimpl.KeyboardImpl")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\r"}, d2 = {"Lcom/cloud/tmc/integration/proxy/IKeyboardProxy;", "Lcom/cloud/tmc/kernel/proxy/Proxiable;", "hideKeyboard", "", "v", "Landroid/view/View;", "initKeyBoardChange", "releaseKeyBoardChange", "setKeyBoardListener", "listener", "Lcom/cloud/tmc/integration/proxy/OnKeyboardListener;", "showKeyboard", "toggleSoftInput", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public interface IKeyboardProxy extends Proxiable {
    void hideKeyboard(View v);

    void initKeyBoardChange(View v);

    void releaseKeyBoardChange(View v);

    void setKeyBoardListener(OnKeyboardListener listener);

    void showKeyboard(View v);

    void toggleSoftInput(View v);
}
