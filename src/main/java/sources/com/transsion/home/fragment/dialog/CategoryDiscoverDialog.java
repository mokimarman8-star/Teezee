package com.transsion.home.fragment.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.R$style;
import com.transsion.home.bean.HomeTabItem;
import com.transsion.home.bean.NameImage;
import com.transsion.home.fragment.dialog.CategoryDiscoverDialog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import ni.f;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\b\b\u0007\u0018\u0000 82\u00020\u0001:\u00049:*;B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000f\u0010\fJ-\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001a\u0010\u0003J!\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010 \u001a\u00020\u00062\u0010\u0010\u001f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0018\u00010\u001d¢\u0006\u0004\b \u0010!J2\u0010'\u001a\u00020\u00062#\u0010&\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u001e¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u00060\"¢\u0006\u0004\b'\u0010(R\"\u00100\u001a\u00020)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R5\u00103\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u001e¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u0006\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u001c\u00107\u001a\b\u0012\u0004\u0012\u00020\u001e048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106¨\u0006<"}, d2 = {"Lcom/transsion/home/fragment/dialog/CategoryDiscoverDialog;", "Lcom/transsion/baseui/dialog/BaseDialog;", "<init>", "()V", "Landroid/view/View;", "view", BuildConfig.FLAVOR, "t0", "(Landroid/view/View;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onActivityCreated", "outState", "onSaveInstanceState", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "onResume", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", BuildConfig.FLAVOR, "Lcom/transsion/home/bean/HomeTabItem;", "tabs", "s0", "(Ljava/util/List;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "categoryName", "callback", "q0", "(Lkotlin/jvm/functions/Function1;)V", BuildConfig.FLAVOR, "c", "I", "getCurrentTabIndex", "()I", "r0", "(I)V", "currentTabIndex", "d", "Lkotlin/jvm/functions/Function1;", "mCallback", BuildConfig.FLAVOR, "e", "Ljava/util/List;", "tabList", "f", "b", "a", "CategorySelectEvent", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class CategoryDiscoverDialog extends BaseDialog {

    /* renamed from: f, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int g = 8;

    /* renamed from: c, reason: from kotlin metadata */
    private int currentTabIndex;

    /* renamed from: d, reason: from kotlin metadata */
    private Function1 mCallback;

    /* renamed from: e, reason: from kotlin metadata */
    private List tabList = new ArrayList();

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/transsion/home/fragment/dialog/CategoryDiscoverDialog$CategorySelectEvent;", "Landroid/os/Parcelable;", "categoryName", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;)V", "getCategoryName", "()Ljava/lang/String;", "component1", "copy", "describeContents", BuildConfig.FLAVOR, "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "toString", "writeToParcel", BuildConfig.FLAVOR, "dest", "Landroid/os/Parcel;", "flags", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class CategorySelectEvent implements Parcelable {
        private final String categoryName;
        public static final Parcelable.Creator<CategorySelectEvent> CREATOR = new a();
        public static final int $stable = 8;

        public static final class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final CategorySelectEvent createFromParcel(Parcel parcel) {
                Intrinsics.h(parcel, "parcel");
                return new CategorySelectEvent(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final CategorySelectEvent[] newArray(int i) {
                return new CategorySelectEvent[i];
            }
        }

        public CategorySelectEvent(String str) {
            Intrinsics.h(str, "categoryName");
            this.categoryName = str;
        }

        public static /* synthetic */ CategorySelectEvent copy$default(CategorySelectEvent categorySelectEvent, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = categorySelectEvent.categoryName;
            }
            return categorySelectEvent.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getCategoryName() {
            return this.categoryName;
        }

        public final CategorySelectEvent copy(String categoryName) {
            Intrinsics.h(categoryName, "categoryName");
            return new CategorySelectEvent(categoryName);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CategorySelectEvent) && Intrinsics.c(this.categoryName, ((CategorySelectEvent) other).categoryName);
        }

        public final String getCategoryName() {
            return this.categoryName;
        }

        public int hashCode() {
            return this.categoryName.hashCode();
        }

        public String toString() {
            return "CategorySelectEvent(categoryName=" + this.categoryName + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.h(dest, "dest");
            dest.writeString(this.categoryName);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0012B\u001d\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/transsion/home/fragment/dialog/CategoryDiscoverDialog$a;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/home/bean/HomeTabItem;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", BuildConfig.FLAVOR, "data", BuildConfig.FLAVOR, "currentTabIndex", "<init>", "(Ljava/util/List;I)V", "holder", "item", BuildConfig.FLAVOR, "C1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/home/bean/HomeTabItem;)V", "F", "I", "G", "a", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @SourceDebugExtension
    public static final class a extends BaseQuickAdapter {
        private static final C0032a G = new C0032a(null);
        public static final int H = 8;

        @Deprecated
        public static final float I = 22.0f;

        @Deprecated
        public static final float J = 120.0f;

        /* renamed from: F, reason: from kotlin metadata */
        private final int currentTabIndex;

        /* renamed from: com.transsion.home.fragment.dialog.CategoryDiscoverDialog$a$a, reason: collision with other inner class name */
        private static final class C0032a {
            private C0032a() {
            }

            public /* synthetic */ C0032a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(List<HomeTabItem> list, int i) {
            super(R.layout.item_category_discover_layout, list);
            Intrinsics.h(list, "data");
            this.currentTabIndex = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit D1(AppCompatImageView appCompatImageView, String str, View view, boolean z, boolean z2, long j) {
            if (!Intrinsics.c(appCompatImageView.getTag(), str)) {
                return Unit.a;
            }
            if (!z) {
                appCompatImageView.setVisibility(8);
                view.setVisibility(0);
            }
            return Unit.a;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: C1, reason: merged with bridge method [inline-methods] */
        public void F(BaseViewHolder holder, HomeTabItem item) {
            Integer width;
            Intrinsics.h(holder, "holder");
            Intrinsics.h(item, "item");
            holder.setText(R.id.tvCategoryName, item.getName());
            final View view = holder.getView(R.id.tvCategoryName);
            final ImageView imageView = (AppCompatImageView) holder.getView(R.id.ivCategoryNameImage);
            view.setVisibility(0);
            imageView.setVisibility(8);
            imageView.setImageDrawable((Drawable) null);
            NameImage nameImage = item.getNameImage();
            final String url = nameImage != null ? nameImage.getUrl() : null;
            if (url == null || StringsKt.q0(url)) {
                return;
            }
            Context context = ((RecyclerView.a0) holder).itemView.getContext();
            int a = a0.a(120.0f);
            int a2 = a0.a(22.0f);
            NameImage nameImage2 = item.getNameImage();
            Integer valueOf = (nameImage2 == null || (width = nameImage2.getWidth()) == null) ? null : Integer.valueOf(a0.a(width.intValue()));
            int h = valueOf != null ? RangesKt.h(valueOf.intValue(), a) : -2;
            ConstraintLayout.b layoutParams = imageView.getLayoutParams();
            ConstraintLayout.b bVar = layoutParams instanceof ConstraintLayout.b ? layoutParams : null;
            if (bVar != null) {
                ((ViewGroup.MarginLayoutParams) bVar).width = h;
                ((ViewGroup.MarginLayoutParams) bVar).height = a2;
                imageView.setLayoutParams(bVar);
            }
            imageView.setTag(url);
            imageView.setVisibility(0);
            view.setVisibility(8);
            f.a aVar = ni.f.a;
            Intrinsics.e(context);
            aVar.m(context).g(url).i(com.tn.lib.widget.R.color.transparent).b(new Function3() { // from class: com.transsion.home.fragment.dialog.c
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit D1;
                    D1 = CategoryDiscoverDialog.a.D1(imageView, url, view, ((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), ((Long) obj3).longValue());
                    return D1;
                }
            }).d(imageView);
        }
    }

    /* renamed from: com.transsion.home.fragment.dialog.CategoryDiscoverDialog$b, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CategoryDiscoverDialog a() {
            return new CategoryDiscoverDialog();
        }
    }

    public static final class c extends RecyclerView.l {
        private final int a;
        private final int b;
        private final boolean c;

        public c(int i, int i2, boolean z) {
            this.a = i;
            this.b = i2;
            this.c = z;
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.x xVar) {
            Intrinsics.h(rect, "outRect");
            Intrinsics.h(view, "view");
            Intrinsics.h(recyclerView, "parent");
            Intrinsics.h(xVar, "state");
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            int i = this.a;
            int i2 = childAdapterPosition % i;
            if (this.c) {
                int i3 = this.b;
                rect.left = i3 - ((i2 * i3) / i);
                rect.right = ((i2 + 1) * i3) / i;
                if (childAdapterPosition < i) {
                    rect.top = i3;
                }
                rect.bottom = i3;
                return;
            }
            int i4 = this.b;
            rect.left = (i2 * i4) / i;
            rect.right = i4 - (((i2 + 1) * i4) / i);
            if (childAdapterPosition >= i) {
                rect.top = i4;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(CategoryDiscoverDialog categoryDiscoverDialog, View view) {
        categoryDiscoverDialog.dismissAllowingStateLoss();
    }

    private final void t0(View view) {
        RecyclerView findViewById = view.findViewById(R.id.rvCategories);
        findViewById.setLayoutManager(new GridLayoutManager(findViewById.getContext(), 2));
        a aVar = new a(this.tabList, this.currentTabIndex);
        aVar.w1(new r6.d() { // from class: com.transsion.home.fragment.dialog.b
            public final void a(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                CategoryDiscoverDialog.u0(CategoryDiscoverDialog.this, baseQuickAdapter, view2, i);
            }
        });
        findViewById.setAdapter(aVar);
        findViewById.addItemDecoration(new c(2, a0.a(12.0f), true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(CategoryDiscoverDialog categoryDiscoverDialog, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.h(baseQuickAdapter, "adapter");
        Intrinsics.h(view, "<unused var>");
        categoryDiscoverDialog.dismissAllowingStateLoss();
        Function1 function1 = categoryDiscoverDialog.mCallback;
        if (function1 != null) {
            Object l0 = CollectionsKt.l0(baseQuickAdapter.getData(), i);
            function1.invoke(l0 instanceof HomeTabItem ? (HomeTabItem) l0 : null);
        }
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState == null || !savedInstanceState.getBoolean("category_discover", false)) {
            return;
        }
        dismissAllowingStateLoss();
    }

    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.h(newConfig, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(newConfig);
        dismissAllowingStateLoss();
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R$style.FullScreenDialogFromBottom);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.h(inflater, "inflater");
        return inflater.inflate(R.layout.dialog_category_discover_layout, container, false);
    }

    @Override // com.transsion.baseui.dialog.BaseDialog
    public void onResume() {
        super.onResume();
    }

    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.h(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putBoolean("category_discover", true);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Window window;
        Intrinsics.h(view, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(view, savedInstanceState);
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setLayout(-1, -2);
            window.setGravity(80);
        }
        view.findViewById(R.id.btnClose).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.fragment.dialog.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CategoryDiscoverDialog.p0(CategoryDiscoverDialog.this, view2);
            }
        });
        t0(view);
    }

    public final void q0(Function1 callback) {
        Intrinsics.h(callback, "callback");
        this.mCallback = callback;
    }

    public final void r0(int i) {
        this.currentTabIndex = i;
    }

    public final void s0(List tabs) {
        if (tabs == null) {
            return;
        }
        this.tabList.addAll(CollectionsKt.f0(tabs));
    }
}
