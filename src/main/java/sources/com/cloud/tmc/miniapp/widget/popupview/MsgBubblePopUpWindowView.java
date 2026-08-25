package com.cloud.tmc.miniapp.widget.popupview;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.utils.MiniBarUtils;
import com.cloud.tmc.integration.utils.ext.ViewExtKt;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.launcherlib.LauncherMiniAppConfigHelper;
import com.cloud.tmc.miniapp.ByteAppManager;
import com.cloud.tmc.miniapp.R;
import com.cloud.tmc.miniutils.util.StringUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class MsgBubblePopUpWindowView extends LinearLayout {
    public final Lazy OooO00o;
    public final Lazy OooO0O0;
    public boolean OooO0OO;

    public static final class OooO00o extends Lambda implements Function0<AppCompatImageView> {
        public OooO00o() {
            super(0);
        }

        public Object invoke() {
            return MsgBubblePopUpWindowView.this.findViewById(R.id.iv_msg_jump);
        }
    }

    public static final class OooO0O0 extends Lambda implements Function0<TextView> {
        public OooO0O0() {
            super(0);
        }

        public Object invoke() {
            return (TextView) MsgBubblePopUpWindowView.this.findViewById(R.id.tv_msg_toast);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MsgBubblePopUpWindowView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MsgBubblePopUpWindowView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MsgBubblePopUpWindowView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MsgBubblePopUpWindowView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.h(context, "context");
        this.OooO00o = LazyKt.b(new OooO0O0());
        this.OooO0O0 = LazyKt.b(new OooO00o());
        this.OooO0OO = true;
        LayoutInflater.from(context).inflate(R.layout.mini_msg_notice_popwindow_layout, this);
        setTranslationY(getTranslationY() + MiniBarUtils.getStatusHeight());
        boolean configTargetBool = MiniAppConfigHelper.INSTANCE.getConfigTargetBool(LauncherMiniAppConfigHelper.KEY_MINI_MSG_ENABLE_JUMP, true);
        this.OooO0OO = configTargetBool;
        if (configTargetBool) {
            AppCompatImageView mIvMsgJump = getMIvMsgJump();
            if (mIvMsgJump != null) {
                ViewExtKt.toVisible(mIvMsgJump);
            }
        } else {
            AppCompatImageView mIvMsgJump2 = getMIvMsgJump();
            if (mIvMsgJump2 != null) {
                ViewExtKt.toInvisible(mIvMsgJump2);
            }
        }
        setOnClickListener(new View.OnClickListener() { // from class: com.cloud.tmc.miniapp.widget.popupview.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MsgBubblePopUpWindowView.OooO00o(MsgBubblePopUpWindowView.this, view);
            }
        });
    }

    public /* synthetic */ MsgBubblePopUpWindowView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    public static final void OooO00o(MsgBubblePopUpWindowView msgBubblePopUpWindowView, View view) {
        Intrinsics.h(msgBubblePopUpWindowView, "this$0");
        if (msgBubblePopUpWindowView.OooO0OO) {
            Context context = msgBubblePopUpWindowView.getContext();
            Bundle bundle = new Bundle();
            bundle.putString("page", "pages/notification/notification");
            bundle.putString("query", "entrance%3DBubble");
            Unit unit = Unit.a;
            ByteAppManager.launchMiniAppForId(context, "1000886706715795456", "", bundle);
        }
        PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
        Bundle bundle2 = new Bundle();
        bundle2.putString("jump_confi", msgBubblePopUpWindowView.OooO0OO ? "0" : "1");
        Unit unit2 = Unit.a;
        performanceAnalyseProxy.recordForCommon(null, TmcConstants.REPORTER_MSG_BUBBLE_CLICK, bundle2);
    }

    private final AppCompatImageView getMIvMsgJump() {
        return (AppCompatImageView) this.OooO0O0.getValue();
    }

    private final TextView getMTvMsgToast() {
        return (TextView) this.OooO00o.getValue();
    }

    public final void OooO00o(String str) {
        if (str != null) {
            try {
                TextView mTvMsgToast = getMTvMsgToast();
                if (mTvMsgToast == null) {
                    return;
                }
                mTvMsgToast.setText(StringUtils.format(StringUtils.getString(R.string.mini_toast_msg_bubble_tips), str));
            } catch (Throwable th) {
                TmcLogger.e("MsgBubblePopUpWindowView", th);
            }
        }
    }
}
