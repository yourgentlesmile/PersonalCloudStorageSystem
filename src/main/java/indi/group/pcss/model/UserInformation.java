package indi.group.pcss.model;

import java.sql.Timestamp;

public class UserInformation {
    private Integer id;
    private String username;
    private Integer parent_space_user_id;
    private String real_name;
    private String email;
    private String telephone;
    private String introduction;
    private String avatar;
    private Timestamp register_time;
    private Integer freespace_kb;
    private Integer total_usable_space_kb;
    public UserInformation(Integer id, String username, Integer parent_space_user_id, String real_name, String email,
            String telephone, String introduction, String avatar, Timestamp register_time, Integer freespace_kb,
            Integer total_usable_space_kb) {
        super();
        this.id = id;
        this.username = username;
        this.parent_space_user_id = parent_space_user_id;
        this.real_name = real_name;
        this.email = email;
        this.telephone = telephone;
        this.introduction = introduction;
        this.avatar = avatar;
        this.register_time = register_time;
        this.freespace_kb = freespace_kb;
        this.total_usable_space_kb = total_usable_space_kb;
    }
    public UserInformation() {
        super();
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }
    public Integer getParent_space_user_id() {
        return parent_space_user_id;
    }
    public void setParent_space_user_id(Integer parent_space_user_id) {
        this.parent_space_user_id = parent_space_user_id;
    }
    public String getReal_name() {
        return real_name;
    }
    public void setReal_name(String real_name) {
        this.real_name = real_name == null ? null : real_name.trim();
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }
    public String getIntroduction() {
        return introduction;
    }
    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }
    public String getAvatar() {
        return avatar;
    }
    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? "default" : avatar.trim();
    }
    public Timestamp getRegister_time() {
        return register_time;
    }
    public void setRegister_time(Timestamp register_time) {
        this.register_time = register_time;
    }
    public Integer getFreespace_kb() {
        return freespace_kb;
    }
    public void setFreespace_kb(Integer freespace_kb) {
        this.freespace_kb = freespace_kb;
    }
    public Integer getTotal_usable_space_kb() {
        return total_usable_space_kb;
    }
    public void setTotal_usable_space_kb(Integer total_usable_space_kb) {
        this.total_usable_space_kb = total_usable_space_kb;
    }
    @Override
    public String toString() {
        return "UserInformation [id=" + id + ", username=" + username + ", parent_space_user_id=" + parent_space_user_id
                + ", real_name=" + real_name + ", email=" + email + ", telephone=" + telephone + ", introduction="
                + introduction + ", avatar=" + avatar + ", register_time=" + register_time + ", freespace_kb="
                + freespace_kb + ", total_usable_space_kb=" + total_usable_space_kb + "]";
    }
   
}