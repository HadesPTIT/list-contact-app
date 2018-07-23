package com.framgia.contactexample;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactAdapter extends ArrayAdapter<ContactInfo> {

    private ArrayList<ContactInfo> mContacts;
    private Context mContext;

    public ContactAdapter(@NonNull Context context, @NonNull ArrayList<ContactInfo> objects) {
        super(context, android.R.layout.simple_list_item_1, objects);
        this.mContext = context;
        this.mContacts = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View v, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (v == null) {
            viewHolder = new ViewHolder();
            v = LayoutInflater.from(mContext).inflate(R.layout.item_contact, parent, false);

            viewHolder.imageAvatar = v.findViewById(R.id.image_avatar);
            viewHolder.tvName = v.findViewById(R.id.text_name);
            viewHolder.tvPhoneNumber = v.findViewById(R.id.text_phone_number);
            v.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) v.getTag();
        }

        ContactInfo info = mContacts.get(position);
        viewHolder.tvName.setText(info.getName());
        viewHolder.tvPhoneNumber.setText(info.getPhoneNumber());
        try {
            viewHolder.imageAvatar.setImageURI(Uri.parse(info.getPhotoUri()));
        } catch (Exception e) {
            viewHolder.imageAvatar.setImageResource(R.mipmap.ic_launcher_round);
        }
        return v;
    }

    private class ViewHolder {
        ImageView imageAvatar;
        TextView tvName;
        TextView tvPhoneNumber;
    }
}
