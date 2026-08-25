package androidx.recyclerview.widget;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class RecyclerView$j {
    public static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
    public static final int FLAG_CHANGED = 2;
    public static final int FLAG_INVALIDATED = 4;
    public static final int FLAG_MOVED = 2048;
    public static final int FLAG_REMOVED = 8;
    private b mListener = null;
    private ArrayList<a> mFinishedListeners = new ArrayList<>();
    private long mAddDuration = 120;
    private long mRemoveDuration = 120;
    private long mMoveDuration = 250;
    private long mChangeDuration = 250;

    public interface a {
        void a();
    }

    interface b {
        void a(RecyclerView$a0 recyclerView$a0);
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public int f12831a;

        /* renamed from: b, reason: collision with root package name */
        public int f12832b;

        /* renamed from: c, reason: collision with root package name */
        public int f12833c;

        /* renamed from: d, reason: collision with root package name */
        public int f12834d;

        public c a(RecyclerView$a0 recyclerView$a0) {
            return b(recyclerView$a0, 0);
        }

        public c b(RecyclerView$a0 recyclerView$a0, int i5) {
            View view = recyclerView$a0.itemView;
            this.f12831a = view.getLeft();
            this.f12832b = view.getTop();
            this.f12833c = view.getRight();
            this.f12834d = view.getBottom();
            return this;
        }
    }

    static int buildAdapterChangeFlagsForAnimations(RecyclerView$a0 recyclerView$a0) {
        int i5 = recyclerView$a0.mFlags;
        int i6 = i5 & 14;
        if (recyclerView$a0.isInvalid()) {
            return 4;
        }
        if ((i5 & 4) != 0) {
            return i6;
        }
        int oldPosition = recyclerView$a0.getOldPosition();
        int absoluteAdapterPosition = recyclerView$a0.getAbsoluteAdapterPosition();
        return (oldPosition == -1 || absoluteAdapterPosition == -1 || oldPosition == absoluteAdapterPosition) ? i6 : i6 | 2048;
    }

    public abstract boolean animateAppearance(RecyclerView$a0 recyclerView$a0, c cVar, c cVar2);

    public abstract boolean animateChange(RecyclerView$a0 recyclerView$a0, RecyclerView$a0 recyclerView$a02, c cVar, c cVar2);

    public abstract boolean animateDisappearance(RecyclerView$a0 recyclerView$a0, c cVar, c cVar2);

    public abstract boolean animatePersistence(RecyclerView$a0 recyclerView$a0, c cVar, c cVar2);

    public boolean canReuseUpdatedViewHolder(RecyclerView$a0 recyclerView$a0) {
        return true;
    }

    public boolean canReuseUpdatedViewHolder(RecyclerView$a0 recyclerView$a0, List list) {
        return canReuseUpdatedViewHolder(recyclerView$a0);
    }

    public final void dispatchAnimationFinished(@NonNull RecyclerView$a0 recyclerView$a0) {
        onAnimationFinished(recyclerView$a0);
        b bVar = this.mListener;
        if (bVar != null) {
            bVar.a(recyclerView$a0);
        }
    }

    public final void dispatchAnimationStarted(@NonNull RecyclerView$a0 recyclerView$a0) {
        onAnimationStarted(recyclerView$a0);
    }

    public final void dispatchAnimationsFinished() {
        if (this.mFinishedListeners.size() <= 0) {
            this.mFinishedListeners.clear();
        } else {
            android.support.v4.media.session.c.a(this.mFinishedListeners.get(0));
            throw null;
        }
    }

    public abstract void endAnimation(RecyclerView$a0 recyclerView$a0);

    public abstract void endAnimations();

    public long getAddDuration() {
        return this.mAddDuration;
    }

    public long getChangeDuration() {
        return this.mChangeDuration;
    }

    public long getMoveDuration() {
        return this.mMoveDuration;
    }

    public long getRemoveDuration() {
        return this.mRemoveDuration;
    }

    public abstract boolean isRunning();

    public final boolean isRunning(@Nullable a aVar) {
        boolean isRunning = isRunning();
        if (aVar != null) {
            if (isRunning) {
                this.mFinishedListeners.add(aVar);
            } else {
                aVar.a();
            }
        }
        return isRunning;
    }

    @NonNull
    public c obtainHolderInfo() {
        return new c();
    }

    public void onAnimationFinished(@NonNull RecyclerView$a0 recyclerView$a0) {
    }

    public void onAnimationStarted(@NonNull RecyclerView$a0 recyclerView$a0) {
    }

    @NonNull
    public c recordPostLayoutInformation(@NonNull RecyclerView$x recyclerView$x, @NonNull RecyclerView$a0 recyclerView$a0) {
        return obtainHolderInfo().a(recyclerView$a0);
    }

    @NonNull
    public c recordPreLayoutInformation(@NonNull RecyclerView$x recyclerView$x, @NonNull RecyclerView$a0 recyclerView$a0, int i5, @NonNull List<Object> list) {
        return obtainHolderInfo().a(recyclerView$a0);
    }

    public abstract void runPendingAnimations();

    public void setAddDuration(long j5) {
        this.mAddDuration = j5;
    }

    public void setChangeDuration(long j5) {
        this.mChangeDuration = j5;
    }

    void setListener(b bVar) {
        this.mListener = bVar;
    }

    public void setMoveDuration(long j5) {
        this.mMoveDuration = j5;
    }

    public void setRemoveDuration(long j5) {
        this.mRemoveDuration = j5;
    }
}
