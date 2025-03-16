package xyz.flapjack.fractal.modules.impl.util;

import net.minecraft.entity.player.EntityPlayer;

public class PlayerNameColor {

    /**
     * Verify player name color
     * @param player EntityPlayer
     * @return true if the player name is green
     */
    public boolean isGreen(EntityPlayer player) {
        String name = player.getDisplayName().getFormattedText();
        return name.contains("§a") || name.matches(".*§a.*");
    }
}
