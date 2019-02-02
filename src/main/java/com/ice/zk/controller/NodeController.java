package com.ice.zk.controller;

import com.ice.common.BaseResponse;
import com.ice.zk.service.ZkService;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zk/node")
public class NodeController {

  @RequestMapping("/env")
  public BaseResponse queryEnv() throws Exception {
    return BaseResponse.builder().isSuccess(true).data(ZkService.queryEnv()).build();
  }

  @RequestMapping(value = "/list", method = {RequestMethod.POST, RequestMethod.GET})
  public BaseResponse list(@Param("path") String path) throws Exception {
    return BaseResponse.builder().isSuccess(true).data(ZkService.listNode(path)).build();
  }

  @RequestMapping("/create")
  public BaseResponse create(@Param("path") String path, @Param("value") String value) throws Exception {
    return BaseResponse.builder().isSuccess(true).data(ZkService.createNode(path, value)).build();
  }

  @RequestMapping("/delete")
  public BaseResponse delete(@Param("path") String path) throws Exception {
    return BaseResponse.builder().isSuccess(true).data(ZkService.deleteNode(path)).build();
  }

  @RequestMapping("/update")
  public BaseResponse update(@Param("path") String path, @Param("value") String value) throws Exception {
    return BaseResponse.builder().isSuccess(true).data(ZkService.updateNode(path, value)).build();
  }

  @RequestMapping("/query")
  public BaseResponse query(@Param("path") String path) throws Exception {
    return BaseResponse.builder().isSuccess(true).data(ZkService.queryNode(path)).build();
  }

}
