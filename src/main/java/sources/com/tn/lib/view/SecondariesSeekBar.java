package com.tn.lib.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.tn.lib.widget.R;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 \u0098\u00012\u00020\u0001:\u0001*B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0014\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0015\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0016\u0010\u0012J\u0017\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0017\u0010\u0012J\u0017\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\fH\u0002¢\u0006\u0004\b \u0010\u000eJ\u000f\u0010!\u001a\u00020\tH\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\fH\u0002¢\u0006\u0004\b#\u0010\u000eJ\u0017\u0010&\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020$2\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020$2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b*\u0010+J\u001f\u0010-\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010,\u001a\u00020$H\u0002¢\u0006\u0004\b-\u0010.J\u001f\u00101\u001a\u00020\f2\u0006\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\tH\u0014¢\u0006\u0004\b1\u00102J\u0017\u00103\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0015¢\u0006\u0004\b3\u0010\u0012J\u0017\u00105\u001a\u0002042\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b5\u00106J\u0015\u00108\u001a\u00020\f2\u0006\u00107\u001a\u000204¢\u0006\u0004\b8\u00109J\u0015\u0010;\u001a\u00020\f2\u0006\u0010:\u001a\u00020\u001c¢\u0006\u0004\b;\u0010\u001fJ\u0015\u0010<\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b<\u0010\u001fJ\r\u0010=\u001a\u00020\u001c¢\u0006\u0004\b=\u0010>J\r\u0010?\u001a\u00020\u001c¢\u0006\u0004\b?\u0010>J!\u0010A\u001a\u00020\f2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0@¢\u0006\u0004\bA\u0010BJ\u0015\u0010E\u001a\u00020\f2\u0006\u0010D\u001a\u00020C¢\u0006\u0004\bE\u0010FR\u0014\u0010I\u001a\u00020G8\u0002X\u0082D¢\u0006\u0006\n\u0004\b*\u0010HR\u0016\u0010K\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010JR\u0016\u0010L\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010JR\u0016\u0010M\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010JR\u0014\u0010P\u001a\u00020N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010OR\u0014\u0010Q\u001a\u00020N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010OR\u0014\u0010R\u001a\u00020N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010OR\u0014\u0010S\u001a\u00020N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010OR\u0016\u0010V\u001a\u00020T8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010UR\u0016\u0010X\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010WR\u0016\u0010Y\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010WR\u0016\u0010Z\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010WR\u0016\u0010[\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010WR\u0016\u0010\\\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010WR\u0016\u0010]\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010WR\u0016\u0010_\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010WR\u0016\u0010b\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010d\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010WR\u0016\u0010f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010WR\u0016\u0010h\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010WR\u0016\u0010j\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010aR\u0016\u0010l\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010WR\u0016\u0010n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010WR\u0016\u0010p\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010aR\u0014\u0010t\u001a\u00020q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\br\u0010sR\u0014\u0010x\u001a\u00020u8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bv\u0010wR\u0016\u00108\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\by\u0010zR\u0016\u0010|\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010WR\u0016\u0010~\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010WR\u0017\u0010\u0080\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u007f\u0010WR\u0018\u0010\u0082\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0081\u0001\u0010WR\u0017\u0010\u0083\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010WR\u0018\u0010\u0085\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0084\u0001\u0010WR\u0018\u0010\u0087\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0086\u0001\u0010WR$\u0010\u0089\u0001\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0@8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bW\u0010\u0088\u0001R\u0019\u0010\u008c\u0001\u001a\u00030\u008a\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bJ\u0010\u008b\u0001R\u001a\u0010\u008e\u0001\u001a\u00030\u008a\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008b\u0001R\u0016\u0010\u0090\u0001\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u008f\u0001\u0010zR\u0018\u0010\u0092\u0001\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0091\u0001\u0010zR\u001a\u0010D\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R\u0017\u0010\u0097\u0001\u001a\u0002048BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001¨\u0006\u0099\u0001"}, d2 = {"Lcom/tn/lib/view/SecondariesSeekBar;", "Landroid/view/View;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "k", "()V", "Landroid/graphics/Canvas;", "canvas", "f", "(Landroid/graphics/Canvas;)V", "i", "e", "g", "h", "j", "Landroid/view/MotionEvent;", "event", "m", "(Landroid/view/MotionEvent;)V", "", "progress", "l", "(J)V", "n", "getThumbHalfWidth", "()I", "o", "", "touchX", "b", "(F)J", "c", "(F)F", "a", "(Landroid/view/MotionEvent;)F", "dpValue", "d", "(Landroid/content/Context;F)I", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "onDraw", "", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", OfflineConstantsKt.OFFLINE_CONFIG_ENABLE, "seekEnable", "(Z)V", "max", "setMax", "setProgress", "getMaxProgress", "()J", "getProgress", "", "setSecondariesProgress", "(Ljava/util/Map;)V", "Lcom/tn/lib/view/s;", "listener", "setOnSeekBarChangeListener", "(Lcom/tn/lib/view/s;)V", "", "Ljava/lang/String;", "TAG", "J", "maxProgress", "currentProgress", "lastProgress", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "bgPaint", "secondaryPaint", "progressPaint", "thumbPaint", "", "[I", "progressColors", "I", "secondariesProgressColor", "bgColor", "progressSize", "thumbColor", "thumbSize", "thumbRadius", "p", "thumbTouchRadius", "q", "F", "thumbTouchMultiple", "r", "thumbShape", "s", "thumbRectWidth", "t", "thumbRectHeight", "u", "thumbCornerRadius", "v", "thumbRectTouchWidth", "w", "thumbRectTouchHeight", "x", "thumbRectTouchCornerRadius", "Landroid/graphics/RectF;", "y", "Landroid/graphics/RectF;", "thumbRectF", "Landroid/graphics/Path;", "z", "Landroid/graphics/Path;", "progressPath", "A", "Z", "B", "viewHeight", "C", "viewWidth", "D", "barWidth", "E", "viewPaddingLeft", "viewPaddingRight", "G", "viewPaddingTop", "H", "viewPaddingBottom", "Ljava/util/Map;", "secondariesProgressLocation", "Landroid/graphics/Rect;", "Landroid/graphics/Rect;", "bgRect", "K", "progressRect", "L", "r2l", "M", "isTouching", "N", "Lcom/tn/lib/view/s;", "getRightToLeft", "()Z", "rightToLeft", "Companion", "UI_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class SecondariesSeekBar extends View {
    public static final int THUMB_SHAPE_CIRCLE = 0;
    public static final int THUMB_SHAPE_ROUNDED_RECT = 1;

    /* renamed from: A, reason: from kotlin metadata */
    private boolean seekEnable;

    /* renamed from: B, reason: from kotlin metadata */
    private int viewHeight;

    /* renamed from: C, reason: from kotlin metadata */
    private int viewWidth;

    /* renamed from: D, reason: from kotlin metadata */
    private int barWidth;

    /* renamed from: E, reason: from kotlin metadata */
    private int viewPaddingLeft;

    /* renamed from: F, reason: from kotlin metadata */
    private int viewPaddingRight;

    /* renamed from: G, reason: from kotlin metadata */
    private int viewPaddingTop;

    /* renamed from: H, reason: from kotlin metadata */
    private int viewPaddingBottom;

    /* renamed from: I, reason: from kotlin metadata */
    private Map secondariesProgressLocation;

    /* renamed from: J, reason: from kotlin metadata */
    private Rect bgRect;

    /* renamed from: K, reason: from kotlin metadata */
    private Rect progressRect;

    /* renamed from: L, reason: from kotlin metadata */
    private final boolean r2l;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean isTouching;

    /* renamed from: N, reason: from kotlin metadata */
    private s listener;

    /* renamed from: a, reason: from kotlin metadata */
    private final String TAG;

    /* renamed from: b, reason: from kotlin metadata */
    private long maxProgress;

    /* renamed from: c, reason: from kotlin metadata */
    private long currentProgress;

    /* renamed from: d, reason: from kotlin metadata */
    private long lastProgress;

    /* renamed from: e, reason: from kotlin metadata */
    private final Paint bgPaint;

    /* renamed from: f, reason: from kotlin metadata */
    private final Paint secondaryPaint;

    /* renamed from: g, reason: from kotlin metadata */
    private final Paint progressPaint;

    /* renamed from: h, reason: from kotlin metadata */
    private final Paint thumbPaint;

    /* renamed from: i, reason: from kotlin metadata */
    private int[] progressColors;

    /* renamed from: j, reason: from kotlin metadata */
    private int secondariesProgressColor;

    /* renamed from: k, reason: from kotlin metadata */
    private int bgColor;

    /* renamed from: l, reason: from kotlin metadata */
    private int progressSize;

    /* renamed from: m, reason: from kotlin metadata */
    private int thumbColor;

    /* renamed from: n, reason: from kotlin metadata */
    private int thumbSize;

    /* renamed from: o, reason: from kotlin metadata */
    private int thumbRadius;

    /* renamed from: p, reason: from kotlin metadata */
    private int thumbTouchRadius;

    /* renamed from: q, reason: from kotlin metadata */
    private float thumbTouchMultiple;

    /* renamed from: r, reason: from kotlin metadata */
    private int thumbShape;

    /* renamed from: s, reason: from kotlin metadata */
    private int thumbRectWidth;

    /* renamed from: t, reason: from kotlin metadata */
    private int thumbRectHeight;

    /* renamed from: u, reason: from kotlin metadata */
    private float thumbCornerRadius;

    /* renamed from: v, reason: from kotlin metadata */
    private int thumbRectTouchWidth;

    /* renamed from: w, reason: from kotlin metadata */
    private int thumbRectTouchHeight;

    /* renamed from: x, reason: from kotlin metadata */
    private float thumbRectTouchCornerRadius;

    /* renamed from: y, reason: from kotlin metadata */
    private final RectF thumbRectF;

    /* renamed from: z, reason: from kotlin metadata */
    private final Path progressPath;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SecondariesSeekBar(Context context) {
        this(context, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SecondariesSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SecondariesSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int[] iArr;
        Intrinsics.h(context, "context");
        this.TAG = "SecondariesSeekBar";
        this.maxProgress = 100L;
        this.thumbTouchMultiple = 1.5f;
        this.thumbRectF = new RectF();
        this.progressPath = new Path();
        this.secondariesProgressLocation = new LinkedHashMap();
        this.bgRect = new Rect();
        this.progressRect = new Rect();
        boolean rightToLeft = getRightToLeft();
        this.r2l = rightToLeft;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SecondariesSeekBar);
        Intrinsics.g(obtainStyledAttributes, "obtainStyledAttributes(...)");
        int color = obtainStyledAttributes.getColor(R.styleable.SecondariesSeekBar_ssb_bar_start_color, -1);
        int color2 = obtainStyledAttributes.getColor(R.styleable.SecondariesSeekBar_ssb_bar_center_color, -1);
        int color3 = obtainStyledAttributes.getColor(R.styleable.SecondariesSeekBar_ssb_bar_end_color, -1);
        if (color2 > 0) {
            iArr = new int[3];
            iArr[rightToLeft ? (char) 2 : (char) 0] = color;
            iArr[1] = color2;
            iArr[rightToLeft ? (char) 0 : (char) 2] = color3;
        } else {
            iArr = new int[2];
            iArr[rightToLeft ? 1 : 0] = color;
            iArr[!rightToLeft ? 1 : 0] = color3;
        }
        this.progressColors = iArr;
        this.secondariesProgressColor = obtainStyledAttributes.getColor(R.styleable.SecondariesSeekBar_ssb_secondaries_color, -1);
        this.bgColor = obtainStyledAttributes.getColor(R.styleable.SecondariesSeekBar_ssb_bg_color, -1);
        this.seekEnable = obtainStyledAttributes.getBoolean(R.styleable.SecondariesSeekBar_ssb_seek_enable, true);
        this.thumbColor = obtainStyledAttributes.getColor(R.styleable.SecondariesSeekBar_ssb_thumb_color, -1);
        this.progressSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SecondariesSeekBar_ssb_progress_size, d(context, 2.0f));
        this.thumbSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SecondariesSeekBar_ssb_thumb_size, d(context, 8.0f));
        this.maxProgress = obtainStyledAttributes.getInt(R.styleable.SecondariesSeekBar_ssb_max, 100);
        this.currentProgress = obtainStyledAttributes.getInt(R.styleable.SecondariesSeekBar_ssb_progress, 0);
        float f = obtainStyledAttributes.getFloat(R.styleable.SecondariesSeekBar_ssb_thumb_enlarge, 1.5f);
        this.thumbTouchMultiple = f;
        if (f < 1.0f) {
            this.thumbTouchMultiple = 1.0f;
        } else if (f > 2.0f) {
            this.thumbTouchMultiple = 2.0f;
        }
        int i2 = this.thumbSize;
        int i3 = this.progressSize;
        if (i2 < i3) {
            this.thumbSize = i3;
        }
        int i4 = (int) (this.thumbSize / 2.0f);
        this.thumbRadius = i4;
        this.thumbTouchRadius = (int) (i4 * this.thumbTouchMultiple);
        this.thumbShape = obtainStyledAttributes.getInt(R.styleable.SecondariesSeekBar_ssb_thumb_shape, 0);
        this.thumbRectWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SecondariesSeekBar_ssb_thumb_width, d(context, 6.0f));
        this.thumbRectHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SecondariesSeekBar_ssb_thumb_height, d(context, 14.0f));
        float dimension = obtainStyledAttributes.getDimension(R.styleable.SecondariesSeekBar_ssb_thumb_corner_radius, this.thumbRectWidth / 2.0f);
        this.thumbCornerRadius = dimension;
        float f2 = this.thumbRectWidth;
        float f3 = this.thumbTouchMultiple;
        this.thumbRectTouchWidth = (int) (f2 * f3);
        this.thumbRectTouchHeight = (int) (this.thumbRectHeight * f3);
        this.thumbRectTouchCornerRadius = dimension * f3;
        obtainStyledAttributes.recycle();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Paint.Cap cap = Paint.Cap.ROUND;
        paint.setStrokeCap(cap);
        paint.setColor(this.bgColor);
        paint.setStrokeWidth(this.progressSize);
        this.bgPaint = paint;
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setStrokeCap(cap);
        paint2.setColor(this.secondariesProgressColor);
        paint2.setStrokeWidth(this.progressSize);
        this.secondaryPaint = paint2;
        Paint paint3 = new Paint();
        paint3.setAntiAlias(true);
        this.progressPaint = paint3;
        Paint paint4 = new Paint();
        paint4.setAntiAlias(true);
        paint4.setColor(this.thumbColor);
        this.thumbPaint = paint4;
    }

    private final float a(MotionEvent event) {
        int paddingRight;
        int thumbHalfWidth = getThumbHalfWidth();
        if (event.getX() < getPaddingLeft() + thumbHalfWidth) {
            paddingRight = getPaddingLeft() + thumbHalfWidth;
        } else {
            if (event.getX() <= (this.viewWidth - getPaddingRight()) - thumbHalfWidth) {
                return event.getX();
            }
            paddingRight = (this.viewWidth - getPaddingRight()) - thumbHalfWidth;
        }
        return paddingRight;
    }

    private final long b(float touchX) {
        int thumbHalfWidth = getThumbHalfWidth();
        this.lastProgress = this.currentProgress;
        long paddingLeft = (long) ((this.maxProgress * ((touchX - getPaddingLeft()) - thumbHalfWidth)) / this.barWidth);
        this.currentProgress = paddingLeft;
        return paddingLeft;
    }

    private final float c(float touchX) {
        return this.r2l ? ((getPaddingLeft() + (getThumbHalfWidth() * 2)) + this.barWidth) - touchX : touchX;
    }

    private final int d(Context context, float dpValue) {
        return (int) TypedValue.applyDimension(1, dpValue, context.getResources().getDisplayMetrics());
    }

    private final void e(Canvas canvas) {
        if (this.thumbShape == 1) {
            h(canvas);
        } else {
            g(canvas);
        }
    }

    private final void f(Canvas canvas) {
        Rect rect = this.bgRect;
        canvas.drawLine(rect.left, rect.top, rect.right, rect.bottom, this.bgPaint);
    }

    private final void g(Canvas canvas) {
        this.progressPaint.setStyle(Paint.Style.STROKE);
        this.progressPaint.setStrokeCap(Paint.Cap.ROUND);
        this.progressPaint.setStrokeWidth(this.progressSize);
        Paint paint = this.progressPaint;
        Rect rect = this.progressRect;
        paint.setShader(new LinearGradient(rect.left, rect.top, rect.right, rect.bottom, this.progressColors, (float[]) null, Shader.TileMode.CLAMP));
        Rect rect2 = this.progressRect;
        canvas.drawLine(rect2.left, rect2.top, rect2.right, rect2.bottom, this.progressPaint);
    }

    private final boolean getRightToLeft() {
        return TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
    }

    private final int getThumbHalfWidth() {
        return this.thumbShape == 1 ? this.thumbRectTouchWidth / 2 : this.thumbTouchRadius;
    }

    private final void h(Canvas canvas) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6 = this.progressSize / 2.0f;
        boolean z = this.r2l;
        float f7 = 0.0f;
        if (z) {
            f = 0.0f;
            f2 = r5.right + f6;
            f3 = this.progressRect.left;
            f4 = f6;
            f5 = f4;
        } else {
            f = f6;
            f2 = this.progressRect.right;
            f3 = r5.left - f6;
            f4 = 0.0f;
            f5 = 0.0f;
            f7 = f;
        }
        int i = this.progressRect.top;
        float f10 = i - f6;
        float f11 = i + f6;
        if (this.currentProgress <= 0) {
            return;
        }
        float f12 = 2 * f6;
        if (z) {
            if (f2 - f3 < f12) {
                f3 = f2 - f12;
            }
            int i2 = this.bgRect.left;
            if (f3 < i2 - f6) {
                f3 = i2 - f6;
            }
        } else {
            if (f2 - f3 < f12) {
                f2 = f3 + f12;
            }
            int i3 = this.bgRect.right;
            if (f2 > i3 + f6) {
                f2 = i3 + f6;
            }
        }
        float f13 = f3;
        float f14 = f2;
        this.progressPaint.setShader(new LinearGradient(f13, f10, f14, f11, this.progressColors, (float[]) null, Shader.TileMode.CLAMP));
        this.progressPath.reset();
        this.progressPath.addRoundRect(f13, f10, f14, f11, new float[]{f7, f7, f4, f4, f5, f5, f, f}, Path.Direction.CW);
        this.progressPaint.setStyle(Paint.Style.FILL);
        canvas.drawPath(this.progressPath, this.progressPaint);
    }

    private final void i(Canvas canvas) {
        int i;
        int i2;
        int i3 = -1;
        for (Map.Entry entry : this.secondariesProgressLocation.entrySet()) {
            int intValue = ((Number) entry.getKey()).intValue();
            int intValue2 = ((Number) entry.getValue()).intValue();
            i3++;
            if (i3 == 0 && intValue < (i2 = this.bgRect.left)) {
                intValue = i2;
            }
            if (i3 == this.secondariesProgressLocation.size() - 1 && intValue2 > (i = this.bgRect.right)) {
                intValue2 = i;
            }
            float f = intValue;
            Rect rect = this.progressRect;
            canvas.drawLine(f, rect.top, intValue2, rect.bottom, this.secondaryPaint);
        }
    }

    private final void j(Canvas canvas) {
        float f = this.r2l ? this.progressRect.left : this.progressRect.right;
        float f2 = this.progressRect.top;
        if (this.thumbShape != 1) {
            canvas.drawCircle(f, f2, this.isTouching ? this.thumbTouchRadius : this.thumbRadius, this.thumbPaint);
            return;
        }
        boolean z = this.isTouching;
        int i = z ? this.thumbRectTouchWidth : this.thumbRectWidth;
        int i2 = z ? this.thumbRectTouchHeight : this.thumbRectHeight;
        float f3 = z ? this.thumbRectTouchCornerRadius : this.thumbCornerRadius;
        float f4 = i / 2.0f;
        float f5 = i2 / 2.0f;
        this.thumbRectF.set(f - f4, f2 - f5, f + f4, f2 + f5);
        canvas.drawRoundRect(this.thumbRectF, f3, f3, this.thumbPaint);
    }

    private final void k() {
        int i = this.thumbShape == 1 ? this.thumbRectTouchWidth / 2 : this.thumbTouchRadius;
        int i2 = this.viewWidth;
        int i3 = this.viewPaddingRight;
        int i4 = this.viewPaddingLeft;
        this.barWidth = ((i2 - i3) - i4) - (i * 2);
        Rect rect = this.bgRect;
        int i5 = i4 + i;
        rect.left = i5;
        int i6 = (i2 - i3) - i;
        rect.right = i6;
        if (this.r2l) {
            this.progressRect.right = i6;
        } else {
            this.progressRect.right = i5;
        }
        int i7 = this.viewHeight / 2;
        rect.top = i7;
        Rect rect2 = this.progressRect;
        rect2.top = i7;
        rect.bottom = i7;
        rect2.bottom = i7;
        n();
        o();
    }

    private final void l(long progress) {
        long j = this.maxProgress;
        if (progress >= j) {
            progress = j;
        }
        this.currentProgress = progress;
        if (this.lastProgress == progress) {
            return;
        }
        this.lastProgress = progress;
        n();
    }

    private final void m(MotionEvent event) {
        long b = b(c(a(event)));
        l(b);
        s sVar = this.listener;
        if (sVar != null) {
            sVar.b(this, b, true);
        }
        invalidate();
    }

    private final void n() {
        int thumbHalfWidth = getThumbHalfWidth();
        int i = this.barWidth;
        int i2 = (int) (((this.currentProgress * 1.0f) / this.maxProgress) * i);
        if (this.r2l) {
            Rect rect = this.progressRect;
            int i3 = this.viewPaddingLeft;
            rect.left = ((i3 + thumbHalfWidth) + i) - i2;
            rect.right = i3 + thumbHalfWidth + i;
            return;
        }
        Rect rect2 = this.progressRect;
        int i4 = this.viewPaddingLeft;
        rect2.left = i4 + thumbHalfWidth;
        rect2.right = i4 + thumbHalfWidth + i2;
    }

    private final void o() {
        if (this.secondariesProgressLocation.isEmpty()) {
            return;
        }
        int intValue = ((Number) CollectionsKt.h0(this.secondariesProgressLocation.keySet())).intValue();
        Integer num = (Integer) this.secondariesProgressLocation.get(Integer.valueOf(intValue));
        int intValue2 = ((Number) CollectionsKt.t0(this.secondariesProgressLocation.keySet())).intValue();
        Integer num2 = (Integer) this.secondariesProgressLocation.get(Integer.valueOf(intValue));
        if ((num2 != null ? num2.intValue() : 0) > this.bgRect.right) {
            this.secondariesProgressLocation.put(Integer.valueOf(intValue2), Integer.valueOf(this.progressRect.right));
        }
        if (intValue < this.bgRect.left) {
            this.secondariesProgressLocation.remove(Integer.valueOf(intValue));
            this.secondariesProgressLocation.put(Integer.valueOf(this.bgRect.left), Integer.valueOf(num != null ? num.intValue() : this.bgRect.left));
        }
    }

    public final long getMaxProgress() {
        return this.maxProgress;
    }

    /* renamed from: getProgress, reason: from getter */
    public final long getCurrentProgress() {
        return this.currentProgress;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.h(canvas, "canvas");
        super.onDraw(canvas);
        f(canvas);
        i(canvas);
        e(canvas);
        if (this.seekEnable) {
            j(canvas);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i;
        int i2;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.viewPaddingLeft = getPaddingLeft();
        this.viewPaddingRight = getPaddingRight();
        this.viewPaddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        this.viewPaddingBottom = paddingBottom;
        if (this.thumbShape == 1) {
            i = this.thumbRectTouchHeight * 3;
            i2 = this.viewPaddingTop;
        } else {
            i = this.thumbTouchRadius * 6;
            i2 = this.viewPaddingTop;
        }
        this.viewHeight = i + i2 + paddingBottom;
        Context context = getContext();
        Intrinsics.g(context, "getContext(...)");
        int resolveSize = View.resolveSize(d(context, 170.0f), widthMeasureSpec);
        this.viewWidth = resolveSize;
        setMeasuredDimension(resolveSize, this.viewHeight);
        k();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001b, code lost:
    
        if (r0 != 3) goto L18;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.h(event, "event");
        if (!this.seekEnable) {
            return super.onTouchEvent(event);
        }
        int action = event.getAction();
        if (action == 0) {
            this.isTouching = true;
            s sVar = this.listener;
            if (sVar != null) {
                sVar.c(this);
            }
            m(event);
            return true;
        }
        if (action != 1) {
            if (action == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                this.isTouching = true;
                m(event);
            }
            return super.onTouchEvent(event);
        }
        this.isTouching = false;
        s sVar2 = this.listener;
        if (sVar2 != null) {
            sVar2.a(this);
        }
        return super.onTouchEvent(event);
    }

    public final void seekEnable(boolean enable) {
        this.seekEnable = enable;
    }

    public final void setMax(long max) {
        this.maxProgress = max;
    }

    public final void setOnSeekBarChangeListener(s listener) {
        Intrinsics.h(listener, "listener");
        this.listener = listener;
    }

    public final void setProgress(long progress) {
        l(progress);
        s sVar = this.listener;
        if (sVar != null) {
            sVar.b(this, progress, false);
        }
        invalidate();
    }

    public final void setSecondariesProgress(Map<Integer, Integer> progress) {
        Intrinsics.h(progress, "progress");
        int thumbHalfWidth = getThumbHalfWidth();
        this.secondariesProgressLocation.clear();
        for (Map.Entry<Integer, Integer> entry : progress.entrySet()) {
            if (entry.getValue().intValue() >= entry.getKey().intValue()) {
                int i = this.barWidth;
                int intValue = (int) ((((entry.getValue().intValue() - entry.getKey().intValue()) * 1.0f) / this.maxProgress) * i);
                int floatValue = this.r2l ? ((this.viewPaddingLeft + thumbHalfWidth) + i) - ((int) (((entry.getKey().floatValue() * 1.0f) / this.maxProgress) * this.barWidth)) : this.viewPaddingLeft + thumbHalfWidth + ((int) (((entry.getKey().floatValue() * 1.0f) / this.maxProgress) * this.barWidth));
                this.secondariesProgressLocation.put(Integer.valueOf(floatValue), Integer.valueOf(this.r2l ? floatValue - intValue : floatValue + intValue));
            }
        }
        invalidate();
    }
}
