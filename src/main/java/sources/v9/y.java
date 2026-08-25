package v9;

import android.os.Bundle;
import com.google.android.exoplayer2.k;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class y implements com.google.android.exoplayer2.k {
    public static final y d = new y(new w[0]);
    public static final k.a e = new k.a() { // from class: v9.x
        public final com.google.android.exoplayer2.k a(Bundle bundle) {
            y e2;
            e2 = y.e(bundle);
            return e2;
        }
    };
    public final int a;
    private final ImmutableList b;
    private int c;

    public y(w... wVarArr) {
        this.b = ImmutableList.copyOf(wVarArr);
        this.a = wVarArr.length;
        f();
    }

    private static String d(int i) {
        return Integer.toString(i, 36);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ y e(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(d(0));
        return parcelableArrayList == null ? new y(new w[0]) : new y((w[]) com.google.android.exoplayer2.util.d.b(w.f, parcelableArrayList).toArray(new w[0]));
    }

    private void f() {
        int i = 0;
        while (i < this.b.size()) {
            int i2 = i + 1;
            for (int i3 = i2; i3 < this.b.size(); i3++) {
                if (((w) this.b.get(i)).equals(this.b.get(i3))) {
                    com.google.android.exoplayer2.util.s.d("TrackGroupArray", "", new IllegalArgumentException("Multiple identical TrackGroups added to one TrackGroupArray."));
                }
            }
            i = i2;
        }
    }

    public w b(int i) {
        return (w) this.b.get(i);
    }

    public int c(w wVar) {
        int indexOf = this.b.indexOf(wVar);
        if (indexOf >= 0) {
            return indexOf;
        }
        return -1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || y.class != obj.getClass()) {
            return false;
        }
        y yVar = (y) obj;
        return this.a == yVar.a && this.b.equals(yVar.b);
    }

    public int hashCode() {
        if (this.c == 0) {
            this.c = this.b.hashCode();
        }
        return this.c;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(d(0), com.google.android.exoplayer2.util.d.d(this.b));
        return bundle;
    }
}
