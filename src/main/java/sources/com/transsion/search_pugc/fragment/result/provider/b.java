package com.transsion.search_pugc.fragment.result.provider;

import android.content.Context;
import android.text.SpannableString;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search_pugc.constant.ResultCollectItemWrapper;
import com.transsion.ugcvideodetail.api.UGCVideoTypeKt;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ni.f;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b extends BaseItemProvider {
    private final boolean e;
    private final int f;

    public b() {
        this(false, 1, null);
    }

    public b(boolean z) {
        this.e = z;
        this.f = ResultCollectItemWrapper.Type.DATA.ordinal();
    }

    public /* synthetic */ b(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    public int l() {
        return this.f;
    }

    public int m() {
        return R$layout.item_search_collection;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0097, code lost:
    
        if (r1 == null) goto L38;
     */
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(BaseViewHolder baseViewHolder, ResultCollectItemWrapper resultCollectItemWrapper) {
        String title;
        String str;
        Cover cover;
        String url;
        Cover cover2;
        String title2;
        Long duration;
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(resultCollectItemWrapper, "item");
        int i = R$id.v_corner;
        UGCVideo a = resultCollectItemWrapper.a();
        SpannableString spannableString = null;
        String corner = a != null ? a.getCorner() : null;
        baseViewHolder.setVisible(i, !(corner == null || corner.length() == 0));
        int i2 = R$id.tv_view_resource_corner;
        UGCVideo a2 = resultCollectItemWrapper.a();
        baseViewHolder.setText(i2, a2 != null ? a2.getCorner() : null);
        int i3 = R$id.tv_view_resource_tag;
        UGCVideo a3 = resultCollectItemWrapper.a();
        baseViewHolder.setText(i3, (a3 == null || (duration = a3.getDuration()) == null) ? null : com.transsion.search_pugc.constant.a.j(duration.longValue()));
        UGCVideo a4 = resultCollectItemWrapper.a();
        if (a4 != null) {
            UGCVideoTypeKt.i((ImageView) baseViewHolder.getView(R$id.iv_view_resource_tag), a4, (Integer) null, 4, (Object) null);
        } else {
            baseViewHolder.setImageResource(R$id.iv_view_resource_tag, UGCVideoTypeKt.e((String) null));
        }
        TextView textView = (TextView) baseViewHolder.getView(R$id.tv_title);
        if (this.e) {
            textView.setLines(1);
            UGCVideo a5 = resultCollectItemWrapper.a();
            if (a5 != null && (title2 = a5.getEpTitle()) != null) {
                if (StringsKt.q0(title2)) {
                    title2 = null;
                }
            }
            UGCVideo a6 = resultCollectItemWrapper.a();
            title2 = a6 != null ? a6.getTitle() : null;
            if (title2 != null) {
                Context context = textView.getContext();
                Intrinsics.g(context, "getContext(...)");
                spannableString = com.transsion.search_pugc.constant.a.d(title2, context, com.transsion.search_pugc.g.g.a(textView.getContext()).e());
            }
        } else {
            textView.setLines(2);
            UGCVideo a7 = resultCollectItemWrapper.a();
            if (a7 != null && (title = a7.getTitle()) != null) {
                Context context2 = textView.getContext();
                Intrinsics.g(context2, "getContext(...)");
                spannableString = com.transsion.search_pugc.constant.a.d(title, context2, com.transsion.search_pugc.g.g.a(textView.getContext()).e());
            }
        }
        textView.setText(spannableString);
        f.b m = ni.f.a.m(k());
        UGCVideo a8 = resultCollectItemWrapper.a();
        String str2 = BuildConfig.FLAVOR;
        if (a8 == null || (cover2 = a8.getCover()) == null || (str = cover2.getThumbnail()) == null) {
            str = BuildConfig.FLAVOR;
        }
        f.b l = m.l(str);
        UGCVideo a9 = resultCollectItemWrapper.a();
        if (a9 != null && (cover = a9.getCover()) != null && (url = cover.getUrl()) != null) {
            str2 = url;
        }
        l.g(str2).d((ImageView) baseViewHolder.getView(R$id.iv_cover));
    }
}
