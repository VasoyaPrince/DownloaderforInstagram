package bane.instadownloader.videodownload;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import bane.instadownloader.videodownload.activity.MainActivity;
import java.util.Map;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "MyFirebaseMsgService";

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Map<String, String> data = remoteMessage.getData();
        if (data.size() > 0) {
            sendNotification(data.get("title"), data.get("message"));
            broadcastNewNotification();
            return;
        }
        sendNotification(remoteMessage.getNotification().getTitle(), remoteMessage.getNotification().getBody());
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String str) {
        Log.d(TAG, "Refreshed token: " + str);
    }

    private void sendNotification(String str, String str2) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(67108864);
        intent.putExtra("Push Notification", str);
        PendingIntent activity = PendingIntent.getActivity(this, 0, intent, 1073741824);
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(getResources().getString(R.string.app_name), getResources().getString(R.string.app_name), 4);
            notificationChannel.enableLights(true);
            notificationChannel.setLockscreenVisibility(1);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        notificationManager.notify(1, new NotificationCompat.Builder(this, getResources().getString(R.string.app_name)).setAutoCancel(true).setSmallIcon(R.mipmap.ic_launcher_foreground).setColor(getResources().getColor(R.color.black)).setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher_foreground)).setDefaults(-1).setPriority(1).setContentTitle(str).setContentText(str2).setChannelId(getResources().getString(R.string.app_name)).setFullScreenIntent(activity, true).build());
    }

    private void broadcastNewNotification() {
        LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent("new_notification"));
    }
}
