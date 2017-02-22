package chap5

/**
  * Created by Administrator on 2017/1/7 0007.
  */
object Closure extends App {
  """
    |An object is data with functions.
    |A closure is a function with data.
  """.stripMargin
  var i = 15
  var f = (x:Int)=>x+i


}
