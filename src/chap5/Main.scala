package chap5

import java.util

import scala.collection.JavaConverters._

/**
  * Created by Administrator on 2017/1/7 0007.
  */
object Main extends App {
  override def toString: String = {
    this.hashCode().toString
  }

  def gcd(x: Int, y: Int): Int = {
    if (x % y == 0) {
      y
    } else {
      gcd(y, x % y)
    }
  }

  def gcd(x: Int, y: Int, print: Boolean): Int = if (!print) {
    gcd(x, y)
  } else {
    println(gcd(x, y))
    return gcd(x, y)
  }

  println(gcd(1, 2))
  gcd(45, 18, true)

  val sum = (x: Int, y: Int) => {
    println(x + "+" + y)
    x + y
  }

  sum.apply(9, 10)

  def higherOrderFunction(f: Double => Double) = {
    println(f(100.0))
  }

  higherOrderFunction(x => x + 7)

  var hssMap = scala.collection.mutable.HashMap[Int, Any]()
  hssMap.+=((7, 4), (74, Main))
  val s = hssMap.map(y => y._2.toString)

  //flatMapy and Map
  var listInt = List(1, 2, 3, 4)
  var list_Map = listInt.map(x => x match {
    case 1 => List(1)
    case _ => List(2 * x)
  })

  val list_flatMaped = listInt.flatMap(x => x match {
    case 1 => List(1)
    case _ => List(2 * x)
  })

  val list_folded = listInt.fold(-5)((x,y)=>x+y)




  println(55)

}
