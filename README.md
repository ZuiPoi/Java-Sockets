# Java-Sockets
Java Sockets experimentation

Experimentation implementation of java sockets.
Contains 3 mains, "Server, client and thread-main"

Thread main will create a Villain object which inherits from the person class, and write it to a file.

Client will repeatedly poll server to ask it if any villains have been made,
If a villain is made server will notice this change, respond to the client and tell it what the name of the villain was.

Client can then ask the server for a copy of that villain object, which will then be returned to the client by the server,
and written to an array list.

Client then matches a hero of the same type as the villain (fly/smart/strong) and appends to the array list
Client then returns these to the server which the server can then write to a file

If testing this code be sure to update the "YOUR PATH HERE" locations in the Writer file to the SHared and SavedTheWorld again folders.
