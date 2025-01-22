package com.flansmod.client.gui;

import com.flansmod.client.FlansModClient;
import com.flansmod.common.network.PacketTeamInfo;
import com.flansmod.common.teams.Team;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiTeamScores extends GuiScreen {
  public static final ResourceLocation texture = new ResourceLocation("flansmod", "gui/teamsScores.png");
  
  public static final ResourceLocation texture2 = new ResourceLocation("flansmod", "gui/teamsScores2.png");
  
  public void func_73863_a(int i, int j, float f) {
    PacketTeamInfo teamInfo = FlansModClient.teamInfo;
    if (teamInfo != null)
      if (PacketTeamInfo.gametype != null)
        if (!PacketTeamInfo.gametype.equals(""))
          if (PacketTeamInfo.teamData != null)
            if (PacketTeamInfo.teamData.length >= 1) {
              if (PacketTeamInfo.sortedByTeam) {
                renderTwoTeamGUI(teamInfo);
              } else {
                renderDMGUI(teamInfo);
              } 
              return;
            }     
    this.field_146297_k.func_147108_a(null);
  }
  
  public void renderTwoTeamGUI(PacketTeamInfo teamInfo) {
    long newTime = this.field_146297_k.field_71441_e.func_72912_H().func_76073_f();
    ScaledResolution scaledresolution = new ScaledResolution(this.field_146297_k, this.field_146297_k.field_71443_c, this.field_146297_k.field_71440_d);
    int k = scaledresolution.func_78326_a();
    int l = scaledresolution.func_78328_b();
    FontRenderer fontrenderer = this.field_146297_k.field_71466_p;
    func_146276_q_();
    GL11.glEnable(3042);
    this.field_146297_k.field_71446_o.func_110577_a(texture2);
    int guiHeight = 68 + 9 * PacketTeamInfo.numLines;
    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    int m = k / 2 - 156;
    int n = l / 2 - guiHeight / 2;
    func_146110_a(m, n, 100.0F, 0.0F, 312, 66, 512.0F, 256.0F);
    for (int p = 0; p < PacketTeamInfo.numLines; p++)
      func_146110_a(m, n + 66 + 9 * p, 100.0F, 71.0F, 312, 9, 512.0F, 256.0F); 
    func_146110_a(m, n + 66 + PacketTeamInfo.numLines * 9, 100.0F, 168.0F, 312, 12, 512.0F, 256.0F);
    if (PacketTeamInfo.showZombieScore) {
      func_146110_a(m + 103, n + 51, 412.0F, 0.0F, 29, 11, 512.0F, 256.0F);
      func_146110_a(m + 254, n + 51, 412.0F, 0.0F, 29, 11, 512.0F, 256.0F);
    } 
    func_73731_b(this.field_146289_q, PacketTeamInfo.map, m + 6, n + 6, 16777215);
    func_73731_b(this.field_146289_q, PacketTeamInfo.gametype, m + 312 - 6 - this.field_146289_q.func_78256_a(PacketTeamInfo.gametype), n + 6, 16777215);
    if (teamInfo.roundOver()) {
      Team winners = teamInfo.getWinner();
      if (winners == null) {
        func_73731_b(this.field_146289_q, "Time Ran Out!", m + 10, n + 20, 16777215);
      } else {
        func_73731_b(this.field_146289_q, winners.name + " Won!", m + 10, n + 20, 16777215);
      } 
    } else {
      int secondsLeft = PacketTeamInfo.timeLeft / 20;
      int minutesLeft = secondsLeft / 60;
      secondsLeft %= 60;
      func_73731_b(this.field_146289_q, "Time Left : " + minutesLeft + ":" + ((secondsLeft < 10) ? ("0" + secondsLeft) : (String)Integer.valueOf(secondsLeft)), m + 10, n + 20, 16777215);
      func_73731_b(this.field_146289_q, "Score Limit : " + PacketTeamInfo.scoreLimit, m + 302 - this.field_146289_q.func_78256_a("Score Limit : " + PacketTeamInfo.scoreLimit), n + 20, 16777215);
    } 
    for (int i = 0; i < 2; i++) {
      this.field_146289_q.func_78276_b("§" + (PacketTeamInfo.teamData[i]).team.textColour + (PacketTeamInfo.teamData[i]).team.name, m + 10 + 151 * i, n + 39, 16777215);
      this.field_146289_q.func_78276_b("§" + (PacketTeamInfo.teamData[i]).team.textColour + (PacketTeamInfo.teamData[i]).score, m + 133 + 151 * i, n + 39, 16777215);
      for (int j = 0; j < (PacketTeamInfo.teamData[i]).numPlayers; j++) {
        func_73731_b(this.field_146289_q, ((PacketTeamInfo.teamData[i]).playerData[j]).username, m + 12 + 151 * i, n + 67 + 9 * j, 16777215);
        func_73732_a(this.field_146289_q, "" + ((PacketTeamInfo.teamData[i]).playerData[j]).score, m + 111 + 151 * i, n + 67 + 9 * j, 16777215);
        func_73732_a(this.field_146289_q, "" + (PacketTeamInfo.showZombieScore ? ((PacketTeamInfo.teamData[i]).playerData[j]).zombieScore : ((PacketTeamInfo.teamData[i]).playerData[j]).kills), m + 127 + 151 * i, n + 67 + 9 * j, 16777215);
        func_73732_a(this.field_146289_q, "" + ((PacketTeamInfo.teamData[i]).playerData[j]).deaths, m + 143 + 151 * i, n + 67 + 9 * j, 16777215);
      } 
    } 
    GL11.glDisable(3042);
  }
  
  public void renderDMGUI(PacketTeamInfo teamInfo) {
    long newTime = this.field_146297_k.field_71441_e.func_72912_H().func_76073_f();
    ScaledResolution scaledresolution = new ScaledResolution(this.field_146297_k, this.field_146297_k.field_71443_c, this.field_146297_k.field_71440_d);
    int k = scaledresolution.func_78326_a();
    int l = scaledresolution.func_78328_b();
    FontRenderer fontrenderer = this.field_146297_k.field_71466_p;
    func_146276_q_();
    GL11.glEnable(3042);
    this.field_146297_k.field_71446_o.func_110577_a(texture);
    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    int guiHeight = 34 + 9 * PacketTeamInfo.numLines;
    int m = k / 2 - 128;
    int n = l / 2 - guiHeight / 2;
    func_73729_b(m, n, 0, 45, 256, 24);
    for (int p = 0; p < PacketTeamInfo.numLines; p++)
      func_73729_b(m, n + 24 + 9 * p, 0, 71, 256, 9); 
    func_73729_b(m, l / 2 + guiHeight / 2 - 10, 0, 87, 256, 10);
    func_73732_a(this.field_146289_q, PacketTeamInfo.gametype, k / 2, n + 4, 16777215);
    func_73731_b(this.field_146289_q, "Name", m + 8, n + 14, 16777215);
    func_73731_b(this.field_146289_q, "Shekels", m + 50, n + 14, 16777215);
    func_73731_b(this.field_146289_q, "Score", m + 100, n + 14, 16777215);
    func_73731_b(this.field_146289_q, "Kills", m + 150, n + 14, 16777215);
    func_73731_b(this.field_146289_q, "Deaths", m + 200, n + 14, 16777215);
    int line = 0;
    if (PacketTeamInfo.sortedByTeam) {
      for (int i = 0; i < PacketTeamInfo.numTeams; i++) {
        if (PacketTeamInfo.teamData[i] != null)
          if ((PacketTeamInfo.teamData[i]).team != null) {
            func_73731_b(this.field_146289_q, "§" + (PacketTeamInfo.teamData[i]).team.textColour + (PacketTeamInfo.teamData[i]).team.name, m + 8, n + 25 + 9 * line, 16777215);
            func_73731_b(this.field_146289_q, "" + (PacketTeamInfo.teamData[i]).score, m + 100, n + 25 + 9 * line, 16777215);
            line++;
            for (int q = 0; q < (PacketTeamInfo.teamData[i]).numPlayers; q++) {
              func_73731_b(this.field_146289_q, ((PacketTeamInfo.teamData[i]).playerData[q]).username, m + 8, n + 25 + 9 * line, 16777215);
              func_73731_b(this.field_146289_q, "" + ((PacketTeamInfo.teamData[i]).playerData[q]).score, m + 100, n + 25 + 9 * line, 16777215);
              func_73731_b(this.field_146289_q, "" + ((PacketTeamInfo.teamData[i]).playerData[q]).kills, m + 150, n + 25 + 9 * line, 16777215);
              func_73731_b(this.field_146289_q, "" + ((PacketTeamInfo.teamData[i]).playerData[q]).deaths, m + 200, n + 25 + 9 * line, 16777215);
              line++;
            } 
          }  
      } 
    } else {
      for (int q = 0; q < (PacketTeamInfo.teamData[0]).numPlayers; q++) {
        func_73731_b(this.field_146289_q, ((PacketTeamInfo.teamData[0]).playerData[q]).username, m + 8, n + 25 + 9 * line, 16777215);
        func_73731_b(this.field_146289_q, "" + ((PacketTeamInfo.teamData[0]).playerData[q]).score, m + 100, n + 25 + 9 * line, 16777215);
        func_73731_b(this.field_146289_q, "" + ((PacketTeamInfo.teamData[0]).playerData[q]).kills, m + 150, n + 25 + 9 * line, 16777215);
        func_73731_b(this.field_146289_q, "" + ((PacketTeamInfo.teamData[0]).playerData[q]).deaths, m + 200, n + 25 + 9 * line, 16777215);
        line++;
      } 
    } 
    GL11.glDisable(3042);
  }
  
  public boolean func_73868_f() {
    return false;
  }
}
