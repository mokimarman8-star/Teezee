package androidx.compose.runtime.collection;

import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class c {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(List list, int i5) {
        int size = list.size();
        if (i5 < 0 || i5 >= size) {
            throw new IndexOutOfBoundsException("Index " + i5 + " is out of bounds. The list has " + size + " elements.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(List list, int i5, int i6) {
        int size = list.size();
        if (i5 > i6) {
            throw new IllegalArgumentException("Indices are out of order. fromIndex (" + i5 + ") is greater than toIndex (" + i6 + ").");
        }
        if (i5 < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + i5 + ") is less than 0.");
        }
        if (i6 <= size) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i6 + ") is more than than the list size (" + size + ')');
    }
}
