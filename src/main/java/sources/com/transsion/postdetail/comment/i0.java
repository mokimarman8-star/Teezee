package com.transsion.postdetail.comment;

import android.text.Editable;
import android.text.TextWatcher;
import com.transsion.flow.bean.CommentBean;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public interface i0 extends TextWatcher {

    public static final class a {
        public static void a(i0 i0Var, Editable editable) {
        }

        public static void b(i0 i0Var, CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    void F();

    void T(Editable editable, CommentBean commentBean);

    @Override // android.text.TextWatcher
    void afterTextChanged(Editable editable);

    @Override // android.text.TextWatcher
    void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3);
}
