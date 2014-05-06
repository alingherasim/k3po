/**
 * Copyright (c) 2007-2013, Kaazing Corporation. All rights reserved.
 */

package com.kaazing.robot.behavior.handler.prepare;

import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFuture;

public class DownstreamPreparationEvent extends AbstractPreparationEvent {

    public DownstreamPreparationEvent(Channel channel, ChannelFuture future) {
        super(channel, future);
    }

    @Override
    public String toString() {
        String channelString = getChannel().toString();
        StringBuilder buf = new StringBuilder(channelString.length() + 32);
        buf.append(channelString);
        buf.append(" PREPARED");
        return buf.toString();
    }

}