package com.hisavana.common.interfacz;

import android.content.Context;
import java.lang.ref.WeakReference;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public interface IadVideo {
    boolean canShow();

    boolean isLoaded();

    void show(WeakReference<Context> weakReference, String str, String str2);
}
