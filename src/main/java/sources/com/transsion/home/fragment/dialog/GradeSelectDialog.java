package com.transsion.home.fragment.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.y;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.flexbox.FlexboxLayout;
import com.tn.lib.widget.TnTextView;
import com.transsion.baseui.R$style;
import com.transsion.baseui.dialog.BaseViewBindingDialog;
import com.transsion.baseui.widget.GradientTextView;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.bean.GradeGroup;
import com.transsion.home.bean.GradeItem;
import com.transsion.home.fragment.dialog.GradeSelectDialog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u0000 ;2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002<=B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\nJ#\u0010\u0011\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0018\u001a\u00020\u00172\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001e\u0010\u0004R2\u0010'\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010 \u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u001c\u0010.\u001a\b\u0018\u00010+R\u00020\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010)R\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u0010)R.\u0010:\u001a\u001c\u0012\u0004\u0012\u000205\u0012\u0006\u0012\u0004\u0018\u000106\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u0002048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u00109¨\u0006>"}, d2 = {"Lcom/transsion/home/fragment/dialog/GradeSelectDialog;", "Lcom/transsion/baseui/dialog/BaseViewBindingDialog;", "Lqk/f;", "<init>", "()V", BuildConfig.FLAVOR, "A0", BuildConfig.FLAVOR, "moduleName", "w0", "(Ljava/lang/String;)V", "id", "z0", BuildConfig.FLAVOR, "Lcom/transsion/home/bean/GradeGroup;", "gradeList", "pageName", "x0", "(Ljava/util/List;Ljava/lang/String;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "Lkotlin/Function1;", "Lcom/transsion/home/bean/GradeItem;", "d", "Lkotlin/jvm/functions/Function1;", "getOnGradeSelected", "()Lkotlin/jvm/functions/Function1;", "y0", "(Lkotlin/jvm/functions/Function1;)V", "onGradeSelected", "e", "Ljava/lang/String;", "selectedGradeId", "Lcom/transsion/home/fragment/dialog/GradeSelectDialog$b;", "f", "Lcom/transsion/home/fragment/dialog/GradeSelectDialog$b;", "gradeAdapter", "g", "GRADE_NAME", "h", "Ljava/util/List;", "i", "Lkotlin/Function3;", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", BuildConfig.FLAVOR, "n0", "()Lkotlin/jvm/functions/Function3;", "bindingInflater", "j", "a", "b", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class GradeSelectDialog extends BaseViewBindingDialog<qk.f> {
    public static final int k = 8;

    /* renamed from: d, reason: from kotlin metadata */
    private Function1 onGradeSelected;

    /* renamed from: f, reason: from kotlin metadata */
    private b gradeAdapter;

    /* renamed from: h, reason: from kotlin metadata */
    private List gradeList;

    /* renamed from: i, reason: from kotlin metadata */
    private String pageName;

    /* renamed from: e, reason: from kotlin metadata */
    private String selectedGradeId = "UN_GRADE";

    /* renamed from: g, reason: from kotlin metadata */
    private String GRADE_NAME = "grade_select";

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B3\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0014\u0010\t\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0017\u001a\u00020\b*\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001e\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010\"\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\"\u0010#R\"\u0010\t\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R$\u0010-\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0014\u00100\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010/R\u0014\u00102\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u0010/R\u0014\u00104\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u0010/R\u0014\u00107\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u0010$¨\u00068"}, d2 = {"Lcom/transsion/home/fragment/dialog/GradeSelectDialog$b;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/home/bean/GradeGroup;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", BuildConfig.FLAVOR, "initialSelectedId", "Lkotlin/Function1;", "Lcom/transsion/home/bean/GradeItem;", BuildConfig.FLAVOR, "onGradeClick", "Lkotlin/Function0;", "onDismiss", "<init>", "(Lcom/transsion/home/fragment/dialog/GradeSelectDialog;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "Landroid/content/Context;", "ctx", "gradeItem", "Lcom/transsion/baseui/widget/GradientTextView;", "F1", "(Landroid/content/Context;Lcom/transsion/home/bean/GradeItem;)Lcom/transsion/baseui/widget/GradientTextView;", "context", BuildConfig.FLAVOR, "selected", "D1", "(Lcom/transsion/baseui/widget/GradientTextView;Landroid/content/Context;Z)V", "Lcom/tn/lib/widget/TnTextView;", "btn", "isSelected", "C1", "(Lcom/tn/lib/widget/TnTextView;Z)V", "I1", "(Lcom/transsion/home/bean/GradeItem;)V", "holder", "item", "E1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/home/bean/GradeGroup;)V", "F", "Lkotlin/jvm/functions/Function1;", "G", "Lkotlin/jvm/functions/Function0;", "value", "H", "Ljava/lang/String;", "H1", "()Ljava/lang/String;", "selectedGradeId", BuildConfig.FLAVOR, "I", "gap", "J", "btnWidth", "K", "btnHeight", BuildConfig.FLAVOR, "L", "cornerRadius", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @SourceDebugExtension
    final class b extends BaseQuickAdapter {

        /* renamed from: F, reason: from kotlin metadata */
        private final Function1<GradeItem, Unit> onGradeClick;

        /* renamed from: G, reason: from kotlin metadata */
        private final Function0<Unit> onDismiss;

        /* renamed from: H, reason: from kotlin metadata */
        private String selectedGradeId;

        /* renamed from: I, reason: from kotlin metadata */
        private final int gap;

        /* renamed from: J, reason: from kotlin metadata */
        private final int btnWidth;

        /* renamed from: K, reason: from kotlin metadata */
        private final int btnHeight;

        /* renamed from: L, reason: from kotlin metadata */
        private final float cornerRadius;
        final /* synthetic */ GradeSelectDialog M;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(GradeSelectDialog gradeSelectDialog, String str, Function1<? super GradeItem, Unit> function1, Function0<Unit> function0) {
            super(R.layout.item_grade_group, (List) null, 2, (DefaultConstructorMarker) null);
            Intrinsics.h(str, "initialSelectedId");
            Intrinsics.h(function1, "onGradeClick");
            Intrinsics.h(function0, "onDismiss");
            this.M = gradeSelectDialog;
            this.onGradeClick = function1;
            this.onDismiss = function0;
            this.selectedGradeId = str;
            int a = a0.a(12.0f);
            this.gap = a;
            this.btnWidth = (y.e() - (a * 4)) / 3;
            this.btnHeight = a0.a(44.0f);
            this.cornerRadius = a0.a(999.0f);
        }

        private final void C1(TnTextView btn, boolean isSelected) {
            GradientDrawable gradientDrawable;
            Context context = btn.getContext();
            float f = this.cornerRadius;
            if (isSelected) {
                gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{androidx.core.content.b.getColor(context, com.tn.lib.widget.R.color.brand_new_gradient_start_20), androidx.core.content.b.getColor(context, com.tn.lib.widget.R.color.brand_new_gradient_end_20)});
                gradientDrawable.setCornerRadius(f);
            } else {
                gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setCornerRadius(f);
                gradientDrawable.setColor(androidx.core.content.b.getColor(context, com.tn.lib.widget.R.color.white_10));
            }
            btn.setBackground(gradientDrawable);
            btn.setTypeface(uf.a.c(getContext()));
        }

        private final void D1(GradientTextView gradientTextView, Context context, boolean z) {
            int color = androidx.core.content.b.getColor(context, com.tn.lib.widget.R.color.white_80);
            int color2 = androidx.core.content.b.getColor(context, com.tn.lib.widget.R.color.brand_new_gradient_start);
            int color3 = androidx.core.content.b.getColor(context, com.tn.lib.widget.R.color.brand_new_gradient_center);
            int color4 = androidx.core.content.b.getColor(context, com.tn.lib.widget.R.color.brand_new_gradient_end);
            if (!z) {
                color2 = color;
            }
            if (!z) {
                color3 = color;
            }
            if (z) {
                color = color4;
            }
            gradientTextView.setGradientColors(color2, color3, color);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v0, types: [android.view.View, android.widget.TextView, com.tn.lib.widget.TnTextView, com.transsion.baseui.widget.GradientTextView] */
        private final GradientTextView F1(Context ctx, final GradeItem gradeItem) {
            ?? gradientTextView = new GradientTextView(ctx, null, 0, 6, null);
            gradientTextView.setText(gradeItem != null ? gradeItem.getName() : null);
            gradientTextView.setTextSize(14.0f);
            gradientTextView.setGravity(17);
            FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(this.btnWidth, this.btnHeight);
            int i = this.gap;
            layoutParams.setMargins(0, 0, i, i);
            gradientTextView.setLayoutParams(layoutParams);
            C1(gradientTextView, Intrinsics.c(gradeItem != null ? gradeItem.getGrade() : null, this.selectedGradeId));
            D1(gradientTextView, ctx, Intrinsics.c(gradeItem != null ? gradeItem.getGrade() : null, this.selectedGradeId));
            gradientTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.fragment.dialog.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GradeSelectDialog.b.G1(GradeSelectDialog.b.this, gradeItem, view);
                }
            });
            return gradientTextView;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void G1(b bVar, GradeItem gradeItem, View view) {
            bVar.I1(gradeItem);
        }

        private final void I1(GradeItem gradeItem) {
            String str;
            String grade;
            if (Intrinsics.c(gradeItem != null ? gradeItem.getGrade() : null, this.selectedGradeId)) {
                this.onDismiss.invoke();
                return;
            }
            String str2 = BuildConfig.FLAVOR;
            if (gradeItem == null || (str = gradeItem.getGrade()) == null) {
                str = BuildConfig.FLAVOR;
            }
            this.selectedGradeId = str;
            notifyDataSetChanged();
            this.onGradeClick.invoke(gradeItem);
            GradeSelectDialog gradeSelectDialog = this.M;
            if (gradeItem != null && (grade = gradeItem.getGrade()) != null) {
                str2 = grade;
            }
            gradeSelectDialog.w0(str2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: E1, reason: merged with bridge method [inline-methods] */
        public void F(BaseViewHolder holder, GradeGroup item) {
            Intrinsics.h(holder, "holder");
            Intrinsics.h(item, "item");
            RecyclerView.n layoutParams = ((RecyclerView.a0) holder).itemView.getLayoutParams();
            RecyclerView.n nVar = layoutParams instanceof RecyclerView.n ? layoutParams : null;
            if (nVar != null) {
                ((ViewGroup.MarginLayoutParams) nVar).topMargin = holder.getBindingAdapterPosition() == 0 ? 0 : a0.a(20.0f);
            }
            ((RecyclerView.a0) holder).itemView.setLayoutParams(nVar);
            TnTextView view = holder.getView(R.id.tvGroupName);
            String title = item.getTitle();
            if (title == null || title.length() == 0) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
                view.setText(item.getTitle());
            }
            FlexboxLayout view2 = holder.getView(R.id.flexboxGrades);
            view2.removeAllViews();
            List<GradeItem> grades = item.getGrades();
            if (grades != null) {
                for (GradeItem gradeItem : grades) {
                    Context context = view2.getContext();
                    Intrinsics.g(context, "getContext(...)");
                    view2.addView(F1(context, gradeItem));
                }
            }
        }

        /* renamed from: H1, reason: from getter */
        public final String getSelectedGradeId() {
            return this.selectedGradeId;
        }
    }

    private final void A0() {
        RecyclerView recyclerView;
        this.gradeAdapter = new b(this, this.selectedGradeId, new Function1() { // from class: com.transsion.home.fragment.dialog.f
            public final Object invoke(Object obj) {
                Unit B0;
                B0 = GradeSelectDialog.B0(GradeSelectDialog.this, (GradeItem) obj);
                return B0;
            }
        }, new Function0() { // from class: com.transsion.home.fragment.dialog.g
            public final Object invoke() {
                Unit C0;
                C0 = GradeSelectDialog.C0(GradeSelectDialog.this);
                return C0;
            }
        });
        qk.f fVar = (qk.f) getViewBinding();
        if (fVar != null && (recyclerView = fVar.e) != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
            recyclerView.setAdapter(this.gradeAdapter);
        }
        List list = this.gradeList;
        if (list == null || list.isEmpty()) {
            b bVar = this.gradeAdapter;
            if (bVar != null) {
                bVar.n1(new ArrayList());
                return;
            }
            return;
        }
        b bVar2 = this.gradeAdapter;
        if (bVar2 != null) {
            bVar2.n1(this.gradeList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B0(GradeSelectDialog gradeSelectDialog, GradeItem gradeItem) {
        Function1 function1 = gradeSelectDialog.onGradeSelected;
        if (function1 != null) {
            function1.invoke(gradeItem);
        }
        gradeSelectDialog.dismissAllowingStateLoss();
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C0(GradeSelectDialog gradeSelectDialog) {
        gradeSelectDialog.dismissAllowingStateLoss();
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(GradeSelectDialog gradeSelectDialog, View view) {
        gradeSelectDialog.dismissAllowingStateLoss();
        gradeSelectDialog.w0("close");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(GradeSelectDialog gradeSelectDialog, View view) {
        gradeSelectDialog.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w0(String moduleName) {
        HashMap hashMap = new HashMap();
        hashMap.put("dialog_name", this.GRADE_NAME);
        hashMap.put("module_name", moduleName);
        String str = this.pageName;
        if (str != null) {
            com.transsion.baselib.helper.a.a.b(str, hashMap);
        }
    }

    @Override // com.transsion.baseui.dialog.BaseViewBindingDialog
    public Function3 n0() {
        return GradeSelectDialog$bindingInflater$1.INSTANCE;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, com.transsnet.downloader.R.style.DownloadBottomDialogTheme);
        String str = this.pageName;
        if (str != null) {
            com.transsion.baselib.helper.a.a.c(str, this.GRADE_NAME);
        }
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.g(onCreateDialog, "onCreateDialog(...)");
        Window window = onCreateDialog.getWindow();
        if (window != null) {
            window.setWindowAnimations(R$style.BaseBottomDialogAnimation);
            window.setGravity(80);
            window.setDimAmount(0.5f);
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes == null) {
                attributes = new WindowManager.LayoutParams();
            }
            attributes.width = -1;
            attributes.height = -1;
            window.setBackgroundDrawable(null);
            window.setAttributes(attributes);
        }
        return onCreateDialog;
    }

    public void onDestroyView() {
        RecyclerView recyclerView;
        super.onDestroyView();
        qk.f fVar = (qk.f) getViewBinding();
        if (fVar != null && (recyclerView = fVar.e) != null) {
            recyclerView.setAdapter((RecyclerView.Adapter) null);
        }
        this.gradeAdapter = null;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        FrameLayout root;
        AppCompatImageView appCompatImageView;
        Intrinsics.h(view, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(view, savedInstanceState);
        qk.f fVar = (qk.f) getViewBinding();
        if (fVar != null && (appCompatImageView = fVar.d) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.fragment.dialog.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    GradeSelectDialog.u0(GradeSelectDialog.this, view2);
                }
            });
        }
        qk.f fVar2 = (qk.f) getViewBinding();
        if (fVar2 != null && (root = fVar2.getRoot()) != null) {
            root.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.fragment.dialog.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    GradeSelectDialog.v0(GradeSelectDialog.this, view2);
                }
            });
        }
        A0();
    }

    public final void x0(List gradeList, String pageName) {
        Intrinsics.h(gradeList, "gradeList");
        Intrinsics.h(pageName, "pageName");
        this.gradeList = gradeList;
        this.pageName = pageName;
    }

    public final void y0(Function1 function1) {
        this.onGradeSelected = function1;
    }

    public final void z0(String id) {
        Intrinsics.h(id, "id");
        this.selectedGradeId = id;
    }
}
