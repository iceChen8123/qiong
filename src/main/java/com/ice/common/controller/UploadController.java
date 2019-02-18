package com.ice.common.controller;

import com.ice.common.BaseResponse;
import com.ice.common.util.OssUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("upload")
public class UploadController {

  public static final String SEPARATOR = "@@@";
  private static String fileCacheLocal = "e://upload/";

  static {
    if (!new File(fileCacheLocal).exists()) {
      new File(fileCacheLocal).mkdir();
    }
  }

  @RequestMapping(value = "", method = RequestMethod.POST)
  public BaseResponse upload(@RequestParam("file") MultipartFile file) throws IOException {
    if (file.isEmpty()) {
      return BaseResponse.builder().isSuccess(false).msg("ÇëÑ¡ÔñÎÄ¼þ").build();
    }
    String fileId = saveFile(file);
    return BaseResponse.builder().isSuccess(true).data(fileId).build();
  }

  private String saveFile(MultipartFile file) throws IOException {
    if (file.getSize() == 0) {
      return "";
    }
    String prefixName = getPrefixName();
    String fileName = prefixName + SEPARATOR + file.getOriginalFilename();
    uploadInternal(file, fileName);
    return prefixName;
  }

  private String getPrefixName() {
    return UUID.randomUUID().toString().replaceAll("-", "") + ThreadLocalRandom.current().nextInt(999999);
  }

  private void uploadInternal(MultipartFile file, String fileName) throws IOException {
    if (System.getProperty("os.name").toLowerCase().startsWith("win")) {
      File dest = new File(fileCacheLocal + fileName);
      file.transferTo(dest);
    } else {
      OssUtil.simpleUpload(fileName, file.getInputStream());
    }
  }

  @PostMapping("/multiUpload")
  @ResponseBody
  public BaseResponse multiUpload(HttpServletRequest request) throws IOException {
    List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
    List<String> fileIds = new ArrayList<>();
    for (int i = 0; i < files.size(); i++) {
      MultipartFile file = files.get(i);
      fileIds.add(saveFile(file));
    }
    return BaseResponse.builder().isSuccess(true).data(fileIds).build();
  }

}
