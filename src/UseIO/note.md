# Saving Objects

Objects can be flattened and inflated.

## Writing a serialized object to a file

1. Make a FileOutputStream

```java
FileOutputStream fileStream = new FileOutputStream("MyGame.ser");
```

2. Make an ObjectOutputStream

```java
ObjectOUtputStream os = new ObjectOutputStream(fileStream);
```

3. Write the object

```java
os.writeObject(characterOne);
os.writeObject(characterTwo);
os.writeObject(characterThree);
```

4. Close the ObjectOutputStream

```java
os.close();
```

Object -> ObjectOutputStream -> FileOutputStream -> File

## Implement Serializable

The Serializable interaface is known as a _marker_ or _tag_ interface, because the interface doesn't have any methods to implement. Its sole purpose is to announce that the class implementing it is, well, _serializable_. In other words, objects of that type are saveable through the serialization mechanism. If any superclass of a class is serializable, the subclass is automatically serializable even if the subclass doesn't explicitly declare _implements Serializable_.

## Marking an instance variable as transient

If you want an instance variable to be skipped by the serialization process, mark the variable with `transient` keyword.

```java
import java.net.*;
class Chat implements Serializable {
    transient String currentID;

    String userName;
}
```

## What happens during deserialization?

1. The object is read from the stream.

2. The JVM determines(through info stored with the serialized object) the object's class type.

3. The JVM attempts to find and load object's class. If the JVM can't find and/or load the class, the JVM throws an exception and deserialization fails.

4. A new object is given space on the heap, but the serialized object's constructor does not run! Obviously, if the constructor ran, it would restore the state of the object back to its original "new" state, and that's not what we want. We want the object to be restored to the state it had when it was serialized, not when it was first created.

5. If the object has a non-serializable class somewhere up its heritance tree, the constructor for that non-serializable class will run along with any constructors above that (even if they're serializable). Oonce the constructor chaining begins, you can't stop it, which means all superclasses, beginning with the first non-serializable one, will reinitialize their state.

6. The object's instance variables are given the values from the serialized state. Transient variables are given a value of null for objects references and defaults(0, false, etc) for primitives.

## Version ID : A Big Serialization Gotcha

**Version Control is crucial!**
If you serialize an object, you must the class in order to deserialize and use the object. But what happens if you change the class in the meantime?
Imagine trying to bring back a Dog object when one of its instance variables(non-transient) has changed from a double to a string. That violates Java's type-safe sensibilities in a Big way. But that's not the only change that might hurt compatibility.

**Changes to a class that can hurt deserialization:**

- Deleting an instance variable
- Changing the declared type of an instance variable
- Chaning a non-transient instance variable to transient
- Moving a class up or down in inheiritance hierarchy
- Chaning a class (anywhere in the object graph) from Serializable to not Serializable
- Chaing an instance variable to static

**Changes to a class that are usually OK:**

- Adding new instance variables to the class
- Adding classes to the inheritance tree
- Removing classes from the inheritance tree
- Chaning the access level of an isntance variables has no effect on the ability of deserialization to assign a value to the variable
- Changing an instance variable from transient to non-transient

**Using the serialVerionUID**

When java tries to deserialize an object, it compares the serialized object's serialVersionID with that of the class the JVM is using for deserializing the object. For example, if a Dog instance was serialized with an ID, of, asy 23 (in reality a serialVersionUID is much longer), when the JVM deserializes the Dog object it will first compare the DOg ogject serialVersionUID withthe Dog class serialVersionUId. If the two numbers don't match, the JVM assumes the class is not compatiable with the previously-serialized object, and you'll get an exception during deserialization.

You can use `serialver` in you JDT to check the `serialVersionID` of a class :

```cmd
serialver Dog
```
