object Main extends App {
  def plus(a: Int, b: Int) = a + b

  def apply(fun: (Int, Int) => Int, a: Int, b: Int) = fun(a, b)

  println(apply(plus, 2, 3))
  val add = plus _
  println(plus(1, 2))
  println(add(5, 7))

  //  Function literal <=> anonymous function
  // Function literals are values

  val numbers = List(2, 3, 4, 4, 2, 5, 25, 21, 3)
  println(numbers.sortWith((a, b) => a > b))
  println(numbers.sortWith((a, b) => a < b))

  val languages = List("Java", "Scala", "Python")
  println(languages.sortWith((a, b) => a > b))
  println(languages.sortWith((a, b) => a.length < b.length))
}
