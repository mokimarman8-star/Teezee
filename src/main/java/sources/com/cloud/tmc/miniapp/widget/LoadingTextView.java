package com.cloud.tmc.miniapp.widget;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.collection.s;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.activity.LoadStepAction;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.model.BaseBean;
import com.cloud.tmc.launcherlib.LauncherMiniAppConfigHelper;
import com.cloud.tmc.miniapp.ui.MiniAppActivity;
import com.cloud.tmc.miniutils.util.GsonUtils;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class LoadingTextView extends AppCompatTextView {
    public final String OooO00o;
    public LoadingAnimationModel OooO0O0;
    public int OooO0OO;
    public int OooO0Oo;
    public ObjectAnimator OooO0o;
    public ObjectAnimator OooO0o0;

    public static final class LoadingAnimationModel extends BaseBean {
        private int creatRender;
        private int decompress;
        private int download;
        private long finishAnimationDuration;
        private long firstDuration;
        private int firstProgress;
        private int loadRender;
        private long secondDuration;

        public LoadingAnimationModel() {
            this(0, 0L, 0, 0, 0, 0, 0L, 0L, 255, null);
        }

        public LoadingAnimationModel(int i, long j, int i2, int i3, int i4, int i5, long j2, long j3) {
            this.firstProgress = i;
            this.firstDuration = j;
            this.download = i2;
            this.decompress = i3;
            this.creatRender = i4;
            this.loadRender = i5;
            this.secondDuration = j2;
            this.finishAnimationDuration = j3;
        }

        public /* synthetic */ LoadingAnimationModel(int i, long j, int i2, int i3, int i4, int i5, long j2, long j3, int i6, DefaultConstructorMarker defaultConstructorMarker) {
            this((i6 & 1) != 0 ? 90 : i, (i6 & 2) != 0 ? 3000L : j, (i6 & 4) != 0 ? 93 : i2, (i6 & 8) != 0 ? 95 : i3, (i6 & 16) != 0 ? 97 : i4, (i6 & 32) != 0 ? 99 : i5, (i6 & 64) != 0 ? 1000L : j2, (i6 & 128) != 0 ? 100L : j3);
        }

        public final int component1() {
            return this.firstProgress;
        }

        public final long component2() {
            return this.firstDuration;
        }

        public final int component3() {
            return this.download;
        }

        public final int component4() {
            return this.decompress;
        }

        public final int component5() {
            return this.creatRender;
        }

        public final int component6() {
            return this.loadRender;
        }

        public final long component7() {
            return this.secondDuration;
        }

        public final long component8() {
            return this.finishAnimationDuration;
        }

        public final LoadingAnimationModel copy(int i, long j, int i2, int i3, int i4, int i5, long j2, long j3) {
            return new LoadingAnimationModel(i, j, i2, i3, i4, i5, j2, j3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LoadingAnimationModel)) {
                return false;
            }
            LoadingAnimationModel loadingAnimationModel = (LoadingAnimationModel) obj;
            return this.firstProgress == loadingAnimationModel.firstProgress && this.firstDuration == loadingAnimationModel.firstDuration && this.download == loadingAnimationModel.download && this.decompress == loadingAnimationModel.decompress && this.creatRender == loadingAnimationModel.creatRender && this.loadRender == loadingAnimationModel.loadRender && this.secondDuration == loadingAnimationModel.secondDuration && this.finishAnimationDuration == loadingAnimationModel.finishAnimationDuration;
        }

        public final int getCreatRender() {
            return this.creatRender;
        }

        public final int getDecompress() {
            return this.decompress;
        }

        public final int getDownload() {
            return this.download;
        }

        public final long getFinishAnimationDuration() {
            return this.finishAnimationDuration;
        }

        public final long getFirstDuration() {
            return this.firstDuration;
        }

        public final int getFirstProgress() {
            return this.firstProgress;
        }

        public final int getLoadRender() {
            return this.loadRender;
        }

        public final long getSecondDuration() {
            return this.secondDuration;
        }

        public int hashCode() {
            return s.a(this.finishAnimationDuration) + ((s.a(this.secondDuration) + ((this.loadRender + ((this.creatRender + ((this.decompress + ((this.download + ((s.a(this.firstDuration) + (this.firstProgress * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
        }

        public final void setCreatRender(int i) {
            this.creatRender = i;
        }

        public final void setDecompress(int i) {
            this.decompress = i;
        }

        public final void setDownload(int i) {
            this.download = i;
        }

        public final void setFinishAnimationDuration(long j) {
            this.finishAnimationDuration = j;
        }

        public final void setFirstDuration(long j) {
            this.firstDuration = j;
        }

        public final void setFirstProgress(int i) {
            this.firstProgress = i;
        }

        public final void setLoadRender(int i) {
            this.loadRender = i;
        }

        public final void setSecondDuration(long j) {
            this.secondDuration = j;
        }

        public String toString() {
            return "LoadingAnimationModel(firstProgress=" + this.firstProgress + ", firstDuration=" + this.firstDuration + ", download=" + this.download + ", decompress=" + this.decompress + ", creatRender=" + this.creatRender + ", loadRender=" + this.loadRender + ", secondDuration=" + this.secondDuration + ", finishAnimationDuration=" + this.finishAnimationDuration + ")";
        }
    }

    public final class OooO00o implements TypeEvaluator<Integer> {
        public OooO00o(LoadingTextView loadingTextView) {
        }

        @Override // android.animation.TypeEvaluator
        public Integer evaluate(float f, Integer num, Integer num2) {
            Integer num3 = num;
            Integer num4 = num2;
            return Integer.valueOf((int) ((((num4 != null ? num4.intValue() : 0) - r3) * f) + (num3 != null ? num3.intValue() : 0)));
        }
    }

    public /* synthetic */ class OooO0O0 {
        public static final /* synthetic */ int[] OooO00o;

        static {
            int[] iArr = new int[LoadStepAction.values().length];
            try {
                iArr[LoadStepAction.STEP_START_LOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LoadStepAction.STEP_UPDATE_APP_INFO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LoadStepAction.STEP_FINISH_DOWNLOAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LoadStepAction.STEP_FINISH_DECOMPRESS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[LoadStepAction.STEP_FINISH_CREAT_RENDER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[LoadStepAction.STEP_FINISH_LOAD_RENDER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[LoadStepAction.STEP_FINISH_MINIAPP_LOAD.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            OooO00o = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LoadingAnimationModel loadingAnimationModel;
        Intrinsics.h(context, "context");
        this.OooO00o = "LoadingTextView";
        try {
            Object fromJson = GsonUtils.getGson().fromJson(MiniAppConfigHelper.INSTANCE.getConfigTargetStr(LauncherMiniAppConfigHelper.KEY_LOADING_PROGRESS, "{\"creatRender\":97,\"decompress\":95,\"download\":93,\"finishAnimationDuration\":100,\"firstDuration\":3000,\"firstProgress\":90,\"loadRender\":99,\"secondDuration\":1000}"), LoadingAnimationModel.class);
            Intrinsics.g(fromJson, "{\n            val loadPr…el::class.java)\n        }");
            loadingAnimationModel = (LoadingAnimationModel) fromJson;
        } catch (Throwable unused) {
            loadingAnimationModel = new LoadingAnimationModel(0, 0L, 0, 0, 0, 0, 0L, 0L, 255, null);
        }
        this.OooO0O0 = loadingAnimationModel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void OooO00o(LoadingTextView loadingTextView) {
        Intrinsics.h(loadingTextView, "this$0");
        loadingTextView.OooO0Oo = 0;
        loadingTextView.setLoadingProgress(0);
        loadingTextView.setText("0%");
    }

    public static final void OooO00o(LoadingTextView loadingTextView, ValueAnimator valueAnimator) {
        Intrinsics.h(loadingTextView, "this$0");
        Intrinsics.h(valueAnimator, "it");
        loadingTextView.OooO0Oo = Integer.parseInt(valueAnimator.getAnimatedValue().toString());
    }

    public static final void OooO0O0(LoadingTextView loadingTextView, ValueAnimator valueAnimator) {
        Intrinsics.h(loadingTextView, "this$0");
        Intrinsics.h(valueAnimator, "it");
        loadingTextView.OooO0Oo = Integer.parseInt(valueAnimator.getAnimatedValue().toString());
    }

    public final void OooO00o() {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        try {
            ObjectAnimator objectAnimator3 = this.OooO0o0;
            if (objectAnimator3 != null && objectAnimator3.isRunning() && (objectAnimator2 = this.OooO0o0) != null) {
                objectAnimator2.cancel();
            }
            ObjectAnimator objectAnimator4 = this.OooO0o;
            if (objectAnimator4 != null && objectAnimator4.isRunning() && (objectAnimator = this.OooO0o) != null) {
                objectAnimator.cancel();
            }
            OooO0O0();
        } catch (Throwable th) {
            TmcLogger.e(this.OooO00o, th);
        }
    }

    public final void OooO00o(int i) {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2 = this.OooO0o0;
        if (objectAnimator2 != null && objectAnimator2.isRunning() && (objectAnimator = this.OooO0o0) != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this, "loadingProgress", new OooO00o(this), Integer.valueOf(i), Integer.valueOf(this.OooO0O0.getFirstProgress()));
        this.OooO0o0 = ofObject;
        if (ofObject != null) {
            ofObject.setDuration(this.OooO0O0.getFirstDuration());
        }
        ObjectAnimator objectAnimator3 = this.OooO0o0;
        if (objectAnimator3 != null) {
            objectAnimator3.setInterpolator(new AccelerateDecelerateInterpolator());
        }
        ObjectAnimator objectAnimator4 = this.OooO0o0;
        if (objectAnimator4 != null) {
            objectAnimator4.start();
        }
        ObjectAnimator objectAnimator5 = this.OooO0o0;
        if (objectAnimator5 != null) {
            objectAnimator5.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.cloud.tmc.miniapp.widget.g
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    LoadingTextView.OooO00o(LoadingTextView.this, valueAnimator);
                }
            });
        }
    }

    public final void OooO00o(int i, int i2, long j) {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        ObjectAnimator objectAnimator3 = this.OooO0o0;
        if (objectAnimator3 == null || !objectAnimator3.isRunning() || i2 == 100) {
            ObjectAnimator objectAnimator4 = this.OooO0o0;
            if (objectAnimator4 != null && objectAnimator4.isRunning() && (objectAnimator2 = this.OooO0o0) != null) {
                objectAnimator2.cancel();
            }
            ObjectAnimator objectAnimator5 = this.OooO0o;
            if (objectAnimator5 != null && objectAnimator5.isRunning() && (objectAnimator = this.OooO0o) != null) {
                objectAnimator.cancel();
            }
            ObjectAnimator ofObject = ObjectAnimator.ofObject(this, "loadingProgress", new OooO00o(this), Integer.valueOf(i), Integer.valueOf(i2));
            this.OooO0o = ofObject;
            if (ofObject != null) {
                ofObject.setDuration(j);
            }
            ObjectAnimator objectAnimator6 = this.OooO0o;
            if (objectAnimator6 != null) {
                objectAnimator6.start();
            }
            ObjectAnimator objectAnimator7 = this.OooO0o;
            if (objectAnimator7 != null) {
                objectAnimator7.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.cloud.tmc.miniapp.widget.e
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        LoadingTextView.OooO0O0(LoadingTextView.this, valueAnimator);
                    }
                });
            }
        }
    }

    public final void OooO00o(LoadStepAction loadStepAction) {
        Intrinsics.h(loadStepAction, "loadStep");
        TmcLogger.d(this.OooO00o, loadStepAction.name() + " startTime: " + System.currentTimeMillis() + ",currentProgress:" + this.OooO0Oo);
        switch (OooO0O0.OooO00o[loadStepAction.ordinal()]) {
            case 1:
                OooO00o(0);
                break;
            case 2:
                break;
            case 3:
                OooO00o(this.OooO0Oo, this.OooO0O0.getDownload(), this.OooO0O0.getFirstDuration());
                break;
            case 4:
                OooO00o(this.OooO0Oo, this.OooO0O0.getDecompress(), this.OooO0O0.getSecondDuration());
                break;
            case 5:
                OooO00o(this.OooO0Oo, this.OooO0O0.getCreatRender(), this.OooO0O0.getSecondDuration());
                break;
            case 6:
                OooO00o(this.OooO0Oo, this.OooO0O0.getLoadRender(), this.OooO0O0.getSecondDuration());
                break;
            case 7:
                OooO00o(this.OooO0Oo, 100, this.OooO0O0.getFinishAnimationDuration());
                break;
            default:
                OooO00o(this.OooO0Oo, 100, this.OooO0O0.getFinishAnimationDuration());
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void OooO0O0() {
        post(new Runnable() { // from class: com.cloud.tmc.miniapp.widget.f
            @Override // java.lang.Runnable
            public final void run() {
                LoadingTextView.OooO00o(LoadingTextView.this);
            }
        });
    }

    public final int getLoadingProgress() {
        return this.OooO0OO;
    }

    public final LoadingAnimationModel getProgressConfigModel() {
        return this.OooO0O0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setLoadingProgress(int i) {
        int i2 = this.OooO0Oo;
        if (i2 != this.OooO0OO || i2 == 100) {
            int i3 = i2 + 1;
            if (i3 > 100) {
                i3 = 100;
            }
            setText(i3 + "%");
            if (this.OooO0Oo == 100) {
                Object context = getContext();
                MiniAppActivity miniAppActivity = context instanceof MiniAppActivity ? (MiniAppActivity) context : null;
                if (miniAppActivity != null) {
                    miniAppActivity.hideStatusLoading();
                }
            }
        }
        this.OooO0OO = i;
    }

    public final void setProgressConfigModel(LoadingAnimationModel loadingAnimationModel) {
        Intrinsics.h(loadingAnimationModel, "<set-?>");
        this.OooO0O0 = loadingAnimationModel;
    }
}
