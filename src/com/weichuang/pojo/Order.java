package com.weichuang.pojo;

/**
 * 一对一关联查询推荐解决方案
 */
public class Order {
    private int id;
    private int userId;
    private String ono;
    private String createtime;
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getOno() {
        return ono;
    }

    public void setOno(String ono) {
        this.ono = ono;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", ono='" + ono + '\'' +
                ", createtime='" + createtime + '\'' +
                ", user=" + user +
                '}';
    }
}
