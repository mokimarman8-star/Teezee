package com.transsion.postdetail.util;

import android.app.Application;
import android.os.Environment;
import com.blankj.utilcode.util.Utils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.tn.lib.widget.R;
import com.transsion.flow.bean.MediaType;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.ninegridview.R$string;
import com.transsion.ninegridview.helper.FileHelper;
import com.transsion.ninegridview.preview.GifImagePreviewActivity;
import java.io.File;
import java.util.List;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PostSaveHelper {
    public static final PostSaveHelper a = new PostSaveHelper();

    public static final class a implements RequestListener {
        final /* synthetic */ Ref.IntRef a;
        final /* synthetic */ Image b;
        final /* synthetic */ Ref.ObjectRef c;

        a(Ref.IntRef intRef, Image image, Ref.ObjectRef objectRef) {
            this.a = intRef;
            this.b = image;
            this.c = objectRef;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onResourceReady(File file, Object obj, Target target, DataSource dataSource, boolean z) {
            Intrinsics.h(file, "resource");
            Intrinsics.h(obj, "model");
            Intrinsics.h(target, "target");
            Intrinsics.h(dataSource, "dataSource");
            this.a.element++;
            PostSaveHelper.a.f(file, this.b.getUrl(), this.a.element == ((List) this.c.element).size());
            return false;
        }

        public boolean onLoadFailed(GlideException glideException, Object obj, Target target, boolean z) {
            Intrinsics.h(target, "target");
            fh.b.a.d(R$string.download_failed);
            return false;
        }
    }

    private PostSaveHelper() {
    }

    private final String d(String str) {
        if (str == null) {
            return null;
        }
        String[] strArr = (String[]) StringsKt.S0(str, new String[]{"[?]"}, false, 0, 6, (Object) null).toArray(new String[0]);
        if (!(strArr.length == 0)) {
            String[] strArr2 = (String[]) StringsKt.S0(strArr[0], new String[]{"/"}, false, 0, 6, (Object) null).toArray(new String[0]);
            if (!(strArr2.length == 0)) {
                return System.currentTimeMillis() + "_" + strArr2[strArr2.length - 1];
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(File file, String str, boolean z) {
        String d = d(str);
        if (new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), GifImagePreviewActivity.PICTURE_SAVE + File.separator + d).exists()) {
            fh.b.a.d(R$string.has_been_saved);
            return;
        }
        if (file == null || d == null) {
            return;
        }
        FileHelper fileHelper = FileHelper.a;
        Application a2 = Utils.a();
        Intrinsics.g(a2, "getApp(...)");
        fileHelper.f(file, a2, d, GifImagePreviewActivity.PICTURE_SAVE, z);
    }

    public final void b(PostSubjectItem postSubjectItem) {
        Media media;
        if (!yg.l.a.e()) {
            fh.b.a.d(R.string.no_network_toast);
            return;
        }
        fh.b.a.d(com.transsion.baseui.R.string.post_start_saving);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = (postSubjectItem == null || (media = postSubjectItem.getMedia()) == null) ? null : media.getImage();
        Ref.IntRef intRef = new Ref.IntRef();
        List<Image> list = (List) objectRef.element;
        if (list != null) {
            for (Image image : list) {
                Glide.with(Utils.a()).downloadOnly().load(image.getUrl()).listener(new a(intRef, image, objectRef)).preload();
            }
        }
    }

    public final void c(PostSubjectItem postSubjectItem) {
        kotlinx.coroutines.i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new PostSaveHelper$downloadVideo$1(postSubjectItem, null), 3, (Object) null);
    }

    public final void e(PostSubjectItem postSubjectItem) {
        Media media;
        Media media2;
        Media media3;
        String str = null;
        if (Intrinsics.c((postSubjectItem == null || (media3 = postSubjectItem.getMedia()) == null) ? null : media3.getMediaType(), MediaType.VIDEO.getValue())) {
            c(postSubjectItem);
            return;
        }
        if (!Intrinsics.c((postSubjectItem == null || (media2 = postSubjectItem.getMedia()) == null) ? null : media2.getMediaType(), MediaType.IMAGE.getValue())) {
            if (postSubjectItem != null && (media = postSubjectItem.getMedia()) != null) {
                str = media.getMediaType();
            }
            if (!Intrinsics.c(str, MediaType.IMAGE_SINGLE.getValue())) {
                return;
            }
        }
        b(postSubjectItem);
    }
}
