package chap4

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

/**
  * Created by Administrator on 2017/1/7 0007.
  */
object M extends App {
  val immutableSet = Set(1, 2, 3)

  import scala.collection.mutable

  val mutableSet = mutable.Set(9, 8, 7)
  mutableSet += 75

  var tryarray = {
    val array = Array(7, 8, 9)
    val arrayBuffer = ArrayBuffer(7, 8, 9, 10)
    arrayBuffer.+=(11)
    val arraySeq: mutable.ArraySeq[Any] = mutable.ArraySeq('a, 'b')
    arraySeq.drop(0)
    println()


  }

  var tryQueue = {
    val queue: mutable.Queue[Any] = mutable.Queue(7, 8, 9, " ")
    queue.+=(789)
    queue.dequeue()
    queue.enqueue(1 << 5)
    println(queue)
  }

  val tryList = {
    val list = List(7, 8, 6, 5)
    val listBuffer = ListBuffer(-1, -2, -3)
    listBuffer += (1, 2)
    val mutableList = mutable.MutableList(" ", 7)
    mutableList.+=(1, 2)
  }

  val truArrayBuffer = {
    val stringBuffer = ArrayBuffer[String]()
    stringBuffer += "14"
    stringBuffer.+=("\u0025\u1425", "あの日見た花の名前を僕達はまだ知らない")
    stringBuffer.++=(Array("new", Boolean.toString(), true.toString))
    stringBuffer trimEnd 2 //删除末尾2个元素
    println(stringBuffer)
    stringBuffer insert(0, ">>>") //插入第0个位置
    stringBuffer.insert(0, "><", "233") //插入两个到第0个位置
    println(stringBuffer)
    stringBuffer.remove(0, 3) //第0个位置移除3个元素
    print()
  }

  val tryListAgain = {

    import scala.collection.mutable.ListBuffer
    var doubleList = ListBuffer[String]()
    doubleList.+=("Str", ">>>")
    println(doubleList.head, doubleList.tail, doubleList.tail.head)

    import scala.collection.immutable.List
    var $6to3 = List.range(6, 2, -1)

    print()


  }

  object setset{
    var sortedSet = mutable.SortedSet[String]()
    sortedSet.+=("").+=("Str","-+","()","123")
    println(sortedSet)
  }

  val s = setset.sortedSet

  val tryMap = {
    val str2Int = mutable.LinkedHashMap[String,Int]()
    str2Int put ("Spark",1)
    str2Int.put("Cdf",2)
    str2Int.put("1",1)
    str2Int.put("1",9)
    var _ = str2Int.contains("Spark")


    print()
  }


  println()

}
