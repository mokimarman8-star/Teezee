package com.cloud.config.utils;

import com.cloud.tmc.integration.event.EventConstants;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.tmc.network.HttpClient;
import com.tmc.network.HttpRequestor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u0001:\u0002\t\nB\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\u000b"}, d2 = {"Lcom/cloud/config/utils/ConfigHttpRequest;", "", "()V", "getHeader", "", TmcStartParams.KEY_URL, "", EventConstants.ABILITY_NAME_CALLBACK, "Lokhttp3/Callback;", "Companion", "ConfigRequestorHolder", "config_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class ConfigHttpRequest {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/cloud/config/utils/ConfigHttpRequest$Companion;", "", "()V", "getInstance", "Lcom/cloud/config/utils/ConfigHttpRequest;", "config_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ConfigHttpRequest getInstance() {
            return ConfigRequestorHolder.INSTANCE.getSInstance();
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/cloud/config/utils/ConfigHttpRequest$ConfigRequestorHolder;", "", "()V", "sInstance", "Lcom/cloud/config/utils/ConfigHttpRequest;", "getSInstance", "()Lcom/cloud/config/utils/ConfigHttpRequest;", "config_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class ConfigRequestorHolder {
        public static final ConfigRequestorHolder INSTANCE = new ConfigRequestorHolder();
        private static final ConfigHttpRequest sInstance = new ConfigHttpRequest();

        private ConfigRequestorHolder() {
        }

        public final ConfigHttpRequest getSInstance() {
            return sInstance;
        }
    }

    protected ConfigHttpRequest() {
    }

    public final void getHeader(String url, Callback callback) {
        HttpClient httpClient;
        Intrinsics.h(url, TmcStartParams.KEY_URL);
        Intrinsics.h(callback, EventConstants.ABILITY_NAME_CALLBACK);
        try {
            Request.Builder head = new Request.Builder().url(url).head();
            Intrinsics.g(head, "Builder()\n              …)\n                .head()");
            HttpRequestor companion = HttpRequestor.Companion.getInstance();
            Call call = null;
            if (companion != null && (httpClient = companion.getHttpClient()) != null) {
                call = httpClient.newCall(head.build());
            }
            if (call == null) {
                return;
            }
            FirebasePerfOkHttpClient.enqueue(call, callback);
        } catch (Exception e) {
            rf.b.a.e(e);
        }
    }
}
