package com.example.user.retrofitdemo.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.retrofitdemo.NoticeBoardDetails;
import com.example.user.retrofitdemo.R;
import com.example.user.retrofitdemo.modelDatas.Noticeboard;


import java.util.ArrayList;

/**
 * Created by User on 12/17/2016.
 */

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.ViewHolder> {

    ArrayList<Noticeboard> noticeModelsList = new ArrayList<Noticeboard>();
    Context context;
    public NoticeAdapter(ArrayList<Noticeboard> noticeModelsList, Context context){
        this.noticeModelsList = noticeModelsList;
        this.context = context;
    }

    @Override
    public NoticeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.notice_lists, parent, false);
        ViewHolder pvh = new ViewHolder(v);
        return pvh;
    }


    @Override
    public void onBindViewHolder(NoticeAdapter.ViewHolder holder, int position) {
        Noticeboard noticeModel = noticeModelsList.get(position);
        if (noticeModelsList.size()==0){
            Toast.makeText(context, "Empty Array", Toast.LENGTH_SHORT).show();
        }
        else if (noticeModelsList.size()>0){
            Toast.makeText(context, noticeModelsList.get(position).getNoticeDescription()+"", Toast.LENGTH_SHORT).show();
        }
        holder.noticeboardName.setText(noticeModel.getNoticeName());



//       holder.noticeboardDescription.setText(noticeModel.getNoticeSummary());
    }

    @Override
    public int getItemCount() {
        return noticeModelsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView noticeboardName,noticeboardDescription;
        private CardView notice_cardview;
        View view;
        public ViewHolder(View itemView) {
            super(itemView);
            noticeboardName = (TextView) itemView.findViewById(R.id.noticeboardName);
            notice_cardview = (CardView) itemView.findViewById(R.id.notice_cardview);
            itemView.setOnClickListener(this);
            view = itemView;

        }

        @Override
        public void onClick(View v) {
            Noticeboard noticeModel = noticeModelsList.get(getAdapterPosition());
            Intent intent = new Intent(context, NoticeBoardDetails.class);
            intent.putExtra("NoticeName",noticeModel.getNoticeName());
            intent.putExtra("NoticeSummary",noticeModel.getNoticeSummary());
            intent.putExtra("NoticeDescription",noticeModel.getNoticeDescription());
            intent.putExtra("NoticeContactUserId",noticeModel.getNoticeID());
            intent.putExtra("NoticeCreateDate",noticeModel.getNoticeCreateDate());
            intent.putExtra("NoticeExpiryDate",noticeModel.getNoticeExpiryDate());
            intent.putExtra("Contactpersonname",noticeModel.getContactpersonname());
            context.startActivity(intent);
            Activity activity = (Activity) context;

        }
    }
}
