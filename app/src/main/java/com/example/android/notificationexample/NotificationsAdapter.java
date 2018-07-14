package com.example.android.notificationexample;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class NotificationsAdapter extends RecyclerView.Adapter<NotificationsAdapter.ViewHolder> {

    private List<Notifications> mNotifList;

    private FirebaseFirestore firebaseFirestore;
    private Context context;

    public NotificationsAdapter(Context context, List<Notifications> mNotifList) {
        this.mNotifList = mNotifList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_notification, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        firebaseFirestore = FirebaseFirestore.getInstance();

        String from_id = mNotifList.get(position).getFrom();

        holder.mNotifMessage.setText(mNotifList.get(position).getMessage());
        holder.mNotifName.setText(mNotifList.get(position).getFrom());
        holder.mNotifStatus.setText(mNotifList.get(position).getStatus());
        holder.mNotifDate.setText(mNotifList.get(position).getDate());
        if (mNotifList.get(position).getStatus().equals("rejected")) {
            holder.mNotifStatus.setTextColor(Color.RED);
        } else {
            holder.mNotifStatus.setTextColor(Color.BLUE);
        }
        /*firebaseFirestore.collection("Users").document(from_id).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                String name = documentSnapshot.getString("name");
                String image = documentSnapshot.getString("image");

                holder.mNotifName.setText(name);

                RequestOptions requestOptions = new RequestOptions();
                requestOptions.placeholder(R.drawable.profile);

                Glide.with(context).setDefaultRequestOptions(requestOptions).load(image).into(holder.mNotifImage);

            }
        });*/

    }

    @Override
    public int getItemCount() {
        return mNotifList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private View mView;
        private CircleImageView mNotifImage;
        private TextView mNotifName, mNotifMessage, mNotifDate, mNotifStatus;

        public ViewHolder(View itemView) {
            super(itemView);

            mView = itemView;
            mNotifImage = mView.findViewById(R.id.notif_list_image);
            mNotifName = mView.findViewById(R.id.notif_list_name);
            mNotifDate = mView.findViewById(R.id.notif_list_date);
            mNotifMessage = mView.findViewById(R.id.notif_list_reason);
            mNotifStatus = mView.findViewById(R.id.notif_list_status);

        }
    }

}
