package ro;

import android.text.Editable;
import android.text.TextWatcher;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public interface a extends TextWatcher {

    /* renamed from: ro.a$a, reason: collision with other inner class name */
    public static final class C0091a {
        public static void a(a aVar, Editable editable) {
        }

        public static void b(a aVar, CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    @Override // android.text.TextWatcher
    void afterTextChanged(Editable editable);

    @Override // android.text.TextWatcher
    void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3);
}
