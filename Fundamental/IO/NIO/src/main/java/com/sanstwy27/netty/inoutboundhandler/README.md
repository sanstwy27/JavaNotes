## Notice

##### Encoder type must be acceptOutboundMessage(msg)
`MessageToByteEncoder<Long>` here
- ctx.writeAndFlush(Unpooled.copiedBuffer("...", CharsetUtil.UTF_8));
- ctx.writeAndFlush(123456L);
- ...

```java
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        ByteBuf buf = null;

        try {
            if (this.acceptOutboundMessage(msg)) {
                I cast = msg;
                buf = this.allocateBuffer(ctx, msg, this.preferDirect);

                try {
                    this.encode(ctx, cast, buf);
                } finally {
                    ReferenceCountUtil.release(msg);
                }

                if (buf.isReadable()) {
                    ctx.write(buf, promise);
                } else {
                    buf.release();
                    ctx.write(Unpooled.EMPTY_BUFFER, promise);
                }

                buf = null;
            } else {
                ctx.write(msg, promise);
            }
        } catch (EncoderException var17) {
            throw var17;
        } catch (Throwable var18) {
            throw new EncoderException(var18);
        } finally {
            if (buf != null) {
                buf.release();
            }

        }

    }
```




