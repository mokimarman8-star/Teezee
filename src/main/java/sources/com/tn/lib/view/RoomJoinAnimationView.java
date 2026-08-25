package com.tn.lib.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.blankj.utilcode.util.Utils;
import com.noober.background.drawable.DrawableCreator;
import com.noober.background.view.BLFrameLayout;
import com.tn.lib.widget.R;
import com.tn.lib.widget.R$layout;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u0015\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0014\u0010\u000eJ\u000f\u0010\u0015\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0015\u0010\u000eR\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u0019R\u0014\u0010 \u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u0019R\u0014\u0010\"\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\u0019R\u0014\u0010$\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010\u0019R\u0014\u0010&\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010\u0019R\u0014\u0010(\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010\u0019R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010.\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010\u0019R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00104\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00101R\u0016\u00107\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0011\u0010\u0011\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0011\u0010>\u001a\u00020)8F¢\u0006\u0006\u001a\u0004\b>\u0010?¨\u0006@"}, d2 = {"Lcom/tn/lib/view/RoomJoinAnimationView;", "Lcom/noober/background/view/BLFrameLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "res", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "a", "()V", "b", "Lcom/tn/lib/view/RoomJoinStatus;", "status", "setStatus", "(Lcom/tn/lib/view/RoomJoinStatus;)V", "onAttachedToWindow", "onDetachedFromWindow", "Leh/f;", "Leh/f;", "viewBinding", "I", "dp4", "c", "jvStyle", "d", "jvJoinBg", "e", "jvLoadingBg", "f", "jvViewBg", "g", "jvLoadingColor", "h", "jvJoinTextColor", "i", "jvJoinedTextColor", "", "j", "Z", "jvJoinedIconEnable", "k", "jvJoinedIconRes", "", "l", "Ljava/lang/String;", "textJoin", "m", "textLeave", "n", "Lcom/tn/lib/view/RoomJoinStatus;", "curStatus", "Landroid/animation/ObjectAnimator;", "o", "Landroid/animation/ObjectAnimator;", "rotationAnimator", "getStatus", "()Lcom/tn/lib/view/RoomJoinStatus;", "isLoading", "()Z", "UI_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class RoomJoinAnimationView extends BLFrameLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private final eh.f viewBinding;

    /* renamed from: b, reason: from kotlin metadata */
    private final int dp4;

    /* renamed from: c, reason: from kotlin metadata */
    private final int jvStyle;

    /* renamed from: d, reason: from kotlin metadata */
    private final int jvJoinBg;

    /* renamed from: e, reason: from kotlin metadata */
    private final int jvLoadingBg;

    /* renamed from: f, reason: from kotlin metadata */
    private final int jvViewBg;

    /* renamed from: g, reason: from kotlin metadata */
    private final int jvLoadingColor;

    /* renamed from: h, reason: from kotlin metadata */
    private final int jvJoinTextColor;

    /* renamed from: i, reason: from kotlin metadata */
    private final int jvJoinedTextColor;

    /* renamed from: j, reason: from kotlin metadata */
    private final boolean jvJoinedIconEnable;

    /* renamed from: k, reason: from kotlin metadata */
    private final int jvJoinedIconRes;

    /* renamed from: l, reason: from kotlin metadata */
    private String textJoin;

    /* renamed from: m, reason: from kotlin metadata */
    private String textLeave;

    /* renamed from: n, reason: from kotlin metadata */
    private RoomJoinStatus curStatus;

    /* renamed from: o, reason: from kotlin metadata */
    private ObjectAnimator rotationAnimator;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[RoomJoinStatus.values().length];
            try {
                iArr[RoomJoinStatus.JOIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RoomJoinStatus.LOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RoomJoinStatus.JOINED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoomJoinAnimationView(Context context) {
        this(context, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoomJoinAnimationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RoomJoinAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        this.dp4 = com.blankj.utilcode.util.a0.a(4.0f);
        RoomJoinStatus roomJoinStatus = RoomJoinStatus.JOIN;
        this.curStatus = roomJoinStatus;
        View.inflate(context, R$layout.view_room_join, this);
        eh.f a2 = eh.f.a(this);
        Intrinsics.g(a2, "bind(...)");
        this.viewBinding = a2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoomJoinAnimationView, 0, 0);
        Intrinsics.g(obtainStyledAttributes, "obtainStyledAttributes(...)");
        int i2 = obtainStyledAttributes.getInt(R.styleable.RoomJoinAnimationView_jv_style, 0);
        this.jvStyle = i2;
        this.jvJoinBg = obtainStyledAttributes.getColor(R.styleable.RoomJoinAnimationView_jv_text_join_bg, -1);
        this.jvLoadingBg = obtainStyledAttributes.getColor(R.styleable.RoomJoinAnimationView_jv_text_loading_bg, Utils.a().getResources().getColor(R.color.white_20));
        this.jvViewBg = obtainStyledAttributes.getColor(R.styleable.RoomJoinAnimationView_jv_text_joined_bg, Utils.a().getResources().getColor(R.color.white_20));
        int color = obtainStyledAttributes.getColor(R.styleable.RoomJoinAnimationView_jv_text_loading_color, Utils.a().getResources().getColor(R.color.white_80));
        this.jvLoadingColor = color;
        this.jvJoinTextColor = obtainStyledAttributes.getColor(R.styleable.RoomJoinAnimationView_jv_text_join_text_color, -16777216);
        this.jvJoinedTextColor = obtainStyledAttributes.getColor(R.styleable.RoomJoinAnimationView_jv_text_joined_text_color, -16777216);
        float dimension = obtainStyledAttributes.getDimension(R.styleable.RoomJoinAnimationView_jv_text_text_size, 14.0f);
        float dimension2 = obtainStyledAttributes.getDimension(R.styleable.RoomJoinAnimationView_jv_text_loading_size, 16.0f);
        this.textJoin = obtainStyledAttributes.getString(R.styleable.RoomJoinAnimationView_jv_text_join_text);
        this.textLeave = obtainStyledAttributes.getString(R.styleable.RoomJoinAnimationView_jv_text_joined_text);
        this.jvJoinedIconEnable = obtainStyledAttributes.getBoolean(R.styleable.RoomJoinAnimationView_jv_text_joined_icon_enable, false);
        this.jvJoinedIconRes = obtainStyledAttributes.getResourceId(R.styleable.RoomJoinAnimationView_jv_text_joined_icon, 0);
        String str = this.textJoin;
        if (str == null || str.length() == 0) {
            this.textJoin = Utils.a().getString(R.string.Join);
        }
        String str2 = this.textLeave;
        if (str2 == null || str2.length() == 0) {
            this.textLeave = Utils.a().getString(R.string.Leave);
        }
        obtainStyledAttributes.recycle();
        if (i2 == 0) {
            AppCompatTextView appCompatTextView = a2.d;
            Intrinsics.g(appCompatTextView, "tvJoin");
            uf.c.g(appCompatTextView);
            ProgressBar progressBar = a2.c;
            Intrinsics.g(progressBar, "pbLoading");
            uf.c.g(progressBar);
            AppCompatImageView appCompatImageView = a2.b;
            Intrinsics.g(appCompatImageView, "ivJoin");
            uf.c.k(appCompatImageView);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(a2.b, "rotation", 0.0f, 360.0f);
            ofFloat.setDuration(1000L);
            ofFloat.setRepeatCount(-1);
            ofFloat.setInterpolator(new LinearInterpolator());
            this.rotationAnimator = ofFloat;
        } else {
            AppCompatTextView appCompatTextView2 = a2.d;
            Intrinsics.g(appCompatTextView2, "tvJoin");
            uf.c.k(appCompatTextView2);
            ProgressBar progressBar2 = a2.c;
            Intrinsics.g(progressBar2, "pbLoading");
            uf.c.k(progressBar2);
            AppCompatImageView appCompatImageView2 = a2.b;
            Intrinsics.g(appCompatImageView2, "ivJoin");
            uf.c.g(appCompatImageView2);
            a2.d.setTextSize(dimension);
            a2.d.setTextSize(0, dimension);
            ViewGroup.LayoutParams layoutParams = a2.c.getLayoutParams();
            if (layoutParams == null) {
                int i3 = (int) dimension2;
                layoutParams = new FrameLayout.LayoutParams(i3, i3);
            }
            int i4 = (int) dimension2;
            layoutParams.width = i4;
            layoutParams.height = i4;
            a2.c.setLayoutParams(layoutParams);
            a2.c.setIndeterminateTintList(ColorStateList.valueOf(color));
        }
        setStatus(roomJoinStatus);
    }

    private final void a() {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2 = this.rotationAnimator;
        if ((objectAnimator2 == null || !objectAnimator2.isRunning()) && (objectAnimator = this.rotationAnimator) != null) {
            objectAnimator.start();
        }
    }

    private final void b() {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2 = this.rotationAnimator;
        if (objectAnimator2 == null || !objectAnimator2.isRunning() || (objectAnimator = this.rotationAnimator) == null) {
            return;
        }
        objectAnimator.cancel();
    }

    /* renamed from: getStatus, reason: from getter */
    public final RoomJoinStatus getCurStatus() {
        return this.curStatus;
    }

    public final boolean isLoading() {
        return this.curStatus == RoomJoinStatus.LOADING;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onAttachedToWindow() {
        super/*android.widget.FrameLayout*/.onAttachedToWindow();
        if (this.curStatus == RoomJoinStatus.LOADING) {
            a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onDetachedFromWindow() {
        super/*android.widget.FrameLayout*/.onDetachedFromWindow();
        b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setStatus(RoomJoinStatus status) {
        String str;
        int i;
        int i2;
        int i3;
        Intrinsics.h(status, "status");
        this.curStatus = status;
        if (this.jvStyle == 0) {
            AppCompatImageView appCompatImageView = this.viewBinding.b;
            int i4 = a.a[status.ordinal()];
            if (i4 == 1) {
                i3 = R.mipmap.ic_room_join_def_new;
            } else if (i4 == 2) {
                i3 = R.mipmap.ic_room_join_loading_new;
            } else {
                if (i4 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                i3 = R.mipmap.ic_room_join_view_new;
            }
            appCompatImageView.setImageResource(i3);
            if (status == RoomJoinStatus.LOADING) {
                a();
                return;
            } else {
                this.viewBinding.b.setRotation(0.0f);
                b();
                return;
            }
        }
        ProgressBar progressBar = this.viewBinding.c;
        Intrinsics.g(progressBar, "pbLoading");
        uf.c.g(progressBar);
        AppCompatTextView appCompatTextView = this.viewBinding.d;
        int[] iArr = a.a;
        int i5 = iArr[status.ordinal()];
        if (i5 == 1) {
            str = this.textJoin;
        } else if (i5 == 2) {
            ProgressBar progressBar2 = this.viewBinding.c;
            Intrinsics.g(progressBar2, "pbLoading");
            uf.c.k(progressBar2);
            str = "";
        } else {
            if (i5 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            str = this.textLeave;
        }
        appCompatTextView.setText(str);
        int i6 = iArr[status.ordinal()];
        if (i6 == 1) {
            i = this.jvJoinBg;
        } else if (i6 == 2) {
            i = this.jvLoadingBg;
        } else {
            if (i6 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            i = this.jvViewBg;
        }
        setBackground(new DrawableCreator.Builder().setCornersRadius(this.dp4).setSolidColor(i).build());
        int i7 = iArr[status.ordinal()];
        if (i7 == 1) {
            i2 = this.jvJoinTextColor;
        } else if (i7 == 2) {
            i2 = this.jvJoinTextColor;
        } else {
            if (i7 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            i2 = this.jvJoinedTextColor;
        }
        this.viewBinding.d.setTextColor(i2);
        int i10 = iArr[status.ordinal()];
        if (i10 == 1) {
            this.viewBinding.d.setCompoundDrawablesWithIntrinsicBounds(R.drawable.room_ic_add, 0, 0, 0);
            return;
        }
        if (i10 != 3) {
            this.viewBinding.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            return;
        }
        if (!this.jvJoinedIconEnable) {
            this.viewBinding.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            return;
        }
        int i11 = this.jvJoinedIconRes;
        if (i11 == 0) {
            i11 = 0;
        }
        this.viewBinding.d.setCompoundDrawablesWithIntrinsicBounds(i11, 0, 0, 0);
    }
}
