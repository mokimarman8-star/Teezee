package com.transsion.commercialization.pslink;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import com.tn.lib.widget.R;
import com.transsion.ad.ps.model.RecommendInfo;
import com.transsion.commercialization.R$string;
import com.transsion.commercialization.R$styleable;
import com.transsion.gslb.BuildConfig;
import com.transsnet.launcherlib.PalmStoreDownLoadTaskInfo;
import ij.y;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0085\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0005*\u0001f\u0018\u0000 i2\u00020\u0001:\u0001BB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ/\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\tH\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0017H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0010H\u0014¢\u0006\u0004\b!\u0010 J\u000f\u0010#\u001a\u00020\"H\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020\t2\u0006\u0010%\u001a\u00020\tH\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b(\u0010\u001aJ\u0017\u0010)\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b)\u0010\u001aJ\u0017\u0010\r\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\r\u0010\u001aJ\u0017\u0010*\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b*\u0010\u001aJ\u0017\u0010+\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b+\u0010\u001aJ\u0017\u0010,\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b,\u0010\u001aJ\u0017\u0010-\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b-\u0010\u001aJ#\u00100\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00172\n\u0010/\u001a\u00020.\"\u00020\tH\u0002¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b2\u0010\u001aJ\u0017\u00106\u001a\u0002052\u0006\u00104\u001a\u000203H\u0002¢\u0006\u0004\b6\u00107J\u001f\u00109\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u00108\u001a\u00020\"H\u0002¢\u0006\u0004\b9\u0010:J\u001f\u0010;\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u00108\u001a\u00020\"H\u0002¢\u0006\u0004\b;\u0010:J\u000f\u0010<\u001a\u00020\"H\u0002¢\u0006\u0004\b<\u0010$J\u000f\u0010=\u001a\u00020\tH\u0002¢\u0006\u0004\b=\u0010>J\u0017\u0010@\u001a\u00020\u00102\u0006\u0010?\u001a\u00020\tH\u0002¢\u0006\u0004\b@\u0010AJ\u000f\u0010B\u001a\u00020\u0010H\u0002¢\u0006\u0004\bB\u0010 J\u000f\u0010C\u001a\u00020\u0010H\u0002¢\u0006\u0004\bC\u0010 J3\u0010I\u001a\u00020\u00102\u0006\u0010D\u001a\u00020\"2\u0006\u0010E\u001a\u00020\"2\b\u0010G\u001a\u0004\u0018\u00010F2\b\u0010H\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0004\bI\u0010JJ\u0019\u0010K\u001a\u00020\u00102\b\u0010G\u001a\u0004\u0018\u00010FH\u0002¢\u0006\u0004\bK\u0010LR\u0016\u0010N\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010MR\u0016\u0010Q\u001a\u00020O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010PR\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010PR\u0016\u0010S\u001a\u00020O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010PR\u0016\u0010T\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010MR\u0016\u0010U\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010MR\u0016\u0010V\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010MR\u0016\u0010W\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010MR\u0016\u0010X\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010MR\u0016\u0010[\u001a\u00020Y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010ZR\u0016\u0010\\\u001a\u00020Y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010ZR\u0016\u0010]\u001a\u00020Y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010ZR\u0016\u0010`\u001a\u00020^8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010_R\u0016\u0010c\u001a\u00020a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010bR\u0018\u0010e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010dR\u0014\u0010h\u001a\u00020f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u0010g¨\u0006j"}, d2 = {"Lcom/transsion/commercialization/pslink/PsLinkDownLoadButton;", "Landroid/widget/ProgressBar;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BuildConfig.FLAVOR, "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "w", "h", "oldw", "oldh", BuildConfig.FLAVOR, "onSizeChanged", "(IIII)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "Lcom/transsion/ad/ps/model/RecommendInfo;", "itemInfo", "setItemInfo", "(Lcom/transsion/ad/ps/model/RecommendInfo;)V", "onAttachedToWindow", "()V", "onDetachedFromWindow", BuildConfig.FLAVOR, "getClassTag", "()Ljava/lang/String;", "res", "o", "(I)I", "d", "n", "f", "e", "i", "m", BuildConfig.FLAVOR, "colors", "l", "(Landroid/graphics/Canvas;[I)V", "j", "Landroid/graphics/RectF;", "mRectF", "Landroid/graphics/LinearGradient;", "p", "(Landroid/graphics/RectF;)Landroid/graphics/LinearGradient;", "text", "k", "(Landroid/graphics/Canvas;Ljava/lang/String;)V", "g", "getPercent", "b", "()I", "state", "setState", "(I)V", "a", "q", "callBackName", "param", "Lcom/transsnet/launcherlib/PalmStoreDownLoadTaskInfo;", "palmStoreDownLoadTaskInfo", "pkgName", "c", "(Ljava/lang/String;Ljava/lang/String;Lcom/transsnet/launcherlib/PalmStoreDownLoadTaskInfo;Ljava/lang/String;)V", "setInnerProgress", "(Lcom/transsnet/launcherlib/PalmStoreDownLoadTaskInfo;)V", "I", "mBgStyle", BuildConfig.FLAVOR, "F", "mBorderRadius", "mBorderWidth", "mTextSize", "mValidWidth", "mValidHeight", "mCurrentState", "mInstallColor", "mProgressColor", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "mPaintBg", "mPaintProgress", "textPaint", "Landroid/graphics/Path;", "Landroid/graphics/Path;", "mProgressPath", "Landroid/graphics/PorterDuffXfermode;", "Landroid/graphics/PorterDuffXfermode;", "mPorterDuffMode", "Lcom/transsion/ad/ps/model/RecommendInfo;", "mItemInfo", "com/transsion/commercialization/pslink/PsLinkDownLoadButton$b", "Lcom/transsion/commercialization/pslink/PsLinkDownLoadButton$b;", "downloadCallback", "Companion", "Commercialization_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PsLinkDownLoadButton extends ProgressBar {
    public static final int BG_STYLE_DEF_BG_08 = 1;
    public static final int BG_STYLE_GRADIENT = 2;
    public static final int STATE_INSTALLED = 6;
    public static final int STATE_NETWORK_ERROR = 12;
    public static final int STATE_PROGRESS_DOWNLOADING = 2;
    public static final int STATE_PROGRESS_INSTALLED = 5;
    public static final int STATE_PROGRESS_INSTALLING = 4;
    public static final int STATE_PROGRESS_NONE = 0;
    public static final int STATE_PROGRESS_PAUSE = 3;
    public static final int STATE_PROGRESS_WAITING = 1;

    /* renamed from: a, reason: from kotlin metadata */
    private int mBgStyle;

    /* renamed from: b, reason: from kotlin metadata */
    private float mBorderRadius;

    /* renamed from: c, reason: from kotlin metadata */
    private float mBorderWidth;

    /* renamed from: d, reason: from kotlin metadata */
    private float mTextSize;

    /* renamed from: e, reason: from kotlin metadata */
    private int mValidWidth;

    /* renamed from: f, reason: from kotlin metadata */
    private int mValidHeight;

    /* renamed from: g, reason: from kotlin metadata */
    private int mCurrentState;

    /* renamed from: h, reason: from kotlin metadata */
    private int mInstallColor;

    /* renamed from: i, reason: from kotlin metadata */
    private int mProgressColor;

    /* renamed from: j, reason: from kotlin metadata */
    private Paint mPaintBg;

    /* renamed from: k, reason: from kotlin metadata */
    private Paint mPaintProgress;

    /* renamed from: l, reason: from kotlin metadata */
    private Paint textPaint;

    /* renamed from: m, reason: from kotlin metadata */
    private Path mProgressPath;

    /* renamed from: n, reason: from kotlin metadata */
    private PorterDuffXfermode mPorterDuffMode;

    /* renamed from: o, reason: from kotlin metadata */
    private RecommendInfo mItemInfo;

    /* renamed from: p, reason: from kotlin metadata */
    private final b downloadCallback;

    public static final class b implements com.transsion.commercialization.pslink.b {
        b() {
        }

        @Override // com.transsion.commercialization.pslink.b
        public void a(String str, String str2, PalmStoreDownLoadTaskInfo palmStoreDownLoadTaskInfo, String str3) {
            Intrinsics.h(str, "callBackName");
            Intrinsics.h(str2, "param");
            a.a.a("callBackCommon: " + str + ", " + str2 + ", " + str3);
            RecommendInfo recommendInfo = PsLinkDownLoadButton.this.mItemInfo;
            if (TextUtils.equals(recommendInfo != null ? recommendInfo.getPackageName() : null, str3)) {
                PsLinkDownLoadButton.this.c(str, str2, palmStoreDownLoadTaskInfo, str3);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PsLinkDownLoadButton(Context context) {
        this(context, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PsLinkDownLoadButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PsLinkDownLoadButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        this.mBgStyle = 1;
        this.mInstallColor = o(R.color.bg_08);
        this.mProgressColor = -256;
        this.mPaintBg = new Paint();
        this.mPaintProgress = new Paint();
        this.textPaint = new Paint();
        this.mProgressPath = new Path();
        this.mPorterDuffMode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        this.downloadCallback = new b();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PsLinkDownLoadButton);
        Intrinsics.g(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.mBorderRadius = obtainStyledAttributes.getDimension(R$styleable.PsLinkDownLoadButton_border_radius, 0.0f);
        this.mBorderWidth = obtainStyledAttributes.getDimension(R$styleable.PsLinkDownLoadButton_border_width, 6.0f);
        this.mTextSize = obtainStyledAttributes.getDimension(R$styleable.PsLinkDownLoadButton_progress_textSize, 46.0f);
        this.mBgStyle = obtainStyledAttributes.getInt(R$styleable.PsLinkDownLoadButton_bg_style, 1);
        obtainStyledAttributes.recycle();
        this.mPaintBg.setAntiAlias(true);
        this.mPaintProgress.setAntiAlias(true);
        this.textPaint.setTextSize(this.mTextSize);
        this.textPaint.setAntiAlias(true);
    }

    private final void a() {
        PsLinkServiceHelper.a.g(this.downloadCallback);
    }

    private final int b() {
        return (int) (100 * ((getProgress() * 1.0f) / getMax()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(String callBackName, String param, PalmStoreDownLoadTaskInfo palmStoreDownLoadTaskInfo, String pkgName) {
        a aVar = a.a;
        String classTag = getClassTag();
        Integer valueOf = palmStoreDownLoadTaskInfo != null ? Integer.valueOf(palmStoreDownLoadTaskInfo.getStatus()) : null;
        Float valueOf2 = palmStoreDownLoadTaskInfo != null ? Float.valueOf(palmStoreDownLoadTaskInfo.getProgress()) : null;
        aVar.b(classTag + " --> dealWithCallBack() --> 开始刷新数据 -- callBackName = " + callBackName + " -- pkgName = " + pkgName + " -- status = " + valueOf + " -- progress = " + valueOf2 + "-- param.length = " + param.length());
        if (palmStoreDownLoadTaskInfo == null) {
            if (TextUtils.equals("installApp", callBackName)) {
                RecommendInfo recommendInfo = this.mItemInfo;
                if (recommendInfo != null) {
                    recommendInfo.setPalmStoreDownLoadTaskInfo(null);
                }
                setState(5);
                return;
            }
            if (TextUtils.equals("removedApp", callBackName)) {
                setState(0);
                return;
            } else {
                setState(0);
                return;
            }
        }
        RecommendInfo recommendInfo2 = this.mItemInfo;
        if (recommendInfo2 != null) {
            recommendInfo2.setPalmStoreDownLoadTaskInfo(palmStoreDownLoadTaskInfo);
        }
        int status = palmStoreDownLoadTaskInfo.getStatus();
        if (status == 1) {
            setState(1);
            return;
        }
        if (status == 2) {
            setInnerProgress(palmStoreDownLoadTaskInfo);
            setState(2);
            return;
        }
        if (status == 3) {
            setInnerProgress(palmStoreDownLoadTaskInfo);
            setState(3);
            f.a.h(pkgName, palmStoreDownLoadTaskInfo.getStatus());
        } else if (status == 6) {
            setState(5);
            f.a.h(pkgName, palmStoreDownLoadTaskInfo.getStatus());
        } else if (status == 11) {
            setState(4);
        } else {
            if (status != 12) {
                return;
            }
            setState(12);
            f.a.h(pkgName, palmStoreDownLoadTaskInfo.getStatus());
        }
    }

    private final void d(Canvas canvas) {
        l(canvas, o(R.color.brand_gradient_start), o(R.color.brand_gradient_center), o(R.color.brand_gradient_end));
        String string = getContext().getResources().getString(R$string.ps_link_install);
        Intrinsics.g(string, "getString(...)");
        k(canvas, string);
    }

    private final void e(Canvas canvas) {
        int i = this.mBgStyle;
        if (i == 1) {
            int i2 = this.mInstallColor;
            l(canvas, i2, i2, i2);
        } else if (i == 2) {
            l(canvas, o(R.color.brand_gradient_start_60), o(R.color.brand_gradient_center_60), o(R.color.brand_gradient_end_60));
        }
        j(canvas);
        k(canvas, BuildConfig.FLAVOR);
        g(canvas, BuildConfig.FLAVOR);
    }

    private final void f(Canvas canvas) {
        int i = this.mBgStyle;
        if (i == 1) {
            int i2 = this.mInstallColor;
            l(canvas, i2, i2, i2);
        } else if (i == 2) {
            l(canvas, o(R.color.brand_gradient_start), o(R.color.brand_gradient_center), o(R.color.brand_gradient_end));
        }
        String string = getContext().getResources().getString(R$string.ps_link_open);
        Intrinsics.g(string, "getString(...)");
        k(canvas, string);
    }

    private final void g(Canvas canvas, String text) {
        this.textPaint.setColor(-1);
        if (TextUtils.isEmpty(text)) {
            text = getPercent();
        }
        float measureText = this.textPaint.measureText(text);
        float f = 2;
        float measuredWidth = (getMeasuredWidth() - measureText) / f;
        float descent = (this.mValidHeight / 2) - ((this.textPaint.descent() + this.textPaint.ascent()) / f);
        float progress = ((getProgress() - (100 / getMax())) * getMeasuredWidth()) / 100;
        if (progress > measuredWidth) {
            canvas.translate(getPaddingLeft(), getPaddingTop());
        }
        canvas.clipRect(measuredWidth, 0.0f, progress, getMeasuredHeight());
        canvas.drawText(text, measuredWidth, descent, this.textPaint);
    }

    private final String getClassTag() {
        String simpleName = PsLinkDownLoadButton.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    private final String getPercent() {
        return TextUtils.concat(String.valueOf(b()), "%").toString();
    }

    private final void h(Canvas canvas) {
        l(canvas, o(R.color.brand_gradient_start), o(R.color.brand_gradient_center), o(R.color.brand_gradient_end));
        String string = getContext().getResources().getString(R$string.ps_link_installing);
        Intrinsics.g(string, "getString(...)");
        k(canvas, string);
    }

    private final void i(Canvas canvas) {
        int i = this.mBgStyle;
        if (i == 1) {
            int i2 = this.mInstallColor;
            l(canvas, i2, i2, i2);
        } else if (i == 2) {
            l(canvas, o(R.color.brand_gradient_start_60), o(R.color.brand_gradient_center_60), o(R.color.brand_gradient_end_60));
        }
        j(canvas);
        String string = getContext().getResources().getString(R$string.ps_link_continue);
        Intrinsics.g(string, "getString(...)");
        k(canvas, string);
        String string2 = getContext().getResources().getString(R$string.ps_link_continue);
        Intrinsics.g(string2, "getString(...)");
        g(canvas, string2);
    }

    private final void j(Canvas canvas) {
        Paint paint = this.mPaintBg;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        float progress = this.mValidWidth * ((getProgress() * 1.0f) / getMax());
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, progress, getHeight(), this.mPaintBg);
        float f = this.mBorderWidth;
        RectF rectF = new RectF(f, f, this.mValidWidth - f, this.mValidHeight - f);
        this.mPaintBg.setShader(null);
        this.mPaintBg.setColor(-256);
        float f2 = this.mBorderRadius;
        canvas.drawRoundRect(rectF, f2, f2, this.mPaintBg);
        this.mPaintProgress.setStyle(style);
        this.mPaintProgress.setShader(p(rectF));
        this.mProgressPath.reset();
        this.mProgressPath.addRect(new RectF(0.0f, 0.0f, progress, this.mValidHeight), Path.Direction.CCW);
        this.mPaintProgress.setXfermode(this.mPorterDuffMode);
        canvas.drawPath(this.mProgressPath, this.mPaintProgress);
        canvas.restoreToCount(saveLayer);
        this.mPaintProgress.setXfermode(null);
    }

    private final void k(Canvas canvas, String text) {
        if (zh.b.a.m()) {
            canvas.rotate(180.0f, this.mValidWidth / 2.0f, this.mValidHeight / 2.0f);
        }
        Paint paint = this.textPaint;
        int i = this.mCurrentState;
        int i2 = -1;
        if (i != 0 && i != 1 && ((i == 2 || i == 3 || i == 5) && this.mBgStyle != 2 && !y.a.a())) {
            i2 = -16777216;
        }
        paint.setColor(i2);
        Paint paint2 = this.textPaint;
        Context context = getContext();
        Intrinsics.g(context, "getContext(...)");
        paint2.setTypeface(uf.a.a(context));
        if (TextUtils.isEmpty(text)) {
            text = getPercent();
        }
        float f = 2;
        canvas.drawText(text, (this.mValidWidth / 2) - (this.textPaint.measureText(text) / f), (this.mValidHeight / 2) - ((this.textPaint.descent() + this.textPaint.ascent()) / f), this.textPaint);
    }

    private final void l(Canvas canvas, int... colors) {
        this.mPaintBg.setStyle(Paint.Style.FILL);
        float f = this.mBorderWidth;
        RectF rectF = new RectF(f, f, this.mValidWidth - f, this.mValidHeight - f);
        this.mPaintBg.setShader(new LinearGradient(0.0f, 0.0f, rectF.right, rectF.bottom, colors, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        float f2 = this.mBorderRadius;
        canvas.drawRoundRect(rectF, f2, f2, this.mPaintBg);
    }

    private final void m(Canvas canvas) {
        int i = this.mBgStyle;
        if (i == 1) {
            int i2 = this.mInstallColor;
            l(canvas, i2, i2, i2);
        } else if (i == 2) {
            l(canvas, o(R.color.brand_gradient_start_60), o(R.color.brand_gradient_center_60), o(R.color.brand_gradient_end_60));
        }
        j(canvas);
        String string = getContext().getString(com.transsion.baseui.R.string.retry_text);
        Intrinsics.g(string, "getString(...)");
        k(canvas, string);
    }

    private final void n(Canvas canvas) {
        l(canvas, o(R.color.brand_gradient_start), o(R.color.brand_gradient_center), o(R.color.brand_gradient_end));
        String string = getContext().getResources().getString(R$string.ps_link_waiting);
        Intrinsics.g(string, "getString(...)");
        k(canvas, string);
    }

    private final int o(int res) {
        return getContext().getColor(res);
    }

    private final LinearGradient p(RectF mRectF) {
        return new LinearGradient(0.0f, 0.0f, mRectF.right, mRectF.bottom, new int[]{o(R.color.brand_gradient_start), o(R.color.brand_gradient_center), o(R.color.brand_gradient_end)}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
    }

    private final void q() {
        PsLinkServiceHelper.a.m(this.downloadCallback);
    }

    private final void setInnerProgress(PalmStoreDownLoadTaskInfo palmStoreDownLoadTaskInfo) {
        int progress = palmStoreDownLoadTaskInfo != null ? (int) palmStoreDownLoadTaskInfo.getProgress() : 0;
        if (progress > 100) {
            progress = 100;
        }
        setProgress(progress);
    }

    private final void setState(int state) {
        this.mCurrentState = state;
        postInvalidate();
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        a();
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        q();
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.h(canvas, "canvas");
        if (zh.b.a.m()) {
            canvas.rotate(180.0f, this.mValidWidth / 2.0f, this.mValidHeight / 2.0f);
        }
        int i = this.mCurrentState;
        if (i == 0) {
            d(canvas);
            return;
        }
        if (i == 1) {
            n(canvas);
            return;
        }
        if (i == 2) {
            e(canvas);
            return;
        }
        if (i == 3) {
            i(canvas);
            return;
        }
        if (i == 4) {
            h(canvas);
        } else if (i == 5) {
            f(canvas);
        } else {
            if (i != 12) {
                return;
            }
            m(canvas);
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        float f = 2;
        int measureText = (int) (this.textPaint.measureText("下载") + (this.mBorderWidth * f));
        int descent = (int) (this.textPaint.descent() + Math.abs(this.textPaint.ascent()) + (this.mBorderWidth * f));
        if (getLayoutParams().width == -2 && getLayoutParams().height == -2) {
            setMeasuredDimension(measureText, descent);
        } else if (getLayoutParams().width == -2) {
            setMeasuredDimension(measureText, size2);
        } else if (getLayoutParams().height == -2) {
            setMeasuredDimension(size, descent);
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.mValidWidth = (getWidth() - getPaddingLeft()) - getPaddingRight();
        this.mValidHeight = (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    public final void setItemInfo(RecommendInfo itemInfo) {
        PalmStoreDownLoadTaskInfo palmStoreDownLoadTaskInfo;
        String str;
        Intrinsics.h(itemInfo, "itemInfo");
        this.mItemInfo = itemInfo;
        if ((itemInfo != null ? itemInfo.getPalmStoreDownLoadTaskInfo() : null) == null) {
            zh.b bVar = zh.b.a;
            RecommendInfo recommendInfo = this.mItemInfo;
            if (recommendInfo == null || (str = recommendInfo.getPackageName()) == null) {
                str = BuildConfig.FLAVOR;
            }
            if (bVar.c(str)) {
                setState(5);
                return;
            } else {
                setState(0);
                return;
            }
        }
        RecommendInfo recommendInfo2 = this.mItemInfo;
        Integer valueOf = (recommendInfo2 == null || (palmStoreDownLoadTaskInfo = recommendInfo2.getPalmStoreDownLoadTaskInfo()) == null) ? null : Integer.valueOf(palmStoreDownLoadTaskInfo.getStatus());
        if (valueOf != null && valueOf.intValue() == 1) {
            setState(1);
            return;
        }
        if (valueOf != null && valueOf.intValue() == 11) {
            setState(4);
            return;
        }
        if (valueOf != null && valueOf.intValue() == 3) {
            RecommendInfo recommendInfo3 = this.mItemInfo;
            setInnerProgress(recommendInfo3 != null ? recommendInfo3.getPalmStoreDownLoadTaskInfo() : null);
            setState(3);
        } else if (valueOf != null && valueOf.intValue() == 2) {
            RecommendInfo recommendInfo4 = this.mItemInfo;
            setInnerProgress(recommendInfo4 != null ? recommendInfo4.getPalmStoreDownLoadTaskInfo() : null);
            setState(2);
        } else if (valueOf != null && valueOf.intValue() == 12) {
            setState(12);
        }
    }
}
