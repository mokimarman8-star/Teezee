package com.transsion.edcation.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.lifecycle.v;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.y;
import com.tn.lib.widget.R;
import com.transsion.baseui.dialog.BaseDialogFragment;
import com.transsion.edcation.CourseManager;
import com.transsion.edcation.R$id;
import com.transsion.edcation.R$layout;
import com.transsion.edcation.R$string;
import com.transsion.edcation.bean.EducationInterestResp;
import com.transsion.edcation.bean.InterestBean;
import com.transsion.edcation.c;
import com.transsion.gslb.BuildConfig;
import io.reactivex.rxjava3.core.j;
import io.reactivex.rxjava3.core.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.y0;
import yx.h;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u001d\u0010\n\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\u0004J\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001f\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010'\u001a\u00020!8\u0002X\u0082D¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006("}, d2 = {"Lcom/transsion/edcation/dialog/InterestSelectDialog;", "Lcom/transsion/baseui/dialog/BaseDialogFragment;", "Lek/a;", "<init>", "()V", BuildConfig.FLAVOR, "v0", BuildConfig.FLAVOR, "Lcom/transsion/edcation/bean/InterestBean;", "options", "s0", "(Ljava/util/List;)V", "initView", "c0", "Landroid/view/Window;", "window", "d0", "(Landroid/view/Window;)V", BuildConfig.FLAVOR, "Z", "()Z", "Landroid/content/Context;", "context", "Landroid/view/View;", "u0", "(Landroid/content/Context;)Landroid/view/View;", "Lcom/transsion/edcation/c;", "e", "Lkotlin/Lazy;", "w0", "()Lcom/transsion/edcation/c;", "mApi", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "f", "Ljava/util/List;", "selectIds", "g", "Ljava/lang/String;", "TAG", "Education_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class InterestSelectDialog extends BaseDialogFragment<ek.a> {

    /* renamed from: e, reason: from kotlin metadata */
    private final Lazy mApi;

    /* renamed from: f, reason: from kotlin metadata */
    private final List selectIds;

    /* renamed from: g, reason: from kotlin metadata */
    private final String TAG;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.transsion.edcation.dialog.InterestSelectDialog$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, ek.a> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, ek.a.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/transsion/edcation/databinding/DialogInterestSelectBinding;", 0);
        }

        public final ek.a invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
            Intrinsics.h(layoutInflater, "p0");
            return ek.a.c(layoutInflater, viewGroup, z);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((LayoutInflater) obj, (ViewGroup) obj2, ((Boolean) obj3).booleanValue());
        }
    }

    static final class a implements h {
        public static final a a = new a();

        a() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final m apply(Throwable th2) {
            Intrinsics.h(th2, "it");
            return j.l(th2);
        }
    }

    public InterestSelectDialog() {
        super(AnonymousClass1.INSTANCE);
        this.mApi = LazyKt.b(new Function0() { // from class: com.transsion.edcation.dialog.a
            public final Object invoke() {
                com.transsion.edcation.c A0;
                A0 = InterestSelectDialog.A0();
                return A0;
            }
        });
        this.selectIds = new ArrayList();
        this.TAG = "InterestSelectDialog";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsion.edcation.c A0() {
        return (com.transsion.edcation.c) kg.c.e.a().h(com.transsion.edcation.c.class);
    }

    public static final /* synthetic */ ek.a p0(InterestSelectDialog interestSelectDialog) {
        return (ek.a) interestSelectDialog.getMViewBinding();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s0(List options) {
        Context context = getContext();
        if (context == null) {
            a0();
            return;
        }
        ((ek.a) getMViewBinding()).b.removeAllViews();
        Iterator it = options.iterator();
        while (it.hasNext()) {
            final InterestBean interestBean = (InterestBean) it.next();
            final View u0 = u0(context);
            ((TextView) u0.findViewById(R$id.tvContent)).setText(interestBean.getName());
            u0.setMinimumHeight(a0.a(40.0f));
            u0.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.edcation.dialog.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    InterestSelectDialog.t0(u0, this, interestBean, view);
                }
            });
            ((ek.a) getMViewBinding()).b.addView(u0);
        }
        CourseManager.a.s(false);
        com.transsion.baselib.report.launch.b.a.b().putBoolean("edu_interest_dialog", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(View view, InterestSelectDialog interestSelectDialog, InterestBean interestBean, View view2) {
        view.setSelected(!view.isSelected());
        if (view.isSelected()) {
            interestSelectDialog.selectIds.add(interestBean.getId());
        } else {
            interestSelectDialog.selectIds.remove(interestBean.getId());
        }
    }

    private final void v0() {
        c.a.a(w0(), null, 1, null).v(ey.a.c()).x(a.a).f(dg.d.a.c()).subscribe(new dg.a() { // from class: com.transsion.edcation.dialog.InterestSelectDialog$getInterestList$2
            public void a(String str, String str2) {
                String unused;
                unused = InterestSelectDialog.this.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("error: ");
                sb.append(str);
                sb.append(", msg:");
                sb.append(str2);
                if (!InterestSelectDialog.this.isAdded() || InterestSelectDialog.this.isDetached() || InterestSelectDialog.this.isRemoving()) {
                    return;
                }
                com.tn.lib.widget.toast.core.h.a.l(Utils.a().getString(R.string.error_load_failed));
                InterestSelectDialog.this.a0();
            }

            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public void c(EducationInterestResp educationInterestResp) {
                List<InterestBean> options;
                List<InterestBean> options2;
                String unused;
                super.c(educationInterestResp);
                unused = InterestSelectDialog.this.TAG;
                Integer valueOf = (educationInterestResp == null || (options2 = educationInterestResp.getOptions()) == null) ? null : Integer.valueOf(options2.size());
                StringBuilder sb = new StringBuilder();
                sb.append("list is empty: ");
                sb.append(valueOf);
                if (InterestSelectDialog.this.getContext() == null || educationInterestResp == null || (options = educationInterestResp.getOptions()) == null || options.isEmpty()) {
                    return;
                }
                i.d(v.a(InterestSelectDialog.this), y0.c(), (CoroutineStart) null, new InterestSelectDialog$getInterestList$2$onSuccess$1(InterestSelectDialog.this, options, null), 2, (Object) null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.transsion.edcation.c w0() {
        return (com.transsion.edcation.c) this.mApi.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(final InterestSelectDialog interestSelectDialog, View view) {
        com.transsion.baseui.util.d.b(0L, new Function0() { // from class: com.transsion.edcation.dialog.d
            public final Object invoke() {
                Unit y0;
                y0 = InterestSelectDialog.y0(InterestSelectDialog.this);
                return y0;
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y0(InterestSelectDialog interestSelectDialog) {
        if (!interestSelectDialog.selectIds.isEmpty()) {
            i.d(v.a(interestSelectDialog), y0.b(), (CoroutineStart) null, new InterestSelectDialog$initView$1$1$1(interestSelectDialog, null), 2, (Object) null);
            return Unit.a;
        }
        if (!interestSelectDialog.isAdded() || interestSelectDialog.isDetached() || interestSelectDialog.isRemoving()) {
            return Unit.a;
        }
        com.tn.lib.widget.toast.core.h.a.l(Utils.a().getString(R$string.course_interest_select_tips));
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(InterestSelectDialog interestSelectDialog, View view) {
        interestSelectDialog.dismiss();
    }

    @Override // com.transsion.baseui.dialog.BaseDialogFragment
    protected boolean Z() {
        return false;
    }

    @Override // com.transsion.baseui.dialog.BaseDialogFragment
    public void c0() {
    }

    @Override // com.transsion.baseui.dialog.BaseDialogFragment
    protected void d0(Window window) {
        Intrinsics.h(window, "window");
        super.d0(window);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.height = -2;
        attributes.width = y.e() - lj.a.b(40);
        window.setAttributes(attributes);
    }

    @Override // com.transsion.baseui.dialog.BaseDialogFragment
    public void initView() {
        ((ek.a) getMViewBinding()).d.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.edcation.dialog.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InterestSelectDialog.x0(InterestSelectDialog.this, view);
            }
        });
        ((ek.a) getMViewBinding()).e.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.edcation.dialog.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InterestSelectDialog.z0(InterestSelectDialog.this, view);
            }
        });
        v0();
    }

    public final View u0(Context context) {
        Intrinsics.h(context, "context");
        View inflate = LayoutInflater.from(context).inflate(R$layout.item_select_interest, (ViewGroup) null);
        Intrinsics.g(inflate, "inflate(...)");
        return inflate;
    }
}
