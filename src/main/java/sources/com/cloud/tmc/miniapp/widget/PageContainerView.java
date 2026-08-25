package com.cloud.tmc.miniapp.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.structure.ui.PageContainer;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class PageContainerView extends FrameLayout implements PageContainer {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.h(context, "context");
    }

    public void attachPage(Page page) {
    }

    public View getContent() {
        return this;
    }
}
