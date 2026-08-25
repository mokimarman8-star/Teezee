package af;

import android.content.Context;
import android.view.OrientationEventListener;
import android.view.WindowManager;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class p {
    private int a;
    private WindowManager b;
    private OrientationEventListener c;
    private o d;

    class a extends OrientationEventListener {
        a(Context context, int i) {
            super(context, i);
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i) {
            int rotation;
            WindowManager windowManager = p.this.b;
            o oVar = p.this.d;
            if (p.this.b == null || oVar == null || (rotation = windowManager.getDefaultDisplay().getRotation()) == p.this.a) {
                return;
            }
            p.this.a = rotation;
            oVar.a(rotation);
        }
    }

    public void e(Context context, o oVar) {
        f();
        Context applicationContext = context.getApplicationContext();
        this.d = oVar;
        this.b = (WindowManager) applicationContext.getSystemService("window");
        a aVar = new a(applicationContext, 3);
        this.c = aVar;
        aVar.enable();
        this.a = this.b.getDefaultDisplay().getRotation();
    }

    public void f() {
        OrientationEventListener orientationEventListener = this.c;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
        this.c = null;
        this.b = null;
        this.d = null;
    }
}
