package com.cloud.tmc.integration.model;

import com.cloud.tmc.integration.BuildConfig;
import com.cloud.tmc.kernel.model.BaseBean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/cloud/tmc/integration/model/TabBarBadgeMessage;", "Lcom/cloud/tmc/kernel/model/BaseBean;", "index", "", "showBadge", "", "text", "", "(IZLjava/lang/String;)V", "getIndex", "()I", "setIndex", "(I)V", "getShowBadge", "()Z", "setShowBadge", "(Z)V", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "toString", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final /* data */ class TabBarBadgeMessage extends BaseBean {
    private int index;
    private boolean showBadge;
    private String text;

    public TabBarBadgeMessage() {
        this(0, false, null, 7, null);
    }

    public TabBarBadgeMessage(int i, boolean z, String str) {
        this.index = i;
        this.showBadge = z;
        this.text = str;
    }

    public /* synthetic */ TabBarBadgeMessage(int i, boolean z, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? -1 : i, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? null : str);
    }

    public static /* synthetic */ TabBarBadgeMessage copy$default(TabBarBadgeMessage tabBarBadgeMessage, int i, boolean z, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = tabBarBadgeMessage.index;
        }
        if ((i2 & 2) != 0) {
            z = tabBarBadgeMessage.showBadge;
        }
        if ((i2 & 4) != 0) {
            str = tabBarBadgeMessage.text;
        }
        return tabBarBadgeMessage.copy(i, z, str);
    }

    /* renamed from: component1, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getShowBadge() {
        return this.showBadge;
    }

    /* renamed from: component3, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public final TabBarBadgeMessage copy(int index, boolean showBadge, String text) {
        return new TabBarBadgeMessage(index, showBadge, text);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TabBarBadgeMessage)) {
            return false;
        }
        TabBarBadgeMessage tabBarBadgeMessage = (TabBarBadgeMessage) other;
        return this.index == tabBarBadgeMessage.index && this.showBadge == tabBarBadgeMessage.showBadge && Intrinsics.c(this.text, tabBarBadgeMessage.text);
    }

    public final int getIndex() {
        return this.index;
    }

    public final boolean getShowBadge() {
        return this.showBadge;
    }

    public final String getText() {
        return this.text;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i = this.index * 31;
        boolean z = this.showBadge;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        int i3 = (i + i2) * 31;
        String str = this.text;
        return i3 + (str == null ? 0 : str.hashCode());
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    public final void setShowBadge(boolean z) {
        this.showBadge = z;
    }

    public final void setText(String str) {
        this.text = str;
    }

    public String toString() {
        return "TabBarBadgeMessage(index=" + this.index + ", showBadge=" + this.showBadge + ", text=" + this.text + ")";
    }
}
