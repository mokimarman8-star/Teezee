package net.lucode.hackware.magicindicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import vy.a;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class MagicIndicator extends FrameLayout {
    private a a;

    public MagicIndicator(Context context) {
        super(context);
    }

    public MagicIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public a getNavigator() {
        return this.a;
    }

    public void onPageScrollStateChanged(int i) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.onPageScrollStateChanged(i);
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.onPageScrolled(i, f, i2);
        }
    }

    public void onPageSelected(int i) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.onPageSelected(i);
        }
    }

    public void setNavigator(a aVar) {
        a aVar2 = this.a;
        if (aVar2 == aVar) {
            return;
        }
        if (aVar2 != null) {
            aVar2.onDetachFromMagicIndicator();
        }
        this.a = aVar;
        removeAllViews();
        if (this.a instanceof View) {
            addView((View) this.a, new FrameLayout.LayoutParams(-1, -1));
            this.a.onAttachToMagicIndicator();
        }
    }
}
