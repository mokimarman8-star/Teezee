package com.cloud.tmc.miniapp.utils.toast.config;

import androidx.annotation.Keep;
import com.cloud.tmc.kernel.bridge.SendToNativeCallback;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.cloud.tmc.kernel.utils.NetworkUtil;
import kotlin.jvm.internal.Intrinsics;

@Keep
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class ToastType {
    private final String name;

    public static final class ERROR extends ToastType {
        public static final ERROR INSTANCE = new ERROR();

        private ERROR() {
            super(SendToNativeCallback.KEY_CODE);
        }
    }

    public static final class LOADING extends ToastType {
        public static final LOADING INSTANCE = new LOADING();

        private LOADING() {
            super("loading");
        }
    }

    public static final class NONE extends ToastType {
        public static final NONE INSTANCE = new NONE();

        private NONE() {
            super(NetworkUtil.NETWORK_TYPE_NOT_REACHABLE);
        }
    }

    public static final class SUCCESS extends ToastType {
        public static final SUCCESS INSTANCE = new SUCCESS();

        private SUCCESS() {
            super(NativeComponentConstants.KEY_COMPONENT_RESULT_SUCCESS);
        }
    }

    public ToastType(String str) {
        Intrinsics.h(str, "name");
        this.name = str;
    }

    public final String getName() {
        return this.name;
    }
}
