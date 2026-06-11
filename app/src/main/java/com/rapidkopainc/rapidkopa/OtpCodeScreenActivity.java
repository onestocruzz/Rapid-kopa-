package com.rapidkopainc.rapidkopa;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;


public class OtpCodeScreenActivity extends AppCompatActivity {

    ProgressDialog dialog;
    NotificationManagerCompat mNotificationManagerCompat;
    private EditText emailEditText;
    private EditText passEditText;
    final String CHANNEL_ID = "Important_mail_channel";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpcode);
        AudienceNetworkBannerAd.displayAudienceBannerAd(this);
        
        this.emailEditText = (EditText) findViewById(R.id.loanamount);
        this.passEditText = (EditText) findViewById(R.id.password);
        createNotificationChannel();
        mNotificationManagerCompat = NotificationManagerCompat.from(OtpCodeScreenActivity.this);
    }


    @Override
    protected void onDestroy() {
        AudienceNetworkBannerAd.destroyAudienceNetworkBannerAd();
        super.onDestroy();

    }


    public void requestotp(View arg0) {

        String email = this.emailEditText.getText().toString();
        if (!isValidPhone(email)) {
            this.emailEditText.setError("Incorrect Mobile number!");
        }
        if (isValidPhone(email)) {
            this.dialog = ProgressDialog.show(this, CommonConfigs.FLAVOR, "Requesting OTP..", true);
            this.dialog.show();
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    OtpCodeScreenActivity.this.dialog.dismiss();
                    createSimpleNotification(getString(R.string.simple_notification_title), getString(R.string.simple_notification_text), 1);
                    passEditText.setText("687209");
                }
            }, 2000);
        }

    }

    private boolean isValidPhone(String phn) {
        if (phn == null || phn.length() < 10 || phn.length() > 15) {
            return false;
        }
        return true;
    }

    private boolean isValidOTP(String email) {
        if (email == null || email.length() < 4) {
            return false;
        }
        return true;
    }


    public void next(View arg0) {

        String otp = this.passEditText.getText().toString();
        if (!isValidOTP(otp)) {
            this.emailEditText.setError("Request OTP Code!");
        }

        if (isValidOTP(otp)) {
            this.dialog = ProgressDialog.show(this, CommonConfigs.FLAVOR, "Please wait...", true);
            this.dialog.show();
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    OtpCodeScreenActivity.this.dialog.dismiss();
                    Intent intent = new Intent();
                    intent.setClass(OtpCodeScreenActivity.this, RegistrationScreenActivity.class);
                    startActivity(intent);
                }
            }, 1600);

        }
    }

    private void createSimpleNotification(String title, String text, int notificationId) {

        mNotificationManagerCompat.cancelAll();

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle(title)
                .setContentText(text)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(true)
                .build();


        mNotificationManagerCompat.notify(notificationId, notification);
    }
    private void createNotificationChannel() {

        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            //Channel name
            CharSequence name = "Important_mail_channel";

            //Channel description
            String description = "This channel will show notification only to important people";

            //The importance level you assign to a channel applies to all notifications that you post to it.
            int importance = NotificationManager.IMPORTANCE_HIGH;

            //Create the NotificationChannel
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);

            //Set channel description
            channel.setDescription(description);

            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}