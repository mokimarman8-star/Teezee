package jm;

import com.transsion.moviedetailapi.bean.Subject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class j {
    private final Subject a;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public j() {
        this(r0, 1, r0);
        Subject subject = null;
    }

    public j(Subject subject) {
        this.a = subject;
    }

    public /* synthetic */ j(Subject subject, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : subject);
    }

    public final Subject a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof j) && Intrinsics.c(this.a, ((j) obj).a);
    }

    public int hashCode() {
        Subject subject = this.a;
        if (subject == null) {
            return 0;
        }
        return subject.hashCode();
    }

    public String toString() {
        return "PosterDetailEvent(mMovieDetailBean=" + this.a + ")";
    }
}
