## Mysql Read-Write Separation with Docker

#### 1. Master

- install
    ```shell script
    docker run -p 13366:3306 --name mysql-master -v E:\DevelopmentConf\master\log:/var/log/mysql -v E:\DevelopmentConf\master\data:/var/lib/mysql -v E:\DevelopmentConf\master\conf:/etc/mysql/my.cnf.d -e MYSQL_ROOT_PASSWORD=123456 -d mysql
    ```

- my.cnf
    ```shell script
    [mysqld]
    server-id=1
    log-bin=mysql-bin
    # Need to synchronize the log database
    binlog-do-db=wr
     # Do not need to synchronize the log database
    binlog-ignore-db=mysql
    binlog-ignore-db=sys
    binlog-ignore-db=information_schema
    binlog-ignore-db=performance_schema
    ```

- mysql
    ```mysql
    docker exec -it container_name bash -c "mysql -u root -p123456"
    
    mysql> CREATE USER 'slave'@'%' IDENTIFIED BY '123456';
    CREATE USER 'slave'@'%' IDENTIFIED BY '123456';
    Query OK, 0 rows affected (0.09 sec)
    
    mysql> GRANT REPLICATION SLAVE ON *.* to 'slave'@'%';
    Query OK, 0 rows affected (0.07 sec)
    
    mysql> GRANT RELOAD, PROCESS, REPLICATION SLAVE, REPLICATION CLIENT ON *.* TO 'slave'@'%';
    Query OK, 0 rows affected (0.06 sec)
    
    mysql> CREATE DATABASE wrdemo;
    Query OK, 1 row affected (0.19 sec)
    
    ....
    CREATE TABLE wrdemo.wr (
        id INT auto_increment NOT NULL PRIMARY KEY,
        comment varchar(100) NULL
    )
    ENGINE=InnoDB
    DEFAULT CHARSET=utf8mb4
    COLLATE=utf8mb4_0900_ai_ci;
    ....
    
    mysql> GRANT ALL ON wrdemo.* TO 'slave'@'%';
    Query OK, 0 rows affected (0.08 sec)
    
    mysql> FLUSH PRIVILEGES;
    Query OK, 0 rows affected (0.04 sec)
    
    mysql> exit;
    Bye
    ```

- network address
    ```shell script
    > docker inspect --format "{{ .NetworkSettings.IPAddress }}" container_name
    172.17.0.4
    ```

#### 2. Slave

- install
    ```shell script
    docker run -p 13367:3306 --name mysql-slave -v E:\DevelopmentConf\slave\log:/var/log/mysql -v E:\DevelopmentConf\slave\data:/var/lib/mysql -v E:\DevelopmentConf\slave\conf:/etc/mysql/my.cnf.d -e MYSQL_ROOT_PASSWORD=123456 -d mysql
    ```

- my.cnf
    ```shell script
    [mysqld]
    server-id=2
     # Need to synchronize the log database
    binlog-do-db=wr
     # Do not need to synchronize the log database
    replicate-ignore-db=mysql
    replicate-ignore-db=sys
    replicate-ignore-db=information_schema
    replicate-ignore-db=performance_schema
    ```

- mysql
    ```shell script
    docker exec -it container_name bash -c "mysql -u root -p123456"
    ```

    ```mysql
    stop slave;
    RESET SLAVE;
    change master to master_host='172.17.0.4', master_port=3306, master_user='slave', master_password='123456', master_log_file='binlog.000006', master_log_pos=1685;
    start slave;
    show slave status;
    ```

    - issue
    ```mysql
    > Last_IO_Error: Fatal error: The slave I/O thread stops because master and slave have equal MySQL server ids; these ids must be different for replication to work (or the –replicate-same-server-id option must be used on slave but this does not always make sense; please check the manual before using it).
    show variables like 'server_id';
    set global server_id=#id;
    ```

#### 4. Solutions

    - proxy: mycat, altas, mysql-proxy
    - jdbc: sharingsphere, tddl

#### 5. Reference

    https://blog.csdn.net/qq_37143673/article/details/94723044/
    https://www.programmersought.com/article/94314971565/
    https://www.cnblogs.com/-mrl/p/13262554.html
    https://blog.csdn.net/qq_42766492/article/details/90762093
    https://www.codenong.com/cs105473785/
    https://my.oschina.net/u/3696256/blog/3120317
    https://blog.wu-boy.com/2008/12/mysql-%E5%AF%A6%E5%81%9A-mysql-master-master-replication-%E5%90%8C%E6%AD%A5/


