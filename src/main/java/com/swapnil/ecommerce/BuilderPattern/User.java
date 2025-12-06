//package com.swapnil.ecommerce.BuilderPattern;
//
//public class User {
//
//    private String name;
//    private Integer age;
//    private String email;
//    private String password;
//
//    private User(Builder builder){
//        this.name = builder.name;
//        this.age = builder.age;
//        this.email = builder.email;
//        this.password = builder.password;
//    }
//
//    static class Builder{
//        private String name;
//        private Integer age;
//        private String email;
//        private String password;
//
//        public Builder(){
//
//        }
//
//        Builder name(String name){
//            this.name = name;
//            return this;
//        }
//
//        Builder age(Integer age){
//            this.age = age;
//            return this;
//        }
//
//        Builder email(String email){
//            this.email = email;
//            return this;
//        }
//
//        Builder password(String password){
//            this.password = password;
//            return this;
//        }
//
//        User build(){
//            return new User(this);
//        }
//
//
//
//    }
//    @Override
//    public String toString(){
//        return "User("+"name = '"+name+"',age = "+age+" ,email = '"+email+"' ,password = '"+password+"'}";
//    }
//}
