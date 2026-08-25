package com.vungle.ads.internal.util;

import android.os.CountDownTimer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class SuspendableTimer {
    private final double durationSecs;
    private boolean isCanceled;
    private boolean isPaused;
    private double nextDurationSecs;
    private final Function0<Unit> onFinish;
    private final Function0<Unit> onTick;
    private final boolean repeats;
    private long startTimeMillis;
    private CountDownTimer timer;

    public static final class a extends CountDownTimer {
        final /* synthetic */ SuspendableTimer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(long j, SuspendableTimer suspendableTimer) {
            super(j, j);
            this.this$0 = suspendableTimer;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            SuspendableTimer suspendableTimer = this.this$0;
            suspendableTimer.onFinish.invoke();
            if (!suspendableTimer.repeats || suspendableTimer.isCanceled) {
                suspendableTimer.cancel();
            } else {
                suspendableTimer.setNextDurationSecs$vungle_ads_release(suspendableTimer.durationSecs);
                suspendableTimer.start();
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            this.this$0.onTick.invoke();
        }
    }

    public SuspendableTimer(double d, boolean z, Function0<Unit> onTick, Function0<Unit> onFinish) {
        Intrinsics.h(onTick, "onTick");
        Intrinsics.h(onFinish, "onFinish");
        this.durationSecs = d;
        this.repeats = z;
        this.onTick = onTick;
        this.onFinish = onFinish;
        this.nextDurationSecs = d;
    }

    public /* synthetic */ SuspendableTimer(double d, boolean z, Function0 function0, Function0 function02, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(d, z, (i & 4) != 0 ? new Function0<Unit>() { // from class: com.vungle.ads.internal.util.SuspendableTimer.1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m129invoke();
                return Unit.a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m129invoke() {
            }
        } : function0, function02);
    }

    private final CountDownTimer createCountdown(long j) {
        return new a(j, this);
    }

    private final long getDurationMillis() {
        return (long) (this.durationSecs * 1000);
    }

    public static /* synthetic */ void getElapsedMillis$vungle_ads_release$annotations() {
    }

    private final double getElapsedSecs() {
        return getElapsedMillis$vungle_ads_release() / 1000;
    }

    private final long getNextDurationMillis() {
        return (long) (this.nextDurationSecs * 1000);
    }

    public static /* synthetic */ void getNextDurationSecs$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getStartTimeMillis$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getTimer$vungle_ads_release$annotations() {
    }

    public final void cancel() {
        this.isPaused = false;
        this.isCanceled = true;
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.timer = null;
    }

    public final long getElapsedMillis$vungle_ads_release() {
        long currentTimeMillis;
        long j;
        if (this.isPaused) {
            currentTimeMillis = getDurationMillis();
            j = getNextDurationMillis();
        } else {
            currentTimeMillis = System.currentTimeMillis();
            j = this.startTimeMillis;
        }
        return currentTimeMillis - j;
    }

    public final double getNextDurationSecs$vungle_ads_release() {
        return this.nextDurationSecs;
    }

    public final long getStartTimeMillis$vungle_ads_release() {
        return this.startTimeMillis;
    }

    public final CountDownTimer getTimer$vungle_ads_release() {
        return this.timer;
    }

    public final void pause() {
        if (this.timer == null) {
            return;
        }
        this.nextDurationSecs -= getElapsedSecs();
        this.isPaused = true;
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.timer = null;
    }

    public final void reset() {
        cancel();
        start();
    }

    public final void resume() {
        if (this.isPaused) {
            this.isPaused = false;
            start();
        }
    }

    public final void setNextDurationSecs$vungle_ads_release(double d) {
        this.nextDurationSecs = d;
    }

    public final void setStartTimeMillis$vungle_ads_release(long j) {
        this.startTimeMillis = j;
    }

    public final void setTimer$vungle_ads_release(CountDownTimer countDownTimer) {
        this.timer = countDownTimer;
    }

    public final void start() {
        this.startTimeMillis = System.currentTimeMillis();
        CountDownTimer createCountdown = createCountdown(getNextDurationMillis());
        this.timer = createCountdown;
        if (createCountdown != null) {
            createCountdown.start();
        }
    }
}
