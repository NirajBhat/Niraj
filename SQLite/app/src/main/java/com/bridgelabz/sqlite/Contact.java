package com.bridgelabz.sqlite;

/**
 * Created by bridgeit on 28/10/16.
 */

public class Contact {
    int id;
    String name;
    String phone_num;
    public Contact(){

    }

    public Contact(int id,String name,String phone_num){
         this.id =id;
        this.name=name;
        this.phone_num=phone_num;
    }
    public Contact(String name,String phone_num){
        this.name=name;
        this.phone_num=phone_num;
    }
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getPhone_num(){
        return this.phone_num;

    }
    public void setPhone_num(String phone_num){
        this.phone_num=phone_num;
    }
}
