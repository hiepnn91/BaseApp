package com.baseapp.hiepnn.mybaseproject.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by LinhNguyen on 9/25/2015.
 */
public class UserInfoBean implements Parcelable {

    public int id;
    public String access_token;
    public String email;
    public String name;
    public String profile_image;
    public String date_of_birth;
    public String my_address;
    public String introduce;
    public String nickname;
    public int num_my_post;
    public int num_my_follower;
    public int num_follower;
    public int num_my_favorite;
    public int num_favorite;
    public int num_match_favorite;
    public int nt_post_image_flag;
    public int nt_visited_from_other_user_flag;
    public int nt_visit_flag;

    public int my_sex;
    public int my_search_sex;
    public String my_hobby;
    public int my_purpose;
    public int my_social_status;
    public int my_brand;
    public int my_country;
    public String my_birth_place;
    public int my_blood;
    public int my_race_of_people;
    public int my_language;
    public float my_height_cm;
    public float my_weight_kg;
    public float my_bust_cm;
    public int my_breast_size;
    public float my_waist_cm;
    public float my_hip_cm;
    public int my_dress_size;
    public int my_shoe_size;
    public int my_hair_color;
    public int my_eyes_color;
    public int my_glasses;
    public int my_body_type;
    public int my_hair_type;
    public int my_personality;
    public int my_smoke;
    public int my_wine;
    public int my_job;
    public String my_job_category;
    public String my_company;
    public String my_graduated_university;
    public String my_income_jpy;
    public int my_model_offer;
    public int my_marriage_status;
    public int my_child_num;

    public int search_sex;

    public int search_search_sex;
    public String search_introduce;
    public String search_name;
    public String search_nickname;

    public String search_hobby;
    public int search_purpose;
    public int search_social_status;
    public int search_brand;
    public int search_country;
    public String search_birth_place;
    public int search_age_from;
    public int search_age_until;
    public int search_blood;
    public int search_language;
    public float search_height_cm_from;
    public float search_height_cm_until;
    public float search_weight_kg_from;
    public float search_weight_kg_until;
    public float search_bust_cm_from;
    public float search_bust_cm_until;
    public int search_breast_size;
    public float search_waist_cm_from;
    public float search_waist_cm_until;
    public float search_hip_cm_from;
    public float search_hip_cm_until;
    public int search_dress_size;
    public int search_shoe_size;
    public int search_hair_color;
    public int search_eyes_color;
    public int search_glasses;
    public int search_body_type;
    public int search_hair_type;
    public int search_personality;
    public int search_smoke;
    public int search_wine;
    public int search_job;
    public String search_job_category;
    public String search_tag_name;
    public String search_company;
    public String search_graduated_university;
    public String search_income_jpy;
    public int search_model_offer;
    public int search_marriage_status;
    public int search_child_num;
    public String others;
    public String coin;


