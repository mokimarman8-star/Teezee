package com.transsion.ninegridview;

import android.content.Context;
import android.widget.ImageView;
import com.blankj.utilcode.util.y;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.GifBean;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.ninegridview.video.NineGridItemView;
import ni.f;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c implements vm.b {
    @Override // vm.b
    public void a(Context context, ImageView imageView, String str, int i, int i2, String str2) {
        if (context == null || imageView == null || str == null) {
            return;
        }
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.getLayoutParams().width = i;
        imageView.getLayoutParams().height = i2;
        f.b i3 = f.a.m(context).g(str).i(R$color.ic_default_bg_color);
        if (str2 == null) {
            str2 = BuildConfig.FLAVOR;
        }
        i3.l(str2).m(i).c(i2).d(imageView);
    }

    @Override // vm.b
    public void b(Context context, NineGridItemView nineGridItemView, Image image, int i, int i2) {
        String thumbnail;
        GifBean gifBean;
        String str = null;
        ShapeableImageView imageView = nineGridItemView != null ? nineGridItemView.getImageView() : null;
        if (((image == null || (gifBean = image.getGifBean()) == null) ? null : gifBean.getVideoUrl()) != null) {
            GifBean gifBean2 = image.getGifBean();
            if (gifBean2 != null) {
                str = gifBean2.getFirstFrameUrl();
            }
        } else if (image != null) {
            str = image.getUrl();
        }
        if (i <= 0) {
            i = y.e();
        }
        if (context == null || imageView == null) {
            return;
        }
        imageView.getLayoutParams().width = i;
        imageView.getLayoutParams().height = i2;
        f.b m = f.a.m(context);
        String str2 = BuildConfig.FLAVOR;
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        f.b i3 = m.g(str).i(R$color.ic_default_bg_color);
        if (image != null && (thumbnail = image.getThumbnail()) != null) {
            str2 = thumbnail;
        }
        i3.l(str2).m(i).c(i2).d(imageView);
    }
}
