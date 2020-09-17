#### send by network
```java
FileChannel sourceChannel = new RandomAccessFile(source, "rw").getChannel();
SocketChannel socketChannel = SocketChannel.open(sa);
sourceChannel.transferTo(0, sourceChannel.size(), socketChannel);
```

#### ZeroCopyFile
```java
class ZeroCopyFile {
    public void copyFile(File src, File dest) {
        try (FileChannel srcChannel = new FileInputStream(src).getChannel();
             FileChannel destChannel = new FileInputStream(dest).getChannel()) {

            srcChannel.transferTo(0, srcChannel.size(), destChannel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```
