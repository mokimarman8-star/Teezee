package com.transsion.payment.lib.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import androidx.compose.foundation.e;
import com.transsion.gslb.BuildConfig;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\u0017\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0003JA\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0001J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0013\u0010 \u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u001fHÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\u0016\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R(\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006*"}, d2 = {"Lcom/transsion/payment/lib/bean/CreateOrderReq;", "Landroid/os/Parcelable;", "productId", BuildConfig.FLAVOR, "cpFrontPage", "subscriptOrder", BuildConfig.FLAVOR, "extStrJson", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/util/Map;)V", "getProductId", "()Ljava/lang/String;", "setProductId", "(Ljava/lang/String;)V", "getCpFrontPage", "setCpFrontPage", "getSubscriptOrder", "()Z", "setSubscriptOrder", "(Z)V", "getExtStrJson", "()Ljava/util/Map;", "setExtStrJson", "(Ljava/util/Map;)V", "component1", "component2", "component3", "component4", "copy", "describeContents", BuildConfig.FLAVOR, "equals", "other", BuildConfig.FLAVOR, "hashCode", "toString", "writeToParcel", BuildConfig.FLAVOR, "dest", "Landroid/os/Parcel;", "flags", "LibPayment_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class CreateOrderReq implements Parcelable {
    public static final Parcelable.Creator<CreateOrderReq> CREATOR = new a();
    private String cpFrontPage;
    private Map<String, String> extStrJson;
    private String productId;
    private boolean subscriptOrder;

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CreateOrderReq createFromParcel(Parcel parcel) {
            LinkedHashMap linkedHashMap;
            Intrinsics.h(parcel, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            boolean z = parcel.readInt() != 0;
            if (parcel.readInt() == 0) {
                linkedHashMap = null;
            } else {
                int readInt = parcel.readInt();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(readInt);
                for (int i = 0; i != readInt; i++) {
                    linkedHashMap2.put(parcel.readString(), parcel.readString());
                }
                linkedHashMap = linkedHashMap2;
            }
            return new CreateOrderReq(readString, readString2, z, linkedHashMap);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final CreateOrderReq[] newArray(int i) {
            return new CreateOrderReq[i];
        }
    }

    public CreateOrderReq(String str, String str2, boolean z, Map<String, String> map) {
        Intrinsics.h(str, "productId");
        this.productId = str;
        this.cpFrontPage = str2;
        this.subscriptOrder = z;
        this.extStrJson = map;
    }

    public /* synthetic */ CreateOrderReq(String str, String str2, boolean z, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? null : map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CreateOrderReq copy$default(CreateOrderReq createOrderReq, String str, String str2, boolean z, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = createOrderReq.productId;
        }
        if ((i & 2) != 0) {
            str2 = createOrderReq.cpFrontPage;
        }
        if ((i & 4) != 0) {
            z = createOrderReq.subscriptOrder;
        }
        if ((i & 8) != 0) {
            map = createOrderReq.extStrJson;
        }
        return createOrderReq.copy(str, str2, z, map);
    }

    /* renamed from: component1, reason: from getter */
    public final String getProductId() {
        return this.productId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCpFrontPage() {
        return this.cpFrontPage;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getSubscriptOrder() {
        return this.subscriptOrder;
    }

    public final Map<String, String> component4() {
        return this.extStrJson;
    }

    public final CreateOrderReq copy(String productId, String cpFrontPage, boolean subscriptOrder, Map<String, String> extStrJson) {
        Intrinsics.h(productId, "productId");
        return new CreateOrderReq(productId, cpFrontPage, subscriptOrder, extStrJson);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreateOrderReq)) {
            return false;
        }
        CreateOrderReq createOrderReq = (CreateOrderReq) other;
        return Intrinsics.c(this.productId, createOrderReq.productId) && Intrinsics.c(this.cpFrontPage, createOrderReq.cpFrontPage) && this.subscriptOrder == createOrderReq.subscriptOrder && Intrinsics.c(this.extStrJson, createOrderReq.extStrJson);
    }

    public final String getCpFrontPage() {
        return this.cpFrontPage;
    }

    public final Map<String, String> getExtStrJson() {
        return this.extStrJson;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final boolean getSubscriptOrder() {
        return this.subscriptOrder;
    }

    public int hashCode() {
        int hashCode = this.productId.hashCode() * 31;
        String str = this.cpFrontPage;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + e.a(this.subscriptOrder)) * 31;
        Map<String, String> map = this.extStrJson;
        return hashCode2 + (map != null ? map.hashCode() : 0);
    }

    public final void setCpFrontPage(String str) {
        this.cpFrontPage = str;
    }

    public final void setExtStrJson(Map<String, String> map) {
        this.extStrJson = map;
    }

    public final void setProductId(String str) {
        Intrinsics.h(str, "<set-?>");
        this.productId = str;
    }

    public final void setSubscriptOrder(boolean z) {
        this.subscriptOrder = z;
    }

    public String toString() {
        return "CreateOrderReq(productId=" + this.productId + ", cpFrontPage=" + this.cpFrontPage + ", subscriptOrder=" + this.subscriptOrder + ", extStrJson=" + this.extStrJson + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.h(dest, "dest");
        dest.writeString(this.productId);
        dest.writeString(this.cpFrontPage);
        dest.writeInt(this.subscriptOrder ? 1 : 0);
        Map<String, String> map = this.extStrJson;
        if (map == null) {
            dest.writeInt(0);
            return;
        }
        dest.writeInt(1);
        dest.writeInt(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            dest.writeString(entry.getKey());
            dest.writeString(entry.getValue());
        }
    }
}
