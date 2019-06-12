<style type="text/css">
    h1 { counter-reset: h2counter; }
    h2 { counter-reset: h3counter; }
    h3 { counter-reset: h4counter; }
    h4 { counter-reset: h5counter; }
    h5 { counter-reset: h6counter; }
    h6 { }
    h2:before {
      counter-increment: h2counter;
      content: counter(h2counter) ".\0000a0\0000a0";
    }
    h3:before {
      counter-increment: h3counter;
      content: counter(h2counter) "."
                counter(h3counter) ".\0000a0\0000a0";
    }
    h4:before {
      counter-increment: h4counter;
      content: counter(h2counter) "."
                counter(h3counter) "."
                counter(h4counter) ".\0000a0\0000a0";
    }
    h5:before {
      counter-increment: h5counter;
      content: counter(h2counter) "."
                counter(h3counter) "."
                counter(h4counter) "."
                counter(h5counter) ".\0000a0\0000a0";
    }
    h6:before {
      counter-increment: h6counter;
      content: counter(h2counter) "."
                counter(h3counter) "."
                counter(h4counter) "."
                counter(h5counter) "."
                counter(h6counter) ".\0000a0\0000a0";
    }
</style>

# Lecture Notes
***
Notes for UCB CS61B, 2018 Spring   
@ Instructor: [Josh Hug](https://www2.eecs.berkeley.edu/Faculty/Homepages/joshhug.html)    
@ [Course Website](https://sp18.datastructur.es/index.html)   
@ [Java Visualizer](https://cscircles.cemc.uwaterloo.ca/java_visualize/)   
@ Contributor: Chutian Tai
***
------------------------------------------
 ## Intro, Hello World Java

* All code in Java must be part of a class.
* We delimit the beginning and end of segments of code using { and }.
* All statements in Java must end in a semi-colon.
* For code to run we need public static void main(String[] args)
* Before Java variables can be used, they must be declared.
* Java variables must have a specific type.
* Java variable types can never change.
* Types are verified before the code even runs!
* Functions must be declared as part of a class in Java.
   A function that is part of a class is called a "method".
   So in Java, all functions are methods.
* To define a function in Java, we use "public static".
   We will see alternate ways of defining functions later.
* All parameters of a function must have a declared type,
   and the return value of the function must have a declared type.
   Functions in Java return only one value!
* Functions must have a return type. If a function does not return anything, we use void.
* **Static VS. Instance methods**  
    - Instance methods are actions that can only be taken by an instance of the class (i.e. a specific object), whereas static methods are taken by the class itself. An instance method is invoked using a reference to a specific instance, e.g. d.bark(), whereas static methods should be invoked using the class name, e.g. Math.sqrt(). 
* **Static variables**  
    - Variables can also be static. Static variables should be accessed using the class name, e.g. Dog.binomen as opposed to d.binomen.  
* **'this'**  
    - Inside a method, we can use the **this** keyword to refer to the current instance. This is equivalent to **self** in Python.  

------------------------------------------
## Lists
> * **Primitive Types**: byte, short, int, long, float, double, boolean, and char.
> * **Reference Type**: If a variable is not a primitive type, then it is a reference type. When we declare object variables, we use reference type variables to store the location in memory of where an object is located. Remember this is what the constructor returns. A reference type is always a box of size 64 bits. Note that the variable does not store the entire object itself!  
> * **Golden Rule of Equals**: when we assign a value with equals, we are just copying the bits from one memory box to another!  

### SLLists
* **Private**
> - prevents code in other classes from accessing(while the code inside the class can still do so).  
* **Nested Classes**  
> - move classes into classes to make nested classes.  
* **Static Nested Classed**  
> - If the IntNode class never uses any variable or method of the SLList class, we can turn this class static by adding the “static” keyword.
* **Invariants**
> - An invariant is a fact about a data structure that is guaranteed to be true.

### DLList  
> give each IntNode a prev pointer, pointing to the previous item. This creates a doubly-linked list.(two sentinel nodes or circular sentinel).

* **Generic DDList**  
```java 
public class DLList<T> {...}
```  
> **T** is a placeholder object type.  

If we now want to create a DLList holding String objects, then we must say:
```java
DLList<String> list = new DLList<>("bone");
```

### Arrays  
> Arrays do not have methods!  

* **Instantiating Arrays**  
```java
int[] y = new int[3];
int[] x = new int[]{1, 2, 3, 4, 5};
int[] w = {1, 2, 3, 4, 5};
```

* **Arraycopy**
```java
System.arraycopy(b, 0, x, 3, 2);
```

> - Source array: **b**;  
> - Start position in source: **b[0]**;
> - Target array: **x**;
> - Start position in target: **x[3]**;
> - Number to copy: **2**

* **Arrays vs. Classes**  
> - Both are used to organize a bunch of memory.
> - Both have a fixed number of “boxes”.
> - Arrays are accessed via square bracket notation. Classes are accessed via dot notation.
> - Elements in the array must be all be the same type. Elements in a class may be of different types.
> - Array indices are computed at runtime. We cannot compute class member variable names.

### ArrayList
> - Resize: multiply resize factor.
> - Generic AList: **items = (Item[]) new Object[100]**

------------------------------------------
## Testing


------------------------------------------
## Inheritance, Implements  

### Interface, Implements  
```java
public interface List61B<Item> {
    public void addFirst(Item x);
    public Item getFirst();
    ...
    default public void print() {
        ...
    }

}

public class AList<Item> implements List61B<Item> {
    @Override
    public void addFirst(Item x) {
        ...
    }
    ...
}
```

> **Interface:** 
> - variables can exist in interfaces but they are public static final.
> - classes can extend more than 1 interface.
> - methods are public unless stated otherwise
> - interfaces cannot be instantiated.

### Interface Inheritance vs. Implementation Inheritance  
* Interface inheritance (what): Simply tells what the subclasses should be able to do.  
* Implementation inheritance (how): Tells the subclasses how they should behave.  

### Extends  
* hierarchical relationship between classes.  
* same functions and additional operation.  
```java
public class RotatingSLList<Item> extends SLList<Item>
```
> Using the **extends** keyword, subclasses inherit all members of the parent class. "Members" includes:
> * All instance and static variables.  
> * All methods.
> * All nested classes.  

The **super** keyword can be used to invoke overridden superclass methods and constructors. 

### Constructors Are Not Inherited
Java requires that all constructors must start with a call to one of its superclass's constructors.  

### Type Checking and Casting
example: VengefulSLList is-a SLList.  
```java
VengefulSLList<Integer> vsl = new VengefulSLList<Integer>(9);
SLList<Integer> sl = vsl;
sl.addLast(50);
sl.removeLast();
```
above lines works fine.  
```java
sl.printLostItems();
```
This line above results in a compile-time error. Remember that the compiler determines whether or not something is valid based on the static type of the object. Since sl is of static type SLList, and printLostItems is not defined in the SLList class, the code will not be allowed to run, even though sl's runtime type is VengefulSLList.  
```java
VengefulSLList<Integer> vsl2 = sl;
```
This line above also results in a compile-time error, for a similar reason. In general, the compiler only allows method calls and assignments based on compile-time types. Since the compiler only sees that the static type of sl is SLList, it will not allow a VengefulSLList "container" to hold it.

#### Casting
Tell the compiler that a specific expression has a specific compile-time type.   
```java
Poodle frank = new Poodle("Frank", 5);
Poodle frankJr = new Poodle("Frank Jr.", 15);
Dog largerDog = maxDog(frank, frankJr);
Poodle largerPoodle = (Poodle) maxDog(frank, frankJr);
```
* Casting is a powerful but dangerous tool. Essentially, casting is telling the compiler not to do its type-checking duties - telling it to trust you and act the way you want it to.

### Higher Order Functions
```java
public interface IntUnaryFunction {
    int apply(int x);
}

public class TenX implements IntUnaryFunction {
    /* Returns ten times the argument. */
    public int apply(int x) {
        return 10 * x;
    }
}

public static int do_twice(IntUnaryFunction f, int x) {
    return f.apply(f.apply(x));
}

System.out.println(do_twice(new TenX(), 2));
```

### Inheritance Cheatsheet
VengefulSLList extends SLList means VengefulSLList "is-an" SLList, and inherits all of SLList's members:  
* Variables, methods nested classes
* Not constructors Subclass constructors must invoke superclass constructor first. The super keyword can be used to invoke overridden superclass methods and constructors.  

Invocation of overridden methods follows two simple rules:
* Compiler plays it safe and only allows us to do things according to the static type.
* For overridden methods (not overloaded methods), the actual method invoked is based on the dynamic type of the invoking expression
* Can use casting to overrule compiler type checking.  

### Subtype Polymorphism vs. HoFs Functions 
### Typing Rules
> * Compiler allows the memory box to hold any subtype.
> * Compiler allows calls based on static type.
> * Overriden non-static methods are selected at runtime based on dynamic type.
> * For overloaded methods, the method is selected at compile time.

#### Polymorphism
> Consider a variable of static type Deque. The behavior of calling deque.method() depends on the dynamic type. Thus, we could have many subclasses the implement the Deque interface, all of which will be able to call deque.method().  

### Comparable  
> Java has an in-built Comparable interface that uses generics to avoid any weird casting issues. Plus, Comparable already works for things like Integer, Character, and String; moreover, these objects have already implemented a max, min, etc. method for you. Thus you do not need to re-do work that’s already been done!  

### Comparator  
```java
import java.util.Comparator;

public class Dog implements Comparable<Dog> {
    ...
    public int compareTo(Dog uddaDog) {
        return this.size - uddaDog.size;
    }

    private static class NameComparator implements Comparator<Dog> {
        public int compare(Dog a, Dog b) {
            return a.name.compareTo(b.name);
        }
    }

    public static Comparator<Dog> getNameComparator() {
        return new NameComparator();
    }
}
```
### Java Libraries and packages  
> **Abstract data type:**  only comes with behaviors, not any concrete ways to exhibit those behaviors.  

> **Abstract Classes**
> - Methods can be public or private
> - Can have any types of variables
> - Cannot be instantiated
> - Methods are by default concrete unless specified to be abstract
> - Can only implement one per class 

------------------------------------------
## Generics and Autoboxing
### Autoboxing
* **Autoboxing and Unboxing**: is the Java's automatic conversion of between wrappers(Integer) to primitives(int).
* In Java cann't provide a primitive type as an actual type argument for generics.
* Arrays are never autoboxes or autoboxed.
* Autoboxing and Unboxing also have a measurable performance impact.
* Wrapper types use much more memory than primitive types.
* **Widening**: widen a primitive if needed.

### Immutability
* **Immutability**: Immutable data types are types that  can't change in any observable way after instantiation. (String)
* **final**: for variables that prevents the variable from being changed after its first assignment.
* **Advantages of immutability**:  
    - Prevents bugs and makes debugging easier.  
    - You can count on objects to have a certian behavior.
* **Disadvantages of immutability**:  
    - You need to create a new object in order to change a property.

### Generics
* **Generic Classes**:
```java
public class ArrayMap<K, V> {...}
```
* **Generic Methods**:
```java
public static <K, V> V get(ArrayMap<K, V> am, K key) {...}
```
* **extends**: is active in giving the subclass the abilities of the superclass.
```java
public static <K extends Comparable<K>, V) K maxKey(Map61B<K, V> map) {...}
```
* **Wildcard character**: **?**  
    dealing with Types we don't care about.
```java
public static void allBark(ArrayMap<Dog, ?> am){...}
```
* **Covariance**： Arrays are covariant in Java, but generic types are invariant.  
    - An FrenchDog[] is a Dog[]  
    - A List<FrenchDog> is not a List<Dog>
```java
// option 1
public static <K extends Dog> void allBark(ArrayMap<K, ?> am) {...}
// option 2
public static void allBark(ArrayMap<? extends Dog, ?> am) {...}
```

------------------------------------------
## Exception, Iterators, Iterables, Object Methods

### Lists, Set and ArrayList
* **List** s an interface we can't instatiate it, instatiate one of its implements.
* **Sets** are a collection of unique elements - you can only have one copy of each element. There is also no sense of order.

### Exception
* Throw our own exception using the **throw** keyword.
```java
throw new RuntimeException("For no reason.");
```
* The keywords *try* and *catch* break the normal flow of the program, protecting it from exceptions.
* **Checked exception**: are considered by the compiler that you must handle them somehow.
* **Unchecked exception**: unchecked by compiler(Runtime Exception, Error)
* Two ways to handle checked exception:  
> - **Catch**
> ```java
> public static void main(String[] args) {
>     try {
>         gulgate();
>     } catch(IOException e) {
>         System.out.println("Averted!");
>     }
> }
> ```
> - **Specify**
> ```java
> public static void main(String[] args) throws IOException {
>     gulgate();
> }
> ```

### Iteration
* **Iterable**: the interface that makes a class able to be iterated on, and requires the method iterator(), which returns an Iterator object.
* Instantiating a non-static nested class requires dot notation.
```java
ArrayMap.KeyIterator ami = am.new KeyIterator();
```

### Object Method
* String object is immutable, use StringBuilder instead.
* Use String.join() makes your code simple.
* **==** checks if two objects are actually the same object in memory. For primitives, this means checking if the values are equal. For objects, this means checking if the address/pointer is equal.
* **equals(Object o)** is a method in the Object that, by default, acts like == in that it checks if the memory address of the this is the same as o. However, we can override it to define equality in whichever way we wish.
* **.of()** method:
```java 
public static <Glerp> ArraySet<Glerp> of(Glerp... stuff) {
    ArraySet<Glerp> returnSet = new ArraySet<Glerp>();
    for (Glerp x : stuff) {
        returnSet.add(x);
    }
    return returnSet;
}
```

------------------------------------------
## Package and Access Control
### Packages
* **Package**: a namespace that organizes classes and interfaces. Package name starts with the website address, backwards.
* Creating a package:  
> - Put the package name at the top of every file in this package.
> ```java
> package ug.joshh.animal;
> ```
> - Store the file in a folder that has the appropriate folder name. The folder should have a name that matches your package:  
> i.e. ug.joshh.animal package is in ug/joshh/animal folder
* **Default packages**: Any Java class without an explicit package name at the top of the file is automatically considered to be part of the “default” package.
* **JAR file**: .jar file will contain all your .class files, along with some other additional information.
* JAR files do not keep your code safe.

### Access Control
* **Private**: Only code from the given class can access private members.
* **Package Private**: Default access. It entails that classes that belong in the same package can access, but not subclasses.
* **Protected**: classes within the same package and subclasses can access these members.
* **Public**: This keyword opens up the access to everyone.
![avatar](./pics/control_access.png)



