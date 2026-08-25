package com.noober.background.drawable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.TextView;
import com.noober.background.R;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class TextViewGradientColor implements ITextViewOperator {
    private int endColor = -1;
    private int startColor = -1;
    private int orientation = 0;

    @Override // com.noober.background.drawable.ITextViewOperator
    public void invoke(Context context, AttributeSet attributeSet, final TextView textView) {
        int i;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.bl_text);
        try {
        } catch (Exception unused) {
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
        if (obtainStyledAttributes.getIndexCount() == 0) {
            obtainStyledAttributes.recycle();
            return;
        }
        for (int i2 = 0; i2 < obtainStyledAttributes.getIndexCount(); i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.bl_text_bl_text_gradient_endColor) {
                this.endColor = obtainStyledAttributes.getColor(index, -1);
            } else if (index == R.styleable.bl_text_bl_text_gradient_startColor) {
                this.startColor = obtainStyledAttributes.getColor(index, -1);
            } else if (index == R.styleable.bl_text_bl_text_gradient_orientation) {
                this.orientation = obtainStyledAttributes.getInt(index, 0);
            }
        }
        int i3 = this.endColor;
        if (i3 != -1 || (i = this.startColor) == -1) {
            int i4 = this.startColor;
            if (i4 == -1 && i3 != -1) {
                textView.setTextColor(i3);
            } else if (i3 != -1 && i4 != -1) {
                if (this.orientation == 0) {
                    textView.post(new Runnable() { // from class: com.noober.background.drawable.TextViewGradientColor.1
                        @Override // java.lang.Runnable
                        public void run() {
                            textView.getPaint().setShader(new LinearGradient(0.0f, 0.0f, 0.0f, textView.getPaint().descent() - textView.getPaint().ascent(), TextViewGradientColor.this.startColor, TextViewGradientColor.this.endColor, Shader.TileMode.REPEAT));
                            textView.invalidate();
                        }
                    });
                } else {
                    textView.post(new Runnable() { // from class: com.noober.background.drawable.TextViewGradientColor.2
                        @Override // java.lang.Runnable
                        public void run() {
                            textView.getPaint().setShader(new LinearGradient(0.0f, 0.0f, textView.getMeasuredWidth(), 0.0f, TextViewGradientColor.this.startColor, TextViewGradientColor.this.endColor, Shader.TileMode.REPEAT));
                            textView.invalidate();
                        }
                    });
                }
            }
        } else {
            textView.setTextColor(i);
        }
        obtainStyledAttributes.recycle();
    }
}
