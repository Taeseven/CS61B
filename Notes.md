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

------------------------------------------
## Efficient Programming
### Encapsulation, API's, ADT's
* **Module**： A set of methods that work together as a whole to perform some task or set of related tasks.

* **Encapsulated**： A module is said to be encapsulated if its implementation is completely hidden, and it can be accessed only through a documented interface.

* **API**: Application Programming Interface. 
* An API of an ADT is the list of constructors and methods and a short description of each.

* API consists of syntactic and semantic specification:  
> - Compiler verifies that syntax is met.  (AKA, everything specified in the API is present.)
> - Tests help verify that semantics are correct. (AKA everything actually works the way it should.)

* **ADT's**: Abstract Data Structures. are high-level types that are defined by their *behaviors*, not their implementations.

* It is safe to use inheritance within a package, where the subclass and the superclass are under control of the same programmers.

* It is safe to extend classes specifically designed and documented for extension.

* Inheriting from ordinary concrete classes across package boundaries is dangerous.

### Asymptotics
* $1+2+3+4+\cdots+N \in \Theta(N^2)$
* $1+2+4+8+\cdots+N \in \Theta(N)$
* **Big Theta**:

$$ R(N) \in \Theta(f(N)) \quad \textbf{if} \quad k_1 f_1(N) \leq R(N) \leq k_2 f_2(N)$$

* - Notations 
    - Big Theta: worst case equal  
    - Big O: less than or equal  
    - Big Omega: greater than or equal

------------------------------------------
## Disjoint Sets
> - connected(x, y)  
> - isConnected(x, y)

* Quick Find:  
    - The indices of the array represent the elements of our set.  
    - The value at an index is the set number it belongs to.   

* Quick Union:  
    - tree structure, need to find the 'root' to see if is connected.  

* Weighted Quick Union:  
    - always link the root of the smaller tree to the larger tree.  
    - Maximum height: $log(N)$  

* Weighted Quick Union with Path Compression:  
    - when using find() to find its root, connect all the items we visit to their root at no extra asymptotic cost.  


* Disjoint Set Runtimes: 

| Implementation | Constructor | connect | isConnected |
| :------: | :------: | :------: | :------: |
| QuickFindDS | $\Theta(N)$ | $\Theta(N)$ | $\Theta(1)$ |
| QuickUnionDS | $\Theta(N)$ | $O(N)$ | $O(N)$ |
| WeightedQuickUnionDS | $\Theta(N)$  | $O(log(N))$ | $O(log(N))$ |
| ^with path compress | $\Theta(N)$ | $O(\alpha(N))$ | $O(\alpha(N))$ |

------------------------------------------
## Binary Search Tree
* Tree:  
> - nodes  
> - edges  
    -   exactly one path between any two nodes

* Rooted Tree:  
> - Every node N except the root has exactly one parent, defined as the first node on the path from N to the root.  
> - Unlike (most) real trees, the root is usually depicted at the top of the tree.  
> - A node with no child is called a leaf.

* BST Property:  
> - Every key in the left subtree is less than X’s key.
> - Every key in the right subtree is greater than X’s key.

* Binary Trees: in addition to the above requirements, also hold the binary property constraint. That is, each node has either 0, 1, or 2 children.

* Binary Search Trees: Binary Trees + BST Property

* Search: If our tree is relatively "bushy", the find operation will run in $log(N)$ time.  

* Insert: always insert a leaf node.

* Delete: Hibbard deletion, need to conern the new root.

* BST runtimes:  

| Shape of Tree | Height | add | search |
| :------: | :------: | :------: | :------: |
| Bushy(best case) | $log(N)$ | $\Theta(log(N))$ | $\Theta(log(N))$ |
| Spindly(worst case) | $N$ | $O(N)$ | $O(N)$ |

------------------------------------------
## Balanced BST
* BST terminology:  
> - **depth**: the number of links between a node and the root.  
> - **height**: the lowest depth of a tree.  
> - **average depth**: average of the total depths in the tree.  
The height of the tree determines the worst-case runtime.  
The average depth determines the average-case runtime.

* B-Tree invariants:  
> - All leaves must be the same distance from the source.  
> - A non-leaf node with k items mut has exactly k+1 children.

