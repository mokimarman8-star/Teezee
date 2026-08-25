package g7;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class n extends GestureDetector {
    private a a;

    public static class a extends GestureDetector.SimpleOnGestureListener {
        boolean a = false;

        boolean a() {
            return this.a;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            this.a = true;
            return super.onSingleTapUp(motionEvent);
        }
    }

    public n(Context context) {
        this(context, new a());
    }

    private n(Context context, a aVar) {
        super(context, aVar);
        this.a = aVar;
        setIsLongpressEnabled(false);
    }

    public boolean a() {
        return this.a.a();
    }
}
