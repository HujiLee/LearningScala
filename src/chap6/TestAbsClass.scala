package chap6

/**
  * Created by Administrator on 2017/1/10 0010.
  */
object TestAbsClass {

  abstract class Person {
    var name: String

    //在抽象类里面这个成员变量可以不初始化
    def print: Unit
  }

  abstract class Student extends Person {
    override var name: String = _

  }

  class Xiaoxuesheng($name: String) extends Student {
    this.name = $name + 1

    override def print: Unit = {
      println("$name =" + $name)
      println(s"name = $name")
    }
  }


  def main(args: Array[String]): Unit = {
    val xiaoxuesheng = new Xiaoxuesheng($name = "神话")
    /* 调试可见
     = "神话"
     name = "神话1"
     */
    xiaoxuesheng.print
    /*
    $name =神话
    name = 神话1
        */

    /**
      * 匿名类 只使用一次的类
      */
    val person = new Person {
      override def print = println(name)

      override var name: String = "hujimiya"
    }

    person.print
  }
}
