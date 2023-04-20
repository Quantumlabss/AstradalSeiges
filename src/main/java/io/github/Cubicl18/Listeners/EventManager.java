package io.github.Cubicl18.Listeners;

import com.fren_gor.ultimateAdvancementAPI.events.PlayerLoadingCompletedEvent;
import com.ticxo.modelengine.api.animation.state.ModelState;
import com.ticxo.modelengine.api.model.ModeledEntity;
import io.github.Cubicl18.AstradalSeigePlugin;
import io.github.Cubicl18.weapons.Cannon;
import io.github.Cubicl18.Items.ItemManager;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Rotation;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import com.ticxo.modelengine.api.animation.*;


public class EventManager implements Listener {


    //---CANNON---//
    @EventHandler
    public void spawnCannon(PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (e.getItem() != null) {
                if (e.getItem().getItemMeta().equals(ItemManager.cannonItem.getItemMeta())) {
                    e.setCancelled(true);
                    Player p = e.getPlayer();
                    //Dummy cannonEntity;
                    //item != null && Objects.equals(item.getItemMeta(), "cannon"

                    Location playerLocation = e.getPlayer().getLocation();
                    //ModeledEntity modeledEntity = Cannon.createCannonEntity(playerLocation);
                    ModeledEntity modeledEntity = Cannon.createCannonEntity(playerLocation);


                    //cannonEntity.addModel((ActiveModel) Cannon.livingEntity, true);
                    Cannon.cannonEntity.setState(ModelState.IDLE);


                    modeledEntity.showToPlayer(p);

                    p.sendMessage("Cannon Spawned");

                    p.getInventory().remove(ItemManager.cannonItem);


                }
            }
        }

    }


    //FIRE CANNON
    @EventHandler
    public void fireCannon(PlayerInteractEntityEvent fire) {
        Player p = fire.getPlayer();
        Entity entity = fire.getRightClicked();
        if (!(entity instanceof LivingEntity)) return;
        if (entity instanceof Player) return;
        if (entity.getCustomName() == null) return;
        //LivingEntity mob = (LivingEntity) en;

        if (entity.getCustomName().contains("Cannon")) {
            if (p.getItemInUse().getItemMeta().equals(ItemManager.cannonBall.getItemMeta())) {
                //Cannon.cannonEntity.getModel("Cannon").getAnimationHandler();
                //Cannon.cannonEntity.getAnimationState(true);
                Cannon.cannonEntity.getState();
                Cannon.cannonEntity.getModel("Cannon").getBlueprint().getAnimations();
                Cannon.cannonEntity.setState(ModelState.get("attack"));
                //fire arrow
                Arrow cannonb = ((LivingEntity) entity).launchProjectile(Arrow.class);
                cannonb.setCustomName("CannonBall");
                FallingBlock block = cannonb.getWorld().spawnFallingBlock(cannonb.getLocation(), Material.POLISHED_BLACKSTONE, (byte) 3);
                cannonb.addPassenger(block);
                block.setVelocity(cannonb.getVelocity());





                //remove 1 ammo item from player
                p.getInventory().remove(ItemManager.cannonBall);
                Cannon.cannonEntity.setState(ModelState.IDLE);
                p.sendMessage("fire!");

            }


        }


    }


    //cannonball hit-use this also for other weapons, but change the explosion strength
    @EventHandler
    public void cannonBallLand(ProjectileHitEvent ch) {
        if (ch.getEntity().getShooter() instanceof Cannon c) {
            Location location = ch.getEntity().getLocation();
            ch.getEntity().getWorld().createExplosion(ch.getEntity().getLocation(), 4);

            ch.getEntity().remove();


        }
    }

    @EventHandler
    public void rotCannon(PlayerInteractEntityEvent rotc) {

        Player p = rotc.getPlayer();
        Entity entity = rotc.getRightClicked();
        if (!(entity instanceof LivingEntity)) return;
        if (entity instanceof Player) return;
        if (entity.getCustomName() == null) return;


        if (entity.getCustomName().contains("Cannon")) {

            float oldYaw = entity.getLocation().getYaw();
            float yaw = oldYaw + 3;

            entity.getLocation().setYaw(yaw);

                p.sendMessage("Rotated!");

        }






    }
}
