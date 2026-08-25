package com.cloud.tmc.integration.ui.p001native;

import android.content.Context;
import android.view.View;
import com.cloud.tmc.integration.BuildConfig;
import com.cloud.tmc.integration.event.EventConstants;
import com.cloud.tmc.integration.ui.data.NativeTabBean;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.minicover.base.BaseNativeComponent;
import com.cloud.tmc.kernel.minicover.callback.OnEventCallback;
import com.cloud.tmc.kernel.minicover.callback.OnViewChangeCallback;
import com.cloud.tmc.kernel.render.IRender;
import com.cloud.tmc.kernel.utils.TmcGsonUtils;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 12\u00020\u0001:\u000212B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0019\u001a\u00020\u0005H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u001dH\u0016J \u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u001dH\u0016J\b\u0010+\u001a\u00020\u001dH\u0016J\b\u0010,\u001a\u00020\u001dH\u0016J\b\u0010-\u001a\u00020\u001dH\u0016J\u001a\u0010.\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u000e\u0010/\u001a\u00020\u001d2\u0006\u00100\u001a\u00020\u001fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u000e\u001a\u00060\u000fR\u00020\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u00063"}, d2 = {"Lcom/cloud/tmc/integration/ui/native/NativeTabComponent;", "Lcom/cloud/tmc/kernel/minicover/base/BaseNativeComponent;", "context", "Landroid/content/Context;", EventConstants.KEY_RENDER_ID, "", "viewId", EventConstants.ADDRESS_RENDER, "Lcom/cloud/tmc/kernel/render/IRender;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/cloud/tmc/kernel/render/IRender;)V", "frameLayout", "Lcom/cloud/tmc/integration/ui/native/NativeTabView;", "getFrameLayout", "()Lcom/cloud/tmc/integration/ui/native/NativeTabView;", "listener", "Lcom/cloud/tmc/integration/ui/native/NativeTabComponent$MiniNativeTabListener;", "getListener", "()Lcom/cloud/tmc/integration/ui/native/NativeTabComponent$MiniNativeTabListener;", "mId", "nativeTabBean", "Lcom/cloud/tmc/integration/ui/data/NativeTabBean;", "getNativeTabBean", "()Lcom/cloud/tmc/integration/ui/data/NativeTabBean;", "setNativeTabBean", "(Lcom/cloud/tmc/integration/ui/data/NativeTabBean;)V", "getComponentName", "getComponentView", "Landroid/view/View;", "onAddView", "", "customObject", "Lcom/google/gson/JsonObject;", "onViewChangeCallback", "Lcom/cloud/tmc/kernel/minicover/callback/OnViewChangeCallback;", "onDestory", "onEventMessage", "methodName", "args", EventConstants.ABILITY_NAME_CALLBACK, "Lcom/cloud/tmc/kernel/minicover/callback/OnEventCallback;", "onInterceptBackPressed", "", "onPause", "onRemove", "onResume", "onStop", "onUpdateView", "parseCustomJson", "json", "Companion", "MiniNativeTabListener", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class NativeTabComponent extends BaseNativeComponent {
    public static final String TAG = "NativeTabComponent";
    private final NativeTabView frameLayout;
    private final MiniNativeTabListener listener;
    private String mId;
    private NativeTabBean nativeTabBean;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/cloud/tmc/integration/ui/native/NativeTabComponent$MiniNativeTabListener;", "Lcom/cloud/tmc/integration/ui/native/INativeTabListener;", "(Lcom/cloud/tmc/integration/ui/native/NativeTabComponent;)V", "onTabEvent", "", EventConstants.KEY_EVENT_NAME, "", "json", "Lcom/google/gson/JsonObject;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class MiniNativeTabListener implements INativeTabListener {
        public MiniNativeTabListener() {
        }

        @Override // com.cloud.tmc.integration.ui.p001native.INativeTabListener
        public void onTabEvent(String eventName, JsonObject json) {
            Intrinsics.h(eventName, EventConstants.KEY_EVENT_NAME);
            Intrinsics.h(json, "json");
            TmcLogger.e(NativeTabComponent.TAG, "onTabEvent id=" + NativeTabComponent.this.mId + " eventName=" + eventName + " $ json = " + json);
            NativeTabComponent.this.postEventMessage(eventName, json);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeTabComponent(Context context, String str, String str2, IRender iRender) {
        super(context, str, str2, iRender);
        Intrinsics.h(context, "context");
        Intrinsics.h(str, EventConstants.KEY_RENDER_ID);
        Intrinsics.h(str2, "viewId");
        Intrinsics.h(iRender, EventConstants.ADDRESS_RENDER);
        this.mId = str2;
        this.frameLayout = new NativeTabView(context, null);
        this.listener = new MiniNativeTabListener();
        this.nativeTabBean = new NativeTabBean();
    }

    public String getComponentName() {
        return "native-tab";
    }

    public View getComponentView() {
        return this.frameLayout;
    }

    public final NativeTabView getFrameLayout() {
        return this.frameLayout;
    }

    public final MiniNativeTabListener getListener() {
        return this.listener;
    }

    public final NativeTabBean getNativeTabBean() {
        return this.nativeTabBean;
    }

    public void onAddView(JsonObject customObject, OnViewChangeCallback onViewChangeCallback) {
        Intrinsics.h(onViewChangeCallback, "onViewChangeCallback");
        this.frameLayout.addNativeTabListener(this.listener);
        if (customObject != null) {
            parseCustomJson(customObject);
        }
        onViewChangeCallback.onSuccess();
    }

    public void onDestory() {
        this.frameLayout.removeNativeTabListener(this.listener);
    }

    public void onEventMessage(String methodName, JsonObject args, OnEventCallback callback) {
        Intrinsics.h(methodName, "methodName");
        Intrinsics.h(args, "args");
        Intrinsics.h(callback, EventConstants.ABILITY_NAME_CALLBACK);
        if (Intrinsics.c(methodName, "switchTab")) {
            this.frameLayout.switchTab(args.get("index").getAsInt());
        }
    }

    public boolean onInterceptBackPressed() {
        return false;
    }

    public void onPause() {
    }

    public void onRemove() {
    }

    public void onResume() {
    }

    public void onStop() {
    }

    public void onUpdateView(JsonObject customObject, OnViewChangeCallback onViewChangeCallback) {
        Intrinsics.h(onViewChangeCallback, "onViewChangeCallback");
        if (customObject != null) {
            parseCustomJson(customObject);
        }
        onViewChangeCallback.onSuccess();
    }

    public final void parseCustomJson(JsonObject json) {
        NativeTabBean nativeTabBean;
        Intrinsics.h(json, "json");
        try {
            try {
                String jsonElement = json.toString();
                Intrinsics.g(jsonElement, "json.toString()");
                Type type = new TypeToken<NativeTabBean>() { // from class: com.cloud.tmc.integration.ui.native.NativeTabComponent$parseCustomJson$tabBar$1
                }.getType();
                Intrinsics.g(type, "object :\n               …<NativeTabBean>() {}.type");
                nativeTabBean = (NativeTabBean) TmcGsonUtils.fromJson(jsonElement, type);
            } catch (Throwable th) {
                TmcLogger.e(TAG, "tabBarConfig json parse error", th);
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("errMsg", NativeTabView.ERROR_MSG_T10002);
                this.listener.onTabEvent("error", jsonObject);
                nativeTabBean = null;
            }
            if (Intrinsics.c(nativeTabBean, this.nativeTabBean) || nativeTabBean == null) {
                return;
            }
            this.nativeTabBean = nativeTabBean;
            this.frameLayout.setTabStyle(nativeTabBean);
        } catch (Throwable th2) {
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.addProperty("errMsg", NativeTabView.ERROR_MSG_T10001);
            this.listener.onTabEvent("error", jsonObject2);
            TmcLogger.e(TAG, th2);
        }
    }

    public final void setNativeTabBean(NativeTabBean nativeTabBean) {
        Intrinsics.h(nativeTabBean, "<set-?>");
        this.nativeTabBean = nativeTabBean;
    }
}
