package week03.gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * @Author: guanys
 * @version: V1.0
 * @Package: week03.gateway.filter
 * @ClassName: GuanyushenRequestFilter
 * @Description: 3）周六作业：实现过滤器
 * @Date: 2020/11/3 19:14
 */

public class GuanyushenRequestFilter implements HttpRequestFilter {
    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        fullRequest.headers().set("nio","guanyushen");
    }
}
