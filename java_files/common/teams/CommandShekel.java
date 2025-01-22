package com.flansmod.common.teams;

import com.flansmod.common.FlansMod;
import com.flansmod.common.PlayerHandler;
import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;

public class CommandShekel extends CommandBase {
  public boolean func_71519_b(ICommandSender sender) {
    return true;
  }
  
  public String func_71517_b() {
    return "shekel";
  }
  
  public void func_71515_b(ICommandSender sender, String[] split) {
    if (split == null || split.length == 0 || split[0].equals("help") || split[0].equals("?")) {
      if (split.length == 2) {
        sendHelpInformation(sender, Integer.parseInt(split[1]));
      } else {
        sendHelpInformation(sender, 1);
      } 
      return;
    } 
    if (split[0].equals("withdraw")) {
      EntityPlayerMP player = getPlayer(sender.func_70005_c_());
      if (player != null)
        if ((PlayerHandler.getPlayerData((EntityPlayer)player)).shekels > 9) {
          player.field_71071_by.func_70441_a(new ItemStack(FlansMod.opStick, 1, 4));
          sender.func_145747_a((IChatComponent)new ChatComponentText("§2Use this to buy shit from NPCs."));
          sender.func_145747_a((IChatComponent)new ChatComponentText("§7Each Physical Shekel Represents 10 Shekels"));
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
        } else if ((PlayerHandler.getPlayerData((EntityPlayer)player)).shekels < 10) {
          sender.func_145747_a((IChatComponent)new ChatComponentText("§7You need 10 Shekels to withdraw a physical Shekel"));
        }  
      return;
    } 
    if (split[0].equals("balance")) {
      EntityPlayerMP player = getPlayer(sender.func_70005_c_());
      if (player != null)
        sender.func_145747_a((IChatComponent)new ChatComponentText("§2You have " + (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels + " shekels")); 
      return;
    } 
    if (split[0].equals("bloodletting")) {
      EntityPlayerMP player = getPlayer(sender.func_70005_c_());
      if (player != null) {
        (PlayerHandler.getPlayerData((EntityPlayer)player)).minorBleed = 10;
        sender.func_145747_a((IChatComponent)new ChatComponentText("§2You are bleeding out now!"));
      } 
      return;
    } 
    if (split[0].equals("Seppuku")) {
      EntityPlayerMP player = getPlayer(sender.func_70005_c_());
      if (player != null) {
        (PlayerHandler.getPlayerData((EntityPlayer)player)).minorBleed = 50;
        sender.func_145747_a((IChatComponent)new ChatComponentText("§2You are seriously bleeding out now!"));
      } 
      return;
    } 
    if (split[0].equals("withdraw5")) {
      EntityPlayerMP player = getPlayer(sender.func_70005_c_());
      if (player != null)
        if ((PlayerHandler.getPlayerData((EntityPlayer)player)).shekels > 49) {
          player.field_71071_by.func_70441_a(new ItemStack(FlansMod.opStick, 1, 4));
          player.field_71071_by.func_70441_a(new ItemStack(FlansMod.opStick, 1, 4));
          player.field_71071_by.func_70441_a(new ItemStack(FlansMod.opStick, 1, 4));
          player.field_71071_by.func_70441_a(new ItemStack(FlansMod.opStick, 1, 4));
          player.field_71071_by.func_70441_a(new ItemStack(FlansMod.opStick, 1, 4));
          sender.func_145747_a((IChatComponent)new ChatComponentText("§2Use this to buy shit from NPCs"));
          sender.func_145747_a((IChatComponent)new ChatComponentText("§7Each Physical Shekel Represents 10 Shekels"));
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
          (PlayerHandler.getPlayerData((EntityPlayer)player)).shekels--;
        } else if ((PlayerHandler.getPlayerData((EntityPlayer)player)).shekels < 50) {
          sender.func_145747_a((IChatComponent)new ChatComponentText("§7You need 50 Shekels to withdraw 5 at once"));
        }  
      return;
    } 
    sender.func_145747_a((IChatComponent)new ChatComponentText(split[0] + " is not a valid teams command. Try /shekel help"));
  }
  
  public List func_71516_a(ICommandSender sender, String[] prm) {
    if (prm.length <= 1)
      return func_71530_a(prm, new String[] { "help", "vehiclesCanZoom" }); 
    return null;
  }
  
  public void sendHelpInformation(ICommandSender sender, int page) {
    if (page > 2 || page < 1) {
      ChatComponentText text = new ChatComponentText("Invalid help page, should be in the range (1-2)");
      text.func_150256_b().func_150238_a(EnumChatFormatting.RED);
      sender.func_145747_a((IChatComponent)text);
      return;
    } 
    sender.func_145747_a((IChatComponent)new ChatComponentText("§2Listing teams non op commands §f[Page " + page + " of 2]"));
    switch (page) {
      case 1:
        sender.func_145747_a((IChatComponent)new ChatComponentText("/shekel help"));
        sender.func_145747_a((IChatComponent)new ChatComponentText("/shekel withdraw to withdraw 10 points as a physical item"));
        sender.func_145747_a((IChatComponent)new ChatComponentText("/shekel withdraw5 to withdraw 50 points as 5 physical items"));
        sender.func_145747_a((IChatComponent)new ChatComponentText("/shekel balance to see your shekel count"));
        sender.func_145747_a((IChatComponent)new ChatComponentText("Check if there are unlockable features for this map at Spectator Spawn"));
        break;
      case 2:
        sender.func_145747_a((IChatComponent)new ChatComponentText("No extra commands here"));
        sender.func_145747_a((IChatComponent)new ChatComponentText("Ahem, despite being only 13% of the population, African Americans are responsible for over 50% of violent crimes"));
        sender.func_145747_a((IChatComponent)new ChatComponentText("yet they are only 40 something% of the prison population. If you calculate tax income vs government program spending,"));
        sender.func_145747_a((IChatComponent)new ChatComponentText("in the year 2014, black people created a deficit of at least 300 billion dollars, while Whites created a surplus."));
        break;
    } 
  }
  
  public EntityPlayerMP getPlayer(String name) {
    return MinecraftServer.func_71276_C().func_71203_ab().func_152612_a(name);
  }
  
  public String func_71518_a(ICommandSender icommandsender) {
    return "/shekel <help/withdraw/withdraw5>";
  }
}
