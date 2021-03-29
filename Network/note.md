# Network : Make a Connection

Your Java program can reach out and touch a program on another machine.

The three things we have to learn to get the client working are:

1. How to establish the initial connection between the client and server?

2. How t send messages to the server?

3. How to receive messages from the server?

## Read data from a socket, Use a BufferedReader

1. Make a Socket connection to the server

```java
Socket chatSocket = new Socket("127.0.0.1", 5000);
```

2. Make an InputStreamReader chained to the Socket's low-level connection input stream

```java
InputStreamReader stream = new InputStreamReader(chatSocket.getInputStream());
```

3. Make a BufferedReader and read

```java
BufferedReader reader = new BufferedReader(stream);
String message = reader.readLine();
```

## Write data to a Socket, use a PrintWriter

We didn't use PrintWriter in the last chapter, we used BufferedWriter. We have a choice here, but when you're writing one String at a time, PrintWriter is the standard choice. And you'll recognize the two key words in PrintWriter, `print()` and `println()`. Just like good ol`System.out.

1. Make a Socket connection to the server

```java
Socket chatSocket = new Socket("127.0.0.1", 5000);
```

2. Make a PrintWriter chanined to the Socket's low-level(connection) output stream

```java
PrintWriter writer = new PrintWriter(chatSocket.getOutputStream());
```

3. Write(print) something

```java
writer.println("message to send");
writer.print("another message");
```
