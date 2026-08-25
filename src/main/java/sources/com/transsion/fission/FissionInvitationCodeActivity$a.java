package com.transsion.fission;

import android.text.Editable;
import android.text.TextWatcher;
import androidx.appcompat.widget.AppCompatButton;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class FissionInvitationCodeActivity$a implements TextWatcher {
    final /* synthetic */ FissionInvitationCodeActivity a;

    public FissionInvitationCodeActivity$a(FissionInvitationCodeActivity fissionInvitationCodeActivity) {
        this.a = fissionInvitationCodeActivity;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        AppCompatButton appCompatButton = ((hk.a) this.a.getMViewBinding()).b;
        boolean z = false;
        if (editable != null && editable.length() == 8) {
            z = true;
        }
        appCompatButton.setSelected(z);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
