package com.cloud.tmc.miniapp.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.cloud.tmc.integration.callback.ISaveImgCallback;
import com.cloud.tmc.integration.callback.OnPhotoSelectListener;
import com.cloud.tmc.integration.utils.AppPrepareUtils;
import com.cloud.tmc.integration.utils.FastClickUtil;
import com.cloud.tmc.integration.utils.FilePathUtils;
import com.cloud.tmc.integration.utils.ImageSaveUtils;
import com.cloud.tmc.integration.utils.MiniBarUtils;
import com.cloud.tmc.integration.utils.ext.ViewExtKt;
import com.cloud.tmc.integration.utils.share.ShareUtils;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.R;
import com.cloud.tmc.miniapp.base.BaseActivity;
import com.cloud.tmc.miniapp.base.BaseAdapter;
import com.cloud.tmc.miniapp.task.OooO0O0;
import com.cloud.tmc.miniapp.ui.adapter.ImagePreviewAdapter;
import com.cloud.tmc.miniapp.utils.toast.ToastUtils;
import com.cloud.tmc.miniapp.widget.OooO;
import com.cloud.tmc.miniutils.constant.PermissionConstants;
import com.cloud.tmc.miniutils.util.BarUtils;
import com.cloud.tmc.miniutils.util.ImageUtils;
import com.cloud.tmc.miniutils.util.PermissionUtils;
import com.cloud.tmc.miniutils.util.ScreenUtils;
import com.cloud.tmc.miniutils.util.ViewUtils;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;

