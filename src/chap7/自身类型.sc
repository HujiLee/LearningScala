trait BB {
  val value = "BB"
}
trait AA {
  this: BB =>
  val value: String = "AA"
}
class CC extends AA with BB {
  //要继承AA,必须同时继承BB
  override val value = "CC"
}
class DD extends BB {
  //可以单独继承BB
}
val cc = new CC
cc.value
cc.asInstanceOf[AA].value //"CC"
cc.asInstanceOf[BB].value//"CC"

class OuterClass {
  selfffff =>
  //定义了一个外部类别名self
  val value = "outer"
  class InnerClass {
    def run()={
      println(selfffff.value)
    }
  }
  def foo(): Unit = {
    val innerClass = new InnerClass
    innerClass.run()
  }
}

val outerClass = new OuterClass
outerClass.foo()

