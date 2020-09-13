## IO Multiplexing

#### 1. select()

    ```c++
      sockfd = socket(AF_INET, SOCK_STREAM, 0);
      memset(&addr, 0, sizeof (addr));
      addr.sin_family = AF_INET;
      addr.sin_port = htons(2000);
      addr.sin_addr.s_addr = INADDR_ANY;
      bind(sockfd,(struct sockaddr*)&addr ,sizeof(addr));
      listen (sockfd, 5); 
     
      for (i=0;i<5;i++) 
      {
        memset(&client, 0, sizeof (client));
        addrlen = sizeof(client);
        fds[i] = accept(sockfd,(struct sockaddr*)&client, &addrlen);
        if(fds[i] > max)
            max = fds[i];
      }
      
      while(1){
        FD_ZERO(&rset);
        for (i = 0; i< 5; i++ ) {
            FD_SET(fds[i],&rset);
        }
     
        puts("round again");
        select(max+1, &rset, NULL, NULL, NULL);
     
        for(i=0;i<5;i++) {
            if (FD_ISSET(fds[i], &rset)){
                memset(buffer,0,MAXBUF);
                read(fds[i], buffer, MAXBUF);
                puts(buffer);
            }
        }	
      }
    ```

#### 2. poll()

    ```c++
      for (i=0;i<5;i++) 
      {
        memset(&client, 0, sizeof (client));
        addrlen = sizeof(client);
        pollfds[i].fd = accept(sockfd,(struct sockaddr*)&client, &addrlen);
        pollfds[i].events = POLLIN;
      }
      sleep(1);
      while(1){
        puts("round again");
        poll(pollfds, 5, 50000);
     
        for(i=0;i<5;i++) {
            if (pollfds[i].revents & POLLIN){
                pollfds[i].revents = 0;
                memset(buffer,0,MAXBUF);
                read(pollfds[i].fd, buffer, MAXBUF);
                puts(buffer);
            }
        }
      }
    ```
    
#### 3. epoll()

    ```c++
      struct epoll_event events[5];
      int epfd = epoll_create(10);
      ...
      ...
      for (i=0;i<5;i++) 
      {
        static struct epoll_event ev;
        memset(&client, 0, sizeof (client));
        addrlen = sizeof(client);
        ev.data.fd = accept(sockfd,(struct sockaddr*)&client, &addrlen);
        ev.events = EPOLLIN;
        epoll_ctl(epfd, EPOLL_CTL_ADD, ev.data.fd, &ev); 
      }
      
      while(1){
        puts("round again");
        nfds = epoll_wait(epfd, events, 5, 10000);
        
        for(i=0;i<nfds;i++) {
                memset(buffer,0,MAXBUF);
                read(events[i].data.fd, buffer, MAXBUF);
                puts(buffer);
        }
      }
    ```
    
#### Hint

interrupt
    
#### Reference

https://devarea.com/linux-io-multiplexing-select-vs-poll-vs-epoll/#.X14WIWgzZaS