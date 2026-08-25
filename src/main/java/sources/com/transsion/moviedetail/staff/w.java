package com.transsion.moviedetail.staff;

import android.os.SystemClock;
import android.util.SparseArray;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Staff;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class w {
    private List c;
    private int a = -1;
    private int b = -1;
    private SparseArray d = new SparseArray();
    private HashSet e = new HashSet();

    public final int a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public final void c(int i, long j) {
        String str;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("reportBrowseEvent  staff----  position:");
            sb.append(i);
            sb.append("  duration:");
            sb.append(j);
            List list = this.c;
            Staff staff = list != null ? (Staff) list.get(i) : null;
            if (this.e.add(staff != null ? staff.getStaffId() : null)) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("item_type", "staff");
                if (staff == null || (str = staff.getStaffId()) == null) {
                    str = BuildConfig.FLAVOR;
                }
                linkedHashMap.put("staff_id", str);
                linkedHashMap.put("position", String.valueOf(i));
                linkedHashMap.put("browse_duration", String.valueOf(j));
                com.transsion.baselib.helper.a.a.e("staff_info", linkedHashMap);
            }
        } catch (Exception unused) {
        }
    }

    public final void d(int i, int i2) {
        int i3 = this.a;
        if (i3 == i && this.b == i2) {
            return;
        }
        if (i3 >= 0 && this.b >= 0) {
            ArrayList arrayList = new ArrayList();
            IntIterator a = androidx.core.util.k.a(this.d);
            while (a.hasNext()) {
                int intValue = ((Number) a.next()).intValue();
                if (i > intValue || intValue > i2) {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    Object obj = this.d.get(intValue);
                    Intrinsics.g(obj, "get(...)");
                    c(intValue, elapsedRealtime - ((Number) obj).longValue());
                    arrayList.add(Integer.valueOf(intValue));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.d.remove(((Number) it.next()).intValue());
            }
            if (i <= i2) {
                int i4 = i;
                while (true) {
                    if (this.d.get(i4) == null) {
                        this.d.put(i4, Long.valueOf(SystemClock.elapsedRealtime()));
                    }
                    if (i4 == i2) {
                        break;
                    } else {
                        i4++;
                    }
                }
            }
        } else if (i <= i2) {
            int i5 = i;
            while (true) {
                this.d.put(i5, Long.valueOf(SystemClock.elapsedRealtime()));
                if (i5 == i2) {
                    break;
                } else {
                    i5++;
                }
            }
        }
        this.a = i;
        this.b = i2;
    }

    public final void e(List list) {
        this.c = list;
    }
}
