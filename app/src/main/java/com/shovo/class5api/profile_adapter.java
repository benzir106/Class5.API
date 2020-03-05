package com.shovo.class5api;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class profile_adapter extends RecyclerView.Adapter<profile_adapter.ExampleviewHolder> {

    private ArrayList<profileModel> profileModels;

    private Context mContext;
    public profile_adapter(Context context, ArrayList<profileModel>profileModelArrayList){
        mContext=context;
        profileModels=profileModelArrayList;

    }

    @NonNull
    @Override
    public profile_adapter.ExampleviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.activity_profile, parent, false);

        return new  profile_adapter.ExampleviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleviewHolder holder, int position) {
        profileModel currentItem=profileModels.get(position);

        String email =currentItem.getEmail();
        String firstname =currentItem.getFirst_name();
        String lastname=currentItem.getLast_name();
        String avater=currentItem.getAvart();

        holder.emailText.setText(email);
        holder.nameText.setText(firstname+" " +lastname);
        Picasso.get().load(avater).into(holder.Avatar);

    }

    @Override
    public int getItemCount() {
        return profileModels.size();
    }
    public class ExampleviewHolder extends RecyclerView.ViewHolder{


        public CircleImageView Avatar;
        public TextView nameText,emailText;

        public ExampleviewHolder(View view){
            super(view);

            Avatar=view.findViewById(R.id.avaterId);
            nameText=view.findViewById(R.id.nameId);
            emailText=view.findViewById(R.id.emailId);
        }

    }
}
