package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.appcompat.R;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class g {

    /* renamed from: a, reason: collision with root package name */
    private final EditText f1033a;

    /* renamed from: b, reason: collision with root package name */
    private final l1.a f1034b;

    g(EditText editText) {
        this.f1033a = editText;
        this.f1034b = new l1.a(editText, false);
    }

    KeyListener a(KeyListener keyListener) {
        return b(keyListener) ? this.f1034b.a(keyListener) : keyListener;
    }

    boolean b(KeyListener keyListener) {
        return !(keyListener instanceof NumberKeyListener);
    }

    boolean c() {
        return this.f1034b.b();
    }

    void d(AttributeSet attributeSet, int i5) {
        TypedArray obtainStyledAttributes = this.f1033a.getContext().obtainStyledAttributes(attributeSet, R.styleable.AppCompatTextView, i5, 0);
        try {
            boolean z5 = obtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_emojiCompatEnabled) ? obtainStyledAttributes.getBoolean(R.styleable.AppCompatTextView_emojiCompatEnabled, true) : true;
            obtainStyledAttributes.recycle();
            f(z5);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    InputConnection e(InputConnection inputConnection, EditorInfo editorInfo) {
        return this.f1034b.c(inputConnection, editorInfo);
    }

    void f(boolean z5) {
        this.f1034b.d(z5);
    }
}
