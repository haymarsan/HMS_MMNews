package com.example.mmnews_hms.persistence.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.mmnews_hms.data.vos.LoginUserVO;

@Dao
public interface LoginUseDao {


    @Insert
    long insertLoginUser(LoginUserVO loginUser);

    @Query("SELECT * FROM user")
    LoginUserVO getLoginUser();

    @Delete
    void  deleteLoginUser(LoginUserVO loginUser);

}
