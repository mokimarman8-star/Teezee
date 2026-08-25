package com.cloud.tmc.kernel.node;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface TitleBarNode {

    @Retention(RetentionPolicy.SOURCE)
    public @interface HomeAction {
    }

    public interface HomeActionMode {
        public static final int ALL = 2;
        public static final int BACK = 1;
        public static final int HOME = 0;
    }

    public interface ThemeColorMode {
        public static final int BLACK = 1;
        public static final int WHITE = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ThemeMode {
    }

    void changeNavigationBarProgress(int i, int i2, long j);

    boolean getAddScreenVisibleStatus();

    void hideAddScreenButton();

    void hideHomeButton();

    void hideNavigationBarLoading();

    boolean isTransparent();

    void setCapsuleStyle(boolean z);

    void setHomeAction(int i, boolean z);

    void setNavigationBarBackgroundColor(String str);

    void setNavigationBarIconStyle(boolean z);

    void setNavigationBarTitle(String str);

    void setNavigationBarTitleColor(boolean z);

    void setNavigationBarTitleVisible(boolean z);

    void setNavigationBarTransparent(boolean z);

    void setStatusBar(boolean z);

    void setTitleBarVisible(boolean z);

    void showAddScreenButton();

    void showHomeButton();

    void showNavigationBarLoading();
}
