package com.example.user.retrofitdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;



public class NoticeBoardDetails extends AppCompatActivity {

    private TextView NoticeDateCreate,NoticeDateExpiry,NoticeName,NoticeSummary,NoticeDescription,NoticeContactUserId,Noticecontactpersonname,Noticecontactpersonnumber,Noticecontactpersonemail;
    private TextView toolbar_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_board_details);


        NoticeName = (TextView) findViewById(R.id.NoticeName);
        NoticeDateCreate = (TextView) findViewById(R.id.NoticeDateCreate);
        NoticeDateExpiry = (TextView) findViewById(R.id.NoticeDateExpiry);
        NoticeSummary = (TextView) findViewById(R.id.NoticeSummary);
        NoticeDescription = (TextView) findViewById(R.id.NoticeDescription);
        NoticeContactUserId = (TextView) findViewById(R.id.NoticeContactUserId);
        Noticecontactpersonname = (TextView) findViewById(R.id.Noticecontactpersonname);


        NoticeName.setText(getIntent().getStringExtra("NoticeName"));
        NoticeSummary.setText(getIntent().getStringExtra("NoticeSummary"));
        NoticeDateCreate.setText(getIntent().getStringExtra("NoticeCreateDate"));
        NoticeDateExpiry.setText(getIntent().getStringExtra("NoticeExpiryDate"));
        NoticeDescription.setText(getIntent().getStringExtra("NoticeDescription"));
        NoticeContactUserId.setText(getIntent().getStringExtra("NoticeContactUserId"));
        Noticecontactpersonname.setText(getIntent().getStringExtra("Contactpersonname"));
       /* Noticecontactpersonnumber.setText(getIntent().getStringExtra("Contactpersonnumber"));
        Noticecontactpersonemail.setText(getIntent().getStringExtra("Contactpersonemail"));*/

    }
}
