package dcs.controller

import net.csdn.annotation.rest.At
import net.csdn.modules.http.{ApplicationController, RestRequest}

/**
 * 4/5/16 WilliamZhu(allwefantasy@gmail.com)
 */
class ExampleController extends ApplicationController {

  @At(path = Array("/hello"), types = Array(RestRequest.Method.GET, RestRequest.Method.POST))
  def hello() = {
    render(s"hello ${param("content")}")
  }
}
