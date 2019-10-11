/*
 * This runnable routes packets as they traverse the network. 
 * 
 * @author -- Sashi Raj Amatya (Template provided by Ryan Hankins).
 * ICS 440 - 01 - The art of multiprocessor programming (Summer 2019)
 * Date: 7/19/2019
 * Programming Assignment 3
 * Instructor: Ryan Hankins
 * 
 */
class  Router implements Runnable {
    private int routes[];
    private Router routers[];
    private int routerNum;
    private Packet packet;
    
    //variable used to end the while loop in run() method
    private  boolean end = false;    
      
    private Queue<Packet> packetQueue = new Queue<Packet>();
    
    Router(int rts[], Router rtrs[], int num) {
        routes = rts;
        routers = rtrs;
        routerNum = num;
    }   
    
    
    /*
     * Add a packet to this router.
     * Packet is added to the packetQueue.
     * Every time a new packet is added, all threads that are waiting
     * are notified.
     */
    public void addWork(Packet inputPacket) {
    	synchronized(this.packetQueue) {  
    		this.packetQueue.enqueue(inputPacket);
    		this.packetQueue.notifyAll();    		
    	}    
    }
   
    /*
     * End the thread, once no more packets are outstanding.
     * Boolean variable end is set to true to terminate the while
     * loop in the run() method.
     */
	public synchronized void end() {
		synchronized(this.packetQueue) {      		
    		this.packetQueue.notifyAll(); 
    		this.end = true;
    	} 	
    }

	/**
	 * If the network is empty, let the waiting threads know
	 * by using notifyAll().
	 */
    public synchronized void networkEmpty() {    	
    	synchronized(this.packetQueue) {      		
    		this.packetQueue.notifyAll();    		
    	}   
    }
    
    /*
     * run() method
     * Process packets.  
     */
    public void run() {
    	/**
    	 * Thread will run until end method is called and boolean end is set to true
    	 * or until there is a packet in the network
    	 */
    	while(!end || Routing.getPacketCount()>0) { 
    		
    		/**
    		 * If the packetQueue is Empty, wait
    		 */	    	
			if(this.packetQueue.isEmpty()) {
	    		synchronized(this.packetQueue) {  
			    	try {				    			
			    		this.packetQueue.wait();			    			
					} catch (InterruptedException e) {					
						e.printStackTrace();
					}
		    	}			    	
	    	}	
	    	
	    	/**
	    	 * If packetQueue is not Empty,
	    	 * start processing
	    	 */
			else {	
				
				/**
				 * Using monitor to synchronize dequeue operation
				 */
		    	synchronized(this.packetQueue) {
		    		this.packet = this.packetQueue.dequeue();		    		
		    	}
		    	
			    /**
			     * If the router is not packet's destination, forward the packet to the appropriate
			     * next router in  the routing table by calling addWork() method of that
			     * instance of the Router, with the packet as an argument.
			     */				    	
			    if(routes[packet.getDestination()]!=-1) {	
				    this.packet.Record(routerNum);
				    this.routers[routes[packet.getDestination()]].addWork(this.packet);	
				    }
			    
			    else {		
			    		this.packet.Record(routerNum);				    	
				    	Routing.decPacketCount();
				} 
			}//-----------------End of if
    	} // -------- End of while
    } // ----------End of run
} // -------End of class




