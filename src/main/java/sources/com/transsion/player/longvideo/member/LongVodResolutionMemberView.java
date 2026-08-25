package com.transsion.player.longvideo.member;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.blankj.utilcode.util.Utils;
import com.therouter.TheRouter;
import com.tn.lib.widget.R;
import com.tn.lib.widget.TnTextView;
import com.transsion.baseui.widget.GradientTextView;
import com.transsion.gslb.BuildConfig;
import com.transsion.player.longvideo.R$id;
import com.transsion.player.longvideo.R$layout;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/transsion/player/longvideo/member/LongVodResolutionMemberView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lln/b;", "config", "Lln/a;", "longVdPlayerBean", BuildConfig.FLAVOR, "setConfig", "(Lln/b;Lln/a;)V", BuildConfig.FLAVOR, "color", "setTextColor", "(I)V", "setGradientColorsV2", "(Lln/b;)V", "Lcom/transsion/baseui/widget/GradientTextView;", "a", "Lcom/transsion/baseui/widget/GradientTextView;", "gradientTextView", "Landroid/widget/ImageView;", "b", "Landroid/widget/ImageView;", "ivMember", "LongVideo_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class LongVodResolutionMemberView extends FrameLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private GradientTextView gradientTextView;

    /* renamed from: b, reason: from kotlin metadata */
    private ImageView ivMember;

    /* JADX WARN: Illegal instructions before constructor call */
    @JvmOverloads
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LongVodResolutionMemberView(Context context) {
        this(context, r0, 2, r0);
        Intrinsics.h(context, "context");
        AttributeSet attributeSet = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LongVodResolutionMemberView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.h(context, "context");
        View inflate = LayoutInflater.from(context).inflate(R$layout.long_vod_resolution_member_layout, (ViewGroup) this, false);
        Object findViewById = inflate.findViewById(R$id.gradientTextView);
        Intrinsics.f(findViewById, "null cannot be cast to non-null type com.transsion.baseui.widget.GradientTextView");
        this.gradientTextView = (GradientTextView) findViewById;
        View findViewById2 = inflate.findViewById(R$id.ivMember);
        Intrinsics.f(findViewById2, "null cannot be cast to non-null type android.widget.ImageView");
        this.ivMember = (ImageView) findViewById2;
        addView(inflate);
    }

    public /* synthetic */ LongVodResolutionMemberView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.View, android.widget.TextView, com.transsion.baseui.widget.GradientTextView] */
    public final void setConfig(ln.b config, ln.a longVdPlayerBean) {
        Intrinsics.h(config, "config");
        ?? r0 = this.gradientTextView;
        if (r0 != 0) {
            r0.setGravity(17);
            boolean z = false;
            im.b bVar = (im.b) TheRouter.d(im.b.class, new Object[0]);
            boolean z2 = bVar != null ? bVar.z() : false;
            ImageView imageView = this.ivMember;
            if (imageView != null) {
                if (r.a.q(config.d()) && z2) {
                    z = true;
                }
                uf.c.j(imageView, z);
            }
            kotlinx.coroutines.i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new LongVodResolutionMemberView$setConfig$1$1(longVdPlayerBean, config, this, null), 3, (Object) null);
            if (config.e()) {
                setGradientColorsV2(config);
            } else {
                r0.setGradientColors(androidx.core.content.b.getColor(Utils.a(), R.color.white), androidx.core.content.b.getColor(Utils.a(), R.color.white), androidx.core.content.b.getColor(Utils.a(), R.color.white));
            }
            r0.setTextSize(16.0f);
            Context context = r0.getContext();
            Intrinsics.g(context, "getContext(...)");
            r0.setTypeface(uf.a.c(context));
            r0.setText(config.d());
        }
    }

    public final void setGradientColorsV2(ln.b config) {
        Intrinsics.h(config, "config");
        if (r.a.q(config.d())) {
            GradientTextView gradientTextView = this.gradientTextView;
            if (gradientTextView != null) {
                gradientTextView.setGradientColors(Color.parseColor("#FED47D"), Color.parseColor("#FED47D"), Color.parseColor("#FEBD3C"));
                return;
            }
            return;
        }
        GradientTextView gradientTextView2 = this.gradientTextView;
        if (gradientTextView2 != null) {
            gradientTextView2.setGradientColors(androidx.core.content.b.getColor(Utils.a(), R.color.brand_new_gradient_start), androidx.core.content.b.getColor(Utils.a(), R.color.brand_new_gradient_center), androidx.core.content.b.getColor(Utils.a(), R.color.brand_new_gradient_end));
        }
    }

    public final void setTextColor(int color) {
        TnTextView tnTextView = this.gradientTextView;
        if (tnTextView != null) {
            tnTextView.setTextColor(color);
        }
    }
}
