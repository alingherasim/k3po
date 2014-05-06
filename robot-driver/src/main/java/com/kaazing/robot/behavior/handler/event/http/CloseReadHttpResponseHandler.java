/**
 * Copyright (c) 2007-2013, Kaazing Corporation. All rights reserved.
 */

package com.kaazing.robot.behavior.handler.event.http;

import static java.util.EnumSet.of;

import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;

import com.kaazing.robot.behavior.handler.codec.HttpUtils;
import com.kaazing.robot.behavior.handler.event.AbstractEventHandler;

public class CloseReadHttpResponseHandler extends AbstractEventHandler {

    private static final InternalLogger LOGGER = InternalLoggerFactory.getInstance(CloseReadHttpResponseHandler.class);

    public CloseReadHttpResponseHandler() {
        super(of(ChannelEventKind.MESSAGE));
    }

    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
        Object message = e.getMessage();
        // consume all message until it is the end of http message buffer
        if (message == HttpUtils.END_OF_HTTP_MESSAGE_BUFFER) {
            LOGGER.info("close read http response");
            ChannelFuture handlerFuture = getHandlerFuture();
            assert handlerFuture != null;
            handlerFuture.setSuccess();
        }
    }
}