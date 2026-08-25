package com.tn.tranpay.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.m;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.lifecycle.y0;
import com.tn.lib.tranpay.R;
import com.tn.tranpay.BillingParams;
import com.tn.tranpay.bean.InputInfoBean;
import com.tn.tranpay.bean.LoadConfigContent;
import com.tn.tranpay.viewmodel.PaymentViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.o0;

@Metadata(d1 = {"\u0000\u008b\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001\u0016\u0018\u0000 n2\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J1\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0003J\u000f\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0003J\u000f\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0003J)\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001f\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0004H\u0002¢\u0006\u0004\b!\u0010\u0003J-\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010#\u001a\u00020\"2\b\u0010%\u001a\u0004\u0018\u00010$2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0004\b)\u0010*J!\u0010,\u001a\u00020\u00042\u0006\u0010+\u001a\u00020(2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0004\b,\u0010-R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00104\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00107\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\"\u0010>\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R(\u0010G\u001a\b\u0012\u0004\u0012\u00020@0?8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010M\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u00103\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\"\u0010Q\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u00103\u001a\u0004\bO\u0010J\"\u0004\bP\u0010LR$\u0010U\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bR\u00103\u001a\u0004\bS\u0010J\"\u0004\bT\u0010LR$\u0010Y\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u00103\u001a\u0004\bW\u0010J\"\u0004\bX\u0010LR\u0016\u0010]\u001a\u00020Z8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b[\u0010\\R\u001b\u0010c\u001a\u00020^8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b_\u0010`\u001a\u0004\ba\u0010bR*\u0010k\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u0016\u0010m\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u00109¨\u0006o"}, d2 = {"Lcom/tn/tranpay/fragment/PaySubFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "", "t0", "", "inputType", "Landroidx/appcompat/widget/AppCompatEditText;", "inputView", "Landroidx/appcompat/widget/AppCompatTextView;", "errorView", "value", "j0", "(Ljava/lang/String;Landroidx/appcompat/widget/AppCompatEditText;Landroidx/appcompat/widget/AppCompatTextView;Ljava/lang/String;)V", "s0", "n0", "q0", "k0", "Landroidx/appcompat/widget/AppCompatImageView;", "clearButton", "regex", "com/tn/tranpay/fragment/PaySubFragment$b", "g0", "(Landroidx/appcompat/widget/AppCompatImageView;Landroidx/appcompat/widget/AppCompatTextView;Ljava/lang/String;)Lcom/tn/tranpay/fragment/PaySubFragment$b;", "text", "", "x0", "(Ljava/lang/String;Ljava/lang/String;)Z", "Lcom/tn/tranpay/bean/LoadConfigContent;", "info", "l0", "(Lcom/tn/tranpay/bean/LoadConfigContent;)V", "w0", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/tn/tranpay/BillingParams;", "a", "Lcom/tn/tranpay/BillingParams;", "paymentParams", "b", "Ljava/lang/String;", "mobileCode", "c", "Lcom/tn/tranpay/bean/LoadConfigContent;", "configBean", "d", "Z", "getNeedCnic", "()Z", "setNeedCnic", "(Z)V", "needCnic", "", "Lcom/tn/tranpay/bean/InputInfoBean;", "e", "Ljava/util/List;", "getInputs", "()Ljava/util/List;", "setInputs", "(Ljava/util/List;)V", "inputs", "f", "getPayMethod", "()Ljava/lang/String;", "setPayMethod", "(Ljava/lang/String;)V", "payMethod", "g", "h0", "setPayMethodCode", "payMethodCode", "h", "getPhone", "setPhone", "phone", "i", "getCnic", "setCnic", "cnic", "Lrg/b;", "j", "Lrg/b;", "viewBinding", "Lcom/tn/tranpay/viewmodel/PaymentViewModel;", "k", "Lkotlin/Lazy;", "i0", "()Lcom/tn/tranpay/viewmodel/PaymentViewModel;", "viewModel", "Lkotlin/Function0;", "l", "Lkotlin/jvm/functions/Function0;", "getOnFragmentPopped", "()Lkotlin/jvm/functions/Function0;", "m0", "(Lkotlin/jvm/functions/Function0;)V", "onFragmentPopped", "m", "isPayable", "n", "lib_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class PaySubFragment extends Fragment {

    /* renamed from: n, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    private BillingParams paymentParams;

    /* renamed from: b, reason: from kotlin metadata */
    private String mobileCode;

    /* renamed from: c, reason: from kotlin metadata */
    private LoadConfigContent configBean;

    /* renamed from: d, reason: from kotlin metadata */
    private boolean needCnic;

    /* renamed from: e, reason: from kotlin metadata */
    private List inputs;

    /* renamed from: f, reason: from kotlin metadata */
    private String payMethod;

    /* renamed from: g, reason: from kotlin metadata */
    private String payMethodCode;

    /* renamed from: h, reason: from kotlin metadata */
    private String phone;

    /* renamed from: i, reason: from kotlin metadata */
    private String cnic;

    /* renamed from: j, reason: from kotlin metadata */
    private rg.b viewBinding;

    /* renamed from: k, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: l, reason: from kotlin metadata */
    private Function0 onFragmentPopped;

    /* renamed from: m, reason: from kotlin metadata */
    private boolean isPayable;

    /* renamed from: com.tn.tranpay.fragment.PaySubFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PaySubFragment a(BillingParams billingParams, LoadConfigContent loadConfigContent, boolean z, List list, String str, String str2, String str3, String str4) {
            Intrinsics.h(billingParams, "params");
            Intrinsics.h(list, "inputs");
            Intrinsics.h(str, "payMethod");
            Intrinsics.h(str2, "payMethodCode");
            PaySubFragment paySubFragment = new PaySubFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("paymentParams", billingParams);
            bundle.putParcelable("configBean", loadConfigContent);
            bundle.putBoolean("needCnic", z);
            bundle.putParcelableArrayList("inputs", new ArrayList<>(list));
            bundle.putString("payMethod", str);
            bundle.putString("payMethodCode", str2);
            bundle.putString("phone", str3);
            bundle.putString("cnic", str4);
            paySubFragment.setArguments(bundle);
            return paySubFragment;
        }
    }

    public static final class b implements TextWatcher {
        final /* synthetic */ AppCompatImageView a;
        final /* synthetic */ PaySubFragment b;
        final /* synthetic */ String c;
        final /* synthetic */ AppCompatTextView d;

        b(AppCompatImageView appCompatImageView, PaySubFragment paySubFragment, String str, AppCompatTextView appCompatTextView) {
            this.a = appCompatImageView;
            this.b = paySubFragment;
            this.c = str;
            this.d = appCompatTextView;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            this.d.setVisibility(this.b.x0(this.c, String.valueOf(editable)) ? 8 : 0);
            this.b.w0();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.a.setVisibility((charSequence == null || charSequence.length() == 0) ? 8 : 0);
        }
    }

    public PaySubFragment() {
        super(R.layout.tran_fragment_sub_layout);
        this.inputs = CollectionsKt.l();
        this.payMethod = "";
        this.payMethodCode = "";
        final Function0<y0> function0 = new Function0<y0>() { // from class: com.tn.tranpay.fragment.PaySubFragment$viewModel$2
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final y0 m138invoke() {
                Fragment requireParentFragment = PaySubFragment.this.requireParentFragment();
                Intrinsics.g(requireParentFragment, "requireParentFragment()");
                return requireParentFragment;
            }
        };
        this.viewModel = FragmentViewModelLazyKt.a(this, Reflection.b(PaymentViewModel.class), new Function0<x0>() { // from class: com.tn.tranpay.fragment.PaySubFragment$special$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final x0 m136invoke() {
                x0 viewModelStore = ((y0) function0.invoke()).getViewModelStore();
                Intrinsics.g(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.tn.tranpay.fragment.PaySubFragment$special$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final v0.c m137invoke() {
                Object invoke = function0.invoke();
                m mVar = invoke instanceof m ? (m) invoke : null;
                v0.c defaultViewModelProviderFactory = mVar != null ? mVar.getDefaultViewModelProviderFactory() : null;
                if (defaultViewModelProviderFactory == null) {
                    defaultViewModelProviderFactory = this.getDefaultViewModelProviderFactory();
                }
                Intrinsics.g(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.isPayable = true;
    }

    private final b g0(AppCompatImageView clearButton, AppCompatTextView errorView, String regex) {
        return new b(clearButton, this, regex, errorView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PaymentViewModel i0() {
        return (PaymentViewModel) this.viewModel.getValue();
    }

    private final void j0(String inputType, AppCompatEditText inputView, AppCompatTextView errorView, String value) {
        Object obj;
        Iterator it = this.inputs.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (Intrinsics.c(((InputInfoBean) obj).getType(), inputType)) {
                    break;
                }
            }
        }
        InputInfoBean inputInfoBean = (InputInfoBean) obj;
        if (inputInfoBean != null) {
            if (x0(inputInfoBean.getReg(), value)) {
                if (value == null) {
                    value = "";
                }
                inputView.setText(value);
            }
            inputView.setHint(inputInfoBean.getRealHint());
            errorView.setText(inputInfoBean.getRealTips());
        }
    }

    private final void k0() {
        Function0 function0 = this.onFragmentPopped;
        if (function0 != null) {
            function0.invoke();
        }
        getParentFragmentManager().g1();
    }

    private final void l0(LoadConfigContent info) {
        if (info != null) {
            rg.b bVar = this.viewBinding;
            if (bVar == null) {
                Intrinsics.y("viewBinding");
                bVar = null;
            }
            bVar.k.setText(info.getCpName());
            AppCompatTextView appCompatTextView = bVar.f;
            Context context = getContext();
            appCompatTextView.setText(context != null ? context.getString(R.string.pay_amount, info.getSymbol()) : null);
            AppCompatTextView appCompatTextView2 = bVar.l;
            Context context2 = getContext();
            appCompatTextView2.setText(context2 != null ? context2.getString(R.string.pay_desc, info.getSymbol(), info.getCpName()) : null);
            AppCompatTextView appCompatTextView3 = bVar.o;
            Context context3 = getContext();
            appCompatTextView3.setText(context3 != null ? context3.getString(R.string.pay_order, info.getOrderId()) : null);
        }
    }

    private final void n0() {
        final rg.b bVar = this.viewBinding;
        if (bVar == null) {
            Intrinsics.y("viewBinding");
            bVar = null;
        }
        bVar.c.setOnClickListener(new View.OnClickListener() { // from class: com.tn.tranpay.fragment.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PaySubFragment.o0(bVar, view);
            }
        });
        bVar.b.setOnClickListener(new View.OnClickListener() { // from class: com.tn.tranpay.fragment.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PaySubFragment.p0(bVar, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(rg.b bVar, View view) {
        Intrinsics.h(bVar, "$this_apply");
        Editable text = bVar.e.getText();
        if (text != null) {
            text.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(rg.b bVar, View view) {
        Intrinsics.h(bVar, "$this_apply");
        Editable text = bVar.d.getText();
        if (text != null) {
            text.clear();
        }
    }

    private final void q0() {
        rg.b bVar = this.viewBinding;
        if (bVar == null) {
            Intrinsics.y("viewBinding");
            bVar = null;
        }
        bVar.p.setOnClickListener(new View.OnClickListener() { // from class: com.tn.tranpay.fragment.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PaySubFragment.r0(PaySubFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(PaySubFragment paySubFragment, View view) {
        Intrinsics.h(paySubFragment, "this$0");
        kotlinx.coroutines.i.d(o0.a(kotlinx.coroutines.y0.c()), (CoroutineContext) null, (CoroutineStart) null, new PaySubFragment$setupPayButtonListener$1$1(paySubFragment, null), 3, (Object) null);
    }

    private final void s0() {
        Object obj;
        Object obj2;
        rg.b bVar = this.viewBinding;
        if (bVar == null) {
            Intrinsics.y("viewBinding");
            bVar = null;
        }
        AppCompatEditText appCompatEditText = bVar.e;
        AppCompatImageView appCompatImageView = bVar.c;
        Intrinsics.g(appCompatImageView, "clearPhoneButton");
        AppCompatTextView appCompatTextView = bVar.n;
        Intrinsics.g(appCompatTextView, "ivInputPhoneError");
        Iterator it = this.inputs.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (Intrinsics.c(((InputInfoBean) obj).getType(), "Phone")) {
                    break;
                }
            }
        }
        InputInfoBean inputInfoBean = (InputInfoBean) obj;
        appCompatEditText.addTextChangedListener(g0(appCompatImageView, appCompatTextView, inputInfoBean != null ? inputInfoBean.getReg() : null));
        AppCompatEditText appCompatEditText2 = bVar.d;
        AppCompatImageView appCompatImageView2 = bVar.b;
        Intrinsics.g(appCompatImageView2, "clearCnicButton");
        AppCompatTextView appCompatTextView2 = bVar.m;
        Intrinsics.g(appCompatTextView2, "ivInputCnicError");
        Iterator it2 = this.inputs.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj2 = null;
                break;
            } else {
                obj2 = it2.next();
                if (Intrinsics.c(((InputInfoBean) obj2).getType(), "CNIC")) {
                    break;
                }
            }
        }
        InputInfoBean inputInfoBean2 = (InputInfoBean) obj2;
        appCompatEditText2.addTextChangedListener(g0(appCompatImageView2, appCompatTextView2, inputInfoBean2 != null ? inputInfoBean2.getReg() : null));
    }

    private final void t0() {
        rg.b bVar = this.viewBinding;
        if (bVar == null) {
            Intrinsics.y("viewBinding");
            bVar = null;
        }
        bVar.h.setOnClickListener(new View.OnClickListener() { // from class: com.tn.tranpay.fragment.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PaySubFragment.u0(PaySubFragment.this, view);
            }
        });
        bVar.g.setOnClickListener(new View.OnClickListener() { // from class: com.tn.tranpay.fragment.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PaySubFragment.v0(PaySubFragment.this, view);
            }
        });
        bVar.i.setVisibility(this.needCnic ? 0 : 8);
        AppCompatTextView appCompatTextView = bVar.r;
        Context context = getContext();
        appCompatTextView.setText(context != null ? context.getString(R.string.pay_phone_code, this.mobileCode) : null);
        AppCompatTextView appCompatTextView2 = bVar.q;
        Context context2 = getContext();
        appCompatTextView2.setText(context2 != null ? context2.getString(R.string.pay_method, this.payMethod) : null);
        AppCompatEditText appCompatEditText = bVar.e;
        Intrinsics.g(appCompatEditText, "inputPhone");
        AppCompatTextView appCompatTextView3 = bVar.n;
        Intrinsics.g(appCompatTextView3, "ivInputPhoneError");
        j0("Phone", appCompatEditText, appCompatTextView3, this.phone);
        AppCompatEditText appCompatEditText2 = bVar.d;
        Intrinsics.g(appCompatEditText2, "inputCnic");
        AppCompatTextView appCompatTextView4 = bVar.m;
        Intrinsics.g(appCompatTextView4, "ivInputCnicError");
        j0("CNIC", appCompatEditText2, appCompatTextView4, this.cnic);
        w0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(PaySubFragment paySubFragment, View view) {
        Intrinsics.h(paySubFragment, "this$0");
        PayFragment parentFragment = paySubFragment.getParentFragment();
        PayFragment payFragment = parentFragment instanceof PayFragment ? parentFragment : null;
        if (payFragment != null) {
            payFragment.o0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(PaySubFragment paySubFragment, View view) {
        Intrinsics.h(paySubFragment, "this$0");
        paySubFragment.k0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0058, code lost:
    
        if (r5.m.getVisibility() != 0) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void w0() {
        boolean z;
        boolean z2;
        rg.b bVar;
        rg.b bVar2 = this.viewBinding;
        rg.b bVar3 = null;
        if (bVar2 == null) {
            Intrinsics.y("viewBinding");
            bVar2 = null;
        }
        Editable text = bVar2.e.getText();
        boolean z3 = false;
        if (text != null && text.length() != 0) {
            rg.b bVar4 = this.viewBinding;
            if (bVar4 == null) {
                Intrinsics.y("viewBinding");
                bVar4 = null;
            }
            if (bVar4.n.getVisibility() != 0) {
                z = true;
                if (this.needCnic) {
                    rg.b bVar5 = this.viewBinding;
                    if (bVar5 == null) {
                        Intrinsics.y("viewBinding");
                        bVar5 = null;
                    }
                    Editable text2 = bVar5.d.getText();
                    if (text2 != null && text2.length() != 0) {
                        rg.b bVar6 = this.viewBinding;
                        if (bVar6 == null) {
                            Intrinsics.y("viewBinding");
                            bVar6 = null;
                        }
                    }
                    z2 = false;
                    bVar = this.viewBinding;
                    if (bVar == null) {
                        Intrinsics.y("viewBinding");
                    } else {
                        bVar3 = bVar;
                    }
                    AppCompatTextView appCompatTextView = bVar3.p;
                    if (z && z2) {
                        z3 = true;
                    }
                    appCompatTextView.setEnabled(z3);
                }
                z2 = true;
                bVar = this.viewBinding;
                if (bVar == null) {
                }
                AppCompatTextView appCompatTextView2 = bVar3.p;
                if (z) {
                    z3 = true;
                }
                appCompatTextView2.setEnabled(z3);
            }
        }
        z = false;
        if (this.needCnic) {
        }
        z2 = true;
        bVar = this.viewBinding;
        if (bVar == null) {
        }
        AppCompatTextView appCompatTextView22 = bVar3.p;
        if (z) {
        }
        appCompatTextView22.setEnabled(z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean x0(String regex, String text) {
        return (regex != null && new Regex(regex).matches(String.valueOf(text))) || text == null || text.length() == 0;
    }

    /* renamed from: h0, reason: from getter */
    public final String getPayMethodCode() {
        return this.payMethodCode;
    }

    public final void m0(Function0 function0) {
        this.onFragmentPopped = function0;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.h(inflater, "inflater");
        return inflater.inflate(R.layout.tran_fragment_sub_layout, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super.onViewCreated(view, savedInstanceState);
        rg.b a = rg.b.a(view);
        Intrinsics.g(a, "bind(view)");
        this.viewBinding = a;
        Bundle arguments = getArguments();
        BillingParams billingParams = arguments != null ? (BillingParams) arguments.getParcelable("paymentParams") : null;
        if (billingParams == null) {
            return;
        }
        this.paymentParams = billingParams;
        Bundle arguments2 = getArguments();
        this.configBean = arguments2 != null ? (LoadConfigContent) arguments2.getParcelable("configBean") : null;
        Bundle arguments3 = getArguments();
        this.needCnic = arguments3 != null ? arguments3.getBoolean("needCnic") : false;
        Bundle arguments4 = getArguments();
        List parcelableArrayList = arguments4 != null ? arguments4.getParcelableArrayList("inputs") : null;
        if (parcelableArrayList == null) {
            parcelableArrayList = CollectionsKt.l();
        }
        this.inputs = parcelableArrayList;
        Bundle arguments5 = getArguments();
        String string = arguments5 != null ? arguments5.getString("payMethod") : null;
        if (string == null) {
            string = "";
        }
        this.payMethod = string;
        Bundle arguments6 = getArguments();
        String string2 = arguments6 != null ? arguments6.getString("payMethodCode") : null;
        this.payMethodCode = string2 != null ? string2 : "";
        Bundle arguments7 = getArguments();
        this.phone = arguments7 != null ? arguments7.getString("phone") : null;
        Bundle arguments8 = getArguments();
        this.cnic = arguments8 != null ? arguments8.getString("cnic") : null;
        this.mobileCode = i0().m();
        t0();
        s0();
        n0();
        q0();
        if (isAdded()) {
            l0(this.configBean);
        }
        com.tn.tranpay.report.h.a.l("sub_tab_page");
    }
}
