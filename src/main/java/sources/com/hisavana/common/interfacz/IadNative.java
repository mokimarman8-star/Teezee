package com.hisavana.common.interfacz;

import android.view.View;
import android.view.ViewGroup;
import com.hisavana.common.bean.AdNativeInfo;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public interface IadNative {
    void registerViewForInteraction(ViewGroup viewGroup, List<View> list, AdNativeInfo adNativeInfo);

    void unregisterView(AdNativeInfo adNativeInfo);
}
