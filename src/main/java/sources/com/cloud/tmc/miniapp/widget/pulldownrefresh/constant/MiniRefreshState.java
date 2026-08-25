package com.cloud.tmc.miniapp.widget.pulldownrefresh.constant;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public enum MiniRefreshState {
    NONE(0, false, false, false, false, false),
    PULL_DOWN_TO_REFRESH(1, true, false, false, false, false),
    PULL_UP_TO_LOAD(2, true, false, false, false, false),
    PULL_DOWN_CANCELED(1, false, false, false, false, false),
    PULL_UP_CANCELED(2, false, false, false, false, false),
    RELEASE_TO_REFRESH(1, true, false, false, false, true),
    RELEASE_TO_LOAD(2, true, false, false, false, true),
    RELEASE_TO_TWO_LEVEL(1, true, false, false, true, true),
    TWO_LEVEL_RELEASED(1, false, false, false, true, false),
    REFRESH_RELEASED(1, false, false, false, false, false),
    LOAD_RELEASED(2, false, false, false, false, false),
    REFRESHING(1, false, true, false, false, false),
    LOADING(2, false, true, false, false, false),
    TwoLevel(1, false, true, false, true, false),
    REFRESH_FINISH(1, false, false, true, false, false),
    LOAD_FINISH(2, false, false, true, false, false),
    TwoLevelFinish(1, false, false, true, true, false);

    public final boolean isDragging;
    public final boolean isFinishing;
    public final boolean isFooter;
    public final boolean isHeader;
    public final boolean isOpening;
    public final boolean isReleaseToOpening;
    public final boolean isTwoLevel;

    MiniRefreshState(int i, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.isHeader = i == 1;
        this.isFooter = i == 2;
        this.isDragging = z;
        this.isOpening = z2;
        this.isFinishing = z3;
        this.isTwoLevel = z4;
        this.isReleaseToOpening = z5;
    }

    public MiniRefreshState toFooter() {
        return (!this.isHeader || this.isTwoLevel) ? this : values()[ordinal() + 1];
    }

    public MiniRefreshState toHeader() {
        return (!this.isFooter || this.isTwoLevel) ? this : values()[ordinal() - 1];
    }
}
