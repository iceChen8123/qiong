package com.ice.zk.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Node {

  private String path;

  private String value;

}
