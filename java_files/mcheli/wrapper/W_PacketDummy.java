package mcheli.wrapper;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import io.netty.buffer.ByteBuf;

public class W_PacketDummy implements IMessage {
  public void fromBytes(ByteBuf buf) {}
  
  public void toBytes(ByteBuf buf) {}
}


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\wrapper\W_PacketDummy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */