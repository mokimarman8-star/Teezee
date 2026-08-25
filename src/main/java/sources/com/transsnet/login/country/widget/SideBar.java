package com.transsnet.login.country.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.b;
import com.tn.lib.widget.R;
import com.transsnet.login.R$dimen;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class SideBar extends View {
    private List a;
    private TextPaint b;
    private int c;
    private a d;
    private float e;
    private int f;
    private int g;
    private float h;

    public interface a {
        void f(String str);
    }

    public SideBar(Context context) {
        super(context.getApplicationContext());
        this.c = -1;
        this.e = -1.0f;
        this.f = -1;
        this.g = -1;
        this.h = -1.0f;
    }

    public SideBar(Context context, AttributeSet attributeSet) {
        super(context.getApplicationContext(), attributeSet);
        this.c = -1;
        this.e = -1.0f;
        this.f = -1;
        this.g = -1;
        this.h = -1.0f;
        setBackgroundColor(0);
    }

    private void a(Canvas canvas) {
        if (this.f < 0) {
            this.f = getContext().getResources().getDimensionPixelSize(R$dimen.side_bar_txt_size);
            this.g = b.getColor(getContext(), R.color.text_03);
            this.e = this.f * 1.5f;
        }
        int i = 0;
        for (String str : this.a) {
            this.b.setTextSize(this.f);
            this.b.setAntiAlias(true);
            this.b.setColor(this.g);
            if (i == this.c) {
                this.b.setColor(b.getColor(getContext(), R.color.text_01));
                this.b.setFakeBoldText(true);
            }
            if (this.h < 0.0f) {
                this.h = ((getWidth() * 1.0f) / 2.0f) - (this.b.measureText(str) / 2.0f);
            }
            float f = this.e;
            canvas.drawText(str, this.h, (i * f) + f, this.b);
            this.b.reset();
            i++;
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.a == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        motionEvent.getX();
        float y = motionEvent.getY();
        int i = this.c;
        int height = (int) ((y / getHeight()) * this.a.size());
        if (action == 1 || action == 3) {
            setBackgroundColor(0);
            invalidate();
        } else {
            setBackgroundColor(0);
            if (i != height && height >= 0 && height < this.a.size()) {
                a aVar = this.d;
                if (aVar != null) {
                    aVar.f((String) this.a.get(height));
                }
                this.c = height;
                invalidate();
            }
        }
        return true;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        List list = this.a;
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.b == null) {
            this.b = new TextPaint(1);
        }
        a(canvas);
    }

    public void setIndexs(List<String> list) {
        this.a = list;
        if (this.f < 0) {
            this.f = getContext().getResources().getDimensionPixelSize(R$dimen.side_bar_txt_size);
            this.g = b.getColor(getContext(), R.color.text_03);
            this.e = this.f * 1.5f;
        }
        if (list != null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            layoutParams.height = (int) (this.e * list.size());
            setLayoutParams(layoutParams);
        }
        invalidate();
    }

    public void setScrollerListener(a aVar) {
        this.d = aVar;
    }

    public void updateIndex(int i) {
        this.c = i;
        invalidate();
    }
}
