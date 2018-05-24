package com.ice.picmanage.bean;

import lombok.Data;

@Data
public class FileInfo {

  private String name;
  private String path;
  private boolean isDirectory;
  private boolean isEmpty;

}
