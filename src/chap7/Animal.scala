package chap7

import chap7.$Sex.$Sex

/**
  * Created by Administrator on 2017/1/10 0010.
  */
class Animal(sex: Sex=Sex.male) {
  override def toString: String = s"雌雄=$sex"
}
class People(_sex:$Sex = $Sex.female){
  override def toString: String = s"男女="+_sex.toString()
}
object Main extends App{
  val animal = new Animal()
  val people = new People()
  println(animal.toString)
  println(people.toString)
}