package ro;

import android.app.Dialog;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import com.blankj.utilcode.util.KeyboardUtils;
import com.tencent.mmkv.MMKV;
import com.transsion.gslb.BuildConfig;
import com.transsion.publish.R$drawable;
import com.transsion.publish.R$id;
import com.transsion.publish.R$string;
import com.transsion.publish.view.LinkEditText;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mo.b;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class j implements TextWatcher {
    private final boolean a;
    private LinkEditText b;
    private TextView c;
    private TextView d;
    private View e;
    private RelativeLayout f;
    private View g;
    private View h;
    private ro.b i;
    private Dialog j;
    private MMKV k;
    private boolean l;
    private b.InterfaceC0085b m;
    private View n;
    private final InputFilter.LengthFilter o;

    public static final class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                RelativeLayout relativeLayout = j.this.f;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(4);
                    return;
                }
                return;
            }
            RelativeLayout relativeLayout2 = j.this.f;
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(0);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public static final class b extends InputFilter.LengthFilter {
        b() {
            super(1000);
        }

        @Override // android.text.InputFilter.LengthFilter, android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length;
            if (charSequence != null) {
                try {
                    length = charSequence.length();
                } catch (Exception unused) {
                }
            } else {
                length = 0;
            }
            if (length + (spanned != null ? spanned.length() : 0) > getMax()) {
                fh.b.a.d(R$string.comment_max_tips);
            }
            return charSequence;
        }
    }

    public j() {
        this(null, null, null, null, false, 31, null);
    }

    public j(View view, Dialog dialog, b.InterfaceC0085b interfaceC0085b, View view2, boolean z) {
        AppCompatEditText appCompatEditText;
        View view3;
        this.a = z;
        this.m = interfaceC0085b;
        this.n = view2;
        this.l = true;
        if (view != null) {
            this.b = (LinkEditText) view.findViewById(R$id.comment_input_edit_text);
            this.e = view.findViewById(R$id.tv_add);
            this.d = (TextView) view.findViewById(R$id.tv_cancel);
            this.g = view.findViewById(R$id.comment_input_disable_click);
            this.c = (TextView) view.findViewById(R$id.tv_hint);
            this.f = (RelativeLayout) view.findViewById(R$id.rl_clear);
        }
        this.j = dialog;
        if (dialog != null) {
            this.b = (LinkEditText) dialog.findViewById(R$id.comment_input_edit_text);
            this.e = dialog.findViewById(R$id.tv_add);
            this.c = (TextView) dialog.findViewById(R$id.tv_hint);
            this.d = (TextView) dialog.findViewById(R$id.tv_cancel);
            this.f = (RelativeLayout) dialog.findViewById(R$id.rl_clear);
            this.h = dialog.findViewById(R$id.comment_input_layout);
        }
        AppCompatEditText appCompatEditText2 = this.b;
        if (appCompatEditText2 != null) {
            appCompatEditText2.setEnabled(z);
            appCompatEditText2.setSingleLine(!z);
            appCompatEditText2.setClickable(!z);
            if (appCompatEditText2.isEnabled()) {
                appCompatEditText2.setMaxLines(4);
            }
        }
        if (z && (view3 = this.e) != null) {
            view3.setVisibility(0);
        }
        AppCompatEditText appCompatEditText3 = this.b;
        if (appCompatEditText3 != null) {
            KeyboardUtils.i(appCompatEditText3);
        }
        try {
            MMKV I = MMKV.I("kv_link_record");
            this.k = I;
            CharSequence string = I != null ? I.getString("link", BuildConfig.FLAVOR) : null;
            if (!TextUtils.isEmpty(string) && (appCompatEditText = this.b) != null) {
                appCompatEditText.setText(string);
            }
        } catch (Exception unused) {
        }
        this.o = new b();
    }

    public /* synthetic */ j(View view, Dialog dialog, b.InterfaceC0085b interfaceC0085b, View view2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : view, (i & 2) != 0 ? null : dialog, (i & 4) != 0 ? null : interfaceC0085b, (i & 8) == 0 ? view2 : null, (i & 16) != 0 ? false : z);
    }

    private final ro.a h() {
        ro.b bVar = this.i;
        if (bVar != null) {
            return bVar.a();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(final j jVar, View view, boolean z) {
        AppCompatEditText appCompatEditText;
        view.dispatchWindowFocusChanged(z);
        if (z) {
            LinkEditText linkEditText = jVar.b;
            if (!TextUtils.isEmpty(linkEditText != null ? linkEditText.getText() : null) || (appCompatEditText = jVar.b) == null) {
                return;
            }
            appCompatEditText.post(new Runnable() { // from class: ro.i
                @Override // java.lang.Runnable
                public final void run() {
                    j.m(j.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(j jVar) {
        AppCompatEditText appCompatEditText = jVar.b;
        if (appCompatEditText != null) {
            appCompatEditText.setText(BuildConfig.FLAVOR);
        }
        AppCompatEditText appCompatEditText2 = jVar.b;
        if (appCompatEditText2 != null) {
            appCompatEditText2.setSelection(0);
        }
        AppCompatEditText appCompatEditText3 = jVar.b;
        if (appCompatEditText3 != null) {
            appCompatEditText3.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(j jVar) {
        b.InterfaceC0085b interfaceC0085b = jVar.m;
        if (interfaceC0085b != null) {
            interfaceC0085b.completeLoad();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(j jVar, View view) {
        LinkEditText linkEditText = jVar.b;
        jVar.s(String.valueOf(linkEditText != null ? linkEditText.getText() : null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(j jVar, View view) {
        LinkEditText linkEditText = jVar.b;
        String valueOf = String.valueOf(linkEditText != null ? linkEditText.getText() : null);
        MMKV mmkv = jVar.k;
        if (mmkv != null) {
            mmkv.putString("link", valueOf);
        }
        jVar.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(j jVar, View view) {
        AppCompatEditText appCompatEditText = jVar.b;
        if (appCompatEditText != null) {
            appCompatEditText.setText(BuildConfig.FLAVOR);
        }
        AppCompatEditText appCompatEditText2 = jVar.b;
        if (appCompatEditText2 != null) {
            appCompatEditText2.requestFocus();
        }
        AppCompatEditText appCompatEditText3 = jVar.b;
        if (appCompatEditText3 != null) {
            appCompatEditText3.setSelection(0);
        }
    }

    private final int r() {
        ro.b bVar = this.i;
        if (bVar != null) {
            return bVar.c();
        }
        return 10;
    }

    private final void s(String str) {
        if (TextUtils.isEmpty(StringsKt.n1(str).toString()) || str.length() < 5) {
            com.tn.lib.widget.toast.core.h.a.k(R$string.post_link_hint);
            return;
        }
        String substring = str.substring(0, 5);
        Intrinsics.g(substring, "substring(...)");
        if (!StringsKt.c0(substring, "http", false, 2, (Object) null) && !StringsKt.c0(substring, "https", false, 2, (Object) null) && !StringsKt.c0(substring, "www.", false, 2, (Object) null)) {
            com.tn.lib.widget.toast.core.h.a.k(R$string.post_link_hint);
            return;
        }
        if (!StringsKt.c0(str, "http:", false, 2, (Object) null) && !StringsKt.c0(str, "https:", false, 2, (Object) null)) {
            str = "https://" + str;
        }
        MMKV mmkv = this.k;
        if (mmkv != null) {
            mmkv.putString("link", BuildConfig.FLAVOR);
        }
        com.transsion.publish.c.a.a().g(str);
        i();
    }

    private final void t(int i) {
        v(i);
        u(i);
    }

    private final void u(int i) {
        if (i > r()) {
            fh.b.a.d(R$string.comment_max_tips);
        }
    }

    private final void v(int i) {
        View view = this.e;
        if (view != null) {
            boolean z = false;
            if (1 <= i && i <= r()) {
                z = true;
            }
            if (view.isSelected() != z) {
                view.setSelected(z);
            }
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        ro.a h = h();
        if (h != null) {
            h.afterTextChanged(editable);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        ro.a h = h();
        if (h != null) {
            h.beforeTextChanged(charSequence, i, i2, i3);
        }
    }

    public final void i() {
        this.n = null;
        AppCompatEditText appCompatEditText = this.b;
        if (appCompatEditText != null) {
            KeyboardUtils.e(appCompatEditText);
        }
        Dialog dialog = this.j;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public final View j() {
        return this.b;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [android.view.View, android.widget.EditText, android.widget.TextView, com.transsion.publish.view.LinkEditText] */
    public final void k(ro.b bVar) {
        AppCompatEditText appCompatEditText;
        Editable b2;
        this.i = bVar;
        ?? r4 = this.b;
        if (r4 != 0) {
            r4.addTextChangedListener(this);
            ro.b bVar2 = this.i;
            if (bVar2 != null && bVar2.d() != null) {
                r4.setText(BuildConfig.FLAVOR);
                r4.setSelection(0);
                t(0);
            }
            ro.b bVar3 = this.i;
            if (bVar3 != null && (b2 = bVar3.b()) != null) {
                r4.setText(b2);
                r4.setSelection(b2.length());
                t(b2.length());
            }
            r4.setMaxEms(r() * 2);
            if (this.a) {
                r4.requestFocus();
                r4.setCursorVisible(true);
                if (Build.VERSION.SDK_INT >= 29) {
                    r4.setTextCursorDrawable(androidx.core.content.b.getDrawable(r4.getContext(), R$drawable.comment_edit_cursor));
                }
            }
            InputFilter[] filters = r4.getFilters();
            Intrinsics.g(filters, "getFilters(...)");
            List J0 = ArraysKt.J0(filters);
            J0.add(0, this.o);
            r4.setFilters((InputFilter[]) J0.toArray(new InputFilter[0]));
        }
        View view = this.e;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: ro.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    j.o(j.this, view2);
                }
            });
        }
        TextView textView = this.d;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: ro.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    j.p(j.this, view2);
                }
            });
        }
        RelativeLayout relativeLayout = this.f;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: ro.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    j.q(j.this, view2);
                }
            });
        }
        LinkEditText linkEditText = this.b;
        CharSequence text = linkEditText != null ? linkEditText.getText() : null;
        if (!TextUtils.isEmpty(text) && (appCompatEditText = this.b) != null) {
            appCompatEditText.setText(text);
        }
        AppCompatEditText appCompatEditText2 = this.b;
        if (appCompatEditText2 != null) {
            appCompatEditText2.addTextChangedListener(new a());
        }
        AppCompatEditText appCompatEditText3 = this.b;
        if (appCompatEditText3 != null) {
            appCompatEditText3.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: ro.g
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view2, boolean z) {
                    j.l(j.this, view2, z);
                }
            });
        }
        AppCompatEditText appCompatEditText4 = this.b;
        if (appCompatEditText4 != null) {
            appCompatEditText4.requestFocus();
        }
        AppCompatEditText appCompatEditText5 = this.b;
        if (appCompatEditText5 != null) {
            appCompatEditText5.setSelection(text != null ? text.length() : 0);
        }
        AppCompatEditText appCompatEditText6 = this.b;
        if (appCompatEditText6 != null) {
            appCompatEditText6.postDelayed(new Runnable() { // from class: ro.h
                @Override // java.lang.Runnable
                public final void run() {
                    j.n(j.this);
                }
            }, 1000L);
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        t(charSequence != null ? charSequence.length() : 0);
        if (this.a) {
            ro.a h = h();
            if (h != null) {
                h.onTextChanged(charSequence, i, i2, i3);
                return;
            }
            return;
        }
        View view = this.e;
        if (view != null) {
            view.setVisibility((charSequence != null ? charSequence.length() : 0) <= 0 ? 8 : 0);
        }
    }
}
