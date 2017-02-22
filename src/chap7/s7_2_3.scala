package chap7

import java.io.PrintWriter

/**
  * Created by Administrator on 2017/1/10 0010.
  */

object _s {

  trait run {
    def run(): Unit
  }

}


object s7_2_3 extends App with _s.run {
  def run: Unit = {
    println(233)
  }

  Class.forName(this.getClass.getName).newInstance().asInstanceOf[_s.run].run()
  var s7 = Class.forName(this.getClass.getName).newInstance()
  var s7_2 = Class.forName(this.getClass.getName).newInstance()
  s7.asInstanceOf[_s.run].run()
  s7_2.asInstanceOf[_s.run].run

  trait Logger {
    println("Logger")

    def log(msg: String): Unit
  }

  trait FileLogger2 extends Logger {
    val fileName: String
    val fileOutput = new PrintWriter(fileName)

    override def log(msg: String): Unit = {
      fileOutput.println(msg)
      fileOutput.flush()
    }
  }

  trait FileLogger extends Logger {
    val fileName: String
    lazy val fileOutput = new PrintWriter(fileName: String)

    //必须用lazy来避免空指针异常
    //    fileOutput.println("#")//这一句不能有
    def log(msg: String): Unit = {
      fileOutput.println(msg)
      fileOutput.flush()
    }
  }
  class A_Logger extends FileLogger {
    val fileName: String = "alog.log"
  }

  val a_Logger = new A_Logger()
  a_Logger.log("Trait demo 懒加载")
  var b_logger = new {
    override val fileName = "blog.log"
  } with FileLogger2  //或者采用这种提前加载的方式
  b_logger.log("提前加载")


}
