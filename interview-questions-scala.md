I took [this list](https://www.journaldev.com/8958/scala-interview-questions-answers#scala-interview-questions) as a base for many questions and answers.

### Like Java’s java.lang.Object class, what is the super class of all classes in Scala?

As we know in Java, the super class of all classes (Java API Classes or User Defined Classes) is java.lang.Object. In the same way in Scala, the super class of all classes or traits is “Any” class.

Any class is defined in scala package like “scala.Any”.

### What is default access modifier in Scala? Does Scala have “public” keyword?

In Scala, if we don’t mention any access modifier to a method, function, trait, object or class, the default access modifier is “public”. Even for Fields also, “public” is the default access modifier.

Because of this default feature, Scala does not have “public” keyword. 

### What is “Type Inference” in Scala?

Types can be inferred by the Scala Compiler at compile-time. It is known as “Type Inference”. Types means Data type or Result type. We use Types at many places in Scala programs like Variable types, Object types, Method/Function Parameter types, Method/Function return types etc.

In simple words, determining the type of a variable or expression or object etc at compile-time by compiler is known as “Type Inference”.

### What is a side effect?
A side effect is:
* modifying a non-local or a static variable
* using IO 
* calling another side effecting function.

### What is a pure function?
* No side effects
* Always returns the same outputs for the same inputs

### What's the difference between methods and functions?
In Scala methods and functions are different syntactially and semantically as well.
Functions are marked with `var` or `val` keywords eg: `val f = (x: Int) => x + 2`.

Methods are marked with the `def` keyword eg: `def f(x: Int) = x + 2`.

Functions cannot have a type parameter, methods can. eg: `def f[A](): A`

Functions and methods have different implementations as well. 
Functions in 2.12 use Java8 lambdas, before 2.12 there was a custom implementation. 

### What is an Expression? What is a Statement? Difference between Expression and Statement?

__Expression:__
Expression is a value that means it will evaluate to a Value. As an Expression returns a value, We can assign it to a variable. Expressions may or may not have side effects.

Example:- Scala’s If condition, Java’s Ternary operator.

__Statement:__
Statement defines one or more actions or operations. That means Statement performs actions. As it does not return a value, we cannot assign it to a Variable.
We only use Statements for side effects.

Example:- Java’s If condition.

### What are the default imports?
* java.lang package
* scala package
* scala.PreDef

### What is Nothing in Scala?
In Scala, Nothing is a Type (final class). It is defined at the bottom of the Scala Type System that means it is a subtype of anything in Scala. There are no instances of Nothing.
* Nothing can represent a return type that never returns
* For example: Nil and None is defined with the help of Nothing

### What is Null in Scala? What is null in Scala? 
Null is a Type (final class) in Scala. Null type is available in “scala” package as “scala.Null”. It has one and only one instance that is null.
In Scala, “null” is an instance of type scala.Null type.
Null is a subtype of all Reference types.
As it is NOT a subtype of Value types, we cannot assign “null” to any variable of Value type.

### What is Unit in Scala? What is the difference between Java’s void and Scala’s Unit?
In Scala, Unit is used to represent “No value” or “No Useful value”. Unit is a final class defined in “scala” package that is “scala.Unit”.

Unit is something similar to Java’s void. But they have few differences.

* Java’s void does not any value. It is nothing.
* Scala’s Unit has one value ()
* () is the one and only value of type Unit in Scala. However, there are no values of type void in Java.
* Java’s void is a keyword. Scala’s Unit is a final class.

Both are used to represent a method or function is not returning anything.

### What is REPL in Scala? What is the use of Scala’s REPL?

REPL stands for Read-Evaluate-Print Loop. In Scala, REPL is acts as an Interpreter to execute Scala code from command prompt. That’s why REPL is also known as Scala CLI(Command Line Interface) or Scala command-line shell.

The main purpose of REPL is that to develop and test small snippets of Scala code for practice purpose. It is very useful for Scala Beginners to practice basic programs.

### Does Scala support Operator Overloading? Does Java support Operator Overloading?

Java does not support Operator Overloading. Scala supports Operator Overloading.

The reason is that Java does not want to support some misleading method names like “+*/”. Scala has given this flexibility to Developer to decide which methods/functions name should use.

When we call 2 + 3 that means ‘+’ is not an operator, it is a method available in Int class (or it’s implicit type). Internally, this call is converted into “2.+(3)“.

### What is Primary Constructor? What is Secondary or Auxiliary Constructor in Scala? What is the purpose of Auxiliary Constructor in Scala? Is it possible to overload constructors in Scala?

 Scala has two kinds of constructors:

    Primary Constructor
    Auxiliary Constructor

Primary Constructor
In Scala, Primary Constructor is a constructor which is defined with class definition itself. Each class must have one Primary Constructor: Either Parameter constructor or Parameterless constructor.

Example:-


```scala 
class Person
```

Above Person class has one Zero-parameter or No-Parameter or Parameterless Primary constructor to create instances of this class.

```scala
class Person (firstName: String, lastName: String)
```

Above Person class has a two Parameters Primary constructor to create instances of this class.

Auxiliary Constructor
Auxiliary Constructor is also known as Secondary Constructor. We can declare a Secondary Constructor using ‘def’ and ‘this’ keywords as shown below:

```scala
class Person (firstName: String, middleName:String, lastName: String){
  def this(firstName: String, lastName: String){
      this(firstName, "", lastName)
  }
}
```

### Difference between Array and List in Scala?

* Arrays are always Mutable where as List is always Immutable.
* Arrays are Invariants where as Lists are Covariants.


### What is the Relationship between equals method and == in Scala? Differentiate Scala’s == and Java’s == Operator?

In Scala, we do NOT need to call equals() method to compare two instances or objects. When we compare two instances with ==, Scala calls that object’s equals() method automatically.

Java’s == operator is used to check References Equality that is whether two references are pointing to the same object or not. Scala’s == is used to check Instances Equality that is whether two instances are equal or not. 

### What is apply method in Scala? What is unapply method in Scala? What is the difference between apply and unapply methods in Scala?

In Scala, apply and unapply methods play very important role.
* apply method: To compose or assemble an object from it’s components.
* unapply method: To decompose or dis-assemble an object into it’s components.

Apply is just a normal function with syntactic sugar (you don't need to write `ObjectName.apply(...)` only `ObjectName(...)`).

Unapply is not a normal function.
An object with an unapply method is called an [extractor object](https://docs.scala-lang.org/tour/extractor-objects.html).
Extractors can be used in:
* match expressions
* for comprehensions (to the left from `<-`s)
* val-s (eg: `val MyExtractor(thing) = value1` will bind the extracted value to `thing`)
* partial functions

### What is pattern matching?
From: https://docs.scala-lang.org/tour/pattern-matching.html
"""Pattern matching is a mechanism for checking a value against a pattern. A successful match can also deconstruct a value into its constituent parts. It is a more powerful version of the switch statement in Java and it can likewise be used in place of a series of if/else statements."""

### What is an Algebraic Data Type or (ADT)?
Long answer: 
https://alvinalexander.com/scala/fp-book/algebraic-data-types-adts-in-scala

Short answer: 
An ADT is a combination of Sum and/or Product types
Product and Sum names imply the number of possibile values that can be created by an ADT.

An example for Sum type is Option. There are 2 possibilities Some and None. So we __sum__ the number of possible values contained by Some and None

Two product types are Some and None. None adds zero possible values.
The number of values for Some depends on its type parameter.
Some[Boolean] has 2 possible values true and false.
Some[Byte] has 256 possible values. So Option[Byte] -> (Some[Byte] = 256 + None = 0) = 256

Some could contain a case class or tuple eg: Some[(Byte, Byte)] which would be 256 * 256 = 65536 possibilities. We multiply the number possiblities, hence the name __product__ type.


### What is a Companion Object in Scala? What is a Companion Class in Scala?

 In simple words, if a Scala class and object shares the same name and defined in the same source file, then that class is known as “Companion Class” and that object is known as “Companion Object”.

When we create a Class by using Scala “class” keyword and Object by using Scala “object” keyword with same name and within the same source file, then that class is known as “Companion Class” and that object is known as “Companion Object”.

### What are the differences between Case class and Normal Class?

Case class is also a class, however when we compare it with normal class, it gives the following extra features or benefits:

* By default, Case-class constructor parameters are ‘val’. We don’t need to declare parameters with ‘val’.
* By default, Case-class constructor parameters become class fields.
* These methods are added automatically: toString, equals, hashCode, copy. apply and unapply.
* It automatically gets Companion object.
* No need to use ‘new’ keyword to create instance of Case Class.
* Easy to use in Pattern Matching.

All these features are added by Scala Compiler at compile-time. It is not possible with normal class.

### What is a Higher-Order Function?

Higher Order Function (HOF) is also a function but which performs one, two or both of the following things:

    Take other functions as arguments
    Return functions as their results

### What are the Java’s OOP constructs not supported by Scala? What are Scala’s OOP constructs not supported by Java? What are the new OOPs constructs introduced by Scala, but not supported by Java?

Java’s OOP constructs, which are not supported by Scala:

* There is no interface concept in Scala
* There is no Enum concept in Scala

Scala’s OOP constructs, which are not supported by Java:
OR
The new OOPs constructs introduced by Scala, but not supported by Java:

* Scala Traits
* Solving Inheritance Diamond Problem automatically 

### What are call-by-name and call-by-value function parameters?

Scala's default type of function parameters are _call-by-value_ parameters. _Call-by-value_ parameters are evaluated once, when a function is called.

_Call-by-name_ parameters are not evaluated when the function is called, but they are evaluated each time we use them in that function. You can think of _call-by-name_ parameters as a function with zero parameters (eg: `f: () => A`), but we don't need to write the empty parameter list. This is reflected in their syntax as well `f: => A`

### What is a trait in Scala?
Traits are similar to Java interfaces.
They can share methods and fields with classes and objects which extend a trait.
As opposed to Java interfaces traits can hold implementations of methods and fields.

### What is a self type?
A trait can have a self type which has the same effect as if the trait would extend another trait.

```scala
trait B {}

trait A {
    this: A =>
}
class Something() extends A with B
```

The difference is that use-site, trait A has to be mixed in with trait B, so that trait B isn't hardwired to trait A but we can mix-in another implementation of trait B.

### What are implicits?
Long answer: https://www.theguardian.com/info/developer-blog/2016/dec/22/parental-advisory-implicit-content

There are 3 types of implicits in Scala
* Implicit parameters
* Implicit conversion
* Implicit classes

(Implicit class is just syntactic sugar for a type of implicit conversion so technically there are only 2 types. (see the linked article above))

Implicit conversions: when the compiler sees a type mismatch, it searches for implicit conversions, if there's a matching implicit conversion in the scope the compiler can apply the conversion, resolving the type mismatch.

Implicit classes can wrap a type to a class, which can have arbitrary methods. This technique is known as _extension method_ or _type enrichment_.

Implicit parameters are method parameters which do not have to be explicitly passed to the method when it is called. If they’re missing, the compiler will look in the surrounding scope for something that fits the bill. 

### What are implicits used for?

Implicit parameters: implicit context, type class, etc.
Implicit classes: extension methods
Implicit conversions: automatically converting types, should be used with care, too general types can lead to trouble

### What is a type class? How does it relate to subtyping?
Type classes are useful when you want to implement common functionality for an arbitrary set of types.
It is a form of polymorphism, similar to subtyping, where you can implement method instances for subtypes of a class or trait, but type class instances don't need to be in a subtyping relationship, one can easily implement a type class instance for any type.

This means that they can be a very useful tool in library design. Type classes can be easily extended/overwritten in application code.

Some examples: Json libraries (Circe), Cats library

### What is covariace, invariance and contravariance in Scala?
(A <: B means A is a subtype of B)
```scala
If A <: B
CovariantBox[A]     <: CovariantBox[B]
ContravariantBox[A] >: ContravariantBox[B]
```
* _Covariance_ is marked with a `+` preceding the type parameter, eg: `class CovariantBox[+A]...`.

* _Contravariance_ is marked with a `-`, eg: `class ContravariantBox[-A]...`.

* Subtyping relationship of a "container" class varying with the subtyping relationship of a "contained" type.
* Covariance varies in the same direction (So A <: B will mean List[A] <: List[B])
* Contravariance varies in the opposite direction (So A <: B will mean ContraBox[A] >: ContraBox[B])
* Invariant type parameters don't affect the container

### Why do you like Scala?
This is a subjective question, think about your own answer.

### Why do you like functional programming?
This is a subjective question, think about your own answer.

### What is a monad?
The simplest, but not complete answer I found: https://stackoverflow.com/a/49858556
So shortly a type that has a flatmap and unit function + satisfies monad laws.

```scala
trait Monad[A] {
  def flatMap[B](f: A => Monad[B]): Monad[B]
}
  
def unit[A](x: A): Monad[A]
```
* The most important thing about _flatMap_ is its type signature, it's more important than the name _flatMap_.
A _flatMap_ creates a new `Monad[B]` typed value from a `Monad[A]` typed value based on the `A` value inside `Monad[A]`.
* _unit_ just wraps a value typed `A` in a monad which then will have type `Monad[A]`. In scala this functionality is many times implemented with an `apply` function (Eg: Option.apply, Try.apply, Future.apply, Right.apply)
* _flatMap_ is also called _bind_ or _>>=_ in Haskell
* _unit_ is also called _pure_ sometimes.

(Technically this answers the "What is a monad" question, but it doesn't 
explain it very well how and why one wants to use monads. You can think about those questions as well.)

### List monads from the Scala standard library
* Option
* Either
* Try
* Future
* List 
Know all of these, what they do.
Similarities and differences between Either and Try.
Either before and after 2.12 (It became right biased in 2.12)

### What are the options for dependency injection in Scala?
* Implicit Parameters
* DI framework/lib (eg: MacWire)
* Cake Pattern
* Reader monad

### OOP Design patterns in Scala

### Exceptions VS monad based error handling
Long answer: https://softwareengineering.stackexchange.com/a/150905

Shorter answer:
There's still no silver bullet for error handling, but in Scala the most common approach is to use
* Try or Either for general error cases
* Option when it's straightforward what None means and there's only one logical None case. 
* Exceptions in _exceptional_ cases, which you couldn't really handle properly anyway.

### Try vs Either
* `Try[A]` is similar to an `Either[Throwable, A]`
* Either isn't necessarily used for error handling
* Try has an `apply` method which catches exceptions, Either doesn't have this -> Use Try if you want to catch exceptions, but be careful, because it will catch every exception
* Try is a part of Future, therefore they have similar methods like `recover` and `recoverWith`
* Either has `swap`, Try has `failed` 

TODO I'm not sure about this part yet

### What's the difference between functional program design and object oriented program design?
The main difference is whether you use objects or not.
If you design your programs with objects in mind you can put data and methods in the same class. 

However if you want to stay purely functional you separate data from functions, which means you have separate ADTs and functions that work on them, but they are not in the same class.

Scala allows for both approaches. Depending on how functional a team wants to go. A common approach is to have some type of functions in companion objects and some type of functions in classes. 

### How does Future work?

* Future provides a way to run computations in parallel.
* Future is a monad so it's possible to compose Futures with map and flatMap
* Future has a Try inside it, which means it catches exceptions. If the default `apply` is used instead of `Future.successful` or `Future.failed`
* Future is eagerly evaluated
* Runs on ExecutionContext

### How do Akka actors works?

### How do Akka-Streams work?

# Sources:
* https://www.journaldev.com/8958/scala-interview-questions-answers#scala-interview-questions
* https://pedrorijo.com/blog/scala-interview-questions/