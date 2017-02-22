
object testProtected{
  class Person{
    protected var name:String = "{More}"
    def print()={
      println(s"(Person:$name)")
    }
  }
  class Student extends Person{
    override def toString: String = s"[Student:$name]"
  }
}
val p1 = new testProtected.Person
var s1 = new testProtected.Student

object testPrivate{
 class Person{
   private var name:String = "<Private>"
   def print={
     println(this.name)
   }
 }
  class Student extends Person{
    val name = "Student"
    override def toString: String = Array("are","you","OK").toString
  }
}
var p2 = new testPrivate.Person
var s2 = new testPrivate.Student
p2.print
s2.print
object privateThis{
  class P{
    private[this] var name:String = "private-this-Person"
    var common = 123456
    def printColor = {
      println(P.color)
    }
  }
  object P{
    private var color = "Yellow"

    //不能访问伴生类中的name
    /*def printName= {
      println(new P().name)
    }*/
  }
}
