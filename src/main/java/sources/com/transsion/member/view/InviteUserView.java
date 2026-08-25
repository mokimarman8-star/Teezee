package com.transsion.member.view;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.gslb.BuildConfig;
import com.transsion.member.R$styleable;
import com.transsion.member.view.InviteUserView;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b*\b\u0007\u0018\u0000 K*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u000568:\u0010\fB'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u0012\u0010\rJ\r\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0018\u001a\u00020\u000b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ\u001b\u0010\u001f\u001a\u00020\u000b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d¢\u0006\u0004\b\u001f\u0010 JE\u0010'\u001a\u00020\u000b26\u0010&\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u000b0!¢\u0006\u0004\b'\u0010(J\u0015\u0010)\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u0007¢\u0006\u0004\b)\u0010*J\r\u0010+\u001a\u00020\u000b¢\u0006\u0004\b+\u0010\rJ\u0015\u0010-\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u0013¢\u0006\u0004\b-\u0010.J\u001b\u00100\u001a\u00020\u000b2\f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016¢\u0006\u0004\b0\u0010\u0019R\u0016\u00103\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00104\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u00102R\u0016\u00105\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u00102R\u0016\u00107\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00102R\u0016\u00109\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00102R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u001e\u0010>\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=RH\u0010A\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(%\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u000b\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010D\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010,\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010H\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010FR\u0016\u0010J\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010F¨\u0006L"}, d2 = {"Lcom/transsion/member/view/InviteUserView;", "T", "Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BuildConfig.FLAVOR, "b", "()V", BuildConfig.FLAVOR, "dp", "c", "(F)I", "onFinishInflate", BuildConfig.FLAVOR, "isLoadingMoreState", "()Z", BuildConfig.FLAVOR, "list", "setData", "(Ljava/util/List;)V", BuildConfig.FLAVOR, "getData", "()Ljava/util/List;", "Lcom/transsion/member/view/InviteUserView$c;", "binder", "setDataViewBinder", "(Lcom/transsion/member/view/InviteUserView$c;)V", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "type", "position", "listener", "setItemClicker", "(Lkotlin/jvm/functions/Function2;)V", "notifyItemInviteUserStateChange", "(I)V", "notifyAllItemInviteUserStateChange", "loadMoreEnable", "setLoadMoreEnable", "(Z)V", "newList", "onLoadMoreCompleted", "a", "I", "doneItemLayoutId", "activeItemLayoutId", "unActiveItemLayoutId", "d", "loadMoreItemLayoutId", "e", "spanCount", "f", "Ljava/util/List;", "g", "Lcom/transsion/member/view/InviteUserView$c;", "viewBinder", "h", "Lkotlin/jvm/functions/Function2;", "clickListener", "i", "F", "spaceH", "j", "Z", "k", "isLoadMoreLoading", "l", "needShowLoadMoreDismissAnimation", "Companion", "Member_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class InviteUserView<T> extends RecyclerView {
    public static final int TYPE_ITEM_ACTIVE = 2;
    public static final int TYPE_ITEM_DONE = 1;
    public static final int TYPE_ITEM_LOADMORE = 4;
    public static final int TYPE_ITEM_UNACTIVE = 3;

    /* renamed from: a, reason: from kotlin metadata */
    private int doneItemLayoutId;

    /* renamed from: b, reason: from kotlin metadata */
    private int activeItemLayoutId;

    /* renamed from: c, reason: from kotlin metadata */
    private int unActiveItemLayoutId;

    /* renamed from: d, reason: from kotlin metadata */
    private int loadMoreItemLayoutId;

    /* renamed from: e, reason: from kotlin metadata */
    private int spanCount;

    /* renamed from: f, reason: from kotlin metadata */
    private List list;

    /* renamed from: g, reason: from kotlin metadata */
    private c viewBinder;

    /* renamed from: h, reason: from kotlin metadata */
    private Function2 clickListener;

    /* renamed from: i, reason: from kotlin metadata */
    private float spaceH;

    /* renamed from: j, reason: from kotlin metadata */
    private boolean loadMoreEnable;

    /* renamed from: k, reason: from kotlin metadata */
    private boolean isLoadMoreLoading;

    /* renamed from: l, reason: from kotlin metadata */
    private boolean needShowLoadMoreDismissAnimation;
    public static final int $stable = 8;

    public static final class a extends RecyclerView.r {
        a() {
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Intrinsics.h(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i, i2);
            if (recyclerView.canScrollHorizontally(1) || !InviteUserView.this.loadMoreEnable || InviteUserView.this.isLoadMoreLoading) {
                return;
            }
            InviteUserView.this.isLoadMoreLoading = true;
            c cVar = InviteUserView.this.viewBinder;
            if (cVar != null) {
                cVar.a();
            }
            RecyclerView.a0 findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(InviteUserView.this.list.size());
            if (findViewHolderForAdapterPosition != null && (findViewHolderForAdapterPosition instanceof e) && ((e) findViewHolderForAdapterPosition).f() == 4) {
                View view = findViewHolderForAdapterPosition.itemView;
                Intrinsics.g(view, "itemView");
                uf.c.k(view);
            }
        }
    }

    public interface c {
        void a();

        int b(int i, Object obj);

        void c(e eVar, int i, Object obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class d extends RecyclerView.Adapter {
        private final int a;

        public static final class a extends AnimatorListenerAdapter {
            final /* synthetic */ e a;
            final /* synthetic */ InviteUserView b;

            a(e eVar, InviteUserView inviteUserView) {
                this.a = eVar;
                this.b = inviteUserView;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Intrinsics.h(animator, "animation");
                View view = ((RecyclerView.a0) this.a).itemView;
                Intrinsics.g(view, "itemView");
                uf.c.h(view);
                this.b.needShowLoadMoreDismissAnimation = false;
                ((RecyclerView.a0) this.a).itemView.setAlpha(1.0f);
                ((RecyclerView.a0) this.a).itemView.setScaleX(1.0f);
                ((RecyclerView.a0) this.a).itemView.setScaleY(1.0f);
                InviteUserView inviteUserView = this.b;
                int width = ((RecyclerView.a0) this.a).itemView.getWidth();
                InviteUserView inviteUserView2 = this.b;
                inviteUserView.smoothScrollBy(-(width + inviteUserView2.c(inviteUserView2.spaceH)), 0);
            }
        }

        public d(int i) {
            this.a = i;
        }

        private final View h(int i, ViewGroup viewGroup) {
            if (!InviteUserView.this.loadMoreEnable || i != 4 || InviteUserView.this.loadMoreItemLayoutId != 0) {
                View inflate = LayoutInflater.from(InviteUserView.this.getContext()).inflate(i != 1 ? i != 2 ? i != 3 ? InviteUserView.this.loadMoreItemLayoutId : InviteUserView.this.unActiveItemLayoutId : InviteUserView.this.activeItemLayoutId : InviteUserView.this.doneItemLayoutId, viewGroup, false);
                Intrinsics.e(inflate);
                return inflate;
            }
            ProgressBar progressBar = new ProgressBar(InviteUserView.this.getContext(), null, R.attr.progressBarStyle);
            InviteUserView inviteUserView = InviteUserView.this;
            progressBar.setIndeterminate(true);
            if (Build.VERSION.SDK_INT < 29) {
                return progressBar;
            }
            progressBar.setMinWidth(inviteUserView.c(50.0f));
            progressBar.setMinHeight(inviteUserView.c(50.0f));
            return progressBar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void j(InviteUserView inviteUserView, int i, e eVar, View view) {
            Function2 function2 = inviteUserView.clickListener;
            if (function2 != null) {
                function2.invoke(Integer.valueOf(i), Integer.valueOf(eVar.f()));
            }
        }

        public int getItemCount() {
            return InviteUserView.this.list.size() + (InviteUserView.this.loadMoreEnable ? 1 : 0);
        }

        public int getItemViewType(int i) {
            if (i >= InviteUserView.this.list.size()) {
                return 4;
            }
            c cVar = InviteUserView.this.viewBinder;
            if (cVar != null) {
                return cVar.b(i, InviteUserView.this.list.get(i));
            }
            return 1;
        }

        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(final e eVar, final int i) {
            Intrinsics.h(eVar, "holder");
            View view = ((RecyclerView.a0) eVar).itemView;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = this.a;
            view.setLayoutParams(layoutParams);
            if (eVar.f() != 4) {
                c cVar = InviteUserView.this.viewBinder;
                if (cVar != null) {
                    cVar.c(eVar, i, InviteUserView.this.list.get(i));
                }
                View view2 = ((RecyclerView.a0) eVar).itemView;
                final InviteUserView inviteUserView = InviteUserView.this;
                view2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.member.view.f
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        InviteUserView.d.j(InviteUserView.this, i, eVar, view3);
                    }
                });
                return;
            }
            if (InviteUserView.this.isLoadMoreLoading) {
                View view3 = ((RecyclerView.a0) eVar).itemView;
                Intrinsics.g(view3, "itemView");
                uf.c.k(view3);
                ((RecyclerView.a0) eVar).itemView.setAlpha(1.0f);
                ((RecyclerView.a0) eVar).itemView.setScaleX(1.0f);
                ((RecyclerView.a0) eVar).itemView.setScaleY(1.0f);
                return;
            }
            View view4 = ((RecyclerView.a0) eVar).itemView;
            Intrinsics.g(view4, "itemView");
            uf.c.k(view4);
            if (InviteUserView.this.needShowLoadMoreDismissAnimation) {
                ((RecyclerView.a0) eVar).itemView.animate().scaleX(0.1f).scaleY(0.1f).alpha(0.0f).setDuration(200L).setListener(new a(eVar, InviteUserView.this)).start();
            }
        }

        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public e onCreateViewHolder(ViewGroup viewGroup, int i) {
            Intrinsics.h(viewGroup, "parent");
            return new e(InviteUserView.this, h(i, viewGroup), i);
        }
    }

    public final class e extends RecyclerView.a0 {
        private final int a;
        final /* synthetic */ InviteUserView b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(InviteUserView inviteUserView, View view, int i) {
            super(view);
            Intrinsics.h(view, "itemView");
            this.b = inviteUserView;
            this.a = i;
        }

        public final int f() {
            return this.a;
        }
    }

    public final class f extends RecyclerView.l {
        private final int a;

        public f(int i) {
            this.a = i;
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.x xVar) {
            Intrinsics.h(rect, "outRect");
            Intrinsics.h(view, "view");
            Intrinsics.h(recyclerView, "parent");
            Intrinsics.h(xVar, "state");
            super.getItemOffsets(rect, view, recyclerView, xVar);
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) != 1) {
                if (childAdapterPosition == 0) {
                    rect.left = 0;
                    return;
                } else {
                    rect.left = this.a;
                    return;
                }
            }
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if (childAdapterPosition == (adapter != null ? adapter.getItemCount() : 0) - 1) {
                rect.left = 0;
            } else {
                rect.left = this.a;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public InviteUserView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public InviteUserView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public InviteUserView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        this.spanCount = 5;
        this.list = new ArrayList();
        this.spaceH = 8.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.InviteUserView);
        Intrinsics.g(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.spaceH = obtainStyledAttributes.getFloat(R$styleable.InviteUserView_iuv_inviteViewHorizontalSpace, 8.0f);
        this.doneItemLayoutId = obtainStyledAttributes.getResourceId(R$styleable.InviteUserView_iuv_doneItemLayout, R.layout.select_dialog_item);
        int resourceId = obtainStyledAttributes.getResourceId(R$styleable.InviteUserView_iuv_unActiveItemLayout, R.layout.select_dialog_item);
        this.unActiveItemLayoutId = resourceId;
        this.activeItemLayoutId = obtainStyledAttributes.getResourceId(R$styleable.InviteUserView_iuv_activeItemLayout, resourceId);
        this.loadMoreItemLayoutId = obtainStyledAttributes.getResourceId(R$styleable.InviteUserView_iuv_loadMoreItemLayout, 0);
        this.spanCount = obtainStyledAttributes.getInt(R$styleable.InviteUserView_iuv_length, 5);
        this.loadMoreEnable = obtainStyledAttributes.getBoolean(R$styleable.InviteUserView_iuv_loadMoreEnable, false);
        obtainStyledAttributes.recycle();
        setWillNotDraw(false);
        addOnScrollListener(new a());
    }

    public /* synthetic */ InviteUserView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void b() {
        View childAt;
        RecyclerView.m layoutManager = getLayoutManager();
        int i = 0;
        if (layoutManager != null && (childAt = layoutManager.getChildAt(0)) != null) {
            i = childAt.getMeasuredHeight();
        }
        int paddingTop = i + getPaddingTop() + getPaddingBottom();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = paddingTop;
        setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final int c(float dp2) {
        return (int) ((dp2 * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void d(InviteUserView inviteUserView) {
        inviteUserView.setLayoutManager(new LinearLayoutManager(inviteUserView.getContext(), 0, false));
        int measuredWidth = inviteUserView.getMeasuredWidth();
        int c2 = inviteUserView.c(inviteUserView.spaceH);
        int i = inviteUserView.spanCount;
        inviteUserView.setAdapter(new d((measuredWidth - (c2 * (i - 1))) / i));
        inviteUserView.addItemDecoration(new f(inviteUserView.c(inviteUserView.spaceH)));
        inviteUserView.b();
    }

    public final List<T> getData() {
        return this.list;
    }

    /* renamed from: isLoadingMoreState, reason: from getter */
    public final boolean getIsLoadMoreLoading() {
        return this.isLoadMoreLoading;
    }

    public final void notifyAllItemInviteUserStateChange() {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    public final void notifyItemInviteUserStateChange(int position) {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter != null) {
            adapter.notifyItemChanged(position);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onFinishInflate() {
        super/*android.view.ViewGroup*/.onFinishInflate();
        post(new Runnable() { // from class: com.transsion.member.view.c
            @Override // java.lang.Runnable
            public final void run() {
                InviteUserView.d(InviteUserView.this);
            }
        });
    }

    public final void onLoadMoreCompleted(List<? extends T> newList) {
        Intrinsics.h(newList, "newList");
        this.isLoadMoreLoading = false;
        int size = this.list.size();
        this.list.addAll(newList);
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter != null) {
            adapter.notifyItemRangeInserted(size, this.list.size());
        }
        this.needShowLoadMoreDismissAnimation = true;
        RecyclerView.Adapter adapter2 = getAdapter();
        if (adapter2 != null) {
            adapter2.notifyItemChanged(this.list.size() + 1);
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void setData(List<? extends T> list) {
        Intrinsics.h(list, "list");
        this.list = CollectionsKt.U0(list);
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    public final void setDataViewBinder(c binder) {
        Intrinsics.h(binder, "binder");
        this.viewBinder = binder;
    }

    public final void setItemClicker(Function2<? super Integer, ? super Integer, Unit> listener) {
        Intrinsics.h(listener, "listener");
        this.clickListener = listener;
    }

    public final void setLoadMoreEnable(boolean loadMoreEnable) {
        this.loadMoreEnable = loadMoreEnable;
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }
}
