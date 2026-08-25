package com.tn.lib.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.widget.AppCompatImageView;
import com.noober.background.view.BLFrameLayout;
import com.tn.lib.widget.R;
import com.tn.lib.widget.R$layout;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u0015\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0014\u0010\u000eJ\u000f\u0010\u0015\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0015\u0010\u000eR\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0011\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0011\u0010\"\u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/tn/lib/view/RoomCacheAnimationView;", "Lcom/noober/background/view/BLFrameLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "res", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "a", "()V", "b", "Lcom/tn/lib/view/RoomCacheStatus;", "status", "setStatus", "(Lcom/tn/lib/view/RoomCacheStatus;)V", "onAttachedToWindow", "onDetachedFromWindow", "Leh/e;", "Leh/e;", "viewBinding", "Lcom/tn/lib/view/RoomCacheStatus;", "curStatus", "Landroid/animation/ObjectAnimator;", "c", "Landroid/animation/ObjectAnimator;", "rotationAnimator", "getStatus", "()Lcom/tn/lib/view/RoomCacheStatus;", "", "isLoading", "()Z", "UI_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class RoomCacheAnimationView extends BLFrameLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private final eh.e viewBinding;

    /* renamed from: b, reason: from kotlin metadata */
    private RoomCacheStatus curStatus;

    /* renamed from: c, reason: from kotlin metadata */
    private ObjectAnimator rotationAnimator;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[RoomCacheStatus.values().length];
            try {
                iArr[RoomCacheStatus.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RoomCacheStatus.LOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RoomCacheStatus.END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoomCacheAnimationView(Context context) {
        this(context, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoomCacheAnimationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RoomCacheAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        RoomCacheStatus roomCacheStatus = RoomCacheStatus.START;
        this.curStatus = roomCacheStatus;
        View.inflate(context, R$layout.view_room_cache, this);
        eh.e a2 = eh.e.a(this);
        Intrinsics.g(a2, "bind(...)");
        this.viewBinding = a2;
        AppCompatImageView appCompatImageView = a2.b;
        Intrinsics.g(appCompatImageView, "ivJoin");
        uf.c.k(appCompatImageView);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(a2.b, "rotation", 0.0f, 360.0f);
        ofFloat.setDuration(1000L);
        ofFloat.setRepeatCount(-1);
        ofFloat.setInterpolator(new LinearInterpolator());
        this.rotationAnimator = ofFloat;
        setStatus(roomCacheStatus);
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
    public final RoomCacheStatus getCurStatus() {
        return this.curStatus;
    }

    public final boolean isLoading() {
        return this.curStatus == RoomCacheStatus.LOADING;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onAttachedToWindow() {
        super/*android.widget.FrameLayout*/.onAttachedToWindow();
        if (this.curStatus == RoomCacheStatus.LOADING) {
            a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onDetachedFromWindow() {
        super/*android.widget.FrameLayout*/.onDetachedFromWindow();
        b();
    }

    public final void setStatus(RoomCacheStatus status) {
        int i;
        Intrinsics.h(status, "status");
        this.curStatus = status;
        AppCompatImageView appCompatImageView = this.viewBinding.b;
        int i2 = a.a[status.ordinal()];
        if (i2 == 1) {
            i = R.mipmap.icon_room_cache_start;
        } else if (i2 == 2) {
            i = R.mipmap.icon_room_cache_loading;
        } else {
            if (i2 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            i = R.mipmap.icon_room_cache_end;
        }
        appCompatImageView.setImageResource(i);
        if (status == RoomCacheStatus.LOADING) {
            a();
        } else {
            this.viewBinding.b.setRotation(0.0f);
            b();
        }
    }
}
