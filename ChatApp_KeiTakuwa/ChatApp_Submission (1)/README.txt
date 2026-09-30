README - Chat Room HW

Port: 5000 (set in ChatServer.java as PORT)

Protocol (plain text lines over the socket):
USERNAME|name   -> client sends this right after connecting
MESSAGE|text    -> client sends this when user hits Send, server broadcasts it back as "name: text"
QUIT            -> sent when user disconnects/closes window
System: ...     -> server sends these for join/leave messages

How to run:
1. open a terminal in the ChatApp folder, run:
   mvn compile exec:java -Dexec.mainClass="com.example.chatroom.ChatServer"
   should print "Chat server started." and "Listening on port 5000..."
2. open another terminal in the SAME folder (need music.wav to be found), run:
   mvn javafx:run
   this opens the chat window, host/port default to localhost/5000, type a username and click Connect
3. can run mvn javafx:run again in more terminals to open more clients

Testing:
connect as Ali in one window and Bob in another, send a message from each,
both windows should show "Ali: ..." and "Bob: ...". disconnecting one client
should show "System: Bob left the chat." on the other, server keeps running.

Play/Stop buttons play music.wav (needs to be in the folder you run from)
