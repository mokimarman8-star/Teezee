package com.cloud.tmc.miniapp.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.cloud.tmc.integration.utils.FilePathUtils;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy;
import com.cloud.tmc.kernel.resource.IResourceProcessor;
import com.cloud.tmc.miniapp.R;
import com.cloud.tmc.miniapp.base.BaseActivity;
import com.cloud.tmc.miniapp.ui.adapter.ImagePreviewAdapter;
import com.cloud.tmc.miniapp.widget.photoview.OooOOO;
import com.cloud.tmc.miniapp.widget.photoview.PhotoView;
import java.io.File;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class ImagePreviewAdapter extends NormalBaseAdapter<String> {
    private final Lazy baseResourceManager$delegate;
    private final Lazy imageLoder$delegate;
    private final List<String> mSelectImages;
    private int selectMode;

    public final class ViewHolder extends NormalBaseAdapter<String>.NormalViewHolder {
        private final Lazy checkBox$delegate;
        private final Lazy photoView$delegate;

        public ViewHolder() {
            super(R.layout.item_image_preview);
            this.photoView$delegate = LazyKt.b(new Function0<PhotoView>() { // from class: com.cloud.tmc.miniapp.ui.adapter.ImagePreviewAdapter$ViewHolder$photoView$2
                {
                    super(0);
                }

                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final PhotoView m85invoke() {
                    return (PhotoView) ImagePreviewAdapter.ViewHolder.this.findViewById(R.id.photoview);
                }
            });
            this.checkBox$delegate = LazyKt.b(new Function0<TextView>() { // from class: com.cloud.tmc.miniapp.ui.adapter.ImagePreviewAdapter$ViewHolder$checkBox$2
                {
                    super(0);
                }

                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final TextView m84invoke() {
                    return (TextView) ImagePreviewAdapter.ViewHolder.this.findViewById(R.id.cb_image_select_check);
                }
            });
        }

        private final TextView getCheckBox() {
            return (TextView) this.checkBox$delegate.getValue();
        }

        private final PhotoView getPhotoView() {
            return (PhotoView) this.photoView$delegate.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Type inference failed for: r0v2 */
        /* JADX WARN: Type inference failed for: r0v3, types: [android.app.Activity, com.cloud.tmc.miniapp.base.BaseActivity] */
        /* JADX WARN: Type inference failed for: r0v5 */
        public static final void onBindView$lambda$1(ImagePreviewAdapter imagePreviewAdapter, View view, float f, float f2) {
            Intrinsics.h(imagePreviewAdapter, "this$0");
            Object context = imagePreviewAdapter.getContext();
            ?? r0 = context instanceof BaseActivity ? (BaseActivity) context : 0;
            if (r0 != 0) {
                r0.finish();
                r0.overridePendingTransition(R.anim.activity_fast_fade_in, R.anim.activity_fast_fade_out);
            }
        }

        public final int getSelectNum(String str) {
            Intrinsics.h(str, "imagePath");
            return ImagePreviewAdapter.this.mSelectImages.indexOf(str) + 1;
        }

        @Override // com.cloud.tmc.miniapp.base.BaseAdapter.BaseViewHolder
        public void onBindView(int i) {
            TextView checkBox;
            String absolutePath;
            PhotoView photoView = getPhotoView();
            if (photoView != null) {
                final ImagePreviewAdapter imagePreviewAdapter = ImagePreviewAdapter.this;
                photoView.setOnViewTapListener(new OooOOO() { // from class: com.cloud.tmc.miniapp.ui.adapter.a
                    @Override // com.cloud.tmc.miniapp.widget.photoview.OooOOO
                    public final void OooO00o(View view, float f, float f2) {
                        ImagePreviewAdapter.ViewHolder.onBindView$lambda$1(ImagePreviewAdapter.this, view, f, f2);
                    }
                });
            }
            String item = ImagePreviewAdapter.this.getItem(i);
            if (item != null) {
                ImagePreviewAdapter imagePreviewAdapter2 = ImagePreviewAdapter.this;
                try {
                    AppCompatImageView photoView2 = getPhotoView();
                    if (photoView2 != null) {
                        if (StringsKt.c0(item, ".miniapp.transsion.com", false, 2, (Object) null)) {
                            String appIdFormVurl = FilePathUtils.INSTANCE.getAppIdFormVurl(item);
                            if (appIdFormVurl == null) {
                                appIdFormVurl = "";
                            }
                            File file = imagePreviewAdapter2.getBaseResourceManager().get(item, appIdFormVurl);
                            absolutePath = file != null ? file.getAbsolutePath() : null;
                            if (absolutePath == null) {
                                absolutePath = "";
                            } else {
                                Intrinsics.g(absolutePath, "baseResourceManager.get(…ppId)?.absolutePath ?: \"\"");
                            }
                        } else {
                            absolutePath = item;
                        }
                        imagePreviewAdapter2.getImageLoder().loadImg(imagePreviewAdapter2.getContext(), absolutePath, photoView2);
                    }
                } catch (Throwable th) {
                    TmcLogger.e("onBindView", th);
                }
                int selectMode = imagePreviewAdapter2.getSelectMode();
                if (selectMode == 1) {
                    TextView checkBox2 = getCheckBox();
                    if (checkBox2 == null) {
                        return;
                    }
                    checkBox2.setVisibility(8);
                    return;
                }
                if (selectMode != 2) {
                    if (selectMode == 3 && (checkBox = getCheckBox()) != null) {
                        checkBox.setVisibility(8);
                        return;
                    }
                    return;
                }
                TextView checkBox3 = getCheckBox();
                if (checkBox3 != null) {
                    checkBox3.setVisibility(0);
                }
                int selectNum = getSelectNum(item);
                if (selectNum != 0) {
                    TextView checkBox4 = getCheckBox();
                    if (checkBox4 != null) {
                        checkBox4.setSelected(true);
                    }
                    TextView checkBox5 = getCheckBox();
                    if (checkBox5 == null) {
                        return;
                    }
                    checkBox5.setText(String.valueOf(selectNum));
                    return;
                }
                TextView checkBox6 = getCheckBox();
                if (checkBox6 != null) {
                    checkBox6.setSelected(false);
                }
                TextView checkBox7 = getCheckBox();
                if (checkBox7 == null) {
                    return;
                }
                checkBox7.setText("");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImagePreviewAdapter(Context context, List<String> list) {
        super(context);
        Intrinsics.h(context, "context");
        Intrinsics.h(list, "mSelectImages");
        this.mSelectImages = list;
        this.imageLoder$delegate = LazyKt.b(new Function0<ImageLoaderProxy>() { // from class: com.cloud.tmc.miniapp.ui.adapter.ImagePreviewAdapter$imageLoder$2
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final ImageLoaderProxy m87invoke() {
                return (ImageLoaderProxy) TmcProxy.get(ImageLoaderProxy.class);
            }
        });
        this.baseResourceManager$delegate = LazyKt.b(new Function0<IResourceProcessor>() { // from class: com.cloud.tmc.miniapp.ui.adapter.ImagePreviewAdapter$baseResourceManager$2
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final IResourceProcessor m86invoke() {
                return (IResourceProcessor) TmcProxy.get(IResourceProcessor.class);
            }
        });
        this.selectMode = 1;
    }

    public final IResourceProcessor getBaseResourceManager() {
        Object value = this.baseResourceManager$delegate.getValue();
        Intrinsics.g(value, "<get-baseResourceManager>(...)");
        return (IResourceProcessor) value;
    }

    public final ImageLoaderProxy getImageLoder() {
        Object value = this.imageLoder$delegate.getValue();
        Intrinsics.g(value, "<get-imageLoder>(...)");
        return (ImageLoaderProxy) value;
    }

    public final int getSelectMode() {
        return this.selectMode;
    }

    public NormalBaseAdapter<String>.NormalViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.h(viewGroup, "parent");
        return new ViewHolder();
    }

    public final void setSelectMode(int i) {
        this.selectMode = i;
    }
}
