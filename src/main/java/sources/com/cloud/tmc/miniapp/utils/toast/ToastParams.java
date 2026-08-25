package com.cloud.tmc.miniapp.utils.toast;

import androidx.collection.s;
import com.cloud.tmc.miniapp.utils.toast.config.IToastInterceptor;
import com.cloud.tmc.miniapp.utils.toast.config.IToastStrategy;
import com.cloud.tmc.miniapp.utils.toast.config.IToastStyle;
import java.io.File;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class ToastParams {
    private final long delayMillis;
    private int drawableResId;
    private int duration;
    private File icon;
    private IToastInterceptor interceptor;
    private final boolean mask;
    private Function0<Unit> showCallBack;
    private IToastStrategy strategy;
    private IToastStyle<?> style;
    private final CharSequence text;

    public ToastParams(CharSequence charSequence, int i, long j, boolean z, File file, int i2, IToastStyle<?> iToastStyle, IToastStrategy iToastStrategy, IToastInterceptor iToastInterceptor, Function0<Unit> function0) {
        Intrinsics.h(charSequence, "text");
        this.text = charSequence;
        this.duration = i;
        this.delayMillis = j;
        this.mask = z;
        this.icon = file;
        this.drawableResId = i2;
        this.style = iToastStyle;
        this.strategy = iToastStrategy;
        this.interceptor = iToastInterceptor;
        this.showCallBack = function0;
    }

    public /* synthetic */ ToastParams(CharSequence charSequence, int i, long j, boolean z, File file, int i2, IToastStyle iToastStyle, IToastStrategy iToastStrategy, IToastInterceptor iToastInterceptor, Function0 function0, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(charSequence, (i3 & 2) != 0 ? -1 : i, (i3 & 4) != 0 ? 0L : j, (i3 & 8) != 0 ? false : z, (i3 & 16) != 0 ? null : file, (i3 & 32) == 0 ? i2 : 0, (i3 & 64) != 0 ? null : iToastStyle, (i3 & 128) != 0 ? null : iToastStrategy, (i3 & 256) != 0 ? null : iToastInterceptor, (i3 & 512) == 0 ? function0 : null);
    }

    public final CharSequence component1() {
        return this.text;
    }

    public final Function0<Unit> component10() {
        return this.showCallBack;
    }

    public final int component2() {
        return this.duration;
    }

    public final long component3() {
        return this.delayMillis;
    }

    public final boolean component4() {
        return this.mask;
    }

    public final File component5() {
        return this.icon;
    }

    public final int component6() {
        return this.drawableResId;
    }

    public final IToastStyle<?> component7() {
        return this.style;
    }

    public final IToastStrategy component8() {
        return this.strategy;
    }

    public final IToastInterceptor component9() {
        return this.interceptor;
    }

    public final ToastParams copy(CharSequence charSequence, int i, long j, boolean z, File file, int i2, IToastStyle<?> iToastStyle, IToastStrategy iToastStrategy, IToastInterceptor iToastInterceptor, Function0<Unit> function0) {
        Intrinsics.h(charSequence, "text");
        return new ToastParams(charSequence, i, j, z, file, i2, iToastStyle, iToastStrategy, iToastInterceptor, function0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ToastParams)) {
            return false;
        }
        ToastParams toastParams = (ToastParams) obj;
        return Intrinsics.c(this.text, toastParams.text) && this.duration == toastParams.duration && this.delayMillis == toastParams.delayMillis && this.mask == toastParams.mask && Intrinsics.c(this.icon, toastParams.icon) && this.drawableResId == toastParams.drawableResId && Intrinsics.c(this.style, toastParams.style) && Intrinsics.c(this.strategy, toastParams.strategy) && Intrinsics.c(this.interceptor, toastParams.interceptor) && Intrinsics.c(this.showCallBack, toastParams.showCallBack);
    }

    public final long getDelayMillis() {
        return this.delayMillis;
    }

    public final int getDrawableResId() {
        return this.drawableResId;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final File getIcon() {
        return this.icon;
    }

    public final IToastInterceptor getInterceptor() {
        return this.interceptor;
    }

    public final boolean getMask() {
        return this.mask;
    }

    public final Function0<Unit> getShowCallBack() {
        return this.showCallBack;
    }

    public final IToastStrategy getStrategy() {
        return this.strategy;
    }

    public final IToastStyle<?> getStyle() {
        return this.style;
    }

    public final CharSequence getText() {
        return this.text;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int a = (s.a(this.delayMillis) + ((this.duration + (this.text.hashCode() * 31)) * 31)) * 31;
        boolean z = this.mask;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (a + i) * 31;
        File file = this.icon;
        int hashCode = (this.drawableResId + ((i2 + (file == null ? 0 : file.hashCode())) * 31)) * 31;
        IToastStyle<?> iToastStyle = this.style;
        int hashCode2 = (hashCode + (iToastStyle == null ? 0 : iToastStyle.hashCode())) * 31;
        IToastStrategy iToastStrategy = this.strategy;
        int hashCode3 = (hashCode2 + (iToastStrategy == null ? 0 : iToastStrategy.hashCode())) * 31;
        IToastInterceptor iToastInterceptor = this.interceptor;
        int hashCode4 = (hashCode3 + (iToastInterceptor == null ? 0 : iToastInterceptor.hashCode())) * 31;
        Function0<Unit> function0 = this.showCallBack;
        return hashCode4 + (function0 != null ? function0.hashCode() : 0);
    }

    public final void setDrawableResId(int i) {
        this.drawableResId = i;
    }

    public final void setDuration(int i) {
        this.duration = i;
    }

    public final void setIcon(File file) {
        this.icon = file;
    }

    public final void setInterceptor(IToastInterceptor iToastInterceptor) {
        this.interceptor = iToastInterceptor;
    }

    public final void setShowCallBack(Function0<Unit> function0) {
        this.showCallBack = function0;
    }

    public final void setStrategy(IToastStrategy iToastStrategy) {
        this.strategy = iToastStrategy;
    }

    public final void setStyle(IToastStyle<?> iToastStyle) {
        this.style = iToastStyle;
    }

    public String toString() {
        CharSequence charSequence = this.text;
        return "ToastParams(text=" + ((Object) charSequence) + ", duration=" + this.duration + ", delayMillis=" + this.delayMillis + ", mask=" + this.mask + ", icon=" + this.icon + ", drawableResId=" + this.drawableResId + ", style=" + this.style + ", strategy=" + this.strategy + ", interceptor=" + this.interceptor + ", showCallBack=" + this.showCallBack + ")";
    }
}
