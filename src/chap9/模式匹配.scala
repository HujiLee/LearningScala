package chap9

/**
  * Created by Administrator on 2017/1/11 0011.
  */
object 模式匹配 extends App {
  var _ = {
    for (i <- 0 to 5) {
      i match {
        case 1 => println(1)
        case 2 => println(2)
        case x if (x >= 2) => {
          println(s"$x > 2")
        }
        case _ => println("其他")
      }
    }
  }
  var $s = {
    /**
      * 常量和变量模式匹配
      * @param x
      * @return
      */
    def $__(x: Int): Any = x match {
      case 0 => 0
      case 1 => "0001"
      case x if (x > 1) => x
      case y => y.toString
    }
    $__(0)
    $__(1)
    $__(5)
    $__(-8)
  }
  $s = {

    case class Dog(val name:String,val age:Int=5)
    case class Point(val x:Int  = 0,val y:Int = 0)
    val dog = Dog("PetDogge")
    val point = Point()
    def patternMatching(x:AnyRef): String = x match {
      case Dog(name,age)=>(s"[Dog  = $x")
      case Point(ix,iy)=>x.toString+s"{$ix,$iy}"
      case i=>i.toString+">>55"
    }
    patternMatching(dog)
    patternMatching(new Integer(5))
    patternMatching(point)
    /**
      * 构造函数模式
      */
  }
  $s = {
    /**
      * 序列模式
      */
    val arrInt = Array(1,2,3,4)
    val arrInt2 = Array(1,2,3,4,5)
    def patternMatching(x:AnyRef) = x match {
      case Array(first,second)=>(first,s"second = $second")
      case Array(_,_,_,s4th)=>s4th
      case Array(_,_,_,s4th,_*)=>(s4th,"第五个")//_*放在最后 匹配剩余若干个元素
    }
    patternMatching(arrInt)
    patternMatching(arrInt2)
  }

  $s = {
    var tuple1 = Tuple1(1)
    var tuple2 = (5,6)
    var tuple4 = (7,1,5,"OP")
    def patternMatching(x:AnyRef) = x match {
        //无法匹配(first)形式
      case Tuple1(fir)=>s"only one:$fir"
      case (first,second)=>s"tuple2 = <$first,$second>"
      case (first,_,_,fourth)=>s"tuple4 = >$first,$fourth<"
      case _=>x
    }
    patternMatching(tuple1)
    patternMatching(tuple2)
    patternMatching(tuple4)
  }

  $s = {
    val s = "string"
    val i = 25
    val t = (1,2,3)
    val n = null
    class A
    class B extends A
    val a = new A
    val b = new B

    /**
      * 类型模式
      * @param x
      * @return
      */
    def matching(x:Any)=x match {
      case i:String =>"String"
      case i if(i.isInstanceOf[Int])=>"Int"
      case i:Tuple3[Int,Int,Int]=>"Tuple3"
      case i:B=>"type B"
      case i:A=>"type A"
      case i =>String.valueOf(i)//不能用i.toString 会出null pointer exception
    }
    matching(n)
    matching(s)
    matching(i)
    matching(t)
    matching(a)
    matching(b)
  }
  $s={
    /**
      * 变量绑定模式
      *
      */
    def matching(x:AnyRef) = x match {
      case d@Dog(_,_)=>d.toString()
      case e@List(_,e2@List(4,i2,_*))=>e2.toString()+s"i2 = $i2"
      case _=>None.toString
    }
    case class Dog(name:String="doge",age:Int = 18)
    matching(new Dog("huji"))//Dog(huji,18)
    matching(List(List(1,2,3),List(1,2,3)))//None
    matching(List(List(1,2,3),List(4,1,2,3)))//List(4, 1, 2, 3)i2 = 1
  }




  println()




}
