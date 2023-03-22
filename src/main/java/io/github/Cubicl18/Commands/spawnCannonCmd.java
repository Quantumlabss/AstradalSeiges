package io.github.Cubicl18.Commands;

import com.ticxo.modelengine.api.ModelEngineAPI;
import com.ticxo.modelengine.api.entity.Dummy;
import com.ticxo.modelengine.api.model.ActiveModel;
import com.ticxo.modelengine.api.model.ModeledEntity;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class spawnCannonCmd implements CommandInterface{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player p = (Player) sender;
        if(args.length > 1) return false;
        ActiveModel activeModel = ModelEngineAPI.createActiveModel("cannon");
        Dummy dummy = ModelEngineAPI.createDummy();
        ModeledEntity modeledEntity = ModelEngineAPI.createModeledEntity(dummy);
        modeledEntity.addModel(activeModel, true);

        modeledEntity.showToPlayer(p);
        p.sendMessage("cannon Spawned!");
        return false;
    }
}
