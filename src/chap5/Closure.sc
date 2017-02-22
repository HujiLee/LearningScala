var i = 15
var f = (x:Double)=>x+i
f(10)
i = 255
f(10)
var hf = (f:Double=>Double,p:Double=>Unit)=>{
  val x = f(10)
  p(x)
}
var p = ($:Double)=>{
  println($)
}
hf(f,p)
f= (x:Double)=>x-i
i = 2
hf(f,p)

var goVar = 10
var go =()=>{
  goVar+=1
  println(goVar)
}
go()
go()

var alpha = ()=>{
  var x= 0
  def inner:Int={
    x+=1
    x
  }
  inner
}

alpha()





val xml = <element attibute="value">data</element>