    protected UserInfoBean(Parcel in) {
        id = in.readInt();
        access_token = in.readString();
        email = in.readString();
        name = in.readString();
        profile_image = in.readString();
        date_of_birth = in.readString();
        introduce = in.readString();
        nickname = in.readString();
        num_my_post = in.readInt();
        num_my_follower = in.readInt();
        num_follower = in.readInt();
        num_my_favorite = in.readInt();
        num_favorite = in.readInt();
        my_sex = in.readInt();
        my_search_sex = in.readInt();
        my_hobby = in.readString();
        my_purpose = in.readInt();
        my_social_status = in.readInt();
        my_brand = in.readInt();
        my_country = in.readInt();
        my_birth_place = in.readString();
        my_blood = in.readInt();
        my_race_of_people = in.readInt();
        my_language = in.readInt();
        my_height_cm = in.readFloat();
        my_weight_kg = in.readFloat();
        my_bust_cm = in.readFloat();
        my_breast_size = in.readInt();
        my_waist_cm = in.readFloat();
        my_hip_cm = in.readFloat();
        my_dress_size = in.readInt();
        my_shoe_size = in.readInt();
        my_hair_color = in.readInt();
        my_eyes_color = in.readInt();
        my_glasses = in.readInt();
        my_body_type = in.readInt();
        my_hair_type = in.readInt();
        my_personality = in.readInt();
        my_smoke = in.readInt();
        my_wine = in.readInt();
        my_job = in.readInt();
        my_job_category = in.readString();
        my_company = in.readString();
        my_graduated_university = in.readString();
        my_income_jpy = in.readString();
        my_model_offer = in.readInt();
        my_marriage_status = in.readInt();
        my_child_num = in.readInt();
        search_sex = in.readInt();
        search_hobby = in.readString();
        search_purpose = in.readInt();
        search_social_status = in.readInt();
        search_brand = in.readInt();
        search_country = in.readInt();
        search_birth_place = in.readString();
        search_age_from = in.readInt();
        search_age_until = in.readInt();
        search_blood = in.readInt();
        search_language = in.readInt();
        search_height_cm_from = in.readFloat();
        search_height_cm_until = in.readFloat();
        search_weight_kg_from = in.readFloat();
        search_weight_kg_until = in.readFloat();
        search_bust_cm_from = in.readFloat();
        search_bust_cm_until = in.readFloat();
        search_breast_size = in.readInt();
        search_waist_cm_from = in.readFloat();
        search_waist_cm_until = in.readFloat();
        search_hip_cm_from = in.readFloat();
        search_hip_cm_until = in.readFloat();
        search_dress_size = in.readInt();
        search_shoe_size = in.readInt();
        search_hair_color = in.readInt();
        search_eyes_color = in.readInt();
        search_glasses = in.readInt();
        search_body_type = in.readInt();
        search_hair_type = in.readInt();
        search_personality = in.readInt();
        search_smoke = in.readInt();
        search_wine = in.readInt();
        search_job = in.readInt();
        search_job_category = in.readString();
        search_tag_name = in.readString();
        search_company = in.readString();
        search_graduated_university = in.readString();
        search_income_jpy = in.readString();
        search_model_offer = in.readInt();
        search_marriage_status = in.readInt();
        search_child_num = in.readInt();

        search_introduce = in.readString();
        search_name = in.readString();
        search_nickname = in.readString();
        search_search_sex = in.readInt();

        others = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(access_token);
        dest.writeString(email);
        dest.writeString(name);
        dest.writeString(profile_image);
        dest.writeString(date_of_birth);
        dest.writeString(introduce);
        dest.writeString(nickname);
        dest.writeInt(num_my_post);
        dest.writeInt(num_my_follower);
        dest.writeInt(num_follower);
        dest.writeInt(num_my_favorite);
        dest.writeInt(num_favorite);
        dest.writeInt(my_sex);
        dest.writeInt(my_search_sex);
        dest.writeString(my_hobby);
        dest.writeInt(my_purpose);
        dest.writeInt(my_social_status);
        dest.writeInt(my_brand);
        dest.writeInt(my_country);
        dest.writeString(my_birth_place);
        dest.writeInt(my_blood);
        dest.writeInt(my_race_of_people);
        dest.writeInt(my_language);
        dest.writeFloat(my_height_cm);
        dest.writeFloat(my_weight_kg);
        dest.writeFloat(my_bust_cm);
        dest.writeInt(my_breast_size);
        dest.writeFloat(my_waist_cm);
        dest.writeFloat(my_hip_cm);
        dest.writeInt(my_dress_size);
        dest.writeInt(my_shoe_size);
        dest.writeInt(my_hair_color);
        dest.writeInt(my_eyes_color);
        dest.writeInt(my_glasses);
        dest.writeInt(my_body_type);
        dest.writeInt(my_hair_type);
        dest.writeInt(my_personality);
        dest.writeInt(my_smoke);
        dest.writeInt(my_wine);
        dest.writeInt(my_job);
        dest.writeString(my_job_category);
        dest.writeString(my_company);
        dest.writeString(my_graduated_university);
        dest.writeString(my_income_jpy);
        dest.writeInt(my_model_offer);
        dest.writeInt(my_marriage_status);
        dest.writeInt(my_child_num);
        dest.writeInt(search_sex);
        dest.writeString(search_hobby);
        dest.writeInt(search_purpose);
        dest.writeInt(search_social_status);
        dest.writeInt(search_brand);
        dest.writeInt(search_country);
        dest.writeString(search_birth_place);
        dest.writeInt(search_age_from);
        dest.writeInt(search_age_until);
        dest.writeInt(search_blood);
        dest.writeInt(search_language);
        dest.writeFloat(search_height_cm_from);
        dest.writeFloat(search_height_cm_until);
        dest.writeFloat(search_weight_kg_from);
        dest.writeFloat(search_weight_kg_until);
        dest.writeFloat(search_bust_cm_from);
        dest.writeFloat(search_bust_cm_until);
        dest.writeInt(search_breast_size);
        dest.writeFloat(search_waist_cm_from);
        dest.writeFloat(search_waist_cm_until);
        dest.writeFloat(search_hip_cm_from);
        dest.writeFloat(search_hip_cm_until);
        dest.writeInt(search_dress_size);
        dest.writeInt(search_shoe_size);
        dest.writeInt(search_hair_color);
        dest.writeInt(search_eyes_color);
        dest.writeInt(search_glasses);
        dest.writeInt(search_body_type);
        dest.writeInt(search_hair_type);
        dest.writeInt(search_personality);
        dest.writeInt(search_smoke);
        dest.writeInt(search_wine);
        dest.writeInt(search_job);
        dest.writeString(search_job_category);
        dest.writeString(search_tag_name);
        dest.writeString(search_company);
        dest.writeString(search_graduated_university);
        dest.writeString(search_income_jpy);
        dest.writeInt(search_model_offer);
        dest.writeInt(search_marriage_status);
        dest.writeInt(search_child_num);

        dest.writeString(search_introduce);
        dest.writeString(search_name);
        dest.writeString(search_nickname);
        dest.writeInt(search_search_sex);

        dest.writeString(others);
    }

    @SuppressWarnings("unused")
    public static final Creator<UserInfoBean> CREATOR = new Creator<UserInfoBean>() {
        @Override
        public UserInfoBean createFromParcel(Parcel in) {
            return new UserInfoBean(in);
        }

        @Override
        public UserInfoBean[] newArray(int size) {
            return new UserInfoBean[size];
        }
    };

    public UserInfoBean() {

    }
}
