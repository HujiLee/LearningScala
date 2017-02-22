package chap3

/**
  * Created by Administrator on 2017/1/7 0007.
  */
import scala.util.control.Breaks._

object chap3 extends App {
  var x ={
    if ("" == "") 1 else 0
  }
  breakable{
    for(i<-1 to 5){
      if(i>3) break
      printf("[%s]\n",i)
    }

  }

  for(i<-1 to 5 if(i<=3)){
    printf(">%s<\n",i)
  }

  val y = for(i<-1 to 5) yield (i*i)//
  println(x)
}
