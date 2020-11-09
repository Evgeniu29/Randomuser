package com.paad.randomuser.API;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result implements Parcelable {
    @SerializedName("gender")
    @Expose
    public String gender;
    @SerializedName("name")
    @Expose
    public Name name;
    @SerializedName("location")
    @Expose
    public Location location;
    @SerializedName("email")
    @Expose
    public String email;
    @SerializedName("login")
    @Expose
    public Login login;
    @SerializedName("dob")
    @Expose
    public Dob dob;
    @SerializedName("registered")
    @Expose
    public Registered registered;
    @SerializedName("phone")
    @Expose
    public String phone;
    @SerializedName("cell")
    @Expose
    public String cell;
    @SerializedName("id")
    @Expose
    public IdUser idUser;
    @SerializedName("picture")
    @Expose
    public Picture picture;
    @SerializedName("nat")
    @Expose
    public String nat;

    @Expose
    private String image;

    protected Result(Parcel in) {
        gender = in.readString();
        email = in.readString();
        phone = in.readString();
        cell = in.readString();
        nat = in.readString();
        image = in.readString();
    }

    public static final Creator<Result> CREATOR = new Creator<Result>() {
        @Override
        public Result createFromParcel(Parcel in) {
            return new Result(in);
        }

        @Override
        public Result[] newArray(int size) {
            return new Result[size];
        }
    };

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Dob getDob() {
        return dob;
    }

    public void setDob(Dob dob) {
        this.dob = dob;
    }

    public Registered getRegistered() {
        return registered;
    }

    public void setRegistered(Registered registered) {
        this.registered = registered;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public IdUser getIdUser() {
        return idUser;
    }

    public void setIdUser(IdUser idUser) {
        this.idUser = idUser;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public String getNat() {
        return nat;
    }

    public void setNat(String nat) {
        this.nat = nat;
    }






    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(gender);
        dest.writeString(email);
        dest.writeString(phone);
        dest.writeString(cell);
        dest.writeString(nat);
        dest.writeString(image);
    }


    public int describeContents() {
        return hashCode();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
