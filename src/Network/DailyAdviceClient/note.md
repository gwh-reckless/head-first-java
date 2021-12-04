# The DailyAdvice app

The Advice Guy is a server program offers up pratical, inspirational tips to get you through those long days of coding.

## The DailyAdvice Client

1. Connect: connects to the server and gets on input stream from it

2. Read: Clients reads a message from the server

## The DailiyAdviceServer

How it works?

1. Server application makes a ServerSocket, on a specific port

```java
ServerSocket serverSock = new ServerSocket(4242);
```

2. Client makes a Socket connection to the server application

```java
Socket sock = new Socket("127.0.0.1",4242);
```

3. Server makes a new Socket to communicate with this client

```java
Socket sock = serverSock.accept();
```
