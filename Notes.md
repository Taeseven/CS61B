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

