package chap5

/**
  * Created by Administrator on 2017/1/8 0008.
  */
object PFunction extends App {
  val sample = 1 to 10
  /**
    * 偏函数 只处理为偶数的参数 其余的抛异常
    */
  val isEven:PartialFunction[Int,Any] = {
    case x if (x%2==0)=>{
      println(x+" is even")
    }
  }
  val isOdd:PartialFunction[Int,Any] = {
    case x if (x%2==1)=>{
      println(x+" is odd")
    }
  }

  try{
    isEven(9)

  }catch {
    case e:Exception=>{
      println(e.getCause)
    }
  }
  isEven(10)

  for(i<-sample.reverse){
    try{
      isEven(i)
    }catch {
      case _:Exception=>{
        printf("%d is NOT even\n",i)
      }
    }
  }

  sample.map(isEven
    orElse(isOdd))

  def receive:PartialFunction[Any,Any]={
    case s:Int=>printf("%s Int type.\n",s)
    case s:String=>printf("%s String type.\n",s)
    case s:Double=>printf("%s Double type.\n",s)
    case _:Any=>println("Other types")
    case null=>println("Null")
  }

  var `try` ={
    val list = List(1,2,2.5,2.5f,"233",scala.io.StdIn,null,true,None)
    for(i<-list){
      receive(i)
    }
  }


}
