package com.transsion.publish.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.KeyboardUtils;
import com.tencent.mmkv.MMKV;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.view.bubbleview.BubbleTextView;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.tn.lib.widget.R;
import com.tn.lib.widget.dialog.TRDialog;
import com.tn.lib.widget.dialog.TRDialogListener;
import com.transsion.baseui.R$color;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.publish.PublishService;
import com.transsion.publish.R$drawable;
import com.transsion.publish.R$id;
import com.transsion.publish.R$string;
import com.transsion.publish.api.AudioEntity;
import com.transsion.publish.api.GroupBean;
import com.transsion.publish.api.LinkEntity;
import com.transsion.publish.api.PhotoEntity;
import com.transsion.publish.api.VsMediaInfo;
import com.transsion.publish.api.bean.MediaAudioEntity;
import com.transsion.publish.api.bean.MediaCoverEntity;
import com.transsion.publish.api.bean.MediaImageEntity;
import com.transsion.publish.api.bean.MediaLinkEntity;
import com.transsion.publish.api.bean.MediaVideoEntity;
import com.transsion.publish.api.bean.RequestPostEntity;
import com.transsion.publish.api.bean.RequestPostMediaEntity;
import com.transsion.publish.bean.BigImageBean;
import com.transsion.publish.bean.CoverEntity;
import com.transsion.publish.ui.SelectImageActivity;
import com.transsion.publish.view.ObservableScrollView;
import com.transsion.publish.view.operation.OperationBarView;
import com.transsion.publish.view.operation.OperationVerticalBarView;
import com.transsion.push.PushConstants;
import com.transsion.room.api.bean.LocationPlace;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import f.g;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import mo.b;
import ni.f;
import wf.a;