* B-Tree performance:  
> - **height**: between $log_L(N)$ to $log_2(N)$.  
> - **runtime**: $O(log(N))$  

* Left-Leaning Red-Black trees have a 1-1 correspondence with 2-3 trees. Every 2-3 tree has a unique LLRB red-black tree associated with it. As for 2-3-4 trees, they maintain correspondence with standard Red-Black trees.

* Properties of LLRB's:  
> - 1-1 correspondence with 2-3 trees.  
> - No node has 2 red links.  
> - There are no red right-links.  
> - Every path from root to leaf has same number of black links (because 2-3 trees have same number of links to every leaf).  
> - Height is no more than 2x height of corresponding 2-3 tree.  

* LLRB runtime:  
> - **height**: $O(log(N))$  
> - **contains**: $O(log(N))$  
> - **insert**: $O(log(N))$ ($O(log(N))$ to add the new node, $O(log(N))$ rotation and color flip operations per insert.)

------------------------------------------
## Hashing
* **Overflow issues**: The largest possible value for integers in Java is 2,147,483,647. The smallest value is -2,147,483,648.

* Every Object in Java has a default *.hashcode()* method.

* Properties of HashCodes:  
> - It must be an Integer.  
> - If we run *.hashCode()* on an object twice, it should return the same number.  
> - Two objects that are considered *.equal()* must have the same hash code.

* Dynamically growing the hash table.

* Use a 'base' that's a small prime.

* Hash table performance:  
> - contains: $\Theta(1)$  
> - add: $\Theta(1)$

* Hash table runtimes:  

|  | add | get | remove |
| :------: | :------: | :------: | :------: |
| best case | $\Theta(1)$ |  $\Theta(1)$ | $\Theta(1)$ |
| worst case | $\Theta(N)$ | $\Theta(N)$ | $\Theta(N)$ |

------------------------------------------
## Heaps and Priority Queues

* **Priority Queue**: A Max Priority Queue (or PQ for short) is an ADT that supports at least the insert and delete-max operations. A MinPQ supposert insert and delete-min.  

* **Heaps**: A max (min) heap is an array representation of a binary tree such that every node is larger (smaller) than all of its children. This definition naturally applies recursively, i.e. a heap of height 5 is composed of two heaps of height 4 plus a parent.

* Min-Heap Property:  
> - Min-heap: Every node is less than or equal to both of its children.  
> - Complete: Missing items only at the bottom level (if any), all nodes are as far left as possible.  

* **PriorityQueue ADT Operations**:  
> - *add*: Add to the end of heap temporarily. Swim up the hierarchy to the proper place. (Swimming involves swapping nodes if child < parent)  
> - *getSmallest*:  Return the root of the heap (This is guaranteed to be the minimum by our min-heap property)  
> - *removeSmallest*: Swap the last item in the heap into the root. Sink down the hierarchy to the proper place. (Sinking involves swapping nodes if parent > child. Swap with the smallest child to preserve min-heap property)

* Implementation: because of complete tree, no need to create a redundant arrays to store items; parents. (using swim operations to swap up/down)  
> - hint: leave one empty spot at the beginning of the array to simplify computation.  
> - **leftChild(k)**  $= k * 2$  
> - **rightChild(k)** $= k * 2 + 1$  
> - **parent(k)** $=k / 2$

* Comparing to alternative implementations

| Methods | Ordered Array | Bushy BST | Hash Table | Heap |
| :------: | :------: | :------: | :------: | :------: |
| add | $\Theta(N)$ | $\Theta(log(N))$ | $\Theta(1)$ | $\Theta(log(N))$ |
| getSmallest | $\Theta(1)$ | $\Theta(log(N))$ | $\Theta(N)$ | $\Theta(1)$ |
| removeSmallest | $\Theta(N)$ | $\Theta(log(N))$ | $\Theta(N)$ | $\Theta(log(N))$ |

------------------------------------------
## Brief Data Structure Summary

