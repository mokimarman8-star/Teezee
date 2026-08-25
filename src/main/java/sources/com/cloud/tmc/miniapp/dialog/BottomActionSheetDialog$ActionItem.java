package com.cloud.tmc.miniapp.dialog;

import com.cloud.tmc.kernel.model.BaseBean;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class BottomActionSheetDialog$ActionItem extends BaseBean implements Serializable {
    private final String color;
    private final String disabledColor;
    private final boolean enable;
    private final String icon;
    private final String id;
    private final String maskColor;
    private final String text;

    public BottomActionSheetDialog$ActionItem() {
        this(null, null, null, null, false, null, null, 127, null);
    }

    public BottomActionSheetDialog$ActionItem(String str, String str2, String str3, String str4, boolean z, String str5, String str6) {
        Intrinsics.h(str4, "disabledColor");
        Intrinsics.h(str6, "maskColor");
        this.id = str;
        this.text = str2;
        this.color = str3;
        this.disabledColor = str4;
        this.enable = z;
        this.icon = str5;
        this.maskColor = str6;
    }

    public /* synthetic */ BottomActionSheetDialog$ActionItem(String str, String str2, String str3, String str4, boolean z, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? "#4D191F2B" : str4, (i & 16) != 0 ? true : z, (i & 32) == 0 ? str5 : null, (i & 64) != 0 ? "#0F191F2B" : str6);
    }

    public static /* synthetic */ BottomActionSheetDialog$ActionItem copy$default(BottomActionSheetDialog$ActionItem bottomActionSheetDialog$ActionItem, String str, String str2, String str3, String str4, boolean z, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bottomActionSheetDialog$ActionItem.id;
        }
        if ((i & 2) != 0) {
            str2 = bottomActionSheetDialog$ActionItem.text;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = bottomActionSheetDialog$ActionItem.color;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = bottomActionSheetDialog$ActionItem.disabledColor;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            z = bottomActionSheetDialog$ActionItem.enable;
        }
        boolean z2 = z;
        if ((i & 32) != 0) {
            str5 = bottomActionSheetDialog$ActionItem.icon;
        }
        String str10 = str5;
        if ((i & 64) != 0) {
            str6 = bottomActionSheetDialog$ActionItem.maskColor;
        }
        return bottomActionSheetDialog$ActionItem.copy(str, str7, str8, str9, z2, str10, str6);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.text;
    }

    public final String component3() {
        return this.color;
    }

    public final String component4() {
        return this.disabledColor;
    }

    public final boolean component5() {
        return this.enable;
    }

    public final String component6() {
        return this.icon;
    }

    public final String component7() {
        return this.maskColor;
    }

    public final BottomActionSheetDialog$ActionItem copy(String str, String str2, String str3, String str4, boolean z, String str5, String str6) {
        Intrinsics.h(str4, "disabledColor");
        Intrinsics.h(str6, "maskColor");
        return new BottomActionSheetDialog$ActionItem(str, str2, str3, str4, z, str5, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BottomActionSheetDialog$ActionItem)) {
            return false;
        }
        BottomActionSheetDialog$ActionItem bottomActionSheetDialog$ActionItem = (BottomActionSheetDialog$ActionItem) obj;
        return Intrinsics.c(this.id, bottomActionSheetDialog$ActionItem.id) && Intrinsics.c(this.text, bottomActionSheetDialog$ActionItem.text) && Intrinsics.c(this.color, bottomActionSheetDialog$ActionItem.color) && Intrinsics.c(this.disabledColor, bottomActionSheetDialog$ActionItem.disabledColor) && this.enable == bottomActionSheetDialog$ActionItem.enable && Intrinsics.c(this.icon, bottomActionSheetDialog$ActionItem.icon) && Intrinsics.c(this.maskColor, bottomActionSheetDialog$ActionItem.maskColor);
    }

    public final String getColor() {
        return this.color;
    }

    public final String getDisabledColor() {
        return this.disabledColor;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getId() {
        return this.id;
    }

    public final String getMaskColor() {
        return this.maskColor;
    }

    public final String getText() {
        return this.text;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.id;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.text;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.color;
        int hashCode3 = (this.disabledColor.hashCode() + ((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31)) * 31;
        boolean z = this.enable;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (hashCode3 + i) * 31;
        String str4 = this.icon;
        return this.maskColor.hashCode() + ((i2 + (str4 != null ? str4.hashCode() : 0)) * 31);
    }

    public String toString() {
        return "ActionItem(id=" + this.id + ", text=" + this.text + ", color=" + this.color + ", disabledColor=" + this.disabledColor + ", enable=" + this.enable + ", icon=" + this.icon + ", maskColor=" + this.maskColor + ")";
    }
}
