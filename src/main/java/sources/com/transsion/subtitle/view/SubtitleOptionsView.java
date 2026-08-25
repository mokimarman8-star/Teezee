package com.transsion.subtitle.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.avery.subtitle.widget.SimpleSubtitleView;
import com.blankj.utilcode.util.a0;
import com.tn.lib.view.SecondariesSeekBar;
import com.tn.lib.view.SwitchButton;
import com.tn.lib.view.s;
import com.tn.lib.widget.R;
import com.transsion.subtitle.helper.LocalVideoUiType;
import com.transsion.subtitle.view.SubtitleOptionsView;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import com.warkiz.widget.IndicatorSeekBar;
import com.warkiz.widget.e;
import com.warkiz.widget.f;
import java.util.LinkedHashMap;
import jt.i;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.HttpUrl;
import qi.h;
import wf.a;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 h2\u00020\u0001:\u0001CB!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\nB\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ!\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J+\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u00122\b\b\u0002\u0010\u001c\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010!\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u00122\b\b\u0002\u0010 \u001a\u00020\u0012H\u0002¢\u0006\u0004\b!\u0010\"J!\u0010$\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u00122\b\b\u0002\u0010 \u001a\u00020\u0012H\u0002¢\u0006\u0004\b$\u0010\"J!\u0010&\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b&\u0010\u0015J!\u0010(\u001a\u00020\f2\u0006\u0010'\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u0012H\u0002¢\u0006\u0004\b(\u0010\u0019J\u000f\u0010)\u001a\u00020\fH\u0002¢\u0006\u0004\b)\u0010\u000eJ\u000f\u0010*\u001a\u00020\u0012H\u0002¢\u0006\u0004\b*\u0010+J\u0017\u0010.\u001a\u00020,2\u0006\u0010-\u001a\u00020,H\u0002¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\fH\u0002¢\u0006\u0004\b0\u0010\u000eJ\u000f\u00101\u001a\u00020\fH\u0002¢\u0006\u0004\b1\u0010\u000eJ\u000f\u00102\u001a\u00020\fH\u0002¢\u0006\u0004\b2\u0010\u000eJS\u0010>\u001a\u00020\f2\b\u00104\u001a\u0004\u0018\u0001032\b\u00105\u001a\u0004\u0018\u00010\u00062\b\u00107\u001a\u0004\u0018\u0001062\b\u00108\u001a\u0004\u0018\u0001062\b\u0010:\u001a\u0004\u0018\u0001092\b\u0010;\u001a\u0004\u0018\u00010\u00102\b\u0010=\u001a\u0004\u0018\u00010<¢\u0006\u0004\b>\u0010?J\r\u0010@\u001a\u00020\f¢\u0006\u0004\b@\u0010\u000eJ\r\u0010A\u001a\u00020\f¢\u0006\u0004\bA\u0010\u000eR\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0018\u00104\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u00105\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010\u0018R\u0018\u00107\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0018\u00108\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010JR\u0018\u0010:\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010=\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010;\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0014\u0010S\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010\u0018R\u0014\u0010U\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010\u0018R\u0016\u0010W\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010QR\u0016\u0010Y\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010\u0018R\u0016\u0010Z\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010\u0018R\u0016\u0010\\\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010[R\u0016\u0010]\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010[R\u0016\u0010_\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010QR\u0016\u0010a\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010\u0018R\u0016\u0010c\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010[R\u001e\u0010e\u001a\u0004\u0018\u00010d8\u0002@\u0002X\u0083\u000e¢\u0006\f\n\u0004\be\u0010f\u0012\u0004\bg\u0010\u000e¨\u0006i"}, d2 = {"Lcom/transsion/subtitle/view/SubtitleOptionsView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", HttpUrl.FRAGMENT_ENCODE_SET, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", HttpUrl.FRAGMENT_ENCODE_SET, "o", "()V", "n", HttpUrl.FRAGMENT_ENCODE_SET, "fontColorType", HttpUrl.FRAGMENT_ENCODE_SET, "fromRadioGroup", "G", "(Ljava/lang/String;Z)V", "fontSizeProgress", "fromSeekBar", "I", "(IZ)V", "percent", "fromSeekbar", "isSeekbarStopTouch", "K", "(IZZ)V", "openShadow", "fromSwitchButton", "x", "(ZZ)V", "openBackground", "v", "bgColorType", "C", "opacityProgress", "E", "reset", "u", "()Z", HttpUrl.FRAGMENT_ENCODE_SET, "fontSizePercent", "m", "(F)F", "z", "A", "B", "Lcom/transsion/subtitle/helper/LocalVideoUiType;", "layerType", "playerContainerHeight", "Lcom/avery/subtitle/widget/SimpleSubtitleView;", "subtitleViewTop", "subtitleViewBottom", "Landroid/view/ViewGroup;", "subtitleViewGroup", "pageName", "Lcom/transsion/subtitle/helper/d;", "optionsHelper", "initOptions", "(Lcom/transsion/subtitle/helper/LocalVideoUiType;Ljava/lang/Integer;Lcom/avery/subtitle/widget/SimpleSubtitleView;Lcom/avery/subtitle/widget/SimpleSubtitleView;Landroid/view/ViewGroup;Ljava/lang/String;Lcom/transsion/subtitle/helper/d;)V", "addSubtitleOptions", "removeSubtitleOptions", "Ljt/i;", "a", "Ljt/i;", "optionsViewBinding", "b", "Lcom/transsion/subtitle/helper/LocalVideoUiType;", "c", "d", "Lcom/avery/subtitle/widget/SimpleSubtitleView;", "e", "f", "Landroid/view/ViewGroup;", "g", "Lcom/transsion/subtitle/helper/d;", "h", "Ljava/lang/String;", "i", "dp4", "j", "subtitleViewBaseHeight", "k", "curFontColorType", "l", "curFontSizeProgress", "curPositionPercent", "Z", "curOpenShadow", "curOpenBackground", "p", "curBackgroundColorType", "q", "curBackgroundOpacityProgress", "r", "isSetPreviewText", "Landroid/widget/FrameLayout;", "subtitleViewContainer", "Landroid/widget/FrameLayout;", "getSubtitleViewContainer$annotations", "Companion", "VideoSubtitle_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SuppressLint({"ViewConstructor"})
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class SubtitleOptionsView extends ConstraintLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private i optionsViewBinding;

    /* renamed from: b, reason: from kotlin metadata */
    private LocalVideoUiType layerType;

    /* renamed from: c, reason: from kotlin metadata */
    private int playerContainerHeight;

    /* renamed from: d, reason: from kotlin metadata */
    private SimpleSubtitleView subtitleViewTop;

    /* renamed from: e, reason: from kotlin metadata */
    private SimpleSubtitleView subtitleViewBottom;

    /* renamed from: f, reason: from kotlin metadata */
    private ViewGroup subtitleViewGroup;

    /* renamed from: g, reason: from kotlin metadata */
    private com.transsion.subtitle.helper.d optionsHelper;

    /* renamed from: h, reason: from kotlin metadata */
    private String pageName;

    /* renamed from: i, reason: from kotlin metadata */
    private final int dp4;

    /* renamed from: j, reason: from kotlin metadata */
    private final int subtitleViewBaseHeight;

    /* renamed from: k, reason: from kotlin metadata */
    private String curFontColorType;

    /* renamed from: l, reason: from kotlin metadata */
    private int curFontSizeProgress;

    /* renamed from: m, reason: from kotlin metadata */
    private int curPositionPercent;

    /* renamed from: n, reason: from kotlin metadata */
    private boolean curOpenShadow;

    /* renamed from: o, reason: from kotlin metadata */
    private boolean curOpenBackground;

    /* renamed from: p, reason: from kotlin metadata */
    private String curBackgroundColorType;

    /* renamed from: q, reason: from kotlin metadata */
    private int curBackgroundOpacityProgress;

    /* renamed from: r, reason: from kotlin metadata */
    private boolean isSetPreviewText;

    public static final class b implements e {
        b() {
        }

        @Override // com.warkiz.widget.e
        public void a(IndicatorSeekBar indicatorSeekBar) {
        }

        @Override // com.warkiz.widget.e
        public void b(IndicatorSeekBar indicatorSeekBar) {
            SubtitleOptionsView.this.I(indicatorSeekBar != null ? indicatorSeekBar.getProgress() : 0, true);
        }

        @Override // com.warkiz.widget.e
        public void c(f fVar) {
            SubtitleOptionsView.this.I(fVar != null ? fVar.b : 0, true);
        }
    }

    public static final class c implements s {
        c() {
        }

        public void a(SecondariesSeekBar seekBar) {
            Intrinsics.h(seekBar, "seekBar");
            SubtitleOptionsView.this.K((int) seekBar.getProgress(), true, true);
        }

        public void b(SecondariesSeekBar seekBar, long j, boolean z) {
            Intrinsics.h(seekBar, "seekBar");
            SubtitleOptionsView.this.K((int) j, true, false);
        }

        public void c(SecondariesSeekBar seekBar) {
            Intrinsics.h(seekBar, "seekBar");
        }
    }

    public static final class d implements e {
        d() {
        }

        @Override // com.warkiz.widget.e
        public void a(IndicatorSeekBar indicatorSeekBar) {
        }

        @Override // com.warkiz.widget.e
        public void b(IndicatorSeekBar indicatorSeekBar) {
            SubtitleOptionsView.this.E(indicatorSeekBar != null ? indicatorSeekBar.getProgress() : 0, true);
        }

        @Override // com.warkiz.widget.e
        public void c(f fVar) {
            SubtitleOptionsView.this.E(fVar != null ? fVar.b : 0, true);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SubtitleOptionsView(Context context) {
        this(context, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SubtitleOptionsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SubtitleOptionsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        i b2 = i.b(LayoutInflater.from(context), this);
        Intrinsics.g(b2, "inflate(...)");
        this.optionsViewBinding = b2;
        this.pageName = "local_video_detail";
        this.dp4 = a0.a(4.0f);
        this.subtitleViewBaseHeight = a0.a(66.0f);
        this.curFontColorType = "color_white";
        this.curFontSizeProgress = 2;
        this.curPositionPercent = 10;
        this.curOpenShadow = true;
        this.curBackgroundColorType = "color_black";
        this.curBackgroundOpacityProgress = 3;
        o();
    }

    private final void A() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("behavior", "leave");
        linkedHashMap.put("font_color", this.curFontColorType);
        com.transsion.subtitle.helper.d dVar = this.optionsHelper;
        linkedHashMap.put("font_size", String.valueOf(dVar != null ? Float.valueOf(dVar.g(this.curFontSizeProgress)) : null));
        linkedHashMap.put("position_bottom_percent", String.valueOf(this.curPositionPercent));
        linkedHashMap.put("shadow", String.valueOf(this.curOpenShadow));
        linkedHashMap.put("open_bg", String.valueOf(this.curOpenBackground));
        if (this.curOpenBackground) {
            linkedHashMap.put("bg_color", this.curBackgroundColorType);
            com.transsion.subtitle.helper.d dVar2 = this.optionsHelper;
            linkedHashMap.put("bg_opacity", String.valueOf(dVar2 != null ? Float.valueOf(dVar2.c(this.curBackgroundOpacityProgress)) : null));
        }
        h.a.q(this.pageName, "subtitle_options", linkedHashMap);
    }

    private final void B() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("behavior", "reset");
        h.a.q(this.pageName, "subtitle_options", linkedHashMap);
    }

    private final void C(String bgColorType, boolean fromRadioGroup) {
        if (fromRadioGroup) {
            this.curBackgroundColorType = bgColorType;
        } else {
            com.transsion.subtitle.helper.d dVar = this.optionsHelper;
            Integer valueOf = dVar != null ? Integer.valueOf(dVar.b(bgColorType)) : null;
            RadioGroup radioGroup = this.optionsViewBinding.t;
            Intrinsics.e(valueOf);
            radioGroup.check(valueOf.intValue());
        }
        com.transsion.baselib.report.launch.b.a.b().putString("subtitle_options_bg_color", bgColorType);
        a.a.f(a.a, "SubtitleOptionsView", "setBackgroundColorStyle = " + bgColorType, false, 4, (Object) null);
        com.transsion.subtitle.helper.d dVar2 = this.optionsHelper;
        Integer valueOf2 = dVar2 != null ? Integer.valueOf(dVar2.d(bgColorType)) : null;
        SimpleSubtitleView simpleSubtitleView = this.subtitleViewTop;
        if (simpleSubtitleView != null) {
            Intrinsics.e(valueOf2);
            simpleSubtitleView.setBgColor(valueOf2.intValue());
        }
        SimpleSubtitleView simpleSubtitleView2 = this.subtitleViewBottom;
        if (simpleSubtitleView2 != null) {
            Intrinsics.e(valueOf2);
            simpleSubtitleView2.setBgColor(valueOf2.intValue());
        }
    }

    static /* synthetic */ void D(SubtitleOptionsView subtitleOptionsView, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        subtitleOptionsView.C(str, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(int opacityProgress, boolean fromSeekBar) {
        if (fromSeekBar) {
            this.curBackgroundOpacityProgress = opacityProgress;
        } else {
            this.optionsViewBinding.x.setProgress(opacityProgress);
        }
        com.transsion.baselib.report.launch.b.a.b().putInt("subtitle_options_bg_opacity_progress", opacityProgress);
        this.optionsViewBinding.j.setProgress(opacityProgress);
        com.transsion.subtitle.helper.d dVar = this.optionsHelper;
        Float valueOf = dVar != null ? Float.valueOf(dVar.c(opacityProgress)) : null;
        if (valueOf != null) {
            int floatValue = (int) (255 * valueOf.floatValue());
            SimpleSubtitleView simpleSubtitleView = this.subtitleViewTop;
            if (simpleSubtitleView != null) {
                simpleSubtitleView.setBgAlpha(floatValue);
            }
            SimpleSubtitleView simpleSubtitleView2 = this.subtitleViewBottom;
            if (simpleSubtitleView2 != null) {
                simpleSubtitleView2.setBgAlpha(floatValue);
            }
            com.transsion.subtitle.a.a.a(SubtitleOptionsView.class.getSimpleName() + " --> setBackgroundOpacityStyle() --> opacityPercent = " + valueOf + " --> toInt = " + floatValue + " --> subtitleViewTop = " + (this.subtitleViewTop != null) + " --> subtitleViewBottom = " + (this.subtitleViewBottom != null));
        }
    }

    static /* synthetic */ void F(SubtitleOptionsView subtitleOptionsView, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        subtitleOptionsView.E(i, z);
    }

    private final void G(String fontColorType, boolean fromRadioGroup) {
        com.transsion.subtitle.helper.d dVar = this.optionsHelper;
        Integer valueOf = dVar != null ? Integer.valueOf(dVar.f(fontColorType)) : null;
        if (fromRadioGroup) {
            this.curFontColorType = fontColorType;
        } else {
            RadioGroup radioGroup = this.optionsViewBinding.u;
            Intrinsics.e(valueOf);
            radioGroup.check(valueOf.intValue());
        }
        com.transsion.baselib.report.launch.b.a.b().putString("subtitle_options_font_color", fontColorType);
        SimpleSubtitleView simpleSubtitleView = this.subtitleViewTop;
        if (simpleSubtitleView != null) {
            com.transsion.subtitle.helper.d dVar2 = this.optionsHelper;
            Integer valueOf2 = dVar2 != null ? Integer.valueOf(dVar2.d(fontColorType)) : null;
            Intrinsics.e(valueOf2);
            simpleSubtitleView.setTextColor(valueOf2.intValue());
        }
        SimpleSubtitleView simpleSubtitleView2 = this.subtitleViewBottom;
        if (simpleSubtitleView2 != null) {
            com.transsion.subtitle.helper.d dVar3 = this.optionsHelper;
            Integer valueOf3 = dVar3 != null ? Integer.valueOf(dVar3.d(fontColorType)) : null;
            Intrinsics.e(valueOf3);
            simpleSubtitleView2.setTextColor(valueOf3.intValue());
        }
        if (Intrinsics.c(fontColorType, "color_white")) {
            return;
        }
        this.optionsViewBinding.F.setSelected(true);
    }

    static /* synthetic */ void H(SubtitleOptionsView subtitleOptionsView, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        subtitleOptionsView.G(str, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(int fontSizeProgress, boolean fromSeekBar) {
        this.optionsViewBinding.k.setProgress(fontSizeProgress);
        if (fromSeekBar) {
            this.curFontSizeProgress = fontSizeProgress;
        } else {
            this.optionsViewBinding.v.setProgress(fontSizeProgress);
        }
        com.transsion.baselib.report.launch.b.a.b().putInt("subtitle_options_font_size_progress", fontSizeProgress);
        com.transsion.subtitle.helper.d dVar = this.optionsHelper;
        Float valueOf = dVar != null ? Float.valueOf(dVar.g(fontSizeProgress)) : null;
        Intrinsics.e(valueOf);
        float m = m(valueOf.floatValue());
        SimpleSubtitleView simpleSubtitleView = this.subtitleViewTop;
        if (simpleSubtitleView != null) {
            simpleSubtitleView.setTextSize(m);
        }
        SimpleSubtitleView simpleSubtitleView2 = this.subtitleViewBottom;
        if (simpleSubtitleView2 != null) {
            simpleSubtitleView2.setTextSize(m);
        }
        if (fontSizeProgress != 2) {
            this.optionsViewBinding.F.setSelected(true);
        }
    }

    static /* synthetic */ void J(SubtitleOptionsView subtitleOptionsView, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        subtitleOptionsView.I(i, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(int percent, boolean fromSeekbar, boolean isSeekbarStopTouch) {
        com.transsion.subtitle.helper.d dVar;
        LocalVideoUiType localVideoUiType = this.layerType;
        if (localVideoUiType != null && (dVar = this.optionsHelper) != null) {
            dVar.j(localVideoUiType, this.subtitleViewGroup, percent);
        }
        this.curPositionPercent = percent;
        if (fromSeekbar && isSeekbarStopTouch) {
            com.transsion.baselib.report.launch.b.a.b().putInt("subtitle_options_position", percent);
        }
        if (percent != 10) {
            this.optionsViewBinding.F.setSelected(true);
        }
    }

    static /* synthetic */ void L(SubtitleOptionsView subtitleOptionsView, int i, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            z2 = true;
        }
        subtitleOptionsView.K(i, z, z2);
    }

    @Deprecated
    private static /* synthetic */ void getSubtitleViewContainer$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final float m(float fontSizePercent) {
        Context context = getContext();
        Intrinsics.g(context, "getContext(...)");
        return (com.transsion.baseui.util.b.a(context) ? this.layerType == LocalVideoUiType.MIDDLE ? 18 : 30 : this.layerType == LocalVideoUiType.MIDDLE ? 12 : 20) * fontSizePercent;
    }

    private final void n() {
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.a;
        String string = bVar.b().getString("subtitle_options_font_color", "color_white");
        String str = string != null ? string : "color_white";
        this.curFontColorType = str;
        H(this, str, false, 2, null);
        int i = bVar.b().getInt("subtitle_options_font_size_progress", 2);
        this.curFontSizeProgress = i;
        J(this, i, false, 2, null);
        int i2 = bVar.b().getInt("subtitle_options_position", 10);
        this.curPositionPercent = i2;
        this.optionsViewBinding.w.setProgress(i2);
        boolean z = bVar.b().getBoolean("subtitle_options_shadow_enabled", true);
        this.curOpenShadow = z;
        y(this, z, false, 2, null);
        this.curOpenBackground = bVar.b().getBoolean("subtitle_options_bg_enabled", false);
        String string2 = bVar.b().getString("subtitle_options_bg_color", "color_black");
        this.curBackgroundColorType = string2 != null ? string2 : "color_black";
        this.curBackgroundOpacityProgress = bVar.b().getInt("subtitle_options_bg_opacity_progress", 3);
        w(this, this.curOpenBackground, false, 2, null);
        boolean u = u();
        com.transsion.subtitle.a.a.a(SubtitleOptionsView.class.getSimpleName() + " --> initData() --> isOptionsChanged = " + u);
        this.optionsViewBinding.F.setSelected(u);
    }

    private final void o() {
        this.optionsViewBinding.u.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: nt.a
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                SubtitleOptionsView.p(SubtitleOptionsView.this, radioGroup, i);
            }
        });
        this.optionsViewBinding.v.setOnSeekChangeListener(new b());
        this.optionsViewBinding.w.setOnSeekBarChangeListener(new c());
        this.optionsViewBinding.z.setOnCheckedChangeListener(new SwitchButton.d() { // from class: nt.b
            public final void a(SwitchButton switchButton, boolean z) {
                SubtitleOptionsView.q(SubtitleOptionsView.this, switchButton, z);
            }
        });
        this.optionsViewBinding.y.setOnCheckedChangeListener(new SwitchButton.d() { // from class: nt.c
            public final void a(SwitchButton switchButton, boolean z) {
                SubtitleOptionsView.r(SubtitleOptionsView.this, switchButton, z);
            }
        });
        this.optionsViewBinding.t.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: nt.d
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                SubtitleOptionsView.s(SubtitleOptionsView.this, radioGroup, i);
            }
        });
        this.optionsViewBinding.x.setOnSeekChangeListener(new d());
        this.optionsViewBinding.F.setOnClickListener(new View.OnClickListener() { // from class: nt.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubtitleOptionsView.t(SubtitleOptionsView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(SubtitleOptionsView subtitleOptionsView, RadioGroup radioGroup, int i) {
        com.transsion.subtitle.helper.d dVar = subtitleOptionsView.optionsHelper;
        String e = dVar != null ? dVar.e(i) : null;
        Intrinsics.e(e);
        subtitleOptionsView.G(e, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(SubtitleOptionsView subtitleOptionsView, SwitchButton switchButton, boolean z) {
        subtitleOptionsView.x(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(SubtitleOptionsView subtitleOptionsView, SwitchButton switchButton, boolean z) {
        subtitleOptionsView.v(z, true);
    }

    private final void reset() {
        this.curFontColorType = "color_white";
        H(this, "color_white", false, 2, null);
        this.curFontSizeProgress = 2;
        J(this, 2, false, 2, null);
        this.curPositionPercent = 10;
        com.transsion.baselib.report.launch.b.a.b().putInt("subtitle_options_position", this.curPositionPercent);
        L(this, this.curPositionPercent, false, false, 6, null);
        this.optionsViewBinding.w.setProgress(this.curPositionPercent);
        this.curOpenShadow = true;
        y(this, true, false, 2, null);
        this.curOpenBackground = false;
        w(this, false, false, 2, null);
        this.curBackgroundColorType = "color_black";
        D(this, "color_black", false, 2, null);
        this.curBackgroundOpacityProgress = 3;
        F(this, 3, false, 2, null);
        this.optionsViewBinding.F.setSelected(false);
        B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(SubtitleOptionsView subtitleOptionsView, RadioGroup radioGroup, int i) {
        com.transsion.subtitle.helper.d dVar = subtitleOptionsView.optionsHelper;
        String a = dVar != null ? dVar.a(i) : null;
        Intrinsics.e(a);
        subtitleOptionsView.C(a, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(SubtitleOptionsView subtitleOptionsView, View view) {
        if (view.isSelected()) {
            subtitleOptionsView.reset();
        }
    }

    private final boolean u() {
        return (Intrinsics.c(this.curFontColorType, "color_white") && this.curFontSizeProgress == 2 && this.curOpenShadow && !this.curOpenBackground && Intrinsics.c(this.curBackgroundColorType, "color_black") && this.curBackgroundOpacityProgress == 3 && this.curPositionPercent == 10) ? false : true;
    }

    private final void v(boolean openBackground, boolean fromSwitchButton) {
        if (fromSwitchButton) {
            this.curOpenBackground = openBackground;
        } else {
            this.optionsViewBinding.y.setChecked(openBackground);
        }
        com.transsion.baselib.report.launch.b.a.b().putBoolean("subtitle_options_bg_enabled", openBackground);
        Group groupBackground = this.optionsViewBinding.b;
        Intrinsics.g(groupBackground, "groupBackground");
        groupBackground.setVisibility(openBackground ? 0 : 8);
        if (!openBackground) {
            SimpleSubtitleView simpleSubtitleView = this.subtitleViewTop;
            if (simpleSubtitleView != null) {
                simpleSubtitleView.closeBg();
            }
            SimpleSubtitleView simpleSubtitleView2 = this.subtitleViewBottom;
            if (simpleSubtitleView2 != null) {
                simpleSubtitleView2.closeBg();
                return;
            }
            return;
        }
        SimpleSubtitleView simpleSubtitleView3 = this.subtitleViewTop;
        if (simpleSubtitleView3 != null) {
            simpleSubtitleView3.openBg();
        }
        SimpleSubtitleView simpleSubtitleView4 = this.subtitleViewBottom;
        if (simpleSubtitleView4 != null) {
            simpleSubtitleView4.openBg();
        }
        this.optionsViewBinding.F.setSelected(true);
        SimpleSubtitleView simpleSubtitleView5 = this.subtitleViewTop;
        if (simpleSubtitleView5 != null) {
            simpleSubtitleView5.setBgdRadius(this.dp4);
        }
        SimpleSubtitleView simpleSubtitleView6 = this.subtitleViewBottom;
        if (simpleSubtitleView6 != null) {
            simpleSubtitleView6.setBgdRadius(this.dp4);
        }
        D(this, this.curBackgroundColorType, false, 2, null);
        F(this, this.curBackgroundOpacityProgress, false, 2, null);
    }

    static /* synthetic */ void w(SubtitleOptionsView subtitleOptionsView, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        subtitleOptionsView.v(z, z2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void x(boolean openShadow, boolean fromSwitchButton) {
        if (fromSwitchButton) {
            this.curOpenShadow = openShadow;
        } else {
            this.optionsViewBinding.z.setChecked(openShadow);
        }
        com.transsion.baselib.report.launch.b.a.b().putBoolean("subtitle_options_shadow_enabled", openShadow);
        if (openShadow) {
            SimpleSubtitleView simpleSubtitleView = this.subtitleViewTop;
            if (simpleSubtitleView != null) {
                simpleSubtitleView.setShadowLayer(1.0f, 3.0f, 2.0f, androidx.core.content.b.getColor(getContext(), R.color.black_90));
            }
            SimpleSubtitleView simpleSubtitleView2 = this.subtitleViewBottom;
            if (simpleSubtitleView2 != null) {
                simpleSubtitleView2.setShadowLayer(1.0f, 3.0f, 2.0f, androidx.core.content.b.getColor(getContext(), R.color.black_90));
            }
        } else {
            SimpleSubtitleView simpleSubtitleView3 = this.subtitleViewTop;
            if (simpleSubtitleView3 != null) {
                simpleSubtitleView3.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
            SimpleSubtitleView simpleSubtitleView4 = this.subtitleViewBottom;
            if (simpleSubtitleView4 != null) {
                simpleSubtitleView4.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
        }
        if (openShadow) {
            return;
        }
        this.optionsViewBinding.F.setSelected(true);
    }

    static /* synthetic */ void y(SubtitleOptionsView subtitleOptionsView, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        subtitleOptionsView.x(z, z2);
    }

    private final void z() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("behavior", "enter");
        h.a.q(this.pageName, "subtitle_options", linkedHashMap);
    }

    public final void addSubtitleOptions() {
        z();
    }

    public final void initOptions(LocalVideoUiType layerType, Integer playerContainerHeight, SimpleSubtitleView subtitleViewTop, SimpleSubtitleView subtitleViewBottom, ViewGroup subtitleViewGroup, String pageName, com.transsion.subtitle.helper.d optionsHelper) {
        this.layerType = layerType;
        this.playerContainerHeight = playerContainerHeight != null ? playerContainerHeight.intValue() : 0;
        this.subtitleViewTop = subtitleViewTop;
        this.subtitleViewBottom = subtitleViewBottom;
        this.subtitleViewGroup = subtitleViewGroup;
        if (pageName != null) {
            this.pageName = pageName;
        }
        this.optionsHelper = optionsHelper;
        n();
    }

    public final void removeSubtitleOptions() {
        A();
        if (this.isSetPreviewText) {
            SimpleSubtitleView simpleSubtitleView = this.subtitleViewTop;
            if (simpleSubtitleView != null) {
                uf.c.h(simpleSubtitleView);
            }
            SimpleSubtitleView simpleSubtitleView2 = this.subtitleViewBottom;
            if (simpleSubtitleView2 != null) {
                uf.c.h(simpleSubtitleView2);
            }
            SimpleSubtitleView simpleSubtitleView3 = this.subtitleViewTop;
            if (simpleSubtitleView3 != null) {
                simpleSubtitleView3.setText(HttpUrl.FRAGMENT_ENCODE_SET);
            }
            SimpleSubtitleView simpleSubtitleView4 = this.subtitleViewBottom;
            if (simpleSubtitleView4 != null) {
                simpleSubtitleView4.setText(HttpUrl.FRAGMENT_ENCODE_SET);
            }
        }
    }
}
