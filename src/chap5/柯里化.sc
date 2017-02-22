
/**
  * 这是一个可以生成函数的高阶函数
  * @param factor
  * @return
  */
def high(factor:Int)={
  (x:Double)=>factor*x
}
high(5)
high(5)(10)
/**
  * 这是一个柯里化函数 并不能返回一个函数
  * @param factor
  * @param x
  * @return
  */
def curry(factor: Int)(x:Double)={
  factor*x
}
curry(5)(x = 7)
curry(5)(10)
//curry(5)不能返回一个函数 会报错
//paf是一个 部分应用函数
val paf = curry(5)_
paf(7)

def summ(x1:Int,x2:Int,x3:Int)=x1+x2+x3+0.0

//普通函数也可以有部分应用函数
def sum$1 = summ(_:Int,2,3)
sum$1.apply(-1)

def sum$2 = summ(_:Int,_:Int,6)
sum$2.apply(-1,-1)





