package com.bytedance.adsdk.ugeno.Dq;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class sP {
    private final DataSetObservable Sj = new DataSetObservable();
    private DataSetObserver sP;

    public float Sj(int i) {
        return 1.0f;
    }

    public abstract int Sj();

    public int Sj(Object obj) {
        return -1;
    }

    @Deprecated
    public Object Sj(View view, int i) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    public Object Sj(ViewGroup viewGroup, int i) {
        return Sj((View) viewGroup, i);
    }

    void Sj(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.sP = dataSetObserver;
        }
    }

    @Deprecated
    public void Sj(View view, int i, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void Sj(ViewGroup viewGroup, int i, Object obj) {
        Sj((View) viewGroup, i, obj);
    }

    public abstract boolean Sj(View view, Object obj);

    public void TKC() {
        synchronized (this) {
            try {
                DataSetObserver dataSetObserver = this.sP;
                if (dataSetObserver != null) {
                    dataSetObserver.onChanged();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.Sj.notifyChanged();
    }

    public Parcelable sP() {
        return null;
    }
}
