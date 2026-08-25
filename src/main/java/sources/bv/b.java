package bv;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.d0;
import androidx.lifecycle.t;
import androidx.lifecycle.u;
import com.blankj.utilcode.util.h;
import com.google.android.material.bottomsheet.c;
import com.tn.lib.widget.R;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.R$string;
import com.transsion.usercenter.R$style;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class b implements View.OnClickListener, t {
    private Activity a;
    private TextView b;
    private TextView c;
    private TextView d;
    private a e;
    private c f;
    private String g;
    private boolean h;

    public interface a {
        void onDialogSelect(int i, String str);
    }

    public b(Activity activity, a aVar, String str) {
        this.a = activity;
        this.e = aVar;
        this.g = str;
        a();
    }

    private void a() {
        View inflate = LayoutInflater.from(this.a).inflate(R$layout.dialog_edit_gender, (ViewGroup) null);
        this.b = (TextView) inflate.findViewById(R$id.tv_first);
        this.c = (TextView) inflate.findViewById(R$id.tv_second);
        this.d = (TextView) inflate.findViewById(R$id.tv_third);
        this.b.setOnClickListener(this);
        this.c.setOnClickListener(this);
        this.d.setOnClickListener(this);
        c cVar = new c(this.a, R$style.BottomDialog1);
        this.f = cVar;
        cVar.getWindow().setWindowAnimations(R$style.bottom_dialog_animation);
        this.f.setContentView(inflate);
    }

    public void b() {
        if (TextUtils.equals(this.g, this.a.getString(R$string.profile_female))) {
            this.b.setTextColor(h.a(R.color.white));
            this.c.setTextColor(h.a(R.color.text_03));
            this.d.setTextColor(h.a(R.color.text_03));
        } else if (TextUtils.equals(this.g, this.a.getString(R$string.profile_male))) {
            this.c.setTextColor(h.a(R.color.white));
            this.b.setTextColor(h.a(R.color.text_03));
            this.d.setTextColor(h.a(R.color.text_03));
        } else {
            this.d.setTextColor(h.a(R.color.white));
            this.b.setTextColor(h.a(R.color.text_03));
            this.c.setTextColor(h.a(R.color.text_03));
        }
        this.b.setText(R$string.profile_female);
        this.c.setText(R$string.profile_male);
        this.d.setText(R$string.profile_gender_other);
        this.f.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R$id.tv_first) {
            a aVar = this.e;
            if (aVar != null) {
                aVar.onDialogSelect(0, this.b.getText().toString());
                this.f.dismiss();
                return;
            }
            return;
        }
        if (id != R$id.tv_second) {
            if (id == R$id.tv_third) {
                this.e.onDialogSelect(2, this.d.getText().toString());
                this.f.dismiss();
                return;
            }
            return;
        }
        a aVar2 = this.e;
        if (aVar2 != null) {
            aVar2.onDialogSelect(1, this.c.getText().toString());
            this.f.dismiss();
        }
    }

    @d0(Lifecycle.Event.ON_ANY)
    public void onLifecycleChanged(u uVar, Lifecycle.Event event) {
    }

    @d0(Lifecycle.Event.ON_PAUSE)
    public void onPause(u uVar) {
        this.h = false;
    }

    @d0(Lifecycle.Event.ON_RESUME)
    public void onResume(u uVar) {
        this.h = true;
    }
}
