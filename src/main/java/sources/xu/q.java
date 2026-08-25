package xu;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.transsion.usercenter.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class q implements f4.a {
    private final FrameLayout a;
    public final Button b;
    public final Button c;
    public final RadioButton d;
    public final RadioButton e;
    public final RadioGroup f;

    private q(FrameLayout frameLayout, Button button, Button button2, RadioButton radioButton, RadioButton radioButton2, RadioGroup radioGroup) {
        this.a = frameLayout;
        this.b = button;
        this.c = button2;
        this.d = radioButton;
        this.e = radioButton2;
        this.f = radioGroup;
    }

    public static q a(View view) {
        int i = R$id.btnCancel;
        Button button = (Button) f4.b.a(view, i);
        if (button != null) {
            i = R$id.btnOk;
            Button button2 = (Button) f4.b.a(view, i);
            if (button2 != null) {
                i = R$id.radioButtonGP;
                RadioButton radioButton = (RadioButton) f4.b.a(view, i);
                if (radioButton != null) {
                    i = R$id.radioButtonPS;
                    RadioButton radioButton2 = (RadioButton) f4.b.a(view, i);
                    if (radioButton2 != null) {
                        i = R$id.radioGroup;
                        RadioGroup radioGroup = (RadioGroup) f4.b.a(view, i);
                        if (radioGroup != null) {
                            return new q((FrameLayout) view, button, button2, radioButton, radioButton2, radioGroup);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.a;
    }
}
