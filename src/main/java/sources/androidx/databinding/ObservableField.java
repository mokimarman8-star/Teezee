package androidx.databinding;

import androidx.annotation.Nullable;
import java.io.Serializable;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class ObservableField<T> extends b implements Serializable {
    static final long serialVersionUID = 1;
    private T mValue;

    public ObservableField() {
    }

    public ObservableField(T t5) {
        this.mValue = t5;
    }

    public ObservableField(i... iVarArr) {
        super(iVarArr);
    }

    @Nullable
    public T get() {
        return this.mValue;
    }

    public void set(T t5) {
        if (t5 != this.mValue) {
            this.mValue = t5;
            notifyChange();
        }
    }
}
