package chap8



/**
  * Created by Administrator on 2017/1/10 0010.
  */
package cn {
  package object Math{
    val PI = "Huji"+math.Pi//可以用cn.Math.PI访问
  }
  package scala {

    class Apple {
      println("挨一炮!")
      val name = "apple-pie"
    }

     class Banana {
      private[this]  def print = {
        println("黑又粗")
      }



      //private[this]限定的是只有在该类的对象才能访问
    }
    private[scala] class Orange{
      println("挤出鲜嫩多汁")
    }

    private[scala] object Utils{
      //private[scala]限定了这个object只能在cn.scala里面使用了
    }

    object U{
      def getO:Orange = new Orange
    }


  }

}


object Main extends App {
  var apple = {
    import cn.scala.Apple
    new Apple
  }
  println(apple.name)
  var orange = {
    import cn.scala.U
    U.getO
  }
  orange.toString
  println({
    import cn.Math
    Math.PI
  })

  var javaHashMap = {
    import java.util.{HashMap=>JavaHashMap}//重命名
    val javaHashMap = new JavaHashMap[Int,String](){{
      this.put(5,"5")
      this.put(65,"KON")
    }}
    javaHashMap
  }
  println(javaHashMap)
  val scalaHashMap ={
    import java.util.{HashMap=>_,_}//隐藏这个HashMap
    import scala.collection.mutable.HashMap
    new HashMap[Int,Double]{{
      this.+=((5,25.7),(4,16.5),(3,9.145))
    }}
  }
  println(scalaHashMap)



}
