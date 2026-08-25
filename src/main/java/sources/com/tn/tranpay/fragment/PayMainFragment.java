package com.tn.tranpay.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.m;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.lifecycle.y0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cloud.tmc.miniapp.utils.toast.ToastStrategy;
import com.tn.lib.tranpay.R;
import com.tn.tranpay.BillingParams;
import com.tn.tranpay.bean.InputInfoBean;
import com.tn.tranpay.bean.LoadConfigContent;
import com.tn.tranpay.bean.MediumInputBean;
import com.tn.tranpay.fragment.PaySubFragment;
import com.tn.tranpay.helper.PaymentMMKV;
import com.tn.tranpay.viewmodel.PaymentViewModel;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 92\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\f2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u000f\u001a\u00020\u00062\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J3\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J3\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0019\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001e\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ!\u0010\"\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010!\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\b\"\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b+\u0010,R\u001b\u00103\u001a\u00020.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0016\u00105\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u0010\rR\u0018\u00108\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107¨\u0006:"}, d2 = {"Lcom/tn/tranpay/fragment/PayMainFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "g0", "(Landroidx/recyclerview/widget/RecyclerView;)V", "", "Lcom/tn/tranpay/bean/MediumInputBean;", "list", "", "Z", "(Ljava/util/List;)Z", "f0", "(Ljava/util/List;)V", "item", "Landroid/view/View;", "view", "", "phone", "cnic", "b0", "(Lcom/tn/tranpay/bean/MediumInputBean;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;)V", "needCnic", "c0", "(Lcom/tn/tranpay/bean/MediumInputBean;Ljava/lang/String;Ljava/lang/String;Z)V", "Lcom/tn/tranpay/bean/LoadConfigContent;", "configBean", "e0", "(Lcom/tn/tranpay/bean/LoadConfigContent;)V", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/tn/tranpay/BillingParams;", "a", "Lcom/tn/tranpay/BillingParams;", "paymentParams", "b", "Lcom/tn/tranpay/bean/LoadConfigContent;", "Lcom/tn/tranpay/adapter/b;", "c", "Lcom/tn/tranpay/adapter/b;", "payMethodAdapter", "Lcom/tn/tranpay/viewmodel/PaymentViewModel;", "d", "Lkotlin/Lazy;", "a0", "()Lcom/tn/tranpay/viewmodel/PaymentViewModel;", "viewModel", "e", "isPayable", "f", "Ljava/lang/String;", "usedMethodCode", "g", "lib_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class PayMainFragment extends Fragment {

    /* renamed from: g, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    private BillingParams paymentParams;

    /* renamed from: b, reason: from kotlin metadata */
    private LoadConfigContent configBean;

    /* renamed from: c, reason: from kotlin metadata */
    private com.tn.tranpay.adapter.b payMethodAdapter;

    /* renamed from: d, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: e, reason: from kotlin metadata */
    private boolean isPayable;

    /* renamed from: f, reason: from kotlin metadata */
    private String usedMethodCode;

    /* renamed from: com.tn.tranpay.fragment.PayMainFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PayMainFragment a(BillingParams billingParams, LoadConfigContent loadConfigContent) {
            Intrinsics.h(billingParams, "params");
            PayMainFragment payMainFragment = new PayMainFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("paymentParams", billingParams);
            bundle.putParcelable("configBean", loadConfigContent);
            payMainFragment.setArguments(bundle);
            return payMainFragment;
        }
    }

    public PayMainFragment() {
        super(R.layout.tran_fragment_main_layout);
        final Function0<y0> function0 = new Function0<y0>() { // from class: com.tn.tranpay.fragment.PayMainFragment$viewModel$2
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final y0 m135invoke() {
                Fragment requireParentFragment = PayMainFragment.this.requireParentFragment();
                Intrinsics.g(requireParentFragment, "requireParentFragment()");
                return requireParentFragment;
            }
        };
        this.viewModel = FragmentViewModelLazyKt.a(this, Reflection.b(PaymentViewModel.class), new Function0<x0>() { // from class: com.tn.tranpay.fragment.PayMainFragment$special$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final x0 m132invoke() {
                x0 viewModelStore = ((y0) function0.invoke()).getViewModelStore();
                Intrinsics.g(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.tn.tranpay.fragment.PayMainFragment$special$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final v0.c m133invoke() {
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

    private final boolean Z(List list) {
        if (list == null) {
            return false;
        }
        List list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return false;
        }
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            if (Intrinsics.c(((MediumInputBean) it.next()).getCode(), this.usedMethodCode)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PaymentViewModel a0() {
        return (PaymentViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b0(MediumInputBean item, View view, String phone, String cnic) {
        boolean z;
        boolean z2;
        if (!this.isPayable) {
            lh.a.g(lh.a.a, "It's illegal that the method is not payable", null, 2, null);
            return;
        }
        lh.a.g(lh.a.a, "Choose method " + item.getCode(), null, 2, null);
        if (com.tn.tranpay.helper.a.a.a(view.getId(), ToastStrategy.SHORT_DURATION_TIMEOUT)) {
            return;
        }
        this.isPayable = false;
        List<InputInfoBean> inputs = item.getInputs();
        if (inputs != null) {
            List<InputInfoBean> list = inputs;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.c(((InputInfoBean) it.next()).getType(), "Phone")) {
                        z = true;
                        break;
                    }
                }
            }
        }
        z = false;
        List<InputInfoBean> inputs2 = item.getInputs();
        if (inputs2 != null) {
            List<InputInfoBean> list2 = inputs2;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                Iterator<T> it2 = list2.iterator();
                while (it2.hasNext()) {
                    if (Intrinsics.c(((InputInfoBean) it2.next()).getType(), "CNIC")) {
                        z2 = true;
                        break;
                    }
                }
            }
        }
        z2 = false;
        com.tn.tranpay.report.h hVar = com.tn.tranpay.report.h.a;
        String code = item.getCode();
        if (code == null) {
            code = "";
        }
        hVar.a(code, z, z2, false);
        if (z && z2) {
            c0(item, phone, cnic, true);
            return;
        }
        if (z) {
            c0(item, phone, cnic, false);
        } else {
            if (z2) {
                lh.a.e(lh.a.a, "It's illegal that doesn't exist only cnic", null, 2, null);
                return;
            }
            PaymentViewModel a0 = a0();
            String code2 = item.getCode();
            PaymentViewModel.k(a0, code2 == null ? "" : code2, null, null, false, 14, null);
        }
    }

    private final void c0(MediumInputBean item, String phone, String cnic, boolean needCnic) {
        BillingParams billingParams = this.paymentParams;
        if (billingParams != null) {
            PaySubFragment.Companion companion = PaySubFragment.INSTANCE;
            LoadConfigContent loadConfigContent = this.configBean;
            List<InputInfoBean> inputs = item.getInputs();
            if (inputs == null) {
                inputs = CollectionsKt.l();
            }
            List<InputInfoBean> list = inputs;
            String name = item.getName();
            String str = name == null ? "" : name;
            String code = item.getCode();
            if (code == null) {
                code = "";
            }
            PaySubFragment a = companion.a(billingParams, loadConfigContent, needCnic, list, str, code, phone, cnic);
            a.m0(new Function0<Unit>() { // from class: com.tn.tranpay.fragment.PayMainFragment$navigateToSubFragment$1$1$1
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m134invoke();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m134invoke() {
                    PaymentViewModel a0;
                    PayMainFragment.this.isPayable = true;
                    a0 = PayMainFragment.this.a0();
                    a0.w().n(Boolean.FALSE);
                    lh.a.g(lh.a.a, "PaySubFragment popped", null, 2, null);
                }
            });
            getParentFragmentManager().p().s(R.id.fragment_container, a).g((String) null).i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(PayMainFragment payMainFragment, View view) {
        Intrinsics.h(payMainFragment, "this$0");
        PayFragment parentFragment = payMainFragment.getParentFragment();
        PayFragment payFragment = parentFragment instanceof PayFragment ? parentFragment : null;
        if (payFragment != null) {
            payFragment.o0();
        }
    }

    private final void e0(LoadConfigContent configBean) {
        View view;
        if (configBean == null || (view = getView()) == null) {
            return;
        }
        view.findViewById(R.id.iv_company).setText(configBean.getCpName());
        view.findViewById(R.id.iv_amount).setText(view.getContext().getString(R.string.pay_amount, configBean.getSymbol()));
        view.findViewById(R.id.iv_desc).setText(view.getContext().getString(R.string.pay_desc, configBean.getSymbol(), configBean.getCpName()));
        view.findViewById(R.id.iv_order_id).setText(view.getContext().getString(R.string.pay_order, configBean.getOrderId()));
    }

    private final void f0(List list) {
        if (list != null) {
            PaymentMMKV paymentMMKV = PaymentMMKV.a;
            RecyclerView.Adapter adapter = null;
            final String string = paymentMMKV.h().getString("k_phone_number", (String) null);
            final String string2 = paymentMMKV.h().getString("k_cnic_number", (String) null);
            com.tn.tranpay.adapter.b bVar = new com.tn.tranpay.adapter.b(CollectionsKt.U0(list), Z(list), this.usedMethodCode);
            bVar.l(new int[]{R.id.item_root});
            bVar.E1(new Function2<MediumInputBean, View, Unit>() { // from class: com.tn.tranpay.fragment.PayMainFragment$setPayMethodList$1$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((MediumInputBean) obj, (View) obj2);
                    return Unit.a;
                }

                public final void invoke(MediumInputBean mediumInputBean, View view) {
                    Intrinsics.h(mediumInputBean, "item");
                    Intrinsics.h(view, "view");
                    PayMainFragment.this.b0(mediumInputBean, view, string, string2);
                }
            });
            this.payMethodAdapter = bVar;
            View view = getView();
            RecyclerView recyclerView = view != null ? (RecyclerView) view.findViewById(R.id.iv_recycler) : null;
            if (recyclerView == null) {
                return;
            }
            RecyclerView.Adapter adapter2 = this.payMethodAdapter;
            if (adapter2 == null) {
                Intrinsics.y("payMethodAdapter");
            } else {
                adapter = adapter2;
            }
            recyclerView.setAdapter(adapter);
        }
    }

    private final void g0(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        this.paymentParams = arguments != null ? (BillingParams) arguments.getParcelable("paymentParams") : null;
        Bundle arguments2 = getArguments();
        this.configBean = arguments2 != null ? (LoadConfigContent) arguments2.getParcelable("configBean") : null;
        view.findViewById(R.id.iv_close).setOnClickListener(new View.OnClickListener() { // from class: com.tn.tranpay.fragment.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PayMainFragment.d0(PayMainFragment.this, view2);
            }
        });
        String string = PaymentMMKV.a.h().getString("k_pay_method_code", (String) null);
        this.usedMethodCode = string;
        lh.a.g(lh.a.a, "The used method code is " + string, null, 2, null);
        View findViewById = view.findViewById(R.id.iv_recycler);
        Intrinsics.g(findViewById, "view.findViewById(R.id.iv_recycler)");
        g0((RecyclerView) findViewById);
        if (isAdded()) {
            LoadConfigContent loadConfigContent = this.configBean;
            f0(loadConfigContent != null ? loadConfigContent.getMedium() : null);
            e0(this.configBean);
        }
        com.tn.tranpay.report.h.a.l("main_tab_page");
    }
}