@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class ImagePreviewActivity extends BaseActivity implements BaseAdapter.OnItemClickListener, BaseAdapter.OnChildClickListener {
    public static final Companion Companion = new Companion(null);
    private static final String IMAGE_LIST = "imageList";
    private static final String IMAGE_MAX_SELECT = "imageMaxSelect";
    private static final String IMAGE_PREVIEW_CURRENT = "current";
    private static final String IMAGE_PREVIEW_SHOW_MENU = "showMenu";
    private static final String IMAGE_SELECT_BACK_PRESSED = "imageBackPressed";
    private static final String IMAGE_SELECT_INDEX = "imageIndex";
    private static final String IMAGE_SELECT_LIST = "imageSelectList";
    private static final String IMAGE_SELECT_POSITION_LIST = "imageSelectPositionList";
    private static final String TAG = "ImagePreviewActivity";
    private int index;
    private final Lazy flTitleBack$delegate = LazyKt.b(new Function0<FrameLayout>() { // from class: com.cloud.tmc.miniapp.ui.ImagePreviewActivity$flTitleBack$2
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final FrameLayout m44invoke() {
            return (FrameLayout) ImagePreviewActivity.this.findViewById(R.id.fl_title_back);
        }
    });
    private final Lazy tvTitle$delegate = LazyKt.b(new Function0<TextView>() { // from class: com.cloud.tmc.miniapp.ui.ImagePreviewActivity$tvTitle$2
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final TextView m49invoke() {
            return (TextView) ImagePreviewActivity.this.findViewById(R.id.tv_title);
        }
    });
    private final Lazy tvPreviewTitle$delegate = LazyKt.b(new Function0<TextView>() { // from class: com.cloud.tmc.miniapp.ui.ImagePreviewActivity$tvPreviewTitle$2
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final TextView m48invoke() {
            return (TextView) ImagePreviewActivity.this.findViewById(R.id.tv_preview_title);
        }
    });
    private final Lazy tvImageSelect$delegate = LazyKt.b(new Function0<TextView>() { // from class: com.cloud.tmc.miniapp.ui.ImagePreviewActivity$tvImageSelect$2
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final TextView m47invoke() {
            return (TextView) ImagePreviewActivity.this.findViewById(R.id.tv_image_select);
        }
    });
    private final Lazy vpPreviewImage$delegate = LazyKt.b(new Function0<ViewPager2>() { // from class: com.cloud.tmc.miniapp.ui.ImagePreviewActivity$vpPreviewImage$2
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ViewPager2 m50invoke() {
            return ImagePreviewActivity.this.findViewById(R.id.vp_preview_image);
        }
    });
    private final Lazy linearOperatePanel$delegate = LazyKt.b(new Function0<LinearLayout>() { // from class: com.cloud.tmc.miniapp.ui.ImagePreviewActivity$linearOperatePanel$2
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final LinearLayout m45invoke() {
            return (LinearLayout) ImagePreviewActivity.this.findViewById(R.id.linear_operate_panel);
        }
    });
    private final Lazy flOperateShare$delegate = LazyKt.b(new Function0<FrameLayout>() { // from class: com.cloud.tmc.miniapp.ui.ImagePreviewActivity$flOperateShare$2
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final FrameLayout m43invoke() {
            return (FrameLayout) ImagePreviewActivity.this.findViewById(R.id.fl_operate_share);
        }
    });
    private final Lazy flOperateDownload$delegate = LazyKt.b(new Function0<FrameLayout>() { // from class: com.cloud.tmc.miniapp.ui.ImagePreviewActivity$flOperateDownload$2
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final FrameLayout m42invoke() {
            return (FrameLayout) ImagePreviewActivity.this.findViewById(R.id.fl_operate_download);
        }
    });
    private final Lazy adapter$delegate = LazyKt.b(new Function0<ImagePreviewAdapter>() { // from class: com.cloud.tmc.miniapp.ui.ImagePreviewActivity$adapter$2
        {
            super(0);
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [android.content.Context, com.cloud.tmc.miniapp.ui.ImagePreviewActivity] */
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ImagePreviewAdapter m41invoke() {
            ArrayList arrayList;
            ?? r1 = ImagePreviewActivity.this;
            arrayList = ((ImagePreviewActivity) r1).selectImage;
            return new ImagePreviewAdapter(r1, arrayList);
        }
    });
    private int selectMode = 1;
    private final Lazy mTaskQueue$delegate = LazyKt.b(new Function0<OooO0O0>() { // from class: com.cloud.tmc.miniapp.ui.ImagePreviewActivity$mTaskQueue$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final OooO0O0 m46invoke() {
            return new OooO0O0();
        }
    });
    private int maxSelect = 1;
    private final ArrayList<String> selectImage = new ArrayList<>();
    private final ArrayList<Integer> selectPosition = new ArrayList<>();
    private final ViewPager2.OnPageChangeCallback mPageChangeCallback = new ViewPager2.OnPageChangeCallback() { // from class: com.cloud.tmc.miniapp.ui.ImagePreviewActivity$mPageChangeCallback$1
        public void onPageSelected(int i) {
            TextView tvTitle;
            TextView tvPreviewTitle;
            ImagePreviewAdapter adapter;
            ImagePreviewAdapter adapter2;
            super.onPageSelected(i);
            ImagePreviewActivity.this.setIndex(i);
            tvTitle = ImagePreviewActivity.this.getTvTitle();
            if (tvTitle != null) {
                adapter2 = ImagePreviewActivity.this.getAdapter();
                tvTitle.setText((i + 1) + "/" + adapter2.getCount());
            }
            tvPreviewTitle = ImagePreviewActivity.this.getTvPreviewTitle();
            if (tvPreviewTitle == null) {
                return;
            }
            adapter = ImagePreviewActivity.this.getAdapter();
            tvPreviewTitle.setText((i + 1) + "/" + adapter.getCount());
        }
    };

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void launch(BaseActivity baseActivity, int i, String str, ArrayList<String> arrayList, ArrayList<Integer> arrayList2, OnPhotoSelectListener onPhotoSelectListener) {
            Intrinsics.h(baseActivity, "context");
            Intrinsics.h(str, "url");
            Intrinsics.h(arrayList, "selectList");
            Intrinsics.h(arrayList2, "positionList");
            ArrayList arrayList3 = new ArrayList(1);
            arrayList3.add(str);
            launch(baseActivity, i, arrayList3, arrayList, arrayList2, onPhotoSelectListener);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void launch(BaseActivity baseActivity, int i, ArrayList<String> arrayList, boolean z, int i2) {
            Intrinsics.h(baseActivity, "activity");
            Intrinsics.h(arrayList, "urls");
            Intent intent = new Intent((Context) baseActivity, (Class<?>) ImagePreviewActivity.class);
            intent.putExtra(ImagePreviewActivity.IMAGE_LIST, arrayList);
            intent.putExtra(ImagePreviewActivity.IMAGE_MAX_SELECT, i);
            intent.putExtra(ImagePreviewActivity.IMAGE_PREVIEW_SHOW_MENU, z);
            intent.putExtra(ImagePreviewActivity.IMAGE_PREVIEW_CURRENT, i2);
            intent.putExtra(ImagePreviewActivity.IMAGE_SELECT_INDEX, i2);
            AppPrepareUtils.INSTANCE.addCommonIntentParameter(intent, baseActivity);
            baseActivity.startActivity(intent);
            baseActivity.overridePendingTransition(R.anim.activity_fast_fade_in, R.anim.activity_fast_fade_out);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void launch(BaseActivity baseActivity, int i, List<String> list, int i2, ArrayList<String> arrayList, ArrayList<Integer> arrayList2, final OnPhotoSelectListener onPhotoSelectListener) {
            Intrinsics.h(baseActivity, "context");
            Intrinsics.h(list, "urls");
            Intrinsics.h(arrayList, "selectList");
            Intrinsics.h(arrayList2, "positionList");
            if (list.isEmpty()) {
                return;
            }
            Intent intent = new Intent((Context) baseActivity, (Class<?>) ImagePreviewActivity.class);
            if (list.size() > 2000) {
                list = CollectionsKt.e(list.get(i2));
            }
            if (list instanceof ArrayList) {
                intent.putExtra(ImagePreviewActivity.IMAGE_LIST, (Serializable) list);
            } else {
                intent.putExtra(ImagePreviewActivity.IMAGE_LIST, new ArrayList(list));
            }
            intent.putExtra(ImagePreviewActivity.IMAGE_SELECT_LIST, arrayList);
            intent.putExtra(ImagePreviewActivity.IMAGE_SELECT_INDEX, i2);
            intent.putExtra(ImagePreviewActivity.IMAGE_SELECT_POSITION_LIST, arrayList2);
            intent.putExtra(ImagePreviewActivity.IMAGE_MAX_SELECT, i);
            AppPrepareUtils.INSTANCE.addCommonIntentParameter(intent, baseActivity);
            baseActivity.startActivityForResult(intent, new BaseActivity.OnActivityCallback() { // from class: com.cloud.tmc.miniapp.ui.ImagePreviewActivity$Companion$launch$1
                @Override // com.cloud.tmc.miniapp.base.BaseActivity.OnActivityCallback
                public void onActivityResult(int i3, Intent intent2) {
                    OnPhotoSelectListener onPhotoSelectListener2 = onPhotoSelectListener;
                    if (onPhotoSelectListener2 == null) {
                        return;
                    }
                    if (intent2 == null) {
                        onPhotoSelectListener2.onCancel();
                        return;
                    }
                    ArrayList<String> stringArrayListExtra = intent2.getStringArrayListExtra("imageSelectList");
                    boolean booleanExtra = intent2.getBooleanExtra("imageBackPressed", false);
                    ArrayList<Integer> integerArrayListExtra = intent2.getIntegerArrayListExtra("imageSelectPositionList");
                    if (stringArrayListExtra == null || stringArrayListExtra.isEmpty()) {
                        onPhotoSelectListener.onCancel();
                        return;
                    }
                    Iterator<String> it = stringArrayListExtra.iterator();
                    Intrinsics.g(it, "list.iterator()");
                    while (it.hasNext()) {
                        if (!new File(it.next()).isFile()) {
                            it.remove();
                        }
                    }
                    if (i3 != -1 || stringArrayListExtra.isEmpty()) {
                        onPhotoSelectListener.onCancel();
                    } else {
                        onPhotoSelectListener.onSelected(stringArrayListExtra, integerArrayListExtra, !booleanExtra);
                    }
                }
            });
        }

        public final void launch(BaseActivity baseActivity, int i, List<String> list, ArrayList<String> arrayList, ArrayList<Integer> arrayList2, OnPhotoSelectListener onPhotoSelectListener) {
            Intrinsics.h(baseActivity, "context");
            Intrinsics.h(list, "urls");
            Intrinsics.h(arrayList, "selectList");
            Intrinsics.h(arrayList2, "positionList");
            launch(baseActivity, i, list, 0, arrayList, arrayList2, onPhotoSelectListener);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void changeSelectTv() {
        String format;
        if (this.selectImage.isEmpty()) {
            TextView tvImageSelect = getTvImageSelect();
            if (tvImageSelect != null) {
                tvImageSelect.setText(getString(R.string.mini_image_select_done));
            }
            TextView tvImageSelect2 = getTvImageSelect();
            if (tvImageSelect2 != null) {
                tvImageSelect2.setTextColor(androidx.core.content.b.getColor(this, R.color.mini_color_505358));
                return;
            }
            return;
        }
        TextView tvImageSelect3 = getTvImageSelect();
        if (tvImageSelect3 != null) {
            if (this.maxSelect == 1) {
                format = getString(R.string.mini_image_select_done);
            } else {
                StringCompanionObject stringCompanionObject = StringCompanionObject.a;
                String string = getString(R.string.mini_image_select_mutiple_done);
                Intrinsics.g(string, "getString(R.string.mini_image_select_mutiple_done)");
                format = String.format(string, Arrays.copyOf(new Object[]{String.valueOf(this.selectImage.size()), String.valueOf(this.maxSelect)}, 2));
                Intrinsics.g(format, "format(format, *args)");
            }
            tvImageSelect3.setText(format);
        }
        TextView tvImageSelect4 = getTvImageSelect();
        if (tvImageSelect4 != null) {
            tvImageSelect4.setTextColor(androidx.core.content.b.getColor(this, R.color.mini_color_white));
        }
    }

    private final void doDownloadFile() {
        String currentImageUrl = getCurrentImageUrl();
        if (currentImageUrl != null) {
            loadFile(currentImageUrl, new Function1<File, Unit>() { // from class: com.cloud.tmc.miniapp.ui.ImagePreviewActivity$doDownloadFile$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((File) obj);
                    return Unit.a;
                }

                public final void invoke(File file) {
                    if (file == null) {
                        TmcLogger.d("ImagePreviewActivity", "doDownloadFile file is null");
                        ToastUtils.showToast$default(R.string.mini_image_select_save_failed, 0, 0L, false, 14, null);
                    } else {
                        Bitmap bitmap = ImageUtils.getBitmap(file);
                        String w = FilesKt.w(file);
                        ImageSaveUtils.saveImage(bitmap, new ISaveImgCallback() { // from class: com.cloud.tmc.miniapp.ui.ImagePreviewActivity$doDownloadFile$1.1
                            public void onFail(int i, String str) {
                                ToastUtils.showToast$default(R.string.mini_image_select_save_failed, 0, 0L, false, 14, null);
                                TmcLogger.d("ImagePreviewActivity", i + " -> " + str);
                            }

                            public void onSuccess(File file2) {
                                ToastUtils.showToast$default(R.string.mini_image_select_save_success, 0, 0L, false, 14, null);
                            }
                        }, Intrinsics.c(w, "png") ? Bitmap.CompressFormat.PNG : Intrinsics.c(w, "webp") ? Build.VERSION.SDK_INT >= 30 ? com.cloud.tmc.integration.utils.compress.a.a() : Bitmap.CompressFormat.WEBP : Bitmap.CompressFormat.JPEG);
                    }
                }
            });
        } else {
            TmcLogger.d(TAG, "doDownloadFile imagePath is null");
            ToastUtils.showToast$default(R.string.mini_image_select_save_failed, 0, 0L, false, 14, null);
        }
    }

    private final void doShareFile() {
        String currentImageUrl = getCurrentImageUrl();
        if (currentImageUrl != null) {
            loadFile(currentImageUrl, new Function1<File, Unit>() { // from class: com.cloud.tmc.miniapp.ui.ImagePreviewActivity$doShareFile$1
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((File) obj);
                    return Unit.a;
                }

                public final void invoke(final File file) {
                    if (file == null) {
                        TmcLogger.d("ImagePreviewActivity", "doShareFile file is null");
                        ToastUtils.showToast$default(R.string.mini_image_select_shared_failed, 0, 0L, false, 14, null);
                    } else {
                        PermissionUtils permissionGroup = PermissionUtils.permissionGroup(PermissionConstants.STORAGE_WRITE);
                        final ImagePreviewActivity imagePreviewActivity = ImagePreviewActivity.this;
                        permissionGroup.callback(new PermissionUtils.SimpleCallback() { // from class: com.cloud.tmc.miniapp.ui.ImagePreviewActivity$doShareFile$1.1
                            @Override // com.cloud.tmc.miniutils.util.PermissionUtils.SimpleCallback
                            public void onDenied() {
                                TmcLogger.d("ImagePreviewActivity", "doShareFile onDenied");
                                ToastUtils.showToast$default(R.string.mini_image_select_shared_failed, 0, 0L, false, 14, null);
                            }

                            @Override // com.cloud.tmc.miniutils.util.PermissionUtils.SimpleCallback
                            public void onGranted() {
                                ImagePreviewActivity.this.systemShare(file);
                            }
                        }).request();
                    }
                }
            });
        } else {
            TmcLogger.d(TAG, "doShareFile imagePath is null");
            ToastUtils.showToast$default(R.string.mini_image_select_shared_failed, 0, 0L, false, 14, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImagePreviewAdapter getAdapter() {
        return (ImagePreviewAdapter) this.adapter$delegate.getValue();
    }

    private final String getCurrentImageUrl() {
        String str;
        try {
            List<String> data = getAdapter().getData();
            if (this.index >= data.size() || (str = data.get(this.index)) == null) {
                return null;
            }
            if (!StringsKt.c0(str, ".miniapp.transsion.com", false, 2, (Object) null)) {
                return str;
            }
            String appIdFormVurl = FilePathUtils.INSTANCE.getAppIdFormVurl(str);
            if (appIdFormVurl == null) {
                appIdFormVurl = "";
            }
            File file = getAdapter().getBaseResourceManager().get(str, appIdFormVurl);
            if (file != null) {
                return file.getAbsolutePath();
            }
            return null;
        } catch (Throwable th) {
            TmcLogger.e(TAG, th);
        }
        return null;
    }

    private final FrameLayout getFlOperateDownload() {
        return (FrameLayout) this.flOperateDownload$delegate.getValue();
    }

    private final FrameLayout getFlOperateShare() {
        return (FrameLayout) this.flOperateShare$delegate.getValue();
    }

    private final FrameLayout getFlTitleBack() {
        return (FrameLayout) this.flTitleBack$delegate.getValue();
    }

    private final LinearLayout getLinearOperatePanel() {
        return (LinearLayout) this.linearOperatePanel$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OooO0O0 getMTaskQueue() {
        return (OooO0O0) this.mTaskQueue$delegate.getValue();
    }

    private final TextView getTvImageSelect() {
        return (TextView) this.tvImageSelect$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView getTvPreviewTitle() {
        return (TextView) this.tvPreviewTitle$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView getTvTitle() {
        return (TextView) this.tvTitle$delegate.getValue();
    }

    private final ViewPager2 getVpPreviewImage() {
        return (ViewPager2) this.vpPreviewImage$delegate.getValue();
    }

    private final void loadFile(String str, Function1<? super File, Unit> function1) {
        kotlinx.coroutines.i.d(kotlinx.coroutines.o0.a(kotlinx.coroutines.y0.b()), (CoroutineContext) null, (CoroutineStart) null, new ImagePreviewActivity$loadFile$1(this, str, function1, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void systemShare(File file) {
        ShareUtils.shareFile$default(this, file, (String) null, (String) null, (String) null, false, new ImagePreviewActivity$systemShare$1(this), 60, (Object) null);
    }

    public final int getIndex() {
        return this.index;
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public int getLayoutId() {
        return R.layout.activity_image_preview;
    }

    public final int getMaxSelect() {
        return this.maxSelect;
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void hideStatusLoading() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void initData() {
        int i;
        ViewPager2 vpPreviewImage;
        ArrayList<String> stringArrayList = getStringArrayList(IMAGE_LIST);
        ArrayList<String> stringArrayList2 = getStringArrayList(IMAGE_SELECT_LIST);
        ArrayList<Integer> integerArrayList = getIntegerArrayList(IMAGE_SELECT_POSITION_LIST);
        boolean z = getBoolean(IMAGE_PREVIEW_SHOW_MENU, false);
        if (stringArrayList2 != null) {
            this.selectImage.addAll(stringArrayList2);
        }
        if (integerArrayList != null) {
            this.selectPosition.addAll(integerArrayList);
        }
        this.maxSelect = getInt(IMAGE_MAX_SELECT);
        ScreenUtils.setFullScreen(this);
        int i2 = this.maxSelect;
        if (i2 == 0) {
            BarUtils.setNavBarVisibility((Activity) this, false);
            BarUtils.setStatusBarVisibility((Activity) this, false);
            TextView tvImageSelect = getTvImageSelect();
            if (tvImageSelect != null) {
                tvImageSelect.setVisibility(4);
            }
            FrameLayout flTitleBack = getFlTitleBack();
            if (flTitleBack != null) {
                flTitleBack.setVisibility(4);
            }
            TextView tvPreviewTitle = getTvPreviewTitle();
            if (tvPreviewTitle != null) {
                tvPreviewTitle.setVisibility(0);
            }
            i = 3;
        } else if (i2 != 1) {
            MiniBarUtils.setStatusBarNightMode(this);
            i = 2;
        } else {
            MiniBarUtils.setStatusBarNightMode(this);
            i = 1;
        }
        this.selectMode = i;
        getAdapter().setSelectMode(this.selectMode);
        if (stringArrayList == null || stringArrayList.isEmpty()) {
            finish();
            return;
        }
        getAdapter().setData(stringArrayList);
        getAdapter().setOnItemClickListener(this);
        getAdapter().setOnChildClickListener(R.id.fl_image_select_check, this);
        ViewPager2 vpPreviewImage2 = getVpPreviewImage();
        if (vpPreviewImage2 != null) {
            vpPreviewImage2.setAdapter(getAdapter());
        }
        if (stringArrayList.size() != 1) {
            if (this.selectMode == 3) {
                TextView tvTitle = getTvTitle();
                if (tvTitle != null) {
                    tvTitle.setVisibility(4);
                }
                TextView tvPreviewTitle2 = getTvPreviewTitle();
                if (tvPreviewTitle2 != null) {
                    tvPreviewTitle2.setVisibility(0);
                }
            } else {
                TextView tvPreviewTitle3 = getTvPreviewTitle();
                if (tvPreviewTitle3 != null) {
                    tvPreviewTitle3.setVisibility(4);
                }
                TextView tvTitle2 = getTvTitle();
                if (tvTitle2 != null) {
                    tvTitle2.setVisibility(0);
                }
            }
            ViewPager2 vpPreviewImage3 = getVpPreviewImage();
            if (vpPreviewImage3 != null) {
                vpPreviewImage3.registerOnPageChangeCallback(this.mPageChangeCallback);
            }
            int i3 = getInt(IMAGE_SELECT_INDEX);
            this.index = i3;
            if (i3 < stringArrayList.size() && (vpPreviewImage = getVpPreviewImage()) != null) {
                vpPreviewImage.setCurrentItem(this.index, false);
            }
        }
        if (this.selectMode == 1) {
            TextView tvImageSelect2 = getTvImageSelect();
            if (tvImageSelect2 != null) {
                tvImageSelect2.setTextColor(androidx.core.content.b.getColor(this, R.color.mini_color_white));
            }
        } else {
            changeSelectTv();
        }
        LinearLayout linearOperatePanel = getLinearOperatePanel();
        if (linearOperatePanel != null) {
            ViewExtKt.toVisibleOrGone(linearOperatePanel, z);
        }
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void initView() {
        ViewPager2 vpPreviewImage = getVpPreviewImage();
        if (vpPreviewImage != null) {
            vpPreviewImage.setOffscreenPageLimit(3);
        }
        FrameLayout flTitleBack = getFlTitleBack();
        if (flTitleBack != null) {
            flTitleBack.setRotationY(ViewUtils.isLayoutRtl() ? 180.0f : 0.0f);
        }
        setOnClickListener(getFlTitleBack(), getTvImageSelect(), getFlOperateShare(), getFlOperateDownload());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onBackPressed() {
        if (this.selectMode == 2) {
            Intent intent = new Intent();
            intent.putStringArrayListExtra(IMAGE_SELECT_LIST, this.selectImage);
            intent.putIntegerArrayListExtra(IMAGE_SELECT_POSITION_LIST, this.selectPosition);
            intent.putExtra(IMAGE_SELECT_BACK_PRESSED, true);
            setResult(-1, intent);
        }
        finish();
    }

    @Override // com.cloud.tmc.miniapp.base.BaseAdapter.OnChildClickListener
    public void onChildClick(RecyclerView recyclerView, View view, int i) {
        String item;
        int i2 = 0;
        if (this.selectMode == 1 || view == null || view.getId() != R.id.fl_image_select_check || (item = getAdapter().getItem(i)) == null) {
            return;
        }
        if (!new File(item).isFile()) {
            getAdapter().removeItem(i);
            String string = getResources().getString(R.string.image_select_error);
            Intrinsics.g(string, "resources.getString(R.string.image_select_error)");
            OooO.OooO0O0(string);
            return;
        }
        int indexOf = this.selectImage.indexOf(item);
        if (indexOf < 0) {
            if (this.selectImage.size() < this.maxSelect) {
                if (this.selectImage.size() < this.maxSelect) {
                    this.selectImage.add(item);
                    this.selectPosition.add(Integer.valueOf(i));
                    changeSelectTv();
                }
                getAdapter().notifyItemChanged(i);
                return;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.a;
            String string2 = getResources().getString(R.string.image_select_max_hint);
            Intrinsics.g(string2, "resources.getString(R.st…ng.image_select_max_hint)");
            String format = String.format(string2, Arrays.copyOf(new Object[]{String.valueOf(this.maxSelect)}, 1));
            Intrinsics.g(format, "format(format, *args)");
            OooO.OooO00o(format);
            return;
        }
        this.selectPosition.remove(Integer.valueOf(i));
        this.selectImage.remove(item);
        changeSelectTv();
        getAdapter().notifyItemChanged(i);
        for (Object obj : this.selectPosition) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.u();
            }
            Integer num = (Integer) obj;
            if (i2 >= indexOf && num != null) {
                getAdapter().notifyItemChanged(num.intValue());
            }
            i2 = i3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.cloud.tmc.miniapp.base.BaseActivity, com.cloud.tmc.miniapp.action.ClickAction, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.h(view, "view");
        if (FastClickUtil.isFastDoubleClick()) {
            return;
        }
        if (Intrinsics.c(view, getFlTitleBack())) {
            onBackPressed();
            return;
        }
        if (!Intrinsics.c(view, getTvImageSelect())) {
            if (Intrinsics.c(view, getFlOperateShare())) {
                doShareFile();
                return;
            } else {
                if (Intrinsics.c(view, getFlOperateDownload())) {
                    doDownloadFile();
                    return;
                }
                return;
            }
        }
        if (this.selectMode != 1) {
            if (this.selectImage.size() > 0) {
                Intent intent = new Intent();
                intent.putStringArrayListExtra(IMAGE_SELECT_LIST, this.selectImage);
                setResult(-1, intent);
                finish();
                return;
            }
            return;
        }
        if (this.index < getAdapter().getData().size()) {
            this.selectImage.add(getAdapter().getData().get(this.index));
            Intent intent2 = new Intent();
            intent2.putStringArrayListExtra(IMAGE_SELECT_LIST, this.selectImage);
            setResult(-1, intent2);
            finish();
        }
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void onDestroy() {
        super.onDestroy();
        getMTaskQueue().OooO00o.clear();
        ViewPager2 vpPreviewImage = getVpPreviewImage();
        if (vpPreviewImage != null) {
            vpPreviewImage.unregisterOnPageChangeCallback(this.mPageChangeCallback);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.cloud.tmc.miniapp.base.BaseAdapter.OnItemClickListener
    public void onItemClick(RecyclerView recyclerView, View view, int i) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        finish();
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void onResume() {
        super.onResume();
        getMTaskQueue().OooO00o();
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    public final void setMaxSelect(int i) {
        this.maxSelect = i;
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void showStatusLoading() {
    }
}
