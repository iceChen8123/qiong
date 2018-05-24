package com.ice.zk.service;

import com.ice.zk.bean.Node;
import lombok.extern.slf4j.Slf4j;
import org.apache.solr.common.cloud.SolrZkClient;
import org.apache.zookeeper.CreateMode;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ZkService {

  //dev
  private final static SolrZkClient solrZkClient = new SolrZkClient("10.18.19.64:12181,10.18.19.61:12181,10.18.19.28:12181", 10000);
  //demo
//  private final static SolrZkClient solrZkClient = new SolrZkClient("10.18.19.64:22181,10.18.19.28:22181,10.18.19.61:22181", 10000);

  public static List<Node> listNode(String path) throws Exception {
    List<String> children = solrZkClient.getChildren(path, null, true);
    List<Node> nodeList = new ArrayList<>();
    children.forEach(pathTmp -> {
      try {
        nodeList.add(queryNode(path + "/" + pathTmp));
      } catch (NullPointerException e) {
        nodeList.add(new Node(path + "/" + pathTmp, ""));
      } catch (Exception e) {
        log.warn("", e);
        nodeList.add(new Node(path + "/" + pathTmp, ""));
      }
    });
    return nodeList;
  }

  public static boolean updateNode(String path, String value) throws Exception {
    solrZkClient.setData(path, value.getBytes("UTF-8"), true);
    return true;
  }

  public static boolean createNode(String path, String value) throws Exception {
    solrZkClient.create(path, value.getBytes("UTF-8"), CreateMode.PERSISTENT, true);
    return true;
  }

  public static boolean deleteNode(String path) throws Exception {
    solrZkClient.delete(path, -1, true);
    return true;
  }

  public static Node queryNode(String path) throws Exception {
    return new Node(path, new String(solrZkClient.getData(path, null, null, true), "UTF-8"));
  }

  public static String queryEnv() {
    return solrZkClient.getZkServerAddress();
  }

  public static void main(String[] args) throws Exception {
//    String path = "/com/dianrong/cfg/1.0.0$/eyrie";
//    String nodeName = "IAMTEST";
//    log.info("listNode : {}", listNode(path).toString());
//    log.info("createNode : {} ", createNode(path + "/" + nodeName, "TEST1"));
//    log.info("queryNode1 : {} ", queryNode(path + "/" + nodeName));
//    log.info("updateNode : {} ", updateNode(path + "/" + nodeName, "TEST2"));
//    log.info("queryNode2 : {} ", queryNode(path + "/" + nodeName));
//    log.info("deleteNode : {} ", deleteNode(path + "/" + nodeName));
//    log.info("queryNode3 : {} ", queryNode(path + "/" + nodeName));
//
//    log.info("createNode : {} ", createNode(path + "/" + nodeName, "TEST1222"));
//    log.info("createNode : {} ", createNode(path + "/" + nodeName, "TEST12223333"));
//    log.info("queryNode2 : {} ", queryNode(path + "/" + nodeName));
//    log.info("deleteNode : {} ", deleteNode(path + "/" + nodeName));


    log.info("createNode : {} ", createNode("/com/dianrong/cfg/1.0.0/plateaux/SPECIAL_USER_FOR_INVEST", "61"));
  }

}