@Metadata(d1 = {"\u0000¢\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 Ð\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005:\u0002Ñ\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\u0007J\u000f\u0010\n\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u0007J\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\u0007J\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0012\u0010\u0007J\u000f\u0010\u0013\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0013\u0010\u0007J\u000f\u0010\u0014\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0014\u0010\u0007J\u001f\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b!\u0010\"J\u001f\u0010%\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u000fH\u0002¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\bH\u0003¢\u0006\u0004\b)\u0010\u0007J\u000f\u0010*\u001a\u00020\bH\u0002¢\u0006\u0004\b*\u0010\u0007J\u0017\u0010-\u001a\u00020\b2\u0006\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\u00020\b2\u0006\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\b/\u0010.J\u0017\u00100\u001a\u00020\b2\u0006\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\b0\u0010.J\u000f\u00101\u001a\u00020\bH\u0002¢\u0006\u0004\b1\u0010\u0007J\u000f\u00102\u001a\u00020\bH\u0002¢\u0006\u0004\b2\u0010\u0007J\u0015\u00104\u001a\b\u0012\u0004\u0012\u00020#03H\u0002¢\u0006\u0004\b4\u00105J\u0015\u00107\u001a\b\u0012\u0004\u0012\u00020603H\u0002¢\u0006\u0004\b7\u00105J\u001f\u00109\u001a\u00020\b2\u000e\u00108\u001a\n\u0012\u0004\u0012\u000206\u0018\u000103H\u0002¢\u0006\u0004\b9\u0010:J\u0017\u0010;\u001a\u00020\b2\u0006\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\b;\u0010.J\u0017\u0010<\u001a\u00020\b2\u0006\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\b<\u0010.J\u0017\u0010=\u001a\u00020\b2\u0006\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\b=\u0010.J\u0017\u0010>\u001a\u00020\b2\u0006\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\b>\u0010.J\u0017\u0010?\u001a\u00020\b2\u0006\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\b?\u0010.J\u0017\u0010B\u001a\u00020\b2\u0006\u0010A\u001a\u00020@H\u0002¢\u0006\u0004\bB\u0010CJ\u0017\u0010F\u001a\u00020\b2\u0006\u0010E\u001a\u00020DH\u0002¢\u0006\u0004\bF\u0010GJ\u0019\u0010J\u001a\u00020\b2\b\u0010I\u001a\u0004\u0018\u00010HH\u0002¢\u0006\u0004\bJ\u0010KJ\u0017\u0010L\u001a\u00020\b2\u0006\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\bL\u0010.J\u000f\u0010M\u001a\u00020\bH\u0002¢\u0006\u0004\bM\u0010\u0007J\u0017\u0010O\u001a\u00020\b2\u0006\u0010N\u001a\u00020\u0017H\u0002¢\u0006\u0004\bO\u0010PJ\u000f\u0010Q\u001a\u00020\bH\u0002¢\u0006\u0004\bQ\u0010\u0007J\u000f\u0010R\u001a\u00020\bH\u0002¢\u0006\u0004\bR\u0010\u0007J\u000f\u0010S\u001a\u00020\bH\u0002¢\u0006\u0004\bS\u0010\u0007J\u000f\u0010T\u001a\u00020\bH\u0002¢\u0006\u0004\bT\u0010\u0007J\u000f\u0010U\u001a\u00020\bH\u0002¢\u0006\u0004\bU\u0010\u0007J\u0017\u0010X\u001a\u00020\b2\u0006\u0010W\u001a\u00020VH\u0002¢\u0006\u0004\bX\u0010YJ\u000f\u0010Z\u001a\u00020\bH\u0002¢\u0006\u0004\bZ\u0010\u0007J\u0017\u0010]\u001a\u00020\b2\u0006\u0010\\\u001a\u00020[H\u0002¢\u0006\u0004\b]\u0010^J\u000f\u0010_\u001a\u00020\bH\u0002¢\u0006\u0004\b_\u0010\u0007J\u000f\u0010`\u001a\u00020\bH\u0002¢\u0006\u0004\b`\u0010\u0007J\u000f\u0010a\u001a\u00020[H\u0002¢\u0006\u0004\ba\u0010bJ\u000f\u0010c\u001a\u00020\bH\u0002¢\u0006\u0004\bc\u0010\u0007J\u000f\u0010e\u001a\u00020dH\u0016¢\u0006\u0004\be\u0010fJ\u0017\u0010i\u001a\u00020\u00022\u0006\u0010h\u001a\u00020gH\u0016¢\u0006\u0004\bi\u0010jJ!\u0010o\u001a\u00020\b2\u0006\u0010l\u001a\u00020k2\b\u0010n\u001a\u0004\u0018\u00010mH\u0016¢\u0006\u0004\bo\u0010pJ!\u0010q\u001a\u00020\b2\u0006\u0010l\u001a\u00020k2\b\u0010n\u001a\u0004\u0018\u00010mH\u0016¢\u0006\u0004\bq\u0010pJ\r\u0010r\u001a\u00020\b¢\u0006\u0004\br\u0010\u0007J\r\u0010s\u001a\u00020\b¢\u0006\u0004\bs\u0010\u0007J\u000f\u0010t\u001a\u00020\bH\u0016¢\u0006\u0004\bt\u0010\u0007J\u000f\u0010u\u001a\u00020\bH\u0016¢\u0006\u0004\bu\u0010\u0007J\u0017\u0010x\u001a\u00020\b2\u0006\u0010w\u001a\u00020vH\u0016¢\u0006\u0004\bx\u0010yJ\u0017\u0010z\u001a\u00020\b2\u0006\u0010w\u001a\u00020vH\u0016¢\u0006\u0004\bz\u0010yJ\u0017\u0010{\u001a\u00020\b2\u0006\u0010W\u001a\u00020VH\u0016¢\u0006\u0004\b{\u0010YJ\u0017\u0010|\u001a\u00020\b2\u0006\u0010W\u001a\u00020VH\u0016¢\u0006\u0004\b|\u0010YJ\u0017\u0010}\u001a\u00020\b2\u0006\u0010W\u001a\u00020VH\u0016¢\u0006\u0004\b}\u0010YJ\u0017\u0010~\u001a\u00020\b2\u0006\u0010W\u001a\u00020VH\u0016¢\u0006\u0004\b~\u0010YJ\u0017\u0010\u007f\u001a\u00020\b2\u0006\u0010W\u001a\u00020VH\u0016¢\u0006\u0004\b\u007f\u0010YJ\u0019\u0010\u0080\u0001\u001a\u00020\b2\u0006\u0010W\u001a\u00020VH\u0016¢\u0006\u0005\b\u0080\u0001\u0010YJ\u0019\u0010\u0081\u0001\u001a\u00020\b2\u0006\u0010W\u001a\u00020VH\u0016¢\u0006\u0005\b\u0081\u0001\u0010YJ\u0019\u0010\u0082\u0001\u001a\u00020\b2\u0006\u0010W\u001a\u00020VH\u0016¢\u0006\u0005\b\u0082\u0001\u0010YJ\u0011\u0010\u0083\u0001\u001a\u00020\bH\u0016¢\u0006\u0005\b\u0083\u0001\u0010\u0007J\u0011\u0010\u0084\u0001\u001a\u00020\bH\u0016¢\u0006\u0005\b\u0084\u0001\u0010\u0007J\u0011\u0010\u0085\u0001\u001a\u00020\bH\u0016¢\u0006\u0005\b\u0085\u0001\u0010\u0007J\u0011\u0010\u0086\u0001\u001a\u00020\bH\u0016¢\u0006\u0005\b\u0086\u0001\u0010\u0007J\u000f\u0010\u0087\u0001\u001a\u00020\u000f¢\u0006\u0005\b\u0087\u0001\u0010(R\u001c\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u0088\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R\u001c\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008b\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R\u001c\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u008e\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R\u001b\u0010\u0091\u0001\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001R\u001c\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0093\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0094\u0001\u0010\u0095\u0001R\u001c\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0096\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001R\u0019\u0010E\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bE\u0010\u0099\u0001R\u001b\u0010\u009a\u0001\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009a\u0001\u0010\u009b\u0001R\u001b\u0010\u009c\u0001\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009c\u0001\u0010\u009d\u0001R\u001b\u0010\u009e\u0001\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009e\u0001\u0010\u009d\u0001R\u001c\u0010 \u0001\u001a\u0005\u0018\u00010\u009f\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b \u0001\u0010¡\u0001R\u0019\u0010¢\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¢\u0001\u0010£\u0001R\u0019\u0010¤\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¤\u0001\u0010£\u0001R\u0019\u0010¥\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¥\u0001\u0010£\u0001R\u0017\u0010¦\u0001\u001a\u00020\u00178\u0002X\u0082D¢\u0006\b\n\u0006\b¦\u0001\u0010£\u0001R\u0017\u0010§\u0001\u001a\u00020\u00178\u0002X\u0082D¢\u0006\b\n\u0006\b§\u0001\u0010£\u0001R\u0019\u0010¨\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¨\u0001\u0010©\u0001R\u0019\u0010ª\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bª\u0001\u0010£\u0001R\u0019\u0010«\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b«\u0001\u0010©\u0001R\u0019\u0010¬\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¬\u0001\u0010\u00ad\u0001R\u0019\u0010®\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b®\u0001\u0010©\u0001R\u0019\u0010¯\u0001\u001a\u00020[8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¯\u0001\u0010°\u0001R#\u0010¶\u0001\u001a\u0005\u0018\u00010±\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b²\u0001\u0010³\u0001\u001a\u0006\b´\u0001\u0010µ\u0001R#\u0010»\u0001\u001a\u0005\u0018\u00010·\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b¸\u0001\u0010³\u0001\u001a\u0006\b¹\u0001\u0010º\u0001R!\u0010À\u0001\u001a\u00030¼\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b½\u0001\u0010³\u0001\u001a\u0006\b¾\u0001\u0010¿\u0001R#\u0010Ã\u0001\u001a\f\u0012\u0005\u0012\u00030Â\u0001\u0018\u00010Á\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÃ\u0001\u0010Ä\u0001R\u0019\u0010Å\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÅ\u0001\u0010©\u0001R\u001c\u0010Ç\u0001\u001a\u0005\u0018\u00010Æ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÇ\u0001\u0010È\u0001R\u001c\u0010É\u0001\u001a\u0005\u0018\u00010Æ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÉ\u0001\u0010È\u0001R\u0019\u0010Ê\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÊ\u0001\u0010©\u0001R#\u0010Ì\u0001\u001a\f\u0012\u0005\u0012\u00030Ë\u0001\u0018\u00010Á\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÌ\u0001\u0010Ä\u0001R\u0018\u0010Î\u0001\u001a\u00030Í\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÎ\u0001\u0010Ï\u0001¨\u0006Ò\u0001"}, d2 = {"Lcom/transsion/publish/ui/FilmReviewFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Llo/h;", "Lcom/tn/lib/widget/dialog/TRDialogListener;", "Lcom/transsion/publish/adapter/a;", "Lmo/b$b;", "<init>", "()V", BuildConfig.FLAVOR, "getVideoIconView", "getImageIconView", "showActivityTips", BuildConfig.FLAVOR, "timestamp1", "timestamp2", BuildConfig.FLAVOR, "isMoreThanADay", "(JJ)Z", "requestCurrentLocation", "userPost", "userGrade", "Lcom/transsion/publish/api/bean/RequestPostEntity;", "request", BuildConfig.FLAVOR, "source", "postService", "(Lcom/transsion/publish/api/bean/RequestPostEntity;I)V", "buildRequest", "()Lcom/transsion/publish/api/bean/RequestPostEntity;", "detectionSelect", "(Lcom/transsion/publish/api/bean/RequestPostEntity;)V", "Lcom/transsion/publish/api/bean/RequestPostMediaEntity;", "mediaTypes", "checkCover", "(Lcom/transsion/publish/api/bean/RequestPostMediaEntity;)V", "Lcom/transsion/publish/api/VsMediaInfo;", "vsMediaInfo", "checkVideoCover", "(Lcom/transsion/publish/api/bean/RequestPostMediaEntity;Lcom/transsion/publish/api/VsMediaInfo;)V", "checkLogin", "()Z", "initViewModel", "observe", "Ljo/b;", "it", "disposeOperate", "(Ljo/b;)V", "refreshLocation", "refreshImage", "initImageAdapter", "initVideoAdapter", BuildConfig.FLAVOR, "getAddVideoEntity", "()Ljava/util/List;", "Lcom/transsion/publish/api/PhotoEntity;", "getAddImageEntity", "photoEntity", "selectPhotosDispose", "(Ljava/util/List;)V", "refreshAudio", "refreshVideo", "refreshCover", "refreshLink", "refreshWork", "Lcom/transsion/moviedetailapi/bean/Subject;", "subject", "setSubject", "(Lcom/transsion/moviedetailapi/bean/Subject;)V", "Lcom/transsion/publish/api/GroupBean;", "groupBean", "setGroup", "(Lcom/transsion/publish/api/GroupBean;)V", "Lcom/transsion/room/api/bean/LocationPlace;", "location", "setLocation", "(Lcom/transsion/room/api/bean/LocationPlace;)V", "refreshGroup", "initManagerAdapter", "text", "setStarTips", "(I)V", "deleteAudio", "deleteLocation", "coverClearDialog", "backSaveDialog", "initRegisterMediaSelector", "Landroid/content/Context;", "context", "showLinkEditInputDialog", "(Landroid/content/Context;)V", "checkBottomMargin", BuildConfig.FLAVOR, "value", "clickTrace", "(Ljava/lang/String;)V", "clickPostTrace", "openRoomList", "getPageName", "()Ljava/lang/String;", "hideOpertaionDialog", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", "Landroid/view/LayoutInflater;", "inflater", "getViewBinding", "(Landroid/view/LayoutInflater;)Llo/h;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initView", "closeAffirm", "checkPost", "lazyLoadData", "onDestroy", "Lcom/tn/lib/widget/dialog/TRDialog;", "dialog", "onLeftButtonClick", "(Lcom/tn/lib/widget/dialog/TRDialog;)V", "onRightButtonClick", "startPhoto", "startVideo", "startAudio", "startWork", "startLink", "startLocation", "startGroup", "put", "onPause", "completeLoad", "onStop", "onResume", "isPostEnable", "Lcom/transsion/publish/adapter/g;", "imageAdapter", "Lcom/transsion/publish/adapter/g;", "Lcom/transsion/publish/adapter/r;", "managerAdapter", "Lcom/transsion/publish/adapter/r;", "Lcom/transsion/publish/adapter/v;", "videoAdapter", "Lcom/transsion/publish/adapter/v;", "operationMenu", "Ljo/b;", "Lcom/transsion/publish/viewmodel/d;", "postViewModel", "Lcom/transsion/publish/viewmodel/d;", "Lcom/transsion/publish/bean/CoverEntity;", "coverPath", "Lcom/transsion/publish/bean/CoverEntity;", "Lcom/transsion/publish/api/GroupBean;", "mSubject", "Lcom/transsion/moviedetailapi/bean/Subject;", "locationBean", "Lcom/transsion/room/api/bean/LocationPlace;", "curLocationBean", "Lcom/transsion/publish/api/bean/MediaLinkEntity;", "linkEntity", "Lcom/transsion/publish/api/bean/MediaLinkEntity;", "publishType", "I", "sourceType", "sourceMode", "TITLE_MAX", "DESC_MAX", "requestGroup", "Z", "postStar", "isBold", "showTime", "J", "hasFocus", "TAG", "Ljava/lang/String;", "Lep/f;", "mRoomApi$delegate", "Lkotlin/Lazy;", "getMRoomApi", "()Lep/f;", "mRoomApi", "Lqx/a;", "loginApi$delegate", "getLoginApi", "()Lqx/a;", "loginApi", "Loo/b;", "publishModel$delegate", "getPublishModel", "()Loo/b;", "publishModel", "Landroidx/activity/result/b;", "Landroid/content/Intent;", "loginLaunch", "Landroidx/activity/result/b;", "isNeedShowLoginActivity", "Landroid/widget/ImageView;", "videoIcon", "Landroid/widget/ImageView;", "imageIcon", "underOS33", "Landroidx/activity/result/e;", "videoSelectLauncher", "Ljava/lang/Runnable;", "mRunnable", "Ljava/lang/Runnable;", "Companion", "a", "Publish_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class FilmReviewFragment extends BaseFragment<lo.h> implements TRDialogListener, com.transsion.publish.adapter.a, b.InterfaceC0085b {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String PAGE_NAME = "publish_post";
    private CoverEntity coverPath;
    private LocationPlace curLocationBean;
    private GroupBean groupBean;
    private boolean hasFocus;
    private com.transsion.publish.adapter.g imageAdapter;
    private ImageView imageIcon;
    private boolean isBold;
    private boolean isNeedShowLoginActivity;
    private MediaLinkEntity linkEntity;
    private LocationPlace locationBean;
    private androidx.activity.result.b loginLaunch;
    private final Runnable mRunnable;
    private Subject mSubject;
    private com.transsion.publish.adapter.r managerAdapter;
    private jo.b operationMenu;
    private int postStar;
    private com.transsion.publish.viewmodel.d postViewModel;
    private int publishType;
    private boolean requestGroup;
    private long showTime;
    private int sourceMode;
    private int sourceType;
    private boolean underOS33;
    private com.transsion.publish.adapter.v videoAdapter;
    private ImageView videoIcon;
    private androidx.activity.result.b videoSelectLauncher;
    private final int TITLE_MAX = 100;
    private final int DESC_MAX = 1000;
    private String TAG = "TNPublish";

    /* renamed from: mRoomApi$delegate, reason: from kotlin metadata */
    private final Lazy mRoomApi = LazyKt.b(new Function0() { // from class: com.transsion.publish.ui.h
        public final Object invoke() {
            ep.f mRoomApi_delegate$lambda$0;
            mRoomApi_delegate$lambda$0 = FilmReviewFragment.mRoomApi_delegate$lambda$0();
            return mRoomApi_delegate$lambda$0;
        }
    });

    /* renamed from: loginApi$delegate, reason: from kotlin metadata */
    private final Lazy loginApi = LazyKt.b(new Function0() { // from class: com.transsion.publish.ui.s
        public final Object invoke() {
            qx.a loginApi_delegate$lambda$1;
            loginApi_delegate$lambda$1 = FilmReviewFragment.loginApi_delegate$lambda$1();
            return loginApi_delegate$lambda$1;
        }
    });

    /* renamed from: publishModel$delegate, reason: from kotlin metadata */
    private final Lazy publishModel = LazyKt.b(new Function0() { // from class: com.transsion.publish.ui.w
        public final Object invoke() {
            oo.b publishModel_delegate$lambda$2;
            publishModel_delegate$lambda$2 = FilmReviewFragment.publishModel_delegate$lambda$2();
            return publishModel_delegate$lambda$2;
        }
    });

    /* renamed from: com.transsion.publish.ui.FilmReviewFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FilmReviewFragment a(int i, Subject subject, int i2, GroupBean groupBean) {
            FilmReviewFragment filmReviewFragment = new FilmReviewFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("sourceType", i);
            bundle.putInt("sourceMode", i2);
            if (subject != null) {
                bundle.putSerializable("subject", subject);
            }
            if (groupBean != null) {
                bundle.putSerializable("group", groupBean);
            }
            filmReviewFragment.setArguments(bundle);
            return filmReviewFragment;
        }
    }

    public static final class b implements TextWatcher {
        final /* synthetic */ Ref.ObjectRef b;
        final /* synthetic */ Ref.ObjectRef c;

        b(Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2) {
            this.b = objectRef;
            this.c = objectRef2;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            EditText editText;
            EditText editText2;
            TextView textView;
            EditText editText3;
            EditText editText4;
            TextView textView2;
            TextView textView3;
            EditText editText5;
            EditText editText6;
            int length = editable != null ? editable.length() : 0;
            if (length <= 0) {
                FilmReviewFragment.this.isBold = false;
                lo.h hVar = (lo.h) FilmReviewFragment.this.getMViewBinding();
                if (hVar != null && (editText2 = hVar.d) != null) {
                    editText2.setTypeface((Typeface) this.c.element, 0);
                }
                lo.h hVar2 = (lo.h) FilmReviewFragment.this.getMViewBinding();
                if (hVar2 != null && (editText = hVar2.d) != null) {
                    editText.invalidate();
                }
            } else if (!FilmReviewFragment.this.isBold) {
                lo.h hVar3 = (lo.h) FilmReviewFragment.this.getMViewBinding();
                if (hVar3 != null && (editText6 = hVar3.d) != null) {
                    editText6.setTypeface((Typeface) this.b.element, 1);
                }
                lo.h hVar4 = (lo.h) FilmReviewFragment.this.getMViewBinding();
                if (hVar4 != null && (editText5 = hVar4.d) != null) {
                    editText5.invalidate();
                }
                FilmReviewFragment.this.isBold = true;
            }
            if (length < FilmReviewFragment.this.TITLE_MAX - 20 || length > FilmReviewFragment.this.TITLE_MAX) {
                lo.h hVar5 = (lo.h) FilmReviewFragment.this.getMViewBinding();
                if (hVar5 != null && (textView = hVar5.w) != null) {
                    textView.setVisibility(8);
                }
            } else {
                lo.h hVar6 = (lo.h) FilmReviewFragment.this.getMViewBinding();
                if (hVar6 != null && (textView3 = hVar6.w) != null) {
                    textView3.setVisibility(0);
                }
                lo.h hVar7 = (lo.h) FilmReviewFragment.this.getMViewBinding();
                if (hVar7 != null && (textView2 = hVar7.w) != null) {
                    textView2.setText(String.valueOf(FilmReviewFragment.this.TITLE_MAX - length));
                }
            }
            if (length > FilmReviewFragment.this.TITLE_MAX) {
                com.tn.lib.widget.toast.core.h.a.k(R$string.post_title_length_max);
                if (TextUtils.isEmpty(editable)) {
                    return;
                }
                Integer valueOf = editable != null ? Integer.valueOf(editable.length()) : null;
                Intrinsics.e(valueOf);
                if (valueOf.intValue() > FilmReviewFragment.this.TITLE_MAX) {
                    String obj = editable.subSequence(0, FilmReviewFragment.this.TITLE_MAX).toString();
                    lo.h hVar8 = (lo.h) FilmReviewFragment.this.getMViewBinding();
                    if (hVar8 != null && (editText4 = hVar8.d) != null) {
                        editText4.setText(obj);
                    }
                    lo.h hVar9 = (lo.h) FilmReviewFragment.this.getMViewBinding();
                    if (hVar9 == null || (editText3 = hVar9.d) == null) {
                        return;
                    }
                    editText3.setSelection(obj.length());
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public static final class c implements TextWatcher {
        c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            OperationBarView operationBarView;
            OperationBarView operationBarView2;
            OperationBarView operationBarView3;
            lo.h hVar;
            EditText editText;
            EditText editText2;
            OperationBarView operationBarView4;
            EditText editText3;
            Integer valueOf = editable != null ? Integer.valueOf(editable.length()) : null;
            lo.h hVar2 = (lo.h) FilmReviewFragment.this.getMViewBinding();
            if (hVar2 != null && (editText3 = hVar2.c) != null) {
                Linkify.addLinks(editText3, 1);
            }
            if (valueOf != null) {
                FilmReviewActivity activity = FilmReviewFragment.this.getActivity();
                Intrinsics.f(activity, "null cannot be cast to non-null type com.transsion.publish.ui.FilmReviewActivity");
                activity.j0(FilmReviewFragment.this.isPostEnable());
                if (valueOf.intValue() >= 995) {
                    lo.h hVar3 = (lo.h) FilmReviewFragment.this.getMViewBinding();
                    if (hVar3 != null && (operationBarView4 = hVar3.m) != null) {
                        operationBarView4.setInputLimitColor(R.color.error_50);
                    }
                } else {
                    lo.h hVar4 = (lo.h) FilmReviewFragment.this.getMViewBinding();
                    if (hVar4 != null && (operationBarView2 = hVar4.m) != null) {
                        operationBarView2.setInputLimitColor(R.color.white_80);
                    }
                }
                if (valueOf.intValue() >= FilmReviewFragment.this.DESC_MAX) {
                    if (TextUtils.isEmpty(editable)) {
                        return;
                    }
                    Integer valueOf2 = editable != null ? Integer.valueOf(editable.length()) : null;
                    Intrinsics.e(valueOf2);
                    if (valueOf2.intValue() > FilmReviewFragment.this.DESC_MAX) {
                        String obj = editable != null ? editable.subSequence(0, FilmReviewFragment.this.DESC_MAX).toString() : null;
                        lo.h hVar5 = (lo.h) FilmReviewFragment.this.getMViewBinding();
                        if (hVar5 != null && (editText2 = hVar5.c) != null) {
                            editText2.setText(obj);
                        }
                        if (obj != null && (hVar = (lo.h) FilmReviewFragment.this.getMViewBinding()) != null && (editText = hVar.c) != null) {
                            editText.setSelection(obj.length());
                        }
                        lo.h hVar6 = (lo.h) FilmReviewFragment.this.getMViewBinding();
                        if (hVar6 == null || (operationBarView3 = hVar6.m) == null) {
                            return;
                        }
                        operationBarView3.updateInputNum(obj != null ? obj.length() : 0);
                        return;
                    }
                    return;
                }
            }
            lo.h hVar7 = (lo.h) FilmReviewFragment.this.getMViewBinding();
            if (hVar7 == null || (operationBarView = hVar7.m) == null) {
                return;
            }
            operationBarView.updateInputNum(valueOf != null ? valueOf.intValue() : 0);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public static final class d extends CountDownTimer {
        d() {
            super(5000L, 1000L);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            BubbleTextView bubbleTextView;
            lo.h hVar = (lo.h) FilmReviewFragment.this.getMViewBinding();
            if (hVar == null || (bubbleTextView = hVar.b) == null) {
                return;
            }
            bubbleTextView.setVisibility(8);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
        }
    }

    public FilmReviewFragment() {
        this.underOS33 = Build.VERSION.SDK_INT < 33;
        this.mRunnable = new Runnable() { // from class: com.transsion.publish.ui.x
            @Override // java.lang.Runnable
            public final void run() {
                FilmReviewFragment.mRunnable$lambda$36(FilmReviewFragment.this);
            }
        };
    }

    private final void backSaveDialog() {
        try {
            TRDialog.a aVar = new TRDialog.a();
            String string = getString(R$string.cover_save_des);
            Intrinsics.g(string, "getString(...)");
            TRDialog.a g = aVar.g(string);
            String string2 = getString(R$string.cover_save_right);
            Intrinsics.g(string2, "getString(...)");
            TRDialog.a e = g.e(string2);
            String string3 = getString(R$string.cover_save_left);
            Intrinsics.g(string3, "getString(...)");
            e.j(string3).h(R$drawable.btn_bg_dialog_edit_selector).c(R$drawable.btn_bg_dialog_edit_selector).i(com.blankj.utilcode.util.h.a(R.color.error_50)).f(this).a().d0(this, "back_save");
            HashMap hashMap = new HashMap();
            hashMap.put("module_name", "back_save_dialog");
            qi.h.a.z(getPageName(), hashMap);
        } catch (Exception unused) {
        }
    }

    private final RequestPostEntity buildRequest() {
        String str;
        String str2;
        Double lat;
        Double lon;
        EditText editText;
        String subjectId;
        EditText editText2;
        lo.h hVar = (lo.h) getMViewBinding();
        Editable editable = null;
        String Q = StringsKt.Q(StringsKt.Q(String.valueOf((hVar == null || (editText2 = hVar.c) == null) ? null : editText2.getText()), "\\n", BuildConfig.FLAVOR, false, 4, (Object) null), "\\t", BuildConfig.FLAVOR, false, 4, (Object) null);
        RequestPostEntity requestPostEntity = new RequestPostEntity();
        GroupBean groupBean = this.groupBean;
        String str3 = "0";
        if (groupBean == null || (str = groupBean.getGroupId()) == null) {
            str = "0";
        }
        requestPostEntity.setGroupId(str);
        requestPostEntity.setScore(String.valueOf(this.postStar));
        requestPostEntity.setLink(this.linkEntity);
        Subject subject = this.mSubject;
        if (subject != null && (subjectId = subject.getSubjectId()) != null) {
            str3 = subjectId;
        }
        requestPostEntity.setSubjectId(str3);
        lo.h hVar2 = (lo.h) getMViewBinding();
        if (hVar2 != null && (editText = hVar2.d) != null) {
            editable = editText.getText();
        }
        requestPostEntity.setTitle(String.valueOf(editable));
        requestPostEntity.setContent(Q);
        requestPostEntity.setPublishType(this.sourceType);
        LocationPlace locationPlace = this.locationBean;
        double d2 = 0.0d;
        requestPostEntity.setLon((locationPlace == null || (lon = locationPlace.getLon()) == null) ? 0.0d : lon.doubleValue());
        LocationPlace locationPlace2 = this.locationBean;
        if (locationPlace2 != null && (lat = locationPlace2.getLat()) != null) {
            d2 = lat.doubleValue();
        }
        requestPostEntity.setLat(d2);
        LocationPlace locationPlace3 = this.locationBean;
        if (locationPlace3 == null || (str2 = locationPlace3.getName()) == null) {
            str2 = BuildConfig.FLAVOR;
        }
        requestPostEntity.setPoiName(str2);
        detectionSelect(requestPostEntity);
        return requestPostEntity;
    }

    private final void checkBottomMargin() {
    }

    private final void checkCover(RequestPostMediaEntity mediaTypes) {
        Integer height;
        Integer width;
        Long size;
        if (this.coverPath != null) {
            MediaCoverEntity mediaCoverEntity = new MediaCoverEntity();
            CoverEntity coverEntity = this.coverPath;
            mediaCoverEntity.setUrl(coverEntity != null ? coverEntity.getUrl() : null);
            CoverEntity coverEntity2 = this.coverPath;
            mediaCoverEntity.setSize((coverEntity2 == null || (size = coverEntity2.getSize()) == null) ? 0L : size.longValue());
            CoverEntity coverEntity3 = this.coverPath;
            int i = 0;
            mediaCoverEntity.setWidth((coverEntity3 == null || (width = coverEntity3.getWidth()) == null) ? 0 : width.intValue());
            CoverEntity coverEntity4 = this.coverPath;
            if (coverEntity4 != null && (height = coverEntity4.getHeight()) != null) {
                i = height.intValue();
            }
            mediaCoverEntity.setHeight(i);
            mediaTypes.setCover(mediaCoverEntity);
        }
    }

    private final boolean checkLogin() {
        qx.a loginApi = getLoginApi();
        if (loginApi == null || loginApi.a()) {
            return true;
        }
        androidx.activity.result.b bVar = this.loginLaunch;
        if (bVar == null) {
            this.isNeedShowLoginActivity = true;
        }
        if (bVar == null) {
            return false;
        }
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        Intent p = loginApi.p(requireContext);
        p.putExtra("title_name", getString(R$string.post_login_title));
        bVar.a(p);
        return false;
    }

    private final void checkVideoCover(RequestPostMediaEntity mediaTypes, VsMediaInfo vsMediaInfo) {
        if (TextUtils.isEmpty(vsMediaInfo.getImagePath())) {
            return;
        }
        int[] d2 = ImageUtils.d(vsMediaInfo.getImagePath());
        MediaCoverEntity mediaCoverEntity = new MediaCoverEntity();
        mediaCoverEntity.setUrl(vsMediaInfo.getImagePath());
        mediaCoverEntity.setSize(d2[0] * d2[1]);
        mediaCoverEntity.setWidth(d2[0]);
        mediaCoverEntity.setHeight(d2[1]);
        mediaTypes.setCover(mediaCoverEntity);
    }

    private final void clickPostTrace() {
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "post");
        qi.h.a.o(getPageName(), hashMap);
    }

    private final void clickTrace(String value) {
        HashMap hashMap = new HashMap();
        hashMap.put(PushConstants.PUSH_SERVICE_TYPE_CLICK, value);
        qi.h.a.o(getPageName(), hashMap);
    }

    private final void coverClearDialog() {
        try {
            TRDialog.a aVar = new TRDialog.a();
            String string = getString(R$string.cover_clear_des);
            Intrinsics.g(string, "getString(...)");
            TRDialog.a g = aVar.g(string);
            String string2 = getString(R$string.cover_clear_left);
            Intrinsics.g(string2, "getString(...)");
            TRDialog.a e = g.e(string2);
            String string3 = getString(R$string.cover_clear_right);
            Intrinsics.g(string3, "getString(...)");
            e.j(string3).h(R$drawable.btn_bg_dialog_edit_selector).c(R$drawable.btn_bg_dialog_edit_selector).i(com.blankj.utilcode.util.h.a(R$color.base_color_black)).f(this).a().d0(this, "clear_cover");
        } catch (Exception unused) {
        }
    }

    private final void deleteAudio() {
        OperationBarView operationBarView;
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        LinearLayout linearLayout;
        ImageView imageView;
        ImageView imageView2;
        RelativeLayout relativeLayout3;
        RelativeLayout relativeLayout4;
        this.coverPath = null;
        lo.h hVar = (lo.h) getMViewBinding();
        if (hVar != null && (relativeLayout = hVar.o) != null && relativeLayout.getVisibility() == 0) {
            lo.h hVar2 = (lo.h) getMViewBinding();
            if (hVar2 != null && (relativeLayout4 = hVar2.o) != null) {
                relativeLayout4.setVisibility(8);
            }
            if (this.sourceType == 1) {
                lo.h hVar3 = (lo.h) getMViewBinding();
                if (hVar3 != null && (relativeLayout3 = hVar3.q) != null) {
                    relativeLayout3.setVisibility(0);
                }
            } else {
                lo.h hVar4 = (lo.h) getMViewBinding();
                if (hVar4 != null && (relativeLayout2 = hVar4.q) != null) {
                    relativeLayout2.setVisibility(8);
                }
            }
            lo.h hVar5 = (lo.h) getMViewBinding();
            if (hVar5 != null && (imageView2 = hVar5.g) != null) {
                imageView2.setImageResource(0);
            }
            lo.h hVar6 = (lo.h) getMViewBinding();
            if (hVar6 != null && (imageView = hVar6.g) != null) {
                imageView.setBackgroundResource(0);
            }
            lo.h hVar7 = (lo.h) getMViewBinding();
            if (hVar7 != null && (linearLayout = hVar7.j) != null) {
                linearLayout.requestLayout();
            }
        }
        lo.h hVar8 = (lo.h) getMViewBinding();
        if (hVar8 != null && (operationBarView = hVar8.m) != null) {
            operationBarView.resetItem();
        }
        jo.b bVar = this.operationMenu;
        if (bVar != null) {
            if ((bVar != null ? bVar.a() : null) != null) {
                com.transsion.publish.adapter.r rVar = this.managerAdapter;
                if (rVar != null) {
                    jo.b bVar2 = this.operationMenu;
                    AudioEntity a = bVar2 != null ? bVar2.a() : null;
                    Intrinsics.e(a);
                    rVar.I(a);
                }
                this.operationMenu = null;
            }
        }
        com.transsion.publish.adapter.r rVar2 = this.managerAdapter;
        if (rVar2 != null) {
            rVar2.u();
        }
    }

    private final void deleteLocation() {
        jo.b bVar = this.operationMenu;
        if (bVar != null) {
            if ((bVar != null ? bVar.g() : null) != null) {
                com.transsion.publish.adapter.r rVar = this.managerAdapter;
                if (rVar != null) {
                    jo.b bVar2 = this.operationMenu;
                    LocationPlace g = bVar2 != null ? bVar2.g() : null;
                    Intrinsics.e(g);
                    rVar.I(g);
                }
                this.locationBean = null;
                this.operationMenu = null;
            }
        }
    }

    private final void detectionSelect(RequestPostEntity request) {
        List<rm.a> v;
        List<VsMediaInfo> m;
        List<PhotoEntity> m2;
        OperationBarView operationBarView;
        lo.h hVar = (lo.h) getMViewBinding();
        List<Integer> selectItem = (hVar == null || (operationBarView = hVar.m) == null) ? null : operationBarView.getSelectItem();
        RequestPostMediaEntity requestPostMediaEntity = new RequestPostMediaEntity();
        request.setMedia(requestPostMediaEntity);
        if (selectItem != null) {
            Iterator<T> it = selectItem.iterator();
            while (it.hasNext()) {
                int intValue = ((Number) it.next()).intValue();
                if (intValue == 0) {
                    requestPostMediaEntity.setMediaType(1);
                    ArrayList arrayList = new ArrayList();
                    com.transsion.publish.adapter.g gVar = this.imageAdapter;
                    if (gVar != null && (m2 = gVar.m()) != null) {
                        for (PhotoEntity photoEntity : m2) {
                            if (!photoEntity.getIsAdd()) {
                                MediaImageEntity mediaImageEntity = new MediaImageEntity();
                                mediaImageEntity.setUrl(String.valueOf(photoEntity.getLocalPath()));
                                if (photoEntity.getWidth() > 0) {
                                    mediaImageEntity.setWidth(Integer.valueOf(photoEntity.getWidth()));
                                }
                                if (photoEntity.getHeight() > 0) {
                                    mediaImageEntity.setHeight(Integer.valueOf(photoEntity.getHeight()));
                                }
                                if (photoEntity.getImageSize() > 0) {
                                    mediaImageEntity.setSize(Long.valueOf(photoEntity.getImageSize()));
                                }
                                arrayList.add(mediaImageEntity);
                            }
                        }
                    }
                    requestPostMediaEntity.setImage(arrayList);
                } else if (intValue == 1) {
                    requestPostMediaEntity.setMediaType(4);
                    requestPostMediaEntity.setVideo(new ArrayList());
                    com.transsion.publish.adapter.v vVar = this.videoAdapter;
                    if (vVar != null && (m = vVar.m()) != null) {
                        for (VsMediaInfo vsMediaInfo : m) {
                            if (!vsMediaInfo.getIsAdd()) {
                                MediaVideoEntity mediaVideoEntity = new MediaVideoEntity();
                                mediaVideoEntity.setUrl(String.valueOf(vsMediaInfo.getVideoPath()));
                                mediaVideoEntity.setImagePath(vsMediaInfo.getImagePath());
                                if (vsMediaInfo.getWidth() > 0) {
                                    mediaVideoEntity.setWidth(vsMediaInfo.getWidth());
                                }
                                if (vsMediaInfo.getHeight() > 0) {
                                    mediaVideoEntity.setHeight(vsMediaInfo.getHeight());
                                }
                                if (vsMediaInfo.getVideoDuration() > 0) {
                                    mediaVideoEntity.setDuration(vsMediaInfo.getVideoDuration() / 1000);
                                }
                                mediaVideoEntity.setSize(vsMediaInfo.getVideoSize());
                                mediaVideoEntity.setFps(0);
                                mediaVideoEntity.setBitrate(0);
                                mediaVideoEntity.setDefinition(0);
                                List<MediaVideoEntity> video = requestPostMediaEntity.getVideo();
                                if (video != null) {
                                    video.add(mediaVideoEntity);
                                }
                                checkVideoCover(requestPostMediaEntity, vsMediaInfo);
                            }
                        }
                    }
                } else if (intValue == 2) {
                    requestPostMediaEntity.setMediaType(2);
                    requestPostMediaEntity.setAudio(new ArrayList());
                    com.transsion.publish.adapter.r rVar = this.managerAdapter;
                    if (rVar != null && (v = rVar.v()) != null) {
                        for (rm.a aVar : v) {
                            if (aVar instanceof AudioEntity) {
                                MediaAudioEntity mediaAudioEntity = new MediaAudioEntity();
                                AudioEntity audioEntity = (AudioEntity) aVar;
                                mediaAudioEntity.setUrl(String.valueOf(audioEntity.getLocalPath()));
                                mediaAudioEntity.setSize(audioEntity.getSize());
                                Long duration = audioEntity.getDuration();
                                if ((duration != null ? duration.longValue() : 0L) > 0) {
                                    Long duration2 = audioEntity.getDuration();
                                    mediaAudioEntity.setDuration(duration2 != null ? duration2.longValue() / 1000 : 0L);
                                }
                                mediaAudioEntity.setBitrate(0L);
                                List<MediaAudioEntity> audio = requestPostMediaEntity.getAudio();
                                if (audio != null) {
                                    audio.add(mediaAudioEntity);
                                }
                            }
                        }
                    }
                    checkCover(requestPostMediaEntity);
                }
            }
        }
    }

    private final void disposeOperate(jo.b it) {
        Integer e;
        this.operationMenu = it;
        hideOpertaionDialog();
        Integer e2 = it.e();
        if (e2 != null && e2.intValue() == 0) {
            refreshImage(it);
        } else if (e2 != null && e2.intValue() == 1) {
            refreshVideo(it);
        } else if (e2 != null && e2.intValue() == 2) {
            refreshAudio(it);
        } else if (e2 != null && e2.intValue() == 5) {
            refreshCover(it);
        } else if (e2 != null && e2.intValue() == 3) {
            refreshWork(it);
        } else if (e2 != null && e2.intValue() == 6) {
            refreshGroup(it);
        } else if (e2 != null && e2.intValue() == 4) {
            refreshLink(it);
        } else if (e2 != null && e2.intValue() == 8) {
            refreshLocation(it);
        }
        Integer e3 = it.e();
        if (e3 != null && e3.intValue() == 5 && (e = it.e()) != null && e.intValue() == 6) {
            return;
        }
        checkBottomMargin();
    }

    private final List<PhotoEntity> getAddImageEntity() {
        ArrayList arrayList = new ArrayList();
        PhotoEntity photoEntity = new PhotoEntity();
        photoEntity.setAdd(true);
        arrayList.add(photoEntity);
        return arrayList;
    }

    private final List<VsMediaInfo> getAddVideoEntity() {
        ArrayList arrayList = new ArrayList();
        VsMediaInfo vsMediaInfo = new VsMediaInfo();
        vsMediaInfo.setAdd(true);
        arrayList.add(vsMediaInfo);
        return arrayList;
    }

    private final void getImageIconView() {
        OperationBarView operationBarView;
        RecyclerView rv;
        lo.h hVar = (lo.h) getMViewBinding();
        if (hVar == null || (operationBarView = hVar.m) == null || (rv = operationBarView.getRv()) == null) {
            return;
        }
        rv.post(new Runnable() { // from class: com.transsion.publish.ui.l
            @Override // java.lang.Runnable
            public final void run() {
                FilmReviewFragment.getImageIconView$lambda$11(FilmReviewFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getImageIconView$lambda$11(FilmReviewFragment filmReviewFragment) {
        OperationBarView operationBarView;
        RecyclerView rv;
        lo.h hVar = (lo.h) filmReviewFragment.getMViewBinding();
        RecyclerView.a0 findViewHolderForAdapterPosition = (hVar == null || (operationBarView = hVar.m) == null || (rv = operationBarView.getRv()) == null) ? null : rv.findViewHolderForAdapterPosition(0);
        if (findViewHolderForAdapterPosition instanceof so.f) {
            filmReviewFragment.imageIcon = (ImageView) ((RecyclerView.a0) ((so.f) findViewHolderForAdapterPosition)).itemView.findViewById(R$id.image);
        }
    }

    private final qx.a getLoginApi() {
        return (qx.a) this.loginApi.getValue();
    }

    private final ep.f getMRoomApi() {
        return (ep.f) this.mRoomApi.getValue();
    }

    private final String getPageName() {
        return PAGE_NAME;
    }

    private final oo.b getPublishModel() {
        return (oo.b) this.publishModel.getValue();
    }

    private final void getVideoIconView() {
        OperationBarView operationBarView;
        RecyclerView rv;
        lo.h hVar = (lo.h) getMViewBinding();
        if (hVar == null || (operationBarView = hVar.m) == null || (rv = operationBarView.getRv()) == null) {
            return;
        }
        rv.post(new Runnable() { // from class: com.transsion.publish.ui.k
            @Override // java.lang.Runnable
            public final void run() {
                FilmReviewFragment.getVideoIconView$lambda$10(FilmReviewFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getVideoIconView$lambda$10(FilmReviewFragment filmReviewFragment) {
        OperationBarView operationBarView;
        RecyclerView rv;
        lo.h hVar = (lo.h) filmReviewFragment.getMViewBinding();
        RecyclerView.a0 findViewHolderForAdapterPosition = (hVar == null || (operationBarView = hVar.m) == null || (rv = operationBarView.getRv()) == null) ? null : rv.findViewHolderForAdapterPosition(1);
        if (findViewHolderForAdapterPosition instanceof so.f) {
            filmReviewFragment.videoIcon = (ImageView) ((RecyclerView.a0) ((so.f) findViewHolderForAdapterPosition)).itemView.findViewById(R$id.image);
        }
    }

    private final void hideOpertaionDialog() {
    }

    private final void initImageAdapter() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        if (this.imageAdapter == null) {
            this.imageAdapter = new com.transsion.publish.adapter.g();
            lo.h hVar = (lo.h) getMViewBinding();
            if (hVar != null && (recyclerView3 = hVar.s) != null) {
                recyclerView3.setLayoutManager(new NpaGridLayoutManager(getContext(), 3));
            }
            lo.h hVar2 = (lo.h) getMViewBinding();
            if (hVar2 != null && (recyclerView2 = hVar2.s) != null) {
                recyclerView2.addItemDecoration(new tf.b(com.blankj.utilcode.util.a0.a(2.0f), com.blankj.utilcode.util.a0.a(2.0f), 0, com.blankj.utilcode.util.a0.a(8.0f)));
            }
        }
        lo.h hVar3 = (lo.h) getMViewBinding();
        if (hVar3 == null || (recyclerView = hVar3.s) == null) {
            return;
        }
        recyclerView.setAdapter(this.imageAdapter);
    }

    private final void initManagerAdapter() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        if (this.managerAdapter == null) {
            this.managerAdapter = new com.transsion.publish.adapter.r();
            lo.h hVar = (lo.h) getMViewBinding();
            if (hVar != null && (recyclerView2 = hVar.r) != null) {
                recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
            }
            lo.h hVar2 = (lo.h) getMViewBinding();
            if (hVar2 == null || (recyclerView = hVar2.r) == null) {
                return;
            }
            recyclerView.setAdapter(this.managerAdapter);
        }
    }

    private final void initRegisterMediaSelector() {
        if (this.underOS33) {
            return;
        }
        this.videoSelectLauncher = requireActivity().registerForActivityResult(new f.g(), new androidx.activity.result.a() { // from class: com.transsion.publish.ui.t
            public final void a(Object obj) {
                FilmReviewFragment.initRegisterMediaSelector$lambda$31(FilmReviewFragment.this, (Uri) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRegisterMediaSelector$lambda$31(FilmReviewFragment filmReviewFragment, Uri uri) {
        if (uri != null) {
            jo.b bVar = new jo.b();
            bVar.o(1);
            bVar.n(1);
            VsMediaInfo vsMediaInfo = new VsMediaInfo();
            qo.g gVar = qo.g.a;
            Context requireContext = filmReviewFragment.requireContext();
            Intrinsics.g(requireContext, "requireContext(...)");
            ko.a b2 = gVar.b(requireContext, uri);
            if (b2 != null) {
                vsMediaInfo.setVideoPath(b2.c());
                vsMediaInfo.setVideoTitle(b2.e());
                vsMediaInfo.setVideoDuration(b2.a());
                vsMediaInfo.setWidth(b2.f());
                vsMediaInfo.setHeight(b2.b());
                vsMediaInfo.setVideoSize(b2.d());
            }
            bVar.u(vsMediaInfo);
            filmReviewFragment.refreshVideo(bVar);
            filmReviewFragment.requireActivity().getContentResolver().takePersistableUriPermission(uri, 1);
        }
    }

    private final void initVideoAdapter() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        if (this.videoAdapter == null) {
            this.videoAdapter = new com.transsion.publish.adapter.v();
            lo.h hVar = (lo.h) getMViewBinding();
            if (hVar != null && (recyclerView3 = hVar.s) != null) {
                recyclerView3.setLayoutManager(new NpaGridLayoutManager(getContext(), 3));
            }
            lo.h hVar2 = (lo.h) getMViewBinding();
            if (hVar2 != null && (recyclerView2 = hVar2.s) != null) {
                recyclerView2.addItemDecoration(new tf.b(com.blankj.utilcode.util.a0.a(2.0f), com.blankj.utilcode.util.a0.a(2.0f), 0, com.blankj.utilcode.util.a0.a(8.0f)));
            }
        }
        lo.h hVar3 = (lo.h) getMViewBinding();
        if (hVar3 == null || (recyclerView = hVar3.s) == null) {
            return;
        }
        recyclerView.setAdapter(this.videoAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(FilmReviewFragment filmReviewFragment, RatingBar ratingBar, float f, boolean z) {
        filmReviewFragment.postStar = (int) f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(FilmReviewFragment filmReviewFragment, View view) {
        SelectImageActivity.Companion companion = SelectImageActivity.INSTANCE;
        Context requireContext = filmReviewFragment.requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        com.transsion.publish.adapter.g gVar = filmReviewFragment.imageAdapter;
        companion.a(requireContext, 5, 1, gVar != null ? gVar.m() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5(FilmReviewFragment filmReviewFragment, ActivityResult activityResult) {
        Intrinsics.h(activityResult, "it");
        if (activityResult.getResultCode() != -1) {
            a.a.f(wf.a.a, "loginStatus", "登录失败或者取消", false, 4, (Object) null);
            return;
        }
        a.a.f(wf.a.a, "loginStatus", "登录成功", false, 4, (Object) null);
        com.tn.lib.widget.toast.core.h hVar = com.tn.lib.widget.toast.core.h.a;
        qx.a loginApi = filmReviewFragment.getLoginApi();
        hVar.l(loginApi != null ? loginApi.b() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6(FilmReviewFragment filmReviewFragment, View view, boolean z) {
        view.dispatchWindowFocusChanged(z);
        filmReviewFragment.hasFocus = z;
        if (z) {
            filmReviewFragment.hideOpertaionDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$8(final FilmReviewFragment filmReviewFragment, View view, boolean z) {
        lo.h hVar;
        EditText editText;
        EditText editText2;
        view.dispatchWindowFocusChanged(z);
        if (z) {
            filmReviewFragment.hideOpertaionDialog();
            lo.h hVar2 = (lo.h) filmReviewFragment.getMViewBinding();
            if (!TextUtils.isEmpty((hVar2 == null || (editText2 = hVar2.c) == null) ? null : editText2.getText()) || (hVar = (lo.h) filmReviewFragment.getMViewBinding()) == null || (editText = hVar.c) == null) {
                return;
            }
            editText.post(new Runnable() { // from class: com.transsion.publish.ui.v
                @Override // java.lang.Runnable
                public final void run() {
                    FilmReviewFragment.initView$lambda$8$lambda$7(FilmReviewFragment.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$8$lambda$7(FilmReviewFragment filmReviewFragment) {
        EditText editText;
        EditText editText2;
        EditText editText3;
        lo.h hVar = (lo.h) filmReviewFragment.getMViewBinding();
        if (hVar != null && (editText3 = hVar.c) != null) {
            editText3.setText(BuildConfig.FLAVOR);
        }
        lo.h hVar2 = (lo.h) filmReviewFragment.getMViewBinding();
        if (hVar2 != null && (editText2 = hVar2.c) != null) {
            editText2.setSelection(0);
        }
        lo.h hVar3 = (lo.h) filmReviewFragment.getMViewBinding();
        if (hVar3 == null || (editText = hVar3.c) == null) {
            return;
        }
        editText.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$9(int i) {
    }

    @SuppressLint({"InflateParams"})
    private final void initViewModel() {
        observe();
    }

    private final boolean isMoreThanADay(long timestamp1, long timestamp2) {
        return timestamp1 - timestamp2 > ((long) 604800000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qx.a loginApi_delegate$lambda$1() {
        return (qx.a) TheRouter.d(qx.a.class, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ep.f mRoomApi_delegate$lambda$0() {
        return (ep.f) TheRouter.d(ep.f.class, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mRunnable$lambda$36(FilmReviewFragment filmReviewFragment) {
        EditText editText;
        lo.h hVar = (lo.h) filmReviewFragment.getMViewBinding();
        if (hVar == null || (editText = hVar.c) == null) {
            return;
        }
        editText.clearFocus();
        editText.requestFocus();
        KeyboardUtils.i(editText);
    }

    private final void observe() {
        Function1 function1 = new Function1() { // from class: com.transsion.publish.ui.n
            public final Object invoke(Object obj) {
                Unit observe$lambda$23;
                observe$lambda$23 = FilmReviewFragment.observe$lambda$23(FilmReviewFragment.this, (jo.b) obj);
                return observe$lambda$23;
            }
        };
        AppScopeVMlProvider appScopeVMlProvider = AppScopeVMlProvider.INSTANCE;
        FlowEventBus applicationScopeViewModel = appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
        String name = jo.b.class.getName();
        Intrinsics.g(name, "getName(...)");
        Lifecycle.State state = Lifecycle.State.CREATED;
        applicationScopeViewModel.observeEvent(this, name, state, kotlinx.coroutines.y0.c().p(), false, function1);
        Function1 function12 = new Function1() { // from class: com.transsion.publish.ui.o
            public final Object invoke(Object obj) {
                Unit observe$lambda$24;
                observe$lambda$24 = FilmReviewFragment.observe$lambda$24(FilmReviewFragment.this, (BigImageBean) obj);
                return observe$lambda$24;
            }
        };
        FlowEventBus applicationScopeViewModel2 = appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
        String name2 = BigImageBean.class.getName();
        Intrinsics.g(name2, "getName(...)");
        applicationScopeViewModel2.observeEvent(this, name2, state, kotlinx.coroutines.y0.c().p(), false, function12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit observe$lambda$23(FilmReviewFragment filmReviewFragment, jo.b bVar) {
        Intrinsics.h(bVar, "it");
        filmReviewFragment.disposeOperate(bVar);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit observe$lambda$24(FilmReviewFragment filmReviewFragment, BigImageBean bigImageBean) {
        Intrinsics.h(bigImageBean, "it");
        Integer from = bigImageBean.getFrom();
        if (from == null || from.intValue() != 2) {
            return Unit.a;
        }
        Integer operator = bigImageBean.getOperator();
        if (operator != null && operator.intValue() == 1) {
            filmReviewFragment.selectPhotosDispose(bigImageBean.getSelect());
        }
        return Unit.a;
    }

    private final void openRoomList() {
        Navigator.x(TheRouter.c("/room/list").z("is_select_room", true).F("index", 1), requireContext(), (mf.c) null, 2, (Object) null);
    }

    private final void postService(RequestPostEntity request, int source) {
        PublishService.Companion companion = PublishService.INSTANCE;
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        companion.a(requireContext, request, this.sourceType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final oo.b publishModel_delegate$lambda$2() {
        return new oo.b();
    }

    private final void refreshAudio(jo.b it) {
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        RelativeLayout relativeLayout3;
        OperationBarView operationBarView;
        Integer d2 = it.d();
        if (d2 == null || d2.intValue() != 1) {
            if (d2 != null && d2.intValue() == 2) {
                if (this.coverPath != null) {
                    coverClearDialog();
                    return;
                } else {
                    deleteAudio();
                    return;
                }
            }
            return;
        }
        if (it.a() == null) {
            return;
        }
        lo.h hVar = (lo.h) getMViewBinding();
        if (hVar != null && (operationBarView = hVar.m) != null) {
            operationBarView.selectItem(2);
        }
        initManagerAdapter();
        AudioEntity a = it.a();
        if (a != null) {
            a.setType(2);
        }
        com.transsion.publish.adapter.r rVar = this.managerAdapter;
        if (rVar != null) {
            rVar.J(it.a());
        }
        lo.h hVar2 = (lo.h) getMViewBinding();
        if (hVar2 == null || (relativeLayout3 = hVar2.o) == null || relativeLayout3.getVisibility() != 0) {
            lo.h hVar3 = (lo.h) getMViewBinding();
            if (hVar3 != null && (relativeLayout2 = hVar3.o) != null) {
                relativeLayout2.setVisibility(0);
            }
            lo.h hVar4 = (lo.h) getMViewBinding();
            if (hVar4 == null || (relativeLayout = hVar4.q) == null) {
                return;
            }
            relativeLayout.setVisibility(8);
        }
    }

    private final void refreshCover(jo.b it) {
        ImageView imageView;
        if (it.b() == null) {
            return;
        }
        if (this.coverPath == null) {
            this.coverPath = new CoverEntity();
        }
        CoverEntity coverEntity = this.coverPath;
        if (coverEntity != null) {
            PhotoEntity b2 = it.b();
            coverEntity.setUrl(b2 != null ? b2.getLocalPath() : null);
        }
        CoverEntity coverEntity2 = this.coverPath;
        if (coverEntity2 != null) {
            PhotoEntity b3 = it.b();
            coverEntity2.setSize(b3 != null ? Long.valueOf(b3.getImageSize()) : null);
        }
        CoverEntity coverEntity3 = this.coverPath;
        if (coverEntity3 != null) {
            PhotoEntity b4 = it.b();
            coverEntity3.setWidth(b4 != null ? Integer.valueOf(b4.getWidth()) : null);
        }
        CoverEntity coverEntity4 = this.coverPath;
        if (coverEntity4 != null) {
            PhotoEntity b5 = it.b();
            coverEntity4.setHeight(b5 != null ? Integer.valueOf(b5.getHeight()) : null);
        }
        lo.h hVar = (lo.h) getMViewBinding();
        if (hVar != null && (imageView = hVar.g) != null) {
            imageView.setVisibility(0);
        }
        f.a aVar = ni.f.a;
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        f.b m = aVar.m(requireContext);
        PhotoEntity b6 = it.b();
        f.b i = m.g(b6 != null ? b6.getLocalPath() : null).i(com.transsion.publish.R$color.color_ff999999);
        lo.h hVar2 = (lo.h) getMViewBinding();
        ImageView imageView2 = hVar2 != null ? hVar2.g : null;
        Intrinsics.e(imageView2);
        i.d(imageView2);
    }

    private final void refreshGroup(jo.b it) {
        this.groupBean = it.c();
        Integer d2 = it.d();
        if (d2 != null && d2.intValue() == 1) {
            GroupBean c2 = it.c();
            if (c2 != null) {
                setGroup(c2);
            }
        } else if (d2 != null && d2.intValue() == 2) {
            jo.b bVar = this.operationMenu;
            if (bVar != null) {
                if ((bVar != null ? bVar.c() : null) != null) {
                    com.transsion.publish.adapter.r rVar = this.managerAdapter;
                    if (rVar != null) {
                        jo.b bVar2 = this.operationMenu;
                        GroupBean c3 = bVar2 != null ? bVar2.c() : null;
                        Intrinsics.e(c3);
                        rVar.I(c3);
                    }
                    this.operationMenu = null;
                }
            }
            this.groupBean = null;
        }
        HashMap hashMap = new HashMap();
        GroupBean groupBean = this.groupBean;
        hashMap.put("group_id", String.valueOf(groupBean != null ? groupBean.getGroupId() : null));
        qi.h.a.o(getPageName(), hashMap);
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0098, code lost:
    
        if (((r5 == null || (r5 = r5.l()) == null || (r5 = (com.transsion.publish.api.PhotoEntity) r5.get(0)) == null || !r5.getIsAdd()) ? false : true) != false) goto L67;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void refreshImage(jo.b it) {
        OperationBarView operationBarView;
        lo.h hVar;
        OperationBarView operationBarView2;
        List l;
        List l2;
        List l3;
        List l4;
        Integer d2 = it.d();
        int i = 0;
        if (d2 != null && d2.intValue() == 1) {
            com.transsion.publish.adapter.g gVar = this.imageAdapter;
            if (gVar != null && (l4 = gVar.l()) != null) {
                i = l4.size();
            }
            if (i < 9) {
                com.transsion.publish.adapter.g gVar2 = this.imageAdapter;
                if (gVar2 != null) {
                    List h = it.h();
                    if (h == null) {
                        h = new ArrayList();
                    }
                    h.addAll(gVar2.l());
                    it.r(h);
                }
                selectPhotosDispose(it.h());
            }
        } else {
            Integer d3 = it.d();
            if (d3 != null && d3.intValue() == 2) {
                com.transsion.publish.adapter.g gVar3 = this.imageAdapter;
                if (!((gVar3 == null || (l3 = gVar3.l()) == null || l3.size() != 0) ? false : true)) {
                    com.transsion.publish.adapter.g gVar4 = this.imageAdapter;
                    if ((gVar4 == null || (l2 = gVar4.l()) == null || l2.size() != 1) ? false : true) {
                        com.transsion.publish.adapter.g gVar5 = this.imageAdapter;
                    }
                    com.transsion.publish.adapter.g gVar6 = this.imageAdapter;
                    if (((gVar6 == null || (l = gVar6.l()) == null) ? 0 : l.size()) < 9 && (hVar = (lo.h) getMViewBinding()) != null && (operationBarView2 = hVar.m) != null) {
                        operationBarView2.selectItem(0);
                    }
                }
                lo.h hVar2 = (lo.h) getMViewBinding();
                if (hVar2 != null && (operationBarView = hVar2.m) != null) {
                    operationBarView.resetItem();
                }
            }
        }
        FilmReviewActivity activity = getActivity();
        Intrinsics.f(activity, "null cannot be cast to non-null type com.transsion.publish.ui.FilmReviewActivity");
        activity.j0(isPostEnable());
    }

    private final void refreshLink(jo.b it) {
        lo.h hVar;
        OperationBarView operationBarView;
        OperationBarView operationBarView2;
        Integer d2 = it.d();
        if (d2 == null || d2.intValue() != 1) {
            if (d2 == null || d2.intValue() != 2 || (hVar = (lo.h) getMViewBinding()) == null || (operationBarView = hVar.m) == null) {
                return;
            }
            operationBarView.resetItem(true);
            return;
        }
        if (it.f() == null) {
            return;
        }
        lo.h hVar2 = (lo.h) getMViewBinding();
        if (hVar2 != null && (operationBarView2 = hVar2.m) != null) {
            operationBarView2.selectItem(4);
        }
        initManagerAdapter();
        com.transsion.publish.adapter.r rVar = this.managerAdapter;
        if (rVar != null) {
            rVar.J(it.f());
        }
        LinkEntity f = it.f();
        this.linkEntity = new MediaLinkEntity(f != null ? f.getUrl() : null, f != null ? f.getTitle() : null, f != null ? f.getCover() : null);
        LinkEntity f2 = it.f();
        if (f2 == null || !f2.getLoading()) {
            return;
        }
        com.tn.lib.widget.toast.core.h.a.k(R$string.postint_state_added);
    }

    private final void refreshLocation(jo.b it) {
        OperationBarView operationBarView;
        this.locationBean = it.g();
        Integer d2 = it.d();
        if (d2 == null || d2.intValue() != 1) {
            if (d2 != null && d2.intValue() == 2) {
                deleteLocation();
                return;
            }
            return;
        }
        if (it.g() == null) {
            return;
        }
        lo.h hVar = (lo.h) getMViewBinding();
        if (hVar != null && (operationBarView = hVar.m) != null) {
            operationBarView.selectItem(8);
        }
        initManagerAdapter();
        LocationPlace g = it.g();
        if (g != null) {
            g.setType(8);
        }
        com.transsion.publish.adapter.r rVar = this.managerAdapter;
        if (rVar != null) {
            rVar.J(it.g());
        }
    }

    private final void refreshVideo(jo.b it) {
        OperationBarView operationBarView;
        ImageView imageView;
        List l;
        OperationBarView operationBarView2;
        Integer d2 = it.d();
        if (d2 != null && d2.intValue() == 1) {
            if (it.j() == null) {
                return;
            }
            VsMediaInfo j = it.j();
            if ((j != null ? j.getVideoDuration() : 0L) > 600000) {
                com.tn.lib.widget.toast.core.h.a.l(getString(R$string.publish_video_limit));
                return;
            }
            initVideoAdapter();
            ArrayList arrayList = new ArrayList();
            VsMediaInfo j2 = it.j();
            Intrinsics.e(j2);
            arrayList.add(j2);
            com.transsion.publish.adapter.v vVar = this.videoAdapter;
            if (vVar != null) {
                vVar.setData(arrayList);
            }
            lo.h hVar = (lo.h) getMViewBinding();
            if (hVar != null && (operationBarView2 = hVar.m) != null) {
                operationBarView2.selectItem(1);
            }
            com.transsion.publish.adapter.v vVar2 = this.videoAdapter;
            if (((vVar2 == null || (l = vVar2.l()) == null) ? 0 : l.size()) >= 1 && (imageView = this.videoIcon) != null) {
                imageView.postDelayed(new Runnable() { // from class: com.transsion.publish.ui.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        FilmReviewFragment.refreshVideo$lambda$27(FilmReviewFragment.this);
                    }
                }, 200L);
            }
        } else if (d2 != null && d2.intValue() == 2) {
            this.coverPath = null;
            com.transsion.publish.adapter.v vVar3 = this.videoAdapter;
            if (vVar3 != null) {
                vVar3.t();
            }
            lo.h hVar2 = (lo.h) getMViewBinding();
            if (hVar2 != null && (operationBarView = hVar2.m) != null) {
                operationBarView.resetItem();
            }
        }
        FilmReviewActivity activity = getActivity();
        Intrinsics.f(activity, "null cannot be cast to non-null type com.transsion.publish.ui.FilmReviewActivity");
        activity.j0(isPostEnable());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshVideo$lambda$27(FilmReviewFragment filmReviewFragment) {
        ImageView imageView = filmReviewFragment.videoIcon;
        if (imageView != null) {
            imageView.setImageResource(R$drawable.icon_post_video_unable);
        }
    }

    private final void refreshWork(jo.b it) {
        com.transsion.publish.adapter.g gVar;
        com.transsion.publish.adapter.v vVar;
        lo.h hVar;
        OperationBarView operationBarView;
        String str;
        this.mSubject = it.i();
        Integer d2 = it.d();
        if (d2 != null && d2.intValue() == 1) {
            Subject i = it.i();
            if (i != null) {
                setSubject(i);
            }
            HashMap hashMap = new HashMap();
            Subject i2 = it.i();
            if (i2 == null || (str = i2.getSubjectId()) == null) {
                str = BuildConfig.FLAVOR;
            }
            hashMap.put("subject_id", str);
            qi.h.a.o(getPageName(), hashMap);
            return;
        }
        if (d2 == null || d2.intValue() != 2 || (gVar = this.imageAdapter) == null || !gVar.n() || (vVar = this.videoAdapter) == null || !vVar.n() || (hVar = (lo.h) getMViewBinding()) == null || (operationBarView = hVar.m) == null) {
            return;
        }
        operationBarView.resetItem();
    }

    private final void requestCurrentLocation() {
        ep.f mRoomApi;
        FragmentActivity activity = getActivity();
        if (activity == null || !cf.c.a.f(activity, "android.permission.ACCESS_FINE_LOCATION") || (mRoomApi = getMRoomApi()) == null) {
            return;
        }
        mRoomApi.b(activity, new Function1() { // from class: com.transsion.publish.ui.z
            public final Object invoke(Object obj) {
                Unit requestCurrentLocation$lambda$15;
                requestCurrentLocation$lambda$15 = FilmReviewFragment.requestCurrentLocation$lambda$15(FilmReviewFragment.this, (LocationPlace) obj);
                return requestCurrentLocation$lambda$15;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestCurrentLocation$lambda$15(FilmReviewFragment filmReviewFragment, LocationPlace locationPlace) {
        String name = locationPlace != null ? locationPlace.getName() : null;
        if (name == null || name.length() == 0) {
            return Unit.a;
        }
        filmReviewFragment.setLocation(locationPlace);
        return Unit.a;
    }

    private final void selectPhotosDispose(List<PhotoEntity> photoEntity) {
        OperationBarView operationBarView;
        ImageView imageView;
        List l;
        OperationBarView operationBarView2;
        com.transsion.publish.adapter.g gVar;
        List<PhotoEntity> list = photoEntity;
        if (list == null || list.isEmpty()) {
            com.transsion.publish.adapter.g gVar2 = this.imageAdapter;
            if (gVar2 == null) {
                initImageAdapter();
                return;
            }
            if (gVar2 != null) {
                gVar2.u();
            }
            lo.h hVar = (lo.h) getMViewBinding();
            if (hVar == null || (operationBarView = hVar.m) == null) {
                return;
            }
            operationBarView.resetItem();
            return;
        }
        initImageAdapter();
        com.transsion.publish.adapter.g gVar3 = this.imageAdapter;
        if (gVar3 != null) {
            if (photoEntity == null) {
                photoEntity = new ArrayList<>();
            }
            gVar3.setData(photoEntity);
        }
        com.transsion.publish.adapter.g gVar4 = this.imageAdapter;
        if ((gVar4 != null ? gVar4.getItemCount() : 0) < 9 && (gVar = this.imageAdapter) != null) {
            gVar.addData(getAddImageEntity());
        }
        lo.h hVar2 = (lo.h) getMViewBinding();
        if (hVar2 != null && (operationBarView2 = hVar2.m) != null) {
            operationBarView2.selectItem(0);
        }
        com.transsion.publish.adapter.g gVar5 = this.imageAdapter;
        Integer valueOf = (gVar5 == null || (l = gVar5.l()) == null) ? null : Integer.valueOf(l.size());
        Intrinsics.e(valueOf);
        if (valueOf.intValue() < 9 || (imageView = this.imageIcon) == null) {
            return;
        }
        imageView.postDelayed(new Runnable() { // from class: com.transsion.publish.ui.u
            @Override // java.lang.Runnable
            public final void run() {
                FilmReviewFragment.selectPhotosDispose$lambda$26(FilmReviewFragment.this);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void selectPhotosDispose$lambda$26(FilmReviewFragment filmReviewFragment) {
        ImageView imageView = filmReviewFragment.imageIcon;
        if (imageView != null) {
            imageView.setImageResource(R$drawable.icon_post_select_image_unable);
        }
    }

    private final void setGroup(GroupBean groupBean) {
        if (groupBean == null) {
            return;
        }
        initManagerAdapter();
        groupBean.setType(6);
        com.transsion.publish.adapter.r rVar = this.managerAdapter;
        if (rVar != null) {
            rVar.J(groupBean);
        }
    }

    private final void setLocation(LocationPlace location) {
        this.locationBean = location;
        this.curLocationBean = location;
        initManagerAdapter();
        if (location != null) {
            location.setType(8);
        }
        com.transsion.publish.adapter.r rVar = this.managerAdapter;
        if (rVar != null) {
            rVar.J(location);
        }
    }

    private final void setStarTips(int text) {
        TextView textView;
        lo.h hVar = (lo.h) getMViewBinding();
        if (hVar == null || (textView = hVar.v) == null) {
            return;
        }
        textView.setText(text);
    }

    private final void setSubject(Subject subject) {
        if (subject == null) {
            return;
        }
        initManagerAdapter();
        subject.setType(3);
        if (this.sourceType == 1) {
            subject.setCorrelation(true);
        }
        com.transsion.publish.adapter.r rVar = this.managerAdapter;
        if (rVar != null) {
            rVar.J(subject);
        }
    }

    private final void showActivityTips() {
        BubbleTextView bubbleTextView;
        lo.h hVar = (lo.h) getMViewBinding();
        if (hVar == null || (bubbleTextView = hVar.b) == null) {
            return;
        }
        bubbleTextView.postDelayed(new Runnable() { // from class: com.transsion.publish.ui.r
            @Override // java.lang.Runnable
            public final void run() {
                FilmReviewFragment.showActivityTips$lambda$14(FilmReviewFragment.this);
            }
        }, 800L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showActivityTips$lambda$14(final FilmReviewFragment filmReviewFragment) {
        OperationBarView operationBarView;
        RecyclerView rv;
        if (filmReviewFragment.isMoreThanADay(System.currentTimeMillis(), com.transsion.baselib.report.launch.b.a.b().getLong("publish_show_guide_time", 0L))) {
            if (filmReviewFragment.groupBean == null && filmReviewFragment.mSubject == null && filmReviewFragment.locationBean != null) {
                return;
            }
            if (filmReviewFragment.mSubject != null || filmReviewFragment.locationBean == null) {
                final d dVar = filmReviewFragment.new d();
                lo.h hVar = (lo.h) filmReviewFragment.getMViewBinding();
                if (hVar == null || (operationBarView = hVar.m) == null || (rv = operationBarView.getRv()) == null) {
                    return;
                }
                rv.post(new Runnable() { // from class: com.transsion.publish.ui.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        FilmReviewFragment.showActivityTips$lambda$14$lambda$13(FilmReviewFragment.this, dVar);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showActivityTips$lambda$14$lambda$13(FilmReviewFragment filmReviewFragment, d dVar) {
        float f;
        BubbleTextView bubbleTextView;
        OperationBarView operationBarView;
        RecyclerView rv;
        if (!filmReviewFragment.isAdded() || filmReviewFragment.isDetached() || filmReviewFragment.isRemoving()) {
            return;
        }
        String string = filmReviewFragment.getString(R$string.publish_tip_text);
        Intrinsics.g(string, "getString(...)");
        GroupBean groupBean = filmReviewFragment.groupBean;
        int i = 3;
        if (groupBean == null && filmReviewFragment.mSubject == null) {
            string = filmReviewFragment.getString(R$string.publish_tip_text);
            Intrinsics.g(string, "getString(...)");
            f = 30.0f;
        } else {
            if (filmReviewFragment.mSubject == null) {
                string = filmReviewFragment.getString(R$string.publish_tip_text_no_subject);
                Intrinsics.g(string, "getString(...)");
            } else if (groupBean == null) {
                string = filmReviewFragment.getString(R$string.publish_tip_text_no_group);
                Intrinsics.g(string, "getString(...)");
                i = 2;
            } else {
                f = 0.0f;
                i = 0;
            }
            f = 6.0f;
        }
        lo.h hVar = (lo.h) filmReviewFragment.getMViewBinding();
        View childAt = (hVar == null || (operationBarView = hVar.m) == null || (rv = operationBarView.getRv()) == null) ? null : rv.getChildAt(i);
        int[] iArr = new int[2];
        if (childAt != null) {
            childAt.getLocationOnScreen(iArr);
        }
        lo.h hVar2 = (lo.h) filmReviewFragment.getMViewBinding();
        if (hVar2 == null || (bubbleTextView = hVar2.b) == null) {
            return;
        }
        dVar.start();
        bubbleTextView.setVisibility(0);
        com.transsion.baselib.report.launch.b.a.b().putLong("publish_show_guide_time", System.currentTimeMillis());
        bubbleTextView.setText(string);
        int i2 = iArr[0];
        zg.h hVar3 = zg.h.a;
        Intrinsics.g(bubbleTextView.getContext(), "getContext(...)");
        bubbleTextView.setArrowPosition(i2 + hVar3.a(r2, f));
    }

    private final void showLinkEditInputDialog(Context context) {
        clickTrace("url");
        b.a aVar = new b.a(context);
        lo.h hVar = (lo.h) getMViewBinding();
        androidx.appcompat.app.w a = aVar.a(this, hVar != null ? hVar.p : null);
        a.show();
        a.setCancelable(true);
        a.setCanceledOnTouchOutside(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startLocation$lambda$33(Context context, FilmReviewFragment filmReviewFragment, boolean z) {
        if (z) {
            Intent intent = new Intent(context, (Class<?>) SelectLocationActivity.class);
            LocationPlace locationPlace = filmReviewFragment.curLocationBean;
            if (locationPlace != null) {
                intent.putExtra("location_data", locationPlace);
            }
            intent.setFlags(268435456);
            context.startActivity(intent);
        }
        return Unit.a;
    }

    private final void userGrade() {
        com.transsion.publish.adapter.r rVar;
        com.transsion.publish.adapter.g gVar;
        com.transsion.publish.adapter.v vVar;
        RatingBar ratingBar;
        EditText editText;
        Editable text;
        this.publishType = 2;
        lo.h hVar = (lo.h) getMViewBinding();
        Float f = null;
        if (TextUtils.isEmpty((hVar == null || (editText = hVar.c) == null || (text = editText.getText()) == null) ? null : StringsKt.n1(text)) && (rVar = this.managerAdapter) != null && rVar.B() && (((gVar = this.imageAdapter) == null || (gVar != null && gVar.n())) && ((vVar = this.videoAdapter) == null || (vVar != null && vVar.n())))) {
            lo.h hVar2 = (lo.h) getMViewBinding();
            if (hVar2 != null && (ratingBar = hVar2.n) != null) {
                f = Float.valueOf(ratingBar.getRating());
            }
            Intrinsics.e(f);
            if (f.floatValue() > 0.0f && this.coverPath == null) {
                postService(buildRequest(), 2);
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    activity.finish();
                    return;
                }
                return;
            }
        }
        if (checkLogin()) {
            postService(buildRequest(), 2);
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
            }
        }
    }

    private final void userPost() {
        this.publishType = 1;
        if (checkLogin()) {
            postService(buildRequest(), 1);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    public final void checkPost() {
        String w;
        if (!yg.l.a.e()) {
            com.tn.lib.widget.toast.core.h.a.k(com.transsion.baseui.R.string.base_network_fail);
            return;
        }
        clickPostTrace();
        KeyboardUtils.d(requireActivity());
        com.transsion.publish.adapter.r rVar = this.managerAdapter;
        if (rVar != null && (w = rVar.w()) != null) {
            gx.b.a.a().i(1, w);
        }
        int i = this.sourceType;
        if (i == 1) {
            userGrade();
        } else {
            if (i != 2) {
                return;
            }
            userPost();
        }
    }

    public final void closeAffirm() {
        EditText editText;
        Editable text;
        lo.h hVar = (lo.h) getMViewBinding();
        boolean isEmpty = TextUtils.isEmpty((hVar == null || (editText = hVar.c) == null || (text = editText.getText()) == null) ? null : StringsKt.n1(text));
        com.transsion.publish.adapter.r rVar = this.managerAdapter;
        boolean z = (rVar == null || rVar.A()) ? false : true;
        com.transsion.publish.adapter.g gVar = this.imageAdapter;
        boolean z2 = (gVar == null || gVar.n()) ? false : true;
        com.transsion.publish.adapter.v vVar = this.videoAdapter;
        boolean z3 = (vVar == null || vVar.n()) ? false : true;
        if (!isEmpty || z || z2 || z3) {
            backSaveDialog();
            return;
        }
        KeyboardUtils.d(requireActivity());
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // mo.b.InterfaceC0085b
    public void completeLoad() {
        lo.h hVar;
        OperationBarView operationBarView;
        OperationBarView operationBarView2;
        lo.h hVar2 = (lo.h) getMViewBinding();
        if ((hVar2 != null && (operationBarView2 = hVar2.m) != null && operationBarView2.getVisibility() == 0) || (hVar = (lo.h) getMViewBinding()) == null || (operationBarView = hVar.m) == null) {
            return;
        }
        uf.c.k(operationBarView);
    }

    public lo.h getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        lo.h c2 = lo.h.c(inflater);
        Intrinsics.g(c2, "inflate(...)");
        return c2;
    }

    public void initView(View view, Bundle savedInstanceState) {
        RelativeLayout relativeLayout;
        RatingBar ratingBar;
        TextView textView;
        RatingBar ratingBar2;
        ObservableScrollView observableScrollView;
        EditText editText;
        EditText editText2;
        EditText editText3;
        EditText editText4;
        EditText editText5;
        EditText editText6;
        EditText editText7;
        OperationBarView operationBarView;
        OperationBarView operationBarView2;
        RelativeLayout relativeLayout2;
        RelativeLayout relativeLayout3;
        RatingBar ratingBar3;
        TextView textView2;
        Intrinsics.h(view, "view");
        int i = this.sourceType;
        if (i == 1) {
            lo.h hVar = (lo.h) getMViewBinding();
            if (hVar != null && (ratingBar2 = hVar.n) != null) {
                ratingBar2.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() { // from class: com.transsion.publish.ui.a0
                    @Override // android.widget.RatingBar.OnRatingBarChangeListener
                    public final void onRatingChanged(RatingBar ratingBar4, float f, boolean z) {
                        FilmReviewFragment.initView$lambda$3(FilmReviewFragment.this, ratingBar4, f, z);
                    }
                });
            }
            lo.h hVar2 = (lo.h) getMViewBinding();
            if (hVar2 != null && (textView = hVar2.u) != null) {
                textView.setVisibility(0);
            }
            lo.h hVar3 = (lo.h) getMViewBinding();
            if (hVar3 != null && (ratingBar = hVar3.n) != null) {
                ratingBar.setVisibility(0);
            }
            lo.h hVar4 = (lo.h) getMViewBinding();
            if (hVar4 != null && (relativeLayout = hVar4.q) != null) {
                relativeLayout.setVisibility(0);
            }
        } else if (i == 2) {
            lo.h hVar5 = (lo.h) getMViewBinding();
            if (hVar5 != null && (textView2 = hVar5.u) != null) {
                textView2.setVisibility(8);
            }
            lo.h hVar6 = (lo.h) getMViewBinding();
            if (hVar6 != null && (ratingBar3 = hVar6.n) != null) {
                ratingBar3.setVisibility(8);
            }
            lo.h hVar7 = (lo.h) getMViewBinding();
            if (hVar7 != null && (relativeLayout3 = hVar7.q) != null) {
                relativeLayout3.setVisibility(8);
            }
            lo.h hVar8 = (lo.h) getMViewBinding();
            if (hVar8 != null && (relativeLayout2 = hVar8.o) != null) {
                relativeLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.ui.b0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        FilmReviewFragment.initView$lambda$4(FilmReviewFragment.this, view2);
                    }
                });
            }
        }
        lo.h hVar9 = (lo.h) getMViewBinding();
        if (hVar9 != null && (operationBarView2 = hVar9.m) != null) {
            operationBarView2.setClickListener(this);
        }
        lo.h hVar10 = (lo.h) getMViewBinding();
        if (hVar10 != null && (operationBarView = hVar10.m) != null) {
            operationBarView.init(this.sourceType, this.groupBean, this.mSubject);
        }
        this.loginLaunch = registerForActivityResult(new f.j(), new androidx.activity.result.a() { // from class: com.transsion.publish.ui.c0
            public final void a(Object obj) {
                FilmReviewFragment.initView$lambda$5(FilmReviewFragment.this, (ActivityResult) obj);
            }
        });
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        lo.h hVar11 = (lo.h) getMViewBinding();
        Typeface typeface = null;
        objectRef.element = Typeface.create((hVar11 == null || (editText7 = hVar11.d) == null) ? null : editText7.getTypeface(), 1);
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        lo.h hVar12 = (lo.h) getMViewBinding();
        if (hVar12 != null && (editText6 = hVar12.d) != null) {
            typeface = editText6.getTypeface();
        }
        objectRef2.element = Typeface.create(typeface, 0);
        lo.h hVar13 = (lo.h) getMViewBinding();
        if (hVar13 != null && (editText5 = hVar13.d) != null) {
            editText5.addTextChangedListener(new b(objectRef, objectRef2));
        }
        lo.h hVar14 = (lo.h) getMViewBinding();
        if (hVar14 != null && (editText4 = hVar14.d) != null) {
            editText4.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.transsion.publish.ui.d0
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view2, boolean z) {
                    FilmReviewFragment.initView$lambda$6(FilmReviewFragment.this, view2, z);
                }
            });
        }
        lo.h hVar15 = (lo.h) getMViewBinding();
        if (hVar15 != null && (editText3 = hVar15.c) != null) {
            editText3.addTextChangedListener(new c());
        }
        lo.h hVar16 = (lo.h) getMViewBinding();
        if (hVar16 != null && (editText2 = hVar16.c) != null) {
            editText2.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.transsion.publish.ui.i
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view2, boolean z) {
                    FilmReviewFragment.initView$lambda$8(FilmReviewFragment.this, view2, z);
                }
            });
        }
        lo.h hVar17 = (lo.h) getMViewBinding();
        if (hVar17 != null && (editText = hVar17.c) != null) {
            editText.postDelayed(this.mRunnable, 500L);
        }
        lo.h hVar18 = (lo.h) getMViewBinding();
        if (hVar18 != null && (observableScrollView = hVar18.t) != null) {
            observableScrollView.setScrollListener(new ObservableScrollView.a() { // from class: com.transsion.publish.ui.j
                @Override // com.transsion.publish.view.ObservableScrollView.a
                public final void a(int i2) {
                    FilmReviewFragment.initView$lambda$9(i2);
                }
            });
        }
        requestCurrentLocation();
        showActivityTips();
        getVideoIconView();
        getImageIconView();
    }

    public final boolean isPostEnable() {
        com.transsion.publish.adapter.v vVar;
        lo.h hVar;
        EditText editText;
        Editable text;
        com.transsion.publish.adapter.g gVar = this.imageAdapter;
        return ((gVar == null || gVar.n()) && ((vVar = this.videoAdapter) == null || vVar.n()) && ((hVar = (lo.h) getMViewBinding()) == null || (editText = hVar.c) == null || (text = editText.getText()) == null || text.length() == 0)) ? false : true;
    }

    public void lazyLoadData() {
    }

    public qi.b newLogViewConfig() {
        return new qi.b(PAGE_NAME, false, 2, null);
    }

    public void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        com.transsion.publish.adapter.r rVar = this.managerAdapter;
        if (rVar != null) {
            rVar.u();
        }
        MMKV I = MMKV.I("kv_link_record");
        Intrinsics.g(I, "mmkvWithID(...)");
        I.putString("link", BuildConfig.FLAVOR);
        a.a.f(wf.a.a, this.TAG, "FilmReviewFragment onDestroy", false, 4, (Object) null);
    }

    public void onLeftButtonClick(TRDialog dialog) {
        Intrinsics.h(dialog, "dialog");
    }

    public void onPause() {
        super.onPause();
        System.currentTimeMillis();
    }

    public void onResume() {
        super.onResume();
    }

    public void onRightButtonClick(TRDialog dialog) {
        FragmentActivity activity;
        Intrinsics.h(dialog, "dialog");
        String tag = dialog.getTag();
        if (tag != null) {
            int hashCode = tag.hashCode();
            if (hashCode == -1257717947) {
                if (tag.equals("clear_cover")) {
                    deleteAudio();
                }
            } else if (hashCode == 1335127509 && tag.equals("back_save") && (activity = getActivity()) != null) {
                activity.finish();
            }
        }
    }

    public void onStop() {
        super/*androidx.fragment.app.Fragment*/.onStop();
        com.transsion.publish.adapter.r rVar = this.managerAdapter;
        if (rVar != null) {
            rVar.H();
        }
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        Bundle arguments = getArguments();
        Integer valueOf = arguments != null ? Integer.valueOf(arguments.getInt("sourceType", 2)) : null;
        Intrinsics.e(valueOf);
        this.sourceType = valueOf.intValue();
        Bundle arguments2 = getArguments();
        Integer valueOf2 = arguments2 != null ? Integer.valueOf(arguments2.getInt("sourceMode", 0)) : null;
        Intrinsics.e(valueOf2);
        this.sourceMode = valueOf2.intValue();
        Bundle arguments3 = getArguments();
        if (arguments3 != null && arguments3.containsKey("subject")) {
            Bundle arguments4 = getArguments();
            Serializable serializable = arguments4 != null ? arguments4.getSerializable("subject") : null;
            if (serializable != null && (serializable instanceof Subject)) {
                this.mSubject = (Subject) serializable;
            }
        }
        Bundle arguments5 = getArguments();
        if (arguments5 != null && arguments5.containsKey("group")) {
            Bundle arguments6 = getArguments();
            Serializable serializable2 = arguments6 != null ? arguments6.getSerializable("group") : null;
            if (serializable2 != null && (serializable2 instanceof GroupBean)) {
                this.groupBean = (GroupBean) serializable2;
            }
        }
        super.onViewCreated(view, savedInstanceState);
        initViewModel();
        initRegisterMediaSelector();
        this.showTime = System.currentTimeMillis();
        a.a.f(wf.a.a, this.TAG, "FilmReviewFragment onViewCreated", false, 4, (Object) null);
    }

    @Override // com.transsion.publish.adapter.a
    public void put(Context context) {
        EditText editText;
        Intrinsics.h(context, "context");
        lo.h hVar = (lo.h) getMViewBinding();
        if (hVar == null || (editText = hVar.c) == null) {
            return;
        }
        KeyboardUtils.e(editText);
    }

    @Override // com.transsion.publish.adapter.a
    public void startAudio(Context context) {
        Intrinsics.h(context, "context");
        clickTrace("audio");
        SelectMusicActivity.INSTANCE.a(context);
    }

    @Override // com.transsion.publish.adapter.a
    public void startGroup(Context context) {
        Intrinsics.h(context, "context");
        openRoomList();
    }

    @Override // com.transsion.publish.adapter.a
    public void startLink(Context context) {
        OperationVerticalBarView operationVerticalBarView;
        EditText editText;
        OperationBarView operationBarView;
        Intrinsics.h(context, "context");
        lo.h hVar = (lo.h) getMViewBinding();
        if (hVar == null || (operationVerticalBarView = hVar.l) == null || operationVerticalBarView.getVisibility() != 0) {
            showLinkEditInputDialog(context);
            return;
        }
        lo.h hVar2 = (lo.h) getMViewBinding();
        if (hVar2 != null && (operationBarView = hVar2.m) != null) {
            uf.c.g(operationBarView);
        }
        hideOpertaionDialog();
        showLinkEditInputDialog(context);
        lo.h hVar3 = (lo.h) getMViewBinding();
        if (hVar3 == null || (editText = hVar3.c) == null) {
            return;
        }
        editText.postDelayed(new Runnable() { // from class: com.transsion.publish.ui.y
            @Override // java.lang.Runnable
            public final void run() {
                FilmReviewFragment.this.completeLoad();
            }
        }, 2000L);
    }

    @Override // com.transsion.publish.adapter.a
    public void startLocation(final Context context) {
        Intrinsics.h(context, "context");
        FragmentActivity activity = getActivity();
        if (activity == null || !isAdded() || isDetached() || isRemoving()) {
            return;
        }
        if (!cf.c.a.f(activity, "android.permission.ACCESS_FINE_LOCATION")) {
            ep.f mRoomApi = getMRoomApi();
            if (mRoomApi != null) {
                mRoomApi.a(activity, true, new Function1() { // from class: com.transsion.publish.ui.q
                    public final Object invoke(Object obj) {
                        Unit startLocation$lambda$33;
                        startLocation$lambda$33 = FilmReviewFragment.startLocation$lambda$33(context, this, ((Boolean) obj).booleanValue());
                        return startLocation$lambda$33;
                    }
                });
                return;
            }
            return;
        }
        Intent intent = new Intent(context, (Class<?>) SelectLocationActivity.class);
        LocationPlace locationPlace = this.curLocationBean;
        if (locationPlace != null) {
            intent.putExtra("location_data", locationPlace);
        }
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    @Override // com.transsion.publish.adapter.a
    public void startPhoto(Context context) {
        List l;
        String str;
        List l2;
        Intrinsics.h(context, "context");
        com.transsion.publish.adapter.g gVar = this.imageAdapter;
        if (((gVar == null || (l2 = gVar.l()) == null) ? 0 : l2.size()) < 9) {
            clickTrace("image");
            SelectImageActivity.Companion companion = SelectImageActivity.INSTANCE;
            com.transsion.publish.adapter.g gVar2 = this.imageAdapter;
            companion.a(context, 0, 9 - ((gVar2 == null || (l = gVar2.l()) == null) ? 0 : l.size()), new ArrayList());
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity == null || (str = activity.getString(R$string.add_img_max_tips)) == null) {
            str = BuildConfig.FLAVOR;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String format = String.format(str, Arrays.copyOf(new Object[]{9}, 1));
        Intrinsics.g(format, "format(...)");
        com.tn.lib.widget.toast.core.h.a.l(format);
    }

    @Override // com.transsion.publish.adapter.a
    public void startVideo(Context context) {
        String str;
        List l;
        Intrinsics.h(context, "context");
        com.transsion.publish.adapter.v vVar = this.videoAdapter;
        if (((vVar == null || (l = vVar.l()) == null) ? 0 : l.size()) >= 1) {
            FragmentActivity activity = getActivity();
            if (activity == null || (str = activity.getString(R$string.add_video_max_tips)) == null) {
                str = BuildConfig.FLAVOR;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.a;
            String format = String.format(str, Arrays.copyOf(new Object[]{1}, 1));
            Intrinsics.g(format, "format(...)");
            com.tn.lib.widget.toast.core.h.a.l(format);
            return;
        }
        clickTrace("vidio");
        if (this.underOS33) {
            Intent intent = new Intent(context, (Class<?>) SelectVideoActivity.class);
            intent.setFlags(268435456);
            startActivity(intent);
        } else {
            androidx.activity.result.b bVar = this.videoSelectLauncher;
            if (bVar != null) {
                bVar.a(androidx.activity.result.f.b(g.e.a, 0, false, (g.b) null, 14, (Object) null));
            }
        }
    }

    @Override // com.transsion.publish.adapter.a
    public void startWork(Context context) {
        Intrinsics.h(context, "context");
        clickTrace("choose a subject");
        gj.b bVar = (gj.b) gj.a.a.a(gj.b.class);
        if (bVar != null) {
            Context requireContext = requireContext();
            Intrinsics.g(requireContext, "requireContext(...)");
            bVar.e(requireContext);
        }
    }
}
