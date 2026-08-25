package h3;

import com.google.common.collect.ImmutableList;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final ImmutableList f15478a;

    /* renamed from: b, reason: collision with root package name */
    public final long f15479b;

    /* renamed from: c, reason: collision with root package name */
    public final long f15480c;

    /* renamed from: d, reason: collision with root package name */
    public final long f15481d;

    public e(List list, long j5, long j6) {
        this.f15478a = ImmutableList.copyOf(list);
        this.f15479b = j5;
        this.f15480c = j6;
        long j7 = -9223372036854775807L;
        if (j5 != -9223372036854775807L && j6 != -9223372036854775807L) {
            j7 = j5 + j6;
        }
        this.f15481d = j7;
    }
}
