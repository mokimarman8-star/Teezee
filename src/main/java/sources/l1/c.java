package l1;

import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;
import androidx.emoji2.text.EmojiCompat;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class c extends InputConnectionWrapper {

    /* renamed from: a, reason: collision with root package name */
    private final TextView f16383a;

    /* renamed from: b, reason: collision with root package name */
    private final a f16384b;

    public static class a {
        public boolean a(InputConnection inputConnection, Editable editable, int i5, int i6, boolean z5) {
            return EmojiCompat.f(inputConnection, editable, i5, i6, z5);
        }

        public void b(EditorInfo editorInfo) {
            if (EmojiCompat.i()) {
                EmojiCompat.c().v(editorInfo);
            }
        }
    }

    c(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        this(textView, inputConnection, editorInfo, new a());
    }

    c(TextView textView, InputConnection inputConnection, EditorInfo editorInfo, a aVar) {
        super(inputConnection, false);
        this.f16383a = textView;
        this.f16384b = aVar;
        aVar.b(editorInfo);
    }

    private Editable a() {
        return this.f16383a.getEditableText();
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int i5, int i6) {
        return this.f16384b.a(this, a(), i5, i6, false) || super.deleteSurroundingText(i5, i6);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int i5, int i6) {
        return this.f16384b.a(this, a(), i5, i6, true) || super.deleteSurroundingTextInCodePoints(i5, i6);
    }
}
