import scala.util.Try

object DarkSyntaxSugar extends App {
  //  syntax sugar #1: method with single param
  def singleArgMethod(arg: Int): String = s"Your age is $arg"

  val simpleCallMethod = singleArgMethod {
    45
  }

  val aTryInstance = Try { // java's try {...}
    throw new RuntimeException
  }

  List(1, 2, 3).map { x =>
    x + 1
  }

  //  syntax sugar #2: single abstract method
  // Example 1
  trait Action {
    def act(x: Int): Int
  }

  val anInstance = new Action {
    override def act(x: Int): Int = x + 1
  }

  val aFunkyInstance: Action = (x: Int) => x + 1

  //  Example 2: Runnable
  val aThread = new Thread(new Runnable {
    override def run(): Unit = println("Hello, Scala!")
  })

  val aSweetThread = new Thread(() => println("Sweet, Scala!"))

  //  Example 3
  abstract class anAbstractType {
    def implemented: Int = 34

    def f(a: Int): Unit
  }

  val anAbstractInstance: anAbstractType = (a: Int) => println("Sweet")

  //  syntax sugar #3: the :: and #:: methods are special

  val prependedList = 3 :: List(4, 5)

  //  scala spec: last char decides associativity of methods
  1 :: 2 :: 3 :: List(4, 5)
  List(4, 5).::(3).::(2).::(1) // equivalent

  class MyStream[T] {
    def -->:(value: T): MyStream[T] = this //actual implementation here
  }

  val myStream = 1 -->: 2 -->: 3 -->: new MyStream[Int]

  // syntax sugar #4: multi-word method naming
  class TeenGirl(name: String) {
    def `and said then`(gossip: String): Unit = println(s"$name said $gossip")
  }

  val lilly = new TeenGirl("Lilly")
  lilly `and said then` "Scala is so sweet!"

  // syntax sugar #5: infix types
  class Composite[A, B] {
    //    def composite: Composite[Int, String] = ???
    def composite: Int Composite String = ???
  }

  class -->[A, B] {
    def towards: Int --> String = ???
  }

  // syntax sugar #6: update() is special, much like apply()
  val anArray = Array(1,2,3)
  anArray(2) = 7 // rewritten to anArray.update(2, 7)
  // used in mutable collections
  // remember apply() AND update()!

  // syntax sugar #7: setter for mutable containers
  class Mutable {
    private var internalMember: Int = 0
    def member: Int = internalMember // getter
    def member_=(value: Int): Unit =
      internalMember = value // setter
  }

  val aMutableContainer = new Mutable
  aMutableContainer.member = 3 // rewritten aMutableContainer.member_=(3)
}
