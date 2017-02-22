package chap7

import java.util

/**
  * Created by Administrator on 2017/1/10 0010.
  */
object TestTrait extends App {

  trait Closable {
    def close(): Unit //只有抽象的时候 trait会被翻译成interface
    /**
      * public interface chap7.TestTrait$Closable {
      * public abstract void close();
      * }
      */
  }

  class File(filename: String) extends Cloneable {
    def close(): Unit = {
      println(s"s$filename is closed")
    }

    /**
      * public class chap7.TestTrait$File implements scala.Cloneable {
      * private final java.lang.String filename;
      * public void close();
      * public chap7.TestTrait$File(java.lang.String);
      * }
      */
  }

  var closable = new Closable {
    override def close() = println(s"$close is closed")
  }
  var file = new File("killey.txt")
  file.close()

  /**
    * 同时有抽象和具体的trait
    * 生成两个class
    *
    */
  trait FileDao{
    var recordNum:Long = _//具体成员变量
    def add(file:File):Unit
    """TestTrait$FileDao$class.class
      |public abstract class chap7.TestTrait$FileDao$class {
      |  public static void $init$(chap7.TestTrait$FileDao);
      |}
      |
    """.stripMargin
    """TestTrait$FileDao.class
      |public abstract class chap7.TestTrait$FileDao$class {
      |  public static void $init$(chap7.TestTrait$FileDao);
      |}
      |
      |"""
  }

  class Circle( val radius:Double)
  trait CircleDao{
    //具体变量
    protected val circles = new util.LinkedList[Circle]()
    //具体方法
    def add(circle: Circle):Unit={
      this.circles.add(circle)
    }

    //抽象方法
    def update(circle: Circle)
  }

  class JutiCircleDao extends CircleDao{
    //实现抽象方法
    override def update(circle: Circle): Unit = {
      this.circles.add(circle)
    }
  }



}
