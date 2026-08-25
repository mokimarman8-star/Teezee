package com.transsion.publish;

import android.content.Context;
import android.content.Intent;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.publish.api.GroupBean;
import com.transsion.publish.ui.FilmReviewActivity;
import com.transsion.publish.ui.SelectImageActivity;
import java.io.Serializable;
import jo.a;
import kotlin.jvm.internal.Intrinsics;
import org.mvel2.ast.ASTNode;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class j implements a {
    @Override // jo.a
    public void a(Context context, String str, String str2, String str3) {
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "groupId");
        Intrinsics.h(str2, "groupName");
        Intrinsics.h(str3, "groupImage");
        Intent intent = new Intent(context, (Class<?>) FilmReviewActivity.class);
        intent.setFlags(ASTNode.DEOP);
        intent.putExtra("sourceType", 2);
        GroupBean groupBean = new GroupBean();
        groupBean.setGroupId(str);
        groupBean.setName(str2);
        groupBean.setAvatar(str3);
        intent.putExtra("group", (Serializable) groupBean);
        context.startActivity(intent);
    }

    @Override // jo.a
    public void b(Context context) {
        Intrinsics.h(context, "context");
        Intent intent = new Intent(context, (Class<?>) FilmReviewActivity.class);
        intent.setFlags(ASTNode.DEOP);
        intent.putExtra("sourceType", 2);
        context.startActivity(intent);
    }

    @Override // jo.a
    public void c() {
        PublishManager.Companion.a().reset();
    }

    @Override // jo.a
    public boolean d() {
        return PublishManager.Companion.a().getUploading();
    }

    @Override // jo.a
    public void e(Context context, String str, String str2, String str3, String str4, int i) {
        Subject subject;
        Intent intent;
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "subjectId");
        Intrinsics.h(str2, "cover");
        Intrinsics.h(str3, "title");
        Intrinsics.h(str4, "description");
        Intent intent2 = new Intent(context, (Class<?>) FilmReviewActivity.class);
        intent2.setFlags(ASTNode.DEOP);
        intent2.putExtra("sourceType", 2);
        intent2.putExtra("sourceMode", i);
        Subject subject2 = new Subject(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, null, null, null, null, null, false, false, null, null, 0, false, false, 0L, null, null, 0L, null, 0, false, null, 0, null, null, null, null, null, 0, null, null, null, null, null, -1, 67108863, null);
        if (subject2.getCover() == null) {
            intent = intent2;
            subject = subject2;
            subject.setCover(new Cover(0, 0, 0, str2, "", "", null, null, null, 384, null));
        } else {
            subject = subject2;
            intent = intent2;
            Cover cover = subject.getCover();
            if (cover != null) {
                cover.setUrl(str2);
            }
        }
        subject.setSubjectId(str);
        subject.setTitle(str3);
        subject.setDescription(str4);
        intent.putExtra("subject", subject);
        context.startActivity(intent);
    }

    @Override // jo.a
    public boolean f() {
        return PublishManager.Companion.a().getUploadFail();
    }

    @Override // jo.a
    public void g(Context context, String str, String str2, String str3, String str4, int i) {
        Subject subject;
        Intent intent;
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "subjectId");
        Intrinsics.h(str2, "cover");
        Intrinsics.h(str3, "title");
        Intrinsics.h(str4, "description");
        Intent intent2 = new Intent(context, (Class<?>) FilmReviewActivity.class);
        intent2.setFlags(ASTNode.DEOP);
        intent2.putExtra("sourceType", 1);
        intent2.putExtra("sourceMode", i);
        Subject subject2 = new Subject(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, null, null, null, null, null, false, false, null, null, 0, false, false, 0L, null, null, 0L, null, 0, false, null, 0, null, null, null, null, null, 0, null, null, null, null, null, -1, 67108863, null);
        if (subject2.getCover() == null) {
            intent = intent2;
            subject = subject2;
            subject.setCover(new Cover(0, 0, 0, str2, "", "", null, null, null, 384, null));
        } else {
            subject = subject2;
            intent = intent2;
            Cover cover = subject.getCover();
            if (cover != null) {
                cover.setUrl(str2);
            }
        }
        subject.setSubjectId(str);
        subject.setTitle(str3);
        subject.setDescription(str4);
        intent.putExtra("subject", subject);
        context.startActivity(intent);
    }

    @Override // jo.a
    public Intent h(Context context) {
        Intrinsics.h(context, "context");
        Intent intent = new Intent(context, (Class<?>) SelectImageActivity.class);
        intent.putExtra("key_type", 7);
        return intent;
    }
}
