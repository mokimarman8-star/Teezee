package n6;

import android.util.SparseIntArray;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class a {
    private SparseIntArray a;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a() {
        this(r0, 1, r0);
        SparseIntArray sparseIntArray = null;
    }

    public a(SparseIntArray sparseIntArray) {
        Intrinsics.h(sparseIntArray, "layouts");
        this.a = sparseIntArray;
    }

    public /* synthetic */ a(SparseIntArray sparseIntArray, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new SparseIntArray() : sparseIntArray);
    }

    public abstract int a(List list, int i);

    public final int b(int i) {
        int i2 = this.a.get(i);
        if (i2 != 0) {
            return i2;
        }
        throw new IllegalArgumentException(("ViewType: " + i + " found layoutResId，please use registerItemType() first!").toString());
    }
}
