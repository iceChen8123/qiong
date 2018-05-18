package com.ice;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BaseResponse {

  private boolean isSuccess = true;

  private Object data;

  private String msg;

}
