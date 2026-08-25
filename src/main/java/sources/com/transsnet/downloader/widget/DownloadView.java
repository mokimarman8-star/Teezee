package com.transsnet.downloader.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.b;
import bx.q;
import com.blankj.utilcode.util.a0;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$styleable;
import com.tn.lib.widget.TnTextView;
import com.transsion.baseui.R$mipmap;
import com.transsion.baseui.R$string;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.downloader.R$layout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import uf.a;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b \u0018\u0000 G2\u00020\u0001:\u0001\rB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014JE\u0010\u001b\u001a\u00020\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\t¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\f¢\u0006\u0004\b\u001d\u0010\u0010J\r\u0010\u001e\u001a\u00020\f¢\u0006\u0004\b\u001e\u0010\u0010J\r\u0010\u001f\u001a\u00020\f¢\u0006\u0004\b\u001f\u0010\u0010J1\u0010$\u001a\u00020\f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b$\u0010%J\r\u0010&\u001a\u00020\t¢\u0006\u0004\b&\u0010'R$\u0010.\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0016\u00100\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010/R\u0016\u00103\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00105\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00102R\u0016\u00107\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00102R\u0016\u00109\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00102R\u0016\u0010;\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u00102R\u0018\u0010>\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010A\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\"\u0010F\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u00102\u001a\u0004\bC\u0010'\"\u0004\bD\u0010E¨\u0006H"}, d2 = {"Lcom/transsnet/downloader/widget/DownloadView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "res", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "a", "(Landroid/util/AttributeSet;)V", "b", "()V", "", "pageName", "setPageFrom", "(Ljava/lang/String;)V", "subjectId", "resourceId", "", "isSeries", "mutiRatio", "downloadTextResId", "setShowType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;ZI)V", "setShowPlayType", "setAddCourse", "setCourseAdded", "tipTextColor", "", "tipsTextSize", "iconSrc", "setAttrs", "(Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Integer;)V", "getShowType", "()I", "Lbx/q;", "Lbx/q;", "getMViewBinding", "()Lbx/q;", "setMViewBinding", "(Lbx/q;)V", "mViewBinding", "F", "textSize", "c", "I", "downloadIconSrc", "d", "playIconSrc", "e", "textVisibility", "f", "textStyle", "g", "textColor", "h", "Ljava/lang/Integer;", "icTintColor", "i", "Ljava/lang/String;", "pageFrom", "j", "getType", "setType", "(I)V", "type", "Companion", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class DownloadView extends FrameLayout {
    public static final int ADD_COURSE = 2;
    public static final int COURSE_ADDED = 3;
    public static final a Companion = new a((DefaultConstructorMarker) null);
    public static final int DOWNLOAD = 0;
    public static final int PLAY = 1;

    /* renamed from: a, reason: from kotlin metadata */
    private q mViewBinding;

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
    public DownloadView(Context context) {
        this(context, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        this.textSize = a0.a(12.0f);
        this.downloadIconSrc = R$mipmap.ic_download_red;
        this.playIconSrc = com.tn.lib.widget.R$mipmap.icon_play_white;
        this.textStyle = 1;
        this.textColor = -1;
        this.pageFrom = "";
        a(attributeSet);
        b();
    }

    private final void a(AttributeSet attrs) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R$styleable.download_view);
        Intrinsics.g(obtainStyledAttributes, "obtainStyledAttributes(...)");
        try {
            try {
                this.textSize = obtainStyledAttributes.getDimension(R$styleable.download_view_tips_textSize, this.textSize);
                this.downloadIconSrc = obtainStyledAttributes.getResourceId(R$styleable.download_view_iconSrc, this.downloadIconSrc);
                this.playIconSrc = obtainStyledAttributes.getResourceId(R$styleable.download_view_playIconSrc, this.playIconSrc);
                this.textStyle = obtainStyledAttributes.getInteger(R$styleable.download_view_tips_textStyle, 1);
                this.textColor = obtainStyledAttributes.getColor(R$styleable.download_view_tips_textColor, b.getColor(getContext(), R$color.white));
                if (obtainStyledAttributes.hasValue(R$styleable.download_view_tips_textColor)) {
                    this.icTintColor = Integer.valueOf(obtainStyledAttributes.getColor(R$styleable.download_view_tips_textColor, b.getColor(getContext(), R$color.white)));
                }
                this.textVisibility = obtainStyledAttributes.getColor(R$styleable.download_view_tips_textVisibility, 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    private final void b() {
        TnTextView tnTextView;
        Typeface d;
        TnTextView tnTextView2;
        TnTextView tnTextView3;
        TnTextView tnTextView4;
        q qVar;
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        View.inflate(getContext(), R$layout.download_view_type_list, this);
        q a = q.a(this);
        this.mViewBinding = a;
        if (a != null && (appCompatImageView2 = a.b) != null) {
            appCompatImageView2.setImageResource(this.downloadIconSrc);
        }
        Integer num = this.icTintColor;
        if (num != null && (qVar = this.mViewBinding) != null && (appCompatImageView = qVar.b) != null) {
            Intrinsics.e(num);
            appCompatImageView.setImageTintList(ColorStateList.valueOf(num.intValue()));
        }
        q qVar2 = this.mViewBinding;
        if (qVar2 != null && (tnTextView4 = qVar2.d) != null) {
            tnTextView4.setTextSize(0, this.textSize);
        }
        q qVar3 = this.mViewBinding;
        if (qVar3 != null && (tnTextView3 = qVar3.d) != null) {
            tnTextView3.setTextColor(this.textColor);
        }
        q qVar4 = this.mViewBinding;
        if (qVar4 != null && (tnTextView2 = qVar4.d) != null) {
            tnTextView2.setVisibility(this.textVisibility);
        }
        q qVar5 = this.mViewBinding;
        if (qVar5 == null || (tnTextView = qVar5.d) == null) {
            return;
        }
        int i = this.textStyle;
        if (i == 0) {
            Context context = getContext();
            Intrinsics.g(context, "getContext(...)");
            d = a.d(context);
        } else if (i == 1) {
            Context context2 = getContext();
            Intrinsics.g(context2, "getContext(...)");
            d = a.c(context2);
        } else if (i == 2) {
            Context context3 = getContext();
            Intrinsics.g(context3, "getContext(...)");
            d = a.a(context3);
        } else if (i != 3) {
            Context context4 = getContext();
            Intrinsics.g(context4, "getContext(...)");
            d = a.c(context4);
        } else {
            Context context5 = getContext();
            Intrinsics.g(context5, "getContext(...)");
            d = a.b(context5);
        }
        tnTextView.setTypeface(d);
    }

    public static /* synthetic */ void setAttrs$default(DownloadView downloadView, Integer num, Float f, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            f = null;
        }
        if ((i & 4) != 0) {
            num2 = null;
        }
        downloadView.setAttrs(num, f, num2);
    }

    public static /* synthetic */ void setShowType$default(DownloadView downloadView, String str, String str2, Boolean bool, boolean z, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "";
        }
        if ((i2 & 2) != 0) {
            str2 = "";
        }
        if ((i2 & 4) != 0) {
            bool = Boolean.FALSE;
        }
        if ((i2 & 8) != 0) {
            z = false;
        }
        if ((i2 & 16) != 0) {
            i = R$string.download_movie;
        }
        downloadView.setShowType(str, str2, bool, z, i);
    }

    public final q getMViewBinding() {
        return this.mViewBinding;
    }

    /* renamed from: getShowType, reason: from getter */
    public final int getType() {
        return this.type;
    }

    public final int getType() {
        return this.type;
    }

    public final void setAddCourse() {
        TnTextView tnTextView;
        AppCompatImageView appCompatImageView;
        this.type = 2;
        q qVar = this.mViewBinding;
        if (qVar != null && (appCompatImageView = qVar.b) != null) {
            appCompatImageView.setImageResource(R$mipmap.ic_add);
        }
        q qVar2 = this.mViewBinding;
        if (qVar2 == null || (tnTextView = qVar2.d) == null) {
            return;
        }
        tnTextView.setTextById(R$string.education_add_course);
    }

    public final void setAttrs(Integer tipTextColor, Float tipsTextSize, Integer iconSrc) {
        q qVar;
        TnTextView tnTextView;
        TnTextView tnTextView2;
        AppCompatImageView appCompatImageView;
        if (iconSrc != null) {
            int intValue = iconSrc.intValue();
            q qVar2 = this.mViewBinding;
            if (qVar2 != null && (appCompatImageView = qVar2.b) != null) {
                appCompatImageView.setImageResource(intValue);
            }
        }
        if (tipsTextSize != null) {
            float floatValue = tipsTextSize.floatValue();
            q qVar3 = this.mViewBinding;
            if (qVar3 != null && (tnTextView2 = qVar3.d) != null) {
                tnTextView2.setTextSize(0, floatValue);
            }
        }
        if (tipTextColor == null || (qVar = this.mViewBinding) == null || (tnTextView = qVar.d) == null) {
            return;
        }
        tnTextView.setTextColor(tipTextColor.intValue());
    }

    public final void setCourseAdded() {
        TnTextView tnTextView;
        AppCompatImageView appCompatImageView;
        this.type = 3;
        q qVar = this.mViewBinding;
        if (qVar != null && (appCompatImageView = qVar.b) != null) {
            appCompatImageView.setImageResource(R$mipmap.ic_added);
        }
        q qVar2 = this.mViewBinding;
        if (qVar2 == null || (tnTextView = qVar2.d) == null) {
            return;
        }
        tnTextView.setTextById(R$string.education_added);
    }

    public final void setMViewBinding(q qVar) {
        this.mViewBinding = qVar;
    }

    public final void setPageFrom(String pageName) {
        Intrinsics.h(pageName, "pageName");
        this.pageFrom = pageName;
    }

    public final void setShowPlayType() {
        q qVar;
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        TnTextView tnTextView;
        AppCompatImageView appCompatImageView3;
        this.type = 1;
        q qVar2 = this.mViewBinding;
        if (qVar2 != null && (appCompatImageView3 = qVar2.b) != null) {
            appCompatImageView3.setImageResource(this.playIconSrc);
        }
        q qVar3 = this.mViewBinding;
        if (qVar3 != null && (tnTextView = qVar3.d) != null) {
            tnTextView.setTextById(R$string.play);
        }
        q qVar4 = this.mViewBinding;
        Drawable drawable = (qVar4 == null || (appCompatImageView2 = qVar4.b) == null) ? null : appCompatImageView2.getDrawable();
        if (drawable == null || (qVar = this.mViewBinding) == null || (appCompatImageView = qVar.b) == null) {
            return;
        }
        appCompatImageView.setImageDrawable(drawable);
    }

    public final void setShowType(String subjectId, String resourceId, Boolean isSeries, boolean mutiRatio, int downloadTextResId) {
        q qVar;
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        TnTextView tnTextView;
        AppCompatImageView appCompatImageView3;
        TnTextView tnTextView2;
        AppCompatImageView appCompatImageView4;
        boolean w0 = DownloadManagerApi.j.a().w0(subjectId, resourceId, isSeries != null ? isSeries.booleanValue() : false, mutiRatio);
        this.type = w0 ? 1 : 0;
        if (!w0) {
            q qVar2 = this.mViewBinding;
            if (qVar2 != null && (appCompatImageView4 = qVar2.b) != null) {
                appCompatImageView4.setImageResource(this.downloadIconSrc);
            }
            q qVar3 = this.mViewBinding;
            if (qVar3 == null || (tnTextView2 = qVar3.d) == null) {
                return;
            }
            tnTextView2.setTextById(downloadTextResId);
            return;
        }
        q qVar4 = this.mViewBinding;
        if (qVar4 != null && (appCompatImageView3 = qVar4.b) != null) {
            appCompatImageView3.setImageResource(this.playIconSrc);
        }
        q qVar5 = this.mViewBinding;
        if (qVar5 != null && (tnTextView = qVar5.d) != null) {
            tnTextView.setTextById(R$string.play);
        }
        q qVar6 = this.mViewBinding;
        Drawable drawable = (qVar6 == null || (appCompatImageView2 = qVar6.b) == null) ? null : appCompatImageView2.getDrawable();
        if (drawable == null || (qVar = this.mViewBinding) == null || (appCompatImageView = qVar.b) == null) {
            return;
        }
        appCompatImageView.setImageDrawable(drawable);
    }

    public final void setType(int i) {
        this.type = i;
    }
}
