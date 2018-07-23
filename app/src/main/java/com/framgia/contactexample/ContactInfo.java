package com.framgia.contactexample;

public class ContactInfo {

    private String mId;
    private String mName;
    private String mPhoneNumber;
    private String mPhotoUri;

    public ContactInfo() {
    }

    public ContactInfo(String id, String name, String phoneNumber, String photoUri) {
        this.mId = id;
        this.mName = name;
        this.mPhoneNumber = phoneNumber;
        this.mPhotoUri = photoUri;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        this.mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.mPhoneNumber = phoneNumber;
    }

    public String getPhotoUri() {
        return mPhotoUri;
    }

    public void setPhotoUri(String photoUri) {
        this.mPhotoUri = photoUri;
    }
}
