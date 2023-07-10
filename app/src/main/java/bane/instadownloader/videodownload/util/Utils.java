package bane.instadownloader.videodownload.util;

import android.app.Activity;
import android.app.Dialog;
import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import bane.instadownloader.videodownload.R;
import java.io.File;

public class Utils {
    public static String RootDirectoryInsta = "/StatusSaver/Insta/";
    public static File RootDirectoryInstaShow = new File(Environment.getExternalStorageDirectory() + "/Download/StatusSaver/Insta");
    public static File RootDirectoryWhatsappShow = new File(Environment.getExternalStorageDirectory() + "/Download/StatusSaver/WhatsApp");
    private static Context context;
    public static Dialog customDialog;

    public Utils(Context context2) {
        context = context2;
    }

    public static void setToast(Context context2, String str) {
        Toast makeText = Toast.makeText(context2, str, 0);
        makeText.setGravity(17, 0, 0);
        makeText.show();
    }

    public static void createFileFolder() {
        if (!RootDirectoryInstaShow.exists()) {
            RootDirectoryInstaShow.mkdirs();
        }
        if (!RootDirectoryWhatsappShow.exists()) {
            RootDirectoryWhatsappShow.mkdirs();
        }
    }

    public static void  showProgressDialog(Activity activity) {
        System.out.println("Show");
        Dialog dialog = customDialog;
        if (dialog != null) {
            dialog.dismiss();
            customDialog = null;
        }
        customDialog = new Dialog(activity);
        View inflate = LayoutInflater.from(activity).inflate(R.layout.progress_dialog, (ViewGroup) null);
        customDialog.setCancelable(false);
        customDialog.setContentView(inflate);
        if (!customDialog.isShowing() && !activity.isFinishing()) {
            customDialog.show();
        }
    }

    public static void hideProgressDialog(Activity activity) {
        System.out.println("Hide");
        Dialog dialog = customDialog;
        if (dialog != null && dialog.isShowing()) {
            customDialog.dismiss();
        }
    }

    public boolean isNetworkAvailable() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static void startDownload(String str, String str2, Context context2, String str3) {
        setToast(context2, "Download Started");
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
        request.setAllowedNetworkTypes(3);
        request.setNotificationVisibility(1);
        request.setTitle(str3 + "");
        request.setVisibleInDownloadsUi(true);
        String str4 = Environment.DIRECTORY_DOWNLOADS;
        request.setDestinationInExternalPublicDir(str4, str2 + str3);
        ((DownloadManager) context2.getSystemService("download")).enqueue(request);
        try {
            MediaScannerConnection.scanFile(context2, new String[]{new File(Environment.DIRECTORY_DOWNLOADS + "/" + str2 + str3).getAbsolutePath()}, null, new MediaScannerConnection.OnScanCompletedListener() {
                /* class bane.instadownloader.videodownload.util.Utils.AnonymousClass1 */

                public void onScanCompleted(String str, Uri uri) {
                }
            });
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void shareImage(Context context2, String str) {
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.TEXT", context2.getResources().getString(R.string.share_txt));
            intent.putExtra("android.intent.extra.STREAM", Uri.parse(MediaStore.Images.Media.insertImage(context2.getContentResolver(), str, "", (String) null)));
            intent.setType("image/*");
            context2.startActivity(Intent.createChooser(intent, context2.getResources().getString(R.string.share_image_via)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void shareImageVideoOnWhatsapp(Context context2, String str, boolean z) {
        Uri parse = Uri.parse(str);
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.setPackage("com.whatsapp");
        intent.putExtra("android.intent.extra.TEXT", "");
        intent.putExtra("android.intent.extra.STREAM", parse);
        if (z) {
            intent.setType("video/*");
        } else {
            intent.setType("image/*");
        }
        intent.addFlags(1);
        try {
            context2.startActivity(intent);
        } catch (Exception unused) {
            setToast(context2, "Whtasapp not installed.");
        }
    }

    public static void shareVideo(Context context2, String str) {
        Uri parse = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("video/mp4");
        intent.putExtra("android.intent.extra.STREAM", parse);
        intent.addFlags(1);
        try {
            context2.startActivity(Intent.createChooser(intent, "Share Video using"));
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(context2, "No application found to open this file.", 1).show();
        }
    }

    public static void RateApp(Context context2) {
        String packageName = context2.getPackageName();
        try {
            context2.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + packageName)));
        } catch (ActivityNotFoundException unused) {
            context2.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=" + packageName)));
        }
    }

    public static void MoreApp(Context context2) {
        String packageName = context2.getPackageName();
        try {
            context2.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + packageName)));
        } catch (ActivityNotFoundException unused) {
            context2.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=" + packageName)));
        }
    }

    public static void ShareApp(Context context2) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.SUBJECT", context2.getString(R.string.app_name));
        intent.putExtra("android.intent.extra.TEXT", context2.getString(R.string.share_app_message) + ("\nhttps://play.google.com/store/apps/details?id=" + context2.getPackageName()));
        intent.setType("text/plain");
        context2.startActivity(Intent.createChooser(intent, "Share"));
    }

    public static void OpenApp(Context context2, String str) {
        Intent launchIntentForPackage = context2.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage != null) {
            context2.startActivity(launchIntentForPackage);
        } else {
            setToast(context2, "App Not Available.");
        }
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.length() == 0 || str.equalsIgnoreCase("null") || str.equalsIgnoreCase("0");
    }
}
