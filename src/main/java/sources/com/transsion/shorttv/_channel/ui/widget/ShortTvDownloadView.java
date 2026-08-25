package com.transsion.shorttv._channel.ui.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.b;
import com.transsion.core.utils.e;
import com.transsion.gslb.BuildConfig;
import com.transsion.shorttv.R;
import com.transsion.shorttv.base.widget.TnTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import qr.u;
import xq.c;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b \u0018\u0000 E2\u00020\u0001:\u0001\rB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014JE\u0010\u001b\u001a\u00020\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\t¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\f¢\u0006\u0004\b\u001d\u0010\u0010J1\u0010\"\u001a\u00020\f2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\"\u0010#J\r\u0010$\u001a\u00020\t¢\u0006\u0004\b$\u0010%R$\u0010,\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010-R\u0016\u00101\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00100R\u0016\u00105\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00100R\u0016\u00107\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00100R\u0016\u00109\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00100R\u0018\u0010<\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010?\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\"\u0010D\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u00100\u001a\u0004\bA\u0010%\"\u0004\bB\u0010C¨\u0006F"}, d2 = {"Lcom/transsion/shorttv/_channel/ui/widget/ShortTvDownloadView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BuildConfig.FLAVOR, "res", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BuildConfig.FLAVOR, "a", "(Landroid/util/AttributeSet;)V", "b", "()V", BuildConfig.FLAVOR, "pageName", "setPageFrom", "(Ljava/lang/String;)V", "subjectId", "resourceId", BuildConfig.FLAVOR, "isSeries", "mutiRatio", "downloadTextResId", "setShowType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;ZI)V", "setShowPlayType", "tipTextColor", BuildConfig.FLAVOR, "tipsTextSize", "iconSrc", "setAttrs", "(Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Integer;)V", "getShowType", "()I", "Lqr/u;", "Lqr/u;", "getMViewBinding", "()Lqr/u;", "setMViewBinding", "(Lqr/u;)V", "mViewBinding", "F", "textSize", "c", "I", "downloadIconSrc", "d", "playIconSrc", "e", "textVisibility", "f", "textStyle", "g", "textColor", "h", "Ljava/lang/Integer;", "icTintColor", "i", "Ljava/lang/String;", "pageFrom", "j", "getType", "setType", "(I)V", "type", "Companion", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ShortTvDownloadView extends FrameLayout {
    public static final int ADD_COURSE = 2;
    public static final int COURSE_ADDED = 3;
    public static final int DOWNLOAD = 0;
    public static final int PLAY = 1;

    /* renamed from: a, reason: from kotlin metadata */
    private u mViewBinding;

    /* renamed from: b, reason: from kotlin metadata */
    private float textSize;

    /* renamed from: c, reason: from kotlin metadata */
    private int downloadIconSrc;

    /* renamed from: d, reason: from kotlin metadata */
    private int playIconSrc;

    /* renamed from: e, reason: from kotlin metadata */
    private int textVisibility;

    /* renamed from: f, reason: from kotlin metadata */
    private int textStyle;

    /* renamed from: g, reason: from kotlin metadata */
    private int textColor;

    /* renamed from: h, reason: from kotlin metadata */
    private Integer icTintColor;

    /* renamed from: i, reason: from kotlin metadata */
    private String pageFrom;

    /* renamed from: j, reason: from kotlin metadata */
    private int type;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShortTvDownloadView(Context context) {
        this(context, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShortTvDownloadView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTvDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        this.textSize = e.a(12.0f);
        this.downloadIconSrc = R.mipmap.short_tv_ic_download_red;
        this.playIconSrc = R.mipmap.short_tv_icon_play_white;
        this.textStyle = 1;
        this.textColor = -1;
        this.pageFrom = BuildConfig.FLAVOR;
        a(attributeSet);
        b();
    }

    private final void a(AttributeSet attrs) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.short_tv_download_view);
        Intrinsics.g(obtainStyledAttributes, "obtainStyledAttributes(...)");
        try {
            try {
                this.textSize = obtainStyledAttributes.getDimension(R.styleable.short_tv_download_view_tips_textSize, this.textSize);
                this.downloadIconSrc = obtainStyledAttributes.getResourceId(R.styleable.short_tv_download_view_iconSrc, this.downloadIconSrc);
                this.playIconSrc = obtainStyledAttributes.getResourceId(R.styleable.short_tv_download_view_playIconSrc, this.playIconSrc);
                this.textStyle = obtainStyledAttributes.getInteger(R.styleable.short_tv_download_view_short_tv_tips_textStyle, 1);
                this.textColor = obtainStyledAttributes.getColor(R.styleable.short_tv_download_view_tips_textColor, b.getColor(getContext(), R.color.short_tv_white));
                if (obtainStyledAttributes.hasValue(R.styleable.short_tv_download_view_tips_textColor)) {
                    this.icTintColor = Integer.valueOf(obtainStyledAttributes.getColor(R.styleable.short_tv_download_view_tips_textColor, b.getColor(getContext(), R.color.short_tv_white)));
                }
                this.textVisibility = obtainStyledAttributes.getColor(R.styleable.short_tv_download_view_tips_textVisibility, 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th2) {
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }

    private final void b() {
        AppCompatTextView appCompatTextView;
        Typeface d;
        AppCompatTextView appCompatTextView2;
        AppCompatTextView appCompatTextView3;
        TnTextView tnTextView;
        u uVar;
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        View.inflate(getContext(), R.layout.short_tv_download_view_type_list, this);
        u a = u.a(this);
        this.mViewBinding = a;
        if (a != null && (appCompatImageView2 = a.b) != null) {
            appCompatImageView2.setImageResource(this.downloadIconSrc);
        }
        Integer num = this.icTintColor;
        if (num != null && (uVar = this.mViewBinding) != null && (appCompatImageView = uVar.b) != null) {
            Intrinsics.e(num);
            appCompatImageView.setImageTintList(ColorStateList.valueOf(num.intValue()));
        }
        u uVar2 = this.mViewBinding;
        if (uVar2 != null && (tnTextView = uVar2.d) != null) {
            tnTextView.setTextSize(0, this.textSize);
        }
        u uVar3 = this.mViewBinding;
        if (uVar3 != null && (appCompatTextView3 = uVar3.d) != null) {
            appCompatTextView3.setTextColor(this.textColor);
        }
        u uVar4 = this.mViewBinding;
        if (uVar4 != null && (appCompatTextView2 = uVar4.d) != null) {
            appCompatTextView2.setVisibility(this.textVisibility);
        }
        u uVar5 = this.mViewBinding;
        if (uVar5 == null || (appCompatTextView = uVar5.d) == null) {
            return;
        }
        int i = this.textStyle;
        if (i == 0) {
            Context context = getContext();
            Intrinsics.g(context, "getContext(...)");
            d = c.d(context);
        } else if (i == 1) {
            Context context2 = getContext();
            Intrinsics.g(context2, "getContext(...)");
            d = c.c(context2);
        } else if (i == 2) {
            Context context3 = getContext();
            Intrinsics.g(context3, "getContext(...)");
            d = c.a(context3);
        } else if (i != 3) {
            Context context4 = getContext();
            Intrinsics.g(context4, "getContext(...)");
            d = c.c(context4);
        } else {
            Context context5 = getContext();
            Intrinsics.g(context5, "getContext(...)");
            d = c.b(context5);
        }
        appCompatTextView.setTypeface(d);
    }

    public static /* synthetic */ void setAttrs$default(ShortTvDownloadView shortTvDownloadView, Integer num, Float f, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            f = null;
        }
        if ((i & 4) != 0) {
            num2 = null;
        }
        shortTvDownloadView.setAttrs(num, f, num2);
    }

    public static /* synthetic */ void setShowType$default(ShortTvDownloadView shortTvDownloadView, String str, String str2, Boolean bool, boolean z, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = BuildConfig.FLAVOR;
        }
        if ((i2 & 2) != 0) {
            str2 = BuildConfig.FLAVOR;
        }
        if ((i2 & 4) != 0) {
            bool = Boolean.FALSE;
        }
        if ((i2 & 8) != 0) {
            z = false;
        }
        if ((i2 & 16) != 0) {
            i = R.string.short_tv_download;
        }
        shortTvDownloadView.setShowType(str, str2, bool, z, i);
    }

    public final u getMViewBinding() {
        return this.mViewBinding;
    }

    /* renamed from: getShowType, reason: from getter */
    public final int getType() {
        return this.type;
    }

    public final int getType() {
        return this.type;
    }

    public final void setAttrs(Integer tipTextColor, Float tipsTextSize, Integer iconSrc) {
        u uVar;
        AppCompatTextView appCompatTextView;
        TnTextView tnTextView;
        AppCompatImageView appCompatImageView;
        if (iconSrc != null) {
            int intValue = iconSrc.intValue();
            u uVar2 = this.mViewBinding;
            if (uVar2 != null && (appCompatImageView = uVar2.b) != null) {
                appCompatImageView.setImageResource(intValue);
            }
        }
        if (tipsTextSize != null) {
            float floatValue = tipsTextSize.floatValue();
            u uVar3 = this.mViewBinding;
            if (uVar3 != null && (tnTextView = uVar3.d) != null) {
                tnTextView.setTextSize(0, floatValue);
            }
        }
        if (tipTextColor == null || (uVar = this.mViewBinding) == null || (appCompatTextView = uVar.d) == null) {
            return;
        }
        appCompatTextView.setTextColor(tipTextColor.intValue());
    }

    public final void setMViewBinding(u uVar) {
        this.mViewBinding = uVar;
    }

    public final void setPageFrom(String pageName) {
        Intrinsics.h(pageName, "pageName");
        this.pageFrom = pageName;
    }

    public final void setShowPlayType() {
        u uVar;
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        TnTextView tnTextView;
        AppCompatImageView appCompatImageView3;
        this.type = 1;
        u uVar2 = this.mViewBinding;
        if (uVar2 != null && (appCompatImageView3 = uVar2.b) != null) {
            appCompatImageView3.setImageResource(this.playIconSrc);
        }
        u uVar3 = this.mViewBinding;
        if (uVar3 != null && (tnTextView = uVar3.d) != null) {
            tnTextView.setTextById(R.string.short_tv_play);
        }
        u uVar4 = this.mViewBinding;
        Drawable drawable = (uVar4 == null || (appCompatImageView2 = uVar4.b) == null) ? null : appCompatImageView2.getDrawable();
        if (drawable == null || (uVar = this.mViewBinding) == null || (appCompatImageView = uVar.b) == null) {
            return;
        }
        appCompatImageView.setImageDrawable(drawable);
    }

    public final void setShowType(String subjectId, String resourceId, Boolean isSeries, boolean mutiRatio, int downloadTextResId) {
        TnTextView tnTextView;
        AppCompatImageView appCompatImageView;
        this.type = 0;
        u uVar = this.mViewBinding;
        if (uVar != null && (appCompatImageView = uVar.b) != null) {
            appCompatImageView.setImageResource(this.downloadIconSrc);
        }
        u uVar2 = this.mViewBinding;
        if (uVar2 == null || (tnTextView = uVar2.d) == null) {
            return;
        }
        tnTextView.setTextById(downloadTextResId);
    }

    public final void setType(int i) {
        this.type = i;
    }
}
