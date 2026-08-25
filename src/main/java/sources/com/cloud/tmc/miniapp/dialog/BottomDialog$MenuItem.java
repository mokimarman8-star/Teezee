package com.cloud.tmc.miniapp.dialog;

import com.cloud.tmc.kernel.model.BaseBean;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class BottomDialog$MenuItem extends BaseBean implements Serializable {
    private boolean customStyle;
    private boolean dotBadge;
    private int icon;
    private final String id;
    private String name;

    public BottomDialog$MenuItem(String str, int i, String str2, boolean z, boolean z2) {
        Intrinsics.h(str, "id");
        this.id = str;
        this.icon = i;
        this.name = str2;
        this.dotBadge = z;
        this.customStyle = z2;
    }

    public /* synthetic */ BottomDialog$MenuItem(String str, int i, String str2, boolean z, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, str2, (i2 & 8) != 0 ? false : z, (i2 & 16) != 0 ? false : z2);
    }

    public static /* synthetic */ BottomDialog$MenuItem copy$default(BottomDialog$MenuItem bottomDialog$MenuItem, String str, int i, String str2, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = bottomDialog$MenuItem.id;
        }
        if ((i2 & 2) != 0) {
            i = bottomDialog$MenuItem.icon;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            str2 = bottomDialog$MenuItem.name;
        }
        String str3 = str2;
        if ((i2 & 8) != 0) {
            z = bottomDialog$MenuItem.dotBadge;
        }
        boolean z3 = z;
        if ((i2 & 16) != 0) {
            z2 = bottomDialog$MenuItem.customStyle;
        }
        return bottomDialog$MenuItem.copy(str, i3, str3, z3, z2);
    }

    public final String component1() {
        return this.id;
    }

    public final int component2() {
        return this.icon;
    }

    public final String component3() {
        return this.name;
    }

    public final boolean component4() {
        return this.dotBadge;
    }

    public final boolean component5() {
        return this.customStyle;
    }

    public final BottomDialog$MenuItem copy(String str, int i, String str2, boolean z, boolean z2) {
        Intrinsics.h(str, "id");
        return new BottomDialog$MenuItem(str, i, str2, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BottomDialog$MenuItem)) {
            return false;
        }
        BottomDialog$MenuItem bottomDialog$MenuItem = (BottomDialog$MenuItem) obj;
        return Intrinsics.c(this.id, bottomDialog$MenuItem.id) && this.icon == bottomDialog$MenuItem.icon && Intrinsics.c(this.name, bottomDialog$MenuItem.name) && this.dotBadge == bottomDialog$MenuItem.dotBadge && this.customStyle == bottomDialog$MenuItem.customStyle;
    }

    public final boolean getCustomStyle() {
        return this.customStyle;
    }

    public final boolean getDotBadge() {
        return this.dotBadge;
    }

    public final int getIcon() {
        return this.icon;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = (this.icon + (this.id.hashCode() * 31)) * 31;
        String str = this.name;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        boolean z = this.dotBadge;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (hashCode2 + i) * 31;
        boolean z2 = this.customStyle;
        return i2 + (z2 ? 1 : z2 ? 1 : 0);
    }

    public final void setCustomStyle(boolean z) {
        this.customStyle = z;
    }

    public final void setDotBadge(boolean z) {
        this.dotBadge = z;
    }

    public final void setIcon(int i) {
        this.icon = i;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public String toString() {
        return "MenuItem(id=" + this.id + ", icon=" + this.icon + ", name=" + this.name + ", dotBadge=" + this.dotBadge + ", customStyle=" + this.customStyle + ")";
    }
}
