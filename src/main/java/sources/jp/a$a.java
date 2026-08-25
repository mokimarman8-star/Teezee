package jp;

import com.transsion.room.api.RoomsViewType;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public /* synthetic */ class a$a {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[RoomsViewType.values().length];
        try {
            iArr[RoomsViewType.TYPE_ROOM_HOME.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[RoomsViewType.TYPE_TRENDING.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr[RoomsViewType.TYPE_SUBJECT_DETAIL.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        a = iArr;
    }
}
