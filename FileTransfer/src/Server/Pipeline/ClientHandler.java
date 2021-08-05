package Server.Pipeline;

import Utilities.Utilities;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ClientHandler extends ChannelInboundHandlerAdapter {
    private static int index = 0;

    private String name;
    private Utilities utilities = new Utilities();

    @Override
    public void channelActive(ChannelHandlerContext ctx)
    {
        name = "Client№" + index;
        index++;
        System.out.println(" Server.Pipeline opened for: " +  name);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println(name + ": " + Thread.currentThread());

        ByteBuf byteBuf = (ByteBuf) msg;
        byte[] data = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(data);

        System.out.println(name + ": " + data[0]);

        byte[] arr = utilities.commandEncoder(data[0]).getBytes();
        ByteBuf buf = ctx.alloc().buffer(arr.length);
        buf.writeBytes(arr);

        ctx.writeAndFlush(buf);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }


}
