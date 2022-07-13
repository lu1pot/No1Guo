package echo_demo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;


public class EchoServer {
    private final int port;

    public EchoServer(int port){
        this.port = port;

    }

    public static void main(String[] args) throws InterruptedException {
        new EchoServer(9090).start();
    }
    private void start() throws InterruptedException {

        NioEventLoopGroup boss = new NioEventLoopGroup(1);
        NioEventLoopGroup workers = new NioEventLoopGroup(4);

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(boss,workers).channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(port))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new EchoServerHandler());
                        }
                    });
            ChannelFuture cf = bootstrap.bind().sync();

            cf.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            boss.shutdownGracefully().sync();
            workers.shutdownGracefully().sync();
        }

    }
}
