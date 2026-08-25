package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.R;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class h {

    /* renamed from: a, reason: collision with root package name */
    private final TextView f1039a;

    /* renamed from: b, reason: collision with root package name */
    private final l1.f f1040b;

    h(TextView textView) {
        this.f1039a = textView;
        this.f1040b = new l1.f(textView, false);
    }

    InputFilter[] a(InputFilter[] inputFilterArr) {
        return this.f1040b.a(inputFilterArr);
    }

    public boolean b() {
        return this.f1040b.b();
    }

    void c(AttributeSet attributeSet, int i5) {
        TypedArray obtainStyledAttributes = this.f1039a.getContext().obtainStyledAttributes(attributeSet, R.styleable.AppCompatTextView, i5, 0);
        try {
            boolean z5 = obtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_emojiCompatEnabled) ? obtainStyledAttributes.getBoolean(R.styleable.AppCompatTextView_emojiCompatEnabled, true) : true;
            obtainStyledAttributes.recycle();
            e(z5);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    void d(boolean z5) {
        this.f1040b.c(z5);
    }

    void e(boolean z5) {
        this.f1040b.d(z5);
    }

    public TransformationMethod f(TransformationMethod transformationMethod) {
        return this.f1040b.e(transformationMethod);
    }
}
