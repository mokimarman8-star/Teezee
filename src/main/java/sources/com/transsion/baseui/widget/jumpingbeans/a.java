package com.transsion.baseui.widget.jumpingbeans;

import android.text.SpannableStringBuilder;
import android.widget.TextView;
import java.lang.ref.WeakReference;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a {
    private final JumpingBeansSpan[] a;
    private final WeakReference b;

    /* renamed from: com.transsion.baseui.widget.jumpingbeans.a$a, reason: collision with other inner class name */
    public static class C0017a {
        private final TextView a;
        private int b;
        private int c;
        private float d = 0.65f;
        private int e = 1300;
        private int f = -1;
        private CharSequence g;
        private boolean h;

        C0017a(TextView textView) {
            this.a = textView;
        }

        private JumpingBeansSpan[] b(SpannableStringBuilder spannableStringBuilder) {
            JumpingBeansSpan[] jumpingBeansSpanArr = {new JumpingBeansSpan(this.a, this.e, 0, 0, this.d)};
            spannableStringBuilder.setSpan(jumpingBeansSpanArr[0], this.b, this.c, 33);
            return jumpingBeansSpanArr;
        }

        private JumpingBeansSpan[] c(SpannableStringBuilder spannableStringBuilder) {
            if (this.f == -1) {
                this.f = this.e / ((this.c - this.b) * 3);
            }
            int i = this.c;
            int i2 = this.b;
            JumpingBeansSpan[] jumpingBeansSpanArr = new JumpingBeansSpan[i - i2];
            while (i2 < this.c) {
                JumpingBeansSpan jumpingBeansSpan = new JumpingBeansSpan(this.a, this.e, i2 - this.b, this.f, this.d);
                int i3 = i2 + 1;
                spannableStringBuilder.setSpan(jumpingBeansSpan, i2, i3, 33);
                jumpingBeansSpanArr[i2 - this.b] = jumpingBeansSpan;
                i2 = i3;
            }
            return jumpingBeansSpanArr;
        }

        private static CharSequence d(int i, int i2, CharSequence charSequence) {
            if (charSequence == null) {
                throw new NullPointerException("The textView text must not be null");
            }
            if (i2 < i) {
                throw new IllegalArgumentException("The start position must be smaller than the end position");
            }
            if (i < 0) {
                throw new IndexOutOfBoundsException("The start position must be non-negative");
            }
            if (i2 <= charSequence.length()) {
                return charSequence;
            }
            throw new IndexOutOfBoundsException("The end position must be smaller than the text length");
        }

        public a a() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.g);
            JumpingBeansSpan[] c = this.h ? c(spannableStringBuilder) : b(spannableStringBuilder);
            this.a.setText(spannableStringBuilder);
            return new a(c, this.a);
        }

        public C0017a e(int i, int i2) {
            CharSequence text = this.a.getText();
            d(i, i2, text);
            this.g = text;
            this.h = true;
            this.b = i;
            this.c = i2;
            return this;
        }

        public C0017a f(float f) {
            if (f <= 0.0f || f > 1.0f) {
                throw new IllegalArgumentException("The animated range must be in the (0, 1] range");
            }
            this.d = f;
            return this;
        }

        public C0017a g(boolean z) {
            this.h = z;
            return this;
        }

        public C0017a h(int i) {
            if (i < 1) {
                throw new IllegalArgumentException("The loop duration must be bigger than zero");
            }
            this.e = i;
            return this;
        }

        public C0017a i(int i) {
            if (i < 0) {
                throw new IllegalArgumentException("The wave char offset must be non-negative");
            }
            this.f = i;
            return this;
        }
    }

    private a(JumpingBeansSpan[] jumpingBeansSpanArr, TextView textView) {
        this.a = jumpingBeansSpanArr;
        this.b = new WeakReference(textView);
    }

    public static C0017a a(TextView textView) {
        return new C0017a(textView);
    }
}
