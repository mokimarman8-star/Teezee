package com.transsion.member;

import com.transsion.memberapi.MemberSource;
import com.transsion.memberapi.MembershipDetailType;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public /* synthetic */ class MemberFragment$b {
    public static final /* synthetic */ int[] a;
    public static final /* synthetic */ int[] b;

    static {
        int[] iArr = new int[MembershipDetailType.values().length];
        try {
            iArr[MembershipDetailType.TRIAL.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[MembershipDetailType.SUBSCRIPTION_MEMBER.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr[MembershipDetailType.FINANCIAL_MEMBER.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr[MembershipDetailType.EXPIRED.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        a = iArr;
        int[] iArr2 = new int[MemberSource.values().length];
        try {
            iArr2[MemberSource.SOURCE_LANDSCAPE_PLAY.ordinal()] = 1;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[MemberSource.SOURCE_HDDL.ordinal()] = 2;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            iArr2[MemberSource.SOURCE_AD_DIALOG.ordinal()] = 3;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            iArr2[MemberSource.SOURCE_DOWNLOAD_DIALOG.ordinal()] = 4;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            iArr2[MemberSource.SOURCE_OTHER_DOWNLOAD_DIALOG.ordinal()] = 5;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            iArr2[MemberSource.SOURCE_MULTI_DL.ordinal()] = 6;
        } catch (NoSuchFieldError unused10) {
        }
        b = iArr2;
    }
}
