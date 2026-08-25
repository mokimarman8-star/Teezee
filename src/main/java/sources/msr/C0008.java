package msr;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.Html;

/* renamed from: msr.ରାଧେକୃଷ୍ଣ, reason: contains not printable characters */
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class C0008 {
    private static int showTime = 2;

    /* renamed from: msr.ରାଧେକୃଷ୍ଣ$a */
    public class a implements DialogInterface.OnClickListener {
        Context context;
        private final C0008 this$0;

        a(C0008 c0008, Context context) {
            this.this$0 = c0008;
            this.context = context;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.context.startActivity(new Intent("android.intent.action.VIEW").setData(Uri.parse("https://msrofficial.github.io/")));
            dialogInterface.dismiss();
        }
    }

    /* renamed from: msr.ରାଧେକୃଷ୍ଣ$b */
    class b implements DialogInterface.OnClickListener {
        Context context;
        private final C0008 this$0;

        b(C0008 c0008, Context context) {
            this.this$0 = c0008;
            this.context = context;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.context.startActivity(new Intent("android.intent.action.VIEW").setData(Uri.parse("https://t.me/msrpatch")));
            dialogInterface.dismiss();
        }
    }

    public static void Mod(Context context) {
        if (context.getSharedPreferences("", 0).getInt("msr_sakibur", 0) != showTime) {
            context.getSharedPreferences("", 0).edit().putInt("msr_sakibur", context.getSharedPreferences("", 0).getInt("msr_sakibur", 0) + 1).commit();
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(Html.fromHtml("<font color= #FFFFFF>Mod By MD Sakibur Rahman</font>"));
            builder.setMessage(Html.fromHtml("<font color= #FFFFFF>As this is a mod APK, Google account login is not supported. Please use email to sign up or sign in instead.</font>"));
            builder.setPositiveButton(Html.fromHtml("<font color= #81D4FA>Contact</font>"), new a(new C0008(), context));
            builder.setNeutralButton(Html.fromHtml("<font color= #81D4FA>Telegram Channel</font>"), new b(new C0008(), context));
            builder.setNegativeButton(Html.fromHtml("<font color= #FF5252>Close</font>"), (DialogInterface.OnClickListener) null);
            int parseColor = Color.parseColor("#CEF87E");
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(Color.parseColor("#CC000000"));
            gradientDrawable.setStroke(0, parseColor);
            gradientDrawable.setCornerRadius(25);
            AlertDialog create = builder.create();
            create.getWindow().setBackgroundDrawable(gradientDrawable);
            create.setCancelable(false);
            create.show();
        }
    }
}
