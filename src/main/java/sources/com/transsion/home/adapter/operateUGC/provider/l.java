package com.transsion.home.adapter.operateUGC.provider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.view.FlowLayout;
import com.tn.lib.widget.TnTextView;
import com.transsion.baseui.widget.GradientTextView;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.ugcvideodetail.api.bean.UGCVideoHashTag;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class l extends BaseItemProvider {
    private final Integer e;

    public l(Integer num) {
        this.e = num;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(l lVar, UGCVideoHashTag uGCVideoHashTag, OperateItem operateItem, FlowLayout flowLayout, View view, View view2) {
        lVar.C(uGCVideoHashTag, operateItem, flowLayout.indexOfChild(view));
        String deepLink = uGCVideoHashTag.getDeepLink();
        if (deepLink != null) {
            ij.k.g(deepLink, "&tabId=" + lVar.e);
        }
    }

    private final void B(UGCVideoHashTag uGCVideoHashTag, OperateItem operateItem, int i) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "item");
        if (uGCVideoHashTag == null || (str = uGCVideoHashTag.getTitle()) == null) {
            str = BuildConfig.FLAVOR;
        }
        hashMap.put("title", str);
        hashMap.put("position", String.valueOf(i));
        sk.b.a(operateItem, hashMap);
        qi.h hVar = qi.h.a;
        SubTabFragment.Companion companion = SubTabFragment.INSTANCE;
        Integer num = this.e;
        hVar.z(companion.a(num != null ? num.intValue() : 1), hashMap);
    }

    private final void C(UGCVideoHashTag uGCVideoHashTag, OperateItem operateItem, int i) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "item");
        if (uGCVideoHashTag == null || (str = uGCVideoHashTag.getTitle()) == null) {
            str = BuildConfig.FLAVOR;
        }
        hashMap.put("title", str);
        hashMap.put("position", String.valueOf(i));
        sk.b.a(operateItem, hashMap);
        qi.h hVar = qi.h.a;
        SubTabFragment.Companion companion = SubTabFragment.INSTANCE;
        Integer num = this.e;
        hVar.o(companion.a(num != null ? num.intValue() : 1), hashMap);
    }

    public int l() {
        return PostItemType.HASH_TAG.ordinal();
    }

    public int m() {
        return R.layout.provider_ugc_op_hashtag;
    }

    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, final OperateItem operateItem) {
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(operateItem, "item");
        int i = R.id.tv_op_ugc_hashtag_title;
        String title = operateItem.getTitle();
        if (title == null) {
            title = BuildConfig.FLAVOR;
        }
        baseViewHolder.setText(i, title);
        final FlowLayout view = baseViewHolder.getView(R.id.fl_op_ugc_hashtag_layout);
        view.removeAllViews();
        LayoutInflater from = LayoutInflater.from(k());
        List<UGCVideoHashTag> hashtagList = operateItem.getHashtagList();
        if (hashtagList == null) {
            hashtagList = CollectionsKt.l();
        }
        for (final UGCVideoHashTag uGCVideoHashTag : hashtagList) {
            final View inflate = from.inflate(R.layout.item_hashtag_chip, (ViewGroup) view, false);
            TnTextView tnTextView = (GradientTextView) inflate.findViewById(R.id.hashtag_chip_text);
            CharSequence title2 = uGCVideoHashTag.getTitle();
            if (title2 == null) {
                title2 = uGCVideoHashTag.getTag();
            }
            tnTextView.setText(title2);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.operateUGC.provider.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    l.A(l.this, uGCVideoHashTag, operateItem, view, inflate, view2);
                }
            });
            view.addView(inflate);
            B(uGCVideoHashTag, operateItem, view.indexOfChild(inflate));
        }
    }
}
