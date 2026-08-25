package com.cloud.tmc.miniapp.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.cloud.tmc.integration.utils.FastClickUtil;
import com.cloud.tmc.integration.utils.MiniAppConfigUtils;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.imageloader.ImageLoadCallback;
import com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy;
import com.cloud.tmc.miniapp.R;
import com.cloud.tmc.miniutils.util.SystemUtils;
import com.cloud.tmc.miniutils.util.ViewUtils;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class CapsuleView extends LinearLayoutCompat {
    public final Lazy OooO;
    public final HashMap<Integer, HashMap<Integer, Integer>> OooO00o;
    public final HashMap<Integer, HashMap<Integer, Integer>> OooO0O0;
    public final HashMap<Integer, Integer> OooO0OO;
    public final HashMap<Integer, Integer> OooO0Oo;
    public Function0<Unit> OooO0o;
    public Function0<Unit> OooO0o0;
    public final Lazy OooO0oO;
    public final Lazy OooO0oo;
    public final Lazy OooOO0;
    public HashMap<Integer, HashMap<Integer, Integer>> OooOO0O;

    public static final class OooO extends Lambda implements Function0<AppCompatImageView> {
        public OooO() {
            super(0);
        }

        public Object invoke() {
            return CapsuleView.this.findViewById(R.id.iv_left);
        }
    }

    public static final class OooO00o implements ImageLoadCallback<Drawable> {
        public OooO00o() {
        }

        @Override // com.cloud.tmc.kernel.proxy.imageloader.ImageLoadCallback
        public void onLoadFailed(String str) {
        }

        @Override // com.cloud.tmc.kernel.proxy.imageloader.ImageLoadCallback
        public void onLoadSuccess(Drawable drawable) {
            Drawable drawable2 = drawable;
            if (drawable2 != null) {
                CapsuleView.this.getIvLeft().setForeground(drawable2);
            }
        }
    }

    public static final class OooO0O0 implements ImageLoadCallback<Drawable> {
        public OooO0O0() {
        }

        @Override // com.cloud.tmc.kernel.proxy.imageloader.ImageLoadCallback
        public void onLoadFailed(String str) {
        }

        @Override // com.cloud.tmc.kernel.proxy.imageloader.ImageLoadCallback
        public void onLoadSuccess(Drawable drawable) {
            Drawable drawable2 = drawable;
            if (drawable2 != null) {
                CapsuleView.this.getIvRight().setForeground(drawable2);
            }
        }
    }

    public static final class OooO0OO extends Lambda implements Function0<LinearLayoutCompat> {
        public OooO0OO() {
            super(0);
        }

        public Object invoke() {
            return CapsuleView.this.findViewById(R.id.capsule_layout);
        }
    }

    public static final class OooO0o extends Lambda implements Function0<View> {
        public OooO0o() {
            super(0);
        }

        public Object invoke() {
            return CapsuleView.this.findViewById(R.id.view_center_line);
        }
    }

    public static final class OooOO0 extends Lambda implements Function0<AppCompatImageView> {
        public OooOO0() {
            super(0);
        }

        public Object invoke() {
            return CapsuleView.this.findViewById(R.id.iv_right);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CapsuleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.h(context, "context");
        HashMap<Integer, HashMap<Integer, Integer>> j = MapsKt.j(new Pair[]{TuplesKt.a(0, MapsKt.j(new Pair[]{TuplesKt.a(Integer.valueOf(R.id.iv_left), Integer.valueOf(R.drawable.mini_ic_title_more_white_mode)), TuplesKt.a(Integer.valueOf(R.id.iv_right), Integer.valueOf(R.drawable.mini_ic_title_close_white_mode))})), TuplesKt.a(1, MapsKt.j(new Pair[]{TuplesKt.a(Integer.valueOf(R.id.iv_left), Integer.valueOf(R.drawable.mini_ic_title_more_black_mode)), TuplesKt.a(Integer.valueOf(R.id.iv_right), Integer.valueOf(R.drawable.mini_ic_title_close_black_mode))}))});
        this.OooO00o = j;
        HashMap<Integer, HashMap<Integer, Integer>> j2 = MapsKt.j(new Pair[]{TuplesKt.a(0, MapsKt.j(new Pair[]{TuplesKt.a(Integer.valueOf(R.id.iv_left), Integer.valueOf(R.drawable.mini_ic_title_back_white_mode)), TuplesKt.a(Integer.valueOf(R.id.iv_right), Integer.valueOf(R.drawable.mini_ic_title_home_white_mode))})), TuplesKt.a(1, MapsKt.j(new Pair[]{TuplesKt.a(Integer.valueOf(R.id.iv_left), Integer.valueOf(R.drawable.mini_ic_immersive_title_bar_back_black_mode)), TuplesKt.a(Integer.valueOf(R.id.iv_right), Integer.valueOf(R.drawable.mini_ic_immersive_title_bar_home_black_mode))}))});
        this.OooO0O0 = j2;
        this.OooO0OO = MapsKt.j(new Pair[]{TuplesKt.a(0, Integer.valueOf(R.color.mini_color_capsule_line_white_mode_bg)), TuplesKt.a(1, Integer.valueOf(R.color.mini_color_border_capsule))});
        this.OooO0Oo = MapsKt.j(new Pair[]{TuplesKt.a(0, Integer.valueOf(R.drawable.shape_bg_capsule_white_mode)), TuplesKt.a(1, Integer.valueOf(R.drawable.shape_bg_capsule_black_mode))});
        this.OooO0oO = LazyKt.b(new OooO0OO());
        this.OooO0oo = LazyKt.b(new OooO());
        this.OooO = LazyKt.b(new OooO0o());
        this.OooOO0 = LazyKt.b(new OooOO0());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Mini_CapsuleView);
        Intrinsics.g(obtainStyledAttributes, "context.obtainStyledAttr…yleable.Mini_CapsuleView)");
        int i = obtainStyledAttributes.getInt(R.styleable.Mini_CapsuleView_capsule_style, 0);
        if (i != 1 && i == 2) {
            j = j2;
        }
        this.OooOO0O = j;
        obtainStyledAttributes.recycle();
        LayoutInflater.from(context).inflate(R.layout.layout_mini_capsule, (ViewGroup) this);
        if (!isInEditMode()) {
            getIvLeft().setRotationY(ViewUtils.isLayoutRtl() ? 180.0f : 0.0f);
            getIvRight().setRotationY(ViewUtils.isLayoutRtl() ? 180.0f : 0.0f);
        }
        getIvLeft().setOnClickListener(new View.OnClickListener() { // from class: com.cloud.tmc.miniapp.widget.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CapsuleView.OooO00o(CapsuleView.this, view);
            }
        });
        getIvRight().setOnClickListener(new View.OnClickListener() { // from class: com.cloud.tmc.miniapp.widget.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CapsuleView.OooO0O0(CapsuleView.this, view);
            }
        });
        int i2 = !SystemUtils.darkThemeIsEnabled(context) ? 1 : 0;
        try {
            ImageLoaderProxy imageLoaderProxy = (ImageLoaderProxy) TmcProxy.get(ImageLoaderProxy.class);
            imageLoaderProxy.loadImg(context, R.drawable.shape_fg_capsule_left_click, 0, (ImageView) getIvLeft(), (ImageLoadCallback<Drawable>) new OooO00o());
            imageLoaderProxy.loadImg(context, R.drawable.shape_fg_capsule_right_click, 0, (ImageView) getIvRight(), (ImageLoadCallback<Drawable>) new OooO0O0());
        } catch (Throwable th) {
            TmcLogger.e("", th);
        }
        OooO00o(this, i2, null, 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0064 A[Catch: all -> 0x0058, TryCatch #1 {all -> 0x0058, blocks: (B:46:0x0049, B:15:0x005e, B:17:0x0064, B:44:0x0070, B:14:0x005a), top: B:45:0x0049, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0098 A[Catch: all -> 0x008c, TryCatch #3 {all -> 0x008c, blocks: (B:38:0x007d, B:20:0x0092, B:22:0x0098, B:36:0x00a4, B:19:0x008e), top: B:37:0x007d, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c6 A[Catch: all -> 0x00cb, TryCatch #2 {all -> 0x00cb, blocks: (B:24:0x00b4, B:26:0x00c6, B:27:0x00cf, B:31:0x00cd), top: B:23:0x00b4 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00cd A[Catch: all -> 0x00cb, TryCatch #2 {all -> 0x00cb, blocks: (B:24:0x00b4, B:26:0x00c6, B:27:0x00cf, B:31:0x00cd), top: B:23:0x00b4 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a4 A[Catch: all -> 0x008c, TRY_LEAVE, TryCatch #3 {all -> 0x008c, blocks: (B:38:0x007d, B:20:0x0092, B:22:0x0098, B:36:0x00a4, B:19:0x008e), top: B:37:0x007d, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0070 A[Catch: all -> 0x0058, TRY_LEAVE, TryCatch #1 {all -> 0x0058, blocks: (B:46:0x0049, B:15:0x005e, B:17:0x0064, B:44:0x0070, B:14:0x005a), top: B:45:0x0049, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void OooO00o(CapsuleView capsuleView, int i, HashMap hashMap, int i2) {
        ImageLoaderProxy imageLoaderProxy;
        Integer num;
        Integer num2;
        int intValue;
        int intValue2;
        HashMap<Integer, HashMap<Integer, Integer>> hashMap2 = (i2 & 2) != 0 ? capsuleView.OooOO0O : null;
        capsuleView.getClass();
        Intrinsics.h(hashMap2, "style");
        Integer valueOf = MiniAppConfigUtils.getTitleBarNodeMode() == null ? Integer.valueOf(i) : MiniAppConfigUtils.getTitleBarNodeMode();
        LinearLayoutCompat capsuleLayout = capsuleView.getCapsuleLayout();
        Integer num3 = capsuleView.OooO0Oo.get(valueOf);
        capsuleLayout.setBackgroundResource(num3 != null ? num3.intValue() : 0);
        HashMap<Integer, Integer> hashMap3 = hashMap2.get(valueOf);
        try {
            imageLoaderProxy = (ImageLoaderProxy) TmcProxy.get(ImageLoaderProxy.class);
        } catch (Throwable th) {
            TmcLogger.e("", th);
        }
        try {
            if (hashMap3 != null) {
                try {
                    num = hashMap3.get(Integer.valueOf(R.id.iv_left));
                    if (num == null) {
                    }
                    intValue2 = num.intValue();
                    if (intValue2 == 0) {
                        imageLoaderProxy.loadImg(capsuleView.getContext(), intValue2, intValue2, (ImageView) capsuleView.getIvLeft());
                    } else {
                        capsuleView.getIvLeft().setImageResource(intValue2);
                    }
                } catch (Throwable th2) {
                    TmcLogger.e("", th2);
                }
                if (hashMap3 != null) {
                    try {
                        num2 = hashMap3.get(Integer.valueOf(R.id.iv_right));
                        if (num2 == null) {
                        }
                        intValue = num2.intValue();
                        if (intValue != 0) {
                            imageLoaderProxy.loadImg(capsuleView.getContext(), intValue, intValue, (ImageView) capsuleView.getIvRight());
                        } else {
                            capsuleView.getIvRight().setImageResource(intValue);
                        }
                    } catch (Throwable th3) {
                        TmcLogger.e("", th3);
                    }
                    View centerLineView = capsuleView.getCenterLineView();
                    Context context = capsuleView.getContext();
                    Integer num4 = capsuleView.OooO0OO.get(valueOf);
                    centerLineView.setBackgroundColor(androidx.core.content.b.getColor(context, num4 != null ? num4.intValue() : R.color.mini_color_border_capsule));
                    return;
                }
                num2 = 0;
                intValue = num2.intValue();
                if (intValue != 0) {
                }
                View centerLineView2 = capsuleView.getCenterLineView();
                Context context2 = capsuleView.getContext();
                Integer num42 = capsuleView.OooO0OO.get(valueOf);
                centerLineView2.setBackgroundColor(androidx.core.content.b.getColor(context2, num42 != null ? num42.intValue() : R.color.mini_color_border_capsule));
                return;
            }
            View centerLineView22 = capsuleView.getCenterLineView();
            Context context22 = capsuleView.getContext();
            Integer num422 = capsuleView.OooO0OO.get(valueOf);
            centerLineView22.setBackgroundColor(androidx.core.content.b.getColor(context22, num422 != null ? num422.intValue() : R.color.mini_color_border_capsule));
            return;
        } catch (Throwable th4) {
            TmcLogger.e("", th4);
            return;
        }
        num = 0;
        intValue2 = num.intValue();
        if (intValue2 == 0) {
        }
        if (hashMap3 != null) {
        }
        num2 = 0;
        intValue = num2.intValue();
        if (intValue != 0) {
        }
    }

    public static final void OooO00o(CapsuleView capsuleView, View view) {
        Function0<Unit> function0;
        Intrinsics.h(capsuleView, "this$0");
        if (FastClickUtil.isFastDoubleClick() || (function0 = capsuleView.OooO0o0) == null) {
            return;
        }
        function0.invoke();
    }

    public static final void OooO0O0(CapsuleView capsuleView, View view) {
        Function0<Unit> function0;
        Intrinsics.h(capsuleView, "this$0");
        if (FastClickUtil.isFastDoubleClick() || (function0 = capsuleView.OooO0o) == null) {
            return;
        }
        function0.invoke();
    }

    private final LinearLayoutCompat getCapsuleLayout() {
        Object value = this.OooO0oO.getValue();
        Intrinsics.g(value, "<get-capsuleLayout>(...)");
        return (LinearLayoutCompat) value;
    }

    private final View getCenterLineView() {
        Object value = this.OooO.getValue();
        Intrinsics.g(value, "<get-centerLineView>(...)");
        return (View) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppCompatImageView getIvLeft() {
        Object value = this.OooO0oo.getValue();
        Intrinsics.g(value, "<get-ivLeft>(...)");
        return (AppCompatImageView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppCompatImageView getIvRight() {
        Object value = this.OooOO0.getValue();
        Intrinsics.g(value, "<get-ivRight>(...)");
        return (AppCompatImageView) value;
    }

    public final HashMap<Integer, HashMap<Integer, Integer>> getBackAndHome() {
        return this.OooO0O0;
    }

    public final HashMap<Integer, HashMap<Integer, Integer>> getCapsuleStyle() {
        return this.OooOO0O;
    }

    public final HashMap<Integer, HashMap<Integer, Integer>> getMoreAndClose() {
        return this.OooO00o;
    }

    public final void setCapsuleStyle(HashMap<Integer, HashMap<Integer, Integer>> hashMap) {
        Intrinsics.h(hashMap, "<set-?>");
        this.OooOO0O = hashMap;
    }

    public final void setOnLeftClickListener(Function0<Unit> function0) {
        Intrinsics.h(function0, "cb");
        this.OooO0o0 = function0;
    }

    public final void setOnRightClickListener(Function0<Unit> function0) {
        Intrinsics.h(function0, "cb");
        this.OooO0o = function0;
    }
}
