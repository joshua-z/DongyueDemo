package com.example.as.dongyuedemo;

public class Act{
    private int actid;
    private String name;
    private int type;
    private String location;
    private int poster_id;
    private String source;
    private String start_time;
    private String end_time;
    private String sign_start_time;
    private String sign_end_time;
    private int member_count;
    private int max_member;
    private int view_count;
    private int comment_count;
    private String small;
    private String typename;
    private String poster;
    private int time_status;
    private String stime_status_str;

    public Act() {

    }

    public void setActid(int actid) {
        this.actid = actid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(int type) {
        this.type = type;
    }


    public void setLocation(String location) {
        this.location = location;
    }

    public void setPoster_id(int poster_id) {
        this.poster_id = poster_id;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public void setSign_start_time(String sign_start_time) {
        this.sign_start_time = sign_start_time;
    }

    public void setSign_end_time(String sign_end_time) {
        this.sign_end_time = sign_end_time;
    }

    public void setMember_count(int member_count) {
        this.member_count = member_count;
    }

    public void setMax_member(int max_member) {
        this.max_member = max_member;
    }

    public void setView_count(int view_count) {
        this.view_count = view_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public void setTime_status(int time_status) {
        this.time_status = time_status;
    }

    public void setStime_status_str(String stime_status_str) {
        this.stime_status_str = stime_status_str;
    }

    public int getActid() {
        return actid;
    }

    public String getName() {
        return name;
    }

    public int getType() {
        return type;
    }

    public String getLocation() {
        return location;
    }

    public int getPoster_id() {
        return poster_id;
    }

    public String getSource() {
        return source;
    }

    public String getStart_time() {
        return start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public String getSign_start_time() {
        return sign_start_time;
    }

    public String getSign_end_time() {
        return sign_end_time;
    }

    public int getMember_count() {
        return member_count;
    }

    public int getMax_member() {
        return max_member;
    }

    public int getView_count() {
        return view_count;
    }

    public int getComment_count() {
        return comment_count;
    }

    public String getSmall() {
        return small;
    }

    public String getTypename() {
        return typename;
    }

    public String getPoster() {
        return poster;
    }

    public int getTime_status() {
        return time_status;
    }

    public String getStime_status_str() {
        return stime_status_str;
    }


    @Override
    public String toString() {
        return "Act{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", location='" + location + '\'' +
                ", source='" + source + '\'' +
                ", start_time='" + start_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", sign_start_time='" + sign_start_time + '\'' +
                ", sign_end_time='" + sign_end_time + '\'' +
                ", poster='" + poster + '\'' +
                '}';
    }
}
