package fr;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c implements a {
    private final TextView a;
    private String b;
    private Function0 c;
    private int d;
    private int e;
    private Function0 f;

    public c(TextView textView) {
        Intrinsics.h(textView, "textView");
        this.a = textView;
        this.b = "http://schemas.android.com/apk/res/android";
    }

    public final void a(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.h(context, "context");
        if (attributeSet != null) {
            String attributeValue = attributeSet.getAttributeValue(this.b, "text");
            if (attributeValue != null && attributeValue.length() >= 2) {
                String substring = attributeValue.substring(1, attributeValue.length());
                Intrinsics.g(substring, "substring(...)");
                this.d = b.a(substring);
            }
            String attributeValue2 = attributeSet.getAttributeValue(this.b, "hint");
            if (attributeValue2 == null || attributeValue2.length() < 2) {
                return;
            }
            String substring2 = attributeValue2.substring(1, attributeValue2.length());
            Intrinsics.g(substring2, "substring(...)");
            this.e = b.a(substring2);
        }
    }

    public void b(int i) {
        this.e = i;
        if (i != 0) {
            this.a.setHint(i);
        }
    }

    public void c(CharSequence charSequence) {
        this.e = 0;
        this.a.setHint(charSequence);
    }

    @Override // fr.a
    public void changeLocal() {
        try {
            int i = this.d;
            if (i != 0) {
                this.a.setText(i);
            }
            int i2 = this.e;
            if (i2 != 0) {
                this.a.setHint(i2);
            }
            Function0 function0 = this.f;
            if (function0 != null) {
                this.a.setText(function0 != null ? (CharSequence) function0.invoke() : null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Function0 function02 = this.c;
        if (function02 != null) {
            function02.invoke();
        }
    }

    public void d(Function0 function0) {
        Intrinsics.h(function0, "listener");
        this.c = function0;
    }

    public void e(Function0 function0) {
        this.f = function0;
        this.d = 0;
        this.a.setText(function0 != null ? (CharSequence) function0.invoke() : null);
    }

    public void f(int i) {
        this.d = i;
        if (i != 0) {
            this.a.setText(i);
        }
    }

    public void g(CharSequence charSequence) {
        this.f = null;
        this.d = 0;
        this.a.setText(charSequence);
    }
}
