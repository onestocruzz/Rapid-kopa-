package com.rapidkopainc.rapidkopa;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class PhonesViewHolder extends RecyclerView.ViewHolder {
    TextView txtPhoneName, txtHeading;
    CardView cardBg;

    public PhonesViewHolder(@NonNull View itemView) {
        super(itemView);
        txtPhoneName = itemView.findViewById(R.id.txtPhoneName);
        cardBg = itemView.findViewById(R.id.cardView);
        txtHeading = itemView.findViewById(R.id.txtHeading);
    }
}
