package com.transsion.subtitle.helper;

import android.content.Context;
import android.view.ViewGroup;
import com.avery.subtitle.widget.SimpleSubtitleView;
import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.y;
import com.tn.lib.widget.R;
import com.transsion.subtitle.R$color;
import com.transsion.subtitle.R$id;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class d {
    public static final a n = new a(null);
    private final Context a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;
    private final int h;
    private final int i;
    private final int j;
    private final int k;
    private final int l;
    private final int m;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[LocalVideoUiType.values().length];
            try {
                iArr[LocalVideoUiType.MIDDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LocalVideoUiType.LAND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LocalVideoUiType.PORTRAIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    public d(Context context) {
        Intrinsics.h(context, "context");
        this.a = context;
        this.f = a0.a(66.0f);
        this.g = a0.a(24.0f);
        this.h = a0.a(24.0f);
        this.i = a0.a(68.0f);
        this.j = y.e();
        int c = y.c();
        this.k = c;
        int c2 = com.blankj.utilcode.util.d.c();
        this.l = c2;
        this.m = c - c2;
        this.b = androidx.core.content.b.getColor(context, R.color.black);
        this.c = androidx.core.content.b.getColor(context, R.color.white);
        this.d = androidx.core.content.b.getColor(context, R$color.subtitle_color_yellow);
        this.e = androidx.core.content.b.getColor(context, R$color.subtitle_color_green);
    }

    public final String a(int i) {
        return i == R$id.rb_background_black ? "color_black" : i == R$id.rb_background_white ? "color_white" : i == R$id.rb_background_yellor ? "color_yellow" : i == R$id.rb_background_green ? "color_green" : "color_black";
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final int b(String bgColorType) {
        Intrinsics.h(bgColorType, "bgColorType");
        switch (bgColorType.hashCode()) {
            case -1720275760:
                if (bgColorType.equals("color_yellow")) {
                    return R$id.rb_background_yellor;
                }
                break;
            case 1308937251:
                if (bgColorType.equals("color_black")) {
                    return R$id.rb_background_black;
                }
                break;
            case 1313737511:
                if (bgColorType.equals("color_green")) {
                    return R$id.rb_background_green;
                }
                break;
            case 1328220237:
                if (bgColorType.equals("color_white")) {
                    return R$id.rb_background_white;
                }
                break;
        }
        return R$id.rb_background_white;
    }

    public final float c(int i) {
        if (i == 0) {
            return 0.1f;
        }
        if (i == 1) {
            return 0.25f;
        }
        if (i != 2) {
            return (i == 3 || i != 4) ? 0.75f : 1.0f;
        }
        return 0.5f;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
     */
    public final int d(String colorType) {
        Intrinsics.h(colorType, "colorType");
        switch (colorType.hashCode()) {
            case -1720275760:
                if (colorType.equals("color_yellow")) {
                    return this.d;
                }
                break;
            case 1308937251:
                if (colorType.equals("color_black")) {
                    return this.b;
                }
                break;
            case 1313737511:
                if (colorType.equals("color_green")) {
                    return this.e;
                }
                break;
            case 1328220237:
                if (colorType.equals("color_white")) {
                    return this.c;
                }
                break;
        }
        return this.c;
    }

    public final String e(int i) {
        if (i == R$id.rb_font_color_black) {
            return "color_black";
        }
        if (i != R$id.rb_font_color_white) {
            if (i == R$id.rb_font_color_yellor) {
                return "color_yellow";
            }
            if (i == R$id.rb_font_color_green) {
                return "color_green";
            }
        }
        return "color_white";
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final int f(String fontColorType) {
        Intrinsics.h(fontColorType, "fontColorType");
        switch (fontColorType.hashCode()) {
            case -1720275760:
                if (fontColorType.equals("color_yellow")) {
                    return R$id.rb_font_color_yellor;
                }
                break;
            case 1308937251:
                if (fontColorType.equals("color_black")) {
                    return R$id.rb_font_color_black;
                }
                break;
            case 1313737511:
                if (fontColorType.equals("color_green")) {
                    return R$id.rb_font_color_green;
                }
                break;
            case 1328220237:
                if (fontColorType.equals("color_white")) {
                    return R$id.rb_font_color_white;
                }
                break;
        }
        return R$id.rb_font_color_white;
    }

    public final float g(int i) {
        switch (i) {
            case 0:
                return 0.5f;
            case 1:
                return 0.75f;
            case 2:
            default:
                return 1.0f;
            case 3:
                return 1.5f;
            case 4:
                return 2.0f;
            case 5:
                return 3.0f;
            case 6:
                return 4.0f;
        }
    }

    public final int h(LocalVideoUiType uiType) {
        Intrinsics.h(uiType, "uiType");
        y.c();
        int i = b.a[uiType.ordinal()];
        if (i == 1) {
            return (this.j * 9) / 16;
        }
        if (i == 2) {
            return this.j;
        }
        if (i == 3) {
            return this.k;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void i(SimpleSubtitleView simpleSubtitleView, SimpleSubtitleView simpleSubtitleView2, LocalVideoUiType uiType, ViewGroup viewGroup) {
        Intrinsics.h(uiType, "uiType");
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.a;
        String string = bVar.b().getString("subtitle_options_font_color", "color_white");
        String str = string != null ? string : "color_white";
        int d = d(str);
        if (simpleSubtitleView != null) {
            simpleSubtitleView.setTextColor(d);
        }
        if (simpleSubtitleView2 != null) {
            simpleSubtitleView2.setTextColor(d);
        }
        float g = g(bVar.b().getInt("subtitle_options_font_size_progress", 2));
        int i = com.transsion.baseui.util.b.a(this.a) ? uiType == LocalVideoUiType.MIDDLE ? 18 : 30 : uiType == LocalVideoUiType.MIDDLE ? 12 : 20;
        if (simpleSubtitleView != null) {
            simpleSubtitleView.setTextSize(i * g);
        }
        if (simpleSubtitleView2 != null) {
            simpleSubtitleView2.setTextSize(i * g);
        }
        int i2 = bVar.b().getInt("subtitle_options_position", 10);
        j(uiType, viewGroup, i2);
        boolean z = bVar.b().getBoolean("subtitle_options_shadow_enabled", true);
        if (z) {
            if (simpleSubtitleView != null) {
                simpleSubtitleView.setShadowLayer(1.0f, 3.0f, 2.0f, androidx.core.content.b.getColor(simpleSubtitleView.getContext(), R.color.black_90));
            }
            if (simpleSubtitleView2 != null) {
                simpleSubtitleView2.setShadowLayer(1.0f, 3.0f, 2.0f, androidx.core.content.b.getColor(simpleSubtitleView2.getContext(), R.color.black_90));
            }
        } else {
            if (simpleSubtitleView != null) {
                simpleSubtitleView.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
            if (simpleSubtitleView2 != null) {
                simpleSubtitleView2.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
        }
        boolean z2 = bVar.b().getBoolean("subtitle_options_bg_enabled", false);
        String string2 = bVar.b().getString("subtitle_options_bg_color", "color_black");
        String str2 = string2 != null ? string2 : "color_black";
        int i3 = bVar.b().getInt("subtitle_options_bg_opacity_progress", 3);
        if (z2) {
            if (simpleSubtitleView != null) {
                simpleSubtitleView.openBg();
            }
            if (simpleSubtitleView2 != null) {
                simpleSubtitleView2.openBg();
            }
            if (simpleSubtitleView != null) {
                simpleSubtitleView.setBgdRadius(a0.a(4.0f));
            }
            if (simpleSubtitleView2 != null) {
                simpleSubtitleView2.setBgdRadius(a0.a(4.0f));
            }
            int d2 = d(str2);
            if (simpleSubtitleView != null) {
                simpleSubtitleView.setBgColor(d2);
            }
            if (simpleSubtitleView2 != null) {
                simpleSubtitleView2.setBgColor(d2);
            }
            float c = c(i3);
            if (simpleSubtitleView != null) {
                simpleSubtitleView.setBgAlpha((int) (255 * c));
            }
            if (simpleSubtitleView2 != null) {
                simpleSubtitleView2.setBgAlpha((int) (255 * c));
            }
        } else {
            if (simpleSubtitleView != null) {
                simpleSubtitleView.closeBg();
            }
            if (simpleSubtitleView2 != null) {
                simpleSubtitleView2.closeBg();
            }
        }
        a.a.v(wf.a.a, "SubtitleOptionsView", StringsKt.n("\n            initSubtitleOptions, fontColorType= " + str + "， fontSizePercent = " + g + "\n                positionPercent = " + i2 + ", openShadow =" + z + "\n                openBackground = " + z2 + ", bgColorType = " + str2 + ", bgOpacityProgress = " + i3 + "\n        "), false, 4, (Object) null);
    }

    public final void j(LocalVideoUiType uiType, ViewGroup viewGroup, int i) {
        Intrinsics.h(uiType, "uiType");
        int h = h(uiType);
        int a2 = a0.a(40.0f);
        int i2 = h - a2;
        ViewGroup.LayoutParams layoutParams = viewGroup != null ? viewGroup.getLayoutParams() : null;
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        int i3 = (i * i2) / 100;
        if (i3 >= 0) {
            if (i3 > i2 - a2) {
                if (marginLayoutParams != null) {
                    marginLayoutParams.bottomMargin = i2 - a0.a(40.0f);
                }
            } else if (marginLayoutParams != null) {
                marginLayoutParams.bottomMargin = i3;
            }
            int height = viewGroup != null ? viewGroup.getHeight() : 0;
            if ((marginLayoutParams != null ? marginLayoutParams.bottomMargin : 0) + height > h && marginLayoutParams != null) {
                marginLayoutParams.bottomMargin = h - height;
            }
        }
        if (viewGroup != null) {
            viewGroup.requestLayout();
        }
    }
}
