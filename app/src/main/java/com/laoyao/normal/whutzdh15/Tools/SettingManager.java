package com.laoyao.normal.whutzdh15.Tools;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Laoyao on 2018/4/3.
 */

public class SettingManager
{
    private static final String IsBaseDataGotKey = "IsBDGot" ;
    private static final String StudentNumberKey = "StudentNumber" ;
    private static final String MNameKey = "MName" ;
    private static final String LivePlaceKey = "LivePlace" ;
    private static final String MPhoneKey = "MPhone" ;
    private static final String ENameKey = "EName" ;
    private static final String EPhoneKey = "EPhone" ;
    private static final String FNameKey = "FName" ;
    private static final String FPhoneKey = "FPhone" ;
    private static final String YearKey = "Year" ;
    private static final String IsInWuhanKey = "IsInWuhan" ;
    private static final String ClassKey = "Class" ;
    private static final String ProfessionKey = "Profession" ;

    //保存base数据的share Predereneces 文件名
    private static final String SPreferencesFileName = "BaseData" ;
    private Context GiveContext ;
    private SharedPreferences SP ;

    public SettingManager(Context giveContext)
    {
        GiveContext = giveContext ;
        SP = GiveContext.getSharedPreferences(SPreferencesFileName , Context.MODE_PRIVATE) ;
    }

    public  boolean getIsBaseDataGot()
    {
        //默认为false , 没有获得基本信息
        return SP.getBoolean(IsBaseDataGotKey , false) ;
    }

    public void setIsBaseDataGot(boolean value)
    {
        SharedPreferences.Editor editor = SP.edit() ;
        editor.putBoolean(IsBaseDataGotKey , value) ;
        editor.commit() ;
    }


    public  String getStudentNumber() {
        return SP.getString(StudentNumberKey , "") ;
    }

    public  void setStudentNumber(String value) {
        SetStringValue(StudentNumberKey , value) ;
    }

    public String getMName() {
        return SP.getString(MNameKey , "");
    }

    public void setMName(String value) {
        SetStringValue(MNameKey , value) ;
    }

    public String getLivePlace() {
        return SP.getString(LivePlaceKey,"");
    }

    public void setLivePlace(String value) {
        SetStringValue(LivePlaceKey, value);
    }

    public String getMPhone() {
        return SP.getString(MPhoneKey , "");
    }

    public void setMPhone(String value) {
        SetStringValue(MPhoneKey , value);
    }

    public String getEName() {
        return SP.getString(ENameKey , "");
    }

    public void setEName(String value) {
        SetStringValue(ENameKey , value);
    }

    public String getEPhone() {
        return SP.getString(EPhoneKey , "");
    }

    public void setEPhone(String value) {
        SetStringValue(EPhoneKey , value);
    }

    public String getFName() {
        return SP.getString(FNameKey , "");
    }

    public void setFName(String value) {
        SetStringValue(FNameKey , value);
    }

    public String getFPhone() {
        return SP.getString(FPhoneKey , "");
    }

    public void setFPhone(String value) {
        SetStringValue(FPhoneKey , value);
    }

    public String getYear() {
        return SP.getString(YearKey , "");
    }

    public void setYear(String value) {
        SetStringValue(YearKey ,value );
    }

    public String getIsInWuhan() {
        return SP.getString(IsInWuhanKey , "");
    }

    public void setIsInWuhan(String value) {
        SetStringValue(IsInWuhanKey , value);
    }

    public String getClassName() {
        return SP.getString(ClassKey , "");
    }

    public void setClassName(String value) {
        SetStringValue(ClassKey , value);
    }

    public String getProfession() {
        return SP.getString(ProfessionKey , "");
    }

    public void setProfession(String value) {
        SetStringValue(ProfessionKey , value);
    }

    private void SetStringValue(String key , String value)
    {
        SharedPreferences.Editor editor = SP.edit() ;
        editor.putString(key , value) ;
        editor.commit() ;
    }

}
