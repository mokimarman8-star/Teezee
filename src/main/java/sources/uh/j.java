package uh;

import androidx.room.RoomDatabase;
import com.transsion.ad.db.plan.MbAdDbPlans;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class j implements uh.a {
    private final RoomDatabase a;
    private final androidx.room.g b = new a();
    private final androidx.room.e c = new b();

    class a extends androidx.room.g {
        a() {
        }

        protected String b() {
            return "INSERT OR REPLACE INTO `mb_ad_db_plans` (`id`,`version`,`name`,`startTime`,`endTime`,`extraConfig`,`displayTimes`,`showedTimes`,`showDate`,`advertiserName`,`advertiserAvatar`,`advertiserAvatarPath`,`brand`,`denyBrand`,`model`,`denyModel`,`country`,`scenes`,`adSource`,`extAdSlot`,`adMaterialList`,`adPlanUpdateTime`,`sort`,`adShowLevel`,`filterClientVersion`,`adPlanCreateTime`,`appStarDesc`,`appSizeDesc`,`ctxEnableExpr`,`ctxDisableExpr`,`ctxAttributeConfig`,`dispatchTimeStart`,`dispatchTimeEnd`,`extImage`,`bidEcpmCent`,`ecpmCent`,`isValid`,`h5LinkPreload`,`h5LinkOpenByCct`,`countryCode`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, MbAdDbPlans mbAdDbPlans) {
            if (mbAdDbPlans.getId() == null) {
                eVar.g(1);
            } else {
                eVar.i(1, mbAdDbPlans.getId());
            }
            if (mbAdDbPlans.getVersion() == null) {
                eVar.g(2);
            } else {
                eVar.i(2, mbAdDbPlans.getVersion());
            }
            if (mbAdDbPlans.getName() == null) {
                eVar.g(3);
            } else {
                eVar.i(3, mbAdDbPlans.getName());
            }
            if (mbAdDbPlans.getStartTime() == null) {
                eVar.g(4);
            } else {
                eVar.i(4, mbAdDbPlans.getStartTime());
            }
            if (mbAdDbPlans.getEndTime() == null) {
                eVar.g(5);
            } else {
                eVar.i(5, mbAdDbPlans.getEndTime());
            }
            if (mbAdDbPlans.getExtraConfig() == null) {
                eVar.g(6);
            } else {
                eVar.i(6, mbAdDbPlans.getExtraConfig());
            }
            if (mbAdDbPlans.getDisplayTimes() == null) {
                eVar.g(7);
            } else {
                eVar.c(7, mbAdDbPlans.getDisplayTimes().intValue());
            }
            if (mbAdDbPlans.getShowedTimes() == null) {
                eVar.g(8);
            } else {
                eVar.c(8, mbAdDbPlans.getShowedTimes().intValue());
            }
            if (mbAdDbPlans.getShowDate() == null) {
                eVar.g(9);
            } else {
                eVar.i(9, mbAdDbPlans.getShowDate());
            }
            if (mbAdDbPlans.getAdvertiserName() == null) {
                eVar.g(10);
            } else {
                eVar.i(10, mbAdDbPlans.getAdvertiserName());
            }
            if (mbAdDbPlans.getAdvertiserAvatar() == null) {
                eVar.g(11);
            } else {
                eVar.i(11, mbAdDbPlans.getAdvertiserAvatar());
            }
            if (mbAdDbPlans.getAdvertiserAvatarPath() == null) {
                eVar.g(12);
            } else {
                eVar.i(12, mbAdDbPlans.getAdvertiserAvatarPath());
            }
            if (mbAdDbPlans.getBrand() == null) {
                eVar.g(13);
            } else {
                eVar.i(13, mbAdDbPlans.getBrand());
            }
            if (mbAdDbPlans.getDenyBrand() == null) {
                eVar.g(14);
            } else {
                eVar.i(14, mbAdDbPlans.getDenyBrand());
            }
            if (mbAdDbPlans.getModel() == null) {
                eVar.g(15);
            } else {
                eVar.i(15, mbAdDbPlans.getModel());
            }
            if (mbAdDbPlans.getDenyModel() == null) {
                eVar.g(16);
            } else {
                eVar.i(16, mbAdDbPlans.getDenyModel());
            }
            if (mbAdDbPlans.getCountry() == null) {
                eVar.g(17);
            } else {
                eVar.i(17, mbAdDbPlans.getCountry());
            }
            if (mbAdDbPlans.getScenes() == null) {
                eVar.g(18);
            } else {
                eVar.i(18, mbAdDbPlans.getScenes());
            }
            if (mbAdDbPlans.getAdSource() == null) {
                eVar.g(19);
            } else {
                eVar.i(19, mbAdDbPlans.getAdSource());
            }
            if (mbAdDbPlans.getExtAdSlot() == null) {
                eVar.g(20);
            } else {
                eVar.i(20, mbAdDbPlans.getExtAdSlot());
            }
            if (mbAdDbPlans.getAdMaterialList() == null) {
                eVar.g(21);
            } else {
                eVar.i(21, mbAdDbPlans.getAdMaterialList());
            }
            if (mbAdDbPlans.getAdPlanUpdateTime() == null) {
                eVar.g(22);
            } else {
                eVar.i(22, mbAdDbPlans.getAdPlanUpdateTime());
            }
            if (mbAdDbPlans.getSort() == null) {
                eVar.g(23);
            } else {
                eVar.c(23, mbAdDbPlans.getSort().intValue());
            }
            if (mbAdDbPlans.getAdShowLevel() == null) {
                eVar.g(24);
            } else {
                eVar.i(24, mbAdDbPlans.getAdShowLevel());
            }
            if (mbAdDbPlans.getFilterClientVersion() == null) {
                eVar.g(25);
            } else {
                eVar.i(25, mbAdDbPlans.getFilterClientVersion());
            }
            if (mbAdDbPlans.getAdPlanCreateTime() == null) {
                eVar.g(26);
            } else {
                eVar.i(26, mbAdDbPlans.getAdPlanCreateTime());
            }
            if (mbAdDbPlans.getAppStarDesc() == null) {
                eVar.g(27);
            } else {
                eVar.i(27, mbAdDbPlans.getAppStarDesc());
            }
            if (mbAdDbPlans.getAppSizeDesc() == null) {
                eVar.g(28);
            } else {
                eVar.i(28, mbAdDbPlans.getAppSizeDesc());
            }
            if (mbAdDbPlans.getCtxEnableExpr() == null) {
                eVar.g(29);
            } else {
                eVar.i(29, mbAdDbPlans.getCtxEnableExpr());
            }
            if (mbAdDbPlans.getCtxDisableExpr() == null) {
                eVar.g(30);
            } else {
                eVar.i(30, mbAdDbPlans.getCtxDisableExpr());
            }
            if (mbAdDbPlans.getCtxAttributeConfig() == null) {
                eVar.g(31);
            } else {
                eVar.i(31, mbAdDbPlans.getCtxAttributeConfig());
            }
            if (mbAdDbPlans.getDispatchTimeStart() == null) {
                eVar.g(32);
            } else {
                eVar.i(32, mbAdDbPlans.getDispatchTimeStart());
            }
            if (mbAdDbPlans.getDispatchTimeEnd() == null) {
                eVar.g(33);
            } else {
                eVar.i(33, mbAdDbPlans.getDispatchTimeEnd());
            }
            if (mbAdDbPlans.getExtImage() == null) {
                eVar.g(34);
            } else {
                eVar.i(34, mbAdDbPlans.getExtImage());
            }
            if (mbAdDbPlans.getBidEcpmCent() == null) {
                eVar.g(35);
            } else {
                eVar.a(35, mbAdDbPlans.getBidEcpmCent().doubleValue());
            }
            if (mbAdDbPlans.getEcpmCent() == null) {
                eVar.g(36);
            } else {
                eVar.c(36, mbAdDbPlans.getEcpmCent().longValue());
            }
            eVar.c(37, mbAdDbPlans.isValid() ? 1L : 0L);
            eVar.c(38, mbAdDbPlans.getH5LinkPreload() ? 1L : 0L);
            eVar.c(39, mbAdDbPlans.getH5LinkOpenByCct() ? 1L : 0L);
            if (mbAdDbPlans.getCountryCode() == null) {
                eVar.g(40);
            } else {
                eVar.i(40, mbAdDbPlans.getCountryCode());
            }
        }
    }

    class b extends androidx.room.e {
        b() {
        }

        protected String b() {
            return "UPDATE OR ABORT `mb_ad_db_plans` SET `id` = ?,`version` = ?,`name` = ?,`startTime` = ?,`endTime` = ?,`extraConfig` = ?,`displayTimes` = ?,`showedTimes` = ?,`showDate` = ?,`advertiserName` = ?,`advertiserAvatar` = ?,`advertiserAvatarPath` = ?,`brand` = ?,`denyBrand` = ?,`model` = ?,`denyModel` = ?,`country` = ?,`scenes` = ?,`adSource` = ?,`extAdSlot` = ?,`adMaterialList` = ?,`adPlanUpdateTime` = ?,`sort` = ?,`adShowLevel` = ?,`filterClientVersion` = ?,`adPlanCreateTime` = ?,`appStarDesc` = ?,`appSizeDesc` = ?,`ctxEnableExpr` = ?,`ctxDisableExpr` = ?,`ctxAttributeConfig` = ?,`dispatchTimeStart` = ?,`dispatchTimeEnd` = ?,`extImage` = ?,`bidEcpmCent` = ?,`ecpmCent` = ?,`isValid` = ?,`h5LinkPreload` = ?,`h5LinkOpenByCct` = ?,`countryCode` = ? WHERE `id` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, MbAdDbPlans mbAdDbPlans) {
            if (mbAdDbPlans.getId() == null) {
                eVar.g(1);
            } else {
                eVar.i(1, mbAdDbPlans.getId());
            }
            if (mbAdDbPlans.getVersion() == null) {
                eVar.g(2);
            } else {
                eVar.i(2, mbAdDbPlans.getVersion());
            }
            if (mbAdDbPlans.getName() == null) {
                eVar.g(3);
            } else {
                eVar.i(3, mbAdDbPlans.getName());
            }
            if (mbAdDbPlans.getStartTime() == null) {
                eVar.g(4);
            } else {
                eVar.i(4, mbAdDbPlans.getStartTime());
            }
            if (mbAdDbPlans.getEndTime() == null) {
                eVar.g(5);
            } else {
                eVar.i(5, mbAdDbPlans.getEndTime());
            }
            if (mbAdDbPlans.getExtraConfig() == null) {
                eVar.g(6);
            } else {
                eVar.i(6, mbAdDbPlans.getExtraConfig());
            }
            if (mbAdDbPlans.getDisplayTimes() == null) {
                eVar.g(7);
            } else {
                eVar.c(7, mbAdDbPlans.getDisplayTimes().intValue());
            }
            if (mbAdDbPlans.getShowedTimes() == null) {
                eVar.g(8);
            } else {
                eVar.c(8, mbAdDbPlans.getShowedTimes().intValue());
            }
            if (mbAdDbPlans.getShowDate() == null) {
                eVar.g(9);
            } else {
                eVar.i(9, mbAdDbPlans.getShowDate());
            }
            if (mbAdDbPlans.getAdvertiserName() == null) {
                eVar.g(10);
            } else {
                eVar.i(10, mbAdDbPlans.getAdvertiserName());
            }
            if (mbAdDbPlans.getAdvertiserAvatar() == null) {
                eVar.g(11);
            } else {
                eVar.i(11, mbAdDbPlans.getAdvertiserAvatar());
            }
            if (mbAdDbPlans.getAdvertiserAvatarPath() == null) {
                eVar.g(12);
            } else {
                eVar.i(12, mbAdDbPlans.getAdvertiserAvatarPath());
            }
            if (mbAdDbPlans.getBrand() == null) {
                eVar.g(13);
            } else {
                eVar.i(13, mbAdDbPlans.getBrand());
            }
            if (mbAdDbPlans.getDenyBrand() == null) {
                eVar.g(14);
            } else {
                eVar.i(14, mbAdDbPlans.getDenyBrand());
            }
            if (mbAdDbPlans.getModel() == null) {
                eVar.g(15);
            } else {
                eVar.i(15, mbAdDbPlans.getModel());
            }
            if (mbAdDbPlans.getDenyModel() == null) {
                eVar.g(16);
            } else {
                eVar.i(16, mbAdDbPlans.getDenyModel());
            }
            if (mbAdDbPlans.getCountry() == null) {
                eVar.g(17);
            } else {
                eVar.i(17, mbAdDbPlans.getCountry());
            }
            if (mbAdDbPlans.getScenes() == null) {
                eVar.g(18);
            } else {
                eVar.i(18, mbAdDbPlans.getScenes());
            }
            if (mbAdDbPlans.getAdSource() == null) {
                eVar.g(19);
            } else {
                eVar.i(19, mbAdDbPlans.getAdSource());
            }
            if (mbAdDbPlans.getExtAdSlot() == null) {
                eVar.g(20);
            } else {
                eVar.i(20, mbAdDbPlans.getExtAdSlot());
            }
            if (mbAdDbPlans.getAdMaterialList() == null) {
                eVar.g(21);
            } else {
                eVar.i(21, mbAdDbPlans.getAdMaterialList());
            }
            if (mbAdDbPlans.getAdPlanUpdateTime() == null) {
                eVar.g(22);
            } else {
                eVar.i(22, mbAdDbPlans.getAdPlanUpdateTime());
            }
            if (mbAdDbPlans.getSort() == null) {
                eVar.g(23);
            } else {
                eVar.c(23, mbAdDbPlans.getSort().intValue());
            }
            if (mbAdDbPlans.getAdShowLevel() == null) {
                eVar.g(24);
            } else {
                eVar.i(24, mbAdDbPlans.getAdShowLevel());
            }
            if (mbAdDbPlans.getFilterClientVersion() == null) {
                eVar.g(25);
            } else {
                eVar.i(25, mbAdDbPlans.getFilterClientVersion());
            }
            if (mbAdDbPlans.getAdPlanCreateTime() == null) {
                eVar.g(26);
            } else {
                eVar.i(26, mbAdDbPlans.getAdPlanCreateTime());
            }
            if (mbAdDbPlans.getAppStarDesc() == null) {
                eVar.g(27);
            } else {
                eVar.i(27, mbAdDbPlans.getAppStarDesc());
            }
            if (mbAdDbPlans.getAppSizeDesc() == null) {
                eVar.g(28);
            } else {
                eVar.i(28, mbAdDbPlans.getAppSizeDesc());
            }
            if (mbAdDbPlans.getCtxEnableExpr() == null) {
                eVar.g(29);
            } else {
                eVar.i(29, mbAdDbPlans.getCtxEnableExpr());
            }
            if (mbAdDbPlans.getCtxDisableExpr() == null) {
                eVar.g(30);
            } else {
                eVar.i(30, mbAdDbPlans.getCtxDisableExpr());
            }
            if (mbAdDbPlans.getCtxAttributeConfig() == null) {
                eVar.g(31);
            } else {
                eVar.i(31, mbAdDbPlans.getCtxAttributeConfig());
            }
            if (mbAdDbPlans.getDispatchTimeStart() == null) {
                eVar.g(32);
            } else {
                eVar.i(32, mbAdDbPlans.getDispatchTimeStart());
            }
            if (mbAdDbPlans.getDispatchTimeEnd() == null) {
                eVar.g(33);
            } else {
                eVar.i(33, mbAdDbPlans.getDispatchTimeEnd());
            }
            if (mbAdDbPlans.getExtImage() == null) {
                eVar.g(34);
            } else {
                eVar.i(34, mbAdDbPlans.getExtImage());
            }
            if (mbAdDbPlans.getBidEcpmCent() == null) {
                eVar.g(35);
            } else {
                eVar.a(35, mbAdDbPlans.getBidEcpmCent().doubleValue());
            }
            if (mbAdDbPlans.getEcpmCent() == null) {
                eVar.g(36);
            } else {
                eVar.c(36, mbAdDbPlans.getEcpmCent().longValue());
            }
            eVar.c(37, mbAdDbPlans.isValid() ? 1L : 0L);
            eVar.c(38, mbAdDbPlans.getH5LinkPreload() ? 1L : 0L);
            eVar.c(39, mbAdDbPlans.getH5LinkOpenByCct() ? 1L : 0L);
            if (mbAdDbPlans.getCountryCode() == null) {
                eVar.g(40);
            } else {
                eVar.i(40, mbAdDbPlans.getCountryCode());
            }
            if (mbAdDbPlans.getId() == null) {
                eVar.g(41);
            } else {
                eVar.i(41, mbAdDbPlans.getId());
            }
        }
    }

    public j(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
    }

    public static List q() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit r(String str, y3.b bVar) {
        y3.e F0 = bVar.F0("DELETE FROM mb_ad_db_plans WHERE version !=?");
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            F0.C0();
            Unit unit = Unit.a;
            F0.close();
            return unit;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List s(y3.b bVar) {
        int i;
        int i2;
        Integer valueOf;
        String q0;
        int i3;
        String q02;
        int i4;
        int i5;
        String q03;
        int i6;
        String q04;
        int i7;
        String q05;
        int i8;
        String q06;
        int i9;
        String q07;
        int i10;
        String q08;
        int i11;
        String q09;
        int i12;
        int i13;
        int i14;
        Integer valueOf2;
        int i15;
        String q010;
        int i16;
        String q011;
        int i17;
        int i18;
        String q012;
        int i19;
        String q013;
        int i20;
        String q014;
        int i21;
        String q015;
        int i22;
        String q016;
        int i23;
        String q017;
        int i24;
        String q018;
        int i25;
        String q019;
        int i26;
        String q020;
        int i27;
        Double valueOf3;
        int i28;
        Long valueOf4;
        int i29;
        int i30;
        int i31;
        boolean z;
        int i32;
        boolean z2;
        y3.e F0 = bVar.F0("SELECT * FROM mb_ad_db_plans WHERE isValid = 1 ORDER BY sort");
        try {
            int c = androidx.room.util.i.c(F0, "id");
            int c2 = androidx.room.util.i.c(F0, "version");
            int c3 = androidx.room.util.i.c(F0, "name");
            int c4 = androidx.room.util.i.c(F0, "startTime");
            int c5 = androidx.room.util.i.c(F0, "endTime");
            int c6 = androidx.room.util.i.c(F0, "extraConfig");
            int c7 = androidx.room.util.i.c(F0, "displayTimes");
            int c8 = androidx.room.util.i.c(F0, "showedTimes");
            int c9 = androidx.room.util.i.c(F0, "showDate");
            int c10 = androidx.room.util.i.c(F0, "advertiserName");
            int c11 = androidx.room.util.i.c(F0, "advertiserAvatar");
            int c12 = androidx.room.util.i.c(F0, "advertiserAvatarPath");
            int c13 = androidx.room.util.i.c(F0, "brand");
            int c14 = androidx.room.util.i.c(F0, "denyBrand");
            int c15 = androidx.room.util.i.c(F0, "model");
            int c16 = androidx.room.util.i.c(F0, "denyModel");
            int c17 = androidx.room.util.i.c(F0, "country");
            int c18 = androidx.room.util.i.c(F0, "scenes");
            int c19 = androidx.room.util.i.c(F0, "adSource");
            int c20 = androidx.room.util.i.c(F0, "extAdSlot");
            int c21 = androidx.room.util.i.c(F0, "adMaterialList");
            int c22 = androidx.room.util.i.c(F0, "adPlanUpdateTime");
            int c23 = androidx.room.util.i.c(F0, "sort");
            int c24 = androidx.room.util.i.c(F0, "adShowLevel");
            int c25 = androidx.room.util.i.c(F0, "filterClientVersion");
            int c26 = androidx.room.util.i.c(F0, "adPlanCreateTime");
            int c27 = androidx.room.util.i.c(F0, "appStarDesc");
            int c28 = androidx.room.util.i.c(F0, "appSizeDesc");
            int c29 = androidx.room.util.i.c(F0, "ctxEnableExpr");
            int c30 = androidx.room.util.i.c(F0, "ctxDisableExpr");
            int c31 = androidx.room.util.i.c(F0, "ctxAttributeConfig");
            int c32 = androidx.room.util.i.c(F0, "dispatchTimeStart");
            int c33 = androidx.room.util.i.c(F0, "dispatchTimeEnd");
            int c34 = androidx.room.util.i.c(F0, "extImage");
            int c35 = androidx.room.util.i.c(F0, "bidEcpmCent");
            int c36 = androidx.room.util.i.c(F0, "ecpmCent");
            int c37 = androidx.room.util.i.c(F0, "isValid");
            int c38 = androidx.room.util.i.c(F0, "h5LinkPreload");
            int c39 = androidx.room.util.i.c(F0, "h5LinkOpenByCct");
            int c40 = androidx.room.util.i.c(F0, "countryCode");
            ArrayList arrayList = new ArrayList();
            while (F0.C0()) {
                String q021 = F0.isNull(c) ? null : F0.q0(c);
                String q022 = F0.isNull(c2) ? null : F0.q0(c2);
                String q023 = F0.isNull(c3) ? null : F0.q0(c3);
                String q024 = F0.isNull(c4) ? null : F0.q0(c4);
                String q025 = F0.isNull(c5) ? null : F0.q0(c5);
                String q026 = F0.isNull(c6) ? null : F0.q0(c6);
                if (F0.isNull(c7)) {
                    i = c2;
                    i2 = c3;
                    valueOf = null;
                } else {
                    i = c2;
                    i2 = c3;
                    valueOf = Integer.valueOf((int) F0.getLong(c7));
                }
                Integer valueOf5 = F0.isNull(c8) ? null : Integer.valueOf((int) F0.getLong(c8));
                String q027 = F0.isNull(c9) ? null : F0.q0(c9);
                String q028 = F0.isNull(c10) ? null : F0.q0(c10);
                String q029 = F0.isNull(c11) ? null : F0.q0(c11);
                String q030 = F0.isNull(c12) ? null : F0.q0(c12);
                String q031 = F0.isNull(c13) ? null : F0.q0(c13);
                if (F0.isNull(c14)) {
                    i3 = c15;
                    q0 = null;
                } else {
                    q0 = F0.q0(c14);
                    i3 = c15;
                }
                if (F0.isNull(i3)) {
                    i4 = c16;
                    q02 = null;
                } else {
                    q02 = F0.q0(i3);
                    i4 = c16;
                }
                if (F0.isNull(i4)) {
                    i5 = c;
                    i6 = c17;
                    q03 = null;
                } else {
                    i5 = c;
                    q03 = F0.q0(i4);
                    i6 = c17;
                }
                if (F0.isNull(i6)) {
                    c17 = i6;
                    i7 = c18;
                    q04 = null;
                } else {
                    c17 = i6;
                    q04 = F0.q0(i6);
                    i7 = c18;
                }
                if (F0.isNull(i7)) {
                    c18 = i7;
                    i8 = c19;
                    q05 = null;
                } else {
                    c18 = i7;
                    q05 = F0.q0(i7);
                    i8 = c19;
                }
                if (F0.isNull(i8)) {
                    c19 = i8;
                    i9 = c20;
                    q06 = null;
                } else {
                    c19 = i8;
                    q06 = F0.q0(i8);
                    i9 = c20;
                }
                if (F0.isNull(i9)) {
                    c20 = i9;
                    i10 = c21;
                    q07 = null;
                } else {
                    c20 = i9;
                    q07 = F0.q0(i9);
                    i10 = c21;
                }
                if (F0.isNull(i10)) {
                    c21 = i10;
                    i11 = c22;
                    q08 = null;
                } else {
                    c21 = i10;
                    q08 = F0.q0(i10);
                    i11 = c22;
                }
                if (F0.isNull(i11)) {
                    c22 = i11;
                    i12 = c23;
                    q09 = null;
                } else {
                    c22 = i11;
                    q09 = F0.q0(i11);
                    i12 = c23;
                }
                if (F0.isNull(i12)) {
                    i13 = i3;
                    i14 = i4;
                    i15 = c24;
                    valueOf2 = null;
                } else {
                    i13 = i3;
                    i14 = i4;
                    valueOf2 = Integer.valueOf((int) F0.getLong(i12));
                    i15 = c24;
                }
                if (F0.isNull(i15)) {
                    i16 = c25;
                    q010 = null;
                } else {
                    q010 = F0.q0(i15);
                    i16 = c25;
                }
                if (F0.isNull(i16)) {
                    i17 = i12;
                    i18 = c26;
                    q011 = null;
                } else {
                    q011 = F0.q0(i16);
                    i17 = i12;
                    i18 = c26;
                }
                if (F0.isNull(i18)) {
                    c26 = i18;
                    i19 = c27;
                    q012 = null;
                } else {
                    c26 = i18;
                    q012 = F0.q0(i18);
                    i19 = c27;
                }
                if (F0.isNull(i19)) {
                    c27 = i19;
                    i20 = c28;
                    q013 = null;
                } else {
                    c27 = i19;
                    q013 = F0.q0(i19);
                    i20 = c28;
                }
                if (F0.isNull(i20)) {
                    c28 = i20;
                    i21 = c29;
                    q014 = null;
                } else {
                    c28 = i20;
                    q014 = F0.q0(i20);
                    i21 = c29;
                }
                if (F0.isNull(i21)) {
                    c29 = i21;
                    i22 = c30;
                    q015 = null;
                } else {
                    c29 = i21;
                    q015 = F0.q0(i21);
                    i22 = c30;
                }
                if (F0.isNull(i22)) {
                    c30 = i22;
                    i23 = c31;
                    q016 = null;
                } else {
                    c30 = i22;
                    q016 = F0.q0(i22);
                    i23 = c31;
                }
                if (F0.isNull(i23)) {
                    c31 = i23;
                    i24 = c32;
                    q017 = null;
                } else {
                    c31 = i23;
                    q017 = F0.q0(i23);
                    i24 = c32;
                }
                if (F0.isNull(i24)) {
                    c32 = i24;
                    i25 = c33;
                    q018 = null;
                } else {
                    c32 = i24;
                    q018 = F0.q0(i24);
                    i25 = c33;
                }
                if (F0.isNull(i25)) {
                    c33 = i25;
                    i26 = c34;
                    q019 = null;
                } else {
                    c33 = i25;
                    q019 = F0.q0(i25);
                    i26 = c34;
                }
                if (F0.isNull(i26)) {
                    c34 = i26;
                    i27 = c35;
                    q020 = null;
                } else {
                    c34 = i26;
                    q020 = F0.q0(i26);
                    i27 = c35;
                }
                if (F0.isNull(i27)) {
                    c35 = i27;
                    i28 = c36;
                    valueOf3 = null;
                } else {
                    c35 = i27;
                    valueOf3 = Double.valueOf(F0.getDouble(i27));
                    i28 = c36;
                }
                if (F0.isNull(i28)) {
                    c36 = i28;
                    i30 = i15;
                    i29 = c37;
                    valueOf4 = null;
                } else {
                    c36 = i28;
                    valueOf4 = Long.valueOf(F0.getLong(i28));
                    i29 = c37;
                    i30 = i15;
                }
                int i33 = i16;
                if (((int) F0.getLong(i29)) != 0) {
                    i31 = c38;
                    z = true;
                } else {
                    i31 = c38;
                    z = false;
                }
                int i34 = c4;
                int i35 = c6;
                int i36 = c39;
                boolean z3 = ((int) F0.getLong(i31)) != 0;
                int i37 = c5;
                if (((int) F0.getLong(i36)) != 0) {
                    i32 = c40;
                    z2 = true;
                } else {
                    i32 = c40;
                    z2 = false;
                }
                arrayList.add(new MbAdDbPlans(q021, q022, q023, q024, q025, q026, valueOf, valueOf5, q027, q028, q029, q030, q031, q0, q02, q03, q04, q05, q06, q07, q08, q09, valueOf2, q010, q011, q012, q013, q014, q015, q016, q017, q018, q019, q020, valueOf3, valueOf4, z, z3, z2, F0.isNull(i32) ? null : F0.q0(i32)));
                c40 = i32;
                c5 = i37;
                c3 = i2;
                c6 = i35;
                c39 = i36;
                c4 = i34;
                c38 = i31;
                c2 = i;
                int i38 = i29;
                c = i5;
                c15 = i13;
                c16 = i14;
                c23 = i17;
                c24 = i30;
                c25 = i33;
                c37 = i38;
            }
            return arrayList;
        } finally {
            F0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ MbAdDbPlans t(String str, y3.b bVar) {
        String q0;
        int i;
        String q02;
        int i2;
        String q03;
        int i3;
        String q04;
        int i4;
        String q05;
        int i5;
        String q06;
        int i6;
        String q07;
        int i7;
        String q08;
        int i8;
        String q09;
        int i9;
        Integer valueOf;
        int i10;
        String q010;
        int i11;
        String q011;
        int i12;
        String q012;
        int i13;
        String q013;
        int i14;
        String q014;
        int i15;
        String q015;
        int i16;
        String q016;
        int i17;
        String q017;
        int i18;
        String q018;
        int i19;
        String q019;
        int i20;
        String q020;
        int i21;
        Double valueOf2;
        int i22;
        Long valueOf3;
        int i23;
        boolean z;
        int i24;
        boolean z2;
        int i25;
        y3.e F0 = bVar.F0("SELECT * FROM mb_ad_db_plans where id=?");
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            int c = androidx.room.util.i.c(F0, "id");
            int c2 = androidx.room.util.i.c(F0, "version");
            int c3 = androidx.room.util.i.c(F0, "name");
            int c4 = androidx.room.util.i.c(F0, "startTime");
            int c5 = androidx.room.util.i.c(F0, "endTime");
            int c6 = androidx.room.util.i.c(F0, "extraConfig");
            int c7 = androidx.room.util.i.c(F0, "displayTimes");
            int c8 = androidx.room.util.i.c(F0, "showedTimes");
            int c9 = androidx.room.util.i.c(F0, "showDate");
            int c10 = androidx.room.util.i.c(F0, "advertiserName");
            int c11 = androidx.room.util.i.c(F0, "advertiserAvatar");
            int c12 = androidx.room.util.i.c(F0, "advertiserAvatarPath");
            int c13 = androidx.room.util.i.c(F0, "brand");
            int c14 = androidx.room.util.i.c(F0, "denyBrand");
            int c15 = androidx.room.util.i.c(F0, "model");
            int c16 = androidx.room.util.i.c(F0, "denyModel");
            int c17 = androidx.room.util.i.c(F0, "country");
            int c18 = androidx.room.util.i.c(F0, "scenes");
            int c19 = androidx.room.util.i.c(F0, "adSource");
            int c20 = androidx.room.util.i.c(F0, "extAdSlot");
            int c21 = androidx.room.util.i.c(F0, "adMaterialList");
            int c22 = androidx.room.util.i.c(F0, "adPlanUpdateTime");
            int c23 = androidx.room.util.i.c(F0, "sort");
            int c24 = androidx.room.util.i.c(F0, "adShowLevel");
            int c25 = androidx.room.util.i.c(F0, "filterClientVersion");
            int c26 = androidx.room.util.i.c(F0, "adPlanCreateTime");
            int c27 = androidx.room.util.i.c(F0, "appStarDesc");
            int c28 = androidx.room.util.i.c(F0, "appSizeDesc");
            int c29 = androidx.room.util.i.c(F0, "ctxEnableExpr");
            int c30 = androidx.room.util.i.c(F0, "ctxDisableExpr");
            int c31 = androidx.room.util.i.c(F0, "ctxAttributeConfig");
            int c32 = androidx.room.util.i.c(F0, "dispatchTimeStart");
            int c33 = androidx.room.util.i.c(F0, "dispatchTimeEnd");
            int c34 = androidx.room.util.i.c(F0, "extImage");
            int c35 = androidx.room.util.i.c(F0, "bidEcpmCent");
            int c36 = androidx.room.util.i.c(F0, "ecpmCent");
            int c37 = androidx.room.util.i.c(F0, "isValid");
            int c38 = androidx.room.util.i.c(F0, "h5LinkPreload");
            int c39 = androidx.room.util.i.c(F0, "h5LinkOpenByCct");
            int c40 = androidx.room.util.i.c(F0, "countryCode");
            MbAdDbPlans mbAdDbPlans = null;
            if (F0.C0()) {
                String q021 = F0.isNull(c) ? null : F0.q0(c);
                String q022 = F0.isNull(c2) ? null : F0.q0(c2);
                String q023 = F0.isNull(c3) ? null : F0.q0(c3);
                String q024 = F0.isNull(c4) ? null : F0.q0(c4);
                String q025 = F0.isNull(c5) ? null : F0.q0(c5);
                String q026 = F0.isNull(c6) ? null : F0.q0(c6);
                Integer valueOf4 = F0.isNull(c7) ? null : Integer.valueOf((int) F0.getLong(c7));
                Integer valueOf5 = F0.isNull(c8) ? null : Integer.valueOf((int) F0.getLong(c8));
                String q027 = F0.isNull(c9) ? null : F0.q0(c9);
                String q028 = F0.isNull(c10) ? null : F0.q0(c10);
                String q029 = F0.isNull(c11) ? null : F0.q0(c11);
                String q030 = F0.isNull(c12) ? null : F0.q0(c12);
                String q031 = F0.isNull(c13) ? null : F0.q0(c13);
                if (F0.isNull(c14)) {
                    i = c15;
                    q0 = null;
                } else {
                    q0 = F0.q0(c14);
                    i = c15;
                }
                if (F0.isNull(i)) {
                    i2 = c16;
                    q02 = null;
                } else {
                    q02 = F0.q0(i);
                    i2 = c16;
                }
                if (F0.isNull(i2)) {
                    i3 = c17;
                    q03 = null;
                } else {
                    q03 = F0.q0(i2);
                    i3 = c17;
                }
                if (F0.isNull(i3)) {
                    i4 = c18;
                    q04 = null;
                } else {
                    q04 = F0.q0(i3);
                    i4 = c18;
                }
                if (F0.isNull(i4)) {
                    i5 = c19;
                    q05 = null;
                } else {
                    q05 = F0.q0(i4);
                    i5 = c19;
                }
                if (F0.isNull(i5)) {
                    i6 = c20;
                    q06 = null;
                } else {
                    q06 = F0.q0(i5);
                    i6 = c20;
                }
                if (F0.isNull(i6)) {
                    i7 = c21;
                    q07 = null;
                } else {
                    q07 = F0.q0(i6);
                    i7 = c21;
                }
                if (F0.isNull(i7)) {
                    i8 = c22;
                    q08 = null;
                } else {
                    q08 = F0.q0(i7);
                    i8 = c22;
                }
                if (F0.isNull(i8)) {
                    i9 = c23;
                    q09 = null;
                } else {
                    q09 = F0.q0(i8);
                    i9 = c23;
                }
                if (F0.isNull(i9)) {
                    i10 = c24;
                    valueOf = null;
                } else {
                    valueOf = Integer.valueOf((int) F0.getLong(i9));
                    i10 = c24;
                }
                if (F0.isNull(i10)) {
                    i11 = c25;
                    q010 = null;
                } else {
                    q010 = F0.q0(i10);
                    i11 = c25;
                }
                if (F0.isNull(i11)) {
                    i12 = c26;
                    q011 = null;
                } else {
                    q011 = F0.q0(i11);
                    i12 = c26;
                }
                if (F0.isNull(i12)) {
                    i13 = c27;
                    q012 = null;
                } else {
                    q012 = F0.q0(i12);
                    i13 = c27;
                }
                if (F0.isNull(i13)) {
                    i14 = c28;
                    q013 = null;
                } else {
                    q013 = F0.q0(i13);
                    i14 = c28;
                }
                if (F0.isNull(i14)) {
                    i15 = c29;
                    q014 = null;
                } else {
                    q014 = F0.q0(i14);
                    i15 = c29;
                }
                if (F0.isNull(i15)) {
                    i16 = c30;
                    q015 = null;
                } else {
                    q015 = F0.q0(i15);
                    i16 = c30;
                }
                if (F0.isNull(i16)) {
                    i17 = c31;
                    q016 = null;
                } else {
                    q016 = F0.q0(i16);
                    i17 = c31;
                }
                if (F0.isNull(i17)) {
                    i18 = c32;
                    q017 = null;
                } else {
                    q017 = F0.q0(i17);
                    i18 = c32;
                }
                if (F0.isNull(i18)) {
                    i19 = c33;
                    q018 = null;
                } else {
                    q018 = F0.q0(i18);
                    i19 = c33;
                }
                if (F0.isNull(i19)) {
                    i20 = c34;
                    q019 = null;
                } else {
                    q019 = F0.q0(i19);
                    i20 = c34;
                }
                if (F0.isNull(i20)) {
                    i21 = c35;
                    q020 = null;
                } else {
                    q020 = F0.q0(i20);
                    i21 = c35;
                }
                if (F0.isNull(i21)) {
                    i22 = c36;
                    valueOf2 = null;
                } else {
                    valueOf2 = Double.valueOf(F0.getDouble(i21));
                    i22 = c36;
                }
                if (F0.isNull(i22)) {
                    i23 = c37;
                    valueOf3 = null;
                } else {
                    valueOf3 = Long.valueOf(F0.getLong(i22));
                    i23 = c37;
                }
                if (((int) F0.getLong(i23)) != 0) {
                    i24 = c38;
                    z = true;
                } else {
                    z = false;
                    i24 = c38;
                }
                if (((int) F0.getLong(i24)) != 0) {
                    i25 = c39;
                    z2 = true;
                } else {
                    z2 = false;
                    i25 = c39;
                }
                mbAdDbPlans = new MbAdDbPlans(q021, q022, q023, q024, q025, q026, valueOf4, valueOf5, q027, q028, q029, q030, q031, q0, q02, q03, q04, q05, q06, q07, q08, q09, valueOf, q010, q011, q012, q013, q014, q015, q016, q017, q018, q019, q020, valueOf2, valueOf3, z, z2, ((int) F0.getLong(i25)) != 0, F0.isNull(c40) ? null : F0.q0(c40));
            }
            F0.close();
            return mbAdDbPlans;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List u(String str, y3.b bVar) {
        int i;
        int i2;
        Integer valueOf;
        String q0;
        int i3;
        String q02;
        int i4;
        int i5;
        String q03;
        int i6;
        String q04;
        int i7;
        String q05;
        int i8;
        String q06;
        int i9;
        String q07;
        int i10;
        String q08;
        int i11;
        String q09;
        int i12;
        int i13;
        int i14;
        Integer valueOf2;
        int i15;
        String q010;
        int i16;
        String q011;
        int i17;
        int i18;
        String q012;
        int i19;
        String q013;
        int i20;
        String q014;
        int i21;
        String q015;
        int i22;
        String q016;
        int i23;
        String q017;
        int i24;
        String q018;
        int i25;
        String q019;
        int i26;
        String q020;
        int i27;
        Double valueOf3;
        int i28;
        Long valueOf4;
        int i29;
        int i30;
        int i31;
        boolean z;
        int i32;
        boolean z2;
        int i33;
        boolean z3;
        y3.e F0 = bVar.F0("SELECT * FROM mb_ad_db_plans where adSource=?");
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            int c = androidx.room.util.i.c(F0, "id");
            int c2 = androidx.room.util.i.c(F0, "version");
            int c3 = androidx.room.util.i.c(F0, "name");
            int c4 = androidx.room.util.i.c(F0, "startTime");
            int c5 = androidx.room.util.i.c(F0, "endTime");
            int c6 = androidx.room.util.i.c(F0, "extraConfig");
            int c7 = androidx.room.util.i.c(F0, "displayTimes");
            int c8 = androidx.room.util.i.c(F0, "showedTimes");
            int c9 = androidx.room.util.i.c(F0, "showDate");
            int c10 = androidx.room.util.i.c(F0, "advertiserName");
            int c11 = androidx.room.util.i.c(F0, "advertiserAvatar");
            int c12 = androidx.room.util.i.c(F0, "advertiserAvatarPath");
            int c13 = androidx.room.util.i.c(F0, "brand");
            int c14 = androidx.room.util.i.c(F0, "denyBrand");
            int c15 = androidx.room.util.i.c(F0, "model");
            int c16 = androidx.room.util.i.c(F0, "denyModel");
            int c17 = androidx.room.util.i.c(F0, "country");
            int c18 = androidx.room.util.i.c(F0, "scenes");
            int c19 = androidx.room.util.i.c(F0, "adSource");
            int c20 = androidx.room.util.i.c(F0, "extAdSlot");
            int c21 = androidx.room.util.i.c(F0, "adMaterialList");
            int c22 = androidx.room.util.i.c(F0, "adPlanUpdateTime");
            int c23 = androidx.room.util.i.c(F0, "sort");
            int c24 = androidx.room.util.i.c(F0, "adShowLevel");
            int c25 = androidx.room.util.i.c(F0, "filterClientVersion");
            int c26 = androidx.room.util.i.c(F0, "adPlanCreateTime");
            int c27 = androidx.room.util.i.c(F0, "appStarDesc");
            int c28 = androidx.room.util.i.c(F0, "appSizeDesc");
            int c29 = androidx.room.util.i.c(F0, "ctxEnableExpr");
            int c30 = androidx.room.util.i.c(F0, "ctxDisableExpr");
            int c31 = androidx.room.util.i.c(F0, "ctxAttributeConfig");
            int c32 = androidx.room.util.i.c(F0, "dispatchTimeStart");
            int c33 = androidx.room.util.i.c(F0, "dispatchTimeEnd");
            int c34 = androidx.room.util.i.c(F0, "extImage");
            int c35 = androidx.room.util.i.c(F0, "bidEcpmCent");
            int c36 = androidx.room.util.i.c(F0, "ecpmCent");
            int c37 = androidx.room.util.i.c(F0, "isValid");
            int c38 = androidx.room.util.i.c(F0, "h5LinkPreload");
            int c39 = androidx.room.util.i.c(F0, "h5LinkOpenByCct");
            int c40 = androidx.room.util.i.c(F0, "countryCode");
            ArrayList arrayList = new ArrayList();
            while (F0.C0()) {
                String q021 = F0.isNull(c) ? null : F0.q0(c);
                String q022 = F0.isNull(c2) ? null : F0.q0(c2);
                String q023 = F0.isNull(c3) ? null : F0.q0(c3);
                String q024 = F0.isNull(c4) ? null : F0.q0(c4);
                String q025 = F0.isNull(c5) ? null : F0.q0(c5);
                String q026 = F0.isNull(c6) ? null : F0.q0(c6);
                if (F0.isNull(c7)) {
                    i = c2;
                    i2 = c3;
                    valueOf = null;
                } else {
                    i = c2;
                    i2 = c3;
                    valueOf = Integer.valueOf((int) F0.getLong(c7));
                }
                Integer valueOf5 = F0.isNull(c8) ? null : Integer.valueOf((int) F0.getLong(c8));
                String q027 = F0.isNull(c9) ? null : F0.q0(c9);
                String q028 = F0.isNull(c10) ? null : F0.q0(c10);
                String q029 = F0.isNull(c11) ? null : F0.q0(c11);
                String q030 = F0.isNull(c12) ? null : F0.q0(c12);
                String q031 = F0.isNull(c13) ? null : F0.q0(c13);
                if (F0.isNull(c14)) {
                    i3 = c15;
                    q0 = null;
                } else {
                    q0 = F0.q0(c14);
                    i3 = c15;
                }
                if (F0.isNull(i3)) {
                    i4 = c16;
                    q02 = null;
                } else {
                    q02 = F0.q0(i3);
                    i4 = c16;
                }
                if (F0.isNull(i4)) {
                    i5 = c;
                    i6 = c17;
                    q03 = null;
                } else {
                    i5 = c;
                    q03 = F0.q0(i4);
                    i6 = c17;
                }
                if (F0.isNull(i6)) {
                    c17 = i6;
                    i7 = c18;
                    q04 = null;
                } else {
                    c17 = i6;
                    q04 = F0.q0(i6);
                    i7 = c18;
                }
                if (F0.isNull(i7)) {
                    c18 = i7;
                    i8 = c19;
                    q05 = null;
                } else {
                    c18 = i7;
                    q05 = F0.q0(i7);
                    i8 = c19;
                }
                if (F0.isNull(i8)) {
                    c19 = i8;
                    i9 = c20;
                    q06 = null;
                } else {
                    c19 = i8;
                    q06 = F0.q0(i8);
                    i9 = c20;
                }
                if (F0.isNull(i9)) {
                    c20 = i9;
                    i10 = c21;
                    q07 = null;
                } else {
                    c20 = i9;
                    q07 = F0.q0(i9);
                    i10 = c21;
                }
                if (F0.isNull(i10)) {
                    c21 = i10;
                    i11 = c22;
                    q08 = null;
                } else {
                    c21 = i10;
                    q08 = F0.q0(i10);
                    i11 = c22;
                }
                if (F0.isNull(i11)) {
                    c22 = i11;
                    i12 = c23;
                    q09 = null;
                } else {
                    c22 = i11;
                    q09 = F0.q0(i11);
                    i12 = c23;
                }
                if (F0.isNull(i12)) {
                    i13 = i3;
                    i14 = i4;
                    i15 = c24;
                    valueOf2 = null;
                } else {
                    i13 = i3;
                    i14 = i4;
                    valueOf2 = Integer.valueOf((int) F0.getLong(i12));
                    i15 = c24;
                }
                if (F0.isNull(i15)) {
                    i16 = c25;
                    q010 = null;
                } else {
                    q010 = F0.q0(i15);
                    i16 = c25;
                }
                if (F0.isNull(i16)) {
                    i17 = i12;
                    i18 = c26;
                    q011 = null;
                } else {
                    q011 = F0.q0(i16);
                    i17 = i12;
                    i18 = c26;
                }
                if (F0.isNull(i18)) {
                    c26 = i18;
                    i19 = c27;
                    q012 = null;
                } else {
                    c26 = i18;
                    q012 = F0.q0(i18);
                    i19 = c27;
                }
                if (F0.isNull(i19)) {
                    c27 = i19;
                    i20 = c28;
                    q013 = null;
                } else {
                    c27 = i19;
                    q013 = F0.q0(i19);
                    i20 = c28;
                }
                if (F0.isNull(i20)) {
                    c28 = i20;
                    i21 = c29;
                    q014 = null;
                } else {
                    c28 = i20;
                    q014 = F0.q0(i20);
                    i21 = c29;
                }
                if (F0.isNull(i21)) {
                    c29 = i21;
                    i22 = c30;
                    q015 = null;
                } else {
                    c29 = i21;
                    q015 = F0.q0(i21);
                    i22 = c30;
                }
                if (F0.isNull(i22)) {
                    c30 = i22;
                    i23 = c31;
                    q016 = null;
                } else {
                    c30 = i22;
                    q016 = F0.q0(i22);
                    i23 = c31;
                }
                if (F0.isNull(i23)) {
                    c31 = i23;
                    i24 = c32;
                    q017 = null;
                } else {
                    c31 = i23;
                    q017 = F0.q0(i23);
                    i24 = c32;
                }
                if (F0.isNull(i24)) {
                    c32 = i24;
                    i25 = c33;
                    q018 = null;
                } else {
                    c32 = i24;
                    q018 = F0.q0(i24);
                    i25 = c33;
                }
                if (F0.isNull(i25)) {
                    c33 = i25;
                    i26 = c34;
                    q019 = null;
                } else {
                    c33 = i25;
                    q019 = F0.q0(i25);
                    i26 = c34;
                }
                if (F0.isNull(i26)) {
                    c34 = i26;
                    i27 = c35;
                    q020 = null;
                } else {
                    c34 = i26;
                    q020 = F0.q0(i26);
                    i27 = c35;
                }
                if (F0.isNull(i27)) {
                    c35 = i27;
                    i28 = c36;
                    valueOf3 = null;
                } else {
                    c35 = i27;
                    valueOf3 = Double.valueOf(F0.getDouble(i27));
                    i28 = c36;
                }
                if (F0.isNull(i28)) {
                    c36 = i28;
                    i30 = i15;
                    i29 = c37;
                    valueOf4 = null;
                } else {
                    c36 = i28;
                    valueOf4 = Long.valueOf(F0.getLong(i28));
                    i29 = c37;
                    i30 = i15;
                }
                int i34 = i16;
                if (((int) F0.getLong(i29)) != 0) {
                    i31 = c38;
                    z = true;
                } else {
                    i31 = c38;
                    z = false;
                }
                int i35 = c4;
                if (((int) F0.getLong(i31)) != 0) {
                    i32 = c39;
                    z2 = true;
                } else {
                    i32 = c39;
                    z2 = false;
                }
                int i36 = c5;
                if (((int) F0.getLong(i32)) != 0) {
                    i33 = c40;
                    z3 = true;
                } else {
                    i33 = c40;
                    z3 = false;
                }
                arrayList.add(new MbAdDbPlans(q021, q022, q023, q024, q025, q026, valueOf, valueOf5, q027, q028, q029, q030, q031, q0, q02, q03, q04, q05, q06, q07, q08, q09, valueOf2, q010, q011, q012, q013, q014, q015, q016, q017, q018, q019, q020, valueOf3, valueOf4, z, z2, z3, F0.isNull(i33) ? null : F0.q0(i33)));
                c40 = i33;
                c4 = i35;
                c5 = i36;
                c38 = i31;
                c39 = i32;
                c2 = i;
                c3 = i2;
                int i37 = i29;
                c = i5;
                c15 = i13;
                c16 = i14;
                c23 = i17;
                c24 = i30;
                c25 = i34;
                c37 = i37;
            }
            F0.close();
            return arrayList;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit v(MbAdDbPlans mbAdDbPlans, y3.b bVar) {
        this.b.d(bVar, mbAdDbPlans);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit w(List list, y3.b bVar) {
        this.b.c(bVar, list);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit x(MbAdDbPlans mbAdDbPlans, y3.b bVar) {
        this.c.c(bVar, mbAdDbPlans);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit y(boolean z, String str, y3.b bVar) {
        y3.e F0 = bVar.F0("UPDATE mb_ad_db_plans SET isValid = ? WHERE version !=?");
        try {
            F0.c(1, z ? 1L : 0L);
            if (str == null) {
                F0.g(2);
            } else {
                F0.i(2, str);
            }
            F0.C0();
            Unit unit = Unit.a;
            F0.close();
            return unit;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    @Override // uh.a
    public Object a(Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: uh.e
            public final Object invoke(Object obj) {
                List s;
                s = j.s((y3.b) obj);
                return s;
            }
        }, continuation);
    }

    @Override // uh.a
    public Object b(final List list, Continuation continuation) {
        list.getClass();
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: uh.d
            public final Object invoke(Object obj) {
                Unit w;
                w = j.this.w(list, (y3.b) obj);
                return w;
            }
        }, continuation);
    }

    @Override // uh.a
    public Object c(final MbAdDbPlans mbAdDbPlans, Continuation continuation) {
        mbAdDbPlans.getClass();
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: uh.h
            public final Object invoke(Object obj) {
                Unit v;
                v = j.this.v(mbAdDbPlans, (y3.b) obj);
                return v;
            }
        }, continuation);
    }

    @Override // uh.a
    public Object d(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: uh.i
            public final Object invoke(Object obj) {
                Unit r;
                r = j.r(str, (y3.b) obj);
                return r;
            }
        }, continuation);
    }

    @Override // uh.a
    public Object e(final boolean z, final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: uh.f
            public final Object invoke(Object obj) {
                Unit y;
                y = j.y(z, str, (y3.b) obj);
                return y;
            }
        }, continuation);
    }

    @Override // uh.a
    public Object f(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: uh.c
            public final Object invoke(Object obj) {
                MbAdDbPlans t;
                t = j.t(str, (y3.b) obj);
                return t;
            }
        }, continuation);
    }

    @Override // uh.a
    public Object g(final MbAdDbPlans mbAdDbPlans, Continuation continuation) {
        mbAdDbPlans.getClass();
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: uh.b
            public final Object invoke(Object obj) {
                Unit x;
                x = j.this.x(mbAdDbPlans, (y3.b) obj);
                return x;
            }
        }, continuation);
    }

    @Override // uh.a
    public Object h(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: uh.g
            public final Object invoke(Object obj) {
                List u;
                u = j.u(str, (y3.b) obj);
                return u;
            }
        }, continuation);
    }
}
