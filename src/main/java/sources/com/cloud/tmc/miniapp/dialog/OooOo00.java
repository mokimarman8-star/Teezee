package com.cloud.tmc.miniapp.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cloud.tmc.integration.utils.ext.ViewExtKt;
import com.cloud.tmc.miniapp.R;
import com.cloud.tmc.miniapp.dialog.OooO0O0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OooOo00 extends OooO0O0.OooO00o<OooOo00> {
    public final Lazy OooO;
    public final boolean OooO00o;
    public final Lazy OooO0O0;
    public final Lazy OooO0OO;
    public final Lazy OooO0Oo;
    public final Lazy OooO0o;
    public final Lazy OooO0o0;
    public final Lazy OooO0oO;
    public final Lazy OooO0oo;
    public final Lazy OooOO0;
    public final Lazy OooOO0O;
    public OooOo OooOO0o;

    public static final class OooO extends Lambda implements Function0<FrameLayout> {
        public OooO() {
            super(0);
        }

        public Object invoke() {
            return (FrameLayout) OooOo00.this.findViewById(R.id.fl_text_panel);
        }
    }

    public static final class OooO00o extends Lambda implements Function0<View> {
        public OooO00o() {
            super(0);
        }

        public Object invoke() {
            return OooOo00.this.findViewById(R.id.view_halving_line);
        }
    }

    public static final class OooO0O0 extends Lambda implements Function0<TextView> {
        public OooO0O0() {
            super(0);
        }

        public Object invoke() {
            return (TextView) OooOo00.this.findViewById(R.id.btn_common_dialog_left);
        }
    }

    public static final class OooO0OO extends Lambda implements Function0<TextView> {
        public OooO0OO() {
            super(0);
        }

        public Object invoke() {
            return (TextView) OooOo00.this.findViewById(R.id.btn_common_dialog_right);
        }
    }

    public static final class OooO0o extends Lambda implements Function0<FrameLayout> {
        public OooO0o() {
            super(0);
        }

        public Object invoke() {
            return (FrameLayout) OooOo00.this.findViewById(R.id.fl_edit_panel);
        }
    }

    public static final class OooOO0 extends Lambda implements Function0<TextView> {
        public OooOO0() {
            super(0);
        }

        public Object invoke() {
            return (TextView) OooOo00.this.findViewById(R.id.txt_common_dialog_describe);
        }
    }

    public static final class OooOO0O extends Lambda implements Function0<TextView> {
        public OooOO0O() {
            super(0);
        }

        public Object invoke() {
            return (TextView) OooOo00.this.findViewById(R.id.txt_common_dialog_edit);
        }
    }

    public static final class OooOOO extends Lambda implements Function0<View> {
        public OooOOO() {
            super(0);
        }

        public Object invoke() {
            return OooOo00.this.findViewById(R.id.view_line_bottom);
        }
    }

    public static final class OooOOO0 extends Lambda implements Function0<TextView> {
        public OooOOO0() {
            super(0);
        }

        public Object invoke() {
            return (TextView) OooOo00.this.findViewById(R.id.txt_common_dialog_title);
        }
    }

    public static final class OooOOOO extends Lambda implements Function0<View> {
        public OooOOOO() {
            super(0);
        }

        public Object invoke() {
            return OooOo00.this.findViewById(R.id.view_line_top);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OooOo00(Context context, boolean z) {
        super(context);
        Intrinsics.h(context, "context");
        this.OooO00o = z;
        this.OooO0O0 = LazyKt.b(new OooOOOO());
        this.OooO0OO = LazyKt.b(new OooOOO());
        this.OooO0Oo = LazyKt.b(new OooO());
        this.OooO0o0 = LazyKt.b(new OooO0o());
        this.OooO0o = LazyKt.b(new OooOOO0());
        this.OooO0oO = LazyKt.b(new OooOO0());
        this.OooO0oo = LazyKt.b(new OooOO0O());
        this.OooO = LazyKt.b(new OooO0O0());
        this.OooOO0 = LazyKt.b(new OooO0OO());
        this.OooOO0O = LazyKt.b(new OooO00o());
        setContentView(z ? R.layout.layout_common_tip_confirm_dialog : R.layout.layout_common_tip_confirm_normal_dialog);
        setBackgroundDimAmount(0.2f);
        TextView OooO0Oo = OooO0Oo();
        if (OooO0Oo != null) {
            OooO0Oo.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.tmc.miniapp.dialog.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OooOo00.OooO00o(OooOo00.this, view);
                }
            });
        }
        TextView OooO0o0 = OooO0o0();
        if (OooO0o0 != null) {
            OooO0o0.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.tmc.miniapp.dialog.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OooOo00.OooO0O0(OooOo00.this, view);
                }
            });
        }
        TextView OooO0o2 = OooO0o();
        if (OooO0o2 != null) {
            OooO0o2.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.cloud.tmc.miniapp.dialog.f
                @Override // android.view.View.OnScrollChangeListener
                public final void onScrollChange(View view, int i, int i2, int i3, int i4) {
                    OooOo00.OooO00o(OooOo00.this, view, i, i2, i3, i4);
                }
            });
        }
    }

    public static final void OooO00o(OooOo00 oooOo00) {
        Intrinsics.h(oooOo00, "$this_apply");
        TextView OooO0o2 = oooOo00.OooO0o();
        if ((OooO0o2 != null ? OooO0o2.getHeight() : 0) >= ((int) oooOo00.getResources().getDimension(R.dimen.mini_dp_216))) {
            View OooOO02 = oooOo00.OooOO0();
            if (OooOO02 != null) {
                ViewExtKt.toInvisible(OooOO02);
            }
            View OooO2 = oooOo00.OooO();
            if (OooO2 != null) {
                ViewExtKt.toVisible(OooO2);
                return;
            }
            return;
        }
        View OooOO03 = oooOo00.OooOO0();
        if (OooOO03 != null) {
            ViewExtKt.toGone(OooOO03);
        }
        View OooO3 = oooOo00.OooO();
        if (OooO3 != null) {
            ViewExtKt.toGone(OooO3);
        }
    }

    public static final void OooO00o(OooOo00 oooOo00, View view) {
        Intrinsics.h(oooOo00, "this$0");
        OooOo oooOo = oooOo00.OooOO0o;
        if (oooOo != null) {
            Intrinsics.g(view, "it");
            oooOo.OooO00o(view);
        }
        oooOo00.dismiss();
    }

    public static final void OooO00o(OooOo00 oooOo00, View view, int i, int i2, int i3, int i4) {
        View OooOO02;
        View OooOO03;
        View OooO2;
        View OooO3;
        View OooO4;
        View OooOO04;
        Intrinsics.h(oooOo00, "this$0");
        if (i2 <= 0) {
            View OooOO05 = oooOo00.OooOO0();
            if ((OooOO05 == null || OooOO05.getVisibility() != 4) && (OooOO04 = oooOo00.OooOO0()) != null) {
                ViewExtKt.toInvisible(OooOO04);
            }
        } else {
            View OooOO06 = oooOo00.OooOO0();
            if (i2 <= (OooOO06 != null ? OooOO06.getHeight() : 1)) {
                View OooOO07 = oooOo00.OooOO0();
                if ((OooOO07 == null || OooOO07.getVisibility() != 0) && (OooOO03 = oooOo00.OooOO0()) != null) {
                    ViewExtKt.toVisible(OooOO03);
                }
                float height = i2 / (oooOo00.OooOO0() != null ? r2.getHeight() : 1);
                View OooOO08 = oooOo00.OooOO0();
                if (OooOO08 != null) {
                    OooOO08.setAlpha(1 * height);
                }
            } else {
                View OooOO09 = oooOo00.OooOO0();
                if (!Intrinsics.b(OooOO09 != null ? Float.valueOf(OooOO09.getAlpha()) : null, 1.0f) && (OooOO02 = oooOo00.OooOO0()) != null) {
                    OooOO02.setAlpha(1.0f);
                }
            }
        }
        TextView OooO0o2 = oooOo00.OooO0o();
        int lineHeight = OooO0o2 != null ? OooO0o2.getLineHeight() : 1;
        TextView OooO0o3 = oooOo00.OooO0o();
        int lineCount = (lineHeight * (OooO0o3 != null ? OooO0o3.getLineCount() : 1)) - view.getHeight();
        if (i2 >= lineCount) {
            View OooO5 = oooOo00.OooO();
            if ((OooO5 == null || OooO5.getVisibility() != 4) && (OooO4 = oooOo00.OooO()) != null) {
                ViewExtKt.toInvisible(OooO4);
                return;
            }
            return;
        }
        int i5 = lineCount - i2;
        View OooO6 = oooOo00.OooO();
        if (i5 > (OooO6 != null ? OooO6.getHeight() : 1)) {
            View OooO7 = oooOo00.OooO();
            if (Intrinsics.b(OooO7 != null ? Float.valueOf(OooO7.getAlpha()) : null, 1.0f) || (OooO2 = oooOo00.OooO()) == null) {
                return;
            }
            OooO2.setAlpha(1.0f);
            return;
        }
        View OooO8 = oooOo00.OooO();
        if ((OooO8 == null || OooO8.getVisibility() != 0) && (OooO3 = oooOo00.OooO()) != null) {
            ViewExtKt.toVisible(OooO3);
        }
        float height2 = i5 / (oooOo00.OooO() != null ? r6.getHeight() : 1);
        View OooO9 = oooOo00.OooO();
        if (OooO9 == null) {
            return;
        }
        OooO9.setAlpha(1 * height2);
    }

    public static final void OooO0O0(OooOo00 oooOo00, View view) {
        Intrinsics.h(oooOo00, "this$0");
        OooOo oooOo = oooOo00.OooOO0o;
        if (oooOo != null) {
            Intrinsics.g(view, "it");
            oooOo.OooO0O0(view);
        }
        oooOo00.dismiss();
    }

    public final View OooO() {
        return (View) this.OooO0OO.getValue();
    }

    public final OooOo00 OooO00o(int i) {
        if (i > 0) {
            TextView OooO0o2 = OooO0o();
            if (OooO0o2 != null) {
                OooO0o2.setMaxLines(i);
            }
            TextView OooO0o3 = OooO0o();
            if (OooO0o3 != null) {
                OooO0o3.setEllipsize(TextUtils.TruncateAt.END);
            }
        } else {
            OooO00o(true);
        }
        return this;
    }

    public final OooOo00 OooO00o(OooOo oooOo) {
        Intrinsics.h(oooOo, "listener");
        this.OooOO0o = oooOo;
        return this;
    }

    public final OooOo00 OooO00o(String str) {
        TextView OooO0oO;
        FrameLayout frameLayout = (FrameLayout) this.OooO0Oo.getValue();
        if (frameLayout == null || !ViewExtKt.getVisible(frameLayout)) {
            FrameLayout frameLayout2 = (FrameLayout) this.OooO0o0.getValue();
            if (frameLayout2 != null && ViewExtKt.getVisible(frameLayout2) && (OooO0oO = OooO0oO()) != null) {
                OooO0oO.setText(str);
            }
        } else {
            TextView OooO0o2 = OooO0o();
            if (OooO0o2 != null) {
                OooO0o2.setText(str);
            }
            TextView OooO0o3 = OooO0o();
            if (OooO0o3 != null) {
                ViewExtKt.toVisible(OooO0o3);
            }
            OooO0OO();
            TextView OooO0o4 = OooO0o();
            if (OooO0o4 != null) {
                OooO0o4.postDelayed(new Runnable() { // from class: com.cloud.tmc.miniapp.dialog.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        OooOo00.OooO00o(OooOo00.this);
                    }
                }, 10L);
            }
        }
        return this;
    }

    public final OooOo00 OooO00o(boolean z) {
        if (z) {
            TextView OooO0o2 = OooO0o();
            if (OooO0o2 != null) {
                OooO0o2.setMovementMethod(ScrollingMovementMethod.getInstance());
            }
        } else {
            TextView OooO0o3 = OooO0o();
            if (OooO0o3 != null) {
                OooO0o3.setMovementMethod(null);
            }
        }
        return this;
    }

    public final String OooO00o(String str, int i) {
        if (str == null || str.length() == 0) {
            return "";
        }
        if (str.length() < i) {
            return str;
        }
        String substring = str.substring(0, i);
        Intrinsics.g(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring + "...";
    }

    public final void OooO00o() {
        TextView OooO0o0;
        TextView OooO0Oo = OooO0Oo();
        if (OooO0Oo == null || !ViewExtKt.getVisible(OooO0Oo) || (OooO0o0 = OooO0o0()) == null || !ViewExtKt.getVisible(OooO0o0)) {
            TextView OooO0o02 = OooO0o0();
            if (OooO0o02 != null) {
                OooO0o02.setBackgroundResource(this.OooO00o ? R.drawable.shape_mini_common_tip_confirm_dialog_click : R.drawable.shape_mini_common_tip_confirm_normal_dialog_click);
                return;
            }
            return;
        }
        TextView OooO0o03 = OooO0o0();
        if (OooO0o03 != null) {
            OooO0o03.setBackgroundResource(this.OooO00o ? R.drawable.shape_mini_common_tip_confirm_dialog_right_click : R.drawable.shape_mini_common_tip_confirm_normal_dialog_right_click);
        }
    }

    public final OooOo00 OooO0O0(int i) {
        TextView OooO0Oo = OooO0Oo();
        if (OooO0Oo != null) {
            OooO0Oo.setTextColor(i);
        }
        return this;
    }

    public final OooOo00 OooO0O0(String str) {
        TextView OooO0Oo = OooO0Oo();
        if (OooO0Oo != null) {
            OooO0Oo.setText(OooO00o(str, 12));
        }
        return this;
    }

    public final OooOo00 OooO0O0(boolean z) {
        TextView OooO0Oo = OooO0Oo();
        if (OooO0Oo != null) {
            ViewExtKt.toVisibleOrGone(OooO0Oo, z);
        }
        OooO00o();
        OooO0O0();
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000b, code lost:
    
        if (com.cloud.tmc.integration.utils.ext.ViewExtKt.getVisible(r0) == true) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void OooO0O0() {
        TextView OooO0Oo = OooO0Oo();
        boolean z = OooO0Oo != null;
        View view = (View) this.OooOO0O.getValue();
        if (view != null) {
            ViewExtKt.toVisibleOrGone(view, z);
        }
    }

    public final OooOo00 OooO0OO(int i) {
        TextView OooO0o0 = OooO0o0();
        if (OooO0o0 != null) {
            OooO0o0.setTextColor(i);
        }
        return this;
    }

    public final OooOo00 OooO0OO(String str) {
        TextView OooO0o0 = OooO0o0();
        if (OooO0o0 != null) {
            TextView OooO0Oo = OooO0Oo();
            OooO0o0.setText(OooO00o(str, (OooO0Oo == null || !ViewExtKt.getVisible(OooO0Oo)) ? 24 : 12));
        }
        OooO00o();
        OooO0O0();
        return this;
    }

    public final void OooO0OO() {
        TextView OooO0o2;
        TextView OooO0o3;
        TextView OooO0o4;
        TextView OooO0oo = OooO0oo();
        if (OooO0oo != null && ViewExtKt.getVisible(OooO0oo) && (OooO0o4 = OooO0o()) != null && ViewExtKt.getVisible(OooO0o4)) {
            TextView OooO0oo2 = OooO0oo();
            if (OooO0oo2 != null) {
                OooO0oo2.setTextColor(getColor(this.OooO00o ? R.color.mini_confirm_dialog_title_color : R.color.mini_confirm_normal_dialog_title_color));
            }
            TextView OooO0o5 = OooO0o();
            if (OooO0o5 != null) {
                OooO0o5.setTextColor(getColor(this.OooO00o ? R.color.mini_confirm_dialog_describe_color : R.color.mini_confirm_normal_dialog_describe_color));
                return;
            }
            return;
        }
        TextView OooO0oo3 = OooO0oo();
        if (OooO0oo3 == null || ViewExtKt.getVisible(OooO0oo3) || (OooO0o2 = OooO0o()) == null || !ViewExtKt.getVisible(OooO0o2) || (OooO0o3 = OooO0o()) == null) {
            return;
        }
        OooO0o3.setTextColor(getColor(this.OooO00o ? R.color.mini_confirm_dialog_title_color : R.color.mini_confirm_normal_dialog_title_color));
    }

    public final TextView OooO0Oo() {
        return (TextView) this.OooO.getValue();
    }

    public final OooOo00 OooO0Oo(String str) {
        TextView OooO0oo = OooO0oo();
        if (OooO0oo != null) {
            OooO0oo.setText(str);
        }
        TextView OooO0oo2 = OooO0oo();
        if (OooO0oo2 != null) {
            ViewExtKt.toVisible(OooO0oo2);
        }
        OooO0OO();
        return this;
    }

    public final TextView OooO0o() {
        return (TextView) this.OooO0oO.getValue();
    }

    public final TextView OooO0o0() {
        return (TextView) this.OooOO0.getValue();
    }

    public final TextView OooO0oO() {
        return (TextView) this.OooO0oo.getValue();
    }

    public final TextView OooO0oo() {
        return (TextView) this.OooO0o.getValue();
    }

    public final View OooOO0() {
        return (View) this.OooO0O0.getValue();
    }
}
