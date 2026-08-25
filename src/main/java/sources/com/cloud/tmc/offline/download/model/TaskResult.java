package com.cloud.tmc.offline.download.model;

import com.cloud.tmc.kernel.constants.TmcConstants;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

@kotlin.Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0003\u0018\u0019\u001aB=\b\u0004\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u0000\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u0017\u001a\u00020\tH\u0016R\u0015\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0016\u0082\u0001\u0003\u001b\u001c\u001d¨\u0006\u001e"}, d2 = {"Lcom/cloud/tmc/offline/download/model/TaskResult;", "T", "", TmcConstants.KEY_BRIDGE_RESULT_DATA, "delay", "", "errorCode", "", "errorMsg", "", "isTrace", "", "(Ljava/lang/Object;JILjava/lang/String;Z)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getDelay", "()J", "getErrorCode", "()I", "getErrorMsg", "()Ljava/lang/String;", "()Z", "toString", "Failure", "Retry", "Success", "Lcom/cloud/tmc/offline/download/model/TaskResult$Failure;", "Lcom/cloud/tmc/offline/download/model/TaskResult$Retry;", "Lcom/cloud/tmc/offline/download/model/TaskResult$Success;", "com.cloud.tmc.offline_download"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public abstract class TaskResult<T> {
    private final T data;
    private final long delay;
    private final int errorCode;
    private final String errorMsg;
    private final boolean isTrace;

    @kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/cloud/tmc/offline/download/model/TaskResult$Failure;", "Lcom/cloud/tmc/offline/download/model/TaskResult;", "", "errorCode", "", "errorMsg", "isTrace", "", "(ILjava/lang/String;Z)V", "com.cloud.tmc.offline_download"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Failure extends TaskResult<String> {
        public Failure() {
            this(0, null, false, 7, null);
        }

        public Failure(int i, String str, boolean z) {
            super(null, 0L, i, str, z, 3, null);
        }

        public /* synthetic */ Failure(int i, String str, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 1000 : i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? false : z);
        }
    }

    @kotlin.Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/cloud/tmc/offline/download/model/TaskResult$Retry;", "Lcom/cloud/tmc/offline/download/model/TaskResult;", "", "delay", "", "(J)V", "com.cloud.tmc.offline_download"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Retry extends TaskResult<String> {
        public Retry() {
            this(0L, 1, null);
        }

        public Retry(long j) {
            super(null, j, TaskResultKt.RETRY, null, false, 25, null);
        }

        public /* synthetic */ Retry(long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 100L : j);
        }
    }

    @kotlin.Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u0001\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/cloud/tmc/offline/download/model/TaskResult$Success;", "T", "Lcom/cloud/tmc/offline/download/model/TaskResult;", TmcConstants.KEY_BRIDGE_RESULT_DATA, "isTrace", "", "(Ljava/lang/Object;Z)V", "com.cloud.tmc.offline_download"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Success<T> extends TaskResult<T> {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Success() {
            this(r2, false, 3, r2);
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        public Success(T t, boolean z) {
            super(t, 0L, 200, null, z, 10, null);
        }

        public /* synthetic */ Success(Object obj, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : obj, (i & 2) != 0 ? false : z);
        }
    }

    private TaskResult(T t, long j, int i, String str, boolean z) {
        this.data = t;
        this.delay = j;
        this.errorCode = i;
        this.errorMsg = str;
        this.isTrace = z;
    }

    public /* synthetic */ TaskResult(Object obj, long j, int i, String str, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : obj, (i2 & 2) != 0 ? 100L : j, (i2 & 4) != 0 ? 200 : i, (i2 & 8) == 0 ? str : null, (i2 & 16) != 0 ? false : z, null);
    }

    public /* synthetic */ TaskResult(Object obj, long j, int i, String str, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, j, i, str, z);
    }

    public final T getData() {
        return this.data;
    }

    public final long getDelay() {
        return this.delay;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    /* renamed from: isTrace, reason: from getter */
    public final boolean getIsTrace() {
        return this.isTrace;
    }

    public String toString() {
        if (this instanceof Success) {
            return "Success[data=" + this.data + "]";
        }
        if (!(this instanceof Failure)) {
            if (!(this instanceof Retry)) {
                throw new NoWhenBranchMatchedException();
            }
            return "Retry[delay=" + this.delay + "]";
        }
        return "Failure[errorCode=" + this.errorCode + ", errorMsg=" + this.errorMsg + "]";
    }
}