[Josh's textbook](https://joshhug.gitbooks.io/hug61b/content/chap14/chap141.html)

------------------------------------------
## Tries

* **Tries**:   
> - Every node stores only one letter.
> - Nodes can be shared by multiple keys.

* Implementation: (R: size of the alphabet)  
> - DataIndexedCharMap: $\Theta(1)$ for add and contains, but use much memory.  
> - BST: less memory, still fast $O(log(R))$
> - HashTable: less memory. still realy fast $O(R)$

* Advantages of Tries:  
> - longestPrefixOf  
> - prefixMatches  
> - spell checkings

------------------------------------------
## QuadTrees

* Deal with Mutli-dimensional Data:  
> - Uniform Partitioning  
> - X-Based(Y-Based) Tree  
> - QuadTrees(for 2D)
> - K-D Trees(when $k=2$ X-based on the first level, Y-based on the second level, X-based on the third level, when $k=3$ XYZXYZ)

------------------------------------------
## Trees Traversals and Graphs

* **Trees**: A tree consists of a set of nodes and a set of edges connecting the nodes, where there is only one path between any two nodes. A tree is thus a graph with no cycles and all vertices connected.

* **Tree Traversal Orderings**:  
    > - **Level Order**: Visit top-to-bottom, left-to-right (like reading in English)  
    > - **Depth First Traversals**:  
        > > - **Preorder**: “Visit” a node, then traverse its children  
        > > - **Inorder**: Traverse left child, visit, then traverse right child  
        > > - **Postorder**: Traverse left, traverse right, then visit

* **Graphs**: A graph consists of a set of nodes and a set of edges connecting the nodes. However, unlike our tree definition, we can have more than one path between nodes. Note that all trees are graphs.

* **Simple Graphs**: no loops or parallel edges.

* **Depth First Traversals**: DFS for graphs is similar to DFS for trees, but since there are potential cycles within our graph, we add the constraint that each vertex should be visited at most once. This can be accomplished by marking nodes as visited and only visiting a node if it had not been marked as visited already.

* **Breadth First Search**: analogous to 'level order'.

------------------------------------------
## Graph Traversals and Implementation

* **Graph Traversals Overview**:  
    > - DFS Preorder: order in which DFS is called on each vertex.  
    > - DFS Postorder: order in which we return from DFS calls.  
    > - BFS: order of distance from the source.  

* Pseudocode of BFS:  
    > - Initialize the fringe (a queue with the starting vertex) and mark that vertex.  
    > - Repeat until fringe is empty:  
    > - Remove vertex v from the fringe.
    > - For each unmarked neighbor n of v:
    > - Mark n.
    > - Add n to fringe.
    > - Set edgeTo[n] = v.
    > - Set distTo[n] = distTo[v] + 1.

* **Graph Representations**:  
    > - Adjacency Matrix
    > - Edge Sets
    > - Adjacency Lists

| Methods | addEdge(s, t) | for(w : adj(v)) | print()| hasEdge(s, t) | space used |
| :------: | :------: | :------: | :------: | :------: | :------: |
| Adjacency Matrix | $\Theta(1)$ | $\Theta(V)$ | $\Theta(V^2)$ | $\Theta(1)$ | $\Theta(V^2)$ |
| Edge Sets | $\Theta(1)$ | $\Theta(E)$ | $\Theta(E)$ | $\Theta(E)$ | $\Theta(E)$ |
| Adjacency Lists | $\Theta(1)$ | $\Theta(1)$ to $\Theta(V)$ | $\Theta(V + E)$ | $\Theta(degree(v))$ | $\Theta(V + E)$ |


------------------------------------------
## Shortest Paths

* Shortest Path Tree will always be a tree.

* **Dijkstra's Algorithm**:  
    > - Create a priority queue.
    > - Add s to the priority queue with priority 0. Add all other vertices to the priority queue with priority $\infty$
    > - While the priority queue is not empty: pop a vertex out of the priority queue, and relax all of the edges going out from the vertex.  

    Important note: we never relax edges that point to already visited vertices.

* As long as the edges are all non-negative, Dijkstra's is guaranteed to be optimal.

* Runtime of Dijkstra's Algorithm:  

| | # operations | Cost per operation | Total cost| 
| :------: | :------: | :------: | :------: | 
| PQ add | V | $O(log(V))$ | $O(Vlog(V))$ |
| PQ removeSmallest | V | $O(log(V))$ | $O(Vlog(V))$ |
| PQ changPriority| E | $O(log(V))$ | $O(Elog(V))$ |

* **$A^*$ Algorithm**:  instead of visiting vertices in order of distance from the source, we visit them in order of distance from the source $+ h(v)$, where $h(v)$ is some heuristic.


------------------------------------------
## Minimum Spanning Trees

* **Minimum Spanning Trees**: Given an undirected graph, a spanning tree T is a subgraph of G, where T is connected, acyclic, includes all vertices. The minimum spanning tree is the spanning tree whose edge weights have the smallest sum. 

* **Cut**: an assignment of a graph’s nodes to two non-empty sets (i.e. we assign every node to either set number one or set number two).

* **crossing edge**: an edge which connects a node from one set to a node from the other set.  

* **Cut Property**: given any cut, the minimum weight crossing edge is in the MST.

* **Prim’s Algorithm**:  
    > - Start from some arbitrary start node.  
    > - Repeatedly add shortest edge that has one node inside the MST under construction.  
    > - Repeat until $V-1$ edges.

* Prims's vs. Dijkstra's:  
    > - Dijkstra's considers "distance from the source", Prims's considers "distance from the tree".  

* Runtime of Prim's Algorithm:  

| | # operations | Cost per operation | Total cost| 
| :------: | :------: | :------: | :------: | 
| PQ add | V | $O(log(V))$ | $O(Vlog(V))$ |
| PQ removeSmallest | V | $O(log(V))$ | $O(Vlog(V))$ |
| PQ changPriority| $O(E)$| $O(log(V))$ | $O(Elog(V))$ |

* **Kruskal’s Algorithm**:  
    > - Consider edges in invreasing order of weights.  
    > - Add edges to MST unless doing so creats a cycle.  
    > - Repeat until $V-1$ edges.

* Runtime of Kruskal's Algorithm:  

| | # operations | Cost per operation | Total cost| 
| :------: | :------: | :------: | :------: | 
| Insert | E | $O(log(E))$ | $O(Elog(E))$ |
| PQ removeSmallest | $O(E)$ | $O(log(E))$ | $O(Elog(E))$ |
| union| $O(V)$| $O(log^*(V))$ | $O(Vlog^*(V))$ |
| isConnected| $O(E)$| $O(log^*(V))$ | $O(Elog^*(V))$ |

------------------------------------------
## Reduction and Decomposition

* **DAGs**: directed, acyclic (no cycles) graphs.

* **Topological Sort**: an ordering of a DAG's vertices such that for every directed edge $u \rightarrow v$, u comes before v in the ordering.

* For any topological ordering, you can redraw the graph so that the vertices are all in one line. Thus, topological sort is sometimes called a **linearization** of the graph.

to be continued ...

------------------------------------------
## Dynamic Programming

* DAG Shortest Path Tree: consists of first finding a topological ordering of the vertices, then relaxing all of the edges from each vertex in topological order. The runtime of this algorithm is $O(E + V)$.  

* **Dynamic Programming**:  
    > - Identify a collection of subproblems
    > - Solve subproblems, working from smallest to largest
    > - Use the answers from the smaller problems to help solve the larger ones

* **Reduction**: Transforming a problem from one domain and solving it in that new domain.

* 

to be continued ...

------------------------------------------
## Sorting  

### Selection Sort  
> * Find smallest item.  
> * Swap this item to the front and 'fix' it.  
> * Repeat for unfixed itmes until all items are fixed.

* Time complexity: $\Theta(n^2)$
* Space complexity: $O(1)$

### Heap Sort(In-place)
> * use "bottom-up heapifivation' to convert the array into a heap
> * Repeat N times: delect largest item; change unfixed items into a heap

* Time complexity: $O(Nlog(N))$
> * into the heap: $O(NlogN)$
> * Selecting largest item: $\Theta(1)$
> * Removing largest item: $O(logN)$

* Space complexity: $O(1)$

### Merge Sort
> * Split items into 2 roughly even pieces.
> * Merge sort each half(recursive)
> * Merge the two sorted halves to form the final result.

* Time complexity: $\Theta(NlogN)$
* Space complexity: $\Theta(N)$

### Insertion Sort
> * Starting with an empty output sequence.
> * Add each item from input, inserting into output at right point.
> * Also can do in-place insertion sort.

* On arrays with a small number of inversions, insertion sort is extremely fast.

* For small arrays (N < 15 or so), insertion sort is fastest

* Time complexity: $\Omega(N)$, $O(N^2)$

### Shell's Sort

to be finished...



