package chap7

import java.io.PrintWriter

/**
  * Created by Administrator on 2017/1/10 0010.
  */
object TestLazy extends App {

  trait Logger {
    println("Logger")

    def log(msg: String): Unit
  }

  trait FileLogger extends Logger {
    val fileName: String
    lazy val fileOutput = new PrintWriter(fileName: String) //必须用lazy来避免空指针异常

    def log(msg: String): Unit = {
      fileOutput.println(msg)
      fileOutput.flush()
    }


  }
  class A_Logger extends FileLogger {
    val fileName: String = "alog.log"
  }

  val a_Logger = new A_Logger()
  a_Logger.log("Trait demo")

}
