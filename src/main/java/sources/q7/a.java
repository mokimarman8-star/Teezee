package q7;

import android.os.Handler;
import android.os.Message;
import com.contrarywind.view.WheelView;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class a extends Handler {
    private final WheelView a;

    public a(WheelView wheelView) {
        this.a = wheelView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1000) {
            this.a.invalidate();
        } else if (i == 2000) {
            this.a.smoothScroll(WheelView.ACTION.FLING);
        } else {
            if (i != 3000) {
                return;
            }
            this.a.onItemSelected();
        }
    }
}
