package com.framgia.contactexample;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_CONTACTS = 1;
    private ArrayList<ContactInfo> mContacts;
    private ListView mListView;
    private ContactAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = findViewById(R.id.list_contact);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermission();
            return;
        }
        mContacts = ContactUtil.getContacts(this);
        mAdapter = new ContactAdapter(this, mContacts);
        mListView.setAdapter(mAdapter);
    }

    private void requestPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
                == PackageManager.PERMISSION_GRANTED) {
            mContacts = ContactUtil.getContacts(this);
            mAdapter = new ContactAdapter(this, mContacts);
            mListView.setAdapter(mAdapter);
        } else if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.READ_CONTACTS)) {
            new AlertDialog.Builder(this)
                    .setTitle(R.string.title_permission_needed)
                    .setMessage(R.string.msg_permission_rationale)
                    .setPositiveButton(R.string.button_ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(MainActivity.this,
                                    new String[]{android.Manifest.permission.READ_CONTACTS},
                                    REQUEST_CODE_CONTACTS);
                        }
                    }).setNegativeButton(R.string.button_cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            }).create().show();
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.READ_CONTACTS}, REQUEST_CODE_CONTACTS);
        }
    }
}
