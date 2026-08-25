package com.cloud.tmc.integration.processor.intercept;

import android.content.Context;
import com.cloud.tmc.integration.BuildConfig;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.cloud.tmc.integration.processor.IBackPressedProcessor;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.node.AppNode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003\u0010\u0011\u0012J,\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&¨\u0006\u0013"}, d2 = {"Lcom/cloud/tmc/integration/processor/intercept/IBackPressedIntercept;", "", "backResult", "Lcom/cloud/tmc/integration/processor/intercept/IBackPressedIntercept$Result;", "app", "Lcom/cloud/tmc/integration/structure/App;", "isIntercept", "", "intercept", "isRemove", "getInterceptName", "", "getPriority", "", "chain", "Lcom/cloud/tmc/integration/processor/intercept/IBackPressedIntercept$Chain;", "Chain", "Params", "Result", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public interface IBackPressedIntercept {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/cloud/tmc/integration/processor/intercept/IBackPressedIntercept$Chain;", "", "params", "Lcom/cloud/tmc/integration/processor/intercept/IBackPressedIntercept$Params;", "proceed", "Lcom/cloud/tmc/integration/processor/intercept/IBackPressedIntercept$Result;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Chain {
        /* renamed from: params */
        Params getParams();

        Result proceed(Params params);
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static Result backResult(IBackPressedIntercept iBackPressedIntercept, App app, boolean z, IBackPressedIntercept iBackPressedIntercept2, boolean z2) {
            IBackPressedProcessor backPressedProcessor;
            Intrinsics.h(iBackPressedIntercept2, "intercept");
            if (z2 && app != null && (backPressedProcessor = app.getBackPressedProcessor()) != null) {
                backPressedProcessor.removeInterceptors(iBackPressedIntercept2);
            }
            return new Result(z);
        }

        public static /* synthetic */ Result backResult$default(IBackPressedIntercept iBackPressedIntercept, App app, boolean z, IBackPressedIntercept iBackPressedIntercept2, boolean z2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: backResult");
            }
            if ((i & 8) != 0) {
                z2 = true;
            }
            return iBackPressedIntercept.backResult(app, z, iBackPressedIntercept2, z2);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b \b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010$\u001a\u00020\tHÆ\u0003J\t\u0010%\u001a\u00020\u000bHÆ\u0003JA\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010'\u001a\u00020\t2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u000bHÖ\u0001J\t\u0010*\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006+"}, d2 = {"Lcom/cloud/tmc/integration/processor/intercept/IBackPressedIntercept$Params;", "", "context", "Landroid/content/Context;", "appId", "", "app", "Lcom/cloud/tmc/integration/structure/node/AppNode;", "autoExit", "", TmcStartParams.KEY_FROM_TYPE, "", "(Landroid/content/Context;Ljava/lang/String;Lcom/cloud/tmc/integration/structure/node/AppNode;ZI)V", "getApp", "()Lcom/cloud/tmc/integration/structure/node/AppNode;", "setApp", "(Lcom/cloud/tmc/integration/structure/node/AppNode;)V", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "getAutoExit", "()Z", "setAutoExit", "(Z)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getFromType", "()I", "setFromType", "(I)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Params {
        private AppNode app;
        private String appId;
        private boolean autoExit;
        private Context context;
        private int fromType;

        public Params() {
            this(null, null, null, false, 0, 31, null);
        }

        public Params(Context context, String str, AppNode appNode, boolean z, int i) {
            this.context = context;
            this.appId = str;
            this.app = appNode;
            this.autoExit = z;
            this.fromType = i;
        }

        public /* synthetic */ Params(Context context, String str, AppNode appNode, boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? null : context, (i2 & 2) != 0 ? null : str, (i2 & 4) == 0 ? appNode : null, (i2 & 8) != 0 ? false : z, (i2 & 16) != 0 ? 0 : i);
        }

        public static /* synthetic */ Params copy$default(Params params, Context context, String str, AppNode appNode, boolean z, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                context = params.context;
            }
            if ((i2 & 2) != 0) {
                str = params.appId;
            }
            String str2 = str;
            if ((i2 & 4) != 0) {
                appNode = params.app;
            }
            AppNode appNode2 = appNode;
            if ((i2 & 8) != 0) {
                z = params.autoExit;
            }
            boolean z2 = z;
            if ((i2 & 16) != 0) {
                i = params.fromType;
            }
            return params.copy(context, str2, appNode2, z2, i);
        }

        /* renamed from: component1, reason: from getter */
        public final Context getContext() {
            return this.context;
        }

        /* renamed from: component2, reason: from getter */
        public final String getAppId() {
            return this.appId;
        }

        /* renamed from: component3, reason: from getter */
        public final AppNode getApp() {
            return this.app;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getAutoExit() {
            return this.autoExit;
        }

        /* renamed from: component5, reason: from getter */
        public final int getFromType() {
            return this.fromType;
        }

        public final Params copy(Context context, String appId, AppNode app, boolean autoExit, int fromType) {
            return new Params(context, appId, app, autoExit, fromType);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Params)) {
                return false;
            }
            Params params = (Params) other;
            return Intrinsics.c(this.context, params.context) && Intrinsics.c(this.appId, params.appId) && Intrinsics.c(this.app, params.app) && this.autoExit == params.autoExit && this.fromType == params.fromType;
        }

        public final AppNode getApp() {
            return this.app;
        }

        public final String getAppId() {
            return this.appId;
        }

        public final boolean getAutoExit() {
            return this.autoExit;
        }

        public final Context getContext() {
            return this.context;
        }

        public final int getFromType() {
            return this.fromType;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            Context context = this.context;
            int hashCode = (context == null ? 0 : context.hashCode()) * 31;
            String str = this.appId;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            AppNode appNode = this.app;
            int hashCode3 = (hashCode2 + (appNode != null ? appNode.hashCode() : 0)) * 31;
            boolean z = this.autoExit;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            return ((hashCode3 + i) * 31) + this.fromType;
        }

        public final void setApp(AppNode appNode) {
            this.app = appNode;
        }

        public final void setAppId(String str) {
            this.appId = str;
        }

        public final void setAutoExit(boolean z) {
            this.autoExit = z;
        }

        public final void setContext(Context context) {
            this.context = context;
        }

        public final void setFromType(int i) {
            this.fromType = i;
        }

        public String toString() {
            return "Params(context=" + this.context + ", appId=" + this.appId + ", app=" + this.app + ", autoExit=" + this.autoExit + ", fromType=" + this.fromType + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0005\"\u0004\b\u0006\u0010\u0004¨\u0006\u000f"}, d2 = {"Lcom/cloud/tmc/integration/processor/intercept/IBackPressedIntercept$Result;", "", "isIntercept", "", "(Z)V", "()Z", "setIntercept", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Result {
        private boolean isIntercept;

        public Result() {
            this(false, 1, null);
        }

        public Result(boolean z) {
            this.isIntercept = z;
        }

        public /* synthetic */ Result(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z);
        }

        public static /* synthetic */ Result copy$default(Result result, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = result.isIntercept;
            }
            return result.copy(z);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsIntercept() {
            return this.isIntercept;
        }

        public final Result copy(boolean isIntercept) {
            return new Result(isIntercept);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Result) && this.isIntercept == ((Result) other).isIntercept;
        }

        public int hashCode() {
            boolean z = this.isIntercept;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public final boolean isIntercept() {
            return this.isIntercept;
        }

        public final void setIntercept(boolean z) {
            this.isIntercept = z;
        }

        public String toString() {
            return "Result(isIntercept=" + this.isIntercept + ")";
        }
    }

    Result backResult(App app, boolean isIntercept, IBackPressedIntercept intercept, boolean isRemove);

    String getInterceptName();

    int getPriority();

    Result intercept(Chain chain);
}
