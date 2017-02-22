package chap6

import scala.beans.BeanProperty

/**
  * Created by Administrator on 2017/1/8 0008.
  */
package iosos{
  class Person extends Run {
    /**
      * BeanProperty可以让它有Java风格的getter和setter
      */
    @BeanProperty var name: String = _

    override def run(): Unit = {
      println(s"[name=$name] is running")
    }
  }
}



class Hujimiya {
  private var name: String = "pri-Hujimiya"
}

object Hujimiya extends Run {
  private var no: Int = 65

  def uniqueNo = {
    no += 1
    no
  }

  /**
    * 伴生对象里的apply方法方便我们在后面省略new
    *
    * @return
    */
  def apply(): Hujimiya = new Hujimiya()

  override def run(): Unit = {
    println(s"($no is running")
  }
}
object Male extends Sex{

}
object Female extends Sex{

}
object NoSex extends Sex{}
object DoubleSex extends Sex{}
class Fruit(var name: String) {
  override def toString: String = s"[fruit:$name]"

  def getName(): String = {
    println(this.name)
    this.name
  }


  var sex:Sex = _
  def this( isMale:Sex=NoSex){
    this("sex")
    this.sex = isMale
  }
}

class Apple( name: String, var size: Int) extends Fruit(name){
  override def toString: String = s"[apple:$name]"
}

class Banana( name:String, var color:String) extends Fruit{
  override def toString: String = s"[banana:$name]"
}
class Book(val name:String){
  var author:String = "Hujimiya"
  def this( name:String,author:String){
    this(name)
    this.author = author
  }
}
