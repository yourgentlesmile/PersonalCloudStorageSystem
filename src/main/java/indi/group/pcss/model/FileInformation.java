package indi.group.pcss.model;

import java.sql.Timestamp;

public class FileInformation {
    private String md5_filename;
    private Integer file_size_kb;
    private String file_type;
    private Integer file_status;
    private Timestamp create_time;
    private String upload_ip;
    private String save_server_name;
    public String getMd5_filename() {
        return md5_filename;
    }
    public void setMd5_filename(String md5_filename) {
        this.md5_filename = md5_filename;
    }
    public Integer getFile_size_kb() {
        return file_size_kb;
    }
    public void setFile_size_kb(Integer file_size_kb) {
        this.file_size_kb = file_size_kb;
    }
    public String getFile_type() {
        return file_type;
    }
    public void setFile_type(String file_type) {
        this.file_type = file_type;
    }
    public Integer getFile_status() {
        return file_status;
    }
    public void setFile_status(Integer file_status) {
        this.file_status = file_status;
    }
    public Timestamp getCreate_time() {
        return create_time;
    }
    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }
    public String getUpload_ip() {
        return upload_ip;
    }
    public void setUpload_ip(String upload_ip) {
        this.upload_ip = upload_ip;
    }
    public String getSave_server_name() {
        return save_server_name;
    }
    public void setSave_server_name(String save_server_name) {
        this.save_server_name = save_server_name;
    }
    @Override
    public String toString() {
        return "FileInformation [md5_filename=" + md5_filename + ", file_size_kb=" + file_size_kb + ", file_type="
                + file_type + ", file_status=" + file_status + ", create_time=" + create_time + ", upload_ip="
                + upload_ip + ", save_server_name=" + save_server_name + "]";
    }
    public FileInformation(String md5_filename, Integer file_size_kb, String file_type, Integer file_status,
            Timestamp create_time, String upload_ip, String save_server_name) {
        super();
        this.md5_filename = md5_filename;
        this.file_size_kb = file_size_kb;
        this.file_type = file_type;
        this.file_status = file_status;
        this.create_time = create_time;
        this.upload_ip = upload_ip;
        this.save_server_name = save_server_name;
    }
    public FileInformation() {
        super();
    }
    
}
