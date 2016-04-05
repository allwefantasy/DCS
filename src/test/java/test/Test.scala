package test

import _root_.com.redis.RedisClientPool
import scala.collection.JavaConversions._
import java.util
/**
 * Created by 改改 on 2014/5/28.
 */
object Test {

  def main(args: Array[String]) {
    val redisClientPool: RedisClientPool = new RedisClientPool("192.168.4.201", 6379)

    redisClientPool.withClient(c =>{
      c.mset(("111", """{"id":"111","title":"111_title"}"""))
      c.mset(("222", """{"id":"222","title":"222_title"}"""))
      c.mset(("333", """"{"id":"333","title":"333_title"}""""))
    })
    redisClientPool.withClient(c =>{

      val list: util.List[String] = new util.ArrayList[String]()
      list.add("111")
      list.add("222")
      list.add("333")
      c.mget(list(0),list.subList(1,list.size-1):_*)
    }) match {

      case Some(v) => {
        v.foreach(
          c =>{
            c match {
              case Some(cur) =>{
                println(cur)
              }
              case None =>{println("none")}
            }

          }
        )
      }
      case None => println("123")
    }
  }
}
