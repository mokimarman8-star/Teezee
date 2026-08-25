package com.transsion.rewardscenter.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import androidx.activity.result.ActivityResult;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.therouter.TheRouter;
import com.transsion.gslb.BuildConfig;
import com.transsion.rewardscenter.R$string;
import com.transsion.rewardscenterapi.SkuPoint;
import com.transsion.rewardscenterapi.TopUpType;
import com.transsnet.loginapi.bean.Country;
import java.io.Serializable;
import java.math.BigDecimal;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import wf.a;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 .2\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0003J\u0019\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J+\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00162\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001c\u0010\u0003R\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\"\u0010*\u001a\u0010\u0012\f\u0012\n '*\u0004\u0018\u00010&0&0%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010-\u001a\u00020\u001d8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,¨\u00060"}, d2 = {"Lcom/transsion/rewardscenter/ui/PhoneBottomSheetFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", BuildConfig.FLAVOR, "s0", "v0", "t0", "n0", BuildConfig.FLAVOR, "setCursor", "j0", "(Z)V", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "Lyo/e;", "b", "Lyo/e;", "_binding", "Lcom/transsnet/loginapi/bean/Country;", "c", "Lcom/transsnet/loginapi/bean/Country;", "country", "Landroidx/activity/result/b;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "d", "Landroidx/activity/result/b;", "countryPickerLauncher", "m0", "()Lyo/e;", "binding", "e", "a", "RewardsCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PhoneBottomSheetFragment extends BottomSheetDialogFragment {

    /* renamed from: e, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int f = 8;

    /* renamed from: b, reason: from kotlin metadata */
    private yo.e _binding;

    /* renamed from: c, reason: from kotlin metadata */
    private Country country = new Country();

    /* renamed from: d, reason: from kotlin metadata */
    private final androidx.activity.result.b countryPickerLauncher;

    /* renamed from: com.transsion.rewardscenter.ui.PhoneBottomSheetFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PhoneBottomSheetFragment a(TopUpType topUpType, SkuPoint skuPoint) {
            Intrinsics.h(topUpType, "topUpType");
            PhoneBottomSheetFragment phoneBottomSheetFragment = new PhoneBottomSheetFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("source", topUpType.getValue());
            bundle.putSerializable("sku_point", skuPoint);
            phoneBottomSheetFragment.setArguments(bundle);
            return phoneBottomSheetFragment;
        }
    }

    public static final class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            PhoneBottomSheetFragment.k0(PhoneBottomSheetFragment.this, false, 1, null);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public PhoneBottomSheetFragment() {
        androidx.activity.result.b registerForActivityResult = registerForActivityResult(new f.j(), new androidx.activity.result.a() { // from class: com.transsion.rewardscenter.ui.o
            public final void a(Object obj) {
                PhoneBottomSheetFragment.l0(PhoneBottomSheetFragment.this, (ActivityResult) obj);
            }
        });
        Intrinsics.g(registerForActivityResult, "registerForActivityResult(...)");
        this.countryPickerLauncher = registerForActivityResult;
    }

    private final void j0(boolean setCursor) {
        Editable text = m0().c.getText();
        String obj = text != null ? text.toString() : null;
        if (obj == null) {
            obj = BuildConfig.FLAVOR;
        }
        boolean b2 = com.transsion.rewardscenter.utils.c.a.b(obj);
        m0().b.setEnabled(b2);
        m0().b.setAlpha(b2 ? 1.0f : 0.4f);
        AppCompatImageView appCompatImageView = m0().e;
        Intrinsics.g(appCompatImageView, "ivClear");
        appCompatImageView.setVisibility(obj.length() > 0 ? 0 : 8);
        if (setCursor) {
            m0().c.setSelection(obj.length());
        }
    }

    static /* synthetic */ void k0(PhoneBottomSheetFragment phoneBottomSheetFragment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        phoneBottomSheetFragment.j0(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(PhoneBottomSheetFragment phoneBottomSheetFragment, ActivityResult activityResult) {
        Intrinsics.h(activityResult, "result");
        if (activityResult.getResultCode() == -1) {
            Intent data = activityResult.getData();
            Serializable serializableExtra = data != null ? data.getSerializableExtra("countryCode") : null;
            Country country = serializableExtra instanceof Country ? (Country) serializableExtra : null;
            if (country != null) {
                phoneBottomSheetFragment.country = country;
                yo.e eVar = phoneBottomSheetFragment._binding;
                if (eVar == null) {
                    return;
                }
                eVar.j.setText("+" + country.getCode());
            }
        }
    }

    private final yo.e m0() {
        yo.e eVar = this._binding;
        Intrinsics.e(eVar);
        return eVar;
    }

    private final void n0() {
        m0().d.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.rewardscenter.ui.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhoneBottomSheetFragment.o0(PhoneBottomSheetFragment.this, view);
            }
        });
        m0().f.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.rewardscenter.ui.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhoneBottomSheetFragment.p0(PhoneBottomSheetFragment.this, view);
            }
        });
        m0().g.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.rewardscenter.ui.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhoneBottomSheetFragment.q0(PhoneBottomSheetFragment.this, view);
            }
        });
        m0().b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.rewardscenter.ui.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhoneBottomSheetFragment.r0(PhoneBottomSheetFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(PhoneBottomSheetFragment phoneBottomSheetFragment, View view) {
        phoneBottomSheetFragment.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(PhoneBottomSheetFragment phoneBottomSheetFragment, View view) {
        phoneBottomSheetFragment.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(PhoneBottomSheetFragment phoneBottomSheetFragment, View view) {
        phoneBottomSheetFragment.countryPickerLauncher.a(TheRouter.c("/loginapi/select_country").l(phoneBottomSheetFragment.requireContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(PhoneBottomSheetFragment phoneBottomSheetFragment, View view) {
        yo.e eVar = phoneBottomSheetFragment._binding;
        if (eVar == null) {
            return;
        }
        Editable text = eVar.c.getText();
        String obj = text != null ? text.toString() : null;
        if (obj == null) {
            obj = BuildConfig.FLAVOR;
        }
        if (StringsKt.q0(obj) || !com.transsion.rewardscenter.utils.c.a.b(obj)) {
            k0(phoneBottomSheetFragment, false, 1, null);
            return;
        }
        Bundle arguments = phoneBottomSheetFragment.getArguments();
        int i = arguments != null ? arguments.getInt("source") : TopUpType.BANNER.getValue();
        eVar.b.setEnabled(false);
        eVar.b.setAlpha(0.4f);
        phoneBottomSheetFragment.getParentFragmentManager().F1("phone_bottom_sheet_result", androidx.core.os.d.b(new Pair[]{TuplesKt.a("source", Integer.valueOf(i)), TuplesKt.a("cc", phoneBottomSheetFragment.country.getCode()), TuplesKt.a("iso", phoneBottomSheetFragment.country.getCountry_s()), TuplesKt.a("number", obj)}));
    }

    private final void s0() {
        Triple a = com.transsion.rewardscenter.utils.c.a.a();
        Country country = this.country;
        country.setCode((String) a.getFirst());
        country.setCountry_s((String) a.getSecond());
        a.a.f(wf.a.a, "RewardsCenter", "initCountry --> country: " + this.country, false, 4, (Object) null);
        if (this.country.getCode() != null && (!StringsKt.q0(r1))) {
            m0().j.setText("+" + this.country.getCode());
        }
        if (StringsKt.q0((CharSequence) a.getThird())) {
            return;
        }
        m0().c.setText((CharSequence) a.getThird());
    }

    private final void t0() {
        j0(true);
        AppCompatEditText appCompatEditText = m0().c;
        Intrinsics.g(appCompatEditText, "etPhone");
        appCompatEditText.addTextChangedListener(new b());
        m0().e.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.rewardscenter.ui.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhoneBottomSheetFragment.u0(PhoneBottomSheetFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(PhoneBottomSheetFragment phoneBottomSheetFragment, View view) {
        phoneBottomSheetFragment.m0().c.setText(BuildConfig.FLAVOR);
    }

    private final void v0() {
        Bundle arguments = getArguments();
        if ((arguments != null ? arguments.getInt("source") : TopUpType.BANNER.getValue()) == TopUpType.PHONE_CREDIT.getValue()) {
            AppCompatTextView appCompatTextView = m0().k;
            Intrinsics.g(appCompatTextView, "tvPrice");
            appCompatTextView.setVisibility(8);
            AppCompatTextView appCompatTextView2 = m0().m;
            Intrinsics.g(appCompatTextView2, "tvSubtitle");
            appCompatTextView2.setVisibility(8);
            m0().b.setText(getString(R$string.redeem_continue));
            return;
        }
        Bundle arguments2 = getArguments();
        Serializable serializable = arguments2 != null ? arguments2.getSerializable("sku_point") : null;
        SkuPoint skuPoint = serializable instanceof SkuPoint ? (SkuPoint) serializable : null;
        if (skuPoint == null) {
            AppCompatTextView appCompatTextView3 = m0().k;
            Intrinsics.g(appCompatTextView3, "tvPrice");
            appCompatTextView3.setVisibility(8);
            AppCompatTextView appCompatTextView4 = m0().m;
            Intrinsics.g(appCompatTextView4, "tvSubtitle");
            appCompatTextView4.setVisibility(8);
            return;
        }
        String currencySymbol = skuPoint.getCurrencySymbol();
        if (currencySymbol == null) {
            currencySymbol = BuildConfig.FLAVOR;
        }
        String plainString = com.cloud.hisavana.sdk.common.util.m0.a(new BigDecimal(String.valueOf(skuPoint.getPrice()))).toPlainString();
        m0().k.setText(currencySymbol + plainString);
        m0().m.setText(getString(R$string.payment_sheet_tips, new Object[]{currencySymbol + plainString}));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(com.google.android.material.bottomsheet.c cVar, DialogInterface dialogInterface) {
        View findViewById = cVar.findViewById(R.id.design_bottom_sheet);
        if (findViewById != null) {
            BottomSheetBehavior m0 = BottomSheetBehavior.m0(findViewById);
            m0.U0(3);
            m0.T0(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(PhoneBottomSheetFragment phoneBottomSheetFragment) {
        Context context;
        yo.e eVar = phoneBottomSheetFragment._binding;
        if (eVar == null || (context = phoneBottomSheetFragment.getContext()) == null) {
            return;
        }
        eVar.c.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) androidx.core.content.b.getSystemService(context, InputMethodManager.class);
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(eVar.c, 1);
        }
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        com.google.android.material.bottomsheet.c onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.f(onCreateDialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        final com.google.android.material.bottomsheet.c cVar = onCreateDialog;
        Window window = cVar.getWindow();
        if (window != null) {
            window.setSoftInputMode(16);
        }
        cVar.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.transsion.rewardscenter.ui.p
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                PhoneBottomSheetFragment.w0(cVar, dialogInterface);
            }
        });
        return cVar;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.h(inflater, "inflater");
        this._binding = yo.e.c(inflater, container, false);
        LinearLayoutCompat root = m0().getRoot();
        Intrinsics.g(root, "getRoot(...)");
        return root;
    }

    public void onDestroyView() {
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        this._binding = null;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(view, savedInstanceState);
        s0();
        v0();
        t0();
        n0();
        m0().c.post(new Runnable() { // from class: com.transsion.rewardscenter.ui.n
            @Override // java.lang.Runnable
            public final void run() {
                PhoneBottomSheetFragment.x0(PhoneBottomSheetFragment.this);
            }
        });
    }
}
