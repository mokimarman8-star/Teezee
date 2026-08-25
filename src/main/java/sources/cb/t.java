package cb;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.compose.ui.graphics.layer.k0;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class t extends r {

    class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            if (t.this.e.isEmpty()) {
                return;
            }
            k0.a(outline, t.this.e);
        }
    }

    t(View view) {
        l(view);
    }

    private void l(View view) {
        view.setOutlineProvider(new a());
    }

    @Override // cb.r
    void b(View view) {
        view.setClipToOutline(!j());
        if (j()) {
            view.invalidate();
        } else {
            view.invalidateOutline();
        }
    }

    @Override // cb.r
    boolean j() {
        return this.a;
    }
}
