package dcs

import net.csdn.ServiceFramwork
import net.csdn.bootstrap.Application
import net.csdn.modules.http.PortGenerator

/**
 * 4/5/16 WilliamZhu(allwefantasy@gmail.com)
 */
object DCS {
  def main(args: Array[String]) = {
    PortG.setPort(args(0).toInt)
    ServiceFramwork.scanService.setLoader(classOf[DCS])
    ServiceFramwork.applicaionYamlName("application.dynamic.yml")
    Application.main(args)
  }
}

class DCS

class PortG extends PortGenerator {
  override def getPort: Int = PortG.port
}

object PortG {
  var port = 8080

  def setPort(p: Int) = {
    port = p
  }
}
