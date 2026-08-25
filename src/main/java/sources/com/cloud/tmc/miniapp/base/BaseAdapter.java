package com.cloud.tmc.miniapp.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cloud.tmc.miniapp.action.ResourcesAction;
import com.cloud.tmc.miniapp.base.BaseAdapter;
import com.cloud.tmc.miniapp.base.BaseAdapter.BaseViewHolder;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public abstract class BaseAdapter<VH extends BaseAdapter<VH>.BaseViewHolder> extends RecyclerView.Adapter implements ResourcesAction {
    private final Lazy childClickListeners$delegate;
    private final Lazy childLongClickListeners$delegate;
    private final Context context;
    private OnItemClickListener itemClickListener;
    private OnItemLongClickListener itemLongClickListener;
    private int positionOffset;
    private RecyclerView recyclerView;

    public abstract class BaseViewHolder extends RecyclerView.a0 implements View.OnClickListener, View.OnLongClickListener {
        public final /* synthetic */ BaseAdapter<VH> this$0;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public BaseViewHolder(BaseAdapter baseAdapter, int i) {
            this(baseAdapter, r5);
            View inflate = LayoutInflater.from(baseAdapter.getContext()).inflate(i, (ViewGroup) baseAdapter.recyclerView, false);
            Intrinsics.g(inflate, "from(getContext()).infla…(id, recyclerView, false)");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BaseViewHolder(BaseAdapter baseAdapter, View view) {
            super(view);
            Intrinsics.h(view, "itemView");
            this.this$0 = baseAdapter;
            if (baseAdapter.itemClickListener != null) {
                view.setOnClickListener(this);
            }
            if (baseAdapter.itemLongClickListener != null) {
                view.setOnLongClickListener(this);
            }
            int size = baseAdapter.getChildClickListeners().size();
            for (int i = 0; i < size; i++) {
                View findViewById = findViewById(this.this$0.getChildClickListeners().keyAt(i));
                if (findViewById != null) {
                    findViewById.setOnClickListener(this);
                }
            }
            int size2 = this.this$0.getChildLongClickListeners().size();
            for (int i2 = 0; i2 < size2; i2++) {
                View findViewById2 = findViewById(this.this$0.getChildLongClickListeners().keyAt(i2));
                if (findViewById2 != null) {
                    findViewById2.setOnLongClickListener(this);
                }
            }
        }

        public <V extends View> V findViewById(int i) {
            return (V) getItemView().findViewById(i);
        }

        public View getItemView() {
            View view = ((RecyclerView.a0) this).itemView;
            Intrinsics.g(view, "itemView");
            return view;
        }

        public int getViewHolderPosition() {
            return ((BaseAdapter) this.this$0).positionOffset + getLayoutPosition();
        }

        public abstract void onBindView(int i);

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intrinsics.h(view, "view");
            int viewHolderPosition = getViewHolderPosition();
            if (viewHolderPosition < 0 || viewHolderPosition >= this.this$0.getItemCount()) {
                return;
            }
            if (view == getItemView()) {
                OnItemClickListener onItemClickListener = ((BaseAdapter) this.this$0).itemClickListener;
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(((BaseAdapter) this.this$0).recyclerView, view, viewHolderPosition);
                    return;
                }
                return;
            }
            OnChildClickListener onChildClickListener = (OnChildClickListener) this.this$0.getChildClickListeners().get(view.getId());
            if (onChildClickListener != null) {
                onChildClickListener.onChildClick(((BaseAdapter) this.this$0).recyclerView, view, viewHolderPosition);
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            Intrinsics.h(view, "view");
            int viewHolderPosition = getViewHolderPosition();
            if (viewHolderPosition >= 0 && viewHolderPosition < this.this$0.getItemCount()) {
                if (view == getItemView()) {
                    if (((BaseAdapter) this.this$0).itemLongClickListener == null) {
                        return false;
                    }
                    OnItemLongClickListener onItemLongClickListener = ((BaseAdapter) this.this$0).itemLongClickListener;
                    Intrinsics.e(onItemLongClickListener);
                    return onItemLongClickListener.onItemLongClick(((BaseAdapter) this.this$0).recyclerView, view, viewHolderPosition);
                }
                OnChildLongClickListener onChildLongClickListener = (OnChildLongClickListener) this.this$0.getChildLongClickListeners().get(view.getId());
                if (onChildLongClickListener != null) {
                    return onChildLongClickListener.onChildLongClick(((BaseAdapter) this.this$0).recyclerView, view, viewHolderPosition);
                }
            }
            return false;
        }
    }

    public interface OnChildClickListener {
        void onChildClick(RecyclerView recyclerView, View view, int i);
    }

    public interface OnChildLongClickListener {
        boolean onChildLongClick(RecyclerView recyclerView, View view, int i);
    }

    public interface OnItemClickListener {
        void onItemClick(RecyclerView recyclerView, View view, int i);
    }

    public interface OnItemLongClickListener {
        boolean onItemLongClick(RecyclerView recyclerView, View view, int i);
    }

    public BaseAdapter(Context context) {
        Intrinsics.h(context, "context");
        this.context = context;
        this.childClickListeners$delegate = LazyKt.b(new Function0<SparseArray<OnChildClickListener>>() { // from class: com.cloud.tmc.miniapp.base.BaseAdapter$childClickListeners$2
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final SparseArray<BaseAdapter.OnChildClickListener> m22invoke() {
                return new SparseArray<>();
            }
        });
        this.childLongClickListeners$delegate = LazyKt.b(new Function0<SparseArray<OnChildLongClickListener>>() { // from class: com.cloud.tmc.miniapp.base.BaseAdapter$childLongClickListeners$2
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final SparseArray<BaseAdapter.OnChildLongClickListener> m23invoke() {
                return new SparseArray<>();
            }
        });
    }

    private final void checkRecyclerViewState() {
        if (this.recyclerView != null) {
            throw new IllegalStateException("are you ok?");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SparseArray<OnChildClickListener> getChildClickListeners() {
        return (SparseArray) this.childClickListeners$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SparseArray<OnChildLongClickListener> getChildLongClickListeners() {
        return (SparseArray) this.childLongClickListeners$delegate.getValue();
    }

    public RecyclerView.m generateDefaultLayoutManager(Context context) {
        Intrinsics.h(context, "context");
        return new LinearLayoutManager(context);
    }

    @Override // com.cloud.tmc.miniapp.action.ResourcesAction
    public int getColor(int i) {
        return ResourcesAction.DefaultImpls.getColor(this, i);
    }

    @Override // com.cloud.tmc.miniapp.action.ResourcesAction
    public Context getContext() {
        return this.context;
    }

    @Override // com.cloud.tmc.miniapp.action.ResourcesAction
    public Drawable getDrawable(int i) {
        return ResourcesAction.DefaultImpls.getDrawable(this, i);
    }

    public RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    @Override // com.cloud.tmc.miniapp.action.ResourcesAction
    public Resources getResources() {
        return ResourcesAction.DefaultImpls.getResources(this);
    }

    @Override // com.cloud.tmc.miniapp.action.ResourcesAction
    public String getString(int i) {
        return ResourcesAction.DefaultImpls.getString(this, i);
    }

    @Override // com.cloud.tmc.miniapp.action.ResourcesAction
    public String getString(int i, Object... objArr) {
        return ResourcesAction.DefaultImpls.getString(this, i, objArr);
    }

    @Override // com.cloud.tmc.miniapp.action.ResourcesAction
    public <S> S getSystemService(Class<S> cls) {
        return (S) ResourcesAction.DefaultImpls.getSystemService(this, cls);
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        RecyclerView recyclerView2;
        Intrinsics.h(recyclerView, "recyclerView");
        this.recyclerView = recyclerView;
        if ((recyclerView != null ? recyclerView.getLayoutManager() : null) != null || (recyclerView2 = this.recyclerView) == null) {
            return;
        }
        recyclerView2.setLayoutManager(generateDefaultLayoutManager(this.context));
    }

    public void onBindViewHolder(VH vh, int i) {
        Intrinsics.h(vh, "holder");
        this.positionOffset = i - vh.getAdapterPosition();
        vh.onBindView(i);
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        Intrinsics.h(recyclerView, "recyclerView");
        this.recyclerView = null;
    }

    public void setOnChildClickListener(int i, OnChildClickListener onChildClickListener) {
        checkRecyclerViewState();
        getChildClickListeners().put(i, onChildClickListener);
    }

    public void setOnChildLongClickListener(int i, OnChildLongClickListener onChildLongClickListener) {
        checkRecyclerViewState();
        getChildLongClickListeners().put(i, onChildLongClickListener);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        checkRecyclerViewState();
        this.itemClickListener = onItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        checkRecyclerViewState();
        this.itemLongClickListener = onItemLongClickListener;
    }
}
