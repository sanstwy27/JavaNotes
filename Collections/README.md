## Collections

#### 1. HashMap

  - Why is the capacity in power of 2?
  
      - https://www.javarticles.com/2012/11/hashmap-faq.html
        1. In general, the number of buckets should be prime is so that the hash values are well distributed and will have less collisions.
        2. If the capacity of array is in power-of-two, the hash code can be easily converted to the index based on a simple AND operation and this seems to be more efficient as compared to modulus operation:
         > index =  hashCode & (array length-1)
    
      - https://stackoverflow.com/questions/53526790/
    
        When you subtract 1 from a number which is a power of 2, what you get is a number whose binary representation is all 1. E.g. 16 is a power of 2. If you subtract 1 from it, you get 15, whose binary representation is 1111. Now, if you do a bitwise AND of any number with 1111, you're going to get the last 4 bits of the number which, in other words, is equivalent to the modulo of the number by 16 (Division operation is usually an expensive operation. Hence, bitwise operation is usually preferred over division). These last 4 bits will evaluate to any number from 0 to 15 which are the indexes of your underlying array.
      
        You could make the size 17 instead. In that case, after subtracting 1 from it, you'd get 16 which is 10000 in binary. Now you do a bit wise AND of a number with 16, you'll lose all bits of the number except the 5th bit from the end. So, regardless of the number you take, the array index will be either 16 or 0. That means you'd have lot of collisions, which in turn means poor performance. Instead of O(1) for retrieval, you'd need O(log n), because when collision occurs, all the nodes in a given bucket are going to be stored in a red black tree. Not only that. In case you are using a ConcurrentHashMap in a multithreaded environmemt, you'd experience lot of synchronizations, because all the new additions will end up in a very small number of buckets (only two - 0 and 16 in the above case) and when you add new nodes in a bucket that already has other nodes, the bucket will be locked to avoid data inconsistancies due to modifications by multiple threads. Therefore, other threads trying to add new nodes need to wait until the current thread release the lock.
         
        Finally, I should also mention that the Java HashMap implementation also shifts 16 bits of the hash code of key to the right and does bitwise XOR with the original hash code before doing the bitwise AND with (length - 1) to ensure that the effect of the higher order bits are also captured.
          
        So, basically the point is, if the size is a power of two, the keys will be more evenly distributed across the array with minimal collision leading to better retrieval performance (and also less synchronizations in case of ConcurrentHashMap) when compared with any other size which is not a power of 2.
      
  - What if an entry already exists in the bucket location?
    
    The old entry will replaced by the new entry and the new entry’s next will point to the old entry.
    
  - When and how does HashMap convert the bucket from linked list to Red Black Trees?

    When there are at least 8 entries (TREEIFY_THRESHOLD) in a single bucket and the total number of buckets is more then 64 (MIN_TREEIFY_CAPACITY) then that single bucket will be transformed to a perfectly balanced red black tree node.
    
    ref: https://stackoverflow.com/questions/47921663/



