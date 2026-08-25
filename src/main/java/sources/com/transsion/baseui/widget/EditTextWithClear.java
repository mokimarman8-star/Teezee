package com.transsion.baseui.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import com.transsion.baseui.R$styleable;
import com.transsion.gslb.BuildConfig;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class EditTextWithClear extends AppCompatEditText implements View.OnFocusChangeListener, TextWatcher {
    private Drawable a;
    private boolean b;
    private boolean c;

    public interface a {
    }

    public EditTextWithClear(Context context) {
        this(context, null);
    }

    public EditTextWithClear(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextStyle);
    }

    public EditTextWithClear(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = true;
        this.c = false;
        init(context, attributeSet);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.EditTextWithClear);
        this.a = obtainStyledAttributes.getDrawable(R$styleable.EditTextWithClear_et_clear_ic);
        this.c = obtainStyledAttributes.getBoolean(R$styleable.EditTextWithClear_et_close_withoutfocus, false);
        if (this.a == null) {
            this.a = androidx.core.content.b.getDrawable(context, com.transsion.baseui.R.mipmap.ic_input_close);
        }
        Drawable drawable = this.a;
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.a.getIntrinsicHeight());
        setClearIconVisible(false);
        setOnFocusChangeListener(this);
        addTextChangedListener(this);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void hideClear() {
        setClearIconVisible(false);
        this.b = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onAttachedToWindow() {
        super/*android.widget.EditText*/.onAttachedToWindow();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (z) {
            setClearIconVisible(getText().length() > 0);
        } else {
            setClearIconVisible(false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        setClearIconVisible(charSequence.length() > 0 && (hasFocus() || this.c));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getCompoundDrawables()[2] != null && motionEvent.getAction() == 1) {
            double width = (getWidth() - getPaddingRight()) + (this.a.getIntrinsicWidth() * 0.5d);
            if (motionEvent.getX() > (getWidth() - getPaddingRight()) - (this.a.getIntrinsicWidth() * 1.5d) && motionEvent.getX() < width) {
                setText(BuildConfig.FLAVOR);
            }
        }
        return super/*android.widget.EditText*/.onTouchEvent(motionEvent);
    }

    public void setActionListener(a aVar) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void setClearIconVisible(boolean z) {
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], (z && this.b) ? this.a : null, getCompoundDrawables()[3]);
    }

    public void showClear() {
        this.b = true;
        setClearIconVisible(false);
    }
}
