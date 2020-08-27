## Troubleshoot (Linux Commends)

#### 0. outline

- overall : top, uptime
- cpu: vmstat, mpstat, pidstat
- memory: free
- disk: df, iostat
- network: ifstat

#### 1. top

CPU, MEM, load average, etc.

#### 2. uptime (top lite)

```shell
 09:51:43 up 103 days, 13:30,  1 user,  load average: 0.40, 0.08, 0.03
```

#### 3. vmstat

```shell
> vmstat -n 2 3
procs -----------memory---------- ---swap-- -----io---- -system-- ------cpu-----
 r  b   swpd   free   buff  cache   si   so    bi    bo   in   cs us sy id wa st
 2  0   9692 139804 211396 1111224    0    0     0     4    2    0  1  1 98  0  0
 0  0   9692 139804 211396 1111260    0    0     0     0 1217 2866  1  0 99  0  0
 0  0   9692 139804 211396 1111260    0    0     0    10 1222 2883  1  3 97  0  0
```

  - procs
    - r: running, b: blocked
    - normally, 1 <= procs <= 2 * processors
  - cpu
    - us: time spent in user space
    - sy: time spent in kernel space
    - id: time spent in idle operations
    - wa: time spent on waiting on IO peripherals (eg. disk)
    - st: time spent on involuntary waits by virtual cpu while hypervisor is servicing another processor (stolen from a virtual machine)
  - notes:
    - enough memory if (us + sy) <= 80% else the proces might run out of memory

#### 4. mpstat

```shell
> mpstat -P ALL 2
Linux 4.15.0-48-generic (iZuf61fmfrfsi6wa6qszjnZ) 	02/22/2020 	_x86_64_	(1 CPU)

10:09:37 AM  CPU    %usr   %nice    %sys %iowait    %irq   %soft  %steal  %guest  %gnice   %idle
10:09:39 AM  all    0.51    0.00    0.51    0.00    0.00    0.00    0.00    0.00    0.00   98.97
10:09:39 AM    0    0.51    0.00    0.51    0.00    0.00    0.00    0.00    0.00    0.00   98.97
```

#### 5. pidstat

```shell
> pidstat -u 1 -p [pid]
Linux 4.15.0-48-generic (iZuf61fmfrfsi6wa6qszjnZ) 	02/22/2020 	_x86_64_	(1 CPU)

10:12:09 AM   UID       PID    %usr %system  %guest   %wait    %CPU   CPU  Command
10:12:10 AM     0       421    0.00    0.00    0.00    0.00    0.00     0  exe
```

```shell
> pidstat -d [sample interval] -p [pid]
Linux 4.15.0-48-generic (iZuf61fmfrfsi6wa6qszjnZ) 	02/22/2020 	_x86_64_	(1 CPU)

10:36:36 AM   UID       PID   kB_rd/s   kB_wr/s kB_ccwr/s iodelay  Command
10:36:38 AM     0       421      0.00      0.00      0.00       0  exe
```

#### 6. free

```shell
> free -m
              total        used        free      shared  buff/cache   available
Mem:           1993         565         136           5        1291        1239
```

  - Normal value
    - 20% <= available <= 70%

#### 7. df (disk free)

```shell
> df -h
udev            976M     0  976M   0% /dev
tmpfs           200M  7.0M  193M   4% /run
/dev/vda1        40G  7.7G   30G  21% /
tmpfs           997M     0  997M   0% /dev/shm
tmpfs           5.0M     0  5.0M   0% /run/lock
tmpfs           997M     0  997M   0% /sys/fs/cgroup
overlay          40G  7.7G   30G  21% /var/lib/docker/overlay2/694d674357e0942db7f405d1ef000e38f6bdda68eb155fd94c36cb60d1a00693/merged
shm              64M     0   64M   0% /var/lib/docker/containers/d141334137bd358d858454d48f833faf74d7f1d9b2feae0de010c14110938761/mounts/shm
tmpfs           200M     0  200M   0% /run/user/0
```

#### 8. iostat

```shell
> iostat -xdk 2 3
Linux 4.15.0-48-generic (iZuf61fmfrfsi6wa6qszjnZ) 	02/22/2020 	_x86_64_	(1 CPU)

Device            r/s     w/s     rkB/s     wkB/s   rrqm/s   wrqm/s  %rrqm  %wrqm r_await w_await aqu-sz rareq-sz wareq-sz  svctm  %util
vda              0.01    0.44      0.38      4.16     0.00     0.31   0.05  41.02    2.07    1.14   0.00    25.83     9.41   0.11   0.01
```

  - **util**: smaller is better
  - svctm(average service time) ~= await(average time) is better

#### 9. ifstat

```shell
> ifstat 1
      eth1               docker()
KB/s in  KB/s out     KB/s in  KB/s out
   0.00      0.00        0.00      0.00
   0.00      0.00        0.00      0.00
   0.00      0.00        0.00      0.00
   ...        ...         ...       ...
```

#### 10. Troubleshooting High CPU Utilization

1. top
    - check CPU Utilization
2. ps -ef / jps
    - locate application
3. `ps -mp [pid] -o THREAD,tid,time`
    - -m: display threads
    - -p: cpu time
    - -o: display format
    ```shell script
    > ps -mp [pid] -o THREAD,tid,time
    USER      %CPU PRI SCNT WCHAN  USER SYSTEM    TID     TIME
    root      36.4   -    - -         -      -      - 00:11:49
    root       0.0  19    - futex_    -      -   5101 00:00:00
    root      35.6  19    - -         -      -   5102 00:11:35
    root       0.0  19    - -         -      -   5103 00:00:01
    ...       ... ...  ... ...     ...    ...    ...      ...
    ```
4. convert decimal TID to hex TID
    - ex: 5101(dec) = 13ee(hex)
5. `jstack [pid] | grep tid(hex, lowercase) -A60`
    - -A60: display 60 line messages
    ```shell script
    "main" #1 prio=5 os_prio=0 tid=0x00007f0964009000 nid=0x13ee runnable [0x00007f096875c000]
       java.lang.Thread.State: RUNNABLE
            at java.io.FileOutputStream.writeBytes(Native Method)
            ...
            ...
   
    "VM Thread" os_prio=0 tid=0x00007f0964080000 nid=0x13f7 runnable
       ...
    ```