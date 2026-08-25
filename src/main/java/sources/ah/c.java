package ah;

import android.graphics.Typeface;
import android.text.SpannableStringBuilder;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class c extends SpannableStringBuilder {

    public static class a {
        private b a = new b();
        private c b = new c();

        private void a() {
            if (this.a.length() != 0) {
                this.b.append(this.a);
            }
        }

        public c b() {
            a();
            return this.b;
        }

        public a c(int i) {
            this.a.c(i);
            return this;
        }

        public a d(int i) {
            this.a.d(i);
            return this;
        }

        public a e(CharSequence charSequence) {
            a();
            this.a = new b(charSequence);
            return this;
        }

        public a f(Typeface typeface) {
            this.a.e(typeface);
            return this;
        }
    }

    public static a e() {
        return new a();
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public c append(char c) {
        super.append(c);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public c append(CharSequence charSequence, int i, int i2) {
        super.append((CharSequence) new b(charSequence, i, i2));
        return this;
    }

    @Override // android.text.SpannableStringBuilder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public c append(CharSequence charSequence, Object obj, int i) {
        super.append(charSequence, obj, i);
        return this;
    }
}
