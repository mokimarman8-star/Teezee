package com.transsion.ad.ps;

import ai.b;
import com.transsion.ad.db.pslink.AttributionPoint;
import com.transsion.ad.ps.model.RecommendInfo;
import com.transsion.gslb.BuildConfig;
import com.transsion.push.PushConstants;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PSReportUtil {
    public static final PSReportUtil a = new PSReportUtil();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/transsion/ad/ps/PSReportUtil$ItemResourceEnum;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "ITEM_RES_HI", "ITEM_RES_PS", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ItemResourceEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ItemResourceEnum[] $VALUES;
        public static final ItemResourceEnum ITEM_RES_HI = new ItemResourceEnum("ITEM_RES_HI", 0, "hi");
        public static final ItemResourceEnum ITEM_RES_PS = new ItemResourceEnum("ITEM_RES_PS", 1, com.transsion.al.BuildConfig.FLAVOR);
        private final String value;

        private static final /* synthetic */ ItemResourceEnum[] $values() {
            return new ItemResourceEnum[]{ITEM_RES_HI, ITEM_RES_PS};
        }

        static {
            ItemResourceEnum[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.a($values);
        }

        private ItemResourceEnum(String str, int i, String str2) {
            this.value = str2;
        }

        public static EnumEntries<ItemResourceEnum> getEntries() {
            return $ENTRIES;
        }

        public static ItemResourceEnum valueOf(String str) {
            return (ItemResourceEnum) Enum.valueOf(ItemResourceEnum.class, str);
        }

        public static ItemResourceEnum[] values() {
            return (ItemResourceEnum[]) $VALUES.clone();
        }

        public final String getValue() {
            return this.value;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/transsion/ad/ps/PSReportUtil$PSRequestState;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "REQUEST_TRIGGER", "REQUEST_SUCCESS", "REQUEST_FAIL", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PSRequestState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PSRequestState[] $VALUES;
        private final String value;
        public static final PSRequestState REQUEST_TRIGGER = new PSRequestState("REQUEST_TRIGGER", 0, "trigger");
        public static final PSRequestState REQUEST_SUCCESS = new PSRequestState("REQUEST_SUCCESS", 1, "success");
        public static final PSRequestState REQUEST_FAIL = new PSRequestState("REQUEST_FAIL", 2, "fail");

        private static final /* synthetic */ PSRequestState[] $values() {
            return new PSRequestState[]{REQUEST_TRIGGER, REQUEST_SUCCESS, REQUEST_FAIL};
        }

        static {
            PSRequestState[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.a($values);
        }

        private PSRequestState(String str, int i, String str2) {
            this.value = str2;
        }

        public static EnumEntries<PSRequestState> getEntries() {
            return $ENTRIES;
        }

        public static PSRequestState valueOf(String str) {
            return (PSRequestState) Enum.valueOf(PSRequestState.class, str);
        }

        public static PSRequestState[] values() {
            return (PSRequestState[]) $VALUES.clone();
        }

        public final String getValue() {
            return this.value;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/transsion/ad/ps/PSReportUtil$PsDistributeSceneEnum;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "PS_DISTRIBUTE_SCENE_DOWNLOAD_INTERCEPT", "PS_DISTRIBUTE_SCENE_APP_CENTER", "PS_DISTRIBUTE_SCENE_DOWNLOAD_CENTER_APP", "PS_DISTRIBUTE_SCENE_AD_PLAN", "PS_DISTRIBUTE_SCENE_ACTIVATE", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PsDistributeSceneEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PsDistributeSceneEnum[] $VALUES;
        private final String value;
        public static final PsDistributeSceneEnum PS_DISTRIBUTE_SCENE_DOWNLOAD_INTERCEPT = new PsDistributeSceneEnum("PS_DISTRIBUTE_SCENE_DOWNLOAD_INTERCEPT", 0, "download_intercept");
        public static final PsDistributeSceneEnum PS_DISTRIBUTE_SCENE_APP_CENTER = new PsDistributeSceneEnum("PS_DISTRIBUTE_SCENE_APP_CENTER", 1, "app_center");
        public static final PsDistributeSceneEnum PS_DISTRIBUTE_SCENE_DOWNLOAD_CENTER_APP = new PsDistributeSceneEnum("PS_DISTRIBUTE_SCENE_DOWNLOAD_CENTER_APP", 2, "download_center_app");
        public static final PsDistributeSceneEnum PS_DISTRIBUTE_SCENE_AD_PLAN = new PsDistributeSceneEnum("PS_DISTRIBUTE_SCENE_AD_PLAN", 3, "ad_plan");
        public static final PsDistributeSceneEnum PS_DISTRIBUTE_SCENE_ACTIVATE = new PsDistributeSceneEnum("PS_DISTRIBUTE_SCENE_ACTIVATE", 4, "ps_activate");

        private static final /* synthetic */ PsDistributeSceneEnum[] $values() {
            return new PsDistributeSceneEnum[]{PS_DISTRIBUTE_SCENE_DOWNLOAD_INTERCEPT, PS_DISTRIBUTE_SCENE_APP_CENTER, PS_DISTRIBUTE_SCENE_DOWNLOAD_CENTER_APP, PS_DISTRIBUTE_SCENE_AD_PLAN, PS_DISTRIBUTE_SCENE_ACTIVATE};
        }

        static {
            PsDistributeSceneEnum[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.a($values);
        }

        private PsDistributeSceneEnum(String str, int i, String str2) {
            this.value = str2;
        }

        public static EnumEntries<PsDistributeSceneEnum> getEntries() {
            return $ENTRIES;
        }

        public static PsDistributeSceneEnum valueOf(String str) {
            return (PsDistributeSceneEnum) Enum.valueOf(PsDistributeSceneEnum.class, str);
        }

        public static PsDistributeSceneEnum[] values() {
            return (PsDistributeSceneEnum[]) $VALUES.clone();
        }

        public final String getValue() {
            return this.value;
        }
    }

    private PSReportUtil() {
    }

    public final void a(AttributionPoint.AttributionType attributionType, String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("type", attributionType != null ? attributionType.name() : null);
        linkedHashMap.put("psId", str);
        linkedHashMap.put("action", "ps_attribution");
        b.a.a("ad_ps_attribution", linkedHashMap, "ps_attribution");
    }

    public final void b(String str, String str2, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(PushConstants.PROVIDER_FIELD_PKG, str);
        linkedHashMap.put("source", str2);
        linkedHashMap.put("activate_state", str3);
        linkedHashMap.put("action", "ps_install");
        b.a.a("ad_ps_distribute", linkedHashMap, "ps_distribute");
    }

    public final void c(PSRequestState pSRequestState, RecommendInfo recommendInfo, String str, String str2) {
        Intrinsics.h(pSRequestState, "psState");
        Intrinsics.h(str, "sceneStr");
        Intrinsics.h(str2, "adPlanId");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("scene", str);
        linkedHashMap.put("ad_planId", str2);
        linkedHashMap.put("ps_state", pSRequestState.getValue());
        linkedHashMap.put("id", recommendInfo != null ? Long.valueOf(recommendInfo.getId()).toString() : null);
        linkedHashMap.put("action", "ps_material");
        b.a.a("ad_ps_distribute", linkedHashMap, "ps_distribute");
    }

    public final void d(PSRequestState pSRequestState, Integer num, String str, String str2, String str3) {
        Intrinsics.h(pSRequestState, "psState");
        Intrinsics.h(str3, "scene");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("ps_state", pSRequestState.getValue());
        linkedHashMap.put("count", String.valueOf(num));
        linkedHashMap.put("error_msg", String.valueOf(str));
        linkedHashMap.put("ps_scene", String.valueOf(str2));
        linkedHashMap.put("scene", str3);
        linkedHashMap.put("action", "ps_request");
        b.a.a("ad_ps_distribute", linkedHashMap, "ps_distribute");
    }
}
