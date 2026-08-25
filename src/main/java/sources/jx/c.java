package jx;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsnet.login.R$id;
import com.transsnet.login.country.SelectCountryViewModel;
import com.transsnet.loginapi.bean.Country;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class c extends RecyclerView.a0 {
    private View a;
    private TextView b;
    private TextView c;
    private TextView d;

    public c(View view) {
        super(view);
        this.a = view.findViewById(R$id.index_layout);
        this.b = (TextView) view.findViewById(R$id.index_tv);
        this.c = (TextView) view.findViewById(R$id.name);
        this.d = (TextView) view.findViewById(R$id.code);
    }

    public void g(final Country country, final SelectCountryViewModel selectCountryViewModel) {
        ((RecyclerView.a0) this).itemView.setOnClickListener(new View.OnClickListener() { // from class: jx.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectCountryViewModel.this.r(country);
            }
        });
        if (TextUtils.isEmpty(country.getIndex())) {
            this.a.setVisibility(8);
        } else {
            this.a.setVisibility(0);
            this.b.setText(country.getIndex());
        }
        this.c.setText(country.getCountry());
        this.d.setText(country.getCodeAndAdd());
    }
}
