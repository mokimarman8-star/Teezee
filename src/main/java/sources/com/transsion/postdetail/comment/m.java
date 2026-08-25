package com.transsion.postdetail.comment;

import android.app.Application;
import android.app.Dialog;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.util.Linkify;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.blankj.utilcode.util.Utils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.flow.bean.CommentBean;
import com.transsion.gslb.BuildConfig;
import com.transsion.postdetail.R;
import com.transsion.postdetail.R$drawable;
import com.transsion.postdetail.R$id;
import com.transsion.publish.api.PhotoEntity;
import com.transsion.publish.ui.GalleryActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class m implements TextWatcher {
    private final SocialStatus a;
    private final boolean b;
    private AppCompatEditText c;
    private TextView d;
    private TextView e;
    private View f;
    private View g;
    private ProgressBar h;
    private LinearLayoutCompat i;
    private AppCompatTextView j;
    private AppCompatTextView k;
    private AppCompatTextView l;
    private AppCompatImageView m;
    private ShapeableImageView n;
    private ShapeableImageView o;
    private AppCompatImageView p;
    private vn.a q;
    private List r;
    private final InputFilter.LengthFilter s;

    public static final class a extends InputFilter.LengthFilter {
        a() {
            super(300);
        }

        @Override // android.text.InputFilter.LengthFilter, android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            if (charSequence != null) {
                try {
                    charSequence.length();
                } catch (Exception unused) {
                }
            }
            if (spanned != null) {
                spanned.length();
            }
            return charSequence;
        }
    }

    public m() {
        this(null, null, null, false, 15, null);
    }

    public m(View view, Dialog dialog, SocialStatus socialStatus, boolean z) {
        View view2;
        Intrinsics.h(socialStatus, "socialStatus");
        this.a = socialStatus;
        this.b = z;
        this.r = new ArrayList();
        if (view != null) {
            this.c = view.findViewById(R$id.comment_input_edit_text);
            this.d = (TextView) view.findViewById(R$id.comment_input_edit_limit);
            this.f = view.findViewById(R$id.comment_input_edit_post);
            this.g = view.findViewById(R$id.comment_input_disable_click);
            this.e = (TextView) view.findViewById(R$id.tv_hint);
            this.h = (ProgressBar) view.findViewById(R$id.progress_bar);
            this.i = view.findViewById(R$id.ll_tint);
            this.j = view.findViewById(R$id.tv_like);
            this.k = view.findViewById(R$id.tv_comment);
            this.l = view.findViewById(R$id.tv_share);
            this.m = view.findViewById(R$id.iv_download);
            this.n = view.findViewById(R$id.iv_choose_image);
            this.o = view.findViewById(R$id.iv_selected_image);
            this.p = view.findViewById(R$id.icon_delete_image);
            p(z);
        }
        if (dialog != null) {
            this.c = dialog.findViewById(R$id.comment_input_edit_text);
            this.d = (TextView) dialog.findViewById(R$id.comment_input_edit_limit);
            this.f = dialog.findViewById(R$id.comment_input_edit_post);
            this.e = (TextView) dialog.findViewById(R$id.tv_hint);
            this.h = (ProgressBar) dialog.findViewById(R$id.progress_bar);
            this.i = dialog.findViewById(R$id.ll_tint);
            this.j = dialog.findViewById(R$id.tv_like);
            this.k = dialog.findViewById(R$id.tv_comment);
            this.l = dialog.findViewById(R$id.tv_share);
            this.m = dialog.findViewById(R$id.iv_download);
            this.n = dialog.findViewById(R$id.iv_choose_image);
            this.o = dialog.findViewById(R$id.iv_selected_image);
            this.p = dialog.findViewById(R$id.icon_delete_image);
            p(z);
        }
        AppCompatEditText appCompatEditText = this.c;
        if (appCompatEditText != null) {
            appCompatEditText.setEnabled(z);
            appCompatEditText.setSingleLine(!z);
            appCompatEditText.setClickable(!z);
            if (appCompatEditText.isEnabled()) {
                appCompatEditText.setMaxLines(4);
            }
        }
        if (z) {
            TextView textView = this.d;
            if (textView != null) {
                textView.setVisibility(0);
            }
        } else {
            TextView textView2 = this.d;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
        }
        if (z && (view2 = this.f) != null) {
            view2.setVisibility(0);
        }
        this.s = new a();
    }

    public /* synthetic */ m(View view, Dialog dialog, SocialStatus socialStatus, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : view, (i & 2) != 0 ? null : dialog, (i & 4) != 0 ? new SocialStatus(true, true, true, true) : socialStatus, (i & 8) != 0 ? false : z);
    }

    private final void A(int i) {
        D(i);
        C(i);
    }

    private final void C(int i) {
        TextView textView = this.d;
        if (textView != null) {
            if (!this.b || i < 0) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                textView.setText(new SpannableStringBuilder(i + "/" + q()));
            }
        }
        if (i > q()) {
            fh.b.a.d(R.string.comment_max_tips);
        }
    }

    private final void D(int i) {
        View view = this.f;
        if (view != null) {
            boolean z = true;
            if ((1 > i || i > q()) && this.r.isEmpty()) {
                z = false;
            }
            if (view.isEnabled() != z) {
                view.setEnabled(z);
            }
        }
    }

    private final i0 e() {
        vn.a aVar = this.q;
        if (aVar != null) {
            return aVar.a();
        }
        return null;
    }

    private final void f() {
        Editable text;
        CharSequence n1;
        ShapeableImageView shapeableImageView = this.o;
        if (shapeableImageView != null) {
            shapeableImageView.setVisibility(8);
        }
        this.r.clear();
        AppCompatEditText appCompatEditText = this.c;
        D((appCompatEditText == null || (text = appCompatEditText.getText()) == null || (n1 = StringsKt.n1(text)) == null) ? 0 : n1.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(m mVar, View view) {
        AppCompatEditText appCompatEditText = mVar.c;
        mVar.r(appCompatEditText != null ? appCompatEditText.getText() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(m mVar, View view) {
        mVar.s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(m mVar, View view) {
        mVar.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(m mVar, View view) {
        com.transsion.publish.n.b.a().f(mVar.r);
        GalleryActivity.Companion companion = GalleryActivity.INSTANCE;
        Application a2 = Utils.a();
        Intrinsics.g(a2, "getApp(...)");
        companion.a(a2, mVar.r, 0, 4, 1);
    }

    private final void p(boolean z) {
        if (z) {
            LinearLayoutCompat linearLayoutCompat = this.i;
            if (linearLayoutCompat != null) {
                uf.c.g(linearLayoutCompat);
            }
            AppCompatTextView appCompatTextView = this.j;
            if (appCompatTextView != null) {
                uf.c.g(appCompatTextView);
            }
            AppCompatTextView appCompatTextView2 = this.l;
            if (appCompatTextView2 != null) {
                uf.c.g(appCompatTextView2);
            }
            AppCompatImageView appCompatImageView = this.m;
            if (appCompatImageView != null) {
                uf.c.g(appCompatImageView);
            }
            AppCompatEditText appCompatEditText = this.c;
            if (appCompatEditText != null) {
                uf.c.k(appCompatEditText);
                return;
            }
            return;
        }
        LinearLayoutCompat linearLayoutCompat2 = this.i;
        if (linearLayoutCompat2 != null) {
            uf.c.j(linearLayoutCompat2, this.a.getShowTint());
        }
        AppCompatTextView appCompatTextView3 = this.j;
        if (appCompatTextView3 != null) {
            uf.c.j(appCompatTextView3, this.a.getShowLike());
        }
        AppCompatTextView appCompatTextView4 = this.l;
        if (appCompatTextView4 != null) {
            uf.c.j(appCompatTextView4, this.a.getShowShare());
        }
        AppCompatImageView appCompatImageView2 = this.m;
        if (appCompatImageView2 != null) {
            uf.c.j(appCompatImageView2, this.a.getShowDownload());
        }
        AppCompatEditText appCompatEditText2 = this.c;
        if (appCompatEditText2 != null) {
            uf.c.g(appCompatEditText2);
        }
    }

    private final int q() {
        vn.a aVar = this.q;
        if (aVar != null) {
            return aVar.c();
        }
        return 10;
    }

    private final void r(Editable editable) {
        i0 e = e();
        if (e != null) {
            vn.a aVar = this.q;
            e.T(editable, aVar != null ? aVar.d() : null);
        }
    }

    private final void s() {
        i0 e = e();
        if (e != null) {
            e.F();
        }
    }

    public final void B() {
        AppCompatEditText appCompatEditText = this.c;
        if (appCompatEditText != null) {
            appCompatEditText.setMaxEms(q() * 2);
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        i0 e = e();
        if (e != null) {
            e.afterTextChanged(editable);
        }
        TextView textView = this.e;
        if (textView != null) {
            textView.setVisibility((editable == null || editable.length() == 0) ? 0 : 8);
        }
        if ((editable != null ? editable.length() : 0) >= 295) {
            TextView textView2 = this.d;
            if (textView2 != null) {
                textView2.setTextColor(com.blankj.utilcode.util.h.a(com.tn.lib.widget.R.color.error_50));
                return;
            }
            return;
        }
        TextView textView3 = this.d;
        if (textView3 != null) {
            textView3.setTextColor(com.blankj.utilcode.util.h.a(com.tn.lib.widget.R.color.text_02));
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        i0 e = e();
        if (e != null) {
            e.beforeTextChanged(charSequence, i, i2, i3);
        }
    }

    public final void g() {
        ProgressBar progressBar = this.h;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        View view = this.f;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public final Editable h() {
        AppCompatEditText appCompatEditText = this.c;
        if (appCompatEditText != null) {
            return appCompatEditText.getText();
        }
        return null;
    }

    public final CommentBean i() {
        vn.a aVar = this.q;
        if (aVar != null) {
            return aVar.d();
        }
        return null;
    }

    public final List j() {
        return this.r;
    }

    public final void k(vn.a aVar) {
        Editable b;
        CommentBean d;
        this.q = aVar;
        AppCompatEditText appCompatEditText = this.c;
        if (appCompatEditText != null) {
            appCompatEditText.addTextChangedListener(this);
            vn.a aVar2 = this.q;
            if ((aVar2 != null ? aVar2.d() : null) == null) {
                appCompatEditText.setText(BuildConfig.FLAVOR);
                appCompatEditText.setSelection(0);
                A(0);
                AppCompatEditText appCompatEditText2 = this.c;
                if (appCompatEditText2 != null) {
                    appCompatEditText2.setHint(appCompatEditText.getContext().getString(R.string.comment_hint_add));
                }
            }
            vn.a aVar3 = this.q;
            if (aVar3 != null && (d = aVar3.d()) != null) {
                appCompatEditText.setText(BuildConfig.FLAVOR);
                appCompatEditText.setSelection(0);
                A(0);
                AppCompatEditText appCompatEditText3 = this.c;
                if (appCompatEditText3 != null) {
                    appCompatEditText3.setHint(appCompatEditText.getContext().getString(R.string.comment_reply_to, d.getNickName()));
                }
            }
            vn.a aVar4 = this.q;
            if (aVar4 != null && (b = aVar4.b()) != null) {
                appCompatEditText.setText(b);
                appCompatEditText.setSelection(b.length());
                A(b.length());
            }
            appCompatEditText.setMaxEms(q() * 2);
            if (this.b) {
                appCompatEditText.requestFocus();
                appCompatEditText.setCursorVisible(true);
                if (Build.VERSION.SDK_INT >= 29) {
                    appCompatEditText.setTextCursorDrawable(androidx.core.content.b.getDrawable(appCompatEditText.getContext(), R$drawable.comment_edit_cursor));
                }
            }
            InputFilter[] filters = appCompatEditText.getFilters();
            Intrinsics.g(filters, "getFilters(...)");
            List J0 = ArraysKt.J0(filters);
            J0.add(0, this.s);
            appCompatEditText.setFilters((InputFilter[]) J0.toArray(new InputFilter[0]));
        }
        View view = this.f;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.comment.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    m.l(m.this, view2);
                }
            });
        }
        ShapeableImageView shapeableImageView = this.n;
        if (shapeableImageView != null) {
            shapeableImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.comment.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    m.m(m.this, view2);
                }
            });
        }
        AppCompatImageView appCompatImageView = this.p;
        if (appCompatImageView != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.comment.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    m.n(m.this, view2);
                }
            });
        }
        ShapeableImageView shapeableImageView2 = this.o;
        if (shapeableImageView2 != null) {
            shapeableImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.comment.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    m.o(m.this, view2);
                }
            });
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        A(charSequence != null ? charSequence.length() : 0);
        if (this.b) {
            i0 e = e();
            if (e != null) {
                e.onTextChanged(charSequence, i, i2, i3);
            }
        } else {
            View view = this.f;
            if (view != null) {
                view.setVisibility((charSequence != null ? charSequence.length() : 0) <= 0 ? 8 : 0);
            }
        }
        AppCompatEditText appCompatEditText = this.c;
        if (appCompatEditText != null) {
            Linkify.addLinks((TextView) appCompatEditText, 1);
        }
    }

    public final void t() {
        x(BuildConfig.FLAVOR);
        vn.a aVar = this.q;
        if (aVar != null) {
            aVar.e();
        }
        p(false);
    }

    public final void u() {
        this.r.clear();
        ShapeableImageView shapeableImageView = this.o;
        if (shapeableImageView != null) {
            shapeableImageView.setVisibility(8);
        }
    }

    public final void v(CommentBean commentBean) {
        vn.a aVar = this.q;
        if (aVar != null) {
            aVar.i(commentBean);
        }
    }

    public final void w(PhotoEntity photoEntity) {
        Editable text;
        CharSequence n1;
        Intrinsics.h(photoEntity, "photoEntity");
        ShapeableImageView shapeableImageView = this.o;
        if (shapeableImageView != null) {
            int i = 0;
            shapeableImageView.setVisibility(0);
            this.r.add(photoEntity);
            RequestManager with = Glide.with(shapeableImageView);
            String localPath = photoEntity.getLocalPath();
            if (localPath == null) {
                localPath = BuildConfig.FLAVOR;
            }
            RequestBuilder load = with.load(new File(localPath));
            ShapeableImageView shapeableImageView2 = this.o;
            Intrinsics.e(shapeableImageView2);
            load.into(shapeableImageView2);
            AppCompatEditText appCompatEditText = this.c;
            if (appCompatEditText != null && (text = appCompatEditText.getText()) != null && (n1 = StringsKt.n1(text)) != null) {
                i = n1.length();
            }
            D(i);
        }
    }

    public final void x(CharSequence charSequence) {
        AppCompatEditText appCompatEditText;
        if (this.b || (appCompatEditText = this.c) == null) {
            return;
        }
        appCompatEditText.setText(charSequence);
    }

    public final void y() {
        ProgressBar progressBar = this.h;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
        View view = this.f;
        if (view != null) {
            view.setVisibility(4);
        }
    }

    public final void z() {
        AppCompatEditText appCompatEditText = this.c;
        if (appCompatEditText != null) {
            appCompatEditText.removeTextChangedListener(this);
        }
        View view = this.f;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }
}
