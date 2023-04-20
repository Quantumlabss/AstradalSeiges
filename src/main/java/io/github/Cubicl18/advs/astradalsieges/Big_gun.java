package io.github.Cubicl18.advs.astradalsieges;

import com.fren_gor.ultimateAdvancementAPI.util.AdvancementKey;
import io.github.Cubicl18.advs.AdvancementTabNamespaces;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.BaseAdvancement;
import org.bukkit.Material;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.advancement.Advancement;

public class Big_gun extends BaseAdvancement  {

  public static AdvancementKey KEY = new AdvancementKey(AdvancementTabNamespaces.astradalsieges_NAMESPACE, "big_gun");


  public Big_gun(Advancement parent) {
    super(KEY.getKey(), new AdvancementDisplay(Material.POLISHED_BLACKSTONE, "Bring Out The Big Guns!", AdvancementFrameType.TASK, true, true, 1f, 0f , "Craft a Siege Weapon", "-Cannon", "-Trebuchet", "-Ballista", "-Catapult"), parent, 1);
  }
}