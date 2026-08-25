package com.cloud.tmc.integration.structure.ui;

import android.view.View;
import androidx.annotation.Nullable;
import com.cloud.tmc.integration.structure.Page;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public interface TitleBar {
    void attachPage(Page page);

    boolean getAddScreenVisibility();

    View getContent();

    Integer getHomeAction();

    boolean isTransparent();

    void setAddScreenVisibility(boolean z);

    void setHomeAction(int i, boolean z);

    void setHomeVisibility(boolean z);

    void setOnAddScreenClickListener(View.OnClickListener onClickListener);

    void setOnBackClickListener(View.OnClickListener onClickListener);

    void setOnHomeClickListener(View.OnClickListener onClickListener);

    void setThemeMode(int i);

    void setTitle(@Nullable String str);

    void setTitleBarVisible(boolean z);

    void setTitleColor(boolean z);

    void setTitleVisible(boolean z);

    void setTransparent(boolean z);
}
