package indi.group.pcss.dao;

import java.util.List;

import indi.group.pcss.model.FileInformation;

public interface IFileInformationDao {
    int insert(FileInformation record);
    int deleteByMd5(String md5name);
    FileInformation selectByMd5(String md5name);
    int updateByMd5(FileInformation record);
    List<FileInformation> listGetAll();
}
