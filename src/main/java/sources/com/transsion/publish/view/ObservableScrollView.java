package com.transsion.publish.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class ObservableScrollView extends ScrollView {
    public static final int SCROLL_DOWN = 16;
    public static final int SCROLL_UP = 1;
    private a a;

    public interface a {
        void a(int i);
    }

    public ObservableScrollView(Context context) {
        super(context);
    }

    public ObservableScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ObservableScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public ObservableScrollView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        a aVar;
        super.onScrollChanged(i, i2, i3, i4);
        if (i4 > i2 && i4 - i2 > 40) {
            a aVar2 = this.a;
            if (aVar2 != null) {
                aVar2.a(16);
                return;
            }
            return;
        }
        if (i4 >= i2 || i2 - i4 <= 40 || (aVar = this.a) == null) {
            return;
        }
        aVar.a(1);
    }

    public void setScrollListener(a aVar) {
        this.a = aVar;
    }
}
