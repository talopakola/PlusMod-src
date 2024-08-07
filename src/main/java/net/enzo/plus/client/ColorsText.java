package net.enzo.plus.client;

import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumChatFormatting;

import static net.minecraft.util.EnumChatFormatting.*;

public class ColorsText {

    private static final EnumChatFormatting[] fabulousnes = new EnumChatFormatting[] {RED, GOLD, YELLOW, GREEN, AQUA, BLUE, DARK_PURPLE, LIGHT_PURPLE};
    public static String rainbow(String input) {
        return ludicrousFormatting(input, fabulousnes, 80.0, 1, 1);
    }

    public static String ludicrousFormatting(String input, EnumChatFormatting[] colours, double delay, int step, int posstep) {
        StringBuilder sb = new StringBuilder(input.length()*3);
        if (delay <= 0) {
            delay = 0.001;
        }

        int offset = (int) Math.floor(Minecraft.getSystemTime() / delay) % colours.length;

        for (int i=0; i<input.length(); i++) {
            char c = input.charAt(i);

            int col = ((i * posstep) + colours.length - offset) % colours.length;

            sb.append(colours[col].toString());
            sb.append(c);
        }

        return sb.toString();
    }
}
