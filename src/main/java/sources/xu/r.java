package xu;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.transsion.usercenter.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class r implements f4.a {
    private final LinearLayout a;
    public final Button b;
    public final Button c;
    public final RadioButton d;
    public final RadioButton e;
    public final RadioButton f;
    public final RadioGroup g;

    private r(LinearLayout linearLayout, Button button, Button button2, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioGroup radioGroup) {
        this.a = linearLayout;
        this.b = button;
        this.c = button2;
        this.d = radioButton;
        this.e = radioButton2;
        this.f = radioButton3;
        this.g = radioGroup;
    }

    public static r a(View view) {
        int i = R$id.btnCancel;
        Button button = (Button) f4.b.a(view, i);
        if (button != null) {
            i = R$id.btnOk;
            Button button2 = (Button) f4.b.a(view, i);
            if (button2 != null) {
                i = R$id.radioButtonReset;
                RadioButton radioButton = (RadioButton) f4.b.a(view, i);
                if (radioButton != null) {
                    i = R$id.radioButtonSubject;
                    RadioButton radioButton2 = (RadioButton) f4.b.a(view, i);
                    if (radioButton2 != null) {
                        i = R$id.radioButtonUGCVideo;
                        RadioButton radioButton3 = (RadioButton) f4.b.a(view, i);
                        if (radioButton3 != null) {
                            i = R$id.radioGroup;
                            RadioGroup radioGroup = (RadioGroup) f4.b.a(view, i);
                            if (radioGroup != null) {
                                return new r((LinearLayout) view, button, button2, radioButton, radioButton2, radioButton3, radioGroup);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }
}
