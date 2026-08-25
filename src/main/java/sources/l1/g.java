package l1;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.datastore.preferences.protobuf.DescriptorProtos$Edition;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.EmojiCompat$f;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class g implements TextWatcher {

    /* renamed from: a, reason: collision with root package name */
    private final EditText f16396a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f16397b;

    /* renamed from: c, reason: collision with root package name */
    private EmojiCompat$f f16398c;

    /* renamed from: d, reason: collision with root package name */
    private int f16399d = DescriptorProtos$Edition.EDITION_MAX_VALUE;

    /* renamed from: e, reason: collision with root package name */
    private int f16400e = 0;

    /* renamed from: f, reason: collision with root package name */
    private boolean f16401f = true;

    private static class a extends EmojiCompat$f {

        /* renamed from: a, reason: collision with root package name */
        private final Reference f16402a;

        a(EditText editText) {
            this.f16402a = new WeakReference(editText);
        }

        @Override // androidx.emoji2.text.EmojiCompat$f
        public void b() {
            super.b();
            g.c((EditText) this.f16402a.get(), 1);
        }
    }

    g(EditText editText, boolean z5) {
        this.f16396a = editText;
        this.f16397b = z5;
    }

    private EmojiCompat$f a() {
        if (this.f16398c == null) {
            this.f16398c = new a(this.f16396a);
        }
        return this.f16398c;
    }

    static void c(EditText editText, int i5) {
        if (i5 == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            EmojiCompat.c().p(editableText);
            d.b(editableText, selectionStart, selectionEnd);
        }
    }

    private boolean e() {
        return (this.f16401f && (this.f16397b || EmojiCompat.i())) ? false : true;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    public boolean b() {
        return this.f16401f;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
    }

    public void d(boolean z5) {
        if (this.f16401f != z5) {
            if (this.f16398c != null) {
                EmojiCompat.c().u(this.f16398c);
            }
            this.f16401f = z5;
            if (z5) {
                c(this.f16396a, EmojiCompat.c().e());
            }
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
        if (this.f16396a.isInEditMode() || e() || i6 > i7 || !(charSequence instanceof Spannable)) {
            return;
        }
        int e5 = EmojiCompat.c().e();
        if (e5 != 0) {
            if (e5 == 1) {
                EmojiCompat.c().s((Spannable) charSequence, i5, i5 + i7, this.f16399d, this.f16400e);
                return;
            } else if (e5 != 3) {
                return;
            }
        }
        EmojiCompat.c().t(a());
    }
}
