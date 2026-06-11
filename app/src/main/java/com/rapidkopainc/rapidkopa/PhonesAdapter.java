package com.rapidkopainc.rapidkopa;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PhonesAdapter extends RecyclerView.Adapter<PhonesViewHolder> {

    List<Phones> phonesList;
    Context context;
    ProgressDialog dialog;

    public PhonesAdapter(List<Phones> phonesList, Context context) {
        this.phonesList = phonesList;
        this.context = context;
    }

    @NonNull
    @Override
    public PhonesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PhonesViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_phones, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PhonesViewHolder holder, int position) {
        holder.txtPhoneName.setText(phonesList.get(position).getPhoneName());
        holder.txtHeading.setVisibility(View.GONE);
        int selected =holder.getLayoutPosition();

        if (position==2){


            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.gravity = Gravity.RIGHT;
            holder.txtHeading.setLayoutParams(params);
        }
        if (position==3){


            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.gravity = Gravity.LEFT;
            holder.txtHeading.setLayoutParams(params);
        }
        if (position==10){


            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.gravity = Gravity.RIGHT;
            holder.txtHeading.setLayoutParams(params);
        }
        if (position==11){

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.gravity = Gravity.LEFT;
            holder.txtHeading.setLayoutParams(params);
        }
        if (position==20){


            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.gravity = Gravity.RIGHT;
            holder.txtHeading.setLayoutParams(params);
        }
        if (position==21){

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.gravity = Gravity.LEFT;
            holder.txtHeading.setLayoutParams(params);
        }
        if (position==22){


            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.gravity = Gravity.RIGHT;
            holder.txtHeading.setLayoutParams(params);
        }
        /*if (position==23){
            holder.txtHeading.setVisibility(View.VISIBLE);
            holder.txtHeading.setText("LOANS");
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.gravity = Gravity.LEFT;
            holder.txtHeading.setLayoutParams(params);
        }*/
        holder.cardBg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = ProgressDialog.show(context, CommonConfigs.FLAVOR, "Please Wait...", true);
                dialog.show();
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        dialog.dismiss();

                        Intent intent = new Intent();
                        if (selected == 0) {
                            intent.setClass(context, AboutCompanyScreenActivity.class);
                            context.startActivity(intent);
                        }else if(selected==1){
                            Toast.makeText(context, "Select Any Phone Here", Toast.LENGTH_SHORT).show();
                        }else {
                            intent.putExtra("phoneName", phonesList.get(position).getPhoneName());
                            intent.setClass(context, ProductDetailsScreenActivity.class);
                            context.startActivity(intent);
                        }

                    }
                }, 1500);

            }
        });
    }

    @Override
    public int getItemCount() {
        return phonesList.size();
    }
}
