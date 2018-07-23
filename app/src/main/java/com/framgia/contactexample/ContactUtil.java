package com.framgia.contactexample;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;

import java.util.ArrayList;

public class ContactUtil {

    public static ArrayList<ContactInfo> getContacts(Context context) {
        ArrayList<ContactInfo> contacts = new ArrayList<>();
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;

        Cursor cursor = context.getContentResolver()
                .query(uri, null, null, null, null);
        cursor.moveToFirst();

        int indexID = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.CONTACT_ID);
        int indexName = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
        int indexPhone = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
        int indexImage = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHOTO_URI);

        while (!cursor.isAfterLast()) {
            String id = cursor.getString(indexID);
            String name = cursor.getString(indexName);
            String phone = cursor.getString(indexPhone);
            String photo = cursor.getString(indexImage);
            ContactInfo contactInfo = new ContactInfo(id, name, phone, photo);
            contacts.add(contactInfo);
            cursor.moveToNext();
        }
        cursor.close();
        return contacts;
    }
}
