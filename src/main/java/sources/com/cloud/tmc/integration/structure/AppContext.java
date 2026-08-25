package com.cloud.tmc.integration.structure;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public interface AppContext {
    void destroy();

    void exitPage(@NonNull Page page, boolean z);

    Intent getActivityStartIntent();

    Context getContext();

    boolean isTaskRoot();

    boolean moveToBackground();

    boolean pushPage(@NonNull Page page);

    void pushWebViewPage(@NonNull Page page);

    void start(@NonNull Page page);

    void switchTab(@NonNull Page page);
}
