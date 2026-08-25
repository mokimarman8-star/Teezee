package com.cloud.hisavana.sdk.common.widget.expandmenu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cloud.hisavana.sdk.R$id;
import com.cloud.hisavana.sdk.R$layout;
import com.cloud.hisavana.sdk.common.widget.expandmenu.AdExpandMenuItemView;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class AdExpandMenuContentView extends RelativeLayout {
    private TextView a;
    private AdExpandMenuItemView b;
    private AdExpandMenuItemView c;
    private AdExpandMenuItemView d;
    private d e;

    class a implements View.OnClickListener {
        final /* synthetic */ d a;

        a(d dVar) {
            this.a = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.a(AdExpandMenuItemView.Type.PERSONALISE_CLOSE);
        }
    }

    class b implements View.OnClickListener {
        final /* synthetic */ d a;

        b(d dVar) {
            this.a = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.a(AdExpandMenuItemView.Type.ADVERTISER_INFO);
        }
    }

    class c implements View.OnClickListener {
        final /* synthetic */ d a;

        c(d dVar) {
            this.a = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.a(AdExpandMenuItemView.Type.COPY_LINK);
        }
    }

    public interface d {
        void a(AdExpandMenuItemView.Type type);
    }

    public AdExpandMenuContentView(@NonNull Context context) {
        this(context, null, 0);
    }

    public AdExpandMenuContentView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdExpandMenuContentView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R$layout.ad_expand_menu_content_layout, this);
        a();
    }

    private void a() {
        this.a = (TextView) findViewById(R$id.advertiser_info);
        AdExpandMenuItemView adExpandMenuItemView = (AdExpandMenuItemView) findViewById(R$id.personalise);
        this.b = adExpandMenuItemView;
        adExpandMenuItemView.setData(AdExpandMenuItemView.Type.PERSONALISE_CLOSE);
        AdExpandMenuItemView adExpandMenuItemView2 = (AdExpandMenuItemView) findViewById(R$id.about);
        this.c = adExpandMenuItemView2;
        adExpandMenuItemView2.setData(AdExpandMenuItemView.Type.ADVERTISER_INFO);
        AdExpandMenuItemView adExpandMenuItemView3 = (AdExpandMenuItemView) findViewById(R$id.copy_link);
        this.d = adExpandMenuItemView3;
        adExpandMenuItemView3.setData(AdExpandMenuItemView.Type.COPY_LINK);
    }

    protected void setAdvertiserName(String str) {
        this.a.setText(str);
    }

    public void setListener(d dVar) {
        this.e = dVar;
        this.b.setOnClickListener(new a(dVar));
        this.c.setOnClickListener(new b(dVar));
        this.d.setOnClickListener(new c(dVar));
    }
}
