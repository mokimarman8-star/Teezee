package l1;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.EmojiCompat$f;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class d implements InputFilter {

    /* renamed from: a, reason: collision with root package name */
    private final TextView f16385a;

    /* renamed from: b, reason: collision with root package name */
    private EmojiCompat$f f16386b;

    private static class a extends EmojiCompat$f {

        /* renamed from: a, reason: collision with root package name */
        private final Reference f16387a;

        /* renamed from: b, reason: collision with root package name */
        private final Reference f16388b;

        a(TextView textView, d dVar) {
            this.f16387a = new WeakReference(textView);
            this.f16388b = new WeakReference(dVar);
        }

        private boolean c(TextView textView, InputFilter inputFilter) {
            InputFilter[] filters;
            if (inputFilter == null || textView == null || (filters = textView.getFilters()) == null) {
                return false;
            }
            for (InputFilter inputFilter2 : filters) {
                if (inputFilter2 == inputFilter) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.emoji2.text.EmojiCompat$f
        public void b() {
            CharSequence text;
            CharSequence p5;
            super.b();
            TextView textView = (TextView) this.f16387a.get();
            if (c(textView, (InputFilter) this.f16388b.get()) && textView.isAttachedToWindow() && text != (p5 = EmojiCompat.c().p((text = textView.getText())))) {
                int selectionStart = Selection.getSelectionStart(p5);
                int selectionEnd = Selection.getSelectionEnd(p5);
                textView.setText(p5);
                if (p5 instanceof Spannable) {
                    d.b((Spannable) p5, selectionStart, selectionEnd);
                }
            }
        }
    }

    d(TextView textView) {
        this.f16385a = textView;
    }

    private EmojiCompat$f a() {
        if (this.f16386b == null) {
            this.f16386b = new a(this.f16385a, this);
        }
        return this.f16386b;
    }

    static void b(Spannable spannable, int i5, int i6) {
        if (i5 >= 0 && i6 >= 0) {
            Selection.setSelection(spannable, i5, i6);
        } else if (i5 >= 0) {
            Selection.setSelection(spannable, i5);
        } else if (i6 >= 0) {
            Selection.setSelection(spannable, i6);
        }
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i5, int i6, Spanned spanned, int i7, int i8) {
        if (this.f16385a.isInEditMode()) {
            return charSequence;
        }
        int e5 = EmojiCompat.c().e();
        if (e5 != 0) {
            if (e5 == 1) {
                if ((i8 == 0 && i7 == 0 && spanned.length() == 0 && charSequence == this.f16385a.getText()) || charSequence == null) {
                    return charSequence;
                }
                if (i5 != 0 || i6 != charSequence.length()) {
                    charSequence = charSequence.subSequence(i5, i6);
                }
                return EmojiCompat.c().q(charSequence, 0, charSequence.length());
            }
            if (e5 != 3) {
                return charSequence;
            }
        }
        EmojiCompat.c().t(a());
        return charSequence;
    }
}
