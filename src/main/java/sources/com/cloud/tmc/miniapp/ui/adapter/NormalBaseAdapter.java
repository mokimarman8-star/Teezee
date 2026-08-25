package com.cloud.tmc.miniapp.ui.adapter;

import android.content.Context;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.base.BaseAdapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public abstract class NormalBaseAdapter<T> extends BaseAdapter<NormalBaseAdapter<T>.NormalViewHolder> {
    private List<T> dataSet;

    public abstract class NormalViewHolder extends BaseAdapter<NormalBaseAdapter<T>.NormalViewHolder>.BaseViewHolder {
        public NormalViewHolder(int i) {
            super(NormalBaseAdapter.this, i);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NormalBaseAdapter(Context context) {
        super(context);
        Intrinsics.h(context, "context");
        this.dataSet = new ArrayList();
    }

    public void addData(List<T> list) {
        if (list != null) {
            try {
                if (list.isEmpty()) {
                    return;
                }
                this.dataSet.addAll(list);
                notifyItemRangeInserted(this.dataSet.size() - list.size(), list.size());
            } catch (Throwable th) {
                TmcLogger.e("", th);
            }
        }
    }

    public void addItem(int i, T t) {
        if (i < this.dataSet.size()) {
            this.dataSet.add(i, t);
        } else {
            this.dataSet.add(t);
            i = this.dataSet.size() - 1;
        }
        notifyItemInserted(i);
    }

    public void addItem(T t) {
        addItem(this.dataSet.size(), t);
    }

    public void clearData() {
        this.dataSet.clear();
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.dataSet.size();
    }

    public List<T> getData() {
        return this.dataSet;
    }

    public T getItem(int i) {
        return this.dataSet.get(i);
    }

    public int getItemCount() {
        return getCount();
    }

    public void removeItem(int i) {
        this.dataSet.remove(i);
        notifyItemRemoved(i);
    }

    public void setData(List<T> list) {
        if (list == null) {
            this.dataSet.clear();
        } else {
            this.dataSet = list;
        }
        notifyDataSetChanged();
    }
}
