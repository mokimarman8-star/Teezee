package com.transsion.usercenter.setting.labelsfeedback;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.usercenter.setting.labelsfeedback.model.FBContact;
import com.transsion.usercenter.setting.labelsfeedback.model.FbDataModel;
import com.transsnet.loginapi.bean.Country;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;
import xu.e0;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class h extends RecyclerView.Adapter {
    private final FbDataModel a;
    private final i b;
    private a c;

    public final class a extends RecyclerView.a0 {
        private final LinearLayout a;
        private final UCEditText b;
        private final AppCompatTextView c;
        private final ShapeableImageView d;
        private final AppCompatEditText e;
        private final AppCompatEditText f;
        final /* synthetic */ h g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(h hVar, e0 binding) {
            super(binding.getRoot());
            Intrinsics.h(binding, "binding");
            this.g = hVar;
            LinearLayout root = binding.getRoot();
            Intrinsics.g(root, "getRoot(...)");
            this.a = root;
            UCEditText editText = binding.d;
            Intrinsics.g(editText, "editText");
            this.b = editText;
            AppCompatTextView countTextView = binding.b;
            Intrinsics.g(countTextView, "countTextView");
            this.c = countTextView;
            ShapeableImageView imageView = binding.e;
            Intrinsics.g(imageView, "imageView");
            this.d = imageView;
            AppCompatEditText countryEditText = binding.c;
            Intrinsics.g(countryEditText, "countryEditText");
            this.e = countryEditText;
            AppCompatEditText phoneEditText = binding.f;
            Intrinsics.g(phoneEditText, "phoneEditText");
            this.f = phoneEditText;
        }

        public final AppCompatTextView f() {
            return this.c;
        }

        public final AppCompatEditText g() {
            return this.e;
        }

        public final UCEditText h() {
            return this.b;
        }

        public final ShapeableImageView i() {
            return this.d;
        }

        public final AppCompatEditText j() {
            return this.f;
        }

        public final LinearLayout k() {
            return this.a;
        }
    }

    public static final class b implements TextWatcher {
        final /* synthetic */ a a;
        final /* synthetic */ h b;

        public b(a aVar, h hVar) {
            this.a = aVar;
            this.b = hVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String obj;
            int length = editable != null ? editable.length() : 0;
            this.a.f().setText(length + "/" + Sdk$SDKError.Reason.BANNER_VIEW_INVALID_SIZE_VALUE);
            this.b.m().setContent((editable == null || (obj = editable.toString()) == null) ? null : StringsKt.n1(obj).toString());
            i l = this.b.l();
            if (l != null) {
                l.b(this.b);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public static final class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String str;
            FBContact contact = h.this.m().getContact();
            if (editable == null || (str = editable.toString()) == null) {
                str = HttpUrl.FRAGMENT_ENCODE_SET;
            }
            contact.setPhone(str);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public h(FbDataModel model, i iVar) {
        Intrinsics.h(model, "model");
        this.a = model;
        this.b = iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(h hVar, View view) {
        i iVar = hVar.b;
        if (iVar != null) {
            iVar.e(hVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(h hVar, View view) {
        i iVar = hVar.b;
        if (iVar != null) {
            iVar.a(hVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(h hVar, View view) {
        i iVar = hVar.b;
        if (iVar != null) {
            iVar.i(hVar);
        }
    }

    public int getItemCount() {
        return 1;
    }

    public final void j(Country country) {
        AppCompatEditText g;
        if (country != null) {
            this.a.getContact().setCountry(country);
            String str = country.getCountry_s() + " +" + country.getCode();
            a aVar = this.c;
            if (aVar == null || (g = aVar.g()) == null) {
                return;
            }
            g.setText(str);
        }
    }

    public final void k(String str) {
        AppCompatImageView i;
        i iVar;
        this.a.setImagePath(str);
        a aVar = this.c;
        if (aVar == null || (i = aVar.i()) == null || (iVar = this.b) == null) {
            return;
        }
        iVar.c(this, i);
    }

    public final i l() {
        return this.b;
    }

    public final FbDataModel m() {
        return this.a;
    }

    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, int i) {
        Intrinsics.h(holder, "holder");
        holder.k().setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.setting.labelsfeedback.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.o(h.this, view);
            }
        });
        holder.i().setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.setting.labelsfeedback.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.p(h.this, view);
            }
        });
        holder.f().setText("0/500");
        holder.h().addTextChangedListener(new b(holder, this));
        holder.g().setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.setting.labelsfeedback.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.q(h.this, view);
            }
        });
        holder.j().addTextChangedListener(new c());
        String content = this.a.getContent();
        if (content != null) {
            holder.h().setText(new SpannableStringBuilder(content));
        }
        k(this.a.getImagePath());
        j(this.a.getContact().getCountry());
        holder.j().setText(new SpannableStringBuilder(this.a.getContact().getPhone()));
    }

    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.h(parent, "parent");
        e0 c2 = e0.c(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.g(c2, "inflate(...)");
        a aVar = new a(this, c2);
        this.c = aVar;
        return aVar;
    }
}
