package io.github.Cubicl18.advs.astradalsieges;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import io.github.Cubicl18.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import org.bukkit.Material;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;

public class Fire extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.astradalsieges_NAMESPACE, "fire");


  public Fire(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.FIREWORK_STAR, "FIRE!", AdvancementFrameType.TASK, true, true, 2f, 0f , "Fire A Siege Weapon by right clicking", "it with their specific ammo."), parent, 1);
  }
}