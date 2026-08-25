package androidx.databinding;

import androidx.annotation.NonNull;
import androidx.databinding.i;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class a implements i {
    private transient l mCallbacks;

    @Override // androidx.databinding.i
    public void addOnPropertyChangedCallback(@NonNull i.a aVar) {
        synchronized (this) {
            try {
                if (this.mCallbacks == null) {
                    this.mCallbacks = new l();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.mCallbacks.a(aVar);
    }

    public void notifyChange() {
        synchronized (this) {
            try {
                l lVar = this.mCallbacks;
                if (lVar == null) {
                    return;
                }
                lVar.d(this, 0, null);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void notifyPropertyChanged(int i5) {
        synchronized (this) {
            try {
                l lVar = this.mCallbacks;
                if (lVar == null) {
                    return;
                }
                lVar.d(this, i5, null);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void removeOnPropertyChangedCallback(@NonNull i.a aVar) {
        synchronized (this) {
            try {
                l lVar = this.mCallbacks;
                if (lVar == null) {
                    return;
                }
                lVar.j(aVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
