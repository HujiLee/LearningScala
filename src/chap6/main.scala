package chap6

import chap6.iosos.Person

/**
  * Created by Administrator on 2017/1/8 0008.
  */
object Ns extends Run{
  private val name = "Lsj"
  private val age = 18

  override def run(): Unit = {
    println(s"$name go go go")
  }
}

object main extends App  {
  Ns.eq(null)
  val person = new Person
  person.getName


  var hujimiya = Hujimiya()
  var apple = new Apple("aipao",5)
  apple.getName()
  var banana = new Banana("KON","yellow")
  banana.getName()

  var akalin = new Fruit()
  println(akalin.sex)
  val Cpp = new Book("C++")
  val Java = new Book ("Java")
  val iOS = new Book("Swift or Obj-C",author = ???)
  println(iOS)





}
