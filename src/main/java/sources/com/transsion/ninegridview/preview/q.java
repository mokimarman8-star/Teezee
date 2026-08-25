package com.transsion.ninegridview.preview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;
import com.transsion.gslb.BuildConfig;
import com.transsion.ninegridview.ImageInfo;
import com.transsion.ninegridview.R$drawable;
import com.transsion.ninegridview.R$id;
import com.transsion.ninegridview.R$layout;
import com.transsion.photoview.PhotoView;
import java.util.List;
import ni.f;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class q extends PagerAdapter {
    private final List a;
    private final Context b;
    private View c;

    class a implements com.transsion.photoview.i {
        a() {
        }

        @Override // com.transsion.photoview.i
        public void a() {
            ((ImagePreviewActivity) q.this.b).finish();
        }
    }

    public q(Context context, List list) {
        this.a = list;
        this.b = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(View view) {
        ((ImagePreviewActivity) this.b).finishActivityAnim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(View view) {
        ((ImagePreviewActivity) this.b).finishActivityAnim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void j(ImageInfo imageInfo, PhotoView photoView) {
        try {
            f.b m = ni.f.a.m(this.b);
            String str = imageInfo.bigImageUrl;
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            m.g(str).i(R$drawable.ic_default_color).m((int) imageInfo.imageViewWidth).c((int) imageInfo.imageViewHeight).j(0).f(true).l(imageInfo.thumbnailUrl).e(true).h(false).d(photoView);
        } catch (Exception unused) {
        }
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public PhotoView e() {
        return (PhotoView) this.c.findViewById(R$id.pv);
    }

    public ImageView f() {
        return (ImageView) this.c.findViewById(R$id.thumb);
    }

    public View g() {
        return this.c;
    }

    public int getCount() {
        List list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [android.view.View, com.transsion.photoview.PhotoView] */
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(this.b).inflate(R$layout.item_photoview, viewGroup, false);
        inflate.findViewById(R$id.root).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ninegridview.preview.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                q.this.h(view);
            }
        });
        final ImageInfo imageInfo = (ImageInfo) this.a.get(i);
        if (imageInfo == null) {
            return inflate;
        }
        try {
            float f = imageInfo.imageViewWidth;
            zg.h hVar = zg.h.a;
            if (f > hVar.e(this.b) || imageInfo.imageViewHeight > hVar.c(this.b)) {
                float f2 = imageInfo.imageViewWidth / imageInfo.imageViewHeight;
                imageInfo.imageViewWidth = hVar.e(this.b);
                imageInfo.imageViewHeight = hVar.e(this.b) / f2;
            }
        } catch (Exception unused) {
        }
        final ?? r1 = (PhotoView) inflate.findViewById(R$id.pv);
        r1.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ninegridview.preview.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                q.this.i(view);
            }
        });
        r1.setSlideUpAndDownListener(new a());
        r1.post(new Runnable() { // from class: com.transsion.ninegridview.preview.p
            @Override // java.lang.Runnable
            public final void run() {
                q.this.j(imageInfo, r1);
            }
        });
        viewGroup.addView(inflate);
        return inflate;
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        this.c = (View) obj;
    }
}
