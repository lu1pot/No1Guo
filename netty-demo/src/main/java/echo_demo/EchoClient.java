package echo_demo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;


public class EchoClient {
    private final String host;
    private final int port;

    public EchoClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    private void start() throws Exception{
        NioEventLoopGroup group = new NioEventLoopGroup(2);
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group).channel(NioSocketChannel.class)
                    .remoteAddress(new InetSocketAddress(host,port))
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                                 ch.pipeline().addLast(new EchoClientHandler());
                        }
                    });

            ChannelFuture cf = bootstrap.connect().sync();
            cf.channel().closeFuture().sync();
        } catch (Exception e) {
            group.shutdownGracefully().sync();
        }

    }

    public static void main(String[] args) {
        try {
            new EchoClient("localhost",9090).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
