package p7;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.contrarywind.view.WheelView;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class a extends GestureDetector.SimpleOnGestureListener {
    private final WheelView a;

    public a(WheelView wheelView) {
        this.a = wheelView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.a.scrollBy(f2);
        return true;
    }
}
