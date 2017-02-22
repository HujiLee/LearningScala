object O{
  trait A{
    def print:Unit
  }
  trait B1 extends A{
    override def print: Unit = println("B1")
  }
  trait B2 extends A{
    override def print: Unit = println("B2")
  }
  class C extends B1 with B2{

  }
}

val c = new O.C
c.print//"B2"
//最右深度优先遍历

object P{
  trait A{
    def print(msg:String) = println(s"$msg:Trait A")
  }
  trait B1 extends A{
    override def print(msg: String): Unit = super.print(msg+": Trait B1]")
  }
  trait B2 extends A{
    override def print(msg: String): Unit = super.print(msg+": Trait B2]")
  }
  class C extends B1 with B2{

  }
}

val c2 = new P.C
c2.print("<C>")//"<C>: Trait B2]: Trait B1]:Trait A"
/**
  * Bug why????
  */


