package chap6

/**
  * Created by Administrator on 2017/1/10 0010.
  */
object 主构造函数中的成员访问 extends App {

  class Person(protected var name: String, var age: Int)

  class Student(name: String = "student-huji", age: Int,  studentNo: String = "12345") extends Person(name, age){
    override def toString: String = s"学生ID=$studentNo"
  }

  class Daxuesheng(age: Int, private val grade: Int) extends Student(age = age)//最终会生成private的getter和setter
  class Xiaoxuesheng(var studentNo:String) extends Student("0",-5,studentNo)



  var person = new Person(age = 15, name = "PersonB")
  //  println(person.name)//无法访问name name是protected
  var student = new Student(name = "K-ON", studentNo = "14785412", age = 14)
//  student.studentNo//无法访问,studentNo是默认的private[this],最后变成private final
  var daxuesheng = new Daxuesheng(15, 4)
  daxuesheng.age = 115//可以访问age 因为age是var
//  daxuesheng.grage//访问不了
  var xiaoxuesheng = new Xiaoxuesheng("-5145266")
  xiaoxuesheng.studentNo = "A5142"//改变的是小学生的NO,学生的NO还是"-5145266"

  class PC(name:String){
     val s_name = name
  }
  val pC = new PC("惠普")//调试可见PC最后只有一个变量s_name
  pC.s_name
  class Note(private val iname:String){
    def getName:String = {
      return iname
    }
  }
  var note = new Note("刺客")//调试最后只有一个成员变量iname
  class _C(private[this] val name:String)
  var _c = new _C("KK_C")//调试发现Class has no fields 因为name在类里面最终没有使用到,编译器干脆不生成

  println()



}
