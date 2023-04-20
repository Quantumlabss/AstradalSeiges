package io.github.Cubicl18.weapons;

import com.ticxo.modelengine.api.ModelEngineAPI;
import com.ticxo.modelengine.api.animation.AnimationHandler;
import com.ticxo.modelengine.api.model.ActiveModel;
import com.ticxo.modelengine.api.model.ModeledEntity;
import org.bukkit.Location;
import org.bukkit.entity.*;

public class Cannon {
    private Location location;
    public static LivingEntity livingEntity;
    public static ModeledEntity cannonEntity;
    public ActiveModel activeModel;
    private static int id;




    public static ModeledEntity createCannonEntity(Location location) {


        ActiveModel activeModel = ModelEngineAPI.createActiveModel("cannon");
        //---redundant stuff---//
        //Dummy cannonEntity = ModelEngineAPI.createDummy();
        //ArmorStand livingEntity = location.getWorld().spawn(location, ArmorStand.class);
        //---set base Entity---//
        livingEntity = (Skeleton) location.getWorld().spawnEntity(location, EntityType.SKELETON);
        livingEntity.setCollidable(false);
        livingEntity.setAI(false);
        livingEntity.setCustomName("Cannon");
        livingEntity.setSilent(true);
        livingEntity.setInvulnerable(true);

        //---set ModelEngine Model---//
        //Location cannonLocation = p.getLocation();
        cannonEntity = ModelEngineAPI.getModeledEntity(livingEntity.getUniqueId());
        cannonEntity = ModelEngineAPI.createModeledEntity(livingEntity);
        //cannonEntity.setLocation(location);
        ModeledEntity modeledEntity = ModelEngineAPI.createModeledEntity(livingEntity);

        modeledEntity.addModel(activeModel, true);
        modeledEntity.setBaseEntityVisible(false);
        AnimationHandler animationHandler = activeModel.getAnimationHandler();
        animationHandler.getAnimations();
        //animationHandler.playAnimation("attack", 1,1,1,true);



        return modeledEntity;


    }








    public Location getLocation() {
        return location;
    }



}
