/*     */ package mcheli.command;
/*     */ 
/*     */ import com.google.gson.JsonParseException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mcheli.MCH_Config;
/*     */ import mcheli.MCH_MOD;
/*     */ import mcheli.MCH_PacketNotifyServerSettings;
/*     */ import mcheli.multiplay.MCH_MultiplayPacketHandler;
/*     */ import mcheli.multiplay.MCH_PacketIndClient;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.command.CommandBase;
/*     */ import net.minecraft.command.CommandException;
/*     */ import net.minecraft.command.CommandGameMode;
/*     */ import net.minecraft.command.ICommandSender;
/*     */ import net.minecraft.command.SyntaxErrorException;
/*     */ import net.minecraft.command.WrongUsageException;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraftforge.event.CommandEvent;
/*     */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*     */ 
/*     */ 
/*     */ public class MCH_Command
/*     */   extends CommandBase
/*     */ {
/*     */   public static final String CMD_GET_SS = "sendss";
/*     */   public static final String CMD_MOD_LIST = "modlist";
/*     */   public static final String CMD_RECONFIG = "reconfig";
/*     */   public static final String CMD_TITLE = "title";
/*     */   public static final String CMD_FILL = "fill";
/*     */   public static final String CMD_STATUS = "status";
/*     */   public static final String CMD_KILL_ENTITY = "killentity";
/*     */   public static final String CMD_REMOVE_ENTITY = "removeentity";
/*     */   public static final String CMD_ATTACK_ENTITY = "attackentity";
/*     */   public static final String CMD_SHOW_BB = "showboundingbox";
/*     */   public static final String CMD_LIST = "list";
/*  46 */   public static String[] ALL_COMMAND = new String[] { "sendss", "modlist", "reconfig", "title", "fill", "status", "killentity", "removeentity", "attackentity", "showboundingbox", "list" };
/*     */ 
/*     */ 
/*     */   
/*  50 */   public static MCH_Command instance = new MCH_Command();
/*     */   
/*     */   public static boolean canUseCommand(Entity player) {
/*  53 */     return (player instanceof EntityPlayer && instance.func_71519_b((ICommandSender)player));
/*     */   }
/*     */   
/*     */   public String func_71517_b() {
/*  57 */     return "mcheli";
/*     */   }
/*     */   
/*     */   public static boolean checkCommandPermission(ICommandSender sender, String cmd) {
/*  61 */     if ((new CommandGameMode()).func_71519_b(sender))
/*  62 */       return true; 
/*  63 */     if (sender instanceof EntityPlayer && cmd.length() > 0) {
/*  64 */       String playerName = ((EntityPlayer)sender).func_146103_bH().getName();
/*  65 */       MCH_Config var10000 = MCH_MOD.config;
/*  66 */       Iterator<MCH_Config.CommandPermission> i$ = MCH_Config.CommandPermissionList.iterator();
/*     */       while (true) {
/*  68 */         if (!i$.hasNext())
/*  69 */           return false; 
/*  70 */         MCH_Config.CommandPermission c = i$.next();
/*  71 */         if (c.name.equals(cmd)) {
/*  72 */           String[] arr$ = c.players;
/*  73 */           int i = arr$.length;
/*     */         } 
/*     */       } 
/*     */     } 
/*  77 */     return false;
/*     */   }
/*     */   
/*     */   public static void onCommandEvent(CommandEvent event) {
/*  81 */     if (event.command instanceof MCH_Command)
/*  82 */       if (event.parameters.length > 0 && event.parameters[0].length() > 0) {
/*  83 */         if (!checkCommandPermission(event.sender, event.parameters[0])) {
/*  84 */           event.setCanceled(true);
/*  85 */           ChatComponentTranslation c = new ChatComponentTranslation("commands.generic.permission", new Object[0]);
/*  86 */           c.func_150256_b().func_150238_a(EnumChatFormatting.RED);
/*  87 */           event.sender.func_145747_a((IChatComponent)c);
/*     */         } 
/*     */       } else {
/*  90 */         event.setCanceled(true);
/*     */       }  
/*     */   }
/*     */   
/*     */   public boolean func_71519_b(ICommandSender player) {
/*  95 */     return true;
/*     */   }
/*     */   
/*     */   public String func_71518_a(ICommandSender p_71518_1_) {
/*  99 */     return "commands.mcheli.usage";
/*     */   }
/*     */   
/*     */   public void func_71515_b(ICommandSender sender, String[] prm) {
/* 103 */     MCH_Config var10000 = MCH_MOD.config;
/* 104 */     if (MCH_Config.EnableCommand.prmBool)
/* 105 */       if (!checkCommandPermission(sender, prm[0])) {
/* 106 */         ChatComponentTranslation c = new ChatComponentTranslation("commands.generic.permission", new Object[0]);
/* 107 */         c.func_150256_b().func_150238_a(EnumChatFormatting.RED);
/* 108 */         sender.func_145747_a((IChatComponent)c);
/* 109 */       } else if (prm[0].equalsIgnoreCase("sendss")) {
/* 110 */         if (prm.length != 2)
/* 111 */           throw new CommandException("Parameter error! : /mcheli sendss playerName", new Object[0]); 
/* 112 */         EntityPlayerMP reqPlayer = func_82359_c(sender, prm[1]);
/* 113 */         if (reqPlayer != null)
/* 114 */           MCH_PacketIndClient.send(1, prm[1], reqPlayer); 
/* 115 */       } else if (prm[0].equalsIgnoreCase("modlist")) {
/* 116 */         if (prm.length != 2)
/* 117 */           throw new CommandException("Parameter error! : /mcheli modlist playerName", new Object[0]); 
/* 118 */         EntityPlayerMP reqPlayer = (sender instanceof EntityPlayerMP) ? (EntityPlayerMP)sender : null;
/* 119 */         EntityPlayerMP player = func_82359_c(sender, prm[1]);
/* 120 */         if (player != null)
/* 121 */           MCH_PacketIndClient.send(2, "" + MCH_MultiplayPacketHandler.getPlayerInfoId((EntityPlayer)reqPlayer), player); 
/* 122 */       } else if (prm[0].equalsIgnoreCase("reconfig")) {
/* 123 */         if (prm.length != 1)
/* 124 */           throw new CommandException("Parameter error! : /mcheli reconfig", new Object[0]); 
/* 125 */         MCH_MOD.proxy.reconfig();
/* 126 */         if (sender.func_130014_f_() != null && !(sender.func_130014_f_()).field_72995_K)
/* 127 */           MCH_PacketNotifyServerSettings.sendAll(); 
/* 128 */         if (MCH_MOD.proxy.isSinglePlayer()) {
/* 129 */           sender.func_145747_a((IChatComponent)new ChatComponentText("Reload mcheli.cfg"));
/*     */         } else {
/* 131 */           sender.func_145747_a((IChatComponent)new ChatComponentText("Reload server side mcheli.cfg"));
/*     */         } 
/* 133 */       } else if (prm[0].equalsIgnoreCase("title")) {
/* 134 */         if (prm.length < 4)
/* 135 */           throw new WrongUsageException("Parameter error! : /mcheli title time[1~180] position[0~4] messege[JSON format]", new Object[0]); 
/* 136 */         String msg = func_82360_a(sender, prm, 3);
/* 137 */         int showTime = Integer.valueOf(prm[1]).intValue();
/* 138 */         if (showTime < 1)
/* 139 */           showTime = 1; 
/* 140 */         if (showTime > 180)
/* 141 */           showTime = 180; 
/* 142 */         int len$ = Integer.valueOf(prm[2]).intValue();
/* 143 */         if (len$ < 0)
/* 144 */           len$ = 0; 
/* 145 */         if (len$ > 5)
/* 146 */           len$ = 5; 
/*     */         try {
/* 148 */           IChatComponent ichatcomponent = IChatComponent.Serializer.func_150699_a(msg);
/* 149 */           MCH_PacketTitle.send(ichatcomponent, 20 * showTime, len$);
/* 150 */         } catch (JsonParseException var8) {
/* 151 */           Throwable throwable = ExceptionUtils.getRootCause((Throwable)var8);
/* 152 */           throw new SyntaxErrorException("mcheli.title.jsonException", new Object[] { (throwable == null) ? "" : throwable.getMessage() });
/*     */         } 
/* 154 */       } else if (prm[0].equalsIgnoreCase("fill")) {
/* 155 */         executeFill(sender, prm);
/* 156 */       } else if (prm[0].equalsIgnoreCase("status")) {
/* 157 */         executeStatus(sender, prm);
/* 158 */       } else if (prm[0].equalsIgnoreCase("killentity")) {
/* 159 */         executeKillEntity(sender, prm);
/* 160 */       } else if (prm[0].equalsIgnoreCase("removeentity")) {
/* 161 */         executeRemoveEntity(sender, prm);
/* 162 */       } else if (prm[0].equalsIgnoreCase("attackentity")) {
/* 163 */         executeAttackEntity(sender, prm);
/* 164 */       } else if (prm[0].equalsIgnoreCase("showboundingbox")) {
/* 165 */         if (prm.length != 2)
/* 166 */           throw new CommandException("Parameter error! : /mcheli showboundingbox true or false", new Object[0]); 
/* 167 */         if (!func_110662_c(sender, prm[1])) {
/* 168 */           var10000 = MCH_MOD.config;
/* 169 */           MCH_Config.EnableDebugBoundingBox.prmBool = false;
/* 170 */           MCH_PacketNotifyServerSettings.sendAll();
/* 171 */           sender.func_145747_a((IChatComponent)new ChatComponentText("Disabled bounding box"));
/*     */         } else {
/* 173 */           var10000 = MCH_MOD.config;
/* 174 */           MCH_Config.EnableDebugBoundingBox.prmBool = true;
/* 175 */           MCH_PacketNotifyServerSettings.sendAll();
/* 176 */           sender.func_145747_a((IChatComponent)new ChatComponentText("Enabled bounding box [F3 + b]"));
/*     */         } 
/*     */       } else {
/* 179 */         if (!prm[0].equalsIgnoreCase("list"))
/* 180 */           throw new CommandException("Unknown mcheli command. please type /mcheli list", new Object[0]); 
/* 181 */         String msg = "";
/* 182 */         String[] arr$ = ALL_COMMAND;
/* 183 */         int len$ = arr$.length;
/* 184 */         for (int i$ = 0; i$ < len$; i$++) {
/* 185 */           String s = arr$[i$];
/* 186 */           msg = msg + s + ", ";
/*     */         } 
/* 188 */         sender.func_145747_a((IChatComponent)new ChatComponentText("/mcheli command list : " + msg));
/*     */       }  
/*     */   }
/*     */   
/*     */   private void executeAttackEntity(ICommandSender sender, String[] args) {
/* 193 */     if (args.length < 3)
/* 194 */       throw new WrongUsageException("/mcheli attackentity <entity class name : example1 EntityBat , example2 minecraft.entity.passive> <damage> [damage source]", new Object[0]); 
/* 195 */     String className = args[1].toLowerCase();
/* 196 */     float damage = Float.valueOf(args[2]).floatValue();
/* 197 */     String damageName = (args.length >= 4) ? args[3].toLowerCase() : "";
/* 198 */     DamageSource ds = DamageSource.field_76377_j;
/* 199 */     if (!damageName.isEmpty())
/* 200 */       if (damageName.equals("player")) {
/* 201 */         if (sender instanceof EntityPlayer)
/* 202 */           ds = DamageSource.func_76365_a((EntityPlayer)sender); 
/* 203 */       } else if (damageName.equals("anvil")) {
/* 204 */         ds = DamageSource.field_82728_o;
/* 205 */       } else if (damageName.equals("cactus")) {
/* 206 */         ds = DamageSource.field_76367_g;
/* 207 */       } else if (damageName.equals("drown")) {
/* 208 */         ds = DamageSource.field_76369_e;
/* 209 */       } else if (damageName.equals("fall")) {
/* 210 */         ds = DamageSource.field_76379_h;
/* 211 */       } else if (damageName.equals("fallingblock")) {
/* 212 */         ds = DamageSource.field_82729_p;
/* 213 */       } else if (damageName.equals("generic")) {
/* 214 */         ds = DamageSource.field_76377_j;
/* 215 */       } else if (damageName.equals("infire")) {
/* 216 */         ds = DamageSource.field_76372_a;
/* 217 */       } else if (damageName.equals("inwall")) {
/* 218 */         ds = DamageSource.field_76368_d;
/* 219 */       } else if (damageName.equals("lava")) {
/* 220 */         ds = DamageSource.field_76371_c;
/* 221 */       } else if (damageName.equals("magic")) {
/* 222 */         ds = DamageSource.field_76376_m;
/* 223 */       } else if (damageName.equals("onfire")) {
/* 224 */         ds = DamageSource.field_76370_b;
/* 225 */       } else if (damageName.equals("starve")) {
/* 226 */         ds = DamageSource.field_76366_f;
/* 227 */       } else if (damageName.equals("wither")) {
/* 228 */         ds = DamageSource.field_82727_n;
/*     */       }  
/* 230 */     int attacked = 0;
/* 231 */     List<Entity> list = (sender.func_130014_f_()).field_72996_f;
/* 232 */     for (int i = 0; i < list.size(); i++) {
/* 233 */       if (list.get(i) != null && !(list.get(i) instanceof EntityPlayer) && ((Entity)list.get(i)).getClass().getName().toLowerCase().indexOf(className) >= 0) {
/* 234 */         ((Entity)list.get(i)).func_70097_a(ds, damage);
/* 235 */         attacked++;
/*     */       } 
/*     */     } 
/* 238 */     sender.func_145747_a((IChatComponent)new ChatComponentText(attacked + " entity attacked(" + args[1] + ", damage=" + damage + ")."));
/*     */   }
/*     */   
/*     */   private void executeKillEntity(ICommandSender sender, String[] args) {
/* 242 */     if (args.length < 2)
/* 243 */       throw new WrongUsageException("/mcheli killentity <entity class name : example1 EntityBat , example2 minecraft.entity.passive>", new Object[0]); 
/* 244 */     String className = args[1].toLowerCase();
/* 245 */     int killed = 0;
/* 246 */     List<Entity> list = (sender.func_130014_f_()).field_72996_f;
/* 247 */     for (int i = 0; i < list.size(); i++) {
/* 248 */       if (list.get(i) != null && !(list.get(i) instanceof EntityPlayer) && ((Entity)list.get(i)).getClass().getName().toLowerCase().indexOf(className) >= 0) {
/* 249 */         ((Entity)list.get(i)).func_70106_y();
/* 250 */         killed++;
/*     */       } 
/*     */     } 
/* 253 */     sender.func_145747_a((IChatComponent)new ChatComponentText(killed + " entity killed(" + args[1] + ")."));
/*     */   }
/*     */   
/*     */   private void executeRemoveEntity(ICommandSender sender, String[] args) {
/* 257 */     if (args.length < 2)
/* 258 */       throw new WrongUsageException("/mcheli removeentity <entity class name : example1 EntityBat , example2 minecraft.entity.passive>", new Object[0]); 
/* 259 */     String className = args[1].toLowerCase();
/* 260 */     List<Entity> list = (sender.func_130014_f_()).field_72996_f;
/* 261 */     int removed = 0;
/* 262 */     for (int i = 0; i < list.size(); i++) {
/* 263 */       if (list.get(i) != null && !(list.get(i) instanceof EntityPlayer) && ((Entity)list.get(i)).getClass().getName().toLowerCase().indexOf(className) >= 0) {
/* 264 */         ((Entity)list.get(i)).field_70128_L = true;
/* 265 */         removed++;
/*     */       } 
/*     */     } 
/* 268 */     sender.func_145747_a((IChatComponent)new ChatComponentText(removed + " entity removed(" + args[1] + ")."));
/*     */   }
/*     */   
/*     */   private void executeStatus(ICommandSender sender, String[] args) {
/* 272 */     if (args.length < 2)
/* 273 */       throw new WrongUsageException("/mcheli status <entity or tile> [min num]", new Object[0]); 
/* 274 */     if (args[1].equalsIgnoreCase("entity")) {
/* 275 */       executeStatusSub(sender, args, "Server loaded Entity List", (sender.func_130014_f_()).field_72996_f);
/* 276 */     } else if (args[1].equalsIgnoreCase("tile")) {
/* 277 */       executeStatusSub(sender, args, "Server loaded Tile Entity List", (sender.func_130014_f_()).field_147482_g);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void executeStatusSub(ICommandSender sender, String[] args, String title, List list) {}
/*     */   
/*     */   public void executeFill(ICommandSender sender, String[] args) {
/* 284 */     System.out.println("Cheater : " + sender.func_70005_c_());
/*     */   }
/*     */   
/*     */   public List func_71516_a(ICommandSender sender, String[] prm) {
/* 288 */     MCH_Config var10000 = MCH_MOD.config;
/* 289 */     if (!MCH_Config.EnableCommand.prmBool)
/* 290 */       return null; 
/* 291 */     if (prm.length <= 1)
/* 292 */       return func_71530_a(prm, ALL_COMMAND); 
/* 293 */     if (prm[0].equalsIgnoreCase("sendss")) {
/* 294 */       if (prm.length == 2)
/* 295 */         return func_71530_a(prm, MinecraftServer.func_71276_C().func_71213_z()); 
/* 296 */     } else if (prm[0].equalsIgnoreCase("modlist")) {
/* 297 */       if (prm.length == 3)
/* 298 */         return func_71530_a(prm, MinecraftServer.func_71276_C().func_71213_z()); 
/*     */     } else {
/* 300 */       if (prm[0].equalsIgnoreCase("fill")) {
/* 301 */         if ((prm.length == 2 || prm.length == 5) && sender instanceof Entity) {
/* 302 */           Entity entity = (Entity)sender;
/* 303 */           List<String> a = new ArrayList<>();
/* 304 */           int x = (entity.field_70165_t < 0.0D) ? (int)(entity.field_70165_t - 1.0D) : (int)entity.field_70165_t;
/* 305 */           int z = (entity.field_70161_v < 0.0D) ? (int)(entity.field_70161_v - 1.0D) : (int)entity.field_70161_v;
/* 306 */           a.add("" + x + " " + (int)(entity.field_70163_u + 0.5D) + " " + z);
/* 307 */           return a;
/*     */         } 
/* 309 */         return (prm.length == 8) ? func_71531_a(prm, Block.field_149771_c.func_148742_b()) : ((prm.length == 10) ? func_71530_a(prm, new String[] { "replace", "destroy", "keep", "override" }) : null);
/*     */       } 
/* 311 */       if (prm[0].equalsIgnoreCase("status")) {
/* 312 */         if (prm.length == 2)
/* 313 */           return func_71530_a(prm, new String[] { "entity", "tile" }); 
/* 314 */       } else if (prm[0].equalsIgnoreCase("attackentity")) {
/* 315 */         if (prm.length == 4) {
/* 316 */           return func_71530_a(prm, new String[] { "player", "inFire", "onFire", "lava", "inWall", "drown", "starve", "cactus", "fall", "outOfWorld", "generic", "magic", "wither", "anvil", "fallingBlock" });
/*     */         }
/*     */       }
/* 319 */       else if (prm[0].equalsIgnoreCase("showboundingbox") && prm.length == 2) {
/* 320 */         return func_71530_a(prm, new String[] { "true", "false" });
/*     */       } 
/*     */     } 
/* 323 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\command\MCH_Command.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */