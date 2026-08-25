package net.lucode.hackware.magicindicator.buildins.commonnavigator.titles;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.widget.TextView;
import xy.b;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class SimplePagerTitleView extends TextView implements b {
    protected int a;
    protected int b;

    public SimplePagerTitleView(Context context) {
        super(context, null);
        a(context);
    }

    private void a(Context context) {
        setGravity(17);
        int a = wy.b.a(context, 10.0d);
        setPadding(a, 0, a, 0);
        setSingleLine();
        setEllipsize(TextUtils.TruncateAt.END);
    }

    public int getContentBottom() {
        Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
        return (int) ((getHeight() / 2) + ((fontMetrics.bottom - fontMetrics.top) / 2.0f));
    }

    public int getContentLeft() {
        String charSequence;
        Rect rect = new Rect();
        if (getText().toString().contains("\n")) {
            charSequence = "";
            for (String str : getText().toString().split("\\n")) {
                if (str.length() > charSequence.length()) {
                    charSequence = str;
                }
            }
        } else {
            charSequence = getText().toString();
        }
        getPaint().getTextBounds(charSequence, 0, charSequence.length(), rect);
        return (getLeft() + (getWidth() / 2)) - (rect.width() / 2);
    }

    public int getContentRight() {
        String charSequence;
        Rect rect = new Rect();
        if (getText().toString().contains("\n")) {
            charSequence = "";
            for (String str : getText().toString().split("\\n")) {
                if (str.length() > charSequence.length()) {
                    charSequence = str;
                }
            }
        } else {
            charSequence = getText().toString();
        }
        getPaint().getTextBounds(charSequence, 0, charSequence.length(), rect);
        return getLeft() + (getWidth() / 2) + (rect.width() / 2);
    }

    public int getContentTop() {
        Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
        return (int) ((getHeight() / 2) - ((fontMetrics.bottom - fontMetrics.top) / 2.0f));
    }

    public int getNormalColor() {
        return this.b;
    }

    public int getSelectedColor() {
        return this.a;
    }

    public void onDeselected(int i, int i2) {
        setTextColor(this.b);
    }

    public void onEnter(int i, int i2, float f, boolean z) {
    }

    public void onLeave(int i, int i2, float f, boolean z) {
    }

    public void onSelected(int i, int i2) {
        setTextColor(this.a);
    }

    public void setNormalColor(int i) {
        this.b = i;
    }

    public void setSelectedColor(int i) {
        this.a = i;
    }
}
