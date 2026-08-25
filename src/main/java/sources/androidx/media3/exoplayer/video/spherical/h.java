package androidx.media3.exoplayer.video.spherical;

import android.content.Context;
import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.media3.exoplayer.video.spherical.b;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class h extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener, b.a {

    /* renamed from: c, reason: collision with root package name */
    private final a f11974c;

    /* renamed from: d, reason: collision with root package name */
    private final float f11975d;

    /* renamed from: e, reason: collision with root package name */
    private final GestureDetector f11976e;

    /* renamed from: a, reason: collision with root package name */
    private final PointF f11972a = new PointF();

    /* renamed from: b, reason: collision with root package name */
    private final PointF f11973b = new PointF();

    /* renamed from: f, reason: collision with root package name */
    private volatile float f11977f = 3.1415927f;

    public interface a {
        void b(PointF pointF);

        boolean onSingleTapUp(MotionEvent motionEvent);
    }

    public h(Context context, a aVar, float f5) {
        this.f11974c = aVar;
        this.f11975d = f5;
        this.f11976e = new GestureDetector(context, this);
    }

    @Override // androidx.media3.exoplayer.video.spherical.b.a
    public void a(float[] fArr, float f5) {
        this.f11977f = -f5;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        this.f11972a.set(motionEvent.getX(), motionEvent.getY());
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f5, float f6) {
        float x5 = (motionEvent2.getX() - this.f11972a.x) / this.f11975d;
        float y5 = motionEvent2.getY();
        PointF pointF = this.f11972a;
        float f7 = (y5 - pointF.y) / this.f11975d;
        pointF.set(motionEvent2.getX(), motionEvent2.getY());
        double d5 = this.f11977f;
        float cos = (float) Math.cos(d5);
        float sin = (float) Math.sin(d5);
        PointF pointF2 = this.f11973b;
        pointF2.x -= (cos * x5) - (sin * f7);
        float f8 = pointF2.y + (sin * x5) + (cos * f7);
        pointF2.y = f8;
        pointF2.y = Math.max(-45.0f, Math.min(45.0f, f8));
        this.f11974c.b(this.f11973b);
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return this.f11974c.onSingleTapUp(motionEvent);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f11976e.onTouchEvent(motionEvent);
    }
}
