package androidx.coroutines;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public enum WorkInfo$State {
    ENQUEUED,
    RUNNING,
    SUCCEEDED,
    FAILED,
    BLOCKED,
    CANCELLED;

    public boolean isFinished() {
        return this == SUCCEEDED || this == FAILED || this == CANCELLED;
    }
}
