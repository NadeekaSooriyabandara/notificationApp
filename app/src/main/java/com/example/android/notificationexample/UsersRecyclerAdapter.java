package com.example.android.notificationexample;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class UsersRecyclerAdapter extends RecyclerView.Adapter<UsersRecyclerAdapter.ViewHolder>{

    private List<Users> usersList;
    private Context context;

    public UsersRecyclerAdapter(Context context, List<Users> usersList) {
        this.usersList = usersList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //holder.user_name_view.setText(usersList.get(position).getName());

        //CircleImageView user_image_view = holder.user_image_view;
        //Glide.with(context).load(usersList.get(position).getImage()).into(user_image_view);

        String user_id = usersList.get(position).userId;
        String user_name = usersList.get(position).getName();
        String message = usersList.get(position).getImage();

        holder.user_name_view.setText(user_name);
        holder.reason_view.setText(message);

        /*holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent(context, SendActivity.class);
                sendIntent.putExtra("user_id", user_id);
                sendIntent.putExtra("user_name", user_name);
                context.startActivity(sendIntent);
            }
        });*/

    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private View mView;
        private CircleImageView user_image_view;
        private TextView user_name_view, vehicles_view, date_view, reason_view;
        private Button confirm_btn, reject_btn;

        public ViewHolder(View itemView) {
            super(itemView);

            mView = itemView;
            user_image_view = mView.findViewById(R.id.user_list_image);
            user_name_view = mView.findViewById(R.id.user_list_name);
            vehicles_view = mView.findViewById(R.id.user_list_vehicles);
            date_view = mView.findViewById(R.id.user_list_date);
            reason_view = mView.findViewById(R.id.user_list_reason);
            confirm_btn = mView.findViewById(R.id.user_list_confirm_btn);
            reject_btn = mView.findViewById(R.id.user_list_reject_btn);

        }
    }
}
