Lecture Notes
------------------------------------------
# Intro, Hello World Java

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

------------------------------------------
# Intro, Hello World Java
* **Static VS. Instance methods**  
    - Instance methods are actions that can only be taken by an instance of the class (i.e. a specific object), whereas static methods are taken by the class itself. An instance method is invoked using a reference to a specific instance, e.g. d.bark(), whereas static methods should be invoked using the class name, e.g. Math.sqrt(). 
* **Static variables**  
    - Variables can also be static. Static variables should be accessed using the class name, e.g. Dog.binomen as opposed to d.binomen.  
* **'this'**  
    - Inside a method, we can use the **this** keyword to refer to the current instance. This is equivalent to **self** in Python.  

------------------------------------------
# Lists
> * **Primitive Types**: byte, short, int, long, float, double, boolean, and char.
> * **Reference Type**: If a variable is not a primitive type, then it is a reference type. When we declare object variables, we use reference type variables to store the location in memory of where an object is located. Remember this is what the constructor returns. A reference type is always a box of size 64 bits. Note that the variable does not store the entire object itself!  
> * **Golden Rule of Equals**: when we assign a value with equals, we are just copying the bits from one memory box to another!  

## SLLists
* **Private**
> - prevents code in other classes from accessing(while the code inside the class can still do so).  
* **Nested Classes**  
> - move classes into classes to make nested classes.  
* **Static Nested Classed**  
> - If the IntNode class never uses any variable or method of the SLList class, we can turn this class static by adding the “static” keyword.
* **Invariants**
> - An invariant is a fact about a data structure that is guaranteed to be true.

## DLList  
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

## Arrays  
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

## ArrayList
> - Resize: multiply resize factor.
> - Generic AList: **items = (Item[]) new Object[100]**

------------------------------------------
# Inheritance, Implements  

## Interface, Implements  
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

## Interface Inheritance vs. Implementation Inheritance  
* Interface inheritance (what): Simply tells what the subclasses should be able to do.  
* Implementation inheritance (how): Tells the subclasses how they should behave.  

## Extends  
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

## Constructors Are Not Inherited
Java requires that all constructors must start with a call to one of its superclass's constructors.  

## Type Checking and Casting
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

### Casting
Tell the compiler that a specific expression has a specific compile-time type.   
```java
Poodle frank = new Poodle("Frank", 5);
Poodle frankJr = new Poodle("Frank Jr.", 15);
Dog largerDog = maxDog(frank, frankJr);
Poodle largerPoodle = (Poodle) maxDog(frank, frankJr);
```
* Casting is a powerful but dangerous tool. Essentially, casting is telling the compiler not to do its type-checking duties - telling it to trust you and act the way you want it to.

## Higher Order Functions
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

## Inheritance Cheatsheet
VengefulSLList extends SLList means VengefulSLList "is-an" SLList, and inherits all of SLList's members:  
* Variables, methods nested classes
* Not constructors Subclass constructors must invoke superclass constructor first. The super keyword can be used to invoke overridden superclass methods and constructors.  

Invocation of overridden methods follows two simple rules:
* Compiler plays it safe and only allows us to do things according to the static type.
* For overridden methods (not overloaded methods), the actual method invoked is based on the dynamic type of the invoking expression
* Can use casting to overrule compiler type checking.  

## Subtype Polymorphism vs. HoFs Functions 
## Typing Rules
> * Compiler allows the memory box to hold any subtype.
> * Compiler allows calls based on static type.
> * Overriden non-static methods are selected at runtime based on dynamic type.
> * For overloaded methods, the method is selected at compile time.

### Polymorphism
> Consider a variable of static type Deque. The behavior of calling deque.method() depends on the dynamic type. Thus, we could have many subclasses the implement the Deque interface, all of which will be able to call deque.method().  

## Comparable  
> Java has an in-built Comparable interface that uses generics to avoid any weird casting issues. Plus, Comparable already works for things like Integer, Character, and String; moreover, these objects have already implemented a max, min, etc. method for you. Thus you do not need to re-do work that’s already been done!  

## Comparator  
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
