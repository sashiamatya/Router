# Router
A multithreaded system that routes packets from source to destination among a series of routers on a network.Each router is represented 
by an instance of runnable router and a single corresponding thread. Monitors are used to ensure synchronization between threads. All 
packets are processed in parallel on multiprocessor system in order to substantially improve the performance. Packets are routed  to 
their destination correctly and they exit cleanly.

Routing.java -  A driver class
