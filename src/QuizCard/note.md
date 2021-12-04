# QuizCard

We are going to build a e-Flashcards app.

We're going to build three classes:

1. QuizCardBuilder : a simple authoring tool for creating and saving a set of e-Flashcards.

2. QuizCardPlayer : a playback engine that can load a flashcard set and play it for the user

3. QuizCard : a simple class representing card data.

# java.io.File class

The `java.io.File` class represents a file on disk, but doesn't actually represent the contents of the file.

The File class does not, for example, have methods for reading and writing. One very useful thing about a File object is taht it offers a much safer way to represent a file than just using a String file name. For example, most classes that take a String file name in their constructor (liek FileWriter or FileInputStream) can take a File object instaed. You can construct a File object, verify that you've got a valid path, etc. and then give that File object to the FileWriter or FileInputStream.

# The beauty of buffers

If there were no buffers, it would be like shopping without a cart. You'd have to carry each thing out to your car, one souop can or toilet paper roll at a time.

Buffers give you a temporary holding place to group thing util the holder (like the cart) is full. You get to maek far ferwe trips when you use a buffer.

String -> BufferedWriter -> FileWriter -> File 


