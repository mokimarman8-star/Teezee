package com.mbridge.msdk.nativex.listener;

import android.content.Context;
import androidx.viewpager.widget.ViewPager;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.h;
import com.mbridge.msdk.foundation.same.report.j;
import com.mbridge.msdk.foundation.same.report.metrics.d;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.out.Frame;
import com.mbridge.msdk.out.NativeListener;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class RollingPagerListenrt implements ViewPager.h {
    private NativeListener.FilpListener FilpListening;
    private List<Frame> frames;
    private List<Integer> list = new ArrayList();
    private h reportController;
    private String unit_id;

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    public void onPageSelected(int i) {
        reportRollBC(i);
    }

    public void reportRollBC(int i) {
        try {
            NativeListener.FilpListener filpListener = this.FilpListening;
            if (filpListener != null) {
                filpListener.filpEvent(i);
            }
            if (this.list.contains(Integer.valueOf(i))) {
                return;
            }
            this.list.add(Integer.valueOf(i));
            Frame frame = this.frames.get(i);
            List campaigns = frame.getCampaigns();
            if (campaigns == null || campaigns.isEmpty()) {
                return;
            }
            CampaignEx campaignEx = (CampaignEx) campaigns.get(0);
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < campaigns.size(); i2++) {
                campaignEx = (CampaignEx) campaigns.get(i2);
                if (i2 == campaigns.size() - 1) {
                    sb2.append(campaignEx.getId());
                } else {
                    sb2.append(campaignEx.getId() + ",");
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put("rid", campaignEx.getRequestId());
            hashMap.put("rid_n", campaignEx.getRequestIdNotice());
            hashMap.put("frame_id", (i + 1) + TtmlNode.ANONYMOUS_REGION_ID);
            hashMap.put("template", Integer.valueOf(frame.getTemplate()));
            hashMap.put("cids", sb2.toString());
            hashMap.put(MBridgeConstans.PROPERTIES_UNIT_ID, this.unit_id);
            d.b().a(j.a("2000005", hashMap));
        } catch (Throwable th) {
            o0.b("RollingPagerListener", th.getMessage());
        }
    }

    public void setCampList(List<Frame> list, Context context, String str) {
        this.frames = list;
        this.reportController = new h(context, 2);
        this.unit_id = str;
        this.list.clear();
        reportRollBC(0);
    }

    public void setFilpListening(NativeListener.FilpListener filpListener) {
        this.FilpListening = filpListener;
    }
}
