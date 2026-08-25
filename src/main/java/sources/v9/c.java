package v9;

import com.google.android.exoplayer2.source.b0;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class c implements b0 {
    protected final b0[] a;

    public c(b0[] b0VarArr) {
        this.a = b0VarArr;
    }

    public boolean continueLoading(long j) {
        boolean z;
        boolean z2 = false;
        do {
            long nextLoadPositionUs = getNextLoadPositionUs();
            if (nextLoadPositionUs == Long.MIN_VALUE) {
                break;
            }
            z = false;
            for (b0 b0Var : this.a) {
                long nextLoadPositionUs2 = b0Var.getNextLoadPositionUs();
                boolean z3 = nextLoadPositionUs2 != Long.MIN_VALUE && nextLoadPositionUs2 <= j;
                if (nextLoadPositionUs2 == nextLoadPositionUs || z3) {
                    z |= b0Var.continueLoading(j);
                }
            }
            z2 |= z;
        } while (z);
        return z2;
    }

    public final long getBufferedPositionUs() {
        long j = Long.MAX_VALUE;
        for (b0 b0Var : this.a) {
            long bufferedPositionUs = b0Var.getBufferedPositionUs();
            if (bufferedPositionUs != Long.MIN_VALUE) {
                j = Math.min(j, bufferedPositionUs);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    public final long getNextLoadPositionUs() {
        long j = Long.MAX_VALUE;
        for (b0 b0Var : this.a) {
            long nextLoadPositionUs = b0Var.getNextLoadPositionUs();
            if (nextLoadPositionUs != Long.MIN_VALUE) {
                j = Math.min(j, nextLoadPositionUs);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    public boolean isLoading() {
        for (b0 b0Var : this.a) {
            if (b0Var.isLoading()) {
                return true;
            }
        }
        return false;
    }

    public final void reevaluateBuffer(long j) {
        for (b0 b0Var : this.a) {
            b0Var.reevaluateBuffer(j);
        }
    }
}
