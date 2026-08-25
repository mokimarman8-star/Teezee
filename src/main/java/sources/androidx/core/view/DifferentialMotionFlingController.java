package androidx.core.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.datastore.preferences.protobuf.DescriptorProtos$Edition;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class DifferentialMotionFlingController {
    private final Context mContext;
    private final int[] mFlingVelocityThresholds;
    private float mLastFlingVelocity;
    private int mLastProcessedAxis;
    private int mLastProcessedDeviceId;
    private int mLastProcessedSource;
    private final DifferentialMotionFlingTarget mTarget;
    private final a mVelocityProvider;
    private final b mVelocityThresholdCalculator;
    private VelocityTracker mVelocityTracker;

    interface a {
        float a(VelocityTracker velocityTracker, MotionEvent motionEvent, int i5);
    }

    interface b {
        void a(Context context, int[] iArr, MotionEvent motionEvent, int i5);
    }

    public DifferentialMotionFlingController(Context context, DifferentialMotionFlingTarget differentialMotionFlingTarget) {
        this(context, differentialMotionFlingTarget, new b() { // from class: androidx.core.view.q
            @Override // androidx.core.view.DifferentialMotionFlingController.b
            public final void a(Context context2, int[] iArr, MotionEvent motionEvent, int i5) {
                DifferentialMotionFlingController.calculateFlingVelocityThresholds(context2, iArr, motionEvent, i5);
            }
        }, new a() { // from class: androidx.core.view.r
            @Override // androidx.core.view.DifferentialMotionFlingController.a
            public final float a(VelocityTracker velocityTracker, MotionEvent motionEvent, int i5) {
                float currentVelocity;
                currentVelocity = DifferentialMotionFlingController.getCurrentVelocity(velocityTracker, motionEvent, i5);
                return currentVelocity;
            }
        });
    }

    DifferentialMotionFlingController(Context context, DifferentialMotionFlingTarget differentialMotionFlingTarget, b bVar, a aVar) {
        this.mLastProcessedAxis = -1;
        this.mLastProcessedSource = -1;
        this.mLastProcessedDeviceId = -1;
        this.mFlingVelocityThresholds = new int[]{DescriptorProtos$Edition.EDITION_MAX_VALUE, 0};
        this.mContext = context;
        this.mTarget = differentialMotionFlingTarget;
        this.mVelocityThresholdCalculator = bVar;
        this.mVelocityProvider = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void calculateFlingVelocityThresholds(Context context, int[] iArr, MotionEvent motionEvent, int i5) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        iArr[0] = ViewConfigurationCompat.getScaledMinimumFlingVelocity(context, viewConfiguration, motionEvent.getDeviceId(), i5, motionEvent.getSource());
        iArr[1] = ViewConfigurationCompat.getScaledMaximumFlingVelocity(context, viewConfiguration, motionEvent.getDeviceId(), i5, motionEvent.getSource());
    }

    private boolean calculateFlingVelocityThresholds(MotionEvent motionEvent, int i5) {
        int source = motionEvent.getSource();
        int deviceId = motionEvent.getDeviceId();
        if (this.mLastProcessedSource == source && this.mLastProcessedDeviceId == deviceId && this.mLastProcessedAxis == i5) {
            return false;
        }
        this.mVelocityThresholdCalculator.a(this.mContext, this.mFlingVelocityThresholds, motionEvent, i5);
        this.mLastProcessedSource = source;
        this.mLastProcessedDeviceId = deviceId;
        this.mLastProcessedAxis = i5;
        return true;
    }

    private float getCurrentVelocity(MotionEvent motionEvent, int i5) {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        return this.mVelocityProvider.a(this.mVelocityTracker, motionEvent, i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float getCurrentVelocity(VelocityTracker velocityTracker, MotionEvent motionEvent, int i5) {
        VelocityTrackerCompat.addMovement(velocityTracker, motionEvent);
        VelocityTrackerCompat.computeCurrentVelocity(velocityTracker, 1000);
        return VelocityTrackerCompat.getAxisVelocity(velocityTracker, i5);
    }

    public void onMotionEvent(MotionEvent motionEvent, int i5) {
        boolean calculateFlingVelocityThresholds = calculateFlingVelocityThresholds(motionEvent, i5);
        if (this.mFlingVelocityThresholds[0] == Integer.MAX_VALUE) {
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.mVelocityTracker = null;
                return;
            }
            return;
        }
        float currentVelocity = getCurrentVelocity(motionEvent, i5) * this.mTarget.getScaledScrollFactor();
        float signum = Math.signum(currentVelocity);
        if (calculateFlingVelocityThresholds || (signum != Math.signum(this.mLastFlingVelocity) && signum != 0.0f)) {
            this.mTarget.stopDifferentialMotionFling();
        }
        float abs = Math.abs(currentVelocity);
        int[] iArr = this.mFlingVelocityThresholds;
        if (abs < iArr[0]) {
            return;
        }
        float max = Math.max(-r6, Math.min(currentVelocity, iArr[1]));
        this.mLastFlingVelocity = this.mTarget.startDifferentialMotionFling(max) ? max : 0.0f;
    }
}
