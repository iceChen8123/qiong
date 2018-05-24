package com.ice.picmanage;

import com.ice.picmanage.bean.FileInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class PicService {

  public static void main(String[] args) throws IOException {
    List<FileInfo> fileList = getFileList("D:/");
    for (FileInfo file : fileList) {
      log.info("name: {}, path: {}", file.getName(), file.getPath().replace("\\", "/"));
    }
  }

  public static List<FileInfo> getFileList(String path) {
    if (StringUtils.isBlank(path) || path.equals("/")) {//cause js concat it
      List<FileInfo> rtnList = new ArrayList<>();
      File[] parts = File.listRoots();
      FileSystemView fsv = FileSystemView.getFileSystemView();
      for (File file : parts) {
        FileInfo fileInfo = new FileInfo();
        fileInfo.setName(fsv.getSystemDisplayName(file));
        fileInfo.setPath(file.getAbsolutePath().replace("\\", "/"));
        fileInfo.setDirectory(file.isDirectory());
        fileInfo.setEmpty(!(file.listFiles() != null && file.listFiles().length > 0));
        rtnList.add(fileInfo);
      }
      return rtnList;
    }


    List<FileInfo> rtnList = new ArrayList<>();
    File[] files = new File(path).listFiles();

    List<FileInfo> fileList = new ArrayList<>();
    List<FileInfo> dirList = new ArrayList<>();
    if (files != null && files.length > 0) {
      for (File file : files) {
        FileInfo fileInfo = new FileInfo();
        fileInfo.setName(file.getName());
        fileInfo.setPath(file.getAbsolutePath().replace("\\", "/"));
        fileInfo.setDirectory(file.isDirectory());
        fileInfo.setEmpty(!(file.listFiles() != null && file.listFiles().length > 0));
        if (file.isDirectory()) {
          dirList.add(fileInfo);
        } else {
          fileList.add(fileInfo);
        }
      }
    }
    rtnList.addAll(dirList);
    rtnList.addAll(fileList);
    return rtnList;
  }

}
